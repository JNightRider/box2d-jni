/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.Library;

/**
 * <pre><code>
 * enum b2TreeNodeFlags
 * {
 *     b2_allocatedNode = 0x0001,
 *     b2_enlargedNode = 0x0002,
 *     b2_leafNode = 0x0004,
 * };
 * </code></pre>
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public enum b2TreeNodeFlags {

    /**
     * <pre><code>
     * b2_allocatedNode -&#62; box2d
     * </code></pre>
     */
    b2_allocatedNode(
        nb2_allocatedNode()
    ),

    /**
     * <pre><code>
     * b2_enlargedNode -&#62; box2d
     * </code></pre>
     */
    b2_enlargedNode(
        nb2_enlargedNode()
    ),

    /**
     * <pre><code>
     * b2_leafNode -&#62; box2d
     * </code></pre>
     */
    b2_leafNode(
        nb2_leafNode()
    );

    static {
        Library.initialize();
    }

    /**
     * An integer value that identifies the body type natively, that is, it is the native body type.
     */
    private final Integer b2Type;

    /**
     * Generate a new <code>b2TreeNodeFlags</code>.
     *
     * @param b2Type type
     */
    private b2TreeNodeFlags(Integer b2Type) {
        this.b2Type = b2Type;
    }

    /**
     * Returns the native type
     *
     * @return int
     */
    protected Integer value() {
        return b2Type;
    }

    /**
     * Evaluate the native type to return an enumerated object ready to be consumed.
     *
     * @param type type
     * @return Tree node flag
     */
    public static b2TreeNodeFlags valueOf(int type) {
        if (type == b2_allocatedNode.value()) {
            return b2_allocatedNode;
        } else if (type == b2_enlargedNode.value()) {
            return b2_enlargedNode;
        } else if (type == b2_leafNode.value()) {
            return b2_leafNode;
        }
        throw new UnsupportedOperationException("enum: " + type);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.valueOf(b2Type);
    }

    /* Binding JNI to property 'b2_allocatedNode' of structure 'b2TreeNodeFlags' */
    public static native int nb2_allocatedNode();
    /* Binding JNI to property 'b2_enlargedNode' of structure 'b2TreeNodeFlags' */
    public static native int nb2_enlargedNode();
    /* Binding JNI to property 'b2_leafNode' of structure 'b2TreeNodeFlags' */
    public static native int nb2_leafNode();
}
