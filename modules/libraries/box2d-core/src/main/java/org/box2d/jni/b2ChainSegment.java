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
 * typedef struct b2ChainSegment
 * {
 *     b2Vec2 ghost1;
 *     b2Segment segment;
 *     b2Vec2 ghost2;
 *     int chainId;
 * } b2ChainSegment;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2ChainSegment extends Struct<b2ChainSegment> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            GHOST1,
            SEGMENT,
            GHOST2,
            CHAIN_ID;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Segment.SIZEOF, b2Segment.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4)
        );

        GHOST1 = layout.offsetof(0);
        SEGMENT = layout.offsetof(1);
        GHOST2 = layout.offsetof(2);
        CHAIN_ID = layout.offsetof(3);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2ChainSegment(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2ChainSegment(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2ChainSegment(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code ghost1} */
    public b2Vec2 ghost1() { return nghost1(address()); }
    /** @return Returns the property {@code segment} */
    public b2Segment segment() { return nsegment(address()); }
    /** @return Returns the property {@code ghost2} */
    public b2Vec2 ghost2() { return nghost2(address()); }
    /** @return Returns the property {@code chainId} */
    public int chainId() { return nchainId(address()); }

    /**
     * Set the value of property {@code ghost1}
     * 
     * @param value b2Vec2
     * @return b2ChainSegment
     */
    public b2ChainSegment ghost1(b2Vec2 value) {
        nghost1(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code segment}
     * 
     * @param value b2Segment
     * @return b2ChainSegment
     */
    public b2ChainSegment segment(b2Segment value) {
        nsegment(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code ghost2}
     * 
     * @param value b2Vec2
     * @return b2ChainSegment
     */
    public b2ChainSegment ghost2(b2Vec2 value) {
        nghost2(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code chainId}
     * 
     * @param value int
     * @return b2ChainSegment
     */
    public b2ChainSegment chainId(int value) {
        nchainId(address(), value);
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
    protected b2ChainSegment create(long address, Pointer ptr) {
        return ptr == null ? new b2ChainSegment(address) : new b2ChainSegment(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2ChainSegment
     */
    private static b2ChainSegment factory() {
        return new b2ChainSegment(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2ChainSegment
     */
    public static b2ChainSegment createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2ChainSegment(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ChainSegment}.
     *
     * @param alloc Custom memory manager
     * @return b2ChainSegment
     */
    public static b2ChainSegment alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2ChainSegment(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2ChainSegment}.
     *
     * @return b2ChainSegment
     */
    public static b2ChainSegment calloc() {
        return new b2ChainSegment(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2ChainSegment}.
     *
     * @param alloc arena
     * @return b2ChainSegment
     */
    public static b2ChainSegment calloc(ArenaAlloc alloc) {
        long ptr = alloc.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2ChainSegment(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ChainSegment}.
     *
     * @return b2ChainSegment
     */
    public static b2ChainSegment malloc() {
        return new b2ChainSegment(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ChainSegment}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ChainSegment}.
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
     * Reserve an amount n of memory for the object {@code b2ChainSegment}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ChainSegment}.
     *
     * @param capacity Number of elements
     * @param alloc Arean
     * @return Buffer
     */
    public static Buffer calloc(int capacity, ArenaAlloc alloc) {
        long ptr = alloc.ncalloc(ALIGNOF, capacity, SIZEOF);
        return new Buffer(ptr, capacity);
    }

    // -----------------------------------
    
    public static b2Vec2 nghost1(long address) { return b2Vec2.createSafe(() -> address + GHOST1); }
    public static b2Segment nsegment(long address) { return b2Segment.createSafe(() -> address + SEGMENT); }
    public static b2Vec2 nghost2(long address) { return b2Vec2.createSafe(() -> address + GHOST2); }
    public static int nchainId(long address) { return memGetInt(address + CHAIN_ID); }

    public static void nghost1(long address, b2Vec2 value) { nmemcpy(address + GHOST1, value.address(), b2Vec2.SIZEOF); }
    public static void nsegment(long address, b2Segment value) { nmemcpy(address + SEGMENT, value.address(), b2Segment.SIZEOF); }
    public static void nghost2(long address, b2Vec2 value) { nmemcpy(address + GHOST2, value.address(), b2Vec2.SIZEOF); }
    public static void nchainId(long address, int value) { memPutInt(address + CHAIN_ID, value); }
    
    // -----------------------------------

    /** An array of {@code b2ChainSegment} structs. */
    public static class Buffer extends StructBuffer<b2ChainSegment, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2ChainSegment ELEMENT_FACTORY = b2ChainSegment.factory();

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
        protected b2ChainSegment getElementFactory() {
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
