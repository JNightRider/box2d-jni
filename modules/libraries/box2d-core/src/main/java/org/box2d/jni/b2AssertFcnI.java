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
import static org.box2d.jni.system.MemoryUtil.*;
import static org.box2d.jni.system.Upcalls.*;

/**
 * Callback function: {@code typedef int b2AssertFcn( const char* condition, const char* fileName, int lineNumber ); }
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@FunctionalInterface
public interface b2AssertFcnI extends CallbackI {
    
    /**
     * Native callback constructor.
     */
    Function<CallbackI, Long> CONSTRUCTOR = (instance) -> {
        LongBuffer targs = createLongBuffer(3);
        targs.put(ffi_type_pointer)
             .put(ffi_type_pointer)
             .put(ffi_type_sint32);
        targs.flip();
        long rtype = ffi_type_uint32;
        
        return njniCallbackCreate(instance, rtype, targs, 3);
    };

    /*(non-Javadoc)*/
    @Override
    public default void callback(long resp, long args) {
        int __result = invoke(
                memGetStringUTF8(memGetAddress(memGetAddress(args))),
                memGetStringUTF8(memGetAddress(memGetAddress(args + VarType.Uintptrt.sizeof()))),
                memGetInt(memGetAddress(args + 2 * VarType.Uintptrt.sizeof()))
        );
        apiClosureRet(resp, __result);
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
     * @param condition string
     * @param fileName string
     * @param lineNumber iny
     *
     * @return int
     */
    int invoke( String condition, String fileName, int lineNumber );
}
