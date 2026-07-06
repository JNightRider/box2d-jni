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
package org.box2d.jni.unit;

import org.box2d.jni.b2AssertFcn;
import org.box2d.jni.b2AssertFcnI;
import org.box2d.jni.libc.LibCStdlib;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.JNI;
import org.box2d.jni.system.MemoryUtil;
import org.box2d.jni.system.Sys;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2AssertFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2AssertFcnTest {
    static { Sys.BOX2D_NDEBUG.set(true); }

    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        long buffer0 = MemoryUtil.memMallocUTF("1/0", LibCStdlib.nmalloc(20));
        long buffer1 = MemoryUtil.memMallocUTF("box2d.jni.log", LibCStdlib.nmalloc(20));

        {
            b2AssertFcnI func = (condition, fileName, lineNumber) -> {
                Assert.assertEquals("1/0", condition);
                Assert.assertEquals("box2d.jni.log", fileName);
                Assert.assertEquals(4, lineNumber);
                return 1;
            };
            int __result = JNI.invokePPII(buffer0, buffer1, 4, func.address());
            Assert.assertEquals(1, __result);
        }
        {
            b2AssertFcn func = b2AssertFcn.create((condition, fileName, lineNumber) -> {
                Assert.assertEquals("1/0", condition);
                Assert.assertEquals("box2d.jni.log", fileName);
                Assert.assertEquals(4, lineNumber);
                return 1;
            });
            int __result = JNI.invokePPII(buffer0, buffer1, 4, func.address());
            Assert.assertEquals(1, __result);
        }
        LibCStdlib.nfree(buffer0);
        LibCStdlib.nfree(buffer1);
        Callbacks.b2FreeCallbacks();
    }
}
