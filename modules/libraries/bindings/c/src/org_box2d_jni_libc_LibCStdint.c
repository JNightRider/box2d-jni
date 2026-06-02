// Copyright Night Rider. All rights reserved.
// https://opensource.org/license/bsd-3-clause

/*
 * File:   org_box2d_jni_libc_LibCStdint.c
 * Author: wil
 */

#include <stdint.h>

#include "common_tools.h"
#include "box2d/jni/org_box2d_jni_libc_LibCStdint.h"

/*
 * Class:     org_box2d_jni_libc_LibCStdint
 * Method:    nUINT64_MAX
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_libc_LibCStdint_nUINT64_1MAX
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)UINT64_MAX;
}
