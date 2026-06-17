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
 * enum b2TreeNodeFlags
 * {
 *     b2_allocatedNode = 0x0001,
 *     b2_enlargedNode = 0x0002,
 *     b2_leafNode = 0x0004,
 * };
 * </code></pre>
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public enum b2TreeNodeFlags {

    /**
     * <pre><code>
     * b2_allocatedNode -&#62; box2d
     * </code></pre>
     */
    b2_allocatedNode(
        nb2_allocatedNode()
    ),

    /**
     * <pre><code>
     * b2_enlargedNode -&#62; box2d
     * </code></pre>
     */
    b2_enlargedNode(
        nb2_enlargedNode()
    ),

    /**
     * <pre><code>
     * b2_leafNode -&#62; box2d
     * </code></pre>
     */
    b2_leafNode(
        nb2_leafNode()
    );

    static {
        Library.initialize();
    }

    /**
     * An integer value that identifies the body type natively, that is, it is the native body type.
     */
    private final Integer b2Type;

    /**
     * Generate a new <code>b2TreeNodeFlags</code>.
     *
     * @param b2Type type
     */
    private b2TreeNodeFlags(Integer b2Type) {
        this.b2Type = b2Type;
    }

    /**
     * Returns the native type
     *
     * @return int
     */
    protected Integer value() {
        return b2Type;
    }

    /**
     * Evaluate the native type to return an enumerated object ready to be consumed.
     *
     * @param type type
     * @return Tree node flag
     */
    public static b2TreeNodeFlags valueOf(int type) {
        if (type == b2_allocatedNode.value()) {
            return b2_allocatedNode;
        } else if (type == b2_enlargedNode.value()) {
            return b2_enlargedNode;
        } else if (type == b2_leafNode.value()) {
            return b2_leafNode;
        }
        throw new UnsupportedOperationException("enum: " + type);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.valueOf(b2Type);
    }

    /* Binding JNI to property 'b2_allocatedNode' of structure 'b2TreeNodeFlags' */
    public static native int nb2_allocatedNode();
    /* Binding JNI to property 'b2_enlargedNode' of structure 'b2TreeNodeFlags' */
    public static native int nb2_enlargedNode();
    /* Binding JNI to property 'b2_leafNode' of structure 'b2TreeNodeFlags' */
    public static native int nb2_leafNode();
}
