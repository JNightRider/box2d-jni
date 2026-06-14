/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.system;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.box2d.jni.libc.LibCStdlib;

import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Pointer.*;

/**
 *
 * @author wil
 */
public final class MemoryUtil {
    static {
        Library.initialize();
    }
    
    public static ByteBuffer memByteBuffer(long ptr, int capacity) {
        if (ptr == NULL) {
            return null;
        }
        ByteBuffer nbuffer = nmemByteBuffer(ptr, capacity);
        nbuffer.order(ByteOrder.nativeOrder());
        return nbuffer;
    }
    
    public static native ByteBuffer nmemByteBuffer(long ptr, int capacity);
    
    public static FloatBuffer memFloatBuffer(long ptr, int capacity) {
        return nmemFloatBuffer(ptr, capacity * Float.BYTES);
    }
    
    public static FloatBuffer nmemFloatBuffer(long ptr, int capacity) {
        ByteBuffer buffer = memByteBuffer(ptr, capacity);
        return buffer.asFloatBuffer();
    }
    
    public static IntBuffer memIntBuffer(long ptr, int capacity) {
        return nmemIntBuffer(ptr, capacity * Integer.BYTES);
    }
    
    public static IntBuffer nmemIntBuffer(long ptr, int capacity) {
        ByteBuffer buffer = memByteBuffer(ptr, capacity);
        return buffer.asIntBuffer();
    }

    public static void memFree(ByteBuffer buffer) {
        nmemFree(buffer);
    }
    
    public static void memFree(FloatBuffer buffer) {
        nmemFree(buffer);
    }
    
    public static void memFree(IntBuffer buffer) {
        nmemFree(buffer);
    }
    
    public static native void nmemFree(Buffer ptr);
    
    public static long memMallocUTF8L(String value, long len) {
        return memMallocUTF8(value, LibCStdlib.nmalloc(len));
    }

    public static long memMallocUTF8(String value, long __result) {
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
