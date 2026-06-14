/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.include;

import java.nio.ByteBuffer;

import org.box2d.jni.b2AABB;
import org.box2d.jni.b2BodyEvents;
import org.box2d.jni.b2BodyId;
import org.box2d.jni.b2BodyType;
import org.box2d.jni.b2Capacity;
import org.box2d.jni.b2CastResultFcnI;
import org.box2d.jni.b2ContactEvents;
import org.box2d.jni.b2Counters;
import org.box2d.jni.b2CustomFilterFcnI;
import org.box2d.jni.b2DebugDraw;
import org.box2d.jni.b2FrictionCallbackI;
import org.box2d.jni.b2JointEvents;
import org.box2d.jni.b2OverlapResultFcnI;
import org.box2d.jni.b2PlaneResultFcnI;
import org.box2d.jni.b2PreSolveFcnI;
import org.box2d.jni.b2Profile;
import org.box2d.jni.b2QueryFilter;
import org.box2d.jni.b2RayResult;
import org.box2d.jni.b2Recording;
import org.box2d.jni.b2RestitutionCallbackI;
import org.box2d.jni.b2SensorEvents;
import org.box2d.jni.b2TreeStats;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.b2WorldId;
import org.box2d.jni.readonly.ConstB2BodyDef;

import org.box2d.jni.readonly.ConstB2Capsule;
import org.box2d.jni.readonly.ConstB2ExplosionDef;
import org.box2d.jni.readonly.ConstB2Recording;
import org.box2d.jni.readonly.ConstB2ShapeProxy;
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
}
