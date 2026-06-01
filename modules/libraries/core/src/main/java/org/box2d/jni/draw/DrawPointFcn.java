/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.draw;

import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code void ( *DrawPointFcn )( b2Vec2 p, float size, b2HexColor color, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class DrawPointFcn extends Callback implements DrawPointFcnI {

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
    public DrawPointFcn(long address) {
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
     * Create a new empty object of type {@code DrawPointFcn}.
     *
     * @param delegate the dynamic function handler.
     * @return DrawPointFcn
     */
    public static DrawPointFcn create(DrawPointFcnI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof DrawPointFcn) {
            return (DrawPointFcn) delegate;
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
    private static final class Container extends DrawPointFcn {

        /**The dynamic or lambda function. */
        private final DrawPointFcnI delegate;

        /**
         * Create a new container to handle the <code>DrawPointFcn</code> function.
         *
         * @param address long
         * @param delegate DrawPointFcn|function
         */
        public Container(long address, DrawPointFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public void invoke(b2Vec2 p, float size, int color, long context) {
            delegate.invoke(p, size, color, context);
        }
    }
}
