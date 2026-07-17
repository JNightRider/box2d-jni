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

import org.box2d.jni.readonly.ConstB2WorldCastOutput;
import org.box2d.jni.system.AllocFunc;
import org.box2d.jni.system.ArenaAlloc;
import org.box2d.jni.system.BufferDef;
import org.box2d.jni.system.Pointer;

/**
 * <pre><code>
 * #if defined( BOX2D_DOUBLE_PRECISION )
 * 
 * /// World-space cast output. The hit point is a world position. The normal stays a float direction.
 * typedef struct b2WorldCastOutput
 * {
 * 	b2Vec2 normal;	/// The surface normal at the hit point
 * 	b2Pos point;	/// The surface hit point in world space
 * 	float fraction; /// The fraction of the input translation at collision
 * 	int iterations; /// The number of iterations used
 * 	bool hit;	/// Did the cast hit?
 * } b2WorldCastOutput;
 * 
 * #else
 * 
 * typedef b2CastOutput b2WorldCastOutput;
 * 
 * #endif
 * </code></pre>
 *
 * @param <SELF> The type of structure that implements this definition
 *              {@code const typedef b2Pos}
 * @param <POINT> The value type of property {@code POINT} of the structure
 *
 * @author wil
 * @version 1.0.0
 * @since 1.2.0
 */
public interface b2WorldCastOutput<SELF extends b2WorldCastOutput<SELF, POINT>, POINT extends b2Pos> extends Pointer, ConstB2WorldCastOutput<POINT> {

    /** The struct size in bytes. */
    final int DSIZEOF = BOX2D_DOUBLE_PRECISION ? b2WorldCastOutputI.SIZEOF : b2CastOutput.SIZEOF;

    /** The struct alignment in bytes. */
    final int DALIGNOF = BOX2D_DOUBLE_PRECISION ? b2WorldCastOutputI.ALIGNOF : b2CastOutput.ALIGNOF;

    /**
     * The surface normal at the hit point
     *
     * @return b2Vec2
     */
    @Override
    b2Vec2 normal();

    /**
     * The surface hit point in world space
     *
     * @return POINT
     */
    @Override
    POINT point();

    /**
     * The fraction of the input translation at collision
     *
     * @return float
     */
    @Override
    float fraction();

    /**
     * The number of iterations used
     *
     * @return int
     */
    @Override
    int iterations();

    /**
     * Did the cast hit?
     *
     * @return boolean
     */
    @Override
    boolean hit();

    /**
     * The surface normal at the hit point
     *
     * @param value b2Vec2
     * @return b2WorldCastOutput
     */
    SELF normal(b2Vec2 value);

    /**
     * The surface hit point in world space
     *
     * @param value b2Pos
     * @return b2WorldCastOutput
     */
    SELF point(POINT value);

    /**
     * The fraction of the input translation at collision
     *
     * @param value float
     * @return b2WorldCastOutput
     */
    SELF fraction(float value);

    /**
     * The number of iterations used
     *
     * @param value int
     * @return b2WorldCastOutput
     */
    SELF iterations(int value);

    /**
     * Did the cast hit?
     *
     * @param value boolean
     * @return b2WorldCastOutput
     */
    SELF hit(boolean value);

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2WorldCastOutput
     */
    static b2WorldCastOutput createSafe(Pointer ptr) {
        return BOX2D_DOUBLE_PRECISION ? b2WorldCastOutputI.createSafe(ptr) : b2CastOutput.createSafe(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2WorldCastOutput}.
     *
     * @param alloc Custom memory manager
     * @return b2WorldCastOutput
     */
    static b2WorldCastOutput alloc(AllocFunc alloc) {
        return BOX2D_DOUBLE_PRECISION ? b2WorldCastOutputI.alloc(alloc) : b2CastOutput.alloc(alloc);
    }

    /**
     * Reserve memory for the new object {@code b2WorldCastOutput}.
     *
     * @param arean arena
     * @return b2WorldCastOutput
     */
    static b2WorldCastOutput calloc(ArenaAlloc arean) {
        return BOX2D_DOUBLE_PRECISION ? b2WorldCastOutputI.calloc(arean) : b2CastOutput.calloc(arean);
    }

    /**
     * Reserve memory for the new object {@code b2WorldCastOutput}.
     *
     * @return b2WorldCastOutput
     */
    static b2WorldCastOutput calloc() {
        return BOX2D_DOUBLE_PRECISION ? b2WorldCastOutputI.calloc() : b2CastOutput.calloc();
    }

    /**
     * Reserve memory for the new object {@code b2WorldCastOutput}.
     *
     * @return b2WorldCastOutput
     */
    static b2WorldCastOutput malloc() {
        return BOX2D_DOUBLE_PRECISION ? b2WorldCastOutputI.malloc() : b2CastOutput.malloc();
    }

    /**
     * Reserve an amount n of memory for the object {@code b2WorldCastOutput}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    static Buffer malloc(int capacity) {
        return BOX2D_DOUBLE_PRECISION ? b2WorldCastOutputI.malloc(capacity) : b2CastOutput.malloc(capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2WorldCastOutput}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    static Buffer malloc(int capacity, AllocFunc alloc) {
        return BOX2D_DOUBLE_PRECISION ? b2WorldCastOutputI.malloc(capacity, alloc) : b2CastOutput.malloc(capacity, alloc);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2WorldCastOutput}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    static Buffer calloc(int capacity) {
        return BOX2D_DOUBLE_PRECISION ? b2WorldCastOutputI.calloc(capacity) : b2CastOutput.calloc(capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2WorldCastOutput}.
     *
     * @param capacity Number of elements
     * @param arena Arean
     * @return Buffer
     */
    static Buffer calloc(int capacity, ArenaAlloc arena) {
        return BOX2D_DOUBLE_PRECISION ? b2WorldCastOutputI.calloc(capacity, arena) : b2CastOutput.calloc(capacity, arena);
    }

    /**
     * A definition of buffers or pointers to structures of type {@code b2WorldCastOutput};
     * this interface acts as a representation of the structure's
     * implementation.
     *
     * @param <T> Data type managed by the buffer
     * @param <SELF> The object that implements the buffer
     */
    interface Buffer<T extends b2WorldCastOutput, SELF extends Buffer<T, SELF>> extends BufferDef<T, SELF> {
        /* nothng */
    }
}
