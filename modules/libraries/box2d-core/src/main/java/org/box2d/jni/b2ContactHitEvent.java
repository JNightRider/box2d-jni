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
 * typedef struct b2ContactHitEvent
 * {
 *     /// Id of the first shape
 *     b2ShapeId shapeIdA;
 *
 *     /// Id of the second shape
 *     b2ShapeId shapeIdB;
 *
 *     /// Id of the contact.
 *     /// @warning this contact may have been destroyed
 *     /// @see b2Contact_IsValid
 *     b2ContactId contactId;
 *
 *     /// Point where the shapes hit at the beginning of the time step.
 *     /// This is a mid-point between the two surfaces. It could be at speculative
 *     /// point where the two shapes were not touching at the beginning of the time step.
 *     b2Pos point;
 *
 *     /// Normal vector pointing from shape A to shape B
 *     b2Vec2 normal;
 *
 *     /// The speed the shapes are approaching. Always positive. Typically in meters per second.
 *     float approachSpeed;
 * } b2ContactHitEvent;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2ContactHitEvent extends Struct<b2ContactHitEvent> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            SHAPE_ID_A,
            SHAPE_ID_B,
            CONTACT_ID,
            POINT,
            NORMAL,
            APPROACH_SPEED;

    static {
        Layout layout = __struct(
                __member(b2ShapeId.SIZEOF, b2ShapeId.ALIGNOF),
                __member(b2ShapeId.SIZEOF, b2ShapeId.ALIGNOF),
                __member(b2ContactId.SIZEOF, b2ContactId.ALIGNOF),
                __member(b2Pos.DSIZEOF, b2Pos.DALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4)
        );

        SHAPE_ID_A = layout.offsetof(0);
        SHAPE_ID_B = layout.offsetof(1);
        CONTACT_ID = layout.offsetof(2);
        POINT = layout.offsetof(3);
        NORMAL = layout.offsetof(4);
        APPROACH_SPEED = layout.offsetof(5);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2ContactHitEvent(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2ContactHitEvent(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2ContactHitEvent(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code shapeIdA} */
    public b2ShapeId shapeIdA() { return nshapeIdA(address());}
    /** @return Returns the property {@code shapeIdB} */
    public b2ShapeId shapeIdB() { return nshapeIdB(address());}
    /** @return Returns the property {@code contactId} */
    public b2ContactId contactId() { return ncontactId(address());}
    /** @return Returns the property {@code point} */
    public b2Pos point() { return npoint(address());}
    /** @return Returns the property {@code normal} */
    public b2Vec2 normal() { return nnormal(address());}
    /** @return Returns the property {@code approachSpeed} */
    public float approachSpeed() { return napproachSpeed(address());}

    /**
     * Set the value of property {@code shapeIdA}
     * 
     * @param value b2ShapeId
     * @return b2ContactHitEvent
     */
    public b2ContactHitEvent shapeIdA(b2ShapeId value) {
        nshapeIdA(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code shapeIdB}
     * 
     * @param value b2ShapeId
     * @return b2ContactHitEvent
     */
    public b2ContactHitEvent shapeIdB(b2ShapeId value) {
        nshapeIdB(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code contactId}
     * 
     * @param value b2ContactId
     * @return b2ContactHitEvent
     */
    public b2ContactHitEvent contactId(b2ContactId value) {
        ncontactId(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code point}
     * 
     * @param value b2Vec2
     * @return b2ContactHitEvent
     */
    public b2ContactHitEvent point(b2Pos value) {
        npoint(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code normal}
     * 
     * @param value b2Vec2
     * @return b2ContactHitEvent
     */
    public b2ContactHitEvent normal(b2Vec2 value) {
        nnormal(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code approachSpeed}
     * 
     * @param value float
     * @return b2ContactHitEvent
     */
    public b2ContactHitEvent approachSpeed(float value) {
        napproachSpeed(address(), value);
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
    protected b2ContactHitEvent create(long address, Pointer ptr) {
        return ptr == null
                ? new b2ContactHitEvent(address)
                : new b2ContactHitEvent(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2ContactHitEvent
     */
    private static b2ContactHitEvent factory() {
        return new b2ContactHitEvent(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2ContactHitEvent
     */
    public static b2ContactHitEvent createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2ContactHitEvent(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ContactHitEvent}.
     *
     * @param alloc Custom memory manager
     * @return b2ContactHitEvent
     */
    public static b2ContactHitEvent alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2ContactHitEvent(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2ContactHitEvent}.
     *
     * @return b2ContactHitEvent
     */
    public static b2ContactHitEvent calloc() {
        return new b2ContactHitEvent(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2ContactHitEvent}.
     *
     * @param alloc arena
     * @return b2ContactHitEvent
     */
    public static b2ContactHitEvent calloc(ArenaAlloc alloc) {
        long ptr = alloc.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2ContactHitEvent(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ContactHitEvent}.
     *
     * @return b2ContactHitEvent
     */
    public static b2ContactHitEvent malloc() {
        return new b2ContactHitEvent(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ContactHitEvent}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ContactHitEvent}.
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
     * Reserve an amount n of memory for the object {@code b2ContactHitEvent}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ContactHitEvent}.
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
    
    public static b2ShapeId nshapeIdA(long address) { return b2ShapeId.createSafe(() -> address + SHAPE_ID_A); }
    public static b2ShapeId nshapeIdB(long address) { return b2ShapeId.createSafe(() -> address + SHAPE_ID_B); }
    public static b2ContactId ncontactId(long address) { return b2ContactId.createSafe(() -> address + CONTACT_ID); }
    public static b2Pos npoint(long address) { return b2Pos.createSafe(() -> address + POINT); }
    public static b2Vec2 nnormal(long address) { return b2Vec2.createSafe(() -> address + NORMAL); }
    public static float napproachSpeed(long address) { return memGetFloat(address + APPROACH_SPEED); }

    public static void nshapeIdA(long address, b2ShapeId value) { nmemcpy(address + SHAPE_ID_A, value.address(), b2ShapeId.SIZEOF);}
    public static void nshapeIdB(long address, b2ShapeId value) { nmemcpy(address + SHAPE_ID_B, value.address(), b2ShapeId.SIZEOF);}
    public static void ncontactId(long address, b2ContactId value) { nmemcpy(address + CONTACT_ID, value.address(), b2ContactId.SIZEOF);}
    public static void npoint(long address, b2Pos value) { nmemcpy(address + POINT, value.address(), b2Pos.DSIZEOF);}
    public static void nnormal(long address, b2Vec2 value) { nmemcpy(address + NORMAL, value.address(), b2Vec2.SIZEOF);}
    public static void napproachSpeed(long address, float value) { memPutFloat(address + APPROACH_SPEED, value);}

    // -----------------------------------

    /** An array of {@code b2ContactHitEvent} structs. */
    public static class Buffer extends StructBuffer<b2ContactHitEvent, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2ContactHitEvent ELEMENT_FACTORY = b2ContactHitEvent.factory();

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
        protected b2ContactHitEvent getElementFactory() {
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
