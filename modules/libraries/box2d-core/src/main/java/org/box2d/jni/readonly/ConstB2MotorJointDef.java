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
