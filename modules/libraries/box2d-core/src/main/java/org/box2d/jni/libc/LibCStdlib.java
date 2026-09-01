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
package org.box2d.jni.libc;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

import org.box2d.jni.system.Library;

import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.MemoryUtil.*;

/**
 * Implementation of C libraries: {@code <stdlib.h>}
 *
 * @author wil
 * @version 1.1.0
 * @since 1.0.0
 */
public final class LibCStdlib {
    static {
        Library.initialize();
    }

    // --- [ calloc ] ---

    /**
     * {@code void* calloc( size_t num, size_t size ); }
     *
     * @param num long
     * @param size long
     * @return ByteBuffer
     */
    public static ByteBuffer calloc(long num, long size) {
        long __result = ncalloc(num, size);
        return memByteBuffer(__result, (int)(num * size));
    }

    /* {@code void* calloc( size_t num, size_t size ); } */
    public static native long ncalloc(long num, long size);

    // --- [ malloc ] ---

    /**
     * {@code void* malloc( size_t size ); }
     *
     * @param size long
     * @return ByteBuffer
     */
    public static ByteBuffer malloc(long size) {
        long __result = nmalloc(size);
        return memByteBuffer(__result, (int)size);
    }

    /* {@code void* malloc( size_t size ); } */
    public static native long nmalloc(long size);

    // --- [ free ] ---

    /**
     * {@code void free( void* ptr ); }
     *
     * @param buffer ByteBuffer
     */
    public static void free(ByteBuffer buffer) {
        nfree(memGetNativeAddress(buffer));
    }

    /**
     * {@code void free( void* ptr ); }
     *
     * @param buffer ShortBuffer
     */
    public static void free(ShortBuffer buffer) {
        nfree(memGetNativeAddress(buffer));
    }

    /**
     * {@code void free( void* ptr ); }
     *
     * @param buffer IntBuffer
     */
    public static void free(IntBuffer buffer) {
        nfree(memGetNativeAddress(buffer));
    }

    /**
     * {@code void free( void* ptr ); }
     *
     * @param buffer FloatBuffer
     */
    public static void free(FloatBuffer buffer) {
        nfree(memGetNativeAddress(buffer));
    }

    /**
     * {@code void free( void* ptr ); }
     *
     * @param buffer DoubleBuffer
     */
    public static void free(DoubleBuffer buffer) {
        nfree(memGetNativeAddress(buffer));
    }

    /**
     * {@code void free( void* ptr ); }
     *
     * @param buffer LongBuffer
     */
    public static void free(LongBuffer buffer) {
        nfree(memGetNativeAddress(buffer));
    }

    /* {@code void free( void* ptr ); } */
    public static native void nfree(long ptr);

    // --- [ aligned_alloc ] ---

    /**
     * {@code void* aligned_alloc( size_t alignment, size_t size ); }
     *
     * @param alignment long
     * @param size long
     * @return ByteBuffer
     */
    public static ByteBuffer aligned_alloc(long alignment, long size) {
        long __result = naligned_alloc(alignment, size);
        return memByteBuffer(__result, (int)size);
    }

    /* {@code void* aligned_alloc( size_t alignment, size_t size ); } */
    public static native long naligned_alloc(long alignment, long size);

    // --- [ aligned_free ] ---

    /**
     * void aligned_free ( void *memblock );
     *
     * @param ptr ByteBuffer
     */
    public static void aligned_free(ByteBuffer ptr) {
        naligned_free(memGetNativeAddress(ptr));
    }

    /**
     * void aligned_free ( void *memblock );
     *
     * @param ptr ShortBuffer
     */
    public static void aligned_free(ShortBuffer ptr) {
        naligned_free(memGetNativeAddress(ptr));
    }

    /**
     * void aligned_free ( void *memblock );
     *
     * @param ptr IntBuffer
     */
    public static void aligned_free(IntBuffer ptr) {
        naligned_free(memGetNativeAddress(ptr));
    }

    /**
     * void aligned_free ( void *memblock );
     *
     * @param ptr FloatBuffer
     */
    public static void aligned_free(FloatBuffer ptr) {
        naligned_free(memGetNativeAddress(ptr));
    }

    /**
     * void aligned_free ( void *memblock );
     *
     * @param ptr DoubleBuffer
     */

    public static void aligned_free(DoubleBuffer ptr) {
        naligned_free(memGetNativeAddress(ptr));
    }

    /**
     * void aligned_free ( void *memblock );
     *
     * @param ptr LongBuffer
     */
    public static void aligned_free(LongBuffer ptr) {
        naligned_free(memGetNativeAddress(ptr));
    }

    /* void aligned_free ( void *memblock ); */
    public static native void naligned_free(long ptr);
}
