/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2CollisionPlane;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2CollisionPlane
 * {
 *     b2Plane plane;
 *     float pushLimit;
 *     float push;
 *     bool clipVelocity;
 * } b2CollisionPlane;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2CollisionPlane extends Struct<b2CollisionPlane> implements ConstB2CollisionPlane {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            PLANE,
            PUSH_LIMIT,
            PUSH,
            CLIP_VELOCITY;

    static {
        Layout layout = __struct(
                __member(b2Plane.SIZEOF, b2Plane.ALIGNOF),
                __member(4),
                __member(4),
                __member(1)
        );

        PLANE = layout.offsetof(0);
        PUSH_LIMIT = layout.offsetof(1);
        PUSH = layout.offsetof(2);
        CLIP_VELOCITY = layout.offsetof(3);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2CollisionPlane(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2CollisionPlane(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2CollisionPlane(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code plane} */
    @Override
    public b2Plane plane() { return nplane(address()); }
    /** @return Returns the property {@code pushLimit} */
    @Override
    public float pushLimit() { return npushLimit(address()); }
    /** @return Returns the property {@code push} */
    @Override
    public float push() { return npush(address()); }
    /** @return Returns the property {@code clipVelocity} */
    @Override
    public boolean clipVelocity() { return nclipVelocity(address()); }

    /**
     * Set the value of property {@code plane}
     *
     * @param value b2Plane
     * @return b2CollisionPlane
     */
    public b2CollisionPlane plane(b2Plane value) {
        nplane(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code pushLimit}
     *
     * @param value float
     * @return b2CollisionPlane
     */
    public b2CollisionPlane pushLimit(float value) {
        npushLimit(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code push}
     *
     * @param value float
     * @return b2CollisionPlane
     */
    public b2CollisionPlane push(float value) {
        npush(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code clipVelocity}
     *
     * @param value boolean
     * @return b2CollisionPlane
     */
    public b2CollisionPlane clipVelocity(boolean value) {
        nclipVelocity(address(), value);
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
    protected b2CollisionPlane create(long address, Pointer ptr) {
        return ptr == null ? new b2CollisionPlane(address) : new b2CollisionPlane(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2CollisionPlane
     */
    private static b2CollisionPlane factory() {
        return new b2CollisionPlane(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2CollisionPlane
     */
    public static b2CollisionPlane createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2CollisionPlane(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2CollisionPlane}.
     *
     * @param alloc Custom memory manager
     * @return b2CollisionPlane
     */
    public static b2CollisionPlane alloc(AllocFunc alloc) {
        return new b2CollisionPlane(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2CollisionPlane}.
     *
     * @return b2CollisionPlane
     */
    public static b2CollisionPlane malloc() {
        return new b2CollisionPlane(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2CollisionPlane}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2CollisionPlane}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }
    
        // -----------------------------------
    
    public static b2Plane nplane(long address) { return b2Plane.createSafe(() -> address + PLANE); }
    public static float npushLimit(long address) { return memGetFloat(address + PUSH_LIMIT); }
    public static float npush(long address) { return memGetFloat(address + PUSH); }
    public static boolean nclipVelocity(long address) { return memGetByte(address + CLIP_VELOCITY) != 0; }

    public static void nplane(long address, b2Plane value) { nmemcpy(address + PLANE, value.address(), b2Plane.SIZEOF); }
    public static void npushLimit(long address, float value) { memPutFloat(address + PUSH_LIMIT, value); }
    public static void npush(long address, float value) { memPutFloat(address + PUSH, value); }
    public static void nclipVelocity(long address, boolean value) { memPutByte(address + CLIP_VELOCITY, (byte) (value ? 1 : 0)); }
    
    // -----------------------------------

    /** An array of {@code b2CollisionPlane} structs. */
    public static class Buffer extends StructBuffer<b2CollisionPlane, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2CollisionPlane ELEMENT_FACTORY = b2CollisionPlane.factory();

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
        protected b2CollisionPlane getElementFactory() {
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
