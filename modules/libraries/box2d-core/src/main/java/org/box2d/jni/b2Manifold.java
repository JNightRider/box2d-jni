/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 *
 * @author wil
 */
public class b2Manifold extends Struct<b2Manifold> {
    
    /** The struct size in bytes. */
    public static final int SIZEOF = 4;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF = 4;

    public b2Manifold(Pointer ptr) {
        super(ptr);
    }

    public b2Manifold(long address) {
        super(address);
    }

    public b2Manifold(long address, boolean factor) {
        super(address, factor);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2BodyMoveEvent
     */
    public static b2Manifold createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Manifold(ptr);
    }
    
    @Override
    public int sizeof() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected b2Manifold create(long address, Pointer ptr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
