/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2RestitutionCallback;
import org.box2d.jni.b2RestitutionCallbackI;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNI;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2RestitutionCallback} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2RestitutionCallbackTest {

    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        {
            b2RestitutionCallbackI func = (restitutionA, userMaterialIdA, restitutionB, userMaterialIdB) -> {
                Debug.apiPrint("invoke: b2RestitutionCallbackI(restitutionA=" + restitutionA
                        + ", userMaterialIdA=" + userMaterialIdA
                        + ", restitutionB=" + restitutionB
                        + ", userMaterialIdB=" + userMaterialIdB + ")");
                Assert.assertEquals(1.5f, restitutionA, 0.0f);
                Assert.assertEquals(0X5FCl, userMaterialIdA);
                Assert.assertEquals(5.34f, restitutionB, 0.0f);
                Assert.assertEquals(0X003FFL, userMaterialIdB);
                return 10.5f;
            };
            float __result = JNI.invokeFJFJF(1.5f, 0X5FCl, 5.34f, 0X003FFL, func.functionAddress());
            Assert.assertEquals(10.5f, __result, 0.0f);
        }
        {
            b2RestitutionCallback func = b2RestitutionCallback.create((restitutionA, userMaterialIdA, restitutionB, userMaterialIdB) -> {
                Debug.apiPrint("invoke: b2FrictionCallback(restitutionA=" + restitutionA
                        + ", userMaterialIdA=" + userMaterialIdA
                        + ", restitutionB=" + restitutionB
                        + ", userMaterialIdB=" + userMaterialIdB + ")");
                Assert.assertEquals(1.5f, restitutionA, 0.0f);
                Assert.assertEquals(0X5FCl, userMaterialIdA);
                Assert.assertEquals(5.34f, restitutionB, 0.0f);
                Assert.assertEquals(0X003FFL, userMaterialIdB);
                return 10.5f;
            });
            Assert.assertEquals(b2RestitutionCallback.create(func), func);

            float __result = JNI.invokeFJFJF(1.5f, 0X5FCl, 5.34f, 0X003FFL, func.functionAddress());
            Assert.assertEquals(10.5f, __result, 0.0f);
        }
        Callbacks.b2FreeCallbacks();
    }
}
