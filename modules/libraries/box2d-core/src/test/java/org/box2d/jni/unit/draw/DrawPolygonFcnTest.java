/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit.draw;

import org.box2d.jni.b2HexColor;
import org.box2d.jni.draw.DrawPolygonFcn;
import org.box2d.jni.draw.DrawPolygonFcnI;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNI;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link DrawPolygonFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class DrawPolygonFcnTest {

    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        try
        (
                b2Vec2.Buffer buffer = b2Vec2.malloc(10);
        ) {
            buffer.put(b2Vec2.malloc().set(1f, 2f));
            buffer.put(b2Vec2.malloc().set((float) -Math.PI, (float) Math.PI));
            buffer.put(b2Vec2.malloc().set(6f, 8f));
            buffer.put(b2Vec2.malloc().set(1.4f, -34.89f));
            buffer.flip();

            DrawPolygonFcnI func = (vertices, vertexCount, color, context) -> {
                Debug.apiPrint("DrawPolygonFcnI: vertices=" + vertices + ", vertexCount=" + vertexCount + ", color=" + color);

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

            JNI.invokePIIPV(buffer.address(), 10, b2HexColor.b2_colorBlue, 0xFFFFl, func.address());
        }
        try
        (
                b2Vec2.Buffer buffer = b2Vec2.malloc(10);
        ) {
            buffer.put(b2Vec2.malloc().set(1f, 2f));
            buffer.put(b2Vec2.malloc().set((float) -Math.PI, (float) Math.PI));
            buffer.put(b2Vec2.malloc().set(6f, 8f));
            buffer.put(b2Vec2.malloc().set(1.4f, -34.89f));
            buffer.flip();

            DrawPolygonFcn func = DrawPolygonFcn.create((vertices, vertexCount, color, context) -> {
                Debug.apiPrint("DrawPolygonFcn: vertices=" + vertices + ", vertexCount=" + vertexCount + ", color=" + color);

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

            JNI.invokePIIPV(buffer.address(), 10, b2HexColor.b2_colorRed, 0xFFFFl, func.address());
        }
        Callbacks.b2FreeCallbacks();
    }
}
