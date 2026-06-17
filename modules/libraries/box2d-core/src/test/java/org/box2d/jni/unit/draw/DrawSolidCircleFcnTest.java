/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit.draw;

import org.box2d.jni.b2HexColor;
import org.box2d.jni.b2Rot;
import org.box2d.jni.b2Transform;
import org.box2d.jni.draw.DrawSolidCircleFcn;
import org.box2d.jni.draw.DrawSolidCircleFcnI;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNIB2;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link DrawSolidCircleFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class DrawSolidCircleFcnTest {
    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        try
        (
            b2Vec2 v = b2Vec2.malloc().set(1f, 2f);
            b2Rot r =  b2Rot.malloc().set(4, 6);
            b2Transform t = b2Transform.malloc().set(v, r)
        ) {

            DrawSolidCircleFcnI func = (transform, radius, color, context) -> {
                Debug.apiPrint("DrawSolidCircleFcnI: transform=" + transform + ", radius=" + radius + ", color=" + color + ", context=" + context);
                
                Assert.assertEquals(1f, transform.p().x(), 0.0f);
                Assert.assertEquals(2f, transform.p().y(), 0.0f);
                Assert.assertEquals(4f, transform.q().c(), 0.0f);
                Assert.assertEquals(6f, transform.q().s(), 0.0f);
                
                Assert.assertEquals(b2HexColor.b2_colorBlue, color);
                Assert.assertEquals(1.1f, radius, 0.0f);
                
                Assert.assertEquals(0x0CDDDl, context);
            };
            JNIB2.invoke_TRANSFORM_FIPV(t.address(), 1.1f, b2HexColor.b2_colorBlue, 0x0CDDDl, func.address());
        }
        try
        (
            b2Vec2 v = b2Vec2.malloc().set(1f, 2f);
            b2Rot r =  b2Rot.malloc().set(4, 6);
            b2Transform t = b2Transform.malloc().set(v, r)
        ) {

            DrawSolidCircleFcn func = DrawSolidCircleFcn.create((transform, radius, color, context) -> {
                Debug.apiPrint("DrawSolidCircleFcnI: transform=" + transform + ", radius=" + radius + ", color=" + color + ", context=" + context);
                
                Assert.assertEquals(1f, transform.p().x(), 0.0f);
                Assert.assertEquals(2f, transform.p().y(), 0.0f);
                Assert.assertEquals(4f, transform.q().c(), 0.0f);
                Assert.assertEquals(6f, transform.q().s(), 0.0f);
                
                Assert.assertEquals(b2HexColor.b2_colorBlue, color);
                Assert.assertEquals(1.1f, radius, 0.0f);
                
                Assert.assertEquals(0x0CDDDl, context);
            });
            func.byValue(false);
            JNIB2.invoke_TRANSFORM_FIPV(t.address(), 1.1f, b2HexColor.b2_colorBlue, 0x0CDDDl, func.address());
        }
        Callbacks.b2FreeCallbacks();
    }
}
