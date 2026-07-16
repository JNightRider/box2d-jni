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
import org.box2d.jni.readonly.ConstB2DistanceOutput;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2DistanceOutput
 * {
 *     b2Vec2 pointA;      /// Closest point on shapeA
 *     b2Vec2 pointB;      /// Closest point on shapeB
 *     b2Vec2 normal;      /// Normal vector that points from A to B. Invalid if distance is zero.
 *     float distance;     /// The final distance, zero if overlapped
 *     int iterations;     /// Number of GJK iterations used
 *     int simplexCount;   /// The number of simplexes stored in the simplex array
 * } b2DistanceOutput;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2DistanceOutput extends Struct<b2DistanceOutput> implements ConstB2DistanceOutput {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            POINT_A,
            POINT_B,
            NORMAL,
            DISTANCE,
            ITERATIONS,
            SIMPLEX_COUNT;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4),
                __member(4),
                __member(4)
        );

        POINT_A = layout.offsetof(0);
        POINT_B = layout.offsetof(1);
        NORMAL = layout.offsetof(2);
        DISTANCE = layout.offsetof(3);
        ITERATIONS = layout.offsetof(4);
        SIMPLEX_COUNT = layout.offsetof(5);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2DistanceOutput(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2DistanceOutput(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2DistanceOutput(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code pointA} */
    @Override
    public b2Vec2 pointA() { return npointA(address());}
    /** @return Returns the property {@code pointB} */
    @Override
    public b2Vec2 pointB() { return npointB(address());}
    /** @return Returns the property {@code normal} */
    @Override
    public b2Vec2 normal() { return nnormal(address());}
    /** @return Returns the property {@code distance} */
    @Override
    public float distance() { return ndistance(address());}
    /** @return Returns the property {@code iterations} */
    @Override
    public int iterations() { return niterations(address());}
    /** @return Returns the property {@code simplexCount} */
    @Override
    public int simplexCount() { return nsimplexCount(address());}

    /**
     * Set the value of property {@code pointA}
     *
     * @param value b2Vec2
     * @return b2DistanceOutput
     */
    public b2DistanceOutput pointA(b2Vec2 value) {
        npointA(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code pointB}
     *
     * @param value b2Vec2
     * @return b2DistanceOutput
     */
    public b2DistanceOutput pointB(b2Vec2 value) {
        npointB(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code normal}
     *
     * @param value b2Vec2
     * @return b2DistanceOutput
     */
    public b2DistanceOutput normal(b2Vec2 value) {
        nnormal(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code distance}
     *
     * @param value float
     * @return b2DistanceOutput
     */
    public b2DistanceOutput distance(float value) {
        ndistance(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code iterations}
     *
     * @param value int
     * @return b2DistanceOutput
     */
    public b2DistanceOutput iterations(int value) {
        niterations(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code simplexCount}
     *
     * @param value int
     * @return b2DistanceOutput
     */
    public b2DistanceOutput simplexCount(int value) {
        nsimplexCount(address(), value);
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
    protected b2DistanceOutput create(long address, Pointer ptr) {
        return ptr == null ? new b2DistanceOutput(address) : new b2DistanceOutput(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2DistanceOutput
     */
    private static b2DistanceOutput factory() {
        return new b2DistanceOutput(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2DistanceOutput
     */
    public static b2DistanceOutput createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2DistanceOutput(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2DistanceOutput}.
     *
     * @param alloc Custom memory manager
     * @return b2DistanceOutput
     */
    public static b2DistanceOutput alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2DistanceOutput(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2DistanceOutput}.
     *
     * @return b2DistanceOutput
     */
    public static b2DistanceOutput calloc() {
        return new b2DistanceOutput(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2DistanceOutput}.
     *
     * @param arean arena
     * @return b2DistanceOutput
     */
    public static b2DistanceOutput calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2DistanceOutput(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2DistanceOutput}.
     *
     * @return b2DistanceOutput
     */
    public static b2DistanceOutput malloc() {
        return new b2DistanceOutput(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2DistanceOutput}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2DistanceOutput}.
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
     * Reserve an amount n of memory for the object {@code b2DistanceOutput}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2DistanceOutput}.
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
    
    public static b2Vec2 npointA(long address) { return b2Vec2.createSafe(() -> address + POINT_A); }
    public static b2Vec2 npointB(long address) { return b2Vec2.createSafe(() -> address + POINT_B); }
    public static b2Vec2 nnormal(long address) { return b2Vec2.createSafe(() -> address + NORMAL); }
    public static float ndistance(long address) { return memGetFloat(address + DISTANCE); }
    public static int niterations(long address) { return memGetInt(address + ITERATIONS); }
    public static int nsimplexCount(long address) { return memGetInt(address + SIMPLEX_COUNT); }

    public static void npointA(long address, b2Vec2 value) { nmemcpy(address + POINT_A, value.address(), b2Vec2.SIZEOF); }
    public static void npointB(long address, b2Vec2 value) { nmemcpy(address + POINT_B, value.address(), b2Vec2.SIZEOF); }
    public static void nnormal(long address, b2Vec2 value) { nmemcpy(address + NORMAL, value.address(), b2Vec2.SIZEOF); }
    public static void ndistance(long address, float value) { memPutFloat(address + DISTANCE, value); }
    public static void niterations(long address, int value) { memPutInt(address + ITERATIONS, value); }
    public static void nsimplexCount(long address, int value) { memPutInt(address + SIMPLEX_COUNT, value); }
    
    // -----------------------------------

    /** An array of {@code b2DistanceOutput} structs. */
    public static class Buffer extends StructBuffer<b2DistanceOutput, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2DistanceOutput ELEMENT_FACTORY = b2DistanceOutput.factory();

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
        protected b2DistanceOutput getElementFactory() {
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
