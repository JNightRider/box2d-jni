/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2Circle;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2Circle
 * {
 *     b2Vec2 center;
 *     float radius;
 * } b2Circle;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Circle extends Struct<b2Circle> implements ConstB2Circle {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            CENTER,
            RADIUS;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4)
        );

        CENTER = layout.offsetof(0);
        RADIUS = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Circle(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Circle(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2Circle(long address, boolean factor) {
        super(address, factor);
    }

    /**
     * Initializes this struct with the specified values.
     *
     * @param center center
     * @param radius radius
     *
     * @return b2AABB
     */
    public b2Circle set(
        b2Vec2 center,
        float radius
    ) {
        center(center);
        radius(radius);
        return this;
    }
    
    /** @return Returns the property {@code center} */
    @Override
    public b2Vec2 center() { return ncenter(address()); }
    /** @return Returns the property {@code radius} */
    @Override
    public float radius() { return nradius(address()); }

    /**
     * Set the value of property {@code center}
     * 
     * @param value b2Vec2
     * @return b2Circle
     */
    public b2Circle center(b2Vec2 value) {
        ncenter(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code radius}
     * 
     * @param value float
     * @return b2Circle
     */
    public b2Circle radius(float value) {
        nradius(address(), value);
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
    protected b2Circle create(long address, Pointer ptr) {
        return ptr == null ? new b2Circle(address) : new b2Circle(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2Circle
     */
    private static b2Circle factory() {
        return new b2Circle(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Circle
     */
    public static b2Circle createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Circle(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Circle}.
     *
     * @param alloc Custom memory manager
     * @return b2Circle
     */
    public static b2Circle alloc(AllocFunc alloc) {
        return new b2Circle(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2Circle}.
     *
     * @return b2Circle
     */
    public static b2Circle malloc() {
        return new b2Circle(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Circle}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Circle}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static b2Vec2 ncenter(long address) { return b2Vec2.createSafe(() -> address + CENTER); }
    public static float nradius(long address)  { return memGetFloat(address + RADIUS); }

    public static void ncenter(long address, b2Vec2 value) { nmemcpy(address + CENTER, value.address(), b2Vec2.SIZEOF); }
    public static void nradius(long address, float value)  { memPutFloat(address + RADIUS, value); }

    // -----------------------------------

    /** An array of {@code b2Circle} structs. */
    public static class Buffer extends StructBuffer<b2Circle, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2Circle ELEMENT_FACTORY = b2Circle.factory();

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
        protected b2Circle getElementFactory() {
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
