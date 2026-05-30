/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code typedef void b2FinishTaskCallback( void* userTask, void* userContext );}
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class b2FinishTaskCallback extends Callback implements b2FinishTaskCallbackI {

    /**
     * Create a callback instance using libffi.
     *
     * @param address A virtual memory address
     */
    public b2FinishTaskCallback(long address) {
        super(address);
    }

    /**
     * Create a new empty object of type {@code b2FinishTaskCallback}.
     *
     * @param delegate the dynamic function handler.
     * @return b2FinishTaskCallback
     */
    public static b2FinishTaskCallback create(b2FinishTaskCallbackI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof b2FinishTaskCallback) {
            return (b2FinishTaskCallback) delegate;
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
    private static final class Container extends b2FinishTaskCallback {
        /**The dynamic or lambda function. */
        private final b2FinishTaskCallbackI delegate;

        /**
         * Create a new container to handle the <code>b2FinishTaskCallback</code> function.
         * 
         * @param address long
         * @param delegate b2FinishTaskCallbackI|function
         */
        public Container(long address, b2FinishTaskCallbackI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */

        @Override
        public void invoke(long userTask, long userContext) {
            delegate.invoke(userTask, userContext);
        }
    }
}

