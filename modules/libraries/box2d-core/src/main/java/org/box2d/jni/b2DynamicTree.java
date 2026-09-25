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
import org.box2d.jni.readonly.ConstB2DynamicTree;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2DynamicTree
 * {
 *      b2TreeNode* nodes;
 * 	int32_t* parents;
 * 	b2TreeProxy* proxies;
 * 	int32_t nodeEnd;
 * 	int32_t nodeCapacity;
 * 	int32_t pairFreeList;
 * 	int32_t proxyCount;
 * 	int32_t proxyCapacity;
 * 	int32_t proxyFreeList;
 * 	b2TreeNode* swapNodes;
 * 	int32_t* leafIndices;
 * 	b2TreeNode* leafNodes;
 * 	b2AABB* leafBoxes;
 * 	b2Vec2* leafCenters;
 * 	int32_t* binIndices;
 * 	int32_t rebuildCapacity;
 * 	bool dfsOrdered;
 * 
 * } b2DynamicTree;
 * </code></pre>
 *
 * @author wil
 * @version 2.0.0
 * @since 1.0.0
 */
public class b2DynamicTree extends Struct<b2DynamicTree> implements ConstB2DynamicTree {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            NODES,
            PARENTS,
            PROXIES,
            NODE_END,
            NODE_CAPACITY,
            PAIR_FREE_LIST,
            PROXY_COUNT,
            PROXY_CAPACITY,
            PROXY_FREE_LIST,
            SWAP_NODES,
            LEAF_INDICES,
            LEAF_NODES,
            LEAF_BOXES,
            LEAF_CENTERS,
            BIN_INDICES,
            REBUILD_CAPACITY,
            DFS_ORDERED;

    static {
        Layout layout = __struct(
                __member(POINTER_SIZE),
                __member(POINTER_SIZE),
                __member(POINTER_SIZE),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(POINTER_SIZE),
                __member(POINTER_SIZE),
                __member(POINTER_SIZE),
                __member(POINTER_SIZE),
                __member(POINTER_SIZE),
                __member(POINTER_SIZE),
                __member(4),
                __member(1)
        );

        NODES = layout.offsetof(0);
        PARENTS = layout.offsetof(1);
        PROXIES = layout.offsetof(2);

        NODE_END = layout.offsetof(3);
        NODE_CAPACITY = layout.offsetof(4);
        PAIR_FREE_LIST = layout.offsetof(5);
        PROXY_COUNT = layout.offsetof(6);
        PROXY_CAPACITY = layout.offsetof(7);
        PROXY_FREE_LIST = layout.offsetof(8);

        SWAP_NODES = layout.offsetof(9);
        LEAF_INDICES = layout.offsetof(10);
        LEAF_NODES = layout.offsetof(11);
        LEAF_BOXES = layout.offsetof(12);
        LEAF_CENTERS = layout.offsetof(13);
        BIN_INDICES = layout.offsetof(14);

        REBUILD_CAPACITY = layout.offsetof(15);
        DFS_ORDERED = layout.offsetof(16);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2DynamicTree(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2DynamicTree(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2DynamicTree(long address, boolean factor) {
        super(address, factor);
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
    protected b2DynamicTree create(long address, Pointer ptr) {
        return ptr == null ? new b2DynamicTree(address) : new b2DynamicTree(ptr);
    }
    
    /** @return Returns the property {@code nodes} */
    @Override
    public long nodes() { return nnodes(address()); }

    /** @return Returns the property {@code parents} */
    @Override
    public long parents() { return nparents(address()); }

    /** @return Returns the property {@code proxies} */
    @Override
    public long proxies() { return nproxies(address()); }

    /** @return Returns the property {@code nodeEnd} */
    @Override
    public int nodeEnd() { return nnodeEnd(address()); }

    /** @return Returns the property {@code nodeCapacity} */
    @Override
    public int nodeCapacity() { return nnodeCapacity(address()); }

    /** @return Returns the property {@code pairFreeList} */
    @Override
    public int pairFreeList() { return npairFreeList(address()); }

    /** @return Returns the property {@code proxyCount} */
    @Override
    public int proxyCount() { return nproxyCount(address()); }

    /** @return Returns the property {@code proxyCapacity} */
    @Override
    public int proxyCapacity() { return nproxyCapacity(address()); }

    /** @return Returns the property {@code proxyFreeList} */
    @Override
    public int proxyFreeList() { return nproxyFreeList(address()); }

    /** @return Returns the property {@code swapNodes} */
    @Override
    public long swapNodes() { return nswapNodes(address()); }

    /** @return Returns the property {@code leafIndices} */
    @Override
    public long leafIndices() { return nleafIndices(address()); }

    /** @return Returns the property {@code leafNodes} */
    @Override
    public long leafNodes() { return nleafNodes(address()); }

    /** @return Returns the property {@code leafBoxes} */
    @Override
    public long leafBoxes() { return nleafBoxes(address()); }

    /** @return Returns the property {@code leafCenters} */
    @Override
    public long leafCenters() { return nleafCenters(address()); }

    /** @return Returns the property {@code binIndices} */
    @Override
    public long binIndices() { return nbinIndices(address()); }

    /** @return Returns the property {@code rebuildCapacity} */
    @Override
    public int rebuildCapacity() { return nrebuildCapacity(address()); }

    /** @return Returns the property {@code dfsOrdered} */
    @Override
    public boolean dfsOrdered() { return ndfsOrdered(address()); }

    /**
     * Set the value of property {@code nodes}
     *
     * @param value long
     * @return b2DynamicTree
     */
    public b2DynamicTree nodes(long value) {
        nnodes(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code parents}
     *
     * @param value long
     * @return b2DynamicTree
     */
    public b2DynamicTree parents(long value) {
        nparents(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code proxies}
     *
     * @param value long
     * @return b2DynamicTree
     */
    public b2DynamicTree proxies(long value) {
        nproxies(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code nodeEnd}
     *
     * @param value int
     * @return b2DynamicTree
     */
    public b2DynamicTree nodeEnd(int value) {
        nnodeEnd(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code nodeCapacity}
     *
     * @param value int
     * @return b2DynamicTree
     */
    public b2DynamicTree nodeCapacity(int value) {
        nnodeCapacity(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code pairFreeList}
     *
     * @param value int
     * @return b2DynamicTree
     */
    public b2DynamicTree pairFreeList(int value) {
        npairFreeList(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code proxyCount}
     *
     * @param value int
     * @return b2DynamicTree
     */
    public b2DynamicTree proxyCount(int value) {
        nproxyCount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code proxyCapacity}
     *
     * @param value int
     * @return b2DynamicTree
     */
    public b2DynamicTree proxyCapacity(int value) {
        nproxyCapacity(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code proxyFreeList}
     *
     * @param value int
     * @return b2DynamicTree
     */
    public b2DynamicTree proxyFreeList(int value) {
        nproxyFreeList(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code swapNodes}
     *
     * @param value long
     * @return b2DynamicTree
     */
    public b2DynamicTree swapNodes(long value) {
        nswapNodes(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code leafIndices}
     *
     * @param value long
     * @return b2DynamicTree
     */
    public b2DynamicTree leafIndices(long value) {
        nleafIndices(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code leafNodes}
     *
     * @param value long
     * @return b2DynamicTree
     */
    public b2DynamicTree leafNodes(long value) {
        nleafNodes(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code leafBoxes}
     *
     * @param value long
     * @return b2DynamicTree
     */
    public b2DynamicTree leafBoxes(long value) {
        nleafBoxes(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code leafCenters}
     *
     * @param value long
     * @return b2DynamicTree
     */
    public b2DynamicTree leafCenters(long value) {
        nleafCenters(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code binIndices}
     *
     * @param value long
     * @return b2DynamicTree
     */
    public b2DynamicTree binIndices(long value) {
        nbinIndices(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code rebuildCapacity}
     *
     * @param value int
     * @return b2DynamicTree
     */
    public b2DynamicTree rebuildCapacity(int value) {
        nrebuildCapacity(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code dfsOrdered}
     *
     * @param value boolean
     * @return b2DynamicTree
     */
    public b2DynamicTree dfsOrdered(boolean value) {
        ndfsOrdered(address(), value);
        return this;
    }
    
    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2DynamicTree
     */
    private static b2DynamicTree factory() {
        return new b2DynamicTree(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2DynamicTree
     */
    public static b2DynamicTree createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2DynamicTree(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2DynamicTree}.
     *
     * @param alloc Custom memory manager
     * @return b2DynamicTree
     */
    public static b2DynamicTree alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2DynamicTree(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2DynamicTree}.
     *
     * @return b2DynamicTree
     */
    public static b2DynamicTree calloc() {
        return new b2DynamicTree(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2DynamicTree}.
     *
     * @param arean arena
     * @return b2DynamicTree
     */
    public static b2DynamicTree calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2DynamicTree(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2DynamicTree}.
     *
     * @return b2DynamicTree
     */
    public static b2DynamicTree malloc() {
        return new b2DynamicTree(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2DynamicTree}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2DynamicTree}.
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
     * Reserve an amount n of memory for the object {@code b2DynamicTree}.
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
    
    public static long nnodes(long address) { return memGetAddress(address + NODES); }
    public static long nparents(long address) { return memGetAddress(address + PARENTS); }
    public static long nproxies(long address) { return memGetAddress(address + PROXIES); }
    public static int nnodeEnd(long address) { return memGetInt(address + NODE_END); }
    public static int nnodeCapacity(long address) { return memGetInt(address + NODE_CAPACITY); }
    public static int npairFreeList(long address) { return memGetInt(address + PAIR_FREE_LIST); }
    public static int nproxyCount(long address) { return memGetInt(address + PROXY_COUNT); }
    public static int nproxyCapacity(long address) { return memGetInt(address + PROXY_CAPACITY); }
    public static int nproxyFreeList(long address) { return memGetInt(address + PROXY_FREE_LIST); }
    public static long nswapNodes(long address) { return memGetAddress(address + SWAP_NODES); }
    public static long nleafIndices(long address) { return memGetAddress(address + LEAF_INDICES); }
    public static long nleafNodes(long address) { return memGetAddress(address + LEAF_NODES); }
    public static long nleafBoxes(long address) { return memGetAddress(address + LEAF_BOXES); }
    public static long nleafCenters(long address) { return memGetAddress(address + LEAF_CENTERS); }
    public static long nbinIndices(long address) { return memGetAddress(address + BIN_INDICES); }
    public static int nrebuildCapacity(long address) { return memGetInt(address + REBUILD_CAPACITY); }
    public static boolean ndfsOrdered(long address) { return memGetByte(address + DFS_ORDERED) != 0; }

    public static void nnodes(long address, long value) { memPutAddress(address + NODES, value); }
    public static void nparents(long address, long value) { memPutAddress(address + PARENTS, value); }
    public static void nproxies(long address, long value) { memPutAddress(address + PROXIES, value); }
    public static void nnodeEnd(long address, int value) { memPutInt(address + NODE_END, value); }
    public static void nnodeCapacity(long address, int value) { memPutInt(address + NODE_CAPACITY, value); }
    public static void npairFreeList(long address, int value) { memPutInt(address + PAIR_FREE_LIST, value); }
    public static void nproxyCount(long address, int value) { memPutInt(address + PROXY_COUNT, value); }
    public static void nproxyCapacity(long address, int value) { memPutInt(address + PROXY_CAPACITY, value); }
    public static void nproxyFreeList(long address, int value) { memPutInt(address + PROXY_FREE_LIST, value); }
    public static void nswapNodes(long address, long value) { memPutAddress(address + SWAP_NODES, value); }
    public static void nleafIndices(long address, long value) { memPutAddress(address + LEAF_INDICES, value); }
    public static void nleafNodes(long address, long value) { memPutAddress(address + LEAF_NODES, value); }
    public static void nleafBoxes(long address, long value) { memPutAddress(address + LEAF_BOXES, value); }
    public static void nleafCenters(long address, long value) { memPutAddress(address + LEAF_CENTERS, value); }
    public static void nbinIndices(long address, long value) { memPutAddress(address + BIN_INDICES, value); }
    public static void nrebuildCapacity(long address, int value) { memPutInt(address + REBUILD_CAPACITY, value); }
    public static void ndfsOrdered(long address, boolean value) { memPutByte(address + DFS_ORDERED, (byte) (value ? 1 : 0)); }

    // -----------------------------------

    /** An array of {@code b2DynamicTree} structs. */
    public static class Buffer extends StructBuffer<b2DynamicTree, Buffer> implements JNINative, ConstB2DynamicTree.ConstBuffer<b2DynamicTree, Buffer> {

        /** An element that provides information about the structure. */
        private static final b2DynamicTree ELEMENT_FACTORY = b2DynamicTree.factory();

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
        protected b2DynamicTree getElementFactory() {
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
