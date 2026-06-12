/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.include;

import org.box2d.jni.b2AABB;
import org.box2d.jni.b2CastOutput;
import org.box2d.jni.b2Hull;
import org.box2d.jni.b2MassData;
import org.box2d.jni.b2Polygon;
import org.box2d.jni.b2Rot;
import org.box2d.jni.b2Transform;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.readonly.ConstB2Capsule;
import org.box2d.jni.readonly.ConstB2Circle;
import org.box2d.jni.readonly.ConstB2Hull;
import org.box2d.jni.readonly.ConstB2Polygon;
import org.box2d.jni.readonly.ConstB2RayCastInput;
import org.box2d.jni.readonly.ConstB2Segment;
import org.box2d.jni.readonly.ConstB2ShapeCastInput;
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
}
