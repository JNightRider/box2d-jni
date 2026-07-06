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

import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Sys;
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
public class b2Vec2Test {
    static { Sys.BOX2D_NDEBUG.set(true); }

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
        try (b2Vec2 ptr = b2Vec2.malloc()) {
            Assert.assertNotEquals(NULL, ptr.address());

            ptr.x(2f);
            ptr.y(4f);

            Assert.assertEquals(2, ptr.x(), 0);
            Assert.assertEquals(4, ptr.y(), 0);
        }
        try (
                b2Vec2 ptr = b2Vec2.malloc();
                b2Vec2 tmp = b2Vec2.malloc()
            ) {
            Assert.assertNotEquals(NULL, ptr.address());
            Assert.assertNotEquals(NULL, tmp.address());

            ptr.clear();
            Assert.assertEquals(0, ptr.x(), 0);
            Assert.assertEquals(0, ptr.y(), 0);

            tmp.x(1f).y(10f);
            ptr.add(tmp);

            Assert.assertEquals(1, ptr.x(), 0);
            Assert.assertEquals(10, ptr.y(), 0);

            tmp.x(0.5f).y(2f);
            ptr.sub(tmp);

            Assert.assertEquals(0.5f, ptr.x(), 0);
            Assert.assertEquals(8f, ptr.y(), 0);

            ptr.neg();
            Assert.assertEquals(-0.5f, ptr.x(), 0);
            Assert.assertEquals(-8f, ptr.y(), 0);
            
            Assert.assertFalse(ptr.equality(tmp));
            
            tmp.set(1f, 1f);
            ptr.set(1f, 1f);
            Assert.assertTrue(ptr.equality(tmp));
        }
    }

    /**
     * Buffer test for {@code b2Vec2.Buffer} structures
     */
    private void buffer() {
        b2Vec2.Buffer ptr = b2Vec2.malloc(5);
        Assert.assertNotEquals(NULL, ptr.address());
        Assert.assertEquals(5, ptr.remaining());

        {
            try (b2Vec2 vec2 = b2Vec2.malloc()) {
                vec2.x(2f).y(3f);
                ptr.put(vec2);
            }
        }
        {
            try (b2Vec2 vec2 = b2Vec2.malloc()) {
                vec2.x(2f).y(3f);
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
