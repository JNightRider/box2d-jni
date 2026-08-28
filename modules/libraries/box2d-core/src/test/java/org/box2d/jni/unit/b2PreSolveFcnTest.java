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

import org.box2d.jni.b2Manifold;
import org.box2d.jni.b2ManifoldPoint;
import org.box2d.jni.b2PreSolveFcn;
import org.box2d.jni.b2PreSolveFcnI;
import org.box2d.jni.b2ShapeId;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.ArenaAlloc;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNIB2;
import org.box2d.jni.system.Sys;
import org.box2d.jni.test.util.AssertUtils;
import static org.box2d.jni.system.ArenaAlloc.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2PreSolveFcn} class.
 *
 * @author wil
 * @version 2.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unchecked")
public class b2PreSolveFcnTest {
     static { Sys.BOX2D_NDEBUG.set(true); }

    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        try (ArenaAlloc arena = allocPush()) {
            b2ShapeId a = b2ShapeId.calloc(arena)
                    .generation((short) 23)
                    .index1(50)
                    .world0((short) 100);

            b2ShapeId b = b2ShapeId.calloc(arena)
                    .generation((short) 30)
                    .index1(100)
                    .world0((short) 10);

            b2ManifoldPoint.Buffer points = b2ManifoldPoint.calloc(2, arena);
            points.put(0, b2ManifoldPoint.calloc(arena)
                    .baseSeparation(10.5f));

            b2Manifold m = b2Manifold.calloc(arena)
                    .normal(b2Vec2.calloc(arena).set(1.3f, -5.5f))
                    .pointCount(3)
                    .points(points)
                    .rollingImpulse(-15.678f);

            b2PreSolveFcnI func = (shapeIdA, shapeIdB, manifold, context) -> {
                Debug.apiPrint("b2PreSolveFcnI<>");

                Assert.assertNotEquals(NULL, a.address());
                Assert.assertNotEquals(NULL, b.address());
                AssertUtils.assertEquals(a, shapeIdA);
                AssertUtils.assertEquals(b, shapeIdB);

                Assert.assertNotEquals(NULL, manifold.address());
                Assert.assertEquals(3, manifold.pointCount());
                Assert.assertEquals(-15.678f, manifold.rollingImpulse(), 0.0f);
                AssertUtils.assertEquals(m.normal(), manifold.normal());

                b2ManifoldPoint.Buffer ptr = manifold.points();
                Assert.assertNotEquals(NULL, ptr);

                Assert.assertNotEquals(NULL, ptr.get(0).address());
                Assert.assertEquals(10.5f, ptr.get(0).baseSeparation(), 0.0f);

                Assert.assertEquals(0X04CCFL, context);
            };
            JNIB2.invoke_SHAPEID_SHAPEID_MANIFOLD_PV(a.address(), b.address(), m.address(), 0X04CCFL, func.address());
        }
        try (ArenaAlloc arena = allocPush()) {
            b2ShapeId a = b2ShapeId.calloc(arena)
                    .generation((short) 23)
                    .index1(50)
                    .world0((short) 100);

            b2ShapeId b = b2ShapeId.calloc(arena)
                    .generation((short) 30)
                    .index1(100)
                    .world0((short) 10);

            b2ManifoldPoint.Buffer points = b2ManifoldPoint.calloc(2, arena);
            points.put(0, b2ManifoldPoint.calloc(arena)
                    .baseSeparation(10.5f));

            b2Manifold m = b2Manifold.calloc(arena)
                    .normal(b2Vec2.calloc(arena).set(1.3f, -5.5f))
                    .pointCount(3)
                    .points(points)
                    .rollingImpulse(-15.678f);

            b2PreSolveFcn func = b2PreSolveFcn.create((shapeIdA, shapeIdB, manifold, context) -> {
                Debug.apiPrint("b2PreSolveFcn<>");

                Assert.assertNotEquals(NULL, a.address());
                Assert.assertNotEquals(NULL, b.address());
                AssertUtils.assertEquals(a, shapeIdA);
                AssertUtils.assertEquals(b, shapeIdB);

                Assert.assertNotEquals(NULL, manifold.address());
                Assert.assertEquals(3, manifold.pointCount());
                Assert.assertEquals(-15.678f, manifold.rollingImpulse(), 0.0f);
                AssertUtils.assertEquals(m.normal(), manifold.normal());

                b2ManifoldPoint.Buffer ptr = manifold.points();
                Assert.assertNotEquals(NULL, ptr);

                Assert.assertNotEquals(NULL, ptr.get(0).address());
                Assert.assertEquals(10.5f, ptr.get(0).baseSeparation(), 0.0f);

                Assert.assertEquals(0X04CCFL, context);
            });
            JNIB2.invoke_SHAPEID_SHAPEID_MANIFOLD_PV(a.address(), b.address(), m.address(), 0X04CCFL, func.address());
        }
        Callbacks.b2FreeCallbacks();
    }
}
