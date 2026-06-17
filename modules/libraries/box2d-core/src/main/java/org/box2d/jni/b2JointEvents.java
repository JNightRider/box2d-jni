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
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2JointEvents
 * {
 *     /// Array of events
 *     b2JointEvent* jointEvents;
 *
 *     /// Number of events
 *     int count;
 * } b2JointEvents;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2JointEvents extends Struct<b2JointEvents> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            JOINT_EVENTS,
            COUNT;

    static {
        Layout layout = __struct(
                __member(VarType.Uintptrt.sizeof()),
                __member(4)
        );

        JOINT_EVENTS = layout.offsetof(0);
        COUNT = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2JointEvents(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2JointEvents(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2JointEvents(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code jointEvents} */
    public long jointEvents() { return njointEvents(address()); }
    /** @return Returns the property {@code count} */
    public int count() { return ncount(address()); }

    /**
     * Set the value of property {@code jointEvents}
     * 
     * @param value long
     * @return b2JointEvents
     */
    public b2JointEvents jointEvents(long value) {
        njointEvents(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code count}
     * 
     * @param value int
     * @return b2JointEvents
     */
    public b2JointEvents count(int value) {
        ncount(address(), value);
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
    protected b2JointEvents create(long address, Pointer ptr) {
        return ptr == null ? new b2JointEvents(address) : new b2JointEvents(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2JointEvents
     */
    private static b2JointEvents factory() {
        return new b2JointEvents(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2JointEvents
     */
    public static b2JointEvents createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2JointEvents(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2JointEvents}.
     *
     * @param alloc Custom memory manager
     * @return b2JointEvents
     */
    public static b2JointEvents alloc(AllocFunc alloc) {
        return new b2JointEvents(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2JointEvents}.
     *
     * @return b2JointEvents
     */
    public static b2JointEvents malloc() {
        return new b2JointEvents(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2JointEvents}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2JointEvents}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------
    
    public static long njointEvents(long address) { return memGetAddress(address + JOINT_EVENTS);}
    public static int ncount(long address) { return memGetInt(address + COUNT);}

    public static void njointEvents(long address, long value) { memPutAddress(address + JOINT_EVENTS, value); }
    public static void ncount(long address, int value) { memPutInt(address + COUNT, value); }

    // -----------------------------------

    /** An array of {@code b2JointEvents} structs. */
    public static class Buffer extends StructBuffer<b2JointEvents, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2JointEvents ELEMENT_FACTORY = b2JointEvents.factory();

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
        protected b2JointEvents getElementFactory() {
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
