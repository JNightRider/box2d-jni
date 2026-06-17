/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2Rot;
import org.box2d.jni.b2Transform;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Destroyer;
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
public class b2TransformTest {

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
        try (b2Transform ptr = b2Transform.malloc()) {
            Assert.assertNotEquals(NULL, ptr.address());
            // set
            {
                try (b2Vec2 a = b2Vec2.malloc()) {
                    a.x(5.6f).y(-1.4f);
                    ptr.p(a);
                }

                try (b2Rot b = b2Rot.malloc()) {
                    b.c(0.5f).s(1.1f);
                    ptr.q(b);
                }
            }
            //get
            {
                try (b2Vec2 a = ptr.p()) {
                    Assert.assertEquals(5.6f, a.x(), 0.0f);
                    Assert.assertEquals(-1.4f, a.y(), 0.0f);
                }
                try (b2Rot b = ptr.q()) {
                    Assert.assertEquals(0.5f, b.c(), 0.0f);
                    Assert.assertEquals(1.1f, b.s(), 0.0f);
                }
            }            
        }
    }
    
    /**
     * Buffer test for {@code Buffer} structures
     */
    private void buffer() {
        b2Transform.Buffer ptr = b2Transform.malloc(5);
        Assert.assertNotEquals(NULL, ptr.address());
        Assert.assertEquals(5, ptr.remaining());

        try (Destroyer.Default destroyer = new Destroyer.Default()) {
            // 1
            ptr.put(
                destroyer.create(() -> b2Transform.malloc()
                    .p( /* b2Vec2 */
                        destroyer.create(() -> b2Vec2.malloc()
                            .x(1f)
                            .y(2f)
                        )
                    )
                    .q( /* b2Rot */
                        destroyer.create(() -> b2Rot.malloc()
                            .c(0.3f)
                            .s(1.5f)
                        )
                    )
                ));

            // 2
            ptr.put(
                destroyer.create(() -> b2Transform.malloc()
                    .p( /* b2Vec2 */
                        destroyer.create(() -> b2Vec2.malloc()
                            .x(5.5f)
                            .y(2.5f)
                        )
                    )
                    .q( /* b2Rot */
                        destroyer.create(() -> b2Rot.malloc()
                            .c(3.3f)
                            .s(10.5f)
                        )
                    )
                ));
        }

        ptr.flip();

        Assert.assertEquals(5, ptr.capacity());
        Assert.assertEquals(2, ptr.remaining());

        {
            try (b2Transform obj = ptr.get(0)) {
                try (b2Vec2 o = obj.p()) {
                    Assert.assertEquals(1, o.x(), 0.0f);
                    Assert.assertEquals(2, o.y(), 0.0f);
                }
                try (b2Rot o = obj.q()) {
                    Assert.assertEquals(0.3f, o.c(), 0.0f);
                    Assert.assertEquals(1.5f, o.s(), 0.0f);
                }
            }
            
        }
        {
            try (b2Transform obj = ptr.get(1)) {
                try (b2Vec2 o = obj.p()) {
                    Assert.assertEquals(5.5f, o.x(), 0.0f);
                    Assert.assertEquals(2.5f, o.y(), 0.0f);
                }
                try (b2Rot o = obj.q()) {
                    Assert.assertEquals(3.3f, o.c(), 0.0f);
                    Assert.assertEquals(10.5f, o.s(), 0.0f);
                }
            }
            
        }
        ptr.free();
    }
}
