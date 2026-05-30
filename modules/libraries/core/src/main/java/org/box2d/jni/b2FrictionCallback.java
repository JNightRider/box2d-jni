/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code typedef float b2FrictionCallback( float frictionA, uint64_t userMaterialIdA, float frictionB, uint64_t userMaterialIdB );
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class b2FrictionCallback extends Callback implements b2FrictionCallbackI {

    /**
     * Create a callback instance using libffi.
     *
     * @param address A virtual memory address
     */
    public b2FrictionCallback(long address) {
        super(address);
    }

    /**
     * Create a new empty object of type {@code b2FrictionCallback}.
     *
     * @param delegate the dynamic function handler.
     * @return b2FrictionCallback
     */
    public static b2FrictionCallback create(b2FrictionCallbackI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof b2FrictionCallback) {
            return (b2FrictionCallback) delegate;
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
    private static final class Container extends b2FrictionCallback {
        /**The dynamic or lambda function. */
        private final b2FrictionCallbackI delegate;

        /**
         * Create a new container to handle the <code>b2FrictionCallback</code> function.
         * 
         * @param address long
         * @param delegate b2FrictionCallbackI|function
         */
        public Container(long address, b2FrictionCallbackI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public float invoke(float frictionA, long userMaterialIdA, float frictionB, long userMaterialIdB) {
            return delegate.invoke(frictionA, userMaterialIdA, frictionB, userMaterialIdB);
        }
    }
}
