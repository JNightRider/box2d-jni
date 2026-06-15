/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2WheelJointDef;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2WheelJointDef
 * {
 *     b2JointDef base;
 *     bool enableSpring;
 *     float hertz;
 *     float dampingRatio;
 *     bool enableLimit;
 *     float lowerTranslation;
 *     float upperTranslation;
 *     bool enableMotor;
 *     float maxMotorTorque;
 *     float motorSpeed;
 *     int internalValue;
 * } b2WheelJointDef;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2WheelJointDef extends Struct<b2WheelJointDef> implements ConstB2WheelJointDef {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            BASE,
            ENABLE_SPRING,
            HERTZ,
            DAMPING_RATIO,
            ENABLE_LIMIT,
            LOWER_TRANSLATION,
            UPPER_TRANSLATION,
            ENABLE_MOTOR,
            MAX_MOTOR_TORQUE,
            MOTOR_SPEED,
            INTERNAL_VALUE;

    static {
        Layout layout = __struct(
                __member(b2JointDef.SIZEOF, b2JointDef.ALIGNOF),
                __member(1),
                __member(4),
                __member(4),
                __member(1),
                __member(4),
                __member(4),
                __member(1),
                __member(4),
                __member(4),
                __member(4)
        );

        BASE = layout.offsetof(0);
        ENABLE_SPRING = layout.offsetof(1);
        HERTZ = layout.offsetof(2);
        DAMPING_RATIO = layout.offsetof(3);
        ENABLE_LIMIT = layout.offsetof(4);
        LOWER_TRANSLATION = layout.offsetof(5);
        UPPER_TRANSLATION = layout.offsetof(6);
        ENABLE_MOTOR = layout.offsetof(7);
        MAX_MOTOR_TORQUE = layout.offsetof(8);
        MOTOR_SPEED = layout.offsetof(9);
        INTERNAL_VALUE = layout.offsetof(10);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2WheelJointDef(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2WheelJointDef(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2WheelJointDef(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code base} */
    @Override
    public b2JointDef base() { return nbase(address()); }
    /** @return Returns the property {@code enableSpring} */
    @Override
    public boolean enableSpring() { return nenableSpring(address()); }
    /** @return Returns the property {@code hertz} */
    @Override
    public float hertz() { return nhertz(address()); }
    /** @return Returns the property {@code dampingRatio} */
    @Override
    public float dampingRatio() { return ndampingRatio(address()); }
    /** @return Returns the property {@code enableLimit} */
    @Override
    public boolean enableLimit() { return nenableLimit(address()); }
    /** @return Returns the property {@code lowerTranslation} */
    @Override
    public float lowerTranslation() { return nlowerTranslation(address()); }
    /** @return Returns the property {@code upperTranslation} */
    @Override
    public float upperTranslation() { return nupperTranslation(address()); }
    /** @return Returns the property {@code enableMotor} */
    @Override
    public boolean enableMotor() { return nenableMotor(address()); }
    /** @return Returns the property {@code maxMotorTorque} */
    @Override
    public float maxMotorTorque() { return nmaxMotorTorque(address()); }
    /** @return Returns the property {@code motorSpeed} */
    @Override
    public float motorSpeed() { return nmotorSpeed(address()); }
    /** @return Returns the property {@code internalValue} */
    @Override
    public int internalValue() { return ninternalValue(address()); }

    /**
     * Set the value of property {@code base}
     *
     * @param value b2JointDef
     * @return b2WheelJointDef
     */
    public b2WheelJointDef base(b2JointDef value) {
        nbase(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code enableSpring}
     *
     * @param value boolean
     * @return b2WheelJointDef
     */
    public b2WheelJointDef enableSpring(boolean value) {
        nenableSpring(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code hertz}
     *
     * @param value float
     * @return b2WheelJointDef
     */
    public b2WheelJointDef hertz(float value) {
        nhertz(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code dampingRatio}
     *
     * @param value float
     * @return b2WheelJointDef
     */
    public b2WheelJointDef dampingRatio(float value) {
        ndampingRatio(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code enableLimit}
     *
     * @param value boolean
     * @return b2WheelJointDef
     */
    public b2WheelJointDef enableLimit(boolean value) {
        nenableLimit(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code lowerTranslation}
     *
     * @param value float
     * @return b2WheelJointDef
     */
    public b2WheelJointDef lowerTranslation(float value) {
        nlowerTranslation(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code upperTranslation}
     *
     * @param value float
     * @return b2WheelJointDef
     */
    public b2WheelJointDef upperTranslation(float value) {
        nupperTranslation(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code enableMotor}
     *
     * @param value boolean
     * @return b2WheelJointDef
     */
    public b2WheelJointDef enableMotor(boolean value) {
        nenableMotor(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code maxMotorTorque}
     *
     * @param value float
     * @return b2WheelJointDef
     */
    public b2WheelJointDef maxMotorTorque(float value) {
        nmaxMotorTorque(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code motorSpeed}
     *
     * @param value float
     * @return b2WheelJointDef
     */
    public b2WheelJointDef motorSpeed(float value) {
        nmotorSpeed(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code internalValue}
     *
     * @param value int
     * @return b2WheelJointDef
     */
    public b2WheelJointDef internalValue(int value) {
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
    protected b2WheelJointDef create(long address, Pointer ptr) {
        return ptr == null ? new b2WheelJointDef(address) : new b2WheelJointDef(ptr);
    }
    
        // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2WheelJointDef
     */
    private static b2WheelJointDef factory() {
        return new b2WheelJointDef(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2WheelJointDef
     */
    public static b2WheelJointDef createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2WheelJointDef(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2WheelJointDef}.
     *
     * @param alloc Custom memory manager
     * @return b2WheelJointDef
     */
    public static b2WheelJointDef alloc(AllocFunc alloc) {
        return new b2WheelJointDef(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2WheelJointDef}.
     *
     * @return b2WheelJointDef
     */
    public static b2WheelJointDef malloc() {
        return new b2WheelJointDef(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2WheelJointDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2WheelJointDef}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------
    
    public static b2JointDef nbase(long address)        { return b2JointDef.createSafe(() -> address + BASE); }
    public static boolean nenableSpring(long address)   { return memGetByte(address + ENABLE_SPRING) != 0; }
    public static float nhertz(long address)            { return memGetFloat(address + HERTZ); }
    public static float ndampingRatio(long address)     { return memGetFloat(address + DAMPING_RATIO); }
    public static boolean nenableLimit(long address)    { return memGetByte(address + ENABLE_LIMIT) != 0; }
    public static float nlowerTranslation(long address) { return memGetFloat(address + LOWER_TRANSLATION); }
    public static float nupperTranslation(long address) { return memGetFloat(address + UPPER_TRANSLATION); }
    public static boolean nenableMotor(long address)    { return memGetByte(address + ENABLE_MOTOR) != 0; }
    public static float nmaxMotorTorque(long address)   { return memGetFloat(address + MAX_MOTOR_TORQUE); }
    public static float nmotorSpeed(long address)       { return memGetFloat(address + MOTOR_SPEED); }
    public static int ninternalValue(long address)      { return memGetInt(address + INTERNAL_VALUE); }

    public static void nbase(long address, b2JointDef value)        { nmemcpy(address + BASE, value.address(), b2JointDef.SIZEOF);}
    public static void nenableSpring(long address, boolean value)   { memPutByte(address + ENABLE_SPRING, (byte) (value ? 1 : 0));}
    public static void nhertz(long address, float value)            { memPutFloat(address + HERTZ, value);}
    public static void ndampingRatio(long address, float value)     { memPutFloat(address + DAMPING_RATIO, value);}
    public static void nenableLimit(long address, boolean value)    { memPutByte(address + ENABLE_LIMIT, (byte) (value ? 1 : 0));}
    public static void nlowerTranslation(long address, float value) { memPutFloat(address + LOWER_TRANSLATION, value);}
    public static void nupperTranslation(long address, float value) { memPutFloat(address + UPPER_TRANSLATION, value);}
    public static void nenableMotor(long address, boolean value)    { memPutByte(address + ENABLE_MOTOR, (byte) (value ? 1 : 0));}
    public static void nmaxMotorTorque(long address, float value)   { memPutFloat(address + MAX_MOTOR_TORQUE, value);}
    public static void nmotorSpeed(long address, float value)   { memPutFloat(address + MOTOR_SPEED, value);}
    public static void ninternalValue(long address, int value)  { memPutInt(address + INTERNAL_VALUE, value);}
    // -----------------------------------

    /** An array of {@code b2WheelJointDef} structs. */
    public static class Buffer extends StructBuffer<b2WheelJointDef, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2WheelJointDef ELEMENT_FACTORY = b2WheelJointDef.factory();

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
        protected b2WheelJointDef getElementFactory() {
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
