/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2Recording;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 *
 * @author wil
 */
public class b2Recording extends Struct<b2Recording> implements ConstB2Recording{

    public b2Recording(Pointer ptr) {
        super(ptr);
    }

    public b2Recording(long address) {
        super(address);
    }

    public b2Recording(long address, boolean factor) {
        super(address, factor);
    }

    
    @Override
    public int sizeof() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected b2Recording create(long address, Pointer ptr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
