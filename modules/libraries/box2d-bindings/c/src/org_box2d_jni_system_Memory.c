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
 * File:   org_box2d_jni_system_Memory.h
 * Author: wil
 */

#include "common_tools.h"
#include "box2d/jni/org_box2d_jni_system_Memory.h"

// -----------

static inline int8_t getByte(void *ptr) { return *(int8_t *)ptr; }
static inline int16_t getShort(void *ptr) { return *(int16_t *)ptr; }
static inline int32_t getInt(void *ptr) { return *(int32_t *)ptr; }
static inline int64_t getLong(void *ptr) { return *(int64_t *)ptr; }
static inline float getFloat(void *ptr) { return *(float *)ptr; }
static inline double getDouble(void *ptr) { return *(double *)ptr; }
static inline uintptr_t getAddress(void *ptr) { return *(uintptr_t *)ptr; }

// -----------

static inline void putByte(void *ptr, int8_t value) { *(int8_t *)ptr = value; }
static inline void putShort(void *ptr, int16_t value) { *(int16_t *)ptr = value; }
static inline void putInt(void *ptr, int32_t value) { *(int32_t *)ptr = value; }
static inline void putLong(void *ptr, int64_t value) { *(int64_t *)ptr = value; }
static inline void putFloat(void *ptr, float value) { *(float *)ptr = value; }
static inline void putDouble(void *ptr, double value) { *(double *)ptr = value; }
static inline void putAddress(void *ptr, uintptr_t value) { *(uintptr_t *)ptr = value; }

// -----------

/*
 * Class:     org_box2d_jni_system_Memory
 * Method:    nsizeof
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_system_Memory_nsizeof
    (JNIEnv *__env, jclass clazz, jlong address)
{
    jint __result;
    UNUSED_PARAMS(__env, clazz)
    void* ptr = (void*)(uintptr_t) address;
    __result = (jint)sizeof(ptr);
    return __result;
}

/*
 * Class:     org_box2d_jni_system_Memory
 * Method:    ngetByte
 * Signature: (J)B
 */
JNIEXPORT jbyte JNICALL Java_org_box2d_jni_system_Memory_ngetByte
    (JNIEnv *__env, jclass clazz, jlong address)
{
    void *ptr = (void *)(uintptr_t)address;
    UNUSED_PARAMS(__env, clazz)
    return (jbyte)getByte(ptr);
}

/*
 * Class:     org_box2d_jni_system_Memory
 * Method:    ngetShort
 * Signature: (J)S
 */
JNIEXPORT jshort JNICALL Java_org_box2d_jni_system_Memory_ngetShort
    (JNIEnv *__env, jclass clazz, jlong address)
{
    void *ptr = (void *)(uintptr_t)address;
    UNUSED_PARAMS(__env, clazz)
    return (jshort)getShort(ptr);
}

/*
 * Class:     org_box2d_jni_system_Memory
 * Method:    ngetInt
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_system_Memory_ngetInt
    (JNIEnv *__env, jclass clazz, jlong address)
{
    void *ptr = (void *)(uintptr_t)address;
    UNUSED_PARAMS(__env, clazz)
    return (jint)getInt(ptr);
}

/*
 * Class:     org_box2d_jni_system_Memory
 * Method:    ngetLong
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Memory_ngetLong
    (JNIEnv *__env, jclass clazz, jlong address)
{
    void *ptr = (void *)(uintptr_t)address;
    UNUSED_PARAMS(__env, clazz)
    return (jlong)getLong(ptr);
}

/*
 * Class:     org_box2d_jni_system_Memory
 * Method:    ngetFloat
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_system_Memory_ngetFloat
    (JNIEnv *__env, jclass clazz, jlong address)
{
    void *ptr = (void *)(uintptr_t)address;
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)getFloat(ptr);
}

/*
 * Class:     org_box2d_jni_system_Memory
 * Method:    ngetDouble
 * Signature: (J)D
 */
JNIEXPORT jdouble JNICALL Java_org_box2d_jni_system_Memory_ngetDouble
    (JNIEnv *__env, jclass clazz, jlong address)
{
    void *ptr = (void *)(uintptr_t)address;
    UNUSED_PARAMS(__env, clazz)
    return (jdouble)getDouble(ptr);
}

/*
 * Class:     org_box2d_jni_system_Memory
 * Method:    ngetAddress
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Memory_ngetAddress
    (JNIEnv *__env, jclass clazz, jlong address)
{
    void *ptr = (void *)(uintptr_t)address;
    UNUSED_PARAMS(__env, clazz)
    return (jlong)getAddress(ptr);
}

/*
 * Class:     org_box2d_jni_system_Memory
 * Method:    nputByte
 * Signature: (JB)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_Memory_nputByte
    (JNIEnv *__env, jclass clazz, jlong address, jbyte value)
{
    void *ptr = (void *)(uintptr_t)address;
    UNUSED_PARAMS(__env, clazz)
    putByte(ptr, (int8_t)value);
}

/*
 * Class:     org_box2d_jni_system_Memory
 * Method:    nputShort
 * Signature: (JS)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_Memory_nputShort
    (JNIEnv *__env, jclass clazz, jlong address, jshort value)
{
    void *ptr = (void *)(uintptr_t)address;
    UNUSED_PARAMS(__env, clazz)
    putShort(ptr, (int16_t)value);
}

/*
 * Class:     org_box2d_jni_system_Memory
 * Method:    nputInt
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_Memory_nputInt
    (JNIEnv *__env, jclass clazz, jlong address, jint value)
{
    void *ptr = (void *)(uintptr_t)address;
    UNUSED_PARAMS(__env, clazz)
    putInt(ptr, (int32_t)value);
}

/*
 * Class:     org_box2d_jni_system_Memory
 * Method:    nputLong
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_Memory_nputLong
    (JNIEnv *__env, jclass clazz, jlong address, jlong value)
{
    void *ptr = (void *)(uintptr_t)address;
    UNUSED_PARAMS(__env, clazz)
    putLong(ptr, (int64_t)value);
}

/*
 * Class:     org_box2d_jni_system_Memory
 * Method:    nputFloat
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_Memory_nputFloat
    (JNIEnv *__env, jclass clazz, jlong address, jfloat value)
{
    void *ptr = (void *)(uintptr_t)address;
    UNUSED_PARAMS(__env, clazz)
    putFloat(ptr, (float)value);
}

/*
 * Class:     org_box2d_jni_system_Memory
 * Method:    nputDouble
 * Signature: (JD)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_Memory_nputDouble
    (JNIEnv *__env, jclass clazz, jlong address, jdouble value)
{
    void *ptr = (void *)(uintptr_t)address;
    UNUSED_PARAMS(__env, clazz)
    putDouble(ptr, (double)value);
}

/*
 * Class:     org_box2d_jni_system_Memory
 * Method:    nputAddress
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_Memory_nputAddress
    (JNIEnv *__env, jclass clazz, jlong address, jlong value)
{
    void *ptr = (void *)(uintptr_t)address;
    UNUSED_PARAMS(__env, clazz)
    putAddress(ptr, (uintptr_t)value);
}

/*
 * Class:     org_box2d_jni_system_Memory
 * Method:    ngetNativeAddress
 * Signature: (Ljava/nio/Buffer;)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Memory_ngetNativeAddress
    (JNIEnv *__env, jclass clazz, jobject jptr)
{
    void* ptr = (*__env)->GetDirectBufferAddress(__env, jptr);
    return (jlong)(uintptr_t)ptr;
}
