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
 * typedef struct b2SensorEvents
 * {
 *     /// Array of sensor begin touch events
 *     b2SensorBeginTouchEvent* beginEvents;
 *
 *     /// Array of sensor end touch events
 *     b2SensorEndTouchEvent* endEvents;
 *
 *     /// The number of begin touch events
 *     int beginCount;
 *
 *     /// The number of end touch events
 *     int endCount;
 * } b2SensorEvents;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2SensorEvents extends Struct<b2SensorEvents> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            BEGIN_EVENTS,
            END_EVENTS,
            BEGIN_COUNT,
            END_COUNT;

    static {
        Layout layout = __struct(
                __member(VarType.Uintptrt.sizeof()),
                __member(VarType.Uintptrt.sizeof()),
                __member(4),
                __member(4)
        );

        BEGIN_EVENTS = layout.offsetof(0);
        END_EVENTS = layout.offsetof(1);
        BEGIN_COUNT = layout.offsetof(2);
        END_COUNT = layout.offsetof(3);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2SensorEvents(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2SensorEvents(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2SensorEvents(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code beginEvents} */
    public long beginEvents() { return nbeginEvents(address()); }
    /** @return Returns the property {@code endEvents} */
    public long endEvents() { return nendEvents(address()); }
    /** @return Returns the property {@code beginCount} */
    public int beginCount() { return nbeginCount(address()); }
    /** @return Returns the property {@code endCount} */
    public int endCount() { return nendCount(address()); }

    /**
     * Set the value of property {@code beginEvents}
     * 
     * @param value long
     * @return b2SensorEvents
     */
    public b2SensorEvents beginEvents(long value) {
        nbeginEvents(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code endEvents}
     * 
     * @param value long
     * @return b2SensorEvents
     */
    public b2SensorEvents endEvents(long value) {
        nendEvents(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code beginCount}
     * 
     * @param value int
     * @return b2SensorEvents
     */
    public b2SensorEvents beginCount(int value) {
        nbeginCount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code endCount}
     * 
     * @param value int
     * @return b2SensorEvents
     */
    public b2SensorEvents endCount(int value) {
        nendCount(address(), value);
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
    protected b2SensorEvents create(long address, Pointer ptr) {
        return ptr == null ? new b2SensorEvents(address) : new b2SensorEvents(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2SensorEvents
     */
    private static b2SensorEvents factory() {
        return new b2SensorEvents(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2SensorEvents
     */
    public static b2SensorEvents createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2SensorEvents(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2SensorEvents}.
     *
     * @param alloc Custom memory manager
     * @return b2SensorEvents
     */
    public static b2SensorEvents alloc(AllocFunc alloc) {
        return new b2SensorEvents(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2SensorEvents}.
     *
     * @return b2SensorEvents
     */
    public static b2SensorEvents malloc() {
        return new b2SensorEvents(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2SensorEvents}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2SensorEvents}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------
    
    public static long nbeginEvents(long address) { return memGetAddress(address + BEGIN_EVENTS);}
    public static long nendEvents(long address) { return memGetAddress(address + END_EVENTS);}
    public static int nbeginCount(long address) { return memGetInt(address + BEGIN_COUNT);}
    public static int nendCount(long address) { return memGetInt(address + END_COUNT);}

    public static void nbeginEvents(long address, long value) { memPutAddress(address + BEGIN_EVENTS, value);}
    public static void nendEvents(long address, long value) { memPutAddress(address + END_EVENTS, value);}
    public static void nbeginCount(long address, int value) { memPutInt(address + BEGIN_COUNT, value);}
    public static void nendCount(long address, int value) { memPutInt(address + END_COUNT, value);}
    
    // -----------------------------------

    /** An array of {@code b2SensorEvents} structs. */
    public static class Buffer extends StructBuffer<b2SensorEvents, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2SensorEvents ELEMENT_FACTORY = b2SensorEvents.factory();

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
        protected b2SensorEvents getElementFactory() {
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
