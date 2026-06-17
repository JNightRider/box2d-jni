/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code typedef bool b2PreSolveFcn( b2ShapeId shapeIdA, b2ShapeId shapeIdB, b2Pos point, b2Vec2 normal, void* context );}
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class b2PreSolveFcn extends Callback implements b2PreSolveFcnI {
    
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
    public b2PreSolveFcn(long address) {
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
     * Create a new empty object of type {@code b2PreSolveFcn}.
     *
     * @param delegate the dynamic function handler.
     * @return b2PreSolveFcn
     */
    public static b2PreSolveFcn create(b2PreSolveFcnI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof b2PreSolveFcn) {
            return (b2PreSolveFcn) delegate;
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
    private static final class Container extends b2PreSolveFcn {
        /**The dynamic or lambda function. */
        private final b2PreSolveFcnI delegate;

        /**
         * Create a new container to handle the <code>b2PreSolveFcn</code> function.
         * 
         * @param address long
         * @param delegate b2PreSolveFcnI|function
         */
        public Container(long address, b2PreSolveFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public boolean invoke(b2ShapeId shapeIdA, b2ShapeId shapeIdB, b2Pos point, b2Vec2 normal, long context) {
            return delegate.invoke(shapeIdA, shapeIdB, point, normal, context);
        }
    }
}
