/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a constant
 * of type <code>b2RayCastInput</code>. (native type: const b2RayCastInput)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2RayCastInput extends ConstStruct {

    /**
     * Start point of the ray cast
     *
     * @return ConstB2Vec2
     */
    ConstB2Vec2 origin();

    /**
     * Translation of the ray cast
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
}
