/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;

/**
 * <pre><code>
 * typedef struct b2SensorBeginTouchEvent
 * {
 *     /// The id of the sensor shape
 *     b2ShapeId sensorShapeId;
 *
 *     /// The id of the shape that began touching the sensor shape
 *     b2ShapeId visitorShapeId;
 * } b2SensorBeginTouchEvent;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2SensorBeginTouchEvent extends Struct<b2SensorBeginTouchEvent> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            SENSOR_SHAPE_ID,
            VISITOR_SHAPE_ID;

    static {
        Layout layout = __struct(
                __member(b2ShapeId.SIZEOF, b2ShapeId.ALIGNOF),
                __member(b2ShapeId.SIZEOF, b2ShapeId.ALIGNOF)
        );

        SENSOR_SHAPE_ID = layout.offsetof(0);
        VISITOR_SHAPE_ID = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2SensorBeginTouchEvent(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2SensorBeginTouchEvent(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2SensorBeginTouchEvent(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code sensorShapeId} */
    public b2ShapeId sensorShapeId() { return nsensorShapeId(address()); }
    /** @return Returns the property {@code visitorShapeId} */
    public b2ShapeId visitorShapeId() { return nvisitorShapeId(address()); }

    /**
     * Set the value of property {@code sensorShapeId}
     * 
     * @param value b2ShapeId
     * @return b2SensorBeginTouchEvent
     */
    public b2SensorBeginTouchEvent sensorShapeId(b2ShapeId value) {
        nsensorShapeId(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code visitorShapeId}
     * 
     * @param value b2ShapeId
     * @return b2SensorBeginTouchEvent
     */
    public b2SensorBeginTouchEvent visitorShapeId(b2ShapeId value) {
        nvisitorShapeId(address(), value);
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
    protected b2SensorBeginTouchEvent create(long address, Pointer ptr) {
        return ptr == null ? new b2SensorBeginTouchEvent(address) : new b2SensorBeginTouchEvent(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2SensorBeginTouchEvent
     */
    private static b2SensorBeginTouchEvent factory() {
        return new b2SensorBeginTouchEvent(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2SensorBeginTouchEvent
     */
    public static b2SensorBeginTouchEvent createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2SensorBeginTouchEvent(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2SensorBeginTouchEvent}.
     *
     * @param alloc Custom memory manager
     * @return b2SensorBeginTouchEvent
     */
    public static b2SensorBeginTouchEvent alloc(AllocFunc alloc) {
        return new b2SensorBeginTouchEvent(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2SensorBeginTouchEvent}.
     *
     * @return b2SensorBeginTouchEvent
     */
    public static b2SensorBeginTouchEvent malloc() {
        return new b2SensorBeginTouchEvent(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2SensorBeginTouchEvent}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2SensorBeginTouchEvent}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static b2ShapeId nsensorShapeId(long address) { return b2ShapeId.createSafe(() -> address + SENSOR_SHAPE_ID); }
    public static b2ShapeId nvisitorShapeId(long address) { return b2ShapeId.createSafe(() -> address + VISITOR_SHAPE_ID); }

    public static void nsensorShapeId(long address, b2ShapeId value) { nmemcpy(address + SENSOR_SHAPE_ID, value.address(), b2ShapeId.SIZEOF); }
    public static void nvisitorShapeId(long address, b2ShapeId value) { nmemcpy(address + VISITOR_SHAPE_ID, value.address(), b2ShapeId.SIZEOF); }

    // -----------------------------------

    /** An array of {@code b2SensorBeginTouchEvent} structs. */
    public static class Buffer extends StructBuffer<b2SensorBeginTouchEvent, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2SensorBeginTouchEvent ELEMENT_FACTORY = b2SensorBeginTouchEvent.factory();

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
        protected b2SensorBeginTouchEvent getElementFactory() {
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
