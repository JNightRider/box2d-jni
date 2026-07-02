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

import org.box2d.jni.b2LogFcn;
import org.box2d.jni.b2LogFcnI;
import org.box2d.jni.libc.LibCStdlib;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.JNI;
import org.box2d.jni.system.MemoryUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2LogFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2LogFcnTest {

    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        String str = "Box2d-JNI";
        long buffer = LibCStdlib.nmalloc(20);
        MemoryUtil.memMallocUTF(str, buffer);

        {
            b2LogFcnI func = (message) -> {
                Assert.assertEquals("Box2d-JNI", message);
            };
            JNI.invokePV(buffer, func.address());
        }
        {
            b2LogFcn func = b2LogFcn.create((message) -> {
                Assert.assertEquals("Box2d-JNI", message);
            });
            JNI.invokePV(buffer, func.address());
        }
        LibCStdlib.nfree(buffer);
        Callbacks.b2FreeCallbacks();
    }
}
