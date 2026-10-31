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
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * /// An array of chain loops created by merging polygons.
 * typedef struct b2ChainResult
 * {
 *     b2ChainData* chains;
 *     int chainCount;
 *     b2ChainStatus status;
 * } b2ChainResult;
 * </code></pre>
 *
 * @author wil
 * @version 1.0.0
 * @since 2.2.0
 */
public class b2ChainResult extends Struct<b2ChainResult> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            CHAINS,
            CHAIN_COUNT,
            STATUS;

    static {
        Layout layout = __struct(
                __member(POINTER_SIZE),
                __member(4),
                __member(4)
        );

        CHAINS = layout.offsetof(0);
        CHAIN_COUNT = layout.offsetof(1);
        STATUS = layout.offsetof(2);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2ChainResult(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2ChainResult(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2ChainResult(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code chains} */
    public long chains() { return nchains(address()); }

    /** @return Returns the property {@code chainCount} */
    public int chainCount() { return nchainCount(address()); }

    /** @return Returns the property {@code status} */
    public b2ChainStatus status() { return b2ChainStatus.valueOf(nstatus(address())); }

    /**
     * Set the value of property {@code chains}
     *
     * @param value long
     * @return b2ChainResult
     */
    public b2ChainResult chains(long value) {
        nchains(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code chainCount}
     *
     * @param value int
     * @return b2ChainResult
     */
    public b2ChainResult chainCount(int value) {
        nchainCount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code status}
     *
     * @param value b2ChainStatus
     * @return b2ChainResult
     */
    public b2ChainResult status(b2ChainStatus value) {
        nstatus(address(), value.value());
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
    protected b2ChainResult create(long address, Pointer ptr) {
        return ptr == null ? new b2ChainResult(address) : new b2ChainResult(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2ChainResult
     */
    private static b2ChainResult factory() {
        return new b2ChainResult(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2ChainResult
     */
    public static b2ChainResult createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2ChainResult(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ChainResult}.
     *
     * @param alloc Custom memory manager
     * @return b2ChainResult
     */
    public static b2ChainResult alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2ChainResult(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2ChainResult}.
     *
     * @return b2ChainResult
     */
    public static b2ChainResult calloc() {
        return new b2ChainResult(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2ChainResult}.
     *
     * @param arean arena
     * @return b2ChainResult
     */
    public static b2ChainResult calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2ChainResult(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ChainResult}.
     *
     * @return b2ChainResult
     */
    public static b2ChainResult malloc() {
        return new b2ChainResult(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ChainResult}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ChainResult}.
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
     * Reserve an amount n of memory for the object {@code b2ChainResult}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ChainResult}.
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
     * Reserve an amount n of memory for the object {@code b2ChainResult}.
     *
     * @param address Buffer address
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : new Buffer(address, capacity);
    }

    // -----------------------------------

    public static long nchains(long address) { return memGetAddress(address + CHAINS); }
    public static int nchainCount(long address) { return memGetInt(address + CHAIN_COUNT); }
    public static int nstatus(long address) { return memGetInt(address + STATUS); }

    public static void nchains(long address, long value) { memPutAddress(address + CHAINS, value); }
    public static void nchainCount(long address, int value) { memPutInt(address + CHAIN_COUNT, value); }
    public static void nstatus(long address, int value) { memPutInt(address + STATUS, value); }

    // -----------------------------------

    /** An array of {@code b2ChainResult} structs. */
    public static class Buffer extends StructBuffer<b2ChainResult, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2ChainResult ELEMENT_FACTORY = b2ChainResult.factory();

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
        protected b2ChainResult getElementFactory() {
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
