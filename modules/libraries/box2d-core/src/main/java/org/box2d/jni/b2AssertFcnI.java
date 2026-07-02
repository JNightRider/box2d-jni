/*
BSD 3-Clause License

Copyright (c) 2026, Night Rider

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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
        LongBuffer targs = memCreateLongBuffer(3);
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
                memUTF(memGetAddress(memGetAddress(args))),
                memUTF(memGetAddress(memGetAddress(args + VarType.Uintptrt.sizeof()))),
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
