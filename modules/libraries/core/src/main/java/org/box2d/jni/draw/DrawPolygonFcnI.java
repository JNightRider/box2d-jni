/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.draw;

import java.nio.LongBuffer;
import java.util.function.Function;

import org.box2d.jni.function.CDrawPolygonFcn;
import org.box2d.jni.system.CallbackI;
import org.box2d.jni.system.VarType;

import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.Upcalls.*;

/**
 * Callback function: {@code void ( *DrawPolygonFcn )( const b2Vec2* vertices, int vertexCount, b2HexColor color, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@FunctionalInterface
public interface DrawPolygonFcnI extends CallbackI, CDrawPolygonFcn {

    /**
     * Native callback constructor.
     */
    Function<CallbackI, Long> CONSTRUCTOR = (instance) -> {
        LongBuffer targs = createLongBuffer(4);
        targs.put(ffi_type_pointer)
             .put(ffi_type_sint32)
             .put(ffi_type_sint32)
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
                memGetAddress(memGetAddress(args)),
                memGetInt(memGetAddress(args + VarType.Pointer.sizeof())),
                memGetInt(memGetAddress(args + 2 * VarType.Pointer.sizeof())),
                memGetAddress(memGetAddress(args + 3 * VarType.Pointer.sizeof()))
        );
    }
}
