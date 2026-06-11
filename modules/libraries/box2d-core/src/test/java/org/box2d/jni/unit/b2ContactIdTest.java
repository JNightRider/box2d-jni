/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2ContactId;

import static org.box2d.jni.system.Pointer.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2ContactId} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2ContactIdTest {

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
        try (b2ContactId ptr = b2ContactId.malloc()) {
            Assert.assertNotEquals(NULL, ptr.address());

            ptr.index1(1);
            ptr.world0((short) 2);
            ptr.padding((short) 3);
            ptr.generation(5);

            Assert.assertEquals(1, (int) ptr.index1());
            Assert.assertEquals(2, (int) ptr.world0());
            Assert.assertEquals(3, (int) ptr.padding());
            Assert.assertEquals(5L, (long) ptr.generation());
        }
    }

    /**
     * Buffer test for {@code Buffer} structures
     */
    private void buffer() {
        b2ContactId.Buffer ptr = b2ContactId.malloc(5);

        Assert.assertNotEquals(NULL, ptr.address());
        Assert.assertEquals(5, ptr.remaining());

        {
            try (b2ContactId obj = b2ContactId.malloc()) {
                obj.index1(1)
                   .world0((short) 10)
                   .padding((short) 11)
                   .generation(2);

                ptr.put(obj);
            }
            try (b2ContactId obj = b2ContactId.malloc()) {
                obj.index1(4)
                   .world0((short) 20)
                   .padding((short) 21)
                   .generation(1);

                ptr.put(obj);
            }
            try (b2ContactId obj = b2ContactId.malloc()) {
                obj.index1(10)
                   .world0((short) 30)
                   .padding((short) 31)
                   .generation(100);

                ptr.put(obj);
            }
        }

        ptr.flip();

        Assert.assertEquals(5, ptr.capacity());
        Assert.assertEquals(3, ptr.remaining());

        {
            try (b2ContactId obj = ptr.get(0)) {
                Assert.assertEquals(1, (int) obj.index1());
                Assert.assertEquals(10, (int) obj.world0());
                Assert.assertEquals(11, (int) obj.padding());
                Assert.assertEquals(2L, (long) obj.generation());
            }
            try (b2ContactId obj = ptr.get(1)) {
                Assert.assertEquals(4, (int) obj.index1());
                Assert.assertEquals(20, (int) obj.world0());
                Assert.assertEquals(21, (int) obj.padding());
                Assert.assertEquals(1L, (long) obj.generation());
            }
            try (b2ContactId obj = ptr.get(2)) {
                Assert.assertEquals(10, (int) obj.index1());
                Assert.assertEquals(30, (int) obj.world0());
                Assert.assertEquals(31, (int) obj.padding());
                Assert.assertEquals(100L, (long) obj.generation());
            }
        }

        ptr.free();
    }
}
