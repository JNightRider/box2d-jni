/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

import org.box2d.jni.b2ShapeId;
import org.box2d.jni.b2Vec2;

/**
 * Interface that is responsible for representing a native object that is a constant
 * of type <code>b2RayResult</code>. (native type: const b2RayResult)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2RayResult extends ConstStruct {
    /** @return Returns the property {@code shapeId} */
    public b2ShapeId shapeId();
    /** @return Returns the property {@code point} */
    public b2Vec2 point();
    /** @return Returns the property {@code normal} */
    public b2Vec2 normal();
    /** @return Returns the property {@code fraction} */
    public float fraction();
    /** @return Returns the property {@code nodeVisits} */
    public int nodeVisits();
    /** @return Returns the property {@code leafVisits} */
    public int leafVisits();
    /** @return Returns the property {@code hit} */
    public boolean hit();
}
