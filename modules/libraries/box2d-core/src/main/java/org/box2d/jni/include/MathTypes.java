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
package org.box2d.jni.include;

import org.box2d.jni.b2Mat22;
import org.box2d.jni.b2Pos;
import org.box2d.jni.b2Rot;
import org.box2d.jni.b2Transform;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.b2WorldTransform;

import org.box2d.jni.system.ArenaAlloc;

import org.box2d.jni.system.Library;
import static org.box2d.jni.system.ArenaAlloc.*;

/**
 * Class that represents the {@code <math_types.h>} header of box2d.
 *
 * @author wil
 * @version 1.0.0
 * @since 2.0.0
 */
@SuppressWarnings("unchecked")
public class MathTypes {
    static {
        Library.initialize();
    }

    /**
     * The PI number used by box2d in the native layer.
     */
    public static final float B2_PI = nB2_PI();
    /* Native bindings: {@code #define B2_PI } */
    public static native float nB2_PI();

    /** A vector at the origin. */
    public static final b2Vec2 b2Vec2_zero = b2Vec2.malloc().set( 0.0f, 0.0f );
    /** A rotation identity. */
    public static final b2Rot b2Rot_identity = b2Rot.malloc().set( 1.0f, 0.0f );
    /** A transformed identity. */
    public static final b2Transform b2Transform_identity = b2Transform.malloc() ;
    /** A matrix of zeros. */
    public static final b2Mat22 b2Mat22_zero = b2Mat22.malloc();

    /** Native bindings: {@code static const b2Pos b2Pos_zero = { 0.0f, 0.0f };} */
    public static final b2Pos b2Pos_zero = b2Pos.malloc().set( 0.0f, 0.0f );
    /** Native bindings: {@code static const b2WorldTransform b2WorldTransform_identity = { { 0.0f, 0.0f }, { 1.0f, 0.0f } };} */
    public static final b2WorldTransform b2WorldTransform_identity = b2WorldTransform.malloc();

    static {
        try (ArenaAlloc arena = allocPush()) {
            b2Transform_identity.set(
                b2Vec2.calloc(arena).set(0.0f, 0.0f),
                b2Rot.calloc(arena).set(1.0f, 0.0f)
            );
            b2Mat22_zero.set(
                b2Vec2.calloc(arena).set(0.0f, 0.0f),
                b2Vec2.calloc(arena).set(0.0f, 0.0f)
            );
            b2WorldTransform_identity.set(
                b2Pos.calloc(arena).set(0.0f, 0.0f),
                b2Rot.calloc(arena).set(1.0f, 0.0f)
            );
        }
    }
}
