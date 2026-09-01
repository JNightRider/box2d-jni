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
package org.box2d.jni.test

import org.box2d.jni.*

import org.box2d.jni.b2TOIState.*
import org.box2d.jni.include.Collision.*
import org.box2d.jni.include.Constants.*
import org.box2d.jni.include.MathFunctions.*

import org.box2d.jni.libc.LibCFloat.*
import org.box2d.jni.system.Pointer.*

import org.box2d.jni.test.TestMacros.ARRAY_COUNT
import org.box2d.jni.test.TestMacros.ENSURE
import org.box2d.jni.test.TestMacros.ENSURE_SMALL
import org.box2d.jni.test.TestMacros.RUN_SUBTEST

/**
 * A line-by-line Java translation of the box2d 'test/test_distance.c' example.
 * <p>
 * Source code: https://github.com/erincatto/box2d/blob/main/test/test_distance.c
 *
 * @author wil
 * @version 1.0.0
 * @since 1.3.0
 */
class TestDistance {
    companion object {
        const val B2_SHORT_EDGE_CAST_REPRO = true
    }

    fun SegmentDistanceTest( ): Int
    {
        val p1 = b2Vec2.malloc().set( -1.0f, -1.0f )
        val q1 = b2Vec2.malloc().set( -1.0f, 1.0f )
        val p2 = b2Vec2.malloc().set( 2.0f, 0.0f )
        val q2 = b2Vec2.malloc().set( 1.0f, 0.0f )

        val result = b2SegmentDistance( p1, q1, p2, q2, b2SegmentDistanceResult.malloc() )

        ENSURE_SMALL( result.fraction1() - 0.5f, FLT_EPSILON )
        ENSURE_SMALL( result.fraction2() - 1.0f, FLT_EPSILON )
        ENSURE_SMALL( result.closest1().x() + 1.0f, FLT_EPSILON )
        ENSURE_SMALL( result.closest1().y(), FLT_EPSILON )
        ENSURE_SMALL( result.closest2().x() - 1.0f, FLT_EPSILON )
        ENSURE_SMALL( result.closest2().y(), FLT_EPSILON )
        ENSURE_SMALL( result.distanceSquared() - 4.0f, FLT_EPSILON )

        return 0
    }

    fun ShapeDistanceTest(): Int
    {
        val vas = b2Vec2.mallocSafe(b2Vec2.malloc().set( -1.0f, -1.0f ), b2Vec2.malloc().set( 1.0f, -1.0f ), b2Vec2.malloc().set( 1.0f, 1.0f ), b2Vec2.malloc().set( -1.0f, 1.0f ) )

        val vbs = b2Vec2.mallocSafe(
                b2Vec2.malloc().set( 2.0f, -1.0f ),
                b2Vec2.malloc().set( 2.0f, 1.0f )
        )

        val input = b2DistanceInput.malloc();input.clear()
        input.proxyA(b2MakeProxy( vas, ARRAY_COUNT( vas ), 0.0f , b2ShapeProxy.malloc() ))
        input.proxyB(b2MakeProxy( vbs, ARRAY_COUNT( vbs ), 0.0f, b2ShapeProxy.malloc() ))
        input.transform(b2Transform_identity)
        input.useRadii(false)

        val cache = b2SimplexCache.calloc()
        val output = b2DistanceOutput.malloc();nb2ShapeDistance(input.address(), cache.address(), NULL, 0, output.address() )

        ENSURE_SMALL( output.distance() - 1.0f, FLT_EPSILON );

        return 0
    }

    fun ShapeCastTest( ): Int
    {
        val vas = b2Vec2.mallocSafe(b2Vec2.malloc().set( -1.0f, -1.0f ), b2Vec2.malloc().set( 1.0f, -1.0f ), b2Vec2.malloc().set( 1.0f, 1.0f ), b2Vec2.malloc().set( -1.0f, 1.0f ) )

        val vbs = b2Vec2.mallocSafe(
            b2Vec2.malloc().set( 2.0f, -1.0f ),
                b2Vec2.malloc().set( 2.0f, 1.0f )
        )

        val input = b2ShapeCastPairInput.calloc()
        input.proxyA(b2MakeProxy( vas, ARRAY_COUNT( vas ), 0.0f, b2ShapeProxy.malloc() ))
        input.proxyB(b2MakeProxy( vbs, ARRAY_COUNT( vbs ), 0.0f, b2ShapeProxy.malloc() ))
        input.transform(b2Transform_identity)
        input.translationB(b2Vec2.malloc().set( -2.0f, 0.0f ))
        input.maxFraction(1.0f)
        input.canEncroach(false)

        val output = b2ShapeCast( input, b2CastOutput.malloc() )

        ENSURE( output.hit() );
        ENSURE_SMALL( output.fraction() - 0.5f, 0.005f );

        return 0;
    }

    // A thin plank and a point a linear slop off the middle of its short end face. The closest feature
    // is that end face, so GJK finishes on a two point simplex spanning it.
    //
    // b2SolveSimplex2 hands back a search direction of magnitude 2 * distance * edge^2, which the
    // caller weighs against an absolute epsilon. That test is cubic in length, so it gives out on
    // short edges: below an edge of about 3.5 mm at default length units it declares the shapes
    // overlapped and returns a zero distance with no normal, though they are plainly apart.
    //
    // Measured cutoff matches 2 * distance * edge^2 < FLT_EPSILON to three digits, and it tracks the
    // contact edge alone. Widening the plank from 1 m to 100 m changes nothing.
    fun ShapeDistanceShortEdgeTest( ): Int
    {
        val halfThickness = 0.0016f

        val corners = b2Vec2.mallocSafe(
                b2Vec2.malloc().set( -0.5f, -halfThickness ),
                    b2Vec2.malloc().set( 0.5f, -halfThickness ),
                    b2Vec2.malloc().set( 0.5f, halfThickness ),
                    b2Vec2.malloc().set( -0.5f, halfThickness )
        )

        val point = b2Vec2.malloc().set( 0.5f + B2_LINEAR_SLOP, 0.0f )

        val input = b2DistanceInput.calloc()
        input.proxyA(b2MakeProxy( corners, ARRAY_COUNT( corners ), 0.0f, b2ShapeProxy.malloc() ))
        run {
            val proxy = b2ShapeProxy.malloc()
            nb2MakeProxy( point.address(), 1, 0.0f, proxy.address() )
            input.proxyB(proxy)
        }
        input.transform(b2Transform_identity)
        input.useRadii(false)

        val cache = b2SimplexCache.calloc()
        val output = b2ShapeDistance( input, cache, null, 0, b2DistanceOutput.malloc() )

        ENSURE( output.distance() > 0.0f )
        ENSURE( b2IsNormalized( output.normal() ) )
        ENSURE_SMALL( output.distance() - B2_LINEAR_SLOP, 1e-6f )

        return 0
    }

    // The same false overlap seen through b2ShapeCast, which is how it was reported.
    //
    // Conservative advancement stops the cores a target apart and target is at least a linear slop, so
    // the query can never legitimately answer overlap after the first iteration. Here iteration 1 does,
    // and b2ShapeCast has no fallback: it trips
    // B2_ASSERT( distanceOutput.distance > 0.0f && b2IsNormalized( distanceOutput.normal ) ).
    //
    // Enable once b2ShapeDistance stops reporting the false overlap. The assert aborts the run, so
    // leaving it on would take the rest of the suite with it.
    fun ShapeCastShortEdgeTest(): Int
    {
        val halfThickness = 0.0002f

        val corners = b2Vec2.mallocSafe(
                b2Vec2.malloc().set( -0.5f, -halfThickness ),
                b2Vec2.malloc().set( 0.5f, -halfThickness ),
                b2Vec2.malloc().set( 0.5f, halfThickness ),
                b2Vec2.malloc().set( -0.5f, halfThickness )
        )

        // falls past the end of the plank and drifts into it, so the second query lands on the end face
        val start = b2Vec2.malloc().set( 0.506f, 0.0035f )

        val input = b2ShapeCastPairInput.calloc()
        input.proxyA(b2MakeProxy( corners, ARRAY_COUNT( corners ), 0.0f, b2ShapeProxy.malloc() ))
        run {
            val proxy = b2ShapeProxy.malloc()
            nb2MakeProxy( start.address(), 1, 0.0f, proxy.address() )
            input.proxyB(proxy)
        }
        input.transform(b2Transform_identity)
        input.translationB(b2Vec2.malloc().set( -0.01f, -0.5f ))
        input.maxFraction(1.0f)
        input.canEncroach(false)

        val output = b2ShapeCast( input, b2CastOutput.malloc() )

        ENSURE( output.hit() == false || b2IsNormalized( output.normal() ) )

        return 0
    }

    fun TimeOfImpactTest( ): Int
    {
        val vas = b2Vec2.mallocSafe(b2Vec2.malloc().set( -1.0f, -1.0f ), b2Vec2.malloc().set( 1.0f, -1.0f ), b2Vec2.malloc().set( 1.0f, 1.0f ), b2Vec2.malloc().set( -1.0f, 1.0f ) )

        val vbs = b2Vec2.mallocSafe(
                b2Vec2.malloc().set( 2.0f, -1.0f ),
                b2Vec2.malloc().set( 2.0f, 1.0f )
        )

        val input = b2TOIInput.malloc()
        input.proxyA(b2MakeProxy( vas, ARRAY_COUNT( vas ), 0.0f, b2ShapeProxy.malloc() ))
        input.proxyB(b2MakeProxy( vbs, ARRAY_COUNT( vbs ), 0.0f, b2ShapeProxy.malloc() ))
        input.sweepA( b2Sweep.malloc().set( b2Vec2_zero, b2Vec2_zero, b2Vec2_zero, b2Rot_identity, b2Rot_identity ))
        input.sweepB( b2Sweep.malloc().set( b2Vec2_zero, b2Vec2_zero, b2Vec2.malloc().set( -2.0f, 0.0f ), b2Rot_identity, b2Rot_identity ))
        input.maxFraction(1.0f);

        val output = b2TimeOfImpact( input, b2TOIOutput.malloc() )

        ENSURE( output.state() == b2_toiStateHit )
        ENSURE_SMALL( output.fraction() - 0.5f, 0.005f )

        return 0;
    }

    fun DistanceTest( ): Int
    {
        RUN_SUBTEST( ::SegmentDistanceTest )
        RUN_SUBTEST( ::ShapeDistanceTest )
        RUN_SUBTEST( ::ShapeCastTest )
        RUN_SUBTEST( ::ShapeDistanceShortEdgeTest )
if (B2_SHORT_EDGE_CAST_REPRO) {
        RUN_SUBTEST( ::ShapeCastShortEdgeTest )
}
        RUN_SUBTEST( ::TimeOfImpactTest )

        return 0
    }
}