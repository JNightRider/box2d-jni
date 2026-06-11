/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.Callback;

import org.box2d.jni.system.*;

/**
 * Callback function: {@code typedef void b2FreeFcn( void* mem, unsigned int size ); }
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class b2FreeFcn extends Callback implements b2FreeFcnI {

    /**
     * Create a callback instance using libffi.
     * 
     * @param address A virtual memory address
     */
    public b2FreeFcn(long address) {
        super(address);
    }

    /**
     * Create a new empty object of type {@code b2FreeFcn}.
     * 
     * @param delegate the dynamic function handler.
     * @return b2AllocFcn
     */
    public static b2FreeFcn create(b2FreeFcnI delegate) {
        if (delegate == null) {
            return null;
        }
        
        if (delegate instanceof b2FreeFcn) {
            return (b2FreeFcn) delegate;
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
    private static final class Container extends b2FreeFcn {
        /**The dynamic or lambda function. */
        private final b2FreeFcnI delegate;
        
        /**
         * Create a new container to handle the <code>b2FreeFcn</code> function.
         * 
         * @param address long
         * @param delegate b2AllocFcnI|function
         */
        public Container(long address, b2FreeFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public void invoke(long mem, long size) {
            delegate.invoke(mem, size);
        }
    }
}
