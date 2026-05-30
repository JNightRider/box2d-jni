/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.function;

import org.box2d.jni.system.Pointer;

/**
 * It represents the read-only function {@code b2FrictionCallback} (its structure
 * cannot be modified, only invoked).
 *
 * @author wil
 * @version 1.0.0
 * @since
 */
public interface CFrictionCallback extends Pointer {
    /**
     * The function of the callback.
     *
     * @param frictionA float
     * @param userMaterialIdA long
     * @param frictionB float
     * @param userMaterialIdB long
     * @return float
     */
    float invoke(float frictionA, long userMaterialIdA, float frictionB, long userMaterialIdB);
}
