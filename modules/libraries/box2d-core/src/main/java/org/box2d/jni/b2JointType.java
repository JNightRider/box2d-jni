/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;

/**
 * <pre><code>
 * typedef enum b2JointType
 * {
 * 	b2_distanceJoint,
 * 	b2_filterJoint,
 * 	b2_motorJoint,
 * 	b2_prismaticJoint,
 * 	b2_revoluteJoint,
 * 	b2_weldJoint,
 * 	b2_wheelJoint,
 * } b2JointType;
 * </code></pre>
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public enum b2JointType {

    /**
     * <pre><code>
     * b2_distanceJoint -&#62; box2d
     * </code></pre>
     */
    b2_distanceJoint(
        nb2_distanceJoint()
    ),

    /**
     * <pre><code>
     * b2_filterJoint -&#62; box2d
     * </code></pre>
     */
    b2_filterJoint(
        nb2_filterJoint()
    ),

    /**
     * <pre><code>
     * b2_motorJoint -&#62; box2d
     * </code></pre>
     */
    b2_motorJoint(
        nb2_motorJoint()
    ),

    /**
     * <pre><code>
     * b2_prismaticJoint -&#62; box2d
     * </code></pre>
     */
    b2_prismaticJoint(
        nb2_prismaticJoint()
    ),

    /**
     * <pre><code>
     * b2_revoluteJoint -&#62; box2d
     * </code></pre>
     */
    b2_revoluteJoint(
        nb2_revoluteJoint()
    ),

    /**
     * <pre><code>
     * b2_weldJoint -&#62; box2d
     * </code></pre>
     */
    b2_weldJoint(
        nb2_weldJoint()
    ),

    /**
     * <pre><code>
     * b2_wheelJoint -&#62; box2d
     * </code></pre>
     */
    b2_wheelJoint(
        nb2_wheelJoint()
    );

    static {
        Library.initialize();
    }

    /**
     * An integer value that identifies the body type natively, that is, it is the native body type.
     */
    private final Integer b2Type;

    /**
     * Generate a new <code>b2JointType</code>.
     *
     * @param b2Type type
     */
    private b2JointType(Integer b2Type) {
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
     * Evaluate the native type of a body to return an enumerated object ready to be consumed.
     *
     * @param type type
     * @return body type
     */
    public static b2JointType valueOf(int type) {
        if (type == b2_distanceJoint.value()) {
            return b2_distanceJoint;
        } else if (type == b2_filterJoint.value()) {
            return b2_filterJoint;
        } else if (type == b2_motorJoint.value()) {
            return b2_motorJoint;
        } else if (type == b2_prismaticJoint.value()) {
            return b2_prismaticJoint;
        } else if (type == b2_revoluteJoint.value()) {
            return b2_revoluteJoint;
        } else if (type == b2_weldJoint.value()) {
            return b2_weldJoint;
        }
        return b2_wheelJoint;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.valueOf(b2Type);
    }

    /* Binding JNI to property 'b2_distanceJoint' of structure 'b2JointType' */
    public static native int nb2_distanceJoint();
    /* Binding JNI to property 'b2_filterJoint' of structure 'b2JointType' */
    public static native int nb2_filterJoint();
    /* Binding JNI to property 'b2_motorJoint' of structure 'b2JointType' */
    public static native int nb2_motorJoint();
    /* Binding JNI to property 'b2_prismaticJoint' of structure 'b2JointType' */
    public static native int nb2_prismaticJoint();
    /* Binding JNI to property 'b2_revoluteJoint' of structure 'b2JointType' */
    public static native int nb2_revoluteJoint();
    /* Binding JNI to property 'b2_weldJoint' of structure 'b2JointType' */
    public static native int nb2_weldJoint();
    /* Binding JNI to property 'b2_wheelJoint' of structure 'b2JointType' */
    public static native int nb2_wheelJoint();
}
