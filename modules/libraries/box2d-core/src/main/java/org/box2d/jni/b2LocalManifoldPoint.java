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
import org.box2d.jni.readonly.ConstB2LocalManifoldPoint;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2LocalManifoldPoint
 * {
 *     /// Contact point in frame A
 *     b2Vec2 point;
 *
 *     /// The separation of the contact point, negative if penetrating. May be positive or negative.
 *     float separation;
 *
 *     /// Uniquely identifies a contact point between two shapes
 *     uint16_t id;
 * } b2LocalManifoldPoint;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2LocalManifoldPoint extends Struct<b2LocalManifoldPoint> implements ConstB2LocalManifoldPoint {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            POINT,
            SEPARATION,
            ID;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4),
                __member(2)
        );

        POINT = layout.offsetof(0);
        SEPARATION = layout.offsetof(1);
        ID = layout.offsetof(2);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2LocalManifoldPoint(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2LocalManifoldPoint(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2LocalManifoldPoint(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code point} */
    @Override
    public b2Vec2 point() { return npoint(address()); }
    /** @return Returns the property {@code separation} */
    @Override
    public float separation() { return nseparation(address()); }
    /** @return Returns the property {@code id} */
    @Override
    public short id() { return nid(address()); }

    /**
     * Set the value of property {@code point}
     *
     * @param value b2Vec2
     * @return b2LocalManifoldPoint
     */
    public b2LocalManifoldPoint point(b2Vec2 value) {
        npoint(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code separation}
     *
     * @param value float
     * @return b2LocalManifoldPoint
     */
    public b2LocalManifoldPoint separation(float value) {
        nseparation(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code id}
     *
     * @param value short
     * @return b2LocalManifoldPoint
     */
    public b2LocalManifoldPoint id(short value) {
        nid(address(), value);
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
    protected b2LocalManifoldPoint create(long address, Pointer ptr) {
        return ptr == null ? new b2LocalManifoldPoint(address) : new b2LocalManifoldPoint(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2LocalManifoldPoint
     */
    private static b2LocalManifoldPoint factory() {
        return new b2LocalManifoldPoint(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2LocalManifoldPoint
     */
    public static b2LocalManifoldPoint createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2LocalManifoldPoint(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2LocalManifoldPoint}.
     *
     * @param alloc Custom memory manager
     * @return b2LocalManifoldPoint
     */
    public static b2LocalManifoldPoint alloc(AllocFunc alloc) {
        return new b2LocalManifoldPoint(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2LocalManifoldPoint}.
     *
     * @return b2LocalManifoldPoint
     */
    public static b2LocalManifoldPoint malloc() {
        return new b2LocalManifoldPoint(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2LocalManifoldPoint}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2LocalManifoldPoint}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }
    
    /**
     * Reserve an amount n of memory for the object {@code b2LocalManifoldPoint}.
     *
     * @param address Buffer address
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : new Buffer(address, capacity);
    }

    // -----------------------------------

    public static b2Vec2 npoint(long address) { return b2Vec2.createSafe(() -> address + POINT); }
    public static float nseparation(long address) { return memGetFloat(address + SEPARATION); }
    public static short nid(long address) { return memGetShort(address + ID); }

    public static void npoint(long address, b2Vec2 value) { nmemcpy(address + POINT, value.address(), b2Vec2.SIZEOF); }
    public static void nseparation(long address, float value) { memPutFloat(address + SEPARATION, value); }
    public static void nid(long address, short value) { memPutShort(address + ID, value); }

    // -----------------------------------

    /** An array of {@code b2LocalManifoldPoint} structs. */
    public static class Buffer extends StructBuffer<b2LocalManifoldPoint, Buffer> implements ConstB2LocalManifoldPoint.ConstBuffer<b2LocalManifoldPoint, Buffer>, JNINative {

        /** An element that provides information about the structure. */
        private static final b2LocalManifoldPoint ELEMENT_FACTORY = b2LocalManifoldPoint.factory();

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
        protected b2LocalManifoldPoint getElementFactory() {
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
