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
import java.util.List;
import javax.inject.Inject;

import org.box2d.jni.BuildType;
import org.box2d.jni.Flavor;
import org.box2d.jni.ios.BuildDirectory;
import org.box2d.jni.ios.Device;
import org.box2d.jni.ios.IOSProperties;
import org.box2d.jni.util.IOUtils;

import static org.box2d.jni.ios.IOSProperties.*;
import static org.box2d.jni.util.Debug.*;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.process.ExecOperations;

/**
 * Class responsible for configuring CMake for a specific iOS platform
 * architecture or device.
 *
 * <pre><code>
 * cmake -S /path/workdir -B /path/output -G Xcode \
 *  -DCMAKE_SYSTEM_NAME=iOS \
 *  -DCMAKE_OSX_SYSROOT=iphoneos|iphonesimulator \
 *  -DCMAKE_OSX_DEPLOYMENT_TARGET=15.0 \
 *  -DCMAKE_OSX_ARCHITECTURES=arm64|x86_64 \
 *  -DCMAKE_BUILD_TYPE=Debug|Release \
 *  -DBUILD_SHARED_LIBS=OFF \
 *  -DCMAKE_POSITION_INDEPENDENT_CODE=ON \
 *  -DBOX2D_BUILD_IOS=ON \
 *  -DBINDINGS_SUFFIX=_...
 * </code></pre>
 *
 * @author wil
 * @version 1.0.0
 * @since 1.3.0
 */
public class XconfigureTask extends DefaultTask {

    /** Device type. */
    private final Device device;
    /** Command executor. */
    private final ExecOperations cmd;

    /**
     * Task constructor {@code Xconfigure}.
     *
     * @param device Device
     * @param cmd ExecOperations
     */
    @Inject
    public XconfigureTask(Device device, ExecOperations cmd) {
        this.device = device;
        this.cmd = cmd;
    }

    /**
     * Start the task to be executed
     */
    @TaskAction
    public void configure() {
        BuildDirectory directory = BuildDirectory.getInstance(this);
        IOSProperties iosp       = getProject().getExtensions()
                                               .getByType(IOSProperties.class);
        
        BuildDirectory.Data data = directory.getData();
        File workDir = data.getCMakeWorkingDir();
        
        String minVersion = iosp.getMiVersion().get();
        iosp.getBuildTypes().all((buildType) -> {
            iosp.getProductFlavors().all((flavor) -> {
                BuildType type = buildType.getBuildType().get();
                Flavor fv      = flavor.getFlavor().get();
                
                File buildDir = data.getCMakeBuildTypeDir(device, buildType, flavor);
                IOUtils.checkDir(buildDir);
                
                List<String> arguments = makeCMakeArguments(iosp, buildType, flavor);                
                log("CMake " + type.getName() + ':' + fv.getName());
                logMore("minVersion:", minVersion);
                logMore("workDir:   ", workDir);
                logMore("buildDir:  ", buildDir);
                logMore("arch:      ", device.getType() + '_' + device.getNativeArch());

                cmd.exec((exec) -> {
                    exec.commandLine(
                            "cmake",
                            "-S", workDir,
                            "-B", buildDir,
                            "-G", "Xcode"
                    );
                    exec.args(
                            "-DCMAKE_SYSTEM_NAME=iOS",
                            "-DCMAKE_OSX_SYSROOT=" + device.getType(),
                            "-DCMAKE_OSX_DEPLOYMENT_TARGET=" + minVersion,
                            "-DCMAKE_OSX_ARCHITECTURES=" + device.getNativeArch(),
                            "-DCMAKE_BUILD_TYPE=" + type.getName(),
                            "-DBUILD_SHARED_LIBS=OFF",
                            "-DCMAKE_POSITION_INDEPENDENT_CODE=ON",
                            "-DBOX2D_BUILD_IOS=ON",
                            "-DBINDINGS_SUFFIX=_" + type.getName() + fv.getName()
                    );
                    exec.args(arguments);

                });
            });            
        });
    }
}
