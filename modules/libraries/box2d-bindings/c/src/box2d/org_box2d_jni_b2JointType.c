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
