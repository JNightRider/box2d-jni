/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2JointId;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2JointId
 * {
 *     int32_t index1;
 *     uint16_t world0;
 *     uint16_t generation;
 * } b2JointId;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2JointId extends Struct<b2JointId> implements ConstB2JointId {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            INDEX1,
            WORLD0,
            GENERATION;

    static {
        Layout layout = __struct(
                __member(4),
                __member(2),
                __member(2)
        );

        INDEX1 = layout.offsetof(0);
        WORLD0 = layout.offsetof(1);
        GENERATION = layout.offsetof(2);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2JointId(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2JointId(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2JointId(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code index1} */
    @Override
    public Integer index1() { return nindex1(address()); }
    /** @return Returns the property {@code world0} */
    @Override
    public Short world0() { return nworld0(address()); }
    /** @return Returns the property {@code generation} */
    @Override
    public Short generation() { return ngeneration(address()); }

    /**
     * Set the value of property {@code index1}
     *
     * @param value The value
     * @return b2JointId
     */
    public b2JointId index1(int value) { nindex1(address(), value); return this; }
    /**
     * Set the value of property {@code world0}
     *
     * @param value The value
     * @return b2JointId
     */
    public b2JointId world0(short value) { nworld0(address(), value); return this; }
    /**
     * Set the value of property {@code generation}
     *
     * @param value The value
     * @return b2JointId
     */
    public b2JointId generation(short value) { ngeneration(address(), value); return this; }

    /*(non-Javadoc)
     */
    @Override
    public int sizeof() {
        return SIZEOF;
    }

    /*(non-Javadoc)
     */
    @Override
    protected b2JointId create(long address, Pointer ptr) {
        return ptr == null ? new b2JointId(address) : new b2JointId(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2JointId
     */
    private static b2JointId factory() {
        return new b2JointId(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2JointId
     */
    public static b2JointId createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2JointId(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2JointId}.
     *
     * @param alloc Custom memory manager
     * @return b2JointId
     */
    public static b2JointId alloc(AllocFunc alloc) {
        return new b2JointId(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2JointId}.
     *
     * @return b2JointId
     */
    public static b2JointId malloc() {
        return new b2JointId(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2JointId}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2JointId}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static int nindex1(long address) { return memGetInt(address + INDEX1); }
    public static short nworld0(long address) { return memGetShort(address + WORLD0); }
    public static short ngeneration(long address) { return memGetShort(address + GENERATION); }

    public static void nindex1(long address, int value) { memPutInt(address + INDEX1, value); }
    public static void nworld0(long address, short value) { memPutShort(address + WORLD0, value); }
    public static void ngeneration(long address, short value) { memPutShort(address + GENERATION, value); }
    
    // -----------------------------------

    /** An array of {@code b2JointId} structs. */
    public static class Buffer extends StructBuffer<b2JointId, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2JointId ELEMENT_FACTORY = b2JointId.factory();

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
        protected b2JointId getElementFactory() {
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


