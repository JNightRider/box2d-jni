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

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2ManifoldPoint
 * {
 *     b2Vec2 anchorA;
 *     b2Vec2 anchorB;
 *     float separation;
 *     float baseSeparation;
 *     float normalImpulse;
 *     float tangentImpulse;
 *     float totalNormalImpulse;
 *     float normalVelocity;
 *     uint16_t id;
 *     bool persisted;
 * } b2ManifoldPoint;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.1.0
 */
public class b2ManifoldPoint extends Struct<b2ManifoldPoint> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            ANCHOR_A,
            ANCHOR_B,
            SEPARATION,
            BASE_SEPARATION,
            NORMAL_IMPULSE,
            TANGENT_IMPULSE,
            TOTAL_NORMAL_IMPULSE,
            NORMAL_VELOCITY,
            ID,
            PERSISTED;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(2),
                __member(1)
        );

        ANCHOR_A = layout.offsetof(0);
        ANCHOR_B = layout.offsetof(1);
        SEPARATION = layout.offsetof(2);
        BASE_SEPARATION = layout.offsetof(3);
        NORMAL_IMPULSE = layout.offsetof(4);
        TANGENT_IMPULSE = layout.offsetof(5);
        TOTAL_NORMAL_IMPULSE = layout.offsetof(6);
        NORMAL_VELOCITY = layout.offsetof(7);
        ID = layout.offsetof(8);
        PERSISTED = layout.offsetof(9);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2ManifoldPoint(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2ManifoldPoint(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2ManifoldPoint(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code anchorA} */
    public b2Vec2 anchorA() { return nanchorA(address()); }
    /** @return Returns the property {@code anchorB} */
    public b2Vec2 anchorB() { return nanchorB(address()); }
    /** @return Returns the property {@code separation} */
    public float separation() { return nseparation(address()); }
    /** @return Returns the property {@code baseSeparation} */
    public float baseSeparation() { return nbaseSeparation(address()); }
    /** @return Returns the property {@code normalImpulse} */
    public float normalImpulse() { return nnormalImpulse(address()); }
    /** @return Returns the property {@code tangentImpulse} */
    public float tangentImpulse() { return ntangentImpulse(address()); }
    /** @return Returns the property {@code totalNormalImpulse} */
    public float totalNormalImpulse() { return ntotalNormalImpulse(address()); }
    /** @return Returns the property {@code normalVelocity} */
    public float normalVelocity() { return nnormalVelocity(address()); }
    /** @return Returns the property {@code id} */
    public short id() { return nid(address()); }
    /** @return Returns the property {@code persisted} */
    public boolean persisted() { return npersisted(address()); }

    /**
     * Set the value of property {@code anchorA}
     *
     * @param value b2Vec2
     * @return b2ManifoldPoint
     */
    public b2ManifoldPoint anchorA(b2Vec2 value) {
        nanchorA(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code anchorB}
     *
     * @param value b2Vec2
     * @return b2ManifoldPoint
     */
    public b2ManifoldPoint anchorB(b2Vec2 value) {
        nanchorB(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code separation}
     *
     * @param value float
     * @return b2ManifoldPoint
     */
    public b2ManifoldPoint separation(float value) {
        nseparation(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code baseSeparation}
     *
     * @param value float
     * @return b2ManifoldPoint
     */
    public b2ManifoldPoint baseSeparation(float value) {
        nbaseSeparation(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code normalImpulse}
     *
     * @param value float
     * @return b2ManifoldPoint
     */
    public b2ManifoldPoint normalImpulse(float value) {
        nnormalImpulse(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code tangentImpulse}
     *
     * @param value float
     * @return b2ManifoldPoint
     */
    public b2ManifoldPoint tangentImpulse(float value) {
        ntangentImpulse(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code totalNormalImpulse}
     *
     * @param value float
     * @return b2ManifoldPoint
     */
    public b2ManifoldPoint totalNormalImpulse(float value) {
        ntotalNormalImpulse(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code normalVelocity}
     *
     * @param value float
     * @return b2ManifoldPoint
     */
    public b2ManifoldPoint normalVelocity(float value) {
        nnormalVelocity(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code id}
     *
     * @param value short
     * @return b2ManifoldPoint
     */
    public b2ManifoldPoint id(short value) {
        nid(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code persisted}
     *
     * @param value boolean
     * @return b2ManifoldPoint
     */
    public b2ManifoldPoint persisted(boolean value) {
        npersisted(address(), value);
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
    protected b2ManifoldPoint create(long address, Pointer ptr) {
        return ptr == null ? new b2ManifoldPoint(address) : new b2ManifoldPoint(ptr);
    }
        // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2ManifoldPoint
     */
    private static b2ManifoldPoint factory() {
        return new b2ManifoldPoint(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2ManifoldPoint
     */
    public static b2ManifoldPoint createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2ManifoldPoint(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ManifoldPoint}.
     *
     * @param alloc Custom memory manager
     * @return b2ManifoldPoint
     */
    public static b2ManifoldPoint alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2ManifoldPoint(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2ManifoldPoint}.
     *
     * @param arean arena
     * @return b2ManifoldPoint
     */
    public static b2ManifoldPoint calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2ManifoldPoint(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ManifoldPoint}.
     *
     * @return b2ManifoldPoint
     */
    public static b2ManifoldPoint malloc() {
        return new b2ManifoldPoint(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ManifoldPoint}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ManifoldPoint}.
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
     * Reserve an amount n of memory for the object {@code b2ManifoldPoint}.
     *
     * @param capacity Number of elements
     * @param arena Arean
     * @return Buffer
     */
    public static Buffer calloc(int capacity, ArenaAlloc arena) {
        long ptr = arena.ncalloc(ALIGNOF, capacity, SIZEOF);
        return new Buffer(ptr, capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ManifoldPoint}.
     *
     * @param address Buffer address
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : new Buffer(address, capacity);
    }

    // -----------------------------------
    
    public static b2Vec2 nanchorA(long address) { return b2Vec2.createSafe(() -> address + ANCHOR_A); }
    public static b2Vec2 nanchorB(long address) { return b2Vec2.createSafe(() -> address + ANCHOR_B); }
    public static float nseparation(long address) { return memGetFloat(address + SEPARATION); }
    public static float nbaseSeparation(long address) { return memGetFloat(address + BASE_SEPARATION); }
    public static float nnormalImpulse(long address) { return memGetFloat(address + NORMAL_IMPULSE); }
    public static float ntangentImpulse(long address) { return memGetFloat(address + TANGENT_IMPULSE); }
    public static float ntotalNormalImpulse(long address) { return memGetFloat(address + TOTAL_NORMAL_IMPULSE); }
    public static float nnormalVelocity(long address) { return memGetFloat(address + NORMAL_VELOCITY); }
    public static short nid(long address) { return memGetShort(address + ID); }
    public static boolean npersisted(long address) { return memGetByte(address + PERSISTED) != 0; }

    public static void nanchorA(long address, b2Vec2 value) { nmemcpy(address + ANCHOR_A, value.address(), b2Vec2.SIZEOF); }
    public static void nanchorB(long address, b2Vec2 value) { nmemcpy(address + ANCHOR_B, value.address(), b2Vec2.SIZEOF); }
    public static void nseparation(long address, float value) { memPutFloat(address + SEPARATION, value); }
    public static void nbaseSeparation(long address, float value) { memPutFloat(address + BASE_SEPARATION, value); }
    public static void nnormalImpulse(long address, float value) { memPutFloat(address + NORMAL_IMPULSE, value); }
    public static void ntangentImpulse(long address, float value) { memPutFloat(address + TANGENT_IMPULSE, value); }
    public static void ntotalNormalImpulse(long address, float value) { memPutFloat(address + TOTAL_NORMAL_IMPULSE, value); }
    public static void nnormalVelocity(long address, float value) { memPutFloat(address + NORMAL_VELOCITY, value); }
    public static void nid(long address, short value) { memPutShort(address + ID, value); }
    public static void npersisted(long address, boolean value) { memPutByte(address + PERSISTED, (byte) (value ? 1 : 0)); }
    
    // -----------------------------------

    /** An array of {@code b2ManifoldPoint} structs. */
    public static class Buffer extends StructBuffer<b2ManifoldPoint, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2ManifoldPoint ELEMENT_FACTORY = b2ManifoldPoint.factory();

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
        protected b2ManifoldPoint getElementFactory() {
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
