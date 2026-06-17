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

import org.box2d.jni.b2Rot;
import org.box2d.jni.b2Transform;
import org.box2d.jni.draw.DrawTransformFcn;
import org.box2d.jni.draw.DrawTransformFcnI;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.Debug;
import org.box2d.jni.system.JNIB2;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link DrawTransformFcn} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class DrawTransformFcnTest {
    /**
     * Initialize all tests.
     */
    @Test
    public void callback() {
        try
        (
            b2Vec2 v = b2Vec2.malloc().set(1f, 2f);
            b2Rot r =  b2Rot.malloc().set(4, 6);
            b2Transform t = b2Transform.malloc().set(v, r)
        ) {

            DrawTransformFcnI func = (transform, context) -> {
                Debug.apiPrint("DrawTransformFcnI: transform=" + transform + ", context=" + context);
                Assert.assertEquals(1f, transform.p().x(), 0.0f);
                Assert.assertEquals(2f, transform.p().y(), 0.0f);
                Assert.assertEquals(4f, transform.q().c(), 0.0f);
                Assert.assertEquals(6f, transform.q().s(), 0.0f);                
                Assert.assertEquals(0x0ddccc, context);
            };
            JNIB2.invoke_TRANSFORM_PV(t.address(), 0x0ddccc, func.address());
        }
        try
        (
            b2Vec2 v = b2Vec2.malloc().set(1f, 2f);
            b2Rot r =  b2Rot.malloc().set(4, 6);
            b2Transform t = b2Transform.malloc().set(v, r)
        ) {

            DrawTransformFcn func = DrawTransformFcn.create((transform, context) -> {
                Debug.apiPrint("DrawTransformFcn: transform=" + transform + ", context=" + context);
                Assert.assertEquals(1f, transform.p().x(), 0.0f);
                Assert.assertEquals(2f, transform.p().y(), 0.0f);
                Assert.assertEquals(4f, transform.q().c(), 0.0f);
                Assert.assertEquals(6f, transform.q().s(), 0.0f);                
                Assert.assertEquals(0x0ddccc, context);
            });
            func.byValue(false);
            JNIB2.invoke_TRANSFORM_PV(t.address(), 0x0ddccc, func.address());
        }
        Callbacks.b2FreeCallbacks();
    }
}
