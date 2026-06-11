/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import java.nio.LongBuffer;
import java.util.function.Function;

import org.box2d.jni.system.CallbackI;
import org.box2d.jni.system.VarType;

import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.Upcalls.*;
import org.box2d.jni.function.CFinishTaskCallback;

/**
 * Callback function: {@code typedef void b2FinishTaskCallback( void* userTask, void* userContext );}
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@FunctionalInterface
public interface b2FinishTaskCallbackI extends CallbackI, CFinishTaskCallback {

    /**
     * Native callback constructor.
     */
    Function<CallbackI, Long> CONSTRUCTOR = (instance) -> {
        LongBuffer targs = createLongBuffer(2);
        targs.put(ffi_type_pointer)
             .put(ffi_type_pointer);
        targs.flip();
        long rtype = ffi_type_void;
        
        return njniCallbackCreate(instance, rtype, targs, 2);
    };

    /**
     * A handler for the native class constructor.
     *
     * @return Function|new
     */
    @Override
    public default Function<CallbackI, Long> __constructor() {
        return CONSTRUCTOR;
    }

    /*(non-Javadoc)*/
    @Override
    public default void callback(long resp, long args) {
        invoke(
                memGetAddress(memGetAddress(args)),
                memGetAddress(memGetAddress(args + VarType.Pointer.sizeof()))
        );
    }
}
