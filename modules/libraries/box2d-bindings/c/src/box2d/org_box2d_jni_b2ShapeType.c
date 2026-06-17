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

