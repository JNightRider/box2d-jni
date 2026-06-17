/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2Pos</code>. (native type: const b2Pos)
 *
 * @param <X> The value type of property {@code x} of the structure
 * @param <Y> The value type of property {@code y} of the structure
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2Pos<X extends Number, Y extends Number> extends ConstStruct {

    /**
     * Returns the x coordinate.
     *
     * @return Number
     */
    X x();

    /**
     * Returns the y coordinate.
     *
     * @return Number
     */
    Y y();

    /**
     * A template that handles the representation of a constant pointer (buffer)
     * of constant structures such as {@code ConstB2Pos}
     *
     * @param <T> The type of object stored in this buffer
     * @param <SELF> The type of this buffer
     */
    interface ConstBuffer<T extends ConstB2Pos, SELF extends ConstBuffer<T, SELF>> extends ConstStructBuffer<T, SELF> {
        /* nothing */
    }
}
