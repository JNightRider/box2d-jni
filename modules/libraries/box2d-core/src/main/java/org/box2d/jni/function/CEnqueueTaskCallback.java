/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.function;

import org.box2d.jni.system.Pointer;

/**
 * It represents the read-only function {@code b2EnqueueTaskCallbackI} (its structure
 * cannot be modified, only invoked).
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CEnqueueTaskCallback extends Pointer {
    /**
     * The function of the callback.
     *
     * @param task FuntionTaskCallback
     * @param taskContext long
     * @param userContext long
     * @return long
     */
    long invoke(CTaskCallback task, long taskContext, long userContext );
}
