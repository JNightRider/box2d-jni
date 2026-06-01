/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.function;

import org.box2d.jni.b2Transform;
import org.box2d.jni.system.Pointer;

/**
 * It represents the read-only function {@code b2DrawSolidPolygonFcn} (its
 * structure cannot be modified, only invoked).
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CDrawSolidPolygonFcn extends Pointer {

    /**
     * The function of the callback.
     *
     * @param transform b2Transform
     * @param vertices long
     * @param vertexCount int
     * @param radius float
     * @param color int
     * @param context long
     */
    void invoke(b2Transform transform, long vertices, int vertexCount, float radius, int color, long context);

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
