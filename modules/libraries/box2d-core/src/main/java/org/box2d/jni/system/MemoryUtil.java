/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.system;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Pointer.*;

/**
 *
 * @author wil
 */
public final class MemoryUtil {
    
    public static FloatBuffer memFloatBuffer(long ptr, int capacity) {
        ByteBuffer buffer = Memory.memPutNativeAddress(ptr, capacity);
        return buffer.asFloatBuffer();
    }
    
    public static IntBuffer memIntBuffer(long ptr, int capacity) {
        ByteBuffer buffer = Memory.memPutNativeAddress(ptr, capacity);
        return buffer.asIntBuffer();
    }

    public static long memUTF8(String value, long __result) {
        long ptr = nGetStringUTFChars(value);
        if (ptr != NULL) {
            nmemcpy(__result, ptr, nstrlen(ptr) + 1);
        }
        nReleaseStringUTFChars(value, ptr);
        return __result;
    }
    
    public static String memGetStringUTF8(long ptr) {
        if (ptr == NULL) {
            return null;
        }
        return nNewStringUTF(ptr);
    }
    
    public static native long nGetStringUTFChars(String string);
    
    public static native void nReleaseStringUTFChars(String string, long ptr);
    
    public static native String nNewStringUTF(long ptr);
}
