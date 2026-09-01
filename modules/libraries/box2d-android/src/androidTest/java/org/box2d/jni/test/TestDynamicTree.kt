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

import java.util.Objects

import org.box2d.jni.*

import org.box2d.jni.include.Collision.*
import org.box2d.jni.include.MathFunctions.*

import org.box2d.jni.libc.LibCMath.*
import org.box2d.jni.system.Memory.*
import org.box2d.jni.system.MemoryUtil.*

import org.box2d.jni.readonly.ConstB2RayCastInput

import org.box2d.jni.test.TestMacros.ENSURE
import org.box2d.jni.test.TestMacros.RUN_SUBTEST

/**
 * A line-by-line Java translation of the box2d 'test/test_dynamic_tree.c' example.
 * <p>
 * Source code: https://github.com/erincatto/box2d/blob/main/test/test_dynamic_tree.c
 *
 * @author wil
 * @version 1.0.0
 * @since 1.3.0
 */
class TestDynamicTree {
    companion object {
        const val GRID_COUNT: Int = 20
    }

    fun TreeCreateDestroy( ): Int
    {
        val a = b2AABB.malloc()
            .lowerBound( b2Vec2.malloc().set( -1.0f, -1.0f ) )
            .upperBound( b2Vec2.malloc().set( 2.0f, 2.0f ) )


        val tree = b2DynamicTree_Create( 16, b2DynamicTree.malloc() )
        b2DynamicTree_CreateProxy( tree, a, 1, 0 )

        ENSURE( tree.nodeCount() > 0 )
        ENSURE( tree.proxyCount() == 1 )

        b2DynamicTree_Destroy( tree )

        ENSURE( tree.nodeCount() == 0 )
        ENSURE( tree.proxyCount() == 0 )

        return 0
    }

    val RayCastCallbackFcn: b2TreeRayCastCallbackFcnI = b2TreeRayCastCallbackFcnI { input: ConstB2RayCastInput?, proxyId: Int, userData: Long, context: Long ->
        val proxyHit = memIntBuffer(context, 1)
        proxyHit.put(0, proxyId)
        0.0f
    }

    fun TreeRayCastTest( ): Int
    {
        // Test AABB centered at origin with bounds [-1, -1] to [1, 1]
        val a = b2AABB.malloc().lowerBound(b2Vec2.malloc().set( -1.0f, -1.0f )).upperBound(b2Vec2.malloc().set( 1.0f, 1.0f ))
        val tree = b2DynamicTree_Create( 16, b2DynamicTree.malloc() )
        val proxyId = b2DynamicTree_CreateProxy( tree, a, 1, 0 )

        val input = b2RayCastInput.calloc()
        input.maxFraction( 1.0f )

        // Test 1: Ray hits AABB from left side
        run {
            val p1 = b2Vec2.malloc().set( -3.0f, 0.0f )
            val p2 = b2Vec2.malloc().set( 3.0f, 0.0f )

            input.origin(p1);
            input.translation(b2Sub( p2, p1, b2Vec2.malloc() ));

            val proxyHit = memCreateIntBuffer(1)
            proxyHit.put(0, -1)
            b2DynamicTree_RayCast( tree, input, 1, RayCastCallbackFcn, memGetNativeAddress(proxyHit), b2TreeStats.malloc() )

            ENSURE( proxyHit.get(0) == proxyId )
        }

        // Test 2: Ray hits AABB from right side
        run {
            val p1 = b2Vec2.malloc().set( 3.0f, 0.0f )
            val p2 = b2Vec2.malloc().set( -3.0f, 0.0f )
            input.origin(p1)
            input.translation(b2Sub( p2, p1, b2Vec2.malloc() ))

            val proxyHit = memCreateIntBuffer(1)
            proxyHit.put(0, -1);
            b2DynamicTree_RayCast( tree, input, 1, RayCastCallbackFcn, memGetNativeAddress(proxyHit), b2TreeStats.malloc() )

            ENSURE( proxyHit.get(0) == proxyId )
        }

        // Test 3: Ray hits AABB from bottom
        run {
            val p1 = b2Vec2.malloc().set( 0.0f, -3.0f )
            val p2 = b2Vec2.malloc().set( 0.0f, 3.0f )
            input.origin(p1)
            input.translation(b2Sub( p2, p1, b2Vec2.malloc() ))

            val proxyHit = memCreateIntBuffer(1)
            proxyHit.put(0, -1)
            b2DynamicTree_RayCast( tree, input, 1, RayCastCallbackFcn, memGetNativeAddress(proxyHit), b2TreeStats.malloc() )

            ENSURE( proxyHit.get(0) == proxyId )
        }

        // Test 4: Ray hits AABB from top
        run {
            val p1 = b2Vec2.malloc().set( 0.0f, 3.0f )
            val p2 = b2Vec2.malloc().set( 0.0f, -3.0f )
            input.origin(p1);
            input.translation(b2Sub( p2, p1, b2Vec2.malloc() ));

            val proxyHit = memCreateIntBuffer(1)
            proxyHit.put(0, -1)
            b2DynamicTree_RayCast( tree, input, 1, RayCastCallbackFcn, memGetNativeAddress(proxyHit), b2TreeStats.malloc() )

            ENSURE( proxyHit.get(0) == proxyId )
        }

        // Test 5: Ray misses AABB completely (parallel to x-axis)
        run {
            val p1 = b2Vec2.malloc().set( -3.0f, 2.0f )
            val p2 = b2Vec2.malloc().set( 3.0f, 2.0f )
            input.origin(p1)
            input.translation( b2Sub( p2, p1, b2Vec2.malloc() ) )

            val proxyHit = memCreateIntBuffer(1)
            proxyHit.put(0, -1)
            b2DynamicTree_RayCast( tree, input, 1, RayCastCallbackFcn, memGetNativeAddress(proxyHit), b2TreeStats.malloc() )

            ENSURE( proxyHit.get(0) == -1 )
        }

        // Test 6: Ray misses AABB completely (parallel to y-axis)
        run {
            val p1 = b2Vec2.malloc().set( 2.0f, -3.0f )
            val p2 = b2Vec2.malloc().set( 2.0f, 3.0f )
            input.origin(p1)
            input.translation(b2Sub( p2, p1, b2Vec2.malloc() ))

            val proxyHit = memCreateIntBuffer(1)
            proxyHit.put(0, -1)
            b2DynamicTree_RayCast( tree, input, 1, RayCastCallbackFcn, memGetNativeAddress(proxyHit), b2TreeStats.malloc() )

            ENSURE( proxyHit.get(0) == -1 )
        }

        // Test 7: Ray starts inside AABB
        run {
            val p1 = b2Vec2.malloc().set( 0.0f, 0.0f )
            val p2 = b2Vec2.malloc().set( 2.0f, 0.0f )
            input.origin(p1)
            input.translation( b2Sub( p2, p1, b2Vec2.malloc() ))

            val proxyHit = memCreateIntBuffer(1)
            proxyHit.put(0, -1)
            b2DynamicTree_RayCast( tree, input, 1, RayCastCallbackFcn, memGetNativeAddress(proxyHit), b2TreeStats.malloc() )

            ENSURE( proxyHit.get(0) == proxyId )
        }

        // Test 8: Ray hits corner of AABB (diagonal ray)
        run {
            val p1 = b2Vec2.malloc().set( -2.0f, -2.0f )
            val p2 = b2Vec2.malloc().set( 2.0f, 2.0f )
            input.origin(p1)
            input.translation(b2Sub( p2, p1, b2Vec2.malloc() ))

            val proxyHit = memCreateIntBuffer(1)
            proxyHit.put(0, -1)
            b2DynamicTree_RayCast( tree, input, 1, RayCastCallbackFcn, memGetNativeAddress(proxyHit), b2TreeStats.malloc() )

            ENSURE( proxyHit.get(0) == proxyId )
        }

        // Test 9: Ray parallel to AABB edge but outside
        run {
            val p1 = b2Vec2.malloc().set( -2.0f, 1.5f )
            val p2 = b2Vec2.malloc().set( 2.0f, 1.5f )
            input.origin(p1)
            input.translation(b2Sub( p2, p1, b2Vec2.malloc() ))

            val proxyHit = memCreateIntBuffer(1)
            proxyHit.put(0, -1)
            b2DynamicTree_RayCast( tree, input, 1, RayCastCallbackFcn, memGetNativeAddress(proxyHit), b2TreeStats.malloc() )

            ENSURE( proxyHit.get(0) == -1 )
        }

        // Test 10: Ray parallel to AABB edge and exactly on boundary
        run {
            val p1 = b2Vec2.malloc().set( -2.0f, 1.0f )
            val p2 = b2Vec2.malloc().set( 2.0f, 1.0f )
            input.origin(p1)
            input.translation(b2Sub( p2, p1, b2Vec2.malloc() ))

            val proxyHit = memCreateIntBuffer(1)
            proxyHit.put(0, -1)
            b2DynamicTree_RayCast( tree, input, 1, RayCastCallbackFcn, memGetNativeAddress(proxyHit), b2TreeStats.malloc() )

            ENSURE( proxyHit.get(0) == proxyId )
        }

        // Test 11: Very short ray that doesn't reach AABB
        run {
            val p1 = b2Vec2.malloc().set( -3.0f, 0.0f )
            val p2 = b2Vec2.malloc().set( -2.5f, 0.0f )
            input.origin(p1)
            input.translation(b2Sub( p2, p1, b2Vec2.malloc() ))

            val proxyHit = memCreateIntBuffer(1)
            proxyHit.put(0, -1)
            b2DynamicTree_RayCast( tree, input, 1, RayCastCallbackFcn, memGetNativeAddress(proxyHit), b2TreeStats.malloc() )

            ENSURE( proxyHit.get(0) == -1 )
        }

        // Test 12: Zero-length ray (degenerate case)
        run {
            val p1 = b2Vec2.malloc().set( 0.0f, 0.0f )
            val p2 = b2Vec2.malloc().set( 0.0f, 0.0f )
            input.origin(p1)
            input.translation(b2Sub( p2, p1, b2Vec2.malloc() ))

            val proxyHit = memCreateIntBuffer(1)
            proxyHit.put(0, -1)
            b2DynamicTree_RayCast( tree, input, 1, RayCastCallbackFcn, memGetNativeAddress(proxyHit), b2TreeStats.malloc() )

            ENSURE( proxyHit.get(0) == proxyId )
        }

        // Test 13: Ray hits AABB at exact boundary condition (t = 1.0)
        run {
            val p1 = b2Vec2.malloc().set( -2.0f, 0.0f )
            val p2 = b2Vec2.malloc().set( -1.0f, 0.0f )
            input.origin(p1)
            input.translation(b2Sub( p2, p1, b2Vec2.malloc() ))

            val proxyHit = memCreateIntBuffer(1)
            proxyHit.put(0, -1)
            b2DynamicTree_RayCast( tree, input, 1, RayCastCallbackFcn, memGetNativeAddress(proxyHit), b2TreeStats.malloc() )

            ENSURE( proxyHit.get(0) == proxyId )
        }

        b2DynamicTree_Destroy( tree )

        return 0
    }

    val QueryCollectCallback: b2TreeQueryCallbackFcnI = b2TreeQueryCallbackFcnI { proxyId: Int, userData: Long, context: Long ->
        val out = memIntBuffer(context, 32)
        out.put(proxyId, 1)
        true // continue the query
    }

    val QueryCollectListCallback: b2TreeQueryCallbackFcnI =  b2TreeQueryCallbackFcnI { proxyId: Int, userData: Long, context: Long ->
        val list = memIntBuffer(context, 16)
        val count = list.get(0)
        list.put(count + 1, proxyId)
        list.put(0, count + 1)
        true
    }

    fun TreeMultipleProxiesTest( ): Int
    {
        val tree = b2DynamicTree_Create( 16, b2DynamicTree.malloc() )

        val a1 = b2AABB.malloc().lowerBound(b2Vec2.malloc().set( -5.0f, -1.0f )).upperBound(b2Vec2.malloc().set( -3.0f, 1.0f ))
        val a2 = b2AABB.malloc().lowerBound(b2Vec2.malloc().set( -1.0f, -1.0f )).upperBound(b2Vec2.malloc().set( 1.0f, 1.0f ))
        val a3 = b2AABB.malloc().lowerBound(b2Vec2.malloc().set( 3.0f, -1.0f )).upperBound(b2Vec2.malloc().set( 5.0f, 1.0f ))

        val id1 = b2DynamicTree_CreateProxy( tree, a1, 0x1L, 42 )
        val id2 = b2DynamicTree_CreateProxy( tree, a2, 0x2L, 43 )
        val id3 = b2DynamicTree_CreateProxy( tree, a3, 0x4L, 44 )

        ENSURE( b2DynamicTree_GetProxyCount( tree ) == 3 )

        ENSURE( b2DynamicTree_GetUserData( tree, id1 ) == 42L )
        ENSURE( b2DynamicTree_GetUserData( tree, id2 ) == 43L )
        ENSURE( b2DynamicTree_GetUserData( tree, id3 ) == 44L )

        ENSURE( b2DynamicTree_GetCategoryBits( tree, id1 ) == 0x1L )
        ENSURE( b2DynamicTree_GetCategoryBits( tree, id2 ) == 0x2L )
        ENSURE( b2DynamicTree_GetCategoryBits( tree, id3 ) == 0x4L )

        b2DynamicTree_Destroy( tree )
        return 0
    }

    fun TreeQueryTest( ): Int
    {
        val tree = b2DynamicTree_Create( 16, b2DynamicTree.malloc() )

        val a1 = b2AABB.malloc().lowerBound(b2Vec2.malloc().set( -5.0f, -1.0f )).upperBound(b2Vec2.malloc().set( -3.0f, 1.0f ))
        val a2 = b2AABB.malloc().lowerBound(b2Vec2.malloc().set( -1.0f, -1.0f )).upperBound(b2Vec2.malloc().set( 1.0f, 1.0f ))
        val a3 = b2AABB.malloc().lowerBound(b2Vec2.malloc().set( 3.0f, -1.0f )).upperBound(b2Vec2.malloc().set( 5.0f, 1.0f ))

        val id1 = b2DynamicTree_CreateProxy( tree, a1, 0xFFL, 0 )
        val id2 = b2DynamicTree_CreateProxy( tree, a2, 0xFFL, 0 )
        val id3 = b2DynamicTree_CreateProxy( tree, a3, 0xFFL, 0 )

        val queryA = b2AABB.malloc().lowerBound(b2Vec2.malloc().set( -2.0f, -2.0f )).upperBound(b2Vec2.malloc().set( 2.0f, 2.0f ))

        val foundFlags = memCreateIntBuffer(32)
        val stats = b2DynamicTree_Query( tree, queryA, 0xFFFFFFFFL, QueryCollectCallback, memGetNativeAddress(foundFlags), b2TreeStats.malloc())

        // We expect at least the middle proxy to be visited.
        ENSURE( foundFlags.get(id2) == 1 )
        ENSURE( stats.leafVisits() >= 1 )

        // Test QueryAll using list collector
        val list = memCreateIntBuffer(16) // list[0] holds count, following entries are ids
        val allStats = b2DynamicTree_QueryAll( tree, queryA, QueryCollectListCallback, memGetNativeAddress(list), b2TreeStats.malloc() )
        ENSURE( list.get(0) >= 1 ) // at least one proxy should be collected
        ENSURE( allStats.leafVisits() >= 1 )

        b2DynamicTree_Destroy( tree )
        return 0;
    }

    fun TreeMoveAndEnlargeTest( ): Int
    {
        val tree = b2DynamicTree_Create( 16, b2DynamicTree.malloc() )

        val a = b2AABB.malloc().lowerBound(b2Vec2.malloc().set( 0.0f, 0.0f )).upperBound(b2Vec2.malloc().set( 1.0f, 1.0f ))
        val id = b2DynamicTree_CreateProxy( tree, a, 0x1L, 100 )

        // Move proxy to a new place
        val moved = b2AABB.malloc().lowerBound(b2Vec2.malloc().set( 10.0f, 10.0f )).upperBound(b2Vec2.malloc().set( 11.0f, 11.0f ))
        b2DynamicTree_MoveProxy( tree, id, moved )

        val got = b2DynamicTree_GetAABB( tree, id, b2AABB.malloc() )
        ENSURE(Objects.equals(got.lowerBound().x(), moved.lowerBound().x()))
        ENSURE(Objects.equals(got.lowerBound().y(), moved.lowerBound().y()))
        ENSURE(Objects.equals(got.upperBound().x(), moved.upperBound().x()))
        ENSURE(Objects.equals(got.upperBound().y(), moved.upperBound().y()))

        // Now enlarge the proxy
        val enlarge = b2AABB.malloc().lowerBound(b2Vec2.malloc().set( 9.5f, 9.5f )).upperBound(b2Vec2.malloc().set( 11.5f, 11.5f ))
        b2DynamicTree_EnlargeProxy( tree, id, enlarge )

        val got2 = b2DynamicTree_GetAABB( tree, id, b2AABB.malloc() )
        ENSURE( got2.lowerBound().x() <= enlarge.lowerBound().x() + 1e-6f )
        ENSURE( got2.upperBound().x() >= enlarge.upperBound().x() - 1e-6f )

        b2DynamicTree_Destroy( tree )
        return 0
    }

    fun TreeRebuildAndValidateTest( ): Int
    {
        val tree = b2DynamicTree_Create( 16, b2DynamicTree.malloc() )

        // Create a number of proxies to make rebuild meaningful
        for (i in 0..11)
        {
            val x = i.toFloat() * 2.0f
            val a = b2AABB.malloc().lowerBound(b2Vec2.malloc().set( x - 0.5f, -0.5f )).upperBound(b2Vec2.malloc().set( x + 0.5f, 0.5f ))
            b2DynamicTree_CreateProxy( tree, a, 0xFFL, i.toLong() );
        }

        val sorted = b2DynamicTree_Rebuild( tree, true )

        ENSURE( sorted >= 0 )
        ENSURE( b2DynamicTree_GetByteCount( tree ) > 0 )
        ENSURE( b2DynamicTree_GetHeight( tree ) > 0 )

        b2DynamicTree_Destroy( tree )
        return 0
    }

    fun TreeRowHeightTest(): Int
    {
        val tree = b2DynamicTree_Create(16, b2DynamicTree.malloc())

        val columnCount = 200
        for (i in 0..<columnCount) {
            val x = 1.0f * i
            val a = b2AABB.malloc().lowerBound(b2Vec2.malloc().set(x, 0.0f)).upperBound(b2Vec2.malloc().set(x + 1.0f, 1.0f))
            b2DynamicTree_CreateProxy(tree, a, 1, i.toLong())
        }

        val minHeight = log2f(columnCount.toFloat())

        ENSURE(b2DynamicTree_GetHeight(tree) < 2.0f * minHeight)

        b2DynamicTree_Destroy(tree)
        return 0
    }

    fun TreeGridHeightTest(): Int 
    {
        val tree = b2DynamicTree_Create(16, b2DynamicTree.malloc())

        val columnCount = 20
        val rowCount = 20
        for (i in 0..< columnCount)
        {
            val x = 1.0f * i
            for (j in 0..< rowCount)
            {
                val y = 1.0f * j
                val a = b2AABB.malloc().lowerBound(b2Vec2.malloc().set(x, y)).upperBound(b2Vec2.malloc().set(x + 1.0f, y + 1.0f))
                b2DynamicTree_CreateProxy(tree, a, 1, i.toLong())
            }
        }

        val minHeight = log2f((rowCount * columnCount).toFloat())

        ENSURE(b2DynamicTree_GetHeight(tree) < 2.0f * minHeight)

        b2DynamicTree_Destroy(tree)
        return 0
    }

    fun TreeGridMovementTest(): Int {
        val tree = b2DynamicTree_Create(16, b2DynamicTree.malloc())

        val proxyIds = IntArray(GRID_COUNT * GRID_COUNT)
        var index = 0
        for (i in 0..<GRID_COUNT)
        {
            val x = 1.0f * i
            for (j in 0..<GRID_COUNT)
            {
                val y = 1.0f * j
                val a = b2AABB.malloc().lowerBound(b2Vec2.malloc().set(x, y)).upperBound(b2Vec2.malloc().set(x + 1.0f, y + 1.0f))
                proxyIds[index] = b2DynamicTree_CreateProxy(tree, a, 1, i.toLong())
                index += 1
            }
        }

        ENSURE(index == GRID_COUNT * GRID_COUNT)

        val minHeight = log2f((GRID_COUNT * GRID_COUNT).toFloat())

        val height1 = b2DynamicTree_GetHeight(tree)
        ENSURE(height1 < 2.0f * minHeight)

        val offset = b2Vec2.malloc().set(10.0f, 20.0f)
        index = 0
        for (i in 0..<GRID_COUNT)
        {
            for (j in 0..<GRID_COUNT)
            {
                val a = b2DynamicTree_GetAABB(tree, proxyIds[index], b2AABB.malloc())
                a.lowerBound(b2Add(a.lowerBound(), offset, b2Vec2.malloc()))
                a.upperBound(b2Add(a.upperBound(), offset, b2Vec2.malloc()))
                b2DynamicTree_MoveProxy(tree, proxyIds[index], a)
                index += 1
            }
        }

        val height2 = b2DynamicTree_GetHeight(tree)
        ENSURE(height2 < 3.0f * minHeight)

        b2DynamicTree_Rebuild(tree, true)

        val height3 = b2DynamicTree_GetHeight(tree)
        ENSURE(height3 < 2.0f * minHeight)

        b2DynamicTree_Destroy(tree)
        return 0
    }

    fun DynamicTreeTest( ): Int
    {
        RUN_SUBTEST( ::TreeCreateDestroy )
        RUN_SUBTEST( ::TreeRayCastTest )
        RUN_SUBTEST( ::TreeMultipleProxiesTest )
        RUN_SUBTEST( ::TreeQueryTest )
        RUN_SUBTEST( ::TreeMoveAndEnlargeTest )
        RUN_SUBTEST( ::TreeRebuildAndValidateTest )
        RUN_SUBTEST( ::TreeRowHeightTest )
        RUN_SUBTEST( ::TreeGridHeightTest )
        RUN_SUBTEST( ::TreeGridMovementTest )

        // todo test queries versus brute force

        return 0
    }
}