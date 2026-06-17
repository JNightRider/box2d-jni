/*
BSD 3-Clause License

Copyright (c) 2026, Night Rider

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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
