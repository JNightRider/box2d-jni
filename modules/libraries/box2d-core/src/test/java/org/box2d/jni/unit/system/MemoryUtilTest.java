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
package org.box2d.jni.unit.system;

import java.nio.IntBuffer;

import org.box2d.jni.libc.LibCStdlib;
import org.box2d.jni.libc.LibCString;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.Memory;
import org.box2d.jni.system.MemoryUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link MemoryUtil} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class MemoryUtilTest {

    /**
     * Initialize all tests.
     */
    @Test
    public void memUtilTest() {
        {
            long ptr = LibCStdlib.nmalloc(4 * 10);
            LibCString.nmemset(ptr, 0, 4 * 10);

            IntBuffer buffer = MemoryUtil.memIntBuffer(ptr, 10);
            buffer.clear();

            buffer.put(1)
                    .put(30)
                    .put(50);

            buffer.flip();

            Debug.apiPrint("IntBuffer");
            for (int i = 0; i < buffer.remaining(); i++) {
                Debug.apiLogMore("[" + i + "] : " + buffer.get(i));
            }

            Assert.assertEquals(1, buffer.get(0));
            Assert.assertEquals(30, buffer.get(1));
            Assert.assertEquals(50, buffer.get(2));

            Debug.apiPrint("Native: int*");
            for (int i = 0; i < 10; i++) {
                Debug.apiLogMore("[" + i + "] : " + Memory.memGetInt(ptr + 4 * i));
            }

            Assert.assertEquals(1, Memory.memGetInt(ptr));
            Assert.assertEquals(30, Memory.memGetInt(ptr + 4));
            Assert.assertEquals(50, Memory.memGetInt(ptr + 4 * 2));
            MemoryUtil.memFree(buffer);
        }
        {
            String txtSimple = "Hola | HI > año";
            long chars = MemoryUtil.memMallocUTF(txtSimple);
            Assert.assertNotEquals(0L, chars);

            String recSimple = MemoryUtil.memUTF(chars);
            Assert.assertEquals(txtSimple, recSimple);
            LibCStdlib.nfree(chars);
        }
    }
}
