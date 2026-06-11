/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
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

