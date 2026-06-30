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
import org.box2d.jni.readonly.ConstB2WorldId;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2WorldId
 * {
 * 	uint16_t index1;
 * 	uint16_t generation;
 * } b2WorldId;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2WorldId extends Struct<b2WorldId> implements ConstB2WorldId {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            INDEX1,
            GENERATION;

    static {
        Layout layout = __struct(
                __member(2),
                __member(2)
        );

        INDEX1 = layout.offsetof(0);
        GENERATION = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }
    
    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2WorldId(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2WorldId(long address) {
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
    protected b2WorldId(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code index1} */
    @Override
    public Short index1() { return nindex1(address()); }
    /** @return Returns the property {@code generation} */
    @Override
    public Short generation() { return ngeneration(address()); }
    
    /**
     * Set the value of property {@code index1}
     *
     * @param value The value
     * @return b2WorldId
     */
    public b2WorldId index1(short value) { nindex1(address(), value); return this; }

    /**
     * Set the value of property {@code generation}
     *
     * @param value The value
     * @return b2WorldId
     */
    public b2WorldId generation(short value) { ngeneration(address(), value); return this; }
    
    /*(non-Javadoc)
     */
    @Override
    public int sizeof() { return SIZEOF; }
 
    /*(non-Javadoc)
     */
    @Override
    protected b2WorldId create(long address, Pointer ptr) {
        return ptr == null ? new b2WorldId(address) : new b2WorldId(ptr);
    }
    
    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2WorldId
     */
    private static b2WorldId factory() {
        return new b2WorldId(-1L, true);
    }
    
    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2WorldId
     */
    public static b2WorldId createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2WorldId(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2WorldId}.
     *
     * @param alloc Custom memory manager
     * @return b2WorldId
     */
    public static b2WorldId alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2WorldId(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2WorldId}.
     *
     * @param arean arena
     * @return b2WorldId
     */
    public static b2WorldId calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2WorldId(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2WorldId}.
     *
     * @return b2WorldId
     */
    public static b2WorldId malloc() {
        return new b2WorldId(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2WorldId}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2WorldId}.
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
     * Reserve an amount n of memory for the object {@code b2WorldId}.
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

    public static short nindex1(long address) { return memGetShort(address + INDEX1); }
    public static short ngeneration(long address) { return memGetShort(address + GENERATION); }

    public static void nindex1(long address, short value) { memPutShort(address + INDEX1, value); }
    public static void ngeneration(long address, short value) { memPutShort(address + GENERATION, value); }

    
    /** An array of {@code b2WorldId} structs. */
    public static class Buffer extends StructBuffer<b2WorldId, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2WorldId ELEMENT_FACTORY = b2WorldId.factory();

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

        /*(non-Jabadoc)
         */
        @Override
        protected b2WorldId getElementFactory() {
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
