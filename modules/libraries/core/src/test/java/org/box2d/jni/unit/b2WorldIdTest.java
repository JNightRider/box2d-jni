/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2WorldId;
import static org.box2d.jni.system.Pointer.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2WorldId} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2WorldIdTest {

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
        try (b2WorldId ptr = b2WorldId.malloc()) {
            Assert.assertNotEquals(NULL, ptr.address());

            ptr.index1((short) 1);
            ptr.generation((short) 5);

            Assert.assertEquals(1, (int) ptr.index1());
            Assert.assertEquals(5, (int) ptr.generation());
        }
    }

    /**
     * Buffer test for {@code Buffer} structures
     */
    private void buffer() {
//        b2Version.Buffer ptr = b2Version.malloc(5);
//        Assert.assertNotEquals(NULL, ptr.address());
//        Assert.assertEquals(5, ptr.remaining());
//
//        {
//            try (b2Version obj = b2Version.malloc()) {
//                obj.major(1).minor(3).revision(2);
//                ptr.put(obj);
//            }
//        }
//        {
//            try (b2Version obj = b2Version.malloc()) {
//                obj.major(4).minor(0).revision(0);
//                ptr.put(obj);
//            }
//        }
//        {
//            try (b2Version obj = b2Version.malloc()) {
//                obj.major(10).minor(9).revision(1);
//                ptr.put(obj);
//            }
//        }
//
//        ptr.flip();
//
//        Assert.assertEquals(5, ptr.capacity());
//        Assert.assertEquals(3, ptr.remaining());
//
//        {
//            try (b2Version obj = ptr.get(0)) {
//                Assert.assertEquals(1, obj.major());
//                Assert.assertEquals(3, obj.minor());
//                Assert.assertEquals(2, obj.revision());
//            }
//        }
//        {
//            try (b2Version obj = ptr.get(1)) {
//                Assert.assertEquals(4, obj.major());
//                Assert.assertEquals(0, obj.minor());
//                Assert.assertEquals(0, obj.revision());
//            }
//        }
//        {
//            try (b2Version obj = ptr.get(2)) {
//                Assert.assertEquals(10, obj.major());
//                Assert.assertEquals(9, obj.minor());
//                Assert.assertEquals(1, obj.revision());
//            }
//        }
//        ptr.free();
    }
}
