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
 * typedef enum b2RecQueryType
 * {
 * 	b2_recQueryOverlapAABB,
 * 	b2_recQueryOverlapShape,
 * 	b2_recQueryCastRay,
 * 	b2_recQueryCastShape,
 * 	b2_recQueryCollideMover,
 * 	b2_recQueryCastRayClosest,
 * 	b2_recQueryCastMover,
 * 	b2_recQueryShapeTestPoint,
 * 	b2_recQueryShapeRayCast,
 * } b2RecQueryType;
 * </code></pre>
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public enum b2RecQueryType {
    /** 
     * <pre><code>
     * b2_recQueryOverlapAABB -&#62; box2d
     * </code></pre>
     */
    b2_recQueryOverlapAABB(
        nb2_recQueryOverlapAABB()
    ),
    
    /** 
     * <pre><code>
     * b2_recQueryOverlapShape -&#62; box2d
     * </code></pre>
     */
    b2_recQueryOverlapShape(
        nb2_recQueryOverlapShape()
    ),
    
    /** 
     * <pre><code>
     * b2_recQueryCastRay -&#62; box2d
     * </code></pre>
     */
    b2_recQueryCastRay(
        nb2_recQueryCastRay()
    ),
    
    /** 
     * <pre><code>
     * b2_recQueryCastShape -&#62; box2d
     * </code></pre>
     */
    b2_recQueryCastShape(
        nb2_recQueryCastShape()
    ),
    
    /** 
     * <pre><code>
     * b2_recQueryCollideMover -&#62; box2d
     * </code></pre>
     */
    b2_recQueryCollideMover(
        nb2_recQueryCollideMover()
    ),
    
    /** 
     * <pre><code>
     * b2_recQueryCastRayClosest -&#62; box2d
     * </code></pre>
     */
    b2_recQueryCastRayClosest(
        nb2_recQueryCastRayClosest()
    ),
    
    /** 
     * <pre><code>
     * b2_recQueryCastMover -&#62; box2d
     * </code></pre>
     */
    b2_recQueryCastMover(
        nb2_recQueryCastMover()
    ),
    
    /** 
     * <pre><code>
     * b2_recQueryShapeTestPoint -&#62; box2d
     * </code></pre>
     */
    b2_recQueryShapeTestPoint(
        nb2_recQueryShapeTestPoint()
    ),
    
    /** 
     * <pre><code>
     * b2_recQueryShapeRayCast -&#62; box2d
     * </code></pre>
     */
    b2_recQueryShapeRayCast(
        nb2_recQueryShapeRayCast()
    );

    static {
        Library.initialize();
    }

    /**
     * An integer value that identifies the body type natively, that is, it is the native body type.
     */
    private final Integer b2Type;

    /**
     * Generate a new <code>BodyType</code>.
     * @param b2Type type
     */
    private b2RecQueryType(Integer b2Type) {
        this.b2Type = b2Type;
    }

    /**
     * Returns the native type
     * @return int
     */
    public Integer value() {
        return b2Type;
    }
    
    /**
     * Evaluate the native type of a body to return an enumerated object ready to be consumed.
     * @param type type
     * @return body type
     */
    public static b2RecQueryType valueOf(int type) {
        if (type == b2_recQueryOverlapAABB.value()) {
            return b2_recQueryOverlapAABB;
        } else if (type == b2_recQueryOverlapShape.value()) {
            return b2_recQueryOverlapShape;
        } else if (type == b2_recQueryCastRay.value()) {
            return b2_recQueryCastRay;
        } else if (type == b2_recQueryCastShape.value()) {
            return b2_recQueryCastShape;
        } else if (type == b2_recQueryCollideMover.value()) {
            return b2_recQueryCollideMover;
        } else if (type == b2_recQueryCastRayClosest.value()) {
            return b2_recQueryCastRayClosest;
        } else if (type == b2_recQueryCastMover.value()) {
            return b2_recQueryCastMover;
        } else if (type == b2_recQueryShapeTestPoint.value()) {
            return b2_recQueryShapeTestPoint;
        } else if (type == b2_recQueryShapeRayCast.value()) {
            return b2_recQueryShapeRayCast;
        }
        throw new UnsupportedOperationException("enum: " + type);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString() 
     */
    @Override
    public String toString() {
        return String.valueOf(b2Type);
    }
    
    /* Binding JNI to property 'b2_recQueryOverlapAABB' of structure 'b2RecQueryType' */
    public static native int nb2_recQueryOverlapAABB();
    /* Binding JNI to property 'b2_recQueryOverlapShape' of structure 'b2RecQueryType' */
    public static native int nb2_recQueryOverlapShape();
    /* Binding JNI to property 'b2_recQueryCastRay' of structure 'b2RecQueryType' */
    public static native int nb2_recQueryCastRay();
    /* Binding JNI to property 'b2_recQueryCastShape' of structure 'b2RecQueryType' */
    public static native int nb2_recQueryCastShape();
    /* Binding JNI to property 'b2_recQueryCollideMover' of structure 'b2RecQueryType' */
    public static native int nb2_recQueryCollideMover();
    /* Binding JNI to property 'b2_recQueryCastRayClosest' of structure 'b2RecQueryType' */
    public static native int nb2_recQueryCastRayClosest();
    /* Binding JNI to property 'b2_recQueryCastMover' of structure 'b2RecQueryType' */
    public static native int nb2_recQueryCastMover();
    /* Binding JNI to property 'b2_recQueryShapeTestPoint' of structure 'b2RecQueryType' */
    public static native int nb2_recQueryShapeTestPoint();
    /* Binding JNI to property 'b2_recQueryShapeRayCast' of structure 'b2RecQueryType' */
    public static native int nb2_recQueryShapeRayCast(); 
}
