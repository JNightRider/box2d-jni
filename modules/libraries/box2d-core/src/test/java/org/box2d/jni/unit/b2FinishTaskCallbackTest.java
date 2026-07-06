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

import org.box2d.jni.b2FinishTaskCallback;
import org.box2d.jni.b2FinishTaskCallbackI;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNI;
import org.box2d.jni.system.Sys;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2FinishTaskCallback} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2FinishTaskCallbackTest {
    static { Sys.BOX2D_NDEBUG.set(true); }

    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        {
            b2FinishTaskCallbackI func = (userTask, userContext) -> {
                Debug.apiPrint("invoke: b2TaskCallbackI(userTask=" + userTask + ", userContext=" + userContext + ")");
                Assert.assertEquals(10l, userTask);
                Assert.assertEquals(20l, userContext);
            };
            JNI.invokePPV(10, 20, func.address());
        }
        {
            b2FinishTaskCallback func = b2FinishTaskCallback.create((userTask, userContext) -> {
                Debug.apiPrint("invoke: b2TaskCallback(userTask=" + userTask + ", userContext=" + userContext + ")");
                Assert.assertEquals(10l, userTask);
                Assert.assertEquals(20l, userContext);
            });
            Assert.assertEquals(b2FinishTaskCallback.create(func), func);
            JNI.invokePPV(10, 20, func.address());
        }
        Callbacks.b2FreeCallbacks();
    }
}
