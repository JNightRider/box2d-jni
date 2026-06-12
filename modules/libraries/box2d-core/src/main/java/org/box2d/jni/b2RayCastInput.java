/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import org.box2d.jni.readonly.ConstB2RayCastInput;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2RayCastInput
 * {
 *     b2Vec2 origin;
 *     b2Vec2 translation;
 *     float maxFraction;
 * } b2RayCastInput;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2RayCastInput extends Struct<b2RayCastInput> implements ConstB2RayCastInput {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            ORIGIN,
            TRANSLATION,
            MAX_FRACTION;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4)
        );

        ORIGIN = layout.offsetof(0);
        TRANSLATION = layout.offsetof(1);
        MAX_FRACTION = layout.offsetof(2);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2RayCastInput(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2RayCastInput(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2RayCastInput(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code origin} */
    @Override
    public b2Vec2 origin() { return norigin(address()); }
    /** @return Returns the property {@code translation} */
    @Override
    public b2Vec2 translation() { return ntranslation(address()); }
    /** @return Returns the property {@code maxFraction} */
    public float maxFraction() { return nmaxFraction(address()); }

    /**
     * Set the value of property {@code origin}
     * 
     * @param value b2Vec2
     * @return b2RayCastInput
     */
    public b2RayCastInput origin(b2Vec2 value) {
        norigin(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code translation}
     * 
     * @param value b2Vec2
     * @return b2RayCastInput
     */
    public b2RayCastInput translation(b2Vec2 value) {
        ntranslation(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code maxFraction}
     * 
     * @param value float
     * @return b2RayCastInput
     */
    public b2RayCastInput maxFraction(float value) {
        nmaxFraction(address(), value);
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
    protected b2RayCastInput create(long address, Pointer ptr) {
        return ptr == null ? new b2RayCastInput(address) : new b2RayCastInput(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2RayCastInput
     */
    private static b2RayCastInput factory() {
        return new b2RayCastInput(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2RayCastInput
     */
    public static b2RayCastInput createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2RayCastInput(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2RayCastInput}.
     *
     * @param alloc Custom memory manager
     * @return b2RayCastInput
     */
    public static b2RayCastInput alloc(AllocFunc alloc) {
        return new b2RayCastInput(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2RayCastInput}.
     *
     * @return b2RayCastInput
     */
    public static b2RayCastInput malloc() {
        return new b2RayCastInput(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2RayCastInput}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2RayCastInput}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }
    
    // -----------------------------------

    public static b2Vec2 norigin(long address)         { return b2Vec2.createSafe(() -> address + ORIGIN);           }
    public static b2Vec2 ntranslation(long address)    { return b2Vec2.createSafe(() -> address + TRANSLATION);      }
    public static float nmaxFraction(long address)     { return memGetFloat(address + MAX_FRACTION);                 }

    public static void norigin(long address, b2Vec2 value)      { nmemcpy(address + ORIGIN, value.address(), b2Vec2.SIZEOF);           }
    public static void ntranslation(long address, b2Vec2 value) { nmemcpy(address + TRANSLATION, value.address(), b2Vec2.SIZEOF);      }
    public static void nmaxFraction(long address, float value)  { memPutFloat(address + MAX_FRACTION, value);                          }

    // -----------------------------------

    /** An array of {@code b2RayCastInput} structs. */
    public static class Buffer extends StructBuffer<b2RayCastInput, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2RayCastInput ELEMENT_FACTORY = b2RayCastInput.factory();

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
        protected b2RayCastInput getElementFactory() {
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
