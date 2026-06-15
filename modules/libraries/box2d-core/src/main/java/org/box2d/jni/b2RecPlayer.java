/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2RecPlayer;

import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2RecPlayer b2RecPlayer;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2RecPlayer extends Struct<b2RecPlayer> implements ConstB2RecPlayer {
    
    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2RecPlayer(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2RecPlayer(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2RecPlayer(long address, boolean factor) {
        super(address, factor);
    }
    
    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2RecPlayer
     */
    public static b2RecPlayer createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2RecPlayer(ptr);
    }
    
    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr address
     * @return b2RecPlayer
     */
    public static b2RecPlayer create(long ptr) {
        return new b2RecPlayer(ptr);
    }
    
    /*(non-Javadoc)
     */
    @Override
    public int sizeof() {
        long __struct = address();
        if (__struct == NULL) {
            return 0;
        }
        return nsizeof(__struct);
    }

    /*(non-Javadoc)
     */
    @Override
    protected b2RecPlayer create(long address, Pointer ptr) {
        return ptr == null ? new b2RecPlayer(address) : new b2RecPlayer(ptr);
    }
}
