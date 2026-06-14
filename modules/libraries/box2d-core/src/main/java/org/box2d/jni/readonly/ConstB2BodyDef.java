/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

import org.box2d.jni.b2BodyType;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2BodyDef</code>. (native type: const b2BodyDef)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2BodyDef extends ConstStruct {

    /**
     * The body type: static, kinematic, or dynamic.
     *
     * @return b2BodyType
     */
    b2BodyType type();

    /**
     * The initial world position of the body. Bodies should be created with the
     * desired position.
     * <b> Creating bodies at the origin and then moving them nearly doubles the
     * cost of body creation, especially if the body is moved after shapes have
     * been added.</b>
     *
     * @return
     */
    ConstB2Vec2 position();

    /**
     * The initial world rotation of the body. Use b2MakeRot() if you have an
     * angle.
     *
     * @return ConstB2Rot
     */
    ConstB2Rot rotation();

    /**
     * The initial linear velocity of the body's origin. Usually in meters per
     * second.
     *
     * @return ConstB2Vec2
     */
    ConstB2Vec2 linearVelocity();

    /**
     * The initial angular velocity of the body. Radians per second.
     *
     * @return
     */
    float angularVelocity();

    /**
     * Linear damping is used to reduce the linear velocity. The damping
     * parameter can be larger than 1 but the damping effect becomes sensitive
     * to the time step when the damping parameter is large. Generally linear
     * damping is undesirable because it makes objects move slowly as if they
     * are floating.
     *
     * @return float
     */
    float linearDamping();

    /**
     * Angular damping is used to reduce the angular velocity. The damping
     * parameter can be larger than 1.0f but the damping effect becomes
     * sensitive to the time step when the damping parameter is large. Angular
     * damping can be use slow down rotating bodies.
     *
     * @return float
     */
    float angularDamping();

    /**
     * Scale the gravity applied to this body. Non-dimensional.
     *
     * @return float
     */
    float gravityScale();

    /**
     * Sleep speed threshold, default is 0.05 meters per second
     *
     * @return float
     */
    float sleepThreshold();

    /**
     * Optional body name for debugging. Up to B2_NAME_LENGTH characters
     *
     * @return long
     */
    long name();

    /**
     * Use this to store application specific body data.
     *
     * @return long
     */
    long userData();

    /**
     * Motions locks to restrict linear and angular movement. Caution: may lead
     * to softer constraints along the locked direction
     *
     * @return ConstB2MotionLocks
     */
    ConstB2MotionLocks motionLocks();

    /**
     * Set this flag to false if this body should never fall asleep.
     *
     * @return boolean
     */
    boolean enableSleep();

    /**
     * Is this body initially awake or sleeping?
     *
     * @return boolean
     */
    boolean isAwake();

    /**
     * Treat this body as a high speed object that performs continuous collision
     * detection against dynamic and kinematic bodies, but not other bullet
     * bodies.
     * <p>
     * @warning Bullets should be used sparingly. They are not a solution for
     * general dynamic-versus-dynamic continuous collision. They do not
     * guarantee accurate collision if both bodies are fast moving because the
     * bullet does a continuous check after all non-bullet bodies have moved.
     * You could get unlucky and have the bullet body end a time step very close
     * to a non-bullet body and the non-bullet body then moves over the bullet
     * body. In continuous collision, initial overlap is ignored to avoid
     * freezing bodies in place. I do not recommend using them for game
     * projectiles if precise collision timing is needed. Instead consider using
     * a ray or shape cast. You can use a marching ray or shape cast for
     * projectile that moves over time. If you want a fast moving projectile to
     * collide with a fast moving target, you need to consider the relative
     * movement in your ray or shape cast. This is out of the scope of Box2D. So
     * what are good use cases for bullets? Pinball games or games with dynamic
     * containers that hold other objects. It should be a use case where it
     * doesn't break the
     * </p>
     * @return boolean
     */
    boolean isBullet();

    /**
     * Used to disable a body. A disabled body does not move or collide.
     *
     * @return boolean
     */
    boolean isEnabled();

    /**
     * This allows this body to bypass rotational speed limits. Should only be
     * used for circular objects, like wheels.
     *
     * @return boolean
     */
    boolean allowFastRotation();

    /**
     * Enable contact recycling. True by default. Leaving this enabled improves
     * performance but may lead to ghost collision that should be avoided on
     * characters.
     *
     * @return boolean
     */
    boolean enableContactRecycling();

    /**
     * Used internally to detect a valid definition. DO NOT SET.
     *
     * @return int
     */
    int internalValue();
}
