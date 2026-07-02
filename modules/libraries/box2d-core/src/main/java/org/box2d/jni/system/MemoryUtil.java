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

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.box2d.jni.libc.LibCStdlib;

import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Pointer.*;

/**
 * A utility class responsible for manipulating references and managing the
 * representation of pointers in C and the JVM.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
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
    
    public static long memMallocUTF(String value) {
        long ptr = nGetStringUTFChars(value);
        long size = nstrlen(ptr) + 1;
        long address = LibCStdlib.nmalloc(size);
        if (ptr != NULL) {
            nmemcpy(address, ptr, size);
        }
        nReleaseStringUTFChars(value, ptr);
        return address;
    }
    
    public static long memMallocUTF(String value, ArenaAlloc alloc) {
        long ptr = nGetStringUTFChars(value);
        long size = nstrlen(ptr) + 1;
        long address = alloc.nmalloc((int)size);
        if (ptr != NULL) {
            nmemcpy(address, ptr, size);
        }
        nReleaseStringUTFChars(value, ptr);
        return address;
    }

    public static long memMallocUTF(String value, long __result) {
        long ptr = nGetStringUTFChars(value);
        if (ptr != NULL) {
            nmemcpy(__result, ptr, nstrlen(ptr) + 1);
        }
        nReleaseStringUTFChars(value, ptr);
        return __result;
    }

    public static String memUTF(long ptr) {
        if (ptr == NULL) {
            return null;
        }
        return nNewStringUTF(ptr);
    }

    static native long nGetStringUTFChars(String string);    
    static native void nReleaseStringUTFChars(String string, long ptr);    
    static native String nNewStringUTF(long ptr);
}
