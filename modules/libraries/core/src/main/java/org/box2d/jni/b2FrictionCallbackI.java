/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import java.nio.LongBuffer;
import java.util.function.Function;

import org.box2d.jni.function.CFrictionCallback;
import org.box2d.jni.system.CallbackI;
import org.box2d.jni.system.VarType;

import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.Upcalls.*;

/**
 * Callback function: {@code typedef float b2FrictionCallback( float frictionA, uint64_t userMaterialIdA, float frictionB, uint64_t userMaterialIdB );
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@FunctionalInterface
public interface b2FrictionCallbackI extends CallbackI, CFrictionCallback {

    /**
     * Native callback constructor.
     */
    Function<CallbackI, Long> CONSTRUCTOR = (instance) -> {
        LongBuffer targs = createLongBuffer(4);
        targs.put(ffi_type_float)
             .put(ffi_type_uint64)
             .put(ffi_type_float)
             .put(ffi_type_uint64);
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
                memGetFloat(memGetAddress(args)),
                memGetLong(memGetAddress(args + VarType.Uintptrt.sizeof())),
                memGetFloat(memGetAddress(args + 2 * VarType.Uintptrt.sizeof())),
                memGetLong(memGetAddress(args + 3 * VarType.Uintptrt.sizeof()))
        );
        apiClosureRet(resp, __result);
    }    
}
