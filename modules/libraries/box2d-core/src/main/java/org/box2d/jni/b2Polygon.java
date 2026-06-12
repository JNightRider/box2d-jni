/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2Polygon;

import static org.box2d.jni.include.Collision.*;
import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2Polygon
 * {
 *     b2Vec2 vertices[B2_MAX_POLYGON_VERTICES];
 *     b2Vec2 normals[B2_MAX_POLYGON_VERTICES];
 *     b2Vec2 centroid;
 *     float radius;
 *     int count;
 * } b2Polygon;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Polygon extends Struct<b2Polygon> implements ConstB2Polygon {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            VERTICES,
            NORMALS,
            CENTROID,
            RADIUS,
            COUNT;

    static {
        Layout layout = __struct(
                __array(b2Vec2.SIZEOF, b2Vec2.ALIGNOF, B2_MAX_POLYGON_VERTICES),
                __array(b2Vec2.SIZEOF, b2Vec2.ALIGNOF, B2_MAX_POLYGON_VERTICES),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4),
                __member(4)
        );

        VERTICES = layout.offsetof(0);
        NORMALS = layout.offsetof(1);
        CENTROID = layout.offsetof(2);
        RADIUS = layout.offsetof(3);
        COUNT = layout.offsetof(4);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Polygon(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Polygon(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2Polygon(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code vertices} */
    @Override
    public b2Vec2.Buffer vertices() { return nvertices(address()); }
    /** @return Returns the property {@code normals} */
    @Override
    public b2Vec2.Buffer normals() { return nnormals(address()); }
    /** @return Returns the property {@code centroid} */
    @Override
    public b2Vec2 centroid() { return ncentroid(address()); }
    /** @return Returns the property {@code radius} */
    @Override
    public float radius() { return nradius(address()); }
    /** @return Returns the property {@code count} */
    @Override
    public int count() { return ncount(address()); }

    /**
     * Set the value of property {@code vertices}
     * 
     * @param value b2Vec2.Buffer
     * @return b2Polygon
     */
    public b2Polygon vertices(b2Vec2.Buffer value) {
        nvertices(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code normals}
     * 
     * @param value b2Vec2.Buffer
     * @return b2Polygon
     */
    public b2Polygon normals(b2Vec2.Buffer value) {
        nnormals(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code centroid}
     * 
     * @param value b2Vec2
     * @return b2Polygon
     */
    public b2Polygon centroid(b2Vec2 value) {
        ncentroid(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code radius}
     * 
     * @param value float
     * @return b2Polygon
     */
    public b2Polygon radius(float value) {
        nradius(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code count}
     * 
     * @param value int
     * @return b2Polygon
     */
    public b2Polygon count(int value) {
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
    protected b2Polygon create(long address, Pointer ptr) {
        return ptr == null ? new b2Polygon(address) : new b2Polygon(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2Polygon
     */
    private static b2Polygon factory() {
        return new b2Polygon(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Polygon
     */
    public static b2Polygon createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Polygon(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Polygon}.
     *
     * @param alloc Custom memory manager
     * @return b2Polygon
     */
    public static b2Polygon alloc(AllocFunc alloc) {
        return new b2Polygon(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2Polygon}.
     *
     * @return b2Polygon
     */
    public static b2Polygon malloc() {
        return new b2Polygon(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Polygon}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Polygon}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static b2Vec2.Buffer nvertices(long address) { return b2Vec2.createSafe(address + VERTICES, B2_MAX_POLYGON_VERTICES); }
    public static b2Vec2.Buffer nnormals(long address) { return b2Vec2.createSafe(address + NORMALS, B2_MAX_POLYGON_VERTICES); }
    public static b2Vec2 ncentroid(long address) { return b2Vec2.createSafe(() -> address + CENTROID); }
    public static float nradius(long address) { return memGetFloat(address + RADIUS); }
    public static int ncount(long address) { return memGetInt(address + COUNT); }

    public static void nvertices(long address, b2Vec2.Buffer value) { nmemcpy(address + VERTICES, value.address(), b2Vec2.SIZEOF * B2_MAX_POLYGON_VERTICES ); }
    public static void nnormals(long address, b2Vec2.Buffer value) { nmemcpy(address + NORMALS, value.address(), b2Vec2.SIZEOF * B2_MAX_POLYGON_VERTICES); }
    public static void ncentroid(long address, b2Vec2 value) { nmemcpy(address + CENTROID, value.address(), b2Vec2.SIZEOF); }
    public static void nradius(long address, float value) { memPutFloat(address + RADIUS, value); }
    public static void ncount(long address, int value) { memPutInt(address + COUNT, value); }

    // -----------------------------------

    /** An array of {@code b2Polygon} structs. */
    public static class Buffer extends StructBuffer<b2Polygon, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2Polygon ELEMENT_FACTORY = b2Polygon.factory();

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
        protected b2Polygon getElementFactory() {
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
