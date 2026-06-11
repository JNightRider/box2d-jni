/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2Capacity;

import static org.box2d.jni.system.Pointer.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2Capacity} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2CapacityTest {

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
        try (b2Capacity ptr = b2Capacity.malloc()) {
            Assert.assertNotEquals(NULL, ptr.address());

            ptr.staticShapeCount(10);
            ptr.dynamicShapeCount(20);
            ptr.staticBodyCount(30);
            ptr.dynamicBodyCount(40);
            ptr.contactCount(50);

            Assert.assertEquals(10, ptr.staticShapeCount());
            Assert.assertEquals(20, ptr.dynamicShapeCount());
            Assert.assertEquals(30, ptr.staticBodyCount());
            Assert.assertEquals(40, ptr.dynamicBodyCount());
            Assert.assertEquals(50, ptr.contactCount());
        }
    }

    /**
     * Buffer test for {@code Buffer} structures.
     */
    private void buffer() {
        b2Capacity.Buffer ptr = b2Capacity.malloc(5);

        Assert.assertNotEquals(NULL, ptr.address());
        Assert.assertEquals(5, ptr.remaining());

        {
            try (b2Capacity obj = b2Capacity.malloc()) {
                obj.staticShapeCount(1)
                   .dynamicShapeCount(2)
                   .staticBodyCount(3)
                   .dynamicBodyCount(4)
                   .contactCount(5);
                ptr.put(obj);
            }

            try (b2Capacity obj = b2Capacity.malloc()) {
                obj.staticShapeCount(10)
                   .dynamicShapeCount(20)
                   .staticBodyCount(30)
                   .dynamicBodyCount(40)
                   .contactCount(50);
                ptr.put(obj);
            }

            try (b2Capacity obj = b2Capacity.malloc()) {
                obj.staticShapeCount(100)
                   .dynamicShapeCount(200)
                   .staticBodyCount(300)
                   .dynamicBodyCount(400)
                   .contactCount(500);
                ptr.put(obj);
            }
        }

        ptr.flip();

        Assert.assertEquals(5, ptr.capacity());
        Assert.assertEquals(3, ptr.remaining());

        {
            try (b2Capacity obj = ptr.get(0)) {
                Assert.assertEquals(1, obj.staticShapeCount());
                Assert.assertEquals(2, obj.dynamicShapeCount());
                Assert.assertEquals(3, obj.staticBodyCount());
                Assert.assertEquals(4, obj.dynamicBodyCount());
                Assert.assertEquals(5, obj.contactCount());
            }

            try (b2Capacity obj = ptr.get(1)) {
                Assert.assertEquals(10, obj.staticShapeCount());
                Assert.assertEquals(20, obj.dynamicShapeCount());
                Assert.assertEquals(30, obj.staticBodyCount());
                Assert.assertEquals(40, obj.dynamicBodyCount());
                Assert.assertEquals(50, obj.contactCount());
            }

            try (b2Capacity obj = ptr.get(2)) {
                Assert.assertEquals(100, obj.staticShapeCount());
                Assert.assertEquals(200, obj.dynamicShapeCount());
                Assert.assertEquals(300, obj.staticBodyCount());
                Assert.assertEquals(400, obj.dynamicBodyCount());
                Assert.assertEquals(500, obj.contactCount());
            }
        }

        ptr.free();
    }
}
