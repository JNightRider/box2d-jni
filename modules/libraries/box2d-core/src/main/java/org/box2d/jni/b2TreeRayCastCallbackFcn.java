/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.readonly.ConstB2RayCastInput;
import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code typedef float b2TreeRayCastCallbackFcn( const b2RayCastInput* input, int proxyId, uint64_t userData, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class b2TreeRayCastCallbackFcn extends Callback implements b2TreeRayCastCallbackFcnI {

    /**
     * Create a callback instance using libffi.
     *
     * @param address A virtual memory address
     */
    public b2TreeRayCastCallbackFcn(long address) {
        super(address);
    }

    /**
     * Create a new empty object of type {@code b2TreeRayCastCallbackFcn}.
     *
     * @param delegate the dynamic function handler.
     * @return b2TreeRayCastCallbackFcn
     */
    public static b2TreeRayCastCallbackFcn create(b2TreeRayCastCallbackFcnI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof b2TreeRayCastCallbackFcn) {
            return (b2TreeRayCastCallbackFcn) delegate;
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
    private static final class Container extends b2TreeRayCastCallbackFcn {
        /**The dynamic or lambda function. */
        private final b2TreeRayCastCallbackFcnI delegate;

        /**
         * Create a new container to handle the <code>b2TreeRayCastCallbackFcn</code> function.
         * 
         * @param address long
         * @param delegate b2TreeRayCastCallbackFcnI|function
         */
        public Container(long address, b2TreeRayCastCallbackFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public float invoke(ConstB2RayCastInput input, int proxyId, long userData, long context) {
            return delegate.invoke(input, proxyId, userData, context);
        }
    }
}
