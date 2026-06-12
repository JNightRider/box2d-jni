/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.Pointer;
import org.box2d.jni.system.Struct;

/**
 *
 * @author wil
 */
public class b2SimplexCache extends Struct<b2SimplexCache> {

    public b2SimplexCache(Pointer ptr) {
        super(ptr);
    }

    public b2SimplexCache(long address) {
        super(address);
    }

    public b2SimplexCache(long address, boolean factor) {
        super(address, factor);
    }

    @Override
    public int sizeof() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected b2SimplexCache create(long address, Pointer ptr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
