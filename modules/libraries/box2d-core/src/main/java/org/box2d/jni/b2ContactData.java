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
 * typedef struct b2ContactData
 * {
 *     b2ContactId contactId;
 *     b2ShapeId shapeIdA;
 *     b2ShapeId shapeIdB;
 *     b2Manifold manifold;
 * } b2ContactData;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2ContactData extends Struct<b2ContactData> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            CONTACT_ID,
            SHAPE_ID_A,
            SHAPE_ID_B,
            MANIFOLD;

    static {
        Layout layout = __struct(
                __member(b2ContactId.SIZEOF, b2ContactId.ALIGNOF),
                __member(b2ShapeId.SIZEOF, b2ShapeId.ALIGNOF),
                __member(b2ShapeId.SIZEOF, b2ShapeId.ALIGNOF),
                __member(b2Manifold.SIZEOF, b2Manifold.ALIGNOF)
        );

        CONTACT_ID = layout.offsetof(0);
        SHAPE_ID_A = layout.offsetof(1);
        SHAPE_ID_B = layout.offsetof(2);
        MANIFOLD = layout.offsetof(3);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2ContactData(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2ContactData(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2ContactData(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code contactId} */
    public b2ContactId contactId() { return ncontactId(address()); }
    /** @return Returns the property {@code shapeIdA} */
    public b2ShapeId shapeIdA() { return nshapeIdA(address()); }
    /** @return Returns the property {@code shapeIdB} */
    public b2ShapeId shapeIdB() { return nshapeIdB(address()); }
    /** @return Returns the property {@code manifold} */
    public b2Manifold manifold() { return nmanifold(address()); }

    /**
     * Set the value of property {@code contactId}
     * 
     * @param value b2ContactId
     * @return b2ContactData
     */
    public b2ContactData contactId(b2ContactId value) {
        ncontactId(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code shapeIdA}
     * 
     * @param value b2ShapeId
     * @return b2ContactData
     */
    public b2ContactData shapeIdA(b2ShapeId value) {
        nshapeIdA(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code shapeIdB}
     * 
     * @param value b2ShapeId
     * @return b2ContactData
     */
    public b2ContactData shapeIdB(b2ShapeId value) {
        nshapeIdB(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code manifold}
     * 
     * @param value b2Manifold
     * @return b2ContactData
     */
    public b2ContactData manifold(b2Manifold value) {
        nmanifold(address(), value);
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
    protected b2ContactData create(long address, Pointer ptr) {
        return ptr == null ? new b2ContactData(address) : new b2ContactData(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2ContactData
     */
    private static b2ContactData factory() {
        return new b2ContactData(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2ContactData
     */
    public static b2ContactData createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2ContactData(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ContactData}.
     *
     * @param alloc Custom memory manager
     * @return b2ContactData
     */
    public static b2ContactData alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2ContactData(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2ContactData}.
     *
     * @param alloc arena
     * @return b2ContactData
     */
    public static b2ContactData calloc(ArenaAlloc alloc) {
        long ptr = alloc.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2ContactData(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ContactData}.
     *
     * @return b2ContactData
     */
    public static b2ContactData malloc() {
        return new b2ContactData(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ContactData}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ContactData}.
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
     * Reserve an amount n of memory for the object {@code b2ContactData}.
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

    public static b2ContactId ncontactId(long address) { return b2ContactId.createSafe(() -> address + CONTACT_ID); }
    public static b2ShapeId nshapeIdA(long address) { return b2ShapeId.createSafe(() -> address + SHAPE_ID_A); }
    public static b2ShapeId nshapeIdB(long address) { return b2ShapeId.createSafe(() -> address + SHAPE_ID_B); }
    public static b2Manifold nmanifold(long address) { return b2Manifold.createSafe(() -> address + MANIFOLD); }

    public static void ncontactId(long address, b2ContactId value) { nmemcpy(address + CONTACT_ID, value.address(), b2ContactId.SIZEOF); }
    public static void nshapeIdA(long address, b2ShapeId value) { nmemcpy(address + SHAPE_ID_A, value.address(), b2ShapeId.SIZEOF); }
    public static void nshapeIdB(long address, b2ShapeId value) { nmemcpy(address + SHAPE_ID_B, value.address(), b2ShapeId.SIZEOF); }
    public static void nmanifold(long address, b2Manifold value) { nmemcpy(address + MANIFOLD, value.address(), b2Manifold.SIZEOF); }
    
    // -----------------------------------

    /** An array of {@code b2ContactData} structs. */
    public static class Buffer extends StructBuffer<b2ContactData, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2ContactData ELEMENT_FACTORY = b2ContactData.factory();

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
        protected b2ContactData getElementFactory() {
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
