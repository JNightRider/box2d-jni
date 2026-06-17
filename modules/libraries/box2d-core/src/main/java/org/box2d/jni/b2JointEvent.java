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
 * typedef struct b2JointEvent
 * {
 *     /// The joint id
 *     b2JointId jointId;
 *
 *     /// The user data from the joint for convenience
 *     void* userData;
 * } b2JointEvent;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2JointEvent extends Struct<b2JointEvent> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            JOINT_ID,
            USER_DATA;

    static {
        Layout layout = __struct(
                __member(b2JointId.SIZEOF, b2JointId.ALIGNOF),
                __member(VarType.Uintptrt.sizeof())
        );

        JOINT_ID = layout.offsetof(0);
        USER_DATA = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2JointEvent(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2JointEvent(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2JointEvent(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code jointId} */
    public b2JointId jointId() { return njointId(address()); }
    /** @return Returns the property {@code userData} */
    public long userData() { return nuserData(address()); }

    /**
     * Set the value of property {@code jointId}
     * 
     * @param value b2JointId
     * @return b2JointEvent
     */
    public b2JointEvent jointId(b2JointId value) {
        njointId(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code userData}
     * 
     * @param value long
     * @return b2JointEvent
     */
    public b2JointEvent userData(long value) {
        nuserData(address(), value);
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
    protected b2JointEvent create(long address, Pointer ptr) {
        return ptr == null ? new b2JointEvent(address) : new b2JointEvent(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2JointEvent
     */
    private static b2JointEvent factory() {
        return new b2JointEvent(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2JointEvent
     */
    public static b2JointEvent createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2JointEvent(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2JointEvent}.
     *
     * @param alloc Custom memory manager
     * @return b2JointEvent
     */
    public static b2JointEvent alloc(AllocFunc alloc) {
        return new b2JointEvent(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2JointEvent}.
     *
     * @return b2JointEvent
     */
    public static b2JointEvent malloc() {
        return new b2JointEvent(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2JointEvent}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2JointEvent}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------
    
    public static b2JointId njointId(long address) { return b2JointId.createSafe(() -> address + JOINT_ID);}
    public static long nuserData(long address) { return memGetAddress(address + USER_DATA);}

    public static void njointId(long address, b2JointId value) { nmemcpy(address + JOINT_ID, value.address(), b2JointId.SIZEOF); }
    public static void nuserData(long address, long value) { memPutAddress(address + USER_DATA, value); }
    
    // -----------------------------------

    /** An array of {@code b2JointEvent} structs. */
    public static class Buffer extends StructBuffer<b2JointEvent, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2JointEvent ELEMENT_FACTORY = b2JointEvent.factory();

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
        protected b2JointEvent getElementFactory() {
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
