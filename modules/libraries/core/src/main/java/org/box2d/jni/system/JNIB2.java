/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.system;

/**
 *
 * @author wil
 */
public final class JNIB2 {
    public static native boolean invoke_SHAPEID_PB(long param0, long param1, long __functionAddress);
    public static native boolean invoke_SHAPEID_PPB(long param0, long param1, long param2, long __functionAddress);
    public static native boolean invoke_SHAPEID_SHAPEID_PB(long param0, long param1, long param2, long __functionAddress);
    public static native boolean invoke_SHAPEID_SHAPEID_VEC2_VEC2_PB(long param0, long param1, long param2, long param3, long param4, long __functionAddress);
    public static native float invoke_SHAPEID_VEC2_VEC2_FPF(long param0, long param1, long param2, float param3, long param4, long __functionAddress);
    
}
