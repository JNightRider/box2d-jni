/*
BSD 3-Clause License

Copyright (c) 2026, Night Rider

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.box2d.jni.system;

import java.util.function.Function;

/**
 * Class responsible for managing the configurations of the Box2d-JNI library.
 *
 * @param <T> type
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Sys<T> {

    public static final Sys<String> B2JNI_LIB_PATH = new Sys<>("org.box2d.jni.path", StateInit.STRING);
    
    public static final Sys<String> B2JNI_LIB_NAME = new Sys<>("org.box2d.jni.name", StateInit.STRING);
    
    public static final Sys<Boolean> DISABLE_DEBUG = new Sys<>("org.box2d.jni.system.Debugs", StateInit.BOOLEAN);
    public static final Sys<Boolean> DISABLE_DEBUG_COLOR = new Sys<>("org.box2d.jni.system.Debug.Color", StateInit.BOOLEAN);
    
    public static final Sys<Boolean> BOX2D_DOUBLE_PRECISION = new Sys<>("BOX2D_JNI_DOUBLE_PRECISION", StateInit.BOOLEAN);
    
    public static final Sys<Boolean> BOX2D_NDEBUG = new Sys<>("BOX2D_JNI_NDEBUG", StateInit.BOOLEAN);

    public static final Sys<Integer> STACK_SIZE = new Sys<>("BOX2D_JNI_STACK_SIZE", StateInit.INT);
    
    private interface StateInit<T> extends Function<String, T> {

        StateInit<Boolean> BOOLEAN = property -> {
            String value = System.getProperty(property);
            return value == null ? null : Boolean.parseBoolean(value);
        };

        StateInit<Integer> INT = Integer::getInteger;

        StateInit<String> STRING = System::getProperty;
    }

    private final String property;

    private volatile T state;

    Sys(String property, StateInit<? extends T> init) {
        this.property = property;
        this.state = init.apply(property);
    }

    public String getProperty() {
        return property;
    }

    /**
     * Sets the option value.
     *
     * @param value the value to set
     */
    public void set(T value) {
        this.state = value;
    }

    /**
     * Returns the option value.
     *
     * <p>
     * If the option value has not been set, null will be returned.</p>
     *
     * @return the value
     */
    public T get() {
        return state;
    }

    /**
     * Returns the option value.
     *
     * <p>
     * If the option value has not been set, the specified default value will be
     * returned.</p>
     *
     * @param defaultValue the default value
     * @return the value
     */
    public T get(T defaultValue) {
        T state0 = this.state;
        if (state0 == null) {
            state0 = defaultValue;
        }
        return state0;
    }
}
