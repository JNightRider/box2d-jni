/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2ShapeCastPairInput;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2ShapeCastPairInput
 * {
 *     b2ShapeProxy proxyA;
 *     b2ShapeProxy proxyB;
 *     b2Transform transformA;
 *     b2Transform transformB;
 *     b2Vec2 translationB;
 *     float maxFraction;
 *     bool canEncroach;
 * } b2ShapeCastPairInput;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2ShapeCastPairInput extends Struct<b2ShapeCastPairInput> implements ConstB2ShapeCastPairInput {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            PROXY_A,
            PROXY_B,
            TRANSFORM_A,
            TRANSFORM_B,
            TRANSLATION_B,
            MAX_FRACTION,
            CAN_ENCROACH;

    static {
        Layout layout = __struct(
                __member(b2ShapeProxy.SIZEOF, b2ShapeProxy.ALIGNOF),
                __member(b2ShapeProxy.SIZEOF, b2ShapeProxy.ALIGNOF),
                __member(b2Transform.SIZEOF, b2Transform.ALIGNOF),
                __member(b2Transform.SIZEOF, b2Transform.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4),
                __member(1)
        );

        PROXY_A = layout.offsetof(0);
        PROXY_B = layout.offsetof(1);
        TRANSFORM_A = layout.offsetof(2);
        TRANSFORM_B = layout.offsetof(3);
        TRANSLATION_B = layout.offsetof(4);
        MAX_FRACTION = layout.offsetof(5);
        CAN_ENCROACH = layout.offsetof(6);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2ShapeCastPairInput(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2ShapeCastPairInput(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2ShapeCastPairInput(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code proxyA} */
    @Override
    public b2ShapeProxy proxyA() { return nproxyA(address()); }
    /** @return Returns the property {@code proxyB} */
    @Override
    public b2ShapeProxy proxyB() { return nproxyB(address()); }
    /** @return Returns the property {@code transformA} */
    @Override
    public b2Transform transformA() { return ntransformA(address()); }
    /** @return Returns the property {@code transformB} */
    @Override
    public b2Transform transformB() { return ntransformB(address()); }
    /** @return Returns the property {@code translationB} */
    @Override
    public b2Vec2 translationB() { return ntranslationB(address()); }
    /** @return Returns the property {@code maxFraction} */
    @Override
    public float maxFraction() { return nmaxFraction(address()); }
    /** @return Returns the property {@code canEncroach} */
    @Override
    public boolean canEncroach() { return ncanEncroach(address()); }
    
        /**
     * Set the value of property {@code proxyA}
     * 
     * @param value b2ShapeProxy
     * @return b2ShapeCastPairInput
     */
    public b2ShapeCastPairInput proxyA(b2ShapeProxy value) {
        nproxyA(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code proxyB}
     * 
     * @param value b2ShapeProxy
     * @return b2ShapeCastPairInput
     */
    public b2ShapeCastPairInput proxyB(b2ShapeProxy value) {
        nproxyB(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code transformA}
     * 
     * @param value b2Transform
     * @return b2ShapeCastPairInput
     */
    public b2ShapeCastPairInput transformA(b2Transform value) {
        ntransformA(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code transformB}
     * 
     * @param value b2Transform
     * @return b2ShapeCastPairInput
     */
    public b2ShapeCastPairInput transformB(b2Transform value) {
        ntransformB(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code translationB}
     * 
     * @param value b2Vec2
     * @return b2ShapeCastPairInput
     */
    public b2ShapeCastPairInput translationB(b2Vec2 value) {
        ntranslationB(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code maxFraction}
     * 
     * @param value float
     * @return b2ShapeCastPairInput
     */
    public b2ShapeCastPairInput maxFraction(float value) {
        nmaxFraction(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code canEncroach}
     * 
     * @param value boolean
     * @return b2ShapeCastPairInput
     */
    public b2ShapeCastPairInput canEncroach(boolean value) {
        ncanEncroach(address(), value);
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
    protected b2ShapeCastPairInput create(long address, Pointer ptr) {
        return ptr == null ? new b2ShapeCastPairInput(address) : new b2ShapeCastPairInput(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2ShapeCastPairInput
     */
    private static b2ShapeCastPairInput factory() {
        return new b2ShapeCastPairInput(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2ShapeCastPairInput
     */
    public static b2ShapeCastPairInput createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2ShapeCastPairInput(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ShapeCastPairInput}.
     *
     * @param alloc Custom memory manager
     * @return b2ShapeCastPairInput
     */
    public static b2ShapeCastPairInput alloc(AllocFunc alloc) {
        return new b2ShapeCastPairInput(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2ShapeCastPairInput}.
     *
     * @return b2ShapeCastPairInput
     */
    public static b2ShapeCastPairInput malloc() {
        return new b2ShapeCastPairInput(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ShapeCastPairInput}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ShapeCastPairInput}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }
    
    // -----------------------------------
    
    public static b2ShapeProxy nproxyA(long address) { return b2ShapeProxy.createSafe(() -> address + PROXY_A); }
    public static b2ShapeProxy nproxyB(long address) { return b2ShapeProxy.createSafe(() -> address + PROXY_B); }
    public static b2Transform ntransformA(long address) { return b2Transform.createSafe(() -> address + TRANSFORM_A); }
    public static b2Transform ntransformB(long address) { return b2Transform.createSafe(() -> address + TRANSFORM_B); }
    public static b2Vec2 ntranslationB(long address) { return b2Vec2.createSafe(() -> address + TRANSLATION_B); }
    public static float nmaxFraction(long address) { return memGetFloat(address + MAX_FRACTION); }
    public static boolean ncanEncroach(long address) { return memGetByte(address + CAN_ENCROACH) != 0; }

    public static void nproxyA(long address, b2ShapeProxy value) { nmemcpy(address + PROXY_A, value.address(), b2ShapeProxy.SIZEOF); }
    public static void nproxyB(long address, b2ShapeProxy value) { nmemcpy(address + PROXY_B, value.address(), b2ShapeProxy.SIZEOF); }
    public static void ntransformA(long address, b2Transform value) { nmemcpy(address + TRANSFORM_A, value.address(), b2Transform.SIZEOF); }
    public static void ntransformB(long address, b2Transform value) { nmemcpy(address + TRANSFORM_B, value.address(), b2Transform.SIZEOF); }
    public static void ntranslationB(long address, b2Vec2 value) { nmemcpy(address + TRANSLATION_B, value.address(), b2Vec2.SIZEOF); }
    public static void nmaxFraction(long address, float value) { memPutFloat(address + MAX_FRACTION, value); }
    public static void ncanEncroach(long address, boolean value) { memPutByte(address + CAN_ENCROACH, (byte)(value ? 1 : 0)); }
    
    // -----------------------------------

    /** An array of {@code b2ShapeCastPairInput} structs. */
    public static class Buffer extends StructBuffer<b2ShapeCastPairInput, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2ShapeCastPairInput ELEMENT_FACTORY = b2ShapeCastPairInput.factory();

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
        protected b2ShapeCastPairInput getElementFactory() {
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
