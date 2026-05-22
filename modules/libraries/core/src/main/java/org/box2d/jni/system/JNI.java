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
}
