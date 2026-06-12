/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>Struct</code>. (native type: const struct*|struct[])
 *
 * @param <T>
 * @param <SELF> type|{@code const void*}
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstStructBuffer<T extends ConstStruct, SELF extends ConstStructBuffer<T, SELF>> extends ConstUintptrBuffer<SELF> {

    /**
     * Relative <i>get</i> method. Reads the struct at this buffer's current
     * position, and then increments the position.
     *
     * <p>
     * The struct instance returned is a view of the buffer at the current
     * position. Changes to this buffer's content will be visible in the struct
     * instance and vice versa.</p>
     *
     * @return the struct at the buffer's current position
     *
     * @throws java.nio.BufferUnderflowException If the buffer's current
     * position is not smaller than its limit
     */
    T get();

    /**
     * Absolute <i>get</i> method. Reads the struct at the specified index.
     *
     * <p>
     * The struct instance returned is a view of the buffer at the specified
     * position. Changes to this buffer's content will be visible in the struct
     * instance and vice versa.</p>
     *
     * @param index the index from which the struct will be read
     *
     * @return the struct at the specified index
     *
     * @throws IndexOutOfBoundsException If {@code index} is negative or not
     * smaller than the buffer's limit
     */
    T get(int index);
}
