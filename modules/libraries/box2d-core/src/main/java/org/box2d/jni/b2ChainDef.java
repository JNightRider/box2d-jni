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
import org.box2d.jni.readonly.ConstB2ChainDef;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2ChainDef
 * {
 * 	void* userData;
 * 	const b2Vec2* points;
 * 	int count;
 * 	const b2SurfaceMaterial* materials;
 * 	int materialCount;
 * 	b2Filter filter;
 * 	bool isLoop;
 * 	bool enableSensorEvents;
 * 	int internalValue;
 * } b2ChainDef;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2ChainDef extends Struct<b2ChainDef> implements ConstB2ChainDef {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            USER_DATA,
            POINTS,
            COUNT,
            MATERIALS,
            MATERIAL_COUNT,
            FILTER,
            IS_LOOP,
            ENABLE_SENSOR_EVENTS,
            INTERNAL_VALUE;

    static {

        Layout layout = __struct(
                __member(POINTER_SIZE),
                __member(POINTER_SIZE),
                __member(4),
                __member(POINTER_SIZE),
                __member(4),
                __member(b2Filter.SIZEOF, b2Filter.ALIGNOF),
                __member(1),
                __member(1),
                __member(4)
        );

        USER_DATA = layout.offsetof(0);
        POINTS = layout.offsetof(1);
        COUNT = layout.offsetof(2);
        MATERIALS = layout.offsetof(3);
        MATERIAL_COUNT = layout.offsetof(4);
        FILTER = layout.offsetof(5);
        IS_LOOP = layout.offsetof(6);
        ENABLE_SENSOR_EVENTS = layout.offsetof(7);
        INTERNAL_VALUE = layout.offsetof(8);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2ChainDef(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2ChainDef(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     *
     * @see Struct#Struct(long, boolean)
     */
    protected b2ChainDef(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code userData} */
    @Override
    public long userData() { return nuserData(address()); }
    /** @return Returns the property {@code points} */
    @Override
    public long points() { return npoints(address()); }
    /** @return Returns the property {@code count} */
    @Override
    public int count() { return ncount(address()); }
    /** @return Returns the property {@code materials} */
    @Override
    public long materials() { return nmaterials(address()); }
    /** @return Returns the property {@code materialCount} */
    @Override
    public int materialCount() { return nmaterialCount(address()); }
    /** @return Returns the property {@code filter} */
    @Override
    public b2Filter filter() { return nfilter(address()); }
    /** @return Returns the property {@code isLoop} */
    @Override
    public boolean isLoop() { return nisLoop(address()); }
    /** @return Returns the property {@code enableSensorEvents} */
    @Override
    public boolean enableSensorEvents() { return nenableSensorEvents(address()); }
    /** @return Returns the property {@code internalValue} */
    @Override
    public int internalValue() { return ninternalValue(address()); }

        /**
     * Set the value of property {@code userData}
     *
     * @param value The value
     * @return b2ChainDef
     */
    public b2ChainDef userData(long value) {
        nuserData(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code points}
     *
     * @param value The value
     * @return b2ChainDef
     */
    public b2ChainDef points(b2Vec2.Buffer value) {
        npoints(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code count}
     *
     * @param value The value
     * @return b2ChainDef
     */
    public b2ChainDef count(int value) {
        ncount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code materials}
     *
     * @param value The value
     * @return b2ChainDef
     */
    public b2ChainDef materials(b2SurfaceMaterial.Buffer value) {
        nmaterials(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code materialCount}
     *
     * @param value The value
     * @return b2ChainDef
     */
    public b2ChainDef materialCount(int value) {
        nmaterialCount(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code filter}
     *
     * @param value The value
     * @return b2ChainDef
     */
    public b2ChainDef filter(b2Filter value) {
        nfilter(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code isLoop}
     *
     * @param value The value
     * @return b2ChainDef
     */
    public b2ChainDef isLoop(boolean value) {
        nisLoop(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code enableSensorEvents}
     *
     * @param value The value
     * @return b2ChainDef
     */
    public b2ChainDef enableSensorEvents(boolean value) {
        nenableSensorEvents(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code internalValue}
     *
     * @param value The value
     * @return b2ChainDef
     */
    public b2ChainDef internalValue(int value) {
        ninternalValue(address(), value);
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
    protected b2ChainDef create(long address, Pointer ptr) {
        return ptr == null ? new b2ChainDef(address) : new b2ChainDef(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2ChainDef
     */
    private static b2ChainDef factory() {
        return new b2ChainDef(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2ChainDef
     */
    public static b2ChainDef createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2ChainDef(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ChainDef}.
     *
     * @param alloc Custom memory manager
     * @return b2ChainDef
     */
    public static b2ChainDef alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2ChainDef(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2ChainDef}.
     *
     * @return b2ChainDef
     */
    public static b2ChainDef calloc() {
        return new b2ChainDef(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2ChainDef}.
     *
     * @param alloc arena
     * @return b2ChainDef
     */
    public static b2ChainDef calloc(ArenaAlloc alloc) {
        long ptr = alloc.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2ChainDef(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ChainDef}.
     *
     * @return b2ChainDef
     */
    public static b2ChainDef malloc() {
        return new b2ChainDef(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ChainDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ChainDef}.
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
     * Reserve an amount n of memory for the object {@code b2ChainDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ChainDef}.
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
    
    public static long nuserData(long address)               { return memGetAddress(address + USER_DATA);              }
    public static long npoints(long address)                 { return memGetAddress(address + POINTS);                 }
    public static int ncount(long address)                   { return memGetInt(address + COUNT);                      }
    public static long nmaterials(long address)              { return memGetAddress(address + MATERIALS);              }
    public static int nmaterialCount(long address)           { return memGetInt(address + MATERIAL_COUNT);             }
    public static b2Filter nfilter(long address)             { return b2Filter.createSafe(() -> address + FILTER);     }
    public static boolean nisLoop(long address)              { return memGetByte(address + IS_LOOP) != 0;              }
    public static boolean nenableSensorEvents(long address)  { return memGetByte(address + ENABLE_SENSOR_EVENTS) != 0; }
    public static int ninternalValue(long address)           { return memGetInt(address + INTERNAL_VALUE);             }

    public static void nuserData(long address, long value)               { memPutAddress(address + USER_DATA, value);                         }
    public static void npoints(long address, b2Vec2.Buffer value)        { memPutAddress(address + POINTS, value.address0());           }
    public static void ncount(long address, int value)                   { memPutInt(address + COUNT, value);                                 }
    public static void nmaterials(long address, b2SurfaceMaterial.Buffer value) { memPutAddress(address + MATERIALS, value.address0()); }
    public static void nmaterialCount(long address, int value)           { memPutInt(address + MATERIAL_COUNT, value);                        }
    public static void nfilter(long address, b2Filter value)             { nmemcpy(address + FILTER, value.address(), b2Filter.SIZEOF); }
    public static void nisLoop(long address, boolean value)              { memPutByte(address + IS_LOOP, (byte)(value ? 1 : 0));              }
    public static void nenableSensorEvents(long address, boolean value)  { memPutByte(address + ENABLE_SENSOR_EVENTS, (byte)(value ? 1 : 0)); }
    public static void ninternalValue(long address, int value)           { memPutInt(address + INTERNAL_VALUE, value);                        }

    // -----------------------------------
    
    /** An array of {@code b2ChainDef} structs. */
    public static class Buffer extends StructBuffer<b2ChainDef, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2ChainDef ELEMENT_FACTORY = b2ChainDef.factory();

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

        /*(non-Jabadoc)
         */
        @Override
        protected b2ChainDef getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /*(non-Jabadoc)
         */
        @Override
        protected Buffer self() {
            return this;
        }

        /*(non-Jabadoc)
         */
        @Override
        protected Buffer create(long address, int mark, int position, int limit, int capacity) {
            return new Buffer(address, mark, position, limit, capacity);
        }
    }
}
