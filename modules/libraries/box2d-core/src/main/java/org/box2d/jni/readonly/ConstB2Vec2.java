/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2Vec2</code>. (native type: const b2Vec2)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2Vec2 extends ConstStruct {

    /**
     * Returns the x coordinate.
     *
     * @return float
     */
    float x();

    /**
     * Returns the y coordinate.
     *
     * @return float
     */
    float y();

    /**
     * A template that handles the representation of a constant pointer (buffer)
     * of constant structures such as {@code ConstB2Vec2}
     *
     * @param <T> The type of object stored in this buffer
     * @param <SELF> The type of this buffer
     */
    interface ConstBuffer<T extends ConstB2Vec2, SELF extends ConstBuffer<T, SELF>> extends ConstStructBuffer<T, SELF> {
        /* nothing */
    }
}
