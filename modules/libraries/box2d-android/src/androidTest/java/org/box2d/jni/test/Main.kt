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
package org.box2d.jni.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry

import org.box2d.jni.include.Base

import org.box2d.jni.test.TestMacros.MAYBE_RUN_TEST
import org.box2d.jni.test.TestMacros.filter
import org.box2d.jni.test.util.LibraryUtils

import org.junit.Test
import org.junit.runner.RunWith

import kotlin.reflect.KFunction

/**
 * A line-by-line Java translation of the box2d 'test/main.c' example.
 * <p>
 * Source code: https://github.com/erincatto/box2d/blob/main/test/main.c
 *
 * @author wil
 * @version 1.0.0
 * @since 1.3.0
 */
@RunWith(AndroidJUnit4::class)
class Main {
    companion object {
        init {
            LibraryUtils.setupLibrary()
        }
    }

    private val CollisionTest: KFunction<Int> = TestCollision()::CollisionTest
    private val DistanceTest: KFunction<Int> = TestDistance()::DistanceTest
    private val DynamicTreeTest: KFunction<Int> = TestDynamicTree()::DynamicTreeTest
    private val IdTest: KFunction<Int> = TestId()::IdTest
    //private val MathTest: KFunction<Int> = TestId()::IdTest
    //private val ShapeTest: KFunction<Int> = TestId()::IdTest
    //private val WorldTest: KFunction<Int> = TestId()::IdTest

    @Test fun main() {
        val args = InstrumentationRegistry.getArguments()
        /*const char* */ filter = null;
        if (args.size() > 0)
        {
            filter = args.getString("-f")
        }

        val ticks = Base.b2GetTicks()
        System.out.printf("Starting Box2D unit tests\n")
        if (filter != null) {
            System.out.printf("Filter: %s\n", filter)
        }

        System.out.printf("======================================\n")

        //TestMacros.MAYBE_RUN_TEST(Main.MathTest)
        MAYBE_RUN_TEST(CollisionTest)
        MAYBE_RUN_TEST(DistanceTest)
        MAYBE_RUN_TEST(DynamicTreeTest)
        MAYBE_RUN_TEST(IdTest)
        //TestMacros.MAYBE_RUN_TEST(Main.ShapeTest)
        //TestMacros.MAYBE_RUN_TEST(Main.WorldTest)

        System.out.printf("======================================\n")
        System.out.printf("All Box2D tests passed!\n")

        val duration = Base.b2GetMilliseconds(ticks)
        System.out.printf("Test duration = %.2f s\n", 0.001f * duration)
    }
}