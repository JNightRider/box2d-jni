// Copyright Night Rider. All rights reserved.
// https://opensource.org/license/bsd-3-clause

/*
 * File:   org_box2d_jni_include_Id.c
 * Author: wil
 */

#include <stdlib.h>

#include "common_tools.h"

#include "box2d/id.h"
#include "box2d/jni/org_box2d_jni_include_Id.h"

/*
 * Class:     org_box2d_jni_include_Id
 * Method:    nb2StoreWorldId
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Id_nb2StoreWorldId
    (JNIEnv *__env, jclass clazz, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    b2WorldId* id = (b2WorldId*)(uintptr_t)address;
    return (jint)b2StoreWorldId( *id );
}

/*
 * Class:     org_box2d_jni_include_Id
 * Method:    nb2LoadWorldId
 * Signature: (IJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Id_nb2LoadWorldId
    (JNIEnv *__env, jclass clazz, jint x, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    b2WorldId* ptr = (b2WorldId*)(uintptr_t) address;
    *ptr = b2LoadWorldId( (uint32_t) x );
}

/*
 * Class:     org_box2d_jni_include_Id
 * Method:    nb2StoreBodyId
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_include_Id_nb2StoreBodyId
    (JNIEnv *__env, jclass clazz, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    b2BodyId* id = (b2BodyId*)(uintptr_t)address;
    return (jlong) b2StoreBodyId( *id );
}

/*
 * Class:     org_box2d_jni_include_Id
 * Method:    nb2LoadBodyId
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Id_nb2LoadBodyId
    (JNIEnv *__env, jclass clazz, jlong x, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    b2BodyId* ptr = (b2BodyId*)(uintptr_t) address;
    *ptr = b2LoadBodyId( (uint64_t) x );
}

/*
 * Class:     org_box2d_jni_include_Id
 * Method:    nb2StoreShapeId
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_include_Id_nb2StoreShapeId
    (JNIEnv *__env, jclass clazz, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    b2ShapeId* id = (b2ShapeId*)(uintptr_t)address;
    return (jlong)b2StoreShapeId( *id );
}

/*
 * Class:     org_box2d_jni_include_Id
 * Method:    nb2LoadShapeId
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Id_nb2LoadShapeId
    (JNIEnv *__env, jclass clazz, jlong x, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    b2ShapeId* ptr = (b2ShapeId*)(uintptr_t) address;
    *ptr = b2LoadShapeId( (uint64_t) x );
}

/*
 * Class:     org_box2d_jni_include_Id
 * Method:    nb2StoreChainId
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_include_Id_nb2StoreChainId
    (JNIEnv *__env, jclass clazz, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    b2ChainId* id = (b2ChainId*)(uintptr_t)address;
    return (jlong) b2StoreChainId( *id );
}

/*
 * Class:     org_box2d_jni_include_Id
 * Method:    nb2LoadChainId
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Id_nb2LoadChainId
    (JNIEnv *__env, jclass clazz, jlong x, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    b2ChainId* ptr = (b2ChainId*)(uintptr_t) address;
    *ptr = b2LoadChainId( (uint64_t) x );
}

/*
 * Class:     org_box2d_jni_include_Id
 * Method:    nb2StoreJointId
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_include_Id_nb2StoreJointId
    (JNIEnv *__env, jclass clazz, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    b2JointId* id = (b2JointId*)(uintptr_t)address;
    return (jlong)b2StoreJointId( *id );
}

/*
 * Class:     org_box2d_jni_include_Id
 * Method:    nb2LoadJointId
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Id_nb2LoadJointId
    (JNIEnv *__env, jclass clazz, jlong x, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    b2JointId* ptr = (b2JointId*)(uintptr_t) address;
    *ptr = b2LoadJointId( (uint64_t) x );
}

/*
 * Class:     org_box2d_jni_include_Id
 * Method:    nb2StoreContactId
 * Signature: (JLjava/nio/IntBuffer;)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Id_nb2StoreContactId
    (JNIEnv *__env, jclass clazz, jlong address, jobject buffer)
{
    b2ContactId* id = (b2ContactId*)(uintptr_t)address;
    ADDRESS_UINT32_BUFFER(__env, buffer, values, capacity)
    UNUSED_PARAMS(capacity, clazz)
    b2StoreContactId( *id, values );
}

/*
 * Class:     org_box2d_jni_include_Id
 * Method:    nb2LoadContactId
 * Signature: (Ljava/nio/IntBuffer;J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Id_nb2LoadContactId
    (JNIEnv *__env, jclass clazz, jobject buffer, jlong address)
{
    b2ContactId* ptr = (b2ContactId*)(uintptr_t) address;
    ADDRESS_UINT32_BUFFER(__env, buffer, values, capacity)
    UNUSED_PARAMS(capacity, clazz)
    *ptr = b2LoadContactId( values );
}
