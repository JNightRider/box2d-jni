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
import org.box2d.jni.readonly.ConstB2ShapeCastInput;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2ShapeCastInput
 * {
 *     b2ShapeProxy proxy;
 *     b2Vec2 translation;
 *     float maxFraction;
 *     bool canEncroach;
 * } b2ShapeCastInput;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2ShapeCastInput extends Struct<b2ShapeCastInput> implements ConstB2ShapeCastInput {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            PROXY,
            TRANSLATION,
            MAX_FRACTION,
            CAN_ENCROACH;

    static {
        Layout layout = __struct(
                __member(b2ShapeProxy.SIZEOF, b2ShapeProxy.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4),
                __member(1)
        );

        PROXY = layout.offsetof(0);
        TRANSLATION = layout.offsetof(1);
        MAX_FRACTION = layout.offsetof(2);
        CAN_ENCROACH = layout.offsetof(3);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2ShapeCastInput(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2ShapeCastInput(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2ShapeCastInput(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code proxy} */
    @Override
    public b2ShapeProxy proxy() { return nproxy(address()); }
    /** @return Returns the property {@code translation} */
    @Override
    public b2Vec2 translation() { return ntranslation(address()); }
    /** @return Returns the property {@code maxFraction} */
    @Override
    public float maxFraction() { return nmaxFraction(address()); }
    /** @return Returns the property {@code canEncroach} */
    @Override
    public boolean canEncroach() { return ncanEncroach(address()); }

    /**
     * Set the value of property {@code proxy}
     * 
     * @param value b2ShapeProxy
     * @return b2ShapeCastInput
     */
    public b2ShapeCastInput proxy(b2ShapeProxy value) {
        nproxy(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code translation}
     * 
     * @param value b2Vec2
     * @return b2ShapeCastInput
     */
    public b2ShapeCastInput translation(b2Vec2 value) {
        ntranslation(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code maxFraction}
     * 
     * @param value float
     * @return b2ShapeCastInput
     */
    public b2ShapeCastInput maxFraction(float value) {
        nmaxFraction(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code canEncroach}
     * 
     * @param value boolean
     * @return b2ShapeCastInput
     */
    public b2ShapeCastInput canEncroach(boolean value) {
        ncanEncroach(address(), value);
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
    protected b2ShapeCastInput create(long address, Pointer ptr) {
        return ptr == null ? new b2ShapeCastInput(address) : new b2ShapeCastInput(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2ShapeCastInput
     */
    private static b2ShapeCastInput factory() {
        return new b2ShapeCastInput(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2ShapeCastInput
     */
    public static b2ShapeCastInput createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2ShapeCastInput(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ShapeCastInput}.
     *
     * @param alloc Custom memory manager
     * @return b2ShapeCastInput
     */
    public static b2ShapeCastInput alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2ShapeCastInput(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2ShapeCastInput}.
     *
     * @return b2ShapeCastInput
     */
    public static b2ShapeCastInput calloc() {
        return new b2ShapeCastInput(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2ShapeCastInput}.
     *
     * @param arean arena
     * @return b2ShapeCastInput
     */
    public static b2ShapeCastInput calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2ShapeCastInput(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ShapeCastInput}.
     *
     * @return b2ShapeCastInput
     */
    public static b2ShapeCastInput malloc() {
        return new b2ShapeCastInput(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ShapeCastInput}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ShapeCastInput}.
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
     * Reserve an amount n of memory for the object {@code b2ShapeCastInput}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ShapeCastInput}.
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

    public static b2ShapeProxy nproxy(long address)          { return b2ShapeProxy.createSafe(() -> address + PROXY);      }
    public static b2Vec2 ntranslation(long address)          { return b2Vec2.createSafe(() -> address + TRANSLATION);      }
    public static float nmaxFraction(long address)           { return memGetFloat(address + MAX_FRACTION);                 }
    public static boolean ncanEncroach(long address)         { return memGetByte(address + CAN_ENCROACH) != 0;            }

    public static void nproxy(long address, b2ShapeProxy value)     { nmemcpy(address + PROXY, value.address(), b2ShapeProxy.SIZEOF);     }
    public static void ntranslation(long address, b2Vec2 value)     { nmemcpy(address + TRANSLATION, value.address(), b2Vec2.SIZEOF);    }
    public static void nmaxFraction(long address, float value)      { memPutFloat(address + MAX_FRACTION, value);                         }
    public static void ncanEncroach(long address, boolean value)    { memPutByte(address + CAN_ENCROACH, (byte) (value ? 1 : 0));        }

    // -----------------------------------

    /** An array of {@code b2ShapeCastInput} structs. */
    public static class Buffer extends StructBuffer<b2ShapeCastInput, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2ShapeCastInput ELEMENT_FACTORY = b2ShapeCastInput.factory();

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
        protected b2ShapeCastInput getElementFactory() {
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
