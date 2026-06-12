/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2MassData
 * {
 *     float mass;
 *     b2Vec2 center;
 *     float rotationalInertia;
 * } b2MassData;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2MassData extends Struct<b2MassData> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            MASS,
            CENTER,
            ROTATIONAL_INERTIA;

    static {
        Layout layout = __struct(
                __member(4),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4)
        );

        MASS = layout.offsetof(0);
        CENTER = layout.offsetof(1);
        ROTATIONAL_INERTIA = layout.offsetof(2);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2MassData(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2MassData(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2MassData(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code mass} */
    public float mass() { return nmass(address()); }
    /** @return Returns the property {@code center} */
    public b2Vec2 center() { return ncenter(address()); }
    /** @return Returns the property {@code rotationalInertia} */
    public float rotationalInertia() { return nrotationalInertia(address()); }

    /**
     * Set the value of property {@code mass}
     * 
     * @param value float
     * @return b2MassData
     */
    public b2MassData mass(float value) {
        nmass(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code center}
     * 
     * @param value b2Vec2
     * @return b2MassData
     */
    public b2MassData center(b2Vec2 value) {
        ncenter(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code rotationalInertia}
     * 
     * @param value float
     * @return b2MassData
     */
    public b2MassData rotationalInertia(float value) {
        nrotationalInertia(address(), value);
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
    protected b2MassData create(long address, Pointer ptr) {
        return ptr == null ? new b2MassData(address) : new b2MassData(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2MassData
     */
    private static b2MassData factory() {
        return new b2MassData(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2MassData
     */
    public static b2MassData createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2MassData(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2MassData}.
     *
     * @param alloc Custom memory manager
     * @return b2MassData
     */
    public static b2MassData alloc(AllocFunc alloc) {
        return new b2MassData(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2MassData}.
     *
     * @return b2MassData
     */
    public static b2MassData malloc() {
        return new b2MassData(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2MassData}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2MassData}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static float nmass(long address)                    { return memGetFloat(address + MASS);                          }
    public static b2Vec2 ncenter(long address)                 { return b2Vec2.createSafe(() -> address + CENTER);            }
    public static float nrotationalInertia(long address)       { return memGetFloat(address + ROTATIONAL_INERTIA);            }

    public static void nmass(long address, float value)                  { memPutFloat(address + MASS, value);                              }
    public static void ncenter(long address, b2Vec2 value)               { nmemcpy(address + CENTER, value.address(), b2Vec2.SIZEOF); }
    public static void nrotationalInertia(long address, float value)     { memPutFloat(address + ROTATIONAL_INERTIA, value);                }

    // -----------------------------------

    /** An array of {@code b2MassData} structs. */
    public static class Buffer extends StructBuffer<b2MassData, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2MassData ELEMENT_FACTORY = b2MassData.factory();

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
        protected b2MassData getElementFactory() {
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
