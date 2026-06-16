/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.test;

import java.util.Objects;

import org.box2d.jni.system.UintptrBuffer;
import org.box2d.jni.test.internal.Extern;

import static java.lang.System.out;
import static org.box2d.jni.include.Base.*;

/**
 * A line-by-line Java translation of the box2d 'test/main.c' example.
 * <p>
 * Source code: https://github.com/erincatto/box2d/blob/main/test/test_macros.h
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class TestMacros {
    
    static String filter; 
    
    public static void RUN_TEST( Extern<Integer> T ) {
        do                                        
        {
            long testTicks = b2GetTicks();
            int result = T.invoke();
            float s = 0.001f * b2GetMilliseconds( testTicks );
            if ( result == 1 )
            {
                out.printf( "test failed: "  + T.$() + "\n" );
                System.exit(1);
            }
            else
            {
                out.printf( "test passed: " + T.$() + " after %.2f s\n", s );
            }
        }
        while ( false );
    }
    
    public static void RUN_SUBTEST( Extern<Integer> T ) {
        do
        {
            int result = T.invoke();
            if ( result == 1 )
            {
                out.printf( "  subtest failed: " + T.$() + "\n" );
                System.exit(1);
            }
            else
            {
                out.printf( "  subtest passed: " + T.$() + "\n" );
            }
        }
        while ( false );
    }
    
    public static void ENSURE( boolean C ) {
        do                                            
        {
            if ( ( C ) == false )
            {
                out.printf( "condition false: " + C + "\n" );
                assert( false );
                System.exit(1);
            }
        }
	while ( false );
    }
    
    public static void ENSURE_SMALL( float C, Float tol ) {
        do                                                          
        {
            if ( ( C ) < -( tol ) || ( tol ) < ( C ) )
            {
                out.printf( "condition false: abs(" + C + ") < %g\n", tol );
                assert( false );
                System.exit(1);
            }
        }
        while ( false );
    }
    
    public static int ARRAY_COUNT( Object[] A ) {
        return A.length;
    }    
    public static int ARRAY_COUNT( UintptrBuffer A ) {
        return A.remaining();
    }
    
    // Used to prevent the compiler from warning about unused variables
    public static void MAYBE_UNUSED( Object x ) { /*( (void)( x ) )*/ }
    
    // Filter-aware test runner: skips tests that don't match the filter
    public static void MAYBE_RUN_TEST(Extern<Integer> T) {
        do {
            if ( filter != null && Objects.equals(filter, T.$()) )
            {
                out.printf( "test skipped: "  + T.$() + "\n" );
                break;
            }
            RUN_TEST(T);
        }
        while (false);
    }
}

