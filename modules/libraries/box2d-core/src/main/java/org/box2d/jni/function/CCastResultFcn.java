/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.function;

import org.box2d.jni.b2Pos;
import org.box2d.jni.b2ShapeId;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Pointer;

/**
 * It represents the read-only function {@code b2CastResultFcn} (its
 * structure cannot be modified, only invoked).
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CCastResultFcn extends Pointer {

    /**
     * The function of the callback.
     *
     * @param shapeId b2ShapeId
     * @param point b2Pos
     * @param normal b2Vec2
     * @param fraction float
     * @param context long
     * @return float
     */
    float invoke(b2ShapeId shapeId, b2Pos point, b2Vec2 normal, float fraction, long context);

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
