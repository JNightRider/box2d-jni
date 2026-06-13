/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2ShapeCastPairInput</code>. (native type: const
 * b2ShapeCastPairInput)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2ShapeCastPairInput extends ConstStruct {

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
     * The translation of shape B
     *
     * @return ConstB2Vec2
     */
    ConstB2Vec2 translationB();

    /**
     * The fraction of the translation to consider, typically 1
     *
     * @return float
     */
    float maxFraction();

    /**
     * Allows shapes with a radius to move slightly closer if already touching
     *
     * @return boolean
     */
    boolean canEncroach();
}
