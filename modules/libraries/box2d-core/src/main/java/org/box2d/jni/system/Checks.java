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

import java.nio.Buffer;
import static org.box2d.jni.system.Pointer.*;

/**
 * An internal-use class for verifying objects used by Box2dJNI.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.'
 */
public final class Checks {
    
    /**
     * Method in charge of verifying if the pointers are valid, that is, that 
     * they are not null and that they have a valid memory address. Otherwise an 
     * exception will be thrown.
     * 
     * @param pointers the pointers
     */
    public static void checkPointers(Pointer ...pointers) {
        if (pointers == null) {
            throw new NullPointerException("Invalid pointers");
        }
        for (int i = 0; i < pointers.length; i++) {
            final Pointer ptr = pointers[i];
            if (ptr == null || ptr.address() == NULL) {
                throw new IllegalStateException("Pointer " +  ptr + " is invalid");
            }
        }
    }
    
    public static void checkAddress(long ...pointers) {
        for (int i = 0; i < pointers.length; i++) {
            final long ptr = pointers[i];
            if (ptr == NULL) {
                throw new IllegalStateException("Pointer " +  ptr + " is invalid");
            }
        }
    }
    
    public static void checkMinBuffer(Buffer buffer, int length) {
        if (buffer.capacity() < length) {
            throw new IllegalStateException("The capacity of pointer %d does not match the size %d".formatted(buffer.capacity(), length));
        }
    }
    
    public static void checkBuffer(Buffer buffer, int length) {
        if (buffer.capacity() != length) {
            throw new IllegalStateException("The capacity of pointer %d does not match the size %d".formatted(buffer.capacity(), length));
        }
        if (!buffer.isDirect()) {
            throw new IllegalStateException("The buffer does not have direct access to native memory.");
        }
    }
    
    public static void checkIndex(long index, long length) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Out of range:  index=" + index + " length=" + length);
        }
    }
    
    public static void checkArray(Object[] array, int length) {
        if (array.length != length) {
            throw new IllegalStateException("The capacity of array %d does not match the size %d".formatted(array.length, length));
        }
    }
    
    public static void checkArray(int[] array, int length) {
        if (array.length != length) {
            throw new IllegalStateException("The capacity of array %d does not match the size %d".formatted(array.length, length));
        }
    }
    
    public static boolean isValidPointer(Pointer prt) {
        if (prt == null) {
            return false;
        }
        return !isValidPointer(prt.address());
    }
    
    public static boolean isValidPointer(long prt) {
        return prt != NULL;
    }
    
    private Checks() {}
}