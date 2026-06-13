/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

import java.nio.ByteBuffer;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2SimplexCache</code>. (native type: const b2SimplexCache)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2SimplexCache extends ConstStruct {
    /**
     * The number of stored simplex points
     * 
     * @return short
     */
    short count();

    /**
     * The cached simplex indices on shape A
     * 
     * @return ByteBuffer
     */
    ByteBuffer indexA();

    /**
     * The cached simplex indices on shape B
     * 
     * @return ByteBuffer
     */
    ByteBuffer indexB();
}
