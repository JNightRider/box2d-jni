/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2DynamicTree</code>. (native type: const
 * b2DynamicTree)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2DynamicTree extends ConstStruct {

    /**
     * The tree nodes
     *
     * @return ConstB2TreeNode
     */
    long nodes();

    /**
     * The root index
     *
     * @return int
     */
    int root();

    /**
     * The number of nodes
     *
     * @return int
     */
    int nodeCount();

    /**
     * The allocated node space
     *
     * @return int
     */
    int nodeCapacity();

    /**
     * Node free list
     *
     * @return int
     */
    int freeList();

    /**
     * Number of proxies created
     *
     * @return int
     */
    int proxyCount();

    /**
     * Leaf indices for rebuild
     *
     * @return IntBuffer
     */
    long leafIndices();

    /**
     * Leaf bounding boxes for rebuild
     *
     * @return ConstB2AABB.ConstBuffer
     */
    long leafBoxes();

    /**
     * Leaf bounding box centers for rebuild
     *
     * @return ConstB2Vec2.ConstBuffer
     */
    long leafCenters();

    /**
     * Bins for sorting during rebuild
     *
     * @return IntBuffer
     */
    long binIndices();

    /**
     * Allocated space for rebuilding
     *
     * @return int
     */
    int rebuildCapacity();
}
