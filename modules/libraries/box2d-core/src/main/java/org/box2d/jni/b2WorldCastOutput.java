/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.readonly.ConstB2WorldCastOutput;
import org.box2d.jni.system.AllocFunc;
import org.box2d.jni.system.Pointer;

/**
 * <pre><code>
 * #if defined( BOX2D_DOUBLE_PRECISION )
 * 
 * /// World-space cast output. The hit point is a world position. The normal stays a float direction.
 * typedef struct b2WorldCastOutput
 * {
 * 	b2Vec2 normal;	/// The surface normal at the hit point
 * 	b2Pos point;	/// The surface hit point in world space
 * 	float fraction; /// The fraction of the input translation at collision
 * 	int iterations; /// The number of iterations used
 * 	bool hit;	/// Did the cast hit?
 * } b2WorldCastOutput;
 * 
 * #else
 * 
 * typedef b2CastOutput b2WorldCastOutput;
 * 
 * #endif
 * </code></pre>
 *
 * @param <SELF> The type of structure that implements this definition
 *              {@code const typedef b2Pos}
 * @param <POINT> The value type of property {@code POINT} of the structure
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface b2WorldCastOutput<SELF extends b2WorldCastOutput<SELF, POINT>, POINT extends b2Pos> extends Pointer, ConstB2WorldCastOutput<POINT> {

    /** The struct size in bytes. */
    final int DSIZEOF = BOX2D_DOUBLE_PRECISION ? b2WorldCastOutputI.SIZEOF : b2CastOutput.SIZEOF;

    /** The struct alignment in bytes. */
    final int DALIGNOF = BOX2D_DOUBLE_PRECISION ? b2WorldCastOutputI.ALIGNOF : b2CastOutput.ALIGNOF;

    /**
     * The surface normal at the hit point
     *
     * @return b2Vec2
     */
    @Override
    b2Vec2 normal();

    /**
     * The surface hit point in world space
     *
     * @return POINT
     */
    @Override
    POINT point();

    /**
     * The fraction of the input translation at collision
     *
     * @return float
     */
    @Override
    float fraction();

    /**
     * The number of iterations used
     *
     * @return int
     */
    @Override
    int iterations();

    /**
     * Did the cast hit?
     *
     * @return boolean
     */
    @Override
    boolean hit();

    /**
     * The surface normal at the hit point
     *
     * @param value b2Vec2
     * @return b2WorldCastOutput
     */
    SELF normal(b2Vec2 value);

    /**
     * The surface hit point in world space
     *
     * @param value b2Pos
     * @return b2WorldCastOutput
     */
    SELF point(POINT value);

    /**
     * The fraction of the input translation at collision
     *
     * @param value float
     * @return b2WorldCastOutput
     */
    SELF fraction(float value);

    /**
     * The number of iterations used
     *
     * @param value int
     * @return b2WorldCastOutput
     */
    SELF iterations(int value);

    /**
     * Did the cast hit?
     *
     * @param value boolean
     * @return b2WorldCastOutput
     */
    SELF hit(boolean value);

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2WorldCastOutput
     */
    static b2WorldCastOutput ncreateSafe(Pointer ptr) {
        return BOX2D_DOUBLE_PRECISION ? b2WorldCastOutputI.createSafe(ptr) : b2CastOutput.createSafe(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2WorldCastOutput}.
     *
     * @param alloc Custom memory manager
     * @return b2WorldCastOutput
     */
    static b2WorldCastOutput nalloc(AllocFunc alloc) {
        return BOX2D_DOUBLE_PRECISION ? b2WorldCastOutputI.alloc(alloc) : b2CastOutput.alloc(alloc);
    }

    /**
     * Reserve memory for the new object {@code b2WorldCastOutput}.
     *
     * @return b2WorldCastOutput
     */
    static b2WorldCastOutput nmalloc() {
        return BOX2D_DOUBLE_PRECISION ? b2WorldCastOutputI.malloc() : b2CastOutput.malloc();
    }
}
