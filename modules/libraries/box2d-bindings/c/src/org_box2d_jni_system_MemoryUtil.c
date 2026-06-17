/*
BSD 3-Clause License

Copyright (c) 2026, Night Rider

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

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

