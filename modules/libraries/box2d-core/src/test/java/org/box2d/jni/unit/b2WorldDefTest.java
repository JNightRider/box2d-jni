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

import org.box2d.jni.b2TaskCallbackI;
import org.box2d.jni.b2WorldDef;
import org.box2d.jni.system.Callbacks;
import org.box2d.jni.system.JNI;

import static org.box2d.jni.system.Pointer.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * A class to manage the unit tests of the {@link b2WorldDef} class.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class b2WorldDefTest {

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
        try (b2WorldDef ptr = b2WorldDef.malloc()) {
            Assert.assertNotEquals(NULL, ptr.address());
            
            ptr.gravity().x(0.0f).y(-9.8f);

            ptr.restitutionThreshold(1.0f);
            ptr.hitEventThreshold(2.0f);
            ptr.contactHertz(60.0f);
            ptr.contactDampingRatio(0.7f);
            ptr.contactSpeed(3.0f);
            ptr.maximumLinearSpeed(100.0f);

            ptr.enableSleep(true);
            ptr.enableContinuous(true);
            ptr.enableContactSoftening(false);

            ptr.workerCount(4);

            // -------------------------------------------------
            
            ptr.frictionCallback((a, idA, b, idB) -> {
                Assert.assertEquals(1.5f, a, 0.0f);
                Assert.assertEquals(0X5FCl, idA);
                Assert.assertEquals(5.34f, b, 0.0f);
                Assert.assertEquals(0X003FFL, idB);
                return 10.5f;
            });

            ptr.restitutionCallback((a, idA, b, idB) -> {
                Assert.assertEquals(1.5f, a, 0.0f);
                Assert.assertEquals(0X5FCl, idA);
                Assert.assertEquals(5.34f, b, 0.0f);
                Assert.assertEquals(0X003FFL, idB);
                return 10.5f;
            });
            
            ptr.enqueueTask((task, taskContext, userContext) -> {
                Assert.assertNotEquals(NULL, task.address());
                Assert.assertEquals(2, taskContext);
                Assert.assertEquals(3, userContext);

                task.invoke(0x0044FCL);
                return 0x0034FL;
            });

            ptr.finishTask((userTask, userContext) -> {
                Assert.assertEquals(10L, userTask);
                Assert.assertEquals(20L, userContext);
            });

            // -------------------------------------------------
            
            ptr.userTaskContext(1111L);
            ptr.userData(2222L);
            
            ptr.capacity()
                .staticShapeCount(10)
                .dynamicShapeCount(20)
                .staticBodyCount(30)
                .dynamicBodyCount(40)
                .contactCount(50);

            ptr.internalValue(77);

            // -------------------------------------------------
            
            Assert.assertEquals(0.0f, ptr.gravity().x(), 0.0001f);
            Assert.assertEquals(-9.8f, ptr.gravity().y(), 0.0001f);

            Assert.assertEquals(1.0f, ptr.restitutionThreshold(), 0.0001f);
            Assert.assertEquals(2.0f, ptr.hitEventThreshold(), 0.0001f);
            Assert.assertEquals(60.0f, ptr.contactHertz(), 0.0001f);
            Assert.assertEquals(0.7f, ptr.contactDampingRatio(), 0.0001f);
            Assert.assertEquals(3.0f, ptr.contactSpeed(), 0.0001f);
            Assert.assertEquals(100.0f, ptr.maximumLinearSpeed(), 0.0001f);

            Assert.assertTrue(ptr.enableSleep());
            Assert.assertTrue(ptr.enableContinuous());
            Assert.assertFalse(ptr.enableContactSoftening());

            Assert.assertEquals(4, ptr.workerCount());

            // -------------------------------------------------
            
            Assert.assertEquals(1111L, ptr.userTaskContext());
            Assert.assertEquals(2222L, ptr.userData());

            Assert.assertEquals(10, ptr.capacity().staticShapeCount());
            Assert.assertEquals(20, ptr.capacity().dynamicShapeCount());
            Assert.assertEquals(30, ptr.capacity().staticBodyCount());
            Assert.assertEquals(40, ptr.capacity().dynamicBodyCount());
            Assert.assertEquals(50, ptr.capacity().contactCount());

            Assert.assertEquals(77, ptr.internalValue());

            // -------------------------------------------------
            
            float r0 = JNI.invokeFJFJF(
                    1.5f, 0X5FCl, 5.34f, 0X003FFL,
                    ptr.frictionCallback()
            );
            Assert.assertEquals(10.5f, r0, 0.0f);

            float r1 = JNI.invokeFJFJF(
                    1.5f, 0X5FCl, 5.34f, 0X003FFL,
                    ptr.restitutionCallback()
            );
            Assert.assertEquals(10.5f, r1, 0.0f);

            b2TaskCallbackI tci = (ctx) -> {
                Assert.assertEquals(0x0044FCL, ctx);
            };

            long r2 = JNI.invokePPPP(
                    tci.address(),
                    2,
                    3,
                    ptr.enqueueTask()
            );
            Assert.assertEquals(0x0034FL, r2);

            JNI.invokePPV(10, 20, ptr.finishTask());
        }
        Callbacks.b2FreeCallbacks();
    }

    /**
     * Buffer test for {@code Buffer} structures.
     */
    private void buffer() {
        b2WorldDef.Buffer ptr = b2WorldDef.malloc(3);

        Assert.assertNotEquals(NULL, ptr.address());
        Assert.assertEquals(3, ptr.remaining());

        {
            try (b2WorldDef obj = b2WorldDef.malloc()) {
                obj.gravity().x(0f).y(-10f);
                obj.workerCount(1);
                obj.enableSleep(true);
                ptr.put(obj);
            }

            try (b2WorldDef obj = b2WorldDef.malloc()) {
                obj.gravity().x(1f).y(-20f);
                obj.workerCount(2);
                obj.enableSleep(false);
                ptr.put(obj);
            }

            try (b2WorldDef obj = b2WorldDef.malloc()) {
                obj.gravity().x(2f).y(-30f);
                obj.workerCount(3);
                obj.enableSleep(true);
                ptr.put(obj);
            }
        }

        ptr.flip();

        Assert.assertEquals(3, ptr.capacity());
        Assert.assertEquals(3, ptr.remaining());

        {
            try (b2WorldDef obj = ptr.get(0)) {
                Assert.assertEquals(0f, obj.gravity().x(), 0.0001f);
                Assert.assertEquals(-10f, obj.gravity().y(), 0.0001f);
                Assert.assertEquals(1, obj.workerCount());
                Assert.assertTrue(obj.enableSleep());
            }

            try (b2WorldDef obj = ptr.get(1)) {
                Assert.assertEquals(1f, obj.gravity().x(), 0.0001f);
                Assert.assertEquals(-20f, obj.gravity().y(), 0.0001f);
                Assert.assertEquals(2, obj.workerCount());
                Assert.assertFalse(obj.enableSleep());
            }

            try (b2WorldDef obj = ptr.get(2)) {
                Assert.assertEquals(2f, obj.gravity().x(), 0.0001f);
                Assert.assertEquals(-30f, obj.gravity().y(), 0.0001f);
                Assert.assertEquals(3, obj.workerCount());
                Assert.assertTrue(obj.enableSleep());
            }
        }

        ptr.free();
    }
}
