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
