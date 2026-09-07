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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import org.gradle.api.DefaultTask;
import org.gradle.api.file.Directory;
import org.gradle.api.file.ProjectLayout;
import org.gradle.api.provider.Provider;
import org.gradle.api.tasks.TaskAction;

/**
 *
 * @author wil
 */
public class TaskPrepareIosFrameworkInputs extends DefaultTask {

    private static String CONTENT = null;
    
    private static String getContent(ProjectLayout layout) throws IOException {
        if (CONTENT == null) {
            CONTENT = "";
            File file = layout.getProjectDirectory().dir("src/main/Info.plist").getAsFile();
            try (BufferedReader rd = new BufferedReader(new FileReader(file))) {
                String buff;
                while ((buff = rd.readLine()) != null) {
                    CONTENT += (buff + '\n');
                }                
            }
        }
        return CONTENT;
    }
    
    
    @TaskAction
    public void prepareIosFrameworkInputs() throws IOException {
        IOSSetup setup = getProject().getExtensions().getByType(IOSSetup.class);
        ProjectLayout layout = getProject().getLayout();
        
        Provider<Directory> generatedPlistsDir = layout.getBuildDirectory().dir("cxx/plists");
        File directory = generatedPlistsDir.get() .getAsFile();

        if (! directory.exists() )
        {
            if (!directory.mkdirs())
            {
                throw new IOException("Error creating the build folder: " + directory);
            }
        }
        
        InfoPlist infoPlist = setup.getInfoPlist();
        infoPlist.getCFBundleIdentifier()
                 .all( variant -> {            
            try {
                Provider<String> minVer = infoPlist.getMinimumOSVersion();
                if (minVer == null || minVer.get().isEmpty()) {
                    minVer = setup.getMiinVersion();
                }
                
                File file = new File(directory, variant.getName() + "-Info.plist");
                Files.writeString(file.toPath(), getContent(layout).formatted(
                        infoPlist.getCFBundleDevelopmentRegion().get(),
                        infoPlist.getCFBundleExecutable().get(),
                        variant.getIdentifier().get(),
                        infoPlist.getCFBundleInfoDictionaryVersion().get(),
                        infoPlist.getCFBundleName().get(),
                        infoPlist.getCFBundlePackageType().get(),
                        infoPlist.getCFBundleShortVersionString().get(),
                        infoPlist.getCFBundleVersion().get().toString(),
                        minVer.get()
                ));
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        });
    }
}
