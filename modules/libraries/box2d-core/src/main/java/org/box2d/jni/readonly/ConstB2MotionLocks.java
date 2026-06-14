/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2MotionLocks</code>. (native type: const
 * b2MotionLocks)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2MotionLocks extends ConstStruct {

    /**
     * Prevent translation along the x-axis
     *
     * @return boolean
     */
    boolean linearX();

    /**
     * revent translation along the y-axis
     *
     * @return boolean
     */
    boolean linearY();

    /**
     * Prevent rotation around the z-axis
     *
     * @return boolean
     */
    boolean angularZ();
}
