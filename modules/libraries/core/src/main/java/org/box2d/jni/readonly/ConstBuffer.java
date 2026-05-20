/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a constant
 * of type <code>ConstBuffer</code>. (native type: const void*|void[])
 *
 * @param <E> type|{@code const void*}
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstBuffer<E> extends ConstPointer {

    /**
     * Returns this buffer's capacity.
     *
     * @return the capacity of this buffer
     */
    int capacity();

    /**
     * Returns this buffer's position.
     *
     * @return the position of this buffer
     */
    int position();

    /**
     * Returns this buffer's limit.
     *
     * @return the limit of this buffer
     */
    int limit();

    /**
     * Returns the number of elements between the current position and the
     * limit.
     *
     * @return the number of elements remaining in this buffer
     */
    int remaining();

    /**
     * Tells whether there are any elements between the current position and the
     * limit.
     *
     * @return {@code true} if, and only if, there is at least one element
     * remaining in this buffer
     */
    boolean hasRemaining();

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
    E get();

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
    E get(int index);
}
