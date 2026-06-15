/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2RevoluteJointDef</code>. (native type: const b2RevoluteJointDef)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2RevoluteJointDef extends ConstStruct {

    /**
     * Base joint definition
     *
     * @return ConstB2JointDef
     */
    ConstB2JointDef base();

    /**
     * The target angle for the joint in radians. The spring-damper will drive
     * to this angle.
     *
     * @return float
     */
    float targetAngle();

    /**
     * Enable a rotational spring on the revolute hinge axis
     *
     * @return boolean
     */
    boolean enableSpring();

    /**
     * The spring stiffness Hertz, cycles per second
     *
     * @return float
     */
    float hertz();

    /**
     * The spring damping ratio, non-dimensional
     *
     * @return float
     */
    float dampingRatio();

    /**
     * A flag to enable joint limits
     *
     * @return boolean
     */
    boolean enableLimit();

    /**
     * The lower angle for the joint limit in radians. Minimum of -0.99*pi
     * radians.
     *
     * @return float
     */
    float lowerAngle();

    /**
     * The upper angle for the joint limit in radians. Maximum of 0.99*pi
     * radians.
     *
     * @return float
     */
    float upperAngle();

    /**
     * A flag to enable the joint motor
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
