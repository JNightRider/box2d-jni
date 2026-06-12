/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2SegmentDistanceResult</code>. (native type: const
 * b2SegmentDistanceResult)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2SegmentDistanceResult extends ConstStruct {

    /**
     * The closest point on the first segment
     * 
     * @return ConstB2Vec2
     */
    ConstB2Vec2 closest1();

    /**
     * The closest point on the second segment
     * 
     * @return ConstB2Vec2
     */
    ConstB2Vec2 closest2();

    /**
     * The barycentric coordinate on the first segment
     * 
     * @return float
     */
    float fraction1();

    /**
     * The barycentric coordinate on the second segment
     * 
     * @return float
     */
    float fraction2();

    /**
     * The squared distance between the closest points
     * 
     * @return float
     */
    float distanceSquared();
}
