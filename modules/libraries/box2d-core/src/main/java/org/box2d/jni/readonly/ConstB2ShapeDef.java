/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2ShapeDef</code>. (native type: const b2ShapeDef)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2ShapeDef extends ConstStruct {

    /**
     * Use this to store application specific shape data.
     *
     * @return long
     */
    long userData();

    /**
     * The surface material for this shape.
     *
     * @return ConstB2SurfaceMaterial
     */
    ConstB2SurfaceMaterial material();

    /// The density, usually in kg/m^2.
    /// This is not part of the surface material because this is for the interior, which may have
    /// other considerations, such as being hollow. For example a wood barrel may be hollow or full of water.
    float density();

    /**
     * Collision filtering data.
     *
     * @return ConstB2Filter
     */
    ConstB2Filter filter();

    /**
     * Enable custom filtering. Only one of the two shapes needs to enable
     * custom filtering. See b2WorldDef.
     *
     * @return boolean
     */
    boolean enableCustomFiltering();

    /**
     * A sensor shape generates overlap events but never generates a collision
     * response. Sensors do not have continuous collision. Instead, use a ray or
     * shape cast for those scenarios. Sensors still contribute to the body mass
     * if they have non-zero density.
     *
     * @return boolean
     */
    boolean isSensor();

    /**
     * Enable sensor events for this shape. This applies to sensors and
     * non-sensors. Both shapes involved must have this flag set to true. False
     * by default, even for sensors.
     *
     * @return boolean
     */
    boolean enableSensorEvents();

    /**
     * Enable contact events for this shape. Only applies to kinematic and
     * dynamic bodies. Only one shape involved needs this flag set to true.
     * Ignored for sensors. False by default.
     *
     * @return boolean
     */
    boolean enableContactEvents();

    /**
     * Enable hit events for this shape. Only applies to kinematic and dynamic
     * bodies. Only one shape involved needs this flag set to true. Ignored for
     * sensors. False by default.
     *
     * @return boolean
     */
    boolean enableHitEvents();

    /**
     * Enable pre-solve contact events for this shape. Only applies to dynamic
     * bodies. These are expensive and must be carefully handled due to
     * multithreading. Ignored for sensors.
     *
     * @return boolean
     */
    boolean enablePreSolveEvents();

    /**
     * When shapes are created they will scan the environment for collision the
     * next time step. This can significantly slow down static body creation
     * when there are many static shapes. This is flag is ignored for dynamic
     * and kinematic shapes which always invoke contact creation.
     *
     * @return boolean
     */
    boolean invokeContactCreation();

    /**
     * Should the body update the mass properties when this shape is created.
     * Default is true. Warning: if this is true, you MUST call
     * b2Body_ApplyMassFromShapes before simulating the world.
     *
     * @return boolean
     */
    boolean updateBodyMass();

    /**
     * Used internally to detect a valid definition.
     *
     * @return int
     */
    int internalValue();
}
