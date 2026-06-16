/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.test;

import org.box2d.jni.*;

import static org.box2d.jni.b2TOIState.*;
import static org.box2d.jni.include.Collision.*;
import static org.box2d.jni.include.MathFunctions.*;

import static org.box2d.jni.libc.LibCFloat.*;
import static org.box2d.jni.system.Pointer.*;

import static org.box2d.jni.test.TestMacros.*;

/**
 * A line-by-line Java translation of the box2d 'test/test_distance.c' example.
 * <p>
 * Source code: https://github.com/erincatto/box2d/blob/main/test/test_distance.c
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class TestDistance {

    static int SegmentDistanceTest( )
    {
        b2Vec2 p1 = b2Vec2.malloc().set( -1.0f, -1.0f );
        b2Vec2 q1 = b2Vec2.malloc().set( -1.0f, 1.0f );
        b2Vec2 p2 = b2Vec2.malloc().set( 2.0f, 0.0f );
        b2Vec2 q2 = b2Vec2.malloc().set( 1.0f, 0.0f );

        b2SegmentDistanceResult result = b2SegmentDistance( p1, q1, p2, q2, b2SegmentDistanceResult.malloc() );

        ENSURE_SMALL( result.fraction1() - 0.5f, FLT_EPSILON );
        ENSURE_SMALL( result.fraction2() - 1.0f, FLT_EPSILON );
        ENSURE_SMALL( result.closest1().x() + 1.0f, FLT_EPSILON );
        ENSURE_SMALL( result.closest1().y(), FLT_EPSILON );
        ENSURE_SMALL( result.closest2().x() - 1.0f, FLT_EPSILON );
        ENSURE_SMALL( result.closest2().y(), FLT_EPSILON );
        ENSURE_SMALL( result.distanceSquared() - 4.0f, FLT_EPSILON );

        return 0;
    }

    static int ShapeDistanceTest()
    {
        b2Vec2.Buffer vas = b2Vec2.mallocSafe(b2Vec2.malloc().set( -1.0f, -1.0f ), b2Vec2.malloc().set( 1.0f, -1.0f ), b2Vec2.malloc().set( 1.0f, 1.0f ), b2Vec2.malloc().set( -1.0f, 1.0f ) );
        vas.flip();

        b2Vec2.Buffer vbs = b2Vec2.mallocSafe(
                b2Vec2.malloc().set( 2.0f, -1.0f ),
                b2Vec2.malloc().set( 2.0f, 1.0f )
        );
        vbs.flip();

        b2DistanceInput input = b2DistanceInput.malloc();input.clear();
        input.proxyA(b2MakeProxy( vas, ARRAY_COUNT( vas ), 0.0f , b2ShapeProxy.malloc() ));
        input.proxyB(b2MakeProxy( vbs, ARRAY_COUNT( vbs ), 0.0f, b2ShapeProxy.malloc() ));
        input.transformA(b2Transform_identity);
        input.transformB(b2Transform_identity);
        input.useRadii(false);

        b2SimplexCache cache = b2SimplexCache.malloc();cache.clear();
        b2DistanceOutput output = b2DistanceOutput.malloc();nb2ShapeDistance(input.address(), cache.address(), NULL, 0, output.address() );

        ENSURE_SMALL( output.distance() - 1.0f, FLT_EPSILON );

        return 0;
    }

    static int ShapeCastTest( )
    {
        b2Vec2.Buffer vas = b2Vec2.mallocSafe(b2Vec2.malloc().set( -1.0f, -1.0f ), b2Vec2.malloc().set( 1.0f, -1.0f ), b2Vec2.malloc().set( 1.0f, 1.0f ), b2Vec2.malloc().set( -1.0f, 1.0f ) );
        vas.flip();
        
        b2Vec2.Buffer vbs = b2Vec2.mallocSafe(
            b2Vec2.malloc().set( 2.0f, -1.0f ),
            b2Vec2.malloc().set( 2.0f, 1.0f )
        );
        vbs.flip();

        b2ShapeCastPairInput input = b2ShapeCastPairInput.malloc();input.clear();
        input.proxyA(b2MakeProxy( vas, ARRAY_COUNT( vas ), 0.0f, b2ShapeProxy.malloc() ));
        input.proxyB(b2MakeProxy( vbs, ARRAY_COUNT( vbs ), 0.0f, b2ShapeProxy.malloc() ));
        input.transformA(b2Transform_identity);
        input.transformB(b2Transform_identity);
        input.translationB(b2Vec2.malloc().set( -2.0f, 0.0f ));
        input.maxFraction(1.0f);

        b2CastOutput output = b2ShapeCast( input, b2CastOutput.malloc() );

        ENSURE( output.hit() );
        ENSURE_SMALL( output.fraction() - 0.5f, 0.005f );

        return 0;
    }

    static int TimeOfImpactTest( )
    {
        b2Vec2.Buffer vas = b2Vec2.mallocSafe(b2Vec2.malloc().set( -1.0f, -1.0f ), b2Vec2.malloc().set( 1.0f, -1.0f ), b2Vec2.malloc().set( 1.0f, 1.0f ), b2Vec2.malloc().set( -1.0f, 1.0f ) );
        vas.flip();
        
        b2Vec2.Buffer vbs = b2Vec2.mallocSafe(
            b2Vec2.malloc().set( 2.0f, -1.0f ),
            b2Vec2.malloc().set( 2.0f, 1.0f )
        );
        vbs.flip();

        b2TOIInput input = b2TOIInput.malloc();
        input.proxyA(b2MakeProxy( vas, ARRAY_COUNT( vas ), 0.0f, b2ShapeProxy.malloc() ));
        input.proxyB(b2MakeProxy( vbs, ARRAY_COUNT( vbs ), 0.0f, b2ShapeProxy.malloc() ));
        input.sweepA( b2Sweep.malloc().set( b2Vec2_zero, b2Vec2_zero, b2Vec2_zero, b2Rot_identity, b2Rot_identity ));
        input.sweepB( b2Sweep.malloc().set( b2Vec2_zero, b2Vec2_zero, b2Vec2.malloc().set( -2.0f, 0.0f ), b2Rot_identity, b2Rot_identity ));
        input.maxFraction(1.0f);

        b2TOIOutput output = b2TimeOfImpact( input, b2TOIOutput.malloc() );

        ENSURE( output.state() == b2_toiStateHit );
        ENSURE_SMALL( output.fraction() - 0.5f, 0.005f );

        return 0;
    }

    int DistanceTest( )
    {
        RUN_SUBTEST(() -> SegmentDistanceTest() );
        RUN_SUBTEST(() -> ShapeDistanceTest() );
        RUN_SUBTEST(() -> ShapeCastTest() );
        RUN_SUBTEST(() -> TimeOfImpactTest() );

        return 0;
    }
}
