/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2TOIInput</code>. (native type: const b2TOIInput)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2TOIInput extends ConstStruct {

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
     * The movement of shape A
     *
     * @return ConstB2Sweep
     */
    ConstB2Sweep sweepA();

    /**
     * The movement of shape B
     *
     * @return ConstB2Sweep
     */
    ConstB2Sweep sweepB();

    /**
     * Defines the sweep interval [0, maxFraction]
     *
     * @return float
     */
    float maxFraction();
}
