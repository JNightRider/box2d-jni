/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.test;

import org.box2d.jni.test.internal.*;

import static java.lang.System.out;
import java.util.Objects;
import java.util.function.Function;

import static org.box2d.jni.test.TestMacros.*;
import static org.box2d.jni.test.internal.Extern.*;


/**
 * A line-by-line Java translation of the box2d 'test/main.c' example.
 * <p>
 * Source code: https://github.com/erincatto/box2d/blob/main/test/main.c
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class Main {
    
    static {
        MathTest = extern(new TestMath(), TestMath::MathTest);
    }
    

//extern int BitSetTest( void );
//    static Extern<Integer> CollisionTest;
//extern int DeterminismTest( void );
//extern int DistanceTest( void );
//extern int DynamicTreeTest( void );
//    static Extern<Integer> IdTest;
    static Extern<Integer> MathTest;
//extern int ShapeTest( void );
//extern int TableTest( void );    
//    static Extern<Integer> WorldTest;
    
    static String filter;    
    private static void MAYBE_RUN_TEST( Extern<Integer> T )
    {
        if ( filter != null && Objects.equals(filter, T.$()) )
        {
            out.printf( "test skipped: " + T.$() + "\n" );
            return;
        }
        RUN_TEST( T );
    }
    
    public static void main(String[] args) {
        /*const char* */ filter = null;
        if (args.length > 1)
        {
            filter = args[1];
        }

        long ticks = System.currentTimeMillis(); //b2GetTicks();

        out.printf("Starting Box2D unit tests\n");
        if (filter != null)
        {
            out.printf("Filter: %s\n", filter);
        }

        out.printf( "======================================\n" );

        //MAYBE_RUN_TEST( TableTest );
	MAYBE_RUN_TEST( MathTest  );
	//MAYBE_RUN_TEST( BitSetTest );
	//MAYBE_RUN_TEST( CollisionTest );
	//MAYBE_RUN_TEST( ContainerTest );
	//MAYBE_RUN_TEST( DeterminismTest );
	//MAYBE_RUN_TEST( DistanceTest );
	//MAYBE_RUN_TEST( DynamicTreeTest );
	//MAYBE_RUN_TEST( IdTest );
	//MAYBE_RUN_TEST( ShapeTest );
	//MAYBE_RUN_TEST( ThreadTest );
	//MAYBE_RUN_TEST( WorldTest );

        out.printf( "======================================\n" );
	out.printf( "All Box2D tests passed!\n" );
	
	float duration = System.currentTimeMillis(); //b2GetMilliseconds( ticks );
	out.printf( "Test duration = %.2f s\n", 0.001f * duration );
    }
}
