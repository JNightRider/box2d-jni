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
package org.box2d.jni.draw;

import java.nio.LongBuffer;
import java.util.function.Function;

import org.box2d.jni.b2AABB;

import org.box2d.jni.function.CDrawBoundsFcn;
import org.box2d.jni.system.CallbackI;
import org.box2d.jni.system.VarType;

import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.Upcalls.*;

/**
 * Callback function: {@code void ( *DrawBoundsFcn )( b2AABB aabb, b2HexColor color, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@FunctionalInterface
public interface DrawBoundsFcnI extends CallbackI, CDrawBoundsFcn {

    /**
     * Native callback constructor.
     */
    Function<CallbackI, Long> CONSTRUCTOR = (instance) -> {
        LongBuffer targs = memCreateLongBuffer(3);
        targs.put(ffi_type_b2AABB)
             .put(ffi_type_sint32)
             .put(ffi_type_pointer);
        targs.flip();
        long rtype = ffi_type_void;

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
        invoke(
                isByValue()
                        ? memcpy(b2AABB.malloc(), () -> memGetAddress(args), b2AABB.SIZEOF)
                        : b2AABB.createSafe(() -> memGetAddress(args)),
                memGetInt(memGetAddress(args + VarType.Uintptrt.sizeof())),
                memGetAddress(memGetAddress(args + 2 * VarType.Uintptrt.sizeof()))
        );
    }
}
