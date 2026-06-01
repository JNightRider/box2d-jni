/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni;

import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2DebugDraw
 * {
 *     void ( *DrawPolygonFcn )( const b2Vec2* vertices, int vertexCount, b2HexColor color, void* context );
 *     void ( *DrawSolidPolygonFcn )( b2Transform transform, const b2Vec2* vertices, int vertexCount, float radius, b2HexColor color, void* context );
 *     void ( *DrawCircleFcn )( b2Vec2 center, float radius, b2HexColor color, void* context );
 *     void ( *DrawSolidCircleFcn )( b2Transform transform, float radius, b2HexColor color, void* context );
 *     void ( *DrawSolidCapsuleFcn )( b2Vec2 p1, b2Vec2 p2, float radius, b2HexColor color, void* context );
 *     void ( *DrawLineFcn )( b2Vec2 p1, b2Vec2 p2, b2HexColor color, void* context );
 *     void ( *DrawTransformFcn )( b2Transform transform, void* context );
 *     void ( *DrawPointFcn )( b2Vec2 p, float size, b2HexColor color, void* context );
 *     void ( *DrawStringFcn )( b2Vec2 p, const char* s, b2HexColor color, void* context );
 *     b2AABB drawingBounds;
 *     float forceScale;
 *     float jointScale;
 *     bool drawContacts;
 *     bool drawAnchorA;
 *     bool drawShapes;
 *     bool drawChainNormals;
 *     bool drawJoints;
 *     bool drawJointExtras;
 *     bool drawBounds;
 *     bool drawMass;
 *     bool drawBodyNames;
 *     bool drawGraphColors;
 *     bool drawContactFeatures;
 *     bool drawContactNormals;
 *     bool drawContactForces;
 *     bool drawFrictionForces;
 *     bool drawIslands;
 *     void* context;
 * } b2DebugDraw;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2DebugDraw extends Struct<b2DebugDraw> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            DRAW_POLYGON_FCN,
            DRAW_SOLID_POLYGON_FCN,
            DRAW_CIRCLE_FCN,
            DRAW_SOLID_CIRCLE_FCN,
            DRAW_SOLID_CAPSULE_FCN,
            DRAW_LINE_FCN,
            DRAW_TRANSFORM_FCN,
            DRAW_POINT_FCN,
            DRAW_STRING_FCN,
            DRAWING_BOUNDS,
            FORCE_SCALE,
            JOINT_SCALE,
            DRAW_CONTACTS,
            DRAW_ANCHOR_A,
            DRAW_SHAPES,
            DRAW_CHAIN_NORMALS,
            DRAW_JOINTS,
            DRAW_JOINT_EXTRAS,
            DRAW_BOUNDS,
            DRAW_MASS,
            DRAW_BODY_NAMES,
            DRAW_GRAPH_COLORS,
            DRAW_CONTACT_FEATURES,
            DRAW_CONTACT_NORMALS,
            DRAW_CONTACT_FORCES,
            DRAW_FRICTION_FORCES,
            DRAW_ISLANDS,
            CONTEXT;

    static {
        Layout layout = __struct(
                __member(VarType.Uintptrt.sizeof()),
                __member(VarType.Uintptrt.sizeof()),
                __member(VarType.Uintptrt.sizeof()),
                __member(VarType.Uintptrt.sizeof()),
                __member(VarType.Uintptrt.sizeof()),
                __member(VarType.Uintptrt.sizeof()),
                __member(VarType.Uintptrt.sizeof()),
                __member(VarType.Uintptrt.sizeof()),
                __member(VarType.Uintptrt.sizeof()),

                __member(b2AABB.SIZEOF, b2AABB.ALIGNOF),

                __member(4),
                __member(4),

                __member(1),
                __member(1),
                __member(1),
                __member(1),
                __member(1),
                __member(1),
                __member(1),
                __member(1),
                __member(1),
                __member(1),
                __member(1),
                __member(1),
                __member(1),
                __member(1),
                __member(1),

                __member(VarType.Uintptrt.sizeof())
        );

        DRAW_POLYGON_FCN = layout.offsetof(0);
        DRAW_SOLID_POLYGON_FCN = layout.offsetof(1);
        DRAW_CIRCLE_FCN = layout.offsetof(2);
        DRAW_SOLID_CIRCLE_FCN = layout.offsetof(3);
        DRAW_SOLID_CAPSULE_FCN = layout.offsetof(4);
        DRAW_LINE_FCN = layout.offsetof(5);
        DRAW_TRANSFORM_FCN = layout.offsetof(6);
        DRAW_POINT_FCN = layout.offsetof(7);
        DRAW_STRING_FCN = layout.offsetof(8);

        DRAWING_BOUNDS = layout.offsetof(9);

        FORCE_SCALE = layout.offsetof(10);
        JOINT_SCALE = layout.offsetof(11);

        DRAW_CONTACTS = layout.offsetof(12);
        DRAW_ANCHOR_A = layout.offsetof(13);
        DRAW_SHAPES = layout.offsetof(14);
        DRAW_CHAIN_NORMALS = layout.offsetof(15);
        DRAW_JOINTS = layout.offsetof(16);
        DRAW_JOINT_EXTRAS = layout.offsetof(17);
        DRAW_BOUNDS = layout.offsetof(18);
        DRAW_MASS = layout.offsetof(19);
        DRAW_BODY_NAMES = layout.offsetof(20);
        DRAW_GRAPH_COLORS = layout.offsetof(21);
        DRAW_CONTACT_FEATURES = layout.offsetof(22);
        DRAW_CONTACT_NORMALS = layout.offsetof(23);
        DRAW_CONTACT_FORCES = layout.offsetof(24);
        DRAW_FRICTION_FORCES = layout.offsetof(25);
        DRAW_ISLANDS = layout.offsetof(26);

        CONTEXT = layout.offsetof(27);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2DebugDraw(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2DebugDraw(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2DebugDraw(long address, boolean factor) {
        super(address, factor);
    }
    
    /** @return Returns the property {@code drawPolygonFcn} */
    public long drawPolygonFcn() { return ndrawPolygonFcn(address()); }
    /** @return Returns the property {@code drawSolidPolygonFcn} */
    public long drawSolidPolygonFcn() { return ndrawSolidPolygonFcn(address()); }
    /** @return Returns the property {@code drawCircleFcn} */
    public long drawCircleFcn() { return ndrawCircleFcn(address()); }
    /** @return Returns the property {@code drawSolidCircleFcn} */
    public long drawSolidCircleFcn() { return ndrawSolidCircleFcn(address()); }
    /** @return Returns the property {@code drawSolidCapsuleFcn} */
    public long drawSolidCapsuleFcn() { return ndrawSolidCapsuleFcn(address()); }
    /** @return Returns the property {@code drawLineFcn} */
    public long drawLineFcn() { return ndrawLineFcn(address()); }
    /** @return Returns the property {@code drawTransformFcn} */
    public long drawTransformFcn() { return ndrawTransformFcn(address()); }
    /** @return Returns the property {@code drawPointFcn} */
    public long drawPointFcn() { return ndrawPointFcn(address()); }
    /** @return Returns the property {@code drawStringFcn} */
    public long drawStringFcn() { return ndrawStringFcn(address()); }
    /** @return Returns the property {@code drawingBounds} */
    public b2AABB drawingBounds() { return ndrawingBounds(address()); }
    /** @return Returns the property {@code forceScale} */
    public float forceScale() { return nforceScale(address()); }
    /** @return Returns the property {@code jointScale} */
    public float jointScale() { return njointScale(address()); }
    /** @return Returns the property {@code drawContacts} */
    public boolean drawContacts() { return ndrawContacts(address()); }
    /** @return Returns the property {@code drawAnchorA} */
    public boolean drawAnchorA() { return ndrawAnchorA(address()); }
    /** @return Returns the property {@code drawShapes} */
    public boolean drawShapes() { return ndrawShapes(address()); }
    /** @return Returns the property {@code drawChainNormals} */
    public boolean drawChainNormals() { return ndrawChainNormals(address()); }
    /** @return Returns the property {@code drawJoints} */
    public boolean drawJoints() { return ndrawJoints(address()); }
    /** @return Returns the property {@code drawJointExtras} */
    public boolean drawJointExtras() { return ndrawJointExtras(address()); }
    /** @return Returns the property {@code drawBounds} */
    public boolean drawBounds() { return ndrawBounds(address()); }
    /** @return Returns the property {@code drawMass} */
    public boolean drawMass() { return ndrawMass(address()); }
    /** @return Returns the property {@code drawBodyNames} */
    public boolean drawBodyNames() { return ndrawBodyNames(address()); }
    /** @return Returns the property {@code drawGraphColors} */
    public boolean drawGraphColors() { return ndrawGraphColors(address()); }
    /** @return Returns the property {@code drawContactFeatures} */
    public boolean drawContactFeatures() { return ndrawContactFeatures(address()); }
    /** @return Returns the property {@code drawContactNormals} */
    public boolean drawContactNormals() { return ndrawContactNormals(address()); }
    /** @return Returns the property {@code drawContactForces} */
    public boolean drawContactForces() { return ndrawContactForces(address()); }
    /** @return Returns the property {@code drawFrictionForces} */
    public boolean drawFrictionForces() { return ndrawFrictionForces(address()); }
    /** @return Returns the property {@code drawIslands} */
    public boolean drawIslands() { return ndrawIslands(address()); }
    /** @return Returns the property {@code context} */
    public long context() { return ncontext(address()); }
    
    /**
     * Set the value of property {@code drawPolygonFcn}
     *
     * @param value long
     * @return b2DebugDraw
     */
    public b2DebugDraw drawPolygonFcn(long value) {
        ndrawPolygonFcn(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawSolidPolygonFcn}
     *
     * @param value long
     * @return b2DebugDraw
     */
    public b2DebugDraw drawSolidPolygonFcn(long value) {
        ndrawSolidPolygonFcn(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawCircleFcn}
     *
     * @param value long
     * @return b2DebugDraw
     */
    public b2DebugDraw drawCircleFcn(long value) {
        ndrawCircleFcn(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawSolidCircleFcn}
     *
     * @param value long
     * @return b2DebugDraw
     */
    public b2DebugDraw drawSolidCircleFcn(long value) {
        ndrawSolidCircleFcn(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawSolidCapsuleFcn}
     *
     * @param value long
     * @return b2DebugDraw
     */
    public b2DebugDraw drawSolidCapsuleFcn(long value) {
        ndrawSolidCapsuleFcn(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawLineFcn}
     *
     * @param value long
     * @return b2DebugDraw
     */
    public b2DebugDraw drawLineFcn(long value) {
        ndrawLineFcn(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawTransformFcn}
     *
     * @param value long
     * @return b2DebugDraw
     */
    public b2DebugDraw drawTransformFcn(long value) {
        ndrawTransformFcn(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawPointFcn}
     *
     * @param value long
     * @return b2DebugDraw
     */
    public b2DebugDraw drawPointFcn(long value) {
        ndrawPointFcn(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawStringFcn}
     *
     * @param value long
     * @return b2DebugDraw
     */
    public b2DebugDraw drawStringFcn(long value) {
        ndrawStringFcn(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawingBounds}
     *
     * @param value b2AABB
     * @return b2DebugDraw
     */
    public b2DebugDraw drawingBounds(b2AABB value) {
        ndrawingBounds(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code forceScale}
     *
     * @param value float
     * @return b2DebugDraw
     */
    public b2DebugDraw forceScale(float value) {
        nforceScale(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code jointScale}
     *
     * @param value float
     * @return b2DebugDraw
     */
    public b2DebugDraw jointScale(float value) {
        njointScale(address(), value);
        return this;
    }
    
        /**
     * Set the value of property {@code drawContacts}
     *
     * @param value boolean
     * @return b2DebugDraw
     */
    public b2DebugDraw drawContacts(boolean value) {
        ndrawContacts(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawAnchorA}
     *
     * @param value boolean
     * @return b2DebugDraw
     */
    public b2DebugDraw drawAnchorA(boolean value) {
        ndrawAnchorA(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawShapes}
     *
     * @param value boolean
     * @return b2DebugDraw
     */
    public b2DebugDraw drawShapes(boolean value) {
        ndrawShapes(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawChainNormals}
     *
     * @param value boolean
     * @return b2DebugDraw
     */
    public b2DebugDraw drawChainNormals(boolean value) {
        ndrawChainNormals(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawJoints}
     *
     * @param value boolean
     * @return b2DebugDraw
     */
    public b2DebugDraw drawJoints(boolean value) {
        ndrawJoints(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawJointExtras}
     *
     * @param value boolean
     * @return b2DebugDraw
     */
    public b2DebugDraw drawJointExtras(boolean value) {
        ndrawJointExtras(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawBounds}
     *
     * @param value boolean
     * @return b2DebugDraw
     */
    public b2DebugDraw drawBounds(boolean value) {
        ndrawBounds(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawMass}
     *
     * @param value boolean
     * @return b2DebugDraw
     */
    public b2DebugDraw drawMass(boolean value) {
        ndrawMass(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawBodyNames}
     *
     * @param value boolean
     * @return b2DebugDraw
     */
    public b2DebugDraw drawBodyNames(boolean value) {
        ndrawBodyNames(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawGraphColors}
     *
     * @param value boolean
     * @return b2DebugDraw
     */
    public b2DebugDraw drawGraphColors(boolean value) {
        ndrawGraphColors(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawContactFeatures}
     *
     * @param value boolean
     * @return b2DebugDraw
     */
    public b2DebugDraw drawContactFeatures(boolean value) {
        ndrawContactFeatures(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawContactNormals}
     *
     * @param value boolean
     * @return b2DebugDraw
     */
    public b2DebugDraw drawContactNormals(boolean value) {
        ndrawContactNormals(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawContactForces}
     *
     * @param value boolean
     * @return b2DebugDraw
     */
    public b2DebugDraw drawContactForces(boolean value) {
        ndrawContactForces(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawFrictionForces}
     *
     * @param value boolean
     * @return b2DebugDraw
     */
    public b2DebugDraw drawFrictionForces(boolean value) {
        ndrawFrictionForces(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code drawIslands}
     *
     * @param value boolean
     * @return b2DebugDraw
     */
    public b2DebugDraw drawIslands(boolean value) {
        ndrawIslands(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code context}
     *
     * @param value long
     * @return b2DebugDraw
     */
    public b2DebugDraw context(long value) {
        ncontext(address(), value);
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
    protected b2DebugDraw create(long address, Pointer ptr) {
        return ptr == null ? new b2DebugDraw(address) : new b2DebugDraw(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2DebugDraw
     */
    private static b2DebugDraw factory() {
        return new b2DebugDraw(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2DebugDraw
     */
    public static b2DebugDraw createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2DebugDraw(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2DebugDraw}.
     *
     * @param alloc Custom memory manager
     * @return b2DebugDraw
     */
    public static b2DebugDraw alloc(AllocFunc alloc) {
        return new b2DebugDraw(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2DebugDraw}.
     *
     * @return b2DebugDraw
     */
    public static b2DebugDraw malloc() {
        return new b2DebugDraw(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2DebugDraw}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2DebugDraw}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------
    
    public static long ndrawPolygonFcn(long address)        { return memGetAddress(address + DRAW_POLYGON_FCN); }
    public static long ndrawSolidPolygonFcn(long address)   { return memGetAddress(address + DRAW_SOLID_POLYGON_FCN); }
    public static long ndrawCircleFcn(long address)         { return memGetAddress(address + DRAW_CIRCLE_FCN); }
    public static long ndrawSolidCircleFcn(long address)    { return memGetAddress(address + DRAW_SOLID_CIRCLE_FCN); }
    public static long ndrawSolidCapsuleFcn(long address)   { return memGetAddress(address + DRAW_SOLID_CAPSULE_FCN); }
    public static long ndrawLineFcn(long address)           { return memGetAddress(address + DRAW_LINE_FCN); }
    public static long ndrawTransformFcn(long address)      { return memGetAddress(address + DRAW_TRANSFORM_FCN); }
    public static long ndrawPointFcn(long address)          { return memGetAddress(address + DRAW_POINT_FCN); }
    public static long ndrawStringFcn(long address)         { return memGetAddress(address + DRAW_STRING_FCN); }

    public static b2AABB ndrawingBounds(long address)       { return b2AABB.createSafe(() -> address + DRAWING_BOUNDS); }

    public static float nforceScale(long address)           { return memGetFloat(address + FORCE_SCALE); }
    public static float njointScale(long address)           { return memGetFloat(address + JOINT_SCALE); }

    public static boolean ndrawContacts(long address)       { return memGetByte(address + DRAW_CONTACTS) != 0; }
    public static boolean ndrawAnchorA(long address)        { return memGetByte(address + DRAW_ANCHOR_A) != 0; }
    public static boolean ndrawShapes(long address)         { return memGetByte(address + DRAW_SHAPES) != 0; }
    public static boolean ndrawChainNormals(long address)   { return memGetByte(address + DRAW_CHAIN_NORMALS) != 0; }
    public static boolean ndrawJoints(long address)         { return memGetByte(address + DRAW_JOINTS) != 0; }
    public static boolean ndrawJointExtras(long address)    { return memGetByte(address + DRAW_JOINT_EXTRAS) != 0; }
    public static boolean ndrawBounds(long address)         { return memGetByte(address + DRAW_BOUNDS) != 0; }
    public static boolean ndrawMass(long address)           { return memGetByte(address + DRAW_MASS) != 0; }
    public static boolean ndrawBodyNames(long address)      { return memGetByte(address + DRAW_BODY_NAMES) != 0; }
    public static boolean ndrawGraphColors(long address)    { return memGetByte(address + DRAW_GRAPH_COLORS) != 0; }
    public static boolean ndrawContactFeatures(long address){ return memGetByte(address + DRAW_CONTACT_FEATURES) != 0; }
    public static boolean ndrawContactNormals(long address) { return memGetByte(address + DRAW_CONTACT_NORMALS) != 0; }
    public static boolean ndrawContactForces(long address)  { return memGetByte(address + DRAW_CONTACT_FORCES) != 0; }
    public static boolean ndrawFrictionForces(long address) { return memGetByte(address + DRAW_FRICTION_FORCES) != 0; }
    public static boolean ndrawIslands(long address)        { return memGetByte(address + DRAW_ISLANDS) != 0; }

    public static long ncontext(long address)               { return memGetAddress(address + CONTEXT); }

    public static void ndrawPolygonFcn(long address, long value)        { memPutAddress(address + DRAW_POLYGON_FCN, value);}
    public static void ndrawSolidPolygonFcn(long address, long value)   { memPutAddress(address + DRAW_SOLID_POLYGON_FCN, value);}
    public static void ndrawCircleFcn(long address, long value)         { memPutAddress(address + DRAW_CIRCLE_FCN, value);}
    public static void ndrawSolidCircleFcn(long address, long value)    { memPutAddress(address + DRAW_SOLID_CIRCLE_FCN, value);}
    public static void ndrawSolidCapsuleFcn(long address, long value)   { memPutAddress(address + DRAW_SOLID_CAPSULE_FCN, value);}
    public static void ndrawLineFcn(long address, long value)           { memPutAddress(address + DRAW_LINE_FCN, value);}
    public static void ndrawTransformFcn(long address, long value)      { memPutAddress(address + DRAW_TRANSFORM_FCN, value);}
    public static void ndrawPointFcn(long address, long value)          { memPutAddress(address + DRAW_POINT_FCN, value);}
    public static void ndrawStringFcn(long address, long value)         { memPutAddress(address + DRAW_STRING_FCN, value);}
    public static void ndrawingBounds(long address, b2AABB value)       { nmemcpy(address + DRAWING_BOUNDS, value.address(), b2AABB.SIZEOF); }

    public static void nforceScale(long address, float value) { memPutFloat(address + FORCE_SCALE, value);}
    public static void njointScale(long address, float value) { memPutFloat(address + JOINT_SCALE, value);}

    public static void ndrawContacts(long address, boolean value)   { memPutByte(address + DRAW_CONTACTS, (byte) (value ? 1 : 0));}
    public static void ndrawAnchorA(long address, boolean value)    { memPutByte(address + DRAW_ANCHOR_A, (byte) (value ? 1 : 0));}
    public static void ndrawShapes(long address, boolean value)     { memPutByte(address + DRAW_SHAPES, (byte) (value ? 1 : 0));}
    public static void ndrawChainNormals(long address, boolean value)   { memPutByte(address + DRAW_CHAIN_NORMALS, (byte) (value ? 1 : 0));}
    public static void ndrawJoints(long address, boolean value)         { memPutByte(address + DRAW_JOINTS, (byte) (value ? 1 : 0));}
    public static void ndrawJointExtras(long address, boolean value)    { memPutByte(address + DRAW_JOINT_EXTRAS, (byte) (value ? 1 : 0));}
    public static void ndrawBounds(long address, boolean value) { memPutByte(address + DRAW_BOUNDS, (byte) (value ? 1 : 0));}
    public static void ndrawMass(long address, boolean value)   { memPutByte(address + DRAW_MASS, (byte) (value ? 1 : 0));}
    public static void ndrawBodyNames(long address, boolean value)      { memPutByte(address + DRAW_BODY_NAMES, (byte) (value ? 1 : 0));}
    public static void ndrawGraphColors(long address, boolean value)    { memPutByte(address + DRAW_GRAPH_COLORS, (byte) (value ? 1 : 0));}
    public static void ndrawContactFeatures(long address, boolean value) { memPutByte(address + DRAW_CONTACT_FEATURES, (byte) (value ? 1 : 0));}
    public static void ndrawContactNormals(long address, boolean value)  { memPutByte(address + DRAW_CONTACT_NORMALS, (byte) (value ? 1 : 0));}
    public static void ndrawContactForces(long address, boolean value)   { memPutByte(address + DRAW_CONTACT_FORCES, (byte) (value ? 1 : 0));}
    public static void ndrawFrictionForces(long address, boolean value)  { memPutByte(address + DRAW_FRICTION_FORCES, (byte) (value ? 1 : 0));}
    public static void ndrawIslands(long address, boolean value) { memPutByte(address + DRAW_ISLANDS, (byte) (value ? 1 : 0));}

    public static void ncontext(long address, long value) { memPutAddress(address + CONTEXT, value);}

    // -----------------------------------

    /** An array of {@code b2DebugDraw} structs. */
    public static class Buffer extends StructBuffer<b2DebugDraw, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2DebugDraw ELEMENT_FACTORY = b2DebugDraw.factory();

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
        protected b2DebugDraw getElementFactory() {
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
