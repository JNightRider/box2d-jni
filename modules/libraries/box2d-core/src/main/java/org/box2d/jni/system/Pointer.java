/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.system;

/**
 * Pointer interface.
 * <p>
 * This interface can be used where there is a need to manage or make a connection
 * to the native code, this interface provides the methods needed to manage it.
 * </p>
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Pointer {
    
    /** Alias for the null pointer address. */
    public static final long NULL = 0L;
    
    /** The pointer size in bytes. Will be 4 on a 32bit JVM and 8 on a 64bit one. */
    int POINTER_SIZE = VarType.Pointer.sizeof();

    /** Will be true on a 32bit JVM. */
    boolean BITS32 = POINTER_SIZE * 8 == 32;

    /** Will be true on a 64bit JVM. */
    boolean BITS64 = POINTER_SIZE * 8 == 64;
    
    /**
     * Returns the raw pointer address as a {@code long} value.
     *
     * @return the pointer address
     */
    long address();
}
