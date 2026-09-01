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
package org.box2d.jni.unit.libc

import androidx.test.ext.junit.runners.AndroidJUnit4

import org.box2d.jni.system.Sys

import org.box2d.jni.libc.LibCStdlib.*
import org.box2d.jni.system.Debug.*
import org.box2d.jni.system.Memory.*
import org.box2d.jni.system.Pointer.*
import org.box2d.jni.test.util.LibraryUtils
import org.junit.*
import org.junit.Assert.*
import org.junit.runner.RunWith

import kotlin.run

/**
 * A class to manage the unit tests of the {@code LibCStdlib} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.3.0
 */
@RunWith(AndroidJUnit4::class)
class LibCStdlibTest {

    /**
     * Setup Library
     */
    @Before
    fun setupLibrary() {
        Sys.BOX2D_NDEBUG.set(true)
        LibraryUtils.setupLibrary()
    }

    /**
     * Initialize all tests.
     */
    @Test
    fun testLibCStd() {
        testClib()
        testCalloc()
        testMalloc()
    }

    /**
     * simple test
     */
    fun testClib() {
        run {
            apiLog("Start ~nmalloc")
            val ptr = nmalloc(8)
            assertNotEquals(NULL, ptr)
            nfree(ptr)
        }
        run {
            apiLog("Start ~naligned_alloc")
            val alig_ptr = naligned_alloc(64, 128)
            assertNotEquals(NULL, alig_ptr)
            naligned_free(alig_ptr)
        }
    }

    /**
     * test `calloc`
     */
    fun testCalloc() {
        val num = 2L
        val size = 8L

        run {
            val ptr = calloc(num, size)
            apiLog("Start calloc ~ByteBuffer")
            apiLogMore("capacity: " + ptr.capacity())
            apiLogMore("limit: " + ptr.limit())

            assertNotEquals(NULL, memGetNativeAddress(ptr))
            assertEquals(num * size, ptr.capacity().toLong())
            assertEquals(num * size, ptr.limit().toLong())

            ptr.put(1.toByte())
            ptr.put(10.toByte())

            Assert.assertEquals(1, ptr.get(0).toLong())
            Assert.assertEquals(10, ptr.get(1).toLong())
            free(ptr)
        }
        run {
            val ptr = ncalloc(num, size)
            apiLog("Start calloc ~uintptr_t")
            apiLogMore("address: " + ptr)

            assertNotEquals(NULL, ptr)

            memPutByte(ptr, 40.toByte())
            memPutByte(ptr + size, 2.toByte())

            assertEquals(40, memGetByte(ptr).toLong())
            assertEquals(2, memGetByte(ptr + size).toLong())
            nfree(ptr)
        }
    }

    /**
     * test `malloc`
     */
    fun testMalloc() {
        val num = 2L
        val size = 8

        run {
            val ptr = malloc(num * size)
            apiLog("Start malloc ~ByteBuffer")
            apiLogMore("capacity: " + ptr.capacity())
            apiLogMore("limit: " + ptr.limit())

            assertNotEquals(NULL, memGetNativeAddress(ptr))
            assertEquals(num * size, ptr.capacity().toLong())
            assertEquals(num * size, ptr.limit().toLong())

            ptr.put(1.toByte())
            ptr.put(10.toByte())

            assertEquals(1, ptr.get(0).toLong())
            assertEquals(10, ptr.get(1).toLong())
            free(ptr)
        }
        run {
            val ptr = nmalloc(num * size)
            apiLog("Start malloc ~uintptr_t")
            apiLogMore("address: " + ptr)

            assertNotEquals(NULL, ptr)

            memPutByte(ptr, 40.toByte())
            memPutByte(ptr + size, 2.toByte())

            assertEquals(40, memGetByte(ptr).toLong())
            assertEquals(2, memGetByte(ptr + size).toLong())
            nfree(ptr)
        }
    }
}