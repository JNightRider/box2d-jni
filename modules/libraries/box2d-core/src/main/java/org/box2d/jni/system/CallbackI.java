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
package org.box2d.jni.system;

import java.util.function.Function;

import static org.box2d.jni.system.Upcalls.*;

/**
 * Interface for dynamically created native functions that call into Java code
 * (callbacks).
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CallbackI extends Pointer {

    /**
     * Native callback destroyer
     */
    Function<Long, Void> DESCTRUCTOR = (t) -> {
        if (t != null && t != NULL) {
            njniCallbackFree(t);
        }
        return null;
    };

    /**
     * A handler for the native class constructor.
     *
     * @return Function|new
     */
    Function<CallbackI, Long> __constructor();

    /**
     * A handler for the native class destructor.
     *
     * @return Function|free()
     */
    default Function<Long, Void> __destructor() {
        return DESCTRUCTOR;
    }

    /**
     * Returns the raw pointer address as a {@code long} value.
     *
     * @return the pointer address
     */
    @Override
    default long address() {
        long address = upcallGet(this);
        if (address != NULL) {
            return napiClosureFunction(address);
        }
        return NULL;
    }

    /**
     * The Java method that will be called from native code when the native
     * callback function is invoked.
     *
     * @param resp A pointer where the return value of the called function is
     *             stored
     * @param args A pointer that contains all the arguments of the function
     *             called
     */
    void callback(long resp, long args);
}
