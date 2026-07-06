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
package org.box2d.jni.unit.draw;

import org.box2d.jni.b2HexColor;
import org.box2d.jni.b2Pos;
import org.box2d.jni.b2Rot;
import org.box2d.jni.draw.DrawPolygonFcn;
import org.box2d.jni.draw.DrawPolygonFcnI;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.b2WorldTransform;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNIB2;
import org.box2d.jni.system.Sys;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link DrawPolygonFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unchecked")
public class DrawPolygonFcnTest {
    static { Sys.BOX2D_NDEBUG.set(true); }

    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        try (
                b2Vec2.Buffer buffer = b2Vec2.malloc(10);
                b2WorldTransform t = b2WorldTransform.nmalloc().
                set(b2Pos.nmalloc()
                           .set(1f, 2f),
                    b2Rot.malloc()
                           .set(4f, 5f)
                )
            ) {
            buffer.put(b2Vec2.malloc().set(1f, 2f));
            buffer.put(b2Vec2.malloc().set((float) -Math.PI, (float) Math.PI));
            buffer.put(b2Vec2.malloc().set(6f, 8f));
            buffer.put(b2Vec2.malloc().set(1.4f, -34.89f));
            buffer.flip();

            DrawPolygonFcnI func = (transform, vertices, vertexCount, color, context) -> {
                Debug.apiPrint("DrawPolygonFcnI: transform=" + transform + ", vertices=" + vertices + ", vertexCount=" + vertexCount + ", color=" + color);

                Assert.assertEquals(1f, transform.p().x().floatValue(), 0.0f);
                Assert.assertEquals(2f, transform.p().y().floatValue(), 0.0f);
                Assert.assertEquals(4f, transform.q().c(), 0.0f);
                Assert.assertEquals(5f, transform.q().s(), 0.0f);

                Assert.assertEquals(b2HexColor.b2_colorBlue, color);
                Assert.assertEquals(0xFFFFl, context);
                Assert.assertEquals(buffer.address(), vertices);

                b2Vec2.Buffer vrt = b2Vec2.createSafe(vertices, vertexCount * b2Vec2.SIZEOF);

                b2Vec2 v = vrt.get(0);
                Assert.assertEquals(1f, v.x(), 0.0f);
                Assert.assertEquals(2f, v.y(), 0.0f);

                v = vrt.get(1);
                Assert.assertEquals((float) -Math.PI, v.x(), 0.001f);
                Assert.assertEquals((float) Math.PI, v.y(), 0.001f);

                v = vrt.get(2);
                Assert.assertEquals(6f, v.x(), 0.0f);
                Assert.assertEquals(8f, v.y(), 0.0f);

                v = vrt.get(3);
                Assert.assertEquals(1.4f, v.x(), 0.0f);
                Assert.assertEquals(-34.89f, v.y(), 0.0f);
            };

            JNIB2.invoke_WORLDTRANSFORM_PIIPV(t.address(), buffer.address(), 10, b2HexColor.b2_colorBlue, 0xFFFFl, func.address());
        }
        try
        (
            b2Vec2.Buffer buffer = b2Vec2.malloc(10);
            b2WorldTransform t = b2WorldTransform.nmalloc()
                    .set(b2Pos.nmalloc()
                           .set(1f, 2f),
                         b2Rot.malloc()
                                .set(4f, 5f)
                    )
        ) {
            buffer.put(b2Vec2.malloc().set(1f, 2f));
            buffer.put(b2Vec2.malloc().set((float) -Math.PI, (float) Math.PI));
            buffer.put(b2Vec2.malloc().set(6f, 8f));
            buffer.put(b2Vec2.malloc().set(1.4f, -34.89f));
            buffer.flip();

            DrawPolygonFcn func = DrawPolygonFcn.create((transform, vertices, vertexCount, color, context) -> {
                Debug.apiPrint("DrawPolygonFcn: vertices=" + vertices + ", vertexCount=" + vertexCount + ", color=" + color);

                Assert.assertEquals(1f, transform.p().x().floatValue(), 0.0f);
                Assert.assertEquals(2f, transform.p().y().floatValue(), 0.0f);
                Assert.assertEquals(4f, transform.q().c(), 0.0f);
                Assert.assertEquals(5f, transform.q().s(), 0.0f);

                Assert.assertEquals(b2HexColor.b2_colorRed, color);
                Assert.assertEquals(0xFFFFl, context);
                Assert.assertEquals(buffer.address(), vertices);

                b2Vec2.Buffer vrt = b2Vec2.createSafe(vertices, vertexCount * b2Vec2.SIZEOF);

                b2Vec2 v = vrt.get(0);
                Assert.assertEquals(1f, v.x(), 0.0f);
                Assert.assertEquals(2f, v.y(), 0.0f);

                v = vrt.get(1);
                Assert.assertEquals((float) -Math.PI, v.x(), 0.001f);
                Assert.assertEquals((float) Math.PI, v.y(), 0.001f);

                v = vrt.get(2);
                Assert.assertEquals(6f, v.x(), 0.0f);
                Assert.assertEquals(8f, v.y(), 0.0f);

                v = vrt.get(3);
                Assert.assertEquals(1.4f, v.x(), 0.0f);
                Assert.assertEquals(-34.89f, v.y(), 0.0f);
            });
            func.byValue(false);

            JNIB2.invoke_WORLDTRANSFORM_PIIPV(t.address(), buffer.address(), 10, b2HexColor.b2_colorRed, 0xFFFFl, func.address());
        }
        Callbacks.b2FreeCallbacks();
    }
}
