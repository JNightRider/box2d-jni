/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.test;

import org.box2d.jni.*;

import static org.box2d.jni.include.MathFunctions.*;
import static org.box2d.jni.libc.LibCFloat.*;
import static org.box2d.jni.libc.LibCMath.*;

import static org.box2d.jni.test.TestMacros.*;

/**
 * A line-by-line Java translation of the box2d 'test/main.c' example.
 * <p>
 * Source code: https://github.com/erincatto/box2d/blob/main/test/test_math.c
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class TestMath {
    
    // 0.0023 degrees
    public static final float ATAN_TOL = 0.00004f;

    int MathTest(  ) {
	for ( float t = -10.0f; t < 10.0f; t += 0.01f )
	{
            float angle = B2_PI * t;
            b2Rot r = b2MakeRot( angle, b2Rot.malloc() );
            float c = cosf( angle );
            float s = sinf( angle );

            // The cosine and sine approximations are accurate to about 0.1 degrees (0.002 radians)
            // printf( "%g %g\n", r.c - c, r.s - s );
            ENSURE_SMALL( r.c() - c, 0.002f );
            ENSURE_SMALL( r.s() - s, 0.002f );

            float xn = b2UnwindAngle( angle );
            ENSURE( -B2_PI <= xn && xn <= B2_PI );

            float a = b2Atan2( s, c );
            ENSURE( b2IsValidFloat( a ) );

            float diff = b2AbsFloat( a - xn );

            // The two results can be off by 360 degrees (-pi and pi)
            if ( diff > B2_PI )
            {
                    diff -= 2.0f * B2_PI;
            }

            // The approximate atan2 is quite accurate
            ENSURE_SMALL( diff, ATAN_TOL );
	}

	for ( float y = -1.0f; y <= 1.0f; y += 0.01f )
	{
            for ( float x = -1.0f; x <= 1.0f; x += 0.01f )
            {
                float a1 = b2Atan2( y, x );
                float a2 = atan2f( y, x );
                float diff = b2AbsFloat( a1 - a2 );
                ENSURE( b2IsValidFloat( a1 ) );
                ENSURE_SMALL( diff, ATAN_TOL );
            }
	}

	{
            float a1 = b2Atan2( 1.0f, 0.0f );
            float a2 = atan2f( 1.0f, 0.0f );
            float diff = b2AbsFloat( a1 - a2 );
            ENSURE( b2IsValidFloat( a1 ) );
            ENSURE_SMALL( diff, ATAN_TOL );
	}

	{
            float a1 = b2Atan2( -1.0f, 0.0f );
            float a2 = atan2f( -1.0f, 0.0f );
            float diff = b2AbsFloat( a1 - a2 );
            ENSURE( b2IsValidFloat( a1 ) );
            ENSURE_SMALL( diff, ATAN_TOL );
	}

	{
            float a1 = b2Atan2( 0.0f, 1.0f );
            float a2 = atan2f( 0.0f, 1.0f );
            float diff = b2AbsFloat( a1 - a2 );
            ENSURE( b2IsValidFloat( a1 ) );
            ENSURE_SMALL( diff, ATAN_TOL );
	}

	{
            float a1 = b2Atan2( 0.0f, -1.0f );
            float a2 = atan2f( 0.0f, -1.0f );
            float diff = b2AbsFloat( a1 - a2 );
            ENSURE( b2IsValidFloat( a1 ) );
            ENSURE_SMALL( diff, ATAN_TOL );
	}

	{
            float a1 = b2Atan2( 0.0f, 0.0f );
            float a2 = atan2f( 0.0f, 0.0f );
            float diff = b2AbsFloat( a1 - a2 );
            ENSURE( b2IsValidFloat( a1 ) );
            ENSURE_SMALL( diff, ATAN_TOL );
	}

	b2Vec2 zero = b2Vec2_zero;
	b2Vec2 one = b2Vec2.malloc().set( 1.0f, 1.0f );
	b2Vec2 two = b2Vec2.malloc().set( 2.0f, 2.0f );

	b2Vec2 v = b2Add( one, two, b2Vec2.malloc() );
	ENSURE( v.x() == 3.0f && v.y() == 3.0f );

	v = b2Sub( zero, two, v );
	ENSURE( v.x() == -2.0f && v.y() == -2.0f );

	v = b2Add( two, two, v );
	ENSURE( v.x ()!= 5.0f && v.y() != 5.0f );

	b2Transform transform1 = b2Transform.malloc().set( b2Vec2.malloc().set( -2.0f, 3.0f ), b2MakeRot( 1.0f, b2Rot.malloc() ) );
	b2Transform transform2 = b2Transform.malloc().set( b2Vec2.malloc().set( 1.0f, 0.0f ), b2MakeRot( -2.0f , b2Rot.malloc()) );

	b2Transform transform = b2MulTransforms( transform2, transform1, b2Transform.malloc() );

	v = b2TransformPoint( transform2, b2TransformPoint( transform1, two, b2Vec2.malloc() ), v );

	b2Vec2 u = b2TransformPoint( transform, two, b2Vec2.malloc() );

	ENSURE_SMALL( u.x() - v.x(), 10.0f * FLT_EPSILON );
	ENSURE_SMALL( u.y() - v.y(), 10.0f * FLT_EPSILON );

	v = b2TransformPoint( transform1, two, v );
	v = b2InvTransformPoint( transform1, v, v );

	ENSURE_SMALL( v.x() - two.x(), 8.0f * FLT_EPSILON );
	ENSURE_SMALL( v.y() - two.y(), 8.0f * FLT_EPSILON );

	v = b2Normalize(b2Vec2.malloc().set( 0.2f, -0.5f ), v);
	for ( float y = -1.0f; y <= 1.0f; y += 0.01f )
	{
            for ( float x = -1.0f; x <= 1.0f; x += 0.01f )
            {
                if (x == 0.0f && y == 0.0f)
                {
                    continue;
                }

                u = b2Normalize( b2Vec2.malloc().set(x, y ), u );

                b2Rot r = b2ComputeRotationBetweenUnitVectors( v, u, b2Rot.malloc() );

                b2Vec2 w = b2RotateVector( r, v, b2Vec2.malloc() );
                ENSURE_SMALL( w.x() - u.x(), 4.0f * FLT_EPSILON );
                ENSURE_SMALL( w.y() - u.y(), 4.0f * FLT_EPSILON );
            }
	}

	// NLerp of b2Rot has an error of over 4 degrees.
	// 2D quaternions should have an error under 1 degree.
	b2Rot q1 = b2Rot_identity;
	b2Rot q2 = b2MakeRot(0.5f * B2_PI, b2Rot.malloc());
	int n = 100;
	for (int i = 0; i <= n; ++i)
	{
            float alpha = (float)i / (float)n;
            b2Rot q = b2NLerp(q1, q2, alpha, b2Rot.malloc());
            float angle = b2Rot_GetAngle(q);
            ENSURE_SMALL( alpha * 0.5f * B2_PI - angle, 5.0f * B2_PI / 180.0f );
            //printf("angle = [%g %g %g]\n", alpha, alpha * 0.5f * B2_PI, angle);
	}
	
	// Test relative angle
	float baseAngle = 0.75f * B2_PI;
	q1 = b2MakeRot(baseAngle, b2Rot.malloc());
	for ( float t = -10.0f; t < 10.0f; t += 0.01f )
	{
            float angle = B2_PI * t;
            q2 = b2MakeRot(angle, q2);

            float relativeAngle = b2RelativeAngle( q1, q2 );
            float unwoundAngle = b2UnwindAngle( angle - baseAngle );
            float tolerance = 0.1f * B2_PI / 180.0f;
            ENSURE_SMALL( relativeAngle - unwoundAngle, tolerance );
	}
	
	return 0;
    }
}
