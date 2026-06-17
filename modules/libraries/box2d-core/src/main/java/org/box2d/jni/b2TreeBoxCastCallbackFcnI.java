/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import java.nio.LongBuffer;
import java.util.function.Function;

import org.box2d.jni.readonly.ConstB2BoxCastInput;
import org.box2d.jni.system.CallbackI;

import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.Upcalls.*;

/**
 * Callback function: {@code typedef float b2TreeBoxCastCallbackFcn( const b2BoxCastInput* input, int proxyId, uint64_t userData, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.1
 */
@FunctionalInterface
public interface b2TreeBoxCastCallbackFcnI extends CallbackI {

    /**
     * Native callback constructor.
     */
    Function<CallbackI, Long> CONSTRUCTOR = (instance) -> {
        LongBuffer targs = createLongBuffer(4);
        targs.put(ffi_type_pointer)
             .put(ffi_type_sint32)
             .put(ffi_type_uint64)
             .put(ffi_type_pointer);
        targs.flip();
        long rtype = ffi_type_float;
        
        return njniCallbackCreate(instance, rtype, targs, 4);
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
        float __result = invoke(
                b2BoxCastInput.createSafe(() -> memGetAddress(memGetAddress(args))),
                memGetInt(memGetAddress(args + POINTER_SIZE)),
                memGetLong(memGetAddress(args + 2 * POINTER_SIZE)),
                memGetAddress(memGetAddress(args + 3 * POINTER_SIZE))
        );
        apiClosureRet(resp, __result);
    }

    /**
     * The function of the callback.
     *
     * @param input ConstB2ShapeCastInput
     * @param proxyId int
     * @param userData long
     * @param context long
     * @return float
     */
    float invoke(ConstB2BoxCastInput input, int proxyId, long userData, long context );
}

