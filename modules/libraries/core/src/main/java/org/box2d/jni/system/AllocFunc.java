/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
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
