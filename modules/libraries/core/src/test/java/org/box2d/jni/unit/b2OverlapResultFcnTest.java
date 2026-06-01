/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2OverlapResultFcn;
import org.box2d.jni.b2OverlapResultFcnI;
import org.box2d.jni.b2ShapeId;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNIB2;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2OverlapResultFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2OverlapResultFcnTest {
    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        try (
                b2ShapeId id0 = b2ShapeId.malloc().index1(10).generation((short) 20)
            ) {

            b2OverlapResultFcnI func = (shapeId, context) -> {
                Debug.apiPrint("b2OverlapResultFcnI: index1=" + shapeId.index1() + ", generation=" + shapeId.generation());
                Assert.assertEquals(10, (int) shapeId.index1());
                Assert.assertEquals(20, (short) shapeId.generation());

                Assert.assertEquals(0x00ECCFFl, context);
                return true;
            };

            boolean __result = JNIB2.invoke_SHAPEID_PB(id0.address(), 0x00ECCFFl, func.address());
            Assert.assertTrue(__result);
        }
        try (
                b2ShapeId id0 = b2ShapeId.malloc().index1(10).generation((short) 20)
            ) {

            b2OverlapResultFcn func = b2OverlapResultFcn.create((shapeId, context) -> {
                Debug.apiPrint("b2OverlapResultFcn: index1=" + shapeId.index1() + ", generation=" + shapeId.generation());
                Assert.assertEquals(10, (int) shapeId.index1());
                Assert.assertEquals(20, (short) shapeId.generation());

                Assert.assertEquals(0x00ECCFFl, context);
                return false;
            });
            boolean __result = JNIB2.invoke_SHAPEID_PB(id0.address(), 0x00ECCFFl, func.address());
            Assert.assertFalse(__result);
        }
        Callbacks.b2FreeCallbacks();
    }
}
