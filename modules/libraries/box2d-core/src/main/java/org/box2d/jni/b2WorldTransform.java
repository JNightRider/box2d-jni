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

import org.box2d.jni.readonly.ConstB2WorldTransform;
import org.box2d.jni.system.AllocFunc;
import org.box2d.jni.system.ArenaAlloc;
import org.box2d.jni.system.Pointer;

/**
 * <pre><code>
 * #if defined( BOX2D_DOUBLE_PRECISION )
 * typedef struct b2WorldTransform
 * {
 * 	b2Pos p;
 * 	b2Rot q;
 * } b2WorldTransform;
 * #else
 * typedef b2Transform b2WorldTransform;
 * #endif
 * </code></pre>
 *
 * @param <SELF> The type of structure that implements this definition
 *              {@code const typedef b2Pos}
 * @param <P> The value type of property {@code P} of the structure
 * @param <Q> The value type of property {@code Q} of the structure
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface b2WorldTransform<SELF extends b2WorldTransform<SELF, P, Q>, P extends b2Pos, Q extends b2Rot> extends Pointer, ConstB2WorldTransform<P, Q> {

    /** The struct size in bytes. */
    final int DSIZEOF = BOX2D_DOUBLE_PRECISION ? b2WorldTransformI.SIZEOF : b2Transform.SIZEOF;

    /** The struct alignment in bytes. */
    final int DALIGNOF = BOX2D_DOUBLE_PRECISION ? b2WorldTransformI.ALIGNOF : b2Transform.ALIGNOF;

    /**
     * Initializes this struct with the specified values.
     *
     * @param p the valur {@code p}
     * @param q the valur {@code q}
     *
     * @return b2WorldTransform
     */
    SELF set(
        P p,
        Q q
    );

    /**
     * An object of type {@link b2Pos}
     *
     * @return b2Pos
     */
    @Override
    P p();

    /**
     * An object of type {@link b2Rot}
     *
     * @return b2Rot
     */
    @Override
    Q q();

    /**
     * Set an object of type {@link b2Pos}
     *
     * @param value b2Pos
     * @return b2WorldTransform
     */
    SELF p(P value);

    /**
     * Set an object of type {@link b2Rot}
     *
     * @param value b2Rot
     * @return b2WorldTransform
     */
    SELF q(Q value);

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2WorldTransform
     */
    static b2WorldTransform ncreateSafe(Pointer ptr) {
        return BOX2D_DOUBLE_PRECISION ? b2WorldTransformI.createSafe(ptr) : b2Transform.createSafe(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2WorldTransform}.
     *
     * @param alloc Custom memory manager
     * @return b2WorldTransform
     */
    static b2WorldTransform nalloc(AllocFunc alloc) {
        return BOX2D_DOUBLE_PRECISION ? b2WorldTransformI.alloc(alloc) : b2Transform.alloc(alloc);
    }
    
    /**
     * Reserve memory for the new object {@code b2WorldTransform}.
     *
     * @param arean arena
     * @return b2WorldTransform
     */
    static b2WorldTransform ncalloc(ArenaAlloc arean) {
        return BOX2D_DOUBLE_PRECISION ? b2WorldTransformI.calloc(arean) : b2Transform.calloc(arean);
    }

    /**
     * Reserve memory for the new object {@code b2WorldTransform}.
     *
     * @return b2WorldTransform
     */
    static b2WorldTransform nmalloc() {
        return BOX2D_DOUBLE_PRECISION ? b2WorldTransformI.malloc() : b2Transform.malloc();
    }
}
