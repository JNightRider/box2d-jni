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
 * typedef struct b2CosSin
 * {
 * 	/// cosine and sine
 * 	float cosine;
 * 	float sine;
 * } b2CosSi
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2CosSin extends Struct<b2CosSin> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            COSINE,
            SINE;

    static {
        Layout layout = __struct(
                __member(Float.sizeof()),
                __member(Float.sizeof())
        );

        COSINE = layout.offsetof(0);
        SINE = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }
    
    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2CosSin(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2CosSin(long address) {
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
    protected b2CosSin(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code cosine} */
    public float cosine() { return ncosine(address()); }
    /** @return Returns the property {@code sine} */
    public float sine() { return nsine(address()); }
    
    /**
     * Set the value of property {@code cosine}
     *
     * @param value The value
     * @return b2CosSin
     */
    public b2CosSin cosine(float value) { ncosine(address(), value); return this; }
    /**
     * Set the value of property {@code sine}
     *
     * @param value The value
     * @return b2CosSin
     */
    public b2CosSin sine(float value) { nsine(address(), value); return this; }
    
    /*(non-Javadoc)
     */
    @Override
    public int sizeof() { return SIZEOF; }
 
    /*(non-Javadoc)
     */
    @Override
    protected b2CosSin create(long address, Pointer ptr) {
        return ptr == null ? new b2CosSin(address) : new b2CosSin(ptr);
    }
    
    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2CosSin
     */
    private static b2CosSin factory() {
        return new b2CosSin(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2CosSin
     */
    public static b2CosSin createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2CosSin(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2CosSin}.
     *
     * @param alloc Custom memory manager
     * @return b2CosSin
     */
    public static b2CosSin alloc(AllocFunc alloc) {
        return new b2CosSin(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2CosSin}.
     *
     * @return b2CosSin
     */
    public static b2CosSin malloc() {
        return new b2CosSin(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2CosSin}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2CosSin}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }
    
    // -----------------------------------

    public static float ncosine(long address) { return memGetFloat(address + COSINE); }
    public static float nsine(long address) { return memGetFloat(address + SINE); }

    public static void ncosine(long address, float value) { memPutFloat(address + COSINE, value); }
    public static void nsine(long address, float value) { memPutFloat(address + SINE, value); }

    // -----------------------------------
    
    /** An array of {@code b2CosSin} structs. */
    public static class Buffer extends StructBuffer<b2CosSin, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2CosSin ELEMENT_FACTORY = b2CosSin.factory();

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
        protected b2CosSin getElementFactory() {
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
