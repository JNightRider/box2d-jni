/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.include;

import org.box2d.jni.b2BodyDef;
import org.box2d.jni.b2ChainDef;
import org.box2d.jni.b2DebugDraw;
import org.box2d.jni.b2DistanceJointDef;
import org.box2d.jni.b2ExplosionDef;
import org.box2d.jni.b2Filter;
import org.box2d.jni.b2FilterJointDef;
import org.box2d.jni.b2MotorJointDef;
import org.box2d.jni.b2PrismaticJointDef;
import org.box2d.jni.b2QueryFilter;
import org.box2d.jni.b2RevoluteJointDef;
import org.box2d.jni.b2ShapeDef;
import org.box2d.jni.b2SurfaceMaterial;
import org.box2d.jni.b2WeldJointDef;
import org.box2d.jni.b2WorldDef;

import org.box2d.jni.system.Library;
import static org.box2d.jni.system.Checks.*;

/**
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Types {
    static { Library.initialize(); }

    // --- [ b2DefaultWorldDef ] ---

    /**
     * {@code B2_API b2WorldDef b2DefaultWorldDef( void ); }
     *
     * @param __result store
     *
     * @return b2WorldDef
     */
    public static b2WorldDef b2DefaultWorldDef(b2WorldDef __result) {
        checkPointers(__result);
        nb2DefaultWorldDef(__result.address());
        return __result;
    }

    /* {@code B2_API b2WorldDef b2DefaultWorldDef( void ); } */
    public static native void nb2DefaultWorldDef(long __result);
    
    // --- [ b2DefaultBodyDef ] ---

    /**
     * {@code B2_API b2BodyDef b2DefaultBodyDef( void ); }
     *
     * @param __result store
     *
     * @return b2BodyDef
     */
    public static b2BodyDef b2DefaultBodyDef(b2BodyDef __result) {
        checkPointers(__result);
        nb2DefaultBodyDef(__result.address());
        return __result;
    }

    /* {@code B2_API b2BodyDef b2DefaultBodyDef( void ); } */
    public static native void nb2DefaultBodyDef(long __result);
    
    // --- [ b2DefaultFilter ] ---

    /**
     * {@code B2_API b2Filter b2DefaultFilter( void ); }
     *
     * @param __result store
     *
     * @return b2Filter
     */
    public static b2Filter b2DefaultFilter(b2Filter __result) {
        checkPointers(__result);
        nb2DefaultFilter(__result.address());
        return __result;
    }

    /* {@code B2_API b2Filter b2DefaultFilter( void ); } */
    public static native void nb2DefaultFilter(long __result);
    
    // --- [ b2DefaultQueryFilter ] ---

    /**
     * {@code B2_API b2QueryFilter b2DefaultQueryFilter( void ); }
     *
     * @param __result store
     *
     * @return b2QueryFilter
     */
    public static b2QueryFilter b2DefaultQueryFilter(b2QueryFilter __result) {
        checkPointers(__result);
        nb2DefaultQueryFilter(__result.address());
        return __result;
    }

    /* {@code B2_API b2QueryFilter b2DefaultQueryFilter( void ); } */
    public static native void nb2DefaultQueryFilter(long __result);
    
    // --- [ b2DefaultSurfaceMaterial ] ---

    /**
     * {@code B2_API b2SurfaceMaterial b2DefaultSurfaceMaterial( void ); }
     *
     * @param __result store
     *
     * @return b2SurfaceMaterial
     */
    public static b2SurfaceMaterial b2DefaultSurfaceMaterial(b2SurfaceMaterial __result) {
        checkPointers(__result);
        nb2DefaultSurfaceMaterial(__result.address());
        return __result;
    }

    /* {@code B2_API b2SurfaceMaterial b2DefaultSurfaceMaterial( void ); } */
    public static native void nb2DefaultSurfaceMaterial(long __result);
    
    // --- [ b2DefaultShapeDef ] ---

    /**
     * {@code B2_API b2ShapeDef b2DefaultShapeDef( void ); }
     *
     * @param __result store
     *
     * @return b2ShapeDef
     */
    public static b2ShapeDef b2DefaultShapeDef(b2ShapeDef __result) {
        checkPointers(__result);
        nb2DefaultShapeDef(__result.address());
        return __result;
    }

    /* {@code B2_API b2ShapeDef b2DefaultShapeDef( void ); } */
    public static native void nb2DefaultShapeDef(long __result);
    
    // --- [ b2DefaultChainDef ] ---

    /**
     * {@code B2_API b2ChainDef b2DefaultChainDef( void ); }
     *
     * @param __result store
     *
     * @return b2ChainDef
     */
    public static b2ChainDef b2DefaultChainDef(b2ChainDef __result) {
        checkPointers(__result);
        nb2DefaultChainDef(__result.address());
        return __result;
    }

    /* {@code B2_API b2ChainDef b2DefaultChainDef( void ); } */
    public static native void nb2DefaultChainDef(long __result);
    
    // --- [ b2DefaultDistanceJointDef ] ---

    /**
     * {@code B2_API b2DistanceJointDef b2DefaultDistanceJointDef( void ); }
     *
     * @param __result store
     *
     * @return b2DistanceJointDef
     */
    public static b2DistanceJointDef b2DefaultDistanceJointDef(b2DistanceJointDef __result) {
        checkPointers(__result);
        nb2DefaultDistanceJointDef(__result.address());
        return __result;
    }

    /* {@code B2_API b2DistanceJointDef b2DefaultDistanceJointDef( void ); } */
    public static native void nb2DefaultDistanceJointDef(long __result);
    
    // --- [ b2DefaultMotorJointDef ] ---

    /**
     * {@code B2_API b2MotorJointDef b2DefaultMotorJointDef( void ); }
     *
     * @param __result store
     *
     * @return b2MotorJointDef
     */
    public static b2MotorJointDef b2DefaultMotorJointDef(b2MotorJointDef __result) {
        checkPointers(__result);
        nb2DefaultMotorJointDef(__result.address());
        return __result;
    }

    /* {@code B2_API b2MotorJointDef b2DefaultMotorJointDef( void ); } */
    public static native void nb2DefaultMotorJointDef(long __result);
    
    // --- [ b2DefaultFilterJointDef ] ---

    /**
     * {@code B2_API b2FilterJointDef b2DefaultFilterJointDef( void ); }
     *
     * @param __result store
     *
     * @return b2FilterJointDef
     */
    public static b2FilterJointDef b2DefaultFilterJointDef(b2FilterJointDef __result) {
        checkPointers(__result);
        nb2DefaultFilterJointDef(__result.address());
        return __result;
    }

    /* {@code B2_API b2FilterJointDef b2DefaultFilterJointDef( void ); } */
    public static native void nb2DefaultFilterJointDef(long __result);
    
    // --- [ b2DefaultPrismaticJointDef ] ---

    /**
     * {@code B2_API b2PrismaticJointDef b2DefaultPrismaticJointDef( void ); }
     *
     * @param __result store
     *
     * @return b2PrismaticJointDef
     */
    public static b2PrismaticJointDef b2DefaultPrismaticJointDef(b2PrismaticJointDef __result) {
        checkPointers(__result);
        nb2DefaultPrismaticJointDef(__result.address());
        return __result;
    }

    /* {@code B2_API b2PrismaticJointDef b2DefaultPrismaticJointDef( void ); } */
    public static native void nb2DefaultPrismaticJointDef(long __result);
    
    // --- [ b2DefaultRevoluteJointDef ] ---

    /**
     * {@code B2_API b2RevoluteJointDef b2DefaultRevoluteJointDef( void ); }
     *
     * @param __result store
     *
     * @return b2RevoluteJointDef
     */
    public static b2RevoluteJointDef b2DefaultRevoluteJointDef(b2RevoluteJointDef __result) {
        checkPointers(__result);
        nb2DefaultRevoluteJointDef(__result.address());
        return __result;
    }

    /* {@code B2_API b2RevoluteJointDef b2DefaultRevoluteJointDef( void ); } */
    public static native void nb2DefaultRevoluteJointDef(long __result);
    
    // --- [ b2DefaultWeldJointDef ] ---

    /**
     * {@code B2_API b2WeldJointDef b2DefaultWeldJointDef( void ); }
     *
     * @param __result store
     *
     * @return b2WeldJointDef
     */
    public static b2WeldJointDef b2DefaultWeldJointDef(b2WeldJointDef __result) {
        checkPointers(__result);
        nb2DefaultWeldJointDef(__result.address());
        return __result;
    }

    /* {@code B2_API b2WeldJointDef b2DefaultWeldJointDef( void ); } */
    public static native void nb2DefaultWeldJointDef(long __result);
    
    // --- [ b2DefaultWheelJointDef ] ---

//    /**
//     * {@code BB2_API b2WheelJointDef b2DefaultWheelJointDef( void ); }
//     *
//     * @param __result store
//     *
//     * @return b2WeldJointDef
//     */
//    public static b2WheelJointDef b2DefaultWheelJointDef(b2WheelJointDef __result) {
//        checkPointers(__result);
//        nb2DefaultWeldJointDef(__result.address());
//        return __result;
//    }

    /* {@code B2_API b2WheelJointDef b2DefaultWheelJointDef( void ); } */
    public static native void nb2DefaultWheelJointDef(long __result);
    
    // --- [ b2DefaultExplosionDef ] ---

    /**
     * {@code B2_API b2ExplosionDef b2DefaultExplosionDef( void ); }
     *
     * @param __result store
     *
     * @return b2ExplosionDef
     */
    public static b2ExplosionDef b2DefaultExplosionDef(b2ExplosionDef __result) {
        checkPointers(__result);
        nb2DefaultExplosionDef(__result.address());
        return __result;
    }

    /* {@code B2_API b2ExplosionDef b2DefaultExplosionDef( void ); } */
    public static native void nb2DefaultExplosionDef(long __result);

    // --- [ b2GetGraphColor ] ---

    /**
     * {@code B2_API b2HexColor b2GetGraphColor( int index ); }
     *
     * @see org.box2d.jni.b2HexColor
     *
     * @param index graph color index
     *
     * @return b2HexColor
     */
    public static int b2GetGraphColor(int index) {
        return nb2GetGraphColor(index);
    }

    /* {@code B2_API b2HexColor b2GetGraphColor( int index ); } */
    public static native int nb2GetGraphColor(int index);

    // --- [ b2DefaultDebugDraw ] ---

    /**
     * {@code B2_API b2DebugDraw b2DefaultDebugDraw( void ); }
     *
     * Use this to initialize your drawing interface. This allows you to implement a sub-set
     * of the drawing functions.
     *
     * @param __result store
     *
     * @return b2DebugDraw
     */
    public static b2DebugDraw b2DefaultDebugDraw(b2DebugDraw __result) {
        checkPointers(__result);
        nb2DefaultDebugDraw(__result.address());
        return __result;
    }

    /* {@code B2_API b2DebugDraw b2DefaultDebugDraw( void ); } */
    public static native void nb2DefaultDebugDraw(long __result);
}
