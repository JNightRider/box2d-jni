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

import org.box2d.jni.b2BodyId;

import static org.box2d.jni.system.Pointer.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2BodyId} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2BodyIdTest {

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
        try (b2BodyId ptr = b2BodyId.malloc()) {
            Assert.assertNotEquals(NULL, ptr.address());

            ptr.index1(1);
            ptr.world0((short) 2);
            ptr.generation((short) 5);

            Assert.assertEquals(1, (int)ptr.index1());
            Assert.assertEquals(2, (int) ptr.world0());
            Assert.assertEquals(5, (int) ptr.generation());
        }
    }

    /**
     * Buffer test for {@code Buffer} structures
     */
    private void buffer() {
        b2BodyId.Buffer ptr = b2BodyId.malloc(5);

        Assert.assertNotEquals(NULL, ptr.address());
        Assert.assertEquals(5, ptr.remaining());

        {
            try (b2BodyId obj = b2BodyId.malloc()) {
                obj.index1(1) .world0((short) 10) .generation((short) 2);
                ptr.put(obj);
            }
            try (b2BodyId obj = b2BodyId.malloc()) {
                obj.index1(4).world0((short) 20).generation((short) 1);
                ptr.put(obj);
            }
            try (b2BodyId obj = b2BodyId.malloc()) {
                obj.index1(10).world0((short) 30).generation((short) 100);
                ptr.put(obj);
            }
        }

        ptr.flip();

        Assert.assertEquals(5, ptr.capacity());
        Assert.assertEquals(3, ptr.remaining());

        {
            try (b2BodyId obj = ptr.get(0)) {
                Assert.assertEquals(1, (int)obj.index1());
                Assert.assertEquals(10, (int) obj.world0());
                Assert.assertEquals(2, (int) obj.generation());
            }
            try (b2BodyId obj = ptr.get(1)) {
                Assert.assertEquals(4, (int)obj.index1());
                Assert.assertEquals(20, (int) obj.world0());
                Assert.assertEquals(1, (int) obj.generation());
            }
            try (b2BodyId obj = ptr.get(2)) {
                Assert.assertEquals(10, (int)obj.index1());
                Assert.assertEquals(30, (int) obj.world0());
                Assert.assertEquals(100, (int) obj.generation());
            }
        }

        ptr.free();
    }
}
