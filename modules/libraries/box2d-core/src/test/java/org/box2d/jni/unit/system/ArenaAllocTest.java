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
package org.box2d.jni.unit.system;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.box2d.jni.system.ArenaAlloc;
import org.box2d.jni.system.Sys;
import static org.box2d.jni.system.ArenaAlloc.*;
import static org.box2d.jni.system.Debug.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link ArenaAllocTest} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.3.0
 */
public class ArenaAllocTest {
    static { Sys.BOX2D_NDEBUG.set(true); }

    /**
     * Initialize all tests.
     */
    @Test
    public void localAlloc() {
        try (ArenaAlloc arena = allocPush()) {
            FloatBuffer ptr = arena.callocFloat(3);
            FloatBuffer fptr = arena.mallocFloat(3);
            Assert.assertEquals(3, ptr.capacity());
            Assert.assertEquals(3, fptr.capacity());

            {
                ptr.put(3f)
               .put(1.5f)
               .put(-3.3f);
                ptr.flip();
                apiLog("FloatBuffer <calloc>");
                for (int i = 0; i < ptr.remaining(); i++) {
                    apiLogMore(i + ": " + ptr.get(i));
                }
                Assert.assertEquals(3f, ptr.get(0), 0.0f);
                Assert.assertEquals(1.5f, ptr.get(1), 0.0f);
                Assert.assertEquals(-3.3f, ptr.get(2), 0.0f);
            }
            {
                fptr.put(3f)
               .put(1.5f)
               .put(-3.3f);
                fptr.flip();
                apiLog("FloatBuffer <malloc>");
                for (int i = 0; i < fptr.remaining(); i++) {
                    apiLogMore(i + ": " + fptr.get(i));
                }
                Assert.assertEquals(3f, fptr.get(0), 0.0f);
                Assert.assertEquals(1.5f, fptr.get(1), 0.0f);
                Assert.assertEquals(-3.3f, fptr.get(2), 0.0f);
            }
        }
        try (ArenaAlloc arena = allocPush()) {

            {
                IntBuffer ptr = arena.callocInt(3);
                Assert.assertEquals(3, ptr.capacity());
                ptr.put(3)
                        .put(1)
                        .put(-3);
                ptr.flip();
                apiLog("IntBuffer <calloc>");
                for (int i = 0; i < ptr.remaining(); i++) {
                    apiLogMore(i + ": " + ptr.get(i));
                }
                Assert.assertEquals(3, ptr.get(0));
                Assert.assertEquals(1, ptr.get(1));
                Assert.assertEquals(-3, ptr.get(2));
            }
            {
                IntBuffer ptr = arena.mallocInt(3);
                Assert.assertEquals(3, ptr.capacity());
                ptr.put(3)
                        .put(1)
                        .put(-3);
                ptr.flip();
                apiLog("IntBuffer <malloc>");
                for (int i = 0; i < ptr.remaining(); i++) {
                    apiLogMore(i + ": " + ptr.get(i));
                }
                Assert.assertEquals(3, ptr.get(0));
                Assert.assertEquals(1, ptr.get(1));
                Assert.assertEquals(-3, ptr.get(2));
            }
        }
        try (ArenaAlloc arena = allocPush()) {
            {
                ByteBuffer ptr = arena.calloc(3);
                Assert.assertEquals(3, ptr.capacity());
                ptr.put((byte) 3)
                        .put((byte) 1)
                        .put((byte) -3);
                ptr.flip();
                apiLog("ByteBuffer <calloc>");
                for (int i = 0; i < ptr.remaining(); i++) {
                    apiLogMore(i + ": " + ptr.get(i));
                }
                Assert.assertEquals(3, ptr.get(0));
                Assert.assertEquals(1, ptr.get(1));
                Assert.assertEquals(-3, ptr.get(2));
            }
            {
                ByteBuffer ptr = arena.malloc(3);
                Assert.assertEquals(3, ptr.capacity());
                ptr.put((byte) 3)
                        .put((byte) 1)
                        .put((byte) -3);
                ptr.flip();
                apiLog("ByteBuffer <calloc>");
                for (int i = 0; i < ptr.remaining(); i++) {
                    apiLogMore(i + ": " + ptr.get(i));
                }
                Assert.assertEquals(3, ptr.get(0));
                Assert.assertEquals(1, ptr.get(1));
                Assert.assertEquals(-3, ptr.get(2));
            }
        }
    }
}
