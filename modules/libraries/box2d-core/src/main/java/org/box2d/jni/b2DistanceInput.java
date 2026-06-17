/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2DistanceInput;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * /// Input for b2ShapeDistance
 * typedef struct b2DistanceInput
 * {
 * 	/// The proxy for shape A
 * 	b2ShapeProxy proxyA;
 * 
 * 	/// The proxy for shape B
 * 	b2ShapeProxy proxyB;
 * 
 * 	/// Transform of shape B in shape A's frame, the relative pose B in A
 * 	/// (b2InvMulTransforms( worldA, worldB )). The query is origin independent and runs in frame A.
 * 	b2Transform transform;
 * 
 * 	/// Should the proxy radius be considered?
 * 	bool useRadii;
 * } b2DistanceInput;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.1.0
 */
public class b2DistanceInput extends Struct<b2DistanceInput> implements ConstB2DistanceInput {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            PROXY_A,
            PROXY_B,
            TRANSFORM,
            USE_RADII;

    static {
        Layout layout = __struct(
                __member(b2ShapeProxy.SIZEOF, b2ShapeProxy.ALIGNOF),
                __member(b2ShapeProxy.SIZEOF, b2ShapeProxy.ALIGNOF),
                __member(b2Transform.SIZEOF, b2Transform.ALIGNOF),
                __member(1)
        );

        PROXY_A = layout.offsetof(0);
        PROXY_B = layout.offsetof(1);
        TRANSFORM = layout.offsetof(2);
        USE_RADII = layout.offsetof(3);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2DistanceInput(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2DistanceInput(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2DistanceInput(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code proxyA} */
    @Override
    public b2ShapeProxy proxyA() { return nproxyA(address()); }
    /** @return Returns the property {@code proxyB} */
    @Override
    public b2ShapeProxy proxyB() { return nproxyB(address()); }
    /** @return Returns the property {@code transform} */
    @Override
    public b2Transform transform() { return ntransform(address()); }
    /** @return Returns the property {@code useRadii} */
    @Override
    public boolean useRadii() { return nuseRadii(address()); }

    /**
     * Set the value of property {@code proxyA}
     *
     * @param value b2ShapeProxy
     * @return b2DistanceInput
     */
    public b2DistanceInput proxyA(b2ShapeProxy value) {
        nproxyA(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code proxyB}
     *
     * @param value b2ShapeProxy
     * @return b2DistanceInput
     */
    public b2DistanceInput proxyB(b2ShapeProxy value) {
        nproxyB(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code transform}
     *
     * @param value b2Transform
     * @return b2DistanceInput
     */
    public b2DistanceInput transform(b2Transform value) {
        ntransform(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code useRadii}
     *
     * @param value boolean
     * @return b2DistanceInput
     */
    public b2DistanceInput useRadii(boolean value) {
        nuseRadii(address(), value);
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
    protected b2DistanceInput create(long address, Pointer ptr) {
        return ptr == null ? new b2DistanceInput(address) : new b2DistanceInput(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2DistanceInput
     */
    private static b2DistanceInput factory() {
        return new b2DistanceInput(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2DistanceInput
     */
    public static b2DistanceInput createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2DistanceInput(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2DistanceInput}.
     *
     * @param alloc Custom memory manager
     * @return b2DistanceInput
     */
    public static b2DistanceInput alloc(AllocFunc alloc) {
        return new b2DistanceInput(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2DistanceInput}.
     *
     * @return b2DistanceInput
     */
    public static b2DistanceInput malloc() {
        return new b2DistanceInput(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2DistanceInput}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2DistanceInput}.
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
    public static b2Transform ntransform(long address) { return b2Transform.createSafe(() -> address + TRANSFORM); }
    public static boolean nuseRadii(long address) { return memGetByte(address + USE_RADII) != 0; }

    public static void nproxyA(long address, b2ShapeProxy value) { nmemcpy(address + PROXY_A, value.address(), b2ShapeProxy.SIZEOF); }
    public static void nproxyB(long address, b2ShapeProxy value) { nmemcpy(address + PROXY_B, value.address(), b2ShapeProxy.SIZEOF); }
    public static void ntransform(long address, b2Transform value) { nmemcpy(address + TRANSFORM, value.address(), b2Transform.SIZEOF); }
    public static void nuseRadii(long address, boolean value) { memPutByte(address + USE_RADII, (byte)(value ? 1 : 0)); }
    
    // -----------------------------------

    /** An array of {@code b2DistanceInput} structs. */
    public static class Buffer extends StructBuffer<b2DistanceInput, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2DistanceInput ELEMENT_FACTORY = b2DistanceInput.factory();

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
        protected b2DistanceInput getElementFactory() {
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
