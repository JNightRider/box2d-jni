/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import java.nio.LongBuffer;
import java.util.function.Function;

import org.box2d.jni.function.COverlapResultFcn;
import org.box2d.jni.system.CallbackI;
import org.box2d.jni.system.VarType;

import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.Upcalls.*;

/**
 * Callback function: {@code typedef bool b2OverlapResultFcn( b2ShapeId shapeId, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@FunctionalInterface
public interface b2OverlapResultFcnI extends CallbackI, COverlapResultFcn {

    /**
     * Native callback constructor.
     */
    Function<CallbackI, Long> CONSTRUCTOR = (instance) -> {
        LongBuffer targs = createLongBuffer(2);
        targs.put(ffi_type_b2ShapeId)
             .put(ffi_type_pointer);
        targs.flip();
        long rtype = ffi_type_sint8;
        
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
        boolean __result = invoke(
                isByValue()
                        ? memcpy(b2ShapeId.malloc(), () -> memGetAddress(args), b2ShapeId.SIZEOF)
                        : b2ShapeId.createSafe(() -> memGetAddress(args)),
                memGetAddress(memGetAddress(args + VarType.Uintptrt.sizeof()))
        );
        apiClosureRet(resp, (byte) (__result ? 1 : 0));
    }
}
