/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code typedef bool b2CustomFilterFcn( b2ShapeId shapeIdA, b2ShapeId shapeIdB, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class b2CustomFilterFcn extends Callback implements b2CustomFilterFcnI {
    
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
    public b2CustomFilterFcn(long address) {
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
     * Create a new empty object of type {@code b2CustomFilterFcn}.
     *
     * @param delegate the dynamic function handler.
     * @return b2CustomFilterFcn
     */
    public static b2CustomFilterFcn create(b2CustomFilterFcnI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof b2CustomFilterFcn) {
            return (b2CustomFilterFcn) delegate;
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
    private static final class Container extends b2CustomFilterFcn {
        /**The dynamic or lambda function. */
        private final b2CustomFilterFcnI delegate;

        /**
         * Create a new container to handle the <code>b2CustomFilterFcn</code> function.
         * 
         * @param address long
         * @param delegate b2CustomFilterFcnI|function
         */
        public Container(long address, b2CustomFilterFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public boolean invoke(b2ShapeId shapeIdA, b2ShapeId shapeIdB, long context) {
            return delegate.invoke(shapeIdA, shapeIdB, context);
        }
    }
}
