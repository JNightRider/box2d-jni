/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
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
    
    /**
     * Returns the raw pointer address as a {@code long} value.
     *
     * @return the pointer address
     */
    long address();
}
