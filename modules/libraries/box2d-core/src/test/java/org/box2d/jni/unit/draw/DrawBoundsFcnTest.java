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
package org.box2d.jni.unit.draw;

import org.box2d.jni.b2AABB;
import org.box2d.jni.b2HexColor;
import org.box2d.jni.draw.DrawBoundsFcn;
import org.box2d.jni.draw.DrawBoundsFcnI;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.JNIB2;
import org.box2d.jni.system.Library;
import org.box2d.jni.system.Sys;

import static org.box2d.jni.system.Pointer.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link DrawCircleFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.2.0
 */
public class DrawBoundsFcnTest {
    static {
        Sys.BOX2D_NDEBUG.set(true);
        Library.initialize();
    }

    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        {
            b2AABB naabb = b2AABB.calloc();
            naabb.lowerBound(b2Vec2.malloc().set(1f, 2f));
            naabb.upperBound(b2Vec2.malloc().set(-4.5f, 2.76f));

            DrawBoundsFcnI func = (aabb, color, context) -> {
                b2AABB ab = b2AABB.createSafe(aabb);
                Assert.assertNotEquals(NULL, ab.address());

                b2Vec2 lower = ab.lowerBound();
                b2Vec2 upper = ab.upperBound();

                Assert.assertNotEquals(NULL, lower.address());
                Assert.assertNotEquals(NULL, upper.address());
                Assert.assertEquals(1f, lower.x(), 0);
                Assert.assertEquals(2f, lower.y(), 0);
                Assert.assertEquals(-4.5f, upper.x(), 0);
                Assert.assertEquals(2.76f, upper.y(), 0);

                Assert.assertEquals(b2HexColor.b2_colorAntiqueWhite, color);
                Assert.assertEquals(0X234FFL, context);
            };
            JNIB2.invoke_AABB_IPV(naabb.address(), b2HexColor.b2_colorAntiqueWhite, 0X234FFL, func.address());
        }
        {
            b2AABB naabb = b2AABB.calloc();
            naabb.lowerBound(b2Vec2.malloc().set(1f, 2f));
            naabb.upperBound(b2Vec2.malloc().set(-4.5f, 2.76f));

            DrawBoundsFcn func = DrawBoundsFcn.create((aabb, color, context) -> {
                b2AABB ab = b2AABB.createSafe(aabb);
                Assert.assertNotEquals(NULL, ab.address());

                b2Vec2 lower = ab.lowerBound();
                b2Vec2 upper = ab.upperBound();

                Assert.assertNotEquals(NULL, lower.address());
                Assert.assertNotEquals(NULL, upper.address());
                Assert.assertEquals(1f, lower.x(), 0);
                Assert.assertEquals(2f, lower.y(), 0);
                Assert.assertEquals(-4.5f, upper.x(), 0);
                Assert.assertEquals(2.76f, upper.y(), 0);

                Assert.assertEquals(b2HexColor.b2_colorAntiqueWhite, color);
                Assert.assertEquals(0X234FFL, context);
            });
            JNIB2.invoke_AABB_IPV(naabb.address(), b2HexColor.b2_colorAntiqueWhite, 0X234FFL, func.address());
        }
    }
}
