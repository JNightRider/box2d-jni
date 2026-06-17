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
 * typedef enum b2BodyType
 * {
 * 	/// zero mass, zero velocity, may be manually moved
 * 	b2_staticBody = 0,
 * 
 * 	/// zero mass, velocity set by user, moved by solver
 * 	b2_kinematicBody = 1,
 * 
 * 	/// positive mass, velocity determined by forces, moved by solver
 * 	b2_dynamicBody = 2,
 * 
 * 	/// number of body types
 * 	b2_bodyTypeCount,
 * } b2BodyType;
 * </code></pre>
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public enum b2BodyType {
    /** 
     * zero mass, zero velocity, may be manually moved 
     * <pre><code>
     * b2_staticBody = 0 -&#62; box2d
     * </code></pre>
     */
    b2_staticBody(
        nb2_staticBody()
    ),
    
    /** 
     * zero mass, velocity set by user, moved by solver
     * <pre><code>
     * b2_kinematicBody = 1 -&#62; box2d
     * </code></pre>
     */
    b2_kinematicBody(
        nb2_kinematicBody()
    ),
    
    /** 
     * positive mass, velocity determined by forces, moved by solver 
     * <pre><code>
     * b2_dynamicBody = 2 -&#62; box2d
     * </code></pre>
     */
    b2_dynamicBody(
        nb2_dynamicBody()
    ),
    
    /** 
     * number of body types 
     * <pre><code>
     * b2_bodyTypeCount -&#62; box2d
     * </code></pre>
     */
    b2_bodyTypeCount(
        nb2_bodyTypeCount()
    );

    static {
        Library.initialize();
    }

    /**
     * An integer value that identifies the body type natively, that is, it is the native body type.
     */
    private final Integer b2Type;

    /**
     * Generate a new <code>BodyType</code>.
     * @param b2Type type
     */
    private b2BodyType(Integer b2Type) {
        this.b2Type = b2Type;
    }

    /**
     * Returns the native type
     * @return int
     */
    public Integer value() {
        return b2Type;
    }
    
    /**
     * Evaluate the native type of a body to return an enumerated object ready to be consumed.
     * @param type type
     * @return body type
     */
    public static b2BodyType valueOf(int type) {
        if (type == b2_staticBody.value()) {
            return b2_staticBody;
        }  else if (type == b2_kinematicBody.value()) {
            return b2_kinematicBody;
        } else if (type == b2_dynamicBody.value()) {
            return b2_dynamicBody;
        } else if (type == b2_bodyTypeCount.value()) {
            return b2_bodyTypeCount;
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
    
    /* Binding JNI to property 'b2_staticBody' of structure 'b2BodyType' */
    public static native int nb2_staticBody();
    /* Binding JNI to property 'b2_kinematicBody' of structure 'b2BodyType' */
    public static native int nb2_kinematicBody();
    /* Binding JNI to property 'b2_dynamicBody' of structure 'b2BodyType' */
    public static native int nb2_dynamicBody();
    /* Binding JNI to property 'b2_bodyTypeCount' of structure 'b2BodyType' */
    public static native int nb2_bodyTypeCount();
}
