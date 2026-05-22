/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2AllocFcn;
import org.box2d.jni.b2AllocFcnI;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.JNI;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2AllocFcnTest} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2AllocFcnTest {
    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        {
            b2AllocFcnI alloc = (size, alignment) ->  {
                Assert.assertEquals(10L, size);
                Assert.assertEquals(2, alignment);
                return 1024L;
            };
            long mem = JNI.invokeJIP(10L, 2, alloc.functionAddress());
            Assert.assertEquals(1024L, mem);
        }
        {
            b2AllocFcn alloc = b2AllocFcn.create((size, alignment) -> {
                Assert.assertEquals(10L, size);
                Assert.assertEquals(2, alignment);
                return 500L;
            });
            long mem = JNI.invokeJIP(10L, 2, alloc.functionAddress());
            Assert.assertEquals(500L, mem);
        }
        Callbacks.b2FreeCallbacks();
    }
}
