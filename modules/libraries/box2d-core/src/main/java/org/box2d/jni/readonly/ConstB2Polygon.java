/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2Polygon</code>. (native type: const b2Polygon)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2Polygon extends ConstStruct {

    /**
     * The polygon vertices
     *
     * @return b2Vec2.Buffer
     */
    ConstB2Vec2.ConstBuffer vertices();

    /**
     * The outward normal vectors of the polygon sides
     *
     * @return ConstB2Vec2.ConstBuffer
     */
    ConstB2Vec2.ConstBuffer normals();

    /**
     * The centroid of the polygon
     *
     * @return ConstB2Vec2.ConstBuffer
     */
    ConstB2Vec2 centroid();

    /**
     * The external radius for rounded polygons
     *
     * @return float
     */
    float radius();

    /**
     * The number of polygon vertices
     *
     * @return int
     */
    int count();
}
