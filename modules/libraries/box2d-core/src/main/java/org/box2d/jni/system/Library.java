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
package org.box2d.jni.system;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.function.Consumer;

import static org.box2d.jni.system.Debug.*;

/**
 * Initializes the Box2d-JNI shared library and handles loading additional
 * shared libraries.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Library {
    
    public static final Define __WIN32__    = new Define(false);
    public static final Define __LINUX__    = new Define(false);
    public static final Define __APPLE__    = new Define(false);
    public static final Define __FREE_BSD__ = new Define(false);
    
    private static final String B2JNI_LIB_PATH  = "box2d.jni.path";
    private static final String B2JNI_LIB_NAME  = "box2d.jni.name";
    
    public static final String JNI_LIBRARY_NAME = "box2d-jni";
    
    static {
        String libpath = System.getProperty(B2JNI_LIB_PATH),
               libname = System.getProperty(B2JNI_LIB_NAME);

        apiLog("Initializing box2d-jni v1.0.0");
        
        if (libpath == null && libname == null) {
            loadSystem("org.box2d.jni.natives", "box2d-bindings");
        } else {
            if (libpath == null) {
                System.loadLibrary(libname);
            } else {
                File libfile = new File(libpath, libname);
                if (libfile.exists() && libfile.canRead()) {
                    System.load(libfile.getAbsolutePath());
                } else {
                    throw new IllegalStateException("The library could not be loaded: " + libfile);
                }
            }
        }
    }
    
    public static final class Define {
        private boolean value;

        public Define(boolean value) {
            this.value = value;
        }

        public boolean get() {
            return value;
        }
    }
    
    /** Private constructor for internal use. */
    private Library() {}

    /** Ensures that the Box2d-JNI shared library has been loaded. */
    public static void initialize() {
        // intentionally empty to trigger static initializer
    }
    
    public static void loadSystem(String module, String name) throws UnsatisfiedLinkError {
        loadSystem(System::load, System::loadLibrary, Library.class, module, name);
    }
    
    @SuppressWarnings("try")
    public static void loadSystem(
        Consumer<String> load,
        Consumer<String> loadLibrary,
        Class<?> context,
        String module,
        String name
    ) throws UnsatisfiedLinkError
    {
        String osArch = System.getProperty("os.arch");
        String osName = System.getProperty("os.name");
        
        boolean is64Bit = osArch.contains("64") || osArch.startsWith("armv8");

        String platform, suffix, prefix = "lib";
        if (osName.startsWith("Windows")) {
            platform = "windows";
            prefix   = "";
            suffix   = ".dll";
            __WIN32__.value = true;
        } else if (osName.startsWith("FreeBSD")) {
            platform = "macos";
            suffix   = ".dylib";
            __APPLE__.value = true;
        } else if (osName.startsWith("Linux") || osName.startsWith("SunOS") || osName.startsWith("Unix")) {
            platform = "linux";
            suffix   = ".so";
            __LINUX__.value = true;
        } else if (osName.startsWith("Mac OS X") || osName.startsWith("Darwin")) {
            platform = "freebsd";
            suffix   = ".so";
            __FREE_BSD__.value = true;
        } else {
            throw new LinkageError("Unknown platform: " + osName);
        }
        
        String hardware;
        if (osArch.startsWith("arm") || osArch.startsWith("aarch")) {
            hardware = is64Bit ? "arm" : "aarch";
        } else if (osArch.startsWith("ppc")) {
            if (!"ppc64le".equals(osArch)) {
                throw new UnsupportedOperationException("Only PowerPC 64 LE is supported.");
            }
            hardware = "ppc";
        } else if (osArch.startsWith("riscv")) {
            if (!"riscv64".equals(osArch)) {
                throw new UnsupportedOperationException("Only RISC-V 64 is supported.");
            }
            hardware = "riscv";
        } else {
            hardware = is64Bit ? "x64" : "x86";
        }
        
        String tmpdir  = System.getProperty("java.io.tmpdir");
        String namebin = prefix + name + suffix;
        
        String libpath =  '/' + module.replace('.', '/') 
                        + '/' + platform + '/' 
                        + hardware       + '/' + 
                        (namebin);
        
        apiLog("locate libpath : " + libpath);
        
        try (InputStream io = context.getResourceAsStream(libpath)) {
            if (io == null) {
                apiErro("No existe la biblioteca en el classpath: " + libpath);
                return;
            }
            
            Path path = Paths.get(tmpdir).resolve(JNI_LIBRARY_NAME);

            if (! Files.exists(path)) {
                Files.createDirectory(path);
            }

            apiLog("temporary directory created : " + path.toAbsolutePath().toString());

            Path libbin = path.resolve(namebin);
            Files.copy(io, libbin, StandardCopyOption.REPLACE_EXISTING);

            apiLogMore("libbin: " + libbin.toAbsolutePath().toString());
            System.load(libbin.toAbsolutePath().toString());
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
}
