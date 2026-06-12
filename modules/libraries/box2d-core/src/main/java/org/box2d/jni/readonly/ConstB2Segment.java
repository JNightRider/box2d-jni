/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a constant
 * of type <code>b2Segment</code>. (native type: const b2Segment)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2Segment extends ConstStruct {
    /**
     * The first point
     * 
     * @return ConstB2Vec2
     */
    ConstB2Vec2 point1();

    /**
     * The second point
     * 
     * @return ConstB2Vec2
     */
    ConstB2Vec2 point2();
}
