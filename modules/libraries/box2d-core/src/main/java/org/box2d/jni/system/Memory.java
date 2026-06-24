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

import java.nio.*;
import static org.box2d.jni.system.Checks.*;

/**
 * Class responsible for providing methods for managing native pointers (memory)
 * between the JVM and C/C++
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Memory {

    static {
        Library.initialize();
    }

    // -----------------------------------
    public static ByteBuffer memCreateByteBuffer(int size, int sizeof) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(size * sizeof);
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer;
    }

    public static ByteBuffer memCreateByteBuffer(int size) {
        return memCreateByteBuffer(1, size);
    }

    public static DoubleBuffer memCreateDoubleBuffer(int size) {
        ByteBuffer byteBuffer = memCreateByteBuffer(size, Double.BYTES);
        DoubleBuffer result = byteBuffer.asDoubleBuffer();

        checkBuffer(result, size);
        return result;
    }

    public static FloatBuffer memCreateFloatBuffer(int size) {
        ByteBuffer byteBuffer = memCreateByteBuffer(size, Float.BYTES);
        FloatBuffer result = byteBuffer.asFloatBuffer();

        checkBuffer(result, size);
        return result;
    }

    public static IntBuffer memCreateIntBuffer(int size) {
        ByteBuffer byteBuffer = memCreateByteBuffer(size, Integer.BYTES);
        IntBuffer result = byteBuffer.asIntBuffer();

        checkBuffer(result, size);
        return result;
    }

    public static LongBuffer memCreateLongBuffer(int size) {
        ByteBuffer byteBuffer = memCreateByteBuffer(size, Long.BYTES);
        LongBuffer result = byteBuffer.asLongBuffer();

        checkBuffer(result, size);
        return result;
    }

    // -----------------------------------
    
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
    
    public static long memGetNativeAddress(Buffer buffer) {
        return ngetNativeAddress(buffer);
    }
    
    public static native long ngetNativeAddress(Buffer buffer);
}
