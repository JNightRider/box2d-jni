/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.draw;

import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;


/**
 * Callback function: {@code void ( *DrawCircleFcn )( b2Vec2 center, float radius, b2HexColor color, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class DrawCircleFcn extends Callback implements DrawCircleFcnI {

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
    public DrawCircleFcn(long address) {
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
     * Create a new empty object of type {@code DrawCircleFcn}.
     *
     * @param delegate the dynamic function handler.
     * @return DrawCircleFcn
     */
    public static DrawCircleFcn create(DrawCircleFcnI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof DrawCircleFcn) {
            return (DrawCircleFcn) delegate;
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
    private static final class Container extends DrawCircleFcn {
        /**The dynamic or lambda function. */
        private final DrawCircleFcnI delegate;

        /**
         * Create a new container to handle the <code>DrawCircleFcn</code> function.
         *
         * @param address long
         * @param delegate DrawCircleFcn|function
         */
        public Container(long address, DrawCircleFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public void invoke(b2Vec2 center, float radius, int color, long context) {
            delegate.invoke(center, radius, color, context);
        }
    }
}