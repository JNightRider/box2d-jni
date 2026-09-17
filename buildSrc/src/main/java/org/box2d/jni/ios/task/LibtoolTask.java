/*
BSD 3-Clause License

Copyright (c) 2026, Night Rider

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.box2d.jni.ios.task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.box2d.jni.BuildType;
import org.box2d.jni.Flavor;
import org.box2d.jni.ios.BuildDirectory;
import org.box2d.jni.ios.Device;
import org.box2d.jni.ios.IOSProperties;
import static org.box2d.jni.util.Debug.*;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.process.ExecOperations;

/**
 * Since a static library does not include its dependencies, this task handles
 * merging them into a single library.
 *
 * <pre><code>
 * libtool -static libxxx.a libxxxadd.a libffi.a -o /path/libxxx.a
 * </code></pre>
 *
 * @author wil
 * @version 1.0.0
 * @since 1.3.0
 */
public class LibtoolTask extends DefaultTask {

    /** Device type. */
    private final Device device;
    /** Command executor. */
    private final ExecOperations cmd;

    /**
     * Task constructor {@code Libtool}.
     *
     * @param device Device
     * @param cmd ExecOperations
     */
    @Inject
    public LibtoolTask(Device device, ExecOperations cmd) {
        this.device = device;
        this.cmd = cmd;
    }

    /**
     * Start the task to be executed
     */
    @TaskAction
    public void libtool() {
        BuildDirectory directory = BuildDirectory.getInstance(this);
        IOSProperties iosp       = getProject().getExtensions()
                                               .getByType(IOSProperties.class);
        
        BuildDirectory.LibtoolData data = directory.getLibtoolData();
        
        iosp.getBuildTypes().all((buildType) -> {
            iosp.getProductFlavors().all((flavor) -> {                
                BuildType type = buildType.getBuildType().get();
                Flavor fv      = flavor.getFlavor().get();
                
                File nativeDir = data.device(device)
                                     .buildTypeProperty(buildType)
                                     .flavorProperty(flavor)
                                     .getMakeData()
                                     .getCMakeNativeDir();

                log("Libtool " + type.getName() + ':' + fv.getName());
                logMore("arch: ", device.getType() + '_' + device.getNativeArch());
                
                libtoolStatic(data, nativeDir);
            });            
        });
    }

    /**
     * Start the merge command for all dependencies.
     *
     * @param data LibtoolData
     * @param nativeFile File
     */
    private void libtoolStatic(BuildDirectory.LibtoolData data, File nativeFile) {
        File libffi = data.getMakeData().getCMakeLibffi();

        List<File> libraries = new ArrayList<>();
        for (File file : nativeFile.listFiles()) {
            logMore("\t<&" + file);
            libraries.add(file);
        }
        logMore("\t<&" + libffi);

        libraries.add(libffi);
        cmd.exec((exec) -> {
            exec.commandLine("libtool", "-static");
            exec.args(libraries);
            exec.args("-o", data.getXCodeNativeFile());
        });
    }
}
