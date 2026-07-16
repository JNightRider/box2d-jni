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
import org.box2d.jni.readonly.ConstB2WorldTransform;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;

/**
 * <pre><code>
 * typedef struct b2WorldTransform
 * {
 * 	b2Pos p;
 * 	b2Rot q;
 * } b2WorldTransform;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2WorldTransformI extends Struct<b2WorldTransformI> implements b2WorldTransform<b2WorldTransformI, b2PosI, b2Rot>, ConstB2WorldTransform<b2PosI, b2Rot> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            P,
            Q;

    static {
        Layout layout = __struct(
                __member(b2PosI.SIZEOF, b2PosI.ALIGNOF),
                __member(b2Rot.SIZEOF, b2Rot.ALIGNOF)
        );

        P = layout.offsetof(0);
        Q = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2WorldTransformI(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2WorldTransformI(long address) {
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
    protected b2WorldTransformI(long address, boolean factor) {
        super(address, factor);
    }

    /**
     * Initializes this struct with the specified values.
     *
     * @param p the valur {@code p}
     * @param q the valur {@code q}
     *
     * @return b2Transform
     */
    @Override
    public b2WorldTransformI set(
        b2PosI p,
        b2Rot q
    ) {
        p(p);
        q(q);
        return this;
    }
    
    /** @return Returns the property {@code p} */
    @Override
    public b2PosI p() { return np(address()); }
    /** @return Returns the property {@code s} */
    @Override
    public b2Rot q() { return nq(address()); }
    
    /**
     * Set the value of property {@code p}
     *
     * @param value The value
     * @return b2WorldTransformI
     */
    @Override
    public b2WorldTransformI p(b2PosI value) { np(address(), value); return this; }

    /**
     * Set the value of property {@code q}
     *
     * @param value The value
     * @return b2WorldTransformI
     */
    @Override
    public b2WorldTransformI q(b2Rot value) { nq(address(), value); return this; }
    
    /*(non-Javadoc)
     */
    @Override
    public int sizeof() { return SIZEOF; }
 
    /*(non-Javadoc)
     */
    @Override
    protected b2WorldTransformI create(long address, Pointer ptr) {
        return ptr == null ? new b2WorldTransformI(address) : new b2WorldTransformI(ptr);
    }
    
    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2WorldTransformI
     */
    private static b2WorldTransformI factory() {
        return new b2WorldTransformI(-1L, true);
    }
    
    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2WorldTransformI
     */
    public static b2WorldTransformI createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2WorldTransformI(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2WorldTransformI}.
     *
     * @param alloc Custom memory manager
     * @return b2WorldTransformI
     */
    public static b2WorldTransformI alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2WorldTransformI(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2WorldTransformI}.
     *
     * @return b2WorldTransformI
     */
    public static b2WorldTransformI calloc() {
        return new b2WorldTransformI(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2WorldTransformI}.
     *
     * @param arean arena
     * @return b2WorldTransformI
     */
    public static b2WorldTransformI calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2WorldTransformI(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2WorldTransformI}.
     *
     * @return b2WorldTransformI
     */
    public static b2WorldTransformI malloc() {
        return new b2WorldTransformI(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2WorldTransformI}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2WorldTransformI}.
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
     * Reserve an amount n of memory for the object {@code b2WorldTransformI}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2WorldTransformI}.
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

    public static b2PosI np(long address) { return b2PosI.createSafe(() -> address + P); }
    public static b2Rot nq(long address) { return b2Rot.createSafe(() -> address + Q); }

    public static void np(long address, b2PosI value) { nmemcpy(address + P, value.address(), b2PosI.SIZEOF); }
    public static void nq(long address, b2Rot value) { nmemcpy(address + Q, value.address(), b2Rot.SIZEOF); }

    // -----------------------------------
    
    /** An array of {@code b2Transform} structs. */
    public static class Buffer extends StructBuffer<b2WorldTransformI, Buffer> implements b2WorldTransformI.ConstBuffer<b2WorldTransformI, Buffer>, JNINative {
        /** An element that provides information about the structure. */
        private static final b2WorldTransformI ELEMENT_FACTORY = b2WorldTransformI.factory();

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
        protected b2WorldTransformI getElementFactory() {
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
