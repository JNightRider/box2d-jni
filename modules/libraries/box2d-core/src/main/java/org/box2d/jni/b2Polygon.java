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
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2Polygon(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2Polygon}.
     *
     * @return b2Polygon
     */
    public static b2Polygon calloc() {
        return new b2Polygon(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2Polygon}.
     *
     * @param arean arena
     * @return b2Polygon
     */
    public static b2Polygon calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2Polygon(() -> ptr);
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
        long address = alloc.alloc(ALIGNOF, capacity, SIZEOF);
        return new Buffer(address, capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Polygon}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Polygon}.
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
