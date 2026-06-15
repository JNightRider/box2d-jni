/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2ChainDef</code>. (native type: const b2ChainDef)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2ChainDef extends ConstStruct {

    /**
     * Use this to store application specific shape data.
     *
     * @return long
     */
    long userData();

    /**
     * An array of at least 4 points. These are cloned and may be temporary.
     *
     * @return long
     */
    long points();

    /**
     * The point count, must be 4 or more.
     *
     * @return
     */
    int count();

    /**
     * Surface materials for each segment. These are cloned.
     *
     * @return long
     */
    long materials();

    /**
     * The material count. Must be 1 or count. This allows you to provide one
     * material for all segments or a unique material per segment. For open
     * chains, the material on the ghost segments are place holders.
     *
     * @return int
     */
    int materialCount();

    /**
     * Contact filtering data.
     *
     * @return ConstB2Filter
     */
    ConstB2Filter filter();

    /**
     * Indicates a closed chain formed by connecting the first and last points
     *
     * @return boolean
     */
    boolean isLoop();

    /**
     * Enable sensors to detect this chain. False by default.
     *
     * @return boolean
     */
    boolean enableSensorEvents();

    /**
     * Used internally to detect a valid definition. DO NOT SET.
     *
     * @return int
     */
    int internalValue();
}
