/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.include;

import org.box2d.jni.b2BodyDef;
import org.box2d.jni.b2Filter;
import org.box2d.jni.b2QueryFilter;
import org.box2d.jni.b2SurfaceMaterial;
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
}
