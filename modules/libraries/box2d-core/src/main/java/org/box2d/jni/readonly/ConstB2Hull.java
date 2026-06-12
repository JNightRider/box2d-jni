/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2Hull</code>. (native type: const b2Hull)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2Hull extends ConstStruct {

    /**
     * The final points of the hull
     *
     * @return ConstB2Vec2.ConstBuffer
     */
    ConstB2Vec2.ConstBuffer points();

    /**
     * The number of points
     *
     * @return int
     */
    int count();
}
