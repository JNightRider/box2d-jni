/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2ShapeId;

import static org.box2d.jni.system.Pointer.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2ShapeId} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2ShapeIdTest {

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
        try (b2ShapeId ptr = b2ShapeId.malloc()) {
            Assert.assertNotEquals(NULL, ptr.address());

            ptr.index1(1);
            ptr.world0((short) 2);
            ptr.generation((short) 5);

            Assert.assertEquals(1, (int) ptr.index1());
            Assert.assertEquals(2, (int) ptr.world0());
            Assert.assertEquals(5, (int) ptr.generation());
        }
    }

    /**
     * Buffer test for {@code Buffer} structures
     */
    private void buffer() {
        b2ShapeId.Buffer ptr = b2ShapeId.malloc(5);

        Assert.assertNotEquals(NULL, ptr.address());
        Assert.assertEquals(5, ptr.remaining());

        {
            try (b2ShapeId obj = b2ShapeId.malloc()) {
                obj.index1(1)
                   .world0((short) 10)
                   .generation((short) 2);

                ptr.put(obj);
            }
            try (b2ShapeId obj = b2ShapeId.malloc()) {
                obj.index1(4)
                   .world0((short) 20)
                   .generation((short) 1);

                ptr.put(obj);
            }
            try (b2ShapeId obj = b2ShapeId.malloc()) {
                obj.index1(10)
                   .world0((short) 30)
                   .generation((short) 100);

                ptr.put(obj);
            }
        }

        ptr.flip();

        Assert.assertEquals(5, ptr.capacity());
        Assert.assertEquals(3, ptr.remaining());

        {
            try (b2ShapeId obj = ptr.get(0)) {
                Assert.assertEquals(1, (int) obj.index1());
                Assert.assertEquals(10, (int) obj.world0());
                Assert.assertEquals(2, (int) obj.generation());
            }
            try (b2ShapeId obj = ptr.get(1)) {
                Assert.assertEquals(4, (int) obj.index1());
                Assert.assertEquals(20, (int) obj.world0());
                Assert.assertEquals(1, (int) obj.generation());
            }
            try (b2ShapeId obj = ptr.get(2)) {
                Assert.assertEquals(10, (int)obj.index1());
                Assert.assertEquals(30, (int) obj.world0());
                Assert.assertEquals(100, (int) obj.generation());
            }
        }

        ptr.free();
    }
}
