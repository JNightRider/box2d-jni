/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.system;

/**
 *
 * @author wil
 */
public final class Memory {
    
    static {
        Library.initialize();
    }
    
    public static int memSizeOf(long ptr) {
        Checks.checkAddress(ptr);
        return nsizeof(ptr);
    }
    
    public static native int nsizeof(long ptr);
    
    public static byte memGetByte(long ptr) {
        Checks.checkAddress(ptr);
        return ngetByte(ptr);
    }
    
    public static native byte ngetByte(long ptr);
    
    public static short memGetShort(long ptr) {
        Checks.checkAddress(ptr);
        return ngetShort(ptr);
    }
    
    public static native short ngetShort(long ptr);
    
    public static int memGetInt(long ptr) {
        Checks.checkAddress(ptr);
        return ngetInt(ptr);
    }
    
    public static native int ngetInt(long ptr);
    
    public static long memGetLong(long ptr) {
        Checks.checkAddress(ptr);
        return ngetLong(ptr);
    }
    
    public static native long ngetLong(long ptr);
    
    public static float memGetFloat(long ptr) {
        Checks.checkAddress(ptr);
        return ngetFloat(ptr);
    }
    
    public static native float ngetFloat(long ptr);
    
    public static double memGetDouble(long ptr) {
        Checks.checkAddress(ptr);
        return ngetDouble(ptr);
    }
    
    public static native double ngetDouble(long ptr);
    
    public static long memGetAddress(long ptr) {
        Checks.checkAddress(ptr);
        return ngetAddress(ptr);
    }
    
    public static native long ngetAddress(long ptr);
    
    public static void memPutByte(long ptr, byte value) {
        Checks.checkAddress(ptr);
        nputByte(ptr, value);
    }
    
    public static native void nputByte(long ptr, byte value);
    
    public static void memPutShort(long ptr, short value) {
        Checks.checkAddress(ptr);
        nputShort(ptr, value);
    }
    
    public static native void nputShort(long ptr, short value);
    
    public static void memPutInt(long ptr, int value) {
        Checks.checkAddress(ptr);
        nputInt(ptr, value);
    }
    
    public static native void nputInt(long ptr, int value);
    
    public static void memPutLong(long ptr, long value) {
        Checks.checkAddress(ptr);
        nputLong(ptr, value);
    }
    
    public static native void nputLong(long ptr, long value);
    
    public static void memPutFloat(long ptr, float value) {
        Checks.checkAddress(ptr);
        nputFloat(ptr, value);
    }
    
    public static native void nputFloat(long ptr, float value);
    
    public static void memPutDouble(long ptr, double value) {
        Checks.checkAddress(ptr);
        nputDouble(ptr, value);
    }
    
    public static native void nputDouble(long ptr, double value);
    
    public static void memPutAddress(long ptr, long value) {
        Checks.checkAddress(ptr);
        nputAddress(ptr, value);
    }
    
    public static native void nputAddress(long ptr, long value);
}
