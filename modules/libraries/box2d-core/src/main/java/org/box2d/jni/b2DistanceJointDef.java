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
import org.box2d.jni.readonly.ConstB2DistanceJointDef;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2DistanceJointDef
 * {
 * 	b2JointDef base;
 * 	float length;
 * 	bool enableSpring;
 * 	float lowerSpringForce;
 * 	float upperSpringForce;
 * 	float hertz;
 * 	float dampingRatio;
 * 	bool enableLimit;
 * 	float minLength;
 * 	float maxLength;
 * 	bool enableMotor;
 * 	float maxMotorForce;
 * 	float motorSpeed;
 * 	int internalValue;
 * } b2DistanceJointDef;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2DistanceJointDef extends Struct<b2DistanceJointDef> implements ConstB2DistanceJointDef {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            BASE,
            LENGTH,
            ENABLE_SPRING,
            LOWER_SPRING_FORCE,
            UPPER_SPRING_FORCE,
            HERTZ,
            DAMPING_RATIO,
            ENABLE_LIMIT,
            MIN_LENGTH,
            MAX_LENGTH,
            ENABLE_MOTOR,
            MAX_MOTOR_FORCE,
            MOTOR_SPEED,
            INTERNAL_VALUE;

    static {
        Layout layout = __struct(
                __member(b2JointDef.SIZEOF, b2JointDef.ALIGNOF),
                __member(4),
                __member(1),
                __member(4),
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
        LENGTH = layout.offsetof(1);
        ENABLE_SPRING = layout.offsetof(2);
        LOWER_SPRING_FORCE = layout.offsetof(3);
        UPPER_SPRING_FORCE = layout.offsetof(4);
        HERTZ = layout.offsetof(5);
        DAMPING_RATIO = layout.offsetof(6);
        ENABLE_LIMIT = layout.offsetof(7);
        MIN_LENGTH = layout.offsetof(8);
        MAX_LENGTH = layout.offsetof(9);
        ENABLE_MOTOR = layout.offsetof(10);
        MAX_MOTOR_FORCE = layout.offsetof(11);
        MOTOR_SPEED = layout.offsetof(12);
        INTERNAL_VALUE = layout.offsetof(13);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2DistanceJointDef(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2DistanceJointDef(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2DistanceJointDef(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code base} */
    @Override
    public b2JointDef base() { return nbase(address()); }
    /** @return Returns the property {@code length} */
    @Override
    public float length() { return nlength(address()); }
    /** @return Returns the property {@code enableSpring} */
    @Override
    public boolean enableSpring() { return nenableSpring(address()); }
    /** @return Returns the property {@code lowerSpringForce} */
    @Override
    public float lowerSpringForce() { return nlowerSpringForce(address()); }
    /** @return Returns the property {@code upperSpringForce} */
    @Override
    public float upperSpringForce() { return nupperSpringForce(address()); }
    /** @return Returns the property {@code hertz} */
    @Override
    public float hertz() { return nhertz(address()); }
    /** @return Returns the property {@code dampingRatio} */
    @Override
    public float dampingRatio() { return ndampingRatio(address()); }
    /** @return Returns the property {@code enableLimit} */
    @Override
    public boolean enableLimit() { return nenableLimit(address()); }
    /** @return Returns the property {@code minLength} */
    @Override
    public float minLength() { return nminLength(address()); }
    /** @return Returns the property {@code maxLength} */
    @Override
    public float maxLength() { return nmaxLength(address()); }
    /** @return Returns the property {@code enableMotor} */
    @Override
    public boolean enableMotor() { return nenableMotor(address()); }
    /** @return Returns the property {@code maxMotorForce} */
    @Override
    public float maxMotorForce() { return nmaxMotorForce(address()); }
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
     * @return b2DistanceJointDef
     */
    public b2DistanceJointDef base(b2JointDef value) {
        nbase(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code length}
     *
     * @param value float
     * @return b2DistanceJointDef
     */
    public b2DistanceJointDef length(float value) {
        nlength(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code enableSpring}
     *
     * @param value boolean
     * @return b2DistanceJointDef
     */
    public b2DistanceJointDef enableSpring(boolean value) {
        nenableSpring(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code lowerSpringForce}
     *
     * @param value float
     * @return b2DistanceJointDef
     */
    public b2DistanceJointDef lowerSpringForce(float value) {
        nlowerSpringForce(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code upperSpringForce}
     *
     * @param value float
     * @return b2DistanceJointDef
     */
    public b2DistanceJointDef upperSpringForce(float value) {
        nupperSpringForce(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code hertz}
     *
     * @param value float
     * @return b2DistanceJointDef
     */
    public b2DistanceJointDef hertz(float value) {
        nhertz(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code dampingRatio}
     *
     * @param value float
     * @return b2DistanceJointDef
     */
    public b2DistanceJointDef dampingRatio(float value) {
        ndampingRatio(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code enableLimit}
     *
     * @param value boolean
     * @return b2DistanceJointDef
     */
    public b2DistanceJointDef enableLimit(boolean value) {
        nenableLimit(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code minLength}
     *
     * @param value float
     * @return b2DistanceJointDef
     */
    public b2DistanceJointDef minLength(float value) {
        nminLength(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code maxLength}
     *
     * @param value float
     * @return b2DistanceJointDef
     */
    public b2DistanceJointDef maxLength(float value) {
        nmaxLength(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code enableMotor}
     *
     * @param value boolean
     * @return b2DistanceJointDef
     */
    public b2DistanceJointDef enableMotor(boolean value) {
        nenableMotor(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code maxMotorForce}
     *
     * @param value float
     * @return b2DistanceJointDef
     */
    public b2DistanceJointDef maxMotorForce(float value) {
        nmaxMotorForce(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code motorSpeed}
     *
     * @param value float
     * @return b2DistanceJointDef
     */
    public b2DistanceJointDef motorSpeed(float value) {
        nmotorSpeed(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code internalValue}
     *
     * @param value int
     * @return b2DistanceJointDef
     */
    public b2DistanceJointDef internalValue(int value) {
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
    protected b2DistanceJointDef create(long address, Pointer ptr) {
        return ptr == null ? new b2DistanceJointDef(address) : new b2DistanceJointDef(ptr);
    }
    
    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2DistanceJointDef
     */
    private static b2DistanceJointDef factory() {
        return new b2DistanceJointDef(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2DistanceJointDef
     */
    public static b2DistanceJointDef createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2DistanceJointDef(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2DistanceJointDef}.
     *
     * @param alloc Custom memory manager
     * @return b2DistanceJointDef
     */
    public static b2DistanceJointDef alloc(AllocFunc alloc) {
        return new b2DistanceJointDef(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2DistanceJointDef}.
     *
     * @return b2DistanceJointDef
     */
    public static b2DistanceJointDef malloc() {
        return new b2DistanceJointDef(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2DistanceJointDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2DistanceJointDef}.
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
    public static float nlength(long address) { return memGetFloat(address + LENGTH); }
    public static boolean nenableSpring(long address) { return memGetByte(address + ENABLE_SPRING) != 0; }
    public static float nlowerSpringForce(long address) { return memGetFloat(address + LOWER_SPRING_FORCE); }
    public static float nupperSpringForce(long address) { return memGetFloat(address + UPPER_SPRING_FORCE); }
    public static float nhertz(long address) { return memGetFloat(address + HERTZ); }
    public static float ndampingRatio(long address) { return memGetFloat(address + DAMPING_RATIO); }
    public static boolean nenableLimit(long address) { return memGetByte(address + ENABLE_LIMIT) != 0; }
    public static float nminLength(long address) { return memGetFloat(address + MIN_LENGTH); }
    public static float nmaxLength(long address) { return memGetFloat(address + MAX_LENGTH); }
    public static boolean nenableMotor(long address) { return memGetByte(address + ENABLE_MOTOR) != 0; }
    public static float nmaxMotorForce(long address) { return memGetFloat(address + MAX_MOTOR_FORCE); }
    public static float nmotorSpeed(long address) { return memGetFloat(address + MOTOR_SPEED); }
    public static int ninternalValue(long address) { return memGetInt(address + INTERNAL_VALUE); }

    public static void nbase(long address, b2JointDef value) { nmemcpy(address + BASE, value.address(), b2JointDef.SIZEOF); }
    public static void nlength(long address, float value) { memPutFloat(address + LENGTH, value); }
    public static void nenableSpring(long address, boolean value) {  memPutByte(address + ENABLE_SPRING, (byte) (value ? 1 : 0)); }
    public static void nlowerSpringForce(long address, float value) { memPutFloat(address + LOWER_SPRING_FORCE, value); }
    public static void nupperSpringForce(long address, float value) { memPutFloat(address + UPPER_SPRING_FORCE, value); }
    public static void nhertz(long address, float value) { memPutFloat(address + HERTZ, value); }
    public static void ndampingRatio(long address, float value) { memPutFloat(address + DAMPING_RATIO, value); }
    public static void nenableLimit(long address, boolean value) { memPutByte(address + ENABLE_LIMIT, (byte) (value ? 1 : 0)); }
    public static void nminLength(long address, float value) { memPutFloat(address + MIN_LENGTH, value); }
    public static void nmaxLength(long address, float value) { memPutFloat(address + MAX_LENGTH, value); }
    public static void nenableMotor(long address, boolean value) { memPutByte(address + ENABLE_MOTOR, (byte) (value ? 1 : 0)); }
    public static void nmaxMotorForce(long address, float value) { memPutFloat(address + MAX_MOTOR_FORCE, value); }
    public static void nmotorSpeed(long address, float value) { memPutFloat(address + MOTOR_SPEED, value); }
    public static void ninternalValue(long address, int value) { memPutInt(address + INTERNAL_VALUE, value); }

    // -----------------------------------

    /** An array of {@code b2DistanceJointDef} structs. */
    public static class Buffer extends StructBuffer<b2DistanceJointDef, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2DistanceJointDef ELEMENT_FACTORY = b2DistanceJointDef.factory();

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
        protected b2DistanceJointDef getElementFactory() {
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
