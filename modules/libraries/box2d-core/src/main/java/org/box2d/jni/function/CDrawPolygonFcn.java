/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.function;

import org.box2d.jni.system.Pointer;

/**
 * It represents the read-only function {@code DrawPolygonFcn} (its
 * structure cannot be modified, only invoked).
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CDrawPolygonFcn extends Pointer {

    /**
     * The function of the callback.
     *
     * @param vertices long
     * @param vertexCount int
     * @param color long
     * @param context long
     */
    void invoke( long vertices, int vertexCount, int color, long context );
}
