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
import org.box2d.jni.readonly.ConstB2ContactId;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2ContactId
 * {
 *     int32_t index1;
 *     uint16_t world0;
 *     int16_t padding;
 *     uint32_t generation;
 * } b2ContactId;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2ContactId extends Struct<b2ContactId> implements ConstB2ContactId{

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            INDEX1,
            WORLD0,
            PADDING,
            GENERATION;

    static {
        Layout layout = __struct(
                __member(4),
                __member(2),
                __member(2),
                __member(4)
        );

        INDEX1 = layout.offsetof(0);
        WORLD0 = layout.offsetof(1);
        PADDING = layout.offsetof(2);
        GENERATION = layout.offsetof(3);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2ContactId(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2ContactId(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2ContactId(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code index1} */
    @Override
    public Integer index1() { return nindex1(address()); }
    /** @return Returns the property {@code world0} */
    @Override
    public Short world0() { return nworld0(address()); }
    /** @return Returns the property {@code padding} */
    @Override
    public Short padding() { return npadding(address()); }
    /** @return Returns the property {@code generation} */
    @Override
    public Integer generation() { return ngeneration(address()); }

    /**
     * Set the value of property {@code index1}
     *
     * @param value The value
     * @return b2ContactId
     */
    public b2ContactId index1(int value) { nindex1(address(), value); return this; }
    /**
     * Set the value of property {@code world0}
     *
     * @param value The value
     * @return b2ContactId
     */
    public b2ContactId world0(short value) { nworld0(address(), value); return this; }
    /**
     * Set the value of property {@code padding}
     *
     * @param value The value
     * @return b2ContactId
     */
    public b2ContactId padding(short value) { npadding(address(), value); return this; }
    /**
     * Set the value of property {@code generation}
     *
     * @param value The value
     * @return b2ContactId
     */
    public b2ContactId generation(int value) { ngeneration(address(), value); return this; }

    /*(non-Javadoc)
     */
    @Override
    public int sizeof() {
        return SIZEOF;
    }

    /*(non-Javadoc)
     */
    @Override
    protected b2ContactId create(long address, Pointer ptr) {
        return ptr == null ? new b2ContactId(address) : new b2ContactId(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2ContactId
     */
    private static b2ContactId factory() {
        return new b2ContactId(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2ContactId
     */
    public static b2ContactId createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2ContactId(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ContactId}.
     *
     * @param alloc Custom memory manager
     * @return b2ContactId
     */
    public static b2ContactId alloc(AllocFunc alloc) {
        return new b2ContactId(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2ContactId}.
     *
     * @return b2ContactId
     */
    public static b2ContactId malloc() {
        return new b2ContactId(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ContactId}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ContactId}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static int nindex1(long address) { return memGetInt(address + INDEX1); }
    public static short nworld0(long address) { return memGetShort(address + WORLD0); }
    public static short npadding(long address) { return memGetShort(address + PADDING); }
    public static int ngeneration(long address) { return memGetInt(address + GENERATION); }

    public static void nindex1(long address, int value) { memPutInt(address + INDEX1, value); }
    public static void nworld0(long address, short value) { memPutShort(address + WORLD0, value); }
    public static void npadding(long address, short value) { memPutShort(address + PADDING, value); }
    public static void ngeneration(long address, int value) { memPutInt(address + GENERATION, value); }
    
    // -----------------------------------

    /** An array of {@code b2ContactId} structs. */
    public static class Buffer extends StructBuffer<b2ContactId, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2ContactId ELEMENT_FACTORY = b2ContactId.factory();

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
        protected b2ContactId getElementFactory() {
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
