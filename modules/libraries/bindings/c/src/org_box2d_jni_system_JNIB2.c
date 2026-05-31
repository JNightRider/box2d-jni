// Copyright Night Rider. All rights reserved.
// https://opensource.org/license/bsd-3-clause

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