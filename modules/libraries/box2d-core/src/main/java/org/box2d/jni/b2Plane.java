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
import org.box2d.jni.readonly.ConstB2Plane;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.VarType.*;

/**
 * <pre><code>
 * typedef struct b2Plane
 * {
 * 	b2Vec2 normal;
 * 	float offset;
 * } b2Plane;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Plane extends Struct<b2Plane> implements ConstB2Plane {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            NORMAL,
            OFFSET;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(Float.sizeof())
        );

        NORMAL = layout.offsetof(0);
        OFFSET = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }
    
    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Plane(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Plane(long address) {
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
    protected b2Plane(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code normal} */
    @Override
    public b2Vec2 normal() { return nnormal(address()); }
    /** @return Returns the property {@code offset} */
    @Override
    public float offset() { return noffset(address()); }
    
    /**
     * Set the value of property {@code normal}
     *
     * @param value The value
     * @return b2Plane
     */
    public b2Plane normal(b2Vec2 value) { nnormal(address(), value); return this; }

    /**
     * Set the value of property {@code upperBound}
     *
     * @param value The value
     * @return b2Plane
     */
    public b2Plane offset(float value) { noffset(address(), value); return this; }
    
    /*(non-Javadoc)
     */
    @Override
    public int sizeof() { return SIZEOF; }
 
    /*(non-Javadoc)
     */
    @Override
    protected b2Plane create(long address, Pointer ptr) {
        return ptr == null ? new b2Plane(address) : new b2Plane(ptr);
    }
    
    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2Plane
     */
    private static b2Plane factory() {
        return new b2Plane(-1L, true);
    }
    
    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Plane
     */
    public static b2Plane createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Plane(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Plane}.
     *
     * @param alloc Custom memory manager
     * @return b2Plane
     */
    public static b2Plane alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2Plane(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2Plane}.
     *
     * @param alloc arena
     * @return b2Plane
     */
    public static b2Plane malloc(ArenaAlloc alloc) {
        long ptr = alloc.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2Plane(() -> ptr);
    }
    
    /**
     * Reserve memory for the new object {@code b2Plane}.
     *
     * @return b2Plane
     */
    public static b2Plane malloc() {
        return new b2Plane(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Plane}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Plane}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }
    
    // -----------------------------------

    public static b2Vec2 nnormal(long address) { return b2Vec2.createSafe(() -> address + NORMAL); }
    public static float noffset(long address) { return memGetFloat(address + OFFSET); }

    public static void nnormal(long address, b2Vec2 value) { nmemcpy(address + NORMAL, value.address(), b2Vec2.SIZEOF); }
    public static void noffset(long address, float value) { memPutFloat(address + OFFSET, value); }

    // -----------------------------------
    
    /** An array of {@code b2Plane} structs. */
    public static class Buffer extends StructBuffer<b2Plane, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2Plane ELEMENT_FACTORY = b2Plane.factory();

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
        protected b2Plane getElementFactory() {
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
