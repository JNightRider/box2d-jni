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

import org.box2d.jni.system.Library;

/**
 * <pre><code>
 * typedef enum b2ReplayQueryType
 * {
 * 	b2_replayQueryOverlapAABB,
 * 	b2_replayQueryOverlapShape,
 * 	b2_replayQueryCastRay,
 * 	b2_replayQueryCastShape,
 * 	b2_replayQueryCollideMover,
 * 	b2_replayQueryCastRayClosest,
 * 	b2_replayQueryCastMover,
 * 	b2_replayQueryShapeTestPoint,
 * 	b2_replayQueryShapeRayCast,
 * } b2ReplayQueryType;
 * </code></pre>
 *
 * @author wil
 * @version 2.0.0
 * @since 1.0.0
 */
public enum b2ReplayQueryType {
    /** 
     * <pre><code>
     * b2_replayQueryOverlapAABB -&#62; box2d
     * </code></pre>
     */
    b2_replayQueryOverlapAABB(
        nb2_replayQueryOverlapAABB()
    ),
    
    /** 
     * <pre><code>
     * b2_replayQueryOverlapShape -&#62; box2d
     * </code></pre>
     */
    b2_replayQueryOverlapShape(
        nb2_replayQueryOverlapShape()
    ),
    
    /** 
     * <pre><code>
     * b2_replayQueryCastRay -&#62; box2d
     * </code></pre>
     */
    b2_replayQueryCastRay(
        nb2_replayQueryCastRay()
    ),
    
    /** 
     * <pre><code>
     * b2_replayQueryCastShape -&#62; box2d
     * </code></pre>
     */
    b2_replayQueryCastShape(
        nb2_replayQueryCastShape()
    ),
    
    /** 
     * <pre><code>
     * b2_replayQueryCollideMover -&#62; box2d
     * </code></pre>
     */
    b2_replayQueryCollideMover(
        nb2_replayQueryCollideMover()
    ),
    
    /** 
     * <pre><code>
     * b2_replayQueryCastRayClosest -&#62; box2d
     * </code></pre>
     */
    b2_replayQueryCastRayClosest(
        nb2_replayQueryCastRayClosest()
    ),
    
    /** 
     * <pre><code>
     * b2_replayQueryCastMover -&#62; box2d
     * </code></pre>
     */
    b2_replayQueryCastMover(
        nb2_replayQueryCastMover()
    ),
    
    /** 
     * <pre><code>
     * b2_recQueryShapeTestPoint -&#62; box2d
     * </code></pre>
     */
    b2_replayQueryShapeTestPoint(
        nb2_replayQueryShapeTestPoint()
    ),
    
    /** 
     * <pre><code>
     * b2_recQueryShapeRayCast -&#62; box2d
     * </code></pre>
     */
    b2_replayQueryShapeRayCast(
        nb2_replayQueryShapeRayCast()
    );

    static {
        Library.initialize();
    }

    /**
     * An integer value that identifies the body type natively, that is, it is the native body type.
     */
    private final int b2Type;

    /**
     * Generate a new <code>BodyType</code>.
     * @param b2Type type
     */
    private b2ReplayQueryType(int b2Type) {
        this.b2Type = b2Type;
    }

    /**
     * Returns the native type
     * @return int
     */
    public int value() {
        return b2Type;
    }
    
    /**
     * Evaluate the native type of a body to return an enumerated object ready to be consumed.
     * @param type type
     * @return body type
     */
    public static b2ReplayQueryType valueOf(int type) {
        for (b2ReplayQueryType value : b2ReplayQueryType.values()) {
            if (value.value() == type) {
                return value;
            }
        }
        throw new UnsupportedOperationException("enum b2ReplayQueryType: " + type);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString() 
     */
    @Override
    public String toString() {
        return String.valueOf(b2Type);
    }
    
    /* Binding JNI to property 'b2_replayQueryOverlapAABB' of structure 'b2ReplayQueryType' */
    public static native int nb2_replayQueryOverlapAABB();
    /* Binding JNI to property 'b2_replayQueryOverlapShape' of structure 'b2ReplayQueryType' */
    public static native int nb2_replayQueryOverlapShape();
    /* Binding JNI to property 'b2_replayQueryCastRay' of structure 'b2ReplayQueryType' */
    public static native int nb2_replayQueryCastRay();
    /* Binding JNI to property 'b2_replayQueryCastShape' of structure 'b2ReplayQueryType' */
    public static native int nb2_replayQueryCastShape();
    /* Binding JNI to property 'b2_replayQueryCollideMover' of structure 'b2ReplayQueryType' */
    public static native int nb2_replayQueryCollideMover();
    /* Binding JNI to property 'b2_replayQueryCastRayClosest' of structure 'b2ReplayQueryType' */
    public static native int nb2_replayQueryCastRayClosest();
    /* Binding JNI to property 'b2_replayQueryCastMover' of structure 'b2ReplayQueryType' */
    public static native int nb2_replayQueryCastMover();
    /* Binding JNI to property 'b2_replayQueryShapeTestPoint' of structure 'b2ReplayQueryType' */
    public static native int nb2_replayQueryShapeTestPoint();
    /* Binding JNI to property 'b2_replayQueryShapeRayCast' of structure 'b2ReplayQueryType' */
    public static native int nb2_replayQueryShapeRayCast(); 
}
