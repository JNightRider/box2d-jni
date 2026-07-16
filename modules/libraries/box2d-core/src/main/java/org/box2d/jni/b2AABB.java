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
import org.box2d.jni.readonly.ConstB2AABB;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;

/**
 * <pre><code>
 * typedef struct b2AABB
 * {
 * 	b2Vec2 lowerBound;
 * 	b2Vec2 upperBound;
 * } b2AABB;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2AABB extends Struct<b2AABB> implements ConstB2AABB {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            LOWER_BOUND,
            UPPER_BOUND;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF)
        );

        LOWER_BOUND = layout.offsetof(0);
        UPPER_BOUND = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }
    
    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2AABB(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2AABB(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     *
     * @see Struct#Struct(long, boolean)
     */
    protected b2AABB(long address, boolean factor) {
        super(address, factor);
    }

    /**
     * Initializes this struct with the specified values.
     *
     * @param lowerBound the value {@code lowerBound}
     * @param upperBound the value {@code upperBound}
     *
     * @return b2AABB
     */
    public b2AABB set(
        b2Vec2 lowerBound,
        b2Vec2 upperBound
    ) {
        lowerBound(lowerBound);
        upperBound(upperBound);
        return this;
    }
    
    /** @return Returns the property {@code lowerBound} */
    @Override
    public b2Vec2 lowerBound() { return nlowerBound(address()); }
    /** @return Returns the property {@code upperBound} */
    @Override
    public b2Vec2 upperBound() { return nupperBound(address()); }
    
    /**
     * Set the value of property {@code lowerBound}
     *
     * @param value The value
     * @return b2AABB
     */
    public b2AABB lowerBound(b2Vec2 value) { nlowerBound(address(), value); return this; }

    /**
     * Set the value of property {@code upperBound}
     *
     * @param value The value
     * @return b2AABB
     */
    public b2AABB upperBound(b2Vec2 value) { nupperBound(address(), value); return this; }
    
    /*(non-Javadoc)
     */
    @Override
    public int sizeof() { return SIZEOF; }
 
    /*(non-Javadoc)
     */
    @Override
    protected b2AABB create(long address, Pointer ptr) {
        return ptr == null ? new b2AABB(address) : new b2AABB(ptr);
    }
    
    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2AABB
     */
    private static b2AABB factory() {
        return new b2AABB(-1L, true);
    }
    
    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2AABB
     */
    public static b2AABB createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2AABB(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2AABB}.
     *
     * @param alloc Custom memory manager
     * @return b2AABB
     */
    public static b2AABB alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2AABB(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2AABB}.
     *
     * @param alloc arena
     * @return b2AABB
     */
    public static b2AABB calloc(ArenaAlloc alloc) {
        long ptr = alloc.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2AABB(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2AABB}.
     *
     * @return b2AABB
     */
    public static b2AABB calloc() {
        return new b2AABB(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2AABB}.
     *
     * @return b2AABB
     */
    public static b2AABB malloc() {
        return new b2AABB(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2AABB}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2AABB}.
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
     * Reserve an amount n of memory for the object {@code b2AABB}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2AABB}.
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

    public static b2Vec2 nlowerBound(long address) { return b2Vec2.createSafe(() -> address + LOWER_BOUND); }
    public static b2Vec2 nupperBound(long address) { return b2Vec2.createSafe(() -> address + UPPER_BOUND); }

    public static void nlowerBound(long address, b2Vec2 value) { nmemcpy(address + LOWER_BOUND, value.address(), b2Vec2.SIZEOF); }
    public static void nupperBound(long address, b2Vec2 value) { nmemcpy(address + UPPER_BOUND, value.address(), b2Vec2.SIZEOF); }

    // -----------------------------------
    
    /** An array of {@code b2AABB} structs. */
    public static class Buffer extends StructBuffer<b2AABB, Buffer> implements ConstB2AABB.ConstBuffer<b2AABB, Buffer>, JNINative {
        /** An element that provides information about the structure. */
        private static final b2AABB ELEMENT_FACTORY = b2AABB.factory();

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

        /*(non-Jabadoc)
         */
        @Override
        protected b2AABB getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /*(non-Jabadoc)
         */
        @Override
        protected Buffer self() {
            return this;
        }

        /*(non-Jabadoc)
         */
        @Override
        protected Buffer create(long address, int mark, int position, int limit, int capacity) {
            return new Buffer(address, mark, position, limit, capacity);
        }        
    }
}
