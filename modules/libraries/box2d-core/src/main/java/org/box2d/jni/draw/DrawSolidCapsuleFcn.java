/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.draw;

import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code void ( *DrawSolidCapsuleFcn )( b2Vec2 p1, b2Vec2 p2, float radius, b2HexColor color, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class DrawSolidCapsuleFcn extends Callback implements DrawSolidCapsuleFcnI {

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
    public DrawSolidCapsuleFcn(long address) {
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
     * Create a new empty object of type {@code DrawSolidCapsuleFcn}.
     *
     * @param delegate the dynamic function handler.
     * @return DrawSolidCapsuleFcn
     */
    public static DrawSolidCapsuleFcn create(DrawSolidCapsuleFcnI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof DrawSolidCapsuleFcn) {
            return (DrawSolidCapsuleFcn) delegate;
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
    private static final class Container extends DrawSolidCapsuleFcn {

        /**The dynamic or lambda function. */
        private final DrawSolidCapsuleFcnI delegate;

        /**
         * Create a new container to handle the <code>DrawSolidCapsuleFcn</code> function.
         *
         * @param address long
         * @param delegate DrawSolidCapsuleFcn|function
         */
        public Container(long address, DrawSolidCapsuleFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public void invoke(b2Vec2 p1, b2Vec2 p2, float radius, int color, long context) {
            delegate.invoke(p1, p2, radius, color, context);
        }
    }
}
