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
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2Manifold
 * {
 *     b2Vec2 normal;
 *     float rollingImpulse;
 *     b2ManifoldPoint points[2];
 *     int pointCount;
 * } b2Manifold;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Manifold extends Struct<b2Manifold> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            NORMAL,
            ROLLING_IMPULSE,
            POINTS,
            POINT_COUNT;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4),
                __array(b2ManifoldPoint.SIZEOF, b2ManifoldPoint.ALIGNOF, 2),
                __member(4)
        );

        NORMAL = layout.offsetof(0);
        ROLLING_IMPULSE = layout.offsetof(1);
        POINTS = layout.offsetof(2);
        POINT_COUNT = layout.offsetof(3);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Manifold(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Manifold(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2Manifold(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code normal} */
    public b2Vec2 normal() { return nnormal(address()); }
    /** @return Returns the property {@code rollingImpulse} */
    public float rollingImpulse() { return nrollingImpulse(address()); }
    /** @return Returns the property {@code points} */
    public b2ManifoldPoint.Buffer points() { return npoints(address()); }
    /** @return Returns the property {@code pointCount} */
    public int pointCount() { return npointCount(address()); }

    /**
     * Set the value of property {@code normal}
     *
     * @param value b2Vec2
     * @return b2Manifold
     */
    public b2Manifold normal(b2Vec2 value) {
        nnormal(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code rollingImpulse}
     *
     * @param value float
     * @return b2Manifold
     */
    public b2Manifold rollingImpulse(float value) {
        nrollingImpulse(address(), value);
        return this;
    }
    
    /**
     * Set the value of property {@code pointCount}
     *
     * @param value int
     * @return b2Manifold
     */
    public b2Manifold points(b2ManifoldPoint.Buffer value) {
        npoints(address(), value);
        return this;
    }


    /**
     * Set the value of property {@code pointCount}
     *
     * @param value int
     * @return b2Manifold
     */
    public b2Manifold pointCount(int value) {
        npointCount(address(), value);
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
    protected b2Manifold create(long address, Pointer ptr) {
        return ptr == null ? new b2Manifold(address) : new b2Manifold(ptr);
    }
    
    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2Manifold
     */
    private static b2Manifold factory() {
        return new b2Manifold(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Manifold
     */
    public static b2Manifold createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Manifold(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Manifold}.
     *
     * @param alloc Custom memory manager
     * @return b2Manifold
     */
    public static b2Manifold alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2Manifold(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2Manifold}.
     *
     * @param arean arena
     * @return b2Manifold
     */
    public static b2Manifold calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2Manifold(() -> ptr);
    }


    /**
     * Reserve memory for the new object {@code b2Manifold}.
     *
     * @return b2Manifold
     */
    public static b2Manifold malloc() {
        return new b2Manifold(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Manifold}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Manifold}.
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
     * Reserve an amount n of memory for the object {@code b2Manifold}.
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
    
    public static b2Vec2 nnormal(long address) { return b2Vec2.createSafe(() -> address + NORMAL); }
    public static float nrollingImpulse(long address) { return memGetFloat(address + ROLLING_IMPULSE); }
    public static b2ManifoldPoint.Buffer npoints(long address) { return b2ManifoldPoint.createSafe(address + POINTS, 2); }
    public static int npointCount(long address) { return memGetInt(address + POINT_COUNT); }

    public static void nnormal(long address, b2Vec2 value) { nmemcpy(address + NORMAL, value.address(), b2Vec2.SIZEOF); }
    public static void nrollingImpulse(long address, float value) { memPutFloat(address + ROLLING_IMPULSE, value); }
    public static void npoints(long address, b2ManifoldPoint.Buffer value) { nmemcpy(address + POINTS, value.address(), b2ManifoldPoint.SIZEOF * 2 ); }
    public static void npointCount(long address, int value) { memPutInt(address + POINT_COUNT, value); }
    
    // -----------------------------------

    /** An array of {@code b2Manifold} structs. */
    public static class Buffer extends StructBuffer<b2Manifold, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2Manifold ELEMENT_FACTORY = b2Manifold.factory();

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
        protected b2Manifold getElementFactory() {
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
