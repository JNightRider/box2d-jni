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
import org.box2d.jni.b2Rot;
import org.box2d.jni.b2Transform;
import org.box2d.jni.draw.DrawSolidPolygonFcn;
import org.box2d.jni.draw.DrawSolidPolygonFcnI;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.b2WorldTransform;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNIB2;
import org.box2d.jni.system.Sys;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link DrawSolidPolygonFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unchecked")
public class DrawSolidPolygonFcnTest {
    static { Sys.BOX2D_NDEBUG.set(true); }

    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        try
        (
            b2Vec2.Buffer buffer = b2Vec2.malloc(10);
            b2Vec2 v = b2Vec2.malloc().set(1f, 2f);
            b2Rot r =  b2Rot.malloc().set(4, 6);
            b2WorldTransform t = b2WorldTransform.nmalloc().set(v, r)
        ) {
            buffer.put(b2Vec2.malloc().set(1f, 2f));
            buffer.put(b2Vec2.malloc().set(-0.5f, -3.5f));
            buffer.put(b2Vec2.malloc().set(6f, 8f));
            buffer.put(b2Vec2.malloc().set(1.4f, -34.89f));
            buffer.flip();
            System.out.println("t: " + t.getClass());
            DrawSolidPolygonFcnI func = (transform, vertices, vertexCount, radius, color, context) -> {
                Debug.apiPrint("DrawSolidPolygonFcnI: transform=" + transform + ", vertices=" + vertices + "vertexCount=" + vertexCount + ", radius=" + radius + ", color=" + color + ", context=" + context);

                Assert.assertEquals(10.5f, radius, 0.0f);
                Assert.assertEquals(10, vertexCount);
                Assert.assertEquals(b2HexColor.b2_colorGreen, color);
                Assert.assertEquals(0xFFFFl, context);
                Assert.assertEquals(buffer.address(), vertices);
                
                Assert.assertEquals(1f, transform.p().x().floatValue(), 0.0f);
                Assert.assertEquals(2f, transform.p().y().floatValue(), 0.0f);
                Assert.assertEquals(4f, transform.q().c(), 0.0f);
                Assert.assertEquals(6f, transform.q().s(), 0.0f);

                b2Vec2.Buffer vrt = b2Vec2.createSafe(vertices, vertexCount * b2Vec2.SIZEOF);

                b2Vec2 vb = vrt.get(0);
                Assert.assertEquals(1f, vb.x(), 0.0f);
                Assert.assertEquals(2f, vb.y(), 0.0f);

                vb = vrt.get(1);
                Assert.assertEquals(-0.5f, vb.x(), 0.0f);
                Assert.assertEquals(-3.5f, vb.y(), 0.0);

                vb = vrt.get(2);
                Assert.assertEquals(6f, vb.x(), 0.0f);
                Assert.assertEquals(8f, vb.y(), 0.0f);

                vb = vrt.get(3);
                Assert.assertEquals(1.4f, vb.x(), 0.0f);
                Assert.assertEquals(-34.89f, vb.y(), 0.0f);
            };

            JNIB2.invoke_WORLDTRANSFORM_PIFIPV(t.address(), buffer.address(), 10, 10.5f, b2HexColor.b2_colorGreen, 0xFFFFl, func.address());
        }
        try
        (
            b2Vec2.Buffer buffer = b2Vec2.malloc(10);
            b2Vec2 v = b2Vec2.malloc().set(1f, 2f);
            b2Rot r =  b2Rot.malloc().set(4, 6);
            b2Transform t = b2Transform.malloc().set(v, r)
        ) {
            buffer.put(b2Vec2.malloc().set(1f, 2f));
            buffer.put(b2Vec2.malloc().set(-0.5f, -3.5f));
            buffer.put(b2Vec2.malloc().set(6f, 8f));
            buffer.put(b2Vec2.malloc().set(1.4f, -34.89f));
            buffer.flip();

            DrawSolidPolygonFcn func = DrawSolidPolygonFcn.create((transform, vertices, vertexCount, radius, color, context) -> {
                Debug.apiPrint("DrawSolidPolygonFcn: transform=" + transform + ", vertices=" + vertices + "vertexCount=" + vertexCount + ", radius=" + radius + ", color=" + color + ", context=" + context);

                Assert.assertEquals(10.5f, radius, 0.0f);
                Assert.assertEquals(10, vertexCount);
                Assert.assertEquals(b2HexColor.b2_colorGreen, color);
                Assert.assertEquals(0xFFFFl, context);
                Assert.assertEquals(buffer.address(), vertices);

                System.out.println(transform.p().x().floatValue() + ", " + transform.p().y().floatValue());
                Assert.assertEquals(1f, transform.p().x().floatValue(), 0.0f);
                Assert.assertEquals(2f, transform.p().y().floatValue(), 0.0f);
                Assert.assertEquals(4f, transform.q().c(), 0.0f);
                Assert.assertEquals(6f, transform.q().s(), 0.0f);
                
                b2Vec2.Buffer vrt = b2Vec2.createSafe(vertices, vertexCount * b2Vec2.SIZEOF);

                b2Vec2 vb = vrt.get(0);
                Assert.assertEquals(1f, vb.x(), 0.0f);
                Assert.assertEquals(2f, vb.y(), 0.0f);

                vb = vrt.get(1);
                Assert.assertEquals(-0.5f, vb.x(), 0.0f);
                Assert.assertEquals(-3.5f, vb.y(), 0.0);

                vb = vrt.get(2);
                Assert.assertEquals(6f, vb.x(), 0.0f);
                Assert.assertEquals(8f, vb.y(), 0.0f);

                vb = vrt.get(3);
                Assert.assertEquals(1.4f, vb.x(), 0.0f);
                Assert.assertEquals(-34.89f, vb.y(), 0.0f);
            });
            func.byValue(false);

            JNIB2.invoke_WORLDTRANSFORM_PIFIPV(t.address(), buffer.address(), 10, 10.5f, b2HexColor.b2_colorGreen, 0xFFFFl, func.address());
        }
        Callbacks.b2FreeCallbacks();
    }
}
