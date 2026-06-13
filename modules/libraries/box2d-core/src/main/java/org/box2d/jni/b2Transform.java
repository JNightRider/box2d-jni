/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2Transform;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;

/**
 * <pre><code>
 * typedef struct b2Transform
 * {
 * 	b2Vec2 p;
 * 	b2Rot q;
 * } b2Transform;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Transform extends Struct<b2Transform> implements ConstB2Transform {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            P,
            Q;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Rot.SIZEOF, b2Rot.ALIGNOF)
        );

        P = layout.offsetof(0);
        Q = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Transform(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Transform(long address) {
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
    protected b2Transform(long address, boolean factor) {
        super(address, factor);
    }

    /**
     * Initializes this struct with the specified values.
     *
     * @param p the valur {@code p}
     * @param q the valur {@code q}
     *
     * @return b2Transform
     */
    public b2Transform set(
        b2Vec2 p,
        b2Rot q
    ) {
        p(p);
        q(q);
        return this;
    }
    
    /** @return Returns the property {@code p} */
    @Override
    public b2Vec2 p() { return np(address()); }
    /** @return Returns the property {@code s} */
    @Override
    public b2Rot q() { return nq(address()); }
    
    /**
     * Set the value of property {@code p}
     *
     * @param value The value
     * @return b2Transform
     */
    public b2Transform p(b2Vec2 value) { np(address(), value); return this; }

    /**
     * Set the value of property {@code q}
     *
     * @param value The value
     * @return b2Transform
     */
    public b2Transform q(b2Rot value) { nq(address(), value); return this; }
    
    /*(non-Javadoc)
     */
    @Override
    public int sizeof() { return SIZEOF; }
 
    /*(non-Javadoc)
     */
    @Override
    protected b2Transform create(long address, Pointer ptr) {
        return ptr == null ? new b2Transform(address) : new b2Transform(ptr);
    }
    
    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2Transform
     */
    private static b2Transform factory() {
        return new b2Transform(-1L, true);
    }
    
    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Transform
     */
    public static b2Transform createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Transform(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Transform}.
     *
     * @param alloc Custom memory manager
     * @return b2Transform
     */
    public static b2Transform alloc(AllocFunc alloc) {
        return new b2Transform(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2Transform}.
     *
     * @return b2Transform
     */
    public static b2Transform malloc() {
        return new b2Transform(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Transform}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Transform}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }
    
    // -----------------------------------

    public static b2Vec2 np(long address) { return b2Vec2.createSafe(() -> address + P); }
    public static b2Rot nq(long address) { return b2Rot.createSafe(() -> address + Q); }

    public static void np(long address, b2Vec2 value) { nmemcpy(address + P, value.address(), b2Vec2.SIZEOF); }
    public static void nq(long address, b2Rot value) { nmemcpy(address + Q, value.address(), b2Rot.SIZEOF); }

    // -----------------------------------
    
    /** An array of {@code b2Transform} structs. */
    public static class Buffer extends StructBuffer<b2Transform, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2Transform ELEMENT_FACTORY = b2Transform.factory();

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
        protected b2Transform getElementFactory() {
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
