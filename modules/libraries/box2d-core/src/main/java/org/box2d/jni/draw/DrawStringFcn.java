/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.draw;

import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code void ( *DrawStringFcn )( b2Vec2 p, const char* s, b2HexColor color, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class DrawStringFcn extends Callback implements DrawStringFcnI {

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
    public DrawStringFcn(long address) {
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
     * Create a new empty object of type {@code DrawStringFcn}.
     *
     * @param delegate the dynamic function handler.
     * @return DrawStringFcn
     */
    public static DrawStringFcn create(DrawStringFcnI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof DrawStringFcn) {
            return (DrawStringFcn) delegate;
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
    private static final class Container extends DrawStringFcn {

        /**The dynamic or lambda function. */
        private final DrawStringFcnI delegate;

        /**
         * Create a new container to handle the <code>DrawStringFcn</code> function.
         *
         * @param address long
         * @param delegate DrawStringFcn|function
         */
        public Container(long address, DrawStringFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public void invoke(b2Vec2 p, long s, int color, long context) {
            delegate.invoke(p, s, color, context);
        }
    }
}
