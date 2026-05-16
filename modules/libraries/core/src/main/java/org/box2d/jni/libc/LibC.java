/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.libc;

import org.box2d.jni.system.Library;
import org.box2d.jni.system.Pointer;

/**
 *
 * @author wil
 */
public final class LibC {

    static {
        Library.initialize();
    }

    public static long sizeof(Class clazz) {
        if (clazz == null) {
            return 0L;
        }
        if (!(clazz.isPrimitive() || Pointer.class.equals(clazz))) {
            throw new IllegalStateException("Only primitive types are allowed.");
        }
        return nsizeof(LibCVarType.valueOf(clazz));
    }

    public static native long nsizeof(int type);

    public static long sizeof(long address) {
        return nsizeof(address);
    }

    public static native long nsizeof(long var);
}
