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
     * @return Returns the property {@code friction}
     */
    float friction();

    /**
     * @return Returns the property {@code nrestitution}
     */
    float restitution();

    /**
     * @return Returns the property {@code nrollingResistance}
     */
    float rollingResistance();

    /**
     * @return Returns the property {@code ntangentSpeed}
     */
    float tangentSpeed();

    /**
     * @return Returns the property {@code nuserMaterialId}
     */
    long userMaterialId();

    /**
     * @return Returns the property {@code ncustomColor}
     */
    int customColor();
}
