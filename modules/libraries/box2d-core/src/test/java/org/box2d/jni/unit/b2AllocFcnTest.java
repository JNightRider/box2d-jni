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

import org.box2d.jni.b2AllocFcn;
import org.box2d.jni.b2AllocFcnI;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.JNI;
import org.box2d.jni.system.Sys;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2AllocFcnTest} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2AllocFcnTest {
    static { Sys.BOX2D_NDEBUG.set(true); }
    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        {
            b2AllocFcnI alloc = (size, alignment) ->  {
                Assert.assertEquals(10L, size);
                Assert.assertEquals(2, alignment);
                return 1024L;
            };
            long mem = JNI.invokeJIP(10L, 2, alloc.address());
            Assert.assertEquals(1024L, mem);
        }
        {
            b2AllocFcn alloc = b2AllocFcn.create((size, alignment) -> {
                Assert.assertEquals(10L, size);
                Assert.assertEquals(2, alignment);
                return 500L;
            });
            long mem = JNI.invokeJIP(10L, 2, alloc.address());
            Assert.assertEquals(500L, mem);
        }
        Callbacks.b2FreeCallbacks();
    }
}
