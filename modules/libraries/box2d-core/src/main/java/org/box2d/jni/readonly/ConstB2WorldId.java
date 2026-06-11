/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a constant
 * of type <code>b2WorldId</code>. (native type: const b2WorldId)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2WorldId extends ConstB2Id<Short>{
    /**
     * Returns the value of the {@code generation} property.
     *
     * @return number
     */
    Short generation();
}
