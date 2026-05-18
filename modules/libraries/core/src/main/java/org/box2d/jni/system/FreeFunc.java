/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.system;

/**
 *
 * @author wil
 */
@FunctionalInterface
public interface FreeFunc {
    
    void free(long ptr);
}
