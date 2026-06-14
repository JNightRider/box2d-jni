/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2ExplosionDef</code>. (native type: const b2ExplosionDef)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2ExplosionDef extends ConstStruct {

    /**
     * Mask bits to filter shapes
     *
     * @return long
     */
    long maskBits();

    /**
     * The center of the explosion in world space
     *
     * @return ConstB2Vec2
     */
    ConstB2Vec2 position();

    /**
     * The radius of the explosion
     *
     * @return float
     */
    float radius();

    /**
     * The falloff distance beyond the radius. Impulse is reduced to zero at
     * this distance.
     *
     * @return float
     */
    float falloff();

    /**
     * Impulse per unit length. This applies an impulse according to the shape
     * perimeter that is facing the explosion. Explosions only apply to circles,
     * capsules, and polygons. This may be negative for implosions.
     *
     * @return float
     */
    float impulsePerLength();
}
