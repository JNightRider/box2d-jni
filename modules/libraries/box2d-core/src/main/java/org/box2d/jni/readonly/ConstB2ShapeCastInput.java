/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2ShapeCastInput</code>. (native type: const
 * b2ShapeCastInput)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2ShapeCastInput extends ConstStruct {

    /**
     * A generic shape
     *
     * @return ConstB2ShapeProxy
     */
    ConstB2ShapeProxy proxy();

    /**
     * The translation of the shape cast
     *
     * @return ConstB2Vec2
     */
    ConstB2Vec2 translation();

    /**
     * The maximum fraction of the translation to consider, typically 1
     *
     * @return float
     */
    float maxFraction();

    /**
     * Allow shape cast to encroach when initially touching. This only works if
     * the radius is greater than zero.
     *
     * @return boolean
     */
    boolean canEncroach();
}
