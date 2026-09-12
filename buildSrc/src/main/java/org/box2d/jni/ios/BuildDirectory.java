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
import static org.box2d.jni.util.IOCheck.*;
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
    
    public static final class Xcframework {
        
        private final LipoData lipoData;
        private final File outputDir;

        public Xcframework(LipoData lipoData, File outputDir) {
            this.lipoData = lipoData;
            this.outputDir = outputDir;
        }

        public Xcframework buildTypeProperty(BuildType typeProperty) {
            lipoData.buildTypeProperty(typeProperty);
            return this;
        }

        public Xcframework flavorProperty(Flavor flavorProperty) {
            lipoData.flavorProperty(flavorProperty);
            return this;
        }

        public LipoData getLipoData() {
            return lipoData;
        }
        
        public File getXcframeworkFile() {
            return ioMakePath(
                    outputDir.getAbsolutePath(), 
                    "Box2DBindings-" + lipoData.getToolData().getMakeData().getType().getName()   + 
                                 "_" + lipoData.getToolData().getMakeData().getFlavor().getName() + ".xcframework"
            );
        }
    }
    
    public static class LipoData {
        private final LibtoolData toolData;
        private final File outputDir;

        public LipoData(LibtoolData toolData, File outputDir) {
            this.toolData = toolData;
            this.outputDir = outputDir;
        }
        
        public LipoData buildTypeProperty(BuildType typeProperty) {
            toolData.buildTypeProperty(typeProperty);
            return this;
        }

        public LipoData flavorProperty(Flavor flavorProperty) {
            toolData.flavorProperty(flavorProperty);
            return this;
        }

        public LibtoolData getToolData() {
            return toolData;
        }
        
        public File getOutputDir() {
            File dir = ioMakePath(outputDir, "/ios" + toolData.getMakeData().getType().getName() + toolData.getMakeData().getFlavor().getName());
            return ioDir(dir);
        }
        
        public File getOutputDir(boolean isDevice) {
            return ioDir(getOutputDir(), isDevice ? "device" : "simulator");
        }
        
        public File getOutputFile(boolean isDevice) {
            return ioMakePath(getOutputDir(isDevice), "libbox2d-jni-ios.a");
        }
    }
    
    public static class LibtoolData {
        private final CMakeData makeData;

        public LibtoolData(CMakeData makeData) {
            this.makeData = makeData;
        }

        public LibtoolData device(Device device) {
            makeData.device(device);
            return this;
        }

        public LibtoolData buildTypeProperty(BuildTypeProperty typeProperty) {
            makeData.buildTypeProperty(typeProperty);
            return this;
        }

        public LibtoolData flavorProperty(FlavorProperty flavorProperty) {
            makeData.flavorProperty(flavorProperty);
            return this;
        }
        
        public LibtoolData buildTypeProperty(BuildType typeProperty) {
            makeData.buildTypeProperty(typeProperty);
            return this;
        }

        public LibtoolData flavorProperty(Flavor flavorProperty) {
            makeData.flavorProperty(flavorProperty);
            return this;
        }

        public CMakeData getMakeData() {
            return makeData;
        }
        
        public File getXCodeNativeDir() {
            return ioDir(getMakeData().getCMakeBuildTypeDir(), "xcode-native");
        }
        
        public File getXCodeNativeFile() {
            return ioMakePath(getXCodeNativeDir(), "libbox2d-jni-ios.a");
        }
        
        public File getXCodeNativeFile(File variant) {
            return ioMakePath(variant, "xcode-native", "libbox2d-jni-ios.a");
        }
    }
    
    public static class CMakeData {

        private final IOSProperties iosp;
        private Device device;
        private BuildType typeProperty;
        private Flavor flavorProperty;

        public CMakeData(IOSProperties iosp) {
            this.iosp = iosp;
        }
 
        private void check() {
            if (device == null || typeProperty == null || flavorProperty == null) {
                throw new NullPointerException(
                        "device=" + device + '\n'
                        + "typeProperty=" + typeProperty + '\n'
                        + "flavorProperty=" + flavorProperty + '\n'
                );
            }
        }

        public CMakeData device(Device device) {
            this.device = device;
            return this;
        }

        public CMakeData buildTypeProperty(BuildTypeProperty typeProperty) {
            this.typeProperty = typeProperty.getBuildType().get();
            return this;
        }

        public CMakeData flavorProperty(FlavorProperty flavorProperty) {
            this.flavorProperty = flavorProperty.getFlavor().get();
            return this;
        }

        public CMakeData buildTypeProperty(BuildType typeProperty) {
            this.typeProperty = typeProperty;
            return this;
        }

        public CMakeData flavorProperty(Flavor flavorProperty) {
            this.flavorProperty = flavorProperty;
            return this;
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
        
        public File getCMakeBuildTypeDir() {
            check();
            String prefix = "ios-" + device.getType() + '_' + device.getArchitecture();
            String nameDir = prefix + '-' + typeProperty.getName() + '_' + flavorProperty.getName();
            return ioDir(getCMakeOutputDir(), nameDir);
        }
        
        public File getCMakeNativeDir() {
            check();
            File buildDir = getCMakeBuildTypeDir();
            File nativeDir = ioMakePath(buildDir, "natives", typeProperty.getName());
            checkDir(nativeDir);
            return nativeDir;
        }
        
        public File getCMakeLibffi() {
            File buildDir = getCMakeBuildTypeDir();
            File libfii = ioMakePath(buildDir, "extern/libffi/lib/libffi.a");
            checkFile(libfii);
            return libfii;
        }

        public Device getDevice() {
            return device;
        }

        public BuildType getType() {
            return typeProperty;
        }

        public Flavor getFlavor() {
            return flavorProperty;
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
    
    public CMakeData getCMakeData() {
        IOSProperties iosp = project.getExtensions()
                                    .getByType(IOSProperties.class);
        return new CMakeData(iosp);
    }
    
    public LibtoolData getLibtoolData() {
        return new LibtoolData(getCMakeData());
    }
    
    public LipoData getLipoData() {
        return new LipoData(getLibtoolData(), getLipoDir());
    }
    
    public Xcframework getXcframework() {
        return new Xcframework(getLipoData(), getXcframeworkDir());
    }
}
