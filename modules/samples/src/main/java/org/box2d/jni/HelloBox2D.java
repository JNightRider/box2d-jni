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
package org.box2d.jni;

import org.box2d.jni.system.Callbacks;
import static org.box2d.jni.b2BodyType.*;

import static org.box2d.jni.include.Box2d.*;
import static org.box2d.jni.include.Collision.*;
import static org.box2d.jni.include.MathFunctions.*;
import static org.box2d.jni.include.Types.*;

/**
 * This is a good example of how to get up and running with Box2D - <b>HelloBox2D</b>.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class HelloBox2D {

    /**
     * The main method; uses zero arguments in the args array.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        b2WorldDef worldDef = b2DefaultWorldDef(b2WorldDef.malloc());
        worldDef.gravity(b2Vec2.malloc().set(0.0f, -10.0f));
        
        b2WorldId worldId = b2CreateWorld(worldDef, b2WorldId.malloc());
        
        b2BodyDef groundBodyDef = b2DefaultBodyDef(b2BodyDef.malloc());
        groundBodyDef.position(b2Vec2.malloc().set(0.0f, -10.0f));
        
        b2BodyId groundId = b2CreateBody(worldId, groundBodyDef, b2BodyId.malloc());
        b2Polygon groundBox = b2MakeBox(50.0f, 10.0f, b2Polygon.malloc());
        
        b2ShapeDef groundShapeDef = b2DefaultShapeDef(b2ShapeDef.malloc());
        b2CreatePolygonShape(groundId, groundShapeDef, groundBox, b2ShapeId.malloc());
        
        b2BodyDef bodyDef = b2DefaultBodyDef(b2BodyDef.malloc());
        bodyDef.type(b2_dynamicBody);
        bodyDef.position(b2Vec2.malloc().set(0.0f, 4.0f));
        b2BodyId bodyId = b2CreateBody(worldId, bodyDef, b2BodyId.malloc());
        
        b2Polygon dynamicBox = b2MakeBox(1.0f, 1.0f, b2Polygon.malloc());
        
        b2ShapeDef shapeDef = b2DefaultShapeDef(b2ShapeDef.malloc());
        shapeDef.density(1.0f);
        shapeDef.material().friction(0.3f);
        
        b2CreatePolygonShape(bodyId, shapeDef, dynamicBox, b2ShapeId.malloc());
        
        float timeStep = 1.0f / 60.0f;
        int subStepCount = 4;
        
        for (int i = 0; i < 90; ++i)
        {
            b2World_Step(worldId, timeStep, subStepCount);
            b2Pos position = b2Body_GetPosition(bodyId, b2Pos.nmalloc());
            b2Rot rotation = b2Body_GetRotation(bodyId, b2Rot.malloc());
            System.out.printf("%4.2f %4.2f %4.2f\n", position.x(), position.y(), b2Rot_GetAngle(rotation));
        }
        
        b2DestroyWorld(worldId);
        Callbacks.b2FreeCallbacks();
    }
}
