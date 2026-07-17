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
 * typedef struct b2WorldCastOutput
 * {
 * 	b2Vec2 normal;	/// The surface normal at the hit point
 * 	b2Pos point;	/// The surface hit point in world space
 * 	float fraction; /// The fraction of the input translation at collision
 * 	int iterations; /// The number of iterations used
 * 	bool hit;	/// Did the cast hit?
 * } b2WorldCastOutput;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.1
 */
public class b2WorldCastOutputI extends Struct<b2WorldCastOutputI> implements b2WorldCastOutput<b2WorldCastOutputI, b2Pos> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            NORMAL,
            POINT,
            FRACTION,
            ITERATIONS,
            HIT;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Pos.DSIZEOF, b2Pos.DALIGNOF),
                __member(4),
                __member(4),
                __member(1)
        );

        NORMAL = layout.offsetof(0);
        POINT = layout.offsetof(1);
        FRACTION = layout.offsetof(2);
        ITERATIONS = layout.offsetof(3);
        HIT = layout.offsetof(4);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2WorldCastOutputI(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2WorldCastOutputI(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2WorldCastOutputI(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code normal} */
    @Override
    public b2Vec2 normal() { return nnormal(address()); }
    /** @return Returns the property {@code point} */
    @Override
    public b2Pos point() { return npoint(address()); }
    /** @return Returns the property {@code fraction} */
    @Override
    public float fraction() { return nfraction(address()); }
    /** @return Returns the property {@code iterations} */
    @Override
    public int iterations() { return niterations(address()); }
    /** @return Returns the property {@code hit} */
    @Override
    public boolean hit() { return nhit(address()); }

    /**
     * Set the value of property {@code normal}
     * 
     * @param value b2Vec2
     * @return b2WorldCastOutputI
     */
    @Override
    public b2WorldCastOutputI normal(b2Vec2 value) {
        nnormal(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code point}
     * 
     * @param value b2Vec2
     * @return b2WorldCastOutputI
     */
    @Override
    public b2WorldCastOutputI point(b2Pos value) {
        npoint(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code fraction}
     * 
     * @param value float
     * @return b2WorldCastOutputI
     */
    @Override
    public b2WorldCastOutputI fraction(float value) {
        nfraction(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code iterations}
     * 
     * @param value int
     * @return b2WorldCastOutputI
     */
    @Override
    public b2WorldCastOutputI iterations(int value) {
        niterations(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code hit}
     * 
     * @param value boolean
     * @return b2WorldCastOutputI
     */
    @Override
    public b2WorldCastOutputI hit(boolean value) {
        nhit(address(), value);
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
    protected b2WorldCastOutputI create(long address, Pointer ptr) {
        return ptr == null ? new b2WorldCastOutputI(address) : new b2WorldCastOutputI(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2WorldCastOutputI
     */
    private static b2WorldCastOutputI factory() {
        return new b2WorldCastOutputI(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2WorldCastOutputI
     */
    public static b2WorldCastOutputI createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2WorldCastOutputI(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2WorldCastOutputI}.
     *
     * @param alloc Custom memory manager
     * @return b2WorldCastOutputI
     */
    public static b2WorldCastOutputI alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2WorldCastOutputI(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2WorldCastOutputI}.
     *
     * @return b2WorldCastOutputI
     */
    public static b2WorldCastOutputI calloc() {
        return new b2WorldCastOutputI(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2WorldCastOutputI}.
     *
     * @param arean arena
     * @return b2WorldCastOutputI
     */
    public static b2WorldCastOutputI calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2WorldCastOutputI(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2WorldCastOutputI}.
     *
     * @return b2WorldCastOutputI
     */
    public static b2WorldCastOutputI malloc() {
        return new b2WorldCastOutputI(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2WorldCastOutputI}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2WorldCastOutputI}.
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
     * Reserve an amount n of memory for the object {@code b2WorldCastOutputI}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2WorldCastOutputI}.
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

    public static b2Vec2 nnormal(long address)      { return b2Vec2.createSafe(() -> address + NORMAL);      }
    public static b2Pos npoint(long address)        { return b2Pos.createSafe(() -> address + POINT);       }
    public static float nfraction(long address)     { return memGetFloat(address + FRACTION);                }
    public static int niterations(long address)     { return memGetInt(address + ITERATIONS);                }
    public static boolean nhit(long address)        { return memGetByte(address + HIT) != 0;                 }

    public static void nnormal(long address, b2Vec2 value)   { nmemcpy(address + NORMAL, value.address(), b2Vec2.SIZEOF); }
    public static void npoint(long address, b2Pos value)     { nmemcpy(address + POINT, value.address(), b2Pos.DSIZEOF);  }
    public static void nfraction(long address, float value)  { memPutFloat(address + FRACTION, value);                          }
    public static void niterations(long address, int value)  { memPutInt(address + ITERATIONS, value);                          }
    public static void nhit(long address, boolean value)     { memPutByte(address + HIT, (byte) (value ? 1 : 0));               }

    // -----------------------------------

    /** An array of {@code b2WorldCastOutputI} structs. */
    public static class Buffer extends StructBuffer<b2WorldCastOutputI, Buffer> implements b2WorldCastOutput.ConstBuffer<b2WorldCastOutputI, Buffer>,
                                                                                           b2WorldCastOutput.Buffer<b2WorldCastOutputI, Buffer>,
                                                                                           JNINative {

        /** An element that provides information about the structure. */
        private static final b2WorldCastOutputI ELEMENT_FACTORY = b2WorldCastOutputI.factory();

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
        protected b2WorldCastOutputI getElementFactory() {
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
