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

import java.nio.ByteBuffer;

import org.box2d.jni.system.*;

import org.box2d.jni.readonly.ConstB2Vec2;
import org.box2d.jni.readonly.ConstB2Pos;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2Vec2
 * {
 *	/// coordinates
 *	float x, y;
 * } b2Vec2;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Vec2 extends Struct<b2Vec2> implements b2Pos<b2Vec2, Float, Float>, ConstB2Vec2 {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            X,
            Y;
    
    static {
        Layout layout = __struct(
                __member(4),
                __member(4)
        );
        
        X = layout.offsetof(0);
        Y = layout.offsetof(1);
        
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Vec2(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Vec2(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     *
     * @see Struct#Struct(long, boolean)
     */
    protected b2Vec2(long address, boolean factor) {
        super(address, factor);
    }

    /**
     * Initializes this struct with the specified values.
     *
     * @param x the valur {@code x}
     * @param y the valur {@code y}
     *
     * @return b2Vec2
     */
    @Override
    public b2Vec2 set(
        Number x,
        Number y
    ) {
        x(x.floatValue());
        y(y.floatValue());
        return this;
    }

    /**
     * Initializes this struct with the specified values.
     *
     * @param x the valur {@code x}
     * @param y the valur {@code y}
     *
     * @return b2Vec2
     */
    public b2Vec2 set(
        float x,
        float y
    ) {
        x(x);
        y(y);
        return this;
    }

    /** @return Returns the property {@code x} */
    @Override
    public Float x() { return nx(address()); }
    /** @return Returns the property {@code y} */
    @Override
    public Float y() { return ny(address()); }
    
    /**
     * Set the value of property {@code x}
     *
     * @param value The value
     * @return b2Vec2
     */
    @Override
    public b2Vec2 x(Number value) { nx(address(), value.floatValue()); return this; }

    /**
     * Set the value of property {@code x}
     *
     * @param value The value
     * @return b2Vec2
     */
    public b2Vec2 x(float value) { nx(address(), value); return this; }
    /**
     * Set the value of property {@code y}
     *
     * @param value The value
     * @return b2Vec2
     */
    @Override
    public b2Vec2 y(Number value) { ny(address(), value.floatValue()); return this; }

    /**
     * Set the value of property {@code y}
     *
     * @param value The value
     * @return b2Vec2
     */
    public b2Vec2 y(float value) { ny(address(), value); return this; }
    
    /*(non-Javadoc)
     */
    @Override
    public int sizeof() { return SIZEOF; }
 
    /*(non-Javadoc)
     */
    @Override
    protected b2Vec2 create(long address, Pointer ptr) {
        return ptr == null ? new b2Vec2(address) : new b2Vec2(ptr);
    }

    // ----------------------------------

    // --- [ Math operator overloads for Java ] ---

    /**
     * Unary add one vector to another
     *
     * @param o b2Vec2
     * @return b2Vec2
     */
    public b2Vec2 add(b2Vec2 o) {
        nadd(address(), o.address(), address());
        return this;
    }

    /**
     * Unary subtract one vector from another
     *
     * @param o b2Vec2
     * @return b2Vec2
     */
    public b2Vec2 sub(b2Vec2 o) {
        nsub(address(), o.address(), address());
        return this;
    }

    /**
     * Unary multiply a vector by a scalar
     *
     * @param o b2Vec2
     * @return b2Vec2
     */
    public b2Vec2 mult(b2Vec2 o) {
        nmult(address(), o.address(), address());
        return this;
    }

    /**
     * Unary negate a vector
     *
     * @return b2Vec2
     */
    public b2Vec2 neg() {
        x(-x());
        y(-y());
        return this;
    }

    /**
     * Binary vector equality
     *
     * @param o b2Vec2
     * @return boolean
     */
    public boolean equality(b2Vec2 o) {
        return nequality(address(), o.address());
    }

    /**
     * Binary vector inequality
     *
     * @param o b2Vec2
     * @return boolean
     */
    public boolean inequality(b2Vec2 o) {
        return ninequality(address(), o.address());
    }
    
    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2Vec2
     */
    private static b2Vec2 factory() {
        return new b2Vec2(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Vec2
     */
    public static b2Vec2 createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Vec2(ptr);
    }
    
    /**
     * Reserve memory for the new object {@code b2Vec2}.
     *
     * @param alloc Custom memory manager
     * @return b2Vec2
     */
    public static b2Vec2 alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2Vec2(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2Vec2}.
     *
     * @param arean arena
     * @return b2Vec2
     */
    public static b2Vec2 calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2Vec2(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Vec2}.
     *
     * @return b2Vec2
     */
    public static b2Vec2 malloc() {
        return new b2Vec2(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Vec2}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }
    
    /**
     * Reserve an amount n of memory for the object {@code b2Vec2}.
     *
     * @param src source
     * @return Buffer
     */
    public static Buffer mallocSafe(b2Vec2 ...src) {
        if (src == null) {
            return null;
        }
        Buffer ptr = malloc(src.length);
        for (b2Vec2 v : src) {
            ptr.put(v);
        }
        return ptr;
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Vec2}.
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
     * Reserve an amount n of memory for the object {@code b2Vec2}.
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
     * Reserve an amount n of memory for the object {@code b2Vec2}.
     *
     * @param address Buffer address
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : new Buffer(address, capacity);
    }
    
    // -----------------------------------
    public static long nadd(long a, long b, long __result) {
        nx(__result, nx(a) + nx(b));
        ny(__result, ny(a) + ny(b));
        return __result;
    }
    public static long nsub(long a, long b, long __result) {
        nx(__result, nx(a) - nx(b));
        ny(__result, ny(a) - ny(b));
        return __result;
    }
    public static long nmult(long a, long b, long __result) {
        nx(__result, nx(a) * nx(b));
        ny(__result, ny(a) * ny(b));
        return __result;
    }
    public static long nmult(long a, float b, long __result) {
        nx(__result, nx(a) * b);
        ny(__result, ny(a) * b);
        return __result;
    }
    public static boolean nequality(long a, long b) { return nx(a) == nx(b) && ny(a) == ny(b); }
    public static boolean ninequality(long a, long b) { return nx(a) != nx(b) || ny(a) != ny(b); }
    
    public static float nx(long address) { return memGetFloat(address + X); }
    public static float ny(long address) { return memGetFloat(address + Y); }

    public static void nx(long address, float value) { memPutFloat(address + X, value); }
    public static void ny(long address, float value) { memPutFloat(address + Y, value); }

    // -----------------------------------
    
    /** An array of {@code b2Vec2} structs. */
    public static class Buffer extends StructBuffer<b2Vec2, Buffer> implements ConstB2Vec2.ConstBuffer<b2Vec2, Buffer>, 
                                                                               ConstB2Pos.ConstBuffer<b2Vec2, Buffer>,
                                                                               JNINative {
        /** An element that provides information about the structure. */
        private static final b2Vec2 ELEMENT_FACTORY = b2Vec2.factory();

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
         * @param container ByteBuffer
         */
        public Buffer(ByteBuffer container) {
            super(container, container.remaining() / SIZEOF);
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
        protected b2Vec2 getElementFactory() {
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
