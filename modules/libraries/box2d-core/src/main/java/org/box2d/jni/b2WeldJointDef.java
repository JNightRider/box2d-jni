/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2WeldJointDef;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2WeldJointDef
 * {
 *     b2JointDef base;
 *     float linearHertz;
 *     float angularHertz;
 *     float linearDampingRatio;
 *     float angularDampingRatio;
 *     int internalValue;
 * } b2WeldJointDef;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2WeldJointDef extends Struct<b2WeldJointDef> implements ConstB2WeldJointDef {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            BASE,
            LINEAR_HERTZ,
            ANGULAR_HERTZ,
            LINEAR_DAMPING_RATIO,
            ANGULAR_DAMPING_RATIO,
            INTERNAL_VALUE;

    static {
        Layout layout = __struct(
                __member(b2JointDef.SIZEOF, b2JointDef.ALIGNOF),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4)
        );

        BASE = layout.offsetof(0);
        LINEAR_HERTZ = layout.offsetof(1);
        ANGULAR_HERTZ = layout.offsetof(2);
        LINEAR_DAMPING_RATIO = layout.offsetof(3);
        ANGULAR_DAMPING_RATIO = layout.offsetof(4);
        INTERNAL_VALUE = layout.offsetof(5);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2WeldJointDef(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2WeldJointDef(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2WeldJointDef(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code base} */
    @Override
    public b2JointDef base() { return nbase(address()); }
    /** @return Returns the property {@code linearHertz} */
    @Override
    public float linearHertz() { return nlinearHertz(address()); }
    /** @return Returns the property {@code angularHertz} */
    @Override
    public float angularHertz() { return nangularHertz(address()); }
    /** @return Returns the property {@code linearDampingRatio} */
    @Override
    public float linearDampingRatio() { return nlinearDampingRatio(address()); }
    /** @return Returns the property {@code angularDampingRatio} */
    @Override
    public float angularDampingRatio() { return nangularDampingRatio(address()); }
    /** @return Returns the property {@code internalValue} */
    @Override
    public int internalValue() { return ninternalValue(address()); }

    /**
     * Set the value of property {@code base}
     *
     * @param value b2JointDef
     * @return b2WeldJointDef
     */
    public b2WeldJointDef base(b2JointDef value) {
        nbase(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code linearHertz}
     *
     * @param value float
     * @return b2WeldJointDef
     */
    public b2WeldJointDef linearHertz(float value) {
        nlinearHertz(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code angularHertz}
     *
     * @param value float
     * @return b2WeldJointDef
     */
    public b2WeldJointDef angularHertz(float value) {
        nangularHertz(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code linearDampingRatio}
     *
     * @param value float
     * @return b2WeldJointDef
     */
    public b2WeldJointDef linearDampingRatio(float value) {
        nlinearDampingRatio(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code angularDampingRatio}
     *
     * @param value float
     * @return b2WeldJointDef
     */
    public b2WeldJointDef angularDampingRatio(float value) {
        nangularDampingRatio(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code internalValue}
     *
     * @param value int
     * @return b2WeldJointDef
     */
    public b2WeldJointDef internalValue(int value) {
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
    protected b2WeldJointDef create(long address, Pointer ptr) {
        return ptr == null ? new b2WeldJointDef(address) : new b2WeldJointDef(ptr);
    }
    
        // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2WeldJointDef
     */
    private static b2WeldJointDef factory() {
        return new b2WeldJointDef(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2WeldJointDef
     */
    public static b2WeldJointDef createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2WeldJointDef(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2WeldJointDef}.
     *
     * @param alloc Custom memory manager
     * @return b2WeldJointDef
     */
    public static b2WeldJointDef alloc(AllocFunc alloc) {
        return new b2WeldJointDef(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2WeldJointDef}.
     *
     * @return b2WeldJointDef
     */
    public static b2WeldJointDef malloc() {
        return new b2WeldJointDef(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2WeldJointDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2WeldJointDef}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static b2JointDef nbase(long address)                    { return b2JointDef.createSafe(() -> address + BASE);                  }
    public static float nlinearHertz(long address)                  { return memGetFloat(address + LINEAR_HERTZ);                          }
    public static float nangularHertz(long address)                 { return memGetFloat(address + ANGULAR_HERTZ);                         }
    public static float nlinearDampingRatio(long address)           { return memGetFloat(address + LINEAR_DAMPING_RATIO);                  }
    public static float nangularDampingRatio(long address)          { return memGetFloat(address + ANGULAR_DAMPING_RATIO);                 }
    public static int ninternalValue(long address)                  { return memGetInt(address + INTERNAL_VALUE);                          }

    public static void nbase(long address, b2JointDef value)              { nmemcpy(address + BASE, value.address(), b2JointDef.SIZEOF); }
    public static void nlinearHertz(long address, float value)            { memPutFloat(address + LINEAR_HERTZ, value);                 }
    public static void nangularHertz(long address, float value)           { memPutFloat(address + ANGULAR_HERTZ, value);                }
    public static void nlinearDampingRatio(long address, float value)     { memPutFloat(address + LINEAR_DAMPING_RATIO, value);         }
    public static void nangularDampingRatio(long address, float value)    { memPutFloat(address + ANGULAR_DAMPING_RATIO, value);        }
    public static void ninternalValue(long address, int value)            { memPutInt(address + INTERNAL_VALUE, value);                 }

    // -----------------------------------

    /** An array of {@code b2WeldJointDef} structs. */
    public static class Buffer extends StructBuffer<b2WeldJointDef, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2WeldJointDef ELEMENT_FACTORY = b2WeldJointDef.factory();

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
        protected b2WeldJointDef getElementFactory() {
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
