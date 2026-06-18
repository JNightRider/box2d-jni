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
 * File:   org_box2d_jni_system_JNIB2.c
 * Author: wil
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#include "common_tools.h"

#include "box2d/id.h"
#include "box2d/math_functions.h"
#include "box2d/jni/org_box2d_jni_system_JNIB2.h"

/*
 * Class:     org_box2d_jni_system_JNIB2
 * Method:    invoke_SHAPEID_SHAPEID_PB
 * Signature: (JJJJ)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_system_JNIB2_invoke_1SHAPEID_1SHAPEID_1PB
    (JNIEnv *__env, jclass clazz, jlong param0, jlong param1, jlong param2, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    return ((jboolean) ((bool (*) (b2ShapeId, b2ShapeId, uintptr_t)) (uintptr_t)__functionAddress) (*(b2ShapeId*)param0, *(b2ShapeId*)param1, (uintptr_t)param2));
}

/*
 * Class:     org_box2d_jni_system_JNIB2
 * Method:    invoke_SHAPEID_PB
 * Signature: (JJJ)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_system_JNIB2_invoke_1SHAPEID_1PB
    (JNIEnv *__env, jclass clazz, jlong param0, jlong param1, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    return ((jboolean) ((bool (*) (b2ShapeId, uintptr_t)) (uintptr_t)__functionAddress) (*(b2ShapeId*)param0, (uintptr_t)param1));
}


/*
 * Class:     org_box2d_jni_system_JNIB2
 * Method:    invoke_SHAPEID_PPB
 * Signature: (JJJJ)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_system_JNIB2_invoke_1SHAPEID_1PPB
    (JNIEnv *__env, jclass clazz, jlong param0, jlong param1, jlong param2, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    return ((jboolean) ((bool (*) (b2ShapeId, uintptr_t, uintptr_t)) (uintptr_t)__functionAddress) (*(b2ShapeId*)param0, (uintptr_t)param1, (uintptr_t)param2));
}

/*
 * Class:     org_box2d_jni_system_JNIB2
 * Method:    invoke_SHAPEID_SHAPEID_VEC2_VEC2_PB
 * Signature: (JJJJJJ)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_system_JNIB2_invoke_1SHAPEID_1SHAPEID_1VEC2_1VEC2_1PB
    (JNIEnv *__env, jclass clazz, jlong param0, jlong param1, jlong param2, jlong param3, jlong param4, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    return ((jboolean) ((bool (*) (b2ShapeId, b2ShapeId, b2Vec2, b2Vec2, uintptr_t)) (uintptr_t)__functionAddress) (*(b2ShapeId*)param0, *(b2ShapeId*)param1, *(b2Vec2*)param2, *(b2Vec2*)param3, (uintptr_t)param4));
}

/*
 * Class:     org_box2d_jni_system_JNIB2
 * Method:    invoke_SHAPEID_VEC2_VEC2_FPF
 * Signature: (JJJFJJ)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_system_JNIB2_invoke_1SHAPEID_1VEC2_1VEC2_1FPF
    (JNIEnv *__env, jclass clazz, jlong param0, jlong param1, jlong param2, jfloat param3, jlong param4, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    return ((jfloat) ((float (*) (b2ShapeId, b2Vec2, b2Vec2, float, uintptr_t)) (uintptr_t)__functionAddress) (*(b2ShapeId*)param0, *(b2Vec2*)param1, *(b2Vec2*)param2, (float)param3, (uintptr_t)param4));
}

/*
 * Class:     org_box2d_jni_system_JNIB2
 * Method:    invoke_TRANSFORM_PIFIPV
 * Signature: (JJIFIJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_JNIB2_invoke_1TRANSFORM_1PIFIPV
    (JNIEnv *__env, jclass clazz, jlong param0, jlong param1, jint param2, jfloat param3, jint param4, jlong param5, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    ((void (*) (b2Transform, uintptr_t, uint32_t, float, uint32_t, uintptr_t)) (uintptr_t)__functionAddress) (*(b2Transform*)param0, (uintptr_t)param1, (uint32_t)param2, (float)param3, (uint32_t)param4, (uintptr_t)param5);
}

/*
 * Class:     org_box2d_jni_system_JNIB2
 * Method:    invoke_TRANSFORM_PV
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_JNIB2_invoke_1TRANSFORM_1PV
    (JNIEnv *__env, jclass clazz, jlong param0, jlong param1, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    ((void (*) (b2Transform, uintptr_t)) (uintptr_t)__functionAddress) (*(b2Transform*)param0, (uintptr_t)param1);
}

/*
 * Class:     org_box2d_jni_system_JNIB2
 * Method:    invoke_TRANSFORM_FIPV
 * Signature: (JFIJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_JNIB2_invoke_1TRANSFORM_1FIPV
    (JNIEnv *__env, jclass clazz, jlong param0, jfloat param1, jint param2, jlong param3, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    ((void (*) (b2Transform, float, uint32_t, uintptr_t)) (uintptr_t)__functionAddress) (*(b2Transform*)param0, (float)param1, (uint32_t)param2, (uintptr_t)param3);
}

/*
 * Class:     org_box2d_jni_system_JNIB2
 * Method:    invoke_VEC2_FIPV
 * Signature: (JFIJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_JNIB2_invoke_1VEC2_1FIPV
    (JNIEnv *__env, jclass clazz, jlong param0, jfloat param1, jint param2, jlong param3, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    ((void (*) (b2Vec2, float, uint32_t, uintptr_t)) (uintptr_t)__functionAddress) (*(b2Vec2*)param0, (float)param1, (uint32_t)param2, (uintptr_t)param3);
}

/*
 * Class:     org_box2d_jni_system_JNIB2
 * Method:    invoke_VEC2_VEC2_FIPV
 * Signature: (JJFIJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_JNIB2_invoke_1VEC2_1VEC2_1FIPV
    (JNIEnv *__env, jclass clazz, jlong param0, jlong param1, jfloat param2, jint param3, jlong param4, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    ((void (*) (b2Vec2, b2Vec2, float, uint32_t, uintptr_t)) (uintptr_t)__functionAddress) (*(b2Vec2*)param0, *(b2Vec2*)param1, (float)param2, (uint32_t)param3, (uintptr_t)param4);
}

/*
 * Class:     org_box2d_jni_system_JNIB2
 * Method:    invoke_VEC2_VEC2_IPV
 * Signature: (JJIJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_JNIB2_invoke_1VEC2_1VEC2_1IPV
    (JNIEnv *__env, jclass clazz, jlong param0, jlong param1, jint param2, jlong param3, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    ((void (*) (b2Vec2, b2Vec2, uint32_t, uintptr_t)) (uintptr_t)__functionAddress) (*(b2Vec2*)param0, *(b2Vec2*)param1, (uint32_t)param2, (uintptr_t)param3);
}

/*
 * Class:     org_box2d_jni_system_JNIB2
 * Method:    invoke_VEC2_PIPV
 * Signature: (JJIJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_JNIB2_invoke_1VEC2_1PIPV
    (JNIEnv *__env, jclass clazz, jlong param0, jlong param1, jint param2, jlong param3, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    ((void (*) (b2Vec2, uintptr_t, uint32_t, uintptr_t)) (uintptr_t)__functionAddress) (*(b2Vec2*)param0, (uintptr_t)param1, (uint32_t)param2, (uintptr_t)param3);
}

/*
 * Class:     org_box2d_jni_system_JNIB2
 * Method:    invoke_SHAPEID_POS_VEC2_FPF
 * Signature: (JJJFJJ)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_system_JNIB2_invoke_1SHAPEID_1POS_1VEC2_1FPF
    (JNIEnv *__env, jclass clazz, jlong param0, jlong param1, jlong param2, jfloat param3, jlong param4, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    return ((jfloat) ((float (*) (b2ShapeId, b2Pos, b2Vec2, float, uintptr_t)) (uintptr_t)__functionAddress) (*(b2ShapeId*)param0, *(b2Pos*)param1, *(b2Vec2*)param2, (float)param3, (uintptr_t)param4));
}

/*
 * Class:     org_box2d_jni_system_JNIB2
 * Method:    invoke_SHAPEID_SHAPEID_POS_VEC2_PB
 * Signature: (JJJJJJ)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_system_JNIB2_invoke_1SHAPEID_1SHAPEID_1POS_1VEC2_1PB
    (JNIEnv *__env, jclass clazz, jlong param0, jlong param1, jlong param2, jlong param3, jlong param4, jlong __functionAddress)
{
    UNUSED_PARAMS(__env, clazz)
    return ((jboolean) ((bool (*) (b2ShapeId, b2ShapeId, b2Pos, b2Vec2, uintptr_t)) (uintptr_t)__functionAddress) (*(b2ShapeId*)param0, *(b2ShapeId*)param1, *(b2Pos*)param2, *(b2Vec2*)param3, (uintptr_t)param4));
}
