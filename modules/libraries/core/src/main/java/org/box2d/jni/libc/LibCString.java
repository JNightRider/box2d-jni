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
public class LibCString {
    static {
        Library.initialize();
    }
    
    public static native long nmemset(long ptr, int value, long num);
    
    public static native long nmemcpy(long dest, long src, long n);
    
    public static native long nstrlen(long s);
}
