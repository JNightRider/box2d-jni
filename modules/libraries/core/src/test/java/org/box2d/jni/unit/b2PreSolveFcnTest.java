/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2PreSolveFcn;
import org.box2d.jni.b2PreSolveFcnI;
import org.box2d.jni.b2ShapeId;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNIB2;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2PreSolveFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2PreSolveFcnTest {
    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        try (
                b2ShapeId id0 = b2ShapeId.malloc().index1(10).generation((short) 20); 
                b2ShapeId id1 = b2ShapeId.malloc().index1(89).generation((short) 35);
                b2Vec2 v0 = b2Vec2.malloc().set(1.05f, 0.5f);
                b2Vec2 v1 = b2Vec2.malloc().set(4.6f, 0.004f)
            ) {

            b2PreSolveFcnI func = (shapeIdA, shapeIdB, point, normal, context) -> {
                Debug.apiPrint("b2CustomFilterFcnI: index1=" + shapeIdA.index1() + ", generation=" + shapeIdA.generation());
                Debug.apiPrint("b2CustomFilterFcnI: index1=" + shapeIdB.index1() + ", generation=" + shapeIdB.generation());
                Debug.apiPrint("b2CustomFilterFcnI: x=" + point.x() + ", y=" + point.y());
                Debug.apiPrint("b2CustomFilterFcnI: x=" + normal.x() + ", y=" + normal.y());

                Assert.assertEquals(10, (int) shapeIdA.index1());
                Assert.assertEquals(20, (short) shapeIdA.generation());

                Assert.assertEquals(89, (int) shapeIdB.index1());
                Assert.assertEquals(35, (short) shapeIdB.generation());
                
                Assert.assertEquals(1.05f, point.x(), 0.0f);
                Assert.assertEquals(0.5f, point.y(), 0.0f);
                
                Assert.assertEquals(4.6f, normal.x(), 0.0f);
                Assert.assertEquals(0.004f, normal.y(), 0.0f);

                Assert.assertEquals(0x0045CBFFL, context);
                return true;
            };
            
            boolean __result = JNIB2.invoke_SHAPEID_SHAPEID_VEC2_VEC2_PB(id0.address(), id1.address(), v0.address(), v1.address(), 0x0045CBFFL, func.address());
            Assert.assertTrue(__result);
        }
        try (
                b2ShapeId id0 = b2ShapeId.malloc().index1(10).generation((short) 20); 
                b2ShapeId id1 = b2ShapeId.malloc().index1(89).generation((short) 35);
                b2Vec2 v0 = b2Vec2.malloc().set(1.05f, 0.5f);
                b2Vec2 v1 = b2Vec2.malloc().set(4.6f, 0.004f)
            ) {

            b2PreSolveFcn func = b2PreSolveFcn.create((shapeIdA, shapeIdB, point, normal, context) -> {
                Debug.apiPrint("b2CustomFilterFcnI: index1=" + shapeIdA.index1() + ", generation=" + shapeIdA.generation());
                Debug.apiPrint("b2CustomFilterFcnI: index1=" + shapeIdB.index1() + ", generation=" + shapeIdB.generation());
                Debug.apiPrint("b2CustomFilterFcnI: x=" + point.x() + ", y=" + point.y());
                Debug.apiPrint("b2CustomFilterFcnI: x=" + normal.x() + ", y=" + normal.y());

                Assert.assertEquals(10, (int) shapeIdA.index1());
                Assert.assertEquals(20, (short) shapeIdA.generation());

                Assert.assertEquals(89, (int) shapeIdB.index1());
                Assert.assertEquals(35, (short) shapeIdB.generation());
                
                Assert.assertEquals(1.05f, point.x(), 0.0f);
                Assert.assertEquals(0.5f, point.y(), 0.0f);
                
                Assert.assertEquals(4.6f, normal.x(), 0.0f);
                Assert.assertEquals(0.004f, normal.y(), 0.0f);

                Assert.assertEquals(0x0045CBFFL, context);
                return false;
            });
            func.byValue(false);
            
            boolean __result = JNIB2.invoke_SHAPEID_SHAPEID_VEC2_VEC2_PB(id0.address(), id1.address(), v0.address(), v1.address(), 0x0045CBFFL, func.address());
            Assert.assertFalse(__result);
        }
        Callbacks.b2FreeCallbacks();
    }
}
