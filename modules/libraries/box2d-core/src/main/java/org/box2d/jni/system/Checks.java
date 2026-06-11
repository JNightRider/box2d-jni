/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.system;

import java.nio.Buffer;
import static org.box2d.jni.system.Pointer.*;

/**
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.'
 */
public final class Checks {
    
    public static void setDebugEnabled(boolean b) {
        Debug.DEBUG = b;
    }
    
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
            System.out.println("direct");
        }
        if (buffer.limit() != length) {
            System.out.println("limit: " + buffer.limit());
        }
        if (buffer.position() > 0) {
            System.out.println("pos");
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