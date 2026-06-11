/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.function;

import org.box2d.jni.b2ShapeId;
import org.box2d.jni.readonly.ConstB2PlaneResult;
import org.box2d.jni.system.Pointer;

/**
 * It represents the read-only function {@code b2PlaneResultFcn} (its
 * structure cannot be modified, only invoked).
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CPlaneResultFcn extends Pointer {

    /**
     * The function of the callback.
     *
     * @param shapeId b2ShapeId
     * @param plane const b2PlaneResult
     * @param context long
     * @return boolean
     */
    boolean invoke(b2ShapeId shapeId, ConstB2PlaneResult plane, long context);

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
