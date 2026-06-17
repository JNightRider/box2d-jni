/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import java.nio.LongBuffer;
import java.util.function.Function;

import org.box2d.jni.function.CCastResultFcn;
import org.box2d.jni.system.CallbackI;
import org.box2d.jni.system.VarType;

import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.Upcalls.*;

/**
 * Callback function: {@code typedef float b2CastResultFcn( b2ShapeId shapeId, b2Pos point, b2Vec2 normal, float fraction, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@FunctionalInterface
public interface b2CastResultFcnI extends CallbackI, CCastResultFcn {

    /**
     * Native callback constructor.
     */
    Function<CallbackI, Long> CONSTRUCTOR = (instance) -> {
        LongBuffer targs = createLongBuffer(5);
        targs.put(ffi_type_b2ShapeId)
             .put(ffi_type_b2Pos)
             .put(ffi_type_b2Vec2)
             .put(ffi_type_float)
             .put(ffi_type_pointer);
        targs.flip();
        long rtype = ffi_type_float;
        
        return njniCallbackCreate(instance, rtype, targs, 5);
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
                isByValue()
                        ? memcpy(b2ShapeId.malloc(), () -> memGetAddress(args), b2ShapeId.SIZEOF)
                        : b2ShapeId.createSafe(() -> memGetAddress(args)),
                isByValue()
                        ? memcpy(b2Pos.nmalloc(), () -> memGetAddress(args + VarType.Uintptrt.sizeof()), b2Pos.DSIZEOF)
                        : b2Pos.ncreateSafe(() -> memGetAddress(args + VarType.Uintptrt.sizeof())),
                isByValue()
                        ? memcpy(b2Vec2.malloc(), () -> memGetAddress(args + 2 * VarType.Uintptrt.sizeof()), b2Vec2.SIZEOF)
                        : b2Vec2.createSafe(() -> memGetAddress(args + 2 * VarType.Uintptrt.sizeof())),
                memGetFloat(memGetAddress(args + 3 * VarType.Uintptrt.sizeof())),
                memGetAddress(memGetAddress(args + 4 * VarType.Uintptrt.sizeof()))
        );
        apiClosureRet(resp, __result);
    }
}
