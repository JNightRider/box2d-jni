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

import org.box2d.jni.include.Base
import org.box2d.jni.system.UintptrBuffer

import kotlin.reflect.KFunction
import kotlin.system.exitProcess

/**
 * A line-by-line Java translation of the box2d 'test/main.c' example.
 *
 *
 * Source code: https://github.com/erincatto/box2d/blob/main/test/test_macros.h
 *
 * @author wil
 * @version 1.0.0
 * @since 1.3.0
 */
object TestMacros {
    var filter: String? = null

    fun RUN_TEST(T: KFunction<Int>) {
        do {
            val testTicks = Base.b2GetTicks()
            val result = T.call()
            val s = 0.001f * Base.b2GetMilliseconds(testTicks)
            if (result == 1) {
                System.out.printf("test failed: ' ${T.name} '\n")
                exitProcess(1)
            } else {
                System.out.printf("test passed: ' ${T.name} ' after %.2f s\n", s)
            }
        } while (false)
    }

    fun RUN_SUBTEST(T: KFunction<Int>) {
        do {
            val result: Int = T.call()
            if (result == 1) {
                System.out.printf("  subtest failed: ' ${T.name} '\n")
                exitProcess(1)
            } else {
                System.out.printf("  subtest passed: ' ${T.name} '\n")
            }
        } while (false)
    }

    fun ENSURE(C: Boolean) {
        do {
            if ((C) == false) {
                System.out.printf("condition false: ${C}\n")
                assert(false)
                exitProcess(1)
            }
        } while (false)
    }

    fun ENSURE_SMALL(C: Float, tol: Float) {
        do {
            if ((C) < -(tol) || (tol) < (C)) {
                System.out.printf("condition false: abs(${C}) < %g\n", tol)
                assert(false)
                exitProcess(1)
            }
        } while (false)
    }

    fun ARRAY_COUNT(A: Array<Any?>): Int {
        return A.size
    }

    fun ARRAY_COUNT(A: UintptrBuffer<*>): Int {
        A.flip()
        return A.remaining()
    }

    // Used to prevent the compiler from warning about unused variables
    fun MAYBE_UNUSED(x: Any?) { /*( (void)( x ) )*/
    }

    // Filter-aware test runner: skips tests that don't match the filter
    fun MAYBE_RUN_TEST(T: KFunction<Int>) {
        do {
            if (filter != null && filter == T.name) {
                System.out.printf("test skipped: ' ${T.name} '\n")
                break
            }
            RUN_TEST(T)
        } while (false)
    }
}

