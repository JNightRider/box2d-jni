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

