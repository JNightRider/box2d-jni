/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code typedef void b2LogFcn( const char* message ); }
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class b2LogFcn extends Callback implements b2LogFcnI {

    /**
     * Create a callback instance using libffi.
     * 
     * @param address A virtual memory address
     */
    public b2LogFcn(long address) {
        super(address);
    }

    /**
     * Create a new empty object of type {@code b2LogFcn}.
     * 
     * @param delegate the dynamic function handler.
     * @return b2AllocFcn
     */
    public static b2LogFcn create(b2LogFcnI delegate) {
        if (delegate == null) {
            return null;
        }
        
        if (delegate instanceof b2LogFcn) {
            return (b2LogFcn) delegate;
        }
        
        long address = delegate.address();
        if (! Checks.isValidPointer(address)) {
            return null;
        }
        return new Container(address, delegate);
    }

    /**
     * Container that handles the dynamic function.
     */
    private static final class Container extends b2LogFcn {
        /**The dynamic or lambda function. */
        private final b2LogFcnI delegate;

        /**
         * Create a new container to handle the <code>b2LogFcn</code> function.
         * 
         * @param address long
         * @param delegate b2AssertFcn|function
         */
        public Container(long address, b2LogFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public void invoke(String message) {
            delegate.invoke(message);
        }
    }
}
