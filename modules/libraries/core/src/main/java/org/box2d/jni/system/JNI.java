/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.system;

/**
 *
 * @author wil
 */
public final class JNI {
    
    public static native long invokeJIP(long param0, int param1, long __functionAddress);    
    public static native void invokeJJV(long param0, long param1, long __functionAddress);
    public static native void invokePV(long param0, long __functionAddress);
    public static native int invokePPII(long param0, long param1, int param2, long __functionAddress);
    
    public static native void invokePPV(long param0, long param1, long __functionAddress);
    public static native long invokePPPP(long param0, long param1, long param2, long __functionAddress);
    public static native float invokeFJFJF(float param0, long param1, float param2, long param3, long __functionAddress);
}
