/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.draw;

import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code void ( *DrawPolygonFcn )( const b2Vec2* vertices, int vertexCount, b2HexColor color, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class DrawPolygonFcn extends Callback implements DrawPolygonFcnI {
    
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
    public DrawPolygonFcn(long address) {
        super(address);
    }

    /**
     * Create a new empty object of type {@code DrawPolygonFcn}.
     *
     * @param delegate the dynamic function handler.
     * @return DrawPolygonFcn
     */
    public static DrawPolygonFcn create(DrawPolygonFcnI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof DrawPolygonFcn) {
            return (DrawPolygonFcn) delegate;
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
    private static final class Container extends DrawPolygonFcn {
        /**The dynamic or lambda function. */
        private final DrawPolygonFcnI delegate;

        /**
         * Create a new container to handle the <code>DrawPolygonFcn</code> function.
         * 
         * @param address long
         * @param delegate DrawPolygonFcnI|function
         */
        public Container(long address, DrawPolygonFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public void invoke(long vertices, int vertexCount, int color, long context) {
            delegate.invoke(vertices, vertexCount, color, context);
        }
    }
}
