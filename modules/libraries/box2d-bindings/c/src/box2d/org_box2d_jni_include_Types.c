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
 * File:   org_box2d_jni_include_Types.c
 * Author: wil
 */

#include <stdlib.h>

#include "common_tools.h"

#include "box2d/types.h"
#include "box2d/jni/org_box2d_jni_include_Types.h"

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultWorldDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultWorldDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    b2WorldDef* ptr = (b2WorldDef*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DefaultWorldDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultBodyDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultBodyDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    b2BodyDef* ptr = (b2BodyDef*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DefaultBodyDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultFilter
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultFilter
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    b2Filter* ptr = (b2Filter*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DefaultFilter();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultQueryFilter
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultQueryFilter
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    b2QueryFilter* ptr = (b2QueryFilter*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DefaultQueryFilter();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultSurfaceMaterial
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultSurfaceMaterial
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    b2SurfaceMaterial* ptr = (b2SurfaceMaterial*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DefaultSurfaceMaterial();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultShapeDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultShapeDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    b2ShapeDef* ptr = (b2ShapeDef*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DefaultShapeDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultChainDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultChainDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    b2ChainDef* ptr = (b2ChainDef*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DefaultChainDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultDistanceJointDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultDistanceJointDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    b2DistanceJointDef* ptr = (b2DistanceJointDef*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DefaultDistanceJointDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultMotorJointDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultMotorJointDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    b2MotorJointDef* ptr = (b2MotorJointDef*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DefaultMotorJointDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultFilterJointDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultFilterJointDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    b2FilterJointDef* ptr = (b2FilterJointDef*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DefaultFilterJointDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultPrismaticJointDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultPrismaticJointDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    b2PrismaticJointDef* ptr = (b2PrismaticJointDef*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DefaultPrismaticJointDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultRevoluteJointDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultRevoluteJointDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    b2RevoluteJointDef* ptr = (b2RevoluteJointDef*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DefaultRevoluteJointDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultWeldJointDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultWeldJointDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    b2WeldJointDef* ptr = (b2WeldJointDef*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DefaultWeldJointDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultWheelJointDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultWheelJointDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    b2WheelJointDef* ptr = (b2WheelJointDef*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DefaultWheelJointDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultExplosionDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultExplosionDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    b2ExplosionDef* ptr = (b2ExplosionDef*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DefaultExplosionDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2GetGraphColor
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Types_nb2GetGraphColor
    (JNIEnv *__env, jclass clazz, jint index)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)(b2HexColor)b2GetGraphColor( (int)index );
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultDebugDraw
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultDebugDraw
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    b2DebugDraw* ptr = (b2DebugDraw*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DefaultDebugDraw();
}
