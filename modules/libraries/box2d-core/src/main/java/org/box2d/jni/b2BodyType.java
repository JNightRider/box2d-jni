/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.Library;

/**
 * <pre><code>
 * typedef enum b2BodyType
 * {
 * 	/// zero mass, zero velocity, may be manually moved
 * 	b2_staticBody = 0,
 * 
 * 	/// zero mass, velocity set by user, moved by solver
 * 	b2_kinematicBody = 1,
 * 
 * 	/// positive mass, velocity determined by forces, moved by solver
 * 	b2_dynamicBody = 2,
 * 
 * 	/// number of body types
 * 	b2_bodyTypeCount,
 * } b2BodyType;
 * </code></pre>
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public enum b2BodyType {
    /** 
     * zero mass, zero velocity, may be manually moved 
     * <pre><code>
     * b2_staticBody = 0 -&#62; box2d
     * </code></pre>
     */
    b2_staticBody(
        nb2_staticBody()
    ),
    
    /** 
     * zero mass, velocity set by user, moved by solver
     * <pre><code>
     * b2_kinematicBody = 1 -&#62; box2d
     * </code></pre>
     */
    b2_kinematicBody(
        nb2_kinematicBody()
    ),
    
    /** 
     * positive mass, velocity determined by forces, moved by solver 
     * <pre><code>
     * b2_dynamicBody = 2 -&#62; box2d
     * </code></pre>
     */
    b2_dynamicBody(
        nb2_dynamicBody()
    ),
    
    /** 
     * number of body types 
     * <pre><code>
     * b2_bodyTypeCount -&#62; box2d
     * </code></pre>
     */
    b2_bodyTypeCount(
        nb2_bodyTypeCount()
    );

    static {
        Library.initialize();
    }

    /**
     * An integer value that identifies the body type natively, that is, it is the native body type.
     */
    private final Integer b2Type;

    /**
     * Generate a new <code>BodyType</code>.
     * @param b2Type type
     */
    private b2BodyType(Integer b2Type) {
        this.b2Type = b2Type;
    }

    /**
     * Returns the native type
     * @return int
     */
    protected Integer value() {
        return b2Type;
    }
    
    /**
     * Evaluate the native type of a body to return an enumerated object ready to be consumed.
     * @param type type
     * @return body type
     */
    public static b2BodyType valueOf(int type) {
        if (type == b2_staticBody.value()) {
            return b2_staticBody;
        }  else if (type == b2_kinematicBody.value()) {
            return b2_kinematicBody;
        } else if (type == b2_dynamicBody.value()) {
            return b2_dynamicBody;
        }
        return b2_bodyTypeCount;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString() 
     */
    @Override
    public String toString() {
        return String.valueOf(b2Type);
    }
    
    /* Binding JNI to property 'b2_staticBody' of structure 'b2BodyType' */
    public static native int nb2_staticBody();
    /* Binding JNI to property 'b2_kinematicBody' of structure 'b2BodyType' */
    public static native int nb2_kinematicBody();
    /* Binding JNI to property 'b2_dynamicBody' of structure 'b2BodyType' */
    public static native int nb2_dynamicBody();
    /* Binding JNI to property 'b2_bodyTypeCount' of structure 'b2BodyType' */
    public static native int nb2_bodyTypeCount();
}
