/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2CustomFilterFcn;
import org.box2d.jni.b2CustomFilterFcnI;
import org.box2d.jni.b2ShapeId;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNIB2;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2CustomFilterFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2CustomFilterFcnTest {

    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        try (
                b2ShapeId id0 = b2ShapeId.malloc().index1(10).generation((short) 20); 
                b2ShapeId id1 = b2ShapeId.malloc().index1(89).generation((short) 35)
            ) {

            b2CustomFilterFcnI func = (shapeIdA, shapeIdB, context) -> {
                Debug.apiPrint("b2CustomFilterFcnI: index1=" + shapeIdA.index1() + ", generation=" + shapeIdA.generation());
                Debug.apiPrint("b2CustomFilterFcnI: index1=" + shapeIdB.index1() + ", generation=" + shapeIdB.generation());

                Assert.assertEquals(10, (int) shapeIdA.index1());
                Assert.assertEquals(20, (short) shapeIdA.generation());

                Assert.assertEquals(89, (int) shapeIdB.index1());
                Assert.assertEquals(35, (short) shapeIdB.generation());

                Assert.assertEquals(0x00373ADCl, context);
                return true;
            };

            boolean __result = JNIB2.invoke_SHAPEID_SHAPEID_PB(id0.address(), id1.address(), 0x00373ADCl, func.address());
            Assert.assertTrue(__result);
        }
        
        try (
                b2ShapeId id0 = b2ShapeId.malloc().index1(10).generation((short) 20); 
                b2ShapeId id1 = b2ShapeId.malloc().index1(89).generation((short) 35)
            ) {

            b2CustomFilterFcn func = b2CustomFilterFcn.create((shapeIdA, shapeIdB, context) -> {
                Debug.apiPrint("b2CustomFilterFcnI: index1=" + shapeIdA.index1() + ", generation=" + shapeIdA.generation());
                Debug.apiPrint("b2CustomFilterFcnI: index1=" + shapeIdB.index1() + ", generation=" + shapeIdB.generation());

                Assert.assertEquals(10, (int) shapeIdA.index1());
                Assert.assertEquals(20, (short) shapeIdA.generation());

                Assert.assertEquals(89, (int) shapeIdB.index1());
                Assert.assertEquals(35, (short) shapeIdB.generation());

                Assert.assertEquals(0x00373ADCl, context);
                return false;
            });

            func.byValue(false);

            boolean __result = JNIB2.invoke_SHAPEID_SHAPEID_PB(id0.address(), id1.address(), 0x00373ADCl, func.address());
            Assert.assertFalse(__result);

        }
        Callbacks.b2FreeCallbacks();
    }
}
