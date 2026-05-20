/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.readonly;

/**
 * Read-only access to a {@code Struct}.
 *
 * @author wil
 * @version 1.0.1
 * @since 1.0.0
 */
public interface ConstStruct extends ConstPointer, AutoCloseable {

    /* (non-Javadoc)
     * @see AutoCloseable#close() 
     */
    @Override
    void close();
}
