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

import java.nio.ByteBuffer;
import java.util.Arrays;

import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Debug.*;

/**
 * An off-heap memory stack.
 *
 * <p>
 * This class should be used in a thread-local manner for stack allocations.
 * </p>
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class ArenaAlloc extends Uintptr implements AutoCloseable {

    private static final int DEFAULT_STACK_SIZE = B2System.STACK_SIZE.get(64) * 1024;
    private static final int DEFAULT_STACK_FRAMES = 8;

    private static final ThreadLocal<ArenaAlloc> TLS = ThreadLocal.withInitial(ArenaAlloc::create);

    static {
        if (DEFAULT_STACK_SIZE < 0) {
            throw new IllegalStateException("Invalid stack size.");
        }
    }

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final ByteBuffer container;

    private final int size;

    private int pointer;

    private int[] frames;
    protected int frameIndex;

    /**
     * Creates a new {@code MemoryStack} backed by the specified memory region.
     *
     *
     * @param container the backing memory buffer, may be null
     * @param address the backing memory address
     * @param size the backing memory size
     */
    protected ArenaAlloc(ByteBuffer container, long address, int size) {
        super(address, true);
        this.container = container;

        this.size = size;
        this.pointer = size;

        this.frames = new int[DEFAULT_STACK_FRAMES];
    }

    /**
     * Creates a new {@code ArenaAlloc} with the default size.
     *
     * <p>
     * In the initial state, there is no active stack frame. The {@link #push}
     * method must be used before any allocations.</p>
     *
     * @return ArenaAlloc
     */
    public static ArenaAlloc create() {
        return create(DEFAULT_STACK_SIZE);
    }

    /**
     * Creates a new {@code ArenaAlloc} with the specified size.
     *
     * <p>
     * In the initial state, there is no active stack frame. The {@link #push}
     * method must be used before any allocations.</p>
     *
     * @param capacity the maximum number of bytes that may be allocated on the
     * stack
     * @return ArenaAlloc
     */
    public static ArenaAlloc create(int capacity) {
        return create(Memory.memCreateByteBuffer(capacity));
    }

    /**
     * Creates a new {@code ArenaAlloc} backed by the specified memory buffer.
     *
     * <p>
     * In the initial state, there is no active stack frame. The {@link #push}
     * method must be used before any allocations.</p>
     *
     * @param buffer the backing memory buffer
     * @return ArenaAlloc
     */
    public static ArenaAlloc create(ByteBuffer buffer) {
        long address = Memory.memGetNativeAddress(buffer);
        int size = buffer.remaining();
        return new ArenaAlloc(buffer, address, size);
    }

    /**
     * Stores the current stack pointer and pushes a new frame to the stack.
     *
     * @return this stack
     */
    public ArenaAlloc push() {
        if (frameIndex == frames.length) {
            frameOverflow();
        }

        frames[frameIndex++] = pointer;
        return this;
    }

    private void frameOverflow() {
        apiLog("[WARNING] Out of frame stack space (" + frames.length + ") in thread: " + Thread.currentThread());
        frames = Arrays.copyOf(frames, frames.length * 3 / 2);
    }

    /**
     * Pops the current stack frame and moves the stack pointer to the end of
     * the previous stack frame.
     *
     * @return this stack
     */
    public ArenaAlloc pop() {
        pointer = frames[--frameIndex];
        return this;
    }

    /**
     * Calls {@link #pop} on this {@code ArenaAlloc}.
     *
     * <p>
     * This method should not be used directly. It is called automatically when
     * the {@code ArenaAlloc} is used as a resource in a try-with-resources
     * statement.</p>
     */
    @Override
    public void close() {
        //noinspection resource
        pop();
    }

    /**
     * Returns the address of the backing off-heap memory.
     *
     * @return long
     */
    public long getAddress() {
        return address();
    }

    /**
     * Returns the size of the backing off-heap memory.
     *
     * <p>
     * This is the maximum number of bytes that may be allocated on the
     * stack.</p>
     *
     * @return int
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the current frame index.
     *
     * <p>
     * This is the current number of nested {@link #push} calls.</p>
     *
     * @return int
     */
    public int getFrameIndex() {
        return frameIndex;
    }

    /**
     * Returns the memory address at the current stack pointer.
     *
     * @return int
     */
    public long getPointerAddress() {
        return address() + (pointer & 0xFFFF_FFFFL);
    }

    /**
     * Returns the current stack pointer.
     *
     * <p>
     * The stack grows "downwards", so when the stack is empty {@code pointer}
     * is equal to {@code size}. On every allocation {@code pointer} is reduced
     * by the allocated size (after alignment) and {@code address + pointer}
     * points to the first byte of the last allocation.</p>
     *
     * <p>
     * Effectively, this methods returns how many more bytes may be allocated on
     * the stack.</p>
     *
     * @return int
     */
    public int getPointer() {
        return pointer;
    }

    /**
     * Sets the current stack pointer.
     *
     * @param pointer int
     */
    public void setPointer(int pointer) {
        checkPointer(pointer);
        this.pointer = pointer;
    }

    private void checkPointer(int pointer) {
        if (pointer < 0 || size < pointer) {
            throw new IndexOutOfBoundsException("Invalid stack pointer");
        }
    }

    private static void checkAlignment(int alignment) {
        if (Integer.bitCount(alignment) != 1) {
            throw new IllegalArgumentException("Alignment must be a power-of-two value.");
        }
    }

    /**
     * Calls {@link #nmalloc(int, int)} with {@code alignment} equal to
     * {@link Pointer#POINTER_SIZE POINTER_SIZE}.
     *
     * @param size the allocation size
     *
     * @return the memory address on the stack for the requested allocation
     */
    public long nmalloc(int size) {
        return nmalloc(POINTER_SIZE, size);
    }

    /**
     * Allocates a block of {@code size} bytes of memory on the stack. The
     * content of the newly allocated block of memory is not initialized,
     * remaining with indeterminate values.
     *
     * @param alignment the required alignment
     * @param size the allocation size
     *
     * @return the memory address on the stack for the requested allocation
     */
    public long nmalloc(int alignment, int size) {
        long base = this.address();

        // Align address to the specified alignment
        long address0 = (base + (pointer - size)) & -Integer.toUnsignedLong(alignment);

        int newPointer = (int) (address0 - base);
        if (newPointer < 0) {
            throw new OutOfMemoryError("Out of stack space.");
        }

        pointer = newPointer;
        return address0;
    }

    /**
     * Allocates a block of memory on the stack for an array of {@code num}
     * elements, each of them {@code size} bytes long, and initializes all its
     * bits to zero.
     *
     * @param alignment the required element alignment
     * @param num num the number of elements to allocate
     * @param size the size of each element
     *
     * @return the memory address on the stack for the requested allocation
     */
    public long ncalloc(int alignment, int num, int size) {
        int bytes = num * size;
        long address0 = nmalloc(alignment, bytes);
        nmemset(address0, 0, bytes);
        return address0;
    }

    // -------------------------------------------------

    /**
     * Returns the stack of the current thread.
     *
     * @return ArenaAlloc
     */
    public static ArenaAlloc allocGet() {
        return TLS.get();
    }

    /**
     * Calls {@link #push} on the stack of the current thread.
     *
     * @return the stack of the current thread.
     */
    public static ArenaAlloc allocPush() {
        return allocGet().push();
    }

    /**
     * Calls {@link #pop} on the stack of the current thread.
     *
     * @return the stack of the current thread.
     */
    public static ArenaAlloc allocPop() {
        return allocGet().pop();
    }
}
