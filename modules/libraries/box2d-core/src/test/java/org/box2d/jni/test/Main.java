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

import org.box2d.jni.test.internal.*;

import static java.lang.System.out;

import static org.box2d.jni.include.Base.*;
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
        CollisionTest = extern(new TestCollision(), TestCollision::CollisionTest);
        DistanceTest  = extern(new TestDistance(), TestDistance::DistanceTest);
        MathTest      = extern(new TestMath(), TestMath::MathTest);
        ShapeTest     = extern(new TestShape(), TestShape::ShapeTest);
        IdTest        = extern(new TestId(), TestId::IdTest);
    }
    

//extern int BitSetTest( void );
    static Extern<Integer> CollisionTest;
//extern int DeterminismTest( void );
    static Extern<Integer> DistanceTest;
//extern int DynamicTreeTest( void );
    static Extern<Integer> IdTest;
    static Extern<Integer> MathTest;
    static Extern<Integer> ShapeTest;
//extern int TableTest( void );    
//    static Extern<Integer> WorldTest;
    
    public static void main(String[] args) {
        /*const char* */ filter = null;
        if (args.length > 0)
        {
            filter = args[0];
        }

        long ticks =  b2GetTicks();
        out.printf("Starting Box2D unit tests\n");
        if (filter != null)
        {
            out.printf("Filter: %s\n", filter);
        }

        out.printf("======================================\n");

        //MAYBE_RUN_TEST( TableTest );
        MAYBE_RUN_TEST(MathTest);
        //MAYBE_RUN_TEST( BitSetTest );
        MAYBE_RUN_TEST( CollisionTest );
        //MAYBE_RUN_TEST( ContainerTest );
        //MAYBE_RUN_TEST( DeterminismTest );
        MAYBE_RUN_TEST( DistanceTest );
        //MAYBE_RUN_TEST( DynamicTreeTest );
        MAYBE_RUN_TEST( IdTest );
        MAYBE_RUN_TEST( ShapeTest );
        //MAYBE_RUN_TEST( ThreadTest );
        //MAYBE_RUN_TEST( WorldTest );

        out.printf("======================================\n");
        out.printf("All Box2D tests passed!\n");

        float duration = b2GetMilliseconds(ticks);
        out.printf("Test duration = %.2f s\n", 0.001f * duration);
    }
}
