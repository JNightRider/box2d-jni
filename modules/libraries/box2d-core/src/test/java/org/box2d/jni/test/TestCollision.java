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

import org.box2d.jni.*;

import static org.box2d.jni.include.Collision.*;
import static org.box2d.jni.include.MathFunctions.*;
import static org.box2d.jni.libc.LibCFloat.*;
import static org.box2d.jni.system.Sys.*;
import static org.box2d.jni.test.TestMacros.*;

/**
 * A line-by-line Java translation of the box2d 'test/test_collision.c' example.
 * <p>
 * Source code: https://github.com/erincatto/box2d/blob/main/test/test_collision.c
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class TestCollision {

    static int AABBTest( )
    {
        b2AABB a = b2AABB.malloc();
        a.lowerBound(b2Vec2.malloc().set( -1.0f, -1.0f ));
        a.upperBound(b2Vec2.malloc().set( -2.0f, -2.0f));

        ENSURE( b2IsValidAABB( a ) == false );

        a.upperBound(b2Vec2.malloc().set( 1.0f, 1.0f ));
        ENSURE( b2IsValidAABB( a ) == true );

        b2AABB b = b2AABB.malloc().set( b2Vec2.malloc().set( 2.0f, 2.0f ), b2Vec2.malloc().set( 4.0f, 4.0f ) );
        ENSURE( b2AABB_Overlaps( a, b ) == false );
        ENSURE( b2AABB_Contains( a, b ) == false );

        return 0;
    }

    // The narrow phase differences the two world positions in double then works in frame A, so a
    // manifold far from the origin must match the same manifold at the origin. Float loses this past
    // ~1e7 m where the ULP grows larger than the overlap, which is the whole point of large world mode.
    @SuppressWarnings("unchecked")
    static int LargeWorldManifoldTest( )
    {
            b2Polygon boxA = b2MakeBox( 0.5f, 0.5f, b2Polygon.malloc() );
            b2Polygon boxB = b2MakeBox( 0.5f, 0.5f, b2Polygon.malloc() );

            // Centers 0.9 apart so the boxes overlap by 0.1 along x
            b2Vec2 sep = b2Vec2.malloc().set( 0.9f, 0.0f );

            b2WorldTransform xfAo = b2WorldTransform_identity;            
            b2WorldTransform xfBo = b2WorldTransform.malloc().set( b2OffsetPos( b2Pos_zero, sep, b2Pos.malloc() ), b2Rot_identity );
            b2LocalManifold mOrigin = b2CollidePolygons( boxA, boxB, b2InvMulWorldTransforms( xfAo, xfBo, b2Transform.malloc() ), b2LocalManifold.malloc() );

            ENSURE( mOrigin.pointCount() == 2 );
            ENSURE_SMALL( mOrigin.points().get(0).separation() + 0.1f, 0.01f );
            ENSURE_SMALL( mOrigin.points().get(1).separation() + 0.1f, 0.01f );

if (defined( BOX2D_DOUBLE_PRECISION )) {
            // Same relative configuration shifted far from the origin. The relative pose differences the
            // world positions in double, so in double the frame A manifold is preserved to float precision.
            // In float it would collapse since the offset is below the ULP.
            b2Pos base = b2OffsetPos( b2Pos_zero, b2Vec2.malloc().set( 1.0e7f, 1.0e7f ), b2Pos.malloc() );
            b2WorldTransform xfAl = b2WorldTransform.malloc().set( base, b2Rot_identity );
            b2WorldTransform xfBl = b2WorldTransform.malloc().set( b2OffsetPos( base, sep, b2Pos.malloc() ), b2Rot_identity );
            b2LocalManifold mLarge = b2CollidePolygons( boxA, boxB, b2InvMulWorldTransforms( xfAl, xfBl, b2Transform.malloc() ), b2LocalManifold.malloc() );

            ENSURE( mLarge.pointCount() == mOrigin.pointCount() );
            ENSURE_SMALL( mLarge.normal().x() - mOrigin.normal().x(), 1e-4f );
            ENSURE_SMALL( mLarge.normal().y() - mOrigin.normal().y(), 1e-4f );
            for ( int i = 0; i < mLarge.pointCount(); ++i )
            {
                ENSURE_SMALL( mLarge.points().get(i).separation() - mOrigin.points().get(i).separation(), 1e-4f );
                ENSURE_SMALL( mLarge.points().get(i).point().x() - mOrigin.points().get(i).point().x(), 1e-4f );
                ENSURE_SMALL( mLarge.points().get(i).point().y() - mOrigin.points().get(i).point().y(), 1e-4f );
            }
}

            return 0;
    }

    // Broad-phase AABBs are built in double and narrowed to float with directed outward rounding, so a
    // shape and its speculative margin stay inside their box far from the origin. A float build would
    // round the extent away into the ULP (~1 m at 1e7) and clip the shape out of its own box.
    @SuppressWarnings("unchecked")
    static int LargeWorldAABBTest( )
    {
            // Rounded box: 0.5 half extents plus 0.1 radius, so the tight extent is 0.6 each way
            b2Polygon box = b2MakeRoundedBox( 0.5f, 0.5f, 0.1f, b2Polygon.malloc() );

            b2AABB aabbOrigin = b2ComputePolygonAABB( box, b2WorldTransform_identity, b2AABB.malloc() );
            ENSURE_SMALL( aabbOrigin.lowerBound().x() + 0.6f, FLT_EPSILON );
            ENSURE_SMALL( aabbOrigin.lowerBound().y() + 0.6f, FLT_EPSILON );
            ENSURE_SMALL( aabbOrigin.upperBound().x() - 0.6f, FLT_EPSILON );
            ENSURE_SMALL( aabbOrigin.upperBound().y() - 0.6f, FLT_EPSILON );

if (defined( BOX2D_DOUBLE_PRECISION )) {
            double d = 1.0e7;
            b2WorldTransform xfLarge = b2WorldTransform.malloc().set( b2Pos.malloc().set( d, d ), b2Rot_identity );

            // Tight world AABB still contains the 0.6 m extent
            b2AABB tight = b2ComputePolygonAABB( box, xfLarge, b2AABB.malloc() );
            ENSURE( (double)tight.lowerBound().x() <= d - 0.6 );
            ENSURE( (double)tight.lowerBound().y() <= d - 0.6 );
            ENSURE( (double)tight.upperBound().x() >= d + 0.6 );
            ENSURE( (double)tight.upperBound().y() >= d + 0.6 );
}

            return 0;
    }

    int CollisionTest( )
    {
        RUN_SUBTEST(() -> AABBTest() );
        RUN_SUBTEST(() -> LargeWorldManifoldTest() );
        RUN_SUBTEST(() -> LargeWorldAABBTest() );
        return 0;
    }
}
