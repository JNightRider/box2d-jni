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
 * typedef struct b2PrismaticJointDef
 * {
 *     b2JointDef base;
 *     bool enableSpring;
 *     float hertz;
 *     float dampingRatio;
 *     float targetTranslation;
 *     bool enableLimit;
 *     float lowerTranslation;
 *     float upperTranslation;
 *     bool enableMotor;
 *     float maxMotorForce;
 *     float motorSpeed;
 *     int internalValue;
 * } b2PrismaticJointDef;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2PrismaticJointDef extends Struct<b2PrismaticJointDef> {

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
            TARGET_TRANSLATION,
            ENABLE_LIMIT,
            LOWER_TRANSLATION,
            UPPER_TRANSLATION,
            ENABLE_MOTOR,
            MAX_MOTOR_FORCE,
            MOTOR_SPEED,
            INTERNAL_VALUE;

    static {
        Layout layout = __struct(
                __member(b2JointDef.SIZEOF, b2JointDef.ALIGNOF),
                __member(1),
                __member(4),
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
        TARGET_TRANSLATION = layout.offsetof(4);
        ENABLE_LIMIT = layout.offsetof(5);
        LOWER_TRANSLATION = layout.offsetof(6);
        UPPER_TRANSLATION = layout.offsetof(7);
        ENABLE_MOTOR = layout.offsetof(8);
        MAX_MOTOR_FORCE = layout.offsetof(9);
        MOTOR_SPEED = layout.offsetof(10);
        INTERNAL_VALUE = layout.offsetof(11);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2PrismaticJointDef(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2PrismaticJointDef(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2PrismaticJointDef(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code base} */
    public b2JointDef base() { return nbase(address()); }
    /** @return Returns the property {@code enableSpring} */
    public boolean enableSpring() { return nenableSpring(address()); }
    /** @return Returns the property {@code hertz} */
    public float hertz() { return nhertz(address()); }
    /** @return Returns the property {@code dampingRatio} */
    public float dampingRatio() { return ndampingRatio(address()); }
    /** @return Returns the property {@code targetTranslation} */
    public float targetTranslation() { return ntargetTranslation(address()); }
    /** @return Returns the property {@code enableLimit} */
    public boolean enableLimit() { return nenableLimit(address()); }
    /** @return Returns the property {@code lowerTranslation} */
    public float lowerTranslation() { return nlowerTranslation(address()); }
    /** @return Returns the property {@code upperTranslation} */
    public float upperTranslation() { return nupperTranslation(address()); }
    /** @return Returns the property {@code enableMotor} */
    public boolean enableMotor() { return nenableMotor(address()); }
    /** @return Returns the property {@code maxMotorForce} */
    public float maxMotorForce() { return nmaxMotorForce(address()); }
    /** @return Returns the property {@code motorSpeed} */
    public float motorSpeed() { return nmotorSpeed(address()); }
    /** @return Returns the property {@code internalValue} */
    public int internalValue() { return ninternalValue(address()); }

    /**
     * Set the value of property {@code base}
     *
     * @param value b2JointDef
     * @return b2PrismaticJointDef
     */
    public b2PrismaticJointDef base(b2JointDef value) {
        nbase(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code enableSpring}
     *
     * @param value boolean
     * @return b2PrismaticJointDef
     */
    public b2PrismaticJointDef enableSpring(boolean value) {
        nenableSpring(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code hertz}
     *
     * @param value float
     * @return b2PrismaticJointDef
     */
    public b2PrismaticJointDef hertz(float value) {
        nhertz(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code dampingRatio}
     *
     * @param value float
     * @return b2PrismaticJointDef
     */
    public b2PrismaticJointDef dampingRatio(float value) {
        ndampingRatio(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code targetTranslation}
     *
     * @param value float
     * @return b2PrismaticJointDef
     */
    public b2PrismaticJointDef targetTranslation(float value) {
        ntargetTranslation(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code enableLimit}
     *
     * @param value boolean
     * @return b2PrismaticJointDef
     */
    public b2PrismaticJointDef enableLimit(boolean value) {
        nenableLimit(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code lowerTranslation}
     *
     * @param value float
     * @return b2PrismaticJointDef
     */
    public b2PrismaticJointDef lowerTranslation(float value) {
        nlowerTranslation(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code upperTranslation}
     *
     * @param value float
     * @return b2PrismaticJointDef
     */
    public b2PrismaticJointDef upperTranslation(float value) {
        nupperTranslation(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code enableMotor}
     *
     * @param value boolean
     * @return b2PrismaticJointDef
     */
    public b2PrismaticJointDef enableMotor(boolean value) {
        nenableMotor(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code maxMotorForce}
     *
     * @param value float
     * @return b2PrismaticJointDef
     */
    public b2PrismaticJointDef maxMotorForce(float value) {
        nmaxMotorForce(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code motorSpeed}
     *
     * @param value float
     * @return b2PrismaticJointDef
     */
    public b2PrismaticJointDef motorSpeed(float value) {
        nmotorSpeed(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code internalValue}
     *
     * @param value int
     * @return b2PrismaticJointDef
     */
    public b2PrismaticJointDef internalValue(int value) {
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
    protected b2PrismaticJointDef create(long address, Pointer ptr) {
        return ptr == null ? new b2PrismaticJointDef(address) : new b2PrismaticJointDef(ptr);
    }
    
    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2PrismaticJointDef
     */
    private static b2PrismaticJointDef factory() {
        return new b2PrismaticJointDef(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2PrismaticJointDef
     */
    public static b2PrismaticJointDef createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2PrismaticJointDef(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2PrismaticJointDef}.
     *
     * @param alloc Custom memory manager
     * @return b2PrismaticJointDef
     */
    public static b2PrismaticJointDef alloc(AllocFunc alloc) {
        return new b2PrismaticJointDef(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2PrismaticJointDef}.
     *
     * @return b2PrismaticJointDef
     */
    public static b2PrismaticJointDef malloc() {
        return new b2PrismaticJointDef(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2PrismaticJointDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2PrismaticJointDef}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static b2JointDef nbase(long address)                  { return b2JointDef.createSafe(() -> address + BASE);             }
    public static boolean nenableSpring(long address)             { return memGetByte(address + ENABLE_SPRING) != 0;                }
    public static float nhertz(long address)                      { return memGetFloat(address + HERTZ);                            }
    public static float ndampingRatio(long address)               { return memGetFloat(address + DAMPING_RATIO);                    }
    public static float ntargetTranslation(long address)          { return memGetFloat(address + TARGET_TRANSLATION);               }
    public static boolean nenableLimit(long address)              { return memGetByte(address + ENABLE_LIMIT) != 0;                 }
    public static float nlowerTranslation(long address)           { return memGetFloat(address + LOWER_TRANSLATION);                }
    public static float nupperTranslation(long address)           { return memGetFloat(address + UPPER_TRANSLATION);                }
    public static boolean nenableMotor(long address)              { return memGetByte(address + ENABLE_MOTOR) != 0;                 }
    public static float nmaxMotorForce(long address)              { return memGetFloat(address + MAX_MOTOR_FORCE);                  }
    public static float nmotorSpeed(long address)                 { return memGetFloat(address + MOTOR_SPEED);                      }
    public static int ninternalValue(long address)                { return memGetInt(address + INTERNAL_VALUE);                     }

    public static void nbase(long address, b2JointDef value)            { nmemcpy(address + BASE, value.address(), b2JointDef.SIZEOF); }
    public static void nenableSpring(long address, boolean value)       { memPutByte(address + ENABLE_SPRING, (byte) (value ? 1 : 0));   }
    public static void nhertz(long address, float value)                { memPutFloat(address + HERTZ, value);                           }
    public static void ndampingRatio(long address, float value)         { memPutFloat(address + DAMPING_RATIO, value);                   }
    public static void ntargetTranslation(long address, float value)    { memPutFloat(address + TARGET_TRANSLATION, value);              }
    public static void nenableLimit(long address, boolean value)        { memPutByte(address + ENABLE_LIMIT, (byte) (value ? 1 : 0));    }
    public static void nlowerTranslation(long address, float value)     { memPutFloat(address + LOWER_TRANSLATION, value);               }
    public static void nupperTranslation(long address, float value)     { memPutFloat(address + UPPER_TRANSLATION, value);               }
    public static void nenableMotor(long address, boolean value)        { memPutByte(address + ENABLE_MOTOR, (byte) (value ? 1 : 0));    }
    public static void nmaxMotorForce(long address, float value)        { memPutFloat(address + MAX_MOTOR_FORCE, value);                 }
    public static void nmotorSpeed(long address, float value)           { memPutFloat(address + MOTOR_SPEED, value);                     }
    public static void ninternalValue(long address, int value)          { memPutInt(address + INTERNAL_VALUE, value);                    }

    // -----------------------------------

    /** An array of {@code b2PrismaticJointDef} structs. */
    public static class Buffer extends StructBuffer<b2PrismaticJointDef, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2PrismaticJointDef ELEMENT_FACTORY = b2PrismaticJointDef.factory();

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
        protected b2PrismaticJointDef getElementFactory() {
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
