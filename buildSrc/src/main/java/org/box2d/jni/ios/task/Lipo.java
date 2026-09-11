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
import org.box2d.jni.ios.Device;
import org.box2d.jni.ios.IOSProperties;
import static org.box2d.jni.util.Debug.log;
import static org.box2d.jni.util.Debug.logMore;
import org.box2d.jni.util.IOUtils;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.process.ExecOperations;

/**
 *
 * @author wil
 */
public class Lipo extends DefaultTask {
    
    private final BuildType targetType;
    private final Flavor targetFlavor;
    private final ExecOperations cmd;

    @Inject
    public Lipo(BuildType targetType, Flavor targetFlavor, ExecOperations cmd) {
        this.targetType = targetType;
        this.targetFlavor = targetFlavor;
        this.cmd = cmd;
    }
    
    @TaskAction
    public void lipo() {
        log("Lipo " + targetType + ':' + targetFlavor);
        
        IOSProperties iosp = getProject().getExtensions().getByType(IOSProperties.class);
        File buildDir = getProject().getLayout().getBuildDirectory().getAsFile().get();
        File cxxDir =  new File(iosp.getCMake().getOutputDir().get());

        File outputDir = new File(buildDir, "Xcframework/ios" + targetType.getName() + targetFlavor.getName());
        IOUtils.checkDir(outputDir);
        
        
        List<File> simulator = new ArrayList<>();
        List<File> device    = new ArrayList<>();
        for (File file : cxxDir.listFiles()) {
            String name = file.getName();

            if (checkTypes(name)) {
                File liba = new File(file, "xcode-native/libbox2d-jni-ios.a");
                
                if (checkSimulator(name)) {
                    simulator.add(liba);
                } else {
                    device.add(liba);
                }
            }
        }
        
        cmd.exec((exec) -> {
            exec.commandLine("lipo", "-create");
            for (File file : simulator) {
                exec.args(file);
            }
            exec.args("-output", new File(IOUtils.checkDir(new File(outputDir, "simulato")), "libbox2d-jni-ios.a"));
        });
        
        IOUtils.flCopy(device, new File(outputDir, "device"));
    }
    
    private boolean checkTypes(String name ){
        if (name.contains(targetType.getName() + '_' + targetFlavor.getName())) {
            return true;
        }
        return false;
    }
    
    private boolean checkSimulator(String name) {
        if (name.contains(Device.simulator_arm64.getType()) ||
                name.contains(Device.simulator_x86_64.getType())) {
            return true;
        }
        return false;
    }
}
