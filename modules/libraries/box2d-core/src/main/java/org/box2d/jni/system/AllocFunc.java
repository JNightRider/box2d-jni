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
public interface AllocFunc {
    
    long alloc(int alignment, int sizeof, long num);
}
