/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a constant
 * of type <code>b2Circle</code>. (native type: const b2Circle)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2Circle extends ConstStruct {
    /**
     * The local center
     * 
     * @return ConstB2Vec2
     */
    ConstB2Vec2 center();

    /**
     * The radius
     * 
     * @return float
     */
    float radius();
}
