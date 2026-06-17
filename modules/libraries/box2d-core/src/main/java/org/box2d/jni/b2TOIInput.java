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
import org.box2d.jni.readonly.ConstB2TOIInput;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2TOIInput
 * {
 *     b2ShapeProxy proxyA;
 *     b2ShapeProxy proxyB;
 *     b2Sweep sweepA;
 *     b2Sweep sweepB;
 *     float maxFraction;
 * } b2TOIInput;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2TOIInput extends Struct<b2TOIInput> implements ConstB2TOIInput {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            PROXY_A,
            PROXY_B,
            SWEEP_A,
            SWEEP_B,
            MAX_FRACTION;

    static {
        Layout layout = __struct(
                __member(b2ShapeProxy.SIZEOF, b2ShapeProxy.ALIGNOF),
                __member(b2ShapeProxy.SIZEOF, b2ShapeProxy.ALIGNOF),
                __member(b2Sweep.SIZEOF, b2Sweep.ALIGNOF),
                __member(b2Sweep.SIZEOF, b2Sweep.ALIGNOF),
                __member(4)
        );

        PROXY_A = layout.offsetof(0);
        PROXY_B = layout.offsetof(1);
        SWEEP_A = layout.offsetof(2);
        SWEEP_B = layout.offsetof(3);
        MAX_FRACTION = layout.offsetof(4);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2TOIInput(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2TOIInput(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2TOIInput(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code proxyA} */
    @Override
    public b2ShapeProxy proxyA() { return nproxyA(address()); }
    /** @return Returns the property {@code proxyB} */
    @Override
    public b2ShapeProxy proxyB() { return nproxyB(address()); }
    /** @return Returns the property {@code sweepA} */
    @Override
    public b2Sweep sweepA() { return nsweepA(address()); }
    /** @return Returns the property {@code sweepB} */
    @Override
    public b2Sweep sweepB() { return nsweepB(address()); }
    /** @return Returns the property {@code maxFraction} */
    @Override
    public float maxFraction() { return nmaxFraction(address()); }

    /**
     * Set the value of property {@code proxyA}
     * 
     * @param value b2ShapeProxy
     * @return b2TOIInput
     */
    public b2TOIInput proxyA(b2ShapeProxy value) {
        nproxyA(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code proxyB}
     * 
     * @param value b2ShapeProxy
     * @return b2TOIInput
     */
    public b2TOIInput proxyB(b2ShapeProxy value) {
        nproxyB(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code sweepA}
     * 
     * @param value b2Sweep
     * @return b2TOIInput
     */
    public b2TOIInput sweepA(b2Sweep value) {
        nsweepA(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code sweepB}
     * 
     * @param value b2Sweep
     * @return b2TOIInput
     */
    public b2TOIInput sweepB(b2Sweep value) {
        nsweepB(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code maxFraction}
     * 
     * @param value float
     * @return b2TOIInput
     */
    public b2TOIInput maxFraction(float value) {
        nmaxFraction(address(), value);
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
    protected b2TOIInput create(long address, Pointer ptr) {
        return ptr == null ? new b2TOIInput(address) : new b2TOIInput(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2TOIInput
     */
    private static b2TOIInput factory() {
        return new b2TOIInput(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2TOIInput
     */
    public static b2TOIInput createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2TOIInput(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2TOIInput}.
     *
     * @param alloc Custom memory manager
     * @return b2TOIInput
     */
    public static b2TOIInput alloc(AllocFunc alloc) {
        return new b2TOIInput(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2TOIInput}.
     *
     * @return b2TOIInput
     */
    public static b2TOIInput malloc() {
        return new b2TOIInput(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2TOIInput}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2TOIInput}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static b2ShapeProxy nproxyA(long address) { return b2ShapeProxy.createSafe(() -> address + PROXY_A); }
    public static b2ShapeProxy nproxyB(long address) { return b2ShapeProxy.createSafe(() -> address + PROXY_B); }
    public static b2Sweep nsweepA(long address)      { return b2Sweep.createSafe(() -> address + SWEEP_A); }
    public static b2Sweep nsweepB(long address)      { return b2Sweep.createSafe(() -> address + SWEEP_B); }
    public static float nmaxFraction(long address)   { return memGetFloat(address + MAX_FRACTION); }

    public static void nproxyA(long address, b2ShapeProxy value) { nmemcpy(address + PROXY_A, value.address(), b2ShapeProxy.SIZEOF); }
    public static void nproxyB(long address, b2ShapeProxy value) { nmemcpy(address + PROXY_B, value.address(), b2ShapeProxy.SIZEOF); }
    public static void nsweepA(long address, b2Sweep value) { nmemcpy(address + SWEEP_A, value.address(), b2Sweep.SIZEOF); }
    public static void nsweepB(long address, b2Sweep value) { nmemcpy(address + SWEEP_B, value.address(), b2Sweep.SIZEOF); }
    public static void nmaxFraction(long address, float value) { memPutFloat(address + MAX_FRACTION, value); }
    
    // -----------------------------------

    /** An array of {@code b2TOIInput} structs. */
    public static class Buffer extends StructBuffer<b2TOIInput, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2TOIInput ELEMENT_FACTORY = b2TOIInput.factory();

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
        protected b2TOIInput getElementFactory() {
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
