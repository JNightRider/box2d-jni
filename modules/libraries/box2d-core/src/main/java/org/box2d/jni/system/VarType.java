/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.system;

/**
 *
 * @author wil
 */
public enum VarType {
    Int8t("byte|int8_t") {
        @Override public int sizeof() {
            return __nsizeof(int8_t);
        }
    },
    Int16t("short|int16_t") {
        @Override public int sizeof() {
            return __nsizeof(int16_t);
        }
    },
    Int32t("int|int32_t") {
        @Override public int sizeof() {
            return __nsizeof(int32_t);
        }
    },
    Int64t("long|int64_t") {
        @Override public int sizeof() {
            return __nsizeof(int64_t);
        }
    },
    Float("float") {
        @Override public int sizeof() {
            return __nsizeof(float_t);
        }
    },
    Double("double") {
        @Override public int sizeof() {
            return __nsizeof(double_t);
        }
    },
    Uintptrt("uintptr_t") {
        @Override public int sizeof() {
            return __nsizeof(uintptr_t);
        }
    },
    Pointer("void*") {
        @Override public int sizeof() {
            return __nsizeof(uintptr_t);
        }
    };
    
    private static final int
            int8_t     = 0x0001,
            int16_t    = 0x0002,
            int32_t    = 0x0003,
            int64_t    = 0x0004,
            float_t    = 0x0005,
            double_t   = 0x0006,
            uintptr_t  = 0x0007;

    static {
        Library.initialize();
    }
    
    private final String name;

    private VarType(String name) {
        this.name = name;
    }

    public abstract int sizeof();

    private static native int __nsizeof(int __type);

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
