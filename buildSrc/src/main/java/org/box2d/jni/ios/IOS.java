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

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskProvider;
import org.gradle.process.ExecOperations;

/**
 *
 * @author wil
 * @version 1.0.0
 * @since 1.3.0
 */
public class IOS implements Plugin<Project> {

    @Override
    public void apply(Project target) {
        target.getExtensions().create(
                "ios",
                IOSSetup.class
        );
        TaskProvider<TaskBuild> build = target.getTasks().register("build", TaskBuild.class);
        TaskProvider<TaskPrepareIosFrameworkInputs> prepareIosFrameworkInputs = target.getTasks().register("prepareIosFrameworkInputs", TaskPrepareIosFrameworkInputs.class);
        
        build.configure(task -> {
            task.dependsOn(prepareIosFrameworkInputs);
        });
    }
    
    public static String xcrun(ExecOperations execOperations, String sdk, String tool ) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
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
    }
    
    public static String sdkPath(ExecOperations execOperations, String sdk) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
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
    }
}
