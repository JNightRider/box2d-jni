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
 * An enumerated class that provides the size in bytes of different data types
 * in C.
 *
 * @author wil
 * @version 1.0.1
 * @since 1.0.0
 */
public enum VarType {
    Int8t("byte|int8_t", (int)nint8_t()),
    Int16t("short|int16_t", (int) nint16_t()),
    Int32t("int|int32_t", (int) nint32_t()),
    Int64t("long|int64_t", (int) nint64_t()),
    Float("float", (int) nfloat_t()),
    Double("double", (int) ndouble_t()),
    Uintptrt("uintptr_t", (int) ndouble_t()),
    Pointer("void*", (int) npointer());
    
    static {
        Library.initialize();
    }
    
    private final String name;
    private final int sizeof;

    private VarType(String name, int sizeof) {
        this.name = name;
        this.sizeof = sizeof;
    }
    
    public static native long nint8_t();
    
    public static native long nint16_t();
    
    public static native long nint32_t();
    
    public static native long nint64_t();
    
    public static native long nfloat_t();
    
    public static native long ndouble_t();
    
    public static native long nuintptr_t();
    
    public static native long npointer();

    public int sizeof() {
        return sizeof;
    }

    @Override
    public String toString() {
        return String.valueOf('(' + name + ')' + sizeof + "bits");
    }
}
