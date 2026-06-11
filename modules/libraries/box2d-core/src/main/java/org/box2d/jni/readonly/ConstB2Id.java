/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.readonly;

/**
 * A read-only representation of box2d id.
 *
 * @param <INDEX1> index1 | number
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2Id<INDEX1 extends Number> extends ConstStruct {

    /**
     * Returns the value of the {@code index1} property.
     *
     * @return number
     */
    INDEX1 index1();

    /**
     * A read-only representation of box2d id that supports the {@code world0}
     * property.
     *
     * @param <T> index1 | number
     * @param <WORLD0> world0 | number
     * @param <GENERATION> generation | number
     */
    interface Default<T extends Number, WORLD0 extends Number, GENERATION extends Number> extends ConstB2Id<T> {

        /**
         * Returns the value of the {@code world0} property.
         *
         * @return number
         */
        WORLD0 world0();

        /**
         * Returns the value of the {@code generation} property.
         *
         * @return number
         */
        GENERATION generation();
    }
}
