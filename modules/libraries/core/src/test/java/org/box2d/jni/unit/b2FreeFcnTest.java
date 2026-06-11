/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2FreeFcn;
import org.box2d.jni.b2FreeFcnI;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.JNI;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2FreeFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2FreeFcnTest {
    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        {
            b2FreeFcnI func = (mem, size) -> {
                Assert.assertEquals(1024L, mem);
                Assert.assertEquals(6L, size);
            };
            JNI.invokeJJV(1024L, 6L, func.address());
        }
        {
            b2FreeFcn func = b2FreeFcn.create((mem, size) -> {
                Assert.assertEquals(1024L, mem);
                Assert.assertEquals(6L, size);
            });
            JNI.invokeJJV(1024L, 6L, func.address());
        }
        Callbacks.b2FreeCallbacks();
    }
}
