/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.libc;

import org.box2d.jni.system.Library;
import org.box2d.jni.system.Pointer;

/**
 *
 * @author wil
 */
public class LibCString {
    static {
        Library.initialize();
    }
    
    public static native long nmemset(long ptr, int value, long num);
    
    public static <T extends Pointer> T memcpy(T dest, Pointer src, long n) {
        nmemcpy(dest.address(), src.address(), n);
        return dest;
    }
    
    public static native long nmemcpy(long dest, long src, long n);
    
    public static native long nstrlen(long s);
}
