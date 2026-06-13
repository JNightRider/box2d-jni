/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code typedef bool b2TreeQueryCallbackFcn( int proxyId, uint64_t userData, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class b2TreeQueryCallbackFcn extends Callback implements b2TreeQueryCallbackFcnI {

    /**
     * Create a callback instance using libffi.
     *
     * @param address A virtual memory address
     */
    public b2TreeQueryCallbackFcn(long address) {
        super(address);
    }

    /**
     * Create a new empty object of type {@code b2TreeQueryCallbackFcn}.
     *
     * @param delegate the dynamic function handler.
     * @return b2TreeQueryCallbackFcn
     */
    public static b2TreeQueryCallbackFcn create(b2TreeQueryCallbackFcnI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof b2TreeQueryCallbackFcn) {
            return (b2TreeQueryCallbackFcn) delegate;
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
    private static final class Container extends b2TreeQueryCallbackFcn {
        /**The dynamic or lambda function. */
        private final b2TreeQueryCallbackFcnI delegate;

        /**
         * Create a new container to handle the <code>b2TreeQueryCallbackFcn</code> function.
         * 
         * @param address long
         * @param delegate b2TreeQueryCallbackFcnI|function
         */
        public Container(long address, b2TreeQueryCallbackFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public boolean invoke(int proxyId, long userData, long context) {
            return delegate.invoke(proxyId, userData, context);
        }
    }
}
