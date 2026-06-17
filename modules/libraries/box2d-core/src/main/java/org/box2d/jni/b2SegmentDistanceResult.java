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
import org.box2d.jni.readonly.ConstB2SegmentDistanceResult;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2SegmentDistanceResult
 * {
 *     b2Vec2 closest1;
 *     b2Vec2 closest2;
 *     float fraction1;
 *     float fraction2;
 *     float distanceSquared;
 * } b2SegmentDistanceResult;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2SegmentDistanceResult extends Struct<b2SegmentDistanceResult> implements ConstB2SegmentDistanceResult {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            CLOSEST1,
            CLOSEST2,
            FRACTION1,
            FRACTION2,
            DISTANCE_SQUARED;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4),
                __member(4),
                __member(4)
        );

        CLOSEST1 = layout.offsetof(0);
        CLOSEST2 = layout.offsetof(1);
        FRACTION1 = layout.offsetof(2);
        FRACTION2 = layout.offsetof(3);
        DISTANCE_SQUARED = layout.offsetof(4);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2SegmentDistanceResult(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2SegmentDistanceResult(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2SegmentDistanceResult(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code closest1} */
    @Override
    public b2Vec2 closest1() { return nclosest1(address()); }
    /** @return Returns the property {@code closest2} */
    @Override
    public b2Vec2 closest2() { return nclosest2(address()); }
    /** @return Returns the property {@code fraction1} */
    @Override
    public float fraction1() { return nfraction1(address()); }
    /** @return Returns the property {@code fraction2} */
    @Override
    public float fraction2() { return nfraction2(address()); }
    /** @return Returns the property {@code distanceSquared} */
    @Override
    public float distanceSquared() { return ndistanceSquared(address()); }

    /**
     * Set the value of property {@code closest1}
     * 
     * @param value b2Vec2
     * @return b2SegmentDistanceResult
     */
    public b2SegmentDistanceResult closest1(b2Vec2 value) {
        nclosest1(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code closest2}
     * 
     * @param value b2Vec2
     * @return b2SegmentDistanceResult
     */
    public b2SegmentDistanceResult closest2(b2Vec2 value) {
        nclosest2(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code fraction1}
     * 
     * @param value float
     * @return b2SegmentDistanceResult
     */
    public b2SegmentDistanceResult fraction1(float value) {
        nfraction1(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code fraction2}
     * 
     * @param value float
     * @return b2SegmentDistanceResult
     */
    public b2SegmentDistanceResult fraction2(float value) {
        nfraction2(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code distanceSquared}
     * 
     * @param value float
     * @return b2SegmentDistanceResult
     */
    public b2SegmentDistanceResult distanceSquared(float value) {
        ndistanceSquared(address(), value);
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
    protected b2SegmentDistanceResult create(long address, Pointer ptr) {
        return ptr == null ? new b2SegmentDistanceResult(address) : new b2SegmentDistanceResult(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2SegmentDistanceResult
     */
    private static b2SegmentDistanceResult factory() {
        return new b2SegmentDistanceResult(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2SegmentDistanceResult
     */
    public static b2SegmentDistanceResult createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2SegmentDistanceResult(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2SegmentDistanceResult}.
     *
     * @param alloc Custom memory manager
     * @return b2SegmentDistanceResult
     */
    public static b2SegmentDistanceResult alloc(AllocFunc alloc) {
        return new b2SegmentDistanceResult(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2SegmentDistanceResult}.
     *
     * @return b2SegmentDistanceResult
     */
    public static b2SegmentDistanceResult malloc() {
        return new b2SegmentDistanceResult(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2SegmentDistanceResult}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2SegmentDistanceResult}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static b2Vec2 nclosest1(long address)          { return b2Vec2.createSafe(() -> address + CLOSEST1); }
    public static b2Vec2 nclosest2(long address)          { return b2Vec2.createSafe(() -> address + CLOSEST2); }
    public static float nfraction1(long address)          { return memGetFloat(address + FRACTION1); }
    public static float nfraction2(long address)          { return memGetFloat(address + FRACTION2); }
    public static float ndistanceSquared(long address)    { return memGetFloat(address + DISTANCE_SQUARED); }

    public static void nclosest1(long address, b2Vec2 value)       { nmemcpy(address + CLOSEST1, value.address(), b2Vec2.SIZEOF); }
    public static void nclosest2(long address, b2Vec2 value)       { nmemcpy(address + CLOSEST2, value.address(), b2Vec2.SIZEOF); }
    public static void nfraction1(long address, float value)       { memPutFloat(address + FRACTION1, value); }
    public static void nfraction2(long address, float value)       { memPutFloat(address + FRACTION2, value); }
    public static void ndistanceSquared(long address, float value) { memPutFloat(address + DISTANCE_SQUARED, value); }

    // -----------------------------------

    /** An array of {@code b2SegmentDistanceResult} structs. */
    public static class Buffer extends StructBuffer<b2SegmentDistanceResult, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2SegmentDistanceResult ELEMENT_FACTORY = b2SegmentDistanceResult.factory();

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
        protected b2SegmentDistanceResult getElementFactory() {
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
