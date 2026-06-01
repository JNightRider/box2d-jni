/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.draw;

import org.box2d.jni.b2Transform;
import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code void ( *DrawSolidCircleFcn )( b2Transform transform, float radius, b2HexColor color, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class DrawSolidCircleFcn extends Callback implements DrawSolidCircleFcnI {

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
    public DrawSolidCircleFcn(long address) {
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
     * Create a new empty object of type {@code DrawSolidCircleFcn}.
     *
     * @param delegate the dynamic function handler.
     * @return DrawSolidCircleFcn
     */
    public static DrawSolidCircleFcn create(DrawSolidCircleFcnI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof DrawSolidCircleFcn) {
            return (DrawSolidCircleFcn) delegate;
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
    private static final class Container extends DrawSolidCircleFcn {

        /**The dynamic or lambda function. */
        private final DrawSolidCircleFcnI delegate;

        /**
         * Create a new container to handle the <code>DrawSolidCircleFcn</code> function.
         *
         * @param address long
         * @param delegate DrawSolidCircleFcn|function
         */
        public Container(long address, DrawSolidCircleFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public void invoke(b2Transform transform, float radius, int color, long context) {
            delegate.invoke(transform, radius, color, context);
        }
    }
}
