/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit.draw;

import org.box2d.jni.b2HexColor;
import org.box2d.jni.b2Rot;
import org.box2d.jni.b2Transform;
import org.box2d.jni.draw.DrawSolidPolygonFcn;
import org.box2d.jni.draw.DrawSolidPolygonFcnI;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNIB2;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link DrawSolidPolygonFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class DrawSolidPolygonFcnTest {
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
            b2Transform t = b2Transform.malloc().set(v, r)
        ) {
            buffer.put(b2Vec2.malloc().set(1f, 2f));
            buffer.put(b2Vec2.malloc().set(-0.5f, -3.5f));
            buffer.put(b2Vec2.malloc().set(6f, 8f));
            buffer.put(b2Vec2.malloc().set(1.4f, -34.89f));
            buffer.flip();

            DrawSolidPolygonFcnI func = (transform, vertices, vertexCount, radius, color, context) -> {
                Debug.apiPrint("DrawSolidPolygonFcnI: transform=" + transform + ", vertices=" + vertices + "vertexCount=" + vertexCount + ", radius=" + radius + ", color=" + color + ", context=" + context);

                Assert.assertEquals(10.5f, radius, 0.0f);
                Assert.assertEquals(10, vertexCount);
                Assert.assertEquals(b2HexColor.b2_colorGreen, color);
                Assert.assertEquals(0xFFFFl, context);
                Assert.assertEquals(buffer.address(), vertices);
                
                Assert.assertEquals(1f, transform.p().x(), 0.0f);
                Assert.assertEquals(2f, transform.p().y(), 0.0f);
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

            JNIB2.invoke_TRANSFORM_PIFIPV(t.address(), buffer.address(), 10, 10.5f, b2HexColor.b2_colorGreen, 0xFFFFl, func.address());
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

                Assert.assertEquals(1f, transform.p().x(), 0.0f);
                Assert.assertEquals(2f, transform.p().y(), 0.0f);
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

            JNIB2.invoke_TRANSFORM_PIFIPV(t.address(), buffer.address(), 10, 10.5f, b2HexColor.b2_colorGreen, 0xFFFFl, func.address());
        }
        Callbacks.b2FreeCallbacks();
    }
}
