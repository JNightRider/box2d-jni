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
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2DynamicTree</code>. (native type: const
 * b2DynamicTree)
 *
 * @author wil
 * @version 2.0.0
 * @since 1.0.0
 */
public interface ConstB2DynamicTree extends ConstStruct {

    /**
     * Array of nodes. The root is at index zero and index 1 is empty. Otherwise
     * siblings are paired at even indices. Has holes for free node pairs.
     *
     * @return {@code b2TreeNode*}
     */
    long nodes();

    /**
     * Parent index per node. The free list is interweaved.
     *
     * @return {@code int32_t*}
     */
    long parents();

    /**
     * Proxy data split from node array as cold data.
     *
     * @return {@code b2TreeProxy*}
     */
    long proxies();

    /**
     * Every allocated node has a lower index than this.
     *
     * @return {@code int32_t}
     */
    int nodeEnd();

    /**
     * The allocated node space
     *
     * @return {@code int32_t}
     */
    int nodeCapacity();

    /**
     * Free pairs below nodeEnd
     *
     * @return {@code int32_t}
     */
    int pairFreeList();

    /**
     * Number of proxies created
     *
     * @return {@code int32_t}
     */
    int proxyCount();

    /**
     * The allocated proxy space
     *
     * @return {@code int32_t}
     */
    int proxyCapacity();

    /**
     * Proxy free list
     *
     * @return {@code int32_t}
     */
    int proxyFreeList();

    /**
     * Array of nodes for rebuild.
     *
     * @return {@code b2TreeNode*}
     */
    long swapNodes();

    /**
     * Leaf indices for rebuild
     *
     * @return {@code int32_t*}
     */
    long leafIndices();

    /**
     * Leaves for the rebuild. May represent a proxy or a retained subtree.
     *
     * @return {@code b2TreeNode*}
     */
    long leafNodes();

    /**
     * Leaf bounding boxes for rebuild
     *
     * @return {@code b2AABB*}
     */
    long leafBoxes();

    /**
     * Leaf bounding box centers for rebuild
     *
     * @return {@code b2Vec2*}
     */
    long leafCenters();

    /**
     * Bins for sorting during rebuild
     *
     * @return {@code int32_t*}
     */
    long binIndices();

    /**
     * Allocated space for rebuilding
     *
     * @return {@code int32_t}
     */
    int rebuildCapacity();

    /**
     * Rebuild orders the nodes so the children follow parents. Cache friendly
     * for queries and refitting. The order can be disrupted by proxy creation.
     *
     * @return {@code bool}
     */
    boolean dfsOrdered();

    /**
     * A template that handles the representation of a constant pointer (buffer)
     * of constant structures such as {@code ConstB2DynamicTree}
     *
     * @param <T> The type of object stored in this buffer
     * @param <SELF> The type of this buffer
     */
    interface ConstBuffer<T extends ConstB2DynamicTree, SELF extends ConstBuffer<T, SELF>> extends ConstStructBuffer<T, SELF> {
        /* nothing */
    }
}
