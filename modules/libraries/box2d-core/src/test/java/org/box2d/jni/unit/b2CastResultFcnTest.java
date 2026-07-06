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

import org.box2d.jni.b2CastResultFcn;
import org.box2d.jni.b2CastResultFcnI;
import org.box2d.jni.b2Pos;
import org.box2d.jni.b2ShapeId;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNIB2;
import org.box2d.jni.system.Sys;

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
    static { Sys.BOX2D_NDEBUG.set(true); }

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
