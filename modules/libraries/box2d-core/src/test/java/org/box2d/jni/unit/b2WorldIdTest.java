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
        b2WorldId.Buffer ptr = b2WorldId.malloc(5);
        Assert.assertNotEquals(NULL, ptr.address());
        Assert.assertEquals(5, ptr.remaining());

        {
            try (b2WorldId obj = b2WorldId.malloc()) {
                obj.index1((short)1).generation((short) 2);
                ptr.put(obj);
            }        
            try (b2WorldId obj = b2WorldId.malloc()) {
                obj.index1((short)4).generation((short) 1);
                ptr.put(obj);
            }
            try (b2WorldId obj = b2WorldId.malloc()) {
                obj.index1((short)10).generation((short)100);
                ptr.put(obj);
            }
        }
        

        ptr.flip();

        Assert.assertEquals(5, ptr.capacity());
        Assert.assertEquals(3, ptr.remaining());

        {
            try (b2WorldId obj = ptr.get(0)) {
                Assert.assertEquals(1, (int)obj.index1());
                Assert.assertEquals(2, (int)obj.generation());
            }
            try (b2WorldId obj = ptr.get(1)) {
                Assert.assertEquals(4, (int)obj.index1());
                Assert.assertEquals(1, (int)obj.generation());
            }
            try (b2WorldId obj = ptr.get(2)) {
                Assert.assertEquals(10, (int)obj.index1());
                Assert.assertEquals(100, (int)obj.generation());
            }
        }
        ptr.free();
    }
}
