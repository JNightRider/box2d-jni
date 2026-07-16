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

/**
 * <pre><code>
 * typedef struct b2Mat22
 * {
 * 	/// columns
 * 	b2Vec2 cx, cy;
 * } b2Mat22;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Mat22 extends Struct<b2Mat22> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            CX,
            CY;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF)
        );

        CX = layout.offsetof(0);
        CY = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }
    
    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Mat22(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Mat22(long address) {
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
    protected b2Mat22(long address, boolean factor) {
        super(address, factor);
    }

    /**
     * Initializes this struct with the specified values.
     *
     * @param cx the valur {@code cx}
     * @param cy the valur {@code cy}
     *
     * @return b2Mat22
     */
    public b2Mat22 set(
        b2Vec2 cx,
        b2Vec2 cy
    ) {
        cx(cx);
        cy(cy);
        return this;
    }
    
    /** @return Returns the property {@code cx} */
    public b2Vec2 cx() { return ncx(address()); }
    /** @return Returns the property {@code cy} */
    public b2Vec2 cy() { return ncy(address()); }
    
    /**
     * Set the value of property {@code cx}
     *
     * @param value The value
     * @return b2Mat22
     */
    public b2Mat22 cx(b2Vec2 value) { ncx(address(), value); return this; }

    /**
     * Set the value of property {@code cy}
     *
     * @param value The value
     * @return b2Mat22
     */
    public b2Mat22 cy(b2Vec2 value) { ncy(address(), value); return this; }
    
    /*(non-Javadoc)
     */
    @Override
    public int sizeof() { return SIZEOF; }
 
    /*(non-Javadoc)
     */
    @Override
    protected b2Mat22 create(long address, Pointer ptr) {
        return ptr == null ? new b2Mat22(address) : new b2Mat22(ptr);
    }
    
    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2Mat22
     */
    private static b2Mat22 factory() {
        return new b2Mat22(-1L, true);
    }
    
    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Mat22
     */
    public static b2Mat22 createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Mat22(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Mat22}.
     *
     * @param alloc Custom memory manager
     * @return b2Mat22
     */
    public static b2Mat22 alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2Mat22(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2Mat22}.
     *
     * @return b2Mat22
     */
    public static b2Mat22 calloc() {
        return new b2Mat22(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2Mat22}.
     *
     * @param alloc arena
     * @return b2Mat22
     */
    public static b2Mat22 calloc(ArenaAlloc alloc) {
        long ptr = alloc.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2Mat22(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Mat22}.
     *
     * @return b2Mat22
     */
    public static b2Mat22 malloc() {
        return new b2Mat22(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Mat22}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Mat22}.
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
     * Reserve an amount n of memory for the object {@code b2Mat22}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Mat22}.
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

    public static b2Vec2 ncx(long address) { return b2Vec2.createSafe(() -> address + CX); }
    public static b2Vec2 ncy(long address) { return b2Vec2.createSafe(() -> address + CY); }

    public static void ncx(long address, b2Vec2 value) { nmemcpy(address + CX, value.address(), b2Vec2.SIZEOF); }
    public static void ncy(long address, b2Vec2 value) { nmemcpy(address + CY, value.address(), b2Vec2.SIZEOF); }

    // -----------------------------------
    
    /** An array of {@code b2Mat22} structs. */
    public static class Buffer extends StructBuffer<b2Mat22, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2Mat22 ELEMENT_FACTORY = b2Mat22.factory();

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
        protected b2Mat22 getElementFactory() {
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
