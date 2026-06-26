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
 * Pointer interface.
 * <p>
 * This interface can be used where there is a need to manage or make a connection
 * to the native code, this interface provides the methods needed to manage it.
 * </p>
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Pointer {
    
    /** Alias for the null pointer address. */
    public static final long NULL = 0L;
    
    /** Determine if the 2D motor has started using the {@code BOX2D_DOUBLE_PRECISION} indicator. */
    final boolean BOX2D_DOUBLE_PRECISION = Sys.BOX2D_DOUBLE_PRECISION.get(false);
    
    /** The pointer size in bytes. Will be 4 on a 32bit JVM and 8 on a 64bit one. */
    int POINTER_SIZE = VarType.Pointer.sizeof();

    /** Will be true on a 32bit JVM. */
    boolean BITS32 = POINTER_SIZE * 8 == 32;

    /** Will be true on a 64bit JVM. */
    boolean BITS64 = POINTER_SIZE * 8 == 64;
    
    /**
     * Returns the raw pointer address as a {@code long} value.
     *
     * @return the pointer address
     */
    long address();
}
