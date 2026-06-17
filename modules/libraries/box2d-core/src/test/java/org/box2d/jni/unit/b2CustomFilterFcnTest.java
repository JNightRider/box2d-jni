/*
BSD 3-Clause License

Copyright (c) 2026, Night Rider

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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
