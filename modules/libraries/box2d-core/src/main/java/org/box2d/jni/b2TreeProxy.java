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
import org.box2d.jni.readonly.ConstB2TreeProxy;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2TreeProxy
 * {
 *     uint64_t userData;
 *     uint64_t categoryBits;
 *     int32_t node;
 *     int32_t next;
 * } b2TreeProxy;
 * </code></pre>
 *
 * @author wil
 * @version 1.0.0
 * @since 2.0.0
 */
public class b2TreeProxy extends Struct<b2TreeProxy> implements ConstB2TreeProxy {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            USER_DATA,
            CATEGORY_BITS,
            NODE,
            NEXT;

    static {
        Layout layout = __struct(
                __member(8),
                __member(8),
                __member(4),
                __member(4)
        );

        USER_DATA = layout.offsetof(0);
        CATEGORY_BITS = layout.offsetof(1);
        NODE = layout.offsetof(2);
        NEXT = layout.offsetof(3);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2TreeProxy(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2TreeProxy(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2TreeProxy(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code userData} */
    @Override
    public long userData() { return nuserData(address()); }

    /** @return Returns the property {@code categoryBits} */
    @Override
    public long categoryBits() { return ncategoryBits(address()); }

    /** @return Returns the property {@code node} */
    @Override
    public int node() { return nnode(address()); }

    /** @return Returns the property {@code next} */
    @Override
    public int next() { return nnext(address()); }

    /**
     * Set the value of property {@code userData}
     *
     * @param value long
     * @return b2TreeProxy
     */
    public b2TreeProxy userData(long value) {
        nuserData(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code categoryBits}
     *
     * @param value long
     * @return b2TreeProxy
     */
    public b2TreeProxy categoryBits(long value) {
        ncategoryBits(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code node}
     *
     * @param value int
     * @return b2TreeProxy
     */
    public b2TreeProxy node(int value) {
        nnode(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code next}
     *
     * @param value int
     * @return b2TreeProxy
     */
    public b2TreeProxy next(int value) {
        nnext(address(), value);
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
    protected b2TreeProxy create(long address, Pointer ptr) {
        return ptr == null ? new b2TreeProxy(address) : new b2TreeProxy(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2TreeProxy
     */
    private static b2TreeProxy factory() {
        return new b2TreeProxy(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2TreeProxy
     */
    public static b2TreeProxy createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2TreeProxy(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2TreeProxy}.
     *
     * @param alloc Custom memory manager
     * @return b2TreeProxy
     */
    public static b2TreeProxy alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2TreeProxy(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2TreeProxy}.
     *
     * @return b2TreeProxy
     */
    public static b2TreeProxy calloc() {
        return new b2TreeProxy(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2TreeProxy}.
     *
     * @param arean arena
     * @return b2TreeProxy
     */
    public static b2TreeProxy calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2TreeProxy(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2TreeProxy}.
     *
     * @return b2TreeProxy
     */
    public static b2TreeProxy malloc() {
        return new b2TreeProxy(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2TreeProxy}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2TreeProxy}.
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
     * Reserve an amount n of memory for the object {@code b2TreeProxy}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2TreeProxy}.
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

    public static long nuserData(long address)     { return memGetLong(address + USER_DATA);     }
    public static long ncategoryBits(long address) { return memGetLong(address + CATEGORY_BITS); }
    public static int nnode(long address) { return memGetInt(address + NODE); }
    public static int nnext(long address) { return memGetInt(address + NEXT); }

    public static void nuserData(long address, long value)     { memPutLong(address + USER_DATA, value);     }
    public static void ncategoryBits(long address, long value) { memPutLong(address + CATEGORY_BITS, value); }
    public static void nnode(long address, int value) { memPutInt(address + NODE, value); }
    public static void nnext(long address, int value) { memPutInt(address + NEXT, value); }
    // -----------------------------------

    /** An array of {@code b2TreeProxy} structs. */
    public static class Buffer extends StructBuffer<b2TreeProxy, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2TreeProxy ELEMENT_FACTORY = b2TreeProxy.factory();

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
        protected b2TreeProxy getElementFactory() {
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
