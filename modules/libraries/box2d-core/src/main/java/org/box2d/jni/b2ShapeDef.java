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
import org.box2d.jni.readonly.ConstB2ShapeDef;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2ShapeDef
 * {
 * 	void* userData;
 * 	b2SurfaceMaterial material;
 * 	float density;
 * 	b2Filter filter;
 * 	bool enableCustomFiltering;
 * 	bool isSensor;
 * 	bool enableSensorEvents;
 * 	bool enableContactEvents;
 * 	bool enableHitEvents;
 * 	bool enablePreSolveEvents;
 * 	bool invokeContactCreation;
 * 	bool updateBodyMass;
 * 	int internalValue;
 * } b2ShapeDef;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2ShapeDef extends Struct<b2ShapeDef> implements ConstB2ShapeDef {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            USER_DATA,
            MATERIAL,
            DENSITY,
            FILTER,
            ENABLE_CUSTOM_FILTERING,
            IS_SENSOR,
            ENABLE_SENSOR_EVENTS,
            ENABLE_CONTACT_EVENTS,
            ENABLE_HIT_EVENTS,
            ENABLE_PRE_SOLVE_EVENTS,
            INVOKE_CONTACT_CREATION,
            UPDATE_BODY_MASS,
            INTERNAL_VALUE;

    static {

        Layout layout = __struct(
                __member(VarType.Uintptrt.sizeof()),
                __member(b2SurfaceMaterial.SIZEOF, b2SurfaceMaterial.ALIGNOF),
                __member(4),
                __member(b2Filter.SIZEOF, b2Filter.ALIGNOF),
                __member(1),
                __member(1),
                __member(1),
                __member(1),
                __member(1),
                __member(1),
                __member(1),
                __member(1),
                __member(4)
        );

        USER_DATA = layout.offsetof(0);
        MATERIAL = layout.offsetof(1);
        DENSITY = layout.offsetof(2);
        FILTER = layout.offsetof(3);
        ENABLE_CUSTOM_FILTERING = layout.offsetof(4);
        IS_SENSOR = layout.offsetof(5);
        ENABLE_SENSOR_EVENTS = layout.offsetof(6);
        ENABLE_CONTACT_EVENTS = layout.offsetof(7);
        ENABLE_HIT_EVENTS = layout.offsetof(8);
        ENABLE_PRE_SOLVE_EVENTS = layout.offsetof(9);
        INVOKE_CONTACT_CREATION = layout.offsetof(10);
        UPDATE_BODY_MASS = layout.offsetof(11);
        INTERNAL_VALUE = layout.offsetof(12);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2ShapeDef(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2ShapeDef(long address) {
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
    protected b2ShapeDef(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code userData} */
    @Override
    public long userData() { return nuserData(address()); }
    /** @return Returns the property {@code material} */
    @Override
    public b2SurfaceMaterial material() { return nmaterial(address()); }
    /** @return Returns the property {@code density} */
    @Override
    public float density() { return ndensity(address()); }
    /** @return Returns the property {@code filter} */
    @Override
    public b2Filter filter() { return nfilter(address()); }
    /** @return Returns the property {@code enableCustomFiltering} */
    @Override
    public boolean enableCustomFiltering() { return nenableCustomFiltering(address()); }
    /** @return Returns the property {@code isSensor} */
    @Override
    public boolean isSensor() { return nisSensor(address()); }
    /** @return Returns the property {@code enableSensorEvents} */
    @Override
    public boolean enableSensorEvents() { return nenableSensorEvents(address()); }
    /** @return Returns the property {@code enableContactEvents} */
    @Override
    public boolean enableContactEvents() { return nenableContactEvents(address()); }
    /** @return Returns the property {@code enableHitEvents} */
    @Override
    public boolean enableHitEvents() { return nenableHitEvents(address()); }
    /** @return Returns the property {@code enablePreSolveEvents} */
    @Override
    public boolean enablePreSolveEvents() { return nenablePreSolveEvents(address()); }
    /** @return Returns the property {@code invokeContactCreation} */
    @Override
    public boolean invokeContactCreation() { return ninvokeContactCreation(address()); }
    /** @return Returns the property {@code updateBodyMass} */
    @Override
    public boolean updateBodyMass() { return nupdateBodyMass(address()); }
    /** @return Returns the property {@code internalValue} */
    @Override
    public int internalValue() { return ninternalValue(address()); }

        /**
     * Set the value of property {@code userData}
     *
     * @param value The value
     * @return b2ShapeDef
     */
    public b2ShapeDef userData(long value) {
        nuserData(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code material}
     *
     * @param value The value
     * @return b2ShapeDef
     */
    public b2ShapeDef material(b2SurfaceMaterial value) {
        nmaterial(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code density}
     *
     * @param value The value
     * @return b2ShapeDef
     */
    public b2ShapeDef density(float value) {
        ndensity(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code filter}
     *
     * @param value The value
     * @return b2ShapeDef
     */
    public b2ShapeDef filter(b2Filter value) {
        nfilter(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code enableCustomFiltering}
     *
     * @param value The value
     * @return b2ShapeDef
     */
    public b2ShapeDef enableCustomFiltering(boolean value) {
        nenableCustomFiltering(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code isSensor}
     *
     * @param value The value
     * @return b2ShapeDef
     */
    public b2ShapeDef isSensor(boolean value) {
        nisSensor(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code enableSensorEvents}
     *
     * @param value The value
     * @return b2ShapeDef
     */
    public b2ShapeDef enableSensorEvents(boolean value) {
        nenableSensorEvents(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code enableContactEvents}
     *
     * @param value The value
     * @return b2ShapeDef
     */
    public b2ShapeDef enableContactEvents(boolean value) {
        nenableContactEvents(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code enableHitEvents}
     *
     * @param value The value
     * @return b2ShapeDef
     */
    public b2ShapeDef enableHitEvents(boolean value) {
        nenableHitEvents(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code enablePreSolveEvents}
     *
     * @param value The value
     * @return b2ShapeDef
     */
    public b2ShapeDef enablePreSolveEvents(boolean value) {
        nenablePreSolveEvents(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code invokeContactCreation}
     *
     * @param value The value
     * @return b2ShapeDef
     */
    public b2ShapeDef invokeContactCreation(boolean value) {
        ninvokeContactCreation(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code updateBodyMass}
     *
     * @param value The value
     * @return b2ShapeDef
     */
    public b2ShapeDef updateBodyMass(boolean value) {
        nupdateBodyMass(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code internalValue}
     *
     * @param value The value
     * @return b2ShapeDef
     */
    public b2ShapeDef internalValue(int value) {
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
    protected b2ShapeDef create(long address, Pointer ptr) {
        return ptr == null ? new b2ShapeDef(address) : new b2ShapeDef(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2ShapeDef
     */
    private static b2ShapeDef factory() {
        return new b2ShapeDef(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2ShapeDef
     */
    public static b2ShapeDef createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2ShapeDef(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ShapeDef}.
     *
     * @param alloc Custom memory manager
     * @return b2ShapeDef
     */
    public static b2ShapeDef alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2ShapeDef(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2ShapeDef}.
     *
     * @return b2ShapeDef
     */
    public static b2ShapeDef calloc() {
        return new b2ShapeDef(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2ShapeDef}.
     *
     * @param arean arena
     * @return b2ShapeDef
     */
    public static b2ShapeDef calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2ShapeDef(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2ShapeDef}.
     *
     * @return b2ShapeDef
     */
    public static b2ShapeDef malloc() {
        return new b2ShapeDef(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ShapeDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ShapeDef}.
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
     * Reserve an amount n of memory for the object {@code b2ShapeDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2ShapeDef}.
     *
     * @param capacity Number of elements
     * @param arena Arean
     * @return Buffer
     */
    public static Buffer calloc(int capacity, ArenaAlloc arena) {
        long ptr = arena.ncalloc(ALIGNOF, capacity, SIZEOF);
        return new Buffer(ptr, capacity);
    }

    // -----------------------------------
    
    public static long nuserData(long address)                  { return memGetAddress(address + USER_DATA);                        }
    public static b2SurfaceMaterial nmaterial(long address)     { return b2SurfaceMaterial.createSafe(() -> address + MATERIAL);    }
    public static float ndensity(long address)                  { return memGetFloat(address + DENSITY);                            }
    public static b2Filter nfilter(long address)                { return b2Filter.createSafe(() -> address + FILTER);               }
    public static boolean nenableCustomFiltering(long address)  { return memGetByte(address + ENABLE_CUSTOM_FILTERING) != 0;        }
    public static boolean nisSensor(long address)               { return memGetByte(address + IS_SENSOR) != 0;                      }
    public static boolean nenableSensorEvents(long address)     { return memGetByte(address + ENABLE_SENSOR_EVENTS) != 0;           }
    public static boolean nenableContactEvents(long address)    { return memGetByte(address + ENABLE_CONTACT_EVENTS) != 0;          }
    public static boolean nenableHitEvents(long address)        { return memGetByte(address + ENABLE_HIT_EVENTS) != 0;              }
    public static boolean nenablePreSolveEvents(long address)   { return memGetByte(address + ENABLE_PRE_SOLVE_EVENTS) != 0;        }
    public static boolean ninvokeContactCreation(long address)  { return memGetByte(address + INVOKE_CONTACT_CREATION) != 0;        }
    public static boolean nupdateBodyMass(long address)         { return memGetByte(address + UPDATE_BODY_MASS) != 0;               }
    public static int ninternalValue(long address)              { return memGetInt(address + INTERNAL_VALUE);                       }

    public static void nuserData(long address, long value)                  { memPutAddress(address + USER_DATA, value);                                    }
    public static void nmaterial(long address, b2SurfaceMaterial value)     { nmemcpy(address + MATERIAL, value.address(), b2SurfaceMaterial.SIZEOF); }
    public static void ndensity(long address, float value)                  { memPutFloat(address + DENSITY, value);                                        }
    public static void nfilter(long address, b2Filter value)                { nmemcpy(address + FILTER, value.address(), b2Filter.SIZEOF);            }
    public static void nenableCustomFiltering(long address, boolean value)  { memPutByte(address + ENABLE_CUSTOM_FILTERING, (byte)(value ? 1 : 0));         }
    public static void nisSensor(long address, boolean value)               { memPutByte(address + IS_SENSOR, (byte)(value ? 1 : 0));                       }
    public static void nenableSensorEvents(long address, boolean value)     { memPutByte(address + ENABLE_SENSOR_EVENTS, (byte)(value ? 1 : 0));            }
    public static void nenableContactEvents(long address, boolean value)    { memPutByte(address + ENABLE_CONTACT_EVENTS, (byte)(value ? 1 : 0));           }
    public static void nenableHitEvents(long address, boolean value)        { memPutByte(address + ENABLE_HIT_EVENTS, (byte)(value ? 1 : 0));               }
    public static void nenablePreSolveEvents(long address, boolean value)   { memPutByte(address + ENABLE_PRE_SOLVE_EVENTS, (byte)(value ? 1 : 0));         }
    public static void ninvokeContactCreation(long address, boolean value)  { memPutByte(address + INVOKE_CONTACT_CREATION, (byte)(value ? 1 : 0));         }
    public static void nupdateBodyMass(long address, boolean value)         { memPutByte(address + UPDATE_BODY_MASS, (byte)(value ? 1 : 0));                }
    public static void ninternalValue(long address, int value)              { memPutInt(address + INTERNAL_VALUE, value);                                   }

    // -----------------------------------

    /** An array of {@code b2BodyDef} structs. */
    public static class Buffer extends StructBuffer<b2ShapeDef, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2ShapeDef ELEMENT_FACTORY = b2ShapeDef.factory();

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
        protected b2ShapeDef getElementFactory() {
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
