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
