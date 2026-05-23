/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2AssertFcn;
import org.box2d.jni.b2AssertFcnI;
import org.box2d.jni.libc.LibCStdlib;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.JNI;
import org.box2d.jni.system.MemoryUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2AssertFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2AssertFcnTest {

    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        long buffer0 = MemoryUtil.memUTF8("1/0", LibCStdlib.nmalloc(20));
        long buffer1 = MemoryUtil.memUTF8("box2d.jni.log", LibCStdlib.nmalloc(20));

        {
            b2AssertFcnI func = (condition, fileName, lineNumber) -> {
                Assert.assertEquals("1/0", condition);
                Assert.assertEquals("box2d.jni.log", fileName);
                Assert.assertEquals(4, lineNumber);
                return 1;
            };
            int __result = JNI.invokePPII(buffer0, buffer1, 4, func.functionAddress());
            Assert.assertEquals(1, __result);
        }
        {
            b2AssertFcn func = b2AssertFcn.create((condition, fileName, lineNumber) -> {
                Assert.assertEquals("1/0", condition);
                Assert.assertEquals("box2d.jni.log", fileName);
                Assert.assertEquals(4, lineNumber);
                return 1;
            });
            int __result = JNI.invokePPII(buffer0, buffer1, 4, func.functionAddress());
            Assert.assertEquals(1, __result);
        }
        LibCStdlib.nfree(buffer0);
        LibCStdlib.nfree(buffer1);
        Callbacks.b2FreeCallbacks();
    }
}
