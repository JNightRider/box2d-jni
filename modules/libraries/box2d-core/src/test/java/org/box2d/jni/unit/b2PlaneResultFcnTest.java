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

import org.box2d.jni.b2PlaneResultFcn;
import org.box2d.jni.b2PlaneResultFcnI;
import org.box2d.jni.b2ShapeId;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNIB2;
import org.box2d.jni.system.Sys;

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
    static { Sys.BOX2D_NDEBUG.set(true); }

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
