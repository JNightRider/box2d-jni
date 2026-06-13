// Copyright Night Rider. All rights reserved.
// https://opensource.org/license/bsd-3-clause

/*
 * File:   org_box2d_jni_b2TOIState.c
 * Author: wil
 */

#include <stdlib.h>

#include "common_tools.h"

#include "box2d/collision.h"
#include "box2d/jni/org_box2d_jni_b2TOIState.h"

/*
 * Class:     org_box2d_jni_b2TOIState
 * Method:    nb2_toiStateUnknown
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2TOIState_nb2_1toiStateUnknown
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_toiStateUnknown;
}

/*
 * Class:     org_box2d_jni_b2TOIState
 * Method:    nb2_toiStateFailed
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2TOIState_nb2_1toiStateFailed
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_toiStateFailed;
}

/*
 * Class:     org_box2d_jni_b2TOIState
 * Method:    nb2_toiStateOverlapped
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2TOIState_nb2_1toiStateOverlapped
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_toiStateOverlapped;
}

/*
 * Class:     org_box2d_jni_b2TOIState
 * Method:    nb2_toiStateHit
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2TOIState_nb2_1toiStateHit
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_toiStateHit;
}

/*
 * Class:     org_box2d_jni_b2TOIState
 * Method:    nb2_toiStateSeparated
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2TOIState_nb2_1toiStateSeparated
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_toiStateSeparated;
}

