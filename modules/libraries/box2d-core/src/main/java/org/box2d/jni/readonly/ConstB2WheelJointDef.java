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
