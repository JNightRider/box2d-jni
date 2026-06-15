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
public interface ConstB2WeldJointDef extends ConstStruct {

    /**
     * Base joint definition
     *
     * @return ConstB2JointDef
     */
    ConstB2JointDef base();

    /**
     * Linear stiffness expressed as Hertz (cycles per second). Use zero for
     * maximum stiffness.
     *
     * @return float
     */
    float linearHertz();

    /**
     * Angular stiffness as Hertz (cycles per second). Use zero for maximum
     * stiffness.
     *
     * @return float
     */
    float angularHertz();

    /**
     * Linear damping ratio, non-dimensional. Use 1 for critical damping.
     *
     * @return float
     */
    float linearDampingRatio();

    /**
     * Linear damping ratio, non-dimensional. Use 1 for critical damping.
     *
     * @return float
     */
    float angularDampingRatio();

    /**
     * Used internally to detect a valid definition. DO NOT SET.
     *
     * @return float
     */
    int internalValue();
}
