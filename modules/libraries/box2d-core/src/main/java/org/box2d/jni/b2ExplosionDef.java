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
import org.box2d.jni.readonly.ConstB2ExplosionDef;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2ExplosionDef
 * {
 *     uint64_t maskBits;
 *     b2Pos position;
 *     float radius;
 *     float falloff;
 *     float impulsePerLength;
 * } b2ExplosionDef;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2ExplosionDef extends Struct<b2ExplosionDef> implements ConstB2ExplosionDef {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            MASK_BITS,
            POSITION,
            RADIUS,
            FALLOFF,
            IMPULSE_PER_LENGTH;

    static {
        Layout layout = __struct(
                __member(VarType.Int64t.sizeof()),
                __member(b2Pos.DSIZEOF, b2Pos.DALIGNOF),
                __member(4),
                __member(4),
                __member(4)
        );

        MASK_BITS = layout.offsetof(0);
        POSITION = layout.offsetof(1);
        RADIUS = layout.offsetof(2);
        FALLOFF = layout.offsetof(3);
        IMPULSE_PER_LENGTH = layout.offsetof(4);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2ExplosionDef(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2ExplosionDef(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2ExplosionDef(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code maskBits} */
    @Override
    public long maskBits() { return nmaskBits(address()); }
    /** @return Returns the property {@code position} */
    @Override
    public b2Pos position() { return nposition(address()); }
    /** @return Returns the property {@code radius} */
    @Override
    public float radius() { return nradius(address()); }
    /** @return Returns the property {@code falloff} */
    @Override
    public float falloff() { return nfalloff(address()); }
    /** @return Returns the property {@code impulsePerLength} */
    @Override
    public float impulsePerLength() { return nimpulsePerLength(address()); }

    /**
     * Set the value of property {@code maskBits}
     *
     * @param value long
     * @return b2ExplosionDef
     */
    public b2ExplosionDef maskBits(long value) {
        nmaskBits(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code position}
     *
     * @param value b2Vec2
     * @return b2ExplosionDef
     */
    public b2ExplosionDef position(b2Pos value) {
        nposition(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code radius}
     *
     * @param value float
     * @return b2ExplosionDef
     */
    public b2ExplosionDef radius(float value) {
        nradius(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code falloff}
     *
     * @param value float
     * @return b2ExplosionDef
     */
    public b2ExplosionDef falloff(float value) {
        nfalloff(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code impulsePerLength}
     *
     * @param value float
     * @return b2ExplosionDef
     */
    public b2ExplosionDef impulsePerLength(float value) {
        nimpulsePerLength(address(), value);
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
    protected b2ExplosionDef create(long address, Pointer ptr) {
        return ptr == null ? new b2ExplosionDef(address) : new b2ExplosionDef(ptr);
    }
    
        // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2ExplosionDef
     */
    private static b2ExplosionDef factory() {
        return new b2ExplosionDef(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2ExplosionDef
     */
    public static b2ExplosionDef createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2ExplosionDef(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ExplosionDef}.
     *
     * @param alloc Custom memory manager
     * @return b2ExplosionDef
     */
    public static b2ExplosionDef alloc(AllocFunc alloc) {
        return new b2ExplosionDef(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2ExplosionDef}.
     *
     * @return b2ExplosionDef
     */
    public static b2ExplosionDef malloc() {
        return new b2ExplosionDef(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ExplosionDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ExplosionDef}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static long nmaskBits(long address)                      { return memGetLong(address + MASK_BITS);            }
    public static b2Pos nposition(long address)                     { return b2Pos.ncreateSafe(() -> address + POSITION);}
    public static float nradius(long address)                       { return memGetFloat(address + RADIUS);              }
    public static float nfalloff(long address)                      { return memGetFloat(address + FALLOFF);             }
    public static float nimpulsePerLength(long address)             { return memGetFloat(address + IMPULSE_PER_LENGTH);  }

    public static void nmaskBits(long address, long value)          { memPutLong(address + MASK_BITS, value);           }
    public static void nposition(long address, b2Pos value)         { nmemcpy(address + POSITION, value.address(), b2Pos.DSIZEOF); }
    public static void nradius(long address, float value)           { memPutFloat(address + RADIUS, value);             }
    public static void nfalloff(long address, float value)          { memPutFloat(address + FALLOFF, value);            }
    public static void nimpulsePerLength(long address, float value) { memPutFloat(address + IMPULSE_PER_LENGTH, value); }

    // -----------------------------------

    /** An array of {@code b2ExplosionDef} structs. */
    public static class Buffer extends StructBuffer<b2ExplosionDef, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2ExplosionDef ELEMENT_FACTORY = b2ExplosionDef.factory();

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
        protected b2ExplosionDef getElementFactory() {
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
