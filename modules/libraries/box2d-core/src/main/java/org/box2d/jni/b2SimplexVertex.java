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
import org.box2d.jni.readonly.ConstB2SimplexVertex;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2SimplexVertex
 * {
 *     b2Vec2 wA;    /// support point in proxyA
 *     b2Vec2 wB;    /// support point in proxyB
 *     b2Vec2 w;     /// wB - wA
 *     float a;      /// barycentric coordinate for closest point
 *     int indexA;   /// wA index
 *     int indexB;   /// wB index
 * } b2SimplexVertex;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2SimplexVertex extends Struct<b2SimplexVertex> implements ConstB2SimplexVertex {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            W_A,
            W_B,
            W,
            A,
            INDEX_A,
            INDEX_B;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4),
                __member(4),
                __member(4)
        );

        W_A = layout.offsetof(0);
        W_B = layout.offsetof(1);
        W = layout.offsetof(2);
        A = layout.offsetof(3);
        INDEX_A = layout.offsetof(4);
        INDEX_B = layout.offsetof(5);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2SimplexVertex(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2SimplexVertex(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2SimplexVertex(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code wA} */
    @Override
    public b2Vec2 wA() { return nwA(address()); }
    /** @return Returns the property {@code wB} */
    @Override
    public b2Vec2 wB() { return nwB(address()); }
    /** @return Returns the property {@code w} */
    @Override
    public b2Vec2 w() { return nw(address()); }
    /** @return Returns the property {@code a} */
    @Override
    public float a() { return na(address()); }
    /** @return Returns the property {@code indexA} */
    @Override
    public int indexA() { return nindexA(address()); }
    /** @return Returns the property {@code indexB} */
    @Override
    public int indexB() { return nindexB(address()); }

    /**
     * Set the value of property {@code wA}
     *
     * @param value b2Vec2
     * @return b2SimplexVertex
     */
    public b2SimplexVertex wA(b2Vec2 value) {
        nwA(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code wB}
     *
     * @param value b2Vec2
     * @return b2SimplexVertex
     */
    public b2SimplexVertex wB(b2Vec2 value) {
        nwB(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code w}
     *
     * @param value b2Vec2
     * @return b2SimplexVertex
     */
    public b2SimplexVertex w(b2Vec2 value) {
        nw(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code a}
     *
     * @param value float
     * @return b2SimplexVertex
     */
    public b2SimplexVertex a(float value) {
        na(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code indexA}
     *
     * @param value int
     * @return b2SimplexVertex
     */
    public b2SimplexVertex indexA(int value) {
        nindexA(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code indexB}
     *
     * @param value int
     * @return b2SimplexVertex
     */
    public b2SimplexVertex indexB(int value) {
        nindexB(address(), value);
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
    protected b2SimplexVertex create(long address, Pointer ptr) {
        return ptr == null ? new b2SimplexVertex(address) : new b2SimplexVertex(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2SimplexVertex
     */
    private static b2SimplexVertex factory() {
        return new b2SimplexVertex(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2SimplexVertex
     */
    public static b2SimplexVertex createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2SimplexVertex(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2SimplexVertex}.
     *
     * @param alloc Custom memory manager
     * @return b2SimplexVertex
     */
    public static b2SimplexVertex alloc(AllocFunc alloc) {
        return new b2SimplexVertex(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2SimplexVertex}.
     *
     * @return b2SimplexVertex
     */
    public static b2SimplexVertex malloc() {
        return new b2SimplexVertex(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2SimplexVertex}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2SimplexVertex}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------
    
    public static b2Vec2 nwA(long address) { return b2Vec2.createSafe(() -> address + W_A); }
    public static b2Vec2 nwB(long address) { return b2Vec2.createSafe(() -> address + W_B); }
    public static b2Vec2 nw(long address) { return b2Vec2.createSafe(() -> address + W); }
    public static float na(long address) { return memGetFloat(address + A); }
    public static int nindexA(long address) { return memGetInt(address + INDEX_A); }
    public static int nindexB(long address) { return memGetInt(address + INDEX_B); }

    public static void nwA(long address, b2Vec2 value) { nmemcpy(address + W_A, value.address(), b2Vec2.SIZEOF); }
    public static void nwB(long address, b2Vec2 value) { nmemcpy(address + W_B, value.address(), b2Vec2.SIZEOF); }
    public static void nw(long address, b2Vec2 value) { nmemcpy(address + W, value.address(), b2Vec2.SIZEOF); }
    public static void na(long address, float value) { memPutFloat(address + A, value); }
    public static void nindexA(long address, int value) { memPutInt(address + INDEX_A, value); }
    public static void nindexB(long address, int value) { memPutInt(address + INDEX_B, value); }
    
    // -----------------------------------

    /** An array of {@code b2SimplexVertex} structs. */
    public static class Buffer extends StructBuffer<b2SimplexVertex, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2SimplexVertex ELEMENT_FACTORY = b2SimplexVertex.factory();

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
        protected b2SimplexVertex getElementFactory() {
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
