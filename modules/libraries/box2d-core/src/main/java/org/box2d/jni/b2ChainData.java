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

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2ChainData
 * {
 *     b2Vec2* points;
 *     int count;
 * } b2ChainData;
 * </code></pre>
 *
 * @author wil
 * @version 1.0.0
 * @since 2.2.0
 */
public class b2ChainData extends Struct<b2ChainData>  {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            POINTS,
            COUNT;

    static {
        Layout layout = __struct(
                __member(POINTER_SIZE),
                __member(4)
        );

        POINTS = layout.offsetof(0);
        COUNT = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2ChainData(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2ChainData(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2ChainData(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code points} */
    public long points() { return npoints(address()); }

    /** @return Returns the property {@code count} */
    public int count() { return ncount(address()); }

    /**
     * Set the value of property {@code points}
     *
     * @param value long
     * @return b2ChainData
     */
    public b2ChainData points(long value) {
        npoints(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code count}
     *
     * @param value int
     * @return b2ChainData
     */
    public b2ChainData count(int value) {
        ncount(address(), value);
        return this;
    }

    /*(non-Javadoc)
     */
    @Override
    public int sizeof() {
        return SIZEOF;
    }

    /*(non-Javadoc)
     */
    @Override
    protected b2ChainData create(long address, Pointer ptr) {
        return ptr == null ? new b2ChainData(address) : new b2ChainData(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2ChainData
     */
    private static b2ChainData factory() {
        return new b2ChainData(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2ChainData
     */
    public static b2ChainData createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2ChainData(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ChainData}.
     *
     * @param alloc Custom memory manager
     * @return b2ChainData
     */
    public static b2ChainData alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2ChainData(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2ChainData}.
     *
     * @return b2ChainData
     */
    public static b2ChainData calloc() {
        return new b2ChainData(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2ChainData}.
     *
     * @param arean arena
     * @return b2ChainData
     */
    public static b2ChainData calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2ChainData(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ChainData}.
     *
     * @return b2ChainData
     */
    public static b2ChainData malloc() {
        return new b2ChainData(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ChainData}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ChainData}.
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
     * Reserve an amount n of memory for the object {@code b2ChainData}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ChainData}.
     *
     * @param capacity Number of elements
     * @param arena Arean
     * @return Buffer
     */
    public static Buffer calloc(int capacity, ArenaAlloc arena) {
        long ptr = arena.ncalloc(ALIGNOF, capacity, SIZEOF);
        return new Buffer(ptr, capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ChainData}.
     *
     * @param address Buffer address
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : new Buffer(address, capacity);
    }

    // -----------------------------------

    public static long npoints(long address) { return memGetAddress(address + POINTS); }
    public static int ncount(long address) { return memGetInt(address + COUNT); }

    public static void npoints(long address, long value) { memPutAddress(address + POINTS, value); }
    public static void ncount(long address, int value) { memPutInt(address + COUNT, value); }

    // -----------------------------------

    /** An array of {@code b2ChainData} structs. */
    public static class Buffer extends StructBuffer<b2ChainData, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2ChainData ELEMENT_FACTORY = b2ChainData.factory();

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
        protected b2ChainData getElementFactory() {
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
