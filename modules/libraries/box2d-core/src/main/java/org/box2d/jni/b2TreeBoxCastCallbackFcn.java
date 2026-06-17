/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.readonly.ConstB2BoxCastInput;
import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code typedef float b2TreeBoxCastCallbackFcn( const b2BoxCastInput* input, int proxyId, uint64_t userData, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.1
 */
public abstract class b2TreeBoxCastCallbackFcn extends Callback implements b2TreeBoxCastCallbackFcnI {

    /**
     * Create a callback instance using libffi.
     *
     * @param address A virtual memory address
     */
    public b2TreeBoxCastCallbackFcn(long address) {
        super(address);
    }

    /**
     * Create a new empty object of type {@code b2TreeBoxCastCallbackFcn}.
     *
     * @param delegate the dynamic function handler.
     * @return b2TreeBoxCastCallbackFcn
     */
    public static b2TreeBoxCastCallbackFcn create(b2TreeBoxCastCallbackFcnI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof b2TreeBoxCastCallbackFcn) {
            return (b2TreeBoxCastCallbackFcn) delegate;
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
    private static final class Container extends b2TreeBoxCastCallbackFcn {
        /**The dynamic or lambda function. */
        private final b2TreeBoxCastCallbackFcnI delegate;

        /**
         * Create a new container to handle the <code>b2TreeBoxCastCallbackFcn</code> function.
         * 
         * @param address long
         * @param delegate b2TreeBoxCastCallbackFcnI|function
         */
        public Container(long address, b2TreeBoxCastCallbackFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public float invoke(ConstB2BoxCastInput input, int proxyId, long userData, long context) {
            return delegate.invoke(input, proxyId, userData, context);
        }         
    }
}
