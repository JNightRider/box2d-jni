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

import org.box2d.jni.b2HexColor;
import org.box2d.jni.draw.DrawStringFcn;
import org.box2d.jni.draw.DrawStringFcnI;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.libc.LibCStdlib;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNIB2;
import org.box2d.jni.system.MemoryUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link DrawStringFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class DrawStringFcnTest {
    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        long nmem = LibCStdlib.nmalloc(120);
        String str = "JNI_B2";
        try
        (
                b2Vec2 v = b2Vec2.malloc().set(1f, 2f)
        ) {

            DrawStringFcnI func = (p, s, color, context) -> {
                Debug.apiPrint("DrawStringFcnI: p=" + p.x() + ", " + p.y() + ", s=" + s + ", color=" + color);
                Assert.assertEquals(b2HexColor.b2_colorBlue, color);
                Assert.assertEquals("JNI_B2", MemoryUtil.memUTF(s));
                
                Assert.assertEquals(0xDDDEEEl, context);
                
                Assert.assertEquals(1f, p.x().floatValue(), 0.0f);
                Assert.assertEquals(2f, p.y().floatValue(), 0.0f);
            };
            JNIB2.invoke_VEC2_PIPV(v.address(), MemoryUtil.memMallocUTF(str, nmem), b2HexColor.b2_colorBlue, 0xDDDEEEl, func.address());
        }
        try
        (
                b2Vec2 v = b2Vec2.malloc().set(1f, 2f)
        ) {

            DrawStringFcn func = DrawStringFcn.create((p, s, color, context) -> {
                Debug.apiPrint("DrawStringFcnI: p=" + p.x() + ", " + p.y() + ", s=" + s + ", color=" + color);
                Assert.assertEquals(b2HexColor.b2_colorBlue, color);
                Assert.assertEquals("JNI_B2", MemoryUtil.memUTF(s));
                
                Assert.assertEquals(0xDDDEEEl, context);
                
                Assert.assertEquals(1f, p.x().floatValue(), 0.0f);
                Assert.assertEquals(2f, p.y().floatValue(), 0.0f);
            });
            JNIB2.invoke_VEC2_PIPV(v.address(), MemoryUtil.memMallocUTF(str, nmem), b2HexColor.b2_colorBlue, 0xDDDEEEl, func.address());
        }
        LibCStdlib.nfree(nmem);
        Callbacks.b2FreeCallbacks();
    }
}
