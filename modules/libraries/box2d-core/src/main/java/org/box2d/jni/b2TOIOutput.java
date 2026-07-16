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
 * typedef struct b2TOIOutput
 * {
 *     b2TOIState state;
 *     b2Vec2 point;
 *     b2Vec2 normal;
 *     float fraction;
 * } b2TOIOutput;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2TOIOutput extends Struct<b2TOIOutput> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            STATE,
            POINT,
            NORMAL,
            FRACTION;

    static {
        Layout layout = __struct(
                __member(4),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4)
        );

        STATE = layout.offsetof(0);
        POINT = layout.offsetof(1);
        NORMAL = layout.offsetof(2);
        FRACTION = layout.offsetof(3);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2TOIOutput(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2TOIOutput(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2TOIOutput(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code state} */
    public b2TOIState state() { return nstate(address()); }
    /** @return Returns the property {@code point} */
    public b2Vec2 point() { return npoint(address()); }
    /** @return Returns the property {@code normal} */
    public b2Vec2 normal() { return nnormal(address()); }
    /** @return Returns the property {@code fraction} */
    public float fraction() { return nfraction(address()); }

    /**
     * Set the value of property {@code state}
     * 
     * @param value b2TOIState
     * @return b2TOIOutput
     */
    public b2TOIOutput state(b2TOIState value) {
        nstate(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code point}
     * 
     * @param value b2Vec2
     * @return b2TOIOutput
     */
    public b2TOIOutput point(b2Vec2 value) {
        npoint(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code normal}
     * 
     * @param value b2Vec2
     * @return b2TOIOutput
     */
    public b2TOIOutput normal(b2Vec2 value) {
        nnormal(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code fraction}
     * 
     * @param value float
     * @return b2TOIOutput
     */
    public b2TOIOutput fraction(float value) {
        nfraction(address(), value);
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
    protected b2TOIOutput create(long address, Pointer ptr) {
        return ptr == null ? new b2TOIOutput(address) : new b2TOIOutput(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2TOIOutput
     */
    private static b2TOIOutput factory() {
        return new b2TOIOutput(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2TOIOutput
     */
    public static b2TOIOutput createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2TOIOutput(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2TOIOutput}.
     *
     * @param alloc Custom memory manager
     * @return b2TOIOutput
     */
    public static b2TOIOutput alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2TOIOutput(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2TOIOutput}.
     *
     * @return b2TOIOutput
     */
    public static b2TOIOutput calloc() {
        return new b2TOIOutput(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2TOIOutput}.
     *
     * @param arean arena
     * @return b2TOIOutput
     */
    public static b2TOIOutput calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2TOIOutput(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2TOIOutput}.
     *
     * @return b2TOIOutput
     */
    public static b2TOIOutput malloc() {
        return new b2TOIOutput(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2TOIOutput}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2TOIOutput}.
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
     * Reserve an amount n of memory for the object {@code b2TOIOutput}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2TOIOutput}.
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
    
    public static b2TOIState nstate(long address) { return b2TOIState.valueOf(memGetInt(address + STATE)); }
    public static b2Vec2 npoint(long address) { return b2Vec2.createSafe(() -> address + POINT); }
    public static b2Vec2 nnormal(long address) { return b2Vec2.createSafe(() -> address + NORMAL); }
    public static float nfraction(long address) { return memGetFloat(address + FRACTION); }

    public static void nstate(long address, b2TOIState value) { memPutInt(address + STATE, value.value()); }
    public static void npoint(long address, b2Vec2 value) { nmemcpy(address + POINT, value.address(), b2Vec2.SIZEOF); }
    public static void nnormal(long address, b2Vec2 value) { nmemcpy(address + NORMAL, value.address(), b2Vec2.SIZEOF); }
    public static void nfraction(long address, float value) { memPutFloat(address + FRACTION, value); }
    
    // -----------------------------------

    /** An array of {@code b2TOIOutput} structs. */
    public static class Buffer extends StructBuffer<b2TOIOutput, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2TOIOutput ELEMENT_FACTORY = b2TOIOutput.factory();

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
        protected b2TOIOutput getElementFactory() {
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
