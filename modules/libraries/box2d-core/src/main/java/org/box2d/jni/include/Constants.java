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
package org.box2d.jni.include;

import org.box2d.jni.system.Library;
import org.box2d.jni.system.Pointer;

import static org.box2d.jni.include.MathFunctions.*;

/**
 * Class that represents the {@code <constants.h>} header of box2d.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Constants {
    static { Library.initialize(); }

    /**
     * {@code
     * #if defined( BOX2D_DOUBLE_PRECISION )
     * #define B2_HUGE ( 1.0e9f * b2GetLengthUnitsPerMeter() )
     * #else
     * #define B2_HUGE ( 1.0e5f * b2GetLengthUnitsPerMeter() )
     * #endif
     * }
     */
    public static final Number B2_HUGE = Pointer.BOX2D_DOUBLE_PRECISION
                            ? (1.0e9f * b2GetLengthUnitsPerMeter())
                            : (1.0e5f * b2GetLengthUnitsPerMeter());

    /** {@code #define B2_MAX_WORKERS 32 } */
    public static final float  B2_MAX_WORKERS = 32;

    /** {@code } */
    public static final float B2_MAX_TASKS = 256;

    /** {@code } */
    public static final float B2_GRAPH_COLOR_COUNT = 24;

    /** {@code } */
    public static final float B2_LINEAR_SLOP = ( 0.005f * b2GetLengthUnitsPerMeter() );

    /**
     * {@code #ifndef B2_MAX_WORLDS
     * #define B2_MAX_WORLDS 128
     * #endif
     * }
     */
    public static final float B2_MAX_WORLDS = 128;

    /**
     * {@code 
     * #ifndef B2_NAME_LENGTH
     * #define B2_NAME_LENGTH 10
     * #endif
     * }
     */
    public static final float B2_NAME_LENGTH = 10;

   /** {@code #define B2_MAX_ROTATION ( 0.25f * B2_PI ) } */
    public static final float B2_MAX_ROTATION = ( 0.25f * B2_PI );

    /** {@code #define B2_SPECULATIVE_DISTANCE ( 4.0f * B2_LINEAR_SLOP ) } */
    public static final float B2_SPECULATIVE_DISTANCE = ( 4.0f * B2_LINEAR_SLOP );

    /** {@code #define B2_CONTACT_RECYCLE_DISTANCE ( 10.0f * B2_LINEAR_SLOP ) } */
    public static final float B2_CONTACT_RECYCLE_DISTANCE = ( 10.0f * B2_LINEAR_SLOP );

    /** {@code #define B2_CONTACT_RECYCLE_COS_ANGLE ( 0.98f  ) } */
    public static final float B2_CONTACT_RECYCLE_COS_ANGLE = ( 0.98f  );

    /** {@code #define B2_MAX_AABB_MARGIN ( 0.05f * b2GetLengthUnitsPerMeter() ) } */
    public static final float B2_MAX_AABB_MARGIN = ( 0.05f * b2GetLengthUnitsPerMeter() );

    /** {@code #define B2_AABB_MARGIN_FRACTION 0.125f } */
    public static final float B2_AABB_MARGIN_FRACTION =  0.125f;

    /** {@code #define B2_TIME_TO_SLEEP 0.5f } */
    public static final float B2_TIME_TO_SLEEP = 0.5f;
    /** private constructor */
    private Constants() {}
}
