/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2ChainSegment</code>. (native type: const
 * b2ChainSegment)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2ChainSegment extends ConstStruct {

    /**
     * The tail ghost vertex
     *
     * @return ConstB2Vec2
     */
    ConstB2Vec2 ghost1();

    /**
     * The line segment
     *
     * @return ConstB2Segment
     */
    ConstB2Segment segment();

    /**
     * The head ghost vertex
     *
     * @return ConstB2Vec2
     */
    ConstB2Vec2 ghost2();

    /**
     * The owning chain shape index (internal usage only)
     *
     * @return int
     */
    int chainId();
}
