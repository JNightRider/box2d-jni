/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2CollisionPlane</code>. (native type: const b2CollisionPlane)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2CollisionPlane extends ConstStruct {

    /**
     * The collision plane between the mover and some shape
     *
     * @return ConstB2Plane
     */
    ConstB2Plane plane();

    /**
     * Setting this to FLT_MAX makes the plane as rigid as possible. Lower
     * values can make the plane collision soft. Usually in meters.
     *
     * @return float
     */
    float pushLimit();

    /**
     * The push on the mover determined by b2SolvePlanes. Usually in meters.
     *
     * @return float
     */
    float push();

    /**
     * Indicates if b2ClipVector should clip against this plane. Should be false
     * for soft collision.
     *
     * @return boolean
     */
    boolean clipVelocity();
}
