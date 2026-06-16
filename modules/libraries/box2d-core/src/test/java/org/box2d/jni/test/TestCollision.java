/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.test;

import org.box2d.jni.*;

import static org.box2d.jni.include.MathFunctions.*;
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

    int CollisionTest( )
    {
        RUN_SUBTEST(() -> AABBTest() );
        return 0;
    }
}
