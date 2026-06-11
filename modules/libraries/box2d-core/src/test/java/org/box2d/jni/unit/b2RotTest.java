/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2Rot;
import static org.box2d.jni.system.Pointer.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2Rot} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2RotTest {
    
    /**
     * Initialize all tests.
     */
    @Test
    public void __constructor() {
        struct();
        buffer();
    }

    /**
     * Test the properties of the structure.
     */
    private void struct() {
        try (b2Rot ptr = b2Rot.malloc()) {
            Assert.assertNotEquals(NULL, ptr.address());

            ptr.c(2);
            ptr.s(4);

            Assert.assertEquals(2, ptr.c(), 0);
            Assert.assertEquals(4, ptr.s(), 0);
        }
    }

    /**
     * Buffer test for {@code Buffer} structures
     */
    private void buffer() {
        b2Rot.Buffer ptr = b2Rot.malloc(5);
        Assert.assertNotEquals(NULL, ptr.address());
        Assert.assertEquals(5, ptr.remaining());

        {
            try (b2Rot obj = b2Rot.malloc()) {
                obj.c(2).s(3);
                ptr.put(obj);
            }
        }
        {
            try (b2Rot obj = b2Rot.malloc()) {
                obj.c(2).s(3);
                ptr.put(obj);
            }
        }
        {
            try (b2Rot obj = b2Rot.malloc()) {
                obj.c(8.0004f).s(4.5f);
                ptr.put(obj);
            }
        }

        ptr.flip();

        Assert.assertEquals(5, ptr.capacity());
        Assert.assertEquals(3, ptr.remaining());

        {
            try (b2Rot obj = ptr.get(0)) {
                Assert.assertEquals(2f, obj.c(), 0.0f);
                Assert.assertEquals(3f, obj.s(), 0.0f);
            }
        }
        {
            try (b2Rot obj = ptr.get(1)) {
                Assert.assertEquals(2f, obj.c(), 0.0f);
                Assert.assertEquals(3f, obj.s(), 0.0f);
            }
        }
        {
            try (b2Rot obj = ptr.get(2)) {
                Assert.assertEquals(8.0004f, obj.c(), 0.0f);
                Assert.assertEquals(4.5f, obj.s(), 0.0f);
            }
        }
        ptr.free();
    }
}
