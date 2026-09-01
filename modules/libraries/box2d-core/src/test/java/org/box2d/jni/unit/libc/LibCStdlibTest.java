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
package org.box2d.jni.unit.libc;

import java.nio.ByteBuffer;

import org.box2d.jni.system.Library;
import org.box2d.jni.system.Sys;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.system.Debug.*;
import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.Pointer.*;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to manage the unit tests of the {@code LibCStdlib} class.
 *
 * @author wil
 * @version 2.0.0
 * @since 1.0.5
 */
public class LibCStdlibTest {

    /**
     * Setup Library
     */
    @BeforeClass
    public static void setupLibrary() {
        Sys.BOX2D_NDEBUG.set(true);
        Library.initialize();
    }

    /**
     * Initialize all tests.
     */
    @Test
    public void testLibCStd() {
        testClib();
        testCalloc();
        testMalloc();
    }

    /**
     * simple test
     */
    public void testClib() {
        {
            long ptr = nmalloc(8);
            assertNotEquals(NULL, ptr);
            nfree(ptr);
        }
        {
            long alig_ptr = naligned_alloc(64, 128);
            assertNotEquals(NULL, alig_ptr);
            naligned_free(alig_ptr);
        }
    }

    /**
     * test {@code calloc}
     */
    public void testCalloc() {
        long num = 2L;
        long size = Byte.BYTES;

        {
            ByteBuffer ptr = calloc(num, size);

            apiLog("Start calloc ~ByteBuffer");
            apiLogMore("capacity: " + ptr.capacity());
            apiLogMore("limit: " + ptr.limit());

            assertNotEquals(NULL, memGetNativeAddress(ptr));
            assertEquals(num, ptr.capacity());
            assertEquals(num, ptr.limit());

            ptr.put((byte) 1);
            ptr.put((byte) 10);

            assertEquals(1, ptr.get(0));
            assertEquals(10, ptr.get(1));            
            free(ptr);
        }
        {
            long ptr = ncalloc(num, size);
            apiLog("Start calloc ~uintptr_t");
            apiLogMore("address: " + ptr);

            assertNotEquals(NULL, ptr);

            memPutByte(ptr, (byte) 40);
            memPutByte(ptr + size, (byte) 2);

            assertEquals(40, memGetByte(ptr));
            assertEquals(2, memGetByte(ptr + size));
            nfree(ptr);
        }
    }

    /**
     * test {@code malloc}
     */
    public void testMalloc() {
        long num = 2L;
        long size = Byte.BYTES;

        {
            ByteBuffer ptr = malloc(num * size);

            apiLog("Start malloc ~ByteBuffer");
            apiLogMore("capacity: " + ptr.capacity());
            apiLogMore("limit: " + ptr.limit());

            assertNotEquals(NULL, memGetNativeAddress(ptr));
            assertEquals(num, ptr.capacity());
            assertEquals(num, ptr.limit());

            ptr.put((byte) 1);
            ptr.put((byte) 10);

            assertEquals(1, ptr.get(0));
            assertEquals(10, ptr.get(1));            
            free(ptr);
        }
        {
            long ptr = nmalloc(num * size);
            apiLog("Start malloc ~uintptr_t");
            apiLogMore("address: " + ptr);

            assertNotEquals(NULL, ptr);

            memPutByte(ptr, (byte) 40);
            memPutByte(ptr + size, (byte) 2);

            assertEquals(40, memGetByte(ptr));
            assertEquals(2, memGetByte(ptr + size));
            nfree(ptr);
        }
    }
}
