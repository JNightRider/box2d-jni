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

import org.box2d.jni.b2Version;
import org.box2d.jni.system.Sys;
import static org.box2d.jni.system.Pointer.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2Version} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2VersionTest {
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
        try (b2Version ptr = b2Version.malloc()) {
            Assert.assertNotEquals(NULL, ptr.address());

            ptr.major(1);
            ptr.minor(3);
            ptr.revision(2);

            Assert.assertEquals(1, ptr.major());
            Assert.assertEquals(3, ptr.minor());
            Assert.assertEquals(2, ptr.revision());
        }
    }

    /**
     * Buffer test for {@code Buffer} structures
     */
    private void buffer() {
        b2Version.Buffer ptr = b2Version.malloc(5);
        Assert.assertNotEquals(NULL, ptr.address());
        Assert.assertEquals(5, ptr.remaining());

        {
            try (b2Version obj = b2Version.malloc()) {
                obj.major(1).minor(3).revision(2);
                ptr.put(obj);
            }
        }
        {
            try (b2Version obj = b2Version.malloc()) {
                obj.major(4).minor(0).revision(0);
                ptr.put(obj);
            }
        }
        {
            try (b2Version obj = b2Version.malloc()) {
                obj.major(10).minor(9).revision(1);
                ptr.put(obj);
            }
        }

        ptr.flip();

        Assert.assertEquals(5, ptr.capacity());
        Assert.assertEquals(3, ptr.remaining());

        {
            try (b2Version obj = ptr.get(0)) {
                Assert.assertEquals(1, obj.major());
                Assert.assertEquals(3, obj.minor());
                Assert.assertEquals(2, obj.revision());
            }
        }
        {
            try (b2Version obj = ptr.get(1)) {
                Assert.assertEquals(4, obj.major());
                Assert.assertEquals(0, obj.minor());
                Assert.assertEquals(0, obj.revision());
            }
        }
        {
            try (b2Version obj = ptr.get(2)) {
                Assert.assertEquals(10, obj.major());
                Assert.assertEquals(9, obj.minor());
                Assert.assertEquals(1, obj.revision());
            }
        }
        ptr.free();
    }
}
