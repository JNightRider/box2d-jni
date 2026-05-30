/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

import org.box2d.jni.b2Capacity;
import org.box2d.jni.b2Vec2;

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
     * @return b2Vec2
     */
    public b2Vec2 gravity();

    /**
     * Returns the property {@code restitutionThreshold}
     *
     * @return float
     */
    public float restitutionThreshold();

    /**
     * Returns the property {@code hitEventThreshold}
     *
     * @return float
     */
    public float hitEventThreshold();

    /**
     * Returns the property {@code contactHertz}
     *
     * @return float
     */
    public float contactHertz();

    /**
     * Returns the property {@code contactDampingRatio}
     *
     * @return float
     */
    public float contactDampingRatio();

    /**
     * Returns the property {@code contactSpeed}
     *
     * @return float
     */
    public float contactSpeed();

    /**
     * Returns the property {@code maximumLinearSpeed}
     *
     * @return float
     */
    public float maximumLinearSpeed();

    /**
     * Returns the property {@code frictionCallback}
     *
     * @return long
     */
    public long frictionCallback();

    /**
     * Returns the property {@code restitutionCallback}
     *
     * @return long
     */
    public long restitutionCallback();

    /**
     * Returns the property {@code enableSleep}
     *
     * @return boolean
     */
    public boolean enableSleep();

    /**
     * Returns the property {@code enableContinuous}
     *
     * @return boolean
     */
    public boolean enableContinuous();

    /**
     * Returns the property {@code enableContactSoftening}
     *
     * @return boolean
     */
    public boolean enableContactSoftening();

    /**
     * Returns the property {@code workerCount}
     *
     * @return int
     */
    public int workerCount();

    /**
     * Returns the property {@code enqueueTask}
     *
     * @return long
     */
    public long enqueueTask();

    /**
     * Returns the property {@code finishTask}
     *
     * @return long
     */
    public long finishTask();

    /**
     * Returns the property {@code userTaskContext}
     *
     * @return long
     */
    public long userTaskContext();

    /**
     * Returns the property {@code userData}
     *
     * @return long
     */
    public long userData();

    /**
     * Returns the property {@code capacity}
     *
     * @return b2Capacity
     */
    public b2Capacity capacity();

    /**
     * Returns the property {@code internalValue}
     *
     * @return int
     */
    public int internalValue();
}
