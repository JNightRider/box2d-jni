/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.function;

import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Pointer;

/**
 * It represents the read-only function {@code DrawSolidCapsuleFcn} (its
 * structure cannot be modified, only invoked).
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CDrawSolidCapsuleFcn extends Pointer {

    /**
     * The function of the callback.
     *
     * @param p1 b2Vec2
     * @param p2 b2Vec2
     * @param radius float
     * @param color int
     * @param context long
     */
    void invoke(b2Vec2 p1, b2Vec2 p2, float radius, int color, long context);

    /**
     * {@code true} if the function arguments are passed by value (a copy of the
     * structure), otherwise {@code false} if it is simply a direct reference to
     * the structure retrieved from libfii.
     *
     * @return boolean
     */
    default boolean isByValue() {
        return true;
    }
}
