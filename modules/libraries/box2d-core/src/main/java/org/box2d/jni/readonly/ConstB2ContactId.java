/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2ContactId</code>. (native type: const b2ContactId)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2ContactId extends ConstB2Id.Default<Integer, Short, Integer> {

    /**
     * Returns the value of the {@code padding} property.
     *
     * @return number
     */
    Short padding();
}
