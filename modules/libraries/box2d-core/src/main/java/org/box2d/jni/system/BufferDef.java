/*
BSD 3-Clause License

Copyright (c) 2026, Night Rider

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.box2d.jni.system;

import java.util.function.Consumer;

/**
 * Base class of struct custom buffers.
 *
 * @param <T> Data type managed by the buffer
 * @param <SELF> The object that implements the buffer
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.8
 */
public interface BufferDef<T, SELF extends BufferDef<T, SELF>> {

    /**
     * Returns the {@code sizeof} a single element in the buffer.
     *
     * @return int
     */
    int sizeof();

    /**
     * Returns the buffer's base address. [INTERNAL USE ONLY]
     *
     * @return long
     */
    long address0();

    /**
     * Returns the memory address at the current buffer position.
     *
     * @return long
     */
    long address();

    /**
     * Returns the memory address at the specified buffer position.
     *
     * @param position int
     * @return long
     */
    long address(int position);

    /**
     * Frees the buffer allocation.
     *
     * <p>
     * This method should not be used if the memory backing this buffer is not
     * owned by the buffer.</p>
     */
    void free();

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
     * Sets this buffer's position. If the mark is defined and larger than the
     * new position then it is discarded.
     *
     * @param position the new position value; must be non-negative and no
     * larger than the current limit
     *
     * @return This buffer
     *
     * @throws IllegalArgumentException If the preconditions on
     * {@code newPosition} do not hold
     */
    SELF position(int position);

    /**
     * Returns this buffer's limit.
     *
     * @return the limit of this buffer
     */
    int limit();

    /**
     * Sets this buffer's limit. If the position is larger than the new limit
     * then it is set to the new limit. If the mark is defined and larger than
     * the new limit then it is discarded.
     *
     * @param limit the new limit value; must be non-negative and no larger than
     * this buffer's capacity
     *
     * @return This buffer
     *
     * @throws IllegalArgumentException If the preconditions on {@code newLimit}
     * do not hold
     */
    SELF limit(int limit);

    /**
     * Sets this buffer's mark at its position.
     *
     * @return This buffer
     */
    SELF mark();

    /**
     * Resets this buffer's position to the previously-marked position.
     *
     * <p>
     * Invoking this method neither changes nor discards the mark's value.</p>
     *
     * @return This buffer
     *
     * @throws java.nio.InvalidMarkException If the mark has not been set
     */
    SELF reset();

    /**
     * Clears this buffer. The position is set to zero, the limit is set to the
     * capacity, and the mark is discarded.
     *
     * <p>
     * Invoke this method before using a sequence of channel-read or <i>put</i>
     * operations to fill this buffer. For example:</p>
     *
     * <blockquote><pre>
     * buf.clear();     // Prepare buffer for reading
     * in.read(buf);    // Read data</pre></blockquote>
     *
     * <p>
     * This method does not actually erase the data in the buffer, but it is
     * named as if it did because it will most often be used in situations in
     * which that might as well be the case.</p>
     *
     * @return This buffer
     */
    SELF clear();

    /**
     * Flips this buffer. The limit is set to the current position and then the
     * position is set to zero. If the mark is defined then it is discarded.
     *
     * <p>
     * After a sequence of channel-read or <i>put</i> operations, invoke this
     * method to prepare for a sequence of channel-write or relative <i>get</i>
     * operations. For example:</p>
     *
     * <blockquote><pre>
     * buf.put(magic);    // Prepend header
     * in.read(buf);      // Read data into rest of buffer
     * buf.flip();        // Flip buffer
     * out.write(buf);    // Write header + data to channel</pre></blockquote>
     *
     * <p>
     * This method is often used in conjunction with the {@link #compact} method
     * when transferring data from one place to another.</p>
     *
     * @return This buffer
     */
    SELF flip();

    /**
     * Rewinds this buffer. The position is set to zero and the mark is
     * discarded.
     *
     * <p>
     * Invoke this method before a sequence of channel-write or <i>get</i>
     * operations, assuming that the limit has already been set appropriately.
     * For example:</p>
     *
     * <blockquote><pre>
     * out.write(buf);    // Write remaining data
     * buf.rewind();      // Rewind buffer
     * buf.get(array);    // Copy data into array</pre></blockquote>
     *
     * @return This buffer
     */
    SELF rewind();

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
     * Creates a new buffer whose content is a shared subsequence of this
     * buffer's content.
     *
     * <p>
     * The content of the new buffer will start at this buffer's current
     * position. Changes to this buffer's content will be visible in the new
     * buffer, and vice versa; the two buffers' position, limit, and mark values
     * will be independent.</p>
     *
     * <p>
     * The new buffer's position will be zero, its capacity and its limit will
     * be the number of elements remaining in this buffer, and its mark will be
     * undefined. The new buffer will be read-only if, and only if, this buffer
     * is read-only.</p>
     *
     * @return the new buffer
     */
    SELF slice();

    /**
     * Returns a slice of this buffer between
     * {@code (buffer.position() + offset)} and
     * {@code (buffer.position() + offset + capacity)}.
     *
     * <p>
     * The position and limit of this buffer are preserved after a call to this
     * method.</p>
     *
     * @param offset the slice offset, it must be &le; {@code this.remaining()}
     * @param capacity the slice length, it must be &le;
     * {@code this.capacity() - (this.position() + offset)}
     *
     * @return the sliced buffer
     */
    SELF slice(int offset, int capacity);

    /**
     * Creates a new buffer that shares this buffer's content.
     *
     * <p>
     * The content of the new buffer will be that of this buffer. Changes to
     * this buffer's content will be visible in the new buffer, and vice versa;
     * the two buffers' position, limit, and mark values will be independent.
     *
     * <p>
     * The new buffer's capacity, limit and position will be identical to those
     * of this buffer.</p>
     *
     * @return the new buffer
     */
    SELF duplicate();

    // -- Bulk get operations --
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
     * Relative <i>get</i> method. Reads the struct data at this buffer's
     * current position into the specified struct, and then increments the
     * position.
     *
     * @param value value
     * @return the struct at the buffer's current position
     *
     * @throws java.nio.BufferUnderflowException If the buffer's current
     * position is not smaller than its limit
     */
    SELF get(T value);

    /**
     * Relative <i>put</i> method&nbsp;&nbsp;<i>(optional operation)</i>.
     *
     * <p>
     * Writes the specified struct into this buffer at the current position, and
     * then increments the position.</p>
     *
     * @param value the struct to be written
     *
     * @return This buffer
     *
     * @throws java.nio.BufferOverflowException If this buffer's current
     * position is not smaller than its limit
     * @throws java.nio.ReadOnlyBufferException If this buffer is read-only
     */
    SELF put(T value);

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

    /**
     * Absolute <i>get</i> method. Reads the struct data at the specified index
     * into the specified struct.
     *
     * @param index the index from which the struct will be read
     * @param value the value
     *
     * @return the struct at the specified index
     *
     * @throws IndexOutOfBoundsException If {@code index} is negative or not
     * smaller than the buffer's limit
     */
    SELF get(int index, T value);

    /**
     * Relative bulk <i>put</i> method&nbsp;&nbsp;<i>(optional operation)</i>.
     *
     * <p>
     * This method transfers the elements remaining in the specified source
     * buffer into this buffer. If there are more elements remaining in the
     * source buffer than in this buffer, that is, if
     * {@code src.remaining()}&nbsp;{@code &gt;}&nbsp;{@code remaining()}, then
     * no elements are transferred and a
     * {@link java.nio.BufferOverflowException} is thrown.
     *
     * <p>
     * Otherwise, this method copies
     * <i>n</i>&nbsp;=&nbsp;{@code src.remaining()} elements from the specified
     * buffer into this buffer, starting at each buffer's current position. The
     * positions of both buffers are then incremented by <i>n</i>.</p>
     *
     * <p>
     * In other words, an invocation of this method of the form
     * {@code dst.put(src)} has exactly the same effect as the loop</p>
     *
     * <pre>
     *     while (src.hasRemaining())
     *         dst.put(src.get()); </pre>
     *
     * <p>
     * except that it first checks that there is sufficient space in this buffer
     * and it is potentially much more efficient. </p>
     *
     * @param src the source buffer from which elements are to be read; must not
     * be this buffer
     *
     * @return This buffer
     *
     * @throws java.nio.BufferOverflowException If there is insufficient space
     * in this buffer for the remaining elements in the source buffer
     * @throws IllegalArgumentException If the source buffer is this buffer
     * @throws java.nio.ReadOnlyBufferException If this buffer is read-only
     */
    SELF put(SELF src);

    /**
     * Absolute <i>put</i> method&nbsp;&nbsp;<i>(optional operation)</i>.
     *
     * <p>
     * Writes the specified struct into this buffer at the specified index.</p>
     *
     * @param index the index at which the struct will be written
     * @param value the struct value to be written
     *
     * @return This buffer
     *
     * @throws IndexOutOfBoundsException If {@code index} is negative or not
     * smaller than the buffer's limit
     * @throws java.nio.ReadOnlyBufferException If this buffer is read-only
     */
    SELF put(int index, T value);

    /**
     * Relative <i>apply</i> method.
     *
     * <p>
     * Passes the struct at the buffer's current position to the specified
     * {@link Consumer}, and then increments the position.</p>
     *
     * @param consumer The consumer
     * @return This buffer
     *
     * @throws java.nio.BufferUnderflowException If the buffer's current
     * position is not smaller than its limit
     */
    SELF apply(Consumer<T> consumer);

    /**
     * Absolute <i>apply</i> method.
     *
     * <p>
     * Passes the struct at the specified position to the specified
     * {@link Consumer}.</p>
     *
     * @param index the index where the {@code consumer} will be applied.
     * @param consumer The consumer
     *
     * @return This buffer
     *
     * @throws IndexOutOfBoundsException If {@code index} is negative or not
     * smaller than the buffer's limit
     */
    SELF apply(int index, Consumer<T> consumer);

    /**
     * Compacts this buffer&nbsp;&nbsp;<i>(optional operation)</i>.
     *
     * <p>
     * The elements between the buffer's current position and its limit, if any,
     * are copied to the beginning of the buffer. That is, the element at index
     * <i>p</i>&nbsp;=&nbsp;{@code position()} is copied to index zero, the
     * element at index <i>p</i>&nbsp;+&nbsp;1 is copied to index one, and so
     * forth until the element at index {@code limit()}&nbsp;-&nbsp;1 is copied
     * to index
     * <i>n</i>&nbsp;=&nbsp;{@code limit()}&nbsp;-&nbsp;{@code 1}&nbsp;-&nbsp;
     * <i>p</i>. The buffer's position is then set to <i>n+1</i> and its limit
     * is set to its capacity. The mark, if defined, is discarded.
     *
     * <p>
     * The buffer's position is set to the number of elements copied, rather
     * than to zero, so that an invocation of this method can be followed
     * immediately by an invocation of another relative <i>put</i> method.</p>
     *
     * @return This buffer
     *
     * @throws java.nio.ReadOnlyBufferException If this buffer is read-only
     */
    SELF compact();
}
