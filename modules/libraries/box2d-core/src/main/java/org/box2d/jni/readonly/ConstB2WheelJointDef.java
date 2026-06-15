/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2WeldJointDef</code>. (native type: const b2WeldJointDef)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2WheelJointDef extends ConstStruct {

    /**
     * Base joint definition
     *
     * @return ConstB2JointDef
     */
    ConstB2JointDef base();

    /**
     * Enable a linear spring along the local axis
     *
     * @return boolean
     */
    boolean enableSpring();

    /**
     * Spring stiffness in Hertz
     *
     * @return float
     */
    float hertz();

    /**
     * Spring damping ratio, non-dimensional
     *
     * @return float
     */
    float dampingRatio();

    /**
     * Enable/disable the joint linear limit
     *
     * @return boolean
     */
    boolean enableLimit();

    /**
     * The lower translation limit
     *
     * @return float
     */
    float lowerTranslation();

    /**
     * The upper translation limit
     *
     * @return float
     */
    float upperTranslation();

    /**
     * Enable/disable the joint rotational motor
     *
     * @return boolean
     */
    boolean enableMotor();

    /**
     * The maximum motor torque, typically in newton-meters
     *
     * @return float
     */
    float maxMotorTorque();

    /**
     * The desired motor speed in radians per second
     *
     * @return float
     */
    float motorSpeed();

    /**
     * Used internally to detect a valid definition. DO NOT SET.
     *
     * @return float
     */
    int internalValue();
}
