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
import static org.box2d.jni.system.Sys.*;

/**
 * Initializes the Box2d-JNI shared library and handles loading additional
 * shared libraries.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Library {

    public static final String JNI_LIBRARY_NAME = "box2d-jni";

    static {
        String libpath = Sys.B2JNI_LIB_PATH.get(null),
               libname = Sys.B2JNI_LIB_NAME.get(null);

        apiLog("Initializing box2d-jni v1.0.0");
        
        if (libpath == null && libname == null) {
            loadSystem("org/box2d/jni/natives", "box2d-bindings");
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
        Platform platform = Platform.get();
        Platform.Architecture arch = Platform.getArchitecture();
        
        apiLog("Platform: ");
        apiLogMore("OS: %c{" + platform.getName() + "}", Color.PURPLE);
        apiLogMore("ARCH: %c{" + arch.getName() + "}", Color.PURPLE);
        apiLogMore("VM: %c{" + Platform.getJavaName() + "}", Color.PURPLE);
        apiLogMore("VM Ver: %c{" + Platform.getJavaVersion() + "}", Color.PURPLE);
        
        boolean dprecision = BOX2D_DOUBLE_PRECISION.get(false),
                ndebug     = BOX2D_NDEBUG.get(false);
        
        String precision = dprecision
                ? "Dp" 
                : "Sp",

               compilation = ndebug
                ? "Debug"
                : "Release";
        
        StringBuilder builLibPath = new StringBuilder();
        builLibPath.append(module);
        if (platform == Platform.Android) {
            try {
                System.loadLibrary("box2d-bindings_" + compilation + precision);
                return;
            } catch (Exception e) {
                apiErro("The library does not exist on the system: box2d-bindings_" + compilation + precision );
            }
        } else {
            builLibPath.append('/')
                       .append(platform.getNativePath())
                       .append('/')
                       .append(arch.getName());  
        }
        
        
        String libname = System.mapLibraryName("box2d-bindings_" + compilation + precision);
        if (platform == Platform.WINDOWS && !libname.startsWith("lib")) {
            libname = "lib" + libname;
        }
        
        builLibPath.append('/')
                   .append(libname);
        
        String libpath = String.valueOf(builLibPath);
        
        apiLog("Library: ");
        apiLogMore("Jar Path: " + module);
        apiLogMore("Library Directory: " + libpath);
        
        try (InputStream io = context.getClassLoader().getResourceAsStream(libpath)) {
            if (io == null) {
                apiErro("The library does not exist on the classpath: " + libpath);
                return;
            }
            
            Path path = Paths.get(
                System.getProperty("java.io.tmpdir")
            ).resolve(JNI_LIBRARY_NAME);

            if (! Files.exists(path)) {
                Files.createDirectory(path);
            }

            apiLogMore("Temporary directory created: %c{" + path.toAbsolutePath().toString() + "}", Color.CYAN);

            Path libbin = path.resolve(libname);
            Files.copy(io, libbin, StandardCopyOption.REPLACE_EXISTING);

            apiLogMore("Extracted library absolute path: %c{" + libbin.toAbsolutePath().toString() + "}", Color.CYAN);
            load.accept(libbin.toAbsolutePath().toString());
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
}
