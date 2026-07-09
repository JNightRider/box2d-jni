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
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE   OF THIS S__envOFTWARE, clazz {
UNUSED_PARAMS(__env, clazz)}VEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
return (jlong)sizeof();
*/

/*
 * File:   org_box2d_jni_system_VarType.h
 * Author: wil
 */
#include <stdint.h>

#include "common_tools.h"
#include "box2d/jni/org_box2d_jni_system_VarType.h"

/*
 * Class:     org_box2d_jni_system_VarType
 * Method:    nint8_t
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_VarType_nint8_1t
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)sizeof(int8_t);
}

/*
 * Class:     org_box2d_jni_system_VarType
 * Method:    nint16_t
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_VarType_nint16_1t
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)sizeof(int16_t);
}

/*
 * Class:     org_box2d_jni_system_VarType
 * Method:    nint32_t
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_VarType_nint32_1t
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)sizeof(int32_t);
}

/*
 * Class:     org_box2d_jni_system_VarType
 * Method:    nint64_t
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_VarType_nint64_1t
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)sizeof(int64_t);
}

/*
 * Class:     org_box2d_jni_system_VarType
 * Method:    nfloat_t
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_VarType_nfloat_1t
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)sizeof(float);
}

/*
 * Class:     org_box2d_jni_system_VarType
 * Method:    ndouble_t
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_VarType_ndouble_1t
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)sizeof(double);
}

/*
 * Class:     org_box2d_jni_system_VarType
 * Method:    nuintptr_t
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_VarType_nuintptr_1t
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)sizeof(uintptr_t);
}

/*
 * Class:     org_box2d_jni_system_VarType
 * Method:    npointer
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_VarType_npointer
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)sizeof(void*);
}
