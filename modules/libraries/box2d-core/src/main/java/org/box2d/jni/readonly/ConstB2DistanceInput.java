/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2DistanceInput</code>. (native type: const
 * b2DistanceInput)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2DistanceInput extends ConstStruct {

    /**
     * The proxy for shape A
     *
     * @return ConstB2ShapeProxy
     */
    ConstB2ShapeProxy proxyA();

    /**
     * The proxy for shape B
     *
     * @return ConstB2ShapeProxy
     */
    ConstB2ShapeProxy proxyB();

    /**
     * Transform of shape B in shape A's frame, the relative pose B in A
     * (b2InvMulTransforms( worldA, worldB )). The query is origin independent
     * and runs in frame A.
     *
     * @return ConstB2Transform
     */
    ConstB2Transform transform();

    /**
     * Should the proxy radius be considered?
     *
     * @return boolean
     */
    boolean useRadii();
}
