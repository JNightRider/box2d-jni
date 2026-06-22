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
package org.box2d.jni.android;

/**
 *
 * @author wil
 */
public enum ABI {
    arm64_v8a(Host.aarch64_linux_android, "arm64-v8a", "Android_ARM7"),
    armeabi_v7a(Host.arm_linux_androideabi, "armeabi-v7a", "Android_ARM7"),
    x86(Host.i686_linux_android, "x86", "Android_X86"),
    x86_64(Host.x86_64_linux_android, "x86_64", "Android_X86_64");
    
    public static enum Host {
        arm_linux_androideabi("arm-linux-androideabi"), // 32-bit ARM
        aarch64_linux_android("aarch64-linux-android"), // 64-bit ARM
        i686_linux_android("i686-linux-android"),       // 32-bit Intel x86
        x86_64_linux_android("x86_64-linux-android");   // 64-bit Intel x86
        
        private final String name;

        private Host(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "--host=" +  name;
        }
    }
    
    private final Host host;
    private final String abi;
    private final String name;

    private ABI(Host host, String abi, String name) {
        this.host = host;
        this.abi = abi;
        this.name = name;
    }

    public String getAbi() {
        return abi;
    }

    public String getName() {
        return name;
    }

    public Host getHost() {
        return host;
    }

    @Override
    public String toString() {
        return "Android abi " + host;
    }
}
