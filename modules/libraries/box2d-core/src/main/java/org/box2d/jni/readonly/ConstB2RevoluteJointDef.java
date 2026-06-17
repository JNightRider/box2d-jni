/*
BSD 3-Clause License

Copyright (c) 2026, Night Rider

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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
