/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.function;

import org.box2d.jni.system.Pointer;

/**
 * It represents the read-only function {@code b2RestitutionCallback} (its structure
 * cannot be modified, only invoked).
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CRestitutionCallback extends Pointer {
    /**
     * The function of the callback.
     *
     * @param restitutionA float
     * @param userMaterialIdA long
     * @param restitutionB float
     * @param userMaterialIdB long
     * @return float
     */
    float invoke( float restitutionA, long userMaterialIdA, float restitutionB, long userMaterialIdB );
}
