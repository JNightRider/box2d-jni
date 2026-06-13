/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2Rot</code>. (native type: const b2Rot)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2Rot extends ConstStruct {

    /**
     * cosine
     *
     * @return float
     */
    float c();

    /**
     * sine
     *
     * @return float
     */
    float s();
}
