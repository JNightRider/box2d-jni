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

import org.box2d.jni.b2BodyType.*
import org.box2d.jni.b2ShapeType.*

import org.box2d.jni.include.Base.*
import org.box2d.jni.include.Box2d.*
import org.box2d.jni.include.Collision.*
import org.box2d.jni.include.Constants.*
import org.box2d.jni.include.Id.*
import org.box2d.jni.include.MathFunctions.*
import org.box2d.jni.include.Types.*

import org.box2d.jni.system.Memory.*
import org.box2d.jni.system.Pointer.*

import org.box2d.jni.test.TestMacros.ENSURE
import org.box2d.jni.test.TestMacros.ENSURE_SMALL
import org.box2d.jni.test.TestMacros.RUN_SUBTEST

/**
 * A line-by-line Java translation of the box2d 'test/test_world.c' example.
 * <p>
 * Source code: https://github.com/erincatto/box2d/blob/main/test/test_world.c
 *
 * @author wil
 * @version 1.0.0
 * @since 1.3.0
 */
class TestWorld {
    companion object {
        private const val BODY_COUNT: Int = 10
        const val WORLD_COUNT: Int = (B2_MAX_WORLDS / 2)
    }

    // This is a simple example of building and running a simulation
    // using Box2D. Here we create a large ground box and a small dynamic
    // box.
    // There are no graphics for this example. Box2D is meant to be used
    // with your rendering engine in your game engine.
    fun HelloWorld(): Int
    {
        // Construct a world object, which will hold and simulate the rigid bodies.
        val worldDef = b2DefaultWorldDef(b2WorldDef.malloc())
        worldDef.gravity(b2Vec2.malloc().set(0.0f, -10.0f))

        val worldId = b2CreateWorld(worldDef, b2WorldId.malloc())
        ENSURE(b2World_IsValid(worldId))

        // Define the ground body.
        val groundBodyDef = b2DefaultBodyDef(b2BodyDef.malloc())
        groundBodyDef.position(b2Pos.malloc().set(0.0f, -10.0f))

        // Call the body factory which allocates memory for the ground body
        // from a pool and creates the ground box shape (also from a pool).
        // The body is also added to the world.
        val groundId = b2CreateBody(worldId, groundBodyDef, b2BodyId.malloc())
        ENSURE(b2Body_IsValid(groundId))

        // Define the ground box shape. The extents are the half-widths of the box.
        val groundBox = b2MakeBox(50.0f, 10.0f, b2Polygon.malloc())

        // Add the box shape to the ground body.
        val groundShapeDef = b2DefaultShapeDef(b2ShapeDef.malloc())
        b2CreatePolygonShape(groundId, groundShapeDef, groundBox, b2ShapeId.malloc())

        // Define the dynamic body. We set its position and call the body factory.
        val bodyDef = b2DefaultBodyDef(b2BodyDef.malloc())
        bodyDef.type(b2_dynamicBody)
        bodyDef.position(b2Pos.malloc().set(0.0f, 4.0f))

        val bodyId = b2CreateBody(worldId, bodyDef, b2BodyId.malloc())

        // Define another box shape for our dynamic body.
        val dynamicBox = b2MakeBox(1.0f, 1.0f, b2Polygon.malloc())

        // Define the dynamic body shape
        val shapeDef = b2DefaultShapeDef(b2ShapeDef.malloc())

        // Set the box density to be non-zero, so it will be dynamic.
        shapeDef.density(1.0f)

        // Override the default friction.
        shapeDef.material().friction(0.3f)

        // Add the shape to the body.
        b2CreatePolygonShape(bodyId, shapeDef, dynamicBox, b2ShapeId.malloc())

        // Prepare for simulation. Typically we use a time step of 1/60 of a
        // second (60Hz) and 4 sub-steps. This provides a high quality simulation
        // in most game scenarios.
        val timeStep = 1.0f / 60.0f
        val subStepCount = 4

        var position = b2Body_GetPosition(bodyId, b2Pos.malloc())
        var rotation = b2Body_GetRotation(bodyId, b2Rot.malloc())

        // This is our little game loop.
        for (i in 0..89)
        {
            // Instruct the world to perform a single step of simulation.
            // It is generally best to keep the time step and iterations fixed.
            b2World_Step(worldId, timeStep, subStepCount)

            // Now print the position and angle of the body.
            position = b2Body_GetPosition(bodyId, position)
            rotation = b2Body_GetRotation(bodyId, rotation)

            // printf("%4.2f %4.2f %4.2f\n", position.x, position.y, b2Rot_GetAngle(rotation));
        }

        // When the world destructor is called, all bodies and joints are freed. This can
        // create orphaned ids, so be careful about your world management.
        b2DestroyWorld(worldId)

        ENSURE(b2AbsFloat(position.x().toFloat()) < 0.01f)
        ENSURE(b2AbsFloat(position.y().toFloat() - 1.00f) < 0.01f)
        ENSURE(b2AbsFloat(b2Rot_GetAngle(rotation)) < 0.01f)

        return 0
    }

    fun EmptyWorld(): Int
    {
        val worldDef = b2DefaultWorldDef(b2WorldDef.malloc())
        val worldId = b2CreateWorld(worldDef, b2WorldId.malloc())
        ENSURE(b2World_IsValid(worldId) == true)

        val timeStep = 1.0f / 60.0f
        val subStepCount = 1

        for (i in 0..59)
        {
            b2World_Step(worldId, timeStep, subStepCount)
        }

        b2DestroyWorld(worldId)

        ENSURE(b2World_IsValid(worldId) == false)

        return 0
    }

    fun DestroyAllBodiesWorld(): Int
    {
        val worldDef = b2DefaultWorldDef(b2WorldDef.malloc())
        val worldId = b2CreateWorld(worldDef, b2WorldId.malloc())
        ENSURE(b2World_IsValid(worldId) == true)

        var count = 0
        var creating = true

        val bodyIds = arrayOfNulls<b2BodyId>(BODY_COUNT)
        val bodyDef = b2DefaultBodyDef(b2BodyDef.malloc())
        bodyDef.type(b2_dynamicBody)
        val square = b2MakeSquare(0.5f, b2Polygon.malloc())

        for (i in 0..<2 * BODY_COUNT + 10)
        {
            if (creating)
            {
                if (count < BODY_COUNT)
                {
                    bodyIds[count] = b2CreateBody(worldId, bodyDef, b2BodyId.malloc())

                    val shapeDef = b2DefaultShapeDef(b2ShapeDef.malloc())
                    b2CreatePolygonShape(bodyIds[count], shapeDef, square, b2ShapeId.malloc())
                    count += 1
                } else {
                    creating = false
                }
            }
            else if (count > 0)
            {
                b2DestroyBody(bodyIds[count - 1])
                bodyIds[count - 1] = null /*b2_nullBodyId*/
                count -= 1
            }

            b2World_Step(worldId, 1.0f / 60.0f, 3)
        }

        val counters = b2World_GetCounters(worldId, b2Counters.malloc())
        ENSURE(counters.bodyCount() == 0)

        b2DestroyWorld(worldId)

        ENSURE(b2World_IsValid(worldId) == false)

        return 0
    }

    fun TestIsValid(): Int
    {
        val worldDef = b2DefaultWorldDef(b2WorldDef.malloc())
        val worldId = b2CreateWorld(worldDef, b2WorldId.malloc())
        ENSURE(b2World_IsValid(worldId))

        val bodyDef = b2DefaultBodyDef(b2BodyDef.malloc())

        val bodyId1 = b2CreateBody(worldId, bodyDef, b2BodyId.malloc())
        ENSURE(b2Body_IsValid(bodyId1) == true)

        val bodyId2 = b2CreateBody(worldId, bodyDef, b2BodyId.malloc())
        ENSURE(b2Body_IsValid(bodyId2) == true)

        b2DestroyBody(bodyId1)
        ENSURE(b2Body_IsValid(bodyId1) == false)

        b2DestroyBody(bodyId2)
        ENSURE(b2Body_IsValid(bodyId2) == false)

        b2DestroyWorld(worldId)

        ENSURE(b2World_IsValid(worldId) == false)
        ENSURE(b2Body_IsValid(bodyId2) == false)
        ENSURE(b2Body_IsValid(bodyId1) == false)

        return 0
    }

    fun TestWorldRecycle(): Int
    {
        assert(WORLD_COUNT > 0) { "world count" }

        val count = 100

        val worldIds = arrayOfNulls<b2WorldId>(WORLD_COUNT)

        for (i in 0..<count)
        {
            val worldDef = b2DefaultWorldDef(b2WorldDef.malloc())
            for (j in 0..<WORLD_COUNT)
            {
                worldIds[j] = b2CreateWorld(worldDef, b2WorldId.malloc())
                ENSURE(b2World_IsValid(worldIds[j]) == true)

                val bodyDef = b2DefaultBodyDef(b2BodyDef.malloc())
                b2CreateBody(worldIds[j], bodyDef, b2BodyId.malloc())
            }

            for (j in 0..<WORLD_COUNT)
            {
                val timeStep = 1.0f / 60.0f
                val subStepCount = 1

                for (k in 0..9) {
                    b2World_Step(worldIds[j], timeStep, subStepCount)
                }
            }

            for (j in WORLD_COUNT - 1 downTo 0)
            {
                b2DestroyWorld(worldIds[j])
                ENSURE(b2World_IsValid(worldIds[j]) == false)
                worldIds[j] = null /*b2_nullWorldId*/
            }
        }

        return 0
    }

    private val CustomFilter = b2CustomFilterFcnI { shapeIdA: b2ShapeId?, shapeIdB: b2ShapeId?, context: Long ->
        ENSURE(context == NULL)
        true
    }

    private val PreSolveStatic = b2PreSolveFcnI { shapeIdA: b2ShapeId?, shapeIdB: b2ShapeId?, manifold: b2Manifold?, context: Long ->

    }

    // This test is here to ensure all API functions link correctly.
    fun TestWorldCoverage(): Int
    {
        val worldDef = b2DefaultWorldDef(b2WorldDef.malloc())

        val worldId = b2CreateWorld(worldDef, b2WorldId.malloc())
        ENSURE(b2World_IsValid(worldId))

        b2World_EnableSleeping(worldId, true)
        b2World_EnableSleeping(worldId, false)
        var flag = b2World_IsSleepingEnabled(worldId)
        ENSURE(flag == false)

        b2World_EnableContinuous(worldId, false)
        b2World_EnableContinuous(worldId, true)
        flag = b2World_IsContinuousEnabled(worldId)
        ENSURE(flag == true)

        b2World_SetRestitutionThreshold(worldId, 0.0f)
        b2World_SetRestitutionThreshold(worldId, 2.0f)
        var value = b2World_GetRestitutionThreshold(worldId)
        ENSURE(value == 2.0f)

        b2World_SetHitEventThreshold(worldId, 0.0f)
        b2World_SetHitEventThreshold(worldId, 100.0f)
        value = b2World_GetHitEventThreshold(worldId)
        ENSURE(value == 100.0f)

        b2World_SetCustomFilterCallback(worldId, CustomFilter, NULL)
        b2World_SetPreSolveCallback(worldId, PreSolveStatic, null, NULL)

        val g = b2Vec2.malloc().set(1.0f, 2.0f)
        b2World_SetGravity(worldId, g)
        val v = b2World_GetGravity(worldId, b2Vec2.malloc())
        ENSURE(Objects.equals(v.x(), g.x()))
        ENSURE(Objects.equals(v.y(), g.y()))

        val explosionDef = b2DefaultExplosionDef(b2ExplosionDef.malloc())
        b2World_Explode(worldId, explosionDef)

        b2World_SetContactTuning(worldId, 10.0f, 2.0f, 4.0f)

        b2World_SetMaximumLinearSpeed(worldId, 10.0f)
        value = b2World_GetMaximumLinearSpeed(worldId)
        ENSURE(value == 10.0f)

        b2World_EnableWarmStarting(worldId, true)
        flag = b2World_IsWarmStartingEnabled(worldId)
        ENSURE(flag == true)

        val count = b2World_GetAwakeBodyCount(worldId)
        ENSURE(count == 0)

        val nvalue = memCreateFloatBuffer(1)
        nvalue.put(value)
        b2World_SetUserData(worldId, memGetNativeAddress(nvalue))
        val userData = b2World_GetUserData(worldId)
        ENSURE(userData == memGetNativeAddress(nvalue))

        b2World_Step(worldId, 1.0f, 1)

        b2DestroyWorld(worldId)

        return 0
    }

    fun TestSensor(): Int
    {
        val worldDef = b2DefaultWorldDef(b2WorldDef.malloc())
        val worldId = b2CreateWorld(worldDef, b2WorldId.malloc())

        // Wall from x = 1 to x = 2
        var bodyDef = b2DefaultBodyDef(b2BodyDef.malloc())
        bodyDef.type(b2_staticBody)
        bodyDef.position().x(1.5f)
        bodyDef.position().y(11.0f)
        val wallId = b2CreateBody(worldId, bodyDef, b2BodyId.malloc())
        val box = b2MakeBox(0.5f, 10.0f, b2Polygon.malloc())
        var shapeDef = b2DefaultShapeDef(b2ShapeDef.malloc())
        shapeDef.enableSensorEvents(true)
        b2CreatePolygonShape(wallId, shapeDef, box, b2ShapeId.malloc())

        // Bullet fired towards the wall
        bodyDef = b2DefaultBodyDef(bodyDef)
        bodyDef.type(b2_dynamicBody)
        bodyDef.isBullet(true)
        bodyDef.gravityScale(0.0f)
        bodyDef.position(b2Pos.malloc().set(7.39814f, 4.0f))
        bodyDef.linearVelocity(b2Vec2.malloc().set(-20.0f, 0.0f))
        val bulletId = b2CreateBody(worldId, bodyDef, b2BodyId.malloc())
        shapeDef = b2DefaultShapeDef(shapeDef)
        shapeDef.isSensor(true)
        shapeDef.enableSensorEvents(true)
        val circle = b2Circle.malloc().set(b2Vec2.malloc().set(0.0f, 0.0f), 0.1f)
        b2CreateCircleShape(bulletId, shapeDef, circle, b2ShapeId.malloc())

        var beginCount = 0
        var endCount = 0

        while (true)
        {
            val timeStep = 1.0f / 60.0f
            val subStepCount = 4
            b2World_Step(worldId, timeStep, subStepCount)

            val bulletPos = b2Body_GetPosition(bulletId, b2Pos.malloc())

            // printf( "Bullet pos: %g %g\n", bulletPos.x, bulletPos.y );
            val events = b2World_GetSensorEvents(worldId, b2SensorEvents.malloc())

            if (events.beginCount() > 0)
            {
                beginCount += 1
            }

            if (events.endCount() > 0)
            {
                endCount += 1
            }

            if (bulletPos.x().toFloat() < -1.0f)
            {
                break
            }
        }

        b2DestroyWorld(worldId)

        ENSURE(beginCount == 1)
        ENSURE(endCount == 1)

        return 0
    }

    fun ChainSegmentShapeTest(): Int
    {
        val worldDef = b2DefaultWorldDef(b2WorldDef.malloc())
        worldDef.gravity(b2Vec2.malloc().set(0.0f, -10.0f))
        val worldId = b2CreateWorld(worldDef, b2WorldId.malloc())

        val bodyDef = b2DefaultBodyDef(b2BodyDef.malloc())
        val groundId = b2CreateBody(worldId, bodyDef, b2BodyId.malloc())

        val cs = b2ChainSegment.calloc()
        cs.ghost1(b2Vec2.malloc().set(2.0f, 0.0f))
        cs.segment().point1(b2Vec2.malloc().set(1.0f, 0.0f))
        cs.segment().point2(b2Vec2.malloc().set(-1.0f, 0.0f))
        cs.ghost2(b2Vec2.malloc().set(-2.0f, 0.0f))
        cs.chainId(99)

        val shapeDef = b2DefaultShapeDef(b2ShapeDef.malloc())
        val orphanShape = b2CreateChainSegmentShape(groundId, shapeDef, cs, b2ShapeId.malloc())
        ENSURE(B2_IS_NON_NULL(orphanShape))

        ENSURE(b2Shape_GetType(orphanShape) == b2_chainSegmentShape)

        val parentChain = b2Shape_GetParentChain(orphanShape, b2ChainId.malloc())
        ENSURE(B2_IS_NULL(parentChain))

        val got = b2Shape_GetChainSegment(orphanShape, b2ChainSegment.malloc())
        ENSURE_SMALL(got.ghost1().x() - cs.ghost1().x(), 1e-5f)
        ENSURE_SMALL(got.ghost1().y() - cs.ghost1().y(), 1e-5f)
        ENSURE_SMALL(got.segment().point1().x() - cs.segment().point1().x(), 1e-5f)
        ENSURE_SMALL(got.segment().point1().y() - cs.segment().point1().y(), 1e-5f)
        ENSURE_SMALL(got.segment().point2().x() - cs.segment().point2().x(), 1e-5f)
        ENSURE_SMALL(got.segment().point2().y() - cs.segment().point2().y(), 1e-5f)
        ENSURE_SMALL(got.ghost2().x() - cs.ghost2().x(), 1e-5f)
        ENSURE_SMALL(got.ghost2().y() - cs.ghost2().y(), 1e-5f)
        ENSURE(got.chainId() == B2_NULL_INDEX)

        val dynamicDef = b2DefaultBodyDef(b2BodyDef.malloc())
        dynamicDef.type(b2_dynamicBody)
        dynamicDef.position(b2Pos.malloc().set(0.0f, 2.0f))
        val circleBodyId = b2CreateBody(worldId, dynamicDef, b2BodyId.malloc())
        val circle = b2Circle.malloc().set(b2Vec2.malloc().set(0.0f, 0.0f), 0.5f)
        val circleShapeDef = b2DefaultShapeDef(b2ShapeDef.malloc())
        b2CreateCircleShape(circleBodyId, circleShapeDef, circle, b2ShapeId.malloc())

        for (i in 0..119)
        {
            b2World_Step(worldId, 1.0f / 60.0f, 4)
        }

        val circlePos = b2Body_GetPosition(circleBodyId, b2Pos.malloc())
        ENSURE(circlePos.y().toFloat() > 0.0f)

        val cs2 = b2ChainSegment.calloc()
        cs2.ghost1(b2Vec2.malloc().set(3.0f, 0.0f))
        cs2.segment().point1(b2Vec2.malloc().set(2.0f, 0.0f))
        cs2.segment().point2(b2Vec2.malloc().set(-2.0f, 0.0f))
        cs2.ghost2(b2Vec2.malloc().set(-3.0f, 0.0f))
        cs2.chainId(B2_NULL_INDEX)

        b2Shape_SetChainSegment(orphanShape, cs2)

        val got2 = b2Shape_GetChainSegment(orphanShape, b2ChainSegment.malloc())
        ENSURE_SMALL(got2.segment().point1().x() - cs2.segment().point1().x(), 1e-5f)
        ENSURE_SMALL(got2.segment().point1().y() - cs2.segment().point1().y(), 1e-5f)
        ENSURE_SMALL(got2.segment().point2().x() - cs2.segment().point2().x(), 1e-5f)
        ENSURE_SMALL(got2.segment().point2().y() - cs2.segment().point2().y(), 1e-5f)
        ENSURE_SMALL(got2.ghost1().x() - cs2.ghost1().x(), 1e-5f)
        ENSURE_SMALL(got2.ghost1().y() - cs2.ghost1().y(), 1e-5f)
        ENSURE_SMALL(got2.ghost2().x() - cs2.ghost2().x(), 1e-5f)
        ENSURE_SMALL(got2.ghost2().y() - cs2.ghost2().y(), 1e-5f)
        ENSURE(got2.chainId() == B2_NULL_INDEX)

        val parentChain2 = b2Shape_GetParentChain(orphanShape, b2ChainId.malloc())
        ENSURE(B2_IS_NULL(parentChain2))

        val convBody = b2CreateBody(worldId, bodyDef, b2BodyId.malloc())
        val convCircle = b2Circle.malloc().set(b2Vec2.malloc().set(0.0f, 0.0f), 0.25f)
        val convShape = b2CreateCircleShape(convBody, shapeDef, convCircle, b2ShapeId.malloc())
        ENSURE(b2Shape_GetType(convShape) == b2_circleShape)

        b2Shape_SetChainSegment(convShape, cs2)

        ENSURE(b2Shape_GetType(convShape) == b2_chainSegmentShape)
        val got3 = b2Shape_GetChainSegment(convShape, b2ChainSegment.malloc())
        ENSURE_SMALL(got3.ghost1().x() - cs2.ghost1().x(), 1e-5f)
        ENSURE_SMALL(got3.ghost1().y() - cs2.ghost1().y(), 1e-5f)
        ENSURE_SMALL(got3.ghost2().x() - cs2.ghost2().x(), 1e-5f)
        ENSURE_SMALL(got3.ghost2().y() - cs2.ghost2().y(), 1e-5f)
        ENSURE(got3.chainId() == B2_NULL_INDEX)

        val parentChain3 = b2Shape_GetParentChain(convShape, b2ChainId.malloc())
        ENSURE(B2_IS_NULL(parentChain3))

        b2DestroyShape(orphanShape, true)
        b2DestroyWorld(worldId)

        return 0
    }

    fun DeferredMassFlagSyncTest(): Int
    {
        val worldDef = b2DefaultWorldDef(b2WorldDef.malloc())
        val worldId = b2CreateWorld(worldDef, b2WorldId.malloc())

        val bodyDef = b2DefaultBodyDef(b2BodyDef.malloc())
        bodyDef.type(b2_dynamicBody)
        val bodyId = b2CreateBody(worldId, bodyDef, b2BodyId.malloc())

        val shapeDef = b2DefaultShapeDef(b2ShapeDef.malloc())
        shapeDef.updateBodyMass(false)

        val circle = b2Circle.malloc().set(b2Vec2.malloc().set(0.0f, 0.0f), 0.5f)
        b2CreateCircleShape(bodyId, shapeDef, circle, b2ShapeId.malloc())

        b2Body_ApplyMassFromShapes(bodyId)

        b2World_Step(worldId, 1.0f / 60.0f, 4)

        b2DestroyWorld(worldId)
        return 0
    }

    fun EnableSleepFlagSyncTest(): Int
    {
        val worldDef = b2DefaultWorldDef(b2WorldDef.malloc())
        val worldId = b2CreateWorld(worldDef, b2WorldId.malloc())

        val bodyDef = b2DefaultBodyDef(b2BodyDef.malloc())
        bodyDef.type(b2_dynamicBody)
        bodyDef.enableSleep(false)
        val bodyId = b2CreateBody(worldId, bodyDef, b2BodyId.malloc())

        ENSURE(b2Body_IsSleepEnabled(bodyId) == false)

        b2Body_EnableSleep(bodyId, true)
        ENSURE(b2Body_IsSleepEnabled(bodyId) == true)

        b2World_Step(worldId, 1.0f / 60.0f, 4)

        b2DestroyWorld(worldId)
        return 0
    }

    fun EnableContactRecyclingTest(): Int
    {
        val worldDef = b2DefaultWorldDef(b2WorldDef.malloc())
        val worldId = b2CreateWorld(worldDef, b2WorldId.malloc())

        val bodyDef = b2DefaultBodyDef(b2BodyDef.malloc())
        bodyDef.type(b2_dynamicBody)

        // Default is enabled
        val bodyA = b2CreateBody(worldId, bodyDef, b2BodyId.malloc())
        ENSURE(b2Body_IsContactRecyclingEnabled(bodyA) == true)

        b2Body_EnableContactRecycling(bodyA, false)
        ENSURE(b2Body_IsContactRecyclingEnabled(bodyA) == false)

        b2Body_EnableContactRecycling(bodyA, true)
        ENSURE(b2Body_IsContactRecyclingEnabled(bodyA) == true)

        // Per-def opt-out at creation
        bodyDef.enableContactRecycling(false)
        val bodyB = b2CreateBody(worldId, bodyDef, b2BodyId.malloc())
        ENSURE(b2Body_IsContactRecyclingEnabled(bodyB) == false)

        // Stepping after toggling must not trip the flag-sync validator
        b2World_Step(worldId, 1.0f / 60.0f, 4)

        b2DestroyWorld(worldId)
        return 0
    }

    fun SetBulletDriftTest(): Int
    {
        val worldDef = b2DefaultWorldDef(b2WorldDef.malloc())
        val worldId = b2CreateWorld(worldDef, b2WorldId.malloc())

        run {
            val bodyDef = b2DefaultBodyDef(b2BodyDef.malloc())
            bodyDef.type(b2_dynamicBody)
            bodyDef.isBullet(false)
            val bodyId = b2CreateBody(worldId, bodyDef, b2BodyId.malloc())

            ENSURE(b2Body_IsBullet(bodyId) == false)

            b2Body_SetBullet(bodyId, true)
            ENSURE(b2Body_IsBullet(bodyId) == true)

            val locks = b2MotionLocks.calloc()
            locks.linearX(true)
            b2Body_SetMotionLocks(bodyId, locks)
            ENSURE(b2Body_IsBullet(bodyId) == true)
        }

        run {
            val bodyDef = b2DefaultBodyDef(b2BodyDef.malloc())
            bodyDef.type(b2_dynamicBody)
            bodyDef.isBullet(true)
            val bodyId = b2CreateBody(worldId, bodyDef, b2BodyId.malloc())

            ENSURE(b2Body_IsBullet(bodyId) == true)

            b2Body_SetBullet(bodyId, false)
            ENSURE(b2Body_IsBullet(bodyId) == false)

            val locks = b2MotionLocks.calloc()
            locks.linearX(true)
            b2Body_SetMotionLocks(bodyId, locks)
            ENSURE(b2Body_IsBullet(bodyId) == false)
        }

        b2DestroyWorld(worldId)
        return 0
    }

    fun WorldTest( ): Int
    {
        RUN_SUBTEST( ::HelloWorld)
        RUN_SUBTEST( ::EmptyWorld )
        RUN_SUBTEST( ::DestroyAllBodiesWorld )
        RUN_SUBTEST( ::TestIsValid )
        RUN_SUBTEST( ::TestWorldRecycle )
        RUN_SUBTEST( ::TestWorldCoverage )
        RUN_SUBTEST( ::TestSensor )
        //RUN_SUBTEST( ::TestSetWorkerCount )
        RUN_SUBTEST( ::ChainSegmentShapeTest )
        RUN_SUBTEST( ::SetBulletDriftTest )
        RUN_SUBTEST( ::DeferredMassFlagSyncTest )
        RUN_SUBTEST( ::EnableSleepFlagSyncTest )
        RUN_SUBTEST( ::EnableContactRecyclingTest )

        return 0
    }
}