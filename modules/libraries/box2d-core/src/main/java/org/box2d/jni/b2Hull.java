/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.readonly.ConstB2Hull;
import org.box2d.jni.system.*;

import static org.box2d.jni.include.Collision.*;
import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2Hull
 * {
 *     b2Vec2 points[B2_MAX_POLYGON_VERTICES];
 *     int count;
 * } b2Hull;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Hull extends Struct<b2Hull> implements ConstB2Hull {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            POINTS,
            COUNT;

    static {
        Layout layout = __struct(
                __array(b2Vec2.SIZEOF, b2Vec2.ALIGNOF, B2_MAX_POLYGON_VERTICES),
                __member(4)
        );

        POINTS = layout.offsetof(0);
        COUNT = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Hull(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Hull(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2Hull(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code points} */
    @Override
    public b2Vec2.Buffer points() { return npoints(address()); }
    /** @return Returns the property {@code count} */
    @Override
    public int count() { return ncount(address()); }

    /**
     * Set the value of property {@code points}
     * 
     * @param value b2Vec2.Buffer
     * @return b2Hull
     */
    public b2Hull points(b2Vec2.Buffer value) {
        npoints(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code count}
     * 
     * @param value int
     * @return b2Hull
     */
    public b2Hull count(int value) {
        ncount(address(), value);
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
    protected b2Hull create(long address, Pointer ptr) {
        return ptr == null ? new b2Hull(address) : new b2Hull(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2Hull
     */
    private static b2Hull factory() {
        return new b2Hull(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Hull
     */
    public static b2Hull createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Hull(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Hull}.
     *
     * @param alloc Custom memory manager
     * @return b2Hull
     */
    public static b2Hull alloc(AllocFunc alloc) {
        return new b2Hull(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2Hull}.
     *
     * @return b2Hull
     */
    public static b2Hull malloc() {
        return new b2Hull(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Hull}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Hull}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static b2Vec2.Buffer npoints(long address) { return b2Vec2.createSafe(address + POINTS, B2_MAX_POLYGON_VERTICES); }
    public static int ncount(long address) { return memGetInt(address + COUNT); }

    public static void npoints(long address, b2Vec2.Buffer value) { nmemcpy(address + POINTS, value.address(), b2Vec2.SIZEOF * B2_MAX_POLYGON_VERTICES); }
    public static void ncount(long address, int value) { memPutInt(address + COUNT, value); }
    
    // -----------------------------------
        /** An array of {@code b2Hull} structs. */
    public static class Buffer extends StructBuffer<b2Hull, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2Hull ELEMENT_FACTORY = b2Hull.factory();

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
        protected b2Hull getElementFactory() {
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
