/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.include;

import org.box2d.jni.b2AABB;
import org.box2d.jni.b2CastOutput;
import org.box2d.jni.b2DistanceOutput;
import org.box2d.jni.b2Hull;
import org.box2d.jni.b2Manifold;
import org.box2d.jni.b2MassData;
import org.box2d.jni.b2Polygon;
import org.box2d.jni.b2Rot;
import org.box2d.jni.b2SegmentDistanceResult;
import org.box2d.jni.b2ShapeProxy;
import org.box2d.jni.b2Simplex;
import org.box2d.jni.b2SimplexCache;
import org.box2d.jni.b2TOIOutput;
import org.box2d.jni.b2Transform;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.readonly.ConstB2Capsule;
import org.box2d.jni.readonly.ConstB2ChainSegment;
import org.box2d.jni.readonly.ConstB2Circle;
import org.box2d.jni.readonly.ConstB2DistanceInput;
import org.box2d.jni.readonly.ConstB2Hull;
import org.box2d.jni.readonly.ConstB2Polygon;
import org.box2d.jni.readonly.ConstB2RayCastInput;
import org.box2d.jni.readonly.ConstB2Segment;
import org.box2d.jni.readonly.ConstB2ShapeCastInput;
import org.box2d.jni.readonly.ConstB2ShapeCastPairInput;
import org.box2d.jni.readonly.ConstB2Sweep;
import org.box2d.jni.readonly.ConstB2TOIInput;
import org.box2d.jni.readonly.ConstB2Vec2;
import org.box2d.jni.system.Library;
import static org.box2d.jni.system.Checks.*;

/**
 * Class that represents the {@code collision.h} header of box2d.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Collision {
    static { Library.initialize(); }
    /* Native bindings: {@code #define B2_MAX_POLYGON_VERTICES 8 */
    public static final int B2_MAX_POLYGON_VERTICES = 8;

    // --- [ b2IsValidRay ] ---

    /**
     * {@code B2_API bool b2IsValidRay( const b2RayCastInput* input ); }
     *
     * @param input b2RayCastInput
     * @return boolean
     */
    public static boolean b2IsValidRay(ConstB2RayCastInput input) {
        checkPointers(input);
        return nb2IsValidRay(input.address());
    }
    /* {@code B2_API bool b2IsValidRay( const b2RayCastInput* input ); } */
    public static native boolean nb2IsValidRay(long input);

    // --- [ b2MakePolygon ] ---

    /**
     * {@code B2_API b2Polygon b2MakePolygon( const b2Hull* hull, float radius ); }
     *
     * @param hull b2Hull
     * @param radius float
     * @param __result store
     *
     * @return b2Polygon
     */
    public static b2Polygon b2MakePolygon(ConstB2Hull hull, float radius, b2Polygon __result) {
        checkPointers(hull, __result);
        nb2MakePolygon(hull.address(), radius, __result.address());
        return __result;
    }
    /* {@code B2_API b2Polygon b2MakePolygon( const b2Hull* hull, float radius ); } */
    public static native void nb2MakePolygon(long hull, float radius, long __result);

    // --- [ b2MakeOffsetPolygon ] ---

    /**
     * {@code B2_API b2Polygon b2MakeOffsetPolygon( const b2Hull* hull, b2Vec2 position, b2Rot rotation ); }
     *
     * @param hull b2Hull
     * @param position b2Vec2
     * @param rotation b2Rot
     * @param __result store
     *
     * @return b2Polygon
     */
    public static b2Polygon b2MakeOffsetPolygon(ConstB2Hull hull, b2Vec2 position, b2Rot rotation, b2Polygon __result) {
        checkPointers(hull, position, rotation, __result);
        nb2MakeOffsetPolygon(hull.address(), position.address(), rotation.address(), __result.address());
        return __result;
    }
    /* {@code B2_API b2Polygon b2MakeOffsetPolygon( const b2Hull* hull, b2Vec2 position, b2Rot rotation ); } */
    public static native void nb2MakeOffsetPolygon(long hull, long position, long rotation, long __result);

    // --- [ b2MakeOffsetRoundedPolygon ] ---

    /**
     * {@code B2_API b2Polygon b2MakeOffsetRoundedPolygon( const b2Hull* hull, b2Vec2 position, b2Rot rotation, float radius ); }
     *
     * @param hull b2Hull
     * @param position b2Vec2
     * @param rotation b2Rot
     * @param radius float
     * @param __result store
     * 
     * @return b2Polygon
     */
    public static b2Polygon b2MakeOffsetRoundedPolygon(ConstB2Hull hull, b2Vec2 position, b2Rot rotation, float radius, b2Polygon __result) {
        checkPointers(hull, position, rotation, __result);
        nb2MakeOffsetRoundedPolygon(hull.address(), position.address(), rotation.address(), radius, __result.address());
        return __result;
    }
    /* {@code B2_API b2Polygon b2MakeOffsetRoundedPolygon( const b2Hull* hull, b2Vec2 position, b2Rot rotation, float radius ); } */
    public static native void nb2MakeOffsetRoundedPolygon(long hull, long position, long rotation, float radius, long __result);

    // --- [ b2MakeSquare ] ---

    /**
     * {@code B2_API b2Polygon b2MakeSquare( float halfWidth ); }
     *
     * @param halfWidth float
     * @param __result store
     * 
     * @return b2Polygon
     */
    public static b2Polygon b2MakeSquare(float halfWidth, b2Polygon __result) {
        checkPointers(__result);
        nb2MakeSquare(halfWidth, __result.address());
        return __result;
    }
    /* {@code B2_API b2Polygon b2MakeSquare( float halfWidth ); } */
    public static native void nb2MakeSquare(float halfWidth, long __result);

    // --- [ b2MakeBox ] ---

    /**
     * {@code B2_API b2Polygon b2MakeBox( float halfWidth, float halfHeight ); }
     *
     * @param halfWidth float
     * @param halfHeight float
     * @param __result store
     * 
     * @return b2Polygon
     */
    public static b2Polygon b2MakeBox(float halfWidth, float halfHeight, b2Polygon __result) {
        checkPointers(__result);
        nb2MakeBox(halfWidth, halfHeight, __result.address());
        return __result;
    }
    /* {@code B2_API b2Polygon b2MakeBox( float halfWidth, float halfHeight ); } */
    public static native void nb2MakeBox(float halfWidth, float halfHeight, long __result);

    // --- [ b2MakeRoundedBox ] ---

    /**
     * {@code B2_API b2Polygon b2MakeRoundedBox( float halfWidth, float halfHeight, float radius ); }
     *
     * @param halfWidth float
     * @param halfHeight float
     * @param radius float
     * @param __result store
     * 
     * @return b2Polygon
     */
    public static b2Polygon b2MakeRoundedBox(float halfWidth, float halfHeight, float radius, b2Polygon __result) {
        checkPointers(__result);
        nb2MakeRoundedBox(halfWidth, halfHeight, radius, __result.address());
        return __result;
    }
    /* {@code B2_API b2Polygon b2MakeRoundedBox( float halfWidth, float halfHeight, float radius ); } */
    public static native void nb2MakeRoundedBox(float halfWidth, float halfHeight, float radius, long __result);

    // --- [ b2MakeOffsetBox ] ---

    /**
     * {@code B2_API b2Polygon b2MakeOffsetBox( float halfWidth, float halfHeight, b2Vec2 center, b2Rot rotation ); }
     *
     * @param halfWidth float
     * @param halfHeight float
     * @param center b2Vec2
     * @param rotation b2Rot
     * @param __result store
     * 
     * @return b2Polygon
     */
    public static b2Polygon b2MakeOffsetBox(float halfWidth, float halfHeight, b2Vec2 center, b2Rot rotation, b2Polygon __result) {
        checkPointers(center, rotation, __result);
        nb2MakeOffsetBox(halfWidth, halfHeight, center.address(), rotation.address(), __result.address());
        return __result;
    }
    /* {@code B2_API b2Polygon b2MakeOffsetBox( float halfWidth, float halfHeight, b2Vec2 center, b2Rot rotation ); } */
    public static native void nb2MakeOffsetBox(float halfWidth, float halfHeight, long center, long rotation, long __result);

    // --- [ b2MakeOffsetRoundedBox ] ---

    /**
     * {@code B2_API b2Polygon b2MakeOffsetRoundedBox( float halfWidth, float halfHeight, b2Vec2 center, b2Rot rotation, float radius ); }
     *
     * @param halfWidth float
     * @param halfHeight float
     * @param center b2Vec2
     * @param rotation b2Rot
     * @param radius float
     * @param __result store
     * 
     * @return b2Polygon
     */
    public static b2Polygon b2MakeOffsetRoundedBox(float halfWidth, float halfHeight, b2Vec2 center, b2Rot rotation, float radius, b2Polygon __result) {
        checkPointers(center, rotation, __result);
        nb2MakeOffsetRoundedBox(halfWidth, halfHeight, center.address(), rotation.address(), radius, __result.address());
        return __result;
    }
    /* {@code B2_API b2Polygon b2MakeOffsetRoundedBox( float halfWidth, float halfHeight, b2Vec2 center, b2Rot rotation, float radius ); } */
    public static native void nb2MakeOffsetRoundedBox(float halfWidth, float halfHeight, long center, long rotation, float radius, long __result);

    // --- [ b2TransformPolygon ] ---

    /**
     * {@code B2_API b2Polygon b2TransformPolygon( b2Transform transform, const b2Polygon* polygon ); }
     *
     * @param transform b2Transform
     * @param polygon b2Polygon
     * @param __result store
     * 
     * @return b2Polygon
     */
    public static b2Polygon b2TransformPolygon(b2Transform transform, ConstB2Polygon polygon, b2Polygon __result) {
        checkPointers(transform, polygon, __result);
        nb2TransformPolygon(transform.address(), polygon.address(), __result.address());
        return __result;
    }
    /* {@code B2_API b2Polygon b2TransformPolygon( b2Transform transform, const b2Polygon* polygon ); } */
    public static native void nb2TransformPolygon(long transform, long polygon, long __result);

    // --- [ b2ComputeCircleMass ] ---

    /**
     * {@code B2_API b2MassData b2ComputeCircleMass( const b2Circle* shape, float density ); }
     *
     * @param shape b2Circle
     * @param density float
     * @param __result store
     * 
     * @return b2MassData
     */
    public static b2MassData b2ComputeCircleMass(ConstB2Circle shape, float density, b2MassData __result) {
        checkPointers(shape, __result);
        nb2ComputeCircleMass(shape.address(), density, __result.address());
        return __result;
    }
    /* {@code B2_API b2MassData b2ComputeCircleMass( const b2Circle* shape, float density ); } */
    public static native void nb2ComputeCircleMass(long shape, float density, long __result);

    // --- [ b2ComputeCapsuleMass ] ---

    /**
     * {@code B2_API b2MassData b2ComputeCapsuleMass( const b2Capsule* shape, float density ); }
     *
     * @param shape b2Capsule
     * @param density float
     * @param __result store
     * 
     * @return b2MassData
     */
    public static b2MassData b2ComputeCapsuleMass(ConstB2Capsule shape, float density, b2MassData __result) {
        checkPointers(shape, __result);
        nb2ComputeCapsuleMass(shape.address(), density, __result.address());
        return __result;
    }
    /* {@code B2_API b2MassData b2ComputeCapsuleMass( const b2Capsule* shape, float density ); } */
    public static native void nb2ComputeCapsuleMass(long shape, float density, long __result);

    // --- [ b2ComputePolygonMass ] ---

    /**
     * {@code B2_API b2MassData b2ComputePolygonMass( const b2Polygon* shape, float density ); }
     *
     * @param shape b2Polygon
     * @param density float
     * @param __result store
     * 
     * @return b2MassData
     */
    public static b2MassData b2ComputePolygonMass(ConstB2Polygon shape, float density, b2MassData __result) {
        checkPointers(shape, __result);
        nb2ComputePolygonMass(shape.address(), density, __result.address());
        return __result;
    }
    /* {@code B2_API b2MassData b2ComputePolygonMass( const b2Polygon* shape, float density ); } */
    public static native void nb2ComputePolygonMass(long shape, float density, long __result);

    // --- [ b2ComputeCircleAABB ] ---

    /**
     * {@code B2_API b2AABB b2ComputeCircleAABB( const b2Circle* shape, b2Transform transform ); }
     *
     * @param shape b2Circle
     * @param transform b2Transform
     * @param __result store
     * 
     * @return b2AABB
     */
    public static b2AABB b2ComputeCircleAABB(ConstB2Circle shape, b2Transform transform, b2AABB __result) {
        checkPointers(shape, transform, __result);
        nb2ComputeCircleAABB(shape.address(), transform.address(), __result.address());
        return __result;
    }
    /* {@code B2_API b2AABB b2ComputeCircleAABB( const b2Circle* shape, b2Transform transform ); } */
    public static native void nb2ComputeCircleAABB(long shape, long transform, long __result);

    // --- [ b2ComputeCapsuleAABB ] ---

    /**
     * {@code B2_API b2AABB b2ComputeCapsuleAABB( const b2Capsule* shape, b2Transform transform ); }
     *
     * @param shape b2Capsule
     * @param transform b2Transform
     * @param __result store
     * 
     * @return b2AABB
     */
    public static b2AABB b2ComputeCapsuleAABB(ConstB2Capsule shape, b2Transform transform, b2AABB __result) {
        checkPointers(shape, transform, __result);
        nb2ComputeCapsuleAABB(shape.address(), transform.address(), __result.address());
        return __result;
    }
    /* {@code B2_API b2AABB b2ComputeCapsuleAABB( const b2Capsule* shape, b2Transform transform ); } */
    public static native void nb2ComputeCapsuleAABB(long shape, long transform, long __result);

    // --- [ b2ComputePolygonAABB ] ---

    /**
     * {@code B2_API b2AABB b2ComputePolygonAABB( const b2Polygon* shape, b2Transform transform ); }
     *
     * @param shape b2Polygon
     * @param transform b2Transform
     * @param __result store
     * 
     * @return b2AABB
     */
    public static b2AABB b2ComputePolygonAABB(ConstB2Polygon shape, b2Transform transform, b2AABB __result) {
        checkPointers(shape, transform, __result);
        nb2ComputePolygonAABB(shape.address(), transform.address(), __result.address());
        return __result;
    }
    /* {@code B2_API b2AABB b2ComputePolygonAABB( const b2Polygon* shape, b2Transform transform ); } */
    public static native void nb2ComputePolygonAABB(long shape, long transform, long __result);

    // --- [ b2ComputeSegmentAABB ] ---

    /**
     * {@code B2_API b2AABB b2ComputeSegmentAABB( const b2Segment* shape, b2Transform transform ); }
     *
     * @param shape b2Segment
     * @param transform b2Transform
     * @param __result store
     * 
     * @return b2AABB
     */
    public static b2AABB b2ComputeSegmentAABB(ConstB2Segment shape, b2Transform transform, b2AABB __result) {
        checkPointers(shape, transform, __result);
        nb2ComputeSegmentAABB(shape.address(), transform.address(), __result.address());
        return __result;
    }
    /* {@code B2_API b2AABB b2ComputeSegmentAABB( const b2Segment* shape, b2Transform transform ); } */
    public static native void nb2ComputeSegmentAABB(long shape, long transform, long __result);

    // --- [ b2PointInCircle ] ---

    /**
     * {@code B2_API bool b2PointInCircle( const b2Circle* shape, b2Vec2 point ); }
     *
     * @param shape b2Circle
     * @param point b2Vec2
     * @return boolean
     */
    public static boolean b2PointInCircle(ConstB2Circle shape, b2Vec2 point) {
        checkPointers(shape, point);
        return nb2PointInCircle(shape.address(), point.address());
    }
    /* {@code B2_API bool b2PointInCircle( const b2Circle* shape, b2Vec2 point ); } */
    public static native boolean nb2PointInCircle(long shape, long point);

    // --- [ b2PointInCapsule ] ---

    /**
     * {@code B2_API bool b2PointInCapsule( const b2Capsule* shape, b2Vec2 point ); }
     *
     * @param shape b2Capsule
     * @param point b2Vec2
     * @return boolean
     */
    public static boolean b2PointInCapsule(ConstB2Capsule shape, b2Vec2 point) {
        checkPointers(shape, point);
        return nb2PointInCapsule(shape.address(), point.address());
    }
    /* {@code B2_API bool b2PointInCapsule( const b2Capsule* shape, b2Vec2 point ); } */
    public static native boolean nb2PointInCapsule(long shape, long point);

    // --- [ b2PointInPolygon ] ---

    /**
     * {@code B2_API bool b2PointInPolygon( const b2Polygon* shape, b2Vec2 point ); }
     *
     * @param shape b2Polygon
     * @param point b2Vec2
     * @return boolean
     */
    public static boolean b2PointInPolygon(ConstB2Polygon shape, b2Vec2 point) {
        checkPointers(shape, point);
        return nb2PointInPolygon(shape.address(), point.address());
    }
    /* {@code B2_API bool b2PointInPolygon( const b2Polygon* shape, b2Vec2 point ); } */
    public static native boolean nb2PointInPolygon(long shape, long point);

    // --- [ b2RayCastCircle ] ---

    /**
     * {@code B2_API b2CastOutput b2RayCastCircle( const b2Circle* shape, const b2RayCastInput* input ); }
     *
     * @param shape b2Circle
     * @param input b2RayCastInput
     * @param __result store
     * 
     * @return b2CastOutput
     */
    public static b2CastOutput b2RayCastCircle(ConstB2Circle shape, ConstB2RayCastInput input, b2CastOutput __result) {
        checkPointers(shape, input, __result);
        nb2RayCastCircle(shape.address(), input.address(), __result.address());
        return __result;
    }
    /* {@code B2_API b2CastOutput b2RayCastCircle( const b2Circle* shape, const b2RayCastInput* input ); } */
    public static native void nb2RayCastCircle(long shape, long input, long __result);

    // --- [ b2RayCastCapsule ] ---

    /**
     * {@code B2_API b2CastOutput b2RayCastCapsule( const b2Capsule* shape, const b2RayCastInput* input ); }
     *
     * @param shape b2Capsule
     * @param input b2RayCastInput
     * @param __result store
     * 
     * @return b2CastOutput
     */
    public static b2CastOutput b2RayCastCapsule(ConstB2Capsule shape, ConstB2RayCastInput input, b2CastOutput __result) {
        checkPointers(shape, input, __result);
        nb2RayCastCapsule(shape.address(), input.address(), __result.address());
        return __result;
    }
    /* {@code B2_API b2CastOutput b2RayCastCapsule( const b2Capsule* shape, const b2RayCastInput* input ); } */
    public static native void nb2RayCastCapsule(long shape, long input, long __result);

    // --- [ b2RayCastSegment ] ---

    /**
     * {@code B2_API b2CastOutput b2RayCastSegment( const b2Segment* shape, const b2RayCastInput* input, bool oneSided ); }
     *
     * @param shape b2Segment
     * @param input b2RayCastInput
     * @param oneSided boolean
     * @param __result store
     * 
     * @return b2CastOutput
     */
    public static b2CastOutput b2RayCastSegment(ConstB2Segment shape, ConstB2RayCastInput input, boolean oneSided, b2CastOutput __result) {
        checkPointers(shape, input, __result);
        nb2RayCastSegment(shape.address(), input.address(), oneSided, __result.address());
        return __result;
    }
    /* {@code B2_API b2CastOutput b2RayCastSegment( const b2Segment* shape, const b2RayCastInput* input, bool oneSided ); } */
    public static native void nb2RayCastSegment(long shape, long input, boolean oneSided, long __result);

    // --- [ b2RayCastPolygon ] ---

    /**
     * {@code B2_API b2CastOutput b2RayCastPolygon( const b2Polygon* shape, const b2RayCastInput* input ); }
     *
     * @param shape b2Polygon
     * @param input b2RayCastInput
     * @param __result store
     * 
     * @return b2CastOutput
     */
    public static b2CastOutput b2RayCastPolygon(ConstB2Polygon shape, ConstB2RayCastInput input, b2CastOutput __result) {
        checkPointers(shape, input, __result);
        nb2RayCastPolygon(shape.address(), input.address(), __result.address());
        return __result;
    }
    /* {@code B2_API b2CastOutput b2RayCastPolygon( const b2Polygon* shape, const b2RayCastInput* input ); } */
    public static native void nb2RayCastPolygon(long shape, long input, long __result);

    // --- [ b2ShapeCastCircle ] ---

    /**
     * {@code B2_API b2CastOutput b2ShapeCastCircle(const b2Circle* shape,  const b2ShapeCastInput* input ); }
     *
     * @param shape b2Circle
     * @param input b2ShapeCastInput
     * @param __result store
     * 
     * @return b2CastOutput
     */
    public static b2CastOutput b2ShapeCastCircle(ConstB2Circle shape, ConstB2ShapeCastInput input, b2CastOutput __result) {
        checkPointers(shape, input, __result);
        nb2ShapeCastCircle(shape.address(), input.address(), __result.address());
        return __result;
    }
    /* {@code B2_API b2CastOutput b2ShapeCastCircle(const b2Circle* shape,  const b2ShapeCastInput* input ); } */
    public static native void nb2ShapeCastCircle(long shape, long input, long __result);

    // --- [ b2ShapeCastCapsule ] ---

    /**
     * {@code B2_API b2CastOutput b2ShapeCastCapsule( const b2Capsule* shape, const b2ShapeCastInput* input); }
     *
     * @param shape b2Capsule
     * @param input b2ShapeCastInput
     * @param __result store
     * 
     * @return b2CastOutput
     */
    public static b2CastOutput b2ShapeCastCapsule(ConstB2Capsule shape, ConstB2ShapeCastInput input, b2CastOutput __result) {
        checkPointers(shape, input, __result);
        nb2ShapeCastCapsule(shape.address(), input.address(), __result.address());
        return __result;
    }
    /* {@code B2_API b2CastOutput b2ShapeCastCapsule( const b2Capsule* shape, const b2ShapeCastInput* input); } */
    public static native void nb2ShapeCastCapsule(long shape, long input, long __result);

    // --- [ b2ShapeCastSegment ] ---

    /**
     * {@code B2_API b2CastOutput b2ShapeCastSegment( const b2Segment* shape, const b2ShapeCastInput* input ); }
     *
     * @param shape b2Segment
     * @param input b2ShapeCastInput
     * @param __result store
     * 
     * @return b2CastOutput
     */
    public static b2CastOutput b2ShapeCastSegment(ConstB2Segment shape, ConstB2ShapeCastInput input, b2CastOutput __result) {
        checkPointers(shape, input, __result);
        nb2ShapeCastSegment(shape.address(), input.address(), __result.address());
        return __result;
    }
    /* {@code B2_API b2CastOutput b2ShapeCastSegment( const b2Segment* shape, const b2ShapeCastInput* input ); } */
    public static native void nb2ShapeCastSegment(long shape, long input, long __result);

    // --- [ b2ShapeCastPolygon ] ---

    /**
     * {@code B2_API b2CastOutput b2ShapeCastPolygon( const b2Polygon* shape, const b2ShapeCastInput* input ); }
     *
     * @param shape b2Polygon
     * @param input b2ShapeCastInput
     * @param __result store
     * 
     * @return b2CastOutput
     */
    public static b2CastOutput b2ShapeCastPolygon(ConstB2Polygon shape, ConstB2ShapeCastInput input, b2CastOutput __result) {
        checkPointers(shape, input, __result);
        nb2ShapeCastPolygon(shape.address(), input.address(), __result.address());
        return __result;
    }
    /* {@code B2_API b2CastOutput b2ShapeCastPolygon( const b2Polygon* shape, const b2ShapeCastInput* input ); } */
    public static native void nb2ShapeCastPolygon(long shape, long input, long __result);
    
    // --- [ b2ComputeHull ] ---

    /**
     * {@code B2_API b2Hull b2ComputeHull( const b2Vec2* points, int count ); }
     *
     * @param points b2Vec2.Buffer
     * @param count int
     * @param __result store
     * 
     * @return b2Hull
     */
    public static b2Hull b2ComputeHull(ConstB2Vec2.ConstBuffer points, int count, b2Hull __result) {
        checkPointers(points, __result);
        nb2ComputeHull(points.address(), count, __result.address());
        return __result;
    }
    /* {@code B2_API b2Hull b2ComputeHull( const b2Vec2* points, int count ); } */
    public static native void nb2ComputeHull(long points, int count, long __result);

    // --- [ b2ValidateHull ] ---

    /**
     * {@code B2_API bool b2ValidateHull( const b2Hull* hull ); }
     *
     * @param hull b2Hull
     * @return boolean
     */
    public static boolean b2ValidateHull(ConstB2Hull hull) {
        checkPointers(hull);
        return nb2ValidateHull(hull.address());
    }
    /* {@code B2_API bool b2ValidateHull( const b2Hull* hull ); } */
    public static native boolean nb2ValidateHull(long hull);

    // --- [ b2SegmentDistance ] ---

    /**
     * {@code B2_API b2SegmentDistanceResult b2SegmentDistance( b2Vec2 p1, b2Vec2 q1, b2Vec2 p2, b2Vec2 q2 ); }
     *
     * @param p1 b2Vec2
     * @param q1 b2Vec2
     * @param p2 b2Vec2
     * @param q2 b2Vec2
     * @param __result store
     * 
     * @return b2SegmentDistanceResult
     */
    public static b2SegmentDistanceResult b2SegmentDistance(b2Vec2 p1, b2Vec2 q1, b2Vec2 p2, b2Vec2 q2, b2SegmentDistanceResult __result) {
        checkPointers(p1, q1, p2, q2, __result);
        nb2SegmentDistance(p1.address(), q1.address(), p2.address(), q2.address(), __result.address());
        return __result;
    }
    /* {@code B2_API b2SegmentDistanceResult b2SegmentDistance( b2Vec2 p1, b2Vec2 q1, b2Vec2 p2, b2Vec2 q2 ); } */
    public static native void nb2SegmentDistance(long p1, long q1, long p2, long q2, long __result);

    // --- [ b2ShapeDistance ] ---

    /**
     * {@code B2_API b2DistanceOutput b2ShapeDistance( const b2DistanceInput* input, b2SimplexCache* cache, b2Simplex* simplexes, int simplexCapacity ); }
     *
     * @param input ConstB2DistanceInput
     * @param cache b2SimplexCache
     * @param simplexes b2Simplex
     * @param simplexCapacity int
     * @param __result store
     *
     * @return b2DistanceOutput
     */
    public static b2DistanceOutput b2ShapeDistance(ConstB2DistanceInput input, b2SimplexCache cache, b2Simplex simplexes, int simplexCapacity, b2DistanceOutput __result) {
        checkPointers(input, cache, simplexes, __result);
        nb2ShapeDistance(input.address(), cache.address(), simplexes.address(), simplexCapacity, __result.address());
        return __result;
    }

    /* {@code B2_API b2DistanceOutput b2ShapeDistance( const b2DistanceInput* input, b2SimplexCache* cache, b2Simplex* simplexes,  int simplexCapacity ); } */
    public static native void nb2ShapeDistance(long input, long cache, long simplexes, int simplexCapacity, long __result);

    // --- [ b2ShapeCast ] ---

    /**
     * {@code B2_API b2CastOutput b2ShapeCast( const b2ShapeCastPairInput* input ); }
     *
     * @param input ConstB2ShapeCastPairInput
     * @param __result store
     *
     * @return b2CastOutput
     */
    public static b2CastOutput b2ShapeCast(ConstB2ShapeCastPairInput input, b2CastOutput __result) {
        checkPointers(input, __result);
        nb2ShapeCast(input.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2CastOutput b2ShapeCast( const b2ShapeCastPairInput* input ); } */
    public static native void nb2ShapeCast(long input, long __result);


    // --- [ b2MakeProxy ] ---

    /**
     * {@code B2_API b2ShapeProxy b2MakeProxy( const b2Vec2* points, int count, float radius ); }
     *
     * @param points ConstB2Vec2
     * @param count int
     * @param radius float
     * @param __result store
     *
     * @return b2ShapeProxy
     */
    public static b2ShapeProxy b2MakeProxy(ConstB2Vec2 points, int count, float radius, b2ShapeProxy __result) {
        checkPointers(points, __result);
        nb2MakeProxy(points.address(), count, radius, __result.address());
        return __result;
    }

    /* {@code B2_API b2ShapeProxy b2MakeProxy( const b2Vec2* points, int count, float radius ); } */
    public static native void nb2MakeProxy(long points, int count, float radius, long __result);


    // --- [ b2MakeOffsetProxy ] ---

    /**
     * {@code B2_API b2ShapeProxy b2MakeOffsetProxy( const b2Vec2* points, int count, float radius, b2Vec2 position, b2Rot rotation ); }
     *
     * @param points ConstB2Vec2
     * @param count int
     * @param radius float
     * @param position b2Vec2
     * @param rotation b2Rot
     * @param __result store
     *
     * @return b2ShapeProxy
     */
    public static b2ShapeProxy b2MakeOffsetProxy(ConstB2Vec2 points, int count, float radius, b2Vec2 position, b2Rot rotation, b2ShapeProxy __result) {
        checkPointers(points, position, rotation, __result);
        nb2MakeOffsetProxy(points.address(), count, radius, position.address(), rotation.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2ShapeProxy b2MakeOffsetProxy( const b2Vec2* points, int count, float radius, b2Vec2 position, b2Rot rotation ); } */
    public static native void nb2MakeOffsetProxy(long points, int count, float radius, long position, long rotation, long __result);

    // --- [ b2GetSweepTransform ] ---

    /**
     * {@code B2_API b2Transform b2GetSweepTransform( const b2Sweep* sweep, float time ); }
     *
     * @param sweep ConstB2Sweep
     * @param time float
     * @param __result store
     *
     * @return b2Transform
     */
    public static b2Transform b2GetSweepTransform(ConstB2Sweep sweep, float time, b2Transform __result) {
        checkPointers(sweep, __result);
        nb2GetSweepTransform(sweep.address(), time, __result.address());
        return __result;
    }

    /* {@code B2_API b2Transform b2GetSweepTransform( const b2Sweep* sweep, float time ); } */
    public static native void nb2GetSweepTransform(long sweep, float time, long __result);

    // --- [ b2TimeOfImpact ] ---

    /**
     * {@code B2_API b2TOIOutput b2TimeOfImpact( const b2TOIInput* input ); }
     *
     * @param input ConstB2TOIInput
     * @param __result store
     *
     * @return b2TOIOutput
     */
    public static b2TOIOutput b2TimeOfImpact(ConstB2TOIInput input, b2TOIOutput __result) {
        checkPointers(input, __result);
        nb2TimeOfImpact(input.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2TOIOutput b2TimeOfImpact( const b2TOIInput* input ); } */
    public static native void nb2TimeOfImpact(long input, long __result);

    // --- [ b2CollideCircles ] ---

    /**
     * {@code B2_API b2Manifold b2CollideCircles( const b2Circle* circleA, b2Transform xfA, const b2Circle* circleB, b2Transform xfB ); }
     *
     * @param circleA ConstB2Circle
     * @param xfA b2Transform
     * @param circleB ConstB2Circle
     * @param xfB b2Transform
     * @param __result store
     *
     * @return b2Manifold
     */
    public static b2Manifold b2CollideCircles(ConstB2Circle circleA, b2Transform xfA, ConstB2Circle circleB, b2Transform xfB, b2Manifold __result) {
        checkPointers(circleA, xfA, circleB, xfB, __result);
        nb2CollideCircles(circleA.address(), xfA.address(), circleB.address(), xfB.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Manifold b2CollideCircles( const b2Circle* circleA, b2Transform xfA, const b2Circle* circleB, b2Transform xfB ); } */
    public static native void nb2CollideCircles(long circleA, long xfA, long circleB, long xfB, long __result);


    // --- [ b2CollideCapsuleAndCircle ] ---

    /**
     * {@code B2_API b2Manifold b2CollideCapsuleAndCircle( const b2Capsule* capsuleA, b2Transform xfA, const b2Circle* circleB, b2Transform xfB ); }
     *
     * @param capsuleA ConstB2Capsule
     * @param xfA b2Transform
     * @param circleB ConstB2Circle
     * @param xfB b2Transform
     * @param __result store
     *
     * @return b2Manifold
     */
    public static b2Manifold b2CollideCapsuleAndCircle(ConstB2Capsule capsuleA, b2Transform xfA, ConstB2Circle circleB, b2Transform xfB, b2Manifold __result) {
        checkPointers(capsuleA, xfA, circleB, xfB, __result);
        nb2CollideCapsuleAndCircle(capsuleA.address(), xfA.address(), circleB.address(), xfB.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Manifold b2CollideCapsuleAndCircle( const b2Capsule* capsuleA, b2Transform xfA, const b2Circle* circleB, b2Transform xfB ); } */
    public static native void nb2CollideCapsuleAndCircle(long capsuleA, long xfA, long circleB, long xfB, long __result);


    // --- [ b2CollideSegmentAndCircle ] ---

    /**
     * {@code B2_API b2Manifold b2CollideSegmentAndCircle( const b2Segment* segmentA, b2Transform xfA, const b2Circle* circleB, b2Transform xfB ); }
     *
     * @param segmentA ConstB2Segment
     * @param xfA b2Transform
     * @param circleB ConstB2Circle
     * @param xfB b2Transform
     * @param __result store
     *
     * @return b2Manifold
     */
    public static b2Manifold b2CollideSegmentAndCircle(ConstB2Segment segmentA, b2Transform xfA, ConstB2Circle circleB, b2Transform xfB, b2Manifold __result) {
        checkPointers(segmentA, xfA, circleB, xfB, __result);
        nb2CollideSegmentAndCircle(segmentA.address(), xfA.address(), circleB.address(), xfB.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Manifold b2CollideSegmentAndCircle( const b2Segment* segmentA, b2Transform xfA, const b2Circle* circleB,  b2Transform xfB ); } */
    public static native void nb2CollideSegmentAndCircle(long segmentA, long xfA, long circleB, long xfB, long __result);


    // --- [ b2CollidePolygonAndCircle ] ---

    /**
     * {@code B2_API b2Manifold b2CollidePolygonAndCircle( const b2Polygon* polygonA, b2Transform xfA, const b2Circle* circleB, b2Transform xfB ); }
     *
     * @param polygonA ConstB2Polygon
     * @param xfA b2Transform
     * @param circleB ConstB2Circle
     * @param xfB b2Transform
     * @param __result store
     *
     * @return b2Manifold
     */
    public static b2Manifold b2CollidePolygonAndCircle(ConstB2Polygon polygonA, b2Transform xfA, ConstB2Circle circleB, b2Transform xfB, b2Manifold __result) {
        checkPointers(polygonA, xfA, circleB, xfB, __result);
        nb2CollidePolygonAndCircle(polygonA.address(), xfA.address(), circleB.address(), xfB.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Manifold b2CollidePolygonAndCircle( const b2Polygon* polygonA, b2Transform xfA, const b2Circle* circleB, b2Transform xfB ); } */
    public static native void nb2CollidePolygonAndCircle(long polygonA, long xfA, long circleB, long xfB, long __result);


    // --- [ b2CollideCapsules ] ---

    /**
     * {@code B2_API b2Manifold b2CollideCapsules( const b2Capsule* capsuleA, b2Transform xfA, const b2Capsule* capsuleB, b2Transform xfB ); }
     *
     * @param capsuleA ConstB2Capsule
     * @param xfA b2Transform
     * @param capsuleB ConstB2Capsule
     * @param xfB b2Transform
     * @param __result store
     *
     * @return b2Manifold
     */
    public static b2Manifold b2CollideCapsules(ConstB2Capsule capsuleA, b2Transform xfA, ConstB2Capsule capsuleB, b2Transform xfB, b2Manifold __result) {
        checkPointers(capsuleA, xfA, capsuleB, xfB, __result);
        nb2CollideCapsules(capsuleA.address(), xfA.address(), capsuleB.address(), xfB.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Manifold b2CollideCapsules( const b2Capsule* capsuleA, b2Transform xfA, const b2Capsule* capsuleB, b2Transform xfB ); } */
    public static native void nb2CollideCapsules(long capsuleA, long xfA, long capsuleB, long xfB, long __result);


    // --- [ b2CollideSegmentAndCapsule ] ---

    /**
     * {@code B2_API b2Manifold b2CollideSegmentAndCapsule( const b2Segment* segmentA, b2Transform xfA, const b2Capsule* capsuleB,  b2Transform xfB ); }
     *
     * @param segmentA ConstB2Segment
     * @param xfA b2Transform
     * @param capsuleB ConstB2Capsule
     * @param xfB b2Transform
     * @param __result store
     *
     * @return b2Manifold
     */
    public static b2Manifold b2CollideSegmentAndCapsule(ConstB2Segment segmentA, b2Transform xfA, ConstB2Capsule capsuleB, b2Transform xfB, b2Manifold __result) {
        checkPointers(segmentA, xfA, capsuleB, xfB, __result);
        nb2CollideSegmentAndCapsule(segmentA.address(), xfA.address(), capsuleB.address(), xfB.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Manifold b2CollideSegmentAndCapsule( const b2Segment* segmentA, b2Transform xfA, const b2Capsule* capsuleB,  b2Transform xfB ); } */
    public static native void nb2CollideSegmentAndCapsule(long segmentA, long xfA, long capsuleB, long xfB, long __result);

    // --- [ b2CollidePolygonAndCapsule ] ---

    /**
     * {@code B2_API b2Manifold b2CollidePolygonAndCapsule( const b2Polygon* polygonA, b2Transform xfA, const b2Capsule* capsuleB, b2Transform xfB ); }
     *
     * @param polygonA ConstB2Polygon
     * @param xfA b2Transform
     * @param capsuleB ConstB2Capsule
     * @param xfB b2Transform
     * @param __result store
     *
     * @return b2Manifold
     */
    public static b2Manifold b2CollidePolygonAndCapsule(ConstB2Polygon polygonA, b2Transform xfA, ConstB2Capsule capsuleB, b2Transform xfB, b2Manifold __result) {
        checkPointers(polygonA, xfA, capsuleB, xfB, __result);
        nb2CollidePolygonAndCapsule(polygonA.address(), xfA.address(), capsuleB.address(), xfB.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Manifold b2CollidePolygonAndCapsule( const b2Polygon* polygonA, b2Transform xfA, const b2Capsule* capsuleB,
     *                                                      b2Transform xfB ); } */
    public static native void nb2CollidePolygonAndCapsule(long polygonA, long xfA, long capsuleB, long xfB, long __result);


    // --- [ b2CollidePolygons ] ---

    /**
     * {@code B2_API b2Manifold b2CollidePolygons( const b2Polygon* polygonA, b2Transform xfA, const b2Polygon* polygonB, b2Transform xfB ); }
     *
     * @param polygonA ConstB2Polygon
     * @param xfA b2Transform
     * @param polygonB ConstB2Polygon
     * @param xfB b2Transform
     * @param __result store
     *
     * @return b2Manifold
     */
    public static b2Manifold b2CollidePolygons(ConstB2Polygon polygonA, b2Transform xfA, ConstB2Polygon polygonB, b2Transform xfB, b2Manifold __result) {
        checkPointers(polygonA, xfA, polygonB, xfB, __result);
        nb2CollidePolygons(polygonA.address(), xfA.address(), polygonB.address(), xfB.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Manifold b2CollidePolygons( const b2Polygon* polygonA, b2Transform xfA, const b2Polygon* polygonB, b2Transform xfB ); } */
    public static native void nb2CollidePolygons(long polygonA, long xfA, long polygonB, long xfB, long __result);


    // --- [ b2CollideSegmentAndPolygon ] ---

    /**
     * {@code B2_API b2Manifold b2CollideSegmentAndPolygon( const b2Segment* segmentA, b2Transform xfA, const b2Polygon* polygonB, b2Transform xfB ); }
     *
     * @param segmentA ConstB2Segment
     * @param xfA b2Transform
     * @param polygonB ConstB2Polygon
     * @param xfB b2Transform
     * @param __result store
     *
     * @return b2Manifold
     */
    public static b2Manifold b2CollideSegmentAndPolygon(ConstB2Segment segmentA, b2Transform xfA, ConstB2Polygon polygonB, b2Transform xfB, b2Manifold __result) {
        checkPointers(segmentA, xfA, polygonB, xfB, __result);
        nb2CollideSegmentAndPolygon(segmentA.address(), xfA.address(), polygonB.address(), xfB.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Manifold b2CollideSegmentAndPolygon( const b2Segment* segmentA, b2Transform xfA, const b2Polygon* polygonB, b2Transform xfB ); } */
    public static native void nb2CollideSegmentAndPolygon(long segmentA, long xfA, long polygonB, long xfB, long __result);


    // --- [ b2CollideChainSegmentAndCircle ] ---

    /**
     * {@code B2_API b2Manifold b2CollideChainSegmentAndCircle( const b2ChainSegment* segmentA, b2Transform xfA, const b2Circle* circleB, b2Transform xfB ); }
     *
     * @param segmentA ConstB2ChainSegment
     * @param xfA b2Transform
     * @param circleB ConstB2Circle
     * @param xfB b2Transform
     * @param __result store
     *
     * @return b2Manifold
     */
    public static b2Manifold b2CollideChainSegmentAndCircle(ConstB2ChainSegment segmentA, b2Transform xfA, ConstB2Circle circleB, b2Transform xfB, b2Manifold __result) {
        checkPointers(segmentA, xfA, circleB, xfB, __result);
        nb2CollideChainSegmentAndCircle(segmentA.address(), xfA.address(), circleB.address(), xfB.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Manifold b2CollideChainSegmentAndCircle( const b2ChainSegment* segmentA, b2Transform xfA, const b2Circle* circleB,
     *                                                          b2Transform xfB ); } */
    public static native void nb2CollideChainSegmentAndCircle(long segmentA, long xfA, long circleB, long xfB, long __result);


    // --- [ b2CollideChainSegmentAndCapsule ] ---

    /**
     * {@code B2_API b2Manifold b2CollideChainSegmentAndCapsule( const b2ChainSegment* segmentA, b2Transform xfA, const b2Capsule* capsuleB,  b2Transform xfB, b2SimplexCache* cache ); }
     *
     * @param segmentA ConstB2ChainSegment
     * @param xfA b2Transform
     * @param capsuleB ConstB2Capsule
     * @param xfB b2Transform
     * @param cache b2SimplexCache
     * @param __result store
     *
     * @return b2Manifold
     */
    public static b2Manifold b2CollideChainSegmentAndCapsule(ConstB2ChainSegment segmentA, b2Transform xfA, ConstB2Capsule capsuleB, b2Transform xfB, b2SimplexCache cache, b2Manifold __result) {
        checkPointers(segmentA, xfA, capsuleB, xfB, cache, __result);
        nb2CollideChainSegmentAndCapsule(segmentA.address(), xfA.address(), capsuleB.address(), xfB.address(), cache.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Manifold b2CollideChainSegmentAndCapsule( const b2ChainSegment* segmentA, b2Transform xfA, const b2Capsule* capsuleB,  b2Transform xfB, b2SimplexCache* cache ); } */
    public static native void nb2CollideChainSegmentAndCapsule(long segmentA, long xfA, long capsuleB, long xfB, long cache, long __result);


    // --- [ b2CollideChainSegmentAndPolygon ] ---

    /**
     * {@code B2_API b2Manifold b2CollideChainSegmentAndPolygon( const b2ChainSegment* segmentA, b2Transform xfA, const b2Polygon* polygonB, b2Transform xfB, b2SimplexCache* cache ); }
     *
     * @param segmentA ConstB2ChainSegment
     * @param xfA b2Transform
     * @param polygonB ConstB2Polygon
     * @param xfB b2Transform
     * @param cache b2SimplexCache
     * @param __result store
     *
     * @return b2Manifold
     */
    public static b2Manifold b2CollideChainSegmentAndPolygon(ConstB2ChainSegment segmentA, b2Transform xfA, ConstB2Polygon polygonB, b2Transform xfB, b2SimplexCache cache, b2Manifold __result) {
        checkPointers(segmentA, xfA, polygonB, xfB, cache, __result);
        nb2CollideChainSegmentAndPolygon(segmentA.address(), xfA.address(), polygonB.address(), xfB.address(), cache.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Manifold b2CollideChainSegmentAndPolygon( const b2ChainSegment* segmentA, b2Transform xfA, const b2Polygon* polygonB, b2Transform xfB, b2SimplexCache* cache ); } */
    public static native void nb2CollideChainSegmentAndPolygon(long segmentA, long xfA, long polygonB, long xfB, long cache, long __result);
}
