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
 * Interface that is responsible for representing a native object that is a constant
 * of type <code>b2DistanceJointDef</code>. (native type: const b2DistanceJointDef)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2DistanceJointDef extends ConstStruct {

    /**
     * Base joint definition
     *
     * @return ConstB2JointDef
     */
    ConstB2JointDef base();

    /**
     * The rest length of this joint. Clamped to a stable minimum value.
     *
     * @return float
     */
    float length();

    /**
     * Enable the distance constraint to behave like a spring. If false then the
     * distanc()e joint will be rigid, overriding the limit and motor.
     *
     * @return boolean
     */
    boolean enableSpring();

    /**
     * The lower spring force controls how much tension it can sustain
     *
     * @return float
     */
    float lowerSpringForce();

    /**
     * The upper spring force controls how much compression it an sustain
     *
     * @return float
     */
    float upperSpringForce();

    /**
     * The spring linear stiffness Hertz, cycles per second
     *
     * @return float
     */
    float hertz();

    /**
     * The spring linear damping ratio, non-dimensional
     *
     * @return float
     */
    float dampingRatio();

    /**
     * Enable/disable the joint limit
     *
     * @return float
     */
    boolean enableLimit();

    /**
     * Minimum length for limit. Clamped to a stable minimum value.
     *
     * @return float
     */
    float minLength();

    /**
     * Maximum length for limit. Must be greater than or equal to the minimum
     * length.
     *
     * @return float
     */
    float maxLength();

    /**
     * Enable/disable the joint motor
     *
     * @return float
     */
    boolean enableMotor();

    /**
     * The maximum motor force, usually in newtons
     *
     * @return float
     */
    float maxMotorForce();

    /**
     * The desired motor speed, usually in meters per second
     *
     * @return float
     */
    float motorSpeed();

    /**
     * Used internally to detect a valid definition. DO NOT SET.
     *
     * @return int
     */
    int internalValue();
}
