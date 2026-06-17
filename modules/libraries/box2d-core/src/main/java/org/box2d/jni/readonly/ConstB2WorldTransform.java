/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2WorldTransform</code>. (native type: const b2WorldTransform)
 *
 * @param <P> The value type of property {@code p} of the structure
 * @param <Q> The value type of property {@code q} of the structure
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2WorldTransform<P extends ConstB2Pos, Q extends ConstB2Rot> extends ConstStruct {

    /**
     * An object of type {@link ConstB2Vec2}
     *
     * @return ConstB2Pos
     */
    P p();

    /**
     * An object of type {@link ConstB2Rot}
     *
     * @return ConstB2Rot
     */
    Q q();

    /**
     * A template that handles the representation of a constant pointer (buffer)
     * of constant structures such as {@code ConstB2WorldTransform}
     *
     * @param <T> The type of object stored in this buffer
     * @param <SELF> The type of this buffer
     */
    interface ConstBuffer<T extends ConstB2WorldTransform, SELF extends ConstBuffer<T, SELF>> extends ConstStructBuffer<T, SELF> {
        /* nothing */
    }
}
