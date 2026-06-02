// Copyright Night Rider. All rights reserved.
// https://opensource.org/license/bsd-3-clause

/*
 * File:   org_box2d_jni_b2JointType.c
 * Author: wil
 */

#include <stdlib.h>

#include "common_tools.h"

#include "box2d/types.h"
#include "box2d/jni/org_box2d_jni_b2JointType.h"

/*
 * Class:     org_box2d_jni_b2JointType
 * Method:    nb2_distanceJoint
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2JointType_nb2_1distanceJoint
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_distanceJoint;
}

/*
 * Class:     org_box2d_jni_b2JointType
 * Method:    nb2_filterJoint
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2JointType_nb2_1filterJoint
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_filterJoint;
}

/*
 * Class:     org_box2d_jni_b2JointType
 * Method:    nb2_motorJoint
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2JointType_nb2_1motorJoint
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_motorJoint;
}

/*
 * Class:     org_box2d_jni_b2JointType
 * Method:    nb2_prismaticJoint
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2JointType_nb2_1prismaticJoint
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_prismaticJoint;
}

/*
 * Class:     org_box2d_jni_b2JointType
 * Method:    nb2_revoluteJoint
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2JointType_nb2_1revoluteJoint
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_revoluteJoint;
}

/*
 * Class:     org_box2d_jni_b2JointType
 * Method:    nb2_weldJoint
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2JointType_nb2_1weldJoint
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_weldJoint;
}

/*
 * Class:     org_box2d_jni_b2JointType
 * Method:    nb2_wheelJoint
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2JointType_nb2_1wheelJoint
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_wheelJoint;
}
