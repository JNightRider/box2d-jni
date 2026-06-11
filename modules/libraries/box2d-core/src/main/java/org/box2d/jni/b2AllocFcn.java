/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code typedef void* b2AllocFcn( unsigned int size, int alignment );}
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class b2AllocFcn extends Callback implements b2AllocFcnI {

    /**
     * Create a callback instance using libffi.
     *
     * @param address A virtual memory address
     */
    public b2AllocFcn(long address) {
        super(address);
    }

    /**
     * Create a new empty object of type {@code b2AllocFcn}.
     *
     * @param delegate the dynamic function handler.
     * @return b2AllocFcn
     */
    public static b2AllocFcn create(b2AllocFcnI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof b2AllocFcn) {
            return (b2AllocFcn) delegate;
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
    private static final class Container extends b2AllocFcn {
        /**The dynamic or lambda function. */
        private final b2AllocFcnI delegate;

        /**
         * Create a new container to handle the <code>b2AllocFcn</code> function.
         * 
         * @param address long
         * @param delegate b2AllocFcnI|function
         */
        public Container(long address, b2AllocFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public long invoke(long size, int alignment) {
            return delegate.invoke(size, alignment);
        }    
    }
}
