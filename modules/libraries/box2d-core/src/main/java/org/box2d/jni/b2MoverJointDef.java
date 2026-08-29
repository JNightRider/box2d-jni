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
import org.box2d.jni.readonly.ConstB2MoverJointDef;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2MoverJointDef
 * {
 *     b2JointDef base;
 *     b2Vec2 linearVelocity;
 *     b2Vec2 maxVelocityForce;
 *     int internalValue;
 * } b2MoverJointDef;
 * </code></pre>
 *
 * @author wil
 * @version 1.0.0
 * @since 1.3.0
 */
public class b2MoverJointDef extends Struct<b2MoverJointDef> implements ConstB2MoverJointDef {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            BASE,
            LINEAR_VELOCITY,
            MAX_VELOCITY_FORCE,
            INTERNAL_VALUE;

    static {
        Layout layout = __struct(
                __member(b2JointDef.SIZEOF, b2JointDef.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4)
        );

        BASE = layout.offsetof(0);
        LINEAR_VELOCITY = layout.offsetof(1);
        MAX_VELOCITY_FORCE = layout.offsetof(2);
        INTERNAL_VALUE = layout.offsetof(3);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2MoverJointDef(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2MoverJointDef(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2MoverJointDef(long address, boolean factor) {
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
    public b2Vec2 maxVelocityForce() { return nmaxVelocityForce(address()); }
    /** @return Returns the property {@code internalValue} */
    @Override
    public int internalValue() { return ninternalValue(address()); }

    /**
     * Set the value of property {@code base}
     *
     * @param value b2JointDef
     * @return b2MoverJointDef
     */
    public b2MoverJointDef base(b2JointDef value) {
        nbase(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code linearVelocity}
     *
     * @param value b2Vec2
     * @return b2MoverJointDef
     */
    public b2MoverJointDef linearVelocity(b2Vec2 value) {
        nlinearVelocity(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code maxVelocityForce}
     *
     * @param value b2Vec2
     * @return b2MoverJointDef
     */
    public b2MoverJointDef maxVelocityForce(b2Vec2 value) {
        nmaxVelocityForce(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code internalValue}
     *
     * @param value int
     * @return b2MoverJointDef
     */
    public b2MoverJointDef internalValue(int value) {
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
    protected b2MoverJointDef create(long address, Pointer ptr) {
        return ptr == null ? new b2MoverJointDef(address) : new b2MoverJointDef(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2MoverJointDef
     */
    private static b2MoverJointDef factory() {
        return new b2MoverJointDef(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2MoverJointDef
     */
    public static b2MoverJointDef createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2MoverJointDef(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2MoverJointDef}.
     *
     * @param alloc Custom memory manager
     * @return b2MoverJointDef
     */
    public static b2MoverJointDef alloc(AllocFunc alloc) {
        long ptr = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return ptr == NULL ? null : new b2MoverJointDef(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2MoverJointDef}.
     *
     * @return b2MoverJointDef
     */
    public static b2MoverJointDef calloc() {
        return new b2MoverJointDef(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2MoverJointDef}.
     *
     * @param alloc arena
     * @return b2MoverJointDef
     */
    public static b2MoverJointDef calloc(ArenaAlloc alloc) {
        long ptr = alloc.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2MoverJointDef(() -> ptr);
    }
    
    
    /**
     * Reserve memory for the new object {@code b2MoverJointDef}.
     *
     * @return b2MoverJointDef
     */
    public static b2MoverJointDef malloc() {
        return new b2MoverJointDef(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2MoverJointDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2MoverJointDef}.
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
     * Reserve an amount n of memory for the object {@code b2MoverJointDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2MoverJointDef}.
     *
     * @param capacity Number of elements
     * @param alloc Arean
     * @return Buffer
     */
    public static Buffer calloc(int capacity, ArenaAlloc alloc) {
        long ptr = alloc.ncalloc(ALIGNOF, capacity, SIZEOF);
        return new Buffer(ptr, capacity);
    }

    // -----------------------------------

    public static b2JointDef nbase(long address) { return b2JointDef.createSafe(() -> address + BASE); }
    public static b2Vec2 nlinearVelocity(long address) { return b2Vec2.createSafe(() -> address + LINEAR_VELOCITY); }
    public static b2Vec2 nmaxVelocityForce(long address) { return b2Vec2.createSafe(() -> address + MAX_VELOCITY_FORCE); }
    public static int ninternalValue(long address) { return memGetInt(address + INTERNAL_VALUE); }

    public static void nbase(long address, b2JointDef value) { nmemcpy(address + BASE, value.address(), b2JointDef.SIZEOF); }
    public static void nlinearVelocity(long address, b2Vec2 value) { nmemcpy(address + LINEAR_VELOCITY, value.address(), b2Vec2.SIZEOF); }
    public static void nmaxVelocityForce(long address, b2Vec2 value) { nmemcpy(address + MAX_VELOCITY_FORCE, value.address(), b2Vec2.SIZEOF); }
    public static void ninternalValue(long address, int value) { memPutInt(address + INTERNAL_VALUE, value); }
    
    // -----------------------------------

    /** An array of {@code b2MoverJointDef} structs. */
    public static class Buffer extends StructBuffer<b2MoverJointDef, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2MoverJointDef ELEMENT_FACTORY = b2MoverJointDef.factory();

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

        /*(non-Jabadoc)
         */
        @Override
        protected b2MoverJointDef getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /*(non-Jabadoc)
         */
        @Override
        protected Buffer self() {
            return this;
        }

        /*(non-Jabadoc)
         */
        @Override
        protected Buffer create(long address, int mark, int position, int limit, int capacity) {
            return new Buffer(address, mark, position, limit, capacity);
        }  
    }
}
