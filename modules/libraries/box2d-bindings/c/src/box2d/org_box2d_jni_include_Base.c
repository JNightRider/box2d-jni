// Copyright Night Rider. All rights reserved.
// https://opensource.org/license/bsd-3-clause

/*
 * File:   org_box2d_jni_include_Base.c
 * Author: wil
 */

#include <stdlib.h>

#include "common_tools.h"
#include "box2d/base.h"
#include "box2d/jni/org_box2d_jni_include_Base.h"

/*
 * Class:     org_box2d_jni_include_Base
 * Method:    nb2SetAllocator
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Base_nb2SetAllocator
    (JNIEnv *__env, jclass clazz, jlong func0, jlong func1)
{
    UNUSED_PARAMS(__env, clazz)
    b2AllocFcn* __function0 = (b2AllocFcn*)(uintptr_t)func0;
    b2FreeFcn* __function1 = (b2FreeFcn*)(uintptr_t)func1;
    b2SetAllocator( __function0, __function1 );
}

/*
 * Class:     org_box2d_jni_include_Base
 * Method:    nb2GetByteCount
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_include_Base_nb2GetByteCount
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)b2GetByteCount();
}

/*
 * Class:     org_box2d_jni_include_Base
 * Method:    nb2SetAssertFcn
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Base_nb2SetAssertFcn
    (JNIEnv *__env, jclass clazz, jlong func0)
{
    UNUSED_PARAMS(__env, clazz)
    b2AssertFcn* __function = (b2AssertFcn*)(uintptr_t)func0;
    b2SetAssertFcn( __function );
}

/*
 * Class:     org_box2d_jni_include_Base
 * Method:    nb2SetLogFcn
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Base_nb2SetLogFcn
    (JNIEnv *__env, jclass clazz, jlong func0)
{
    UNUSED_PARAMS(__env, clazz)
    b2LogFcn* __function = (b2LogFcn*)(uintptr_t)func0;
    b2SetLogFcn( __function );
}

/*
 * Class:     org_box2d_jni_include_Base
 * Method:    nb2GetVersion
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Base_nb2GetVersion
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Version* ptr = (b2Version*)(uintptr_t)__result;
    *ptr = b2GetVersion();
}

/*
 * Class:     org_box2d_jni_include_Base
 * Method:    nb2GetTicks
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_include_Base_nb2GetTicks
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)(uint64_t)b2GetTicks();
}

/*
 * Class:     org_box2d_jni_include_Base
 * Method:    nb2GetMilliseconds
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Base_nb2GetMilliseconds
    (JNIEnv *__env, jclass clazz, jlong ticks)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2GetMilliseconds((uint64_t)ticks);
}

/*
 * Class:     org_box2d_jni_include_Base
 * Method:    nb2GetMillisecondsAndReset
 * Signature: (Ljava/nio/LongBuffer;)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Base_nb2GetMillisecondsAndReset
    (JNIEnv *__env, jclass clazz, jobject buffer)
{
    ADDRESS_UINT64_BUFFER(__env, buffer, ticks, capacity)
    UNUSED_PARAMS(capacity, clazz)
    return (jfloat)b2GetMillisecondsAndReset( ticks );
}

/*
 * Class:     org_box2d_jni_include_Base
 * Method:    nb2Yield
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Base_nb2Yield
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    b2Yield();
}

/*
 * Class:     org_box2d_jni_include_Base
 * Method:    nb2Hash
 * Signature: (ILjava/nio/ByteBuffer;I)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Base_nb2Hash
    (JNIEnv *__env, jclass clazz, jint hash, jobject buffer, jint count)
{
    ADDRESS_UINT8_BUFFER(__env, buffer, data, capacity)
    UNUSED_PARAMS(capacity, clazz)

    return (jint)b2Hash((uint32_t)hash, data, (int)count );
}
