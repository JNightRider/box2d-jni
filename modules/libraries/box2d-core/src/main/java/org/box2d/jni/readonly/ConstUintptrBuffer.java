/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a constant
 * of type <code>ConstUintptrBuffer</code>. (native type: const void*|void[])
 *
 * @param <SELF> type|{@code const void*}
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstUintptrBuffer<SELF extends ConstUintptrBuffer<SELF>> extends ConstPointer {

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
     * Returns the buffer's base address. [INTERNAL USE ONLY]
     *
     * @return
     */
    long address0();
}
