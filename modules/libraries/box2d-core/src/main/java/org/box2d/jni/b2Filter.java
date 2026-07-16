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
import org.box2d.jni.readonly.ConstB2Filter;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2Filter
 * {
 * 	uint64_t categoryBits;
 * 	uint64_t maskBits;
 * 	int groupIndex;
 * } b2Filter;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Filter extends Struct<b2Filter> implements ConstB2Filter {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            CATEGORY_BITS,
            MASK_BITS,
            GROUP_INDEX;

    static {

        Layout layout = __struct(
                __member(VarType.Int64t.sizeof()),
                __member(VarType.Int64t.sizeof()),
                __member(4)
        );

        CATEGORY_BITS = layout.offsetof(0);
        MASK_BITS = layout.offsetof(1);
        GROUP_INDEX = layout.offsetof(2);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Filter(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Filter(long address) {
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
    protected b2Filter(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code categoryBits} */
    @Override
    public long categoryBits() { return ncategoryBits(address()); }
    /** @return Returns the property {@code maskBits} */
    @Override
    public long maskBits() { return nmaskBits(address()); }
    /** @return Returns the property {@code groupIndex} */
    @Override
    public int groupIndex() { return ngroupIndex(address()); }

    /**
     * Set the value of property {@code categoryBits}
     *
     * @param value The value
     * @return b2Filter
     */
    public b2Filter categoryBits(long value) {
        ncategoryBits(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code maskBits}
     *
     * @param value The value
     * @return b2Filter
     */
    public b2Filter maskBits(long value) {
        nmaskBits(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code groupIndex}
     *
     * @param value The value
     * @return b2Filter
     */
    public b2Filter groupIndex(int value) {
        ngroupIndex(address(), value);
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
    protected b2Filter create(long address, Pointer ptr) {
        return ptr == null ? new b2Filter(address) : new b2Filter(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2Filter
     */
    private static b2Filter factory() {
        return new b2Filter(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Filter
     */
    public static b2Filter createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Filter(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Filter}.
     *
     * @param alloc Custom memory manager
     * @return b2Filter
     */
    public static b2Filter alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2Filter(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2Filter}.
     *
     * @return b2Filter
     */
    public static b2Filter calloc() {
        return new b2Filter(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2Filter}.
     *
     * @param arean arena
     * @return b2Filter
     */
    public static b2Filter calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2Filter(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Filter}.
     *
     * @return b2Filter
     */
    public static b2Filter malloc() {
        return new b2Filter(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Filter}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Filter}.
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
     * Reserve an amount n of memory for the object {@code b2Filter}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Filter}.
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

    public static long ncategoryBits(long address) { return memGetLong(address + CATEGORY_BITS); }
    public static long nmaskBits(long address) { return memGetLong(address + MASK_BITS); }
    public static int ngroupIndex(long address) { return memGetInt(address + GROUP_INDEX); }

    public static void ncategoryBits(long address, long value) { memPutLong(address + CATEGORY_BITS, value); }
    public static void nmaskBits(long address, long value) { memPutLong(address + MASK_BITS, value); }
    public static void ngroupIndex(long address, int value) { memPutInt(address + GROUP_INDEX, value); }

    // -----------------------------------

    /** An array of {@code b2Filter} structs. */
    public static class Buffer extends StructBuffer<b2Filter, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2Filter ELEMENT_FACTORY = b2Filter.factory();

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

        /*(non-Jabadoc)
         */
        @Override
        protected b2Filter getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /*(non-Jabadoc)
         */
        @Override
        protected Buffer self() {
            return this;
        }

        /*(non-Jabadoc)
         */
        @Override
        protected Buffer create(long address, int mark, int position, int limit, int capacity) {
            return new Buffer(address, mark, position, limit, capacity);
        }
    }
}
