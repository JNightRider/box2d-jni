/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.test;

import org.box2d.jni.*;

import static org.box2d.jni.include.Id.*;
import static org.box2d.jni.test.TestMacros.*;

/**
 * A line-by-line Java translation of the box2d 'test/test_id.c' example.
 * <p>
 * Source code: https://github.com/erincatto/box2d/blob/main/test/test_id.c
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class TestId {

    int IdTest( )
    {
        int a = 0x01234567;

        {
            b2WorldId id = b2LoadWorldId( a, b2WorldId.malloc() );
            int b = b2StoreWorldId( id );
            ENSURE( b == a );
        }

        long x = 0x0123456789ABCDEFl;

        {
            b2BodyId id = b2LoadBodyId( x, b2BodyId.malloc() );
            long y = b2StoreBodyId( id );
            ENSURE( x == y );
        }

        {
            b2ShapeId id = b2LoadShapeId( x, b2ShapeId.malloc() );
            long y = b2StoreShapeId( id );
            ENSURE( x == y );
        }

        {
            b2ChainId id = b2LoadChainId( x, b2ChainId.malloc() );
            long y = b2StoreChainId( id );
            ENSURE( x == y );
        }

        {
            b2JointId id = b2LoadJointId( x, b2JointId.malloc() );
            long y = b2StoreJointId( id );
            ENSURE( x == y );
        }

        return 0;
    }
}
