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
package org.box2d.jni;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2MotionLocks;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2MotionLocks
 * {
 * 	bool linearX;
 * 	bool linearY;
 * 	bool angularZ;
 * } b2MotionLocks;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2MotionLocks extends Struct<b2MotionLocks> implements ConstB2MotionLocks {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            LINEAR_X,
            LINEAR_Y,
            ANGULAR_Z;

    static {
        Layout layout = __struct(
                __member(1),
                __member(1),
                __member(1)
        );

        LINEAR_X = layout.offsetof(0);
        LINEAR_Y = layout.offsetof(1);
        ANGULAR_Z = layout.offsetof(2);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2MotionLocks(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2MotionLocks(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     *
     * @see Struct#Struct(long, boolean)
     */
    protected b2MotionLocks(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code linearX} */
    @Override
    public boolean linearX() { return nlinearX(address()); }
    /** @return Returns the property {@code linearY} */
    @Override
    public boolean linearY() { return nlinearY(address()); }
    /** @return Returns the property {@code angularZ} */
    @Override
    public boolean angularZ() { return nangularZ(address()); }

    /**
     * Set the value of property {@code linearX}
     *
     * @param value The value
     * @return b2MotionLocks
     */
    public b2MotionLocks linearX(boolean value) { nlinearX(address(), value); return this; }
    /**
     * Set the value of property {@code linearY}
     *
     * @param value The value
     * @return b2MotionLocks
     */
    public b2MotionLocks linearY(boolean value) { nlinearY(address(), value); return this; }
    /**
     * Set the value of property {@code angularZ}
     *
     * @param value The value
     * @return b2MotionLocks
     */
    public b2MotionLocks angularZ(boolean value) { nangularZ(address(), value); return this; }

    /*(non-Javadoc)
     */
    @Override
    public int sizeof() { return SIZEOF; }

    /*(non-Javadoc)
     */
    @Override
    protected b2MotionLocks create(long address, Pointer ptr) {
        return ptr == null ? new b2MotionLocks(address) : new b2MotionLocks(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2MotionLocks
     */
    private static b2MotionLocks factory() {
        return new b2MotionLocks(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2MotionLocks
     */
    public static b2MotionLocks createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2MotionLocks(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2MotionLocks}.
     *
     * @param alloc Custom memory manager
     * @return b2MotionLocks
     */
    public static b2MotionLocks alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2MotionLocks(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2MotionLocks}.
     *
     * @return b2MotionLocks
     */
    public static b2MotionLocks calloc() {
        return new b2MotionLocks(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2MotionLocks}.
     *
     * @param arean arena
     * @return b2MotionLocks
     */
    public static b2MotionLocks calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2MotionLocks(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2MotionLocks}.
     *
     * @return b2MotionLocks
     */
    public static b2MotionLocks malloc() {
        return new b2MotionLocks(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2MotionLocks}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2MotionLocks}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, capacity, SIZEOF);
        return new Buffer(address, capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2MotionLocks}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2MotionLocks}.
     *
     * @param capacity Number of elements
     * @param arena Arean
     * @return Buffer
     */
    public static Buffer calloc(int capacity, ArenaAlloc arena) {
        long ptr = arena.ncalloc(ALIGNOF, capacity, SIZEOF);
        return new Buffer(ptr, capacity);
    }

    // -----------------------------------

    public static boolean nlinearX(long address) { return memGetByte(address + LINEAR_X) != 0; }
    public static boolean nlinearY(long address) { return memGetByte(address + LINEAR_Y) != 0; }
    public static boolean nangularZ(long address) { return memGetByte(address + ANGULAR_Z) != 0; }

    public static void nlinearX(long address, boolean value) { memPutByte(address + LINEAR_X, (byte)(value ? 1 : 0)); }
    public static void nlinearY(long address, boolean value) {  memPutByte(address + LINEAR_Y, (byte)(value ? 1 : 0)); }
    public static void nangularZ(long address, boolean value) { memPutByte(address + ANGULAR_Z, (byte)(value ? 1 : 0)); }

    // -----------------------------------

    /** An array of {@code b2MotionLocks} structs. */
    public static class Buffer extends StructBuffer<b2MotionLocks, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2MotionLocks ELEMENT_FACTORY = b2MotionLocks.factory();

        /**
         * Create a new buffer.
         *
         * @param address long
         * @param remaining int
         */
        public Buffer(long address, int remaining) {
            super(address, remaining);
        }

        /**
         * Create a new buffer.
         *
         * @param address long
         * @param mark int
         * @param position int
         * @param limit int
         * @param capacity int
         */
        public Buffer(long address, int mark, int position, int limit, int capacity) {
            super(address, mark, position, limit, capacity);
        }

        /*(non-Javadoc)
         */
        @Override
        protected b2MotionLocks getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /*(non-Javadoc)
         */
        @Override
        protected Buffer self() {
            return this;
        }

        /*(non-Javadoc)
         */
        @Override
        protected Buffer create(long address, int mark, int position, int limit, int capacity) {
            return new Buffer(address, mark, position, limit, capacity);
        }
    }
}
