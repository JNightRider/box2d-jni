/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.test.internal;

import java.util.function.Function;

/**
 *
 * @author wil
 * @param <R>
 */
@FunctionalInterface
public interface Extern<R> {

    static <V, R> Extern<R> extern(V object, Function<V, R> func) {
        return new Extern<R>() {
            @Override
            public R invoke() {
                return func.apply(object);
            }

            @Override
            public String $() {
                return object.getClass().getSimpleName();
            }
        };
    }

    R invoke();
    
    default String $() {
        return getClass().getSimpleName();
    }
}
