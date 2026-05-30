/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.function;

import org.box2d.jni.system.Pointer;

/**
 * It represents the read-only function {@code b2FinishTaskCallbackI} (its structure
 * cannot be modified, only invoked).
 *
 * @author wil
 * @version 1.0.0
 * @since
 */
public interface CFinishTaskCallback extends Pointer {
    /**
     * The function of the callback.
     *
     * @param userTask long
     * @param userContext long
     */
    void invoke(long userTask, long userContext );
}
