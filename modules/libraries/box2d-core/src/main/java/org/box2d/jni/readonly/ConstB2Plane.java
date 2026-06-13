/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2Plane</code>. (native type: const b2Plane)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2Plane extends ConstStruct {

    /**
     * An object of type {@link org.box2d.jni.b2Vec2}
     *
     *
     * @return ConstB2Vec2
     */
    ConstB2Vec2 normal();

    /**
     * float: the offset
     *
     * @return float
     */
    float offset();
}
