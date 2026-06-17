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
                            .x(1f)
                            .y(2f)
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
