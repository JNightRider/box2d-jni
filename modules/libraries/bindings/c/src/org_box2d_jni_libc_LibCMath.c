// Copyright Night Rider. All rights reserved.
// https://github.com/JNightRider/box2d-jni/blob/master/LICENSE

/*
 * File:   org_box2d_jni_libc_LibCMath.h
 * Author: wil
 */

#include <stdlib.h>
#include <math.h>

#include "common_tools.h"
#include "box2d/jni/org_box2d_jni_libc_LibCMath.h"

/*
 * Class:     org_box2d_jni_libc_LibCMath
 * Method:    ncosf
 * Signature: (F)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_libc_LibCMath_ncosf
(JNIEnv *__env, jclass clazz, jfloat a)
{
    return (jfloat)cosf(a);
}

/*
 * Class:     org_box2d_jni_libc_LibCMath
 * Method:    nsinf
 * Signature: (F)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_libc_LibCMath_nsinf
(JNIEnv *__env, jclass clazz, jfloat a)
{
    return (jfloat)sinf(a);
}

/*
 * Class:     org_box2d_jni_libc_LibCMath
 * Method:    natan2f
 * Signature: (FF)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_libc_LibCMath_natan2f
(JNIEnv *__env, jclass clazz, jfloat y, jfloat x)
{
    return (jfloat)atan2f(y, x);
}
