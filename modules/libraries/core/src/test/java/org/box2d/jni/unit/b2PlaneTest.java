/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2Plane;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Destroyer;
import static org.box2d.jni.system.Pointer.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2Plane} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2PlaneTest {

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
        try (b2Plane ptr = b2Plane.malloc()) {
            Assert.assertNotEquals(NULL, ptr.address());
            // set
            {
                try (b2Vec2 a = b2Vec2.malloc()) {
                    a.x(5.6f).y(-1.4f);
                    ptr.normal(a);
                }
                ptr.offset(1.1f);
            }
            //get
            {
                try (b2Vec2 a = ptr.normal()) {
                    Assert.assertEquals(5.6f, a.x(), 0.0f);
                    Assert.assertEquals(-1.4f, a.y(), 0.0f);
                }
                Assert.assertEquals(1.1f, ptr.offset(), 0.0f);
            }            
        }
    }
    
    /**
     * Buffer test for {@code Buffer} structures
     */
    private void buffer() {
        b2Plane.Buffer ptr = b2Plane.malloc(5);
        Assert.assertNotEquals(NULL, ptr.address());
        Assert.assertEquals(5, ptr.remaining());

        try (Destroyer.Default destroyer = new Destroyer.Default()) {
            // 1
            ptr.put(
                destroyer.create(() -> b2Plane.malloc()
                    .normal(/* b2Vec2 */
                        destroyer.create(() -> b2Vec2.malloc()
                            .x(1)
                            .y(2)
                        )
                    )
                    .offset(0.1f)
                ));

            // 2
            ptr.put(
                destroyer.create(() -> b2Plane.malloc()
                    .normal(/* b2Vec2 */
                        destroyer.create(() -> b2Vec2.malloc()
                            .x(5.5f)
                            .y(2.5f)
                        )
                    )
                    .offset(56.8f)
                ));
        }

        ptr.flip();

        Assert.assertEquals(5, ptr.capacity());
        Assert.assertEquals(2, ptr.remaining());

        {
            try (b2Plane obj = ptr.get(0)) {
                try (b2Vec2 o = obj.normal()) {
                    Assert.assertEquals(1, o.x(), 0.0f);
                    Assert.assertEquals(2, o.y(), 0.0f);
                }
                Assert.assertEquals(0.1f, obj.offset(), 0.0f);
            }
            
        }
        {
            try (b2Plane obj = ptr.get(1)) {
                try (b2Vec2 o = obj.normal()) {
                    Assert.assertEquals(5.5f, o.x(), 0.0f);
                    Assert.assertEquals(2.5f, o.y(), 0.0f);
                }
                Assert.assertEquals(56.8f, obj.offset(), 0.0f);
            }
            
        }
        ptr.free();
    }
}
