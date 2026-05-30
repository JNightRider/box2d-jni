/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2TaskCallback;
import org.box2d.jni.b2TaskCallbackI;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNI;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2TaskCallback} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2TaskCallbackTest {
    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        {
            b2TaskCallbackI func = (taskContext) -> {
                Debug.apiPrint("invoke: b2TaskCallbackI(" + taskContext + ")");
                Assert.assertEquals(0x045ffl, taskContext);
            };            
            JNI.invokePV(0x045ffl, func.address());
        }
        {
            b2TaskCallback func = b2TaskCallback.create((taskContext) -> {
                Debug.apiPrint("invoke: b2TaskCallbackI(" + taskContext + ")");
                Assert.assertEquals(0x045ffl, taskContext);
            });
            Assert.assertEquals(b2TaskCallback.create(func), func);
            JNI.invokePV(0x045ffl, func.address());
        }
        Callbacks.b2FreeCallbacks();
    }
}
