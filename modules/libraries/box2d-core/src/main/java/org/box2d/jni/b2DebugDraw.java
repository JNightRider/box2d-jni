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

import org.box2d.jni.draw.*;
import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2DebugDraw
 * {
 *     void ( *DrawPolygonFcn )( b2WorldTransform transform, const b2Vec2* vertices, int vertexCount, b2HexColor color, void* context );
 *     void ( *DrawSolidPolygonFcn )( b2WorldTransform transform, const b2Vec2* vertices, int vertexCount, float radius, b2HexColor color, void* context );
 *     void ( *DrawCircleFcn )( b2Pos center, float radius, b2HexColor color, void* context );
 *     void ( *DrawSolidCircleFcn )( b2WorldTransform transform, b2Vec2 center, float radius, b2HexColor color, void* context );
 *     void ( *DrawSolidCapsuleFcn )( b2Pos p1, b2Pos p2, float radius, b2HexColor color, void* context );
 *     void ( *DrawLineFcn )( b2Pos p1, b2Pos p2, b2HexColor color, void* context );
 *     void ( *DrawTransformFcn )( b2WorldTransform transform, void* context );
 *     void ( *DrawPointFcn )( b2Pos p, float size, b2HexColor color, void* context );
 *     void ( *DrawStringFcn )( b2Pos p, const char* s, b2HexColor color, void* context );
 *     void ( *DrawBoundsFcn )( b2AABB aabb, b2HexColor color, void* context );
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
 * @version 1.0.1
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
            DRAW_BOUNDS_FCN,
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
                __member(POINTER_SIZE),
                __member(POINTER_SIZE),
                __member(POINTER_SIZE),
                __member(POINTER_SIZE),
                __member(POINTER_SIZE),
                __member(POINTER_SIZE),
                __member(POINTER_SIZE),
                __member(POINTER_SIZE),
                __member(POINTER_SIZE),
                __member(POINTER_SIZE),
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
                __member(POINTER_SIZE)
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
        DRAW_BOUNDS_FCN = layout.offsetof(9);

        DRAWING_BOUNDS = layout.offsetof(10);

        FORCE_SCALE = layout.offsetof(11);
        JOINT_SCALE = layout.offsetof(12);

        DRAW_CONTACTS = layout.offsetof(13);
        DRAW_ANCHOR_A = layout.offsetof(14);
        DRAW_SHAPES = layout.offsetof(15);
        DRAW_CHAIN_NORMALS = layout.offsetof(16);
        DRAW_JOINTS = layout.offsetof(17);
        DRAW_JOINT_EXTRAS = layout.offsetof(18);
        DRAW_BOUNDS = layout.offsetof(19);
        DRAW_MASS = layout.offsetof(20);
        DRAW_BODY_NAMES = layout.offsetof(21);
        DRAW_GRAPH_COLORS = layout.offsetof(22);
        DRAW_CONTACT_FEATURES = layout.offsetof(23);
        DRAW_CONTACT_NORMALS = layout.offsetof(24);
        DRAW_CONTACT_FORCES = layout.offsetof(25);
        DRAW_FRICTION_FORCES = layout.offsetof(26);
        DRAW_ISLANDS = layout.offsetof(27);

        CONTEXT = layout.offsetof(28);

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
    
    /** @return Returns the property {@code DrawPolygonFcn} */
    public long DrawPolygonFcn() { return nDrawPolygonFcn(address()); }
    /** @return Returns the property {@code DrawSolidPolygonFcn} */
    public long DrawSolidPolygonFcn() { return nDrawSolidPolygonFcn(address()); }
    /** @return Returns the property {@code DrawCircleFcn} */
    public long DrawCircleFcn() { return nDrawCircleFcn(address()); }
    /** @return Returns the property {@code DrawSolidCircleFcn} */
    public long DrawSolidCircleFcn() { return nDrawSolidCircleFcn(address()); }
    /** @return Returns the property {@code DrawSolidCapsuleFcn} */
    public long DrawSolidCapsuleFcn() { return nDrawSolidCapsuleFcn(address()); }
    /** @return Returns the property {@code DrawLineFcn} */
    public long DrawLineFcn() { return nDrawLineFcn(address()); }
    /** @return Returns the property {@code DrawTransformFcn} */
    public long DrawTransformFcn() { return nDrawTransformFcn(address()); }
    /** @return Returns the property {@code DrawPointFcn} */
    public long DrawPointFcn() { return nDrawPointFcn(address()); }
    /** @return Returns the property {@code DrawStringFcn} */
    public long DrawStringFcn() { return nDrawStringFcn(address()); }
    /** @return Returns the property {@code DrawBoundsFcn} */
    public long DrawBoundsFcn() { return nDrawBoundsFcn(address()); }
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
     * Set the value of property {@code DrawPolygonFcn}
     *
     * @param value long
     * @return b2DebugDraw
     */
    public b2DebugDraw DrawPolygonFcn(DrawPolygonFcnI value) {
        nDrawPolygonFcn(address(), value.address());
        return this;
    }

    /**
     * Set the value of property {@code DrawSolidPolygonFcn}
     *
     * @param value long
     * @return b2DebugDraw
     */
    public b2DebugDraw DrawSolidPolygonFcn(DrawSolidPolygonFcnI value) {
        nDrawSolidPolygonFcn(address(), value.address());
        return this;
    }

    /**
     * Set the value of property {@code DrawCircleFcn}
     *
     * @param value long
     * @return b2DebugDraw
     */
    public b2DebugDraw DrawCircleFcn(DrawCircleFcnI value) {
        nDrawCircleFcn(address(), value.address());
        return this;
    }

    /**
     * Set the value of property {@code DrawSolidCircleFcn}
     *
     * @param value long
     * @return b2DebugDraw
     */
    public b2DebugDraw DrawSolidCircleFcn(DrawSolidCircleFcnI value) {
        nDrawSolidCircleFcn(address(), value.address());
        return this;
    }

    /**
     * Set the value of property {@code DrawSolidCapsuleFcn}
     *
     * @param value long
     * @return b2DebugDraw
     */
    public b2DebugDraw DrawSolidCapsuleFcn(DrawSolidCapsuleFcnI value) {
        nDrawSolidCapsuleFcn(address(), value.address());
        return this;
    }

    /**
     * Set the value of property {@code DrawLineFcn}
     *
     * @param value long
     * @return b2DebugDraw
     */
    public b2DebugDraw DrawLineFcn(DrawLineFcnI value) {
        nDrawLineFcn(address(), value.address());
        return this;
    }

    /**
     * Set the value of property {@code DrawTransformFcn}
     *
     * @param value long
     * @return b2DebugDraw
     */
    public b2DebugDraw DrawTransformFcn(DrawTransformFcnI value) {
        nDrawTransformFcn(address(), value.address());
        return this;
    }

    /**
     * Set the value of property {@code DrawPointFcn}
     *
     * @param value long
     * @return b2DebugDraw
     */
    public b2DebugDraw DrawPointFcn(DrawPointFcnI value) {
        nDrawPointFcn(address(), value.address());
        return this;
    }

    /**
     * Set the value of property {@code DrawStringFcn}
     *
     * @param value long
     * @return b2DebugDraw
     */
    public b2DebugDraw DrawStringFcn(DrawStringFcnI value) {
        nDrawStringFcn(address(), value.address());
        return this;
    }
    
    /**
     * Set the value of property {@code DrawBoundsFcn}
     *
     * @param value long
     * @return b2DebugDraw
     */
    public b2DebugDraw DrawBoundsFcn(DrawStringFcnI value) {
        nDrawBoundsFcn(address(), value.address());
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
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2DebugDraw(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2DebugDraw}.
     *
     * @param arean arena
     * @return b2DebugDraw
     */
    public static b2DebugDraw calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2DebugDraw(() -> ptr);
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
        long address = alloc.alloc(ALIGNOF, capacity, SIZEOF);
        return new Buffer(address, capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2DebugDraw}.
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
    
    public static long nDrawPolygonFcn(long address)        { return memGetAddress(address + DRAW_POLYGON_FCN);         }
    public static long nDrawSolidPolygonFcn(long address)   { return memGetAddress(address + DRAW_SOLID_POLYGON_FCN);   }
    public static long nDrawCircleFcn(long address)         { return memGetAddress(address + DRAW_CIRCLE_FCN);          }
    public static long nDrawSolidCircleFcn(long address)    { return memGetAddress(address + DRAW_SOLID_CIRCLE_FCN);    }
    public static long nDrawSolidCapsuleFcn(long address)   { return memGetAddress(address + DRAW_SOLID_CAPSULE_FCN);   }
    public static long nDrawLineFcn(long address)           { return memGetAddress(address + DRAW_LINE_FCN);            }
    public static long nDrawTransformFcn(long address)      { return memGetAddress(address + DRAW_TRANSFORM_FCN);       }
    public static long nDrawPointFcn(long address)          { return memGetAddress(address + DRAW_POINT_FCN);           }
    public static long nDrawStringFcn(long address)         { return memGetAddress(address + DRAW_STRING_FCN);          }
    public static long nDrawBoundsFcn(long address)         { return memGetAddress(address + DRAW_BOUNDS_FCN);          }
    public static b2AABB ndrawingBounds(long address)       { return b2AABB.createSafe(() -> address + DRAWING_BOUNDS); }
    public static float nforceScale(long address)           { return memGetFloat(address + FORCE_SCALE);                }
    public static float njointScale(long address)           { return memGetFloat(address + JOINT_SCALE);                }
    public static boolean ndrawContacts(long address)       { return memGetByte(address + DRAW_CONTACTS) != 0;          }
    public static boolean ndrawAnchorA(long address)        { return memGetByte(address + DRAW_ANCHOR_A) != 0;          }
    public static boolean ndrawShapes(long address)         { return memGetByte(address + DRAW_SHAPES) != 0;            }
    public static boolean ndrawChainNormals(long address)   { return memGetByte(address + DRAW_CHAIN_NORMALS) != 0;     }
    public static boolean ndrawJoints(long address)         { return memGetByte(address + DRAW_JOINTS) != 0;            }
    public static boolean ndrawJointExtras(long address)    { return memGetByte(address + DRAW_JOINT_EXTRAS) != 0;      }
    public static boolean ndrawBounds(long address)         { return memGetByte(address + DRAW_BOUNDS) != 0;            }
    public static boolean ndrawMass(long address)           { return memGetByte(address + DRAW_MASS) != 0;              }
    public static boolean ndrawBodyNames(long address)      { return memGetByte(address + DRAW_BODY_NAMES) != 0;        }
    public static boolean ndrawGraphColors(long address)    { return memGetByte(address + DRAW_GRAPH_COLORS) != 0;      }
    public static boolean ndrawContactFeatures(long address){ return memGetByte(address + DRAW_CONTACT_FEATURES) != 0;  }
    public static boolean ndrawContactNormals(long address) { return memGetByte(address + DRAW_CONTACT_NORMALS) != 0;   }
    public static boolean ndrawContactForces(long address)  { return memGetByte(address + DRAW_CONTACT_FORCES) != 0;    }
    public static boolean ndrawFrictionForces(long address) { return memGetByte(address + DRAW_FRICTION_FORCES) != 0;   }
    public static boolean ndrawIslands(long address)        { return memGetByte(address + DRAW_ISLANDS) != 0;           }
    public static long ncontext(long address)               { return memGetAddress(address + CONTEXT);                  }

    public static void nDrawPolygonFcn(long address, long value)        { memPutAddress(address + DRAW_POLYGON_FCN, value);                     }
    public static void nDrawSolidPolygonFcn(long address, long value)   { memPutAddress(address + DRAW_SOLID_POLYGON_FCN, value);               }
    public static void nDrawCircleFcn(long address, long value)         { memPutAddress(address + DRAW_CIRCLE_FCN, value);                      }
    public static void nDrawSolidCircleFcn(long address, long value)    { memPutAddress(address + DRAW_SOLID_CIRCLE_FCN, value);                }
    public static void nDrawSolidCapsuleFcn(long address, long value)   { memPutAddress(address + DRAW_SOLID_CAPSULE_FCN, value);               }
    public static void nDrawLineFcn(long address, long value)           { memPutAddress(address + DRAW_LINE_FCN, value);                        }
    public static void nDrawTransformFcn(long address, long value)      { memPutAddress(address + DRAW_TRANSFORM_FCN, value);                   }
    public static void nDrawPointFcn(long address, long value)          { memPutAddress(address + DRAW_POINT_FCN, value);                       }
    public static void nDrawStringFcn(long address, long value)         { memPutAddress(address + DRAW_STRING_FCN, value);                      }
    public static void nDrawBoundsFcn(long address, long value)         { memPutAddress(address + DRAW_BOUNDS_FCN, value);                      }
    public static void ndrawingBounds(long address, b2AABB value)       { nmemcpy(address + DRAWING_BOUNDS, value.address(), b2AABB.SIZEOF); }
    public static void nforceScale(long address, float value)           { memPutFloat(address + FORCE_SCALE, value);                            }
    public static void njointScale(long address, float value)           { memPutFloat(address + JOINT_SCALE, value);                            }
    public static void ndrawContacts(long address, boolean value)       { memPutByte(address + DRAW_CONTACTS, (byte) (value ? 1 : 0));          }
    public static void ndrawAnchorA(long address, boolean value)        { memPutByte(address + DRAW_ANCHOR_A, (byte) (value ? 1 : 0));          }
    public static void ndrawShapes(long address, boolean value)         { memPutByte(address + DRAW_SHAPES, (byte) (value ? 1 : 0));            }
    public static void ndrawChainNormals(long address, boolean value)   { memPutByte(address + DRAW_CHAIN_NORMALS, (byte) (value ? 1 : 0));     }
    public static void ndrawJoints(long address, boolean value)         { memPutByte(address + DRAW_JOINTS, (byte) (value ? 1 : 0));            }
    public static void ndrawJointExtras(long address, boolean value)    { memPutByte(address + DRAW_JOINT_EXTRAS, (byte) (value ? 1 : 0));      }
    public static void ndrawBounds(long address, boolean value)         { memPutByte(address + DRAW_BOUNDS, (byte) (value ? 1 : 0));            }
    public static void ndrawMass(long address, boolean value)           { memPutByte(address + DRAW_MASS, (byte) (value ? 1 : 0));              }
    public static void ndrawBodyNames(long address, boolean value)      { memPutByte(address + DRAW_BODY_NAMES, (byte) (value ? 1 : 0));        }
    public static void ndrawGraphColors(long address, boolean value)    { memPutByte(address + DRAW_GRAPH_COLORS, (byte) (value ? 1 : 0));      }
    public static void ndrawContactFeatures(long address, boolean value){ memPutByte(address + DRAW_CONTACT_FEATURES, (byte) (value ? 1 : 0));  }
    public static void ndrawContactNormals(long address, boolean value) { memPutByte(address + DRAW_CONTACT_NORMALS, (byte) (value ? 1 : 0));   }
    public static void ndrawContactForces(long address, boolean value)  { memPutByte(address + DRAW_CONTACT_FORCES, (byte) (value ? 1 : 0));    }
    public static void ndrawFrictionForces(long address, boolean value) { memPutByte(address + DRAW_FRICTION_FORCES, (byte) (value ? 1 : 0));   }
    public static void ndrawIslands(long address, boolean value)        { memPutByte(address + DRAW_ISLANDS, (byte) (value ? 1 : 0));           }
    public static void ncontext(long address, long value)               { memPutAddress(address + CONTEXT, value);                              }

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
