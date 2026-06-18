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
import org.box2d.jni.b2Rot;
import org.box2d.jni.b2Transform;
import org.box2d.jni.draw.DrawSolidCircleFcn;
import org.box2d.jni.draw.DrawSolidCircleFcnI;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.b2WorldTransform;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNIB2;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link DrawSolidCircleFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unchecked")
public class DrawSolidCircleFcnTest {
    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        try
        (
            b2Vec2 v = b2Vec2.malloc().set(1f, 2f);
            b2Rot r =  b2Rot.malloc().set(4, 6);
            b2WorldTransform t = b2WorldTransform.nmalloc().set(v, r)
        ) {

            DrawSolidCircleFcnI func = (transform, center, radius, color, context) -> {
                Debug.apiPrint("DrawSolidCircleFcnI: transform=" + transform + ", radius=" + radius + ", color=" + color + ", context=" + context);
                Assert.assertEquals(1f, center.x(), 0.0f);
                Assert.assertEquals(2f, center.y(), 0.0f);
                Assert.assertEquals(1f, transform.p().x().floatValue(), 0.0f);
                Assert.assertEquals(2f, transform.p().y().floatValue(), 0.0f);
                Assert.assertEquals(4f, transform.q().c(), 0.0f);
                Assert.assertEquals(6f, transform.q().s(), 0.0f);
                
                Assert.assertEquals(b2HexColor.b2_colorBlue, color);
                Assert.assertEquals(1.1f, radius, 0.0f);
                
                Assert.assertEquals(0x0CDDDl, context);
            };
            JNIB2.invoke_WORLDTRANSFORM__VEC2_FIPV(t.address(), v.address(), 1.1f, b2HexColor.b2_colorBlue, 0x0CDDDl, func.address());
        }
        try
        (
            b2Vec2 v = b2Vec2.malloc().set(1f, 2f);
            b2Rot r =  b2Rot.malloc().set(4, 6);
            b2Transform t = b2Transform.malloc().set(v, r)
        ) {

            DrawSolidCircleFcn func = DrawSolidCircleFcn.create((transform, center, radius, color, context) -> {
                Debug.apiPrint("DrawSolidCircleFcnI: transform=" + transform + ", radius=" + radius + ", color=" + color + ", context=" + context);
                Assert.assertEquals(1f, center.x(), 0.0f);
                Assert.assertEquals(2f, center.y(), 0.0f);
                Assert.assertEquals(1f, transform.p().x().floatValue(), 0.0f);
                Assert.assertEquals(2f, transform.p().y().floatValue(), 0.0f);
                Assert.assertEquals(4f, transform.q().c(), 0.0f);
                Assert.assertEquals(6f, transform.q().s(), 0.0f);
                
                Assert.assertEquals(b2HexColor.b2_colorBlue, color);
                Assert.assertEquals(1.1f, radius, 0.0f);
                
                Assert.assertEquals(0x0CDDDl, context);
            });
            func.byValue(false);
            JNIB2.invoke_WORLDTRANSFORM__VEC2_FIPV(t.address(), v.address(), 1.1f, b2HexColor.b2_colorBlue, 0x0CDDDl, func.address());
        }
        Callbacks.b2FreeCallbacks();
    }
}
