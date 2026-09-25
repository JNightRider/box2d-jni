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
import org.box2d.jni.readonly.ConstB2TreeNode;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2TreeNode
 * {
 * 	b2AABB aabb;
 * 	uint64_t padding;
 * 	uint32_t flagIndex;
 * 	union
 * 	{
 *          int32_t height;
 *          int32_t shapeIndex;
 * 	};
 * 
 * } b2TreeNode;
 * </code></pre>
 *
 * @author wil
 * @version 2.0.0
 * @since 1.0.0
 */
public class b2TreeNode extends Struct<b2TreeNode> implements ConstB2TreeNode {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            AABB,
            PADDING,
            FLAG_INDEX,
            HEIGHT,
            SHAPE_INDEX;

    static {
        Layout layout = __struct(
                __member(b2AABB.SIZEOF, b2AABB.ALIGNOF),
                __member(8),
                __member(4),
                __union(
                        __member(4),
                        __member(4)
                )
        );

        AABB = layout.offsetof(0);
        PADDING = layout.offsetof(1);
        FLAG_INDEX = layout.offsetof(2);
        HEIGHT = layout.offsetof(4);
        SHAPE_INDEX = layout.offsetof(5);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2TreeNode(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2TreeNode(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2TreeNode(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code aabb} */
    @Override
    public b2AABB aabb() { return naabb(address()); }
    /** @return Returns the property {@code padding} */
    @Override
    public long padding() { return npadding(address()); }
    /** @return Returns the property {@code flagIndex} */
    @Override
    public int flagIndex() { return nflagIndex(address()); }
    /** @return Returns the property {@code height} */
    @Override
    public int height() { return nheight(address()); }
    /** @return Returns the property {@code flags} */
    @Override
    public int shapeIndex() { return nshapeIndex(address()); }

    /**
     * Set the value of property {@code aabb}
     *
     * @param value b2AABB
     * @return b2TreeNode
     */
    public b2TreeNode aabb(b2AABB value) {
        naabb(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code padding}
     *
     * @param value long
     * @return b2TreeNode
     */
    public b2TreeNode padding(long value) {
        npadding(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code flagIndex}
     *
     * @param value int
     * @return b2TreeNode
     */
    public b2TreeNode flagIndex(int value) {
        nflagIndex(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code height}
     *
     * @param value int
     * @return b2TreeNode
     */
    public b2TreeNode height(int value) {
        nheight(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code shapeIndex}
     *
     * @param value int
     * @return b2TreeNode
     */
    public b2TreeNode shapeIndex(int value) {
        nshapeIndex(address(), value);
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
    protected b2TreeNode create(long address, Pointer ptr) {
        return ptr == null ? new b2TreeNode(address) : new b2TreeNode(ptr);
    }
    
        // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2TreeNode
     */
    private static b2TreeNode factory() {
        return new b2TreeNode(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2TreeNode
     */
    public static b2TreeNode createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2TreeNode(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2TreeNode}.
     *
     * @param alloc Custom memory manager
     * @return b2TreeNode
     */
    public static b2TreeNode alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2TreeNode(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2TreeNode}.
     *
     * @return b2TreeNode
     */
    public static b2TreeNode calloc() {
        return new b2TreeNode(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2TreeNode}.
     *
     * @param arean arena
     * @return b2TreeNode
     */
    public static b2TreeNode calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2TreeNode(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2TreeNode}.
     *
     * @return b2TreeNode
     */
    public static b2TreeNode malloc() {
        return new b2TreeNode(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2TreeNode}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2TreeNode}.
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
     * Reserve an amount n of memory for the object {@code b2TreeNode}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2TreeNode}.
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
     * Reserve an amount n of memory for the object {@code b2TreeNode}.
     *
     * @param address Buffer address
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : new Buffer(address, capacity);
    }

    // -----------------------------------
    
    public static b2AABB naabb(long address)    { return b2AABB.createSafe(() -> address + AABB); }
    public static long npadding(long address)   { return memGetLong(address + PADDING);           }
    public static int nflagIndex(long address)  { return memGetInt(address + FLAG_INDEX);         }
    public static int nheight(long address)     { return memGetInt(address + HEIGHT);             }
    public static int nshapeIndex(long address) { return memGetInt(address + SHAPE_INDEX);        }

    public static void naabb(long address, b2AABB value)    { nmemcpy(address + AABB, value.address(), b2AABB.SIZEOF); }
    public static void npadding(long address, long value)   { memPutLong(address + PADDING, value);                          }
    public static void nflagIndex(long address, int value)  { memPutInt(address + FLAG_INDEX, value);                        }
    public static void nheight(long address, int value)     { memPutInt(address + HEIGHT, value);                            }
    public static void nshapeIndex(long address, int value) { memPutInt(address + SHAPE_INDEX, value);                       }
    
    // -----------------------------------

    /** An array of {@code b2TreeNode} structs. */
    public static class Buffer extends StructBuffer<b2TreeNode, Buffer> implements ConstB2TreeNode.ConstBuffer<b2TreeNode, Buffer>, JNINative {

        /** An element that provides information about the structure. */
        private static final b2TreeNode ELEMENT_FACTORY = b2TreeNode.factory();

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
        protected b2TreeNode getElementFactory() {
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
