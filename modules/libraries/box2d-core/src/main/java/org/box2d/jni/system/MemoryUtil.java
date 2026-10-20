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
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Objects;

import org.box2d.jni.libc.LibCStdlib;

import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Pointer.*;

/**
 * A utility class responsible for manipulating references and managing the
 * representation of pointers in C and the JVM.
 *
 * @author wil
 * @version 1.2.0
 * @since 1.0.0
 */
public final class MemoryUtil {
    static {
        Library.initialize();
    }

    // --- [ Buffer allocation ] ---

    /**
     * Creates a new direct ByteBuffer that starts at the specified memory
     * address and has the specified capacity. The returned ByteBuffer instance
     * will be set to the native {@link ByteOrder}.
     *
     * @param ptr the starting memory address
     * @param capacity the buffer capacity
     *
     * @return the new ByteBuffer
     */
    public static ByteBuffer memByteBuffer(long ptr, int capacity) {
        if (ptr == NULL) {
            return null;
        }
        ByteBuffer nbuffer = nmemByteBuffer(ptr, capacity);
        nbuffer.order(ByteOrder.nativeOrder());
        return nbuffer;
    }

    /* {@code (*__env)->NewDirectByteBuffer(__env, (void*)ptr, capacity); }*/
    public static native ByteBuffer nmemByteBuffer(long ptr, int capacity);

    /**
     * Creates a new direct ShortBuffer that starts at the specified memory
     * address and has the specified capacity.
     *
     * @param ptr the starting memory address
     * @param capacity the buffer capacity
     *
     * @return the new ShortBuffer
     */
    public static ShortBuffer memShortBuffer(long ptr, int capacity) {
        return memByteBuffer(ptr, capacity * Short.BYTES).asShortBuffer();
    }

    /**
     * Creates a new direct FloatBuffer that starts at the specified memory
     * address and has the specified capacity.
     *
     *
     * @param ptr the starting memory address
     * @param capacity the buffer capacity
     *
     * @return the new FloatBuffer
     */
    public static FloatBuffer memFloatBuffer(long ptr, int capacity) {
        return memByteBuffer(ptr, capacity * Float.BYTES).asFloatBuffer();
    }

    /**
     * Creates a new direct IntBuffer that starts at the specified memory
     * address and has the specified capacity.
     *
     * @param ptr the starting memory address
     * @param capacity the buffer capacity
     *
     * @return the new IntBuffer
     */
    public static IntBuffer memIntBuffer(long ptr, int capacity) {
        return memByteBuffer(ptr, capacity * Integer.BYTES).asIntBuffer();
    }

    /**
     * Creates a new direct DoubleBuffer that starts at the specified memory
     * address and has the specified capacity.
     *
     * @param ptr the starting memory address
     * @param capacity the buffer capacity
     *
     * @return the new DoubleBuffer
     */
    public static DoubleBuffer memDoubleBuffer(long ptr, int capacity) {
        return memByteBuffer(ptr, capacity * Double.BYTES).asDoubleBuffer();
    }

    /**
     * Creates a new direct LongBuffer that starts at the specified memory
     * address and has the specified capacity.
     *
     * @param ptr the starting memory address
     * @param capacity the buffer capacity
     *
     * @return the new LongBuffer
     */
    public static LongBuffer memLongBuffer(long ptr, int capacity) {
        return memByteBuffer(ptr, capacity * Long.BYTES).asLongBuffer();
    }

    /**
     * The standard C free function.
     *
     * @param buffer The buffer, which originates from a pointer and is accessed
     *               via a {@link  Buffer} wrapper, points to native memory located outside the
     *               scope of the JVM.
     */
    public static void memFree(ByteBuffer buffer) {
        nmemFree(buffer);
    }

    /* {@code ShortBuffer} version of {@link #memFree(Buffer)}. */
    public static void memFree(ShortBuffer buffer) {
        if (buffer != null) {
            nmemFree(buffer);
        }
    }

    /* {@code FloatBuffer} version of {@link #memFree(Buffer)}. */
    public static void memFree(FloatBuffer buffer) {
        if (buffer != null) {
            nmemFree(buffer);
        }
    }

    /* {@code IntBuffer} version of {@link #memFree(Buffer)}. */
    public static void memFree(IntBuffer buffer) {
        if (buffer != null) {
            nmemFree(buffer);
        }
    }

    /* {@code DoubleBuffer} version of {@link #memFree(Buffer)}. */
    public static void memFree(DoubleBuffer buffer) {
        if (buffer != null) {
            nmemFree(buffer);
        }
    }

    /* {@code LongBuffer} version of {@link #memFree(Buffer)}. */
    public static void memFree(LongBuffer buffer) {
        if (buffer != null) {
            nmemFree(buffer);
        }
    }
    /* {@code free(void*) }*/
    public static native void nmemFree(Buffer ptr);

    // --- [ memAddress0 ] ---

    /**
     * Returns the memory address of the specified buffer.
     *
     * @param buffer the buffer
     *
     * @return the memory address
     */
    public static native long nmemAddress0(Buffer buffer);

    // --- [ Buffer address ] ---

    /**
     * Returns the memory address at the current position of the specified
     * buffer. This is effectively a pointer value that can be used in native
     * function calls.
     *
     * @param buffer the buffer
     *
     * @return the memory address
     */
    public static long memAddress(ByteBuffer buffer) {
        return buffer.position() + nmemAddress0(buffer);
    }
 
    /**
     * Returns the memory address at the specified position of the specified
     * buffer.
     *
     * @param buffer the buffer
     * @param position the buffer position
     *
     * @return the memory address
     *
     * @see #memAddress(ByteBuffer)
     */
    public static long memAddress(ByteBuffer buffer, int position) {
        Objects.requireNonNull(buffer);
        return nmemAddress0(buffer) + Integer.toUnsignedLong(position);
    }

    private static long address(int position, int elementShift, long address) {
        return address + ((position & 0xFFFF_FFFFL) << elementShift);
    }

    /* ShortBuffer version of {@link #memAddress(ByteBuffer)}. */
    public static long memAddress(ShortBuffer buffer) { return address(buffer.position(), 1, nmemAddress0(buffer)); }
    /* ShortBuffer version of {@link #memAddress(ByteBuffer, int)}. */
    public static long memAddress(ShortBuffer buffer, int position) {
        Objects.requireNonNull(buffer);
        return address(position, 1, nmemAddress0(buffer));
    }

    /* IntBuffer version of {@link #memAddress(ByteBuffer)}. */
    public static long memAddress(IntBuffer buffer) { return address(buffer.position(), 2, nmemAddress0(buffer)); }
    /* IntBuffer version of {@link #memAddress(ByteBuffer, int)}. */
    public static long memAddress(IntBuffer buffer, int position) {
        Objects.requireNonNull(buffer);
        return address(position, 2, nmemAddress0(buffer));
    }

    /* FloatBuffer version of {@link #memAddress(ByteBuffer)}. */
    public static long memAddress(FloatBuffer buffer) { return address(buffer.position(), 2, nmemAddress0(buffer)); }
    /* FloatBuffer version of {@link #memAddress(ByteBuffer, int)}. */
    public static long memAddress(FloatBuffer buffer, int position) {
        Objects.requireNonNull(buffer);
        return address(position, 2, nmemAddress0(buffer));
    }

    /* LongBuffer version of {@link #memAddress(ByteBuffer)}. */
    public static long memAddress(LongBuffer buffer) { return address(buffer.position(), 3, nmemAddress0(buffer)); }
    /* LongBuffer version of {@link #memAddress(ByteBuffer, int)}. */
    public static long memAddress(LongBuffer buffer, int position) {
        Objects.requireNonNull(buffer);
        return address(position, 3, nmemAddress0(buffer));
    }

    /* DoubleBuffer version of {@link #memAddress(ByteBuffer)}. */
    public static long memAddress(DoubleBuffer buffer) { return address(buffer.position(), 3, nmemAddress0(buffer)); }
    /* DoubleBuffer version of {@link #memAddress(ByteBuffer, int)}. */
    public static long memAddress(DoubleBuffer buffer, int position) {
        Objects.requireNonNull(buffer);
        return address(position, 3, nmemAddress0(buffer));
    }

    /* UintptrBuffer version of {@link #memAddress(ByteBuffer)}. */
    public static long memAddress(UintptrBuffer<?> buffer) { return buffer.address(); }
    /* UintptrBuffer version of {@link #memAddress(ByteBuffer, int)}. */
    public static long memAddress(UintptrBuffer<?> buffer, int position) { return buffer.address(position); }

    // --- [ StringMalloc ] ----
    
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
