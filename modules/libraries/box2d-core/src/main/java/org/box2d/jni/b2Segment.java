/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2Segment;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;

/**
 * <pre><code>
 * typedef struct b2Segment
 * {
 *     b2Vec2 point1;
 *     b2Vec2 point2;
 * } b2Segment;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Segment extends Struct<b2Segment> implements ConstB2Segment {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            POINT1,
            POINT2;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF)
        );

        POINT1 = layout.offsetof(0);
        POINT2 = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Segment(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Segment(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2Segment(long address, boolean factor) {
        super(address, factor);
    }

    /**
     * Initializes this struct with the specified values.
     * 
     * @param point1 point1
     * @param point2 point2
     *
     * @return b2AABB
     */
    public b2Segment set(
        b2Vec2 point1,
        b2Vec2 point2
    ) {
        point1(point1);
        point2(point2);
        return this;
    }

    /** @return Returns the property {@code point1} */
    @Override
    public b2Vec2 point1() { return npoint1(address()); }
    /** @return Returns the property {@code point2} */
    @Override
    public b2Vec2 point2() { return npoint2(address()); }

    /**
     * Set the value of property {@code point1}
     * 
     * @param value b2Vec2
     * @return b2Segment
     */
    public b2Segment point1(b2Vec2 value) {
        npoint1(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code point2}
     * 
     * @param value b2Vec2
     * @return b2Segment
     */
    public b2Segment point2(b2Vec2 value) {
        npoint2(address(), value);
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
    protected b2Segment create(long address, Pointer ptr) {
        return ptr == null ? new b2Segment(address) : new b2Segment(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2Segment
     */
    private static b2Segment factory() {
        return new b2Segment(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Segment
     */
    public static b2Segment createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Segment(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Segment}.
     *
     * @param alloc Custom memory manager
     * @return b2Segment
     */
    public static b2Segment alloc(AllocFunc alloc) {
        return new b2Segment(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2Segment}.
     *
     * @return b2Segment
     */
    public static b2Segment malloc() {
        return new b2Segment(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Segment}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Segment}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static b2Vec2 npoint1(long address) { return b2Vec2.createSafe(() -> address + POINT1); }
    public static b2Vec2 npoint2(long address) { return b2Vec2.createSafe(() -> address + POINT2); }

    public static void npoint1(long address, b2Vec2 value) { nmemcpy(address + POINT1, value.address(), b2Vec2.SIZEOF); }
    public static void npoint2(long address, b2Vec2 value) { nmemcpy(address + POINT2, value.address(), b2Vec2.SIZEOF); }

    // -----------------------------------

    /** An array of {@code b2Segment} structs. */
    public static class Buffer extends StructBuffer<b2Segment, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2Segment ELEMENT_FACTORY = b2Segment.factory();

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
        protected b2Segment getElementFactory() {
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
