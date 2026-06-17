/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2RayResult;

import static org.box2d.jni.system.Pointer.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2RayResult} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2RayResultTest {

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
    @SuppressWarnings("unchecked")
    private void struct() {
        try (b2RayResult ptr = b2RayResult.malloc()) {
            Assert.assertNotEquals(NULL, ptr.address());

            ptr.shapeId()
                    .index1(1)
                    .world0((short) 2)
                    .generation((short) 3);

            ptr.point()
                    .x(10.5f)
                    .y(20.5f);

            ptr.normal()
                    .x(-1.0f)
                    .y(0.0f);

            ptr.fraction(0.75f);
            ptr.nodeVisits(100);
            ptr.leafVisits(50);
            ptr.hit(true);

            Assert.assertEquals(1, (int) ptr.shapeId().index1());
            Assert.assertEquals(2, (int) ptr.shapeId().world0());
            Assert.assertEquals(3, (int) ptr.shapeId().generation());

            Assert.assertEquals(10.5d, ptr.point().x().doubleValue(), 0.0001d);
            Assert.assertEquals(20.5d, ptr.point().y().doubleValue(), 0.0001d);

            Assert.assertEquals(-1.0f, ptr.normal().x(), 0.0001f);
            Assert.assertEquals(0.0f, ptr.normal().y(), 0.0001f);

            Assert.assertEquals(0.75f, ptr.fraction(), 0.0001f);
            Assert.assertEquals(100, ptr.nodeVisits());
            Assert.assertEquals(50, ptr.leafVisits());
            Assert.assertTrue(ptr.hit());
        }
    }

    /**
     * Buffer test for {@code Buffer} structures.
     */
    @SuppressWarnings("unchecked")
    private void buffer() {
        b2RayResult.Buffer ptr = b2RayResult.malloc(5);

        Assert.assertNotEquals(NULL, ptr.address());
        Assert.assertEquals(5, ptr.remaining());

        {
            try (b2RayResult obj = b2RayResult.malloc()) {
                obj.shapeId().index1(1).world0((short) 10).generation((short) 2);
                obj.point().x(1f).y(2f);
                obj.normal().x(0f).y(1f);
                obj.fraction(0.1f);
                obj.nodeVisits(10);
                obj.leafVisits(20);
                obj.hit(true);
                ptr.put(obj);
            }

            try (b2RayResult obj = b2RayResult.malloc()) {
                obj.shapeId().index1(2).world0((short) 20).generation((short) 3);
                obj.point().x(3f).y(4f);
                obj.normal().x(1f).y(0f);
                obj.fraction(0.2f);
                obj.nodeVisits(30);
                obj.leafVisits(40);
                obj.hit(false);
                ptr.put(obj);
            }

            try (b2RayResult obj = b2RayResult.malloc()) {
                obj.shapeId().index1(3).world0((short) 30).generation((short) 4);
                obj.point().x(5f).y(6f);
                obj.normal().x(-1f).y(0f);
                obj.fraction(0.3f);
                obj.nodeVisits(50);
                obj.leafVisits(60);
                obj.hit(true);
                ptr.put(obj);
            }
        }

        ptr.flip();

        Assert.assertEquals(5, ptr.capacity());
        Assert.assertEquals(3, ptr.remaining());

        {
            try (b2RayResult obj = ptr.get(0)) {
                Assert.assertEquals(1, (int) obj.shapeId().index1());
                Assert.assertEquals(10, (int) obj.shapeId().world0());
                Assert.assertEquals(2, (int) obj.shapeId().generation());

                Assert.assertEquals(1d, obj.point().x().doubleValue(), 0.0001d);
                Assert.assertEquals(2d, obj.point().y().doubleValue(), 0.0001d);

                Assert.assertEquals(0f, obj.normal().x(), 0.0001f);
                Assert.assertEquals(1f, obj.normal().y(), 0.0001f);

                Assert.assertEquals(0.1f, obj.fraction(), 0.0001f);
                Assert.assertEquals(10, obj.nodeVisits());
                Assert.assertEquals(20, obj.leafVisits());
                Assert.assertTrue(obj.hit());
            }

            try (b2RayResult obj = ptr.get(1)) {
                Assert.assertEquals(2, (int) obj.shapeId().index1());
                Assert.assertEquals(20, (int) obj.shapeId().world0());
                Assert.assertEquals(3, (int) obj.shapeId().generation());

                Assert.assertEquals(3d, obj.point().x().doubleValue(), 0.0001d);
                Assert.assertEquals(4d, obj.point().y().doubleValue(), 0.0001d);

                Assert.assertEquals(1f, obj.normal().x(), 0.0001f);
                Assert.assertEquals(0f, obj.normal().y(), 0.0001f);

                Assert.assertEquals(0.2f, obj.fraction(), 0.0001f);
                Assert.assertEquals(30, obj.nodeVisits());
                Assert.assertEquals(40, obj.leafVisits());
                Assert.assertFalse(obj.hit());
            }

            try (b2RayResult obj = ptr.get(2)) {
                Assert.assertEquals(3, (int) obj.shapeId().index1());
                Assert.assertEquals(30, (int) obj.shapeId().world0());
                Assert.assertEquals(4, (int) obj.shapeId().generation());

                Assert.assertEquals(5d, obj.point().x().doubleValue(), 0.0001d);
                Assert.assertEquals(6d, obj.point().y().doubleValue(), 0.0001d);

                Assert.assertEquals(-1f, obj.normal().x(), 0.0001f);
                Assert.assertEquals(0f, obj.normal().y(), 0.0001f);

                Assert.assertEquals(0.3f, obj.fraction(), 0.0001f);
                Assert.assertEquals(50, obj.nodeVisits());
                Assert.assertEquals(60, obj.leafVisits());
                Assert.assertTrue(obj.hit());
            }
        }

        ptr.free();
    }
}