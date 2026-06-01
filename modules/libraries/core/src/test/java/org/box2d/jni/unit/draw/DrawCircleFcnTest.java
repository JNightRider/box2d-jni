/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit.draw;

import org.box2d.jni.b2HexColor;
import org.box2d.jni.draw.DrawCircleFcn;
import org.box2d.jni.draw.DrawCircleFcnI;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNIB2;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link DrawCircleFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class DrawCircleFcnTest {
    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        try
        (
                b2Vec2 v = b2Vec2.malloc().set(1, 2)
        ) {

            DrawCircleFcnI func = (center, radius, color, context) -> {
                Debug.apiPrint("DrawCircleFcnI: center=" + center.x() + ", " + center.y() + ", radius=" + radius + ", color=" + color);
                Assert.assertEquals(b2HexColor.b2_colorRed, color);
                Assert.assertEquals(10.5f, radius, 0.0f);
                
                Assert.assertEquals(0x00fffl, context);
                
                Assert.assertEquals(1f, center.x(), 0.0f);
                Assert.assertEquals(2f, center.y(), 0.0f);
            };
            JNIB2.invoke_VEC2_FIPV(v.address(), 10.5f, b2HexColor.b2_colorRed, 0x00fffl, func.address());
        }
        try
        (
                b2Vec2 v = b2Vec2.malloc().set(1, 2)
        ) {

            DrawCircleFcn func = DrawCircleFcn.create((center, radius, color, context) -> {
                Debug.apiPrint("DrawCircleFcnI: center=" + center.x() + ", " + center.y() + ", radius=" + radius + ", color=" + color);
                Assert.assertEquals(b2HexColor.b2_colorRed, color);
                Assert.assertEquals(10.5f, radius, 0.0f);
                
                Assert.assertEquals(0x00fffl, context);
                
                Assert.assertEquals(1f, center.x(), 0.0f);
                Assert.assertEquals(2f, center.y(), 0.0f);
            });
            func.byValue(false);
            JNIB2.invoke_VEC2_FIPV(v.address(), 10.5f, b2HexColor.b2_colorRed, 0x00fffl, func.address());
        }
        Callbacks.b2FreeCallbacks();
    }
}
