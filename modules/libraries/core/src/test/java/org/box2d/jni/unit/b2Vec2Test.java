/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2Vec2;
import static org.box2d.jni.system.Pointer.*;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author wil
 */
public class b2Vec2Test {

    @Test
    public void __constructor() {
        struct();
        buffer();
    }

    private void struct() {
        try (b2Vec2 ptr = b2Vec2.malloc()) {
            Assert.assertNotEquals(NULL, ptr.address());

            ptr.x(2);
            ptr.y(4);

            Assert.assertEquals(2, ptr.x(), 0);
            Assert.assertEquals(4, ptr.y(), 0);
        }
    }

    private void buffer() {
        b2Vec2.Buffer ptr = b2Vec2.malloc(5);
        Assert.assertNotEquals(NULL, ptr.address());
        Assert.assertEquals(5, ptr.remaining());

        {
            try (b2Vec2 vec2 = b2Vec2.malloc()) {
                vec2.x(2).y(3);
                ptr.put(vec2);
            }
        }
        {
            try (b2Vec2 vec2 = b2Vec2.malloc()) {
                vec2.x(2).y(3);
                ptr.put(vec2);
            }
        }
        {
            try (b2Vec2 vec2 = b2Vec2.malloc()) {
                vec2.x(8.0004f).y(4.5f);
                ptr.put(vec2);
            }
        }

        ptr.flip();

        Assert.assertEquals(5, ptr.capacity());
        Assert.assertEquals(3, ptr.remaining());

        {
            try (b2Vec2 vec2 = ptr.get(0)) {
                Assert.assertEquals(2f, vec2.x(), 0.0f);
                Assert.assertEquals(3f, vec2.y(), 0.0f);
            }
        }
        {
            try (b2Vec2 vec2 = ptr.get(1)) {
                Assert.assertEquals(2f, vec2.x(), 0.0f);
                Assert.assertEquals(3f, vec2.y(), 0.0f);
            }
        }
        {
            try (b2Vec2 vec2 = ptr.get(2)) {
                Assert.assertEquals(8.0004f, vec2.x(), 0.0f);
                Assert.assertEquals(4.5f, vec2.y(), 0.0f);
            }
        }
        ptr.free();
    }
}
