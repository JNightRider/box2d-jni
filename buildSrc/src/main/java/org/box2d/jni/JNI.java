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

import electrostatic4j.snaploader.platform.util.NativeVariant;

/**
 *
 * @author wil
 */
public final class JNI {
    
    public static BuildType[] makeBuildType(Object type) {
        if (type == null) {
            return BuildType.values();
        }
        return new BuildType[] {
            BuildType.valueOf(String.valueOf(type))
        };
    }
    
    public static Flavor[] makeFlavor(Object type) {
        if (type == null) {
            return Flavor.values();
        }
        return new Flavor[] {
            Flavor.valueOf(String.valueOf(type))
        };
    }
        
    public static String makePathLib() {
        StringBuilder buffer = new StringBuilder();        

        if (NativeVariant.Os.isLinux()) {
            buffer.append('/')
                  .append("linux");
        } else if (NativeVariant.Os.isMac()) {
            buffer.append('/')
                  .append("osx");
        } else if (NativeVariant.Os.isWindows()) {
            buffer.append('/')
                  .append("windows");
        } else if (NativeVariant.Os.isAndroid()) {
            buffer.append('/')
                  .append("android");
        } else {
            throw new IllegalStateException("The platform is not supported: " + System.getProperty("os.name"));
        }
        
        boolean is64Bit = NativeVariant.Cpu.is64();
        if(NativeVariant.Cpu.isARM()) {
            buffer.append('/')
                  .append(is64Bit ? "arm" : "aarch");
        } else if(NativeVariant.Cpu.isRiscV()) {
            buffer.append('/')
                  .append("riscv");
        } else if(NativeVariant.Cpu.isX86()) {
            buffer.append('/')
                  .append("x86");
        } else if(NativeVariant.Cpu.isAMD()) {
            buffer.append('/')
                  .append("x64");
        } else {
            throw new IllegalStateException("The architecture is not supported: " + System.getProperty("os.name"));
        }
        
        return String.valueOf(buffer);
    }
}
