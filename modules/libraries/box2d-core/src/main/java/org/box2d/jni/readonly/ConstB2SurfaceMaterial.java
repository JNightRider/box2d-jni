/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a constant
 * of type <code>b2SurfaceMaterial</code>. (native type: const b2SurfaceMaterial)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2SurfaceMaterial extends ConstStruct {

    /**
     * The Coulomb (dry) friction coefficient, usually in the range [0,1].
     *
     * @return float
     */
    float friction();

    /**
     * The coefficient of restitution (bounce) usually in the range [0,1].
     *
     * @return float
     */
    float restitution();

    /**
     * The rolling resistance usually in the range [0,1].
     *
     * @return float
     */
    float rollingResistance();

    /**
     * The tangent speed for conveyor belts
     *
     * @return float
     */
    float tangentSpeed();

    /**
     * User material identifier. This is passed with query results and to
     * friction and restitution combining functions. It is not used internally.
     *
     * @return long
     */
    long userMaterialId();

    /**
     * Custom debug draw color.
     *
     * @return int
     */
    int customColor();
    
    /**
     * A template that handles the representation of a constant pointer (buffer)
     * of constant structures such as {@code ConstB2SurfaceMaterial}
     *
     * @param <T> The type of object stored in this buffer
     * @param <SELF> The type of this buffer
     */
    interface ConstBuffer<T extends ConstB2SurfaceMaterial, SELF extends ConstBuffer<T, SELF>> extends ConstStructBuffer<T, SELF> {
        /* nothing */
    }
}
