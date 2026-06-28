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
package org.box2d.jni;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The platforms supported by Box2d-JNI.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.1
 */
public enum Platform {

    FREEBSD("FreeBSD", "freebsd"),
    LINUX("Linux", "linux"),
    MACOSX("macOS", "osx"),
    WINDOWS("Windows", "windows"),
    Android("Android", "android");

    /** The architectures supported by Box2d-JNI. */
    public enum Architecture {
        X64(true, "x64"),
        X86(false, "x86"),
        ARM64(true, "aarch64"),
        ARM32(false, "aarch32"),
        PPC64LE(true, "ppc64le"),
        RISCV64(true, "riscv64");

        static final Architecture current;

        final boolean is64Bit;
        final String name;
        
        static {
            String  osArch  = System.getProperty("os.arch");
            boolean is64Bit = osArch.contains("64") || osArch.startsWith("armv8");

            if (osArch.startsWith("arm") || osArch.startsWith("aarch")) {
                current = is64Bit ? Architecture.ARM64 : Architecture.ARM32;
            } else if (osArch.startsWith("ppc")) {
                if (!"ppc64le".equals(osArch)) {
                    throw new UnsupportedOperationException("Only PowerPC 64 LE is supported.");
                }
                current = Architecture.PPC64LE;
            } else if (osArch.startsWith("riscv")) {
                if (!"riscv64".equals(osArch)) {
                    throw new UnsupportedOperationException("Only RISC-V 64 is supported.");
                }
                current = Architecture.RISCV64;
            } else {
                current = is64Bit ? Architecture.X64 : Architecture.X86;
            }
        }

        Architecture(boolean is64Bit, String name) {
            this.is64Bit = is64Bit;
            this.name = name;
        }

        public String getName() {
            return name;
        }
        
        public boolean is32Bit() {
            return !is64Bit;
        }

        public boolean is64Bit() {
            return is64Bit;
        }
    }

    private static final int JAVA_VERSION;
    private static final String JAVA_NAME;

    private static final Platform current;

    static {
        JAVA_NAME = System.getProperty("java.vm.name");
        if (JAVA_NAME.contains("Dalvik")) {
            current = Android;
            JAVA_VERSION = 0;
        } else {
            String javaVersion = System.getProperty("java.version");
            Matcher matcher = Pattern
                .compile("^([1-9][0-9]*)(?:(?:\\.0)*\\.[1-9][0-9]*)*(?:-[a-zA-Z0-9]+)?")
                .matcher(javaVersion);

            if (!matcher.find()) {
                if (javaVersion.startsWith("1.")) {
                    if (!javaVersion.startsWith("1.8.")) {
                        throw new UnsupportedOperationException("JDK 8 or newer is required.");
                    }
                }
                throw new IllegalStateException("Failed to parse java.version: " + javaVersion);
            }

            JAVA_VERSION = Math.max(8, Integer.parseInt(matcher.group(1)));

            String osName = System.getProperty("os.name");

            if (osName.startsWith("Windows")) {
                current = WINDOWS;
            } else if (osName.startsWith("FreeBSD")) {
                current = FREEBSD;
            } else if (osName.startsWith("Linux") || osName.startsWith("SunOS") || osName.startsWith("Unix")) {
                current = LINUX;
            } else if (osName.startsWith("Mac OS X") || osName.startsWith("Darwin")) {
                current = MACOSX;
            } else {
                throw new LinkageError("Unknown platform: " + osName);
            }
        }
    }

    public static int getJavaVersion() {
        return JAVA_VERSION;
    }
    
    public static String getJavaName() {
        return JAVA_NAME;
    }

    
    private final String name;
    private final String nativePath;

    Platform(String name, String nativePath) {
        this.name = name;
        this.nativePath = nativePath;
    }

    public String getNativePath() {
        return nativePath;
    }
    
    /**
     * Returns the platform name.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the platform on which the library is running.
     *
     * @return Platform
     */
    public static Platform get() {
        return current;
    }

    /**
     * Returns the architecture on which the library is running.
     *
     * @return Architecture
     */
    public static Architecture getArchitecture() {
        return Architecture.current;
    }
}
