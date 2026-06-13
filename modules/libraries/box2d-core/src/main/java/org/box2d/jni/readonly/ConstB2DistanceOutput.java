/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2DistanceOutput</code>. (native type: const
 * b2DistanceOutput)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2DistanceOutput extends ConstStruct {

    /**
     * Closest point on shapeA
     *
     * @return ConstB2Vec2
     */
    ConstB2Vec2 pointA();

    /**
     * Closest point on shapeB
     *
     * @return ConstB2Vec2
     */
    ConstB2Vec2 pointB();

    /**
     * Normal vector that points from A to B. Invalid if distance is zero.
     *
     * @return ConstB2Vec2
     */
    ConstB2Vec2 normal();

    /**
     * The final distance, zero if overlapped
     *
     * @return float
     */
    float distance();

    /**
     * Number of GJK iterations used
     *
     * @return float
     */
    int iterations();

    /**
     * The number of simplexes stored in the simplex array
     *
     * @return int
     */
    int simplexCount();
}
