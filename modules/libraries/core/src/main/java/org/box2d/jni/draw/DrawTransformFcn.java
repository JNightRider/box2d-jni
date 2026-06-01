/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.draw;

import org.box2d.jni.b2Transform;
import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code void ( *DrawTransformFcn )( b2Transform transform, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class DrawTransformFcn extends Callback implements DrawTransformFcnI {

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
    public DrawTransformFcn(long address) {
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
     * Create a new empty object of type {@code DrawTransformFcn}.
     *
     * @param delegate the dynamic function handler.
     * @return DrawTransformFcn
     */
    public static DrawTransformFcn create(DrawTransformFcnI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof DrawTransformFcn) {
            return (DrawTransformFcn) delegate;
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
    private static final class Container extends DrawTransformFcn {

        /**The dynamic or lambda function. */
        private final DrawTransformFcnI delegate;

        /**
         * Create a new container to handle the <code>DrawTransformFcn</code> function.
         *
         * @param address long
         * @param delegate DrawTransformFcn|function
         */
        public Container(long address, DrawTransformFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public void invoke(b2Transform transform, long context) {
            delegate.invoke(transform, context);
        }
    }
}
