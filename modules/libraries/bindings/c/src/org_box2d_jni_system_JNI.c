// Copyright Night Rider. All rights reserved.
// https://opensource.org/license/bsd-3-clause

/*
 * File:   org_box2d_jni_system_JNI.c
 * Author: wil
 */

#include <stdio.h>
#include <stdlib.h>

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
