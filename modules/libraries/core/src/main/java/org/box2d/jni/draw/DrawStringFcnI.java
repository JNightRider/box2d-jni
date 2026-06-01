/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.draw;

import java.nio.LongBuffer;
import java.util.function.Function;

import org.box2d.jni.b2Vec2;
import org.box2d.jni.function.CDrawStringFcn;
import org.box2d.jni.system.CallbackI;
import org.box2d.jni.system.VarType;

import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.Upcalls.*;

/**
 * Callback function: {@code void ( *DrawStringFcn )( b2Vec2 p, const char* s, b2HexColor color, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@FunctionalInterface
public interface DrawStringFcnI extends CallbackI, CDrawStringFcn {

    /**
     * Native callback constructor.
     */
    Function<CallbackI, Long> CONSTRUCTOR = (instance) -> {
        LongBuffer targs = createLongBuffer(4);
        targs.put(ffi_type_b2Vec2)
             .put(ffi_type_pointer)
             .put(ffi_type_uint32)
             .put(ffi_type_pointer);
        targs.flip();
        long rtype = ffi_type_void;

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
        invoke(
                isByValue()
                        ? memcpy(b2Vec2.malloc(), () -> memGetAddress(args), b2Vec2.SIZEOF)
                        : b2Vec2.createSafe(() -> memGetAddress(args)),
                memGetAddress(memGetAddress(args + VarType.Uintptrt.sizeof())),
                memGetInt(memGetAddress(args + 2 * VarType.Uintptrt.sizeof())),
                memGetAddress(memGetAddress(args + 3 * VarType.Uintptrt.sizeof()))
        );
    }
}
