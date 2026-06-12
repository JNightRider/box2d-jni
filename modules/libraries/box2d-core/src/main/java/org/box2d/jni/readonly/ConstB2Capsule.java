/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a constant
 * of type <code>b2Capsule</code>. (native type: const b2Capsule)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2Capsule extends ConstStruct {
    /**
     * Local center of the first semicircle
     * 
     * @return ConstB2Vec2
     */
    ConstB2Vec2 center1();
    
    /**
     * Local center of the second semicircle
     * 
     * @return ConstB2Vec2
     */
    ConstB2Vec2 center2();

    /**
     * The radius of the semicircles
     * 
     * @return float
     */
    float radius();
}
