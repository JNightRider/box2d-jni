// Copyright Night Rider. All rights reserved.
// https://opensource.org/license/bsd-3-clause

/*
 * File:   org_box2d_jni_b2TreeNodeFlags.c
 * Author: wil
 */

#include <stdlib.h>

#include "common_tools.h"

#include "box2d/collision.h"
#include "box2d/jni/org_box2d_jni_b2TreeNodeFlags.h"

/*
 * Class:     org_box2d_jni_b2TreeNodeFlags
 * Method:    nb2_allocatedNode
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2TreeNodeFlags_nb2_1allocatedNode
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_allocatedNode;
}

/*
 * Class:     org_box2d_jni_b2TreeNodeFlags
 * Method:    nb2_enlargedNode
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2TreeNodeFlags_nb2_1enlargedNode
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_enlargedNode;
}

/*
 * Class:     org_box2d_jni_b2TreeNodeFlags
 * Method:    nb2_leafNode
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2TreeNodeFlags_nb2_1leafNode
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_leafNode;
}
