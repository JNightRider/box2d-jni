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
import static org.box2d.jni.libc.LibCMath.*;

import static org.box2d.jni.test.TestMacros.*;

/**
 * A line-by-line Java translation of the box2d 'test/test_shape.c' example.
 * <p>
 * Source code: https://github.com/erincatto/box2d/blob/main/test/test/test_shape.c
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class TestShape {

    static b2Capsule capsule = b2Capsule.malloc().set( b2Vec2.malloc().set( -1.0f, 0.0f ), b2Vec2.malloc().set( 1.0f, 0.0f ), 1.0f );
    static b2Circle circle = b2Circle.malloc().set( b2Vec2.malloc().set( 1.0f, 0.0f ), 1.0f );
    static b2Polygon box = b2Polygon.malloc();
    static b2Segment segment = b2Segment.malloc().set( b2Vec2.malloc().set( 0.0f, 1.0f ), b2Vec2.malloc().set( 0.0f, -1.0f ) );

    public static final int N = 4;

    static int ShapeMassTest( )
    {
        {
            b2MassData md = b2ComputeCircleMass( circle, 1.0f, b2MassData.malloc() );
            ENSURE_SMALL( md.mass() - B2_PI, FLT_EPSILON );
            ENSURE( md.center().x() == 1.0f && md.center().y() == 0.0f );
            ENSURE_SMALL( md.rotationalInertia() - 0.5f * B2_PI, FLT_EPSILON );
        }

        {
            float radius = capsule.radius();
            float length = b2Distance( capsule.center1(), capsule.center2() );

            b2MassData md = b2ComputeCapsuleMass( capsule, 1.0f, b2MassData.malloc() );

            // Box that full contains capsule
            b2Polygon r = b2MakeBox( radius + 0.5f * length, radius, b2Polygon.malloc() );
            b2MassData mdUpper = b2ComputePolygonMass( r, 1.0f, b2MassData.malloc() );

            // Approximate capsule using convex hull
            b2Vec2.Buffer points = b2Vec2.malloc(2 * N);
            float d = B2_PI / ( N - 1.0f );
            float angle = -0.5f * B2_PI;
            for ( int i = 0; i < N; ++i )
            {
                points.get(i).x(1.0f + radius * cosf( angle ));
                points.get(i).y(radius * sinf( angle ));
                angle += d;
            }

            angle = 0.5f * B2_PI;
            for ( int i = N; i < 2 * N; ++i )
            {
                points.get(i).x(-1.0f + radius * cosf( angle ));
                points.get(i).y(radius * sinf( angle ));
                angle += d;
            }

            b2Hull hull = b2ComputeHull( points, 2 * N, b2Hull.malloc() );
            b2Polygon ac = b2MakePolygon( hull, 0.0f, b2Polygon.malloc() );
            b2MassData mdLower = b2ComputePolygonMass( ac, 1.0f, b2MassData.malloc() );

            ENSURE( mdLower.mass() < md.mass() && md.mass() < mdUpper.mass() );
            ENSURE( mdLower.rotationalInertia() < md.rotationalInertia() && md.rotationalInertia() < mdUpper.rotationalInertia() );
        }

        {
            b2MassData md = b2ComputePolygonMass( box, 1.0f, b2MassData.malloc() );
            ENSURE_SMALL( md.mass() - 4.0f, FLT_EPSILON );
            ENSURE_SMALL( md.center().x(), FLT_EPSILON );
            ENSURE_SMALL( md.center().y(), FLT_EPSILON );
            ENSURE_SMALL( md.rotationalInertia() - 8.0f / 3.0f, 2.0f * FLT_EPSILON );
        }

        {
            b2Vec2 offset = b2Vec2.malloc().set(0.4f, -0.7f);
            b2Polygon b1 = b2MakeBox( 0.25f, 0.5f, b2Polygon.malloc() );
            b2Polygon b2 = b2MakeOffsetBox( 0.25f, 0.5f, offset, b2Rot_identity, b2Polygon.malloc() );

            b2MassData m1 = b2ComputePolygonMass( b1, 1.0f, b2MassData.malloc() );
            b2MassData m2 = b2ComputePolygonMass( b2, 1.0f, b2MassData.malloc() );

            ENSURE_SMALL( m1.mass() - m2.mass(), FLT_EPSILON );
            ENSURE_SMALL( m1.rotationalInertia() - m2.rotationalInertia(), FLT_EPSILON );
            ENSURE_SMALL( m2.center().x() - offset.x(), FLT_EPSILON );
            ENSURE_SMALL( m2.center().y() - offset.y(), FLT_EPSILON );
        }

        return 0;
    }

    static int ShapeAABBTest( )
    {
        {
            b2AABB b = b2ComputeCircleAABB( circle, b2Transform_identity, b2AABB.malloc() );
            ENSURE_SMALL( b.lowerBound().x(), FLT_EPSILON );
            ENSURE_SMALL( b.lowerBound().y() + 1.0f, FLT_EPSILON );
            ENSURE_SMALL( b.upperBound().x() - 2.0f, FLT_EPSILON );
            ENSURE_SMALL( b.upperBound().y() - 1.0f, FLT_EPSILON );
        }

        {
            b2AABB b = b2ComputePolygonAABB( box, b2Transform_identity, b2AABB.malloc() );
            ENSURE_SMALL( b.lowerBound().x() + 1.0f, FLT_EPSILON );
            ENSURE_SMALL( b.lowerBound().y() + 1.0f, FLT_EPSILON );
            ENSURE_SMALL( b.upperBound().x() - 1.0f, FLT_EPSILON );
            ENSURE_SMALL( b.upperBound().y() - 1.0f, FLT_EPSILON );
        }

        {
            b2AABB b = b2ComputeSegmentAABB( segment, b2Transform_identity, b2AABB.malloc() );
            ENSURE_SMALL( b.lowerBound().x(), FLT_EPSILON );
            ENSURE_SMALL( b.lowerBound().y() + 1.0f, FLT_EPSILON );
            ENSURE_SMALL( b.upperBound().x(), FLT_EPSILON );
            ENSURE_SMALL( b.upperBound().y() - 1.0f, FLT_EPSILON );
        }

        return 0;
    }

    static int PointInShapeTest( )
    {
        b2Vec2 p1 = b2Vec2.malloc().set( 0.5f, 0.5f );
        b2Vec2 p2 = b2Vec2.malloc().set( 4.0f, -4.0f );

        {
            boolean hit;
            hit = b2PointInCircle( circle,  p1 );
            ENSURE( hit == true );
            hit = b2PointInCircle( circle, p2 );
            ENSURE( hit == false );
        }

        {
            boolean hit;
            hit = b2PointInPolygon( box,  p1);
            ENSURE( hit == true );
            hit = b2PointInPolygon(box,  p2);
            ENSURE( hit == false );
        }

        return 0;
    }

    static int RayCastShapeTest(  )
    {
        b2RayCastInput input = b2RayCastInput.malloc().set( b2Vec2.malloc().set( -4.0f, 0.0f ), b2Vec2.malloc().set( 8.0f, 0.0f ), 1.0f );

        {
            b2CastOutput output = b2RayCastCircle( circle, input, b2CastOutput.malloc() );
            ENSURE( output.hit() );
            ENSURE_SMALL( output.normal().x ()+ 1.0f, FLT_EPSILON );
            ENSURE_SMALL( output.normal().y(), FLT_EPSILON );
            ENSURE_SMALL( output.fraction() - 0.5f, FLT_EPSILON );
        }

        {
            b2CastOutput output = b2RayCastPolygon( box, input, b2CastOutput.malloc() );
            ENSURE( output.hit() );
            ENSURE_SMALL( output.normal().x() + 1.0f, FLT_EPSILON );
            ENSURE_SMALL( output.normal().y(), FLT_EPSILON );
            ENSURE_SMALL( output.fraction() - 3.0f / 8.0f, FLT_EPSILON );
        }

        {
            b2CastOutput output = b2RayCastSegment( segment, input, true, b2CastOutput.malloc() );
            ENSURE( output.hit() );
            ENSURE_SMALL( output.normal().x() + 1.0f, FLT_EPSILON );
            ENSURE_SMALL( output.normal().y(), FLT_EPSILON );
            ENSURE_SMALL( output.fraction() - 0.5f, FLT_EPSILON );
        }

        return 0;
    }

    int ShapeTest( )
    {
        box = b2MakeBox( 1.0f, 1.0f, b2Polygon.malloc() );

        RUN_SUBTEST(() -> ShapeMassTest() );
        RUN_SUBTEST(() -> ShapeAABBTest() );
        RUN_SUBTEST(() -> PointInShapeTest() );
        RUN_SUBTEST(() -> RayCastShapeTest() );

        return 0;
    }
}
