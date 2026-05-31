/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.function;

import org.box2d.jni.b2ShapeId;
import org.box2d.jni.system.Pointer;

/**
 * It represents the read-only function {@code b2CustomFilterFcnI} (its
 * structure cannot be modified, only invoked).
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CCustomFilterFcn extends Pointer {

    /**
     * The function of the callback.
     *
     * @param shapeIdA b2ShapeId
     * @param shapeIdB b2ShapeId
     * @param context long
     * @return long
     */
    boolean invoke(b2ShapeId shapeIdA, b2ShapeId shapeIdB, long context);

    /**
     * {@code true} if the function arguments are passed by value (a copy of the
     * structure), otherwise {@code false} if it is simply a direct reference to
     * the structure retrieved from linfii.
     *
     * @return boolean
     */
    default boolean isByValue() {
        return true;
    }
}
