/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2Transform</code>. (native type: const b2Transform)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2Transform extends ConstStruct {

    /**
     * An object of type {@link ConstB2Vec2}
     *
     * @return ConstB2Vec2
     */
    ConstB2Vec2 p();

    /**
     * An object of type {@link ConstB2Rot}
     *
     * @return ConstB2Rot
     */
    ConstB2Rot q();

    /**
     * A template that handles the representation of a constant pointer (buffer)
     * of constant structures such as {@code ConstB2Transform}
     *
     * @param <T> The type of object stored in this buffer
     * @param <SELF> The type of this buffer
     */
    interface ConstBuffer<T extends ConstB2Transform, SELF extends ConstBuffer<T, SELF>> extends ConstStructBuffer<T, SELF> {
        /* nothing */
    }
}
