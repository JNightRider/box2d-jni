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
import org.box2d.jni.readonly.ConstB2MotorJointDef;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2MotorJointDef
 * {
 * 	b2JointDef base;
 * 	b2Vec2 linearVelocity;
 * 	float maxVelocityForce;
 * 	float angularVelocity;
 * 	float maxVelocityTorque;
 * 	float linearHertz;
 * 	float linearDampingRatio;
 * 	float maxSpringForce;
 * 	float angularHertz;
 * 	float angularDampingRatio;
 * 	float maxSpringTorque;
 * 	int internalValue;
 * } b2MotorJointDef;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2MotorJointDef extends Struct<b2MotorJointDef> implements ConstB2MotorJointDef {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            BASE,
            LINEAR_VELOCITY,
            MAX_VELOCITY_FORCE,
            ANGULAR_VELOCITY,
            MAX_VELOCITY_TORQUE,
            LINEAR_HERTZ,
            LINEAR_DAMPING_RATIO,
            MAX_SPRING_FORCE,
            ANGULAR_HERTZ,
            ANGULAR_DAMPING_RATIO,
            MAX_SPRING_TORQUE,
            INTERNAL_VALUE;

    static {
        Layout layout = __struct(
                __member(b2JointDef.SIZEOF, b2JointDef.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4)
        );

        BASE = layout.offsetof(0);
        LINEAR_VELOCITY = layout.offsetof(1);
        MAX_VELOCITY_FORCE = layout.offsetof(2);
        ANGULAR_VELOCITY = layout.offsetof(3);
        MAX_VELOCITY_TORQUE = layout.offsetof(4);
        LINEAR_HERTZ = layout.offsetof(5);
        LINEAR_DAMPING_RATIO = layout.offsetof(6);
        MAX_SPRING_FORCE = layout.offsetof(7);
        ANGULAR_HERTZ = layout.offsetof(8);
        ANGULAR_DAMPING_RATIO = layout.offsetof(9);
        MAX_SPRING_TORQUE = layout.offsetof(10);
        INTERNAL_VALUE = layout.offsetof(11);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2MotorJointDef(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2MotorJointDef(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2MotorJointDef(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code base} */
    @Override
    public b2JointDef base() { return nbase(address()); }
    /** @return Returns the property {@code linearVelocity} */
    @Override
    public b2Vec2 linearVelocity() { return nlinearVelocity(address()); }
    /** @return Returns the property {@code maxVelocityForce} */
    @Override
    public float maxVelocityForce() { return nmaxVelocityForce(address()); }
    /** @return Returns the property {@code angularVelocity} */
    @Override
    public float angularVelocity() { return nangularVelocity(address()); }
    /** @return Returns the property {@code maxVelocityTorque} */
    @Override
    public float maxVelocityTorque() { return nmaxVelocityTorque(address()); }
    /** @return Returns the property {@code linearHertz} */
    @Override
    public float linearHertz() { return nlinearHertz(address()); }
    /** @return Returns the property {@code linearDampingRatio} */
    @Override
    public float linearDampingRatio() { return nlinearDampingRatio(address()); }
    /** @return Returns the property {@code maxSpringForce} */
    @Override
    public float maxSpringForce() { return nmaxSpringForce(address()); }
    /** @return Returns the property {@code angularHertz} */
    @Override
    public float angularHertz() { return nangularHertz(address()); }
    /** @return Returns the property {@code angularDampingRatio} */
    @Override
    public float angularDampingRatio() { return nangularDampingRatio(address()); }
    /** @return Returns the property {@code maxSpringTorque} */
    @Override
    public float maxSpringTorque() { return nmaxSpringTorque(address()); }
    /** @return Returns the property {@code internalValue} */
    @Override
    public int internalValue() { return ninternalValue(address()); }

    /**
     * Set the value of property {@code base}
     *
     * @param value b2JointDef
     * @return b2MotorJointDef
     */
    public b2MotorJointDef base(b2JointDef value) {
        nbase(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code linearVelocity}
     *
     * @param value b2Vec2
     * @return b2MotorJointDef
     */
    public b2MotorJointDef linearVelocity(b2Vec2 value) {
        nlinearVelocity(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code maxVelocityForce}
     *
     * @param value float
     * @return b2MotorJointDef
     */
    public b2MotorJointDef maxVelocityForce(float value) {
        nmaxVelocityForce(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code angularVelocity}
     *
     * @param value float
     * @return b2MotorJointDef
     */
    public b2MotorJointDef angularVelocity(float value) {
        nangularVelocity(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code maxVelocityTorque}
     *
     * @param value float
     * @return b2MotorJointDef
     */
    public b2MotorJointDef maxVelocityTorque(float value) {
        nmaxVelocityTorque(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code linearHertz}
     *
     * @param value float
     * @return b2MotorJointDef
     */
    public b2MotorJointDef linearHertz(float value) {
        nlinearHertz(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code linearDampingRatio}
     *
     * @param value float
     * @return b2MotorJointDef
     */
    public b2MotorJointDef linearDampingRatio(float value) {
        nlinearDampingRatio(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code maxSpringForce}
     *
     * @param value float
     * @return b2MotorJointDef
     */
    public b2MotorJointDef maxSpringForce(float value) {
        nmaxSpringForce(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code angularHertz}
     *
     * @param value float
     * @return b2MotorJointDef
     */
    public b2MotorJointDef angularHertz(float value) {
        nangularHertz(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code angularDampingRatio}
     *
     * @param value float
     * @return b2MotorJointDef
     */
    public b2MotorJointDef angularDampingRatio(float value) {
        nangularDampingRatio(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code maxSpringTorque}
     *
     * @param value float
     * @return b2MotorJointDef
     */
    public b2MotorJointDef maxSpringTorque(float value) {
        nmaxSpringTorque(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code internalValue}
     *
     * @param value int
     * @return b2MotorJointDef
     */
    public b2MotorJointDef internalValue(int value) {
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
    protected b2MotorJointDef create(long address, Pointer ptr) {
        return ptr == null ? new b2MotorJointDef(address) : new b2MotorJointDef(ptr);
    }
    
// -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2MotorJointDef
     */
    private static b2MotorJointDef factory() {
        return new b2MotorJointDef(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2MotorJointDef
     */
    public static b2MotorJointDef createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2MotorJointDef(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2MotorJointDef}.
     *
     * @param alloc Custom memory manager
     * @return b2MotorJointDef
     */
    public static b2MotorJointDef alloc(AllocFunc alloc) {
        return new b2MotorJointDef(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2MotorJointDef}.
     *
     * @return b2MotorJointDef
     */
    public static b2MotorJointDef malloc() {
        return new b2MotorJointDef(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2MotorJointDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2MotorJointDef}.
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
    public static b2Vec2 nlinearVelocity(long address)  { return b2Vec2.createSafe(() -> address + LINEAR_VELOCITY); }
    public static float nmaxVelocityForce(long address) { return memGetFloat(address + MAX_VELOCITY_FORCE); }
    public static float nangularVelocity(long address)  { return memGetFloat(address + ANGULAR_VELOCITY); }
    public static float nmaxVelocityTorque(long address)    { return memGetFloat(address + MAX_VELOCITY_TORQUE); }
    public static float nlinearHertz(long address)          { return memGetFloat(address + LINEAR_HERTZ); }
    public static float nlinearDampingRatio(long address)   { return memGetFloat(address + LINEAR_DAMPING_RATIO); }
    public static float nmaxSpringForce(long address)   { return memGetFloat(address + MAX_SPRING_FORCE); }
    public static float nangularHertz(long address)     { return memGetFloat(address + ANGULAR_HERTZ); }
    public static float nangularDampingRatio(long address)  { return memGetFloat(address + ANGULAR_DAMPING_RATIO); }
    public static float nmaxSpringTorque(long address)      { return memGetFloat(address + MAX_SPRING_TORQUE); }
    public static int ninternalValue(long address)          { return memGetInt(address + INTERNAL_VALUE); }
    
    public static void nbase(long address, b2JointDef value)        { nmemcpy(address + BASE, value.address(), b2JointDef.SIZEOF); }
    public static void nlinearVelocity(long address, b2Vec2 value)  { nmemcpy(address + LINEAR_VELOCITY, value.address(), b2Vec2.SIZEOF); }
    public static void nmaxVelocityForce(long address, float value) { memPutFloat(address + MAX_VELOCITY_FORCE, value); }
    public static void nangularVelocity(long address, float value)  { memPutFloat(address + ANGULAR_VELOCITY, value); }
    public static void nmaxVelocityTorque(long address, float value)    { memPutFloat(address + MAX_VELOCITY_TORQUE, value); }
    public static void nlinearHertz(long address, float value)          { memPutFloat(address + LINEAR_HERTZ, value); }
    public static void nlinearDampingRatio(long address, float value)   { memPutFloat(address + LINEAR_DAMPING_RATIO, value); }
    public static void nmaxSpringForce(long address, float value)       { memPutFloat(address + MAX_SPRING_FORCE, value); }
    public static void nangularHertz(long address, float value)         { memPutFloat(address + ANGULAR_HERTZ, value); }
    public static void nangularDampingRatio(long address, float value)  { memPutFloat(address + ANGULAR_DAMPING_RATIO, value); }
    public static void nmaxSpringTorque(long address, float value)  { memPutFloat(address + MAX_SPRING_TORQUE, value); }
    public static void ninternalValue(long address, int value)      { memPutInt(address + INTERNAL_VALUE, value); }

    // -----------------------------------

    /** An array of {@code b2MotorJointDef} structs. */
    public static class Buffer extends StructBuffer<b2MotorJointDef, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2MotorJointDef ELEMENT_FACTORY = b2MotorJointDef.factory();

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
        protected b2MotorJointDef getElementFactory() {
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
