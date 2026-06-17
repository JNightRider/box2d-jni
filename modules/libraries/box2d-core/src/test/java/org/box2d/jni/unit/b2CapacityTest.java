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

import org.box2d.jni.b2Capacity;

import static org.box2d.jni.system.Pointer.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2Capacity} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2CapacityTest {

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
        try (b2Capacity ptr = b2Capacity.malloc()) {
            Assert.assertNotEquals(NULL, ptr.address());

            ptr.staticShapeCount(10);
            ptr.dynamicShapeCount(20);
            ptr.staticBodyCount(30);
            ptr.dynamicBodyCount(40);
            ptr.contactCount(50);

            Assert.assertEquals(10, ptr.staticShapeCount());
            Assert.assertEquals(20, ptr.dynamicShapeCount());
            Assert.assertEquals(30, ptr.staticBodyCount());
            Assert.assertEquals(40, ptr.dynamicBodyCount());
            Assert.assertEquals(50, ptr.contactCount());
        }
    }

    /**
     * Buffer test for {@code Buffer} structures.
     */
    private void buffer() {
        b2Capacity.Buffer ptr = b2Capacity.malloc(5);

        Assert.assertNotEquals(NULL, ptr.address());
        Assert.assertEquals(5, ptr.remaining());

        {
            try (b2Capacity obj = b2Capacity.malloc()) {
                obj.staticShapeCount(1)
                   .dynamicShapeCount(2)
                   .staticBodyCount(3)
                   .dynamicBodyCount(4)
                   .contactCount(5);
                ptr.put(obj);
            }

            try (b2Capacity obj = b2Capacity.malloc()) {
                obj.staticShapeCount(10)
                   .dynamicShapeCount(20)
                   .staticBodyCount(30)
                   .dynamicBodyCount(40)
                   .contactCount(50);
                ptr.put(obj);
            }

            try (b2Capacity obj = b2Capacity.malloc()) {
                obj.staticShapeCount(100)
                   .dynamicShapeCount(200)
                   .staticBodyCount(300)
                   .dynamicBodyCount(400)
                   .contactCount(500);
                ptr.put(obj);
            }
        }

        ptr.flip();

        Assert.assertEquals(5, ptr.capacity());
        Assert.assertEquals(3, ptr.remaining());

        {
            try (b2Capacity obj = ptr.get(0)) {
                Assert.assertEquals(1, obj.staticShapeCount());
                Assert.assertEquals(2, obj.dynamicShapeCount());
                Assert.assertEquals(3, obj.staticBodyCount());
                Assert.assertEquals(4, obj.dynamicBodyCount());
                Assert.assertEquals(5, obj.contactCount());
            }

            try (b2Capacity obj = ptr.get(1)) {
                Assert.assertEquals(10, obj.staticShapeCount());
                Assert.assertEquals(20, obj.dynamicShapeCount());
                Assert.assertEquals(30, obj.staticBodyCount());
                Assert.assertEquals(40, obj.dynamicBodyCount());
                Assert.assertEquals(50, obj.contactCount());
            }

            try (b2Capacity obj = ptr.get(2)) {
                Assert.assertEquals(100, obj.staticShapeCount());
                Assert.assertEquals(200, obj.dynamicShapeCount());
                Assert.assertEquals(300, obj.staticBodyCount());
                Assert.assertEquals(400, obj.dynamicBodyCount());
                Assert.assertEquals(500, obj.contactCount());
            }
        }

        ptr.free();
    }
}
