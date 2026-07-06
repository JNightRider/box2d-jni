/*
BSD 3-Clause License

Copyright (c) 2026, Night Rider

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.box2d.jni.unit;

import org.box2d.jni.b2AABB;
import org.box2d.jni.b2TreeNode;
import org.box2d.jni.b2TreeNodeChildren;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Sys;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2TreeNode} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.1
 */
public class b2TreeNodeTest {
    static { Sys.BOX2D_NDEBUG.set(true); }

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
                            .lowerBound(b2Vec2.malloc().set(1f, 2f))
                            .upperBound(b2Vec2.malloc().set(-2f, -4f)); 

            b2TreeNodeChildren children = b2TreeNodeChildren.malloc()
                    .child1(1)
                    .child2(4);

            b2TreeNode ptr = b2TreeNode.malloc()
                    .aabb(b0)
                    .categoryBits(345L)
                    .children(children)
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
            Assert.assertEquals(1, ptr.children().child1());
            Assert.assertEquals(4, ptr.children().child2());
            Assert.assertEquals((short) 6, ptr.flags());
            Assert.assertEquals((short) 10, ptr.height());
            Assert.assertEquals(56, ptr.next());
        }
    }
}
