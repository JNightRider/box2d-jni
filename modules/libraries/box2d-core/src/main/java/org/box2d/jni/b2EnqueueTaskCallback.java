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

import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;
import org.box2d.jni.function.CTaskCallback;

/**
 * Callback function: {@code typedef void* b2EnqueueTaskCallback( b2TaskCallback* task, void* taskContext, void* userContext );}
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class b2EnqueueTaskCallback extends Callback implements b2EnqueueTaskCallbackI {

    /**
     * Create a callback instance using libffi.
     *
     * @param address A virtual memory address
     */
    public b2EnqueueTaskCallback(long address) {
        super(address);
    }

    /**
     * Create a new empty object of type {@code b2EnqueueTaskCallback}.
     *
     * @param delegate the dynamic function handler.
     * @return b2EnqueueTaskCallback
     */
    public static b2EnqueueTaskCallback create(b2EnqueueTaskCallbackI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof b2EnqueueTaskCallback) {
            return (b2EnqueueTaskCallback) delegate;
        }

        long address = delegate.address();
        if (!Checks.isValidPointer(address)) {
            return null;
        }
        return new Container(address, delegate);
    }

    /**
     * Container that handles the dynamic function.
     */
    private static final class Container extends b2EnqueueTaskCallback {
        /**The dynamic or lambda function. */
        private final b2EnqueueTaskCallbackI delegate;

        /**
         * Create a new container to handle the <code>b2EnqueueTaskCallback</code> function.
         * 
         * @param address long
         * @param delegate b2EnqueueTaskCallbackI|function
         */
        public Container(long address, b2EnqueueTaskCallbackI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */

        @Override
        public long invoke(CTaskCallback task, long taskContext, long userContext) {
            return delegate.invoke(task, taskContext, userContext);
        }
    }
}

