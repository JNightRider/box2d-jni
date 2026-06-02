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
public class LibCStdint {
    static {
        Library.initialize();
    }
    
    public static final long UINT64_MAX = nUINT64_MAX();
    
    public static native long nUINT64_MAX();
}
