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
package org.box2d.jni.test;

import org.box2d.jni.*

import org.box2d.jni.include.MathFunctions.*
import org.box2d.jni.libc.LibCFloat.*
import org.box2d.jni.libc.LibCMath.*
import org.box2d.jni.system.Sys.*

import org.box2d.jni.test.TestMacros.ENSURE
import org.box2d.jni.test.TestMacros.ENSURE_SMALL


/**
 * A line-by-line Java translation of the box2d 'test/test_math.c' example.
 * <p>
 * Source code: https://github.com/erincatto/box2d/blob/main/test/test_math.c
 *
 * @author wil
 * @version 1.0.0
 * @since 1.3.0
 */
class TestMath {
    companion object {
        // 0.0023 degrees
        const val ATAN_TOL: Float = 0.00004f
    }

    fun MathTest(): Int 
    {
        run {
            var t = -10.0f
            while (t < 10.0f)
            {
                val angle = B2_PI * t
                val r = b2MakeRot(angle, b2Rot.malloc())
                val c = cosf(angle)
                val s = sinf(angle)

                // The cosine and sine approximations are accurate to about 0.1 degrees (0.002 radians)
                // printf( "%g %g\n", r.c - c, r.s - s );
                ENSURE_SMALL(r.c() - c, 0.002f)
                ENSURE_SMALL(r.s() - s, 0.002f)

                val xn = b2UnwindAngle(angle)
                ENSURE(-B2_PI <= xn && xn <= B2_PI)

                val a = b2Atan2(s, c)
                ENSURE(b2IsValidFloat(a))

                var diff = b2AbsFloat(a - xn)

                // The two results can be off by 360 degrees (-pi and pi)
                if (diff > B2_PI)
                {
                    diff -= 2.0f * B2_PI
                }

                // The approximate atan2 is quite accurate
                ENSURE_SMALL(diff, ATAN_TOL)
                t += 0.01f
            }
        }

        run {
            var y = -1.0f
            while (y <= 1.0f)
            {
                var x = -1.0f
                while (x <= 1.0f)
                {
                    val a1 = b2Atan2(y, x)
                    val a2 = atan2f(y, x)
                    val diff = b2AbsFloat(a1 - a2)
                    ENSURE(b2IsValidFloat(a1))
                    ENSURE_SMALL(diff, ATAN_TOL)
                    x += 0.01f
                }
                y += 0.01f
            }
        }

        run {
            val a1 = b2Atan2(1.0f, 0.0f)
            val a2 = atan2f(1.0f, 0.0f)
            val diff = b2AbsFloat(a1 - a2)
            ENSURE(b2IsValidFloat(a1))
            ENSURE_SMALL(diff, ATAN_TOL)
        }

        run {
            val a1 = b2Atan2(-1.0f, 0.0f)
            val a2 = atan2f(-1.0f, 0.0f)
            val diff = b2AbsFloat(a1 - a2)
            ENSURE(b2IsValidFloat(a1))
            ENSURE_SMALL(diff, ATAN_TOL)
        }

        run {
            val a1 = b2Atan2(0.0f, 1.0f)
            val a2 = atan2f(0.0f, 1.0f)
            val diff = b2AbsFloat(a1 - a2)
            ENSURE(b2IsValidFloat(a1))
            ENSURE_SMALL(diff, ATAN_TOL)
        }

        run {
            val a1 = b2Atan2(0.0f, -1.0f)
            val a2 = atan2f(0.0f, -1.0f)
            val diff = b2AbsFloat(a1 - a2)
            ENSURE(b2IsValidFloat(a1))
            ENSURE_SMALL(diff, ATAN_TOL)
        }

        run {
            val a1 = b2Atan2(0.0f, 0.0f)
            val a2 = atan2f(0.0f, 0.0f)
            val diff = b2AbsFloat(a1 - a2)
            ENSURE(b2IsValidFloat(a1))
            ENSURE_SMALL(diff, ATAN_TOL)
        }

        val zero = b2Vec2_zero
        val one = b2Vec2.malloc().set(1.0f, 1.0f)
        val two = b2Vec2.malloc().set(2.0f, 2.0f)

        var v = b2Add(one, two, b2Vec2.malloc())
        ENSURE(v.x() == 3.0f && v.y() == 3.0f)

        v = b2Sub(zero, two, v)
        ENSURE(v.x() == -2.0f && v.y() == -2.0f)

        v = b2Add(two, two, v)
        ENSURE(v.x() != 5.0f && v.y() != 5.0f)

        val transform1 = b2Transform.malloc().set(b2Vec2.malloc().set(-2.0f, 3.0f), b2MakeRot(1.0f, b2Rot.malloc()))
        val transform2 = b2Transform.malloc().set(b2Vec2.malloc().set(1.0f, 0.0f), b2MakeRot(-2.0f, b2Rot.malloc()))

        val transform = b2MulTransforms(transform2, transform1, b2Transform.malloc())

        v = b2TransformPoint( transform2, b2TransformPoint(transform1, two, b2Vec2.malloc()), v )

        var u = b2TransformPoint(transform, two, b2Vec2.malloc())

        ENSURE_SMALL(u.x() - v.x(), 10.0f * FLT_EPSILON)
        ENSURE_SMALL(u.y() - v.y(), 10.0f * FLT_EPSILON)

        v = b2TransformPoint(transform1, two, v)
        v = b2InvTransformPoint(transform1, v, v)

        ENSURE_SMALL(v.x() - two.x(), 8.0f * FLT_EPSILON)
        ENSURE_SMALL(v.y() - two.y(), 8.0f * FLT_EPSILON)

        v = b2Normalize(b2Vec2.malloc().set(0.2f, -0.5f), v)
        var y = -1.0f
        while (y <= 1.0f)
        {
            var x = -1.0f
            while (x <= 1.0f)
            {
                if (x == 0.0f && y == 0.0f)
                {
                    x += 0.01f
                    continue
                }

                u = b2Normalize(b2Vec2.malloc().set(x, y), u)

                val r = b2ComputeRotationBetweenUnitVectors(v, u, b2Rot.malloc())

                val w = b2RotateVector(r, v, b2Vec2.malloc())
                ENSURE_SMALL(w.x() - u.x(), 4.0f * FLT_EPSILON)
                ENSURE_SMALL(w.y() - u.y(), 4.0f * FLT_EPSILON)
                x += 0.01f
            }
            y += 0.01f
        }

        // NLerp of b2Rot has an error of over 4 degrees.
        // 2D quaternions should have an error under 1 degree.
        var q1 = b2Rot_identity
        var q2 = b2MakeRot(0.5f * B2_PI, b2Rot.malloc())
        val n = 100
        for (i in 0..n)
        {
            val alpha = i.toFloat() / n.toFloat()
            val q = b2NLerp(q1, q2, alpha, b2Rot.malloc())
            val angle = b2Rot_GetAngle(q)
            ENSURE_SMALL( alpha * 0.5f * B2_PI - angle, 5.0f * B2_PI / 180.0f )
            //printf("angle = [%g %g %g]\n", alpha, alpha * 0.5f * B2_PI, angle);
        }

        // Test relative angle
        val baseAngle = 0.75f * B2_PI
        q1 = b2MakeRot(baseAngle, b2Rot.malloc())
        var t = -10.0f
        while (t < 10.0f)
        {
            val angle = B2_PI * t
            q2 = b2MakeRot(angle, q2)

            val relativeAngle = b2RelativeAngle(q1, q2)
            val unwoundAngle = b2UnwindAngle(angle - baseAngle)
            val tolerance = 0.1f * B2_PI / 180.0f
            ENSURE_SMALL(relativeAngle - unwoundAngle, tolerance)
            t += 0.01f
        }

        // World position boundary helpers. With large world mode off these collapse to the float
        // ops, so the round trips hold in both builds.
        run {
            val d = b2Vec2.malloc().set(0.25f, -0.5f)
            val base = b2Pos.malloc().set(10.0f, -20.0f)
            val p = b2OffsetPos(base, d, b2Pos.malloc())
            val back = b2SubPos(p, base, b2Vec2.malloc())
            ENSURE_SMALL(back.x() - d.x(), 8.0f * FLT_EPSILON)
            ENSURE_SMALL(back.y() - d.y(), 8.0f * FLT_EPSILON)

            val r = b2ToVec2(base, b2Vec2.malloc())
            ENSURE(r.x() == 10.0f && r.y() == -20.0f)

            ENSURE(b2IsValidPosition(p))
            ENSURE(b2IsValidPosition(b2Pos_zero))
            ENSURE(b2IsValidWorldTransform(b2WorldTransform_identity))

            val wt = b2WorldTransform.malloc().set(b2Pos.malloc().set(3.0f, -4.0f), b2MakeRot(0.7f, b2Rot.malloc()))
            ENSURE(b2IsValidWorldTransform(wt))

            // Local to world to local round trip
            val local = b2Vec2.malloc().set(1.5f, 2.5f)
            val world = b2TransformWorldPoint(wt, local, b2Pos.malloc())
            val backLocal = b2InvTransformWorldPoint(wt, world, b2Vec2.malloc())
            ENSURE_SMALL(backLocal.x() - local.x(), 8.0f * FLT_EPSILON)
            ENSURE_SMALL(backLocal.y() - local.y(), 8.0f * FLT_EPSILON)

            // Relative transform of B in A matches a float reference at modest coordinates
            val A = b2WorldTransform.malloc().set(b2Pos.malloc().set(-2.0f, 3.0f), b2MakeRot(1.0f, b2Rot.malloc()))
            val B = b2WorldTransform.malloc().set(b2Pos.malloc().set(1.0f, 0.0f), b2MakeRot(-2.0f, b2Rot.malloc()))
            val rel = b2InvMulWorldTransforms(A, B, b2Transform.malloc())
            val refA = b2Transform.malloc().set(b2ToVec2(A.p(), b2Vec2.malloc()), A.q())
            val refB = b2Transform.malloc().set(b2ToVec2(B.p(), b2Vec2.malloc()), B.q())
            val ref = b2InvMulTransforms(refA, refB, b2Transform.malloc())
            ENSURE_SMALL(rel.p().x() - ref.p().x(), 8.0f * FLT_EPSILON)
            ENSURE_SMALL(rel.p().y() - ref.p().y(), 8.0f * FLT_EPSILON)
        }

if (defined(BOX2D_DOUBLE_PRECISION)) {
        // Far from the origin a float vector cannot resolve sub meter motion, but a double world
        // position can. This is the whole point of large world mode.
        run {
            val d = b2Vec2.malloc().set(0.25f, -0.5f)
            val base = b2Pos.malloc().set(1.0e7f, 0.0f)
            val p = b2OffsetPos(base, d, b2Pos.malloc())
            val back = b2SubPos(p, base, b2Vec2.malloc())
            ENSURE_SMALL(back.x() - d.x(), 1.0e-4f)
            ENSURE_SMALL(back.y() - d.y(), 1.0e-4f)
        }
}

        return 0
    }
}