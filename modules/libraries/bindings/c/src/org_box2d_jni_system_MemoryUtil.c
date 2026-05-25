// Copyright Night Rider. All rights reserved.
// https://opensource.org/license/bsd-3-clause

/*
 * File:   org_box2d_jni_system_MemoryUtil.c
 * Author: wil
 */

#include <string.h>
#include <stdlib.h>

#include "common_tools.h"
#include "box2d/jni/org_box2d_jni_system_MemoryUtil.h"


/*
 * Class:     org_box2d_jni_system_MemoryUtil
 * Method:    nGetStringUTFChars
 * Signature: (Ljava/lang/String;Z)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_MemoryUtil_nGetStringUTFChars
    (JNIEnv *__env, jclass clazz, jstring str)
{
    const char *ptr = (*__env)->GetStringUTFChars(__env, str, NULL);
    return (jlong)ptr;
}

/*
 * Class:     org_box2d_jni_system_MemoryUtil
 * Method:    nReleaseStringUTFChars
 * Signature: (Ljava/lang/String;J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_MemoryUtil_nReleaseStringUTFChars
    (JNIEnv *__env, jclass clazz, jstring str, jlong address)
{
    char* ptr = (char*)(uintptr_t)address;
    (*__env)->ReleaseStringUTFChars(__env, str, ptr);
}

/*
 * Class:     org_box2d_jni_system_MemoryUtil
 * Method:    nNewStringUTF
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_box2d_jni_system_MemoryUtil_nNewStringUTF
    (JNIEnv *__env, jclass clazz, jlong address)
{
    char* ptr = (char*)(uintptr_t)address;
    return (*__env)->NewStringUTF(__env, ptr);
}

