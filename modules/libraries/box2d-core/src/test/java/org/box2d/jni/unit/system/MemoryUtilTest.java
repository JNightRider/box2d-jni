/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.unit.system;

import java.nio.IntBuffer;

import org.box2d.jni.libc.LibCStdlib;
import org.box2d.jni.libc.LibCString;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.Memory;
import org.box2d.jni.system.MemoryUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link MemoryUtil} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class MemoryUtilTest {

    /**
     * Initialize all tests.
     */
    @Test
    public void memUtilTest() {
        {
            long ptr = LibCStdlib.nmalloc(4 * 10);
            LibCString.nmemset(ptr, 0, 4 * 10);

            IntBuffer buffer = MemoryUtil.memIntBuffer(ptr, 10);
            buffer.clear();

            buffer.put(1)
                    .put(30)
                    .put(50);

            buffer.flip();

            Debug.apiPrint("IntBuffer");
            for (int i = 0; i < buffer.remaining(); i++) {
                Debug.apiLogMore("[" + i + "] : " + buffer.get(i));
            }

            Assert.assertEquals(1, buffer.get(0));
            Assert.assertEquals(30, buffer.get(1));
            Assert.assertEquals(50, buffer.get(2));

            Debug.apiPrint("Native: int*");
            for (int i = 0; i < 10; i++) {
                Debug.apiLogMore("[" + i + "] : " + Memory.memGetInt(ptr + 4 * i));
            }

            Assert.assertEquals(1, Memory.memGetInt(ptr));
            Assert.assertEquals(30, Memory.memGetInt(ptr + 4));
            Assert.assertEquals(50, Memory.memGetInt(ptr + 4 * 2));
            MemoryUtil.memFree(buffer);
        }
    }
}
