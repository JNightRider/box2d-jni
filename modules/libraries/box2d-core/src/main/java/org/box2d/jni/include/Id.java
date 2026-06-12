/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.include;

import java.nio.IntBuffer;

import org.box2d.jni.b2BodyId;
import org.box2d.jni.b2ChainId;
import org.box2d.jni.b2ContactId;
import org.box2d.jni.b2JointId;
import org.box2d.jni.b2ShapeId;
import org.box2d.jni.b2WorldId;

import org.box2d.jni.readonly.ConstB2Id;

import org.box2d.jni.system.Library;

import static org.box2d.jni.system.Checks.*;

/**
 * Functions provided by the 'id.h' header of box2d.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Id {
    static { Library.initialize(); }
    
    // --- [ B2_IS_NULL ] ---

    /**
     * {@code #define B2_IS_NULL( id ) ( (id).index1 == 0 ) }
     * @param id ConstB2Id
     * @return boolean
     */
    public static boolean B2_IS_NULL(ConstB2Id id) {
        checkPointers(id);
        return nB2_IS_NULL(id);
    }
    
    /* {@code #define B2_IS_NULL( id ) ( (id).index1 == 0 ) } */
    public static boolean nB2_IS_NULL(ConstB2Id id) {
        return id.index1().intValue() == 0;
    }
    
    // --- [ B2_IS_NON_NULL ] ---
    
    /**
     * {@code #define B2_IS_NON_NULL( id ) ( (id).index1 != 0 ) }
     * @param id ConstB2Id
     * @return boolean
     */
    public static boolean B2_IS_NON_NULL(ConstB2Id id) {
        checkPointers(id);
        return nB2_IS_NON_NULL(id);
    }
    
    /* @code #define B2_IS_NON_NULL( id ) ( (id).index1 != 0 ) } */
    public static boolean nB2_IS_NON_NULL(ConstB2Id id) {
        return id.index1().intValue() != 0;
    }

    // --- [ B2_ID_EQUALS ] ---
    
    /**
     * {@code #define B2_ID_EQUALS( id1, id2 ) ( (id1).index1 == (id2).index1 && (id1).world0 == (id2).world0 && (id1).generation == (id2).generation )}
     *
     * @param id1 ConstB2Id.Defaul
     * @param id2 ConstB2Id.Defaul
     * @return boolean
     */
    public static boolean B2_ID_EQUALS(ConstB2Id.Default id1, ConstB2Id.Default id2) {
        checkPointers(id1, id2);
        return nB2_ID_EQUALS(id1, id2);
    }
    /* {@code #define B2_ID_EQUALS( id1, id2 ) ( (id1).index1 == (id2).index1 && (id1).world0 == (id2).world0 && (id1).generation == (id2).generation )} */
    public static boolean nB2_ID_EQUALS(ConstB2Id.Default id1, ConstB2Id.Default id2) {
        return (id1).index1().intValue() == (id2).index1().intValue() && (id1).world0().intValue() == (id2).world0().intValue() && (id1).generation().intValue() == (id2).generation().intValue();
    }
    
    // --- [ b2StoreWorldId ] ---

    /**
     * {@code B2_ID_INLINE uint32_t b2StoreWorldId( b2WorldId id ) }
     *
     * @param id b2WorldId
     * @return int
     */
    public static int b2StoreWorldId(b2WorldId id) {
        checkPointers(id);
        return nb2StoreWorldId(id.address());
    }

    /* {@code B2_ID_INLINE uint32_t b2StoreWorldId( b2WorldId id ) } */
    public static native int nb2StoreWorldId(long id);


    // --- [ b2LoadWorldId ] ---

    /**
     * {@code B2_ID_INLINE b2WorldId b2LoadWorldId( uint32_t x ) }
     *
     * @param x int
     * @param __result store
     * @return b2WorldId
     */
    public static b2WorldId b2LoadWorldId(int x, b2WorldId __result) {
        checkPointers(__result);
        nb2LoadWorldId(x, __result.address());
        return __result;
    }

    /* {@code B2_ID_INLINE b2WorldId b2LoadWorldId( uint32_t x ) } */
    public static native void nb2LoadWorldId(int x, long __result);


    // --- [ b2StoreBodyId ] ---

    /**
     * {@code B2_ID_INLINE uint64_t b2StoreBodyId( b2BodyId id ) }
     *
     * @param id b2BodyId
     * @return long
     */
    public static long b2StoreBodyId(b2BodyId id) {
        checkPointers(id);
        return nb2StoreBodyId(id.address());
    }

    /* {@code B2_ID_INLINE uint64_t b2StoreBodyId( b2BodyId id ) } */
    public static native long nb2StoreBodyId(long id);


    // --- [ b2LoadBodyId ] ---

    /**
     * {@code B2_ID_INLINE b2BodyId b2LoadBodyId( uint64_t x ) }
     *
     * @param x long
     * @param __result store
     * @return b2BodyId
     */
    public static b2BodyId b2LoadBodyId(long x, b2BodyId __result) {
        checkPointers(__result);
        nb2LoadBodyId(x, __result.address());
        return __result;
    }

    /* {@code B2_ID_INLINE b2BodyId b2LoadBodyId( uint64_t x ) } */
    public static native void nb2LoadBodyId(long x, long __result);


    // --- [ b2StoreShapeId ] ---

    /**
     * {@code B2_ID_INLINE uint64_t b2StoreShapeId( b2ShapeId id ) }
     *
     * @param id b2ShapeId
     * @return long
     */
    public static long b2StoreShapeId(b2ShapeId id) {
        checkPointers(id);
        return nb2StoreShapeId(id.address());
    }

    /* {@code B2_ID_INLINE uint64_t b2StoreShapeId( b2ShapeId id ) } */
    public static native long nb2StoreShapeId(long id);


    // --- [ b2LoadShapeId ] ---

    /**
     * {@code B2_ID_INLINE b2ShapeId b2LoadShapeId( uint64_t x ) }
     *
     * @param x long
     * @param __result store
     * @return b2ShapeId
     */
    public static b2ShapeId b2LoadShapeId(long x, b2ShapeId __result) {
        checkPointers(__result);
        nb2LoadShapeId(x, __result.address());
        return __result;
    }

    /* {@code B2_ID_INLINE b2ShapeId b2LoadShapeId( uint64_t x ) } */
    public static native void nb2LoadShapeId(long x, long __result);


    // --- [ b2StoreChainId ] ---

    /**
     * {@code B2_ID_INLINE uint64_t b2StoreChainId( b2ChainId id ) }
     *
     * @param id b2ChainId
     * @return long
     */
    public static long b2StoreChainId(b2ChainId id) {
        checkPointers(id);
        return nb2StoreChainId(id.address());
    }

    /* {@code B2_ID_INLINE uint64_t b2StoreChainId( b2ChainId id ) } */
    public static native long nb2StoreChainId(long id);


    // --- [ b2LoadChainId ] ---

    /**
     * {@code B2_ID_INLINE b2ChainId b2LoadChainId( uint64_t x ) }
     *
     * @param x long
     * @param __result store
     * @return b2ChainId
     */
    public static b2ChainId b2LoadChainId(long x, b2ChainId __result) {
        checkPointers(__result);
        nb2LoadChainId(x, __result.address());
        return __result;
    }

    /* {@code B2_ID_INLINE b2ChainId b2LoadChainId( uint64_t x ) } */
    public static native void nb2LoadChainId(long x, long __result);


    // --- [ b2StoreJointId ] ---

    /**
     * {@code B2_ID_INLINE uint64_t b2StoreJointId( b2JointId id ) }
     *
     * @param id b2JointId
     * @return long
     */
    public static long b2StoreJointId(b2JointId id) {
        checkPointers(id);
        return nb2StoreJointId(id.address());
    }

    /* {@code B2_ID_INLINE uint64_t b2StoreJointId( b2JointId id ) } */
    public static native long nb2StoreJointId(long id);


    // --- [ b2LoadJointId ] ---

    /**
     * {@code B2_ID_INLINE b2JointId b2LoadJointId( uint64_t x ) }
     *
     * @param x long
     * @param __result store
     * @return b2JointId
     */
    public static b2JointId b2LoadJointId(long x, b2JointId __result) {
        checkPointers(__result);
        nb2LoadJointId(x, __result.address());
        return __result;
    }

    /* {@code B2_ID_INLINE b2JointId b2LoadJointId( uint64_t x ) } */
    public static native void nb2LoadJointId(long x, long __result);


    // --- [ b2StoreContactId ] ---

    /**
     * {@code B2_ID_INLINE void b2StoreContactId( b2ContactId id, uint32_t values[3] ) }
     *
     * @param id b2ContactId
     * @param values IntBuffer
     */
    public static void b2StoreContactId(b2ContactId id, IntBuffer values) {
        checkPointers(id);
        checkMinBuffer(values, 3);
        nb2StoreContactId(id.address(), values);
    }

    /* {@code B2_ID_INLINE void b2StoreContactId( b2ContactId id, uint32_t values[3] ) } */
    public static native void nb2StoreContactId(long id, IntBuffer values);


    // --- [ b2LoadContactId ] ---

    /**
     * {@code B2_ID_INLINE b2ContactId b2LoadContactId( uint32_t values[3] ) }
     *
     * @param values IntBuffer
     * @param __result store
     * @return b2ContactId
     */
    public static b2ContactId b2LoadContactId(IntBuffer values, b2ContactId __result) {
        checkPointers(__result);
        checkMinBuffer(values, 3);
        nb2LoadContactId(values, __result.address());
        return __result;
    }

    /* {@code B2_ID_INLINE b2ContactId b2LoadContactId( uint32_t values[3] ) } */
    public static native void nb2LoadContactId(IntBuffer values, long __result);
}
