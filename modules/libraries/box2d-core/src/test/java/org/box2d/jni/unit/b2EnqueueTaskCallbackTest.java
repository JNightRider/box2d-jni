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

import org.box2d.jni.b2EnqueueTaskCallback;
import org.box2d.jni.b2EnqueueTaskCallbackI;
import org.box2d.jni.b2TaskCallback;
import org.box2d.jni.b2TaskCallbackI;

import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNI;
import static org.box2d.jni.system.Pointer.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2EnqueueTaskCallback} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2EnqueueTaskCallbackTest {

    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        {
            b2TaskCallbackI tci = (cxt) -> {
                Debug.apiPrint("invoke: b2TaskCallbackI(" + cxt + ")");
                Assert.assertEquals(0x0044FCL, cxt);
            };

            b2EnqueueTaskCallbackI func = (task, taskContext, userContext) -> {
                Debug.apiPrint("task=" + task + ", taskContext=" + taskContext + ", userContext=" + userContext);

                Assert.assertNotEquals(NULL, task.address());
                Assert.assertEquals(tci.address(), task.address());
                Assert.assertEquals(2, taskContext);
                Assert.assertEquals(3, userContext);
                task.invoke(0x0044FCL);

                return 0x0034fl;
            };

            long __result = JNI.invokePPPP(tci.address(), 2, 3, func.address());
            Assert.assertEquals(0x0034fl, __result);
        }
        {
            b2TaskCallback tc = b2TaskCallback.create((taskContext) -> {
                Debug.apiPrint("invoke: b2TaskCallback(" + taskContext + ")");
                Assert.assertEquals(0x0044FCL, taskContext);
            });

            b2EnqueueTaskCallback func = b2EnqueueTaskCallback.create((task, taskContext, userContext) -> {
                Debug.apiPrint("task=" + task + ", taskContext=" + taskContext + ", userContext=" + userContext);

                Assert.assertNotEquals(NULL, task.address());
                Assert.assertEquals(tc.address(), task.address());
                Assert.assertEquals(2, taskContext);
                Assert.assertEquals(3, userContext);
                task.invoke(0x0044FCL);

                return 0x0034fl;
            });
            Assert.assertEquals(b2EnqueueTaskCallback.create(func), func);

            long __result = JNI.invokePPPP(tc.address(), 2, 3, func.address());
            Assert.assertEquals(0x0034fl, __result);
        }
        Callbacks.b2FreeCallbacks();
    }
}
