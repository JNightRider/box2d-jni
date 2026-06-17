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

/*
 * File:   org_box2d_jni_system_JNI.c
 * Author: wil
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#include "common_tools.h"
#include "box2d/jni/org_box2d_jni_system_JNI.h"

/*
 * Class:     org_box2d_jni_system_JNI
 * Method:    invokeJIP
 * Signature: (JIJ)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_JNI_invokeJIP
    (JNIEnv *__env, jclass clazz, jlong param0, jint param1, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    return ((jlong) ((uintptr_t* (*) (uintptr_t, int32_t)) (uintptr_t)__functionAddress) ((uintptr_t)param0, (int32_t)param1));
}

/*
 * Class:     org_box2d_jni_system_JNI
 * Method:    invokeJJV
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_JNI_invokeJJV
    (JNIEnv *__env, jclass clazz, jlong param0, jlong param1, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    ((void (*) (uint64_t, uint64_t)) (uintptr_t)__functionAddress) ((uint64_t)param0, (uint64_t)param1);
}

/*
 * Class:     org_box2d_jni_system_JNI
 * Method:    invokePV
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_JNI_invokePV
    (JNIEnv *__env, jclass clazz, jlong param0, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    ((void (*) (uintptr_t)) (uintptr_t)__functionAddress) ((uintptr_t)param0);
}

/*
 * Class:     org_box2d_jni_system_JNI
 * Method:    invokePPII
 * Signature: (JJIJ)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_system_JNI_invokePPII
    (JNIEnv *__env, jclass clazz, jlong param0, jlong param1, jint param2, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    return ((jint) ((int32_t (*) (uintptr_t, uintptr_t, int32_t)) (uintptr_t)__functionAddress) ((uintptr_t)param0, (uintptr_t)param1, (int32_t)param2));
}

/*
 * Class:     org_box2d_jni_system_JNI
 * Method:    invokePPV
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_JNI_invokePPV
    (JNIEnv *__env, jclass clazz, jlong param0, jlong param1, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    ((void (*) (uintptr_t, uintptr_t))(uintptr_t)__functionAddress)((uintptr_t)param0, (uintptr_t)param1);
}

/*
 * Class:     org_box2d_jni_system_JNI
 * Method:    invokePPPP
 * Signature: (JJJJ)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_JNI_invokePPPP
    (JNIEnv *__env, jclass clazz, jlong param0, jlong param1, jlong param2, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    return ((jlong) ((uintptr_t (*) (uintptr_t, uintptr_t, uintptr_t)) (uintptr_t)__functionAddress) ((uintptr_t)param0, (uintptr_t)param1, (uintptr_t)param2));
}

/*
 * Class:     org_box2d_jni_system_JNI
 * Method:    invokeFJFJF
 * Signature: (FJFJJ)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_system_JNI_invokeFJFJF
    (JNIEnv *__env, jclass clazz, jfloat param0, jlong param1, jfloat param2, jlong param3, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    return ((jfloat) ((jfloat (*) (jfloat, uint64_t, jfloat, uint64_t)) (uintptr_t)__functionAddress) ((jfloat)param0, (uint64_t)param1, (jfloat)param2, (uint64_t)param3));
}

/*
 * Class:     org_box2d_jni_system_JNI
 * Method:    invokePIIPV
 * Signature: (JIIJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_JNI_invokePIIPV
    (JNIEnv *__env, jclass clazz, jlong param0, jint param1, jint param2, jlong param3, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    ((void (*) (uintptr_t, uint32_t, uint32_t, uintptr_t))(uintptr_t)__functionAddress)((uintptr_t)param0, (uint32_t)param1, (uint32_t)param2, (uintptr_t)param3);
}
