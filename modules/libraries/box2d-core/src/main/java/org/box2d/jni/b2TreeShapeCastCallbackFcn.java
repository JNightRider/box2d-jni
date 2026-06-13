/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.readonly.ConstB2ShapeCastInput;
import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code typedef float b2TreeShapeCastCallbackFcn( const b2ShapeCastInput* input, int proxyId, uint64_t userData, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class b2TreeShapeCastCallbackFcn extends Callback implements b2TreeShapeCastCallbackFcnI {

    /**
     * Create a callback instance using libffi.
     *
     * @param address A virtual memory address
     */
    public b2TreeShapeCastCallbackFcn(long address) {
        super(address);
    }

    /**
     * Create a new empty object of type {@code b2TreeShapeCastCallbackFcn}.
     *
     * @param delegate the dynamic function handler.
     * @return b2TreeShapeCastCallbackFcn
     */
    public static b2TreeShapeCastCallbackFcn create(b2TreeShapeCastCallbackFcnI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof b2TreeShapeCastCallbackFcn) {
            return (b2TreeShapeCastCallbackFcn) delegate;
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
    private static final class Container extends b2TreeShapeCastCallbackFcn {
        /**The dynamic or lambda function. */
        private final b2TreeShapeCastCallbackFcnI delegate;

        /**
         * Create a new container to handle the <code>b2TreeShapeCastCallbackFcn</code> function.
         * 
         * @param address long
         * @param delegate b2TreeShapeCastCallbackFcnI|function
         */
        public Container(long address, b2TreeShapeCastCallbackFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public float invoke(ConstB2ShapeCastInput input, int proxyId, long userData, long context) {
            return delegate.invoke(input, proxyId, userData, context);
        }         
    }
}
