/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2BodyEvents
 * {
 *     /// Array of move events
 *     b2BodyMoveEvent* moveEvents;
 *
 *     /// Number of move events
 *     int moveCount;
 * } b2BodyEvents;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2BodyEvents extends Struct<b2BodyEvents> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            MOVE_EVENTS,
            MOVE_COUNT;

    static {
        Layout layout = __struct(
                __member(VarType.Uintptrt.sizeof()),
                __member(4)
        );

        MOVE_EVENTS = layout.offsetof(0);
        MOVE_COUNT = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2BodyEvents(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2BodyEvents(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2BodyEvents(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code moveEvents} */
    public long moveEvents() { return nmoveEvents(address()); }
    /** @return Returns the property {@code moveCount} */
    public int moveCount() { return nmoveCount(address()); }

    /**
     * Set the value of property {@code moveEvents}
     * 
     * @param value long
     * @return b2BodyEvents
     */
    public b2BodyEvents moveEvents(long value) {
        nmoveEvents(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code moveCount}
     * 
     * @param value int
     * @return b2BodyEvents
     */
    public b2BodyEvents moveCount(int value) {
        nmoveCount(address(), value);
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
    protected b2BodyEvents create(long address, Pointer ptr) {
        return ptr == null ? new b2BodyEvents(address) : new b2BodyEvents(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2BodyEvents
     */
    private static b2BodyEvents factory() {
        return new b2BodyEvents(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2BodyEvents
     */
    public static b2BodyEvents createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2BodyEvents(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2BodyEvents}.
     *
     * @param alloc Custom memory manager
     * @return b2BodyEvents
     */
    public static b2BodyEvents alloc(AllocFunc alloc) {
        return new b2BodyEvents(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2BodyEvents}.
     *
     * @return b2BodyEvents
     */
    public static b2BodyEvents malloc() {
        return new b2BodyEvents(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2BodyEvents}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2BodyEvents}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------
    
    public static long nmoveEvents(long address) { return memGetAddress(address + MOVE_EVENTS); }
    public static int nmoveCount(long address) { return memGetInt(address + MOVE_COUNT); }

    public static void nmoveEvents(long address, long value) { memPutAddress(address + MOVE_EVENTS, value); }
    public static void nmoveCount(long address, int value) { memPutInt(address + MOVE_COUNT, value); }

    // -----------------------------------

    /** An array of {@code b2BodyEvents} structs. */
    public static class Buffer extends StructBuffer<b2BodyEvents, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2BodyEvents ELEMENT_FACTORY = b2BodyEvents.factory();

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
        protected b2BodyEvents getElementFactory() {
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
