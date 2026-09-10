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
package org.box2d.jni.ios;

import org.box2d.jni.ios.task.Build;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.box2d.jni.ios.task.Libtool;
import org.box2d.jni.ios.task.Xbuild;
import org.box2d.jni.ios.task.Xconfigure;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskContainer;
import org.gradle.api.tasks.TaskProvider;
import org.gradle.process.ExecOperations;

/**
 *
 * @author wil
 * @version 1.0.0
 * @since 1.3.0
 */
public class IOS implements Plugin<Project> {

    private static final Object[] DEPENDS = {
        ":modules:libraries:box2d-bindings:unpackBox2dSource",
        ":modules:libraries:box2d-bindings:unpackLibffiSource",
        ":modules:libraries:box2d-core:classes"
    };

    @Override
    public void apply(Project target) {
        target.getExtensions().create(
                "ios",
                IOSProperties.class
        );        
        TaskContainer tasks = target.getTasks();
        
        TaskProvider<Build> build = tasks.register(Build.NAME, Build.class);
        
        TaskProvider<Xconfigure> configureIosDevice = tasks.register("configureIosDeviceARM64", Xconfigure.class, Device.device_arm64);
        TaskProvider<Xconfigure> configureIosSimulatorArm64 = tasks.register("configureIosSimulator_ARM64", Xconfigure.class, Device.simulator_arm64);
        TaskProvider<Xconfigure> configureIosSimulatorX86_64 = tasks.register("configureIosSimulator_x86_64", Xconfigure.class, Device.simulator_x86_64);

        TaskProvider<Xbuild> buildIosDevice = tasks.register("buildIosDeviceARM64", Xbuild.class, Device.device_arm64);
        TaskProvider<Xbuild> buildIosSimulatorArm64 = tasks.register("buildIosSimulator_ARM64", Xbuild.class, Device.simulator_arm64);
        TaskProvider<Xbuild> buildIosSimulatorX86_64 = tasks.register("buildIosSimulator_x86_64", Xbuild.class, Device.simulator_x86_64);
        
        TaskProvider<Libtool> libtoolIosDevice = tasks.register("libtoolIosDeviceARM64", Libtool.class, Device.device_arm64);
        TaskProvider<Libtool> libtoolIosSimulatorArm64 = tasks.register("libtoolIosSimulator_ARM64", Libtool.class, Device.simulator_arm64);
        TaskProvider<Libtool> libtoolIosSimulatorX86_64 = tasks.register("libtoolIosSimulator_x86_64", Libtool.class, Device.simulator_x86_64);
        
        // --- [ configure ] ---
        configureIosDevice.configure((task) -> {
            task.dependsOn(DEPENDS);
        });
        configureIosSimulatorArm64.configure((task) -> {
            task.dependsOn(DEPENDS);
        });
        configureIosSimulatorX86_64.configure((task) -> {
            task.dependsOn(DEPENDS);
        });

        // --- [ build ] ---
        buildIosDevice.configure((task) -> {
            task.dependsOn(configureIosDevice);
        });
        buildIosSimulatorArm64.configure((task) -> {
            task.dependsOn(configureIosSimulatorArm64);
        });
        buildIosSimulatorX86_64.configure((task) -> {
            task.dependsOn(configureIosSimulatorX86_64);
        });
        
        
        // --- [ libtool ] ---
        libtoolIosDevice.configure((task) -> {
            task.dependsOn(buildIosDevice);
        });
        libtoolIosSimulatorArm64.configure((task) -> {
            task.dependsOn(buildIosSimulatorArm64);
        });
        libtoolIosSimulatorX86_64.configure((task) -> {
            task.dependsOn(buildIosSimulatorX86_64);
        });
        
        build.configure((task) -> {
            IOSProperties iosp = target.getExtensions().getByType(IOSProperties.class);
            Device[] devices = Device.parseValues(
                iosp.getDevices().get()
            );

            for (Device device : devices) {
                switch (device) {
                    case device_arm64 ->
                        task.dependsOn(libtoolIosDevice);
                    case simulator_arm64 ->
                        task.dependsOn(libtoolIosSimulatorArm64);
                    case simulator_x86_64 ->
                        task.dependsOn(libtoolIosSimulatorX86_64);
                    default ->
                        throw new AssertionError();
                }
            }
        });
    }

    public static String xcrun(ExecOperations execOperations, String sdk, String tool) {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            execOperations.exec(spec -> {
                spec.commandLine(
                        "xcrun",
                        "--sdk",
                        sdk,
                        "--find",
                        tool
                );
                spec.setStandardOutput(output);
            });
            return output.toString(StandardCharsets.UTF_8).trim();
        } catch (IOException ex) {
            return null;
        }
    }

    public static String sdkPath(ExecOperations execOperations, String sdk) {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            execOperations.exec(spec -> {
                spec.commandLine(
                        "xcrun",
                        "--sdk",
                        sdk,
                        "--show-sdk-path"
                );
                spec.setStandardOutput(output);
            });
            return output.toString(StandardCharsets.UTF_8).trim();
        } catch (IOException ex) {
            return null;
        }
    }
}
