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

/**
 * Class responsible for providing native methods that reference calls to native
 * functions or members.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class JNI {
    
    static {
        Library.initialize();
    }
    
    public static native long invokeJIP(long param0, int param1, long __functionAddress);    
    public static native void invokeJJV(long param0, long param1, long __functionAddress);
    public static native void invokePV(long param0, long __functionAddress);
    public static native int invokePPII(long param0, long param1, int param2, long __functionAddress);
    
    public static native void invokePPV(long param0, long param1, long __functionAddress);
    public static native long invokePPPP(long param0, long param1, long param2, long __functionAddress);
    public static native float invokeFJFJF(float param0, long param1, float param2, long param3, long __functionAddress);
    
    public static native void invokePIIPV(long param0, int param1, int param2, long param3, long __functionAddress);
}
