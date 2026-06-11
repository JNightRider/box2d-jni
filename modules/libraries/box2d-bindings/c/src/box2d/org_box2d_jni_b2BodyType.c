// Copyright Night Rider. All rights reserved.
// https://opensource.org/license/bsd-3-clause

/*
 * File:   org_box2d_jni_b2BodyType.c
 * Author: wil
 */

#include <stdlib.h>

#include "common_tools.h"

#include "box2d/types.h"
#include "box2d/jni/org_box2d_jni_b2BodyType.h"

/*
 * Class:     org_box2d_jni_b2BodyType
 * Method:    nb2_staticBody
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2BodyType_nb2_1staticBody
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_staticBody;
}

/*
 * Class:     org_box2d_jni_b2BodyType
 * Method:    nb2_kinematicBody
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2BodyType_nb2_1kinematicBody
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_kinematicBody;
}

/*
 * Class:     org_box2d_jni_b2BodyType
 * Method:    nb2_dynamicBody
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2BodyType_nb2_1dynamicBody
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_dynamicBody;
}

/*
 * Class:     org_box2d_jni_b2BodyType
 * Method:    nb2_bodyTypeCount
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2BodyType_nb2_1bodyTypeCount
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_bodyTypeCount;
}
