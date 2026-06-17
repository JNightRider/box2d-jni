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
 * typedef enum b2ShapeType
 * {
 * 	/// A circle with an offset
 * 	b2_circleShape,
 * 
 * 	/// A capsule is an extruded circle
 * 	b2_capsuleShape,
 * 
 * 	/// A line segment
 * 	b2_segmentShape,
 * 
 * 	/// A convex polygon
 * 	b2_polygonShape,
 * 
 * 	/// A line segment owned by a chain shape
 * 	b2_chainSegmentShape,
 * 
 * 	/// The number of shape types
 * 	b2_shapeTypeCount
 * } b2ShapeType;
 * </code></pre>
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public enum b2ShapeType {

    /**
     * A circle with an offset
     * <pre><code>
     * b2_circleShap
     * </code></pre>
     */
    b2_circleShape(
        nb2_circleShape()
    ),

    /**
     * A capsule is an extruded circle
     * <pre><code>
     * b2_capsuleShape
     * </code></pre>
     */
    b2_capsuleShape(
        nb2_capsuleShape()
    ),

    /**
     * A line segment
     * <pre><code>
     * b2_segmentShape
     * </code></pre>
     */
    b2_segmentShape(
        nb2_segmentShape()
    ),

    /**
     * A convex polygon
     * <pre><code>
     * b2_polygonShape
     * </code></pre>
     */
    b2_polygonShape(
        nb2_polygonShape()
    ),

    /**
     * A line segment owned by a chain shape
     * <pre><code>
     * b2_chainSegmentShape
     * </code></pre>
     */
    b2_chainSegmentShape(
        nb2_chainSegmentShape()
    ),

    /**
     * The number of shape types
     * <pre><code>
     * b2_shapeTypeCount
     * </code></pre>
     */
    b2_shapeTypeCount(
        nb2_shapeTypeCount()
    );

    static {  Library.initialize(); }
    /** Native identifier for this shape type. */
    private final int b2Type;

    /**
     * Create enum value.
     *
     * @param b2Type type
     */
    private b2ShapeType(int b2Type) {
        this.b2Type = b2Type;
    }

    /**
     * Get native value.
     * @return int
     */
    protected int value() {
        return b2Type;
    }

    /**
     * Evaluate the native type of a body to return an enumerated object ready to be consumed.
     * @param type type
     * @return body type
     */
    public static b2ShapeType valueOf(int type) {
        if (type == b2_circleShape.value()) {
            return b2_circleShape;
        } else if (type == b2_capsuleShape.value()) {
            return b2_capsuleShape;
        } else if (type == b2_segmentShape.value()) {
            return b2_segmentShape;
        } else if (type == b2_polygonShape.value()) {
            return b2_polygonShape;
        } else if (type == b2_chainSegmentShape.value()) {
            return b2_chainSegmentShape;
        } else if (type == b2_shapeTypeCount.value()) {
            return b2_shapeTypeCount;
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
     /* Binding JNI to property 'b2_circleShape' of structure 'b2ShapeType' */
    public static native int nb2_circleShape();
     /* Binding JNI to property 'b2_capsuleShape' of structure 'b2ShapeType' */
    public static native int nb2_capsuleShape();
     /* Binding JNI to property 'b2_segmentShape' of structure 'b2ShapeType' */
    public static native int nb2_segmentShape();
     /* Binding JNI to property 'b2_polygonShape' of structure 'b2ShapeType' */
    public static native int nb2_polygonShape();
     /* Binding JNI to property 'b2_chainSegmentShape' of structure 'b2ShapeType' */
    public static native int nb2_chainSegmentShape();
     /* Binding JNI to property 'b2_shapeTypeCount' of structure 'b2ShapeType' */
    public static native int nb2_shapeTypeCount();
}
