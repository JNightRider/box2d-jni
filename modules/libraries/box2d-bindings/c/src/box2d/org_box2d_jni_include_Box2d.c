// Copyright Night Rider. All rights reserved.
// https://opensource.org/license/bsd-3-clause

/*
 * File:   org_box2d_jni_include_Box2d.c
 * Author: wil
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

#include "common_tools.h"

#include "box2d/box2d.h"
#include "box2d/base.h"
#include "box2d/collision.h"
#include "box2d/id.h"
#include "box2d/types.h"

#include "box2d/jni/org_box2d_jni_include_Box2d.h"

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2CreateWorld
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2CreateWorld
    (JNIEnv *__env, jclass clazz, jlong def, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2WorldId*)__result = b2CreateWorld((const b2WorldDef*)def);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DestroyWorld
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2DestroyWorld
    (JNIEnv *__env, jclass clazz, jlong worldId)
{
    UNUSED_PARAMS(__env, clazz)
    b2DestroyWorld(*(b2WorldId*)worldId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_IsValid
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1IsValid
    (JNIEnv *__env, jclass clazz, jlong id)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean) b2World_IsValid( *(b2WorldId*)id );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_Step
 * Signature: (JFI)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1Step
    (JNIEnv *__env, jclass clazz, jlong worldId, jfloat timeStep, jint subStepCount)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_Step( *(b2WorldId*)worldId, timeStep, subStepCount );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_Draw
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1Draw
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong draw)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_Draw( *(b2WorldId*)worldId, (b2DebugDraw*)draw );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_GetBounds
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1GetBounds
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2AABB*)__result = b2World_GetBounds( *(b2WorldId*) worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_GetBodyEvents
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1GetBodyEvents
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2BodyEvents*)__result = b2World_GetBodyEvents( *(b2WorldId*)worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_GetSensorEvents
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1GetSensorEvents
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2SensorEvents*)__result = b2World_GetSensorEvents(*(b2WorldId*)worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_GetContactEvents
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1GetContactEvents
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2ContactEvents*)__result = b2World_GetContactEvents( *(b2WorldId*)worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_GetJointEvents
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1GetJointEvents
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2JointEvents*)__result = b2World_GetJointEvents( *(b2WorldId*)worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_OverlapAABB
 * Signature: (JJJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1OverlapAABB
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong aabb, jlong filter, jlong fcn, jlong context, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2TreeStats*)__result = b2World_OverlapAABB(*(b2WorldId*)worldId, *(b2AABB*)aabb, *(b2QueryFilter*)filter, (b2OverlapResultFcn*)fcn, (void*)context );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_OverlapShape
 * Signature: (JJJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1OverlapShape
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong proxy, jlong filter, jlong fcn, jlong context, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2TreeStats*)__result = b2World_OverlapShape(*(b2WorldId*)worldId, (const b2ShapeProxy*)proxy, *(b2QueryFilter*)filter, (b2OverlapResultFcn*) fcn, (void*) context );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_CastRay
 * Signature: (JJJJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1CastRay
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong origin, jlong translation, jlong filter, jlong fcn, jlong context, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2TreeStats*)__result = b2World_CastRay(*(b2WorldId*)worldId, *(b2Vec2*)origin, *(b2Vec2*)translation, *(b2QueryFilter*)filter, (b2CastResultFcn*)fcn, (void*)context);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_CastRayClosest
 * Signature: (JJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1CastRayClosest
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong origin, jlong translation, jlong filter, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2RayResult*)__result = b2World_CastRayClosest(*(b2WorldId*)worldId, *(b2Vec2*)origin, *(b2Vec2*)translation, *(b2QueryFilter*)filter );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_CastShape
 * Signature: (JJJJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1CastShape
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong proxy, jlong translation, jlong filter, jlong fcn, jlong context, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2TreeStats*)__result = b2World_CastShape(*(b2WorldId*) worldId, (const b2ShapeProxy*)proxy, *(b2Vec2*)translation, *(b2QueryFilter*)filter, (b2CastResultFcn*)fcn, (void*) context );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_CastMover
 * Signature: (JJJJ)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1CastMover
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong mover, jlong translation, jlong filter)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2World_CastMover(*(b2WorldId*)worldId, (const b2Capsule*)mover, *(b2Vec2*) translation, *(b2QueryFilter*) filter );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_CollideMover
 * Signature: (JJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1CollideMover
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong mover, jlong filter, jlong fcn, jlong context)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_CollideMover(*(b2WorldId*) worldId, (const b2Capsule*)mover, *(b2QueryFilter*) filter, (b2PlaneResultFcn*)fcn, (void*)context );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_EnableSleeping
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1EnableSleeping
    (JNIEnv *__env, jclass clazz, jlong worldId, jboolean flag)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_EnableSleeping(*(b2WorldId*) worldId, (bool)flag );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_IsSleepingEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1IsSleepingEnabled
    (JNIEnv *__env, jclass clazz, jlong worldId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2World_IsSleepingEnabled(*(b2WorldId*)worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_EnableContinuous
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1EnableContinuous
    (JNIEnv *__env, jclass clazz, jlong worldId, jboolean flag)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_EnableContinuous( *(b2WorldId*)worldId, (bool)flag );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_IsContinuousEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1IsContinuousEnabled
    (JNIEnv *__env, jclass clazz, jlong worldId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2World_IsContinuousEnabled( *(b2WorldId*) worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_SetRestitutionThreshold
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1SetRestitutionThreshold
    (JNIEnv *__env, jclass clazz, jlong worldId, jfloat value)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_SetRestitutionThreshold( *(b2WorldId*)worldId, value );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_GetRestitutionThreshold
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1GetRestitutionThreshold
    (JNIEnv *__env, jclass clazz, jlong worldId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2World_GetRestitutionThreshold( *(b2WorldId*) worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_SetHitEventThreshold
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1SetHitEventThreshold
    (JNIEnv *__env, jclass clazz, jlong worldId, jfloat value)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_SetHitEventThreshold( *(b2WorldId*) worldId, value );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_GetHitEventThreshold
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1GetHitEventThreshold
    (JNIEnv *__env, jclass clazz, jlong worldId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2World_GetHitEventThreshold( *(b2WorldId*) worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_SetCustomFilterCallback
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1SetCustomFilterCallback
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong fcn, jlong context)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_SetCustomFilterCallback( *(b2WorldId*)worldId, (b2CustomFilterFcn*)fcn, (void*)context );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_SetPreSolveCallback
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1SetPreSolveCallback
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong fcn, jlong context)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_SetPreSolveCallback( *(b2WorldId*)worldId, (b2PreSolveFcn*)fcn, (void*)context );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_SetGravity
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1SetGravity
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong gravity)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_SetGravity( *(b2WorldId*)worldId, *(b2Vec2*)gravity );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_GetGravity
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1GetGravity
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Vec2*)__result = b2World_GetGravity( *(b2WorldId*)worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_Explode
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1Explode
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong explosionDef)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_Explode( *(b2WorldId*)worldId, (const b2ExplosionDef*)explosionDef );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_SetContactTuning
 * Signature: (JFFF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1SetContactTuning
    (JNIEnv *__env, jclass clazz, jlong worldId, jfloat hertz, jfloat dampingRatio, jfloat pushSpeed)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_SetContactTuning( *(b2WorldId*)worldId, hertz, dampingRatio, pushSpeed );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_SetContactRecycleDistance
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1SetContactRecycleDistance
    (JNIEnv *__env, jclass clazz, jlong worldId, jfloat recycleDistance)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_SetContactRecycleDistance( *(b2WorldId*)worldId, recycleDistance );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_GetContactRecycleDistance
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1GetContactRecycleDistance
    (JNIEnv *__env, jclass clazz, jlong worldId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2World_GetContactRecycleDistance( *(b2WorldId*)worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_SetMaximumLinearSpeed
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1SetMaximumLinearSpeed
    (JNIEnv *__env, jclass clazz, jlong worldId, jfloat maximumLinearSpeed)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_SetMaximumLinearSpeed( *(b2WorldId*)worldId, maximumLinearSpeed );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_GetMaximumLinearSpeed
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1GetMaximumLinearSpeed
    (JNIEnv *__env, jclass clazz, jlong worldId)
{
    UNUSED_PARAMS(__env, clazz)
    return b2World_GetMaximumLinearSpeed( *(b2WorldId*)worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_EnableWarmStarting
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1EnableWarmStarting
    (JNIEnv *__env, jclass clazz, jlong worldId, jboolean flag)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_EnableWarmStarting( *(b2WorldId*)worldId, (bool)flag );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_IsWarmStartingEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1IsWarmStartingEnabled
    (JNIEnv *__env, jclass clazz, jlong worldId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2World_IsWarmStartingEnabled( *(b2WorldId*)worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_GetAwakeBodyCount
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1GetAwakeBodyCount
    (JNIEnv *__env, jclass clazz, jlong worldId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2World_GetAwakeBodyCount( *(b2WorldId*)worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_GetProfile
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1GetProfile
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Profile*)__result = b2World_GetProfile( *(b2WorldId*)worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_GetCounters
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1GetCounters
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Counters*)__result = b2World_GetCounters( *(b2WorldId*)worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_GetMaxCapacity
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1GetMaxCapacity
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Capacity*)__result = b2World_GetMaxCapacity( *(b2WorldId*)worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_SetUserData
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1SetUserData
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong userData)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_SetUserData( *(b2WorldId*)worldId, (void*)userData );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_GetUserData
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1GetUserData
    (JNIEnv *__env, jclass clazz, jlong worldId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)(uintptr_t)b2World_GetUserData( *(b2WorldId*)worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_SetFrictionCallback
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1SetFrictionCallback
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong callback)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_SetFrictionCallback( *(b2WorldId*)worldId, (b2FrictionCallback*)callback );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_SetRestitutionCallback
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1SetRestitutionCallback
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong callback)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_SetRestitutionCallback( *(b2WorldId*)worldId, (b2RestitutionCallback*)callback );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_SetWorkerCount
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1SetWorkerCount
    (JNIEnv *__env, jclass clazz, jlong worldId, jint count)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_SetWorkerCount( *(b2WorldId*)worldId, count );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_GetWorkerCount
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1GetWorkerCount
    (JNIEnv *__env, jclass clazz, jlong worldId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2World_GetWorkerCount( *(b2WorldId*)worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_DumpMemoryStats
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1DumpMemoryStats
    (JNIEnv *__env, jclass clazz, jlong worldId)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_DumpMemoryStats( *(b2WorldId*)worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_RebuildStaticTree
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1RebuildStaticTree
    (JNIEnv *__env, jclass clazz, jlong worldId)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_RebuildStaticTree( *(b2WorldId*)worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_EnableSpeculative
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1EnableSpeculative
    (JNIEnv *__env, jclass clazz, jlong worldId, jboolean flag)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_EnableSpeculative( *(b2WorldId*)worldId, (bool)flag );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2CreateRecording
 * Signature: (I)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_include_Box2d_nb2CreateRecording
    (JNIEnv *__env, jclass clazz, jint byteCapacity)
{
    UNUSED_PARAMS(__env, clazz)
    b2Recording* ptr = b2CreateRecording( byteCapacity );
    return (jlong)(uintptr_t)ptr;
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DestroyRecording
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2DestroyRecording
    (JNIEnv *__env, jclass clazz, jlong recording)
{
    UNUSED_PARAMS(__env, clazz)
    b2DestroyRecording( (b2Recording*)recording );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Recording_GetData
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_include_Box2d_nb2Recording_1GetData
    (JNIEnv *__env, jclass clazz, jlong recording)
{
    UNUSED_PARAMS(__env, clazz)
    const uint8_t* ptr = b2Recording_GetData( (const b2Recording*)recording );
    return (jlong)(uintptr_t)ptr;
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Recording_GetSize
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2Recording_1GetSize
    (JNIEnv *__env, jclass clazz, jlong recording)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2Recording_GetSize( (const b2Recording*) recording );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_StartRecording
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1StartRecording
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong recording)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_StartRecording( *(b2WorldId*)worldId, (b2Recording*)recording );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_StopRecording
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1StopRecording
    (JNIEnv *__env, jclass clazz, jlong worldId)
{
    UNUSED_PARAMS(__env, clazz)
    b2World_StopRecording( *(b2WorldId*)worldId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2SaveRecordingToFile
 * Signature: (JJ)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2SaveRecordingToFile
    (JNIEnv *__env, jclass clazz, jlong recording, jlong path)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2SaveRecordingToFile( (const b2Recording*)recording, (const char*)path );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2LoadRecordingFromFile
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_include_Box2d_nb2LoadRecordingFromFile
    (JNIEnv *__env, jclass clazz, jlong path)
{
    UNUSED_PARAMS(__env, clazz)
    b2Recording* ptr = b2LoadRecordingFromFile( (const char*)path );
    return (jlong)(uintptr_t)ptr;
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_Snapshot
 * Signature: (JLjava/nio/ByteBuffer;I)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1Snapshot
    (JNIEnv *__env, jclass clazz, jlong worldId, jobject buffer, jint capacity)
{
    ADDRESS_UINT8_BUFFER(__env, buffer, image, __len)
    UNUSED_PARAMS(__len, clazz)
    return (jint)b2World_Snapshot( *(b2WorldId*) worldId, image, capacity );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2World_Restore
 * Signature: (JLjava/nio/ByteBuffer;I)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2World_1Restore
    (JNIEnv *__env, jclass clazz, jlong worldId, jobject buffer, jint size)
{
    ADDRESS_UINT8_BUFFER(__env, buffer, image, __len)
    UNUSED_PARAMS(__len, clazz)
    return (jboolean)b2World_Restore( *(b2WorldId*) worldId, image, size );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2CreateWorldFromSnapshot
 * Signature: (Ljava/nio/ByteBuffer;IIJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2CreateWorldFromSnapshot
    (JNIEnv *__env, jclass clazz, jobject buffer, jint size, jint workerCount, jlong __result)
{
    ADDRESS_UINT8_BUFFER(__env, buffer, image, __len)
    UNUSED_PARAMS(__len, clazz)
    *(b2WorldId*)__result = b2CreateWorldFromSnapshot( image, size, workerCount );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2CreateBody
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2CreateBody
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong def, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2BodyId*)__result = b2CreateBody( *(b2WorldId*)worldId, (const b2BodyDef*)def );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DestroyBody
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2DestroyBody
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    b2DestroyBody( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_IsValid
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1IsValid
    (JNIEnv *__env, jclass clazz, jlong id)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2Body_IsValid( *(b2BodyId*)id );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetType
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetType
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2Body_GetType( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_SetType
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1SetType
    (JNIEnv *__env, jclass clazz, jlong bodyId, jint type)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_SetType( *(b2BodyId*) bodyId, (b2BodyType)type );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_SetName
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1SetName
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong name)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_SetName( *(b2BodyId*)bodyId, (const char*)name );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetName
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetName
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)b2Body_GetName( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_SetUserData
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1SetUserData
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong userData)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_SetUserData( *(b2BodyId*)bodyId, (void*)userData );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetUserData
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetUserData
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)(uintptr_t)b2Body_GetUserData( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetPosition
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetPosition
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Vec2*)__result = b2Body_GetPosition( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetRotation
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetRotation
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Rot*)__result = b2Body_GetRotation( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetTransform
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetTransform
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Transform*)__result = b2Body_GetTransform( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_SetTransform
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1SetTransform
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong position, jlong rotation)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_SetTransform( *(b2BodyId*)bodyId, *(b2Vec2*)position, *(b2Rot*)rotation );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetLocalPoint
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetLocalPoint
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong worldPoint, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Vec2*)__result = b2Body_GetLocalPoint( *(b2BodyId*)bodyId, *(b2Vec2*)worldPoint );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetWorldPoint
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetWorldPoint
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong localPoint, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Vec2*)__result = b2Body_GetWorldPoint( *(b2BodyId*)bodyId, *(b2Vec2*)localPoint );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetLocalVector
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetLocalVector
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong worldVector, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Vec2*)__result = b2Body_GetLocalVector( *(b2BodyId*)bodyId, *(b2Vec2*)worldVector );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetWorldVector
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetWorldVector
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong localVector, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Vec2*)__result = b2Body_GetWorldVector( *(b2BodyId*)bodyId, *(b2Vec2*)localVector );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetLinearVelocity
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetLinearVelocity
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Vec2*)__result = b2Body_GetLinearVelocity( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetAngularVelocity
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetAngularVelocity
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2Body_GetAngularVelocity( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_SetLinearVelocity
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1SetLinearVelocity
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong linearVelocity)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_SetLinearVelocity( *(b2BodyId*)bodyId, *(b2Vec2*)linearVelocity );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_SetAngularVelocity
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1SetAngularVelocity
    (JNIEnv *__env, jclass clazz, jlong bodyId, jfloat angularVelocity)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_SetAngularVelocity( *(b2BodyId*)bodyId, angularVelocity );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_SetTargetTransform
 * Signature: (JJFZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1SetTargetTransform
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong target, jfloat timeStep, jboolean wake)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_SetTargetTransform( *(b2BodyId*) bodyId, *(b2Transform*) target, timeStep, (bool)wake );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetLocalPointVelocity
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetLocalPointVelocity
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong localPoint, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Vec2*)__result = b2Body_GetLocalPointVelocity( *(b2BodyId*)bodyId, *(b2Vec2*)localPoint );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetWorldPointVelocity
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetWorldPointVelocity
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong worldPoint, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Vec2*)__result = b2Body_GetWorldPointVelocity( *(b2BodyId*)bodyId, *(b2Vec2*)worldPoint );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_ApplyForce
 * Signature: (JJJZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1ApplyForce
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong force, jlong point, jboolean wake)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_ApplyForce( *(b2BodyId*)bodyId, *(b2Vec2*)force, *(b2Vec2*)point, (bool)wake );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_ApplyForceToCenter
 * Signature: (JJZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1ApplyForceToCenter
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong force, jboolean wake)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_ApplyForceToCenter( *(b2BodyId*)bodyId, *(b2Vec2*)force, (bool)wake );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_ApplyTorque
 * Signature: (JFZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1ApplyTorque
    (JNIEnv *__env, jclass clazz, jlong bodyId, jfloat torque, jboolean wake)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_ApplyTorque( *(b2BodyId*)bodyId, torque, (bool)wake );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_ClearForces
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1ClearForces
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_ClearForces( *(b2BodyId*) bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_ApplyLinearImpulse
 * Signature: (JJJZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1ApplyLinearImpulse
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong impulse, jlong point, jboolean wake)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_ApplyLinearImpulse( *(b2BodyId*)bodyId, *(b2Vec2*)impulse, *(b2Vec2*)point, (bool)wake );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_ApplyLinearImpulseToCenter
 * Signature: (JJZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1ApplyLinearImpulseToCenter
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong impulse, jboolean wake)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_ApplyLinearImpulseToCenter( *(b2BodyId*)bodyId, *(b2Vec2*)impulse, (bool)wake );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_ApplyAngularImpulse
 * Signature: (JFZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1ApplyAngularImpulse
    (JNIEnv *__env, jclass clazz, jlong bodyId, jfloat impulse, jboolean wake)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_ApplyAngularImpulse( *(b2BodyId*)bodyId, impulse, (bool)wake );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetMass
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetMass
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    return  (jfloat)b2Body_GetMass( *(b2BodyId*) bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetRotationalInertia
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetRotationalInertia
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2Body_GetRotationalInertia( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetLocalCenterOfMass
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetLocalCenterOfMass
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Vec2*)__result = b2Body_GetLocalCenterOfMass( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetWorldCenterOfMass
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetWorldCenterOfMass
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Vec2*)__result = b2Body_GetWorldCenterOfMass( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_SetMassData
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1SetMassData
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong massData)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_SetMassData( *(b2BodyId*)bodyId, *(b2MassData*)massData );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetMassData
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetMassData
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2MassData*)__result = b2Body_GetMassData( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_ApplyMassFromShapes
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1ApplyMassFromShapes
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_ApplyMassFromShapes( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_SetLinearDamping
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1SetLinearDamping
    (JNIEnv *__env, jclass clazz, jlong bodyId, jfloat linearDamping)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_SetLinearDamping( *(b2BodyId*)bodyId, linearDamping );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetLinearDamping
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetLinearDamping
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat) b2Body_GetLinearDamping( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_SetAngularDamping
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1SetAngularDamping
    (JNIEnv *__env, jclass clazz, jlong bodyId, jfloat angularDamping)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_SetAngularDamping( *(b2BodyId*)bodyId, angularDamping );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetAngularDamping
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetAngularDamping
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat) b2Body_GetAngularDamping( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_SetGravityScale
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1SetGravityScale
    (JNIEnv *__env, jclass clazz, jlong bodyId, jfloat gravityScale)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_SetGravityScale( *(b2BodyId*)bodyId, gravityScale );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetGravityScale
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetGravityScale
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat) b2Body_GetGravityScale( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_IsAwake
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1IsAwake
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2Body_IsAwake( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_SetAwake
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1SetAwake
    (JNIEnv *__env, jclass clazz, jlong bodyId, jboolean awake)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_SetAwake( *(b2BodyId*)bodyId, (bool)awake );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_WakeTouching
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1WakeTouching
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_WakeTouching( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_EnableSleep
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1EnableSleep
    (JNIEnv *__env, jclass clazz, jlong bodyId, jboolean enableSleep)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_EnableSleep( *(b2BodyId*)bodyId, (bool)enableSleep );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_IsSleepEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1IsSleepEnabled
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2Body_IsSleepEnabled( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_SetSleepThreshold
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1SetSleepThreshold
    (JNIEnv *__env, jclass clazz, jlong bodyId, jfloat sleepThreshold)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_SetSleepThreshold( *(b2BodyId*)bodyId, sleepThreshold );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetSleepThreshold
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetSleepThreshold
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat) b2Body_GetSleepThreshold( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_IsEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1IsEnabled
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean) b2Body_IsEnabled( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_Disable
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1Disable
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_Disable( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_Enable
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1Enable
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_Enable( *(b2BodyId*) bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_SetMotionLocks
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1SetMotionLocks
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong locks)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_SetMotionLocks( *(b2BodyId*)bodyId, *(b2MotionLocks*)locks );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetMotionLocks
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetMotionLocks
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2MotionLocks*)__result = b2Body_GetMotionLocks( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_SetBullet
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1SetBullet
    (JNIEnv *__env, jclass clazz, jlong bodyId, jboolean flag)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_SetBullet( *(b2BodyId*)bodyId, (bool)flag );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_IsBullet
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1IsBullet
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2Body_IsBullet( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_EnableContactRecycling
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1EnableContactRecycling
    (JNIEnv *__env, jclass clazz, jlong bodyId, jboolean flag)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_EnableContactRecycling( *(b2BodyId*)bodyId, (bool)flag );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_IsContactRecyclingEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1IsContactRecyclingEnabled
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2Body_IsContactRecyclingEnabled( *(b2BodyId*) bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_EnableContactEvents
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1EnableContactEvents
    (JNIEnv *__env, jclass clazz, jlong bodyId, jboolean flag)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_EnableContactEvents( *(b2BodyId*) bodyId, (bool)flag );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_EnableHitEvents
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1EnableHitEvents
    (JNIEnv *__env, jclass clazz, jlong bodyId, jboolean flag)
{
    UNUSED_PARAMS(__env, clazz)
    b2Body_EnableHitEvents( *(b2BodyId*)bodyId, (bool)flag );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetWorld
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetWorld
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2WorldId*)__result = b2Body_GetWorld( *(b2BodyId*) bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetShapeCount
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetShapeCount
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint) b2Body_GetShapeCount( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetShapes
 * Signature: (JJI)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetShapes
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong shapeArray, jint capacity)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint) b2Body_GetShapes( *(b2BodyId*) bodyId, (b2ShapeId*) shapeArray, capacity );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetJointCount
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetJointCount
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2Body_GetJointCount( *(b2BodyId*) bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetJoints
 * Signature: (JJI)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetJoints
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong jointArray, jint capacity)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint) b2Body_GetJoints( *(b2BodyId*)bodyId, (b2JointId*)jointArray, capacity );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetContactCapacity
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetContactCapacity
    (JNIEnv *__env, jclass clazz, jlong bodyId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint) b2Body_GetContactCapacity( *(b2BodyId*) bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_GetContactData
 * Signature: (JJI)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1GetContactData
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong contactData, jint capacity)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2Body_GetContactData( *(b2BodyId*)bodyId, (b2ContactData*)contactData, capacity );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Body_ComputeAABB
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Body_1ComputeAABB
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2AABB*)__result = b2Body_ComputeAABB( *(b2BodyId*)bodyId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2CreateCircleShape
 * Signature: (JJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2CreateCircleShape
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong def, jlong circle, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2ShapeId*)__result = b2CreateCircleShape( *(b2BodyId*)bodyId, (const b2ShapeDef*)def, (const b2Circle*)circle );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2CreateSegmentShape
 * Signature: (JJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2CreateSegmentShape
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong def, jlong segment, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2ShapeId*)__result = b2CreateSegmentShape( *(b2BodyId*)bodyId, (const b2ShapeDef*)def, (const b2Segment*)segment );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2CreateChainSegmentShape
 * Signature: (JJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2CreateChainSegmentShape
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong def, jlong chainSegment, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2ShapeId*)__result = b2CreateChainSegmentShape( *(b2BodyId*)bodyId, (const b2ShapeDef*)def, (const b2ChainSegment*)chainSegment );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2CreateCapsuleShape
 * Signature: (JJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2CreateCapsuleShape
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong def, jlong capsule, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2ShapeId*)__result = b2CreateCapsuleShape( *(b2BodyId*)bodyId, (const b2ShapeDef*)def, (const b2Capsule*)capsule );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2CreatePolygonShape
 * Signature: (JJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2CreatePolygonShape
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong def, jlong polygon, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2ShapeId*)__result = b2CreatePolygonShape( *(b2BodyId*)bodyId, (const b2ShapeDef*)def, (const b2Polygon*)polygon );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DestroyShape
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2DestroyShape
    (JNIEnv *__env, jclass clazz, jlong shapeId, jboolean updateBodyMass)
{
    UNUSED_PARAMS(__env, clazz)
    b2DestroyShape( *(b2ShapeId*)shapeId, (bool)updateBodyMass );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_IsValid
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1IsValid
    (JNIEnv *__env, jclass clazz, jlong id)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2Shape_IsValid( *(b2ShapeId*)id );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetType
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetType
    (JNIEnv *__env, jclass clazz, jlong shapeId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2Shape_GetType( *(b2ShapeId*)shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetBody
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetBody
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2BodyId*)__result = b2Shape_GetBody( *(b2ShapeId*)shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetWorld
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetWorld
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2WorldId*)__result = b2Shape_GetWorld( *(b2ShapeId*)shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_IsSensor
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1IsSensor
    (JNIEnv *__env, jclass clazz, jlong shapeId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2Shape_IsSensor( *(b2ShapeId*)shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_SetUserData
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1SetUserData
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong userData)
{
    UNUSED_PARAMS(__env, clazz)
    b2Shape_SetUserData( *(b2ShapeId*)shapeId, (void*)userData );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetUserData
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetUserData
    (JNIEnv *__env, jclass clazz, jlong shapeId)
{
    UNUSED_PARAMS(__env, clazz)
    return  (jlong)(uintptr_t) b2Shape_GetUserData( *(b2ShapeId*)shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_SetDensity
 * Signature: (JFZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1SetDensity
    (JNIEnv *__env, jclass clazz, jlong shapeId, jfloat density, jboolean updateBodyMass)
{
    UNUSED_PARAMS(__env, clazz)
    b2Shape_SetDensity( *(b2ShapeId*)shapeId, density, (bool)updateBodyMass );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetDensity
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetDensity
    (JNIEnv *__env, jclass clazz, jlong shapeId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat) b2Shape_GetDensity( *(b2ShapeId*)shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_SetFriction
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1SetFriction
    (JNIEnv *__env, jclass clazz, jlong shapeId, jfloat friction)
{
    UNUSED_PARAMS(__env, clazz)
    b2Shape_SetFriction( *(b2ShapeId*)shapeId, friction );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetFriction
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetFriction
    (JNIEnv *__env, jclass clazz, jlong shapeId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat) b2Shape_GetFriction( *(b2ShapeId*)shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_SetRestitution
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1SetRestitution
    (JNIEnv *__env, jclass clazz, jlong shapeId, jfloat restitution)
{
    UNUSED_PARAMS(__env, clazz)
    b2Shape_SetRestitution( *(b2ShapeId*)shapeId, restitution );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetRestitution
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetRestitution
    (JNIEnv *__env, jclass clazz, jlong shapeId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat) b2Shape_GetRestitution( *(b2ShapeId*)shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_SetUserMaterial
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1SetUserMaterial
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong material)
{
    UNUSED_PARAMS(__env, clazz)
    b2Shape_SetUserMaterial( *(b2ShapeId*)shapeId, (uint64_t)material );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetUserMaterial
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetUserMaterial
    (JNIEnv *__env, jclass clazz, jlong shapeId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)(uint64_t) b2Shape_GetUserMaterial( *(b2ShapeId*) shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_SetSurfaceMaterial
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1SetSurfaceMaterial
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong surfaceMaterial)
{
    UNUSED_PARAMS(__env, clazz)
    b2Shape_SetSurfaceMaterial( *(b2ShapeId*)shapeId, (const b2SurfaceMaterial*)surfaceMaterial );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetSurfaceMaterial
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetSurfaceMaterial
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2SurfaceMaterial*)__result = b2Shape_GetSurfaceMaterial( *(b2ShapeId*)shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetFilter
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetFilter
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Filter*)__result = b2Shape_GetFilter( *(b2ShapeId*)shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_SetFilter
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1SetFilter
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong filter)
{
    UNUSED_PARAMS(__env, clazz)
    b2Shape_SetFilter( *(b2ShapeId*)shapeId, *(b2Filter*)filter );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_EnableSensorEvents
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1EnableSensorEvents
    (JNIEnv *__env, jclass clazz, jlong shapeId, jboolean flag)
{
    UNUSED_PARAMS(__env, clazz)
    b2Shape_EnableSensorEvents( *(b2ShapeId*)shapeId, (bool)flag );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_AreSensorEventsEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1AreSensorEventsEnabled
    (JNIEnv *__env, jclass clazz, jlong shapeId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2Shape_AreSensorEventsEnabled( *(b2ShapeId*) shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_EnableContactEvents
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1EnableContactEvents
    (JNIEnv *__env, jclass clazz, jlong shapeId, jboolean flag)
{
    UNUSED_PARAMS(__env, clazz)
    b2Shape_EnableContactEvents( *(b2ShapeId*)shapeId, (bool)flag );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_AreContactEventsEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1AreContactEventsEnabled
    (JNIEnv *__env, jclass clazz, jlong shapeId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2Shape_AreContactEventsEnabled( *(b2ShapeId*)shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_EnablePreSolveEvents
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1EnablePreSolveEvents
    (JNIEnv *__env, jclass clazz, jlong shapeId, jboolean flag)
{
    UNUSED_PARAMS(__env, clazz)
    b2Shape_EnablePreSolveEvents( *(b2ShapeId*)shapeId, (bool)flag );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_ArePreSolveEventsEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1ArePreSolveEventsEnabled
    (JNIEnv *__env, jclass clazz, jlong shapeId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2Shape_ArePreSolveEventsEnabled( *(b2ShapeId*)shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_EnableHitEvents
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1EnableHitEvents
    (JNIEnv *__env, jclass clazz, jlong shapeId, jboolean flag)
{
    UNUSED_PARAMS(__env, clazz)
    b2Shape_EnableHitEvents( *(b2ShapeId*) shapeId, (bool)flag );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_AreHitEventsEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1AreHitEventsEnabled
    (JNIEnv *__env, jclass clazz, jlong shapeId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2Shape_AreHitEventsEnabled( *(b2ShapeId*) shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_TestPoint
 * Signature: (JJ)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1TestPoint
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong point)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2Shape_TestPoint( *(b2ShapeId*)shapeId, *(b2Vec2*)point );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_RayCast
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1RayCast
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong input, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2CastOutput*)__result = b2Shape_RayCast( *(b2ShapeId*) shapeId, (const b2RayCastInput*)input );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetCircle
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetCircle
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Circle*)__result = b2Shape_GetCircle( *(b2ShapeId*) shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetSegment
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetSegment
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Segment*)__result = b2Shape_GetSegment( *(b2ShapeId*)shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetChainSegment
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetChainSegment
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2ChainSegment*)__result = b2Shape_GetChainSegment( *(b2ShapeId*)shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetCapsule
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetCapsule
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Capsule*)__result = b2Shape_GetCapsule( *(b2ShapeId*)shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetPolygon
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetPolygon
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Polygon*)__result = b2Shape_GetPolygon( *(b2ShapeId*) shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_SetCircle
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1SetCircle
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong circle)
{
    UNUSED_PARAMS(__env, clazz)
    b2Shape_SetCircle( *(b2ShapeId*)shapeId, (const b2Circle*)circle );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_SetCapsule
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1SetCapsule
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong capsule)
{
    UNUSED_PARAMS(__env, clazz)
    b2Shape_SetCapsule( *(b2ShapeId*)shapeId, (const b2Capsule*) capsule );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_SetSegment
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1SetSegment
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong segment)
{
    UNUSED_PARAMS(__env, clazz)
    b2Shape_SetSegment( *(b2ShapeId*)shapeId, (const b2Segment*)segment );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_SetPolygon
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1SetPolygon
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong polygon)
{
    UNUSED_PARAMS(__env, clazz)
    b2Shape_SetPolygon( *(b2ShapeId*)shapeId, (const b2Polygon*)polygon );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_SetChainSegment
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1SetChainSegment
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong chainSegment)
{
    UNUSED_PARAMS(__env, clazz)
    b2Shape_SetChainSegment( *(b2ShapeId*)shapeId, (const b2ChainSegment*)chainSegment );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetParentChain
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetParentChain
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2ChainId*)__result = b2Shape_GetParentChain( *(b2ShapeId*)shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetContactCapacity
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetContactCapacity
    (JNIEnv *__env, jclass clazz, jlong shapeId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2Shape_GetContactCapacity( *(b2ShapeId*) shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetContactData
 * Signature: (JJI)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetContactData
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong contactData, jint capacity)
{
    UNUSED_PARAMS(__env, clazz)
    return ( jint)b2Shape_GetContactData( *(b2ShapeId*)shapeId, (b2ContactData*)contactData, capacity );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetSensorCapacity
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetSensorCapacity
    (JNIEnv *__env, jclass clazz, jlong shapeId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2Shape_GetSensorCapacity( *(b2ShapeId*) shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetSensorData
 * Signature: (JJI)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetSensorData
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong visitorIds, jint capacity)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint) b2Shape_GetSensorData( *(b2ShapeId*)shapeId, (b2ShapeId*)visitorIds, capacity );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetAABB
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetAABB
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2AABB*)__result = b2Shape_GetAABB( *(b2ShapeId*)shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_ComputeMassData
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1ComputeMassData
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2MassData*)__result = b2Shape_ComputeMassData( *(b2ShapeId*)shapeId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_GetClosestPoint
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1GetClosestPoint
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong target, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Vec2*)__result = b2Shape_GetClosestPoint( *(b2ShapeId*)shapeId, *(b2Vec2*)target );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Shape_ApplyWind
 * Signature: (JJFFZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Shape_1ApplyWind
    (JNIEnv *__env, jclass clazz, jlong shapeId, jlong wind, jfloat drag, jfloat lift, jboolean wake)
{
    UNUSED_PARAMS(__env, clazz)
    b2Shape_ApplyWind( *(b2ShapeId*) shapeId, *(b2Vec2*) wind, drag, lift, (bool)wake );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2CreateChain
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2CreateChain
    (JNIEnv *__env, jclass clazz, jlong bodyId, jlong def, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2ChainId*)__result = b2CreateChain( *(b2BodyId*)bodyId, (const b2ChainDef*)def );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DestroyChain
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2DestroyChain
    (JNIEnv *__env, jclass clazz, jlong chainId)
{
    UNUSED_PARAMS(__env, clazz)
    b2DestroyChain( *(b2ChainId*)chainId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Chain_GetWorld
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Chain_1GetWorld
    (JNIEnv *__env, jclass clazz, jlong chainId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2WorldId*)__result = b2Chain_GetWorld( *(b2ChainId*)chainId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Chain_GetSegmentCount
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2Chain_1GetSegmentCount
    (JNIEnv *__env, jclass clazz, jlong chainId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint) b2Chain_GetSegmentCount( *(b2ChainId*)chainId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Chain_GetSegments
 * Signature: (JJI)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2Chain_1GetSegments
    (JNIEnv *__env, jclass clazz, jlong chainId, jlong segmentArray, jint capacity)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint) b2Chain_GetSegments( *(b2ChainId*)chainId, (b2ShapeId*)segmentArray, capacity );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Chain_GetSurfaceMaterialCount
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2Chain_1GetSurfaceMaterialCount
    (JNIEnv *__env, jclass clazz, jlong chainId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint) b2Chain_GetSurfaceMaterialCount( *(b2ChainId*)chainId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Chain_SetSurfaceMaterial
 * Signature: (JJI)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Chain_1SetSurfaceMaterial
    (JNIEnv *__env, jclass clazz, jlong chainId, jlong material, jint materialIndex)
{
    UNUSED_PARAMS(__env, clazz)
    b2Chain_SetSurfaceMaterial( *(b2ChainId*)chainId, (const b2SurfaceMaterial*)material, materialIndex );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Chain_GetSurfaceMaterial
 * Signature: (JIJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Chain_1GetSurfaceMaterial
    (JNIEnv *__env, jclass clazz, jlong chainId, jint materialIndex, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2SurfaceMaterial*)__result = b2Chain_GetSurfaceMaterial( *(b2ChainId*)chainId, materialIndex );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Chain_IsValid
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2Chain_1IsValid
    (JNIEnv *__env, jclass clazz, jlong id)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean) b2Chain_IsValid( *(b2ChainId*)id );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DestroyJoint
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2DestroyJoint
    (JNIEnv *__env, jclass clazz, jlong jointId, jboolean wakeAttached)
{
    UNUSED_PARAMS(__env, clazz)
    b2DestroyJoint( *(b2JointId*)jointId, (bool)wakeAttached );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_IsValid
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1IsValid
    (JNIEnv *__env, jclass clazz, jlong id)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2Joint_IsValid( *(b2JointId*)id );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_GetType
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1GetType
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint) b2Joint_GetType( *(b2JointId*)jointId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_GetBodyA
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1GetBodyA
    (JNIEnv *__env, jclass clazz, jlong jointId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2BodyId*)__result = b2Joint_GetBodyA(*(b2JointId*)jointId );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_GetBodyB
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1GetBodyB
    (JNIEnv *__env, jclass clazz, jlong jointId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2BodyId*)__result = b2Joint_GetBodyB(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_GetWorld
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1GetWorld
    (JNIEnv *__env, jclass clazz, jlong jointId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2WorldId*)__result = b2Joint_GetWorld(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_SetLocalFrameA
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1SetLocalFrameA
    (JNIEnv *__env, jclass clazz, jlong jointId, jlong localFrame)
{
    UNUSED_PARAMS(__env, clazz)
    b2Joint_SetLocalFrameA(*(b2JointId*)jointId, *(b2Transform*)localFrame);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_GetLocalFrameA
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1GetLocalFrameA
    (JNIEnv *__env, jclass clazz, jlong jointId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Transform*)__result = b2Joint_GetLocalFrameA(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_SetLocalFrameB
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1SetLocalFrameB
    (JNIEnv *__env, jclass clazz, jlong jointId, jlong localFrame)
{
    UNUSED_PARAMS(__env, clazz)
    b2Joint_SetLocalFrameB(*(b2JointId*)jointId, *(b2Transform*)localFrame);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_GetLocalFrameB
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1GetLocalFrameB
    (JNIEnv *__env, jclass clazz, jlong jointId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Transform*)__result = b2Joint_GetLocalFrameB(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_SetCollideConnected
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1SetCollideConnected
    (JNIEnv *__env, jclass clazz, jlong jointId, jboolean shouldCollide)
{
    UNUSED_PARAMS(__env, clazz)
    b2Joint_SetCollideConnected(*(b2JointId*)jointId, (bool)shouldCollide);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_GetCollideConnected
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1GetCollideConnected
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean) b2Joint_GetCollideConnected(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_SetUserData
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1SetUserData
    (JNIEnv *__env, jclass clazz, jlong jointId, jlong userData)
{
    UNUSED_PARAMS(__env, clazz)
    b2Joint_SetUserData(*(b2JointId*)jointId, (void*)userData);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_GetUserData
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1GetUserData
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)(uintptr_t)b2Joint_GetUserData(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_WakeBodies
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1WakeBodies
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    b2Joint_WakeBodies(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_GetConstraintForce
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1GetConstraintForce
    (JNIEnv *__env, jclass clazz, jlong jointId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Vec2*)__result = b2Joint_GetConstraintForce(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_GetConstraintTorque
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1GetConstraintTorque
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2Joint_GetConstraintTorque(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_GetLinearSeparation
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1GetLinearSeparation
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2Joint_GetLinearSeparation(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_GetAngularSeparation
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1GetAngularSeparation
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat) b2Joint_GetAngularSeparation(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_SetConstraintTuning
 * Signature: (JFF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1SetConstraintTuning
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat hertz, jfloat dampingRatio)
{
    UNUSED_PARAMS(__env, clazz)
    b2Joint_SetConstraintTuning(*(b2JointId*)jointId, hertz, dampingRatio);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_GetConstraintTuning
 * Signature: (JLjava/nio/FloatBuffer;Ljava/nio/FloatBuffer;)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1GetConstraintTuning
    (JNIEnv *__env, jclass clazz, jlong jointId, jobject bufferHertz, jobject bufferDampingRatio)
{
    ADDRESS_FLOAT_BUFFER(__env, bufferHertz, hertz, __len0)
    ADDRESS_FLOAT_BUFFER(__env, bufferDampingRatio, dampingRatio, __len1)
    UNUSED_PARAM(clazz)
    UNUSED_PARAMS(__len0, __len1)    
    b2Joint_GetConstraintTuning(*(b2JointId*)jointId, hertz, dampingRatio);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_SetForceThreshold
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1SetForceThreshold
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat threshold)
{
    UNUSED_PARAMS(__env, clazz)
    b2Joint_SetForceThreshold(*(b2JointId*)jointId, threshold);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_GetForceThreshold
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1GetForceThreshold
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2Joint_GetForceThreshold(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_SetTorqueThreshold
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1SetTorqueThreshold
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat threshold)
{
    UNUSED_PARAMS(__env, clazz)
    b2Joint_SetTorqueThreshold(*(b2JointId*)jointId, threshold);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Joint_GetTorqueThreshold
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2Joint_1GetTorqueThreshold
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2Joint_GetTorqueThreshold(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2CreateDistanceJoint
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2CreateDistanceJoint
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong def, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2JointId*)__result = b2CreateDistanceJoint(*(b2WorldId*)worldId, (const b2DistanceJointDef*)def);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_SetLength
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1SetLength
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat length)
{
    UNUSED_PARAMS(__env, clazz)
    b2DistanceJoint_SetLength(*(b2JointId*)jointId, length);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_GetLength
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1GetLength
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2DistanceJoint_GetLength(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_EnableSpring
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1EnableSpring
    (JNIEnv *__env, jclass clazz, jlong jointId, jboolean enableSpring)
{
    UNUSED_PARAMS(__env, clazz)
    b2DistanceJoint_EnableSpring(*(b2JointId*)jointId, (bool)enableSpring);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_IsSpringEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1IsSpringEnabled
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2DistanceJoint_IsSpringEnabled(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_SetSpringForceRange
 * Signature: (JFF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1SetSpringForceRange
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat lowerForce, jfloat upperForce)
{
    UNUSED_PARAMS(__env, clazz)
    b2DistanceJoint_SetSpringForceRange(*(b2JointId*)jointId, lowerForce, upperForce);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_GetSpringForceRange
 * Signature: (JLjava/nio/FloatBuffer;Ljava/nio/FloatBuffer;)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1GetSpringForceRange
    (JNIEnv *__env, jclass clazz, jlong jointId, jobject bufferLowerForce, jobject bufferUpperForce)
{
    ADDRESS_FLOAT_BUFFER(__env, bufferLowerForce, lowerForce, __len0)
    ADDRESS_FLOAT_BUFFER(__env, bufferUpperForce, upperForce, __len1)
    UNUSED_PARAM(clazz)
    UNUSED_PARAMS(__len0, __len1) 
    b2DistanceJoint_GetSpringForceRange(*(b2JointId*)jointId, lowerForce, upperForce);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_SetSpringHertz
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1SetSpringHertz
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat hertz)
{
    UNUSED_PARAMS(__env, clazz)
    b2DistanceJoint_SetSpringHertz(*(b2JointId*)jointId, hertz);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_SetSpringDampingRatio
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1SetSpringDampingRatio
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat dampingRatio)
{
    UNUSED_PARAMS(__env, clazz)
    b2DistanceJoint_SetSpringDampingRatio(*(b2JointId*)jointId, dampingRatio);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_GetSpringHertz
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1GetSpringHertz
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2DistanceJoint_GetSpringHertz(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_GetSpringDampingRatio
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1GetSpringDampingRatio
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2DistanceJoint_GetSpringDampingRatio(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_EnableLimit
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1EnableLimit
    (JNIEnv *__env, jclass clazz, jlong jointId, jboolean enableLimit)
{
    UNUSED_PARAMS(__env, clazz)
    b2DistanceJoint_EnableLimit(*(b2JointId*)jointId, (bool)enableLimit);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_IsLimitEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1IsLimitEnabled
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2DistanceJoint_IsLimitEnabled(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_SetLengthRange
 * Signature: (JFF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1SetLengthRange
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat minLength, jfloat maxLength)
{
    UNUSED_PARAMS(__env, clazz)
    b2DistanceJoint_SetLengthRange(*(b2JointId*)jointId, minLength, maxLength);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_GetMinLength
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1GetMinLength
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2DistanceJoint_GetMinLength(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_GetMaxLength
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1GetMaxLength
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2DistanceJoint_GetMaxLength(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_GetCurrentLength
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1GetCurrentLength
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2DistanceJoint_GetCurrentLength(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_EnableMotor
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1EnableMotor
    (JNIEnv *__env, jclass clazz, jlong jointId, jboolean enableMotor)
{
    UNUSED_PARAMS(__env, clazz)
    b2DistanceJoint_EnableMotor(*(b2JointId*)jointId, (bool)enableMotor);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_IsMotorEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1IsMotorEnabled
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2DistanceJoint_IsMotorEnabled(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_SetMotorSpeed
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1SetMotorSpeed
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat motorSpeed)
{
    UNUSED_PARAMS(__env, clazz)
    b2DistanceJoint_SetMotorSpeed(*(b2JointId*)jointId, motorSpeed);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_GetMotorSpeed
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1GetMotorSpeed
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2DistanceJoint_GetMotorSpeed(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_SetMaxMotorForce
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1SetMaxMotorForce
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat force)
{
    UNUSED_PARAMS(__env, clazz)
    b2DistanceJoint_SetMaxMotorForce(*(b2JointId*)jointId, force);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_GetMaxMotorForce
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1GetMaxMotorForce
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2DistanceJoint_GetMaxMotorForce(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2DistanceJoint_GetMotorForce
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2DistanceJoint_1GetMotorForce
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2DistanceJoint_GetMotorForce(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2CreateMotorJoint
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2CreateMotorJoint
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong def, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2JointId*)__result = b2CreateMotorJoint(*(b2WorldId*)worldId, (const b2MotorJointDef*)def);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2MotorJoint_SetLinearVelocity
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2MotorJoint_1SetLinearVelocity
    (JNIEnv *__env, jclass clazz, jlong jointId, jlong velocity)
{
    UNUSED_PARAMS(__env, clazz)
    b2MotorJoint_SetLinearVelocity(*(b2JointId*)jointId, *(b2Vec2*)velocity);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2MotorJoint_GetLinearVelocity
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2MotorJoint_1GetLinearVelocity
    (JNIEnv *__env, jclass clazz, jlong jointId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Vec2*)__result = b2MotorJoint_GetLinearVelocity(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2MotorJoint_SetAngularVelocity
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2MotorJoint_1SetAngularVelocity
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat velocity)
{
    UNUSED_PARAMS(__env, clazz)
    b2MotorJoint_SetAngularVelocity(*(b2JointId*)jointId, velocity);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2MotorJoint_GetAngularVelocity
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2MotorJoint_1GetAngularVelocity
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2MotorJoint_GetAngularVelocity(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2MotorJoint_SetMaxVelocityForce
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2MotorJoint_1SetMaxVelocityForce
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat maxForce)
{
    UNUSED_PARAMS(__env, clazz)
    b2MotorJoint_SetMaxVelocityForce(*(b2JointId*)jointId, maxForce);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2MotorJoint_GetMaxVelocityForce
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2MotorJoint_1GetMaxVelocityForce
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2MotorJoint_GetMaxVelocityForce(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2MotorJoint_SetMaxVelocityTorque
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2MotorJoint_1SetMaxVelocityTorque
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat maxTorque)
{
    UNUSED_PARAMS(__env, clazz)
    b2MotorJoint_SetMaxVelocityTorque(*(b2JointId*)jointId, maxTorque);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2MotorJoint_GetMaxVelocityTorque
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2MotorJoint_1GetMaxVelocityTorque
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2MotorJoint_GetMaxVelocityTorque(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2MotorJoint_SetLinearHertz
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2MotorJoint_1SetLinearHertz
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat hertz)
{
    UNUSED_PARAMS(__env, clazz)
    b2MotorJoint_SetLinearHertz(*(b2JointId*)jointId, hertz);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2MotorJoint_GetLinearHertz
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2MotorJoint_1GetLinearHertz
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2MotorJoint_GetLinearHertz(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2MotorJoint_SetLinearDampingRatio
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2MotorJoint_1SetLinearDampingRatio
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat damping)
{
    UNUSED_PARAMS(__env, clazz)
    b2MotorJoint_SetLinearDampingRatio(*(b2JointId*)jointId, damping);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2MotorJoint_GetLinearDampingRatio
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2MotorJoint_1GetLinearDampingRatio
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2MotorJoint_GetLinearDampingRatio(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2MotorJoint_SetAngularHertz
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2MotorJoint_1SetAngularHertz
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat hertz)
{
    UNUSED_PARAMS(__env, clazz)
    b2MotorJoint_SetAngularHertz(*(b2JointId*)jointId, hertz);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2MotorJoint_GetAngularHertz
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2MotorJoint_1GetAngularHertz
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2MotorJoint_GetAngularHertz(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2MotorJoint_SetAngularDampingRatio
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2MotorJoint_1SetAngularDampingRatio
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat damping)
{
    UNUSED_PARAMS(__env, clazz)
    b2MotorJoint_SetAngularDampingRatio(*(b2JointId*)jointId, damping);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2MotorJoint_GetAngularDampingRatio
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2MotorJoint_1GetAngularDampingRatio
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2MotorJoint_GetAngularDampingRatio(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2MotorJoint_SetMaxSpringForce
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2MotorJoint_1SetMaxSpringForce
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat maxForce)
{
    UNUSED_PARAMS(__env, clazz)
    b2MotorJoint_SetMaxSpringForce(*(b2JointId*)jointId, maxForce);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2MotorJoint_GetMaxSpringForce
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2MotorJoint_1GetMaxSpringForce
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2MotorJoint_GetMaxSpringForce(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2MotorJoint_SetMaxSpringTorque
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2MotorJoint_1SetMaxSpringTorque
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat maxTorque)
{
    UNUSED_PARAMS(__env, clazz)
    b2MotorJoint_SetMaxSpringTorque(*(b2JointId*)jointId, maxTorque);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2MotorJoint_GetMaxSpringTorque
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2MotorJoint_1GetMaxSpringTorque
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2MotorJoint_GetMaxSpringTorque(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2CreateFilterJoint
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2CreateFilterJoint
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong def, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2JointId*)__result = b2CreateFilterJoint(*(b2WorldId*)worldId, (const b2FilterJointDef*)def);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2CreatePrismaticJoint
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2CreatePrismaticJoint
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong def, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2JointId*)__result = b2CreatePrismaticJoint(*(b2WorldId*)worldId, (const b2PrismaticJointDef*)def);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_EnableSpring
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1EnableSpring
    (JNIEnv *__env, jclass clazz, jlong jointId, jboolean enableSpring)
{
    UNUSED_PARAMS(__env, clazz)
    b2PrismaticJoint_EnableSpring(*(b2JointId*)jointId, (bool)enableSpring);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_IsSpringEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1IsSpringEnabled
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2PrismaticJoint_IsSpringEnabled(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_SetSpringHertz
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1SetSpringHertz
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat hertz)
{
    UNUSED_PARAMS(__env, clazz)
    b2PrismaticJoint_SetSpringHertz(*(b2JointId*)jointId, hertz);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_GetSpringHertz
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1GetSpringHertz
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2PrismaticJoint_GetSpringHertz(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_SetSpringDampingRatio
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1SetSpringDampingRatio
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat dampingRatio)
{
    UNUSED_PARAMS(__env, clazz)
    b2PrismaticJoint_SetSpringDampingRatio(*(b2JointId*)jointId, dampingRatio);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_GetSpringDampingRatio
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1GetSpringDampingRatio
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2PrismaticJoint_GetSpringDampingRatio(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_SetTargetTranslation
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1SetTargetTranslation
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat translation)
{
    UNUSED_PARAMS(__env, clazz)
    b2PrismaticJoint_SetTargetTranslation(*(b2JointId*)jointId, translation);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_GetTargetTranslation
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1GetTargetTranslation
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2PrismaticJoint_GetTargetTranslation(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_EnableLimit
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1EnableLimit
    (JNIEnv *__env, jclass clazz, jlong jointId, jboolean enableLimit)
{
    UNUSED_PARAMS(__env, clazz)
    b2PrismaticJoint_EnableLimit(*(b2JointId*)jointId, enableLimit);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_IsLimitEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1IsLimitEnabled
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2PrismaticJoint_IsLimitEnabled(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_GetLowerLimit
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1GetLowerLimit
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2PrismaticJoint_GetLowerLimit(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_GetUpperLimit
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1GetUpperLimit
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2PrismaticJoint_GetUpperLimit(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_SetLimits
 * Signature: (JFF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1SetLimits
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat lower, jfloat upper)
{
    UNUSED_PARAMS(__env, clazz)
    b2PrismaticJoint_SetLimits(*(b2JointId*)jointId, lower, upper);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_EnableMotor
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1EnableMotor
    (JNIEnv *__env, jclass clazz, jlong jointId, jboolean enableMotor)
{
    UNUSED_PARAMS(__env, clazz)
    b2PrismaticJoint_EnableMotor(*(b2JointId*)jointId, enableMotor);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_IsMotorEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1IsMotorEnabled
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2PrismaticJoint_IsMotorEnabled(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_SetMotorSpeed
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1SetMotorSpeed
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat motorSpeed)
{
    UNUSED_PARAMS(__env, clazz)
    b2PrismaticJoint_SetMotorSpeed(*(b2JointId*)jointId, motorSpeed);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_GetMotorSpeed
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1GetMotorSpeed
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2PrismaticJoint_GetMotorSpeed(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_SetMaxMotorForce
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1SetMaxMotorForce
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat force)
{
    UNUSED_PARAMS(__env, clazz)
    b2PrismaticJoint_SetMaxMotorForce(*(b2JointId*)jointId, force);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_GetMaxMotorForce
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1GetMaxMotorForce
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2PrismaticJoint_GetMaxMotorForce(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_GetMotorForce
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1GetMotorForce
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2PrismaticJoint_GetMotorForce(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_GetTranslation
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1GetTranslation
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2PrismaticJoint_GetTranslation(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2PrismaticJoint_GetSpeed
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2PrismaticJoint_1GetSpeed
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2PrismaticJoint_GetSpeed(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2CreateRevoluteJoint
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2CreateRevoluteJoint
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong def, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2JointId*)__result = b2CreateRevoluteJoint(*(b2WorldId*)worldId, (const b2RevoluteJointDef*)def);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_EnableSpring
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1EnableSpring
    (JNIEnv *__env, jclass clazz, jlong jointId, jboolean enableSpring)
{
    UNUSED_PARAMS(__env, clazz)
    b2RevoluteJoint_EnableSpring(*(b2JointId*)jointId, enableSpring);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_IsSpringEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1IsSpringEnabled
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2RevoluteJoint_IsSpringEnabled(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_SetSpringHertz
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1SetSpringHertz
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat hertz)
{
    UNUSED_PARAMS(__env, clazz)
    b2RevoluteJoint_SetSpringHertz(*(b2JointId*)jointId, hertz);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_GetSpringHertz
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1GetSpringHertz
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2RevoluteJoint_GetSpringHertz(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_SetSpringDampingRatio
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1SetSpringDampingRatio
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat dampingRatio)
{
    UNUSED_PARAMS(__env, clazz)
    b2RevoluteJoint_SetSpringDampingRatio(*(b2JointId*)jointId, dampingRatio);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_GetSpringDampingRatio
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1GetSpringDampingRatio
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2RevoluteJoint_GetSpringDampingRatio(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_SetTargetAngle
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1SetTargetAngle
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat angle)
{
    UNUSED_PARAMS(__env, clazz)
    b2RevoluteJoint_SetTargetAngle(*(b2JointId*)jointId, angle);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_GetTargetAngle
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1GetTargetAngle
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2RevoluteJoint_GetTargetAngle(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_GetAngle
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1GetAngle
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2RevoluteJoint_GetAngle(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_EnableLimit
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1EnableLimit
    (JNIEnv *__env, jclass clazz, jlong jointId, jboolean enableLimit)
{
    UNUSED_PARAMS(__env, clazz)
    b2RevoluteJoint_EnableLimit(*(b2JointId*)jointId, enableLimit);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_IsLimitEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1IsLimitEnabled
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2RevoluteJoint_IsLimitEnabled(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_GetLowerLimit
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1GetLowerLimit
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2RevoluteJoint_GetLowerLimit(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_GetUpperLimit
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1GetUpperLimit
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2RevoluteJoint_GetUpperLimit(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_SetLimits
 * Signature: (JFF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1SetLimits
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat lower, jfloat upper)
{
    UNUSED_PARAMS(__env, clazz)
    b2RevoluteJoint_SetLimits(*(b2JointId*)jointId, lower, upper);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_EnableMotor
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1EnableMotor
    (JNIEnv *__env, jclass clazz, jlong jointId, jboolean enableMotor)
{
    UNUSED_PARAMS(__env, clazz)
    b2RevoluteJoint_EnableMotor(*(b2JointId*)jointId, enableMotor);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_IsMotorEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1IsMotorEnabled
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2RevoluteJoint_IsMotorEnabled(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_SetMotorSpeed
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1SetMotorSpeed
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat motorSpeed)
{
    UNUSED_PARAMS(__env, clazz)
    b2RevoluteJoint_SetMotorSpeed(*(b2JointId*)jointId, motorSpeed);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_GetMotorSpeed
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1GetMotorSpeed
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2RevoluteJoint_GetMotorSpeed(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_GetMotorTorque
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1GetMotorTorque
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2RevoluteJoint_GetMotorTorque(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_SetMaxMotorTorque
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1SetMaxMotorTorque
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat torque)
{
    UNUSED_PARAMS(__env, clazz)
    b2RevoluteJoint_SetMaxMotorTorque(*(b2JointId*)jointId, torque);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RevoluteJoint_GetMaxMotorTorque
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2RevoluteJoint_1GetMaxMotorTorque
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2RevoluteJoint_GetMaxMotorTorque(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2CreateWeldJoint
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2CreateWeldJoint
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong def, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2JointId*)__result = b2CreateWeldJoint(*(b2WorldId*)worldId, (const b2WeldJointDef*)def);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WeldJoint_SetLinearHertz
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2WeldJoint_1SetLinearHertz
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat hertz)
{
    UNUSED_PARAMS(__env, clazz)
    b2WeldJoint_SetLinearHertz(*(b2JointId*)jointId, hertz);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WeldJoint_GetLinearHertz
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2WeldJoint_1GetLinearHertz
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2WeldJoint_GetLinearHertz(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WeldJoint_SetLinearDampingRatio
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2WeldJoint_1SetLinearDampingRatio
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat dampingRatio)
{
    UNUSED_PARAMS(__env, clazz)
    b2WeldJoint_SetLinearDampingRatio(*(b2JointId*)jointId, dampingRatio);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WeldJoint_GetLinearDampingRatio
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2WeldJoint_1GetLinearDampingRatio
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2WeldJoint_GetLinearDampingRatio(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WeldJoint_SetAngularHertz
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2WeldJoint_1SetAngularHertz
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat hertz)
{
    UNUSED_PARAMS(__env, clazz)
    b2WeldJoint_SetAngularHertz(*(b2JointId*)jointId, hertz);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WeldJoint_GetAngularHertz
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2WeldJoint_1GetAngularHertz
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2WeldJoint_GetAngularHertz(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WeldJoint_SetAngularDampingRatio
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2WeldJoint_1SetAngularDampingRatio
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat dampingRatio)
{
    UNUSED_PARAMS(__env, clazz)
    b2WeldJoint_SetAngularDampingRatio(*(b2JointId*)jointId, dampingRatio);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WeldJoint_GetAngularDampingRatio
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2WeldJoint_1GetAngularDampingRatio
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2WeldJoint_GetAngularDampingRatio(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2CreateWheelJoint
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2CreateWheelJoint
    (JNIEnv *__env, jclass clazz, jlong worldId, jlong def, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2JointId*)__result = b2CreateWheelJoint(*(b2WorldId*)worldId, (const b2WheelJointDef*)def);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WheelJoint_EnableSpring
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2WheelJoint_1EnableSpring
    (JNIEnv *__env, jclass clazz, jlong jointId, jboolean enableSpring)
{
    UNUSED_PARAMS(__env, clazz)
    b2WheelJoint_EnableSpring(*(b2JointId*)jointId, enableSpring);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WheelJoint_IsSpringEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2WheelJoint_1IsSpringEnabled
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2WheelJoint_IsSpringEnabled(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WheelJoint_SetSpringHertz
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2WheelJoint_1SetSpringHertz
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat hertz)
{
    UNUSED_PARAMS(__env, clazz)
    b2WheelJoint_SetSpringHertz(*(b2JointId*)jointId, hertz);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WheelJoint_GetSpringHertz
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2WheelJoint_1GetSpringHertz
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2WheelJoint_GetSpringHertz(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WheelJoint_SetSpringDampingRatio
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2WheelJoint_1SetSpringDampingRatio
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat dampingRatio)
{
    UNUSED_PARAMS(__env, clazz)
    b2WheelJoint_SetSpringDampingRatio(*(b2JointId*)jointId, dampingRatio);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WheelJoint_GetSpringDampingRatio
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2WheelJoint_1GetSpringDampingRatio
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2WheelJoint_GetSpringDampingRatio(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WheelJoint_EnableLimit
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2WheelJoint_1EnableLimit
    (JNIEnv *__env, jclass clazz, jlong jointId, jboolean enableLimit)
{
    UNUSED_PARAMS(__env, clazz)
    b2WheelJoint_EnableLimit(*(b2JointId*)jointId, enableLimit);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WheelJoint_IsLimitEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2WheelJoint_1IsLimitEnabled
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2WheelJoint_IsLimitEnabled(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WheelJoint_GetLowerLimit
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2WheelJoint_1GetLowerLimit
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2WheelJoint_GetLowerLimit(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WheelJoint_GetUpperLimit
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2WheelJoint_1GetUpperLimit
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2WheelJoint_GetUpperLimit(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WheelJoint_SetLimits
 * Signature: (JFF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2WheelJoint_1SetLimits
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat lower, jfloat upper)
{
    UNUSED_PARAMS(__env, clazz)
    b2WheelJoint_SetLimits(*(b2JointId*)jointId, lower, upper);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WheelJoint_EnableMotor
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2WheelJoint_1EnableMotor
    (JNIEnv *__env, jclass clazz, jlong jointId, jboolean enableMotor)
{
    UNUSED_PARAMS(__env, clazz)
    b2WheelJoint_EnableMotor(*(b2JointId*)jointId, enableMotor);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WheelJoint_IsMotorEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2WheelJoint_1IsMotorEnabled
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2WheelJoint_IsMotorEnabled(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WheelJoint_SetMotorSpeed
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2WheelJoint_1SetMotorSpeed
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat motorSpeed)
{
    UNUSED_PARAMS(__env, clazz)
    b2WheelJoint_SetMotorSpeed(*(b2JointId*)jointId, motorSpeed);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WheelJoint_GetMotorSpeed
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2WheelJoint_1GetMotorSpeed
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2WheelJoint_GetMotorSpeed(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WheelJoint_SetMaxMotorTorque
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2WheelJoint_1SetMaxMotorTorque
    (JNIEnv *__env, jclass clazz, jlong jointId, jfloat  torque)
{
    UNUSED_PARAMS(__env, clazz)
    b2WheelJoint_SetMaxMotorTorque(*(b2JointId*)jointId, torque);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WheelJoint_GetMaxMotorTorque
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2WheelJoint_1GetMaxMotorTorque
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2WheelJoint_GetMaxMotorTorque(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2WheelJoint_GetMotorTorque
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Box2d_nb2WheelJoint_1GetMotorTorque
    (JNIEnv *__env, jclass clazz, jlong jointId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2WheelJoint_GetMotorTorque(*(b2JointId*)jointId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Contact_IsValid
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2Contact_1IsValid
    (JNIEnv *__env, jclass clazz, jlong id)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2Contact_IsValid(*(b2ContactId*)id);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2Contact_GetData
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2Contact_1GetData
    (JNIEnv *__env, jclass clazz, jlong contactId, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2ContactData*)__result = b2Contact_GetData(*(b2ContactId*)contactId);
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2ValidateReplay
 * Signature: (JII)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2ValidateReplay
    (JNIEnv *__env, jclass clazz, jlong data, jint size, jint workerCount)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean) b2ValidateReplay( (const void*)data, size, workerCount );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_Create
 * Signature: (JII)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1Create
    (JNIEnv *__env, jclass clazz, jlong data, jint size, jint workerCount)
{
    UNUSED_PARAMS(__env, clazz)
    b2RecPlayer* ptr = b2RecPlayer_Create((const void*) data, size, workerCount);
    return (jlong)(uintptr_t)ptr;
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_StepFrame
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1StepFrame
    (JNIEnv *__env, jclass clazz, jlong player)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2RecPlayer_StepFrame( (b2RecPlayer*)player );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_GetWorldId
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1GetWorldId
    (JNIEnv *__env, jclass clazz, jlong player, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2WorldId*)__result = b2RecPlayer_GetWorldId( (const b2RecPlayer* )player );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_Restart
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1Restart
    (JNIEnv *__env, jclass clazz, jlong player)
{
    UNUSED_PARAMS(__env, clazz)
    b2RecPlayer_Restart( (b2RecPlayer*) player );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_SeekFrame
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1SeekFrame
    (JNIEnv *__env, jclass clazz, jlong player, jint targetFrame)
{
    UNUSED_PARAMS(__env, clazz)
    b2RecPlayer_SeekFrame( (b2RecPlayer*) player, targetFrame );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_GetFrame
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1GetFrame
    (JNIEnv *__env, jclass clazz, jlong player)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint) b2RecPlayer_GetFrame( (const b2RecPlayer*) player );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_GetInfo
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1GetInfo
    (JNIEnv *__env, jclass clazz, jlong player, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2RecPlayerInfo*)__result = b2RecPlayer_GetInfo( (const b2RecPlayer*) player );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_IsAtEnd
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1IsAtEnd
    (JNIEnv *__env, jclass clazz, jlong player)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2RecPlayer_IsAtEnd( (const b2RecPlayer*) player );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_HasDiverged
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1HasDiverged
    (JNIEnv *__env, jclass clazz, jlong player)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2RecPlayer_HasDiverged( (const b2RecPlayer*) player );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_GetDivergeFrame
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1GetDivergeFrame
    (JNIEnv *__env, jclass clazz, jlong player)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint) b2RecPlayer_GetDivergeFrame( (const b2RecPlayer*) player );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_SetKeyframePolicy
 * Signature: (JJI)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1SetKeyframePolicy
    (JNIEnv *__env, jclass clazz, jlong player, jlong budgetBytes, jint minIntervalFrames)
{
    UNUSED_PARAMS(__env, clazz)
    b2RecPlayer_SetKeyframePolicy( (b2RecPlayer*)player, (size_t)budgetBytes, minIntervalFrames );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_GetKeyframeBudget
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1GetKeyframeBudget
    (JNIEnv *__env, jclass clazz, jlong player)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)(size_t) b2RecPlayer_GetKeyframeBudget( (const b2RecPlayer*) player );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_GetKeyframeMinInterval
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1GetKeyframeMinInterval
    (JNIEnv *__env, jclass clazz, jlong player)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint) b2RecPlayer_GetKeyframeMinInterval( (const b2RecPlayer*) player );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_GetKeyframeInterval
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1GetKeyframeInterval
    (JNIEnv *__env, jclass clazz, jlong player)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint) b2RecPlayer_GetKeyframeInterval( (const b2RecPlayer* )player );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_GetKeyframeBytes
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1GetKeyframeBytes
    (JNIEnv *__env, jclass clazz, jlong player)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)(size_t) b2RecPlayer_GetKeyframeBytes( (const b2RecPlayer*) player );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_Destroy
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1Destroy
    (JNIEnv *__env, jclass clazz, jlong player)
{
    UNUSED_PARAMS(__env, clazz)
    b2RecPlayer_Destroy( (b2RecPlayer*) player );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_DrawFrameQueries
 * Signature: (JJI)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1DrawFrameQueries
    (JNIEnv *__env, jclass clazz, jlong player, jlong draw, jint queryIndex)
{
    UNUSED_PARAMS(__env, clazz)
    b2RecPlayer_DrawFrameQueries( (b2RecPlayer*)player, (b2DebugDraw*)draw, queryIndex );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_GetFrameQueryCount
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1GetFrameQueryCount
    (JNIEnv *__env, jclass clazz, jlong player)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint) b2RecPlayer_GetFrameQueryCount( (const b2RecPlayer*) player );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_GetFrameQuery
 * Signature: (JIJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1GetFrameQuery
    (JNIEnv *__env, jclass clazz, jlong player, jint index, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2RecQueryInfo*)__result = b2RecPlayer_GetFrameQuery( (const b2RecPlayer*) player, index );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_GetFrameQueryHit
 * Signature: (JIIJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1GetFrameQueryHit
    (JNIEnv *__env, jclass clazz, jlong player, jint queryIndex, jint hitIndex, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2RecQueryHit*)__result = b2RecPlayer_GetFrameQueryHit( (const b2RecPlayer* )player, queryIndex, hitIndex );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_GetBodyCount
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1GetBodyCount
    (JNIEnv *__env, jclass clazz, jlong player)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint) b2RecPlayer_GetBodyCount( (const b2RecPlayer*) player );
}

/*
 * Class:     org_box2d_jni_include_Box2d
 * Method:    nb2RecPlayer_GetBodyId
 * Signature: (JIJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Box2d_nb2RecPlayer_1GetBodyId
    (JNIEnv *__env, jclass clazz, jlong player, jint index, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2BodyId*)__result = b2RecPlayer_GetBodyId( (const b2RecPlayer*)player, index );
}
