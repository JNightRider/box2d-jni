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
 * typedef struct b2CastOutput
 * {
 *     b2Vec2 normal;
 *     b2Vec2 point;
 *     float fraction;
 *     int iterations;
 *     bool hit;
 * } b2CastOutput;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2CastOutput extends Struct<b2CastOutput> implements b2WorldCastOutput<b2CastOutput, b2Vec2> {

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
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
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
    public b2CastOutput(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2CastOutput(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2CastOutput(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code normal} */
    @Override
    public b2Vec2 normal() { return nnormal(address()); }
    /** @return Returns the property {@code point} */
    @Override
    public b2Vec2 point() { return npoint(address()); }
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
     * @return b2CastOutput
     */
    @Override
    public b2CastOutput normal(b2Vec2 value) {
        nnormal(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code point}
     * 
     * @param value b2Vec2
     * @return b2CastOutput
     */
    @Override
    public b2CastOutput point(b2Vec2 value) {
        npoint(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code fraction}
     * 
     * @param value float
     * @return b2CastOutput
     */
    @Override
    public b2CastOutput fraction(float value) {
        nfraction(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code iterations}
     * 
     * @param value int
     * @return b2CastOutput
     */
    @Override
    public b2CastOutput iterations(int value) {
        niterations(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code hit}
     * 
     * @param value boolean
     * @return b2CastOutput
     */
    @Override
    public b2CastOutput hit(boolean value) {
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
    protected b2CastOutput create(long address, Pointer ptr) {
        return ptr == null ? new b2CastOutput(address) : new b2CastOutput(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2CastOutput
     */
    private static b2CastOutput factory() {
        return new b2CastOutput(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2CastOutput
     */
    public static b2CastOutput createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2CastOutput(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2CastOutput}.
     *
     * @param alloc Custom memory manager
     * @return b2CastOutput
     */
    public static b2CastOutput alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2CastOutput(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2CastOutput}.
     *
     * @return b2CastOutput
     */
    public static b2CastOutput calloc() {
        return new b2CastOutput(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2CastOutput}.
     *
     * @param alloc arena
     * @return b2CastOutput
     */
    public static b2CastOutput calloc(ArenaAlloc alloc) {
        long ptr = alloc.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2CastOutput(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2CastOutput}.
     *
     * @return b2CastOutput
     */
    public static b2CastOutput malloc() {
        return new b2CastOutput(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2CastOutput}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2CastOutput}.
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
     * Reserve an amount n of memory for the object {@code b2CastOutput}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2CastOutput}.
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

    public static b2Vec2 nnormal(long address)      { return b2Vec2.createSafe(() -> address + NORMAL);      }
    public static b2Vec2 npoint(long address)       { return b2Vec2.createSafe(() -> address + POINT);       }
    public static float nfraction(long address)     { return memGetFloat(address + FRACTION);                }
    public static int niterations(long address)     { return memGetInt(address + ITERATIONS);                }
    public static boolean nhit(long address)        { return memGetByte(address + HIT) != 0;                 }

    public static void nnormal(long address, b2Vec2 value)   { nmemcpy(address + NORMAL, value.address(), b2Vec2.SIZEOF); }
    public static void npoint(long address, b2Vec2 value)    { nmemcpy(address + POINT, value.address(), b2Vec2.SIZEOF);  }
    public static void nfraction(long address, float value)  { memPutFloat(address + FRACTION, value);                          }
    public static void niterations(long address, int value)  { memPutInt(address + ITERATIONS, value);                          }
    public static void nhit(long address, boolean value)     { memPutByte(address + HIT, (byte) (value ? 1 : 0));               }

    // -----------------------------------

    /** An array of {@code b2CastOutput} structs. */
    public static class Buffer extends StructBuffer<b2CastOutput, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2CastOutput ELEMENT_FACTORY = b2CastOutput.factory();

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
        protected b2CastOutput getElementFactory() {
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
