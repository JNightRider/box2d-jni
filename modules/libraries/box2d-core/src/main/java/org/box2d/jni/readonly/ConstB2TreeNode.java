/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2TreeNode</code>. (native type: const b2TreeNode)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2TreeNode extends ConstStruct {

    /**
     * The node bounding box
     *
     * @return ConstB2AABB
     */
    ConstB2AABB aabb();

    /**
     * Category bits for collision filtering
     *
     * @return long
     */
    long categoryBits();

    /**
     * Children (internal node)
     *
     * @return ConstB2TreeNodeChildren
     */
    ConstB2TreeNodeChildren children();

    /**
     * User data (leaf node)
     *
     * @return long
     */
    long userData();

    /**
     * The node parent index (allocated node)
     *
     * @return int
     */
    int parent();

    /**
     * The node freelist next index (free node)
     *
     * @return int
     */
    int next();

    /**
     * 2 - height
     *
     * @return short
     */
    short height();

    /**
     * 2 - flags
     *
     * @return short
     */
    short flags();
}
