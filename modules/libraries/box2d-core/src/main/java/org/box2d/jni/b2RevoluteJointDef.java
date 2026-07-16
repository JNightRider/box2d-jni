/*
BSD 3-Clause License

Copyright (c) 2026, Night Rider

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.box2d.jni;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2RevoluteJointDef;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2RevoluteJointDef
 * {
 *     b2JointDef base;
 *     float targetAngle;
 *     bool enableSpring;
 *     float hertz;
 *     float dampingRatio;
 *     bool enableLimit;
 *     float lowerAngle;
 *     float upperAngle;
 *     bool enableMotor;
 *     float maxMotorTorque;
 *     float motorSpeed;
 *     int internalValue;
 * } b2RevoluteJointDef;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2RevoluteJointDef extends Struct<b2RevoluteJointDef> implements ConstB2RevoluteJointDef {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            BASE,
            TARGET_ANGLE,
            ENABLE_SPRING,
            HERTZ,
            DAMPING_RATIO,
            ENABLE_LIMIT,
            LOWER_ANGLE,
            UPPER_ANGLE,
            ENABLE_MOTOR,
            MAX_MOTOR_TORQUE,
            MOTOR_SPEED,
            INTERNAL_VALUE;

    static {
        Layout layout = __struct(
                __member(b2JointDef.SIZEOF, b2JointDef.ALIGNOF),
                __member(4),
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
        TARGET_ANGLE = layout.offsetof(1);
        ENABLE_SPRING = layout.offsetof(2);
        HERTZ = layout.offsetof(3);
        DAMPING_RATIO = layout.offsetof(4);
        ENABLE_LIMIT = layout.offsetof(5);
        LOWER_ANGLE = layout.offsetof(6);
        UPPER_ANGLE = layout.offsetof(7);
        ENABLE_MOTOR = layout.offsetof(8);
        MAX_MOTOR_TORQUE = layout.offsetof(9);
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
    public b2RevoluteJointDef(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2RevoluteJointDef(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2RevoluteJointDef(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code base} */
    @Override
    public b2JointDef base() { return nbase(address()); }
    /** @return Returns the property {@code targetAngle} */
    @Override
    public float targetAngle() { return ntargetAngle(address()); }
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
    /** @return Returns the property {@code lowerAngle} */
    @Override
    public float lowerAngle() { return nlowerAngle(address()); }
    /** @return Returns the property {@code upperAngle} */
    @Override
    public float upperAngle() { return nupperAngle(address()); }
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
     * @return b2RevoluteJointDef
     */
    public b2RevoluteJointDef base(b2JointDef value) {
        nbase(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code targetAngle}
     *
     * @param value float
     * @return b2RevoluteJointDef
     */
    public b2RevoluteJointDef targetAngle(float value) {
        ntargetAngle(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code enableSpring}
     *
     * @param value boolean
     * @return b2RevoluteJointDef
     */
    public b2RevoluteJointDef enableSpring(boolean value) {
        nenableSpring(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code hertz}
     *
     * @param value float
     * @return b2RevoluteJointDef
     */
    public b2RevoluteJointDef hertz(float value) {
        nhertz(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code dampingRatio}
     *
     * @param value float
     * @return b2RevoluteJointDef
     */
    public b2RevoluteJointDef dampingRatio(float value) {
        ndampingRatio(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code enableLimit}
     *
     * @param value boolean
     * @return b2RevoluteJointDef
     */
    public b2RevoluteJointDef enableLimit(boolean value) {
        nenableLimit(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code lowerAngle}
     *
     * @param value float
     * @return b2RevoluteJointDef
     */
    public b2RevoluteJointDef lowerAngle(float value) {
        nlowerAngle(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code upperAngle}
     *
     * @param value float
     * @return b2RevoluteJointDef
     */
    public b2RevoluteJointDef upperAngle(float value) {
        nupperAngle(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code enableMotor}
     *
     * @param value boolean
     * @return b2RevoluteJointDef
     */
    public b2RevoluteJointDef enableMotor(boolean value) {
        nenableMotor(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code maxMotorTorque}
     *
     * @param value float
     * @return b2RevoluteJointDef
     */
    public b2RevoluteJointDef maxMotorTorque(float value) {
        nmaxMotorTorque(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code motorSpeed}
     *
     * @param value float
     * @return b2RevoluteJointDef
     */
    public b2RevoluteJointDef motorSpeed(float value) {
        nmotorSpeed(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code internalValue}
     *
     * @param value int
     * @return b2RevoluteJointDef
     */
    public b2RevoluteJointDef internalValue(int value) {
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
    protected b2RevoluteJointDef create(long address, Pointer ptr) {
        return ptr == null ? new b2RevoluteJointDef(address) : new b2RevoluteJointDef(ptr);
    }
    
        // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2RevoluteJointDef
     */
    private static b2RevoluteJointDef factory() {
        return new b2RevoluteJointDef(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2RevoluteJointDef
     */
    public static b2RevoluteJointDef createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2RevoluteJointDef(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2RevoluteJointDef}.
     *
     * @param alloc Custom memory manager
     * @return b2RevoluteJointDef
     */
    public static b2RevoluteJointDef alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2RevoluteJointDef(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2RevoluteJointDef}.
     *
     * @return b2RevoluteJointDef
     */
    public static b2RevoluteJointDef calloc() {
        return new b2RevoluteJointDef(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2RevoluteJointDef}.
     *
     * @param arean arena
     * @return b2RevoluteJointDef
     */
    public static b2RevoluteJointDef calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2RevoluteJointDef(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2RevoluteJointDef}.
     *
     * @return b2RevoluteJointDef
     */
    public static b2RevoluteJointDef malloc() {
        return new b2RevoluteJointDef(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2RevoluteJointDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2RevoluteJointDef}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, capacity, SIZEOF);
        return new Buffer(address, capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2RevoluteJointDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2RevoluteJointDef}.
     *
     * @param capacity Number of elements
     * @param arena Arean
     * @return Buffer
     */
    public static Buffer calloc(int capacity, ArenaAlloc arena) {
        long ptr = arena.ncalloc(ALIGNOF, capacity, SIZEOF);
        return new Buffer(ptr, capacity);
    }

    // -----------------------------------

    public static b2JointDef nbase(long address)                { return b2JointDef.createSafe(() -> address + BASE);           }
    public static float ntargetAngle(long address)              { return memGetFloat(address + TARGET_ANGLE);                   }
    public static boolean nenableSpring(long address)           { return memGetByte(address + ENABLE_SPRING) != 0;              }
    public static float nhertz(long address)                    { return memGetFloat(address + HERTZ);                          }
    public static float ndampingRatio(long address)             { return memGetFloat(address + DAMPING_RATIO);                  }
    public static boolean nenableLimit(long address)            { return memGetByte(address + ENABLE_LIMIT) != 0;               }
    public static float nlowerAngle(long address)               { return memGetFloat(address + LOWER_ANGLE);                    }
    public static float nupperAngle(long address)               { return memGetFloat(address + UPPER_ANGLE);                    }
    public static boolean nenableMotor(long address)            { return memGetByte(address + ENABLE_MOTOR) != 0;               }
    public static float nmaxMotorTorque(long address)           { return memGetFloat(address + MAX_MOTOR_TORQUE);               }
    public static float nmotorSpeed(long address)               { return memGetFloat(address + MOTOR_SPEED);                    }
    public static int ninternalValue(long address)              { return memGetInt(address + INTERNAL_VALUE);                   }

    public static void nbase(long address, b2JointDef value)         { nmemcpy(address + BASE, value.address(), b2JointDef.SIZEOF); }
    public static void ntargetAngle(long address, float value)       { memPutFloat(address + TARGET_ANGLE, value);                  }
    public static void nenableSpring(long address, boolean value)    { memPutByte(address + ENABLE_SPRING, (byte) (value ? 1 : 0)); }
    public static void nhertz(long address, float value)             { memPutFloat(address + HERTZ, value);                         }
    public static void ndampingRatio(long address, float value)      { memPutFloat(address + DAMPING_RATIO, value);                 }
    public static void nenableLimit(long address, boolean value)     { memPutByte(address + ENABLE_LIMIT, (byte) (value ? 1 : 0));  }
    public static void nlowerAngle(long address, float value)        { memPutFloat(address + LOWER_ANGLE, value);                   }
    public static void nupperAngle(long address, float value)        { memPutFloat(address + UPPER_ANGLE, value);                   }
    public static void nenableMotor(long address, boolean value)     { memPutByte(address + ENABLE_MOTOR, (byte) (value ? 1 : 0));  }
    public static void nmaxMotorTorque(long address, float value)    { memPutFloat(address + MAX_MOTOR_TORQUE, value);              }
    public static void nmotorSpeed(long address, float value)        { memPutFloat(address + MOTOR_SPEED, value);                   }
    public static void ninternalValue(long address, int value)       { memPutInt(address + INTERNAL_VALUE, value);                  }

    // -----------------------------------

    /** An array of {@code b2RevoluteJointDef} structs. */
    public static class Buffer extends StructBuffer<b2RevoluteJointDef, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2RevoluteJointDef ELEMENT_FACTORY = b2RevoluteJointDef.factory();

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
        protected b2RevoluteJointDef getElementFactory() {
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
