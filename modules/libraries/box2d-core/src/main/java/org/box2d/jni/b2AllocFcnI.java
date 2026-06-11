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

/**
 * Callback function: {@code typedef void* b2AllocFcn( unsigned int size, int alignment );}
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@FunctionalInterface
public interface b2AllocFcnI extends CallbackI {

    /**
     * Native callback constructor.
     */
    Function<CallbackI, Long> CONSTRUCTOR = (instance) -> {
        LongBuffer targs = createLongBuffer(2);
        targs.put(ffi_type_size_t)
             .put(ffi_type_sint32);
        targs.flip();
        long rtype = ffi_type_pointer;
        
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
        long __result = invoke(
                memGetAddress(memGetAddress(args)),
                memGetInt(memGetAddress(args + VarType.Pointer.sizeof()))
        );
        apiClosureRetP(resp, __result);
    }

    /**
     * The function of the callback.
     *
     * @param size long
     * @param alignment long
     * @return long
     */
    long invoke(long size, int alignment);
}
