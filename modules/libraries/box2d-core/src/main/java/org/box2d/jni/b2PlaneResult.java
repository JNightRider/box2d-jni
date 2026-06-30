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
import org.box2d.jni.readonly.ConstB2PlaneResult;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2PlaneResult
 * {
 *     b2Plane plane;
 *     b2Vec2 point;
 *     bool hit;
 * } b2PlaneResult;
 * </code></pre>
 *
 * These are the collision planes returned from b2World_CollideMover
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2PlaneResult extends Struct<b2PlaneResult> implements ConstB2PlaneResult {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            PLANE,
            POINT,
            HIT;

    static {
        Layout layout = __struct(
                __member(b2Plane.SIZEOF, b2Plane.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(1)
        );

        PLANE = layout.offsetof(0);
        POINT = layout.offsetof(1);
        HIT = layout.offsetof(2);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2PlaneResult(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2PlaneResult(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2PlaneResult(long address, boolean factor) {
        super(address, factor);
    }

    // -----------------------------------

    /** @return Returns the property {@code plane} */
    @Override
    public b2Plane plane() { return nplane(address()); }
    /** @return Returns the property {@code point} */
    @Override
    public b2Vec2 point() { return npoint(address()); }
    /** @return Returns the property {@code hit} */
    @Override
    public boolean hit() { return nhit(address()); }

    // -----------------------------------

    /**
     * Set the value of property {@code plane}
     * @param value b2Plane
     * @return b2PlaneResult
     */
    public b2PlaneResult plane(b2Plane value) {
        nplane(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code point}
     * @param value b2Vec2
     * @return b2PlaneResult
     */
    public b2PlaneResult point(b2Vec2 value) {
        npoint(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code hit}
     * @param value boolean
     * @return b2PlaneResult
     */
    public b2PlaneResult hit(boolean value) {
        nhit(address(), value);
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
    protected b2PlaneResult create(long address, Pointer ptr) {
        return ptr == null ? new b2PlaneResult(address) : new b2PlaneResult(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     */
    private static b2PlaneResult factory() {
        return new b2PlaneResult(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2RayResult
     */
    public static b2PlaneResult createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2PlaneResult(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2PlaneResult}.
     *
     * @param alloc Custom memory manager
     * @return b2RayResult
     */
    public static b2PlaneResult alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2PlaneResult(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2PlaneResult}.
     *
     * @param arean arena
     * @return b2PlaneResult
     */
    public static b2PlaneResult calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2PlaneResult(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2PlaneResult}.
     *
     * @return b2RayResult
     */
    public static b2PlaneResult malloc() {
        return new b2PlaneResult(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2PlaneResult}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2PlaneResult}.
     *
     *  @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, capacity, SIZEOF);
        return new Buffer(address, capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2PlaneResult}.
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
    
    public static b2Plane nplane(long address) { return b2Plane.createSafe(() -> address + PLANE); }
    public static b2Vec2 npoint(long address) { return b2Vec2.createSafe(() -> address + POINT); }
    public static boolean nhit(long address) { return memGetByte(address + HIT) != 0; }

    public static void nplane(long address, b2Plane value) { nmemcpy(address + PLANE, value.address(), b2Plane.SIZEOF); }
    public static void npoint(long address, b2Vec2 value) { nmemcpy(address + POINT, value.address(), b2Vec2.SIZEOF); }
    public static void nhit(long address, boolean value) { memPutByte(address + HIT, (byte)(value ? 1 : 0)); }
    
    // -----------------------------------

    /** An array of {@code b2PlaneResult} structs. */
    public static class Buffer extends StructBuffer<b2PlaneResult, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2PlaneResult ELEMENT_FACTORY = b2PlaneResult.factory();

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
        protected b2PlaneResult getElementFactory() {
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
