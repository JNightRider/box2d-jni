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
 * typedef struct b2RecPlayerInfo
 * {
 *     int frameCount;      // total recorded steps
 *     int workerCount;     // worker count used for the replay world
 *     float timeStep;      // dt of the recorded steps
 *     int subStepCount;    // recorded sub-steps
 *     float lengthScale;   // length units per meter in effect when recorded
 *     b2AABB bounds;       // accumulated world bounds over the recording, zero-extent if unavailable
 * } b2RecPlayerInfo;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2RecPlayerInfo extends Struct<b2RecPlayerInfo> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            FRAME_COUNT,
            WORKER_COUNT,
            TIME_STEP,
            SUB_STEP_COUNT,
            LENGTH_SCALE,
            BOUNDS;

    static {
        Layout layout = __struct(
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(b2AABB.SIZEOF, b2AABB.ALIGNOF)
        );

        FRAME_COUNT = layout.offsetof(0);
        WORKER_COUNT = layout.offsetof(1);
        TIME_STEP = layout.offsetof(2);
        SUB_STEP_COUNT = layout.offsetof(3);
        LENGTH_SCALE = layout.offsetof(4);
        BOUNDS = layout.offsetof(5);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2RecPlayerInfo(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2RecPlayerInfo(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2RecPlayerInfo(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code frameCount} */
    public int frameCount() { return nframeCount(address()); }
    /** @return Returns the property {@code workerCount} */
    public int workerCount() { return nworkerCount(address()); }
    /** @return Returns the property {@code timeStep} */
    public float timeStep() { return ntimeStep(address()); }
    /** @return Returns the property {@code subStepCount} */
    public int subStepCount() { return nsubStepCount(address()); }
    /** @return Returns the property {@code lengthScale} */
    public float lengthScale() { return nlengthScale(address()); }
    /** @return Returns the property {@code bounds} */
    public b2AABB bounds() { return nbounds(address()); }

    /**
     * Set the value of property {@code frameCount}
     *
     * @param value int
     * @return b2RecPlayerInfo
     */
    public b2RecPlayerInfo frameCount(int value) {
        nframeCount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code workerCount}
     *
     * @param value int
     * @return b2RecPlayerInfo
     */
    public b2RecPlayerInfo workerCount(int value) {
        nworkerCount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code timeStep}
     *
     * @param value float
     * @return b2RecPlayerInfo
     */
    public b2RecPlayerInfo timeStep(float value) {
        ntimeStep(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code subStepCount}
     *
     * @param value int
     * @return b2RecPlayerInfo
     */
    public b2RecPlayerInfo subStepCount(int value) {
        nsubStepCount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code lengthScale}
     *
     * @param value float
     * @return b2RecPlayerInfo
     */
    public b2RecPlayerInfo lengthScale(float value) {
        nlengthScale(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code bounds}
     *
     * @param value b2AABB
     * @return b2RecPlayerInfo
     */
    public b2RecPlayerInfo bounds(b2AABB value) {
        nbounds(address(), value);
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
    protected b2RecPlayerInfo create(long address, Pointer ptr) {
        return ptr == null ? new b2RecPlayerInfo(address) : new b2RecPlayerInfo(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2JointDef
     */
    private static b2RecPlayerInfo factory() {
        return new b2RecPlayerInfo(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2JointDef
     */
    public static b2RecPlayerInfo createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2RecPlayerInfo(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2RecPlayerInfo}.
     *
     * @param alloc Custom memory manager
     * @return b2RecPlayerInfo
     */
    public static b2RecPlayerInfo alloc(AllocFunc alloc) {
        return new b2RecPlayerInfo(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2RecPlayerInfo}.
     *
     * @return b2RecPlayerInfo
     */
    public static b2RecPlayerInfo malloc() {
        return new b2RecPlayerInfo(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2RecPlayerInfo}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2RecPlayerInfo}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static int nframeCount(long address)        { return memGetInt(address + FRAME_COUNT); }
    public static int nworkerCount(long address)       { return memGetInt(address + WORKER_COUNT); }
    public static float ntimeStep(long address)        { return memGetFloat(address + TIME_STEP); }
    public static int nsubStepCount(long address)      { return memGetInt(address + SUB_STEP_COUNT); }
    public static float nlengthScale(long address)     { return memGetFloat(address + LENGTH_SCALE); }
    public static b2AABB nbounds(long address)         { return b2AABB.createSafe(() -> address + BOUNDS); }

    public static void nframeCount(long address, int value)     { memPutInt(address + FRAME_COUNT, value); }
    public static void nworkerCount(long address, int value)     { memPutInt(address + WORKER_COUNT, value); }
    public static void ntimeStep(long address, float value)     { memPutFloat(address + TIME_STEP, value); }
    public static void nsubStepCount(long address, int value)   { memPutInt(address + SUB_STEP_COUNT, value); }
    public static void nlengthScale(long address, float value)  { memPutFloat(address + LENGTH_SCALE, value); }
    public static void nbounds(long address, b2AABB value)      { nmemcpy(address + BOUNDS, value.address(), b2AABB.SIZEOF); }

    // -----------------------------------

    /** An array of {@code b2RecPlayerInfo} structs. */
    public static class Buffer extends StructBuffer<b2RecPlayerInfo, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2RecPlayerInfo ELEMENT_FACTORY = b2RecPlayerInfo.factory();

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
        protected b2RecPlayerInfo getElementFactory() {
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
