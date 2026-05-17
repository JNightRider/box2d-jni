/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.system;

/**
 * Classes that implement this interface are associated with one or more native
 * resources. These resources must be explicitly released when a class instance
 * is no longer in use, using the {@link #free} method.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface JNINative extends AutoCloseable {

    /**
     * Frees any native resources held by this object.
     */
    void free();

    /*(non-Javaodc)
     * @see AutoCloseable#close() 
     */
    @Override
    public default void close() {
        free();
    }
}
