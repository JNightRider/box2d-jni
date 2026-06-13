/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2Sweep</code>. (native type: const b2Sweep)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2Sweep extends ConstStruct {

    /**
     * Local center of mass position
     *
     * @return ConstB2Vec2
     */
    ConstB2Vec2 localCenter();

    /**
     * Starting center of mass world position
     *
     * @return ConstB2Vec2
     */
    ConstB2Vec2 c1();

    /**
     * Ending center of mass world position
     *
     * @return ConstB2Vec2
     */
    ConstB2Vec2 c2();

    /**
     * Starting world rotation
     *
     * @return ConstB2Rot
     */
    ConstB2Rot q1();

    /**
     * Ending world rotation
     *
     * @return ConstB2Rot
     */
    ConstB2Rot q2();
}
