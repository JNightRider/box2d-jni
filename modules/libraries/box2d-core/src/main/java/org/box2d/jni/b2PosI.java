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
import org.box2d.jni.readonly.ConstB2Pos;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2PosI
 * {
 * 	double x, y;
 * } b2PosI;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2PosI extends Struct<b2PosI> implements b2Pos<b2PosI, Double, Double>, ConstB2Pos<Double, Double> {

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
                __member(8),
                __member(8)
        );
        
        X = layout.offsetof(0);
        Y = layout.offsetof(1);
        
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    public b2PosI(Pointer ptr) {
        super(ptr);
    }

    public b2PosI(long address) {
        super(address);
    }

    protected b2PosI(long address, boolean factor) {
        super(address, factor);
    }

    /**
     * Initializes this struct with the specified values.
     *
     * @param x the valur {@code x}
     * @param y the valur {@code y}
     *
     * @return b2PosI
     */
    @Override
    public b2PosI set(
        Double x,
        Double y
    ) {
        x(x);
        y(y);
        return this;
    }

    /** @return Returns the property {@code x} */
    @Override
    public Double x() { return nx(address()); }
    /** @return Returns the property {@code y} */
    @Override
    public Double y() { return ny(address()); }
    
    /**
     * Set the value of property {@code x}
     *
     * @param value The value
     * @return b2PosI
     */
    @Override
    public b2PosI x(Double value) { nx(address(), value); return this; }
    /**
     * Set the value of property {@code y}
     *
     * @param value The value
     * @return b2PosI
     */
    @Override
    public b2PosI y(Double value) { ny(address(), value); return this; }
    
    /*(non-Javadoc)
     */
    @Override
    public int sizeof() { return SIZEOF; }
 
    /*(non-Javadoc)
     */
    @Override
    protected b2PosI create(long address, Pointer ptr) {
        return ptr == null ? new b2PosI(address) : new b2PosI(ptr);
    }

    // ----------------------------------

    // --- [ Math operator overloads for Java ] ---

    /**
     * Unary add one vector to another
     *
     * @param o b2PosI
     * @return b2PosI
     */
    public b2PosI add(b2PosI o) {
        nadd(address(), o.address(), address());
        return this;
    }

    /**
     * Unary subtract one vector from another
     *
     * @param o b2PosI
     * @return b2PosI
     */
    public b2PosI sub(b2PosI o) {
        nsub(address(), o.address(), address());
        return this;
    }

    /**
     * Unary multiply a vector by a scalar
     *
     * @param o b2PosI
     * @return b2PosI
     */
    public b2PosI mult(b2PosI o) {
        nmult(address(), o.address(), address());
        return this;
    }

    /**
     * Unary negate a vector
     *
     * @return b2PosI
     */
    public b2PosI neg() {
        x(-x());
        y(-y());
        return this;
    }

    /**
     * Binary vector equality
     *
     * @param o b2PosI
     * @return boolean
     */
    public boolean equality(b2PosI o) {
        return nequality(address(), o.address());
    }

    /**
     * Binary vector inequality
     *
     * @param o b2PosI
     * @return boolean
     */
    public boolean inequality(b2PosI o) {
        return ninequality(address(), o.address());
    }
    
    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2PosI
     */
    private static b2PosI factory() {
        return new b2PosI(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2PosI
     */
    public static b2PosI createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2PosI(ptr);
    }
    
    /**
     * Reserve memory for the new object {@code b2PosI}.
     *
     * @param alloc Custom memory manager
     * @return b2PosI
     */
    public static b2PosI alloc(AllocFunc alloc) {
        return new b2PosI(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2PosI}.
     *
     * @return b2PosI
     */
    public static b2PosI malloc() {
        return new b2PosI(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2PosI}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }
    
    /**
     * Reserve an amount n of memory for the object {@code b2PosI}.
     *
     * @param src source
     * @return Buffer
     */
    public static Buffer mallocSafe(b2PosI ...src) {
        if (src == null) {
            return null;
        }
        Buffer ptr = malloc(src.length);
        for (b2PosI p : src) {
            ptr.put(p);
        }
        return ptr;
    }

    /**
     * Reserve an amount n of memory for the object {@code b2PosI}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }
    
    /**
     * Reserve an amount n of memory for the object {@code b2PosI}.
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
    public static long nmult(long a, double b, long __result) {
        nx(__result, nx(a) * b);
        ny(__result, ny(a) * b);
        return __result;
    }
    public static boolean nequality(long a, long b) { return nx(a) == nx(b) && ny(a) == ny(b); }
    public static boolean ninequality(long a, long b) { return nx(a) != nx(b) || ny(a) != ny(b); }
    
    public static double nx(long address) { return memGetDouble(address + X); }
    public static double ny(long address) { return memGetDouble(address + Y); }

    public static void nx(long address, double value) { memPutDouble(address + X, value); }
    public static void ny(long address, double value) { memPutDouble(address + Y, value); }

    // -----------------------------------
    
    /** *  An array of {@code b2PosI} structs. */
    public static class Buffer extends StructBuffer<b2PosI, Buffer> implements b2Pos.ConstBuffer<b2PosI, Buffer>, JNINative {
        /** An element that provides information about the structure. */
        private static final b2PosI ELEMENT_FACTORY = b2PosI.factory();

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
        protected b2PosI getElementFactory() {
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
