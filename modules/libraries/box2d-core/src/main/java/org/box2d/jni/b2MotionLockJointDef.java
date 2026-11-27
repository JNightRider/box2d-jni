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
import org.box2d.jni.readonly.ConstB2MotionLockJointDef;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;


/**
 * <pre><code>
 * typedef struct b2MotionLockJointDef
 * {
 *     b2JointDef base;
 *     bool lockLinearX;
 *     bool lockLinearY;
 *     int internalValue;
 * } b2MotionLockJointDef;
 * </code></pre>
 *
 * A motion lock joint is designed to restrict motion to a line or a point.
 * All restrictions are relative to the joint frame in body A.
 *
 * @author wil
 * @version 1.0.0
 * @since 2.3.0
 */
public class b2MotionLockJointDef extends Struct<b2MotionLockJointDef> implements ConstB2MotionLockJointDef {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            BASE,
            LOCK_LINEAR_X,
            LOCK_LINEAR_Y,
            INTERNAL_VALUE;

    static {
        Layout layout = __struct(
                __member(b2JointDef.SIZEOF, b2JointDef.ALIGNOF),
                __member(1),
                __member(1),
                __member(4)
        );

        BASE = layout.offsetof(0);
        LOCK_LINEAR_X = layout.offsetof(1);
        LOCK_LINEAR_Y = layout.offsetof(2);
        INTERNAL_VALUE = layout.offsetof(3);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2MotionLockJointDef(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2MotionLockJointDef(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2MotionLockJointDef(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code base} */
    @Override
    public b2JointDef base() { return nbase(address()); }

    /** @return Returns the property {@code lockLinearX} */
    @Override
    public boolean lockLinearX() { return nlockLinearX(address()); }

    /** @return Returns the property {@code lockLinearY} */
    @Override
    public boolean lockLinearY() { return nlockLinearY(address()); }

    /** @return Returns the property {@code internalValue} */
    @Override
    public int internalValue() { return ninternalValue(address()); }

    /**
     * Set the value of property {@code base}
     *
     * @param value b2JointDef
     * @return b2MotionLockJointDef
     */
    public b2MotionLockJointDef base(b2JointDef value) {
        nbase(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code lockLinearX}
     *
     * @param value boolean
     * @return b2MotionLockJointDef
     */
    public b2MotionLockJointDef lockLinearX(boolean value) {
        nlockLinearX(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code lockLinearY}
     *
     * @param value boolean
     * @return b2MotionLockJointDef
     */
    public b2MotionLockJointDef lockLinearY(boolean value) {
        nlockLinearY(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code internalValue}
     *
     * @param value int
     * @return b2MotionLockJointDef
     */
    public b2MotionLockJointDef internalValue(int value) {
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
    protected b2MotionLockJointDef create(long address, Pointer ptr) {
        return ptr == null ? new b2MotionLockJointDef(address) : new b2MotionLockJointDef(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2MotionLockJointDef
     */
    private static b2MotionLockJointDef factory() {
        return new b2MotionLockJointDef(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2MotionLockJointDef
     */
    public static b2MotionLockJointDef createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2MotionLockJointDef(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2MotionLockJointDef}.
     *
     * @param alloc Custom memory manager
     * @return b2MotionLockJointDef
     */
    public static b2MotionLockJointDef alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2MotionLockJointDef(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2MotionLockJointDef}.
     *
     * @return b2MotionLockJointDef
     */
    public static b2MotionLockJointDef calloc() {
        return new b2MotionLockJointDef(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2MotionLockJointDef}.
     *
     * @param arean arena
     * @return b2MotionLockJointDef
     */
    public static b2MotionLockJointDef calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2MotionLockJointDef(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2MotionLockJointDef}.
     *
     * @return b2MotionLockJointDef
     */
    public static b2MotionLockJointDef malloc() {
        return new b2MotionLockJointDef(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2MotionLockJointDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2MotionLockJointDef}.
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
     * Reserve an amount n of memory for the object {@code b2MotionLockJointDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2MotionLockJointDef}.
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
    
    public static b2JointDef nbase(long address) { return b2JointDef.createSafe(() -> address + BASE); }
    public static boolean nlockLinearX(long address) { return memGetByte(address + LOCK_LINEAR_X) != 0; }
    public static boolean nlockLinearY(long address) { return memGetByte(address + LOCK_LINEAR_Y) != 0; }
    public static int ninternalValue(long address) { return memGetInt(address + INTERNAL_VALUE); }

    public static void nbase(long address, b2JointDef value) { nmemcpy(address + BASE, value.address(), b2JointDef.SIZEOF); }
    public static void nlockLinearX(long address, boolean value) { memPutByte(address + LOCK_LINEAR_X, (byte) (value ? 1 : 0)); }
    public static void nlockLinearY(long address, boolean value) { memPutByte(address + LOCK_LINEAR_Y, (byte) (value ? 1 : 0)); }
    public static void ninternalValue(long address, int value) { memPutInt(address + INTERNAL_VALUE, value); }

    // -----------------------------------

    /** An array of {@code b2MotionLockJointDef} structs. */
    public static class Buffer extends StructBuffer<b2MotionLockJointDef, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2MotionLockJointDef ELEMENT_FACTORY = b2MotionLockJointDef.factory();

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
        protected b2MotionLockJointDef getElementFactory() {
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

