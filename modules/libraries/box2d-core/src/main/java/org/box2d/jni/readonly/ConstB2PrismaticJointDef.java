/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2PrismaticJointDef</code>. (native type: const b2PrismaticJointDef)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2PrismaticJointDef extends ConstStruct {

    /**
     * Base joint definition
     *
     * @return ConstB2JointDef
     */
    ConstB2JointDef base();

    /**
     * Enable a linear spring along the prismatic joint axis
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
     * The target translation for the joint in meters. The spring-damper will
     * drive to this translation.
     *
     * @return float
     */
    float targetTranslation();

    /**
     * Enable/disable the joint limit
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
     * Enable/disable the joint motor
     *
     * @return boolean
     */
    boolean enableMotor();

    /**
     * The maximum motor force, typically in newtons
     *
     * @return float
     */
    float maxMotorForce();

    /**
     * The desired motor speed, typically in meters per second
     *
     * @return float
     */
    float motorSpeed();

    /**
     *
     * @return floatUsed internally to detect a valid definition. DO NOT SET.
     */
    int internalValue();
}
