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
 * Class responsible for compiling or generating binaries for iOS device
 * architectures.
 *
 * <pre><code>
 * cmake --build /path/buildDir \
 *  --config Debug|Release \
 *  --parallel
 * </code></pre>
 *
 * @author wil
 * @version 1.0.0
 * @since 1.3.0
 */
public class XbuildTask extends DefaultTask {

    /** Device type. */
    private final Device device;
    /** Command executor. */
    private final ExecOperations cmd;

    /**
     * Task constructor {@code Xbuild}.
     *
     * @param device Device
     * @param cmd ExecOperations
     */
    @Inject
    public XbuildTask(Device device, ExecOperations cmd) {
        this.device = device;
        this.cmd = cmd;
    }

    /**
     * Start the task to be executed
     */
    @TaskAction
    public void build() {
        BuildDirectory directory = BuildDirectory.getInstance(this);
        IOSProperties iosp       = getProject().getExtensions()
                                               .getByType(IOSProperties.class);
        
        BuildDirectory.CMakeData data = directory.getCMakeData();        
        iosp.getBuildTypes().all((buildType) -> {
            iosp.getProductFlavors().all((flavor) -> {                
                BuildType type = buildType.getBuildType().get();
                Flavor fv      = flavor.getFlavor().get();
                
                File buildDir = data.device(device)
                                    .buildTypeProperty(buildType)
                                    .flavorProperty(flavor)
                                    .getCMakeBuildTypeDir();
                
                log("Build " + type.getName() + ':' + fv.getName());
                logMore("buildDir:", buildDir);
                logMore("target:   ", type.getName());

                cmd.exec((exec) -> {
                    exec.commandLine(
                        "cmake",
                        "--build", buildDir,
                        "--config", type.getName(),
                        "--parallel"
                    );
                });

            });
        });
    }
}
