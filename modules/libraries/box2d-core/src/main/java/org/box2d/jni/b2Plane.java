/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.VarType.*;

/**
 * <pre><code>
 * typedef struct b2Plane
 * {
 * 	b2Vec2 normal;
 * 	float offset;
 * } b2Plane;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Plane extends Struct<b2Plane> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            NORMAL,
            OFFSET;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(Float.sizeof())
        );

        NORMAL = layout.offsetof(0);
        OFFSET = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }
    
    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Plane(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Plane(long address) {
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
    protected b2Plane(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code normal} */
    public b2Vec2 normal() { return nnormal(address()); }
    /** @return Returns the property {@code offset} */
    public float offset() { return noffset(address()); }
    
    /**
     * Set the value of property {@code normal}
     *
     * @param value The value
     * @return b2Plane
     */
    public b2Plane normal(b2Vec2 value) { nnormal(address(), value); return this; }

    /**
     * Set the value of property {@code upperBound}
     *
     * @param value The value
     * @return b2Plane
     */
    public b2Plane offset(float value) { noffset(address(), value); return this; }
    
    /*(non-Javadoc)
     */
    @Override
    public int sizeof() { return SIZEOF; }
 
    /*(non-Javadoc)
     */
    @Override
    protected b2Plane create(long address, Pointer ptr) {
        return ptr == null ? new b2Plane(address) : new b2Plane(ptr);
    }
    
    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2Plane
     */
    private static b2Plane factory() {
        return new b2Plane(-1L, true);
    }
    
    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Plane
     */
    public static b2Plane createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Plane(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Plane}.
     *
     * @param alloc Custom memory manager
     * @return b2Plane
     */
    public static b2Plane alloc(AllocFunc alloc) {
        return new b2Plane(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2Plane}.
     *
     * @return b2Plane
     */
    public static b2Plane malloc() {
        return new b2Plane(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Plane}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Plane}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }
    
    // -----------------------------------

    public static b2Vec2 nnormal(long address) { return b2Vec2.createSafe(() -> address + NORMAL); }
    public static float noffset(long address) { return memGetFloat(address + OFFSET); }

    public static void nnormal(long address, b2Vec2 value) { nmemcpy(address + NORMAL, value.address(), b2Vec2.SIZEOF); }
    public static void noffset(long address, float value) { memPutFloat(address + OFFSET, value); }

    // -----------------------------------
    
    /** An array of {@code b2Plane} structs. */
    public static class Buffer extends StructBuffer<b2Plane, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2Plane ELEMENT_FACTORY = b2Plane.factory();

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
        protected b2Plane getElementFactory() {
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
