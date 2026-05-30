/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.system;

import java.util.function.Function;

import org.box2d.jni.function.CFunction;
import static org.box2d.jni.system.Upcalls.*;

/**
 * Interface for dynamically created native functions that call into Java code
 * (callbacks).
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CallbackI extends Pointer, CFunction {

    /**
     * Native callback destroyer
     */
    Function<Long, Void> DESCTRUCTOR = (t) -> {
        if (t != null && t != NULL) {
            njniCallbackFree(t);
        }
        return null;
    };

    /**
     * A handler for the native class constructor.
     *
     * @return Function|new
     */
    Function<CallbackI, Long> __constructor();

    /**
     * A handler for the native class destructor.
     *
     * @return Function|free()
     */
    public default Function<Long, Void> __destructor() {
        return DESCTRUCTOR;
    }

    /**
     * Returns the raw pointer address as a {@code long} value.
     *
     * @return the pointer address
     */
    @Override
    public default long address() {
        return upcallGet(this);
    }

    /**
     * The Java method that will be called from native code when the native
     * callback function is invoked.
     *
     * @param resp A pointer where the return value of the called function is
     *             stored
     * @param args A pointer that contains all the arguments of the function
     *             called
     */
    void callback(long resp, long args);

    /**
     * Returns the address of the function that this {@code Callback} points to.
     *
     * @see JNI
     *
     * @return the function address
     */
    @Override
    default long functionAddress() {
        return napiClosureFunction(address());
    }
}
