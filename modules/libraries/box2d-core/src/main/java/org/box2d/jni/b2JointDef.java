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
import org.box2d.jni.readonly.ConstB2JointDef;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2JointDef
 * {
 * 	void* userData;
 * 	b2BodyId bodyIdA;
 * 	b2BodyId bodyIdB;
 * 	b2Transform localFrameA;
 * 	b2Transform localFrameB;
 * 	float forceThreshold;
 * 	float torqueThreshold;
 * 	float constraintHertz;
 * 	float constraintDampingRatio;
 * 	float drawScale;
 * 	bool collideConnected;
 * } b2JointDef;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2JointDef extends Struct<b2JointDef> implements ConstB2JointDef {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            USER_DATA,
            BODY_ID_A,
            BODY_ID_B,
            LOCAL_FRAME_A,
            LOCAL_FRAME_B,
            FORCE_THRESHOLD,
            TORQUE_THRESHOLD,
            CONSTRAINT_HERTZ,
            CONSTRAINT_DAMPING_RATIO,
            DRAW_SCALE,
            COLLIDE_CONNECTED;

    static {
        Layout layout = __struct(
                __member(POINTER_SIZE),
                __member(b2BodyId.SIZEOF, b2BodyId.ALIGNOF),
                __member(b2BodyId.SIZEOF, b2BodyId.ALIGNOF),
                __member(b2Transform.SIZEOF, b2Transform.ALIGNOF),
                __member(b2Transform.SIZEOF, b2Transform.ALIGNOF),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(1)
        );

        USER_DATA = layout.offsetof(0);
        BODY_ID_A = layout.offsetof(1);
        BODY_ID_B = layout.offsetof(2);
        LOCAL_FRAME_A = layout.offsetof(3);
        LOCAL_FRAME_B = layout.offsetof(4);
        FORCE_THRESHOLD = layout.offsetof(5);
        TORQUE_THRESHOLD = layout.offsetof(6);
        CONSTRAINT_HERTZ = layout.offsetof(7);
        CONSTRAINT_DAMPING_RATIO = layout.offsetof(8);
        DRAW_SCALE = layout.offsetof(9);
        COLLIDE_CONNECTED = layout.offsetof(10);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2JointDef(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2JointDef(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2JointDef(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code userData} */
    @Override
    public long userData() { return nuserData(address()); }
    /** @return Returns the property {@code bodyIdA} */
    @Override
    public b2BodyId bodyIdA() { return nbodyIdA(address()); }
    /** @return Returns the property {@code bodyIdB} */
    @Override
    public b2BodyId bodyIdB() { return nbodyIdB(address()); }
    /** @return Returns the property {@code localFrameA} */
    @Override
    public b2Transform localFrameA() { return nlocalFrameA(address()); }
    /** @return Returns the property {@code localFrameB} */
    @Override
    public b2Transform localFrameB() { return nlocalFrameB(address()); }
    /** @return Returns the property {@code forceThreshold} */
    @Override
    public float forceThreshold() { return nforceThreshold(address()); }
    /** @return Returns the property {@code torqueThreshold} */
    @Override
    public float torqueThreshold() { return ntorqueThreshold(address()); }
    /** @return Returns the property {@code constraintHertz} */
    @Override
    public float constraintHertz() { return nconstraintHertz(address()); }
    /** @return Returns the property {@code constraintDampingRatio} */
    @Override
    public float constraintDampingRatio() { return nconstraintDampingRatio(address()); }
    /** @return Returns the property {@code drawScale} */
    @Override
    public float drawScale() { return ndrawScale(address()); }
    /** @return Returns the property {@code collideConnected} */
    @Override
    public boolean collideConnected() { return ncollideConnected(address()); }

    /**
     * Set the value of property {@code userData}
     *
     * @param value long
     * @return b2JointDef
     */
    public b2JointDef userData(long value) {
        nuserData(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code bodyIdA}
     *
     * @param value b2BodyId
     * @return b2JointDef
     */
    public b2JointDef bodyIdA(b2BodyId value) {
        nbodyIdA(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code bodyIdB}
     *
     * @param value b2BodyId
     * @return b2JointDef
     */
    public b2JointDef bodyIdB(b2BodyId value) {
        nbodyIdB(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code localFrameA}
     *
     * @param value b2Transform
     * @return b2JointDef
     */
    public b2JointDef localFrameA(b2Transform value) {
        nlocalFrameA(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code localFrameB}
     *
     * @param value b2Transform
     * @return b2JointDef
     */
    public b2JointDef localFrameB(b2Transform value) {
        nlocalFrameB(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code forceThreshold}
     *
     * @param value float
     * @return b2JointDef
     */
    public b2JointDef forceThreshold(float value) {
        nforceThreshold(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code torqueThreshold}
     *
     * @param value float
     * @return b2JointDef
     */
    public b2JointDef torqueThreshold(float value) {
        ntorqueThreshold(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code constraintHertz}
     *
     * @param value float
     * @return b2JointDef
     */
    public b2JointDef constraintHertz(float value) {
        nconstraintHertz(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code constraintDampingRatio}
     *
     * @param value float
     * @return b2JointDef
     */
    public b2JointDef constraintDampingRatio(float value) {
        nconstraintDampingRatio(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawScale}
     *
     * @param value float
     * @return b2JointDef
     */
    public b2JointDef drawScale(float value) {
        ndrawScale(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code collideConnected}
     *
     * @param value boolean
     * @return b2JointDef
     */
    public b2JointDef collideConnected(boolean value) {
        ncollideConnected(address(), value);
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
    protected b2JointDef create(long address, Pointer ptr) {
        return ptr == null ? new b2JointDef(address) : new b2JointDef(ptr);
    }
    
    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2JointDef
     */
    private static b2JointDef factory() {
        return new b2JointDef(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2JointDef
     */
    public static b2JointDef createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2JointDef(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2JointDef}.
     *
     * @param alloc Custom memory manager
     * @return b2JointDef
     */
    public static b2JointDef alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2JointDef(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2JointDef}.
     *
     * @param arean arena
     * @return b2JointDef
     */
    public static b2JointDef calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2JointDef(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2JointDef}.
     *
     * @return b2JointDef
     */
    public static b2JointDef malloc() {
        return new b2JointDef(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2JointDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2JointDef}.
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
     * Reserve an amount n of memory for the object {@code b2JointDef}.
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

    public static long nuserData(long address) { return memGetAddress(address + USER_DATA); }
    public static b2BodyId nbodyIdA(long address) { return b2BodyId.createSafe(() -> address + BODY_ID_A); }
    public static b2BodyId nbodyIdB(long address) { return b2BodyId.createSafe(() -> address + BODY_ID_B); }
    public static b2Transform nlocalFrameA(long address) { return b2Transform.createSafe(() -> address + LOCAL_FRAME_A); }
    public static b2Transform nlocalFrameB(long address) { return b2Transform.createSafe(() -> address + LOCAL_FRAME_B); }
    public static float nforceThreshold(long address) { return memGetFloat(address + FORCE_THRESHOLD); }
    public static float ntorqueThreshold(long address) { return memGetFloat(address + TORQUE_THRESHOLD); }
    public static float nconstraintHertz(long address) { return memGetFloat(address + CONSTRAINT_HERTZ); }
    public static float nconstraintDampingRatio(long address) { return memGetFloat(address + CONSTRAINT_DAMPING_RATIO); }
    public static float ndrawScale(long address) { return memGetFloat(address + DRAW_SCALE); }
    public static boolean ncollideConnected(long address) { return memGetByte(address + COLLIDE_CONNECTED) != 0; }

    public static void nuserData(long address, long value) { memPutAddress(address + USER_DATA, value); }
    public static void nbodyIdA(long address, b2BodyId value) { nmemcpy(address + BODY_ID_A, value.address(), b2BodyId.SIZEOF); }
    public static void nbodyIdB(long address, b2BodyId value) { nmemcpy(address + BODY_ID_B, value.address(), b2BodyId.SIZEOF); }
    public static void nlocalFrameA(long address, b2Transform value) { nmemcpy(address + LOCAL_FRAME_A, value.address(), b2Transform.SIZEOF); }
    public static void nlocalFrameB(long address, b2Transform value) { nmemcpy(address + LOCAL_FRAME_B, value.address(), b2Transform.SIZEOF); }
    public static void nforceThreshold(long address, float value) { memPutFloat(address + FORCE_THRESHOLD, value); }
    public static void ntorqueThreshold(long address, float value) { memPutFloat(address + TORQUE_THRESHOLD, value); }
    public static void nconstraintHertz(long address, float value) { memPutFloat(address + CONSTRAINT_HERTZ, value); }
    public static void nconstraintDampingRatio(long address, float value) { memPutFloat(address + CONSTRAINT_DAMPING_RATIO, value); }
    public static void ndrawScale(long address, float value) { memPutFloat(address + DRAW_SCALE, value); }
    public static void ncollideConnected(long address, boolean value) { memPutByte(address + COLLIDE_CONNECTED, (byte) (value ? 1 : 0)); }

    // -----------------------------------

    /** An array of {@code b2JointDef} structs. */
    public static class Buffer extends StructBuffer<b2JointDef, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2JointDef ELEMENT_FACTORY = b2JointDef.factory();

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
        protected b2JointDef getElementFactory() {
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
