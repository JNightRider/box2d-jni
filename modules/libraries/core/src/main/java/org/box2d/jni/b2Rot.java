/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.VarType.*;

/**
 * <pre><code>
 * typedef struct b2Rot
 * {
 * 	/// cosine and sine
 * 	float c, s;
 * } b2Rot;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Rot extends Struct<b2Rot> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            C,
            S;

    static {
        Layout layout = __struct(
                __member(Float.sizeof()),
                __member(Float.sizeof())
        );

        C = layout.offsetof(0);
        S = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }
    
    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Rot(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Rot(long address) {
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
    protected b2Rot(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code c} */
    public float c() { return nc(address()); }
    /** @return Returns the property {@code s} */
    public float s() { return ns(address()); }
    
    /**
     * Set the value of property {@code c}
     *
     * @param value The value
     * @return b2Rot
     */
    public b2Rot c(float value) { nc(address(), value); return this; }
    /**
     * Set the value of property {@code s}
     *
     * @param value The value
     * @return b2Rot
     */
    public b2Rot s(float value) { ns(address(), value); return this; }
    
    /*(non-Javadoc)
     */
    @Override
    public int sizeof() { return SIZEOF; }
 
    /*(non-Javadoc)
     */
    @Override
    protected b2Rot create(long address, Pointer ptr) {
        return ptr == null ? new b2Rot(address) : new b2Rot(ptr);
    }
    
    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2Rot
     */
    private static b2Rot factory() {
        return new b2Rot(-1L, true);
    }

    /**
     * Reserve memory for the new object {@code b2Rot}.
     *
     * @param alloc Custom memory manager
     * @return b2Rot
     */
    public static b2Rot alloc(AllocFunc alloc) {
        return new b2Rot(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2Rot}.
     *
     * @return b2Rot
     */
    public static b2Rot malloc() {
        return new b2Rot(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Rot}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Rot}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }
    
    // -----------------------------------

    public static float nc(long address) { return memGetFloat(address + C); }
    public static float ns(long address) { return memGetFloat(address + S); }

    public static void nc(long address, float value) { memPutFloat(address + C, value); }
    public static void ns(long address, float value) { memPutFloat(address + S, value); }

    // -----------------------------------
    
    /** An array of {@code b2Rot} structs. */
    public static class Buffer extends StructBuffer<b2Rot, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2Rot ELEMENT_FACTORY = b2Rot.factory();

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
        protected b2Rot getElementFactory() {
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
