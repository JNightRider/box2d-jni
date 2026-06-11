/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.system;

import static org.box2d.jni.system.Debug.*;

/**
 * Base class for dynamically created native functions that call into Java code.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class Callback implements Pointer, CallbackI, AutoCloseable {
    static {
        Library.initialize();
    }

    /**
     * A virtual memory address that manages a native object through a pointer,
     * whose address can be used to manipulate that native object.
     */
    private long address;

    /**
     * Create a callback instance using libffi.
     *
     * @param address A virtual memory address
     */
    protected Callback(long address) {
        this.address = address;
    }

    /*(non-Javaodc)
     * @see AutoCloseable#close() 
     */
    @Override
    public void close() {
        if (address == NULL) {
            apiLog("The callback pointer is invalid");
            apiLogMore("Address: " + address + ", class: " + getClass());
            return;
        }
        address = NULL;
    }

    /* (non-Javadoc) @see org.cube.system.Pointer#address() */
    @Override
    public long address() { return address; }
    /* (non-Javadoc) @see java.lang.Object#equals(java.lang.Object) */
    @Override
    public int hashCode() { return (int)(address ^ (address >>> 32)); }
    /* (non-Javadoc) @see java.lang.Object#toString() */
    @Override
    public String toString() { return String.format("%s pointer [0x%X]", getClass().getSimpleName(), address); }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object) 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Callback other = (Callback) obj;
        return this.address == other.address;
    }
}
