/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2FrictionCallback;
import org.box2d.jni.b2FrictionCallbackI;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNI;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2FrictionCallback} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2FrictionCallbackTest {

    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        {
            b2FrictionCallbackI func = (frictionA, userMaterialIdA, frictionB, userMaterialIdB) -> {
                Debug.apiPrint("invoke: b2FrictionCallbackI(frictionA=" + frictionA
                        + ", userMaterialIdA=" + userMaterialIdA
                        + ", frictionB=" + frictionB
                        + ", userMaterialIdB=" + userMaterialIdB + ")");
                Assert.assertEquals(1.5f, frictionA, 0.0f);
                Assert.assertEquals(0X5FCl, userMaterialIdA);
                Assert.assertEquals(5.34f, frictionB, 0.0f);
                Assert.assertEquals(0X003FFL, userMaterialIdB);
                return 10.5f;
            };
            float __result = JNI.invokeFJFJF(1.5f, 0X5FCl, 5.34f, 0X003FFL, func.address());
            Assert.assertEquals(10.5f, __result, 0.0f);
        }
        {
            b2FrictionCallback func = b2FrictionCallback.create((frictionA, userMaterialIdA, frictionB, userMaterialIdB) -> {
                Debug.apiPrint("invoke: b2FrictionCallback(frictionA=" + frictionA
                        + ", userMaterialIdA=" + userMaterialIdA
                        + ", frictionB=" + frictionB
                        + ", userMaterialIdB=" + userMaterialIdB + ")");
                Assert.assertEquals(1.5f, frictionA, 0.0f);
                Assert.assertEquals(0X5FCl, userMaterialIdA);
                Assert.assertEquals(5.34f, frictionB, 0.0f);
                Assert.assertEquals(0X003FFL, userMaterialIdB);
                return 10.5f;
            });
            Assert.assertEquals(b2FrictionCallback.create(func), func);

            float __result = JNI.invokeFJFJF(1.5f, 0X5FCl, 5.34f, 0X003FFL, func.address());
            Assert.assertEquals(10.5f, __result, 0.0f);
        }
        Callbacks.b2FreeCallbacks();
    }
}
