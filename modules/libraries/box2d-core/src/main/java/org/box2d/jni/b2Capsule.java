/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2Capsule;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2Capsule
 * {
 *     b2Vec2 center1;
 *     b2Vec2 center2;
 *     float radius;
 * } b2Capsule;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Capsule extends Struct<b2Capsule> implements ConstB2Capsule {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            CENTER1,
            CENTER2,
            RADIUS;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4)
        );

        CENTER1 = layout.offsetof(0);
        CENTER2 = layout.offsetof(1);
        RADIUS = layout.offsetof(2);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Capsule(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Capsule(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2Capsule(long address, boolean factor) {
        super(address, factor);
    }

    /**
     * Initializes this struct with the specified values.
     *
     * @param center1
     * @param center2
     * @param radius
     *
     * @return b2AABB
     */
    public b2Capsule set(
        b2Vec2 center1,
        b2Vec2 center2,
        float radius
    ) {
        center1(center1);
        center2(center2);
        radius(radius);
        return this;
    }

    /** @return Returns the property {@code center1} */
    @Override
    public b2Vec2 center1() { return ncenter1(address()); }
    /** @return Returns the property {@code center2} */
    @Override
    public b2Vec2 center2() { return ncenter2(address()); }
    /** @return Returns the property {@code radius} */
    @Override
    public float radius() { return nradius(address()); }

    /**
     * Set the value of property {@code center1}
     * 
     * @param value b2Vec2
     * @return b2Capsule
     */
    public b2Capsule center1(b2Vec2 value) {
        ncenter1(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code center2}
     * 
     * @param value b2Vec2
     * @return b2Capsule
     */
    public b2Capsule center2(b2Vec2 value) {
        ncenter2(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code radius}
     * 
     * @param value float
     * @return b2Capsule
     */
    public b2Capsule radius(float value) {
        nradius(address(), value);
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
    protected b2Capsule create(long address, Pointer ptr) {
        return ptr == null ? new b2Capsule(address) : new b2Capsule(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2Capsule
     */
    private static b2Capsule factory() {
        return new b2Capsule(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Capsule
     */
    public static b2Capsule createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Capsule(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Capsule}.
     *
     * @param alloc Custom memory manager
     * @return b2Capsule
     */
    public static b2Capsule alloc(AllocFunc alloc) {
        return new b2Capsule(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2Capsule}.
     *
     * @return b2Capsule
     */
    public static b2Capsule malloc() {
        return new b2Capsule(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Capsule}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Capsule}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static b2Vec2 ncenter1(long address) { return b2Vec2.createSafe(() -> address + CENTER1); }
    public static b2Vec2 ncenter2(long address) { return b2Vec2.createSafe(() -> address + CENTER2); }
    public static float nradius(long address)   { return memGetFloat(address + RADIUS); }

    public static void ncenter1(long address, b2Vec2 value) { nmemcpy(address + CENTER1, value.address(), b2Vec2.SIZEOF); }
    public static void ncenter2(long address, b2Vec2 value) { nmemcpy(address + CENTER2, value.address(), b2Vec2.SIZEOF); }
    public static void nradius(long address, float value) { memPutFloat(address + RADIUS, value); }

    // -----------------------------------

    /** An array of {@code b2Capsule} structs. */
    public static class Buffer extends StructBuffer<b2Capsule, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2Capsule ELEMENT_FACTORY = b2Capsule.factory();

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
        protected b2Capsule getElementFactory() {
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
