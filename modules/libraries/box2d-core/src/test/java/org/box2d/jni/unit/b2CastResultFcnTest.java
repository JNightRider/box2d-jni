/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2CastResultFcn;
import org.box2d.jni.b2CastResultFcnI;
import org.box2d.jni.b2Pos;
import org.box2d.jni.b2ShapeId;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNIB2;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2CastResultFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unchecked")
public class b2CastResultFcnTest {
    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        try (
                b2ShapeId id0 = b2ShapeId.malloc().index1(10).generation((short) 20);
                b2Pos v0 = b2Pos.nmalloc().set(1f, 2f);
                b2Vec2 v1 = b2Vec2.malloc().set(4f, 6f)
            ) {

            b2CastResultFcnI func = (shapeId, point, normal, fraction, context) -> {
                Debug.apiPrint("b2CastResultFcnI: index1=" + shapeId.index1() + ", generation=" + shapeId.generation());
                Debug.apiPrint("b2CastResultFcnI: x=" + point.x() + ", y=" + point.y());
                Debug.apiPrint("b2CastResultFcnI: x=" + normal.x() + ", y=" + normal.y());
                Debug.apiPrint("b2CastResultFcnI: fraction=" + fraction);
                
                Assert.assertEquals(10, (int) shapeId.index1());
                Assert.assertEquals(20, (short) shapeId.generation());

                Assert.assertEquals(1f, point.x().floatValue(), 0.0f);
                Assert.assertEquals(2f, point.y().floatValue(), 0.0f);
                
                Assert.assertEquals(4f, normal.x(), 0.0f);
                Assert.assertEquals(6f, normal.y(), 0.0f);
                
                Assert.assertEquals(45.5f, fraction, 0.0f);
                Assert.assertEquals(0xFF344FFFl, context);
                return 11.05f;
            };

            float __result = JNIB2.invoke_SHAPEID_POS_VEC2_FPF(id0.address(), v0.address(), v1.address(), 45.5f, 0xFF344FFFl, func.address());
            Assert.assertEquals(11.05f, __result, 0.0f);
        }
        try (
                b2ShapeId id0 = b2ShapeId.malloc().index1(10).generation((short) 20);
                b2Pos v0 = b2Pos.nmalloc().set(1f, 2f);
                b2Vec2 v1 = b2Vec2.malloc().set(4f, 6f)
            ) {

            b2CastResultFcn func = b2CastResultFcn.create((shapeId, point, normal, fraction, context) -> {
                Debug.apiPrint("b2CastResultFcn: index1=" + shapeId.index1() + ", generation=" + shapeId.generation());
                Debug.apiPrint("b2CastResultFcn: x=" + point.x() + ", y=" + point.y());
                Debug.apiPrint("b2CastResultFcn: x=" + normal.x() + ", y=" + normal.y());
                Debug.apiPrint("b2CastResultFcn: fraction=" + fraction);
                
                Assert.assertEquals(10, (int) shapeId.index1());
                Assert.assertEquals(20, (short) shapeId.generation());

                Assert.assertEquals(1f, point.x().floatValue(), 0.0f);
                Assert.assertEquals(2f, point.y().floatValue(), 0.0f);
                
                Assert.assertEquals(4f, normal.x(), 0.0f);
                Assert.assertEquals(6f, normal.y(), 0.0f);
                
                Assert.assertEquals(45.5f, fraction, 0.0f);
                Assert.assertEquals(0xFF344FFFl, context);
                return 11.05f;
            });
            func.byValue(false);
            
            float __result = JNIB2.invoke_SHAPEID_POS_VEC2_FPF(id0.address(), v0.address(), v1.address(), 45.5f, 0xFF344FFFl, func.address());
            Assert.assertEquals(11.05f, __result, 0.0f);
        }
        Callbacks.b2FreeCallbacks();
    }
}
