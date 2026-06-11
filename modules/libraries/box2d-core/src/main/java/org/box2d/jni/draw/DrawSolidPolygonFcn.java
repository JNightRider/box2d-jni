/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.draw;

import org.box2d.jni.b2Transform;
import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code void ( *DrawSolidPolygonFcn )( b2Transform transform, const b2Vec2* vertices, int vertexCount, float radius, b2HexColor color,
								void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class DrawSolidPolygonFcn extends Callback implements DrawSolidPolygonFcnI {
    
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
    public DrawSolidPolygonFcn(long address) {
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
     * Create a new empty object of type {@code DrawSolidPolygonFcn}.
     *
     * @param delegate the dynamic function handler.
     * @return DrawSolidPolygonFcn
     */
    public static DrawSolidPolygonFcn create(DrawSolidPolygonFcnI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof DrawSolidPolygonFcn) {
            return (DrawSolidPolygonFcn) delegate;
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
    private static final class Container extends DrawSolidPolygonFcn {
        /**The dynamic or lambda function. */
        private final DrawSolidPolygonFcnI delegate;

        /**
         * Create a new container to handle the <code>DrawSolidPolygonFcn</code> function.
         * 
         * @param address long
         * @param delegate DrawSolidPolygonFcn|function
         */
        public Container(long address, DrawSolidPolygonFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public void invoke(b2Transform transform, long vertices, int vertexCount, float radius, int color, long context) {
            delegate.invoke(transform, vertices, vertexCount, radius, color, context);
        }
    }
}
