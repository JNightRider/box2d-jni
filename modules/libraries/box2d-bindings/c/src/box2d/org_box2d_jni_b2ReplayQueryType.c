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
 * File:   org_box2d_jni_b2ReplayQueryType.c
 * Author: wil
 */

#include <stdlib.h>

#include "common_tools.h"

#include "box2d/box2d.h"
#include "box2d/jni/org_box2d_jni_b2ReplayQueryType.h.h"

/*
 * Class:     org_box2d_jni_b2ReplayQueryType
 * Method:    nb2_replayQueryOverlapAABB
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2ReplayQueryType_nb2_1replayQueryOverlapAABB
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_replayQueryOverlapAABB;
}

/*
 * Class:     org_box2d_jni_b2ReplayQueryType
 * Method:    nb2_replayQueryOverlapShape
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2ReplayQueryType_nb2_1replayQueryOverlapShape
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_replayQueryOverlapShape;
}

/*
 * Class:     org_box2d_jni_b2ReplayQueryType
 * Method:    nb2_replayQueryCastRay
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2ReplayQueryType_nb2_1replayQueryCastRay
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_replayQueryCastRay;
}

/*
 * Class:     org_box2d_jni_b2ReplayQueryType
 * Method:    nb2_replayQueryCastShape
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2ReplayQueryType_nb2_1replayQueryCastShape
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_replayQueryCastShape;
}

/*
 * Class:     org_box2d_jni_b2ReplayQueryType
 * Method:    nb2_replayQueryCollideMover
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2ReplayQueryType_nb2_1replayQueryCollideMover
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_replayQueryCollideMover;
}

/*
 * Class:     org_box2d_jni_b2ReplayQueryType
 * Method:    nb2_replayQueryCastRayClosest
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2ReplayQueryType_nb2_1replayQueryCastRayClosest
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_replayQueryCastRayClosest;
}

/*
 * Class:     org_box2d_jni_b2ReplayQueryType
 * Method:    nb2_replayQueryCastMover
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2ReplayQueryType_nb2_1replayQueryCastMover
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_replayQueryCastMover;
}

/*
 * Class:     org_box2d_jni_b2ReplayQueryType
 * Method:    nb2_replayQueryShapeTestPoint
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2ReplayQueryType_nb2_1replayQueryShapeTestPoint
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_replayQueryShapeTestPoint;
}

/*
 * Class:     org_box2d_jni_b2ReplayQueryType
 * Method:    nb2_replayQueryShapeRayCast
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_b2ReplayQueryType_nb2_1replayQueryShapeRayCast
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2_replayQueryShapeRayCast;
}
