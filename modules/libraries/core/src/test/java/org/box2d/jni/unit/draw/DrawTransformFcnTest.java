/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit.draw;

import org.box2d.jni.b2HexColor;
import org.box2d.jni.b2Rot;
import org.box2d.jni.b2Transform;
import org.box2d.jni.draw.DrawTransformFcn;
import org.box2d.jni.draw.DrawTransformFcnI;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNIB2;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link DrawTransformFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class DrawTransformFcnTest {
    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        try
        (
            b2Vec2 v = b2Vec2.malloc().set(1, 2);
            b2Rot r =  b2Rot.malloc().set(4, 6);
            b2Transform t = b2Transform.malloc().set(v, r)
        ) {

            DrawTransformFcnI func = (transform, context) -> {
                Debug.apiPrint("DrawTransformFcnI: transform=" + transform + ", context=" + context);
                Assert.assertEquals(1f, transform.p().x(), 0.0f);
                Assert.assertEquals(2f, transform.p().y(), 0.0f);
                Assert.assertEquals(4f, transform.q().c(), 0.0f);
                Assert.assertEquals(6f, transform.q().s(), 0.0f);                
                Assert.assertEquals(0x0ddccc, context);
            };
            JNIB2.invoke_TRANSFORM_PV(t.address(), 0x0ddccc, func.address());
        }
        try
        (
            b2Vec2 v = b2Vec2.malloc().set(1, 2);
            b2Rot r =  b2Rot.malloc().set(4, 6);
            b2Transform t = b2Transform.malloc().set(v, r)
        ) {

            DrawTransformFcn func = DrawTransformFcn.create((transform, context) -> {
                Debug.apiPrint("DrawTransformFcn: transform=" + transform + ", context=" + context);
                Assert.assertEquals(1f, transform.p().x(), 0.0f);
                Assert.assertEquals(2f, transform.p().y(), 0.0f);
                Assert.assertEquals(4f, transform.q().c(), 0.0f);
                Assert.assertEquals(6f, transform.q().s(), 0.0f);                
                Assert.assertEquals(0x0ddccc, context);
            });
            func.byValue(false);
            JNIB2.invoke_TRANSFORM_PV(t.address(), 0x0ddccc, func.address());
        }
        Callbacks.b2FreeCallbacks();
    }
}
