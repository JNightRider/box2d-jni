/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2BoxCastInput</code>. (native type: const b2BoxCastInput)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2BoxCastInput extends ConstStruct {

    /**
     * The AABB to cast, in the tree's frame.
     *
     * @return ConstB2AABB
     */
    ConstB2AABB box();

    /**
     * The sweep translation.
     *
     * @return ConstB2Vec2
     */
    ConstB2Vec2 translation();

    /**
     * The maximum fraction of the translation to consider, typically 1.
     *
     * @return
     */
    float maxFraction();
}
