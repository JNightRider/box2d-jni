/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.unit;

import org.box2d.jni.b2AABB;
import org.box2d.jni.b2TreeNode;
import org.box2d.jni.b2Vec2;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2TreeNode} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2TreeNodeTest {
    /**
     * Initialize all tests.
     */
    @Test
    public void __constructor() {
        struct();
    }

    /**
     * Test the properties of the structure.
     */
    private void struct() {
        try (
            b2AABB b0 = b2AABB.malloc()
                            .lowerBound(b2Vec2.malloc().set(1, 2))
                            .upperBound(b2Vec2.malloc().set(-2, -4)); 

            b2TreeNode ptr = b2TreeNode.malloc()
                    .aabb(b0)
                    .categoryBits(345L)
                    .child1(1)
                    .child2(4)
                    .flags((short) 6)
                    .height((short) 10)
                    .next(56);
        ) {
            b2AABB obj = ptr.aabb();
            obj.close();

            Assert.assertEquals(1, obj.lowerBound().x(), 0);
            Assert.assertEquals(2, obj.lowerBound().y(), 0);
            Assert.assertEquals(-2, obj.upperBound().x(), 0);
            Assert.assertEquals(-4, obj.upperBound().y(), 0);

            Assert.assertEquals(345L, ptr.categoryBits());
            Assert.assertEquals(1, ptr.child1());
            Assert.assertEquals(4, ptr.child2());
            Assert.assertEquals((short) 6, ptr.flags());
            Assert.assertEquals((short) 10, ptr.height());
            Assert.assertEquals(56, ptr.next());
        }
    }
}
