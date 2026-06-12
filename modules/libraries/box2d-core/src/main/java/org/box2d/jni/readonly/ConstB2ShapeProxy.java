/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2ShapeProxy</code>. (native type: const b2ShapeProxy)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2ShapeProxy extends ConstStruct {

    /**
     * The point cloud
     *
     * @return ConstB2Vec2.ConstBuffer
     */
    ConstB2Vec2.ConstBuffer points();

    /**
     * The number of points. Must be greater than 0.
     *
     * @return int
     */
    int count();

    /**
     * The external radius of the point cloud. May be zero.
     *
     * @return int
     */
    float radius();
}
