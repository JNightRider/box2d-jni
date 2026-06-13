/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2PlaneResult</code>. (native type: const
 * b2PlaneResult)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2PlaneResult extends ConstStruct {

    /**
     * The collision plane between the mover and a convex shape
     *
     * @return ConstB2Plane
     */
    ConstB2Plane plane();

    /**
     * The collision point on the shape.
     *
     * @return ConstB2Vec2
     */
    ConstB2Vec2 point();

    /**
     * Did the collision register a hit? If not this plane should be ignored.
     *
     * @return boolean
     */
    boolean hit();
}
