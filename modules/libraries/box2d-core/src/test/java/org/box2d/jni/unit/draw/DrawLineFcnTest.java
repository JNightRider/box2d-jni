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
import org.box2d.jni.draw.DrawLineFcn;
import org.box2d.jni.draw.DrawLineFcnI;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNIB2;
import org.box2d.jni.system.Sys;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link DrawLineFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class DrawLineFcnTest {
    static { Sys.BOX2D_NDEBUG.set(true); }

    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        try
        (
            b2Vec2 v0 = b2Vec2.malloc().set(1f, 2f);
            b2Vec2 v1 = b2Vec2.malloc().set(3f, 5f)
        ) {
            DrawLineFcnI func = (p1, p2, color, context) -> {
                Debug.apiPrint("DrawLineFcnI: p1=" + p1 + ", p2=" + p2 + ", color=" + color + ", context=" + context);
                Assert.assertEquals(b2HexColor.b2_colorBlue, color);
                
                Assert.assertEquals(0x0CDDCCl, context);
                
                Assert.assertEquals(1f, p1.x().floatValue(), 0.0f);
                Assert.assertEquals(2f, p1.y().floatValue(), 0.0f);
                Assert.assertEquals(3f, p2.x().floatValue(), 0.0f);
                Assert.assertEquals(5f, p2.y().floatValue(), 0.0f);
            };
            JNIB2.invoke_VEC2_VEC2_IPV(v0.address(), v1.address(), b2HexColor.b2_colorBlue, 0x0CDDCCl, func.address());
        }
        Callbacks.b2FreeCallbacks();
    }
}
