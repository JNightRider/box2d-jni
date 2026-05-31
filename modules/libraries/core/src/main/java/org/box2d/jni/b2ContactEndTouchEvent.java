/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2ContactEndTouchEvent
 * {
 *     /// Id of the first shape
 *     /// @warning this shape may have been destroyed
 *     /// @see b2Shape_IsValid
 *     b2ShapeId shapeIdA;
 *
 *     /// Id of the second shape
 *     /// @warning this shape may have been destroyed
 *     /// @see b2Shape_IsValid
 *     b2ShapeId shapeIdB;
 *
 *     /// Id of the contact.
 *     /// @warning this contact may have been destroyed
 *     /// @see b2Contact_IsValid
 *     b2ContactId contactId;
 * } b2ContactEndTouchEvent;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2ContactEndTouchEvent extends Struct<b2ContactEndTouchEvent> {

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
    public b2ContactEndTouchEvent(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2ContactEndTouchEvent(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2ContactEndTouchEvent(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code shapeIdA} */
    public b2ShapeId shapeIdA() { return nshapeIdA(address()); }
    /** @return Returns the property {@code shapeIdB} */
    public b2ShapeId shapeIdB() { return nshapeIdB(address()); }
    /** @return Returns the property {@code contactId} */
    public b2ContactId contactId() { return ncontactId(address()); }

    /**
     * Set the value of property {@code shapeIdA}
     * 
     * @param value b2ShapeId
     * @return b2ContactEndTouchEvent
     */
    public b2ContactEndTouchEvent shapeIdA(b2ShapeId value) {
        nshapeIdA(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code shapeIdB}
     * 
     * @param value b2ShapeId
     * @return b2ContactEndTouchEvent
     */
    public b2ContactEndTouchEvent shapeIdB(b2ShapeId value) {
        nshapeIdB(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code contactId}
     * 
     * @param value b2ContactId
     * @return b2ContactEndTouchEvent
     */
    public b2ContactEndTouchEvent contactId(b2ContactId value) {
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
    protected b2ContactEndTouchEvent create(long address, Pointer ptr) {
        return ptr == null ? new b2ContactEndTouchEvent(address) : new b2ContactEndTouchEvent(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2ContactEndTouchEvent
     */
    private static b2ContactEndTouchEvent factory() {
        return new b2ContactEndTouchEvent(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2ContactEndTouchEvent
     */
    public static b2ContactEndTouchEvent createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2ContactEndTouchEvent(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ContactEndTouchEvent}.
     *
     * @param alloc Custom memory manager
     * @return b2ContactEndTouchEvent
     */
    public static b2ContactEndTouchEvent alloc(AllocFunc alloc) {
        return new b2ContactEndTouchEvent(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2ContactEndTouchEvent}.
     *
     * @return b2ContactEndTouchEvent
     */
    public static b2ContactEndTouchEvent malloc() {
        return new b2ContactEndTouchEvent(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ContactEndTouchEvent}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ContactEndTouchEvent}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static b2ShapeId nshapeIdA(long address) { return b2ShapeId.createSafe(() -> address + SHAPE_ID_A); }
    public static b2ShapeId nshapeIdB(long address) { return b2ShapeId.createSafe(() -> address + SHAPE_ID_B); }
    public static b2ContactId ncontactId(long address) { return b2ContactId.createSafe(() -> address + CONTACT_ID); }

    public static void nshapeIdA(long address, b2ShapeId value) { nmemcpy(address + SHAPE_ID_A, value.address(), b2ShapeId.SIZEOF);}
    public static void nshapeIdB(long address, b2ShapeId value) { nmemcpy(address + SHAPE_ID_B, value.address(), b2ShapeId.SIZEOF);}
    public static void ncontactId(long address, b2ContactId value) { nmemcpy(address + CONTACT_ID, value.address(), b2ContactId.SIZEOF);}

    // -----------------------------------

    /** An array of {@code b2ContactEndTouchEvent} structs. */
    public static class Buffer extends StructBuffer<b2ContactEndTouchEvent, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2ContactEndTouchEvent ELEMENT_FACTORY = b2ContactEndTouchEvent.factory();

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
        protected b2ContactEndTouchEvent getElementFactory() {
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
