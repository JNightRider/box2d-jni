// Copyright Night Rider. All rights reserved.
// https://opensource.org/license/bsd-3-clause

/*
 * File:   org_box2d_jni_include_Collision.c
 * Author: wil
 */

#include <stdlib.h>

#include "common_tools.h"

#include "box2d/collision.h"
#include "box2d/jni/org_box2d_jni_include_Collision.h"

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2IsValidRay
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Collision_nb2IsValidRay
    (JNIEnv *__env, jclass clazz, jlong address)
{
    const b2RayCastInput* input = (const b2RayCastInput*)(uintptr_t)address;
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2IsValidRay( input );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2MakePolygon
 * Signature: (JFJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2MakePolygon
    (JNIEnv *__env, jclass clazz, jlong hull, jfloat radius, jlong __result)
{
    b2Polygon* ptr = (b2Polygon*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2MakePolygon( (const b2Hull*)hull, radius );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2MakeOffsetPolygon
 * Signature: (JJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2MakeOffsetPolygon
    (JNIEnv *__env, jclass clazz, jlong hull, jlong positionAdd, jlong rotationAdd, jlong __result)
{
    b2Polygon* ptr   = (b2Polygon*)(uintptr_t)__result;
    b2Vec2* position = (b2Vec2*)(uintptr_t)positionAdd;
    b2Rot* rotation  = (b2Rot*)(uintptr_t)rotationAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2MakeOffsetPolygon( (const b2Hull*)hull, *position, *rotation );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2MakeOffsetRoundedPolygon
 * Signature: (JJJFJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2MakeOffsetRoundedPolygon
    (JNIEnv *__env, jclass clazz, jlong hull, jlong positionAdd, jlong rotationAdd, jfloat radius, jlong __result)
{
    b2Polygon* ptr   = (b2Polygon*)(uintptr_t)__result;
    b2Vec2* position = (b2Vec2*)(uintptr_t)positionAdd;
    b2Rot* rotation  = (b2Rot*)(uintptr_t)rotationAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2MakeOffsetRoundedPolygon( (const b2Hull*) hull, *position, *rotation, radius );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2MakeSquare
 * Signature: (FJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2MakeSquare
    (JNIEnv *__env, jclass clazz, jfloat halfWidth, jlong __result)
{
    b2Polygon* ptr = (b2Polygon*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2MakeSquare( halfWidth );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2MakeBox
 * Signature: (FFJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2MakeBox
    (JNIEnv *__env, jclass clazz, jfloat halfWidth, jfloat halfHeight, jlong __result)
{
    b2Polygon* ptr = (b2Polygon*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2MakeBox( halfWidth, halfHeight );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2MakeRoundedBox
 * Signature: (FFFJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2MakeRoundedBox
    (JNIEnv *__env, jclass clazz, jfloat halfWidth, jfloat halfHeight, jfloat radius, jlong __result)
{
    b2Polygon* ptr = (b2Polygon*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2MakeRoundedBox( halfWidth, halfHeight, radius );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2MakeOffsetBox
 * Signature: (FFJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2MakeOffsetBox
    (JNIEnv *__env, jclass clazz, jfloat halfWidth, jfloat halfHeight, jlong centerAdd, jlong rotationAdd, jlong __result)
{
    b2Polygon* ptr = (b2Polygon*)(uintptr_t)__result;
    b2Vec2* center = (b2Vec2*)(uintptr_t)centerAdd;
    b2Rot* rotation = (b2Rot*)(uintptr_t)rotationAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2MakeOffsetBox( halfWidth, halfHeight, *center, *rotation );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2MakeOffsetRoundedBox
 * Signature: (FFJJFJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2MakeOffsetRoundedBox
    (JNIEnv *__env, jclass clazz, jfloat halfWidth, jfloat halfHeight, jlong centerAdd, jlong rotationAdd, jfloat radius, jlong __result)
{
    b2Polygon* ptr = (b2Polygon*)(uintptr_t)__result;
    b2Vec2* center = (b2Vec2*)(uintptr_t)centerAdd;
    b2Rot* rotation = (b2Rot*)(uintptr_t)rotationAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2MakeOffsetRoundedBox( halfWidth, halfHeight, *center, *rotation, radius );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2TransformPolygon
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2TransformPolygon
    (JNIEnv *__env, jclass clazz, jlong transformAdd, jlong polygon, jlong __result)
{
    b2Polygon* ptr = (b2Polygon*)(uintptr_t)__result;
    b2Transform* transform = (b2Transform*)(uintptr_t)transformAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2TransformPolygon( *transform, (const b2Polygon*)polygon );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2ComputeCircleMass
 * Signature: (JFJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2ComputeCircleMass
    (JNIEnv *__env, jclass clazz, jlong shape, jfloat density, jlong __result)
{
    b2MassData* ptr = (b2MassData*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2ComputeCircleMass( (const b2Circle*) shape, density );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2ComputeCapsuleMass
 * Signature: (JFJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2ComputeCapsuleMass
    (JNIEnv *__env, jclass clazz, jlong shape, jfloat density, jlong __result)
{
    b2MassData* ptr = (b2MassData*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2ComputeCapsuleMass( (const b2Capsule*) shape, density );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2ComputePolygonMass
 * Signature: (JFJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2ComputePolygonMass
    (JNIEnv *__env, jclass clazz, jlong shape, jfloat density, jlong __result)
{
    b2MassData* ptr = (b2MassData*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2ComputePolygonMass( (const b2Polygon*) shape, density );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2ComputeCircleAABB
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2ComputeCircleAABB
    (JNIEnv *__env, jclass clazz, jlong shape, jlong transformAdd, jlong __result)
{
    b2AABB* ptr = (b2AABB*)(uintptr_t)__result;
    b2Transform* transform = (b2Transform*)(uintptr_t)transformAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2ComputeCircleAABB( (const b2Circle*)shape, *transform );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2ComputeCapsuleAABB
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2ComputeCapsuleAABB
    (JNIEnv *__env, jclass clazz, jlong shape, jlong transformAdd, jlong __result)
{
    b2AABB* ptr = (b2AABB*)(uintptr_t)__result;
    b2Transform* transform = (b2Transform*)(uintptr_t)transformAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2ComputeCapsuleAABB( (const b2Capsule*) shape, *transform );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2ComputePolygonAABB
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2ComputePolygonAABB
    (JNIEnv *__env, jclass clazz, jlong shape, jlong transformAdd, jlong __result)
{
    b2AABB* ptr = (b2AABB*)(uintptr_t)__result;
    b2Transform* transform = (b2Transform*)(uintptr_t)transformAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2ComputePolygonAABB( (const b2Polygon*) shape, *transform );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2ComputeSegmentAABB
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2ComputeSegmentAABB
    (JNIEnv *__env, jclass clazz, jlong shape, jlong transformAdd, jlong __result)
{
    b2AABB* ptr = (b2AABB*)(uintptr_t)__result;
    b2Transform* transform = (b2Transform*)(uintptr_t)transformAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2ComputeSegmentAABB( (const b2Segment*) shape, *transform );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2PointInCircle
 * Signature: (JJ)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Collision_nb2PointInCircle
    (JNIEnv *__env, jclass clazz, jlong shape, jlong pointAdd)
{
    b2Vec2* point = (b2Vec2*)(uintptr_t)pointAdd;
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2PointInCircle( (const b2Circle*) shape, *point );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2PointInCapsule
 * Signature: (JJ)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Collision_nb2PointInCapsule
    (JNIEnv *__env, jclass clazz, jlong shape, jlong pointAdd)
{
    b2Vec2* point = (b2Vec2*)(uintptr_t)pointAdd;
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2PointInCapsule( (const b2Capsule*) shape, *point );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2PointInPolygon
 * Signature: (JJ)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Collision_nb2PointInPolygon
    (JNIEnv *__env, jclass clazz, jlong shape, jlong pointAdd)
{
    b2Vec2* point = (b2Vec2*)(uintptr_t)pointAdd;
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2PointInPolygon( (const b2Polygon*) shape, *point );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2RayCastCircle
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2RayCastCircle
    (JNIEnv *__env, jclass clazz, jlong shape, jlong input, jlong __result)
{
    b2CastOutput* ptr = (b2CastOutput*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2RayCastCircle( (const b2Circle*) shape, (const b2RayCastInput*) input );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2RayCastCapsule
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2RayCastCapsule
    (JNIEnv *__env, jclass clazz, jlong shape, jlong input, jlong __result)
{
    b2CastOutput* ptr = (b2CastOutput*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2RayCastCapsule( (const b2Capsule*) shape, (const b2RayCastInput*) input );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2RayCastSegment
 * Signature: (JJZJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2RayCastSegment
    (JNIEnv *__env, jclass clazz, jlong shape, jlong input, jboolean oneSided, jlong __result)
{
    b2CastOutput* ptr = (b2CastOutput*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2RayCastSegment( (const b2Segment*) shape, (const b2RayCastInput*) input, (bool)oneSided );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2RayCastPolygon
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2RayCastPolygon
    (JNIEnv *__env, jclass clazz, jlong shape, jlong input, jlong __result)
{
    b2CastOutput* ptr = (b2CastOutput*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2RayCastPolygon( (const b2Polygon*) shape, (const b2RayCastInput*) input );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2ShapeCastCircle
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2ShapeCastCircle
    (JNIEnv *__env, jclass clazz, jlong shape, jlong input, jlong __result)
{
    b2CastOutput* ptr = (b2CastOutput*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2ShapeCastCircle((const b2Circle*) shape,  (const b2ShapeCastInput*) input );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2ShapeCastCapsule
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2ShapeCastCapsule
    (JNIEnv *__env, jclass clazz, jlong shape, jlong input, jlong __result)
{
    b2CastOutput* ptr = (b2CastOutput*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2ShapeCastCapsule( (const b2Capsule*) shape, (const b2ShapeCastInput*) input);
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2ShapeCastSegment
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2ShapeCastSegment
    (JNIEnv *__env, jclass clazz, jlong shape, jlong input, jlong __result)
{
    b2CastOutput* ptr = (b2CastOutput*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2ShapeCastSegment( (const b2Segment*) shape, (const b2ShapeCastInput*) input );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2ShapeCastPolygon
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2ShapeCastPolygon
    (JNIEnv *__env, jclass clazz, jlong shape, jlong input, jlong __result)
{
    b2CastOutput* ptr = (b2CastOutput*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2ShapeCastPolygon( (const b2Polygon*) shape, (const b2ShapeCastInput*) input );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2ComputeHull
 * Signature: (JIJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2ComputeHull
    (JNIEnv *__env, jclass clazz, jlong points, jint count, jlong __result)
{
    b2Hull* ptr = (b2Hull*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2ComputeHull( (const b2Vec2*) points, count );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2ValidateHull
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_Collision_nb2ValidateHull
    (JNIEnv *__env, jclass clazz, jlong hull)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2ValidateHull( (const b2Hull*) hull );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2SegmentDistance
 * Signature: (JJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2SegmentDistance
    (JNIEnv *__env, jclass clazz, jlong p1Add, jlong q1Add, jlong p2Add, jlong q2Add, jlong __result)
{
    b2SegmentDistanceResult* ptr = (b2SegmentDistanceResult*)(uintptr_t)__result;
    b2Vec2* p1 = (b2Vec2*)(uintptr_t)p1Add;
    b2Vec2* q1 = (b2Vec2*)(uintptr_t)q1Add;
    b2Vec2* p2 = (b2Vec2*)(uintptr_t)p2Add;
    b2Vec2* q2 = (b2Vec2*)(uintptr_t)q2Add;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2SegmentDistance( *p1, *q1, *p2, *q2 );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2ShapeDistance
 * Signature: (JJJIJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2ShapeDistance
    (JNIEnv *__env, jclass clazz, jlong input, jlong cache, jlong simplexes, jint simplexCapacity, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2DistanceOutput*)__result = b2ShapeDistance((const b2DistanceInput*) input, (b2SimplexCache*) cache, (b2Simplex*) simplexes, simplexCapacity );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2ShapeCast
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2ShapeCast
    (JNIEnv *__env, jclass clazz, jlong input, jlong __result)
{
    b2CastOutput* ptr = (b2CastOutput*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2ShapeCast( (const b2ShapeCastPairInput*) input );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2MakeProxy
 * Signature: (JIFJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2MakeProxy
    (JNIEnv *__env, jclass clazz, jlong points, jint count, jfloat radius, jlong __result)
{
    b2ShapeProxy* ptr = (b2ShapeProxy*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2MakeProxy( (const b2Vec2*) points, count, radius );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2MakeOffsetProxy
 * Signature: (JIFJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2MakeOffsetProxy
    (JNIEnv *__env, jclass clazz, jlong points, jint count, jfloat radius, jlong positionAdd, jlong rotationAdd, jlong __result)
{
    b2ShapeProxy* ptr = (b2ShapeProxy*)(uintptr_t)__result;
    b2Vec2* position = (b2Vec2*)(uintptr_t)positionAdd;
    b2Rot* rotation = (b2Rot*)(uintptr_t)rotationAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2MakeOffsetProxy( (const b2Vec2*) points, count, radius, *position, *rotation );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2GetSweepTransform
 * Signature: (JFJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2GetSweepTransform
    (JNIEnv *__env, jclass clazz, jlong sweep, jfloat time, jlong __result)
{
    b2Transform* ptr = (b2Transform*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2GetSweepTransform( (const b2Sweep*) sweep, time );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2TimeOfImpact
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2TimeOfImpact
    (JNIEnv *__env, jclass clazz, jlong input, jlong __result)
{
    b2TOIOutput* ptr = (b2TOIOutput*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2TimeOfImpact( (const b2TOIInput*) input );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2CollideCircles
 * Signature: (JJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2CollideCircles
    (JNIEnv *__env, jclass clazz, jlong circleA, jlong xfAAdd, jlong circleB, jlong xfBAdd, jlong __result)
{
    b2Manifold* ptr = (b2Manifold*)(uintptr_t)__result;
    b2Transform* xfA = (b2Transform*)(uintptr_t)xfAAdd;
    b2Transform* xfB = (b2Transform*)(uintptr_t)xfBAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2CollideCircles( (const b2Circle*) circleA, *xfA, (const b2Circle* )circleB, *xfB );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2CollideCapsuleAndCircle
 * Signature: (JJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2CollideCapsuleAndCircle
    (JNIEnv *__env, jclass clazz, jlong capsuleA, jlong xfAAdd, jlong circleB, jlong xfBAdd, jlong __result)
{
    b2Manifold* ptr = (b2Manifold*)(uintptr_t)__result;
    b2Transform* xfA = (b2Transform*)(uintptr_t)xfAAdd;
    b2Transform* xfB = (b2Transform*)(uintptr_t)xfBAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2CollideCapsuleAndCircle( (const b2Capsule*) capsuleA, *xfA, (const b2Circle*) circleB, *xfB );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2CollideSegmentAndCircle
 * Signature: (JJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2CollideSegmentAndCircle
    (JNIEnv *__env, jclass clazz, jlong segmentA, jlong xfAAdd, jlong circleB, jlong xfBAdd, jlong __result)
{
    b2Manifold* ptr = (b2Manifold*)(uintptr_t)__result;
    b2Transform* xfA = (b2Transform*)(uintptr_t)xfAAdd;
    b2Transform* xfB = (b2Transform*)(uintptr_t)xfBAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2CollideSegmentAndCircle( (const b2Segment*) segmentA, *xfA, (const b2Circle*) circleB, *xfB );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2CollidePolygonAndCircle
 * Signature: (JJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2CollidePolygonAndCircle
    (JNIEnv *__env, jclass clazz, jlong polygonA, jlong xfAAdd, jlong circleB, jlong xfBAdd, jlong __result)
{
    b2Manifold* ptr = (b2Manifold*)(uintptr_t)__result;
    b2Transform* xfA = (b2Transform*)(uintptr_t)xfAAdd;
    b2Transform* xfB = (b2Transform*)(uintptr_t)xfBAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2CollidePolygonAndCircle( (const b2Polygon*) polygonA, *xfA, (const b2Circle* )circleB,  *xfB );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2CollideCapsules
 * Signature: (JJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2CollideCapsules
    (JNIEnv *__env, jclass clazz, jlong capsuleA, jlong xfAAdd, jlong capsuleB, jlong xfBAdd, jlong __result)
{
    b2Manifold* ptr = (b2Manifold*)(uintptr_t)__result;
    b2Transform* xfA = (b2Transform*)(uintptr_t)xfAAdd;
    b2Transform* xfB = (b2Transform*)(uintptr_t)xfBAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2CollideCapsules( (const b2Capsule*) capsuleA, *xfA, (const b2Capsule*) capsuleB, *xfB );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2CollideSegmentAndCapsule
 * Signature: (JJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2CollideSegmentAndCapsule
    (JNIEnv *__env, jclass clazz, jlong segmentA, jlong xfAAdd, jlong capsuleB, jlong xfBAdd, jlong __result)
{
    b2Manifold* ptr = (b2Manifold*)(uintptr_t)__result;
    b2Transform* xfA = (b2Transform*)(uintptr_t)xfAAdd;
    b2Transform* xfB = (b2Transform*)(uintptr_t)xfBAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2CollideSegmentAndCapsule( (const b2Segment*) segmentA, *xfA, (const b2Capsule*) capsuleB, *xfB );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2CollidePolygonAndCapsule
 * Signature: (JJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2CollidePolygonAndCapsule
    (JNIEnv *__env, jclass clazz, jlong polygonA, jlong xfAAdd, jlong capsuleB, jlong xfBAdd, jlong __result)
{
    b2Manifold* ptr = (b2Manifold*)(uintptr_t)__result;
    b2Transform* xfA = (b2Transform*)(uintptr_t)xfAAdd;
    b2Transform* xfB = (b2Transform*)(uintptr_t)xfBAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2CollidePolygonAndCapsule( (const b2Polygon*) polygonA, *xfA, (const b2Capsule*) capsuleB, *xfB );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2CollidePolygons
 * Signature: (JJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2CollidePolygons
    (JNIEnv *__env, jclass clazz, jlong polygonA, jlong xfAAdd, jlong polygonB, jlong xfBAdd, jlong __result)
{
    b2Manifold* ptr = (b2Manifold*)(uintptr_t)__result;
    b2Transform* xfA = (b2Transform*)(uintptr_t)xfAAdd;
    b2Transform* xfB = (b2Transform*)(uintptr_t)xfBAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2CollidePolygons( (const b2Polygon*) polygonA, *xfA, (const b2Polygon*) polygonB, *xfB );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2CollideSegmentAndPolygon
 * Signature: (JJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2CollideSegmentAndPolygon
    (JNIEnv *__env, jclass clazz, jlong segmentA, jlong xfAAdd, jlong polygonB, jlong xfBAdd, jlong __result)
{
    b2Manifold* ptr = (b2Manifold*)(uintptr_t)__result;
    b2Transform* xfA = (b2Transform*)(uintptr_t)xfAAdd;
    b2Transform* xfB = (b2Transform*)(uintptr_t)xfBAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2CollideSegmentAndPolygon( (const b2Segment*) segmentA, *xfA, (const b2Polygon*) polygonB, *xfB );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2CollideChainSegmentAndCircle
 * Signature: (JJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2CollideChainSegmentAndCircle
    (JNIEnv *__env, jclass clazz, jlong segmentA, jlong xfAAdd, jlong circleB, jlong xfBAdd, jlong __result)
{
    b2Manifold* ptr = (b2Manifold*)(uintptr_t)__result;
    b2Transform* xfA = (b2Transform*)(uintptr_t)xfAAdd;
    b2Transform* xfB = (b2Transform*)(uintptr_t)xfBAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2CollideChainSegmentAndCircle( (const b2ChainSegment*) segmentA, *xfA, (const b2Circle*) circleB, *xfB );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2CollideChainSegmentAndCapsule
 * Signature: (JJJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2CollideChainSegmentAndCapsule
    (JNIEnv *__env, jclass clazz, jlong segmentA, jlong xfAAdd, jlong capsuleB, jlong xfBAdd, jlong cache, jlong __result)
{
    b2Manifold* ptr = (b2Manifold*)(uintptr_t)__result;
    b2Transform* xfA = (b2Transform*)(uintptr_t)xfAAdd;
    b2Transform* xfB = (b2Transform*)(uintptr_t)xfBAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2CollideChainSegmentAndCapsule( (const b2ChainSegment*) segmentA, *xfA, (const b2Capsule*) capsuleB, *xfB, (b2SimplexCache*) cache );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2CollideChainSegmentAndPolygon
 * Signature: (JJJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2CollideChainSegmentAndPolygon
    (JNIEnv *__env, jclass clazz, jlong segmentA, jlong xfAAdd, jlong polygonB, jlong xfBAdd, jlong cache, jlong __result)
{
    b2Manifold* ptr = (b2Manifold*)(uintptr_t)__result;
    b2Transform* xfA = (b2Transform*)(uintptr_t)xfAAdd;
    b2Transform* xfB = (b2Transform*)(uintptr_t)xfBAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2CollideChainSegmentAndPolygon( (const b2ChainSegment*) segmentA, *xfA, (const b2Polygon*) polygonB, *xfB, (b2SimplexCache*) cache );
}


/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_Create
 * Signature: (IJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1Create
    (JNIEnv *__env, jclass clazz, jint proxyCapacity, jlong __result)
{
    b2DynamicTree* ptr = (b2DynamicTree*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DynamicTree_Create( proxyCapacity );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_Destroy
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1Destroy
    (JNIEnv *__env, jclass clazz, jlong tree)
{
    UNUSED_PARAMS(__env, clazz)
    b2DynamicTree_Destroy( (b2DynamicTree*) tree );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_CreateProxy
 * Signature: (JJJJ)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1CreateProxy
    (JNIEnv *__env, jclass clazz, jlong tree, jlong aabbAdd, jlong categoryBits, jlong userData)
{
    b2AABB* aabb = (b2AABB*)(uintptr_t)aabbAdd;
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2DynamicTree_CreateProxy( (b2DynamicTree*) tree, *aabb, (uint64_t)categoryBits, (uint64_t)userData );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_DestroyProxy
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1DestroyProxy
    (JNIEnv *__env, jclass clazz, jlong tree, jint proxyId)
{
    UNUSED_PARAMS(__env, clazz)
    b2DynamicTree_DestroyProxy( (b2DynamicTree*) tree, proxyId );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_MoveProxy
 * Signature: (JIJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1MoveProxy
    (JNIEnv *__env, jclass clazz, jlong tree, jint proxyId, jlong aabbAdd)
{
    b2AABB* aabb = (b2AABB*)(uintptr_t)aabbAdd;
    UNUSED_PARAMS(__env, clazz)
    b2DynamicTree_MoveProxy( (b2DynamicTree*) tree, proxyId, *aabb );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_EnlargeProxy
 * Signature: (JIJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1EnlargeProxy
    (JNIEnv *__env, jclass clazz, jlong tree, jint proxyId, jlong aabbAdd)
{
    b2AABB* aabb = (b2AABB*)(uintptr_t)aabbAdd;
    UNUSED_PARAMS(__env, clazz)
    b2DynamicTree_EnlargeProxy( (b2DynamicTree*) tree, proxyId, *aabb );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_SetCategoryBits
 * Signature: (JIJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1SetCategoryBits
    (JNIEnv *__env, jclass clazz, jlong tree, jint proxyId, jlong categoryBits)
{
    UNUSED_PARAMS(__env, clazz)
    b2DynamicTree_SetCategoryBits( (b2DynamicTree*) tree, proxyId, (uint64_t)categoryBits );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_GetCategoryBits
 * Signature: (JI)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1GetCategoryBits
    (JNIEnv *__env, jclass clazz, jlong tree, jint proxyId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)b2DynamicTree_GetCategoryBits( (b2DynamicTree*)tree, proxyId );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_Query
 * Signature: (JJJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1Query
    (JNIEnv *__env, jclass clazz, jlong tree, jlong aabbAdd, jlong maskBits, jlong callback, jlong context, jlong __result)
{
    b2TreeStats* ptr = (b2TreeStats*)(uintptr_t)__result;
    b2AABB* aabb = (b2AABB*)(uintptr_t)aabbAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DynamicTree_Query( (const b2DynamicTree*) tree, *aabb, (uint64_t) maskBits, (b2TreeQueryCallbackFcn*) callback, (void*) context );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_QueryAll
 * Signature: (JJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1QueryAll
    (JNIEnv *__env, jclass clazz, jlong tree, jlong aabbAdd, jlong callback, jlong context, jlong __result)
{
    b2TreeStats* ptr = (b2TreeStats*)(uintptr_t)__result;
    b2AABB* aabb = (b2AABB*)(uintptr_t)aabbAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DynamicTree_QueryAll( (const b2DynamicTree*) tree, *aabb, (b2TreeQueryCallbackFcn*) callback, (void*) context );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_RayCast
 * Signature: (JJJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1RayCast
    (JNIEnv *__env, jclass clazz, jlong tree, jlong input, jlong maskBits, jlong callback, jlong context, jlong __result)
{
    b2TreeStats* ptr = (b2TreeStats*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DynamicTree_RayCast( (const b2DynamicTree*) tree, (const b2RayCastInput*) input, (uint64_t) maskBits, (b2TreeRayCastCallbackFcn*) callback, (void*) context );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_ShapeCast
 * Signature: (JJJJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1ShapeCast
    (JNIEnv *__env, jclass clazz, jlong tree, jlong input, jlong maskBits, jlong callback, jlong context, jlong __result)
{
    b2TreeStats* ptr = (b2TreeStats*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DynamicTree_ShapeCast( (const b2DynamicTree*) tree, (const b2ShapeCastInput* )input, (uint64_t) maskBits, (b2TreeShapeCastCallbackFcn*) callback, (void*) context );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_GetHeight
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1GetHeight
    (JNIEnv *__env, jclass clazz, jlong tree)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2DynamicTree_GetHeight( (const b2DynamicTree*) tree );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_GetAreaRatio
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1GetAreaRatio
    (JNIEnv *__env, jclass clazz, jlong tree)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2DynamicTree_GetAreaRatio( (const b2DynamicTree*)tree );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_GetRootBounds
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1GetRootBounds
    (JNIEnv *__env, jclass clazz, jlong tree, jlong __result)
{
    b2AABB* ptr = (b2AABB*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DynamicTree_GetRootBounds( (const b2DynamicTree*) tree );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_GetProxyCount
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1GetProxyCount
    (JNIEnv *__env, jclass clazz, jlong tree)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2DynamicTree_GetProxyCount( (const b2DynamicTree*) tree );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_Rebuild
 * Signature: (JZ)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1Rebuild
    (JNIEnv *__env, jclass clazz, jlong tree, jboolean fullBuild)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2DynamicTree_Rebuild( (b2DynamicTree*) tree, (bool)fullBuild );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_GetByteCount
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1GetByteCount
    (JNIEnv *__env, jclass clazz, jlong tree)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint)b2DynamicTree_GetByteCount( (const b2DynamicTree*) tree );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_GetUserData
 * Signature: (JI)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1GetUserData
    (JNIEnv *__env, jclass clazz, jlong tree, jint proxyId)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)b2DynamicTree_GetUserData( (const b2DynamicTree*)tree, proxyId );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_GetAABB
 * Signature: (JIJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1GetAABB
    (JNIEnv *__env, jclass clazz, jlong tree, jint proxyId, jlong __result)
{
    b2AABB* ptr = (b2AABB*)(uintptr_t)__result;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2DynamicTree_GetAABB( (const b2DynamicTree*) tree, proxyId );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_Validate
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1Validate
    (JNIEnv *__env, jclass clazz, jlong tree)
{
    UNUSED_PARAMS(__env, clazz)
    b2DynamicTree_Validate( (const b2DynamicTree*) tree );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2DynamicTree_ValidateNoEnlarged
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2DynamicTree_1ValidateNoEnlarged
    (JNIEnv *__env, jclass clazz, jlong tree)
{
    UNUSED_PARAMS(__env, clazz)
    b2DynamicTree_ValidateNoEnlarged( (const b2DynamicTree*) tree );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2SolvePlanes
 * Signature: (JJIJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2SolvePlanes
    (JNIEnv *__env, jclass clazz, jlong targetDeltaAdd, jlong planes, jint count, jlong __result)
{
    b2PlaneSolverResult* ptr = (b2PlaneSolverResult*)(uintptr_t)__result;
    b2Vec2* targetDelta = (b2Vec2*)(uintptr_t)targetDeltaAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2SolvePlanes( *targetDelta, (b2CollisionPlane*) planes, count );
}

/*
 * Class:     org_box2d_jni_include_Collision
 * Method:    nb2ClipVector
 * Signature: (JJIJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_Collision_nb2ClipVector
    (JNIEnv *__env, jclass clazz, jlong vectorAdd, jlong planes, jint count, jlong __result)
{
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Vec2* vector = (b2Vec2*)(uintptr_t)vectorAdd;
    UNUSED_PARAMS(__env, clazz)
    *ptr = b2ClipVector( *vector, (const b2CollisionPlane*) planes, count );
}
