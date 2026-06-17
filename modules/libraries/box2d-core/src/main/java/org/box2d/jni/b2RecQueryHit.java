/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni;

import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2RecQueryHit
 * {
 *     b2ShapeId shape;
 *     b2Pos point;
 *     b2Vec2 normal;
 *     float fraction;
 * } b2RecQueryHit;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2RecQueryHit extends Struct<b2RecQueryHit> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            SHAPE,
            POINT,
            NORMAL,
            FRACTION;

    static {
        Layout layout = __struct(
                __member(b2ShapeId.SIZEOF, b2ShapeId.ALIGNOF),
                __member(b2Pos.DSIZEOF, b2Pos.DALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4)
        );

        SHAPE = layout.offsetof(0);
        POINT = layout.offsetof(1);
        NORMAL = layout.offsetof(2);
        FRACTION = layout.offsetof(3);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2RecQueryHit(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2RecQueryHit(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2RecQueryHit(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code shape} */
    public b2ShapeId shape() { return nshape(address()); }
    /** @return Returns the property {@code point} */
    public b2Pos point() { return npoint(address()); }
    /** @return Returns the property {@code normal} */
    public b2Vec2 normal() { return nnormal(address()); }
    /** @return Returns the property {@code fraction} */
    public float fraction() { return nfraction(address()); }

    /**
     * Set the value of property {@code shape}
     *
     * @param value b2ShapeId
     * @return b2RecQueryHit
     */
    public b2RecQueryHit shape(b2ShapeId value) {
        nshape(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code point}
     *
     * @param value b2Pos
     * @return b2RecQueryHit
     */
    public b2RecQueryHit point(b2Pos value) {
        npoint(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code normal}
     *
     * @param value b2Vec2
     * @return b2RecQueryHit
     */
    public b2RecQueryHit normal(b2Vec2 value) {
        nnormal(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code fraction}
     *
     * @param value float
     * @return b2RecQueryHit
     */
    public b2RecQueryHit fraction(float value) {
        nfraction(address(), value);
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
    protected b2RecQueryHit create(long address, Pointer ptr) {
        return ptr == null ? new b2RecQueryHit(address) : new b2RecQueryHit(ptr);
    }

    // -----------------------------------
    
    private static b2ShapeId nshape(long address) { return b2ShapeId.createSafe(() -> address + SHAPE); }
    private static b2Pos npoint(long address) { return b2Pos.ncreateSafe(() -> address + POINT); }
    private static b2Vec2 nnormal(long address) { return b2Vec2.createSafe(() -> address + NORMAL); }
    private static float nfraction(long address) { return memGetFloat(address + FRACTION); }

    private static void nshape(long address, b2ShapeId value) { nmemcpy(address + SHAPE, value.address(), b2ShapeId.SIZEOF); }
    private static void npoint(long address, b2Pos value) { nmemcpy(address + POINT, value.address(), b2Pos.DSIZEOF); }
    private static void nnormal(long address, b2Vec2 value) { nmemcpy(address + NORMAL, value.address(), b2Vec2.SIZEOF); }
    private static void nfraction(long address, float value) { memPutFloat(address + FRACTION, value); }
    
    // -----------------------------------
}
