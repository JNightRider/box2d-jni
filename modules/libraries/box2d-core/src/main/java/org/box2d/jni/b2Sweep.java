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
import org.box2d.jni.readonly.ConstB2Sweep;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;

/**
 * <pre><code>
 * typedef struct b2Sweep
 * {
 *     b2Vec2 localCenter;
 *     b2Vec2 c1;
 *     b2Vec2 c2;
 *     b2Rot q1;
 *     b2Rot q2;
 * } b2Sweep;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Sweep extends Struct<b2Sweep> implements ConstB2Sweep {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            LOCAL_CENTER,
            C1,
            C2,
            Q1,
            Q2;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Rot.SIZEOF, b2Rot.ALIGNOF),
                __member(b2Rot.SIZEOF, b2Rot.ALIGNOF)
        );

        LOCAL_CENTER = layout.offsetof(0);
        C1 = layout.offsetof(1);
        C2 = layout.offsetof(2);
        Q1 = layout.offsetof(3);
        Q2 = layout.offsetof(4);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Sweep(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Sweep(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2Sweep(long address, boolean factor) {
        super(address, factor);
    }

    /**
     * Initializes this struct with the specified values.
     *
     * @param localCenter the value {@code localCenter}
     * @param c1 the value {@code c1}
     * @param c2 the value {@code c1}
     * @param q2 the value {@code q1}
     * @param q1 the value {@code q2}
     *
     * @return b2Sweep
     */
    public b2Sweep set(
        b2Vec2 localCenter,
        b2Vec2 c1,
        b2Vec2 c2,
        b2Rot q1,
        b2Rot q2
    ) {
        localCenter(localCenter);
        c1(c1);
        c2(c2);
        q1(q1);
        q2(q2);
        return this;
    }

    /** @return Returns the property {@code localCenter} */
    @Override
    public b2Vec2 localCenter() { return nlocalCenter(address()); }
    /** @return Returns the property {@code c1} */
    @Override
    public b2Vec2 c1() { return nc1(address()); }
    /** @return Returns the property {@code c2} */
    @Override
    public b2Vec2 c2() { return nc2(address()); }
    /** @return Returns the property {@code q1} */
    @Override
    public b2Rot q1() { return nq1(address()); }
    /** @return Returns the property {@code q2} */
    @Override
    public b2Rot q2() { return nq2(address()); }

    /**
     * Set the value of property {@code localCenter}
     * 
     * @param value b2Vec2
     * @return b2Sweep
     */
    public b2Sweep localCenter(b2Vec2 value) {
        nlocalCenter(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code c1}
     * 
     * @param value b2Vec2
     * @return b2Sweep
     */
    public b2Sweep c1(b2Vec2 value) {
        nc1(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code c2}
     * 
     * @param value b2Vec2
     * @return b2Sweep
     */
    public b2Sweep c2(b2Vec2 value) {
        nc2(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code q1}
     * 
     * @param value b2Rot
     * @return b2Sweep
     */
    public b2Sweep q1(b2Rot value) {
        nq1(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code q2}
     * 
     * @param value b2Rot
     * @return b2Sweep
     */
    public b2Sweep q2(b2Rot value) {
        nq2(address(), value);
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
    protected b2Sweep create(long address, Pointer ptr) {
        return ptr == null ? new b2Sweep(address) : new b2Sweep(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2Sweep
     */
    private static b2Sweep factory() {
        return new b2Sweep(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Sweep
     */
    public static b2Sweep createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Sweep(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Sweep}.
     *
     * @param alloc Custom memory manager
     * @return b2Sweep
     */
    public static b2Sweep alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2Sweep(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2Sweep}.
     *
     * @param arean arena
     * @return b2Sweep
     */
    public static b2Sweep calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2Sweep(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Sweep}.
     *
     * @return b2Sweep
     */
    public static b2Sweep malloc() {
        return new b2Sweep(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Sweep}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Sweep}.
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
     * Reserve an amount n of memory for the object {@code b2Sweep}.
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

    public static b2Vec2 nlocalCenter(long address) { return b2Vec2.createSafe(() -> address + LOCAL_CENTER); }
    public static b2Vec2 nc1(long address) { return b2Vec2.createSafe(() -> address + C1); }
    public static b2Vec2 nc2(long address) { return b2Vec2.createSafe(() -> address + C2); }
    public static b2Rot nq1(long address) { return b2Rot.createSafe(() -> address + Q1); }
    public static b2Rot nq2(long address) { return b2Rot.createSafe(() -> address + Q2); }

    public static void nlocalCenter(long address, b2Vec2 value) { nmemcpy(address + LOCAL_CENTER, value.address(), b2Vec2.SIZEOF); }
    public static void nc1(long address, b2Vec2 value) { nmemcpy(address + C1, value.address(), b2Vec2.SIZEOF); }
    public static void nc2(long address, b2Vec2 value) { nmemcpy(address + C2, value.address(), b2Vec2.SIZEOF); }
    public static void nq1(long address, b2Rot value) { nmemcpy(address + Q1, value.address(), b2Rot.SIZEOF); }
    public static void nq2(long address, b2Rot value) { nmemcpy(address + Q2, value.address(), b2Rot.SIZEOF); }
    
    // -----------------------------------

    /** An array of {@code b2Sweep} structs. */
    public static class Buffer extends StructBuffer<b2Sweep, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2Sweep ELEMENT_FACTORY = b2Sweep.factory();

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
        protected b2Sweep getElementFactory() {
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
