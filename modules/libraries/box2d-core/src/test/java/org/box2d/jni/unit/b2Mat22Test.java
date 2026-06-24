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

import org.box2d.jni.b2Mat22;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.ArenaAlloc;
import static org.box2d.jni.system.Pointer.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2Mat22} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2Mat22Test {

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
        try (b2Mat22 ptr = b2Mat22.malloc()) {
            Assert.assertNotEquals(NULL, ptr.address());
            // set
            {
                try (b2Vec2 a = b2Vec2.malloc()) {
                    a.x(5.6f).y(-1.4f);
                    ptr.cx(a);
                }

                try (b2Vec2 b = b2Vec2.malloc()) {
                    b.x(0.5f).y(1.1f);
                    ptr.cy(b);
                }
            }
            //get
            {
                try (b2Vec2 a = ptr.cx()) {
                    Assert.assertEquals(5.6f, a.x(), 0.0f);
                    Assert.assertEquals(-1.4f, a.y(), 0.0f);
                }
                try (b2Vec2 b = ptr.cy()) {
                    Assert.assertEquals(0.5f, b.x(), 0.0f);
                    Assert.assertEquals(1.1f, b.y(), 0.0f);
                }
            }            
        }
    }
    
    /**
     * Buffer test for {@code Buffer} structures
     */
    private void buffer() {
        b2Mat22.Buffer ptr = b2Mat22.malloc(5);
        Assert.assertNotEquals(NULL, ptr.address());
        Assert.assertEquals(5, ptr.remaining());

        try (ArenaAlloc alloc = ArenaAlloc.allocPush()) {
            // 1
            ptr.put(
                    b2Mat22.malloc(alloc)
                            .cx( /* b2Vec2 */
                                    b2Vec2.malloc(alloc)
                                            .x(1f)
                                            .y(2f)
                            )
                            .cy( /* b2Rot */
                                    b2Vec2.malloc(alloc)
                                            .x(0.3f)
                                            .y(1.5f)
                            )
            );

            // 2
            ptr.put(
                    b2Mat22.malloc(alloc)
                            .cx( /* b2Vec2 */
                                    b2Vec2.malloc(alloc)
                                            .x(5.5f)
                                            .y(2.5f)
                            )
                            .cy( /* b2Rot */
                                    b2Vec2.malloc(alloc)
                                            .x(3.3f)
                                            .y(10.5f)
                            )
            );
        }

        ptr.flip();

        Assert.assertEquals(5, ptr.capacity());
        Assert.assertEquals(2, ptr.remaining());

        {
            try (b2Mat22 obj = ptr.get(0)) {
                try (b2Vec2 o = obj.cx()) {
                    Assert.assertEquals(1, o.x(), 0.0f);
                    Assert.assertEquals(2, o.y(), 0.0f);
                }
                try (b2Vec2 o = obj.cy()) {
                    Assert.assertEquals(0.3f, o.x(), 0.0f);
                    Assert.assertEquals(1.5f, o.y(), 0.0f);
                }
            }
            
        }
        {
            try (b2Mat22 obj = ptr.get(1)) {
                try (b2Vec2 o = obj.cx()) {
                    Assert.assertEquals(5.5f, o.x(), 0.0f);
                    Assert.assertEquals(2.5f, o.y(), 0.0f);
                }
                try (b2Vec2 o = obj.cy()) {
                    Assert.assertEquals(3.3f, o.x(), 0.0f);
                    Assert.assertEquals(10.5f, o.y(), 0.0f);
                }
            }
            
        }
        ptr.free();
    }
}
