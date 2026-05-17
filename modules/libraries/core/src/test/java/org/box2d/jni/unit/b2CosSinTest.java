/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2CosSin;
import static org.box2d.jni.system.Pointer.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2Vec2} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2CosSinTest {
    
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
        try (b2CosSin ptr = b2CosSin.malloc()) {
            Assert.assertNotEquals(NULL, ptr.address());

            ptr.cosine(2);
            ptr.sine(4);

            Assert.assertEquals(2, ptr.cosine(), 0);
            Assert.assertEquals(4, ptr.sine(), 0);
        }
    }

    /**
     * Buffer test for {@code b2Vec2.Buffer} structures
     */
    private void buffer() {
        b2CosSin.Buffer ptr = b2CosSin.malloc(5);
        Assert.assertNotEquals(NULL, ptr.address());
        Assert.assertEquals(5, ptr.remaining());

        {
            try (b2CosSin obj = b2CosSin.malloc()) {
                obj.cosine(2).sine(3);
                ptr.put(obj);
            }
        }
        {
            try (b2CosSin obj = b2CosSin.malloc()) {
                obj.cosine(2).sine(3);
                ptr.put(obj);
            }
        }
        {
            try (b2CosSin obj = b2CosSin.malloc()) {
                obj.cosine(8.0004f).sine(4.5f);
                ptr.put(obj);
            }
        }

        ptr.flip();

        Assert.assertEquals(5, ptr.capacity());
        Assert.assertEquals(3, ptr.remaining());

        {
            try (b2CosSin obj = ptr.get(0)) {
                Assert.assertEquals(2f, obj.cosine(), 0.0f);
                Assert.assertEquals(3f, obj.sine(), 0.0f);
            }
        }
        {
            try (b2CosSin obj = ptr.get(1)) {
                Assert.assertEquals(2f, obj.cosine(), 0.0f);
                Assert.assertEquals(3f, obj.sine(), 0.0f);
            }
        }
        {
            try (b2CosSin obj = ptr.get(2)) {
                Assert.assertEquals(8.0004f, obj.cosine(), 0.0f);
                Assert.assertEquals(4.5f, obj.sine(), 0.0f);
            }
        }
        ptr.free();
    }
}
