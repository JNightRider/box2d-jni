/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.readonly.ConstB2Pos;
import org.box2d.jni.system.AllocFunc;
import org.box2d.jni.system.Pointer;

/**
 * <pre><code>
 * #if defined( BOX2D_DOUBLE_PRECISION )
 * typedef struct b2Pos
 * {
 * 	double x, y;
 * } b2Pos;
 * #else
 * typedef b2Vec2 b2Pos;
 * #endif
 * </code></pre>
 *
 * @param <SELF> The type of structure that implements this definition
 *              {@code const typedef b2Pos}
 * @param <X> The value type of property {@code x} of the structure
 * @param <Y> The value type of property {@code y} of the structure
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface b2Pos<SELF extends b2Pos<SELF, X, Y>, X extends Number, Y extends Number> extends Pointer, ConstB2Pos<X, Y> {

    /** The struct size in bytes. */
    final int DSIZEOF = BOX2D_DOUBLE_PRECISION ? b2PosI.SIZEOF : b2Vec2.SIZEOF;

    /** The struct alignment in bytes. */
    final int DALIGNOF = BOX2D_DOUBLE_PRECISION ? b2PosI.ALIGNOF : b2Vec2.ALIGNOF;

    /**
     * Initializes this struct with the specified values.
     *
     * @param x the valur {@code x}
     * @param y the valur {@code y}
     *
     * @return b2Pos
     */
    SELF set(
        X x,
        Y y
    );

    /**
     * Returns the x coordinate.
     *
     * @return Number
     */
    @Override
    X x();

    /**
     * Returns the y coordinate.
     *
     * @return Number
     */
    @Override
    Y y();

    /**
     * Set the y coordinate.
     *
     * @param value Number
     *
     * @return b2Pos
     */
    SELF x(X value);

    /**
     * Set the y coordinate.
     *
     * @param value Number
     *
     * @return b2Pos
     */
    SELF y(Y value);

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Pos
     */
    static b2Pos ncreateSafe(Pointer ptr) {
        return BOX2D_DOUBLE_PRECISION ? b2PosI.createSafe(ptr) : b2Vec2.createSafe(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Pos}.
     *
     * @param alloc Custom memory manager
     * @return b2Pos
     */
    static b2Pos nalloc(AllocFunc alloc) {
        return BOX2D_DOUBLE_PRECISION ? b2PosI.alloc(alloc) : b2Vec2.alloc(alloc);
    }

    /**
     * Reserve memory for the new object {@code b2Pos}.
     *
     * @return b2Pos
     */
    static b2Pos nmalloc() {
        return BOX2D_DOUBLE_PRECISION ? b2PosI.malloc() : b2Vec2.malloc();
    }
}
