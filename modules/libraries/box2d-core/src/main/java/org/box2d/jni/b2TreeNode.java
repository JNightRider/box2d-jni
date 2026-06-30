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
 *     b2AABB aabb;
 *     uint64_t categoryBits;
 *     union
 *     {
 *         b2TreeNodeChildren children;
 *         uint64_t userData;
 *     };
 *     union
 *     {
 *         int32_t parent;
 *         int32_t next;
 *     };
 *     uint16_t height;
 *     uint16_t flags;
 * } b2TreeNode;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.1.0
 */
public class b2TreeNode extends Struct<b2TreeNode> implements ConstB2TreeNode {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            AABB,
            CATEGORY_BITS,
            CHILDREN,
            USER_DATA,
            PARENT,
            NEXT,
            HEIGHT,
            FLAGS;

    static {
        Layout layout = __struct(
                __member(b2AABB.SIZEOF, b2AABB.ALIGNOF),
                __member(8),
                __union(
                        __member(b2TreeNodeChildren.SIZEOF, b2TreeNodeChildren.ALIGNOF),
                        __member(8)
                ),
                __union(
                        __member(4),
                        __member(4)
                ),
                __member(2),
                __member(2)
        );

        AABB = layout.offsetof(0);
        CATEGORY_BITS = layout.offsetof(1);

        CHILDREN = layout.offsetof(3);
        USER_DATA = layout.offsetof(4);

        PARENT = layout.offsetof(6);
        NEXT = layout.offsetof(7);

        HEIGHT = layout.offsetof(8);
        FLAGS = layout.offsetof(9);

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
    /** @return Returns the property {@code categoryBits} */
    @Override
    public long categoryBits() { return ncategoryBits(address()); }
    /** @return Returns the property {@code children} */
    @Override
    public b2TreeNodeChildren children() { return nchildren(address()); }
    /** @return Returns the property {@code userData} */
    @Override
    public long userData() { return nuserData(address()); }
    /** @return Returns the property {@code parent} */
    @Override
    public int parent() { return nparent(address()); }
    /** @return Returns the property {@code next} */
    @Override
    public int next() { return nnext(address()); }
    /** @return Returns the property {@code height} */
    @Override
    public short height() { return nheight(address()); }
    /** @return Returns the property {@code flags} */
    @Override
    public short flags() { return nflags(address()); }

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
     * Set the value of property {@code categoryBits}
     *
     * @param value long
     * @return b2TreeNode
     */
    public b2TreeNode categoryBits(long value) {
        ncategoryBits(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code children}
     *
     * @param value int
     * @return b2TreeNode
     */
    public b2TreeNode children(b2TreeNodeChildren value) {
        nchildren(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code userData}
     *
     * @param value long
     * @return b2TreeNode
     */
    public b2TreeNode userData(long value) {
        nuserData(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code parent}
     *
     * @param value int
     * @return b2TreeNode
     */
    public b2TreeNode parent(int value) {
        nparent(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code next}
     *
     * @param value int
     * @return b2TreeNode
     */
    public b2TreeNode next(int value) {
        nnext(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code height}
     *
     * @param value short
     * @return b2TreeNode
     */
    public b2TreeNode height(short value) {
        nheight(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code flags}
     *
     * @param value short
     * @return b2TreeNode
     */
    public b2TreeNode flags(short value) {
        nflags(address(), value);
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
     * @param arena Arean
     * @return Buffer
     */
    public static Buffer calloc(int capacity, ArenaAlloc arena) {
        long ptr = arena.ncalloc(ALIGNOF, capacity, SIZEOF);
        return new Buffer(ptr, capacity);
    }

    // -----------------------------------
    
    public static b2AABB naabb(long address) { return b2AABB.createSafe(() -> address + AABB); }
    public static long ncategoryBits(long address) { return memGetLong(address + CATEGORY_BITS); }
    public static b2TreeNodeChildren nchildren(long address) { return b2TreeNodeChildren.createSafe(() -> address + CHILDREN); }
    public static long nuserData(long address) { return memGetLong(address + USER_DATA); }
    public static int nparent(long address) { return memGetInt(address + PARENT); }
    public static int nnext(long address) { return memGetInt(address + NEXT); }
    public static short nheight(long address) { return memGetShort(address + HEIGHT); }
    public static short nflags(long address) { return memGetShort(address + FLAGS); }

    public static void naabb(long address, b2AABB value) { nmemcpy(address + AABB, value.address(), b2AABB.SIZEOF);}
    public static void ncategoryBits(long address, long value) { memPutLong(address + CATEGORY_BITS, value);}
    public static void nchildren(long address, b2TreeNodeChildren value) { nmemcpy(address + CHILDREN, value.address(), b2TreeNodeChildren.SIZEOF); }
    public static void nuserData(long address, long value) { memPutLong(address + USER_DATA, value);}
    public static void nparent(long address, int value) { memPutInt(address + PARENT, value);}
    public static void nnext(long address, int value) { memPutInt(address + NEXT, value);}
    public static void nheight(long address, short value) { memPutShort(address + HEIGHT, value);}
    public static void nflags(long address, short value) { memPutShort(address + FLAGS, value);}
    
    // -----------------------------------

    /** An array of {@code b2TreeNode} structs. */
    public static class Buffer extends StructBuffer<b2TreeNode, Buffer> implements JNINative {

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
