/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code typedef float b2CastResultFcn( b2ShapeId shapeId, b2Vec2 point, b2Vec2 normal, float fraction, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class b2CastResultFcn extends Callback implements b2CastResultFcnI {
    
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
    public b2CastResultFcn(long address) {
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
     * Create a new empty object of type {@code b2CastResultFcn}.
     *
     * @param delegate the dynamic function handler.
     * @return b2CastResultFcn
     */
    public static b2CastResultFcn create(b2CastResultFcnI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof b2CastResultFcn) {
            return (b2CastResultFcn) delegate;
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
    private static final class Container extends b2CastResultFcn {
        /**The dynamic or lambda function. */
        private final b2CastResultFcnI delegate;

        /**
         * Create a new container to handle the <code>b2CastResultFcn</code> function.
         * 
         * @param address long
         * @param delegate b2CastResultFcnI|function
         */
        public Container(long address, b2CastResultFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public float invoke(b2ShapeId shapeId, b2Vec2 point, b2Vec2 normal, float fraction, long context) {
            return delegate.invoke(shapeId, point, normal, fraction, context);
        }
    }
}
