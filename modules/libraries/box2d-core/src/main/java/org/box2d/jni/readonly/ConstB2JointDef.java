/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a constant
 * of type <code>b2JointDef</code>. (native type: const b2JointDef)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2JointDef extends ConstStruct {

    /**
     * User data pointer
     *
     * @return long
     */
    long userData();

    /**
     * The first attached body
     *
     * @return ConstB2BodyId
     */
    ConstB2BodyId bodyIdA();

    /**
     * The second attached body
     *
     * @return ConstB2BodyId
     */
    ConstB2BodyId bodyIdB();

    /**
     * The first local joint frame
     *
     * @return ConstB2Transform
     */
    ConstB2Transform localFrameA();

    /**
     * The second local joint frame
     *
     * @return ConstB2Transform
     */
    ConstB2Transform localFrameB();

    /**
     * Force threshold for joint events
     *
     * @return float
     */
    float forceThreshold();

    /**
     * Torque threshold for joint events
     *
     * @return float
     */
    float torqueThreshold();

    /**
     * Constraint hertz (advanced feature)
     *
     * @return float
     */
    float constraintHertz();

    /**
     * Constraint damping ratio (advanced feature)
     *
     * @return float
     */
    float constraintDampingRatio();

    /**
     * Debug draw scale
     *
     * @return float
     */
    float drawScale();

    /**
     * Set this flag to true if the attached bodies should collide
     *
     * @return float
     */
    boolean collideConnected();
}
