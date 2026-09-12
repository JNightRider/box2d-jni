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

import java.io.File;
import org.box2d.jni.BuildType;
import org.box2d.jni.Flavor;
import org.box2d.jni.cmake.BuildTypeProperty;
import org.box2d.jni.cmake.FlavorProperty;
import static org.box2d.jni.util.IOUtils.*;
import org.gradle.api.DefaultTask;
import org.gradle.api.Project;

/**
 *
 * @author wil
 */
public final class BuildDirectory {

    public static BuildDirectory getInstance(DefaultTask task) {
        Project project = task.getProject();
        return new BuildDirectory(project);
    }
    
    public static class Data {

        private final IOSProperties iosp;

        public Data(IOSProperties iosp) {
            this.iosp = iosp;
        }

        public File getCMakeWorkingDir() {
            return ioDir(
                    iosp.getCMake()
                        .getWorkingDir()
                        .get()
            );
        }
        
        public File getCMakeOutputDir() {
            return ioDir(
                    iosp.getCMake()
                        .getOutputDir()
                        .get()
            );
        }
        
        public File getCMakeBuildTypeDir(Device device, BuildTypeProperty typeProperty, FlavorProperty flavorProperty) {
            BuildType type = typeProperty.getBuildType().get();
            Flavor fv = flavorProperty.getFlavor().get();
            
            String prefix = "ios-" + device.getType() + '_' + device.getArchitecture();
            String nameDir = prefix + '-' + type.getName() + '_' + fv.getName();
            return ioDir(getCMakeOutputDir(), nameDir);
        }
    }

    public static final String
            DIR_CXX = "cxx",
            DIR_LIPO = "lipo",
            DIR_XFRAMEWORK = "Xcframework";

    private final Project project;

    public BuildDirectory(Project project) {
        this.project = project;
    }

    public File getBuildFile() {
        return project.getBuildFile();
    }

    public File getCXXDir() {
        return ioDir(getBuildFile(), DIR_CXX);
    }

    public File getLipoDir() {
        return ioDir(getBuildFile(), DIR_LIPO);
    }

    public File getXcframeworkDir() {
        return ioDir(getBuildFile(), DIR_XFRAMEWORK);
    }
    
    public Data getData() {
        IOSProperties iosp = project.getExtensions()
                                    .getByType(IOSProperties.class);
        return new Data(iosp);
    }
}
