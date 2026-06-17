/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni;

import org.box2d.jni.readonly.ConstB2RayResult;
import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2RayResult
 * {
 *     b2ShapeId shapeId;
 *     b2Pos point;
 *     b2Vec2 normal;
 *     float fraction;
 *     int nodeVisits;
 *     int leafVisits;
 *     bool hit;
 * } b2RayResult;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2RayResult extends Struct<b2RayResult> implements ConstB2RayResult {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            SHAPE_ID,
            POINT,
            NORMAL,
            FRACTION,
            NODE_VISITS,
            LEAF_VISITS,
            HIT;

    static {
        Layout layout = __struct(
                __member(b2ShapeId.SIZEOF, b2ShapeId.ALIGNOF),
                __member(b2Pos.DSIZEOF, b2Pos.DALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4),
                __member(4),
                __member(4),
                __member(1)
        );

        SHAPE_ID = layout.offsetof(0);
        POINT = layout.offsetof(1);
        NORMAL = layout.offsetof(2);
        FRACTION = layout.offsetof(3);
        NODE_VISITS = layout.offsetof(4);
        LEAF_VISITS = layout.offsetof(5);
        HIT = layout.offsetof(6);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2RayResult(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2RayResult(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2RayResult(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code shapeId} */
    @Override
    public b2ShapeId shapeId() { return nshapeId(address()); }
    /** @return Returns the property {@code point} */
    @Override
    public b2Pos point() { return npoint(address()); }
    /** @return Returns the property {@code normal} */
    @Override
    public b2Vec2 normal() { return nnormal(address()); }
    /** @return Returns the property {@code fraction} */
    @Override
    public float fraction() { return nfraction(address()); }
    /** @return Returns the property {@code nodeVisits} */
    @Override
    public int nodeVisits() { return nnodeVisits(address()); }
    /** @return Returns the property {@code leafVisits} */
    @Override
    public int leafVisits() { return nleafVisits(address()); }
    /** @return Returns the property {@code hit} */
    @Override
    public boolean hit() { return nhit(address()); }

    /**
     * Set the value of property {@code shapeId}
     *
     * @param value The value
     * @return b2RayResult
     */
    public b2RayResult shapeId(b2ShapeId value) {
        nshapeId(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code point}
     *
     * @param value The value
     * @return b2RayResult
     */
    public b2RayResult point(b2Pos value) {
        npoint(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code normal}
     *
     * @param value The value
     * @return b2RayResult
     */
    public b2RayResult normal(b2Vec2 value) {
        nnormal(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code fraction}
     *
     * @param value The value
     * @return b2RayResult
     */
    public b2RayResult fraction(float value) {
        nfraction(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code nodeVisits}
     *
     * @param value The value
     * @return b2RayResult
     */
    public b2RayResult nodeVisits(int value) {
        nnodeVisits(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code leafVisits}
     *
     * @param value The value
     * @return b2RayResult
     */
    public b2RayResult leafVisits(int value) {
        nleafVisits(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code hit}
     *
     * @param value The value
     * @return b2RayResult
     */
    public b2RayResult hit(boolean value) {
        nhit(address(), value);
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
    protected b2RayResult create(long address, Pointer ptr) {
        return ptr == null ? new b2RayResult(address) : new b2RayResult(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2RayResult
     */
    private static b2RayResult factory() {
        return new b2RayResult(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2RayResult
     */
    public static b2RayResult createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2RayResult(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2RayResult}.
     *
     * @param alloc Custom memory manager
     * @return b2RayResult
     */
    public static b2RayResult alloc(AllocFunc alloc) {
        return new b2RayResult(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2RayResult}.
     *
     * @return b2RayResult
     */
    public static b2RayResult malloc() {
        return new b2RayResult(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2RayResult}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2RayResult}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static b2ShapeId nshapeId(long address) { return b2ShapeId.createSafe(() -> address + SHAPE_ID); }
    public static b2Pos npoint(long address) { return b2Pos.ncreateSafe(() -> address + POINT); }
    public static b2Vec2 nnormal(long address) { return b2Vec2.createSafe(() -> address + NORMAL); }
    public static float nfraction(long address) { return memGetFloat(address + FRACTION); }
    public static int nnodeVisits(long address) { return memGetInt(address + NODE_VISITS); }
    public static int nleafVisits(long address) { return memGetInt(address + LEAF_VISITS); }
    public static boolean nhit(long address) { return memGetByte(address + HIT) != 0; }

    public static void nshapeId(long address, b2ShapeId value) { nmemcpy(address + SHAPE_ID, value.address(), b2ShapeId.SIZEOF); }
    public static void npoint(long address, b2Pos value) { nmemcpy(address + POINT, value.address(), b2Vec2.SIZEOF); }
    public static void nnormal(long address, b2Vec2 value) { nmemcpy(address + NORMAL, value.address(), b2Vec2.SIZEOF); }
    public static void nfraction(long address, float value) { memPutFloat(address + FRACTION, value); }
    public static void nnodeVisits(long address, int value) { memPutInt(address + NODE_VISITS, value); }
    public static void nleafVisits(long address, int value) { memPutInt(address + LEAF_VISITS, value); }
    public static void nhit(long address, boolean value) { memPutByte(address + HIT, (byte) (value ? 1 : 0)); }

    // -----------------------------------

    /** An array of {@code b2RayResult} structs. */
    public static class Buffer extends StructBuffer<b2RayResult, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2RayResult ELEMENT_FACTORY = b2RayResult.factory();

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
        protected b2RayResult getElementFactory() {
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
