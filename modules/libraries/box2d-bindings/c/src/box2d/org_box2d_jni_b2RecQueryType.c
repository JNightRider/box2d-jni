// Copyright Night Rider. All rights reserved.
// https://opensource.org/license/bsd-3-clause

/*
 * File:   org_box2d_jni_b2RecQueryType.c
 * Author: wil
 */

#include <stdlib.h>

#include "common_tools.h"

#include "box2d/box2d.h"
#include "box2d/jni/org_box2d_jni_b2RecQueryType.h"

/*
 * Class:     org_box2d_jni_b2RecQueryType
 * Method:    nb2_recQueryOverlapAABB
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2RecQueryType_nb2_1recQueryOverlapAABB
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_recQueryOverlapAABB;
}

/*
 * Class:     org_box2d_jni_b2RecQueryType
 * Method:    nb2_recQueryOverlapShape
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2RecQueryType_nb2_1recQueryOverlapShape
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_recQueryOverlapShape;
}

/*
 * Class:     org_box2d_jni_b2RecQueryType
 * Method:    nb2_recQueryCastRay
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2RecQueryType_nb2_1recQueryCastRay
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_recQueryCastRay;
}

/*
 * Class:     org_box2d_jni_b2RecQueryType
 * Method:    nb2_recQueryCastShape
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2RecQueryType_nb2_1recQueryCastShape
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_recQueryCastShape;
}

/*
 * Class:     org_box2d_jni_b2RecQueryType
 * Method:    nb2_recQueryCollideMover
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2RecQueryType_nb2_1recQueryCollideMover
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_recQueryCollideMover;
}

/*
 * Class:     org_box2d_jni_b2RecQueryType
 * Method:    nb2_recQueryCastRayClosest
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2RecQueryType_nb2_1recQueryCastRayClosest
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_recQueryCastRayClosest;
}

/*
 * Class:     org_box2d_jni_b2RecQueryType
 * Method:    nb2_recQueryCastMover
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2RecQueryType_nb2_1recQueryCastMover
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_recQueryCastMover;
}

/*
 * Class:     org_box2d_jni_b2RecQueryType
 * Method:    nb2_recQueryShapeTestPoint
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2RecQueryType_nb2_1recQueryShapeTestPoint
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_recQueryShapeTestPoint;
}

/*
 * Class:     org_box2d_jni_b2RecQueryType
 * Method:    nb2_recQueryShapeRayCast
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2RecQueryType_nb2_1recQueryShapeRayCast
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_recQueryShapeRayCast;
}
