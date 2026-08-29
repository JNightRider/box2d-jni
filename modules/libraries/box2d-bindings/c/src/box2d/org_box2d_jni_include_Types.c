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
    UNUSED_PARAMS(__env, clazz)
    *(b2WorldDef*)__result = b2DefaultWorldDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultBodyDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultBodyDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2BodyDef*)__result = b2DefaultBodyDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultFilter
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultFilter
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Filter*)__result = b2DefaultFilter();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultQueryFilter
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultQueryFilter
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2QueryFilter*)__result = b2DefaultQueryFilter();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultSurfaceMaterial
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultSurfaceMaterial
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2SurfaceMaterial*)__result = b2DefaultSurfaceMaterial();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultShapeDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultShapeDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2ShapeDef*)__result = b2DefaultShapeDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultChainDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultChainDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2ChainDef*)__result = b2DefaultChainDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultDistanceJointDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultDistanceJointDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2DistanceJointDef*)__result = b2DefaultDistanceJointDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultMotorJointDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultMotorJointDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2MotorJointDef*)__result = b2DefaultMotorJointDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultFilterJointDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultFilterJointDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2FilterJointDef*)__result = b2DefaultFilterJointDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultMoverJointDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultMoverJointDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2MoverJointDef*)__result = b2DefaultMoverJointDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultPogoJointDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultPogoJointDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2PogoJointDef*)__result = b2DefaultPogoJointDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultPrismaticJointDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultPrismaticJointDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2PrismaticJointDef*)__result = b2DefaultPrismaticJointDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultRevoluteJointDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultRevoluteJointDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2RevoluteJointDef*)__result = b2DefaultRevoluteJointDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultWeldJointDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultWeldJointDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2WeldJointDef*)__result = b2DefaultWeldJointDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultWheelJointDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultWheelJointDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2WheelJointDef*)__result = b2DefaultWheelJointDef();
}

/*
 * Class:     org_box2d_jni_include_Types
 * Method:    nb2DefaultExplosionDef
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Types_nb2DefaultExplosionDef
    (JNIEnv *__env, jclass clazz, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2ExplosionDef*)__result = b2DefaultExplosionDef();
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
    UNUSED_PARAMS(__env, clazz)
    *(b2DebugDraw*)__result = b2DefaultDebugDraw();
}
