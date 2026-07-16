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
 * typedef struct b2Simplex
 * {
 *     b2SimplexVertex v1, v2, v3; /// vertices
 *     int count;                  /// number of valid vertices
 * } b2Simplex;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Simplex extends Struct<b2Simplex> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            V1,
            V2,
            V3,
            COUNT;

    static {
        Layout layout = __struct(
                __member(b2SimplexVertex.SIZEOF, b2SimplexVertex.ALIGNOF),
                __member(b2SimplexVertex.SIZEOF, b2SimplexVertex.ALIGNOF),
                __member(b2SimplexVertex.SIZEOF, b2SimplexVertex.ALIGNOF),
                __member(4)
        );

        V1 = layout.offsetof(0);
        V2 = layout.offsetof(1);
        V3 = layout.offsetof(2);
        COUNT = layout.offsetof(3);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Simplex(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Simplex(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2Simplex(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code v1} */
    public b2SimplexVertex v1() { return nv1(address()); }
    /** @return Returns the property {@code v2} */
    public b2SimplexVertex v2() { return nv2(address()); }
    /** @return Returns the property {@code v3} */
    public b2SimplexVertex v3() { return nv3(address()); }
    /** @return Returns the property {@code count} */
    public int count() { return ncount(address()); }
    
    /**
     * Set the value of property {@code v1}
     *
     * @param value b2SimplexVertex
     * @return b2Simplex
     */
    public b2Simplex v1(b2SimplexVertex value) {
        nv1(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code v2}
     *
     * @param value b2SimplexVertex
     * @return b2Simplex
     */
    public b2Simplex v2(b2SimplexVertex value) {
        nv2(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code v3}
     *
     * @param value b2SimplexVertex
     * @return b2Simplex
     */
    public b2Simplex v3(b2SimplexVertex value) {
        nv3(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code count}
     *
     * @param value int
     * @return b2Simplex
     */
    public b2Simplex count(int value) {
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
    protected b2Simplex create(long address, Pointer ptr) {
        return ptr == null ? new b2Simplex(address) : new b2Simplex(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2Simplex
     */
    private static b2Simplex factory() {
        return new b2Simplex(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Simplex
     */
    public static b2Simplex createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Simplex(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Simplex}.
     *
     * @param alloc Custom memory manager
     * @return b2Simplex
     */
    public static b2Simplex alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2Simplex(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2Simplex}.
     *
     * @return b2Simplex
     */
    public static b2Simplex calloc() {
        return new b2Simplex(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2Simplex}.
     *
     * @param arean arena
     * @return b2Simplex
     */
    public static b2Simplex calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2Simplex(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Simplex}.
     *
     * @return b2Simplex
     */
    public static b2Simplex malloc() {
        return new b2Simplex(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Simplex}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Simplex}.
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
     * Reserve an amount n of memory for the object {@code b2Simplex}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Simplex}.
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
    
    public static b2SimplexVertex nv1(long address) { return b2SimplexVertex.createSafe(() -> address + V1); }
    public static b2SimplexVertex nv2(long address) { return b2SimplexVertex.createSafe(() -> address + V2); }
    public static b2SimplexVertex nv3(long address) { return b2SimplexVertex.createSafe(() -> address + V3); }
    public static int ncount(long address) { return memGetInt(address + COUNT); }

    public static void nv1(long address, b2SimplexVertex value) { nmemcpy(address + V1, value.address(), b2SimplexVertex.SIZEOF); }
    public static void nv2(long address, b2SimplexVertex value) { nmemcpy(address + V2, value.address(), b2SimplexVertex.SIZEOF); }
    public static void nv3(long address, b2SimplexVertex value) { nmemcpy(address + V3, value.address(), b2SimplexVertex.SIZEOF); }
    public static void ncount(long address, int value) { memPutInt(address + COUNT, value); }
    
    // -----------------------------------

    /** An array of {@code b2Simplex} structs. */
    public static class Buffer extends StructBuffer<b2Simplex, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2Simplex ELEMENT_FACTORY = b2Simplex.factory();

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
        protected b2Simplex getElementFactory() {
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
