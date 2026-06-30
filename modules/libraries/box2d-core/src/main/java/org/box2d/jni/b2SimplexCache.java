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

import java.nio.ByteBuffer;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2SimplexCache;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.MemoryUtil.*;

/**
 * <pre><code>
 * typedef struct b2SimplexCache
 * {
 *     /// The number of stored simplex points
 *     uint16_t count;
 *
 *     /// The cached simplex indices on shape A
 *     uint8_t indexA[3];
 *
 *     /// The cached simplex indices on shape B
 *     uint8_t indexB[3];
 * } b2SimplexCache;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2SimplexCache extends Struct<b2SimplexCache> implements ConstB2SimplexCache {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            COUNT,
            INDEX_A,
            INDEX_B;

    static {
        Layout layout = __struct(
                __member(2),
                __array(1, 3),
                __array(1, 3)
        );

        COUNT = layout.offsetof(0);
        INDEX_A = layout.offsetof(1);
        INDEX_B = layout.offsetof(2);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2SimplexCache(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2SimplexCache(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2SimplexCache(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code count} */
    @Override
    public short count() { return ncount(address()); }
    /** @return Returns the property {@code indexA} */
    @Override
    public ByteBuffer indexA() {  return nindexA(address()); }
    /** @return Returns the property {@code indexB} */
    @Override
    public ByteBuffer indexB() { return nindexB(address()); }

    /**
     * Set the value of property {@code count}
     *
     * @param value int
     * @return b2SimplexCache
     */
    public b2SimplexCache count(short value) {
        ncount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code indexA}
     *
     * @param value ByteBuffer
     * @return b2SimplexCache
     */
    public b2SimplexCache indexA(ByteBuffer value) {
        nindexA(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code indexB}
     *
     * @param value ByteBuffer
     * @return b2SimplexCache
     */
    public b2SimplexCache indexB(ByteBuffer value) {
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
    protected b2SimplexCache create(long address, Pointer ptr) {
        return ptr == null ? new b2SimplexCache(address) : new b2SimplexCache(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2SimplexCache
     */
    private static b2SimplexCache factory() {
        return new b2SimplexCache(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2SimplexCache
     */
    public static b2SimplexCache createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2SimplexCache(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2SimplexCache}.
     *
     * @param alloc Custom memory manager
     * @return b2SimplexCache
     */
    public static b2SimplexCache alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2SimplexCache(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2SimplexCache}.
     *
     * @param arean arena
     * @return b2SimplexCache
     */
    public static b2SimplexCache calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2SimplexCache(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2SimplexCache}.
     *
     * @return b2SimplexCache
     */
    public static b2SimplexCache malloc() {
        return new b2SimplexCache(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2SimplexCache}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2SimplexCache}.
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
     * Reserve an amount n of memory for the object {@code b2SimplexCache}.
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
    
    public static short ncount(long address) { return memGetShort(address + COUNT); }
    public static ByteBuffer nindexA(long address) { return memByteBuffer(address + INDEX_A, 3); }
    public static ByteBuffer nindexB(long address) { return memByteBuffer(address + INDEX_B, 3); }

    public static void ncount(long address, short value) { memPutShort(address + COUNT, value); }
    public static void nindexA(long address, ByteBuffer value) { nmemcpy(address + INDEX_A, memGetNativeAddress(value), 3); }
    public static void nindexB(long address, ByteBuffer value) { nmemcpy(address + INDEX_B, memGetNativeAddress(value), 3); }
    
    // -----------------------------------

    /** An array of {@code b2SimplexCache} structs. */
    public static class Buffer extends StructBuffer<b2SimplexCache, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2SimplexCache ELEMENT_FACTORY = b2SimplexCache.factory();

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
        protected b2SimplexCache getElementFactory() {
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
