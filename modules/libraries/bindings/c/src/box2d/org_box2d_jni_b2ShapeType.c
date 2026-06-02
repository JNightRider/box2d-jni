// Copyright Night Rider. All rights reserved.
// https://opensource.org/license/bsd-3-clause

/*
 * File:   org_box2d_jni_b2ShapeType.c
 * Author: wil
 */

#include <stdlib.h>

#include "common_tools.h"

#include "box2d/types.h"
#include "box2d/jni/org_box2d_jni_b2ShapeType.h"

/*
 * Class:     org_box2d_jni_b2ShapeType
 * Method:    nb2_circleShape
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2ShapeType_nb2_1circleShape
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_circleShape;
}

/*
 * Class:     org_box2d_jni_b2ShapeType
 * Method:    nb2_capsuleShape
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2ShapeType_nb2_1capsuleShape
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_capsuleShape;
}

/*
 * Class:     org_box2d_jni_b2ShapeType
 * Method:    nb2_segmentShape
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2ShapeType_nb2_1segmentShape
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_segmentShape;
}

/*
 * Class:     org_box2d_jni_b2ShapeType
 * Method:    nb2_polygonShape
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2ShapeType_nb2_1polygonShape
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_polygonShape;
}

/*
 * Class:     org_box2d_jni_b2ShapeType
 * Method:    nb2_chainSegmentShape
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2ShapeType_nb2_1chainSegmentShape
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_chainSegmentShape;
}

/*
 * Class:     org_box2d_jni_b2ShapeType
 * Method:    nb2_shapeTypeCount
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2ShapeType_nb2_1shapeTypeCount
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_shapeTypeCount;
}

