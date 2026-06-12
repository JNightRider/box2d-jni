/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2WorldDef</code>. (native type: const b2WorldDef)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2WorldDef extends ConstStruct {

    /**
     * Returns the property {@code gravity}
     *
     * @return ConstB2Vec2
     */
     ConstB2Vec2 gravity();

    /**
     * Returns the property {@code restitutionThreshold}
     *
     * @return float
     */
     float restitutionThreshold();

    /**
     * Returns the property {@code hitEventThreshold}
     *
     * @return float
     */
     float hitEventThreshold();

    /**
     * Returns the property {@code contactHertz}
     *
     * @return float
     */
     float contactHertz();

    /**
     * Returns the property {@code contactDampingRatio}
     *
     * @return float
     */
     float contactDampingRatio();

    /**
     * Returns the property {@code contactSpeed}
     *
     * @return float
     */
     float contactSpeed();

    /**
     * Returns the property {@code maximumLinearSpeed}
     *
     * @return float
     */
     float maximumLinearSpeed();

    /**
     * Returns the property {@code frictionCallback}
     *
     * @return long
     */
     long frictionCallback();

    /**
     * Returns the property {@code restitutionCallback}
     *
     * @return long
     */
     long restitutionCallback();

    /**
     * Returns the property {@code enableSleep}
     *
     * @return boolean
     */
     boolean enableSleep();

    /**
     * Returns the property {@code enableContinuous}
     *
     * @return boolean
     */
     boolean enableContinuous();

    /**
     * Returns the property {@code enableContactSoftening}
     *
     * @return boolean
     */
     boolean enableContactSoftening();

    /**
     * Returns the property {@code workerCount}
     *
     * @return int
     */
     int workerCount();

    /**
     * Returns the property {@code enqueueTask}
     *
     * @return long
     */
     long enqueueTask();

    /**
     * Returns the property {@code finishTask}
     *
     * @return long
     */
     long finishTask();

    /**
     * Returns the property {@code userTaskContext}
     *
     * @return long
     */
     long userTaskContext();

    /**
     * Returns the property {@code userData}
     *
     * @return long
     */
     long userData();

    /**
     * Returns the property {@code capacity}
     *
     * @return ConstB2Capacity
     */
     ConstB2Capacity capacity();

    /**
     * Returns the property {@code internalValue}
     *
     * @return int
     */
     int internalValue();
}
