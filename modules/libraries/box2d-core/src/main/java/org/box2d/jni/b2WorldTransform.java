/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.readonly.ConstB2WorldTransform;
import org.box2d.jni.system.AllocFunc;
import org.box2d.jni.system.Pointer;

/**
 * <pre><code>
 * #if defined( BOX2D_DOUBLE_PRECISION )
 * typedef struct b2WorldTransform
 * {
 * 	b2Pos p;
 * 	b2Rot q;
 * } b2WorldTransform;
 * #else
 * typedef b2Transform b2WorldTransform;
 * #endif
 * </code></pre>
 *
 * @param <SELF> The type of structure that implements this definition
 *              {@code const typedef b2Pos}
 * @param <P> The value type of property {@code P} of the structure
 * @param <Q> The value type of property {@code Q} of the structure
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface b2WorldTransform<SELF extends b2WorldTransform<SELF, P, Q>, P extends b2Pos, Q extends b2Rot> extends Pointer, ConstB2WorldTransform<P, Q> {

    /** The struct size in bytes. */
    final int DSIZEOF = BOX2D_DOUBLE_PRECISION ? b2WorldTransformI.SIZEOF : b2Transform.SIZEOF;

    /** The struct alignment in bytes. */
    final int DALIGNOF = BOX2D_DOUBLE_PRECISION ? b2WorldTransformI.ALIGNOF : b2Transform.ALIGNOF;

    /**
     * Initializes this struct with the specified values.
     *
     * @param p the valur {@code p}
     * @param q the valur {@code q}
     *
     * @return b2WorldTransform
     */
    SELF set(
        P p,
        Q q
    );

    /**
     * An object of type {@link b2Pos}
     *
     * @return b2Pos
     */
    @Override
    P p();

    /**
     * An object of type {@link b2Rot}
     *
     * @return b2Rot
     */
    @Override
    Q q();

    /**
     * Set an object of type {@link b2Pos}
     *
     * @param value b2Pos
     * @return b2WorldTransform
     */
    SELF p(P value);

    /**
     * Set an object of type {@link b2Rot}
     *
     * @param value b2Rot
     * @return b2WorldTransform
     */
    SELF q(Q value);

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2WorldTransform
     */
    static b2WorldTransform ncreateSafe(Pointer ptr) {
        return BOX2D_DOUBLE_PRECISION ? b2WorldTransformI.createSafe(ptr) : b2Transform.createSafe(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2WorldTransform}.
     *
     * @param alloc Custom memory manager
     * @return b2WorldTransform
     */
    static b2WorldTransform nalloc(AllocFunc alloc) {
        return BOX2D_DOUBLE_PRECISION ? b2WorldTransformI.alloc(alloc) : b2Transform.alloc(alloc);
    }

    /**
     * Reserve memory for the new object {@code b2WorldTransform}.
     *
     * @return b2WorldTransform
     */
    static b2WorldTransform nmalloc() {
        return BOX2D_DOUBLE_PRECISION ? b2WorldTransformI.malloc() : b2Transform.malloc();
    }
}
