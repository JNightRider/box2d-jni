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
 * constant of type <code>b2WorldDef</code>. (native type: const b2WorldDef)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2WorldDef extends ConstStruct {

    /**
     * Returns the property {@code gravity}
     *
     * @return ConstB2Vec2
     */
     ConstB2Vec2 gravity();

    /**
     * Returns the property {@code restitutionThreshold}
     *
     * @return float
     */
     float restitutionThreshold();

    /**
     * Returns the property {@code hitEventThreshold}
     *
     * @return float
     */
     float hitEventThreshold();

    /**
     * Returns the property {@code contactHertz}
     *
     * @return float
     */
     float contactHertz();

    /**
     * Returns the property {@code contactDampingRatio}
     *
     * @return float
     */
     float contactDampingRatio();

    /**
     * Returns the property {@code contactSpeed}
     *
     * @return float
     */
     float contactSpeed();

    /**
     * Returns the property {@code maximumLinearSpeed}
     *
     * @return float
     */
     float maximumLinearSpeed();

    /**
     * Returns the property {@code frictionCallback}
     *
     * @return long
     */
     long frictionCallback();

    /**
     * Returns the property {@code restitutionCallback}
     *
     * @return long
     */
     long restitutionCallback();

    /**
     * Returns the property {@code enableSleep}
     *
     * @return boolean
     */
     boolean enableSleep();

    /**
     * Returns the property {@code enableContinuous}
     *
     * @return boolean
     */
     boolean enableContinuous();

    /**
     * Returns the property {@code enableContactSoftening}
     *
     * @return boolean
     */
     boolean enableContactSoftening();

    /**
     * Returns the property {@code workerCount}
     *
     * @return int
     */
     int workerCount();

    /**
     * Returns the property {@code enqueueTask}
     *
     * @return long
     */
     long enqueueTask();

    /**
     * Returns the property {@code finishTask}
     *
     * @return long
     */
     long finishTask();

    /**
     * Returns the property {@code userTaskContext}
     *
     * @return long
     */
     long userTaskContext();

    /**
     * Returns the property {@code userData}
     *
     * @return long
     */
     long userData();

    /**
     * Returns the property {@code capacity}
     *
     * @return ConstB2Capacity
     */
     ConstB2Capacity capacity();

    /**
     * Returns the property {@code internalValue}
     *
     * @return int
     */
     int internalValue();
}
