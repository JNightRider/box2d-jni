// Copyright Night Rider. All rights reserved.
// https://github.com/JNightRider/box2d-jni/blob/master/LICENSE

/*
 * File:   org_box2d_jni_libc_LibCStdlib.h
 * Author: wil
 */

#include <stdlib.h>

#include "common_tools.h"
#include "box2d/jni/org_box2d_jni_libc_LibCStdlib.h"

/*
 * Class:     org_box2d_jni_libc_LibCStdlib
 * Method:    nmalloc
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_libc_LibCStdlib_nmalloc
    (JNIEnv *__env, jclass clazz, jlong size)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)(uintptr_t)malloc((size_t)size);
}

/*
 * Class:     org_box2d_jni_libc_LibCStdlib
 * Method:    nfree
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_libc_LibCStdlib_nfree
    (JNIEnv *__env, jclass clazz, jlong ptrAddress)
{
    void *ptr = (void *)(uintptr_t)ptrAddress;
    UNUSED_PARAMS(__env, clazz)
    free(ptr);
}
