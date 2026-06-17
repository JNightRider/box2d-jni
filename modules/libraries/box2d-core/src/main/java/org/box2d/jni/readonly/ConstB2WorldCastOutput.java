/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2WorldCastOutput</code>. (native type: const b2WorldCastOutput)
 *
 * @param <POINT> The value type of property {@code point} of the structure
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2WorldCastOutput<POINT extends ConstB2Pos> extends ConstStruct {
    /**
     * The surface normal at the hit point
     *
     * @return b2Vec2
     */
    ConstB2Vec2 normal();

    /**
     * The surface hit point in world space
     *
     * @return POINT
     */
    POINT point();

    /**
     * The fraction of the input translation at collision
     *
     * @return float
     */
    float fraction();

    /**
     * The number of iterations used
     *
     * @return int
     */
    int iterations();

    /**
     * Did the cast hit?
     *
     * @return boolean
     */
    boolean hit();

    /**
     * A template that handles the representation of a constant pointer (buffer)
     * of constant structures such as {@code ConstB2WorldCastOutput}
     *
     * @param <T> The type of object stored in this buffer
     * @param <SELF> The type of this buffer
     */
    interface ConstBuffer<T extends ConstB2WorldCastOutput, SELF extends ConstBuffer<T, SELF>> extends ConstStructBuffer<T, SELF> {
        /* nothing */
    }
}
