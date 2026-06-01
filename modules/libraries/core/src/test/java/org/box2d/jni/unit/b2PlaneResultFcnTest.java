/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2PlaneResultFcn;
import org.box2d.jni.b2PlaneResultFcnI;
import org.box2d.jni.b2ShapeId;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNIB2;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2PlaneResultFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2PlaneResultFcnTest {
    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        try (
                b2ShapeId id0 = b2ShapeId.malloc().index1(10).generation((short) 20)
            ) {

            b2PlaneResultFcnI func = (shapeId, plane, context) -> {
                Debug.apiPrint("b2OverlapResultFcnI: index1=" + shapeId.index1() + ", generation=" + shapeId.generation());
                Assert.assertEquals(10, (int) shapeId.index1());
                Assert.assertEquals(20, (short) shapeId.generation());

                Assert.assertEquals(0xFFFFL, plane.address());
                Assert.assertEquals(0X234CCCCL, context);
                return true;
            };

            boolean __result = JNIB2.invoke_SHAPEID_PPB(id0.address(), 0xFFFFL, 0X234CCCCL, func.address());
            Assert.assertTrue(__result);
        }
        try (
                b2ShapeId id0 = b2ShapeId.malloc().index1(10).generation((short) 20)
            ) {

            b2PlaneResultFcn func = b2PlaneResultFcn.create((shapeId, plane, context) -> {
                Debug.apiPrint("b2OverlapResultFcn: index1=" + shapeId.index1() + ", generation=" + shapeId.generation());
                Assert.assertEquals(10, (int) shapeId.index1());
                Assert.assertEquals(20, (short) shapeId.generation());

                Assert.assertEquals(0xFFFFL, plane.address());
                Assert.assertEquals(0X234CCCCL, context);
                return false;
            });

            boolean __result = JNIB2.invoke_SHAPEID_PPB(id0.address(), 0xFFFFL, 0X234CCCCL, func.address());
            Assert.assertFalse(__result);
        }
        Callbacks.b2FreeCallbacks();
    }
}
