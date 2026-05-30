/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2QueryFilter
 * {
 * 	uint64_t categoryBits;
 * 	uint64_t maskBits;
 * } b2QueryFilter;
 * </code></pre>
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2QueryFilter extends Struct<b2QueryFilter> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            CATEGORY_BITS,
            MASK_BITS;

    static {

        Layout layout = __struct(
                __member(VarType.Int64t.sizeof()),
                __member(VarType.Int64t.sizeof())
        );

        CATEGORY_BITS = layout.offsetof(0);
        MASK_BITS = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2QueryFilter(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2QueryFilter(long address) {
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
    protected b2QueryFilter(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code categoryBits} */
    public long categoryBits() { return ncategoryBits(address()); }
    /** @return Returns the property {@code maskBits} */
    public long maskBits() { return nmaskBits(address()); }

    /**
     * Set the value of property {@code categoryBits}
     *
     * @param value The value
     * @return b2QueryFilter
     */
    public b2QueryFilter categoryBits(long value) {
        ncategoryBits(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code maskBits}
     *
     * @param value The value
     * @return b2QueryFilter
     */
    public b2QueryFilter maskBits(long value) {
        nmaskBits(address(), value);
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
    protected b2QueryFilter create(long address, Pointer ptr) {
        return ptr == null ? new b2QueryFilter(address) : new b2QueryFilter(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2QueryFilter
     */
    private static b2QueryFilter factory() {
        return new b2QueryFilter(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2QueryFilter
     */
    public static b2QueryFilter createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2QueryFilter(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2QueryFilter}.
     *
     * @param alloc Custom memory manager
     * @return b2QueryFilter
     */
    public static b2QueryFilter alloc(AllocFunc alloc) {
        return new b2QueryFilter(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2QueryFilter}.
     *
     * @return b2QueryFilter
     */
    public static b2QueryFilter malloc() {
        return new b2QueryFilter(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2QueryFilter}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2QueryFilter}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static long ncategoryBits(long address) { return memGetLong(address + CATEGORY_BITS); }
    public static long nmaskBits(long address) { return memGetLong(address + MASK_BITS); }

    public static void ncategoryBits(long address, long value) { memPutLong(address + CATEGORY_BITS, value); }
    public static void nmaskBits(long address, long value) { memPutLong(address + MASK_BITS, value); }

    // -----------------------------------

    /** An array of {@code b2QueryFilter} structs. */
    public static class Buffer extends StructBuffer<b2QueryFilter, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2QueryFilter ELEMENT_FACTORY = b2QueryFilter.factory();

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
        protected b2QueryFilter getElementFactory() {
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
