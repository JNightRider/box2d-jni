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
 * Method:    nmemByteBuffer
 * Signature: (JI)Ljava/nio/ByteBuffer;
 */
JNIEXPORT jobject JNICALL Java_org_box2d_jni_system_MemoryUtil_nmemByteBuffer
  (JNIEnv * __env, jclass clazz, jlong ptr, jint capacity)
{
    UNUSED_PARAM(clazz)
    return (*__env)->NewDirectByteBuffer(__env, (void*)ptr, capacity);
}

/*
 * Class:     org_box2d_jni_system_MemoryUtil
 * Method:    nmemFree
 * Signature: (Ljava/nio/Buffer;)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_MemoryUtil_nmemFree
    (JNIEnv * __env, jclass clazz, jobject address)
{
    void* const ptr = (void*)(*__env)->GetDirectBufferAddress(__env, address);
    UNUSED_PARAM(clazz)
    free(ptr);
}

/*
 * Class:     org_box2d_jni_system_MemoryUtil
 * Method:    nGetStringUTFChars
 * Signature: (Ljava/lang/String;Z)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_MemoryUtil_nGetStringUTFChars
    (JNIEnv *__env, jclass clazz, jstring str)
{
    const char *ptr = (*__env)->GetStringUTFChars(__env, str, NULL);
    UNUSED_PARAM(clazz)
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
    UNUSED_PARAM(clazz)
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
    UNUSED_PARAM(clazz)
    return (*__env)->NewStringUTF(__env, ptr);
}

