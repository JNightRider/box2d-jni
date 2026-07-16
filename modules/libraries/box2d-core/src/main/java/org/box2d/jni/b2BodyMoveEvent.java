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

import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2BodyMoveEvent
 * {
 *     void* userData;
 *     b2WorldTransform transform;
 *     b2BodyId bodyId;
 *     bool fellAsleep;
 * } b2BodyMoveEvent;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2BodyMoveEvent extends Struct<b2BodyMoveEvent> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            USER_DATA,
            TRANSFORM,
            BODY_ID,
            FELL_ASLEEP;

    static {
        Layout layout = __struct(
                __member(POINTER_SIZE),
                __member(b2WorldTransform.DSIZEOF, b2WorldTransform.DALIGNOF),
                __member(b2BodyId.SIZEOF, b2BodyId.ALIGNOF),
                __member(1)
        );

        USER_DATA = layout.offsetof(0);
        TRANSFORM = layout.offsetof(1);
        BODY_ID = layout.offsetof(2);
        FELL_ASLEEP = layout.offsetof(3);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2BodyMoveEvent(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2BodyMoveEvent(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2BodyMoveEvent(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code userData} */
    public long userData() { return nuserData(address()); }
    /** @return Returns the property {@code transform} */
    public b2WorldTransform transform() { return ntransform(address()); }
    /** @return Returns the property {@code bodyId} */
    public b2BodyId bodyId() { return nbodyId(address()); }
    /** @return Returns the property {@code fellAsleep} */
    public boolean fellAsleep() { return nfellAsleep(address()); }

    /**
     * Set the value of property {@code userData}
     * 
     * @param value long
     * @return b2BodyMoveEvent
     */
    public b2BodyMoveEvent userData(long value) {
        nuserData(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code transform}
     * 
     * @param value b2Transform
     * @return b2BodyMoveEvent
     */
    public b2BodyMoveEvent transform(b2WorldTransform value) {
        ntransform(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code bodyId}
     * 
     * @param value b2BodyId
     * @return b2BodyMoveEvent
     */
    public b2BodyMoveEvent bodyId(b2BodyId value) {
        nbodyId(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code fellAsleep}
     * 
     * @param value boolean
     * @return b2BodyMoveEvent
     */
    public b2BodyMoveEvent fellAsleep(boolean value) {
        nfellAsleep(address(), value);
        return this;
    }

    /*(non-Javadoc)
     */
    @Override
    public int sizeof() {
        return SIZEOF;
    }

    /*(non-Javadoc)
     */
    @Override
    protected b2BodyMoveEvent create(long address, Pointer ptr) {
        return ptr == null ? new b2BodyMoveEvent(address) : new b2BodyMoveEvent(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2BodyMoveEvent
     */
    private static b2BodyMoveEvent factory() {
        return new b2BodyMoveEvent(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2BodyMoveEvent
     */
    public static b2BodyMoveEvent createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2BodyMoveEvent(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2BodyMoveEvent}.
     *
     * @param alloc Custom memory manager
     * @return b2BodyMoveEvent
     */
    public static b2BodyMoveEvent alloc(AllocFunc alloc) {
        long ptr = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return ptr == NULL ? null : new b2BodyMoveEvent(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2BodyMoveEvent}.
     *
     * @return b2BodyMoveEvent
     */
    public static b2BodyMoveEvent calloc() {
        return new b2BodyMoveEvent(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2BodyMoveEvent}.
     *
     * @param alloc arena
     * @return b2BodyMoveEvent
     */
    public static b2BodyMoveEvent calloc(ArenaAlloc alloc) {
        long ptr = alloc.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2BodyMoveEvent(() -> ptr);
    }   
    
    /**
     * Reserve memory for the new object {@code b2BodyMoveEvent}.
     *
     * @return b2BodyMoveEvent
     */
    public static b2BodyMoveEvent malloc() {
        return new b2BodyMoveEvent(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2BodyMoveEvent}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2BodyMoveEvent}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, capacity, SIZEOF);
        return new Buffer(address, capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2BodyMoveEvent}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2BodyMoveEvent}.
     *
     * @param capacity Number of elements
     * @param alloc Arean
     * @return Buffer
     */
    public static Buffer calloc(int capacity, ArenaAlloc alloc) {
        long ptr = alloc.ncalloc(ALIGNOF, capacity, SIZEOF);
        return new Buffer(ptr, capacity);
    }
    
    // -----------------------------------
    
    public static long nuserData(long address)              { return memGetAddress(address + USER_DATA);}
    public static b2WorldTransform ntransform(long address) { return b2WorldTransform.createSafe(() -> address + TRANSFORM);}
    public static b2BodyId nbodyId(long address)        { return b2BodyId.createSafe(() -> address + BODY_ID);}
    public static boolean nfellAsleep(long address)     { return memGetByte(address + FELL_ASLEEP) != 0;}

    public static void nuserData(long address, long value)              { memPutAddress(address + USER_DATA, value);}
    public static void ntransform(long address, b2WorldTransform value) { nmemcpy(address + TRANSFORM, value.address(), b2WorldTransform.DSIZEOF);}
    public static void nbodyId(long address, b2BodyId value)        { nmemcpy(address + BODY_ID, value.address(), b2BodyId.SIZEOF);}
    public static void nfellAsleep(long address, boolean value)     { memPutByte(address + FELL_ASLEEP, (byte) (value ? 1 : 0));}
    
    // -----------------------------------

    /** An array of {@code b2BodyMoveEvent} structs. */
    public static class Buffer extends StructBuffer<b2BodyMoveEvent, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2BodyMoveEvent ELEMENT_FACTORY = b2BodyMoveEvent.factory();

        /**
         * Create a new buffer.
         *
         * @param address long
         * @param remaining int
         */
        public Buffer(long address, int remaining) {
            super(address, remaining);
        }

        /**
         * Create a new buffer.
         *
         * @param address long
         * @param mark int
         * @param position int
         * @param limit int
         * @param capacity int
         */
        public Buffer(long address, int mark, int position, int limit, int capacity) {
            super(address, mark, position, limit, capacity);
        }

        /*(non-Javadoc)
         */
        @Override
        protected b2BodyMoveEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /*(non-Javadoc)
         */
        @Override
        protected Buffer self() {
            return this;
        }

        /*(non-Javadoc)
         */
        @Override
        protected Buffer create(long address, int mark, int position, int limit, int capacity) {
            return new Buffer(address, mark, position, limit, capacity);
        }
    }
}
