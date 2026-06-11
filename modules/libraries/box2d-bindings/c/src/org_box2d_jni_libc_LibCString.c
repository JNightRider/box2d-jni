// Copyright Night Rider. All rights reserved.
// https://github.com/JNightRider/box2d-jni/blob/master/LICENSE

/*
 * File:   org_box2d_jni_libc_LibCString.h
 * Author: wil
 */

 #include <string.h>

#include "common_tools.h"
#include "box2d/jni/org_box2d_jni_libc_LibCString.h"

/*
 * Class:     org_box2d_jni_libc_LibCString
 * Method:    nmemset
 * Signature: (JIJ)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_libc_LibCString_nmemset
    (JNIEnv *__env, jclass clazz, jlong address, jint value, jlong num)
{
    jlong __result;
    UNUSED_PARAMS(__env, clazz)
    __result = (jlong)(uintptr_t) memset((void *)address, (int)value, (size_t)num);
    return __result;
}

/*
 * Class:     org_box2d_jni_libc_LibCString
 * Method:    nmemcpy
 * Signature: (JJJ)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_libc_LibCString_nmemcpy
    (JNIEnv *__env, jclass clazz, jlong dest, jlong src, jlong n)
{
    jlong __result;
    UNUSED_PARAMS(__env, clazz)
    __result = (jlong)(uintptr_t) memcpy((void *)dest, (const void*) src, (size_t) n);
    return __result;
}

/*
 * Class:     org_box2d_jni_libc_LibCString
 * Method:    nstrlen
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_libc_LibCString_nstrlen
    (JNIEnv *__env, jclass clazz, jlong s)
{
    jlong __result;
    UNUSED_PARAMS(__env, clazz)
    __result = (jlong)(size_t) strlen((char*)s);
    return __result;
}
