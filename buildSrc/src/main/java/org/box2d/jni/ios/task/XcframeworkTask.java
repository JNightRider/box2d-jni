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
import org.box2d.jni.cmake.BuildTypeProperty;
import org.box2d.jni.cmake.FlavorProperty;
import org.box2d.jni.ios.BuildDirectory;
import org.box2d.jni.ios.Device;
import org.box2d.jni.ios.IOSProperties;
import static org.box2d.jni.util.Debug.*;
import org.box2d.jni.util.IOUtils;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.process.ExecOperations;

/**
 *
 * @author wil
 */
public class XcframeworkTask extends DefaultTask {

    private final BuildType targetType;
    private final Flavor targetFlavor;
    private final ExecOperations cmd;

    @Inject
    public XcframeworkTask(BuildType targetType, Flavor targetFlavor, ExecOperations cmd) {
        this.targetType = targetType;
        this.targetFlavor = targetFlavor;
        this.cmd = cmd;
    }

    @TaskAction
    public void framework() {
        log("Xcframework " + targetType + ':' + targetFlavor);
        
        BuildDirectory directory = BuildDirectory.getInstance(this);        
        BuildDirectory.Xcframework data = directory.getXcframework()
                                                .buildTypeProperty(targetType)
                                                .flavorProperty(targetFlavor);
        cmd.exec((exec) -> {
            exec.commandLine("xcodebuild", "-create-xcframework");
            exec.args(
                    "-library", data.getLipoData().getOutputFile(true),
                    "-library", data.getLipoData().getOutputFile(false)
            );        
            exec.args("-output", data.getXcframeworkFile());
        });
    }
}
