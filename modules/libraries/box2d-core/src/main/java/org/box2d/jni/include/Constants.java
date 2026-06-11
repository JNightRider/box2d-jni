/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.include;

import org.box2d.jni.system.Library;
import static org.box2d.jni.include.MathFunctions.*;

/**
 * Class that represents the {@code constants.h} header of box2d.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Constants {
    static { Library.initialize(); }
    
    /** {@code #define B2_HUGE ( 100000.0f * b2GetLengthUnitsPerMeter() ) } */
    public static final float B2_HUGE = ( 100000.0f * b2GetLengthUnitsPerMeter() );

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
}
