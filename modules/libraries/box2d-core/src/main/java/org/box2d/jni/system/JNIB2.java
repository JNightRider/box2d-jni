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
 * functions or members (Box2d).
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class JNIB2 {

    public static native boolean invoke_SHAPEID_PB(long param0, long param1, long __functionAddress);
    public static native boolean invoke_SHAPEID_PPB(long param0, long param1, long param2, long __functionAddress);
    public static native boolean invoke_SHAPEID_SHAPEID_PB(long param0, long param1, long param2, long __functionAddress);
    public static native boolean invoke_SHAPEID_SHAPEID_VEC2_VEC2_PB(long param0, long param1, long param2, long param3, long param4, long __functionAddress);
    public static native boolean invoke_SHAPEID_SHAPEID_POS_VEC2_PB(long param0, long param1, long param2, long param3, long param4, long __functionAddress);

    public static native float invoke_SHAPEID_VEC2_VEC2_FPF(long param0, long param1, long param2, float param3, long param4, long __functionAddress);
    public static native float invoke_SHAPEID_POS_VEC2_FPF(long param0, long param1, long param2, float param3, long param4, long __functionAddress);
    public static native void invoke_TRANSFORM_PIFIPV(long param0, long param1, int param2, float param3, int param4, long param5, long __functionAddress);
    public static native void invoke_WORLDTRANSFORM_PIFIPV(long param0, long param1, int param2, float param3, int param4, long param5, long __functionAddress);

    public static native void invoke_TRANSFORM_PV(long param0, long param1, long __functionAddress);
    public static native void invoke_TRANSFORM_FIPV(long param0, float param1, int param2, long param3, long __functionAddress);
    public static native void invoke_VEC2_FIPV(long param0, float param1, int param2, long param3, long __functionAddress);
    public static native void invoke_VEC2_VEC2_FIPV(long param0, long param1, float param2, int param3, long param4, long __functionAddress);
    public static native void invoke_VEC2_VEC2_IPV(long param0, long param1, int param2, long param3, long __functionAddress);
    public static native void invoke_VEC2_PIPV(long param0, long param1, int param2, long param3, long __functionAddress);

    public static native void invoke_WORLDTRANSFORM_PIIPV(long param0, long param1, int param2, int param3, long param4, long __functionAddress);
    public static native void invoke_WORLDTRANSFORM__VEC2_FIPV(long param0, long param1, float param2, int param3, long param4, long __functionAddress);
}
