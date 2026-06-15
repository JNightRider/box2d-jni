/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.include;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import org.box2d.jni.b2AABB;
import org.box2d.jni.b2BodyEvents;
import org.box2d.jni.b2BodyId;
import org.box2d.jni.b2BodyType;
import org.box2d.jni.b2Capacity;
import org.box2d.jni.b2Capsule;
import org.box2d.jni.b2CastOutput;
import org.box2d.jni.b2CastResultFcnI;
import org.box2d.jni.b2ChainId;
import org.box2d.jni.b2ChainSegment;
import org.box2d.jni.b2Circle;
import org.box2d.jni.b2ContactData;
import org.box2d.jni.b2ContactEvents;
import org.box2d.jni.b2ContactId;
import org.box2d.jni.b2Counters;
import org.box2d.jni.b2CustomFilterFcnI;
import org.box2d.jni.b2DebugDraw;
import org.box2d.jni.b2Filter;
import org.box2d.jni.b2FrictionCallbackI;
import org.box2d.jni.b2JointEvents;
import org.box2d.jni.b2JointId;
import org.box2d.jni.b2JointType;
import org.box2d.jni.b2MassData;
import org.box2d.jni.b2MotionLocks;
import org.box2d.jni.b2OverlapResultFcnI;
import org.box2d.jni.b2PlaneResultFcnI;
import org.box2d.jni.b2Polygon;
import org.box2d.jni.b2PreSolveFcnI;
import org.box2d.jni.b2Profile;
import org.box2d.jni.b2QueryFilter;
import org.box2d.jni.b2RayResult;
import org.box2d.jni.b2RecPlayer;
import org.box2d.jni.b2RecPlayerInfo;
import org.box2d.jni.b2RecQueryHit;
import org.box2d.jni.b2RecQueryInfo;
import org.box2d.jni.b2Recording;
import org.box2d.jni.b2RestitutionCallbackI;
import org.box2d.jni.b2Rot;
import org.box2d.jni.b2Segment;
import org.box2d.jni.b2SensorEvents;
import org.box2d.jni.b2ShapeId;
import org.box2d.jni.b2ShapeType;
import org.box2d.jni.b2SurfaceMaterial;
import org.box2d.jni.b2Transform;
import org.box2d.jni.b2TreeStats;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.b2WorldId;

import org.box2d.jni.readonly.ConstB2BodyDef;
import org.box2d.jni.readonly.ConstB2Capsule;
import org.box2d.jni.readonly.ConstB2ChainDef;
import org.box2d.jni.readonly.ConstB2ChainSegment;
import org.box2d.jni.readonly.ConstB2Circle;
import org.box2d.jni.readonly.ConstB2DistanceJointDef;
import org.box2d.jni.readonly.ConstB2ExplosionDef;
import org.box2d.jni.readonly.ConstB2FilterJointDef;
import org.box2d.jni.readonly.ConstB2MotorJointDef;
import org.box2d.jni.readonly.ConstB2Polygon;
import org.box2d.jni.readonly.ConstB2PrismaticJointDef;
import org.box2d.jni.readonly.ConstB2RayCastInput;
import org.box2d.jni.readonly.ConstB2RecPlayer;
import org.box2d.jni.readonly.ConstB2Recording;
import org.box2d.jni.readonly.ConstB2RevoluteJointDef;
import org.box2d.jni.readonly.ConstB2Segment;
import org.box2d.jni.readonly.ConstB2ShapeDef;
import org.box2d.jni.readonly.ConstB2ShapeProxy;
import org.box2d.jni.readonly.ConstB2SurfaceMaterial;
import org.box2d.jni.readonly.ConstB2WeldJointDef;
import org.box2d.jni.readonly.ConstB2WheelJointDef;
import org.box2d.jni.readonly.ConstB2WorldDef;

import org.box2d.jni.system.Library;
import static org.box2d.jni.system.Checks.*;

/**
 *
 * @author wil
 */
public final class Box2d {
    static { Library.initialize(); }
    
    // --- [ b2CreateWorld ] ---

    /**
     * {@code B2_API b2WorldId b2CreateWorld( const b2WorldDef* def ); }
     *
     * @param def ConstB2WorldDef
     * @param __result store
     *
     * @return b2WorldId
     */
    public static b2WorldId b2CreateWorld(ConstB2WorldDef def, b2WorldId __result) {
        checkPointers(def, __result);
        nb2CreateWorld(def.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2WorldId b2CreateWorld( const b2WorldDef* def ); } */
    public static native void nb2CreateWorld(long def, long __result);


    // --- [ b2DestroyWorld ] ---

    /**
     * {@code B2_API void b2DestroyWorld( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     */
    public static void b2DestroyWorld(b2WorldId worldId) {
        checkPointers(worldId);
        nb2DestroyWorld(worldId.address());
    }

    /* {@code B2_API void b2DestroyWorld( b2WorldId worldId ); } */
    public static native void nb2DestroyWorld(long worldId);


    // --- [ b2World_IsValid ] ---

    /**
     * {@code B2_API bool b2World_IsValid( b2WorldId id ); }
     *
     * @param id b2WorldId
     *
     * @return boolean
     */
    public static boolean b2World_IsValid(b2WorldId id) {
        checkPointers(id);
        return nb2World_IsValid(id.address());
    }

    /* {@code B2_API bool b2World_IsValid( b2WorldId id ); } */
    public static native boolean nb2World_IsValid(long id);
    
    // --- [ b2World_Step ] ---

    /**
     * {@code B2_API void b2World_Step( b2WorldId worldId, float timeStep, int subStepCount ); }
     *
     * @param worldId b2WorldId
     * @param timeStep float
     * @param subStepCount int
     */
    public static void b2World_Step(b2WorldId worldId, float timeStep, int subStepCount) {
        checkPointers(worldId);
        nb2World_Step(worldId.address(), timeStep, subStepCount);
    }

    /* {@code B2_API void b2World_Step( b2WorldId worldId, float timeStep, int subStepCount ); } */
    public static native void nb2World_Step(long worldId, float timeStep, int subStepCount);


    // --- [ b2World_Draw ] ---

    /**
     * {@code B2_API void b2World_Draw( b2WorldId worldId, b2DebugDraw* draw ); }
     *
     * @param worldId b2WorldId
     * @param draw b2DebugDraw
     */
    public static void b2World_Draw(b2WorldId worldId, b2DebugDraw draw) {
        checkPointers(worldId, draw);
        nb2World_Draw(worldId.address(), draw.address());
    }

    /* {@code B2_API void b2World_Draw( b2WorldId worldId, b2DebugDraw* draw ); } */
    public static native void nb2World_Draw(long worldId, long draw);


    // --- [ b2World_GetBounds ] ---

    /**
     * {@code B2_API b2AABB b2World_GetBounds( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     * @param __result store
     *
     * @return b2AABB
     */
    public static b2AABB b2World_GetBounds(b2WorldId worldId, b2AABB __result) {
        checkPointers(worldId, __result);
        nb2World_GetBounds(worldId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2AABB b2World_GetBounds( b2WorldId worldId ); } */
    public static native void nb2World_GetBounds(long worldId, long __result);


    // --- [ b2World_GetBodyEvents ] ---

    /**
     * {@code B2_API b2BodyEvents b2World_GetBodyEvents( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     * @param __result store
     *
     * @return b2BodyEvents
     */
    public static b2BodyEvents b2World_GetBodyEvents(b2WorldId worldId, b2BodyEvents __result) {
        checkPointers(worldId, __result);
        nb2World_GetBodyEvents(worldId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2BodyEvents b2World_GetBodyEvents( b2WorldId worldId ); } */
    public static native void nb2World_GetBodyEvents(long worldId, long __result);


    // --- [ b2World_GetSensorEvents ] ---

    /**
     * {@code B2_API b2SensorEvents b2World_GetSensorEvents( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     * @param __result store
     *
     * @return b2SensorEvents
     */
    public static b2SensorEvents b2World_GetSensorEvents(b2WorldId worldId, b2SensorEvents __result) {
        checkPointers(worldId, __result);
        nb2World_GetSensorEvents(worldId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2SensorEvents b2World_GetSensorEvents( b2WorldId worldId ); } */
    public static native void nb2World_GetSensorEvents(long worldId, long __result);


    // --- [ b2World_GetContactEvents ] ---

    /**
     * {@code B2_API b2ContactEvents b2World_GetContactEvents( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     * @param __result store
     *
     * @return b2ContactEvents
     */
    public static b2ContactEvents b2World_GetContactEvents(b2WorldId worldId, b2ContactEvents __result) {
        checkPointers(worldId, __result);
        nb2World_GetContactEvents(worldId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2ContactEvents b2World_GetContactEvents( b2WorldId worldId ); } */
    public static native void nb2World_GetContactEvents(long worldId, long __result);


    // --- [ b2World_GetJointEvents ] ---

    /**
     * {@code B2_API b2JointEvents b2World_GetJointEvents( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     * @param __result store
     *
     * @return b2JointEvents
     */
    public static b2JointEvents b2World_GetJointEvents(b2WorldId worldId, b2JointEvents __result) {
        checkPointers(worldId, __result);
        nb2World_GetJointEvents(worldId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2JointEvents b2World_GetJointEvents( b2WorldId worldId ); } */
    public static native void nb2World_GetJointEvents(long worldId, long __result);
 
    // --- [ b2World_OverlapAABB ] ---

    /**
     * {@code B2_API b2TreeStats b2World_OverlapAABB( b2WorldId worldId, b2AABB aabb, b2QueryFilter filter, b2OverlapResultFcn* fcn, void* context ); }
     *
     * @param worldId b2WorldId
     * @param aabb b2AABB
     * @param filter b2QueryFilter
     * @param fcn long
     * @param context long
     * @param __result store
     *
     * @return b2TreeStats
     */
    public static b2TreeStats b2World_OverlapAABB(b2WorldId worldId, b2AABB aabb, b2QueryFilter filter, b2OverlapResultFcnI fcn, long context, b2TreeStats __result) {
        checkPointers(worldId, aabb, filter, fcn, __result);
        nb2World_OverlapAABB(worldId.address(), aabb.address(), filter.address(), fcn.address(), context, __result.address());
        return __result;
    }

    /* {@code B2_API b2TreeStats b2World_OverlapAABB( b2WorldId worldId, b2AABB aabb, b2QueryFilter filter, b2OverlapResultFcn* fcn, void* context ); } */
    public static native void nb2World_OverlapAABB(long worldId, long aabb, long filter, long fcn, long context, long __result);


    // --- [ b2World_OverlapShape ] ---

    /**
     * {@code B2_API b2TreeStats b2World_OverlapShape( b2WorldId worldId, const b2ShapeProxy* proxy, b2QueryFilter filter, b2OverlapResultFcn* fcn, void* context ); }
     *
     * @param worldId b2WorldId
     * @param proxy ConstB2ShapeProxy
     * @param filter b2QueryFilter
     * @param fcn long
     * @param context long
     * @param __result store
     *
     * @return b2TreeStats
     */
    public static b2TreeStats b2World_OverlapShape(b2WorldId worldId, ConstB2ShapeProxy proxy, b2QueryFilter filter, b2OverlapResultFcnI fcn, long context, b2TreeStats __result) {
        checkPointers(worldId, proxy, filter, fcn, __result);
        nb2World_OverlapShape(worldId.address(), proxy.address(), filter.address(), fcn.address(), context, __result.address());
        return __result;
    }

    /* {@code B2_API b2TreeStats b2World_OverlapShape( b2WorldId worldId, const b2ShapeProxy* proxy, b2QueryFilter filter, b2OverlapResultFcn* fcn, void* context ); } */
    public static native void nb2World_OverlapShape(long worldId, long proxy, long filter, long fcn, long context, long __result);

    // --- [ b2World_CastRay ] ---

    /**
     * {@code B2_API b2TreeStats b2World_CastRay( b2WorldId worldId, b2Vec2 origin, b2Vec2 translation, b2QueryFilter filter, b2CastResultFcn* fcn, void* context ); }
     *
     * @param worldId b2WorldId
     * @param origin b2Vec2
     * @param translation b2Vec2
     * @param filter b2QueryFilter
     * @param fcn long
     * @param context long
     * @param __result store
     *
     * @return b2TreeStats
     */
    public static b2TreeStats b2World_CastRay(b2WorldId worldId, b2Vec2 origin, b2Vec2 translation, b2QueryFilter filter, b2CastResultFcnI fcn, long context, b2TreeStats __result) {
        checkPointers(worldId, origin, translation, filter, fcn, __result);
        nb2World_CastRay(worldId.address(), origin.address(), translation.address(), filter.address(), fcn.address(), context, __result.address());
        return __result;
    }

    /* {@code B2_API b2TreeStats b2World_CastRay( b2WorldId worldId, b2Vec2 origin, b2Vec2 translation, b2QueryFilter filter, b2CastResultFcn* fcn, void* context ); } */
    public static native void nb2World_CastRay(long worldId, long origin, long translation, long filter, long fcn, long context, long __result);


    // --- [ b2World_CastRayClosest ] ---

    /**
     * {@code B2_API b2RayResult b2World_CastRayClosest( b2WorldId worldId, b2Vec2 origin, b2Vec2 translation, b2QueryFilter filter ); }
     *
     * @param worldId b2WorldId
     * @param origin b2Vec2
     * @param translation b2Vec2
     * @param filter b2QueryFilter
     * @param __result store
     *
     * @return b2RayResult
     */
    public static b2RayResult b2World_CastRayClosest(b2WorldId worldId, b2Vec2 origin, b2Vec2 translation, b2QueryFilter filter, b2RayResult __result) {
        checkPointers(worldId, origin, translation, filter, __result);
        nb2World_CastRayClosest(worldId.address(), origin.address(), translation.address(), filter.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2RayResult b2World_CastRayClosest( b2WorldId worldId, b2Vec2 origin, b2Vec2 translation, b2QueryFilter filter ); } */
    public static native void nb2World_CastRayClosest(long worldId, long origin, long translation, long filter, long __result);


    // --- [ b2World_CastShape ] ---

    /**
     * {@code B2_API b2TreeStats b2World_CastShape( b2WorldId worldId, const b2ShapeProxy* proxy, b2Vec2 translation, b2QueryFilter filter,  b2CastResultFcn* fcn, void* context ); }
     *
     * @param worldId b2WorldId
     * @param proxy ConstB2ShapeProxy
     * @param translation b2Vec2
     * @param filter b2QueryFilter
     * @param fcn long
     * @param context long
     * @param __result store
     *
     * @return b2TreeStats
     */
    public static b2TreeStats b2World_CastShape(b2WorldId worldId, ConstB2ShapeProxy proxy, b2Vec2 translation, b2QueryFilter filter, b2CastResultFcnI fcn, long context, b2TreeStats __result) {
        checkPointers(worldId, proxy, translation, filter, fcn, __result);
        nb2World_CastShape(worldId.address(), proxy.address(), translation.address(), filter.address(), fcn.address(), context, __result.address());
        return __result;
    }

    /* {@code B2_API b2TreeStats b2World_CastShape( b2WorldId worldId, const b2ShapeProxy* proxy, b2Vec2 translation, b2QueryFilter filter, b2CastResultFcn* fcn, void* context ); } */
    public static native void nb2World_CastShape(long worldId, long proxy, long translation, long filter, long fcn, long context, long __result);

    // --- [ b2World_CastMover ] ---

    /**
     * {@code B2_API float b2World_CastMover( b2WorldId worldId, const b2Capsule* mover, b2Vec2 translation, b2QueryFilter filter ); }
     *
     * @param worldId b2WorldId
     * @param mover ConstB2Capsule
     * @param translation b2Vec2
     * @param filter b2QueryFilter
     *
     * @return float
     */
    public static float b2World_CastMover(b2WorldId worldId, ConstB2Capsule mover, b2Vec2 translation, b2QueryFilter filter) {
        checkPointers(worldId, mover, translation, filter);
        return nb2World_CastMover(worldId.address(), mover.address(), translation.address(), filter.address());
    }

    /* {@code B2_API float b2World_CastMover( b2WorldId worldId, const b2Capsule* mover, b2Vec2 translation, b2QueryFilter filter ); } */
    public static native float nb2World_CastMover(long worldId, long mover, long translation, long filter);

    // --- [ b2World_CollideMover ] ---

    /**
     * {@code B2_API void b2World_CollideMover( b2WorldId worldId, const b2Capsule* mover, b2QueryFilter filter, b2PlaneResultFcn* fcn, void* context ); }
     *
     * @param worldId b2WorldId
     * @param mover ConstB2Capsule
     * @param filter b2QueryFilter
     * @param fcn long
     * @param context long
     */
    public static void b2World_CollideMover(b2WorldId worldId, ConstB2Capsule mover, b2QueryFilter filter, b2PlaneResultFcnI fcn, long context) {
        checkPointers(worldId, mover, filter, fcn);
        nb2World_CollideMover(worldId.address(), mover.address(), filter.address(), fcn.address(), context);
    }

    /* {@code B2_API void b2World_CollideMover( b2WorldId worldId, const b2Capsule* mover, b2QueryFilter filter, b2PlaneResultFcn* fcn,
     *                                          void* context ); } */
    public static native void nb2World_CollideMover(long worldId, long mover, long filter, long fcn, long context);

    // --- [ b2World_EnableSleeping ] ---

    /**
     * {@code B2_API void b2World_EnableSleeping( b2WorldId worldId, bool flag ); }
     *
     * @param worldId b2WorldId
     * @param flag boolean
     */
    public static void b2World_EnableSleeping(b2WorldId worldId, boolean flag) {
        checkPointers(worldId);
        nb2World_EnableSleeping(worldId.address(), flag);
    }

    /* {@code B2_API void b2World_EnableSleeping( b2WorldId worldId, bool flag ); } */
    public static native void nb2World_EnableSleeping(long worldId, boolean flag);

    // --- [ b2World_IsSleepingEnabled ] ---

    /**
     * {@code B2_API bool b2World_IsSleepingEnabled( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     *
     * @return boolean
     */
    public static boolean b2World_IsSleepingEnabled(b2WorldId worldId) {
        checkPointers(worldId);
        return nb2World_IsSleepingEnabled(worldId.address());
    }

    /* {@code B2_API bool b2World_IsSleepingEnabled( b2WorldId worldId ); } */
    public static native boolean nb2World_IsSleepingEnabled(long worldId);

    // --- [ b2World_EnableContinuous ] ---

    /**
     * {@code B2_API void b2World_EnableContinuous( b2WorldId worldId, bool flag ); }
     *
     * @param worldId b2WorldId
     * @param flag boolean
     */
    public static void b2World_EnableContinuous(b2WorldId worldId, boolean flag) {
        checkPointers(worldId);
        nb2World_EnableContinuous(worldId.address(), flag);
    }

    /* {@code B2_API void b2World_EnableContinuous( b2WorldId worldId, bool flag ); } */
    public static native void nb2World_EnableContinuous(long worldId, boolean flag);

    // --- [ b2World_IsContinuousEnabled ] ---

    /**
     * {@code B2_API bool b2World_IsContinuousEnabled( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     *
     * @return boolean
     */
    public static boolean b2World_IsContinuousEnabled(b2WorldId worldId) {
        checkPointers(worldId);
        return nb2World_IsContinuousEnabled(worldId.address());
    }

    /* {@code B2_API bool b2World_IsContinuousEnabled( b2WorldId worldId ); } */
    public static native boolean nb2World_IsContinuousEnabled(long worldId);

    // --- [ b2World_SetRestitutionThreshold ] ---

    /**
     * {@code B2_API void b2World_SetRestitutionThreshold( b2WorldId worldId, float value ); }
     *
     * @param worldId b2WorldId
     * @param value float
     */
    public static void b2World_SetRestitutionThreshold(b2WorldId worldId, float value) {
        checkPointers(worldId);
        nb2World_SetRestitutionThreshold(worldId.address(), value);
    }

    /* {@code B2_API void b2World_SetRestitutionThreshold( b2WorldId worldId, float value ); } */
    public static native void nb2World_SetRestitutionThreshold(long worldId, float value);

    // --- [ b2World_GetRestitutionThreshold ] ---

    /**
     * {@code B2_API float b2World_GetRestitutionThreshold( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     *
     * @return float
     */
    public static float b2World_GetRestitutionThreshold(b2WorldId worldId) {
        checkPointers(worldId);
        return nb2World_GetRestitutionThreshold(worldId.address());
    }

    /* {@code B2_API float b2World_GetRestitutionThreshold( b2WorldId worldId ); } */
    public static native float nb2World_GetRestitutionThreshold(long worldId);

    // --- [ b2World_SetHitEventThreshold ] ---

    /**
     * {@code B2_API void b2World_SetHitEventThreshold( b2WorldId worldId, float value ); }
     *
     * @param worldId b2WorldId
     * @param value float
     */
    public static void b2World_SetHitEventThreshold(b2WorldId worldId, float value) {
        checkPointers(worldId);
        nb2World_SetHitEventThreshold(worldId.address(), value);
    }

    /* {@code B2_API void b2World_SetHitEventThreshold( b2WorldId worldId, float value ); } */
    public static native void nb2World_SetHitEventThreshold(long worldId, float value);

    // --- [ b2World_GetHitEventThreshold ] ---

    /**
     * {@code B2_API float b2World_GetHitEventThreshold( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     *
     * @return float
     */
    public static float b2World_GetHitEventThreshold(b2WorldId worldId) {
        checkPointers(worldId);
        return nb2World_GetHitEventThreshold(worldId.address());
    }

    /* {@code B2_API float b2World_GetHitEventThreshold( b2WorldId worldId ); } */
    public static native float nb2World_GetHitEventThreshold(long worldId);

    // --- [ b2World_SetCustomFilterCallback ] ---

    /**
     * {@code B2_API void b2World_SetCustomFilterCallback( b2WorldId worldId, b2CustomFilterFcn* fcn, void* context ); }
     *
     * @param worldId b2WorldId
     * @param fcn long
     * @param context long
     */
    public static void b2World_SetCustomFilterCallback(b2WorldId worldId, b2CustomFilterFcnI fcn, long context) {
        checkPointers(worldId, fcn);
        nb2World_SetCustomFilterCallback(worldId.address(), fcn.address(), context);
    }

    /* {@code B2_API void b2World_SetCustomFilterCallback( b2WorldId worldId, b2CustomFilterFcn* fcn, void* context ); } */
    public static native void nb2World_SetCustomFilterCallback(long worldId, long fcn, long context);


    // --- [ b2World_SetPreSolveCallback ] ---

    /**
     * {@code B2_API void b2World_SetPreSolveCallback( b2WorldId worldId, b2PreSolveFcn* fcn, void* context ); }
     *
     * @param worldId b2WorldId
     * @param fcn long
     * @param context long
     */
    public static void b2World_SetPreSolveCallback(b2WorldId worldId, b2PreSolveFcnI fcn, long context) {
        checkPointers(worldId, fcn);
        nb2World_SetPreSolveCallback(worldId.address(), fcn.address(), context);
    }

    /* {@code B2_API void b2World_SetPreSolveCallback( b2WorldId worldId, b2PreSolveFcn* fcn, void* context ); } */
    public static native void nb2World_SetPreSolveCallback(long worldId, long fcn, long context);

    // --- [ b2World_SetGravity ] ---

    /**
     * {@code B2_API void b2World_SetGravity( b2WorldId worldId, b2Vec2 gravity ); }
     *
     * @param worldId b2WorldId
     * @param gravity b2Vec2
     */
    public static void b2World_SetGravity(b2WorldId worldId, b2Vec2 gravity) {
        checkPointers(worldId, gravity);
        nb2World_SetGravity(worldId.address(), gravity.address());
    }

    /* {@code B2_API void b2World_SetGravity( b2WorldId worldId, b2Vec2 gravity ); } */
    public static native void nb2World_SetGravity(long worldId, long gravity);

    // --- [ b2World_GetGravity ] ---

    /**
     * {@code B2_API b2Vec2 b2World_GetGravity( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     * @param __result store
     *
     * @return b2Vec2
     */
    public static b2Vec2 b2World_GetGravity(b2WorldId worldId, b2Vec2 __result) {
        checkPointers(worldId, __result);
        nb2World_GetGravity(worldId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Vec2 b2World_GetGravity( b2WorldId worldId ); } */
    public static native void nb2World_GetGravity(long worldId, long __result);

    // --- [ b2World_Explode ] ---

    /**
     * {@code B2_API void b2World_Explode( b2WorldId worldId, const b2ExplosionDef* explosionDef ); }
     *
     * @param worldId b2WorldId
     * @param explosionDef ConstB2ExplosionDef
     */
    public static void b2World_Explode(b2WorldId worldId, ConstB2ExplosionDef explosionDef) {
        checkPointers(worldId, explosionDef);
        nb2World_Explode(worldId.address(), explosionDef.address());
    }

    /* {@code B2_API void b2World_Explode( b2WorldId worldId, const b2ExplosionDef* explosionDef ); } */
    public static native void nb2World_Explode(long worldId, long explosionDef);

    // --- [ b2World_SetContactTuning ] ---

    /**
     * {@code B2_API void b2World_SetContactTuning( b2WorldId worldId, float hertz, float dampingRatio, float pushSpeed ); }
     *
     * @param worldId b2WorldId
     * @param hertz float
     * @param dampingRatio float
     * @param pushSpeed float
     */
    public static void b2World_SetContactTuning(b2WorldId worldId, float hertz, float dampingRatio, float pushSpeed) {
        checkPointers(worldId);
        nb2World_SetContactTuning(worldId.address(), hertz, dampingRatio, pushSpeed);
    }

    /* {@code B2_API void b2World_SetContactTuning( b2WorldId worldId, float hertz, float dampingRatio, float pushSpeed ); } */
    public static native void nb2World_SetContactTuning(long worldId, float hertz, float dampingRatio, float pushSpeed);

    // --- [ b2World_SetContactRecycleDistance ] ---

    /**
     * {@code B2_API void b2World_SetContactRecycleDistance( b2WorldId worldId, float recycleDistance ); }
     *
     * @param worldId b2WorldId
     * @param recycleDistance float
     */
    public static void b2World_SetContactRecycleDistance(b2WorldId worldId, float recycleDistance) {
        checkPointers(worldId);
        nb2World_SetContactRecycleDistance(worldId.address(), recycleDistance);
    }

    /* {@code B2_API void b2World_SetContactRecycleDistance( b2WorldId worldId, float recycleDistance ); } */
    public static native void nb2World_SetContactRecycleDistance(long worldId, float recycleDistance);

    // --- [ b2World_GetContactRecycleDistance ] ---

    /**
     * {@code B2_API float b2World_GetContactRecycleDistance( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     *
     * @return float
     */
    public static float b2World_GetContactRecycleDistance(b2WorldId worldId) {
        checkPointers(worldId);
        return nb2World_GetContactRecycleDistance(worldId.address());
    }

    /* {@code B2_API float b2World_GetContactRecycleDistance( b2WorldId worldId ); } */
    public static native float nb2World_GetContactRecycleDistance(long worldId);

    // --- [ b2World_SetMaximumLinearSpeed ] ---

    /**
     * {@code B2_API void b2World_SetMaximumLinearSpeed( b2WorldId worldId, float maximumLinearSpeed ); }
     *
     * @param worldId b2WorldId
     * @param maximumLinearSpeed float
     */
    public static void b2World_SetMaximumLinearSpeed(b2WorldId worldId, float maximumLinearSpeed) {
        checkPointers(worldId);
        nb2World_SetMaximumLinearSpeed(worldId.address(), maximumLinearSpeed);
    }

    /* {@code B2_API void b2World_SetMaximumLinearSpeed( b2WorldId worldId, float maximumLinearSpeed ); } */
    public static native void nb2World_SetMaximumLinearSpeed(long worldId, float maximumLinearSpeed);

    // --- [ b2World_GetMaximumLinearSpeed ] ---

    /**
     * {@code B2_API float b2World_GetMaximumLinearSpeed( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     *
     * @return float
     */
    public static float b2World_GetMaximumLinearSpeed(b2WorldId worldId) {
        checkPointers(worldId);
        return nb2World_GetMaximumLinearSpeed(worldId.address());
    }

    /* {@code B2_API float b2World_GetMaximumLinearSpeed( b2WorldId worldId ); } */
    public static native float nb2World_GetMaximumLinearSpeed(long worldId);

    // --- [ b2World_EnableWarmStarting ] ---

    /**
     * {@code B2_API void b2World_EnableWarmStarting( b2WorldId worldId, bool flag ); }
     *
     * @param worldId b2WorldId
     * @param flag boolean
     */
    public static void b2World_EnableWarmStarting(b2WorldId worldId, boolean flag) {
        checkPointers(worldId);
        nb2World_EnableWarmStarting(worldId.address(), flag);
    }

    /* {@code B2_API void b2World_EnableWarmStarting( b2WorldId worldId, bool flag ); } */
    public static native void nb2World_EnableWarmStarting(long worldId, boolean flag);

    // --- [ b2World_IsWarmStartingEnabled ] ---

    /**
     * {@code B2_API bool b2World_IsWarmStartingEnabled( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     *
     * @return boolean
     */
    public static boolean b2World_IsWarmStartingEnabled(b2WorldId worldId) {
        checkPointers(worldId);
        return nb2World_IsWarmStartingEnabled(worldId.address());
    }

    /* {@code B2_API bool b2World_IsWarmStartingEnabled( b2WorldId worldId ); } */
    public static native boolean nb2World_IsWarmStartingEnabled(long worldId);

    // --- [ b2World_GetAwakeBodyCount ] ---

    /**
     * {@code B2_API int b2World_GetAwakeBodyCount( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     *
     * @return int
     */
    public static int b2World_GetAwakeBodyCount(b2WorldId worldId) {
        checkPointers(worldId);
        return nb2World_GetAwakeBodyCount(worldId.address());
    }

    /* {@code B2_API int b2World_GetAwakeBodyCount( b2WorldId worldId ); } */
    public static native int nb2World_GetAwakeBodyCount(long worldId);

    // --- [ b2World_GetProfile ] ---

    /**
     * {@code B2_API b2Profile b2World_GetProfile( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     * @param __result store
     *
     * @return b2Profile
     */
    public static b2Profile b2World_GetProfile(b2WorldId worldId, b2Profile __result) {
        checkPointers(worldId, __result);
        nb2World_GetProfile(worldId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Profile b2World_GetProfile( b2WorldId worldId ); } */
    public static native void nb2World_GetProfile(long worldId, long __result);

    // --- [ b2World_GetCounters ] ---

    /**
     * {@code B2_API b2Counters b2World_GetCounters( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     * @param __result store
     *
     * @return b2Counters
     */
    public static b2Counters b2World_GetCounters(b2WorldId worldId, b2Counters __result) {
        checkPointers(worldId, __result);
        nb2World_GetCounters(worldId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Counters b2World_GetCounters( b2WorldId worldId ); } */
    public static native void nb2World_GetCounters(long worldId, long __result);

    // --- [ b2World_GetMaxCapacity ] ---

    /**
     * {@code B2_API b2Capacity b2World_GetMaxCapacity( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     * @param __result store
     *
     * @return b2Capacity
     */
    public static b2Capacity b2World_GetMaxCapacity(b2WorldId worldId, b2Capacity __result) {
        checkPointers(worldId, __result);
        nb2World_GetMaxCapacity(worldId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Capacity b2World_GetMaxCapacity( b2WorldId worldId ); } */
    public static native void nb2World_GetMaxCapacity(long worldId, long __result);

    // --- [ b2World_SetUserData ] ---

    /**
     * {@code B2_API void b2World_SetUserData( b2WorldId worldId, void* userData ); }
     *
     * @param worldId b2WorldId
     * @param userData long
     */
    public static void b2World_SetUserData(b2WorldId worldId, long userData) {
        checkPointers(worldId);
        nb2World_SetUserData(worldId.address(), userData);
    }

    /* {@code B2_API void b2World_SetUserData( b2WorldId worldId, void* userData ); } */
    public static native void nb2World_SetUserData(long worldId, long userData);

    // --- [ b2World_GetUserData ] ---

    /**
     * {@code B2_API void* b2World_GetUserData( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     *
     * @return long
     */
    public static long b2World_GetUserData(b2WorldId worldId) {
        checkPointers(worldId);
        return nb2World_GetUserData(worldId.address());
    }

    /* {@code B2_API void* b2World_GetUserData( b2WorldId worldId ); } */
    public static native long nb2World_GetUserData(long worldId);

    // --- [ b2World_SetFrictionCallback ] ---

    /**
     * {@code B2_API void b2World_SetFrictionCallback( b2WorldId worldId, b2FrictionCallback* callback ); }
     *
     * @param worldId b2WorldId
     * @param callback long
     */
    public static void b2World_SetFrictionCallback(b2WorldId worldId, b2FrictionCallbackI callback) {
        checkPointers(worldId, callback);
        nb2World_SetFrictionCallback(worldId.address(), callback.address());
    }

    /* {@code B2_API void b2World_SetFrictionCallback( b2WorldId worldId, b2FrictionCallback* callback ); } */
    public static native void nb2World_SetFrictionCallback(long worldId, long callback);

    // --- [ b2World_SetRestitutionCallback ] ---

    /**
     * {@code B2_API void b2World_SetRestitutionCallback( b2WorldId worldId, b2RestitutionCallback* callback ); }
     *
     * @param worldId b2WorldId
     * @param callback long
     */
    public static void b2World_SetRestitutionCallback(b2WorldId worldId, b2RestitutionCallbackI callback) {
        checkPointers(worldId, callback);
        nb2World_SetRestitutionCallback(worldId.address(), callback.address());
    }

    /* {@code B2_API void b2World_SetRestitutionCallback( b2WorldId worldId, b2RestitutionCallback* callback ); } */
    public static native void nb2World_SetRestitutionCallback(long worldId, long callback);

    // --- [ b2World_SetWorkerCount ] ---

    /**
     * {@code B2_API void b2World_SetWorkerCount( b2WorldId worldId, int count ); }
     *
     * @param worldId b2WorldId
     * @param count int
     */
    public static void b2World_SetWorkerCount(b2WorldId worldId, int count) {
        checkPointers(worldId);
        nb2World_SetWorkerCount(worldId.address(), count);
    }

    /* {@code B2_API void b2World_SetWorkerCount( b2WorldId worldId, int count ); } */
    public static native void nb2World_SetWorkerCount(long worldId, int count);

    // --- [ b2World_GetWorkerCount ] ---

    /**
     * {@code B2_API int b2World_GetWorkerCount( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     *
     * @return int
     */
    public static int b2World_GetWorkerCount(b2WorldId worldId) {
        checkPointers(worldId);
        return nb2World_GetWorkerCount(worldId.address());
    }

    /* {@code B2_API int b2World_GetWorkerCount( b2WorldId worldId ); } */
    public static native int nb2World_GetWorkerCount(long worldId);

    // --- [ b2World_DumpMemoryStats ] ---

    /**
     * {@code B2_API void b2World_DumpMemoryStats( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     */
    public static void b2World_DumpMemoryStats(b2WorldId worldId) {
        checkPointers(worldId);
        nb2World_DumpMemoryStats(worldId.address());
    }

    /* {@code B2_API void b2World_DumpMemoryStats( b2WorldId worldId ); } */
    public static native void nb2World_DumpMemoryStats(long worldId);

    // --- [ b2World_RebuildStaticTree ] ---

    /**
     * {@code B2_API void b2World_RebuildStaticTree( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     */
    public static void b2World_RebuildStaticTree(b2WorldId worldId) {
        checkPointers(worldId);
        nb2World_RebuildStaticTree(worldId.address());
    }

    /* {@code B2_API void b2World_RebuildStaticTree( b2WorldId worldId ); } */
    public static native void nb2World_RebuildStaticTree(long worldId);

    // --- [ b2World_EnableSpeculative ] ---

    /**
     * {@code B2_API void b2World_EnableSpeculative( b2WorldId worldId, bool flag ); }
     *
     * @param worldId b2WorldId
     * @param flag boolean
     */
    public static void b2World_EnableSpeculative(b2WorldId worldId, boolean flag) {
        checkPointers(worldId);
        nb2World_EnableSpeculative(worldId.address(), flag);
    }

    /* {@code B2_API void b2World_EnableSpeculative( b2WorldId worldId, bool flag ); } */
    public static native void nb2World_EnableSpeculative(long worldId, boolean flag);

    // --- [ b2CreateRecording ] ---

    /**
     * {@code B2_API b2Recording* b2CreateRecording( int byteCapacity ); }
     *
     * @param byteCapacity int
     * @param __result store
     *
     * @return b2Recording
     */
    public static b2Recording b2CreateRecording(int byteCapacity, b2Recording __result) {
        checkPointers(__result);
        nb2CreateRecording(byteCapacity, __result.address());
        return __result;
    }

    /* {@code B2_API b2Recording* b2CreateRecording( int byteCapacity ); } */
    public static native void nb2CreateRecording(int byteCapacity, long __result);

    // --- [ b2DestroyRecording ] ---

    /**
     * {@code B2_API void b2DestroyRecording( b2Recording* recording ); }
     *
     * @param recording b2Recording
     */
    public static void b2DestroyRecording(b2Recording recording) {
        checkPointers(recording);
        nb2DestroyRecording(recording.address());
    }

    /* {@code B2_API void b2DestroyRecording( b2Recording* recording ); } */
    public static native void nb2DestroyRecording(long recording);

    // --- [ b2Recording_GetData ] ---

    /**
     * {@code B2_API const uint8_t* b2Recording_GetData( const b2Recording* recording ); }
     *
     * @param recording ConstB2Recording
     *
     * @return long
     */
    public static long b2Recording_GetData(ConstB2Recording recording) {
        checkPointers(recording);
        return nb2Recording_GetData(recording.address());
    }

    /* {@code B2_API const uint8_t* b2Recording_GetData( const b2Recording* recording ); } */
    public static native long nb2Recording_GetData(long recording);

    // --- [ b2Recording_GetSize ] ---

    /**
     * {@code B2_API int b2Recording_GetSize( const b2Recording* recording ); }
     *
     * @param recording ConstB2Recording
     *
     * @return int
     */
    public static int b2Recording_GetSize(ConstB2Recording recording) {
        checkPointers(recording);
        return nb2Recording_GetSize(recording.address());
    }

    /* {@code B2_API int b2Recording_GetSize( const b2Recording* recording ); } */
    public static native int nb2Recording_GetSize(long recording);

    // --- [ b2World_StartRecording ] ---

    /**
     * {@code B2_API void b2World_StartRecording( b2WorldId worldId, b2Recording* recording ); }
     *
     * @param worldId b2WorldId
     * @param recording b2Recording
     */
    public static void b2World_StartRecording(b2WorldId worldId, b2Recording recording) {
        checkPointers(worldId, recording);
        nb2World_StartRecording(worldId.address(), recording.address());
    }

    /* {@code B2_API void b2World_StartRecording( b2WorldId worldId, b2Recording* recording ); } */
    public static native void nb2World_StartRecording(long worldId, long recording);

    // --- [ b2World_StopRecording ] ---

    /**
     * {@code B2_API void b2World_StopRecording( b2WorldId worldId ); }
     *
     * @param worldId b2WorldId
     */
    public static void b2World_StopRecording(b2WorldId worldId) {
        checkPointers(worldId);
        nb2World_StopRecording(worldId.address());
    }

    /* {@code B2_API void b2World_StopRecording( b2WorldId worldId ); } */
    public static native void nb2World_StopRecording(long worldId);

    // --- [ b2SaveRecordingToFile ] ---

    /**
     * {@code B2_API bool b2SaveRecordingToFile( const b2Recording* recording, const char* path ); }
     *
     * @param recording ConstB2Recording
     * @param path long
     *
     * @return boolean
     */
    public static boolean b2SaveRecordingToFile(ConstB2Recording recording, long path) {
        checkPointers(recording);
        return nb2SaveRecordingToFile(recording.address(), path);
    }

    /* {@code B2_API bool b2SaveRecordingToFile( const b2Recording* recording, const char* path ); } */
    public static native boolean nb2SaveRecordingToFile(long recording, long path);

    // --- [ b2LoadRecordingFromFile ] ---

    /**
     * {@code B2_API b2Recording* b2LoadRecordingFromFile( const char* path ); }
     *
     * @param path long
     * @param __result store
     *
     * @return b2Recording
     */
    public static b2Recording b2LoadRecordingFromFile(long path, b2Recording __result) {
        checkPointers(__result);
        nb2LoadRecordingFromFile(path, __result.address());
        return __result;
    }

    /* {@code B2_API b2Recording* b2LoadRecordingFromFile( const char* path ); } */
    public static native void nb2LoadRecordingFromFile(long path, long __result);

    // --- [ b2World_Snapshot ] ---

    /**
     * {@code B2_API int b2World_Snapshot( b2WorldId worldId, uint8_t* image, int capacity ); }
     *
     * @param worldId b2WorldId
     * @param image long
     * @param capacity int
     *
     * @return int
     */
    public static int b2World_Snapshot(b2WorldId worldId, ByteBuffer image, int capacity) {
        checkPointers(worldId);
        return nb2World_Snapshot(worldId.address(), image, capacity);
    }

    /* {@code B2_API int b2World_Snapshot( b2WorldId worldId, uint8_t* image, int capacity ); } */
    public static native int nb2World_Snapshot(long worldId, ByteBuffer image, int capacity);

    // --- [ b2World_Restore ] ---

    /**
     * {@code B2_API bool b2World_Restore( b2WorldId worldId, const uint8_t* image, int size ); }
     *
     * @param worldId b2WorldId
     * @param image long
     * @param size int
     *
     * @return boolean
     */
    public static boolean b2World_Restore(b2WorldId worldId, ByteBuffer image, int size) {
        checkPointers(worldId);
        return nb2World_Restore(worldId.address(), image, size);
    }

    /* {@code B2_API bool b2World_Restore( b2WorldId worldId, const uint8_t* image, int size ); } */
    public static native boolean nb2World_Restore(long worldId, ByteBuffer image, int size);

    // --- [ b2CreateWorldFromSnapshot ] ---

    /**
     * {@code B2_API b2WorldId b2CreateWorldFromSnapshot( const uint8_t* image, int size, int workerCount ); }
     *
     * @param image long
     * @param size int
     * @param workerCount int
     * @param __result store
     *
     * @return b2WorldId
     */
    public static b2WorldId b2CreateWorldFromSnapshot(ByteBuffer image, int size, int workerCount, b2WorldId __result) {
        checkPointers(__result);
        nb2CreateWorldFromSnapshot(image, size, workerCount, __result.address());
        return __result;
    }

    /* {@code B2_API b2WorldId b2CreateWorldFromSnapshot( const uint8_t* image, int size, int workerCount ); } */
    public static native void nb2CreateWorldFromSnapshot(ByteBuffer image, int size, int workerCount, long __result);

    // --- [ b2CreateBody ] ---

    /**
     * {@code B2_API b2BodyId b2CreateBody( b2WorldId worldId, const b2BodyDef* def ); }
     *
     * @param worldId b2WorldId
     * @param def ConstB2BodyDef
     * @param __result store
     *
     * @return b2BodyId
     */
    public static b2BodyId b2CreateBody(b2WorldId worldId, ConstB2BodyDef def, b2BodyId __result) {
        checkPointers(worldId, def, __result);
        nb2CreateBody(worldId.address(), def.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2BodyId b2CreateBody( b2WorldId worldId, const b2BodyDef* def ); } */
    public static native void nb2CreateBody(long worldId, long def, long __result);

    // --- [ b2DestroyBody ] ---

    /**
     * {@code B2_API void b2DestroyBody( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     */
    public static void b2DestroyBody(b2BodyId bodyId) {
        checkPointers(bodyId);
        nb2DestroyBody(bodyId.address());
    }

    /* {@code B2_API void b2DestroyBody( b2BodyId bodyId ); } */
    public static native void nb2DestroyBody(long bodyId);

    // --- [ b2Body_IsValid ] ---

    /**
     * {@code B2_API bool b2Body_IsValid( b2BodyId id ); }
     *
     * @param id b2BodyId
     *
     * @return boolean
     */
    public static boolean b2Body_IsValid(b2BodyId id) {
        checkPointers(id);
        return nb2Body_IsValid(id.address());
    }

    /* {@code B2_API bool b2Body_IsValid( b2BodyId id ); } */
    public static native boolean nb2Body_IsValid(long id);

    // --- [ b2Body_GetType ] ---

    /**
     * {@code B2_API b2BodyType b2Body_GetType( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     *
     * @return int
     */
    public static b2BodyType b2Body_GetType(b2BodyId bodyId) {
        checkPointers(bodyId);
        int ntype = nb2Body_GetType(bodyId.address());
        return b2BodyType.valueOf(ntype);
    }

    /* {@code B2_API b2BodyType b2Body_GetType( b2BodyId bodyId ); } */
    public static native int nb2Body_GetType(long bodyId);

    // --- [ b2Body_SetType ] ---

    /**
     * {@code B2_API void b2Body_SetType( b2BodyId bodyId, b2BodyType type ); }
     *
     * @param bodyId b2BodyId
     * @param type int
     */
    public static void b2Body_SetType(b2BodyId bodyId, b2BodyType type) {
        checkPointers(bodyId);
        nb2Body_SetType(bodyId.address(), type.value());
    }

    /* {@code B2_API void b2Body_SetType( b2BodyId bodyId, b2BodyType type ); } */
    public static native void nb2Body_SetType(long bodyId, int type);

    // --- [ b2Body_SetName ] ---

    /**
     * {@code B2_API void b2Body_SetName( b2BodyId bodyId, const char* name ); }
     *
     * @param bodyId b2BodyId
     * @param name long
     */
    public static void b2Body_SetName(b2BodyId bodyId, long name) {
        checkPointers(bodyId);
        nb2Body_SetName(bodyId.address(), name);
    }

    /* {@code B2_API void b2Body_SetName( b2BodyId bodyId, const char* name ); } */
    public static native void nb2Body_SetName(long bodyId, long name);

    // --- [ b2Body_GetName ] ---

    /**
     * {@code B2_API const char* b2Body_GetName( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     *
     * @return String
     */
    public static String b2Body_GetName(b2BodyId bodyId) {
        checkPointers(bodyId);
        return nb2Body_GetName(bodyId.address());
    }

    /* {@code B2_API const char* b2Body_GetName( b2BodyId bodyId ); } */
    public static native String nb2Body_GetName(long bodyId);

    // --- [ b2Body_SetUserData ] ---

    /**
     * {@code B2_API void b2Body_SetUserData( b2BodyId bodyId, void* userData ); }
     *
     * @param bodyId b2BodyId
     * @param userData long
     */
    public static void b2Body_SetUserData(b2BodyId bodyId, long userData) {
        checkPointers(bodyId);
        nb2Body_SetUserData(bodyId.address(), userData);
    }

    /* {@code B2_API void b2Body_SetUserData( b2BodyId bodyId, void* userData ); } */
    public static native void nb2Body_SetUserData(long bodyId, long userData);

    // --- [ b2Body_GetUserData ] ---

    /**
     * {@code B2_API void* b2Body_GetUserData( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     *
     * @return long
     */
    public static long b2Body_GetUserData(b2BodyId bodyId) {
        checkPointers(bodyId);
        return nb2Body_GetUserData(bodyId.address());
    }

    /* {@code B2_API void* b2Body_GetUserData( b2BodyId bodyId ); } */
    public static native long nb2Body_GetUserData(long bodyId);

    // --- [ b2Body_GetPosition ] ---

    /**
     * {@code B2_API b2Vec2 b2Body_GetPosition( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     * @param __result store
     *
     * @return b2Vec2
     */
    public static b2Vec2 b2Body_GetPosition(b2BodyId bodyId, b2Vec2 __result) {
        checkPointers(bodyId, __result);
        nb2Body_GetPosition(bodyId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Vec2 b2Body_GetPosition( b2BodyId bodyId ); } */
    public static native void nb2Body_GetPosition(long bodyId, long __result);

    // --- [ b2Body_GetRotation ] ---

    /**
     * {@code B2_API b2Rot b2Body_GetRotation( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     * @param __result store
     *
     * @return b2Rot
     */
    public static b2Rot b2Body_GetRotation(b2BodyId bodyId, b2Rot __result) {
        checkPointers(bodyId, __result);
        nb2Body_GetRotation(bodyId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Rot b2Body_GetRotation( b2BodyId bodyId ); } */
    public static native void nb2Body_GetRotation(long bodyId, long __result);

    // --- [ b2Body_GetTransform ] ---

    /**
     * {@code B2_API b2Transform b2Body_GetTransform( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     * @param __result store
     *
     * @return b2Transform
     */
    public static b2Transform b2Body_GetTransform(b2BodyId bodyId, b2Transform __result) {
        checkPointers(bodyId, __result);
        nb2Body_GetTransform(bodyId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Transform b2Body_GetTransform( b2BodyId bodyId ); } */
    public static native void nb2Body_GetTransform(long bodyId, long __result);

    // --- [ b2Body_SetTransform ] ---

    /**
     * {@code B2_API void b2Body_SetTransform( b2BodyId bodyId, b2Vec2 position, b2Rot rotation ); }
     *
     * @param bodyId b2BodyId
     * @param position b2Vec2
     * @param rotation b2Rot
     */
    public static void b2Body_SetTransform(b2BodyId bodyId, b2Vec2 position, b2Rot rotation) {
        checkPointers(bodyId, position, rotation);
        nb2Body_SetTransform(bodyId.address(), position.address(), rotation.address());
    }

    /* {@code B2_API void b2Body_SetTransform( b2BodyId bodyId, b2Vec2 position, b2Rot rotation ); } */
    public static native void nb2Body_SetTransform(long bodyId, long position, long rotation);

    // --- [ b2Body_GetLocalPoint ] ---

    /**
     * {@code B2_API b2Vec2 b2Body_GetLocalPoint( b2BodyId bodyId, b2Vec2 worldPoint ); }
     *
     * @param bodyId b2BodyId
     * @param worldPoint b2Vec2
     * @param __result store
     *
     * @return b2Vec2
     */
    public static b2Vec2 b2Body_GetLocalPoint(b2BodyId bodyId, b2Vec2 worldPoint, b2Vec2 __result) {
        checkPointers(bodyId, worldPoint, __result);
        nb2Body_GetLocalPoint(bodyId.address(), worldPoint.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Vec2 b2Body_GetLocalPoint( b2BodyId bodyId, b2Vec2 worldPoint ); } */
    public static native void nb2Body_GetLocalPoint(long bodyId, long worldPoint, long __result);

    // --- [ b2Body_GetWorldPoint ] ---

    /**
     * {@code B2_API b2Vec2 b2Body_GetWorldPoint( b2BodyId bodyId, b2Vec2 localPoint ); }
     *
     * @param bodyId b2BodyId
     * @param localPoint b2Vec2
     * @param __result store
     *
     * @return b2Vec2
     */
    public static b2Vec2 b2Body_GetWorldPoint(b2BodyId bodyId, b2Vec2 localPoint, b2Vec2 __result) {
        checkPointers(bodyId, localPoint, __result);
        nb2Body_GetWorldPoint(bodyId.address(), localPoint.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Vec2 b2Body_GetWorldPoint( b2BodyId bodyId, b2Vec2 localPoint ); } */
    public static native void nb2Body_GetWorldPoint(long bodyId, long localPoint, long __result);

    // --- [ b2Body_GetLocalVector ] ---

    /**
     * {@code B2_API b2Vec2 b2Body_GetLocalVector( b2BodyId bodyId, b2Vec2 worldVector ); }
     *
     * @param bodyId b2BodyId
     * @param worldVector b2Vec2
     * @param __result store
     *
     * @return b2Vec2
     */
    public static b2Vec2 b2Body_GetLocalVector(b2BodyId bodyId, b2Vec2 worldVector, b2Vec2 __result) {
        checkPointers(bodyId, worldVector, __result);
        nb2Body_GetLocalVector(bodyId.address(), worldVector.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Vec2 b2Body_GetLocalVector( b2BodyId bodyId, b2Vec2 worldVector ); } */
    public static native void nb2Body_GetLocalVector(long bodyId, long worldVector, long __result);

    // --- [ b2Body_GetWorldVector ] ---

    /**
     * {@code B2_API b2Vec2 b2Body_GetWorldVector( b2BodyId bodyId, b2Vec2 localVector ); }
     *
     * @param bodyId b2BodyId
     * @param localVector b2Vec2
     * @param __result store
     *
     * @return b2Vec2
     */
    public static b2Vec2 b2Body_GetWorldVector(b2BodyId bodyId, b2Vec2 localVector, b2Vec2 __result) {
        checkPointers(bodyId, localVector, __result);
        nb2Body_GetWorldVector(bodyId.address(), localVector.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Vec2 b2Body_GetWorldVector( b2BodyId bodyId, b2Vec2 localVector ); } */
    public static native void nb2Body_GetWorldVector(long bodyId, long localVector, long __result);

    // --- [ b2Body_GetLinearVelocity ] ---

    /**
     * {@code B2_API b2Vec2 b2Body_GetLinearVelocity( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     * @param __result store
     *
     * @return b2Vec2
     */
    public static b2Vec2 b2Body_GetLinearVelocity(b2BodyId bodyId, b2Vec2 __result) {
        checkPointers(bodyId, __result);
        nb2Body_GetLinearVelocity(bodyId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Vec2 b2Body_GetLinearVelocity( b2BodyId bodyId ); } */
    public static native void nb2Body_GetLinearVelocity(long bodyId, long __result);

    // --- [ b2Body_GetAngularVelocity ] ---

    /**
     * {@code B2_API float b2Body_GetAngularVelocity( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     *
     * @return float
     */
    public static float b2Body_GetAngularVelocity(b2BodyId bodyId) {
        checkPointers(bodyId);
        return nb2Body_GetAngularVelocity(bodyId.address());
    }

    /* {@code B2_API float b2Body_GetAngularVelocity( b2BodyId bodyId ); } */
    public static native float nb2Body_GetAngularVelocity(long bodyId);

    // --- [ b2Body_SetLinearVelocity ] ---

    /**
     * {@code B2_API void b2Body_SetLinearVelocity( b2BodyId bodyId, b2Vec2 linearVelocity ); }
     *
     * @param bodyId b2BodyId
     * @param linearVelocity b2Vec2
     */
    public static void b2Body_SetLinearVelocity(b2BodyId bodyId, b2Vec2 linearVelocity) {
        checkPointers(bodyId, linearVelocity);
        nb2Body_SetLinearVelocity(bodyId.address(), linearVelocity.address());
    }

    /* {@code B2_API void b2Body_SetLinearVelocity( b2BodyId bodyId, b2Vec2 linearVelocity ); } */
    public static native void nb2Body_SetLinearVelocity(long bodyId, long linearVelocity);

    // --- [ b2Body_SetAngularVelocity ] ---

    /**
     * {@code B2_API void b2Body_SetAngularVelocity( b2BodyId bodyId, float angularVelocity ); }
     *
     * @param bodyId b2BodyId
     * @param angularVelocity float
     */
    public static void b2Body_SetAngularVelocity(b2BodyId bodyId, float angularVelocity) {
        checkPointers(bodyId);
        nb2Body_SetAngularVelocity(bodyId.address(), angularVelocity);
    }

    /* {@code B2_API void b2Body_SetAngularVelocity( b2BodyId bodyId, float angularVelocity ); } */
    public static native void nb2Body_SetAngularVelocity(long bodyId, float angularVelocity);

    // --- [ b2Body_SetTargetTransform ] ---

    /**
     * {@code B2_API void b2Body_SetTargetTransform( b2BodyId bodyId, b2Transform target, float timeStep, bool wake ); }
     *
     * @param bodyId b2BodyId
     * @param target b2Transform
     * @param timeStep float
     * @param wake boolean
     */
    public static void b2Body_SetTargetTransform(b2BodyId bodyId, b2Transform target, float timeStep, boolean wake) {
        checkPointers(bodyId, target);
        nb2Body_SetTargetTransform(bodyId.address(), target.address(), timeStep, wake);
    }

    /* {@code B2_API void b2Body_SetTargetTransform( b2BodyId bodyId, b2Transform target, float timeStep, bool wake ); } */
    public static native void nb2Body_SetTargetTransform(long bodyId, long target, float timeStep, boolean wake);

    // --- [ b2Body_GetLocalPointVelocity ] ---

    /**
     * {@code B2_API b2Vec2 b2Body_GetLocalPointVelocity( b2BodyId bodyId, b2Vec2 localPoint ); }
     *
     * @param bodyId b2BodyId
     * @param localPoint b2Vec2
     * @param __result store
     *
     * @return b2Vec2
     */
    public static b2Vec2 b2Body_GetLocalPointVelocity(b2BodyId bodyId, b2Vec2 localPoint, b2Vec2 __result) {
        checkPointers(bodyId, localPoint, __result);
        nb2Body_GetLocalPointVelocity(bodyId.address(), localPoint.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Vec2 b2Body_GetLocalPointVelocity( b2BodyId bodyId, b2Vec2 localPoint ); } */
    public static native void nb2Body_GetLocalPointVelocity(long bodyId, long localPoint, long __result);

    // --- [ b2Body_GetWorldPointVelocity ] ---

    /**
     * {@code B2_API b2Vec2 b2Body_GetWorldPointVelocity( b2BodyId bodyId, b2Vec2 worldPoint ); }
     *
     * @param bodyId b2BodyId
     * @param worldPoint b2Vec2
     * @param __result store
     *
     * @return b2Vec2
     */
    public static b2Vec2 b2Body_GetWorldPointVelocity(b2BodyId bodyId, b2Vec2 worldPoint, b2Vec2 __result) {
        checkPointers(bodyId, worldPoint, __result);
        nb2Body_GetWorldPointVelocity(bodyId.address(), worldPoint.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Vec2 b2Body_GetWorldPointVelocity( b2BodyId bodyId, b2Vec2 worldPoint ); } */
    public static native void nb2Body_GetWorldPointVelocity(long bodyId, long worldPoint, long __result);

    // --- [ b2Body_ApplyForce ] ---

    /**
     * {@code B2_API void b2Body_ApplyForce( b2BodyId bodyId, b2Vec2 force, b2Vec2 point, bool wake ); }
     *
     * @param bodyId b2BodyId
     * @param force b2Vec2
     * @param point b2Vec2
     * @param wake boolean
     */
    public static void b2Body_ApplyForce(b2BodyId bodyId, b2Vec2 force, b2Vec2 point, boolean wake) {
        checkPointers(bodyId, force, point);
        nb2Body_ApplyForce(bodyId.address(), force.address(), point.address(), wake);
    }

    /* {@code B2_API void b2Body_ApplyForce( b2BodyId bodyId, b2Vec2 force, b2Vec2 point, bool wake ); } */
    public static native void nb2Body_ApplyForce(long bodyId, long force, long point, boolean wake);

    // --- [ b2Body_ApplyForceToCenter ] ---

    /**
     * {@code B2_API void b2Body_ApplyForceToCenter( b2BodyId bodyId, b2Vec2 force, bool wake ); }
     *
     * @param bodyId b2BodyId
     * @param force b2Vec2
     * @param wake boolean
     */
    public static void b2Body_ApplyForceToCenter(b2BodyId bodyId, b2Vec2 force, boolean wake) {
        checkPointers(bodyId, force);
        nb2Body_ApplyForceToCenter(bodyId.address(), force.address(), wake);
    }

    /* {@code B2_API void b2Body_ApplyForceToCenter( b2BodyId bodyId, b2Vec2 force, bool wake ); } */
    public static native void nb2Body_ApplyForceToCenter(long bodyId, long force, boolean wake);

    // --- [ b2Body_ApplyTorque ] ---

    /**
     * {@code B2_API void b2Body_ApplyTorque( b2BodyId bodyId, float torque, bool wake ); }
     *
     * @param bodyId b2BodyId
     * @param torque float
     * @param wake boolean
     */
    public static void b2Body_ApplyTorque(b2BodyId bodyId, float torque, boolean wake) {
        checkPointers(bodyId);
        nb2Body_ApplyTorque(bodyId.address(), torque, wake);
    }

    /* {@code B2_API void b2Body_ApplyTorque( b2BodyId bodyId, float torque, bool wake ); } */
    public static native void nb2Body_ApplyTorque(long bodyId, float torque, boolean wake);

    // --- [ b2Body_ClearForces ] ---

    /**
     * {@code B2_API void b2Body_ClearForces( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     */
    public static void b2Body_ClearForces(b2BodyId bodyId) {
        checkPointers(bodyId);
        nb2Body_ClearForces(bodyId.address());
    }

    /* {@code B2_API void b2Body_ClearForces( b2BodyId bodyId ); } */
    public static native void nb2Body_ClearForces(long bodyId);

    // --- [ b2Body_ApplyLinearImpulse ] ---

    /**
     * {@code B2_API void b2Body_ApplyLinearImpulse( b2BodyId bodyId, b2Vec2 impulse, b2Vec2 point, bool wake ); }
     *
     * @param bodyId b2BodyId
     * @param impulse b2Vec2
     * @param point b2Vec2
     * @param wake boolean
     */
    public static void b2Body_ApplyLinearImpulse(b2BodyId bodyId, b2Vec2 impulse, b2Vec2 point, boolean wake) {
        checkPointers(bodyId, impulse, point);
        nb2Body_ApplyLinearImpulse(bodyId.address(), impulse.address(), point.address(), wake);
    }

    /* {@code B2_API void b2Body_ApplyLinearImpulse( b2BodyId bodyId, b2Vec2 impulse, b2Vec2 point, bool wake ); } */
    public static native void nb2Body_ApplyLinearImpulse(long bodyId, long impulse, long point, boolean wake);

    // --- [ b2Body_ApplyLinearImpulseToCenter ] ---

    /**
     * {@code B2_API void b2Body_ApplyLinearImpulseToCenter( b2BodyId bodyId, b2Vec2 impulse, bool wake ); }
     *
     * @param bodyId b2BodyId
     * @param impulse b2Vec2
     * @param wake boolean
     */
    public static void b2Body_ApplyLinearImpulseToCenter(b2BodyId bodyId, b2Vec2 impulse, boolean wake) {
        checkPointers(bodyId, impulse);
        nb2Body_ApplyLinearImpulseToCenter(bodyId.address(), impulse.address(), wake);
    }

    /* {@code B2_API void b2Body_ApplyLinearImpulseToCenter( b2BodyId bodyId, b2Vec2 impulse, bool wake ); } */
    public static native void nb2Body_ApplyLinearImpulseToCenter(long bodyId, long impulse, boolean wake);

    // --- [ b2Body_ApplyAngularImpulse ] ---

    /**
     * {@code B2_API void b2Body_ApplyAngularImpulse( b2BodyId bodyId, float impulse, bool wake ); }
     *
     * @param bodyId b2BodyId
     * @param impulse float
     * @param wake boolean
     */
    public static void b2Body_ApplyAngularImpulse(b2BodyId bodyId, float impulse, boolean wake) {
        checkPointers(bodyId);
        nb2Body_ApplyAngularImpulse(bodyId.address(), impulse, wake);
    }

    /* {@code B2_API void b2Body_ApplyAngularImpulse( b2BodyId bodyId, float impulse, bool wake ); } */
    public static native void nb2Body_ApplyAngularImpulse(long bodyId, float impulse, boolean wake);

    // --- [ b2Body_GetMass ] ---

    /**
     * {@code B2_API float b2Body_GetMass( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     *
     * @return float
     */
    public static float b2Body_GetMass(b2BodyId bodyId) {
        checkPointers(bodyId);
        return nb2Body_GetMass(bodyId.address());
    }

    /* {@code B2_API float b2Body_GetMass( b2BodyId bodyId ); } */
    public static native float nb2Body_GetMass(long bodyId);

    // --- [ b2Body_GetRotationalInertia ] ---

    /**
     * {@code B2_API float b2Body_GetRotationalInertia( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     *
     * @return float
     */
    public static float b2Body_GetRotationalInertia(b2BodyId bodyId) {
        checkPointers(bodyId);
        return nb2Body_GetRotationalInertia(bodyId.address());
    }

    /* {@code B2_API float b2Body_GetRotationalInertia( b2BodyId bodyId ); } */
    public static native float nb2Body_GetRotationalInertia(long bodyId);

    // --- [ b2Body_GetLocalCenterOfMass ] ---

    /**
     * {@code B2_API b2Vec2 b2Body_GetLocalCenterOfMass( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     * @param __result store
     *
     * @return b2Vec2
     */
    public static b2Vec2 b2Body_GetLocalCenterOfMass(b2BodyId bodyId, b2Vec2 __result) {
        checkPointers(bodyId, __result);
        nb2Body_GetLocalCenterOfMass(bodyId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Vec2 b2Body_GetLocalCenterOfMass( b2BodyId bodyId ); } */
    public static native void nb2Body_GetLocalCenterOfMass(long bodyId, long __result);

    // --- [ b2Body_GetWorldCenterOfMass ] ---

    /**
     * {@code B2_API b2Vec2 b2Body_GetWorldCenterOfMass( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     * @param __result store
     *
     * @return b2Vec2
     */
    public static b2Vec2 b2Body_GetWorldCenterOfMass(b2BodyId bodyId, b2Vec2 __result) {
        checkPointers(bodyId, __result);
        nb2Body_GetWorldCenterOfMass(bodyId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Vec2 b2Body_GetWorldCenterOfMass( b2BodyId bodyId ); } */
    public static native void nb2Body_GetWorldCenterOfMass(long bodyId, long __result);

    // --- [ b2Body_SetMassData ] ---

    /**
     * {@code B2_API void b2Body_SetMassData( b2BodyId bodyId, b2MassData massData ); }
     *
     * @param bodyId b2BodyId
     * @param massData b2MassData
     */
    public static void b2Body_SetMassData(b2BodyId bodyId, b2MassData massData) {
        checkPointers(bodyId, massData);
        nb2Body_SetMassData(bodyId.address(), massData.address());
    }

    /* {@code B2_API void b2Body_SetMassData( b2BodyId bodyId, b2MassData massData ); } */
    public static native void nb2Body_SetMassData(long bodyId, long massData);

    // --- [ b2Body_GetMassData ] ---

    /**
     * {@code B2_API b2MassData b2Body_GetMassData( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     * @param __result store
     *
     * @return b2MassData
     */
    public static b2MassData b2Body_GetMassData(b2BodyId bodyId, b2MassData __result) {
        checkPointers(bodyId, __result);
        nb2Body_GetMassData(bodyId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2MassData b2Body_GetMassData( b2BodyId bodyId ); } */
    public static native void nb2Body_GetMassData(long bodyId, long __result);

    // --- [ b2Body_ApplyMassFromShapes ] ---

    /**
     * {@code B2_API void b2Body_ApplyMassFromShapes( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     */
    public static void b2Body_ApplyMassFromShapes(b2BodyId bodyId) {
        checkPointers(bodyId);
        nb2Body_ApplyMassFromShapes(bodyId.address());
    }

    /* {@code B2_API void b2Body_ApplyMassFromShapes( b2BodyId bodyId ); } */
    public static native void nb2Body_ApplyMassFromShapes(long bodyId);

    // --- [ b2Body_SetLinearDamping ] ---

    /**
     * {@code B2_API void b2Body_SetLinearDamping( b2BodyId bodyId, float linearDamping ); }
     *
     * @param bodyId b2BodyId
     * @param linearDamping float
     */
    public static void b2Body_SetLinearDamping(b2BodyId bodyId, float linearDamping) {
        checkPointers(bodyId);
        nb2Body_SetLinearDamping(bodyId.address(), linearDamping);
    }

    /* {@code B2_API void b2Body_SetLinearDamping( b2BodyId bodyId, float linearDamping ); } */
    public static native void nb2Body_SetLinearDamping(long bodyId, float linearDamping);

    // --- [ b2Body_GetLinearDamping ] ---

    /**
     * {@code B2_API float b2Body_GetLinearDamping( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     *
     * @return float
     */
    public static float b2Body_GetLinearDamping(b2BodyId bodyId) {
        checkPointers(bodyId);
        return nb2Body_GetLinearDamping(bodyId.address());
    }

    /* {@code B2_API float b2Body_GetLinearDamping( b2BodyId bodyId ); } */
    public static native float nb2Body_GetLinearDamping(long bodyId);

    // --- [ b2Body_SetAngularDamping ] ---

    /**
     * {@code B2_API void b2Body_SetAngularDamping( b2BodyId bodyId, float angularDamping ); }
     *
     * @param bodyId b2BodyId
     * @param angularDamping float
     */
    public static void b2Body_SetAngularDamping(b2BodyId bodyId, float angularDamping) {
        checkPointers(bodyId);
        nb2Body_SetAngularDamping(bodyId.address(), angularDamping);
    }

    /* {@code B2_API void b2Body_SetAngularDamping( b2BodyId bodyId, float angularDamping ); } */
    public static native void nb2Body_SetAngularDamping(long bodyId, float angularDamping);

    // --- [ b2Body_GetAngularDamping ] ---

    /**
     * {@code B2_API float b2Body_GetAngularDamping( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     *
     * @return float
     */
    public static float b2Body_GetAngularDamping(b2BodyId bodyId) {
        checkPointers(bodyId);
        return nb2Body_GetAngularDamping(bodyId.address());
    }

    /* {@code B2_API float b2Body_GetAngularDamping( b2BodyId bodyId ); } */
    public static native float nb2Body_GetAngularDamping(long bodyId);

    // --- [ b2Body_SetGravityScale ] ---

    /**
     * {@code B2_API void b2Body_SetGravityScale( b2BodyId bodyId, float gravityScale ); }
     *
     * @param bodyId b2BodyId
     * @param gravityScale float
     */
    public static void b2Body_SetGravityScale(b2BodyId bodyId, float gravityScale) {
        checkPointers(bodyId);
        nb2Body_SetGravityScale(bodyId.address(), gravityScale);
    }

    /* {@code B2_API void b2Body_SetGravityScale( b2BodyId bodyId, float gravityScale ); } */
    public static native void nb2Body_SetGravityScale(long bodyId, float gravityScale);

    // --- [ b2Body_GetGravityScale ] ---

    /**
     * {@code B2_API float b2Body_GetGravityScale( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     *
     * @return float
     */
    public static float b2Body_GetGravityScale(b2BodyId bodyId) {
        checkPointers(bodyId);
        return nb2Body_GetGravityScale(bodyId.address());
    }

    /* {@code B2_API float b2Body_GetGravityScale( b2BodyId bodyId ); } */
    public static native float nb2Body_GetGravityScale(long bodyId);

    // --- [ b2Body_IsAwake ] ---

    /**
     * {@code B2_API bool b2Body_IsAwake( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     *
     * @return boolean
     */
    public static boolean b2Body_IsAwake(b2BodyId bodyId) {
        checkPointers(bodyId);
        return nb2Body_IsAwake(bodyId.address());
    }

    /* {@code B2_API bool b2Body_IsAwake( b2BodyId bodyId ); } */
    public static native boolean nb2Body_IsAwake(long bodyId);

    // --- [ b2Body_SetAwake ] ---

    /**
     * {@code B2_API void b2Body_SetAwake( b2BodyId bodyId, bool awake ); }
     *
     * @param bodyId b2BodyId
     * @param awake boolean
     */
    public static void b2Body_SetAwake(b2BodyId bodyId, boolean awake) {
        checkPointers(bodyId);
        nb2Body_SetAwake(bodyId.address(), awake);
    }

    /* {@code B2_API void b2Body_SetAwake( b2BodyId bodyId, bool awake ); } */
    public static native void nb2Body_SetAwake(long bodyId, boolean awake);

    // --- [ b2Body_WakeTouching ] ---

    /**
     * {@code B2_API void b2Body_WakeTouching( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     */
    public static void b2Body_WakeTouching(b2BodyId bodyId) {
        checkPointers(bodyId);
        nb2Body_WakeTouching(bodyId.address());
    }

    /* {@code B2_API void b2Body_WakeTouching( b2BodyId bodyId ); } */
    public static native void nb2Body_WakeTouching(long bodyId);

    // --- [ b2Body_EnableSleep ] ---

    /**
     * {@code B2_API void b2Body_EnableSleep( b2BodyId bodyId, bool enableSleep ); }
     *
     * @param bodyId b2BodyId
     * @param enableSleep boolean
     */
    public static void b2Body_EnableSleep(b2BodyId bodyId, boolean enableSleep) {
        checkPointers(bodyId);
        nb2Body_EnableSleep(bodyId.address(), enableSleep);
    }

    /* {@code B2_API void b2Body_EnableSleep( b2BodyId bodyId, bool enableSleep ); } */
    public static native void nb2Body_EnableSleep(long bodyId, boolean enableSleep);

    // --- [ b2Body_IsSleepEnabled ] ---

    /**
     * {@code B2_API bool b2Body_IsSleepEnabled( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     *
     * @return boolean
     */
    public static boolean b2Body_IsSleepEnabled(b2BodyId bodyId) {
        checkPointers(bodyId);
        return nb2Body_IsSleepEnabled(bodyId.address());
    }

    /* {@code B2_API bool b2Body_IsSleepEnabled( b2BodyId bodyId ); } */
    public static native boolean nb2Body_IsSleepEnabled(long bodyId);

    // --- [ b2Body_SetSleepThreshold ] ---

    /**
     * {@code B2_API void b2Body_SetSleepThreshold( b2BodyId bodyId, float sleepThreshold ); }
     *
     * @param bodyId b2BodyId
     * @param sleepThreshold float
     */
    public static void b2Body_SetSleepThreshold(b2BodyId bodyId, float sleepThreshold) {
        checkPointers(bodyId);
        nb2Body_SetSleepThreshold(bodyId.address(), sleepThreshold);
    }

    /* {@code B2_API void b2Body_SetSleepThreshold( b2BodyId bodyId, float sleepThreshold ); } */
    public static native void nb2Body_SetSleepThreshold(long bodyId, float sleepThreshold);

    // --- [ b2Body_GetSleepThreshold ] ---

    /**
     * {@code B2_API float b2Body_GetSleepThreshold( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     *
     * @return float
     */
    public static float b2Body_GetSleepThreshold(b2BodyId bodyId) {
        checkPointers(bodyId);
        return nb2Body_GetSleepThreshold(bodyId.address());
    }

    /* {@code B2_API float b2Body_GetSleepThreshold( b2BodyId bodyId ); } */
    public static native float nb2Body_GetSleepThreshold(long bodyId);

    // --- [ b2Body_IsEnabled ] ---

    /**
     * {@code B2_API bool b2Body_IsEnabled( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     *
     * @return boolean
     */
    public static boolean b2Body_IsEnabled(b2BodyId bodyId) {
        checkPointers(bodyId);
        return nb2Body_IsEnabled(bodyId.address());
    }

    /* {@code B2_API bool b2Body_IsEnabled( b2BodyId bodyId ); } */
    public static native boolean nb2Body_IsEnabled(long bodyId);

    // --- [ b2Body_Disable ] ---

    /**
     * {@code B2_API void b2Body_Disable( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     */
    public static void b2Body_Disable(b2BodyId bodyId) {
        checkPointers(bodyId);
        nb2Body_Disable(bodyId.address());
    }

    /* {@code B2_API void b2Body_Disable( b2BodyId bodyId ); } */
    public static native void nb2Body_Disable(long bodyId);

    // --- [ b2Body_Enable ] ---

    /**
     * {@code B2_API void b2Body_Enable( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     */
    public static void b2Body_Enable(b2BodyId bodyId) {
        checkPointers(bodyId);
        nb2Body_Enable(bodyId.address());
    }

    /* {@code B2_API void b2Body_Enable( b2BodyId bodyId ); } */
    public static native void nb2Body_Enable(long bodyId);

    // --- [ b2Body_SetMotionLocks ] ---

    /**
     * {@code B2_API void b2Body_SetMotionLocks( b2BodyId bodyId, b2MotionLocks locks ); }
     *
     * @param bodyId b2BodyId
     * @param locks b2MotionLocks
     */
    public static void b2Body_SetMotionLocks(b2BodyId bodyId, b2MotionLocks locks) {
        checkPointers(bodyId, locks);
        nb2Body_SetMotionLocks(bodyId.address(), locks.address());
    }

    /* {@code B2_API void b2Body_SetMotionLocks( b2BodyId bodyId, b2MotionLocks locks ); } */
    public static native void nb2Body_SetMotionLocks(long bodyId, long locks);

    // --- [ b2Body_GetMotionLocks ] ---

    /**
     * {@code B2_API b2MotionLocks b2Body_GetMotionLocks( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     * @param __result store
     *
     * @return b2MotionLocks
     */
    public static b2MotionLocks b2Body_GetMotionLocks(b2BodyId bodyId, b2MotionLocks __result) {
        checkPointers(bodyId, __result);
        nb2Body_GetMotionLocks(bodyId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2MotionLocks b2Body_GetMotionLocks( b2BodyId bodyId ); } */
    public static native void nb2Body_GetMotionLocks(long bodyId, long __result);

    // --- [ b2Body_SetBullet ] ---

    /**
     * {@code B2_API void b2Body_SetBullet( b2BodyId bodyId, bool flag ); }
     *
     * @param bodyId b2BodyId
     * @param flag boolean
     */
    public static void b2Body_SetBullet(b2BodyId bodyId, boolean flag) {
        checkPointers(bodyId);
        nb2Body_SetBullet(bodyId.address(), flag);
    }

    /* {@code B2_API void b2Body_SetBullet( b2BodyId bodyId, bool flag ); } */
    public static native void nb2Body_SetBullet(long bodyId, boolean flag);

    // --- [ b2Body_IsBullet ] ---

    /**
     * {@code B2_API bool b2Body_IsBullet( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     *
     * @return boolean
     */
    public static boolean b2Body_IsBullet(b2BodyId bodyId) {
        checkPointers(bodyId);
        return nb2Body_IsBullet(bodyId.address());
    }

    /* {@code B2_API bool b2Body_IsBullet( b2BodyId bodyId ); } */
    public static native boolean nb2Body_IsBullet(long bodyId);

    // --- [ b2Body_EnableContactRecycling ] ---

    /**
     * {@code B2_API void b2Body_EnableContactRecycling( b2BodyId bodyId, bool flag ); }
     *
     * @param bodyId b2BodyId
     * @param flag bool
     */
    public static void b2Body_EnableContactRecycling(b2BodyId bodyId, boolean flag) {
        checkPointers(bodyId);
        nb2Body_EnableContactRecycling(bodyId.address(), flag);
    }

    /* {@code B2_API void b2Body_EnableContactRecycling( b2BodyId bodyId, bool flag ); } */
    public static native void nb2Body_EnableContactRecycling(long bodyId, boolean flag);

    // --- [ b2Body_IsContactRecyclingEnabled ] ---

    /**
     * {@code B2_API bool b2Body_IsContactRecyclingEnabled( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     *
     * @return bool
     */
    public static boolean b2Body_IsContactRecyclingEnabled(b2BodyId bodyId) {
        checkPointers(bodyId);
        return nb2Body_IsContactRecyclingEnabled(bodyId.address());
    }

    /* {@code B2_API bool b2Body_IsContactRecyclingEnabled( b2BodyId bodyId ); } */
    public static native boolean nb2Body_IsContactRecyclingEnabled(long bodyId);

    // --- [ b2Body_EnableContactEvents ] ---

    /**
     * {@code B2_API void b2Body_EnableContactEvents( b2BodyId bodyId, bool flag ); }
     *
     * @param bodyId b2BodyId
     * @param flag bool
     */
    public static void b2Body_EnableContactEvents(b2BodyId bodyId, boolean flag) {
        checkPointers(bodyId);
        nb2Body_EnableContactEvents(bodyId.address(), flag);
    }

    /* {@code B2_API void b2Body_EnableContactEvents( b2BodyId bodyId, bool flag ); } */
    public static native void nb2Body_EnableContactEvents(long bodyId, boolean flag);

    // --- [ b2Body_EnableHitEvents ] ---

    /**
     * {@code B2_API void b2Body_EnableHitEvents( b2BodyId bodyId, bool flag ); }
     *
     * @param bodyId b2BodyId
     * @param flag bool
     */
    public static void b2Body_EnableHitEvents(b2BodyId bodyId, boolean flag) {
        checkPointers(bodyId);
        nb2Body_EnableHitEvents(bodyId.address(), flag);
    }

    /* {@code B2_API void b2Body_EnableHitEvents( b2BodyId bodyId, bool flag ); } */
    public static native void nb2Body_EnableHitEvents(long bodyId, boolean flag);

    // --- [ b2Body_GetWorld ] ---

    /**
     * {@code B2_API b2WorldId b2Body_GetWorld( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     * @param __result store
     *
     * @return b2WorldId
     */
    public static b2WorldId b2Body_GetWorld(b2BodyId bodyId, b2WorldId __result) {
        checkPointers(bodyId, __result);
        nb2Body_GetWorld(bodyId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2WorldId b2Body_GetWorld( b2BodyId bodyId ); } */
    public static native void nb2Body_GetWorld(long bodyId, long __result);

    // --- [ b2Body_GetShapeCount ] ---

    /**
     * {@code B2_API int b2Body_GetShapeCount( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     *
     * @return int
     */
    public static int b2Body_GetShapeCount(b2BodyId bodyId) {
        checkPointers(bodyId);
        return nb2Body_GetShapeCount(bodyId.address());
    }

    /* {@code B2_API int b2Body_GetShapeCount( b2BodyId bodyId ); } */
    public static native int nb2Body_GetShapeCount(long bodyId);

    // --- [ b2Body_GetShapes ] ---

    /**
     * {@code B2_API int b2Body_GetShapes( b2BodyId bodyId, b2ShapeId* shapeArray, int capacity ); }
     *
     * @param bodyId b2BodyId
     * @param shapeArray b2ShapeId*
     * @param capacity int
     *
     * @return int
     */
    public static int b2Body_GetShapes(b2BodyId bodyId, b2ShapeId.Buffer shapeArray, int capacity) {
        checkPointers(bodyId, shapeArray);
        return nb2Body_GetShapes(bodyId.address(), shapeArray.address(), capacity);
    }

    /* {@code B2_API int b2Body_GetShapes( b2BodyId bodyId, b2ShapeId* shapeArray, int capacity ); } */
    public static native int nb2Body_GetShapes(long bodyId, long shapeArray, int capacity);

    // --- [ b2Body_GetJointCount ] ---

    /**
     * {@code B2_API int b2Body_GetJointCount( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     *
     * @return int
     */
    public static int b2Body_GetJointCount(b2BodyId bodyId) {
        checkPointers(bodyId);
        return nb2Body_GetJointCount(bodyId.address());
    }

    /* {@code B2_API int b2Body_GetJointCount( b2BodyId bodyId ); } */
    public static native int nb2Body_GetJointCount(long bodyId);

    // --- [ b2Body_GetJoints ] ---

    /**
     * {@code B2_API int b2Body_GetJoints( b2BodyId bodyId, b2JointId* jointArray, int capacity ); }
     *
     * @param bodyId b2BodyId
     * @param jointArray b2JointId*
     * @param capacity int
     *
     * @return int
     */
    public static int b2Body_GetJoints(b2BodyId bodyId, b2JointId.Buffer jointArray, int capacity) {
        checkPointers(bodyId, jointArray);
        return nb2Body_GetJoints(bodyId.address(), jointArray.address(), capacity);
    }

    /* {@code B2_API int b2Body_GetJoints( b2BodyId bodyId, b2JointId* jointArray, int capacity ); } */
    public static native int nb2Body_GetJoints(long bodyId, long jointArray, int capacity);

    // --- [ b2Body_GetContactCapacity ] ---

    /**
     * {@code B2_API int b2Body_GetContactCapacity( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     *
     * @return int
     */
    public static int b2Body_GetContactCapacity(b2BodyId bodyId) {
        checkPointers(bodyId);
        return nb2Body_GetContactCapacity(bodyId.address());
    }

    /* {@code B2_API int b2Body_GetContactCapacity( b2BodyId bodyId ); } */
    public static native int nb2Body_GetContactCapacity(long bodyId);

    // --- [ b2Body_GetContactData ] ---

    /**
     * {@code B2_API int b2Body_GetContactData( b2BodyId bodyId, b2ContactData* contactData, int capacity ); }
     *
     * @param bodyId b2BodyId
     * @param contactData b2ContactData*
     * @param capacity int
     *
     * @return int
     */
    public static int b2Body_GetContactData(b2BodyId bodyId, b2ContactData contactData, int capacity) {
        checkPointers(bodyId, contactData);
        return nb2Body_GetContactData(bodyId.address(), contactData.address(), capacity);
    }

    /* {@code B2_API int b2Body_GetContactData( b2BodyId bodyId, b2ContactData* contactData, int capacity ); } */
    public static native int nb2Body_GetContactData(long bodyId, long contactData, int capacity);

    // --- [ b2Body_ComputeAABB ] ---

    /**
     * {@code B2_API b2AABB b2Body_ComputeAABB( b2BodyId bodyId ); }
     *
     * @param bodyId b2BodyId
     * @param __result store
     *
     * @return b2AABB
     */
    public static b2AABB b2Body_ComputeAABB(b2BodyId bodyId, b2AABB __result) {
        checkPointers(bodyId, __result);
        nb2Body_ComputeAABB(bodyId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2AABB b2Body_ComputeAABB( b2BodyId bodyId ); } */
    public static native void nb2Body_ComputeAABB(long bodyId, long __result);

    // --- [ b2CreateCircleShape ] ---

    /**
     * {@code B2_API b2ShapeId b2CreateCircleShape( b2BodyId bodyId, const b2ShapeDef* def, const b2Circle* circle ); }
     *
     * @param bodyId b2BodyId
     * @param def ConstB2ShapeDef
     * @param circle ConstB2Circle
     * @param __result store
     *
     * @return b2ShapeId
     */
    public static b2ShapeId b2CreateCircleShape(b2BodyId bodyId, ConstB2ShapeDef def, ConstB2Circle circle, b2ShapeId __result) {
        checkPointers(bodyId, def, circle, __result);
        nb2CreateCircleShape(bodyId.address(), def.address(), circle.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2ShapeId b2CreateCircleShape( b2BodyId bodyId, const b2ShapeDef* def, const b2Circle* circle ); } */
    public static native void nb2CreateCircleShape(long bodyId, long def, long circle, long __result);
    
    // --- [ b2CreateSegmentShape ] ---

    /**
     * {@code B2_API b2ShapeId b2CreateSegmentShape( b2BodyId bodyId, const b2ShapeDef* def, const b2Segment* segment ); }
     *
     * @param bodyId b2BodyId
     * @param def ConstB2ShapeDef
     * @param segment ConstB2Segment
     * @param __result store
     *
     * @return b2ShapeId
     */
    public static b2ShapeId b2CreateSegmentShape(b2BodyId bodyId, ConstB2ShapeDef def, ConstB2Segment segment, b2ShapeId __result) {
        checkPointers(bodyId, def, segment, __result);
        nb2CreateSegmentShape(bodyId.address(), def.address(), segment.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2ShapeId b2CreateSegmentShape( b2BodyId bodyId, const b2ShapeDef* def, const b2Segment* segment ); } */
    public static native void nb2CreateSegmentShape(long bodyId, long def, long segment, long __result);

    // --- [ b2CreateChainSegmentShape ] ---

    /**
     * {@code B2_API b2ShapeId b2CreateChainSegmentShape( b2BodyId bodyId, const b2ShapeDef* def, const b2ChainSegment* chainSegment ); }
     *
     * @param bodyId b2BodyId
     * @param def ConstB2ShapeDef
     * @param chainSegment ConstB2ChainSegment
     * @param __result store
     *
     * @return b2ShapeId
     */
    public static b2ShapeId b2CreateChainSegmentShape(b2BodyId bodyId, ConstB2ShapeDef def, ConstB2ChainSegment chainSegment, b2ShapeId __result) {
        checkPointers(bodyId, def, chainSegment, __result);
        nb2CreateChainSegmentShape(bodyId.address(), def.address(), chainSegment.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2ShapeId b2CreateChainSegmentShape( b2BodyId bodyId, const b2ShapeDef* def, const b2ChainSegment* chainSegment ); } */
    public static native void nb2CreateChainSegmentShape(long bodyId, long def, long chainSegment, long __result);

    // --- [ b2CreateCapsuleShape ] ---

    /**
     * {@code B2_API b2ShapeId b2CreateCapsuleShape( b2BodyId bodyId, const b2ShapeDef* def, const b2Capsule* capsule ); }
     *
     * @param bodyId b2BodyId
     * @param def ConstB2ShapeDef
     * @param capsule ConstB2Capsule
     * @param __result store
     *
     * @return b2ShapeId
     */
    public static b2ShapeId b2CreateCapsuleShape(b2BodyId bodyId, ConstB2ShapeDef def, ConstB2Capsule capsule, b2ShapeId __result) {
        checkPointers(bodyId, def, capsule, __result);
        nb2CreateCapsuleShape(bodyId.address(), def.address(), capsule.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2ShapeId b2CreateCapsuleShape( b2BodyId bodyId, const b2ShapeDef* def, const b2Capsule* capsule ); } */
    public static native void nb2CreateCapsuleShape(long bodyId, long def, long capsule, long __result);

    // --- [ b2CreatePolygonShape ] ---

    /**
     * {@code B2_API b2ShapeId b2CreatePolygonShape( b2BodyId bodyId, const b2ShapeDef* def, const b2Polygon* polygon ); }
     *
     * @param bodyId b2BodyId
     * @param def ConstB2ShapeDef
     * @param polygon ConstB2Polygon
     * @param __result store
     *
     * @return b2ShapeId
     */
    public static b2ShapeId b2CreatePolygonShape(b2BodyId bodyId, ConstB2ShapeDef def, ConstB2Polygon polygon, b2ShapeId __result) {
        checkPointers(bodyId, def, polygon, __result);
        nb2CreatePolygonShape(bodyId.address(), def.address(), polygon.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2ShapeId b2CreatePolygonShape( b2BodyId bodyId, const b2ShapeDef* def, const b2Polygon* polygon ); } */
    public static native void nb2CreatePolygonShape(long bodyId, long def, long polygon, long __result);
    
    // --- [ b2DestroyShape ] ---

    /**
     * {@code B2_API void b2DestroyShape( b2ShapeId shapeId, bool updateBodyMass ); }
     *
     * @param shapeId b2ShapeId
     * @param updateBodyMass boolean
     */
    public static void b2DestroyShape(b2ShapeId shapeId, boolean updateBodyMass) {
        checkPointers(shapeId);
        nb2DestroyShape(shapeId.address(), updateBodyMass);
    }

    /* {@code B2_API void b2DestroyShape( b2ShapeId shapeId, bool updateBodyMass ); } */
    public static native void nb2DestroyShape(long shapeId, boolean updateBodyMass);

    // --- [ b2Shape_IsValid ] ---

    /**
     * {@code B2_API bool b2Shape_IsValid( b2ShapeId id ); }
     *
     * @param id b2ShapeId
     *
     * @return boolean
     */
    public static boolean b2Shape_IsValid(b2ShapeId id) {
        checkPointers(id);
        return nb2Shape_IsValid(id.address());
    }

    /* {@code B2_API bool b2Shape_IsValid( b2ShapeId id ); } */
    public static native boolean nb2Shape_IsValid(long id);

    // --- [ b2Shape_GetType ] ---

    /**
     * {@code B2_API b2ShapeType b2Shape_GetType( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     *
     * @return int
     */
    public static b2ShapeType b2Shape_GetType(b2ShapeId shapeId) {
        checkPointers(shapeId);
        int __result = nb2Shape_GetType(shapeId.address());
        return b2ShapeType.valueOf(__result);
    }

    /* {@code B2_API b2ShapeType b2Shape_GetType( b2ShapeId shapeId ); } */
    public static native int nb2Shape_GetType(long shapeId);

    // --- [ b2Shape_GetBody ] ---

    /**
     * {@code B2_API b2BodyId b2Shape_GetBody( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     * @param __result store
     *
     * @return b2BodyId
     */
    public static b2BodyId b2Shape_GetBody(b2ShapeId shapeId, b2BodyId __result) {
        checkPointers(shapeId, __result);
        nb2Shape_GetBody(shapeId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2BodyId b2Shape_GetBody( b2ShapeId shapeId ); } */
    public static native void nb2Shape_GetBody(long shapeId, long __result);

    // --- [ b2Shape_GetWorld ] ---

    /**
     * {@code B2_API b2WorldId b2Shape_GetWorld( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     * @param __result store
     *
     * @return b2WorldId
     */
    public static b2WorldId b2Shape_GetWorld(b2ShapeId shapeId, b2WorldId __result) {
        checkPointers(shapeId, __result);
        nb2Shape_GetWorld(shapeId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2WorldId b2Shape_GetWorld( b2ShapeId shapeId ); } */
    public static native void nb2Shape_GetWorld(long shapeId, long __result);

    // --- [ b2Shape_IsSensor ] ---

    /**
     * {@code B2_API bool b2Shape_IsSensor( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     *
     * @return boolean
     */
    public static boolean b2Shape_IsSensor(b2ShapeId shapeId) {
        checkPointers(shapeId);
        return nb2Shape_IsSensor(shapeId.address());
    }

    /* {@code B2_API bool b2Shape_IsSensor( b2ShapeId shapeId ); } */
    public static native boolean nb2Shape_IsSensor(long shapeId);

    // --- [ b2Shape_SetUserData ] ---

    /**
     * {@code B2_API void b2Shape_SetUserData( b2ShapeId shapeId, void* userData ); }
     *
     * @param shapeId b2ShapeId
     * @param userData long
     */
    public static void b2Shape_SetUserData(b2ShapeId shapeId, long userData) {
        checkPointers(shapeId);
        nb2Shape_SetUserData(shapeId.address(), userData);
    }

    /* {@code B2_API void b2Shape_SetUserData( b2ShapeId shapeId, void* userData ); } */
    public static native void nb2Shape_SetUserData(long shapeId, long userData);

    // --- [ b2Shape_GetUserData ] ---

    /**
     * {@code B2_API void* b2Shape_GetUserData( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     *
     * @return long
     */
    public static long b2Shape_GetUserData(b2ShapeId shapeId) {
        checkPointers(shapeId);
        return nb2Shape_GetUserData(shapeId.address());
    }

    /* {@code B2_API void* b2Shape_GetUserData( b2ShapeId shapeId ); } */
    public static native long nb2Shape_GetUserData(long shapeId);

    // --- [ b2Shape_SetDensity ] ---

    /**
     * {@code B2_API void b2Shape_SetDensity( b2ShapeId shapeId, float density, bool updateBodyMass ); }
     *
     * @param shapeId b2ShapeId
     * @param density float
     * @param updateBodyMass boolean
     */
    public static void b2Shape_SetDensity(b2ShapeId shapeId, float density, boolean updateBodyMass) {
        checkPointers(shapeId);
        nb2Shape_SetDensity(shapeId.address(), density, updateBodyMass);
    }

    /* {@code B2_API void b2Shape_SetDensity( b2ShapeId shapeId, float density, bool updateBodyMass ); } */
    public static native void nb2Shape_SetDensity(long shapeId, float density, boolean updateBodyMass);

    // --- [ b2Shape_GetDensity ] ---

    /**
     * {@code B2_API float b2Shape_GetDensity( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     *
     * @return float
     */
    public static float b2Shape_GetDensity(b2ShapeId shapeId) {
        checkPointers(shapeId);
        return nb2Shape_GetDensity(shapeId.address());
    }

    /* {@code B2_API float b2Shape_GetDensity( b2ShapeId shapeId ); } */
    public static native float nb2Shape_GetDensity(long shapeId);

    // --- [ b2Shape_SetFriction ] ---

    /**
     * {@code B2_API void b2Shape_SetFriction( b2ShapeId shapeId, float friction ); }
     *
     * @param shapeId b2ShapeId
     * @param friction float
     */
    public static void b2Shape_SetFriction(b2ShapeId shapeId, float friction) {
        checkPointers(shapeId);
        nb2Shape_SetFriction(shapeId.address(), friction);
    }

    /* {@code B2_API void b2Shape_SetFriction( b2ShapeId shapeId, float friction ); } */
    public static native void nb2Shape_SetFriction(long shapeId, float friction);

    // --- [ b2Shape_GetFriction ] ---

    /**
     * {@code B2_API float b2Shape_GetFriction( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     *
     * @return float
     */
    public static float b2Shape_GetFriction(b2ShapeId shapeId) {
        checkPointers(shapeId);
        return nb2Shape_GetFriction(shapeId.address());
    }

    /* {@code B2_API float b2Shape_GetFriction( b2ShapeId shapeId ); } */
    public static native float nb2Shape_GetFriction(long shapeId);

    // --- [ b2Shape_SetRestitution ] ---

    /**
     * {@code B2_API void b2Shape_SetRestitution( b2ShapeId shapeId, float restitution ); }
     *
     * @param shapeId b2ShapeId
     * @param restitution float
     */
    public static void b2Shape_SetRestitution(b2ShapeId shapeId, float restitution) {
        checkPointers(shapeId);
        nb2Shape_SetRestitution(shapeId.address(), restitution);
    }

    /* {@code B2_API void b2Shape_SetRestitution( b2ShapeId shapeId, float restitution ); } */
    public static native void nb2Shape_SetRestitution(long shapeId, float restitution);

    // --- [ b2Shape_GetRestitution ] ---

    /**
     * {@code B2_API float b2Shape_GetRestitution( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     *
     * @return float
     */
    public static float b2Shape_GetRestitution(b2ShapeId shapeId) {
        checkPointers(shapeId);
        return nb2Shape_GetRestitution(shapeId.address());
    }

    /* {@code B2_API float b2Shape_GetRestitution( b2ShapeId shapeId ); } */
    public static native float nb2Shape_GetRestitution(long shapeId);

    // --- [ b2Shape_SetUserMaterial ] ---

    /**
     * {@code B2_API void b2Shape_SetUserMaterial( b2ShapeId shapeId, uint64_t material ); }
     *
     * @param shapeId b2ShapeId
     * @param material long
     */
    public static void b2Shape_SetUserMaterial(b2ShapeId shapeId, long material) {
        checkPointers(shapeId);
        nb2Shape_SetUserMaterial(shapeId.address(), material);
    }

    /* {@code B2_API void b2Shape_SetUserMaterial( b2ShapeId shapeId, uint64_t material ); } */
    public static native void nb2Shape_SetUserMaterial(long shapeId, long material);

    // --- [ b2Shape_GetUserMaterial ] ---

    /**
     * {@code B2_API uint64_t b2Shape_GetUserMaterial( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     *
     * @return long
     */
    public static long b2Shape_GetUserMaterial(b2ShapeId shapeId) {
        checkPointers(shapeId);
        return nb2Shape_GetUserMaterial(shapeId.address());
    }

    /* {@code B2_API uint64_t b2Shape_GetUserMaterial( b2ShapeId shapeId ); } */
    public static native long nb2Shape_GetUserMaterial(long shapeId);

    // --- [ b2Shape_SetSurfaceMaterial ] ---

    /**
     * {@code B2_API void b2Shape_SetSurfaceMaterial( b2ShapeId shapeId, const b2SurfaceMaterial* surfaceMaterial ); }
     *
     * @param shapeId b2ShapeId
     * @param surfaceMaterial ConstB2SurfaceMaterial
     */
    public static void b2Shape_SetSurfaceMaterial(b2ShapeId shapeId, ConstB2SurfaceMaterial surfaceMaterial) {
        checkPointers(shapeId, surfaceMaterial);
        nb2Shape_SetSurfaceMaterial(shapeId.address(), surfaceMaterial.address());
    }

    /* {@code B2_API void b2Shape_SetSurfaceMaterial( b2ShapeId shapeId, const b2SurfaceMaterial* surfaceMaterial ); } */
    public static native void nb2Shape_SetSurfaceMaterial(long shapeId, long surfaceMaterial);

    // --- [ b2Shape_GetSurfaceMaterial ] ---

    /**
     * {@code B2_API b2SurfaceMaterial b2Shape_GetSurfaceMaterial( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     * @param __result store
     *
     * @return b2SurfaceMaterial
     */
    public static b2SurfaceMaterial b2Shape_GetSurfaceMaterial(b2ShapeId shapeId, b2SurfaceMaterial __result) {
        checkPointers(shapeId, __result);
        nb2Shape_GetSurfaceMaterial(shapeId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2SurfaceMaterial b2Shape_GetSurfaceMaterial( b2ShapeId shapeId ); } */
    public static native void nb2Shape_GetSurfaceMaterial(long shapeId, long __result);
    
    // --- [ b2Shape_GetFilter ] ---

    /**
     * {@code B2_API b2Filter b2Shape_GetFilter( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     * @param __result store
     *
     * @return b2Filter
     */
    public static b2Filter b2Shape_GetFilter(b2ShapeId shapeId, b2Filter __result) {
        checkPointers(shapeId, __result);
        nb2Shape_GetFilter(shapeId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Filter b2Shape_GetFilter( b2ShapeId shapeId ); } */
    public static native void nb2Shape_GetFilter(long shapeId, long __result);

    // --- [ b2Shape_SetFilter ] ---

    /**
     * {@code B2_API void b2Shape_SetFilter( b2ShapeId shapeId, b2Filter filter ); }
     *
     * @param shapeId b2ShapeId
     * @param filter b2Filter
     */
    public static void b2Shape_SetFilter(b2ShapeId shapeId, b2Filter filter) {
        checkPointers(shapeId, filter);
        nb2Shape_SetFilter(shapeId.address(), filter.address());
    }

    /* {@code B2_API void b2Shape_SetFilter( b2ShapeId shapeId, b2Filter filter ); } */
    public static native void nb2Shape_SetFilter(long shapeId, long filter);

    // --- [ b2Shape_EnableSensorEvents ] ---

    /**
     * {@code B2_API void b2Shape_EnableSensorEvents( b2ShapeId shapeId, bool flag ); }
     *
     * @param shapeId b2ShapeId
     * @param flag boolean
     */
    public static void b2Shape_EnableSensorEvents(b2ShapeId shapeId, boolean flag) {
        checkPointers(shapeId);
        nb2Shape_EnableSensorEvents(shapeId.address(), flag);
    }

    /* {@code B2_API void b2Shape_EnableSensorEvents( b2ShapeId shapeId, bool flag ); } */
    public static native void nb2Shape_EnableSensorEvents(long shapeId, boolean flag);

    // --- [ b2Shape_AreSensorEventsEnabled ] ---

    /**
     * {@code B2_API bool b2Shape_AreSensorEventsEnabled( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     *
     * @return boolean
     */
    public static boolean b2Shape_AreSensorEventsEnabled(b2ShapeId shapeId) {
        checkPointers(shapeId);
        return nb2Shape_AreSensorEventsEnabled(shapeId.address());
    }

    /* {@code B2_API bool b2Shape_AreSensorEventsEnabled( b2ShapeId shapeId ); } */
    public static native boolean nb2Shape_AreSensorEventsEnabled(long shapeId);

    // --- [ b2Shape_EnableContactEvents ] ---

    /**
     * {@code B2_API void b2Shape_EnableContactEvents( b2ShapeId shapeId, bool flag ); }
     *
     * @param shapeId b2ShapeId
     * @param flag boolean
     */
    public static void b2Shape_EnableContactEvents(b2ShapeId shapeId, boolean flag) {
        checkPointers(shapeId);
        nb2Shape_EnableContactEvents(shapeId.address(), flag);
    }

    /* {@code B2_API void b2Shape_EnableContactEvents( b2ShapeId shapeId, bool flag ); } */
    public static native void nb2Shape_EnableContactEvents(long shapeId, boolean flag);

    // --- [ b2Shape_AreContactEventsEnabled ] ---

    /**
     * {@code B2_API bool b2Shape_AreContactEventsEnabled( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     *
     * @return boolean
     */
    public static boolean b2Shape_AreContactEventsEnabled(b2ShapeId shapeId) {
        checkPointers(shapeId);
        return nb2Shape_AreContactEventsEnabled(shapeId.address());
    }

    /* {@code B2_API bool b2Shape_AreContactEventsEnabled( b2ShapeId shapeId ); } */
    public static native boolean nb2Shape_AreContactEventsEnabled(long shapeId);

    // --- [ b2Shape_EnablePreSolveEvents ] ---

    /**
     * {@code B2_API void b2Shape_EnablePreSolveEvents( b2ShapeId shapeId, bool flag ); }
     *
     * @param shapeId b2ShapeId
     * @param flag boolean
     */
    public static void b2Shape_EnablePreSolveEvents(b2ShapeId shapeId, boolean flag) {
        checkPointers(shapeId);
        nb2Shape_EnablePreSolveEvents(shapeId.address(), flag);
    }

    /* {@code B2_API void b2Shape_EnablePreSolveEvents( b2ShapeId shapeId, bool flag ); } */
    public static native void nb2Shape_EnablePreSolveEvents(long shapeId, boolean flag);

    // --- [ b2Shape_ArePreSolveEventsEnabled ] ---

    /**
     * {@code B2_API bool b2Shape_ArePreSolveEventsEnabled( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     *
     * @return boolean
     */
    public static boolean b2Shape_ArePreSolveEventsEnabled(b2ShapeId shapeId) {
        checkPointers(shapeId);
        return nb2Shape_ArePreSolveEventsEnabled(shapeId.address());
    }

    /* {@code B2_API bool b2Shape_ArePreSolveEventsEnabled( b2ShapeId shapeId ); } */
    public static native boolean nb2Shape_ArePreSolveEventsEnabled(long shapeId);

    // --- [ b2Shape_EnableHitEvents ] ---

    /**
     * {@code B2_API void b2Shape_EnableHitEvents( b2ShapeId shapeId, bool flag ); }
     *
     * @param shapeId b2ShapeId
     * @param flag boolean
     */
    public static void b2Shape_EnableHitEvents(b2ShapeId shapeId, boolean flag) {
        checkPointers(shapeId);
        nb2Shape_EnableHitEvents(shapeId.address(), flag);
    }

    /* {@code B2_API void b2Shape_EnableHitEvents( b2ShapeId shapeId, bool flag ); } */
    public static native void nb2Shape_EnableHitEvents(long shapeId, boolean flag);

    // --- [ b2Shape_AreHitEventsEnabled ] ---

    /**
     * {@code B2_API bool b2Shape_AreHitEventsEnabled( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     *
     * @return boolean
     */
    public static boolean b2Shape_AreHitEventsEnabled(b2ShapeId shapeId) {
        checkPointers(shapeId);
        return nb2Shape_AreHitEventsEnabled(shapeId.address());
    }

    /* {@code B2_API bool b2Shape_AreHitEventsEnabled( b2ShapeId shapeId ); } */
    public static native boolean nb2Shape_AreHitEventsEnabled(long shapeId);

    // --- [ b2Shape_TestPoint ] ---

    /**
     * {@code B2_API bool b2Shape_TestPoint( b2ShapeId shapeId, b2Vec2 point ); }
     *
     * @param shapeId b2ShapeId
     * @param point b2Vec2
     *
     * @return boolean
     */
    public static boolean b2Shape_TestPoint(b2ShapeId shapeId, b2Vec2 point) {
        checkPointers(shapeId, point);
        return nb2Shape_TestPoint(shapeId.address(), point.address());
    }

    /* {@code B2_API bool b2Shape_TestPoint( b2ShapeId shapeId, b2Vec2 point ); } */
    public static native boolean nb2Shape_TestPoint(long shapeId, long point);

    // --- [ b2Shape_RayCast ] ---

    /**
     * {@code B2_API b2CastOutput b2Shape_RayCast( b2ShapeId shapeId, const b2RayCastInput* input ); }
     *
     * @param shapeId b2ShapeId
     * @param input ConstB2RayCastInput
     * @param __result store
     *
     * @return b2CastOutput
     */
    public static b2CastOutput b2Shape_RayCast(b2ShapeId shapeId, ConstB2RayCastInput input, b2CastOutput __result) {
        checkPointers(shapeId, input, __result);
        nb2Shape_RayCast(shapeId.address(), input.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2CastOutput b2Shape_RayCast( b2ShapeId shapeId, const b2RayCastInput* input ); } */
    public static native void nb2Shape_RayCast(long shapeId, long input, long __result);

    // --- [ b2Shape_GetCircle ] ---

    /**
     * {@code B2_API b2Circle b2Shape_GetCircle( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     * @param __result store
     *
     * @return b2Circle
     */
    public static b2Circle b2Shape_GetCircle(b2ShapeId shapeId, b2Circle __result) {
        checkPointers(shapeId, __result);
        nb2Shape_GetCircle(shapeId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Circle b2Shape_GetCircle( b2ShapeId shapeId ); } */
    public static native void nb2Shape_GetCircle(long shapeId, long __result);

    // --- [ b2Shape_GetSegment ] ---

    /**
     * {@code B2_API b2Segment b2Shape_GetSegment( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     * @param __result store
     *
     * @return b2Segment
     */
    public static b2Segment b2Shape_GetSegment(b2ShapeId shapeId, b2Segment __result) {
        checkPointers(shapeId, __result);
        nb2Shape_GetSegment(shapeId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Segment b2Shape_GetSegment( b2ShapeId shapeId ); } */
    public static native void nb2Shape_GetSegment(long shapeId, long __result);

    // --- [ b2Shape_GetChainSegment ] ---

    /**
     * {@code B2_API b2ChainSegment b2Shape_GetChainSegment( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     * @param __result store
     *
     * @return b2ChainSegment
     */
    public static b2ChainSegment b2Shape_GetChainSegment(b2ShapeId shapeId, b2ChainSegment __result) {
        checkPointers(shapeId, __result);
        nb2Shape_GetChainSegment(shapeId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2ChainSegment b2Shape_GetChainSegment( b2ShapeId shapeId ); } */
    public static native void nb2Shape_GetChainSegment(long shapeId, long __result);

    // --- [ b2Shape_GetCapsule ] ---

    /**
     * {@code B2_API b2Capsule b2Shape_GetCapsule( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     * @param __result store
     *
     * @return b2Capsule
     */
    public static b2Capsule b2Shape_GetCapsule(b2ShapeId shapeId, b2Capsule __result) {
        checkPointers(shapeId, __result);
        nb2Shape_GetCapsule(shapeId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Capsule b2Shape_GetCapsule( b2ShapeId shapeId ); } */
    public static native void nb2Shape_GetCapsule(long shapeId, long __result);

    // --- [ b2Shape_GetPolygon ] ---

    /**
     * {@code B2_API b2Polygon b2Shape_GetPolygon( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     * @param __result store
     *
     * @return b2Polygon
     */
    public static b2Polygon b2Shape_GetPolygon(b2ShapeId shapeId, b2Polygon __result) {
        checkPointers(shapeId, __result);
        nb2Shape_GetPolygon(shapeId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Polygon b2Shape_GetPolygon( b2ShapeId shapeId ); } */
    public static native void nb2Shape_GetPolygon(long shapeId, long __result);
    
    // --- [ b2Shape_SetCircle ] ---

    /**
     * {@code B2_API void b2Shape_SetCircle( b2ShapeId shapeId, const b2Circle* circle ); }
     *
     * @param shapeId b2ShapeId
     * @param circle ConstB2Circle
     */
    public static void b2Shape_SetCircle(b2ShapeId shapeId, ConstB2Circle circle) {
        checkPointers(shapeId, circle);
        nb2Shape_SetCircle(shapeId.address(), circle.address());
    }

    /* {@code B2_API void b2Shape_SetCircle( b2ShapeId shapeId, const b2Circle* circle ); } */
    public static native void nb2Shape_SetCircle(long shapeId, long circle);

    // --- [ b2Shape_SetCapsule ] ---

    /**
     * {@code B2_API void b2Shape_SetCapsule( b2ShapeId shapeId, const b2Capsule* capsule ); }
     *
     * @param shapeId b2ShapeId
     * @param capsule ConstB2Capsule
     */
    public static void b2Shape_SetCapsule(b2ShapeId shapeId, ConstB2Capsule capsule) {
        checkPointers(shapeId, capsule);
        nb2Shape_SetCapsule(shapeId.address(), capsule.address());
    }

    /* {@code B2_API void b2Shape_SetCapsule( b2ShapeId shapeId, const b2Capsule* capsule ); } */
    public static native void nb2Shape_SetCapsule(long shapeId, long capsule);

    // --- [ b2Shape_SetSegment ] ---

    /**
     * {@code B2_API void b2Shape_SetSegment( b2ShapeId shapeId, const b2Segment* segment ); }
     *
     * @param shapeId b2ShapeId
     * @param segment ConstB2Segment
     */
    public static void b2Shape_SetSegment(b2ShapeId shapeId, ConstB2Segment segment) {
        checkPointers(shapeId, segment);
        nb2Shape_SetSegment(shapeId.address(), segment.address());
    }

    /* {@code B2_API void b2Shape_SetSegment( b2ShapeId shapeId, const b2Segment* segment ); } */
    public static native void nb2Shape_SetSegment(long shapeId, long segment);

    // --- [ b2Shape_SetPolygon ] ---

    /**
     * {@code B2_API void b2Shape_SetPolygon( b2ShapeId shapeId, const b2Polygon* polygon ); }
     *
     * @param shapeId b2ShapeId
     * @param polygon ConstB2Polygon
     */
    public static void b2Shape_SetPolygon(b2ShapeId shapeId, ConstB2Polygon polygon) {
        checkPointers(shapeId, polygon);
        nb2Shape_SetPolygon(shapeId.address(), polygon.address());
    }

    /* {@code B2_API void b2Shape_SetPolygon( b2ShapeId shapeId, const b2Polygon* polygon ); } */
    public static native void nb2Shape_SetPolygon(long shapeId, long polygon);

    // --- [ b2Shape_SetChainSegment ] ---

    /**
     * {@code B2_API void b2Shape_SetChainSegment( b2ShapeId shapeId, const b2ChainSegment* chainSegment ); }
     *
     * @param shapeId b2ShapeId
     * @param chainSegment ConstB2ChainSegment
     */
    public static void b2Shape_SetChainSegment(b2ShapeId shapeId, ConstB2ChainSegment chainSegment) {
        checkPointers(shapeId, chainSegment);
        nb2Shape_SetChainSegment(shapeId.address(), chainSegment.address());
    }

    /* {@code B2_API void b2Shape_SetChainSegment( b2ShapeId shapeId, const b2ChainSegment* chainSegment ); } */
    public static native void nb2Shape_SetChainSegment(long shapeId, long chainSegment);

    // --- [ b2Shape_GetParentChain ] ---

    /**
     * {@code B2_API b2ChainId b2Shape_GetParentChain( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     * @param __result store
     *
     * @return b2ChainId
     */
    public static b2ChainId b2Shape_GetParentChain(b2ShapeId shapeId, b2ChainId __result) {
        checkPointers(shapeId, __result);
        nb2Shape_GetParentChain(shapeId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2ChainId b2Shape_GetParentChain( b2ShapeId shapeId ); } */
    public static native void nb2Shape_GetParentChain(long shapeId, long __result);

    // --- [ b2Shape_GetContactCapacity ] ---

    /**
     * {@code B2_API int b2Shape_GetContactCapacity( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     *
     * @return int
     */
    public static int b2Shape_GetContactCapacity(b2ShapeId shapeId) {
        checkPointers(shapeId);
        return nb2Shape_GetContactCapacity(shapeId.address());
    }

    /* {@code B2_API int b2Shape_GetContactCapacity( b2ShapeId shapeId ); } */
    public static native int nb2Shape_GetContactCapacity(long shapeId);

    // --- [ b2Shape_GetContactData ] ---

    /**
     * {@code B2_API int b2Shape_GetContactData( b2ShapeId shapeId, b2ContactData* contactData, int capacity ); }
     *
     * @param shapeId b2ShapeId
     * @param contactData long
     * @param capacity int
     *
     * @return int
     */
    public static int b2Shape_GetContactData(b2ShapeId shapeId, b2ContactData contactData, int capacity) {
        checkPointers(shapeId, contactData);
        return nb2Shape_GetContactData(shapeId.address(), contactData.address(), capacity);
    }

    /* {@code B2_API int b2Shape_GetContactData( b2ShapeId shapeId, b2ContactData* contactData, int capacity ); } */
    public static native int nb2Shape_GetContactData(long shapeId, long contactData, int capacity);

    // --- [ b2Shape_GetSensorCapacity ] ---

    /**
     * {@code B2_API int b2Shape_GetSensorCapacity( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     *
     * @return int
     */
    public static int b2Shape_GetSensorCapacity(b2ShapeId shapeId) {
        checkPointers(shapeId);
        return nb2Shape_GetSensorCapacity(shapeId.address());
    }

    /* {@code B2_API int b2Shape_GetSensorCapacity( b2ShapeId shapeId ); } */
    public static native int nb2Shape_GetSensorCapacity(long shapeId);

    // --- [ b2Shape_GetSensorData ] ---

    /**
     * {@code B2_API int b2Shape_GetSensorData( b2ShapeId shapeId, b2ShapeId* visitorIds, int capacity ); }
     *
     * @param shapeId b2ShapeId
     * @param visitorIds long
     * @param capacity int
     *
     * @return int
     */
    public static int b2Shape_GetSensorData(b2ShapeId shapeId, b2ShapeId visitorIds, int capacity) {
        checkPointers(shapeId, visitorIds);
        return nb2Shape_GetSensorData(shapeId.address(), visitorIds.address(), capacity);
    }

    /* {@code B2_API int b2Shape_GetSensorData( b2ShapeId shapeId, b2ShapeId* visitorIds, int capacity ); } */
    public static native int nb2Shape_GetSensorData(long shapeId, long visitorIds, int capacity);

    // --- [ b2Shape_GetAABB ] ---

    /**
     * {@code B2_API b2AABB b2Shape_GetAABB( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     * @param __result store
     *
     * @return b2AABB
     */
    public static b2AABB b2Shape_GetAABB(b2ShapeId shapeId, b2AABB __result) {
        checkPointers(shapeId, __result);
        nb2Shape_GetAABB(shapeId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2AABB b2Shape_GetAABB( b2ShapeId shapeId ); } */
    public static native void nb2Shape_GetAABB(long shapeId, long __result);

    // --- [ b2Shape_ComputeMassData ] ---

    /**
     * {@code B2_API b2MassData b2Shape_ComputeMassData( b2ShapeId shapeId ); }
     *
     * @param shapeId b2ShapeId
     * @param __result store
     *
     * @return b2MassData
     */
    public static b2MassData b2Shape_ComputeMassData(b2ShapeId shapeId, b2MassData __result) {
        checkPointers(shapeId, __result);
        nb2Shape_ComputeMassData(shapeId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2MassData b2Shape_ComputeMassData( b2ShapeId shapeId ); } */
    public static native void nb2Shape_ComputeMassData(long shapeId, long __result);

    // --- [ b2Shape_GetClosestPoint ] ---

    /**
     * {@code B2_API b2Vec2 b2Shape_GetClosestPoint( b2ShapeId shapeId, b2Vec2 target ); }
     *
     * @param shapeId b2ShapeId
     * @param target b2Vec2
     * @param __result store
     *
     * @return b2Vec2
     */
    public static b2Vec2 b2Shape_GetClosestPoint(b2ShapeId shapeId, b2Vec2 target, b2Vec2 __result) {
        checkPointers(shapeId, target, __result);
        nb2Shape_GetClosestPoint(shapeId.address(), target.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Vec2 b2Shape_GetClosestPoint( b2ShapeId shapeId, b2Vec2 target ); } */
    public static native void nb2Shape_GetClosestPoint(long shapeId, long target, long __result);

    // --- [ b2Shape_ApplyWind ] ---

    /**
     * {@code B2_API void b2Shape_ApplyWind( b2ShapeId shapeId, b2Vec2 wind, float drag, float lift, bool wake ); }
     *
     * @param shapeId b2ShapeId
     * @param wind b2Vec2
     * @param drag float
     * @param lift float
     * @param wake boolean
     */
    public static void b2Shape_ApplyWind(b2ShapeId shapeId, b2Vec2 wind, float drag, float lift, boolean wake) {
        checkPointers(shapeId, wind);
        nb2Shape_ApplyWind(shapeId.address(), wind.address(), drag, lift, wake);
    }

    /* {@code B2_API void b2Shape_ApplyWind( b2ShapeId shapeId, b2Vec2 wind, float drag, float lift, bool wake ); } */
    public static native void nb2Shape_ApplyWind(long shapeId, long wind, float drag, float lift, boolean wake);
    
    // --- [ b2CreateChain ] ---

    /**
     * {@code B2_API b2ChainId b2CreateChain( b2BodyId bodyId, const b2ChainDef* def ); }
     *
     * @param bodyId b2BodyId
     * @param def ConstB2ChainDef
     * @param __result store
     *
     * @return b2ChainId
     */
    public static b2ChainId b2CreateChain(b2BodyId bodyId, ConstB2ChainDef def, b2ChainId __result) {
        checkPointers(bodyId, def, __result);
        nb2CreateChain(bodyId.address(), def.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2ChainId b2CreateChain( b2BodyId bodyId, const b2ChainDef* def ); } */
    public static native void nb2CreateChain(long bodyId, long def, long __result);

    // --- [ b2DestroyChain ] ---

    /**
     * {@code B2_API void b2DestroyChain( b2ChainId chainId ); }
     *
     * @param chainId b2ChainId
     */
    public static void b2DestroyChain(b2ChainId chainId) {
        checkPointers(chainId);
        nb2DestroyChain(chainId.address());
    }

    /* {@code B2_API void b2DestroyChain( b2ChainId chainId ); } */
    public static native void nb2DestroyChain(long chainId);

    // --- [ b2Chain_GetWorld ] ---

    /**
     * {@code B2_API b2WorldId b2Chain_GetWorld( b2ChainId chainId ); }
     *
     * @param chainId b2ChainId
     * @param __result store
     *
     * @return b2WorldId
     */
    public static b2WorldId b2Chain_GetWorld(b2ChainId chainId, b2WorldId __result) {
        checkPointers(chainId, __result);
        nb2Chain_GetWorld(chainId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2WorldId b2Chain_GetWorld( b2ChainId chainId ); } */
    public static native void nb2Chain_GetWorld(long chainId, long __result);

    // --- [ b2Chain_GetSegmentCount ] ---

    /**
     * {@code B2_API int b2Chain_GetSegmentCount( b2ChainId chainId ); }
     *
     * @param chainId b2ChainId
     *
     * @return int
     */
    public static int b2Chain_GetSegmentCount(b2ChainId chainId) {
        checkPointers(chainId);
        return nb2Chain_GetSegmentCount(chainId.address());
    }

    /* {@code B2_API int b2Chain_GetSegmentCount( b2ChainId chainId ); } */
    public static native int nb2Chain_GetSegmentCount(long chainId);

    // --- [ b2Chain_GetSegments ] ---

    /**
     * {@code B2_API int b2Chain_GetSegments( b2ChainId chainId, b2ShapeId* segmentArray, int capacity ); }
     *
     * @param chainId b2ChainId
     * @param segmentArray long
     * @param capacity int
     *
     * @return int
     */
    public static int b2Chain_GetSegments(b2ChainId chainId, b2ShapeId.Buffer segmentArray, int capacity) {
        checkPointers(chainId, segmentArray);
        return nb2Chain_GetSegments(chainId.address(), segmentArray.address(), capacity);
    }

    /* {@code B2_API int b2Chain_GetSegments( b2ChainId chainId, b2ShapeId* segmentArray, int capacity ); } */
    public static native int nb2Chain_GetSegments(long chainId, long segmentArray, int capacity);

    // --- [ b2Chain_GetSurfaceMaterialCount ] ---

    /**
     * {@code B2_API int b2Chain_GetSurfaceMaterialCount( b2ChainId chainId ); }
     *
     * @param chainId b2ChainId
     *
     * @return int
     */
    public static int b2Chain_GetSurfaceMaterialCount(b2ChainId chainId) {
        checkPointers(chainId);
        return nb2Chain_GetSurfaceMaterialCount(chainId.address());
    }

    /* {@code B2_API int b2Chain_GetSurfaceMaterialCount( b2ChainId chainId ); } */
    public static native int nb2Chain_GetSurfaceMaterialCount(long chainId);

    // --- [ b2Chain_SetSurfaceMaterial ] ---

    /**
     * {@code B2_API void b2Chain_SetSurfaceMaterial( b2ChainId chainId, const b2SurfaceMaterial* material, int materialIndex ); }
     *
     * @param chainId b2ChainId
     * @param material ConstB2SurfaceMaterial
     * @param materialIndex int
     */
    public static void b2Chain_SetSurfaceMaterial(b2ChainId chainId, ConstB2SurfaceMaterial material, int materialIndex) {
        checkPointers(chainId, material);
        nb2Chain_SetSurfaceMaterial(chainId.address(), material.address(), materialIndex);
    }

    /* {@code B2_API void b2Chain_SetSurfaceMaterial( b2ChainId chainId, const b2SurfaceMaterial* material, int materialIndex ); } */
    public static native void nb2Chain_SetSurfaceMaterial(long chainId, long material, int materialIndex);

    // --- [ b2Chain_GetSurfaceMaterial ] ---

    /**
     * {@code B2_API b2SurfaceMaterial b2Chain_GetSurfaceMaterial( b2ChainId chainId, int materialIndex ); }
     *
     * @param chainId b2ChainId
     * @param materialIndex int
     * @param __result store
     *
     * @return b2SurfaceMaterial
     */
    public static b2SurfaceMaterial b2Chain_GetSurfaceMaterial(b2ChainId chainId, int materialIndex, b2SurfaceMaterial __result) {
        checkPointers(chainId, __result);
        nb2Chain_GetSurfaceMaterial(chainId.address(), materialIndex, __result.address());
        return __result;
    }

    /* {@code B2_API b2SurfaceMaterial b2Chain_GetSurfaceMaterial( b2ChainId chainId, int materialIndex ); } */
    public static native void nb2Chain_GetSurfaceMaterial(long chainId, int materialIndex, long __result);

    // --- [ b2Chain_IsValid ] ---

    /**
     * {@code B2_API bool b2Chain_IsValid( b2ChainId id ); }
     *
     * @param id b2ChainId
     *
     * @return boolean
     */
    public static boolean b2Chain_IsValid(b2ChainId id) {
        checkPointers(id);
        return nb2Chain_IsValid(id.address());
    }

    /* {@code B2_API bool b2Chain_IsValid( b2ChainId id ); } */
    public static native boolean nb2Chain_IsValid(long id);
    
    // --- [ b2DestroyJoint ] ---

    /**
     * {@code B2_API void b2DestroyJoint( b2JointId jointId, bool wakeAttached ); }
     *
     * @param jointId b2JointId
     * @param wakeAttached boolean
     */
    public static void b2DestroyJoint(b2JointId jointId, boolean wakeAttached) {
        checkPointers(jointId);
        nb2DestroyJoint(jointId.address(), wakeAttached);
    }

    /* {@code B2_API void b2DestroyJoint( b2JointId jointId, bool wakeAttached ); } */
    public static native void nb2DestroyJoint(long jointId, boolean wakeAttached);

    // --- [ b2Joint_IsValid ] ---

    /**
     * {@code B2_API bool b2Joint_IsValid( b2JointId id ); }
     *
     * @param id b2JointId
     *
     * @return boolean
     */
    public static boolean b2Joint_IsValid(b2JointId id) {
        checkPointers(id);
        return nb2Joint_IsValid(id.address());
    }

    /* {@code B2_API bool b2Joint_IsValid( b2JointId id ); } */
    public static native boolean nb2Joint_IsValid(long id);

    // --- [ b2Joint_GetType ] ---

    /**
     * {@code B2_API b2JointType b2Joint_GetType( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return int
     */
    public static b2JointType b2Joint_GetType(b2JointId jointId) {
        checkPointers(jointId);
        int __result = nb2Joint_GetType(jointId.address());
        return b2JointType.valueOf(__result);
    }

    /* {@code B2_API b2JointType b2Joint_GetType( b2JointId jointId ); } */
    public static native int nb2Joint_GetType(long jointId);

    // --- [ b2Joint_GetBodyA ] ---

    /**
     * {@code B2_API b2BodyId b2Joint_GetBodyA( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     * @param __result store
     *
     * @return b2BodyId
     */
    public static b2BodyId b2Joint_GetBodyA(b2JointId jointId, b2BodyId __result) {
        checkPointers(jointId, __result);
        nb2Joint_GetBodyA(jointId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2BodyId b2Joint_GetBodyA( b2JointId jointId ); } */
    public static native void nb2Joint_GetBodyA(long jointId, long __result);

    // --- [ b2Joint_GetBodyB ] ---

    /**
     * {@code B2_API b2BodyId b2Joint_GetBodyB( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     * @param __result store
     *
     * @return b2BodyId
     */
    public static b2BodyId b2Joint_GetBodyB(b2JointId jointId, b2BodyId __result) {
        checkPointers(jointId, __result);
        nb2Joint_GetBodyB(jointId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2BodyId b2Joint_GetBodyB( b2JointId jointId ); } */
    public static native void nb2Joint_GetBodyB(long jointId, long __result);

    // --- [ b2Joint_GetWorld ] ---

    /**
     * {@code B2_API b2WorldId b2Joint_GetWorld( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     * @param __result store
     *
     * @return b2WorldId
     */
    public static b2WorldId b2Joint_GetWorld(b2JointId jointId, b2WorldId __result) {
        checkPointers(jointId, __result);
        nb2Joint_GetWorld(jointId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2WorldId b2Joint_GetWorld( b2JointId jointId ); } */
    public static native void nb2Joint_GetWorld(long jointId, long __result);

    // --- [ b2Joint_SetLocalFrameA ] ---

    /**
     * {@code B2_API void b2Joint_SetLocalFrameA( b2JointId jointId, b2Transform localFrame ); }
     *
     * @param jointId b2JointId
     * @param localFrame b2Transform
     */
    public static void b2Joint_SetLocalFrameA(b2JointId jointId, b2Transform localFrame) {
        checkPointers(jointId, localFrame);
        nb2Joint_SetLocalFrameA(jointId.address(), localFrame.address());
    }

    /* {@code B2_API void b2Joint_SetLocalFrameA( b2JointId jointId, b2Transform localFrame ); } */
    public static native void nb2Joint_SetLocalFrameA(long jointId, long localFrame);

    // --- [ b2Joint_GetLocalFrameA ] ---

    /**
     * {@code B2_API b2Transform b2Joint_GetLocalFrameA( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     * @param __result store
     *
     * @return b2Transform
     */
    public static b2Transform b2Joint_GetLocalFrameA(b2JointId jointId, b2Transform __result) {
        checkPointers(jointId, __result);
        nb2Joint_GetLocalFrameA(jointId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Transform b2Joint_GetLocalFrameA( b2JointId jointId ); } */
    public static native void nb2Joint_GetLocalFrameA(long jointId, long __result);

    // --- [ b2Joint_SetLocalFrameB ] ---

    /**
     * {@code B2_API void b2Joint_SetLocalFrameB( b2JointId jointId, b2Transform localFrame ); }
     *
     * @param jointId b2JointId
     * @param localFrame b2Transform
     */
    public static void b2Joint_SetLocalFrameB(b2JointId jointId, b2Transform localFrame) {
        checkPointers(jointId, localFrame);
        nb2Joint_SetLocalFrameB(jointId.address(), localFrame.address());
    }

    /* {@code B2_API void b2Joint_SetLocalFrameB( b2JointId jointId, b2Transform localFrame ); } */
    public static native void nb2Joint_SetLocalFrameB(long jointId, long localFrame);

    // --- [ b2Joint_GetLocalFrameB ] ---

    /**
     * {@code B2_API b2Transform b2Joint_GetLocalFrameB( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     * @param __result store
     *
     * @return b2Transform
     */
    public static b2Transform b2Joint_GetLocalFrameB(b2JointId jointId, b2Transform __result) {
        checkPointers(jointId, __result);
        nb2Joint_GetLocalFrameB(jointId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Transform b2Joint_GetLocalFrameB( b2JointId jointId ); } */
    public static native void nb2Joint_GetLocalFrameB(long jointId, long __result);

    // --- [ b2Joint_SetCollideConnected ] ---

    /**
     * {@code B2_API void b2Joint_SetCollideConnected( b2JointId jointId, bool shouldCollide ); }
     *
     * @param jointId b2JointId
     * @param shouldCollide boolean
     */
    public static void b2Joint_SetCollideConnected(b2JointId jointId, boolean shouldCollide) {
        checkPointers(jointId);
        nb2Joint_SetCollideConnected(jointId.address(), shouldCollide);
    }

    /* {@code B2_API void b2Joint_SetCollideConnected( b2JointId jointId, bool shouldCollide ); } */
    public static native void nb2Joint_SetCollideConnected(long jointId, boolean shouldCollide);

    // --- [ b2Joint_GetCollideConnected ] ---

    /**
     * {@code B2_API bool b2Joint_GetCollideConnected( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return boolean
     */
    public static boolean b2Joint_GetCollideConnected(b2JointId jointId) {
        checkPointers(jointId);
        return nb2Joint_GetCollideConnected(jointId.address());
    }

    /* {@code B2_API bool b2Joint_GetCollideConnected( b2JointId jointId ); } */
    public static native boolean nb2Joint_GetCollideConnected(long jointId);

    // --- [ b2Joint_SetUserData ] ---

    /**
     * {@code B2_API void b2Joint_SetUserData( b2JointId jointId, void* userData ); }
     *
     * @param jointId b2JointId
     * @param userData long
     */
    public static void b2Joint_SetUserData(b2JointId jointId, long userData) {
        checkPointers(jointId);
        nb2Joint_SetUserData(jointId.address(), userData);
    }

    /* {@code B2_API void b2Joint_SetUserData( b2JointId jointId, void* userData ); } */
    public static native void nb2Joint_SetUserData(long jointId, long userData);

    // --- [ b2Joint_GetUserData ] ---

    /**
     * {@code B2_API void* b2Joint_GetUserData( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return long
     */
    public static long b2Joint_GetUserData(b2JointId jointId) {
        checkPointers(jointId);
        return nb2Joint_GetUserData(jointId.address());
    }

    /* {@code B2_API void* b2Joint_GetUserData( b2JointId jointId ); } */
    public static native long nb2Joint_GetUserData(long jointId);

    // --- [ b2Joint_WakeBodies ] ---

    /**
     * {@code B2_API void b2Joint_WakeBodies( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     */
    public static void b2Joint_WakeBodies(b2JointId jointId) {
        checkPointers(jointId);
        nb2Joint_WakeBodies(jointId.address());
    }

    /* {@code B2_API void b2Joint_WakeBodies( b2JointId jointId ); } */
    public static native void nb2Joint_WakeBodies(long jointId);

    // --- [ b2Joint_GetConstraintForce ] ---

    /**
     * {@code B2_API b2Vec2 b2Joint_GetConstraintForce( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     * @param __result store
     *
     * @return b2Vec2
     */
    public static b2Vec2 b2Joint_GetConstraintForce(b2JointId jointId, b2Vec2 __result) {
        checkPointers(jointId, __result);
        nb2Joint_GetConstraintForce(jointId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Vec2 b2Joint_GetConstraintForce( b2JointId jointId ); } */
    public static native void nb2Joint_GetConstraintForce(long jointId, long __result);

    // --- [ b2Joint_GetConstraintTorque ] ---

    /**
     * {@code B2_API float b2Joint_GetConstraintTorque( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2Joint_GetConstraintTorque(b2JointId jointId) {
        checkPointers(jointId);
        return nb2Joint_GetConstraintTorque(jointId.address());
    }

    /* {@code B2_API float b2Joint_GetConstraintTorque( b2JointId jointId ); } */
    public static native float nb2Joint_GetConstraintTorque(long jointId);

    // --- [ b2Joint_GetLinearSeparation ] ---

    /**
     * {@code B2_API float b2Joint_GetLinearSeparation( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2Joint_GetLinearSeparation(b2JointId jointId) {
        checkPointers(jointId);
        return nb2Joint_GetLinearSeparation(jointId.address());
    }

    /* {@code B2_API float b2Joint_GetLinearSeparation( b2JointId jointId ); } */
    public static native float nb2Joint_GetLinearSeparation(long jointId);

    // --- [ b2Joint_GetAngularSeparation ] ---

    /**
     * {@code B2_API float b2Joint_GetAngularSeparation( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2Joint_GetAngularSeparation(b2JointId jointId) {
        checkPointers(jointId);
        return nb2Joint_GetAngularSeparation(jointId.address());
    }

    /* {@code B2_API float b2Joint_GetAngularSeparation( b2JointId jointId ); } */
    public static native float nb2Joint_GetAngularSeparation(long jointId);

    // --- [ b2Joint_SetConstraintTuning ] ---

    /**
     * {@code B2_API void b2Joint_SetConstraintTuning( b2JointId jointId, float hertz, float dampingRatio ); }
     *
     * @param jointId b2JointId
     * @param hertz float
     * @param dampingRatio float
     */
    public static void b2Joint_SetConstraintTuning(b2JointId jointId, float hertz, float dampingRatio) {
        checkPointers(jointId);
        nb2Joint_SetConstraintTuning(jointId.address(), hertz, dampingRatio);
    }

    /* {@code B2_API void b2Joint_SetConstraintTuning( b2JointId jointId, float hertz, float dampingRatio ); } */
    public static native void nb2Joint_SetConstraintTuning(long jointId, float hertz, float dampingRatio);

    // --- [ b2Joint_GetConstraintTuning ] ---

    /**
     * {@code B2_API void b2Joint_GetConstraintTuning( b2JointId jointId, float* hertz, float* dampingRatio ); }
     *
     * @param jointId b2JointId
     * @param hertz FloatBuffer
     * @param dampingRatio FloatBuffer
     */
    public static void b2Joint_GetConstraintTuning(b2JointId jointId, FloatBuffer hertz, FloatBuffer dampingRatio) {
        checkPointers(jointId);
        nb2Joint_GetConstraintTuning(jointId.address(), hertz, dampingRatio);
    }

    /* {@code B2_API void b2Joint_GetConstraintTuning( b2JointId jointId, float* hertz, float* dampingRatio ); } */
    public static native void nb2Joint_GetConstraintTuning(long jointId, FloatBuffer hertz, FloatBuffer dampingRatio);

    // --- [ b2Joint_SetForceThreshold ] ---

    /**
     * {@code B2_API void b2Joint_SetForceThreshold( b2JointId jointId, float threshold ); }
     *
     * @param jointId b2JointId
     * @param threshold float
     */
    public static void b2Joint_SetForceThreshold(b2JointId jointId, float threshold) {
        checkPointers(jointId);
        nb2Joint_SetForceThreshold(jointId.address(), threshold);
    }

    /* {@code B2_API void b2Joint_SetForceThreshold( b2JointId jointId, float threshold ); } */
    public static native void nb2Joint_SetForceThreshold(long jointId, float threshold);

    // --- [ b2Joint_GetForceThreshold ] ---

    /**
     * {@code B2_API float b2Joint_GetForceThreshold( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2Joint_GetForceThreshold(b2JointId jointId) {
        checkPointers(jointId);
        return nb2Joint_GetForceThreshold(jointId.address());
    }

    /* {@code B2_API float b2Joint_GetForceThreshold( b2JointId jointId ); } */
    public static native float nb2Joint_GetForceThreshold(long jointId);

    // --- [ b2Joint_SetTorqueThreshold ] ---

    /**
     * {@code B2_API void b2Joint_SetTorqueThreshold( b2JointId jointId, float threshold ); }
     *
     * @param jointId b2JointId
     * @param threshold float
     */
    public static void b2Joint_SetTorqueThreshold(b2JointId jointId, float threshold) {
        checkPointers(jointId);
        nb2Joint_SetTorqueThreshold(jointId.address(), threshold);
    }

    /* {@code B2_API void b2Joint_SetTorqueThreshold( b2JointId jointId, float threshold ); } */
    public static native void nb2Joint_SetTorqueThreshold(long jointId, float threshold);

    // --- [ b2Joint_GetTorqueThreshold ] ---

    /**
     * {@code B2_API float b2Joint_GetTorqueThreshold( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2Joint_GetTorqueThreshold(b2JointId jointId) {
        checkPointers(jointId);
        return nb2Joint_GetTorqueThreshold(jointId.address());
    }

    /* {@code B2_API float b2Joint_GetTorqueThreshold( b2JointId jointId ); } */
    public static native float nb2Joint_GetTorqueThreshold(long jointId);
    
    // --- [ b2CreateDistanceJoint ] ---

    /**
     * {@code B2_API b2JointId b2CreateDistanceJoint( b2WorldId worldId, const b2DistanceJointDef* def ); }
     *
     * @param worldId b2WorldId
     * @param def ConstB2DistanceJointDef
     * @param __result store
     *
     * @return b2JointId
     */
    public static b2JointId b2CreateDistanceJoint(b2WorldId worldId, ConstB2DistanceJointDef def, b2JointId __result) {
        checkPointers(worldId, def, __result);
        nb2CreateDistanceJoint(worldId.address(), def.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2JointId b2CreateDistanceJoint( b2WorldId worldId, const b2DistanceJointDef* def ); } */
    public static native void nb2CreateDistanceJoint(long worldId, long def, long __result);

    // --- [ b2DistanceJoint_SetLength ] ---

    /**
     * {@code B2_API void b2DistanceJoint_SetLength( b2JointId jointId, float length ); }
     *
     * @param jointId b2JointId
     * @param length float
     */
    public static void b2DistanceJoint_SetLength(b2JointId jointId, float length) {
        checkPointers(jointId);
        nb2DistanceJoint_SetLength(jointId.address(), length);
    }

    /* {@code B2_API void b2DistanceJoint_SetLength( b2JointId jointId, float length ); } */
    public static native void nb2DistanceJoint_SetLength(long jointId, float length);

    // --- [ b2DistanceJoint_GetLength ] ---

    /**
     * {@code B2_API float b2DistanceJoint_GetLength( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2DistanceJoint_GetLength(b2JointId jointId) {
        checkPointers(jointId);
        return nb2DistanceJoint_GetLength(jointId.address());
    }

    /* {@code B2_API float b2DistanceJoint_GetLength( b2JointId jointId ); } */
    public static native float nb2DistanceJoint_GetLength(long jointId);

    // --- [ b2DistanceJoint_EnableSpring ] ---

    /**
     * {@code B2_API void b2DistanceJoint_EnableSpring( b2JointId jointId, bool enableSpring ); }
     *
     * @param jointId b2JointId
     * @param enableSpring boolean
     */
    public static void b2DistanceJoint_EnableSpring(b2JointId jointId, boolean enableSpring) {
        checkPointers(jointId);
        nb2DistanceJoint_EnableSpring(jointId.address(), enableSpring);
    }

    /* {@code B2_API void b2DistanceJoint_EnableSpring( b2JointId jointId, bool enableSpring ); } */
    public static native void nb2DistanceJoint_EnableSpring(long jointId, boolean enableSpring);

    // --- [ b2DistanceJoint_IsSpringEnabled ] ---

    /**
     * {@code B2_API bool b2DistanceJoint_IsSpringEnabled( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return boolean
     */
    public static boolean b2DistanceJoint_IsSpringEnabled(b2JointId jointId) {
        checkPointers(jointId);
        return nb2DistanceJoint_IsSpringEnabled(jointId.address());
    }

    /* {@code B2_API bool b2DistanceJoint_IsSpringEnabled( b2JointId jointId ); } */
    public static native boolean nb2DistanceJoint_IsSpringEnabled(long jointId);

    // --- [ b2DistanceJoint_SetSpringForceRange ] ---

    /**
     * {@code B2_API void b2DistanceJoint_SetSpringForceRange( b2JointId jointId, float lowerForce, float upperForce ); }
     *
     * @param jointId b2JointId
     * @param lowerForce float
     * @param upperForce float
     */
    public static void b2DistanceJoint_SetSpringForceRange(b2JointId jointId, float lowerForce, float upperForce) {
        checkPointers(jointId);
        nb2DistanceJoint_SetSpringForceRange(jointId.address(), lowerForce, upperForce);
    }

    /* {@code B2_API void b2DistanceJoint_SetSpringForceRange( b2JointId jointId, float lowerForce, float upperForce ); } */
    public static native void nb2DistanceJoint_SetSpringForceRange(long jointId, float lowerForce, float upperForce);

    // --- [ b2DistanceJoint_GetSpringForceRange ] ---

    /**
     * {@code B2_API void b2DistanceJoint_GetSpringForceRange( b2JointId jointId, float* lowerForce, float* upperForce ); }
     *
     * @param jointId b2JointId
     * @param lowerForce FloatBuffer
     * @param upperForce FloatBuffer
     */
    public static void b2DistanceJoint_GetSpringForceRange(b2JointId jointId, FloatBuffer lowerForce, FloatBuffer upperForce) {
        checkPointers(jointId);
        nb2DistanceJoint_GetSpringForceRange(jointId.address(), lowerForce, upperForce);
    }

    /* {@code B2_API void b2DistanceJoint_GetSpringForceRange( b2JointId jointId, float* lowerForce, float* upperForce ); } */
    public static native void nb2DistanceJoint_GetSpringForceRange(long jointId, FloatBuffer lowerForce, FloatBuffer upperForce);

    // --- [ b2DistanceJoint_SetSpringHertz ] ---

    /**
     * {@code B2_API void b2DistanceJoint_SetSpringHertz( b2JointId jointId, float hertz ); }
     *
     * @param jointId b2JointId
     * @param hertz float
     */
    public static void b2DistanceJoint_SetSpringHertz(b2JointId jointId, float hertz) {
        checkPointers(jointId);
        nb2DistanceJoint_SetSpringHertz(jointId.address(), hertz);
    }

    /* {@code B2_API void b2DistanceJoint_SetSpringHertz( b2JointId jointId, float hertz ); } */
    public static native void nb2DistanceJoint_SetSpringHertz(long jointId, float hertz);

    // --- [ b2DistanceJoint_SetSpringDampingRatio ] ---

    /**
     * {@code B2_API void b2DistanceJoint_SetSpringDampingRatio( b2JointId jointId, float dampingRatio ); }
     *
     * @param jointId b2JointId
     * @param dampingRatio float
     */
    public static void b2DistanceJoint_SetSpringDampingRatio(b2JointId jointId, float dampingRatio) {
        checkPointers(jointId);
        nb2DistanceJoint_SetSpringDampingRatio(jointId.address(), dampingRatio);
    }

    /* {@code B2_API void b2DistanceJoint_SetSpringDampingRatio( b2JointId jointId, float dampingRatio ); } */
    public static native void nb2DistanceJoint_SetSpringDampingRatio(long jointId, float dampingRatio);

    // --- [ b2DistanceJoint_GetSpringHertz ] ---

    /**
     * {@code B2_API float b2DistanceJoint_GetSpringHertz( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2DistanceJoint_GetSpringHertz(b2JointId jointId) {
        checkPointers(jointId);
        return nb2DistanceJoint_GetSpringHertz(jointId.address());
    }

    /* {@code B2_API float b2DistanceJoint_GetSpringHertz( b2JointId jointId ); } */
    public static native float nb2DistanceJoint_GetSpringHertz(long jointId);

    // --- [ b2DistanceJoint_GetSpringDampingRatio ] ---

    /**
     * {@code B2_API float b2DistanceJoint_GetSpringDampingRatio( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2DistanceJoint_GetSpringDampingRatio(b2JointId jointId) {
        checkPointers(jointId);
        return nb2DistanceJoint_GetSpringDampingRatio(jointId.address());
    }

    /* {@code B2_API float b2DistanceJoint_GetSpringDampingRatio( b2JointId jointId ); } */
    public static native float nb2DistanceJoint_GetSpringDampingRatio(long jointId);

    // --- [ b2DistanceJoint_EnableLimit ] ---

    /**
     * {@code B2_API void b2DistanceJoint_EnableLimit( b2JointId jointId, bool enableLimit ); }
     *
     * @param jointId b2JointId
     * @param enableLimit boolean
     */
    public static void b2DistanceJoint_EnableLimit(b2JointId jointId, boolean enableLimit) {
        checkPointers(jointId);
        nb2DistanceJoint_EnableLimit(jointId.address(), enableLimit);
    }

    /* {@code B2_API void b2DistanceJoint_EnableLimit( b2JointId jointId, bool enableLimit ); } */
    public static native void nb2DistanceJoint_EnableLimit(long jointId, boolean enableLimit);

    // --- [ b2DistanceJoint_IsLimitEnabled ] ---

    /**
     * {@code B2_API bool b2DistanceJoint_IsLimitEnabled( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return boolean
     */
    public static boolean b2DistanceJoint_IsLimitEnabled(b2JointId jointId) {
        checkPointers(jointId);
        return nb2DistanceJoint_IsLimitEnabled(jointId.address());
    }

    /* {@code B2_API bool b2DistanceJoint_IsLimitEnabled( b2JointId jointId ); } */
    public static native boolean nb2DistanceJoint_IsLimitEnabled(long jointId);

    // --- [ b2DistanceJoint_SetLengthRange ] ---

    /**
     * {@code B2_API void b2DistanceJoint_SetLengthRange( b2JointId jointId, float minLength, float maxLength ); }
     *
     * @param jointId b2JointId
     * @param minLength float
     * @param maxLength float
     */
    public static void b2DistanceJoint_SetLengthRange(b2JointId jointId, float minLength, float maxLength) {
        checkPointers(jointId);
        nb2DistanceJoint_SetLengthRange(jointId.address(), minLength, maxLength);
    }

    /* {@code B2_API void b2DistanceJoint_SetLengthRange( b2JointId jointId, float minLength, float maxLength ); } */
    public static native void nb2DistanceJoint_SetLengthRange(long jointId, float minLength, float maxLength);

    // --- [ b2DistanceJoint_GetMinLength ] ---

    /**
     * {@code B2_API float b2DistanceJoint_GetMinLength( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2DistanceJoint_GetMinLength(b2JointId jointId) {
        checkPointers(jointId);
        return nb2DistanceJoint_GetMinLength(jointId.address());
    }

    /* {@code B2_API float b2DistanceJoint_GetMinLength( b2JointId jointId ); } */
    public static native float nb2DistanceJoint_GetMinLength(long jointId);

    // --- [ b2DistanceJoint_GetMaxLength ] ---

    /**
     * {@code B2_API float b2DistanceJoint_GetMaxLength( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2DistanceJoint_GetMaxLength(b2JointId jointId) {
        checkPointers(jointId);
        return nb2DistanceJoint_GetMaxLength(jointId.address());
    }

    /* {@code B2_API float b2DistanceJoint_GetMaxLength( b2JointId jointId ); } */
    public static native float nb2DistanceJoint_GetMaxLength(long jointId);

    // --- [ b2DistanceJoint_GetCurrentLength ] ---

    /**
     * {@code B2_API float b2DistanceJoint_GetCurrentLength( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2DistanceJoint_GetCurrentLength(b2JointId jointId) {
        checkPointers(jointId);
        return nb2DistanceJoint_GetCurrentLength(jointId.address());
    }

    /* {@code B2_API float b2DistanceJoint_GetCurrentLength( b2JointId jointId ); } */
    public static native float nb2DistanceJoint_GetCurrentLength(long jointId);

    // --- [ b2DistanceJoint_EnableMotor ] ---

    /**
     * {@code B2_API void b2DistanceJoint_EnableMotor( b2JointId jointId, bool enableMotor ); }
     *
     * @param jointId b2JointId
     * @param enableMotor boolean
     */
    public static void b2DistanceJoint_EnableMotor(b2JointId jointId, boolean enableMotor) {
        checkPointers(jointId);
        nb2DistanceJoint_EnableMotor(jointId.address(), enableMotor);
    }

    /* {@code B2_API void b2DistanceJoint_EnableMotor( b2JointId jointId, bool enableMotor ); } */
    public static native void nb2DistanceJoint_EnableMotor(long jointId, boolean enableMotor);

    // --- [ b2DistanceJoint_IsMotorEnabled ] ---

    /**
     * {@code B2_API bool b2DistanceJoint_IsMotorEnabled( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return boolean
     */
    public static boolean b2DistanceJoint_IsMotorEnabled(b2JointId jointId) {
        checkPointers(jointId);
        return nb2DistanceJoint_IsMotorEnabled(jointId.address());
    }

    /* {@code B2_API bool b2DistanceJoint_IsMotorEnabled( b2JointId jointId ); } */
    public static native boolean nb2DistanceJoint_IsMotorEnabled(long jointId);

    // --- [ b2DistanceJoint_SetMotorSpeed ] ---

    /**
     * {@code B2_API void b2DistanceJoint_SetMotorSpeed( b2JointId jointId, float motorSpeed ); }
     *
     * @param jointId b2JointId
     * @param motorSpeed float
     */
    public static void b2DistanceJoint_SetMotorSpeed(b2JointId jointId, float motorSpeed) {
        checkPointers(jointId);
        nb2DistanceJoint_SetMotorSpeed(jointId.address(), motorSpeed);
    }

    /* {@code B2_API void b2DistanceJoint_SetMotorSpeed( b2JointId jointId, float motorSpeed ); } */
    public static native void nb2DistanceJoint_SetMotorSpeed(long jointId, float motorSpeed);

    // --- [ b2DistanceJoint_GetMotorSpeed ] ---

    /**
     * {@code B2_API float b2DistanceJoint_GetMotorSpeed( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2DistanceJoint_GetMotorSpeed(b2JointId jointId) {
        checkPointers(jointId);
        return nb2DistanceJoint_GetMotorSpeed(jointId.address());
    }

    /* {@code B2_API float b2DistanceJoint_GetMotorSpeed( b2JointId jointId ); } */
    public static native float nb2DistanceJoint_GetMotorSpeed(long jointId);

    // --- [ b2DistanceJoint_SetMaxMotorForce ] ---

    /**
     * {@code B2_API void b2DistanceJoint_SetMaxMotorForce( b2JointId jointId, float force ); }
     *
     * @param jointId b2JointId
     * @param force float
     */
    public static void b2DistanceJoint_SetMaxMotorForce(b2JointId jointId, float force) {
        checkPointers(jointId);
        nb2DistanceJoint_SetMaxMotorForce(jointId.address(), force);
    }

    /* {@code B2_API void b2DistanceJoint_SetMaxMotorForce( b2JointId jointId, float force ); } */
    public static native void nb2DistanceJoint_SetMaxMotorForce(long jointId, float force);

    // --- [ b2DistanceJoint_GetMaxMotorForce ] ---

    /**
     * {@code B2_API float b2DistanceJoint_GetMaxMotorForce( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2DistanceJoint_GetMaxMotorForce(b2JointId jointId) {
        checkPointers(jointId);
        return nb2DistanceJoint_GetMaxMotorForce(jointId.address());
    }

    /* {@code B2_API float b2DistanceJoint_GetMaxMotorForce( b2JointId jointId ); } */
    public static native float nb2DistanceJoint_GetMaxMotorForce(long jointId);

    // --- [ b2DistanceJoint_GetMotorForce ] ---

    /**
     * {@code B2_API float b2DistanceJoint_GetMotorForce( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2DistanceJoint_GetMotorForce(b2JointId jointId) {
        checkPointers(jointId);
        return nb2DistanceJoint_GetMotorForce(jointId.address());
    }

    /* {@code B2_API float b2DistanceJoint_GetMotorForce( b2JointId jointId ); } */
    public static native float nb2DistanceJoint_GetMotorForce(long jointId);
    
    // --- [ b2CreateMotorJoint ] ---

    /**
     * {@code B2_API b2JointId b2CreateMotorJoint( b2WorldId worldId, const b2MotorJointDef* def ); }
     *
     * @param worldId b2WorldId
     * @param def ConstB2MotorJointDef
     * @param __result store
     *
     * @return b2JointId
     */
    public static b2JointId b2CreateMotorJoint(b2WorldId worldId, ConstB2MotorJointDef def, b2JointId __result) {
        checkPointers(worldId, def, __result);
        nb2CreateMotorJoint(worldId.address(), def.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2JointId b2CreateMotorJoint( b2WorldId worldId, const b2MotorJointDef* def ); } */
    public static native void nb2CreateMotorJoint(long worldId, long def, long __result);

    // --- [ b2MotorJoint_SetLinearVelocity ] ---

    /**
     * {@code B2_API void b2MotorJoint_SetLinearVelocity( b2JointId jointId, b2Vec2 velocity ); }
     *
     * @param jointId b2JointId
     * @param velocity b2Vec2
     */
    public static void b2MotorJoint_SetLinearVelocity(b2JointId jointId, b2Vec2 velocity) {
        checkPointers(jointId, velocity);
        nb2MotorJoint_SetLinearVelocity(jointId.address(), velocity.address());
    }

    /* {@code B2_API void b2MotorJoint_SetLinearVelocity( b2JointId jointId, b2Vec2 velocity ); } */
    public static native void nb2MotorJoint_SetLinearVelocity(long jointId, long velocity);

    // --- [ b2MotorJoint_GetLinearVelocity ] ---

    /**
     * {@code B2_API b2Vec2 b2MotorJoint_GetLinearVelocity( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     * @param __result store
     *
     * @return b2Vec2
     */
    public static b2Vec2 b2MotorJoint_GetLinearVelocity(b2JointId jointId, b2Vec2 __result) {
        checkPointers(jointId, __result);
        nb2MotorJoint_GetLinearVelocity(jointId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Vec2 b2MotorJoint_GetLinearVelocity( b2JointId jointId ); } */
    public static native void nb2MotorJoint_GetLinearVelocity(long jointId, long __result);

    // --- [ b2MotorJoint_SetAngularVelocity ] ---

    /**
     * {@code B2_API void b2MotorJoint_SetAngularVelocity( b2JointId jointId, float velocity ); }
     *
     * @param jointId b2JointId
     * @param velocity float
     */
    public static void b2MotorJoint_SetAngularVelocity(b2JointId jointId, float velocity) {
        checkPointers(jointId);
        nb2MotorJoint_SetAngularVelocity(jointId.address(), velocity);
    }

    /* {@code B2_API void b2MotorJoint_SetAngularVelocity( b2JointId jointId, float velocity ); } */
    public static native void nb2MotorJoint_SetAngularVelocity(long jointId, float velocity);

    // --- [ b2MotorJoint_GetAngularVelocity ] ---

    /**
     * {@code B2_API float b2MotorJoint_GetAngularVelocity( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2MotorJoint_GetAngularVelocity(b2JointId jointId) {
        checkPointers(jointId);
        return nb2MotorJoint_GetAngularVelocity(jointId.address());
    }

    /* {@code B2_API float b2MotorJoint_GetAngularVelocity( b2JointId jointId ); } */
    public static native float nb2MotorJoint_GetAngularVelocity(long jointId);

    // --- [ b2MotorJoint_SetMaxVelocityForce ] ---

    /**
     * {@code B2_API void b2MotorJoint_SetMaxVelocityForce( b2JointId jointId, float maxForce ); }
     *
     * @param jointId b2JointId
     * @param maxForce float
     */
    public static void b2MotorJoint_SetMaxVelocityForce(b2JointId jointId, float maxForce) {
        checkPointers(jointId);
        nb2MotorJoint_SetMaxVelocityForce(jointId.address(), maxForce);
    }

    /* {@code B2_API void b2MotorJoint_SetMaxVelocityForce( b2JointId jointId, float maxForce ); } */
    public static native void nb2MotorJoint_SetMaxVelocityForce(long jointId, float maxForce);

    // --- [ b2MotorJoint_GetMaxVelocityForce ] ---

    /**
     * {@code B2_API float b2MotorJoint_GetMaxVelocityForce( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2MotorJoint_GetMaxVelocityForce(b2JointId jointId) {
        checkPointers(jointId);
        return nb2MotorJoint_GetMaxVelocityForce(jointId.address());
    }

    /* {@code B2_API float b2MotorJoint_GetMaxVelocityForce( b2JointId jointId ); } */
    public static native float nb2MotorJoint_GetMaxVelocityForce(long jointId);

    // --- [ b2MotorJoint_SetMaxVelocityTorque ] ---

    /**
     * {@code B2_API void b2MotorJoint_SetMaxVelocityTorque( b2JointId jointId, float maxTorque ); }
     *
     * @param jointId b2JointId
     * @param maxTorque float
     */
    public static void b2MotorJoint_SetMaxVelocityTorque(b2JointId jointId, float maxTorque) {
        checkPointers(jointId);
        nb2MotorJoint_SetMaxVelocityTorque(jointId.address(), maxTorque);
    }

    /* {@code B2_API void b2MotorJoint_SetMaxVelocityTorque( b2JointId jointId, float maxTorque ); } */
    public static native void nb2MotorJoint_SetMaxVelocityTorque(long jointId, float maxTorque);

    // --- [ b2MotorJoint_GetMaxVelocityTorque ] ---

    /**
     * {@code B2_API float b2MotorJoint_GetMaxVelocityTorque( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2MotorJoint_GetMaxVelocityTorque(b2JointId jointId) {
        checkPointers(jointId);
        return nb2MotorJoint_GetMaxVelocityTorque(jointId.address());
    }

    /* {@code B2_API float b2MotorJoint_GetMaxVelocityTorque( b2JointId jointId ); } */
    public static native float nb2MotorJoint_GetMaxVelocityTorque(long jointId);

    // --- [ b2MotorJoint_SetLinearHertz ] ---

    /**
     * {@code B2_API void b2MotorJoint_SetLinearHertz( b2JointId jointId, float hertz ); }
     *
     * @param jointId b2JointId
     * @param hertz float
     */
    public static void b2MotorJoint_SetLinearHertz(b2JointId jointId, float hertz) {
        checkPointers(jointId);
        nb2MotorJoint_SetLinearHertz(jointId.address(), hertz);
    }

    /* {@code B2_API void b2MotorJoint_SetLinearHertz( b2JointId jointId, float hertz ); } */
    public static native void nb2MotorJoint_SetLinearHertz(long jointId, float hertz);

    // --- [ b2MotorJoint_GetLinearHertz ] ---

    /**
     * {@code B2_API float b2MotorJoint_GetLinearHertz( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2MotorJoint_GetLinearHertz(b2JointId jointId) {
        checkPointers(jointId);
        return nb2MotorJoint_GetLinearHertz(jointId.address());
    }

    /* {@code B2_API float b2MotorJoint_GetLinearHertz( b2JointId jointId ); } */
    public static native float nb2MotorJoint_GetLinearHertz(long jointId);

    // --- [ b2MotorJoint_SetLinearDampingRatio ] ---

    /**
     * {@code B2_API void b2MotorJoint_SetLinearDampingRatio( b2JointId jointId, float damping ); }
     *
     * @param jointId b2JointId
     * @param damping float
     */
    public static void b2MotorJoint_SetLinearDampingRatio(b2JointId jointId, float damping) {
        checkPointers(jointId);
        nb2MotorJoint_SetLinearDampingRatio(jointId.address(), damping);
    }

    /* {@code B2_API void b2MotorJoint_SetLinearDampingRatio( b2JointId jointId, float damping ); } */
    public static native void nb2MotorJoint_SetLinearDampingRatio(long jointId, float damping);

    // --- [ b2MotorJoint_GetLinearDampingRatio ] ---

    /**
     * {@code B2_API float b2MotorJoint_GetLinearDampingRatio( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2MotorJoint_GetLinearDampingRatio(b2JointId jointId) {
        checkPointers(jointId);
        return nb2MotorJoint_GetLinearDampingRatio(jointId.address());
    }

    /* {@code B2_API float b2MotorJoint_GetLinearDampingRatio( b2JointId jointId ); } */
    public static native float nb2MotorJoint_GetLinearDampingRatio(long jointId);

    // --- [ b2MotorJoint_SetAngularHertz ] ---

    /**
     * {@code B2_API void b2MotorJoint_SetAngularHertz( b2JointId jointId, float hertz ); }
     *
     * @param jointId b2JointId
     * @param hertz float
     */
    public static void b2MotorJoint_SetAngularHertz(b2JointId jointId, float hertz) {
        checkPointers(jointId);
        nb2MotorJoint_SetAngularHertz(jointId.address(), hertz);
    }

    /* {@code B2_API void b2MotorJoint_SetAngularHertz( b2JointId jointId, float hertz ); } */
    public static native void nb2MotorJoint_SetAngularHertz(long jointId, float hertz);

    // --- [ b2MotorJoint_GetAngularHertz ] ---

    /**
     * {@code B2_API float b2MotorJoint_GetAngularHertz( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2MotorJoint_GetAngularHertz(b2JointId jointId) {
        checkPointers(jointId);
        return nb2MotorJoint_GetAngularHertz(jointId.address());
    }

    /* {@code B2_API float b2MotorJoint_GetAngularHertz( b2JointId jointId ); } */
    public static native float nb2MotorJoint_GetAngularHertz(long jointId);

    // --- [ b2MotorJoint_SetAngularDampingRatio ] ---

    /**
     * {@code B2_API void b2MotorJoint_SetAngularDampingRatio( b2JointId jointId, float damping ); }
     *
     * @param jointId b2JointId
     * @param damping float
     */
    public static void b2MotorJoint_SetAngularDampingRatio(b2JointId jointId, float damping) {
        checkPointers(jointId);
        nb2MotorJoint_SetAngularDampingRatio(jointId.address(), damping);
    }

    /* {@code B2_API void b2MotorJoint_SetAngularDampingRatio( b2JointId jointId, float damping ); } */
    public static native void nb2MotorJoint_SetAngularDampingRatio(long jointId, float damping);

    // --- [ b2MotorJoint_GetAngularDampingRatio ] ---

    /**
     * {@code B2_API float b2MotorJoint_GetAngularDampingRatio( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2MotorJoint_GetAngularDampingRatio(b2JointId jointId) {
        checkPointers(jointId);
        return nb2MotorJoint_GetAngularDampingRatio(jointId.address());
    }

    /* {@code B2_API float b2MotorJoint_GetAngularDampingRatio( b2JointId jointId ); } */
    public static native float nb2MotorJoint_GetAngularDampingRatio(long jointId);

    // --- [ b2MotorJoint_SetMaxSpringForce ] ---

    /**
     * {@code B2_API void b2MotorJoint_SetMaxSpringForce( b2JointId jointId, float maxForce ); }
     *
     * @param jointId b2JointId
     * @param maxForce float
     */
    public static void b2MotorJoint_SetMaxSpringForce(b2JointId jointId, float maxForce) {
        checkPointers(jointId);
        nb2MotorJoint_SetMaxSpringForce(jointId.address(), maxForce);
    }

    /* {@code B2_API void b2MotorJoint_SetMaxSpringForce( b2JointId jointId, float maxForce ); } */
    public static native void nb2MotorJoint_SetMaxSpringForce(long jointId, float maxForce);

    // --- [ b2MotorJoint_GetMaxSpringForce ] ---

    /**
     * {@code B2_API float b2MotorJoint_GetMaxSpringForce( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2MotorJoint_GetMaxSpringForce(b2JointId jointId) {
        checkPointers(jointId);
        return nb2MotorJoint_GetMaxSpringForce(jointId.address());
    }

    /* {@code B2_API float b2MotorJoint_GetMaxSpringForce( b2JointId jointId ); } */
    public static native float nb2MotorJoint_GetMaxSpringForce(long jointId);

    // --- [ b2MotorJoint_SetMaxSpringTorque ] ---

    /**
     * {@code B2_API void b2MotorJoint_SetMaxSpringTorque( b2JointId jointId, float maxTorque ); }
     *
     * @param jointId b2JointId
     * @param maxTorque float
     */
    public static void b2MotorJoint_SetMaxSpringTorque(b2JointId jointId, float maxTorque) {
        checkPointers(jointId);
        nb2MotorJoint_SetMaxSpringTorque(jointId.address(), maxTorque);
    }

    /* {@code B2_API void b2MotorJoint_SetMaxSpringTorque( b2JointId jointId, float maxTorque ); } */
    public static native void nb2MotorJoint_SetMaxSpringTorque(long jointId, float maxTorque);

    // --- [ b2MotorJoint_GetMaxSpringTorque ] ---

    /**
     * {@code B2_API float b2MotorJoint_GetMaxSpringTorque( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2MotorJoint_GetMaxSpringTorque(b2JointId jointId) {
        checkPointers(jointId);
        return nb2MotorJoint_GetMaxSpringTorque(jointId.address());
    }

    /* {@code B2_API float b2MotorJoint_GetMaxSpringTorque( b2JointId jointId ); } */
    public static native float nb2MotorJoint_GetMaxSpringTorque(long jointId);

    // --- [ b2CreateFilterJoint ] ---

    /**
     * {@code B2_API b2JointId b2CreateFilterJoint( b2WorldId worldId, const b2FilterJointDef* def ); }
     *
     * @param worldId b2WorldId
     * @param def ConstB2FilterJointDef
     * @param __result store
     *
     * @return b2JointId
     */
    public static b2JointId b2CreateFilterJoint(b2WorldId worldId, ConstB2FilterJointDef def, b2JointId __result) {
        checkPointers(worldId, def, __result);
        nb2CreateFilterJoint(worldId.address(), def.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2JointId b2CreateFilterJoint( b2WorldId worldId, const b2FilterJointDef* def ); } */
    public static native void nb2CreateFilterJoint(long worldId, long def, long __result);

    // --- [ b2CreatePrismaticJoint ] ---

    /**
     * {@code B2_API b2JointId b2CreatePrismaticJoint( b2WorldId worldId, const b2PrismaticJointDef* def ); }
     *
     * @param worldId b2WorldId
     * @param def ConstB2PrismaticJointDef
     * @param __result store
     *
     * @return b2JointId
     */
    public static b2JointId b2CreatePrismaticJoint(b2WorldId worldId, ConstB2PrismaticJointDef def, b2JointId __result) {
        checkPointers(worldId, def, __result);
        nb2CreatePrismaticJoint(worldId.address(), def.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2JointId b2CreatePrismaticJoint( b2WorldId worldId, const b2PrismaticJointDef* def ); } */
    public static native void nb2CreatePrismaticJoint(long worldId, long def, long __result);

    // --- [ b2PrismaticJoint_EnableSpring ] ---

    /**
     * {@code B2_API void b2PrismaticJoint_EnableSpring( b2JointId jointId, bool enableSpring ); }
     *
     * @param jointId b2JointId
     * @param enableSpring boolean
     */
    public static void b2PrismaticJoint_EnableSpring(b2JointId jointId, boolean enableSpring) {
        checkPointers(jointId);
        nb2PrismaticJoint_EnableSpring(jointId.address(), enableSpring);
    }

    /* {@code B2_API void b2PrismaticJoint_EnableSpring( b2JointId jointId, bool enableSpring ); } */
    public static native void nb2PrismaticJoint_EnableSpring(long jointId, boolean enableSpring);

    // --- [ b2PrismaticJoint_IsSpringEnabled ] ---

    /**
     * {@code B2_API bool b2PrismaticJoint_IsSpringEnabled( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return boolean
     */
    public static boolean b2PrismaticJoint_IsSpringEnabled(b2JointId jointId) {
        checkPointers(jointId);
        return nb2PrismaticJoint_IsSpringEnabled(jointId.address());
    }

    /* {@code B2_API bool b2PrismaticJoint_IsSpringEnabled( b2JointId jointId ); } */
    public static native boolean nb2PrismaticJoint_IsSpringEnabled(long jointId);

    // --- [ b2PrismaticJoint_SetSpringHertz ] ---

    /**
     * {@code B2_API void b2PrismaticJoint_SetSpringHertz( b2JointId jointId, float hertz ); }
     *
     * @param jointId b2JointId
     * @param hertz float
     */
    public static void b2PrismaticJoint_SetSpringHertz(b2JointId jointId, float hertz) {
        checkPointers(jointId);
        nb2PrismaticJoint_SetSpringHertz(jointId.address(), hertz);
    }

    /* {@code B2_API void b2PrismaticJoint_SetSpringHertz( b2JointId jointId, float hertz ); } */
    public static native void nb2PrismaticJoint_SetSpringHertz(long jointId, float hertz);

    // --- [ b2PrismaticJoint_GetSpringHertz ] ---

    /**
     * {@code B2_API float b2PrismaticJoint_GetSpringHertz( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2PrismaticJoint_GetSpringHertz(b2JointId jointId) {
        checkPointers(jointId);
        return nb2PrismaticJoint_GetSpringHertz(jointId.address());
    }

    /* {@code B2_API float b2PrismaticJoint_GetSpringHertz( b2JointId jointId ); } */
    public static native float nb2PrismaticJoint_GetSpringHertz(long jointId);

    // --- [ b2PrismaticJoint_SetSpringDampingRatio ] ---

    /**
     * {@code B2_API void b2PrismaticJoint_SetSpringDampingRatio( b2JointId jointId, float dampingRatio ); }
     *
     * @param jointId b2JointId
     * @param dampingRatio float
     */
    public static void b2PrismaticJoint_SetSpringDampingRatio(b2JointId jointId, float dampingRatio) {
        checkPointers(jointId);
        nb2PrismaticJoint_SetSpringDampingRatio(jointId.address(), dampingRatio);
    }

    /* {@code B2_API void b2PrismaticJoint_SetSpringDampingRatio( b2JointId jointId, float dampingRatio ); } */
    public static native void nb2PrismaticJoint_SetSpringDampingRatio(long jointId, float dampingRatio);

    // --- [ b2PrismaticJoint_GetSpringDampingRatio ] ---

    /**
     * {@code B2_API float b2PrismaticJoint_GetSpringDampingRatio( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2PrismaticJoint_GetSpringDampingRatio(b2JointId jointId) {
        checkPointers(jointId);
        return nb2PrismaticJoint_GetSpringDampingRatio(jointId.address());
    }

    /* {@code B2_API float b2PrismaticJoint_GetSpringDampingRatio( b2JointId jointId ); } */
    public static native float nb2PrismaticJoint_GetSpringDampingRatio(long jointId);

    // --- [ b2PrismaticJoint_SetTargetTranslation ] ---

    /**
     * {@code B2_API void b2PrismaticJoint_SetTargetTranslation( b2JointId jointId, float translation ); }
     *
     * @param jointId b2JointId
     * @param translation float
     */
    public static void b2PrismaticJoint_SetTargetTranslation(b2JointId jointId, float translation) {
        checkPointers(jointId);
        nb2PrismaticJoint_SetTargetTranslation(jointId.address(), translation);
    }

    /* {@code B2_API void b2PrismaticJoint_SetTargetTranslation( b2JointId jointId, float translation ); } */
    public static native void nb2PrismaticJoint_SetTargetTranslation(long jointId, float translation);

    // --- [ b2PrismaticJoint_GetTargetTranslation ] ---

    /**
     * {@code B2_API float b2PrismaticJoint_GetTargetTranslation( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2PrismaticJoint_GetTargetTranslation(b2JointId jointId) {
        checkPointers(jointId);
        return nb2PrismaticJoint_GetTargetTranslation(jointId.address());
    }

    /* {@code B2_API float b2PrismaticJoint_GetTargetTranslation( b2JointId jointId ); } */
    public static native float nb2PrismaticJoint_GetTargetTranslation(long jointId);

    // --- [ b2PrismaticJoint_EnableLimit ] ---

    /**
     * {@code B2_API void b2PrismaticJoint_EnableLimit( b2JointId jointId, bool enableLimit ); }
     *
     * @param jointId b2JointId
     * @param enableLimit boolean
     */
    public static void b2PrismaticJoint_EnableLimit(b2JointId jointId, boolean enableLimit) {
        checkPointers(jointId);
        nb2PrismaticJoint_EnableLimit(jointId.address(), enableLimit);
    }

    /* {@code B2_API void b2PrismaticJoint_EnableLimit( b2JointId jointId, bool enableLimit ); } */
    public static native void nb2PrismaticJoint_EnableLimit(long jointId, boolean enableLimit);

    // --- [ b2PrismaticJoint_IsLimitEnabled ] ---

    /**
     * {@code B2_API bool b2PrismaticJoint_IsLimitEnabled( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return boolean
     */
    public static boolean b2PrismaticJoint_IsLimitEnabled(b2JointId jointId) {
        checkPointers(jointId);
        return nb2PrismaticJoint_IsLimitEnabled(jointId.address());
    }

    /* {@code B2_API bool b2PrismaticJoint_IsLimitEnabled( b2JointId jointId ); } */
    public static native boolean nb2PrismaticJoint_IsLimitEnabled(long jointId);

    // --- [ b2PrismaticJoint_GetLowerLimit ] ---

    /**
     * {@code B2_API float b2PrismaticJoint_GetLowerLimit( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2PrismaticJoint_GetLowerLimit(b2JointId jointId) {
        checkPointers(jointId);
        return nb2PrismaticJoint_GetLowerLimit(jointId.address());
    }

    /* {@code B2_API float b2PrismaticJoint_GetLowerLimit( b2JointId jointId ); } */
    public static native float nb2PrismaticJoint_GetLowerLimit(long jointId);

    // --- [ b2PrismaticJoint_GetUpperLimit ] ---

    /**
     * {@code B2_API float b2PrismaticJoint_GetUpperLimit( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2PrismaticJoint_GetUpperLimit(b2JointId jointId) {
        checkPointers(jointId);
        return nb2PrismaticJoint_GetUpperLimit(jointId.address());
    }

    /* {@code B2_API float b2PrismaticJoint_GetUpperLimit( b2JointId jointId ); } */
    public static native float nb2PrismaticJoint_GetUpperLimit(long jointId);

    // --- [ b2PrismaticJoint_SetLimits ] ---

    /**
     * {@code B2_API void b2PrismaticJoint_SetLimits( b2JointId jointId, float lower, float upper ); }
     *
     * @param jointId b2JointId
     * @param lower float
     * @param upper float
     */
    public static void b2PrismaticJoint_SetLimits(b2JointId jointId, float lower, float upper) {
        checkPointers(jointId);
        nb2PrismaticJoint_SetLimits(jointId.address(), lower, upper);
    }

    /* {@code B2_API void b2PrismaticJoint_SetLimits( b2JointId jointId, float lower, float upper ); } */
    public static native void nb2PrismaticJoint_SetLimits(long jointId, float lower, float upper);

    // --- [ b2PrismaticJoint_EnableMotor ] ---

    /**
     * {@code B2_API void b2PrismaticJoint_EnableMotor( b2JointId jointId, bool enableMotor ); }
     *
     * @param jointId b2JointId
     * @param enableMotor boolean
     */
    public static void b2PrismaticJoint_EnableMotor(b2JointId jointId, boolean enableMotor) {
        checkPointers(jointId);
        nb2PrismaticJoint_EnableMotor(jointId.address(), enableMotor);
    }

    /* {@code B2_API void b2PrismaticJoint_EnableMotor( b2JointId jointId, bool enableMotor ); } */
    public static native void nb2PrismaticJoint_EnableMotor(long jointId, boolean enableMotor);

    // --- [ b2PrismaticJoint_IsMotorEnabled ] ---

    /**
     * {@code B2_API bool b2PrismaticJoint_IsMotorEnabled( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return boolean
     */
    public static boolean b2PrismaticJoint_IsMotorEnabled(b2JointId jointId) {
        checkPointers(jointId);
        return nb2PrismaticJoint_IsMotorEnabled(jointId.address());
    }

    /* {@code B2_API bool b2PrismaticJoint_IsMotorEnabled( b2JointId jointId ); } */
    public static native boolean nb2PrismaticJoint_IsMotorEnabled(long jointId);

    // --- [ b2PrismaticJoint_SetMotorSpeed ] ---

    /**
     * {@code B2_API void b2PrismaticJoint_SetMotorSpeed( b2JointId jointId, float motorSpeed ); }
     *
     * @param jointId b2JointId
     * @param motorSpeed float
     */
    public static void b2PrismaticJoint_SetMotorSpeed(b2JointId jointId, float motorSpeed) {
        checkPointers(jointId);
        nb2PrismaticJoint_SetMotorSpeed(jointId.address(), motorSpeed);
    }

    /* {@code B2_API void b2PrismaticJoint_SetMotorSpeed( b2JointId jointId, float motorSpeed ); } */
    public static native void nb2PrismaticJoint_SetMotorSpeed(long jointId, float motorSpeed);

    // --- [ b2PrismaticJoint_GetMotorSpeed ] ---

    /**
     * {@code B2_API float b2PrismaticJoint_GetMotorSpeed( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2PrismaticJoint_GetMotorSpeed(b2JointId jointId) {
        checkPointers(jointId);
        return nb2PrismaticJoint_GetMotorSpeed(jointId.address());
    }

    /* {@code B2_API float b2PrismaticJoint_GetMotorSpeed( b2JointId jointId ); } */
    public static native float nb2PrismaticJoint_GetMotorSpeed(long jointId);

    // --- [ b2PrismaticJoint_SetMaxMotorForce ] ---

    /**
     * {@code B2_API void b2PrismaticJoint_SetMaxMotorForce( b2JointId jointId, float force ); }
     *
     * @param jointId b2JointId
     * @param force float
     */
    public static void b2PrismaticJoint_SetMaxMotorForce(b2JointId jointId, float force) {
        checkPointers(jointId);
        nb2PrismaticJoint_SetMaxMotorForce(jointId.address(), force);
    }

    /* {@code B2_API void b2PrismaticJoint_SetMaxMotorForce( b2JointId jointId, float force ); } */
    public static native void nb2PrismaticJoint_SetMaxMotorForce(long jointId, float force);

    // --- [ b2PrismaticJoint_GetMaxMotorForce ] ---

    /**
     * {@code B2_API float b2PrismaticJoint_GetMaxMotorForce( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2PrismaticJoint_GetMaxMotorForce(b2JointId jointId) {
        checkPointers(jointId);
        return nb2PrismaticJoint_GetMaxMotorForce(jointId.address());
    }

    /* {@code B2_API float b2PrismaticJoint_GetMaxMotorForce( b2JointId jointId ); } */
    public static native float nb2PrismaticJoint_GetMaxMotorForce(long jointId);

    // --- [ b2PrismaticJoint_GetMotorForce ] ---

    /**
     * {@code B2_API float b2PrismaticJoint_GetMotorForce( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2PrismaticJoint_GetMotorForce(b2JointId jointId) {
        checkPointers(jointId);
        return nb2PrismaticJoint_GetMotorForce(jointId.address());
    }

    /* {@code B2_API float b2PrismaticJoint_GetMotorForce( b2JointId jointId ); } */
    public static native float nb2PrismaticJoint_GetMotorForce(long jointId);

    // --- [ b2PrismaticJoint_GetTranslation ] ---

    /**
     * {@code B2_API float b2PrismaticJoint_GetTranslation( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2PrismaticJoint_GetTranslation(b2JointId jointId) {
        checkPointers(jointId);
        return nb2PrismaticJoint_GetTranslation(jointId.address());
    }

    /* {@code B2_API float b2PrismaticJoint_GetTranslation( b2JointId jointId ); } */
    public static native float nb2PrismaticJoint_GetTranslation(long jointId);

    // --- [ b2PrismaticJoint_GetSpeed ] ---

    /**
     * {@code B2_API float b2PrismaticJoint_GetSpeed( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2PrismaticJoint_GetSpeed(b2JointId jointId) {
        checkPointers(jointId);
        return nb2PrismaticJoint_GetSpeed(jointId.address());
    }

    /* {@code B2_API float b2PrismaticJoint_GetSpeed( b2JointId jointId ); } */
    public static native float nb2PrismaticJoint_GetSpeed(long jointId);

    // --- [ b2CreateRevoluteJoint ] ---

    /**
     * {@code B2_API b2JointId b2CreateRevoluteJoint( b2WorldId worldId, const b2RevoluteJointDef* def ); }
     *
     * @param worldId b2WorldId
     * @param def ConstB2RevoluteJointDef
     * @param __result store
     *
     * @return b2JointId
     */
    public static b2JointId b2CreateRevoluteJoint(b2WorldId worldId, ConstB2RevoluteJointDef def, b2JointId __result) {
        checkPointers(worldId, def, __result);
        nb2CreateRevoluteJoint(worldId.address(), def.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2JointId b2CreateRevoluteJoint( b2WorldId worldId, const b2RevoluteJointDef* def ); } */
    public static native void nb2CreateRevoluteJoint(long worldId, long def, long __result);

    // --- [ b2RevoluteJoint_EnableSpring ] ---

    /**
     * {@code B2_API void b2RevoluteJoint_EnableSpring( b2JointId jointId, bool enableSpring ); }
     *
     * @param jointId b2JointId
     * @param enableSpring boolean
     */
    public static void b2RevoluteJoint_EnableSpring(b2JointId jointId, boolean enableSpring) {
        checkPointers(jointId);
        nb2RevoluteJoint_EnableSpring(jointId.address(), enableSpring);
    }

    /* {@code B2_API void b2RevoluteJoint_EnableSpring( b2JointId jointId, bool enableSpring ); } */
    public static native void nb2RevoluteJoint_EnableSpring(long jointId, boolean enableSpring);

    // --- [ b2RevoluteJoint_IsSpringEnabled ] ---

    /**
     * {@code B2_API bool b2RevoluteJoint_IsSpringEnabled( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return boolean
     */
    public static boolean b2RevoluteJoint_IsSpringEnabled(b2JointId jointId) {
        checkPointers(jointId);
        return nb2RevoluteJoint_IsSpringEnabled(jointId.address());
    }

    /* {@code B2_API bool b2RevoluteJoint_IsSpringEnabled( b2JointId jointId ); } */
    public static native boolean nb2RevoluteJoint_IsSpringEnabled(long jointId);

    // --- [ b2RevoluteJoint_SetSpringHertz ] ---

    /**
     * {@code B2_API void b2RevoluteJoint_SetSpringHertz( b2JointId jointId, float hertz ); }
     *
     * @param jointId b2JointId
     * @param hertz float
     */
    public static void b2RevoluteJoint_SetSpringHertz(b2JointId jointId, float hertz) {
        checkPointers(jointId);
        nb2RevoluteJoint_SetSpringHertz(jointId.address(), hertz);
    }

    /* {@code B2_API void b2RevoluteJoint_SetSpringHertz( b2JointId jointId, float hertz ); } */
    public static native void nb2RevoluteJoint_SetSpringHertz(long jointId, float hertz);

    // --- [ b2RevoluteJoint_GetSpringHertz ] ---

    /**
     * {@code B2_API float b2RevoluteJoint_GetSpringHertz( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2RevoluteJoint_GetSpringHertz(b2JointId jointId) {
        checkPointers(jointId);
        return nb2RevoluteJoint_GetSpringHertz(jointId.address());
    }

    /* {@code B2_API float b2RevoluteJoint_GetSpringHertz( b2JointId jointId ); } */
    public static native float nb2RevoluteJoint_GetSpringHertz(long jointId);

    // --- [ b2RevoluteJoint_SetSpringDampingRatio ] ---

    /**
     * {@code B2_API void b2RevoluteJoint_SetSpringDampingRatio( b2JointId jointId, float dampingRatio ); }
     *
     * @param jointId b2JointId
     * @param dampingRatio float
     */
    public static void b2RevoluteJoint_SetSpringDampingRatio(b2JointId jointId, float dampingRatio) {
        checkPointers(jointId);
        nb2RevoluteJoint_SetSpringDampingRatio(jointId.address(), dampingRatio);
    }

    /* {@code B2_API void b2RevoluteJoint_SetSpringDampingRatio( b2JointId jointId, float dampingRatio ); } */
    public static native void nb2RevoluteJoint_SetSpringDampingRatio(long jointId, float dampingRatio);

    // --- [ b2RevoluteJoint_GetSpringDampingRatio ] ---

    /**
     * {@code B2_API float b2RevoluteJoint_GetSpringDampingRatio( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2RevoluteJoint_GetSpringDampingRatio(b2JointId jointId) {
        checkPointers(jointId);
        return nb2RevoluteJoint_GetSpringDampingRatio(jointId.address());
    }

    /* {@code B2_API float b2RevoluteJoint_GetSpringDampingRatio( b2JointId jointId ); } */
    public static native float nb2RevoluteJoint_GetSpringDampingRatio(long jointId);

    // --- [ b2RevoluteJoint_SetTargetAngle ] ---

    /**
     * {@code B2_API void b2RevoluteJoint_SetTargetAngle( b2JointId jointId, float angle ); }
     *
     * @param jointId b2JointId
     * @param angle float
     */
    public static void b2RevoluteJoint_SetTargetAngle(b2JointId jointId, float angle) {
        checkPointers(jointId);
        nb2RevoluteJoint_SetTargetAngle(jointId.address(), angle);
    }

    /* {@code B2_API void b2RevoluteJoint_SetTargetAngle( b2JointId jointId, float angle ); } */
    public static native void nb2RevoluteJoint_SetTargetAngle(long jointId, float angle);

    // --- [ b2RevoluteJoint_GetTargetAngle ] ---

    /**
     * {@code B2_API float b2RevoluteJoint_GetTargetAngle( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2RevoluteJoint_GetTargetAngle(b2JointId jointId) {
        checkPointers(jointId);
        return nb2RevoluteJoint_GetTargetAngle(jointId.address());
    }

    /* {@code B2_API float b2RevoluteJoint_GetTargetAngle( b2JointId jointId ); } */
    public static native float nb2RevoluteJoint_GetTargetAngle(long jointId);

    // --- [ b2RevoluteJoint_GetAngle ] ---

    /**
     * {@code B2_API float b2RevoluteJoint_GetAngle( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2RevoluteJoint_GetAngle(b2JointId jointId) {
        checkPointers(jointId);
        return nb2RevoluteJoint_GetAngle(jointId.address());
    }

    /* {@code B2_API float b2RevoluteJoint_GetAngle( b2JointId jointId ); } */
    public static native float nb2RevoluteJoint_GetAngle(long jointId);

    // --- [ b2RevoluteJoint_EnableLimit ] ---

    /**
     * {@code B2_API void b2RevoluteJoint_EnableLimit( b2JointId jointId, bool enableLimit ); }
     *
     * @param jointId b2JointId
     * @param enableLimit boolean
     */
    public static void b2RevoluteJoint_EnableLimit(b2JointId jointId, boolean enableLimit) {
        checkPointers(jointId);
        nb2RevoluteJoint_EnableLimit(jointId.address(), enableLimit);
    }

    /* {@code B2_API void b2RevoluteJoint_EnableLimit( b2JointId jointId, bool enableLimit ); } */
    public static native void nb2RevoluteJoint_EnableLimit(long jointId, boolean enableLimit);

    // --- [ b2RevoluteJoint_IsLimitEnabled ] ---

    /**
     * {@code B2_API bool b2RevoluteJoint_IsLimitEnabled( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return boolean
     */
    public static boolean b2RevoluteJoint_IsLimitEnabled(b2JointId jointId) {
        checkPointers(jointId);
        return nb2RevoluteJoint_IsLimitEnabled(jointId.address());
    }

    /* {@code B2_API bool b2RevoluteJoint_IsLimitEnabled( b2JointId jointId ); } */
    public static native boolean nb2RevoluteJoint_IsLimitEnabled(long jointId);

    // --- [ b2RevoluteJoint_GetLowerLimit ] ---

    /**
     * {@code B2_API float b2RevoluteJoint_GetLowerLimit( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2RevoluteJoint_GetLowerLimit(b2JointId jointId) {
        checkPointers(jointId);
        return nb2RevoluteJoint_GetLowerLimit(jointId.address());
    }

    /* {@code B2_API float b2RevoluteJoint_GetLowerLimit( b2JointId jointId ); } */
    public static native float nb2RevoluteJoint_GetLowerLimit(long jointId);

    // --- [ b2RevoluteJoint_GetUpperLimit ] ---

    /**
     * {@code B2_API float b2RevoluteJoint_GetUpperLimit( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2RevoluteJoint_GetUpperLimit(b2JointId jointId) {
        checkPointers(jointId);
        return nb2RevoluteJoint_GetUpperLimit(jointId.address());
    }

    /* {@code B2_API float b2RevoluteJoint_GetUpperLimit( b2JointId jointId ); } */
    public static native float nb2RevoluteJoint_GetUpperLimit(long jointId);

    // --- [ b2RevoluteJoint_SetLimits ] ---

    /**
     * {@code B2_API void b2RevoluteJoint_SetLimits( b2JointId jointId, float lower, float upper ); }
     *
     * @param jointId b2JointId
     * @param lower float
     * @param upper float
     */
    public static void b2RevoluteJoint_SetLimits(b2JointId jointId, float lower, float upper) {
        checkPointers(jointId);
        nb2RevoluteJoint_SetLimits(jointId.address(), lower, upper);
    }

    /* {@code B2_API void b2RevoluteJoint_SetLimits( b2JointId jointId, float lower, float upper ); } */
    public static native void nb2RevoluteJoint_SetLimits(long jointId, float lower, float upper);

    // --- [ b2RevoluteJoint_EnableMotor ] ---

    /**
     * {@code B2_API void b2RevoluteJoint_EnableMotor( b2JointId jointId, bool enableMotor ); }
     *
     * @param jointId b2JointId
     * @param enableMotor boolean
     */
    public static void b2RevoluteJoint_EnableMotor(b2JointId jointId, boolean enableMotor) {
        checkPointers(jointId);
        nb2RevoluteJoint_EnableMotor(jointId.address(), enableMotor);
    }

    /* {@code B2_API void b2RevoluteJoint_EnableMotor( b2JointId jointId, bool enableMotor ); } */
    public static native void nb2RevoluteJoint_EnableMotor(long jointId, boolean enableMotor);

    // --- [ b2RevoluteJoint_IsMotorEnabled ] ---

    /**
     * {@code B2_API bool b2RevoluteJoint_IsMotorEnabled( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return boolean
     */
    public static boolean b2RevoluteJoint_IsMotorEnabled(b2JointId jointId) {
        checkPointers(jointId);
        return nb2RevoluteJoint_IsMotorEnabled(jointId.address());
    }

    /* {@code B2_API bool b2RevoluteJoint_IsMotorEnabled( b2JointId jointId ); } */
    public static native boolean nb2RevoluteJoint_IsMotorEnabled(long jointId);

    // --- [ b2RevoluteJoint_SetMotorSpeed ] ---

    /**
     * {@code B2_API void b2RevoluteJoint_SetMotorSpeed( b2JointId jointId, float motorSpeed ); }
     *
     * @param jointId b2JointId
     * @param motorSpeed float
     */
    public static void b2RevoluteJoint_SetMotorSpeed(b2JointId jointId, float motorSpeed) {
        checkPointers(jointId);
        nb2RevoluteJoint_SetMotorSpeed(jointId.address(), motorSpeed);
    }

    /* {@code B2_API void b2RevoluteJoint_SetMotorSpeed( b2JointId jointId, float motorSpeed ); } */
    public static native void nb2RevoluteJoint_SetMotorSpeed(long jointId, float motorSpeed);

    // --- [ b2RevoluteJoint_GetMotorSpeed ] ---

    /**
     * {@code B2_API float b2RevoluteJoint_GetMotorSpeed( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2RevoluteJoint_GetMotorSpeed(b2JointId jointId) {
        checkPointers(jointId);
        return nb2RevoluteJoint_GetMotorSpeed(jointId.address());
    }

    /* {@code B2_API float b2RevoluteJoint_GetMotorSpeed( b2JointId jointId ); } */
    public static native float nb2RevoluteJoint_GetMotorSpeed(long jointId);

    // --- [ b2RevoluteJoint_GetMotorTorque ] ---

    /**
     * {@code B2_API float b2RevoluteJoint_GetMotorTorque( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2RevoluteJoint_GetMotorTorque(b2JointId jointId) {
        checkPointers(jointId);
        return nb2RevoluteJoint_GetMotorTorque(jointId.address());
    }

    /* {@code B2_API float b2RevoluteJoint_GetMotorTorque( b2JointId jointId ); } */
    public static native float nb2RevoluteJoint_GetMotorTorque(long jointId);

    // --- [ b2RevoluteJoint_SetMaxMotorTorque ] ---

    /**
     * {@code B2_API void b2RevoluteJoint_SetMaxMotorTorque( b2JointId jointId, float torque ); }
     *
     * @param jointId b2JointId
     * @param torque float
     */
    public static void b2RevoluteJoint_SetMaxMotorTorque(b2JointId jointId, float torque) {
        checkPointers(jointId);
        nb2RevoluteJoint_SetMaxMotorTorque(jointId.address(), torque);
    }

    /* {@code B2_API void b2RevoluteJoint_SetMaxMotorTorque( b2JointId jointId, float torque ); } */
    public static native void nb2RevoluteJoint_SetMaxMotorTorque(long jointId, float torque);

    // --- [ b2RevoluteJoint_GetMaxMotorTorque ] ---

    /**
     * {@code B2_API float b2RevoluteJoint_GetMaxMotorTorque( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2RevoluteJoint_GetMaxMotorTorque(b2JointId jointId) {
        checkPointers(jointId);
        return nb2RevoluteJoint_GetMaxMotorTorque(jointId.address());
    }

    /* {@code B2_API float b2RevoluteJoint_GetMaxMotorTorque( b2JointId jointId ); } */
    public static native float nb2RevoluteJoint_GetMaxMotorTorque(long jointId);
    
    // --- [ b2CreateWeldJoint ] ---

    /**
     * {@code B2_API b2JointId b2CreateWeldJoint( b2WorldId worldId, const b2WeldJointDef* def ); }
     *
     * @param worldId b2WorldId
     * @param def ConstB2WeldJointDef
     * @param __result store
     *
     * @return b2JointId
     */
    public static b2JointId b2CreateWeldJoint(b2WorldId worldId, ConstB2WeldJointDef def, b2JointId __result) {
        checkPointers(worldId, def, __result);
        nb2CreateWeldJoint(worldId.address(), def.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2JointId b2CreateWeldJoint( b2WorldId worldId, const b2WeldJointDef* def ); } */
    public static native void nb2CreateWeldJoint(long worldId, long def, long __result);

    // --- [ b2WeldJoint_SetLinearHertz ] ---

    /**
     * {@code B2_API void b2WeldJoint_SetLinearHertz( b2JointId jointId, float hertz ); }
     *
     * @param jointId b2JointId
     * @param hertz float
     */
    public static void b2WeldJoint_SetLinearHertz(b2JointId jointId, float hertz) {
        checkPointers(jointId);
        nb2WeldJoint_SetLinearHertz(jointId.address(), hertz);
    }

    /* {@code B2_API void b2WeldJoint_SetLinearHertz( b2JointId jointId, float hertz ); } */
    public static native void nb2WeldJoint_SetLinearHertz(long jointId, float hertz);

    // --- [ b2WeldJoint_GetLinearHertz ] ---

    /**
     * {@code B2_API float b2WeldJoint_GetLinearHertz( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2WeldJoint_GetLinearHertz(b2JointId jointId) {
        checkPointers(jointId);
        return nb2WeldJoint_GetLinearHertz(jointId.address());
    }

    /* {@code B2_API float b2WeldJoint_GetLinearHertz( b2JointId jointId ); } */
    public static native float nb2WeldJoint_GetLinearHertz(long jointId);

    // --- [ b2WeldJoint_SetLinearDampingRatio ] ---

    /**
     * {@code B2_API void b2WeldJoint_SetLinearDampingRatio( b2JointId jointId, float dampingRatio ); }
     *
     * @param jointId b2JointId
     * @param dampingRatio float
     */
    public static void b2WeldJoint_SetLinearDampingRatio(b2JointId jointId, float dampingRatio) {
        checkPointers(jointId);
        nb2WeldJoint_SetLinearDampingRatio(jointId.address(), dampingRatio);
    }

    /* {@code B2_API void b2WeldJoint_SetLinearDampingRatio( b2JointId jointId, float dampingRatio ); } */
    public static native void nb2WeldJoint_SetLinearDampingRatio(long jointId, float dampingRatio);

    // --- [ b2WeldJoint_GetLinearDampingRatio ] ---

    /**
     * {@code B2_API float b2WeldJoint_GetLinearDampingRatio( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2WeldJoint_GetLinearDampingRatio(b2JointId jointId) {
        checkPointers(jointId);
        return nb2WeldJoint_GetLinearDampingRatio(jointId.address());
    }

    /* {@code B2_API float b2WeldJoint_GetLinearDampingRatio( b2JointId jointId ); } */
    public static native float nb2WeldJoint_GetLinearDampingRatio(long jointId);

    // --- [ b2WeldJoint_SetAngularHertz ] ---

    /**
     * {@code B2_API void b2WeldJoint_SetAngularHertz( b2JointId jointId, float hertz ); }
     *
     * @param jointId b2JointId
     * @param hertz float
     */
    public static void b2WeldJoint_SetAngularHertz(b2JointId jointId, float hertz) {
        checkPointers(jointId);
        nb2WeldJoint_SetAngularHertz(jointId.address(), hertz);
    }

    /* {@code B2_API void b2WeldJoint_SetAngularHertz( b2JointId jointId, float hertz ); } */
    public static native void nb2WeldJoint_SetAngularHertz(long jointId, float hertz);

    // --- [ b2WeldJoint_GetAngularHertz ] ---

    /**
     * {@code B2_API float b2WeldJoint_GetAngularHertz( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2WeldJoint_GetAngularHertz(b2JointId jointId) {
        checkPointers(jointId);
        return nb2WeldJoint_GetAngularHertz(jointId.address());
    }

    /* {@code B2_API float b2WeldJoint_GetAngularHertz( b2JointId jointId ); } */
    public static native float nb2WeldJoint_GetAngularHertz(long jointId);

    // --- [ b2WeldJoint_SetAngularDampingRatio ] ---

    /**
     * {@code B2_API void b2WeldJoint_SetAngularDampingRatio( b2JointId jointId, float dampingRatio ); }
     *
     * @param jointId b2JointId
     * @param dampingRatio float
     */
    public static void b2WeldJoint_SetAngularDampingRatio(b2JointId jointId, float dampingRatio) {
        checkPointers(jointId);
        nb2WeldJoint_SetAngularDampingRatio(jointId.address(), dampingRatio);
    }

    /* {@code B2_API void b2WeldJoint_SetAngularDampingRatio( b2JointId jointId, float dampingRatio ); } */
    public static native void nb2WeldJoint_SetAngularDampingRatio(long jointId, float dampingRatio);

    // --- [ b2WeldJoint_GetAngularDampingRatio ] ---

    /**
     * {@code B2_API float b2WeldJoint_GetAngularDampingRatio( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2WeldJoint_GetAngularDampingRatio(b2JointId jointId) {
        checkPointers(jointId);
        return nb2WeldJoint_GetAngularDampingRatio(jointId.address());
    }

    /* {@code B2_API float b2WeldJoint_GetAngularDampingRatio( b2JointId jointId ); } */
    public static native float nb2WeldJoint_GetAngularDampingRatio(long jointId);

    // --- [ b2CreateWheelJoint ] ---

    /**
     * {@code B2_API b2JointId b2CreateWheelJoint( b2WorldId worldId, const b2WheelJointDef* def ); }
     *
     * @param worldId b2WorldId
     * @param def ConstB2WheelJointDef
     * @param __result store
     *
     * @return b2JointId
     */
    public static b2JointId b2CreateWheelJoint(b2WorldId worldId, ConstB2WheelJointDef def, b2JointId __result) {
        checkPointers(worldId, def, __result);
        nb2CreateWheelJoint(worldId.address(), def.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2JointId b2CreateWheelJoint( b2WorldId worldId, const b2WheelJointDef* def ); } */
    public static native void nb2CreateWheelJoint(long worldId, long def, long __result);

    // --- [ b2WheelJoint_EnableSpring ] ---

    /**
     * {@code B2_API void b2WheelJoint_EnableSpring( b2JointId jointId, bool enableSpring ); }
     *
     * @param jointId b2JointId
     * @param enableSpring boolean
     */
    public static void b2WheelJoint_EnableSpring(b2JointId jointId, boolean enableSpring) {
        checkPointers(jointId);
        nb2WheelJoint_EnableSpring(jointId.address(), enableSpring);
    }

    /* {@code B2_API void b2WheelJoint_EnableSpring( b2JointId jointId, bool enableSpring ); } */
    public static native void nb2WheelJoint_EnableSpring(long jointId, boolean enableSpring);

    // --- [ b2WheelJoint_IsSpringEnabled ] ---

    /**
     * {@code B2_API bool b2WheelJoint_IsSpringEnabled( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return boolean
     */
    public static boolean b2WheelJoint_IsSpringEnabled(b2JointId jointId) {
        checkPointers(jointId);
        return nb2WheelJoint_IsSpringEnabled(jointId.address());
    }

    /* {@code B2_API bool b2WheelJoint_IsSpringEnabled( b2JointId jointId ); } */
    public static native boolean nb2WheelJoint_IsSpringEnabled(long jointId);

    // --- [ b2WheelJoint_SetSpringHertz ] ---

    /**
     * {@code B2_API void b2WheelJoint_SetSpringHertz( b2JointId jointId, float hertz ); }
     *
     * @param jointId b2JointId
     * @param hertz float
     */
    public static void b2WheelJoint_SetSpringHertz(b2JointId jointId, float hertz) {
        checkPointers(jointId);
        nb2WheelJoint_SetSpringHertz(jointId.address(), hertz);
    }

    /* {@code B2_API void b2WheelJoint_SetSpringHertz( b2JointId jointId, float hertz ); } */
    public static native void nb2WheelJoint_SetSpringHertz(long jointId, float hertz);

    // --- [ b2WheelJoint_GetSpringHertz ] ---

    /**
     * {@code B2_API float b2WheelJoint_GetSpringHertz( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2WheelJoint_GetSpringHertz(b2JointId jointId) {
        checkPointers(jointId);
        return nb2WheelJoint_GetSpringHertz(jointId.address());
    }

    /* {@code B2_API float b2WheelJoint_GetSpringHertz( b2JointId jointId ); } */
    public static native float nb2WheelJoint_GetSpringHertz(long jointId);

    // --- [ b2WheelJoint_SetSpringDampingRatio ] ---

    /**
     * {@code B2_API void b2WheelJoint_SetSpringDampingRatio( b2JointId jointId, float dampingRatio ); }
     *
     * @param jointId b2JointId
     * @param dampingRatio float
     */
    public static void b2WheelJoint_SetSpringDampingRatio(b2JointId jointId, float dampingRatio) {
        checkPointers(jointId);
        nb2WheelJoint_SetSpringDampingRatio(jointId.address(), dampingRatio);
    }

    /* {@code B2_API void b2WheelJoint_SetSpringDampingRatio( b2JointId jointId, float dampingRatio ); } */
    public static native void nb2WheelJoint_SetSpringDampingRatio(long jointId, float dampingRatio);

    // --- [ b2WheelJoint_GetSpringDampingRatio ] ---

    /**
     * {@code B2_API float b2WheelJoint_GetSpringDampingRatio( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2WheelJoint_GetSpringDampingRatio(b2JointId jointId) {
        checkPointers(jointId);
        return nb2WheelJoint_GetSpringDampingRatio(jointId.address());
    }

    /* {@code B2_API float b2WheelJoint_GetSpringDampingRatio( b2JointId jointId ); } */
    public static native float nb2WheelJoint_GetSpringDampingRatio(long jointId);

    // --- [ b2WheelJoint_EnableLimit ] ---

    /**
     * {@code B2_API void b2WheelJoint_EnableLimit( b2JointId jointId, bool enableLimit ); }
     *
     * @param jointId b2JointId
     * @param enableLimit boolean
     */
    public static void b2WheelJoint_EnableLimit(b2JointId jointId, boolean enableLimit) {
        checkPointers(jointId);
        nb2WheelJoint_EnableLimit(jointId.address(), enableLimit);
    }

    /* {@code B2_API void b2WheelJoint_EnableLimit( b2JointId jointId, bool enableLimit ); } */
    public static native void nb2WheelJoint_EnableLimit(long jointId, boolean enableLimit);

    // --- [ b2WheelJoint_IsLimitEnabled ] ---

    /**
     * {@code B2_API bool b2WheelJoint_IsLimitEnabled( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return boolean
     */
    public static boolean b2WheelJoint_IsLimitEnabled(b2JointId jointId) {
        checkPointers(jointId);
        return nb2WheelJoint_IsLimitEnabled(jointId.address());
    }

    /* {@code B2_API bool b2WheelJoint_IsLimitEnabled( b2JointId jointId ); } */
    public static native boolean nb2WheelJoint_IsLimitEnabled(long jointId);

    // --- [ b2WheelJoint_GetLowerLimit ] ---

    /**
     * {@code B2_API float b2WheelJoint_GetLowerLimit( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2WheelJoint_GetLowerLimit(b2JointId jointId) {
        checkPointers(jointId);
        return nb2WheelJoint_GetLowerLimit(jointId.address());
    }

    /* {@code B2_API float b2WheelJoint_GetLowerLimit( b2JointId jointId ); } */
    public static native float nb2WheelJoint_GetLowerLimit(long jointId);

    // --- [ b2WheelJoint_GetUpperLimit ] ---

    /**
     * {@code B2_API float b2WheelJoint_GetUpperLimit( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2WheelJoint_GetUpperLimit(b2JointId jointId) {
        checkPointers(jointId);
        return nb2WheelJoint_GetUpperLimit(jointId.address());
    }

    /* {@code B2_API float b2WheelJoint_GetUpperLimit( b2JointId jointId ); } */
    public static native float nb2WheelJoint_GetUpperLimit(long jointId);

    // --- [ b2WheelJoint_SetLimits ] ---

    /**
     * {@code B2_API void b2WheelJoint_SetLimits( b2JointId jointId, float lower, float upper ); }
     *
     * @param jointId b2JointId
     * @param lower float
     * @param upper float
     */
    public static void b2WheelJoint_SetLimits(b2JointId jointId, float lower, float upper) {
        checkPointers(jointId);
        nb2WheelJoint_SetLimits(jointId.address(), lower, upper);
    }

    /* {@code B2_API void b2WheelJoint_SetLimits( b2JointId jointId, float lower, float upper ); } */
    public static native void nb2WheelJoint_SetLimits(long jointId, float lower, float upper);

    // --- [ b2WheelJoint_EnableMotor ] ---

    /**
     * {@code B2_API void b2WheelJoint_EnableMotor( b2JointId jointId, bool enableMotor ); }
     *
     * @param jointId b2JointId
     * @param enableMotor boolean
     */
    public static void b2WheelJoint_EnableMotor(b2JointId jointId, boolean enableMotor) {
        checkPointers(jointId);
        nb2WheelJoint_EnableMotor(jointId.address(), enableMotor);
    }

    /* {@code B2_API void b2WheelJoint_EnableMotor( b2JointId jointId, bool enableMotor ); } */
    public static native void nb2WheelJoint_EnableMotor(long jointId, boolean enableMotor);

    // --- [ b2WheelJoint_IsMotorEnabled ] ---

    /**
     * {@code B2_API bool b2WheelJoint_IsMotorEnabled( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return boolean
     */
    public static boolean b2WheelJoint_IsMotorEnabled(b2JointId jointId) {
        checkPointers(jointId);
        return nb2WheelJoint_IsMotorEnabled(jointId.address());
    }

    /* {@code B2_API bool b2WheelJoint_IsMotorEnabled( b2JointId jointId ); } */
    public static native boolean nb2WheelJoint_IsMotorEnabled(long jointId);

    // --- [ b2WheelJoint_SetMotorSpeed ] ---

    /**
     * {@code B2_API void b2WheelJoint_SetMotorSpeed( b2JointId jointId, float motorSpeed ); }
     *
     * @param jointId b2JointId
     * @param motorSpeed float
     */
    public static void b2WheelJoint_SetMotorSpeed(b2JointId jointId, float motorSpeed) {
        checkPointers(jointId);
        nb2WheelJoint_SetMotorSpeed(jointId.address(), motorSpeed);
    }

    /* {@code B2_API void b2WheelJoint_SetMotorSpeed( b2JointId jointId, float motorSpeed ); } */
    public static native void nb2WheelJoint_SetMotorSpeed(long jointId, float motorSpeed);

    // --- [ b2WheelJoint_GetMotorSpeed ] ---

    /**
     * {@code B2_API float b2WheelJoint_GetMotorSpeed( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2WheelJoint_GetMotorSpeed(b2JointId jointId) {
        checkPointers(jointId);
        return nb2WheelJoint_GetMotorSpeed(jointId.address());
    }

    /* {@code B2_API float b2WheelJoint_GetMotorSpeed( b2JointId jointId ); } */
    public static native float nb2WheelJoint_GetMotorSpeed(long jointId);

    // --- [ b2WheelJoint_SetMaxMotorTorque ] ---

    /**
     * {@code B2_API void b2WheelJoint_SetMaxMotorTorque( b2JointId jointId, float torque ); }
     *
     * @param jointId b2JointId
     * @param torque float
     */
    public static void b2WheelJoint_SetMaxMotorTorque(b2JointId jointId, float torque) {
        checkPointers(jointId);
        nb2WheelJoint_SetMaxMotorTorque(jointId.address(), torque);
    }

    /* {@code B2_API void b2WheelJoint_SetMaxMotorTorque( b2JointId jointId, float torque ); } */
    public static native void nb2WheelJoint_SetMaxMotorTorque(long jointId, float torque);

    // --- [ b2WheelJoint_GetMaxMotorTorque ] ---

    /**
     * {@code B2_API float b2WheelJoint_GetMaxMotorTorque( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2WheelJoint_GetMaxMotorTorque(b2JointId jointId) {
        checkPointers(jointId);
        return nb2WheelJoint_GetMaxMotorTorque(jointId.address());
    }

    /* {@code B2_API float b2WheelJoint_GetMaxMotorTorque( b2JointId jointId ); } */
    public static native float nb2WheelJoint_GetMaxMotorTorque(long jointId);

    // --- [ b2WheelJoint_GetMotorTorque ] ---

    /**
     * {@code B2_API float b2WheelJoint_GetMotorTorque( b2JointId jointId ); }
     *
     * @param jointId b2JointId
     *
     * @return float
     */
    public static float b2WheelJoint_GetMotorTorque(b2JointId jointId) {
        checkPointers(jointId);
        return nb2WheelJoint_GetMotorTorque(jointId.address());
    }

    /* {@code B2_API float b2WheelJoint_GetMotorTorque( b2JointId jointId ); } */
    public static native float nb2WheelJoint_GetMotorTorque(long jointId);
    
    // --- [ b2Contact_IsValid ] ---

    /**
     * {@code B2_API bool b2Contact_IsValid( b2ContactId id ); }
     *
     * @param id b2ContactId
     *
     * @return boolean
     */
    public static boolean b2Contact_IsValid(b2ContactId id) {
        checkPointers(id);
        return nb2Contact_IsValid(id.address());
    }

    /* {@code B2_API bool b2Contact_IsValid( b2ContactId id ); } */
    public static native boolean nb2Contact_IsValid(long id);

    // --- [ b2Contact_GetData ] ---

    /**
     * {@code B2_API b2ContactData b2Contact_GetData( b2ContactId contactId ); }
     *
     * @param contactId b2ContactId
     * @param __result store
     *
     * @return b2ContactData
     */
    public static b2ContactData b2Contact_GetData(b2ContactId contactId, b2ContactData __result) {
        checkPointers(contactId, __result);
        nb2Contact_GetData(contactId.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2ContactData b2Contact_GetData( b2ContactId contactId ); } */
    public static native void nb2Contact_GetData(long contactId, long __result);

    // --- [ b2ValidateReplay ] ---

    /**
     * {@code B2_API bool b2ValidateReplay( const void* data, int size, int workerCount ); }
     *
     * @param data long
     * @param size int
     * @param workerCount int
     *
     * @return boolean
     */
    public static boolean b2ValidateReplay(long data, int size, int workerCount) {
        return nb2ValidateReplay(data, size, workerCount);
    }

    /* {@code B2_API bool b2ValidateReplay( const void* data, int size, int workerCount ); } */
    public static native boolean nb2ValidateReplay(long data, int size, int workerCount);
    
    // --- [ b2RecPlayer_Create ] ---

    /**
     * {@code B2_API b2RecPlayer* b2RecPlayer_Create( const void* data, int size, int workerCount ); }
     *
     * @param data long
     * @param size int
     * @param workerCount int
     *
     * @return b2RecPlayer*
     */
    public static b2RecPlayer b2RecPlayer_Create(long data, int size, int workerCount) {
        long __result = nb2RecPlayer_Create(data, size, workerCount);
        return b2RecPlayer.create(__result);
    }

    /* {@code B2_API b2RecPlayer* b2RecPlayer_Create( const void* data, int size, int workerCount ); } */
    public static native long nb2RecPlayer_Create(long data, int size, int workerCount);

    // --- [ b2RecPlayer_StepFrame ] ---

    /**
     * {@code B2_API bool b2RecPlayer_StepFrame( b2RecPlayer* player ); }
     *
     * @param player long
     *
     * @return boolean
     */
    public static boolean b2RecPlayer_StepFrame(b2RecPlayer player) {
        checkPointers(player);
        return nb2RecPlayer_StepFrame(player.address());
    }

    /* {@code B2_API bool b2RecPlayer_StepFrame( b2RecPlayer* player ); } */
    public static native boolean nb2RecPlayer_StepFrame(long player);

    // --- [ b2RecPlayer_GetWorldId ] ---

    /**
     * {@code B2_API b2WorldId b2RecPlayer_GetWorldId( const b2RecPlayer* player ); }
     *
     * @param player long
     * @param __result store
     *
     * @return b2WorldId
     */
    public static b2WorldId b2RecPlayer_GetWorldId(ConstB2RecPlayer player, b2WorldId __result) {
        checkPointers(player, __result);
        nb2RecPlayer_GetWorldId(player.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2WorldId b2RecPlayer_GetWorldId( const b2RecPlayer* player ); } */
    public static native void nb2RecPlayer_GetWorldId(long player, long __result);

    // --- [ b2RecPlayer_Restart ] ---

    /**
     * {@code B2_API void b2RecPlayer_Restart( b2RecPlayer* player ); }
     *
     * @param player long
     */
    public static void b2RecPlayer_Restart(b2RecPlayer player) {
        checkPointers(player);
        nb2RecPlayer_Restart(player.address());
    }

    /* {@code B2_API void b2RecPlayer_Restart( b2RecPlayer* player ); } */
    public static native void nb2RecPlayer_Restart(long player);

    // --- [ b2RecPlayer_SeekFrame ] ---

    /**
     * {@code B2_API void b2RecPlayer_SeekFrame( b2RecPlayer* player, int targetFrame ); }
     *
     * @param player long
     * @param targetFrame int
     */
    public static void b2RecPlayer_SeekFrame(b2RecPlayer player, int targetFrame) {
        checkPointers(player);
        nb2RecPlayer_SeekFrame(player.address(), targetFrame);
    }

    /* {@code B2_API void b2RecPlayer_SeekFrame( b2RecPlayer* player, int targetFrame ); } */
    public static native void nb2RecPlayer_SeekFrame(long player, int targetFrame);

    // --- [ b2RecPlayer_GetFrame ] ---

    /**
     * {@code B2_API int b2RecPlayer_GetFrame( const b2RecPlayer* player ); }
     *
     * @param player long
     *
     * @return int
     */
    public static int b2RecPlayer_GetFrame(ConstB2RecPlayer player) {
        checkPointers(player);
        return nb2RecPlayer_GetFrame(player.address());
    }

    /* {@code B2_API int b2RecPlayer_GetFrame( const b2RecPlayer* player ); } */
    public static native int nb2RecPlayer_GetFrame(long player);

    // --- [ b2RecPlayer_GetInfo ] ---

    /**
     * {@code B2_API b2RecPlayerInfo b2RecPlayer_GetInfo( const b2RecPlayer* player ); }
     *
     * @param player long
     * @param __result store
     *
     * @return b2RecPlayerInfo
     */
    public static b2RecPlayerInfo b2RecPlayer_GetInfo(ConstB2RecPlayer player, b2RecPlayerInfo __result) {
        checkPointers(player, __result);
        nb2RecPlayer_GetInfo(player.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2RecPlayerInfo b2RecPlayer_GetInfo( const b2RecPlayer* player ); } */
    public static native void nb2RecPlayer_GetInfo(long player, long __result);

    // --- [ b2RecPlayer_IsAtEnd ] ---

    /**
     * {@code B2_API bool b2RecPlayer_IsAtEnd( const b2RecPlayer* player ); }
     *
     * @param player long
     *
     * @return boolean
     */
    public static boolean b2RecPlayer_IsAtEnd(ConstB2RecPlayer player) {
        checkPointers(player);
        return nb2RecPlayer_IsAtEnd(player.address());
    }

    /* {@code B2_API bool b2RecPlayer_IsAtEnd( const b2RecPlayer* player ); } */
    public static native boolean nb2RecPlayer_IsAtEnd(long player);

    // --- [ b2RecPlayer_HasDiverged ] ---

    /**
     * {@code B2_API bool b2RecPlayer_HasDiverged( const b2RecPlayer* player ); }
     *
     * @param player long
     *
     * @return boolean
     */
    public static boolean b2RecPlayer_HasDiverged(ConstB2RecPlayer player) {
        checkPointers(player);
        return nb2RecPlayer_HasDiverged(player.address());
    }

    /* {@code B2_API bool b2RecPlayer_HasDiverged( const b2RecPlayer* player ); } */
    public static native boolean nb2RecPlayer_HasDiverged(long player);

    // --- [ b2RecPlayer_GetDivergeFrame ] ---

    /**
     * {@code B2_API int b2RecPlayer_GetDivergeFrame( const b2RecPlayer* player ); }
     *
     * @param player long
     *
     * @return int
     */
    public static int b2RecPlayer_GetDivergeFrame(ConstB2RecPlayer player) {
        checkPointers(player);
        return nb2RecPlayer_GetDivergeFrame(player.address());
    }

    /* {@code B2_API int b2RecPlayer_GetDivergeFrame( const b2RecPlayer* player ); } */
    public static native int nb2RecPlayer_GetDivergeFrame(long player);

    // --- [ b2RecPlayer_SetKeyframePolicy ] ---

    /**
     * {@code B2_API void b2RecPlayer_SetKeyframePolicy( b2RecPlayer* player, size_t budgetBytes, int minIntervalFrames ); }
     *
     * @param player long
     * @param budgetBytes long
     * @param minIntervalFrames int
     */
    public static void b2RecPlayer_SetKeyframePolicy(b2RecPlayer player, long budgetBytes, int minIntervalFrames) {
        checkPointers(player);
        nb2RecPlayer_SetKeyframePolicy(player.address(), budgetBytes, minIntervalFrames);
    }

    /* {@code B2_API void b2RecPlayer_SetKeyframePolicy( b2RecPlayer* player, size_t budgetBytes, int minIntervalFrames ); } */
    public static native void nb2RecPlayer_SetKeyframePolicy(long player, long budgetBytes, int minIntervalFrames);

    // --- [ b2RecPlayer_GetKeyframeBudget ] ---

    /**
     * {@code B2_API size_t b2RecPlayer_GetKeyframeBudget( const b2RecPlayer* player ); }
     *
     * @param player long
     *
     * @return long
     */
    public static long b2RecPlayer_GetKeyframeBudget(ConstB2RecPlayer player) {
        checkPointers(player);
        return nb2RecPlayer_GetKeyframeBudget(player.address());
    }

    /* {@code B2_API size_t b2RecPlayer_GetKeyframeBudget( const b2RecPlayer* player ); } */
    public static native long nb2RecPlayer_GetKeyframeBudget(long player);

    // --- [ b2RecPlayer_GetKeyframeMinInterval ] ---

    /**
     * {@code B2_API int b2RecPlayer_GetKeyframeMinInterval( const b2RecPlayer* player ); }
     *
     * @param player long
     *
     * @return int
     */
    public static int b2RecPlayer_GetKeyframeMinInterval(ConstB2RecPlayer player) {
        checkPointers(player);
        return nb2RecPlayer_GetKeyframeMinInterval(player.address());
    }

    /* {@code B2_API int b2RecPlayer_GetKeyframeMinInterval( const b2RecPlayer* player ); } */
    public static native int nb2RecPlayer_GetKeyframeMinInterval(long player);

    // --- [ b2RecPlayer_GetKeyframeInterval ] ---

    /**
     * {@code B2_API int b2RecPlayer_GetKeyframeInterval( const b2RecPlayer* player ); }
     *
     * @param player long
     *
     * @return int
     */
    public static int b2RecPlayer_GetKeyframeInterval(ConstB2RecPlayer player) {
        checkPointers(player);
        return nb2RecPlayer_GetKeyframeInterval(player.address());
    }

    /* {@code B2_API int b2RecPlayer_GetKeyframeInterval( const b2RecPlayer* player ); } */
    public static native int nb2RecPlayer_GetKeyframeInterval(long player);

    // --- [ b2RecPlayer_GetKeyframeBytes ] ---

    /**
     * {@code B2_API size_t b2RecPlayer_GetKeyframeBytes( const b2RecPlayer* player ); }
     *
     * @param player long
     *
     * @return long
     */
    public static long b2RecPlayer_GetKeyframeBytes(ConstB2RecPlayer player) {
        checkPointers(player);
        return nb2RecPlayer_GetKeyframeBytes(player.address());
    }

    /* {@code B2_API size_t b2RecPlayer_GetKeyframeBytes( const b2RecPlayer* player ); } */
    public static native long nb2RecPlayer_GetKeyframeBytes(long player);

    // --- [ b2RecPlayer_Destroy ] ---

    /**
     * {@code B2_API void b2RecPlayer_Destroy( b2RecPlayer* player ); }
     *
     * @param player long
     */
    public static void b2RecPlayer_Destroy(b2RecPlayer player) {
        checkPointers(player);
        nb2RecPlayer_Destroy(player.address());
    }

    /* {@code B2_API void b2RecPlayer_Destroy( b2RecPlayer* player ); } */
    public static native void nb2RecPlayer_Destroy(long player);

    // --- [ b2RecPlayer_DrawFrameQueries ] ---

    /**
     * {@code B2_API void b2RecPlayer_DrawFrameQueries( b2RecPlayer* player, b2DebugDraw* draw, int queryIndex ); }
     *
     * @param player long
     * @param draw long
     * @param queryIndex int
     */
    public static void b2RecPlayer_DrawFrameQueries(b2RecPlayer player, b2DebugDraw draw, int queryIndex) {
        checkPointers(player, draw);
        nb2RecPlayer_DrawFrameQueries(player.address(), draw.address(), queryIndex);
    }

    /* {@code B2_API void b2RecPlayer_DrawFrameQueries( b2RecPlayer* player, b2DebugDraw* draw, int queryIndex ); } */
    public static native void nb2RecPlayer_DrawFrameQueries(long player, long draw, int queryIndex);

    // --- [ b2RecPlayer_GetFrameQueryCount ] ---

    /**
     * {@code B2_API int b2RecPlayer_GetFrameQueryCount( const b2RecPlayer* player ); }
     *
     * @param player long
     *
     * @return int
     */
    public static int b2RecPlayer_GetFrameQueryCount(ConstB2RecPlayer player) {
        checkPointers(player);
        return nb2RecPlayer_GetFrameQueryCount(player.address());
    }

    /* {@code B2_API int b2RecPlayer_GetFrameQueryCount( const b2RecPlayer* player ); } */
    public static native int nb2RecPlayer_GetFrameQueryCount(long player);

    // --- [ b2RecPlayer_GetFrameQuery ] ---

    /**
     * {@code B2_API b2RecQueryInfo b2RecPlayer_GetFrameQuery( const b2RecPlayer* player, int index ); }
     *
     * @param player long
     * @param index int
     * @param __result store
     *
     * @return b2RecQueryInfo
     */
    public static b2RecQueryInfo b2RecPlayer_GetFrameQuery(ConstB2RecPlayer player, int index, b2RecQueryInfo __result) {
        checkPointers(player, __result);
        nb2RecPlayer_GetFrameQuery(player.address(), index, __result.address());
        return __result;
    }

    /* {@code B2_API b2RecQueryInfo b2RecPlayer_GetFrameQuery( const b2RecPlayer* player, int index ); } */
    public static native void nb2RecPlayer_GetFrameQuery(long player, int index, long __result);

    // --- [ b2RecPlayer_GetFrameQueryHit ] ---

    /**
     * {@code B2_API b2RecQueryHit b2RecPlayer_GetFrameQueryHit( const b2RecPlayer* player, int queryIndex, int hitIndex ); }
     *
     * @param player long
     * @param queryIndex int
     * @param hitIndex int
     * @param __result store
     *
     * @return b2RecQueryHit
     */
    public static b2RecQueryHit b2RecPlayer_GetFrameQueryHit(ConstB2RecPlayer player, int queryIndex, int hitIndex, b2RecQueryHit __result) {
        checkPointers(player, __result);
        nb2RecPlayer_GetFrameQueryHit(player.address(), queryIndex, hitIndex, __result.address());
        return __result;
    }

    /* {@code B2_API b2RecQueryHit b2RecPlayer_GetFrameQueryHit( const b2RecPlayer* player, int queryIndex, int hitIndex ); } */
    public static native void nb2RecPlayer_GetFrameQueryHit(long player, int queryIndex, int hitIndex, long __result);

    // --- [ b2RecPlayer_GetBodyCount ] ---

    /**
     * {@code B2_API int b2RecPlayer_GetBodyCount( const b2RecPlayer* player ); }
     *
     * @param player long
     *
     * @return int
     */
    public static int b2RecPlayer_GetBodyCount(ConstB2RecPlayer player) {
        checkPointers(player);
        return nb2RecPlayer_GetBodyCount(player.address());
    }

    /* {@code B2_API int b2RecPlayer_GetBodyCount( const b2RecPlayer* player ); } */
    public static native int nb2RecPlayer_GetBodyCount(long player);

    // --- [ b2RecPlayer_GetBodyId ] ---

    /**
     * {@code B2_API b2BodyId b2RecPlayer_GetBodyId( const b2RecPlayer* player, int index ); }
     *
     * @param player long
     * @param index int
     * @param __result store
     *
     * @return b2BodyId
     */
    public static b2BodyId b2RecPlayer_GetBodyId(ConstB2RecPlayer player, int index, b2BodyId __result) {
        checkPointers(player, __result);
            nb2RecPlayer_GetBodyId(player.address(), index, __result.address());
        return __result;
    }

    /* {@code B2_API b2BodyId b2RecPlayer_GetBodyId( const b2RecPlayer* player, int index ); } */
    public static native void nb2RecPlayer_GetBodyId(long player, int index, long __result);

    /** private constructor. */
    private Box2d() {}
}
