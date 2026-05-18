/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.system;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wil
 */
public interface Destroyer extends AutoCloseable {

    <STRUCT extends Struct<STRUCT>> STRUCT create(CallFunction<STRUCT> struct);

    @Override
    public void close();
    
    public interface CallFunction<STRUCT extends Struct<STRUCT>> {
        STRUCT create();
    }

    public static class Default implements Destroyer {

        private final List<Struct> buffer;

        public Default() {
            this.buffer = new ArrayList<>();
        }

        @Override
        public <STRUCT extends Struct<STRUCT>> STRUCT create(CallFunction<STRUCT> struct) {
            STRUCT ptr = struct.create();
            buffer.add(ptr);
            return ptr;
        }

        @Override
        public void close() {
            for (final Struct struct : buffer) {
                struct.close();
            }
        }
    }
}
