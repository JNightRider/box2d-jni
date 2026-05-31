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
 * typedef struct b2FilterJointDef
 * {
 * 	/// Base joint definition
 * 	b2JointDef base;
 *
 * 	/// Used internally to detect a valid definition. DO NOT SET.
 * 	int internalValue;
 * } b2FilterJointDef;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2FilterJointDef extends Struct<b2FilterJointDef> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            BASE,
            INTERNAL_VALUE;

    static {
        Layout layout = __struct(
                __member(b2JointDef.SIZEOF, b2JointDef.ALIGNOF),
                __member(4)
        );

        BASE = layout.offsetof(0);
        INTERNAL_VALUE = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2FilterJointDef(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2FilterJointDef(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2FilterJointDef(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code base} */
    public b2JointDef base() { return nbase(address()); }
    /** @return Returns the property {@code internalValue} */
    public int internalValue() { return ninternalValue(address()); }

    /**
     * Set the value of property {@code base}
     *
     * @param value b2JointDef
     * @return b2FilterJointDef
     */
    public b2FilterJointDef base(b2JointDef value) {
        nbase(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code internalValue}
     *
     * @param value int
     * @return b2FilterJointDef
     */
    public b2FilterJointDef internalValue(int value) {
        ninternalValue(address(), value);
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
    protected b2FilterJointDef create(long address, Pointer ptr) {
        return ptr == null ? new b2FilterJointDef(address) : new b2FilterJointDef(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2FilterJointDef
     */
    private static b2FilterJointDef factory() {
        return new b2FilterJointDef(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2FilterJointDef
     */
    public static b2FilterJointDef createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2FilterJointDef(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2FilterJointDef}.
     *
     * @param alloc Custom memory manager
     * @return b2FilterJointDef
     */
    public static b2FilterJointDef alloc(AllocFunc alloc) {
        return new b2FilterJointDef(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2FilterJointDef}.
     *
     * @return b2FilterJointDef
     */
    public static b2FilterJointDef malloc() {
        return new b2FilterJointDef(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2FilterJointDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2FilterJointDef}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static b2JointDef nbase(long address) { return b2JointDef.createSafe(() -> address + BASE); }
    public static int ninternalValue(long address) { return memGetInt(address + INTERNAL_VALUE); }

    public static void nbase(long address, b2JointDef value) { nmemcpy(address + BASE, value.address(), b2JointDef.SIZEOF); }
    public static void ninternalValue(long address, int value) { memPutInt(address + INTERNAL_VALUE, value); }

    // -----------------------------------

    /** An array of {@code b2FilterJointDef} structs. */
    public static class Buffer extends StructBuffer<b2FilterJointDef, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2FilterJointDef ELEMENT_FACTORY = b2FilterJointDef.factory();

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
        protected b2FilterJointDef getElementFactory() {
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
