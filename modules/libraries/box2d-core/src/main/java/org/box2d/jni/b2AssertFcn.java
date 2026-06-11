/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code typedef int b2AssertFcn( const char* condition, const char* fileName, int lineNumber ); }
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class b2AssertFcn extends Callback implements b2AssertFcnI {

     /**
     * Create a callback instance using libffi.
     * 
     * @param address A virtual memory address
     */
    public b2AssertFcn(long address) {
        super(address);
    }

    /**
     * Create a new empty object of type {@code b2AssertFcn}.
     * 
     * @param delegate the dynamic function handler.
     * @return b2AllocFcn
     */
    public static b2AssertFcn create(b2AssertFcnI delegate) {
        if (delegate == null) {
            return null;
        }
        
        if (delegate instanceof b2AssertFcn) {
            return (b2AssertFcn) delegate;
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
    private static final class Container extends b2AssertFcn {
        /**The dynamic or lambda function. */
        private final b2AssertFcnI delegate;

        /**
         * Create a new container to handle the <code>b2AssertFcn</code> function.
         * 
         * @param address long
         * @param delegate b2AssertFcn|function
         */
        public Container(long address, b2AssertFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public int invoke(String condition, String fileName, int lineNumber) {
            return delegate.invoke(condition, fileName, lineNumber);
        }
    }
}
