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
 * typedef struct b2ContactBeginTouchEvent
 * {
 *     /// Id of the first shape
 *     b2ShapeId shapeIdA;
 *
 *     /// Id of the second shape
 *     b2ShapeId shapeIdB;
 *
 *     /// The transient contact id. This contact maybe destroyed automatically when the world is modified or simulated.
 *     /// Used b2Contact_IsValid before using this id.
 *     b2ContactId contactId;
 * } b2ContactBeginTouchEvent;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2ContactBeginTouchEvent extends Struct<b2ContactBeginTouchEvent> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            SHAPE_ID_A,
            SHAPE_ID_B,
            CONTACT_ID;

    static {
        Layout layout = __struct(
                __member(b2ShapeId.SIZEOF, b2ShapeId.ALIGNOF),
                __member(b2ShapeId.SIZEOF, b2ShapeId.ALIGNOF),
                __member(b2ContactId.SIZEOF, b2ContactId.ALIGNOF)
        );

        SHAPE_ID_A = layout.offsetof(0);
        SHAPE_ID_B = layout.offsetof(1);
        CONTACT_ID = layout.offsetof(2);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2ContactBeginTouchEvent(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2ContactBeginTouchEvent(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2ContactBeginTouchEvent(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code shapeIdA} */
    public b2ShapeId shapeIdA() { return nshapeIdA(address());}
    /** @return Returns the property {@code shapeIdB} */
    public b2ShapeId shapeIdB() { return nshapeIdB(address());}
    /** @return Returns the property {@code contactId} */
    public b2ContactId contactId() { return ncontactId(address());}

    /**
     * Set the value of property {@code shapeIdA}
     * 
     * @param value b2ShapeId
     * @return b2ContactBeginTouchEvent
     */
    public b2ContactBeginTouchEvent shapeIdA(b2ShapeId value) {
        nshapeIdA(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code shapeIdB}
     * 
     * @param value b2ShapeId
     * @return b2ContactBeginTouchEvent
     */
    public b2ContactBeginTouchEvent shapeIdB(b2ShapeId value) {
        nshapeIdB(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code contactId}
     * 
     * @param value b2ContactId
     * @return b2ContactBeginTouchEvent
     */
    public b2ContactBeginTouchEvent contactId(b2ContactId value) {
        ncontactId(address(), value);
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
    protected b2ContactBeginTouchEvent create(long address, Pointer ptr) {
        return ptr == null ? new b2ContactBeginTouchEvent(address) : new b2ContactBeginTouchEvent(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2ContactBeginTouchEvent
     */
    private static b2ContactBeginTouchEvent factory() {
        return new b2ContactBeginTouchEvent(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2ContactBeginTouchEvent
     */
    public static b2ContactBeginTouchEvent createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2ContactBeginTouchEvent(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ContactBeginTouchEvent}.
     *
     * @param alloc Custom memory manager
     * @return b2ContactBeginTouchEvent
     */
    public static b2ContactBeginTouchEvent alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2ContactBeginTouchEvent(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2ContactBeginTouchEvent}.
     *
     * @return b2ContactBeginTouchEvent
     */
    public static b2ContactBeginTouchEvent calloc() {
        return new b2ContactBeginTouchEvent(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2ContactBeginTouchEvent}.
     *
     * @param alloc arena
     * @return b2ContactBeginTouchEvent
     */
    public static b2ContactBeginTouchEvent calloc(ArenaAlloc alloc) {
        long ptr = alloc.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2ContactBeginTouchEvent(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ContactBeginTouchEvent}.
     *
     * @return b2ContactBeginTouchEvent
     */
    public static b2ContactBeginTouchEvent malloc() {
        return new b2ContactBeginTouchEvent(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ContactBeginTouchEvent}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ContactBeginTouchEvent}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ContactBeginTouchEvent}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ContactBeginTouchEvent}.
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
    
    public static b2ShapeId nshapeIdA(long address) { return b2ShapeId.createSafe(() -> address + SHAPE_ID_A);}
    public static b2ShapeId nshapeIdB(long address) { return b2ShapeId.createSafe(() -> address + SHAPE_ID_B);}
    public static b2ContactId ncontactId(long address) { return b2ContactId.createSafe(() -> address + CONTACT_ID);}

    public static void nshapeIdA(long address, b2ShapeId value) { nmemcpy(address + SHAPE_ID_A, value.address(), b2ShapeId.SIZEOF); }
    public static void nshapeIdB(long address, b2ShapeId value) { nmemcpy(address + SHAPE_ID_B, value.address(), b2ShapeId.SIZEOF); }
    public static void ncontactId(long address, b2ContactId value) { nmemcpy(address + CONTACT_ID, value.address(), b2ContactId.SIZEOF); }
    
    // -----------------------------------

    /** An array of {@code b2ContactBeginTouchEvent} structs. */
    public static class Buffer extends StructBuffer<b2ContactBeginTouchEvent, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2ContactBeginTouchEvent ELEMENT_FACTORY = b2ContactBeginTouchEvent.factory();

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
        protected b2ContactBeginTouchEvent getElementFactory() {
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
