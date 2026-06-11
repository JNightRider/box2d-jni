/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit.draw;

import org.box2d.jni.b2HexColor;
import org.box2d.jni.draw.DrawPointFcn;
import org.box2d.jni.draw.DrawPointFcnI;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNIB2;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link DrawPointFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class DrawPointFcnTest {
    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        try
        (
                b2Vec2 v = b2Vec2.malloc().set(1, 2)
        ) {

            DrawPointFcnI func = (p, size, color, context) -> {
                Debug.apiPrint("DrawPointFcn: p=" + p.x() + ", " + p.y() + ", size=" + size + ", color=" + color);
                Assert.assertEquals(b2HexColor.b2_colorBlue, color);
                Assert.assertEquals(1.1f, size, 0.0f);
                
                Assert.assertEquals(0x00cccff, context);
                
                Assert.assertEquals(1f, p.x(), 0.0f);
                Assert.assertEquals(2f, p.y(), 0.0f);
            };
            JNIB2.invoke_VEC2_FIPV(v.address(), 1.1f, b2HexColor.b2_colorBlue, 0x00cccff, func.address());
        }
        try
        (
                b2Vec2 v = b2Vec2.malloc().set(1, 2)
        ) {

            DrawPointFcn func = DrawPointFcn.create((p, size, color, context) -> {
                Debug.apiPrint("DrawPointFc: p=" + p.x() + ", " + p.y() + ", size=" + size + ", color=" + color);
                Assert.assertEquals(b2HexColor.b2_colorBlue, color);
                Assert.assertEquals(1.1f, size, 0.0f);
                
                Assert.assertEquals(0x00cccff, context);
                
                Assert.assertEquals(1f, p.x(), 0.0f);
                Assert.assertEquals(2f, p.y(), 0.0f);
            });
            JNIB2.invoke_VEC2_FIPV(v.address(), 1.1f, b2HexColor.b2_colorBlue, 0x00cccff, func.address());
        }
        Callbacks.b2FreeCallbacks();
    }
}
