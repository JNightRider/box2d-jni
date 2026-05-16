/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.system;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/**
 * A class responsible for representing a raw pointer (virtual address).
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class Uintptr implements Pointer {

    /**
     * A virtual memory address that manages a native object through a pointer,
     * whose address can be used to manipulate that native object.
     */
    protected AtomicLong address;

    /**
     * Generates a new raw pointer, storing its virtual memory address.
     *
     * @param address A virtual memory address
     * @param check A check flag if necessary
     */
    protected Uintptr(long address, boolean check) {
        if (check && address == NULL) {
            throw new NullPointerException("Invalid virtual address");
        }
        this.address = new AtomicLong(address);
    }

    /* (non-Javadoc) @see org.cube.system.Pointer#address() */
    @Override
    public long address() { return address.get(); }
    /* (non-Javadoc) @see java.lang.Object#equals(java.lang.Object) */
    @Override
    public int hashCode() { return (int) (this.address() ^ (this.address() >>> 32)); }
    /* (non-Javadoc) @see java.lang.Object#toString() */
    @Override
    public String toString() {
        return String.format("%s pointer [0x%X]", getClass().getSimpleName(), address());
    }

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
        final Uintptr other = (Uintptr) obj;
        return Objects.equals(this.address, other.address);
    }
}
