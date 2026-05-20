/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import org.box2d.jni.readonly.ConstB2Vec2;
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
public class b2Vec2 extends Struct<b2Vec2> implements ConstB2Vec2 {

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

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Vec2(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Vec2(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     *
     * @see Struct#Struct(long, boolean)
     */
    protected b2Vec2(long address, boolean factor) {
        super(address, factor);
    }

    /**
     * Initializes this struct with the specified values.
     *
     * @param x the valur {@code x}
     * @param y the valur {@code y}
     *
     * @return b2Vec2
     */
    public b2Vec2 set(
        float x,
        float y
    ) {
        x(x);
        y(y);
        return this;
    }

    /** @return Returns the property {@code x} */
    @Override
    public float x() { return nx(address()); }
    /** @return Returns the property {@code y} */
    @Override
    public float y() { return ny(address()); }
    
    /**
     * Set the value of property {@code x}
     *
     * @param value The value
     * @return b2Vec2
     */
    public b2Vec2 x(float value) { nx(address(), value); return this; }
    /**
     * Set the value of property {@code y}
     *
     * @param value The value
     * @return b2Vec2
     */
    public b2Vec2 y(float value) { ny(address(), value); return this; }
    
    /*(non-Javadoc)
     */
    @Override
    public int sizeof() { return SIZEOF; }
 
    /*(non-Javadoc)
     */
    @Override
    protected b2Vec2 create(long address, Pointer ptr) {
        return ptr == null ? new b2Vec2(address) : new b2Vec2(ptr);
    }
    
    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2Vec2
     */
    private static b2Vec2 factory() {
        return new b2Vec2(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Vec2
     */
    public static b2Vec2 createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Vec2(ptr);
    }
    
    /**
     * Reserve memory for the new object {@code b2Vec2}.
     *
     * @param alloc Custom memory manager
     * @return b2Vec2
     */
    public static b2Vec2 alloc(AllocFunc alloc) {
        return new b2Vec2(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2Vec2}.
     *
     * @return b2Vec2
     */
    public static b2Vec2 malloc() {
        return new b2Vec2(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Vec2}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Vec2}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }
    
    // -----------------------------------

    public static float nx(long address) { return memGetFloat(address + X); }
    public static float ny(long address) { return memGetFloat(address + Y); }

    public static void nx(long address, float value) { memPutFloat(address + X, value); }
    public static void ny(long address, float value) { memPutFloat(address + Y, value); }

    // -----------------------------------
    
    /** An array of {@code b2Vec2} structs. */
    public static class Buffer extends StructBuffer<b2Vec2, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2Vec2 ELEMENT_FACTORY = b2Vec2.factory();

        /**
         * Create a new buffer.
         *
         * @param address long
         * @param remaining int
         */
        public Buffer(long address, int remaining) {
            super(address, remaining);
        }

        /**
         * Create a new buffer.
         *
         * @param address long
         * @param mark int
         * @param position int
         * @param limit int
         * @param capacity int
         */
        public Buffer(long address, int mark, int position, int limit, int capacity) {
            super(address, mark, position, limit, capacity);
        }

        /*(non-Jabadoc)
         */
        @Override
        protected b2Vec2 getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /*(non-Jabadoc)
         */
        @Override
        protected Buffer self() {
            return this;
        }

        /*(non-Jabadoc)
         */
        @Override
        protected Buffer create(long address, int mark, int position, int limit, int capacity) {
            return new Buffer(address, mark, position, limit, capacity);
        }        
    }
}
