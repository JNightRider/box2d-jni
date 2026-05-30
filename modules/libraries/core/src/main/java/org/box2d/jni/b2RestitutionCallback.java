/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code typedef float b2RestitutionCallback( float restitutionA, uint64_t userMaterialIdA, float restitutionB, uint64_t userMaterialIdB );}
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class b2RestitutionCallback extends Callback implements b2RestitutionCallbackI {

    /**
     * Create a callback instance using libffi.
     *
     * @param address A virtual memory address
     */
    public b2RestitutionCallback(long address) {
        super(address);
    }

    /**
     * Create a new empty object of type {@code b2RestitutionCallback}.
     *
     * @param delegate the dynamic function handler.
     * @return b2RestitutionCallback
     */
    public static b2RestitutionCallback create(b2RestitutionCallbackI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof b2RestitutionCallback) {
            return (b2RestitutionCallback) delegate;
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
    private static final class Container extends b2RestitutionCallback {
        /**The dynamic or lambda function. */
        private final b2RestitutionCallbackI delegate;

        /**
         * Create a new container to handle the <code>b2RestitutionCallback</code> function.
         * 
         * @param address long
         * @param delegate b2RestitutionCallbackI|function
         */
        public Container(long address, b2RestitutionCallbackI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public float invoke(float restitutionA, long userMaterialIdA, float restitutionB, long userMaterialIdB) {
            return delegate.invoke(restitutionA, userMaterialIdA, restitutionB, userMaterialIdB);
        }
    }
}
