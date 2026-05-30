/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code typedef void b2TaskCallback( void* taskContext ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class b2TaskCallback extends Callback implements b2TaskCallbackI {

    /**
     * Create a callback instance using libffi.
     *
     * @param address A virtual memory address
     */
    public b2TaskCallback(long address) {
        super(address);
    }

    /**
     * Create a new empty object of type {@code b2TaskCallback}.
     *
     * @param delegate the dynamic function handler.
     * @return b2TaskCallback
     */
    public static b2TaskCallback create(b2TaskCallbackI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof b2TaskCallback) {
            return (b2TaskCallback) delegate;
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
    private static final class Container extends b2TaskCallback {
        /**The dynamic or lambda function. */
        private final b2TaskCallbackI delegate;

        /**
         * Create a new container to handle the <code>b2TaskCallback</code> function.
         * 
         * @param address long
         * @param delegate b2TaskCallbackI|function
         */
        public Container(long address, b2TaskCallbackI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public void invoke(long taskContext) {
            delegate.invoke(taskContext);
        }    
    }
}

