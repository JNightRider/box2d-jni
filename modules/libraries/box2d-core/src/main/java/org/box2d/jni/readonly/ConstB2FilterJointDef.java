/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a constant
 * of type <code>b2FilterJointDef</code>. (native type: const b2FilterJointDef)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2FilterJointDef extends ConstStruct {

    /**
     * Base joint definition
     *
     * @return ConstB2JointDef
     */
    ConstB2JointDef base();

    /**
     * Used internally to detect a valid definition. DO NOT SET.
     *
     * @return int
     */
    int internalValue();
}
