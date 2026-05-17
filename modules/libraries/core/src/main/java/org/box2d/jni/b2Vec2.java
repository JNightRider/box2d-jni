/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.VarType.*;

/**
 * <pre><code>
 * typedef struct b2Vec2
 * {
 *	/// coordinates
 *	float x, y;
 * } b2Vec2;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Vec2 extends Struct<b2Vec2> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            X,
            Y;
    
    static {
        Layout layout = __struct(
                __member(Float.sizeof()),
                __member(Float.sizeof())
        );
        
        X = layout.offsetof(0);
        Y = layout.offsetof(1);
        
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }
    
    public b2Vec2(Pointer ptr) {
        super(ptr);
    }

    public b2Vec2(long address) {
        super(address);
    }

    public b2Vec2(long address, boolean factor) {
        super(address, factor);
    }

    public float x() { return nx(address()); }
    public float y() { return ny(address()); }
    
    public b2Vec2 x(float value) { nx(address(), value); return this; }
    public b2Vec2 y(float value) { ny(address(), value); return this; }
    
    @Override
    public int sizeof() { return SIZEOF; }
    
    // -----------------------------------

    @Override
    protected b2Vec2 create(long address, Pointer ptr) {
        return ptr == null ? new b2Vec2(address) : new b2Vec2(ptr);
    }
    
    private static b2Vec2 factory() {
        return new b2Vec2(-1L, true);
    }
    
    public static b2Vec2 alloc(AllocFunc alloc) {
        return new b2Vec2(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }
    
    public static b2Vec2 malloc() {
        return new b2Vec2(nmalloc(SIZEOF));
    }

    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }
    
    
    // -----------------------------------
    
    public static float nx(long address) { return memGetFloat(address + X); }
    public static float ny(long address) { return memGetFloat(address + Y); }
    
    public static void nx(long address, float value) { memPutFloat(address + X, value); }
    public static void ny(long address, float value) { memPutFloat(address + Y, value); }
    
    // -----------------------------------
    
    public static class Buffer extends StructBuffer<b2Vec2, Buffer> implements JNINative {
        
         private static final b2Vec2 ELEMENT_FACTORY = b2Vec2.factory();

        public Buffer(long address, int remaining) {
            super(address, remaining);
        }

        public Buffer(long address, int mark, int position, int limit, int capacity) {
            super(address, mark, position, limit, capacity);
        }
        
        @Override
        protected b2Vec2 getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected Buffer create(long address, int mark, int position, int limit, int capacity) {
            return new Buffer(address, mark, position, limit, capacity);
        }        
    }
}
