/*
Copyright Night Rider. All rights reserved.
https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.libc;

/**
 *
 * @author wil
 */
public final class LibCStdlib {
    
    public static native long nmalloc(long size);
    
    public static native void nfree(long ptr);
}
