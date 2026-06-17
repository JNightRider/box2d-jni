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
