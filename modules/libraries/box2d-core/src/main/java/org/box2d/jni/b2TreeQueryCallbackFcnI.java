/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import java.nio.LongBuffer;
import java.util.function.Function;

import org.box2d.jni.system.CallbackI;

import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.Upcalls.*;

/**
 * Callback function: {@code typedef bool b2TreeQueryCallbackFcn( int proxyId, uint64_t userData, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@FunctionalInterface
public interface b2TreeQueryCallbackFcnI extends CallbackI {

    /**
     * Native callback constructor.
     */
    Function<CallbackI, Long> CONSTRUCTOR = (instance) -> {
        LongBuffer targs = createLongBuffer(3);
        targs.put(ffi_type_sint32)
             .put(ffi_type_uint64)
             .put(ffi_type_pointer);
        targs.flip();
        long rtype = ffi_type_uint8;
        
        return njniCallbackCreate(instance, rtype, targs, 3);
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
        boolean __result = invoke(
                memGetInt(memGetAddress(args)),
                memGetLong(memGetAddress(args + POINTER_SIZE)),
                memGetAddress(memGetAddress(args + 2 * POINTER_SIZE))
        );
        apiClosureRet(resp, (byte) (__result ? 1 : 0));
    }

    /**
     * The function of the callback.
     *
     * @param proxyId int
     * @param userData lont
     * @param context long
     * @return boolean
     */
    boolean invoke(int proxyId, long userData, long context );
}
