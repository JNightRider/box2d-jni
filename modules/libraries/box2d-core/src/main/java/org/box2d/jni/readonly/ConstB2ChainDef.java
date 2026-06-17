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
 * constant of type <code>b2ChainDef</code>. (native type: const b2ChainDef)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2ChainDef extends ConstStruct {

    /**
     * Use this to store application specific shape data.
     *
     * @return long
     */
    long userData();

    /**
     * An array of at least 4 points. These are cloned and may be temporary.
     *
     * @return long
     */
    long points();

    /**
     * The point count, must be 4 or more.
     *
     * @return
     */
    int count();

    /**
     * Surface materials for each segment. These are cloned.
     *
     * @return long
     */
    long materials();

    /**
     * The material count. Must be 1 or count. This allows you to provide one
     * material for all segments or a unique material per segment. For open
     * chains, the material on the ghost segments are place holders.
     *
     * @return int
     */
    int materialCount();

    /**
     * Contact filtering data.
     *
     * @return ConstB2Filter
     */
    ConstB2Filter filter();

    /**
     * Indicates a closed chain formed by connecting the first and last points
     *
     * @return boolean
     */
    boolean isLoop();

    /**
     * Enable sensors to detect this chain. False by default.
     *
     * @return boolean
     */
    boolean enableSensorEvents();

    /**
     * Used internally to detect a valid definition. DO NOT SET.
     *
     * @return int
     */
    int internalValue();
}
