/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2SimplexVertex</code>. (native type: const
 * b2SimplexVertex)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2SimplexVertex extends ConstStruct {

    /**
     * support point in proxyA
     *
     * @return
     */
    ConstB2Vec2 wA();

    /**
     * support point in proxyB
     *
     * @return
     */
    ConstB2Vec2 wB();

    /**
     * wB - wA
     *
     * @return
     */
    ConstB2Vec2 w();

    /**
     * barycentric coordinate for closest point
     *
     * @return float
     */
    float a();

    /**
     * wA index
     *
     * @return int
     */
    int indexA();

    /**
     * wB index
     *
     * @return int
     */
    int indexB();
}
