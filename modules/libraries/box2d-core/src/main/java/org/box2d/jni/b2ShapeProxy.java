/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2ShapeProxy;

import static org.box2d.jni.include.Collision.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2ShapeProxy
 * {
 *     b2Vec2 points[B2_MAX_POLYGON_VERTICES];
 *     int count;
 *     float radius;
 * } b2ShapeProxy;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2ShapeProxy extends Struct<b2ShapeProxy> implements ConstB2ShapeProxy {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            POINTS,
            COUNT,
            RADIUS;

    static {
        Layout layout = __struct(
                __array(b2Vec2.SIZEOF, b2Vec2.ALIGNOF, B2_MAX_POLYGON_VERTICES),
                __member(4),
                __member(4)
        );

        POINTS = layout.offsetof(0);
        COUNT = layout.offsetof(1);
        RADIUS = layout.offsetof(2);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2ShapeProxy(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2ShapeProxy(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2ShapeProxy(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code points} */
    @Override
    public b2Vec2.Buffer points() { return npoints(address()); }
    /** @return Returns the property {@code count} */
    @Override
    public int count() { return ncount(address()); }
    /** @return Returns the property {@code radius} */
    @Override
    public float radius() { return nradius(address()); }

    /**
     * Set the value of property {@code points}
     * 
     * @param value b2Vec2.Buffer
     * @return b2ShapeProxy
     */
    public b2ShapeProxy points(b2Vec2.Buffer value) {
        npoints(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code count}
     * 
     * @param value int
     * @return b2ShapeProxy
     */
    public b2ShapeProxy count(int value) {
        ncount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code radius}
     * 
     * @param value float
     * @return b2ShapeProxy
     */
    public b2ShapeProxy radius(float value) {
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
    protected b2ShapeProxy create(long address, Pointer ptr) {
        return ptr == null ? new b2ShapeProxy(address) : new b2ShapeProxy(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2ShapeProxy
     */
    private static b2ShapeProxy factory() {
        return new b2ShapeProxy(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2ShapeProxy
     */
    public static b2ShapeProxy createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2ShapeProxy(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ShapeProxy}.
     *
     * @param alloc Custom memory manager
     * @return b2ShapeProxy
     */
    public static b2ShapeProxy alloc(AllocFunc alloc) {
        return new b2ShapeProxy(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2ShapeProxy}.
     *
     * @return b2ShapeProxy
     */
    public static b2ShapeProxy malloc() {
        return new b2ShapeProxy(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ShapeProxy}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ShapeProxy}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static b2Vec2.Buffer npoints(long address) { return b2Vec2.createSafe(address + POINTS, B2_MAX_POLYGON_VERTICES); }
    public static int ncount(long address) { return memGetInt(address + COUNT); }
    public static float nradius(long address) { return memGetFloat(address + RADIUS); }

    public static void npoints(long address, b2Vec2.Buffer value) { nmemcpy(address + POINTS, value.address(), b2Vec2.SIZEOF * B2_MAX_POLYGON_VERTICES ); }
    public static void ncount(long address, int value) { memPutInt(address + COUNT, value); }
    public static void nradius(long address, float value) { memPutFloat(address + RADIUS, value); }

    // -----------------------------------

    /** An array of {@code b2ShapeProxy} structs. */
    public static class Buffer extends StructBuffer<b2ShapeProxy, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2ShapeProxy ELEMENT_FACTORY = b2ShapeProxy.factory();

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
        protected b2ShapeProxy getElementFactory() {
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
