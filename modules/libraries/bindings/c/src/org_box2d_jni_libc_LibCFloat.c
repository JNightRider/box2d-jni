// Copyright Night Rider. All rights reserved.
// https://github.com/JNightRider/box2d-jni/blob/master/LICENSE

/*
 * File:   org_box2d_jni_libc_LibCFloat.h
 * Author: wil
 */

#include <stdlib.h>
#include <float.h>

#include "common_tools.h"
#include "box2d/jni/org_box2d_jni_libc_LibCFloat.h"

/*
 * Class:     org_box2d_jni_libc_LibCFloat
 * Method:    nFLT_EPSILON
 * Signature: ()F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_libc_LibCFloat_nFLT_1EPSILON
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)FLT_EPSILON;
}
