/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2AABB;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Destroyer;
import static org.box2d.jni.system.Pointer.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2AABB} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2AABBTest {

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
        try (b2AABB ptr = b2AABB.malloc()) {
            Assert.assertNotEquals(NULL, ptr.address());
            // set
            {
                try (b2Vec2 a = b2Vec2.malloc()) {
                    a.x(5.6f).y(-1.4f);
                    ptr.lowerBound(a);
                }

                try (b2Vec2 b = b2Vec2.malloc()) {
                    b.x(0.5f).y(1.1f);
                    ptr.upperBound(b);
                }
            }
            //get
            {
                try (b2Vec2 a = ptr.lowerBound()) {
                    Assert.assertEquals(5.6f, a.x(), 0.0f);
                    Assert.assertEquals(-1.4f, a.y(), 0.0f);
                }
                try (b2Vec2 b = ptr.upperBound()) {
                    Assert.assertEquals(0.5f, b.x(), 0.0f);
                    Assert.assertEquals(1.1f, b.y(), 0.0f);
                }
            }            
        }
    }
    
    /**
     * Buffer test for {@code Buffer} structures
     */
    private void buffer() {
        b2AABB.Buffer ptr = b2AABB.malloc(5);
        Assert.assertNotEquals(NULL, ptr.address());
        Assert.assertEquals(5, ptr.remaining());

        try (Destroyer.Default destroyer = new Destroyer.Default()) {
            // 1
            ptr.put(
                destroyer.create(() -> b2AABB.malloc()
                    .lowerBound(/* b2Vec2 */
                        destroyer.create(() -> b2Vec2.malloc()
                            .x(1)
                            .y(2)
                        )
                    )
                    .upperBound(/* b2Rot */
                        destroyer.create(() -> b2Vec2.malloc()
                            .x(0.3f)
                            .y(1.5f)
                        )
                    )
                ));

            // 2
            ptr.put(
                destroyer.create(() -> b2AABB.malloc()
                    .lowerBound(/* b2Vec2 */
                        destroyer.create(() -> b2Vec2.malloc()
                            .x(5.5f)
                            .y(2.5f)
                        )
                    )
                    .upperBound(/* b2Rot */
                        destroyer.create(() -> b2Vec2.malloc()
                            .x(3.3f)
                            .y(10.5f)
                        )
                    )
                ));
        }

        ptr.flip();

        Assert.assertEquals(5, ptr.capacity());
        Assert.assertEquals(2, ptr.remaining());

        {
            try (b2AABB obj = ptr.get(0)) {
                try (b2Vec2 o = obj.lowerBound()) {
                    Assert.assertEquals(1, o.x(), 0.0f);
                    Assert.assertEquals(2, o.y(), 0.0f);
                }
                try (b2Vec2 o = obj.upperBound()) {
                    Assert.assertEquals(0.3f, o.x(), 0.0f);
                    Assert.assertEquals(1.5f, o.y(), 0.0f);
                }
            }
            
        }
        {
            try (b2AABB obj = ptr.get(1)) {
                try (b2Vec2 o = obj.lowerBound()) {
                    Assert.assertEquals(5.5f, o.x(), 0.0f);
                    Assert.assertEquals(2.5f, o.y(), 0.0f);
                }
                try (b2Vec2 o = obj.upperBound()) {
                    Assert.assertEquals(3.3f, o.x(), 0.0f);
                    Assert.assertEquals(10.5f, o.y(), 0.0f);
                }
            }
            
        }
        ptr.free();
    }
}
