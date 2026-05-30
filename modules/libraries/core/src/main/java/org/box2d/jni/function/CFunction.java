/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.function;

/**
 * An interface that is responsible for representing an invocable function.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CFunction {

    /**
     * Returns the address of the function that this {@code Callback} points to.
     *
     * @see JNI
     *
     * @return the function address
     */
    long functionAddress();
}
