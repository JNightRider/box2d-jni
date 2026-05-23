/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import java.nio.LongBuffer;
import java.util.function.Function;

import org.box2d.jni.system.CallbackI;

import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.MemoryUtil.*;
import static org.box2d.jni.system.Upcalls.*;

/**
 * Callback function: {@code typedef void b2LogFcn( const char* message ); }
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@FunctionalInterface
public interface b2LogFcnI extends CallbackI {
    
    /**
     * Native callback constructor.
     */
    Function<CallbackI, Long> CONSTRUCTOR = (instance) -> {
        LongBuffer targs = createLongBuffer(1);
        targs.put(ffi_type_pointer);
        targs.flip();
        long rtype = ffi_type_void;
        
        return njniCallbackCreate(instance, rtype, targs, 1);
    };

    /*(non-Javadoc)*/
    @Override
    public default void callback(long resp, long args) {
        invoke(
                memGetStringUTF8(memGetAddress(memGetAddress(args)))
        );
    }

    /**
     * A handler for the native class constructor.
     *
     * @return Function|new
     */
    @Override
    public default Function<CallbackI, Long> __constructor() {
        return CONSTRUCTOR;
    }

    /**
     * The function of the callback.
     *
     * @param message string
     */
    void invoke(String message);
}
