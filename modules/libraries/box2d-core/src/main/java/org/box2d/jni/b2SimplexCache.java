/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni;

import java.nio.ByteBuffer;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2SimplexCache;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.MemoryUtil.*;

/**
 * <pre><code>
 * typedef struct b2SimplexCache
 * {
 *     /// The number of stored simplex points
 *     uint16_t count;
 *
 *     /// The cached simplex indices on shape A
 *     uint8_t indexA[3];
 *
 *     /// The cached simplex indices on shape B
 *     uint8_t indexB[3];
 * } b2SimplexCache;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2SimplexCache extends Struct<b2SimplexCache> implements ConstB2SimplexCache {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            COUNT,
            INDEX_A,
            INDEX_B;

    static {
        Layout layout = __struct(
                __member(2),
                __array(1, 3),
                __array(1, 3)
        );

        COUNT = layout.offsetof(0);
        INDEX_A = layout.offsetof(1);
        INDEX_B = layout.offsetof(2);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2SimplexCache(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2SimplexCache(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2SimplexCache(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code count} */
    @Override
    public short count() { return ncount(address()); }
    /** @return Returns the property {@code indexA} */
    @Override
    public ByteBuffer indexA() {  return nindexA(address()); }
    /** @return Returns the property {@code indexB} */
    @Override
    public ByteBuffer indexB() { return nindexB(address()); }

    /**
     * Set the value of property {@code count}
     *
     * @param value int
     * @return b2SimplexCache
     */
    public b2SimplexCache count(short value) {
        ncount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code indexA}
     *
     * @param value ByteBuffer
     * @return b2SimplexCache
     */
    public b2SimplexCache indexA(ByteBuffer value) {
        nindexA(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code indexB}
     *
     * @param value ByteBuffer
     * @return b2SimplexCache
     */
    public b2SimplexCache indexB(ByteBuffer value) {
        nindexB(address(), value);
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
    protected b2SimplexCache create(long address, Pointer ptr) {
        return ptr == null ? new b2SimplexCache(address) : new b2SimplexCache(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2SimplexCache
     */
    private static b2SimplexCache factory() {
        return new b2SimplexCache(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2SimplexCache
     */
    public static b2SimplexCache createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2SimplexCache(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2SimplexCache}.
     *
     * @param alloc Custom memory manager
     * @return b2SimplexCache
     */
    public static b2SimplexCache alloc(AllocFunc alloc) {
        return new b2SimplexCache(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2SimplexCache}.
     *
     * @return b2SimplexCache
     */
    public static b2SimplexCache malloc() {
        return new b2SimplexCache(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2SimplexCache}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2SimplexCache}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------
    
    public static short ncount(long address) { return memGetShort(address + COUNT); }
    public static ByteBuffer nindexA(long address) { return memByteBuffer(address + INDEX_A, 3); }
    public static ByteBuffer nindexB(long address) { return memByteBuffer(address + INDEX_B, 3); }

    public static void ncount(long address, short value) { memPutShort(address + COUNT, value); }
    public static void nindexA(long address, ByteBuffer value) { nmemcpy(address + INDEX_A, memGetNativeAddress(value), 3); }
    public static void nindexB(long address, ByteBuffer value) { nmemcpy(address + INDEX_B, memGetNativeAddress(value), 3); }
    
    // -----------------------------------

    /** An array of {@code b2SimplexCache} structs. */
    public static class Buffer extends StructBuffer<b2SimplexCache, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2SimplexCache ELEMENT_FACTORY = b2SimplexCache.factory();

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
        protected b2SimplexCache getElementFactory() {
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
