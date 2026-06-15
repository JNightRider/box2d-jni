/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import java.nio.ByteBuffer;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2SurfaceMaterial;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2SurfaceMaterial
 * {
 * 	float friction;
 * 	float restitution;
 * 	float rollingResistance;
 * 	float tangentSpeed;
 * 	uint64_t userMaterialId;
 * 	uint32_t customColor;
 * } b2SurfaceMaterial;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2SurfaceMaterial extends Struct<b2SurfaceMaterial> implements ConstB2SurfaceMaterial {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            FRICTION,
            RESTITUTION,
            ROLLING_RESISTANCE,
            TANGENT_SPEED,
            USER_MATERIAL_ID,
            CUSTOM_COLOR;

    static {

        Layout layout = __struct(
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(VarType.Int64t.sizeof()),
                __member(VarType.Int32t.sizeof())
        );

        FRICTION = layout.offsetof(0);
        RESTITUTION = layout.offsetof(1);
        ROLLING_RESISTANCE = layout.offsetof(2);
        TANGENT_SPEED = layout.offsetof(3);
        USER_MATERIAL_ID = layout.offsetof(4);
        CUSTOM_COLOR = layout.offsetof(5);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2SurfaceMaterial(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2SurfaceMaterial(long address) {
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
    protected b2SurfaceMaterial(long address, boolean factor) {
        super(address, factor);
    }
    
    /** @return Returns the property {@code friction} */
    @Override
    public float friction() { return nfriction(address()); }
    /** @return Returns the property {@code nrestitution} */
    @Override
    public float restitution() { return nrestitution(address()); }
    /** @return Returns the property {@code nrollingResistance} */
    @Override
    public float rollingResistance() { return nrollingResistance(address()); }
    /** @return Returns the property {@code ntangentSpeed} */
    @Override
    public float tangentSpeed() { return ntangentSpeed(address()); }
    /** @return Returns the property {@code nuserMaterialId} */
    @Override
    public long userMaterialId() { return nuserMaterialId(address()); }
    /** @return Returns the property {@code ncustomColor} */
    @Override
    public int customColor() { return ncustomColor(address()); }

    /**
     * Set the value of property {@code friction}
     *
     * @param value The value
     * @return b2SurfaceMaterial
     */
    public b2SurfaceMaterial friction(float value) {
        nfriction(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code restitution}
     *
     * @param value The value
     * @return b2SurfaceMaterial
     */
    public b2SurfaceMaterial restitution(float value) {
        nrestitution(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code rollingResistance}
     *
     * @param value The value
     * @return b2SurfaceMaterial
     */
    public b2SurfaceMaterial rollingResistance(float value) {
        nrollingResistance(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code tangentSpeed}
     *
     * @param value The value
     * @return b2SurfaceMaterial
     */
    public b2SurfaceMaterial tangentSpeed(float value) {
        ntangentSpeed(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code userMaterialId}
     *
     * @param value The value
     * @return b2SurfaceMaterial
     */
    public b2SurfaceMaterial userMaterialId(long value) {
        nuserMaterialId(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code customColor}
     *
     * @param value The value
     * @return b2SurfaceMaterial
     */
    public b2SurfaceMaterial customColor(int value) {
        ncustomColor(address(), value);
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
    protected b2SurfaceMaterial create(long address, Pointer ptr) {
        return ptr == null ? new b2SurfaceMaterial(address) : new b2SurfaceMaterial(ptr);
    }
    
    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2SurfaceMaterial
     */
    private static b2SurfaceMaterial factory() {
        return new b2SurfaceMaterial(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2SurfaceMaterial
     */
    public static b2SurfaceMaterial createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2SurfaceMaterial(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2SurfaceMaterial}.
     *
     * @param alloc Custom memory manager
     * @return b2SurfaceMaterial
     */
    public static b2SurfaceMaterial alloc(AllocFunc alloc) {
        return new b2SurfaceMaterial(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2SurfaceMaterial}.
     *
     * @return b2SurfaceMaterial
     */
    public static b2SurfaceMaterial malloc() {
        return new b2SurfaceMaterial(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2SurfaceMaterial}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2SurfaceMaterial}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer( alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }    

    // ----------------------------------- 
    
    public static float nfriction(long address) { return memGetFloat(address + FRICTION); }
    public static float nrestitution(long address) { return memGetFloat(address + RESTITUTION); }
    public static float nrollingResistance(long address) { return memGetFloat(address + ROLLING_RESISTANCE); }
    public static float ntangentSpeed(long address) { return memGetFloat(address + TANGENT_SPEED); }
    public static long nuserMaterialId(long address) { return memGetLong(address + USER_MATERIAL_ID); }
    public static int ncustomColor(long address) { return memGetInt(address + CUSTOM_COLOR); }

    public static void nfriction(long address, float value) { memPutFloat(address + FRICTION, value); }
    public static void nrestitution(long address, float value) { memPutFloat(address + RESTITUTION, value); }
    public static void nrollingResistance(long address, float value) { memPutFloat(address + ROLLING_RESISTANCE, value); }
    public static void ntangentSpeed(long address, float value) { memPutFloat(address + TANGENT_SPEED, value); }
    public static void nuserMaterialId(long address, long value) { memPutLong(address + USER_MATERIAL_ID, value); }
    public static void ncustomColor(long address, int value) { memPutInt(address + CUSTOM_COLOR, value); }

    // -----------------------------------

    /** An array of {@code b2BodyDef} structs. */
    public static class Buffer extends StructBuffer<b2SurfaceMaterial, Buffer> implements ConstBuffer<b2SurfaceMaterial, Buffer>, JNINative {
        /** An element that provides information about the structure. */
        private static final b2SurfaceMaterial ELEMENT_FACTORY = b2SurfaceMaterial.factory();

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
         * @param container ByteBuffer
         */
        public Buffer(ByteBuffer container) {
            super(container, container.remaining() / SIZEOF);
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
        protected b2SurfaceMaterial getElementFactory() {
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
