/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni;

import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2RecQueryInfo
 * {
 *     b2RecQueryType type;
 *     b2QueryFilter filter; // zeroed for the shape local query types
 *     b2AABB aabb;          // overlap AABB
 *     b2Vec2 origin;        // ray and cast origin
 *     b2Vec2 translation;   // ray and cast translation
 *     b2ShapeId shape;      // target shape for the shape local query types
 *     int hitCount;         // number of recorded results
 * } b2RecQueryInfo;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2RecQueryInfo extends Struct<b2RecQueryInfo> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            TYPE,
            FILTER,
            AABB,
            ORIGIN,
            TRANSLATION,
            SHAPE,
            HIT_COUNT;

    static {
        Layout layout = __struct(
                __member(4),
                __member(b2QueryFilter.SIZEOF, b2QueryFilter.ALIGNOF),
                __member(b2AABB.SIZEOF, b2AABB.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2ShapeId.SIZEOF, b2ShapeId.ALIGNOF),
                __member(4)
        );

        TYPE = layout.offsetof(0);
        FILTER = layout.offsetof(1);
        AABB = layout.offsetof(2);
        ORIGIN = layout.offsetof(3);
        TRANSLATION = layout.offsetof(4);
        SHAPE = layout.offsetof(5);
        HIT_COUNT = layout.offsetof(6);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2RecQueryInfo(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2RecQueryInfo(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2RecQueryInfo(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code type} */
    public b2RecQueryType type() { return ntype(address()); }
    /** @return Returns the property {@code filter} */
    public b2QueryFilter filter() { return nfilter(address()); }
    /** @return Returns the property {@code aabb} */
    public b2AABB aabb() { return naabb(address()); }
    /** @return Returns the property {@code origin} */
    public b2Vec2 origin() { return norigin(address()); }
    /** @return Returns the property {@code translation} */
    public b2Vec2 translation() { return ntranslation(address()); }
    /** @return Returns the property {@code shape} */
    public b2ShapeId shape() { return nshape(address()); }
    /** @return Returns the property {@code hitCount} */
    public int hitCount() { return nhitCount(address()); }

    /**
     * Set the value of property {@code type}
     * 
     * @param value b2RecQueryType
     * @return b2RecQueryInfo
     */
    public b2RecQueryInfo type(b2RecQueryType value) {
        ntype(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code filter}
     * 
     * @param value b2QueryFilter
     * @return b2RecQueryInfo
     */
    public b2RecQueryInfo filter(b2QueryFilter value) {
        nfilter(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code aabb}
     * 
     * @param value b2AABB
     * @return b2RecQueryInfo
     */
    public b2RecQueryInfo aabb(b2AABB value) {
        naabb(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code origin}
     * 
     * @param value b2Vec2
     * @return b2RecQueryInfo
     */
    public b2RecQueryInfo origin(b2Vec2 value) {
        norigin(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code translation}
     * 
     * @param value b2Vec2
     * @return b2RecQueryInfo
     */
    public b2RecQueryInfo translation(b2Vec2 value) {
        ntranslation(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code shape}
     * 
     * @param value b2ShapeId
     * @return b2RecQueryInfo
     */
    public b2RecQueryInfo shape(b2ShapeId value) {
        nshape(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code hitCount}
     * 
     * @param value int
     * @return b2RecQueryInfo
     */
    public b2RecQueryInfo hitCount(int value) {
        nhitCount(address(), value);
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
    protected b2RecQueryInfo create(long address, Pointer ptr) {
        return ptr == null ? new b2RecQueryInfo(address) : new b2RecQueryInfo(ptr);
    }

    // -----------------------------------

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2RecQueryInfo
     */
    public static b2RecQueryInfo createSafe(Pointer ptr) {
        if (ptr == null) return null;
        return new b2RecQueryInfo(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2RecQueryInfo}.
     *
     * @param alloc Custom memory manager
     * @return b2RecQueryInfo
     */
    public static b2RecQueryInfo alloc(AllocFunc alloc) {
        return new b2RecQueryInfo(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2RecQueryInfo}.
     *
     * @return b2RecQueryInfo
     */
    public static b2RecQueryInfo malloc() {
        return new b2RecQueryInfo(nmalloc(SIZEOF));
    }

    // -----------------------------------
    
    public static b2RecQueryType ntype(long address) { return b2RecQueryType.valueOf(memGetInt(address + TYPE)); }
    public static b2QueryFilter nfilter(long address) { return b2QueryFilter.createSafe(() -> address + FILTER); }
    public static b2AABB naabb(long address) { return b2AABB.createSafe(() -> address + AABB); }
    public static b2Vec2 norigin(long address) { return b2Vec2.createSafe(() -> address + ORIGIN); }
    public static b2Vec2 ntranslation(long address) { return b2Vec2.createSafe(() -> address + TRANSLATION); }
    public static b2ShapeId nshape(long address) { return b2ShapeId.createSafe(() -> address + SHAPE); }
    public static int nhitCount(long address) { return memGetInt(address + HIT_COUNT); }

    public static void ntype(long address, b2RecQueryType value) { memPutInt(address + TYPE, value.value()); }
    public static void nfilter(long address, b2QueryFilter value) { nmemcpy(address + FILTER, value.address(), b2QueryFilter.SIZEOF); }
    public static void naabb(long address, b2AABB value) { nmemcpy(address + AABB, value.address(), b2AABB.SIZEOF); }
    public static void norigin(long address, b2Vec2 value) { nmemcpy(address + ORIGIN, value.address(), b2Vec2.SIZEOF); }
    public static void ntranslation(long address, b2Vec2 value) { nmemcpy(address + TRANSLATION, value.address(), b2Vec2.SIZEOF); }
    public static void nshape(long address, b2ShapeId value) { nmemcpy(address + SHAPE, value.address(), b2ShapeId.SIZEOF); }
    public static void nhitCount(long address, int value) { memPutInt(address + HIT_COUNT, value); }
    
    // -----------------------------------
}

