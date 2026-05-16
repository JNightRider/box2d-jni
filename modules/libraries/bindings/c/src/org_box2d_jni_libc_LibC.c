// Copyright Night Rider. All rights reserved.
// https://github.com/JNightRider/box2d-jni/blob/master/LICENSE

/*
 * File:   org_box2d_jni_libc_LibC.h
 * Author: wil
 */


#include <stdint.h>
#include <stdbool.h>

#include "common_tools.h"
#include "box2d/jni/org_box2d_jni_libc_LibC.h"

#define TYPE_CHAR    1
#define TYPE_INT     2
#define TYPE_FLOAT   3
#define TYPE_DOUBLE  4
#define TYPE_LONG    5
#define TYPE_BOOL    6
#define TYPE_POINTER 7

/*
 * Class:     org_box2d_jni_libc_LibC
 * Method:    nsizeof
 * Signature: (I)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_libc_LibC_nsizeof__I
    (JNIEnv *__env, jclass clazz, jint vartype)
{
    jlong __result = 0;
    UNUSED_PARAMS(__env, clazz)
    int type = (int) vartype;

    switch (type)
    {
    case TYPE_CHAR:     __result = (jlong)(uintptr_t) sizeof(char);     break;
    case TYPE_INT:      __result = (jlong)(uintptr_t) sizeof(int);      break;
    case TYPE_FLOAT:    __result = (jlong)(uintptr_t) sizeof(float);    break;
    case TYPE_DOUBLE:   __result = (jlong)(uintptr_t) sizeof(double);   break;
    case TYPE_LONG:     __result = (jlong)(uintptr_t) sizeof(long);     break;
    case TYPE_BOOL:     __result = (jlong)(uintptr_t) sizeof(bool);     break;
    case TYPE_POINTER:  __result = (jlong)(uintptr_t) sizeof(void*);    break;
    default:
        break;
    }
    return __result;
}

/*
 * Class:     org_box2d_jni_libc_LibC
 * Method:    nsizeof
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_libc_LibC_nsizeof__J
    (JNIEnv *__env, jclass clazz, jlong address)
{
    jlong __result;
    UNUSED_PARAMS(__env, clazz)
    void* ptr = (void*)(uintptr_t) address;
    __result = (jlong)(uintptr_t) sizeof(ptr);
    return __result;
}
