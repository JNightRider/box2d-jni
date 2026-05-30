/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2FinishTaskCallback;
import org.box2d.jni.b2FinishTaskCallbackI;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNI;

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
