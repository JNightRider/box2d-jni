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
public class LibCFloat {
    static {
        Library.initialize();
    }
    
    public static final float FLT_EPSILON = nFLT_EPSILON();
    
    public static native float nFLT_EPSILON();
}
