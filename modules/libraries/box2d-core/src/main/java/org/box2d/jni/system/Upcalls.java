/*
BSD 3-Clause License

Copyright (c) 2026, Night Rider

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.box2d.jni.system;

import java.nio.LongBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.box2d.jni.system.Debug.*;
import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.Pointer.*;

/**
 *
 * @author wil
 */
public final class Upcalls {
    static {
        Library.initialize();
    }
    
    /**
     * A list of active calls; this list is responsible for storing all
     * instances of the callbacks that are generated in such a way as to
     * maintain a secure and controlled instance of these calls.
     *
     */
    protected static final Map<CallbackI, Long> UP_CALLS = new HashMap<>();

    static long nmalloc(CallbackI callback, Function<CallbackI, Long> __constructor) {
        if (callback == null && __constructor == null) {
            throw new NullPointerException();
        }
        Long address = __constructor.apply(callback);
        if (address == null || address == NULL) {
            throw new IllegalStateException("Error obtaining a new instance");
        }
        UP_CALLS.put(callback, address);
        return address;
    }

    static void nfree(CallbackI callback) {
        if (callback == null) {
            throw new NullPointerException();
        }
        Long address = UP_CALLS.get(callback);
        if (address == null || address == NULL) {
            apiWarr("There is no record of this: " + callback.getClass());
            return;
        }
        callback.__destructor().apply(address);
        apiLog("Callback free: " + callback.getClass() + String.format(" [0x%X]", address));
    }

    public static long upcallGet(CallbackI callback) {
        Long address = Upcalls.UP_CALLS.get(callback);
        if (address == null || address == NULL) {
            address = Upcalls.nmalloc(callback, callback.__constructor());
        }
        return address;
    }

    public static void upcallFree(CallbackI callback, boolean remove) {
        if (callback == null) {
            return;
        }
        Upcalls.nfree(callback);
        if (remove) {
            UP_CALLS.remove(callback);
            apiLogMore("The %c{" + callback.getClass() + "} was removed from the context.", Color.WHITE);
        }
    }
    
    

    private Upcalls() {
    }
    
    // -----------------------------------
    
    public static final long ffi_type_void = nffi_type_void();
    public static native long nffi_type_void();

    public static final long ffi_type_uint8 = nffi_type_uint8();
    public static native long nffi_type_uint8();

    public static final long ffi_type_sint8 = nffi_type_sint8();
    public static native long nffi_type_sint8();

    public static final long ffi_type_uint16 = nffi_type_uint16();
    public static native long nffi_type_uint16();

    public static final long ffi_type_sint16 = nffi_type_sint16();
    public static native long nffi_type_sint16();

    public static final long ffi_type_uint32 = nffi_type_uint32();
    public static native long nffi_type_uint32();

    public static final long ffi_type_sint32 = nffi_type_sint32();
    public static native long nffi_type_sint32();

    public static final long ffi_type_uint64 = nffi_type_uint64();
    public static native long nffi_type_uint64();

    public static final long ffi_type_sint64 = nffi_type_sint64();
    public static native long nffi_type_sint64();

    public static final long ffi_type_float = nffi_type_float();
    public static native long nffi_type_float();

    public static final long ffi_type_double = nffi_type_double();
    public static native long nffi_type_double();

    public static final long ffi_type_pointer = nffi_type_pointer();
    public static native long nffi_type_pointer();

    public static final long ffi_type_longdouble = nffi_type_longdouble();
    public static native long nffi_type_longdouble();

    // -----------------------------------
    public static final long ffi_type_size_t = nffi_type_size_t();
    public static long nffi_type_size_t() {
        return BITS64 ? ffi_type_uint64 : ffi_type_uint32;
    }
    
    public static final long ffi_type_b2ShapeId = nffi_type_b2ShapeId();
    public static native long nffi_type_b2ShapeId();
    
    public static final long ffi_type_b2Vec2 = nffi_type_b2Vec2();
    public static native long nffi_type_b2Vec2();
    
    public static final long ffi_type_b2Pos = nffi_type_b2Pos() ;
    public static native long nffi_type_b2Pos();
    
    public static final long ffi_type_b2Rot = nffi_type_b2Rot();
    public static native long nffi_type_b2Rot();
    
    public static final long ffi_type_b2Transform = nffi_type_b2Transform();
    public static native long nffi_type_b2Transform();
    
    public static final long ffi_type_b2WorldTransform = nffi_type_b2WorldTransform();
    public static native long nffi_type_b2WorldTransform();
    
    public static final long ffi_type_b2AABB = nffi_type_b2AABB();
    public static native long nffi_type_b2AABB();
    
    // -----------------------------------
    
    public static long jniCallbackCreate(Object handle, long restype, LongBuffer atypes) {
        return njniCallbackCreate(handle, restype, atypes, atypes.remaining());
    }

    public static native long njniCallbackCreate(Object handle, long restype, LongBuffer atypes, long size);

    public static void jniCallbackFree(CallbackI ptr) {
        Checks.checkPointers(ptr);
        njniCallbackFree(ptr.address());
    }

    public static native void njniCallbackFree(long ptr);
    
    // -----------------------------------
    
    public static void apiClosureRet(long ret, boolean __result) { memPutAddress(ret, __result ? 1L : 0L); }
    public static void apiClosureRet(long ret, byte __result)    { memPutAddress(ret, __result & 0xFFL); }
    public static void apiClosureRet(long ret, short __result)   { memPutAddress(ret, __result & 0xFFFFL); }
    public static void apiClosureRet(long ret, int __result)     { memPutAddress(ret, __result & 0xFFFF_FFFFL); }
    public static void apiClosureRetL(long ret, long __result)   { memPutLong(ret, __result); }
    public static void apiClosureRetP(long ret, long __result)   { memPutAddress(ret, __result); }
    public static void apiClosureRet(long ret, float __result)   { memPutFloat(ret, __result); }
    public static void apiClosureRet(long ret, double __result)  { memPutDouble(ret, __result); }
    public static long apiClosureFunction(CallbackI ptr) {
        Long address = UP_CALLS.get(ptr);
        if (address == null || address == NULL) {
            return NULL;
        }
        return napiClosureFunction(address);
    }
    public static native long napiClosureFunction(long ptr);
}
