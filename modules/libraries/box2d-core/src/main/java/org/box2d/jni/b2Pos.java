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

import org.box2d.jni.readonly.ConstB2Pos;
import org.box2d.jni.system.AllocFunc;
import org.box2d.jni.system.ArenaAlloc;
import org.box2d.jni.system.BufferDef;
import org.box2d.jni.system.Library;
import org.box2d.jni.system.Pointer;

/**
 * <pre><code>
 * #if defined( BOX2D_DOUBLE_PRECISION )
 * typedef struct b2Pos
 * {
 * 	double x, y;
 * } b2Pos;
 * #else
 * typedef b2Vec2 b2Pos;
 * #endif
 * </code></pre>
 *
 * @param <SELF> The type of structure that implements this definition
 *              {@code const typedef b2Pos}
 * @param <X> The value type of property {@code x} of the structure
 * @param <Y> The value type of property {@code y} of the structure
 *
 * @author wil
 * @version 1.0.0
 * @since 1.2.0
 */
public interface b2Pos<SELF extends b2Pos<SELF, X, Y>, X extends Number, Y extends Number> extends Pointer, ConstB2Pos<X, Y> {

    /** The struct size in bytes. */
    final int DSIZEOF = BOX2D_DOUBLE_PRECISION ? b2PosI.SIZEOF : b2Vec2.SIZEOF;

    /** The struct alignment in bytes. */
    final int DALIGNOF = BOX2D_DOUBLE_PRECISION ? b2PosI.ALIGNOF : b2Vec2.ALIGNOF;

    /**
     * Initializes this struct with the specified values.
     *
     * @param x the valur {@code x}
     * @param y the valur {@code y}
     *
     * @return b2Pos
     */
    SELF set(
        Number x,
        Number y
    );

    /**
     * Returns the x coordinate.
     *
     * @return Number
     */
    @Override
    X x();

    /**
     * Returns the y coordinate.
     *
     * @return Number
     */
    @Override
    Y y();

    /**
     * Set the y coordinate.
     *
     * @param value Number
     *
     * @return b2Pos
     */
    SELF x(Number value);

    /**
     * Set the y coordinate.
     *
     * @param value Number
     *
     * @return b2Pos
     */
    SELF y(Number value);

    /**
     * Returns {@code sizeof(struct)}.
     *
     * @return long
     */
    int sizeof();

    /**
     * Unary add one vector to another
     *
     * @param o b2Pos
     * @return b2Pos
     */
    SELF add(SELF o);

    /**
     * Unary subtract one vector from another
     *
     * @param o b2Pos
     * @return b2Pos
     */
    SELF sub(SELF o);

    /**
     * Unary multiply a vector by a scalar
     *
     * @param o b2Pos
     * @return b2Pos
     */
    SELF mult(SELF o);

    /**
     * Unary negate a vector
     *
     * @return b2Pos
     */
    SELF neg();

    /**
     * Binary vector equality
     *
     * @param o b2Pos
     * @return boolean
     */
    boolean equality(SELF o);

    /**
     * Binary vector inequality
     *
     * @param o b2Pos
     * @return boolean
     */
    boolean inequality(SELF o);

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Pos
     */
    static b2Pos createSafe(Pointer ptr) {
        return BOX2D_DOUBLE_PRECISION ? b2PosI.createSafe(ptr) : b2Vec2.createSafe(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Pos}.
     *
     * @param alloc Custom memory manager
     * @return b2Pos
     */
    static b2Pos alloc(AllocFunc alloc) {
        return BOX2D_DOUBLE_PRECISION ? b2PosI.alloc(alloc) : b2Vec2.alloc(alloc);
    }

    /**
     * Reserve memory for the new object {@code b2Pos}.
     *
     * @return b2Pos
     */
    static b2Pos calloc() {
        return BOX2D_DOUBLE_PRECISION ? b2PosI.calloc() : b2Vec2.calloc();
    }

    /**
     * Reserve memory for the new object {@code b2Pos}.
     *
     * @param arean arena
     * @return b2Pos
     */
    static b2Pos calloc(ArenaAlloc arean) {
        return BOX2D_DOUBLE_PRECISION ? b2PosI.calloc(arean) : b2Vec2.calloc(arean);
    }

    /**
     * Reserve memory for the new object {@code b2Pos}.
     *
     * @return b2Pos
     */
    static b2Pos malloc() {
        return BOX2D_DOUBLE_PRECISION ? b2PosI.malloc() : b2Vec2.malloc();
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Pos}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    static Buffer malloc(int capacity) {
        return BOX2D_DOUBLE_PRECISION ? b2PosI.malloc(capacity) : b2Vec2.malloc(capacity);
    }
    
    /**
     * Reserve an amount n of memory for the object {@code b2Pos}.
     *
     * @param src source
     * @return Buffer
     */
    @SuppressWarnings("unchecked")
    static Buffer mallocSafe(b2Pos ...src) {
        if (src == null) {
            return null;
        }
        Buffer ptr = malloc(src.length);
        for (b2Pos v : src) {
            ptr.put(v);
        }
        return ptr;
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Pos}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    static Buffer malloc(int capacity, AllocFunc alloc) {
        return BOX2D_DOUBLE_PRECISION ? b2PosI.malloc(capacity, alloc) : b2Vec2.malloc(capacity, alloc);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Pos}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    static Buffer calloc(int capacity) {
        return BOX2D_DOUBLE_PRECISION ? b2PosI.calloc(capacity) : b2Vec2.calloc(capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Pos}.
     *
     * @param capacity Number of elements
     * @param arena Arean
     * @return Buffer
     */
    static Buffer calloc(int capacity, ArenaAlloc arena) {
        return BOX2D_DOUBLE_PRECISION ? b2PosI.calloc(capacity, arena) : b2Vec2.calloc(capacity, arena);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Pos}.
     *
     * @param address Buffer address
     * @param capacity Number of elements
     * @return Buffer
     */
    static Buffer createSafe(long address, int capacity) {
        return BOX2D_DOUBLE_PRECISION ? b2PosI.createSafe(address, capacity) : b2Vec2.createSafe(address, capacity);
    }

    /**
     * A definition of buffers or pointers to structures of type {@code b2Pos};
     * this interface acts as a representation of the structure's
     * implementation.
     *
     * @param <T> Data type managed by the buffer
     * @param <SELF> The object that implements the buffer
     */
    interface Buffer<T extends b2Pos, SELF extends Buffer<T, SELF>> extends BufferDef<T, SELF> {
        /* nothng */
    }
}
