/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.readonly.ConstB2PlaneResult;
import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code typedef bool b2PlaneResultFcn( b2ShapeId shapeId, const b2PlaneResult* plane, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class b2PlaneResultFcn extends Callback implements b2PlaneResultFcnI {
    
    /**
     * Callback flag
     * @see b2CustomFilterFcnI#isByValue() 
     */
    protected boolean byValue;

    /**
     * Create a callback instance using libffi.
     *
     * @param address A virtual memory address
     */
    public b2PlaneResultFcn(long address) {
        super(address);
    }

    /**
     * Modify the way arguments are provided for the invoked function.
     * 
     * @see b2CustomFilterFcnI#isByValue() 
     * 
     * @param byValue boolean
     */
    public void byValue(boolean byValue) {
        this.byValue = byValue;
    }

    /* (non-Javadoc)
     */
    @Override
    public boolean isByValue() {
        return this.byValue;
    }

    /**
     * Create a new empty object of type {@code b2PlaneResultFcn}.
     *
     * @param delegate the dynamic function handler.
     * @return b2PlaneResultFcn
     */
    public static b2PlaneResultFcn create(b2PlaneResultFcnI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof b2PlaneResultFcn) {
            return (b2PlaneResultFcn) delegate;
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
    private static final class Container extends b2PlaneResultFcn {
        /**The dynamic or lambda function. */
        private final b2PlaneResultFcnI delegate;

        /**
         * Create a new container to handle the <code>b2PlaneResultFcn</code> function.
         * 
         * @param address long
         * @param delegate b2PlaneResultFcnI|function
         */
        public Container(long address, b2PlaneResultFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public boolean invoke(b2ShapeId shapeId, ConstB2PlaneResult plane, long context) {
            return delegate.invoke(shapeId, plane, context);
        }
    }
}