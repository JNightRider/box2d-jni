/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
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

                Assert.assertNotEquals(NULL, task.functionAddress());
                Assert.assertEquals(tci.functionAddress(), task.functionAddress());
                Assert.assertEquals(2, taskContext);
                Assert.assertEquals(3, userContext);
                task.invoke(0x0044FCL);

                return 0x0034fl;
            };

            long __result = JNI.invokePPPP(tci.functionAddress(), 2, 3, func.functionAddress());
            Assert.assertEquals(0x0034fl, __result);
        }
        {
            b2TaskCallback tc = b2TaskCallback.create((taskContext) -> {
                Debug.apiPrint("invoke: b2TaskCallback(" + taskContext + ")");
                Assert.assertEquals(0x0044FCL, taskContext);
            });

            b2EnqueueTaskCallback func = b2EnqueueTaskCallback.create((task, taskContext, userContext) -> {
                Debug.apiPrint("task=" + task + ", taskContext=" + taskContext + ", userContext=" + userContext);

                Assert.assertNotEquals(NULL, task.functionAddress());
                Assert.assertEquals(tc.functionAddress(), task.functionAddress());
                Assert.assertEquals(2, taskContext);
                Assert.assertEquals(3, userContext);
                task.invoke(0x0044FCL);

                return 0x0034fl;
            });
            Assert.assertEquals(b2EnqueueTaskCallback.create(func), func);

            long __result = JNI.invokePPPP(tc.functionAddress(), 2, 3, func.functionAddress());
            Assert.assertEquals(0x0034fl, __result);
        }
        Callbacks.b2FreeCallbacks();
    }
}
