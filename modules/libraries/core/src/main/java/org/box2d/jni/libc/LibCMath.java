/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.libc;

import org.box2d.jni.system.Library;

/**
 *
 * @author wil
 */
public class LibCMath {
    static {
        Library.initialize();
    }
    
    public static float cosf(float a) {
        return ncosf(a);
    }
    
    public static native float ncosf(float a);
    
    public static float sinf(float a) {
        return nsinf(a);
    }
    
    public static native float nsinf(float a);
    
    public static float atan2f(float y, float x) {
        return natan2f(y, x);
    }
    
    public static native float natan2f(float y, float x);
}
