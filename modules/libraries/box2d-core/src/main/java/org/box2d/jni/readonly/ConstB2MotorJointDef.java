/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2MotorJointDef</code>. (native type: const
 * b2MotorJointDef)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2MotorJointDef extends ConstStruct {

    /**
     * Base joint definition
     *
     * @return float
     */
    ConstB2JointDef base();

    /**
     * The desired linear velocity
     *
     * @return float
     */
    ConstB2Vec2 linearVelocity();

    /**
     * The maximum motor force in newtons
     *
     * @return float
     */
    float maxVelocityForce();

    /**
     * The desired angular velocity
     *
     * @return float
     */
    float angularVelocity();

    /**
     * The maximum motor torque in newton-meters
     *
     * @return float
     */
    float maxVelocityTorque();

    /**
     * Linear spring hertz for position control
     *
     * @return float
     */
    float linearHertz();

    /**
     * Linear spring damping ratio
     *
     * @return float
     */
    float linearDampingRatio();

    /**
     * Maximum spring force in newtons
     *
     * @return float
     */
    float maxSpringForce();

    /**
     * Angular spring hertz for position control
     *
     * @return float
     */
    float angularHertz();

    /**
     * Angular spring damping ratio
     *
     * @return float
     */
    float angularDampingRatio();

    /**
     * Maximum spring torque in newton-meters
     *
     * @return float
     */
    float maxSpringTorque();

    /**
     * Used internally to detect a valid definition. DO NOT SET.
     *
     * @return int
     */
    int internalValue();
}
