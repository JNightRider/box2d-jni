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
public final class LibCStdlib {
    static {
        Library.initialize();
    }
    
    public static native long nmalloc(long size);
    
    public static native void nfree(long ptr);
}
