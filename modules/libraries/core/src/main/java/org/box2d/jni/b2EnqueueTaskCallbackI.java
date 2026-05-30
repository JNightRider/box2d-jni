/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import java.nio.LongBuffer;
import java.util.function.Function;

import org.box2d.jni.system.CallbackI;
import org.box2d.jni.system.JNI;
import org.box2d.jni.system.VarType;

import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.Upcalls.*;
import org.box2d.jni.function.CTaskCallback;

/**
 * Callback function: {@code typedef void* b2EnqueueTaskCallback( b2TaskCallback* task, void* taskContext, void* userContext );}
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@FunctionalInterface
public interface b2EnqueueTaskCallbackI extends CallbackI {

    /**
     * Native callback constructor.
     */
    Function<CallbackI, Long> CONSTRUCTOR = (instance) -> {
        LongBuffer targs = createLongBuffer(3);
        targs.put(ffi_type_pointer)
             .put(ffi_type_pointer)
             .put(ffi_type_pointer);
        targs.flip();
        long rtype = ffi_type_pointer;
        
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
        try (b2TaskCallback callback = new b2TaskCallback(memGetAddress(memGetAddress(args))) {
            @Override public void invoke(long taskContext) {
                JNI.invokePV(taskContext, address());
            }

            @Override public long functionAddress() {
                return super.address();
            }
        }) {
            long __result = invoke(
                    callback,
                    memGetAddress(memGetAddress(args + VarType.Pointer.sizeof())),
                    memGetAddress(memGetAddress(args + 2 * VarType.Pointer.sizeof()))
            );
            apiClosureRetP(resp, __result);
        }
    }

    /**
     * The function of the callback.
     *
     * @param task FuntionTaskCallback
     * @param taskContext long
     * @param userContext long
     * @return long
     */
    long invoke(CTaskCallback task, long taskContext, long userContext );
}
