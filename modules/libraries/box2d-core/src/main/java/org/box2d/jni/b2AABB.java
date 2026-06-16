/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2AABB;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;

/**
 * <pre><code>
 * typedef struct b2AABB
 * {
 * 	b2Vec2 lowerBound;
 * 	b2Vec2 upperBound;
 * } b2AABB;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2AABB extends Struct<b2AABB> implements ConstB2AABB {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            LOWER_BOUND,
            UPPER_BOUND;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF)
        );

        LOWER_BOUND = layout.offsetof(0);
        UPPER_BOUND = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }
    
    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2AABB(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2AABB(long address) {
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
    protected b2AABB(long address, boolean factor) {
        super(address, factor);
    }

    /**
     * Initializes this struct with the specified values.
     *
     * @param lowerBound the value {@code lowerBound}
     * @param upperBound the value {@code upperBound}
     *
     * @return b2AABB
     */
    public b2AABB set(
        b2Vec2 lowerBound,
        b2Vec2 upperBound
    ) {
        lowerBound(lowerBound);
        upperBound(upperBound);
        return this;
    }
    
    /** @return Returns the property {@code lowerBound} */
    @Override
    public b2Vec2 lowerBound() { return nlowerBound(address()); }
    /** @return Returns the property {@code upperBound} */
    @Override
    public b2Vec2 upperBound() { return nupperBound(address()); }
    
    /**
     * Set the value of property {@code lowerBound}
     *
     * @param value The value
     * @return b2AABB
     */
    public b2AABB lowerBound(b2Vec2 value) { nlowerBound(address(), value); return this; }

    /**
     * Set the value of property {@code upperBound}
     *
     * @param value The value
     * @return b2AABB
     */
    public b2AABB upperBound(b2Vec2 value) { nupperBound(address(), value); return this; }
    
    /*(non-Javadoc)
     */
    @Override
    public int sizeof() { return SIZEOF; }
 
    /*(non-Javadoc)
     */
    @Override
    protected b2AABB create(long address, Pointer ptr) {
        return ptr == null ? new b2AABB(address) : new b2AABB(ptr);
    }
    
    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2AABB
     */
    private static b2AABB factory() {
        return new b2AABB(-1L, true);
    }
    
    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2AABB
     */
    public static b2AABB createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2AABB(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2AABB}.
     *
     * @param alloc Custom memory manager
     * @return b2AABB
     */
    public static b2AABB alloc(AllocFunc alloc) {
        return new b2AABB(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2AABB}.
     *
     * @return b2AABB
     */
    public static b2AABB malloc() {
        return new b2AABB(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2AABB}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2AABB}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }
    
    // -----------------------------------

    public static b2Vec2 nlowerBound(long address) { return b2Vec2.createSafe(() -> address + LOWER_BOUND); }
    public static b2Vec2 nupperBound(long address) { return b2Vec2.createSafe(() -> address + UPPER_BOUND); }

    public static void nlowerBound(long address, b2Vec2 value) { nmemcpy(address + LOWER_BOUND, value.address(), b2Vec2.SIZEOF); }
    public static void nupperBound(long address, b2Vec2 value) { nmemcpy(address + UPPER_BOUND, value.address(), b2Vec2.SIZEOF); }

    // -----------------------------------
    
    /** An array of {@code b2AABB} structs. */
    public static class Buffer extends StructBuffer<b2AABB, Buffer> implements ConstB2AABB.ConstBuffer<b2AABB, Buffer>, JNINative {
        /** An element that provides information about the structure. */
        private static final b2AABB ELEMENT_FACTORY = b2AABB.factory();

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
        protected b2AABB getElementFactory() {
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
