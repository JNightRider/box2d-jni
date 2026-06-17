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
 * typedef struct b2TreeStats
 * {
 *     int nodeVisits;
 *     int leafVisits;
 * } b2TreeStats;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2TreeStats extends Struct<b2TreeStats> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            NODE_VISITS,
            LEAF_VISITS;

    static {
        Layout layout = __struct(
                __member(4),
                __member(4)
        );

        NODE_VISITS = layout.offsetof(0);
        LEAF_VISITS = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2TreeStats(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2TreeStats(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2TreeStats(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code nodeVisits} */
    public int nodeVisits() { return nnodeVisits(address()); }
    /** @return Returns the property {@code leafVisits} */
    public int leafVisits() { return nleafVisits(address()); }

    /**
     * Set the value of property {@code nodeVisits}
     *
     * @param value int
     * @return b2TreeStats
     */
    public b2TreeStats nodeVisits(int value) {
        nnodeVisits(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code leafVisits}
     *
     * @param value int
     * @return b2TreeStats
     */
    public b2TreeStats leafVisits(int value) {
        nleafVisits(address(), value);
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
    protected b2TreeStats create(long address, Pointer ptr) {
        return ptr == null ? new b2TreeStats(address) : new b2TreeStats(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2TreeStats
     */
    private static b2TreeStats factory() {
        return new b2TreeStats(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2TreeStats
     */
    public static b2TreeStats createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2TreeStats(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2TreeStats}.
     *
     * @param alloc Custom memory manager
     * @return b2TreeStats
     */
    public static b2TreeStats alloc(AllocFunc alloc) {
        return new b2TreeStats(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2TreeStats}.
     *
     * @return b2TreeStats
     */
    public static b2TreeStats malloc() {
        return new b2TreeStats(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2TreeStats}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2TreeStats}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static int nnodeVisits(long address) { return memGetInt(address + NODE_VISITS); }
    public static int nleafVisits(long address) { return memGetInt(address + LEAF_VISITS); }

    public static void nnodeVisits(long address, int value) { memPutInt(address + NODE_VISITS, value);}
    public static void nleafVisits(long address, int value) { memPutInt(address + LEAF_VISITS, value);}
    
    // -----------------------------------

    /** An array of {@code b2TreeStats} structs. */
    public static class Buffer extends StructBuffer<b2TreeStats, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2TreeStats ELEMENT_FACTORY = b2TreeStats.factory();

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
        protected b2TreeStats getElementFactory() {
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
