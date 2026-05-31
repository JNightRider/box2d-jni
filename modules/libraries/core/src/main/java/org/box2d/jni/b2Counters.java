/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni;

import java.nio.IntBuffer;
import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.MemoryUtil.*;

/**
 * <pre><code>
 * typedef struct b2Counters
 * {
 *     int bodyCount;
 *     int shapeCount;
 *     int contactCount;
 *     int jointCount;
 *     int islandCount;
 *     int stackUsed;
 *     int staticTreeHeight;
 *     int treeHeight;
 *     int byteCount;
 *     int taskCount;
 *     int colorCounts[24];
 *     int awakeContactCount;
 *     int recycledContactCount;
 * } b2Counters;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Counters extends Struct<b2Counters> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            BODY_COUNT,
            SHAPE_COUNT,
            CONTACT_COUNT,
            JOINT_COUNT,
            ISLAND_COUNT,
            STACK_USED,
            STATIC_TREE_HEIGHT,
            TREE_HEIGHT,
            BYTE_COUNT,
            TASK_COUNT,
            COLOR_COUNTS,
            AWAKE_CONTACT_COUNT,
            RECYCLED_CONTACT_COUNT;

    static {
        Layout layout = __struct(
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __array(4, 24),
                __member(4),
                __member(4)
        );

        BODY_COUNT = layout.offsetof(0);
        SHAPE_COUNT = layout.offsetof(1);
        CONTACT_COUNT = layout.offsetof(2);
        JOINT_COUNT = layout.offsetof(3);
        ISLAND_COUNT = layout.offsetof(4);
        STACK_USED = layout.offsetof(5);
        STATIC_TREE_HEIGHT = layout.offsetof(6);
        TREE_HEIGHT = layout.offsetof(7);
        BYTE_COUNT = layout.offsetof(8);
        TASK_COUNT = layout.offsetof(9);
        COLOR_COUNTS = layout.offsetof(10);
        AWAKE_CONTACT_COUNT = layout.offsetof(11);
        RECYCLED_CONTACT_COUNT = layout.offsetof(12);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Counters(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Counters(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2Counters(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code bodyCount} */
    public int bodyCount() { return nbodyCount(address()); }
    /** @return Returns the property {@code shapeCount} */
    public int shapeCount() { return nshapeCount(address()); }
    /** @return Returns the property {@code contactCount} */
    public int contactCount() { return ncontactCount(address()); }
    /** @return Returns the property {@code jointCount} */
    public int jointCount() { return njointCount(address()); }
    /** @return Returns the property {@code islandCount} */
    public int islandCount() { return nislandCount(address()); }
    /** @return Returns the property {@code stackUsed} */
    public int stackUsed() { return nstackUsed(address()); }
    /** @return Returns the property {@code staticTreeHeight} */
    public int staticTreeHeight() { return nstaticTreeHeight(address()); }
    /** @return Returns the property {@code treeHeight} */
    public int treeHeight() { return ntreeHeight(address()); }
    /** @return Returns the property {@code byteCount} */
    public int byteCount() { return nbyteCount(address()); }
    /** @return Returns the property {@code taskCount} */
    public int taskCount() { return ntaskCount(address()); }
    /** @return Returns the property {@code colorCounts} */
    public IntBuffer colorCounts() { return ncolorCounts(address()); }
    /** @return Returns the property {@code awakeContactCount} */
    public int awakeContactCount() { return nawakeContactCount(address()); }
    /** @return Returns the property {@code recycledContactCount} */
    public int recycledContactCount() { return nrecycledContactCount(address()); }

    /**
     * Set the value of property {@code bodyCount}
     *
     * @param value int
     * @return b2Counters
     */
    public b2Counters bodyCount(int value) {
        nbodyCount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code shapeCount}
     *
     * @param value int
     * @return b2Counters
     */
    public b2Counters shapeCount(int value) {
        nshapeCount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code contactCount}
     *
     * @param value int
     * @return b2Counters
     */
    public b2Counters contactCount(int value) {
        ncontactCount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code jointCount}
     *
     * @param value int
     * @return b2Counters
     */
    public b2Counters jointCount(int value) {
        njointCount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code islandCount}
     *
     * @param value int
     * @return b2Counters
     */
    public b2Counters islandCount(int value) {
        nislandCount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code stackUsed}
     *
     * @param value int
     * @return b2Counters
     */
    public b2Counters stackUsed(int value) {
        nstackUsed(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code staticTreeHeight}
     *
     * @param value int
     * @return b2Counters
     */
    public b2Counters staticTreeHeight(int value) {
        nstaticTreeHeight(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code treeHeight}
     *
     * @param value int
     * @return b2Counters
     */
    public b2Counters treeHeight(int value) {
        ntreeHeight(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code byteCount}
     *
     * @param value int
     * @return b2Counters
     */
    public b2Counters byteCount(int value) {
        nbyteCount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code taskCount}
     *
     * @param value int
     * @return b2Counters
     */
    public b2Counters taskCount(int value) {
        ntaskCount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code colorCounts}
     *
     * @param value int
     * @return b2Counters
     */
    public b2Counters colorCounts(IntBuffer value) {
        ncolorCounts(address(), value);
        return this;
    }
    
    /**
     * Set the value of property {@code awakeContactCount}
     *
     * @param value int
     * @return b2Counters
     */
    public b2Counters awakeContactCount(int value) {
        nawakeContactCount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code recycledContactCount}
     *
     * @param value int
     * @return b2Counters
     */
    public b2Counters recycledContactCount(int value) {
        nrecycledContactCount(address(), value);
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
    protected b2Counters create(long address, Pointer ptr) {
        return ptr == null ? new b2Counters(address) : new b2Counters(ptr);
    }
    
        // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2Counters
     */
    private static b2Counters factory() {
        return new b2Counters(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Counters
     */
    public static b2Counters createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Counters(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Counters}.
     *
     * @param alloc Custom memory manager
     * @return b2Counters
     */
    public static b2Counters alloc(AllocFunc alloc) {
        return new b2Counters(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2Counters}.
     *
     * @return b2Counters
     */
    public static b2Counters malloc() {
        return new b2Counters(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Counters}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Counters}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static int nbodyCount(long address)            { return memGetInt(address + BODY_COUNT); }
    public static int nshapeCount(long address)           { return memGetInt(address + SHAPE_COUNT); }
    public static int ncontactCount(long address)         { return memGetInt(address + CONTACT_COUNT); }
    public static int njointCount(long address)           { return memGetInt(address + JOINT_COUNT); }
    public static int nislandCount(long address)          { return memGetInt(address + ISLAND_COUNT); }
    public static int nstackUsed(long address)            { return memGetInt(address + STACK_USED); }
    public static int nstaticTreeHeight(long address)     { return memGetInt(address + STATIC_TREE_HEIGHT); }
    public static int ntreeHeight(long address)           { return memGetInt(address + TREE_HEIGHT); }
    public static int nbyteCount(long address)            { return memGetInt(address + BYTE_COUNT); }
    public static int ntaskCount(long address)            { return memGetInt(address + TASK_COUNT); }
    public static IntBuffer ncolorCounts(long address)    { return memIntBuffer(address + COLOR_COUNTS, 24); }
    public static int nawakeContactCount(long address)    { return memGetInt(address + AWAKE_CONTACT_COUNT); }
    public static int nrecycledContactCount(long address) { return memGetInt(address + RECYCLED_CONTACT_COUNT); }

    public static void nbodyCount(long address, int value) { memPutInt(address + BODY_COUNT, value); }
    public static void nshapeCount(long address, int value) {  memPutInt(address + SHAPE_COUNT, value); }
    public static void ncontactCount(long address, int value) { memPutInt(address + CONTACT_COUNT, value); }
    public static void njointCount(long address, int value) { memPutInt(address + JOINT_COUNT, value); }
    public static void nislandCount(long address, int value) { memPutInt(address + ISLAND_COUNT, value); }
    public static void nstackUsed(long address, int value) { memPutInt(address + STACK_USED, value); }
    public static void nstaticTreeHeight(long address, int value) { memPutInt(address + STATIC_TREE_HEIGHT, value); }
    public static void ntreeHeight(long address, int value) { memPutInt(address + TREE_HEIGHT, value); }
    public static void nbyteCount(long address, int value) { memPutInt(address + BYTE_COUNT, value); }
    public static void ntaskCount(long address, int value) { memPutInt(address + TASK_COUNT, value); }
    public static void ncolorCounts(long address, IntBuffer value) { nmemcpy(address + COLOR_COUNTS, memGetNativeAddress(value), 24 * 4); }
    public static void nawakeContactCount(long address, int value) { memPutInt(address + AWAKE_CONTACT_COUNT, value); }
    public static void nrecycledContactCount(long address, int value) { memPutInt(address + RECYCLED_CONTACT_COUNT, value); }

    // -----------------------------------

    /** An array of {@code b2Counters} structs. */
    public static class Buffer extends StructBuffer<b2Counters, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2Counters ELEMENT_FACTORY = b2Counters.factory();

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
        protected b2Counters getElementFactory() {
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
