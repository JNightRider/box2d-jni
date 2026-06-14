/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2LogFcn;
import org.box2d.jni.b2LogFcnI;
import org.box2d.jni.libc.LibCStdlib;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.JNI;
import org.box2d.jni.system.MemoryUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2LogFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2LogFcnTest {

    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        String str = "Box2d-JNI";
        long buffer = LibCStdlib.nmalloc(20);
        MemoryUtil.memMallocUTF8(str, buffer);

        {
            b2LogFcnI func = (message) -> {
                Assert.assertEquals("Box2d-JNI", message);
            };
            JNI.invokePV(buffer, func.address());
        }
        {
            b2LogFcn func = b2LogFcn.create((message) -> {
                Assert.assertEquals("Box2d-JNI", message);
            });
            JNI.invokePV(buffer, func.address());
        }
        LibCStdlib.nfree(buffer);
        Callbacks.b2FreeCallbacks();
    }
}
