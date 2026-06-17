/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit.draw;

import org.box2d.jni.b2HexColor;
import org.box2d.jni.draw.DrawStringFcn;
import org.box2d.jni.draw.DrawStringFcnI;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.libc.LibCStdlib;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNIB2;
import org.box2d.jni.system.MemoryUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link DrawStringFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class DrawStringFcnTest {
    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        long nmem = LibCStdlib.nmalloc(120);
        String str = "JNI_B2";
        try
        (
                b2Vec2 v = b2Vec2.malloc().set(1f, 2f)
        ) {

            DrawStringFcnI func = (p, s, color, context) -> {
                Debug.apiPrint("DrawStringFcnI: p=" + p.x() + ", " + p.y() + ", s=" + s + ", color=" + color);
                Assert.assertEquals(b2HexColor.b2_colorBlue, color);
                Assert.assertEquals("JNI_B2", MemoryUtil.memGetStringUTF8(s));
                
                Assert.assertEquals(0xDDDEEEl, context);
                
                Assert.assertEquals(1f, p.x(), 0.0f);
                Assert.assertEquals(2f, p.y(), 0.0f);
            };
            JNIB2.invoke_VEC2_PIPV(v.address(), MemoryUtil.memMallocUTF8(str, nmem), b2HexColor.b2_colorBlue, 0xDDDEEEl, func.address());
        }
        try
        (
                b2Vec2 v = b2Vec2.malloc().set(1f, 2f)
        ) {

            DrawStringFcn func = DrawStringFcn.create((p, s, color, context) -> {
                Debug.apiPrint("DrawStringFcnI: p=" + p.x() + ", " + p.y() + ", s=" + s + ", color=" + color);
                Assert.assertEquals(b2HexColor.b2_colorBlue, color);
                Assert.assertEquals("JNI_B2", MemoryUtil.memGetStringUTF8(s));
                
                Assert.assertEquals(0xDDDEEEl, context);
                
                Assert.assertEquals(1f, p.x(), 0.0f);
                Assert.assertEquals(2f, p.y(), 0.0f);
            });
            JNIB2.invoke_VEC2_PIPV(v.address(), MemoryUtil.memMallocUTF8(str, nmem), b2HexColor.b2_colorBlue, 0xDDDEEEl, func.address());
        }
        LibCStdlib.nfree(nmem);
        Callbacks.b2FreeCallbacks();
    }
}
