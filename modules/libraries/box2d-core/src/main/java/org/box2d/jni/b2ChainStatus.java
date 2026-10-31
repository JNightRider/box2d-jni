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
package org.box2d.jni;

import org.box2d.jni.system.Library;

/**
 * <pre><code>
 * typedef enum b2ChainStatus
 * {
 *     b2_chainStatusSuccess,
 *     b2_chainStatusCornerTouch,
 *     b2_chainStatusOverlap,
 * } b2ChainStatus;
 * </code></pre>
 *
 * @author wil
 * @version 1.0.0
 * @since 2.2.0
 */
public enum b2ChainStatus {

    /**
     * <pre><code>
     * b2_chainStatusSuccess -&#62; box2d
     * </code></pre>
     */
    b2_chainStatusSuccess(
        nb2_chainStatusSuccess()
    ),

    /**
     * <pre><code>
     * b2_chainStatusCornerTouch -&#62; box2d
     * </code></pre>
     */
    b2_chainStatusCornerTouch(
        nb2_chainStatusCornerTouch()
    ),

    /**
     * <pre><code>
     * b2_chainStatusOverlap -&#62; box2d
     * </code></pre>
     */
    b2_chainStatusOverlap(
        nb2_chainStatusOverlap()
    );

    static {
        Library.initialize();
    }

    /**
     * An integer value that identifies the chain status natively,
     * that is, it is the native chain status.
     */
    private final int b2Type;

    /**
     * Generate a new <code>b2ChainStatus</code>.
     *
     * @param b2Type type
     */
    private b2ChainStatus(int b2Type) {
        this.b2Type = b2Type;
    }

    /**
     * Returns the native type
     *
     * @return int
     */
    public int value() {
        return b2Type;
    }

    /**
     * Evaluate the native type of a chain status to return an enumerated object ready to be consumed.
     *
     * @param type type
     * @return chain status
     */
    public static b2ChainStatus valueOf(int type) {
        for (b2ChainStatus chainStatus : b2ChainStatus.values()) {
            if (chainStatus.value() == type) {
                return chainStatus;
            }
        }
        throw new UnsupportedOperationException("enum b2ChainStatus: " + type);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.valueOf(b2Type);
    }

    /* Binding JNI to property 'b2_chainStatusSuccess' of structure 'b2ChainStatus' */
    public static native int nb2_chainStatusSuccess();
    /* Binding JNI to property 'b2_chainStatusCornerTouch' of structure 'b2ChainStatus' */
    public static native int nb2_chainStatusCornerTouch();
    /* Binding JNI to property 'b2_chainStatusOverlap' of structure 'b2ChainStatus' */
    public static native int nb2_chainStatusOverlap();
}
