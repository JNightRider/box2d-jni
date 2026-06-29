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

import org.box2d.jni.readonly.ConstB2Capacity;
import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2Capacity
 * {
 *     int staticShapeCount;
 *     int dynamicShapeCount;
 *     int staticBodyCount;
 *     int dynamicBodyCount;
 *     int contactCount;
 * } b2Capacity;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Capacity extends Struct<b2Capacity> implements ConstB2Capacity {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            STATIC_SHAPE_COUNT,
            DYNAMIC_SHAPE_COUNT,
            STATIC_BODY_COUNT,
            DYNAMIC_BODY_COUNT,
            CONTACT_COUNT;

    static {
        Layout layout = __struct(
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4)
        );

        STATIC_SHAPE_COUNT = layout.offsetof(0);
        DYNAMIC_SHAPE_COUNT = layout.offsetof(1);
        STATIC_BODY_COUNT = layout.offsetof(2);
        DYNAMIC_BODY_COUNT = layout.offsetof(3);
        CONTACT_COUNT = layout.offsetof(4);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Capacity(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Capacity(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2Capacity(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code staticShapeCount} */
    @Override
    public int staticShapeCount() { return nstaticShapeCount(address()); }
    /** @return Returns the property {@code dynamicShapeCount} */
    @Override
    public int dynamicShapeCount() { return ndynamicShapeCount(address()); }
    /** @return Returns the property {@code staticBodyCount} */
    @Override
    public int staticBodyCount() { return nstaticBodyCount(address()); }
    /** @return Returns the property {@code dynamicBodyCount} */
    @Override
    public int dynamicBodyCount() { return ndynamicBodyCount(address()); }
    /** @return Returns the property {@code contactCount} */
    @Override
    public int contactCount() { return ncontactCount(address()); }

    /**
     * Set the value of property {@code staticShapeCount}
     *
     * @param value The value
     * @return b2Capacity
     */
    public b2Capacity staticShapeCount(int value) {
        nstaticShapeCount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code dynamicShapeCount}
     *
     * @param value The value
     * @return b2Capacity
     */
    public b2Capacity dynamicShapeCount(int value) {
        ndynamicShapeCount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code staticBodyCount}
     *
     * @param value The value
     * @return b2Capacity
     */
    public b2Capacity staticBodyCount(int value) {
        nstaticBodyCount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code dynamicBodyCount}
     *
     * @param value The value
     * @return b2Capacity
     */
    public b2Capacity dynamicBodyCount(int value) {
        ndynamicBodyCount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code contactCount}
     *
     * @param value The value
     * @return b2Capacity
     */
    public b2Capacity contactCount(int value) {
        ncontactCount(address(), value);
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
    protected b2Capacity create(long address, Pointer ptr) {
        return ptr == null ? new b2Capacity(address) : new b2Capacity(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2Capacity
     */
    private static b2Capacity factory() {
        return new b2Capacity(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Capacity
     */
    public static b2Capacity createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Capacity(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Capacity}.
     *
     * @param alloc Custom memory manager
     * @return b2Capacity
     */
    public static b2Capacity alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2Capacity(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2Capacity}.
     *
     * @param alloc arena
     * @return b2Capacity
     */
    public static b2Capacity malloc(ArenaAlloc alloc) {
        long ptr = alloc.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2Capacity(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Capacity}.
     *
     * @return b2Capacity
     */
    public static b2Capacity malloc() {
        return new b2Capacity(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Capacity}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Capacity}.
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
     * Reserve an amount n of memory for the object {@code b2Capacity}.
     *
     * @param capacity Number of elements
     * @param alloc Arean
     * @return Buffer
     */
    public static Buffer malloc(int capacity, ArenaAlloc alloc) {
        long ptr = alloc.ncalloc(ALIGNOF, 1, SIZEOF);
        return new Buffer(ptr, capacity);
    }

    // -----------------------------------

    public static int nstaticShapeCount(long address) { return memGetInt(address + STATIC_SHAPE_COUNT); }
    public static int ndynamicShapeCount(long address) { return memGetInt(address + DYNAMIC_SHAPE_COUNT); }
    public static int nstaticBodyCount(long address) { return memGetInt(address + STATIC_BODY_COUNT); }
    public static int ndynamicBodyCount(long address) { return memGetInt(address + DYNAMIC_BODY_COUNT); }
    public static int ncontactCount(long address) { return memGetInt(address + CONTACT_COUNT); }

    public static void nstaticShapeCount(long address, int value) { memPutInt(address + STATIC_SHAPE_COUNT, value); }
    public static void ndynamicShapeCount(long address, int value) { memPutInt(address + DYNAMIC_SHAPE_COUNT, value); }
    public static void nstaticBodyCount(long address, int value) { memPutInt(address + STATIC_BODY_COUNT, value); }
    public static void ndynamicBodyCount(long address, int value) { memPutInt(address + DYNAMIC_BODY_COUNT, value); }
    public static void ncontactCount(long address, int value) { memPutInt(address + CONTACT_COUNT, value); }

    // -----------------------------------

    /** An array of {@code b2Capacity} structs. */
    public static class Buffer extends StructBuffer<b2Capacity, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2Capacity ELEMENT_FACTORY = b2Capacity.factory();

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
        protected b2Capacity getElementFactory() {
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
