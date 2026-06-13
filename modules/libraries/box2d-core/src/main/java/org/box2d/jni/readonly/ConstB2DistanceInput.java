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
     * The world transform for shape A
     *
     * @return ConstB2Transform
     */
    ConstB2Transform transformA();

    /**
     * The world transform for shape B
     *
     * @return ConstB2Transform
     */
    ConstB2Transform transformB();

    /**
     * Should the proxy radius be considered?
     *
     * @return boolean
     */
    boolean useRadii();
}
