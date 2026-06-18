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
package org.box2d.jni.include;

import java.nio.FloatBuffer;

import org.box2d.jni.b2AABB;
import org.box2d.jni.b2CosSin;
import org.box2d.jni.b2Mat22;
import org.box2d.jni.b2Plane;
import org.box2d.jni.b2Pos;
import org.box2d.jni.b2Rot;
import org.box2d.jni.b2Transform;
import org.box2d.jni.b2Vec2;
import org.box2d.jni.b2WorldTransform;

import org.box2d.jni.readonly.ConstB2Vec2;

import org.box2d.jni.system.Library;
import static org.box2d.jni.system.Checks.*;

/**
 * Vector math types and functions
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unchecked")
public final class MathFunctions {
    static { Library.initialize(); }

    /**
     * The PI number used by box2d in the native layer.
     */
    public static final float B2_PI = nB2_PI();
    /* Native bindings: {@code #define B2_PI } */
    public static native float nB2_PI();
    
    /** A vector at the origin. */
    public static final b2Vec2 b2Vec2_zero = b2Vec2.malloc().set( 0.0f, 0.0f );
    /** A rotation identity. */
    public static final b2Rot b2Rot_identity = b2Rot.malloc().set( 1.0f, 0.0f );
    /** A transformed identity. */
    public static final b2Transform b2Transform_identity = b2Transform.malloc() ;
    /** A matrix of zeros. */
    public static final b2Mat22 b2Mat22_zero = b2Mat22.malloc();

    /** Native bindings: {@code static const b2Pos b2Pos_zero = { 0.0f, 0.0f };} */
    public static final b2Pos b2Pos_zero = b2Pos.nmalloc().set( 0.0f, 0.0f );
    /** Native bindings: {@code static const b2WorldTransform b2WorldTransform_identity = { { 0.0f, 0.0f }, { 1.0f, 0.0f } };} */
    public static final b2WorldTransform b2WorldTransform_identity = b2WorldTransform.nmalloc();

    static {
        try
        (
            b2Vec2 vtmp = b2Vec2.malloc();
            b2Rot rtmp = b2Rot.malloc()
        ) {
            vtmp.set(0.0f, 0.0f);
            rtmp.set(1.0f, 0.0f);
            b2Transform_identity.set(vtmp, rtmp);
        }
        try
        (
            b2Vec2 vtmp0 = b2Vec2.malloc();
            b2Vec2 vtmp1 = b2Vec2.malloc()
        ) {
            vtmp0.set(0.0f, 0.0f);
            vtmp1.set(0.0f, 0.0f);
            b2Mat22_zero.set(vtmp0, vtmp1);
        }
        try
        (
            b2Pos vtmp = b2Pos.nmalloc();
            b2Rot rtmp = b2Rot.malloc()
        ) {
            vtmp.set(0.0f, 0.0f);
            rtmp.set(1.0f, 0.0f);
            b2WorldTransform_identity.set(vtmp, rtmp);
        }
    }

    // --- [ b2IsValidFloat ] ---
    
    /**
     * {@code B2_API bool b2IsValidFloat( float a ); }
     *
     * @param a float
     * @return boolean
     */
    public static boolean b2IsValidFloat( float a ) {
        return nb2IsValidFloat(a);
    }
    /* {@code B2_API bool b2IsValidFloat( float a ); } */
    public static native boolean nb2IsValidFloat( float a );
    

    // --- [ b2IsValidVec2 ] ---

    /**
     * {@code B2_API bool b2IsValidVec2( b2Vec2 v ); }
     * 
     * @param v b2Vec2
     * @return boolean
     */
    public static boolean b2IsValidVec2( b2Vec2 v ) {
        checkPointers(v);
        return nb2IsValidVec2(v.address());
    }
    /* {@code B2_API bool b2IsValidVec2( b2Vec2 v ); } */
    public static native boolean nb2IsValidVec2( long v );

    // --- [ b2IsValidRotation ] ---
    
    /**
     * {@code b2IsValidRotation( b2Rot q ); }
     * 
     * @param q b2Rot
     * @return boolean
     */
    public static boolean b2IsValidRotation( b2Rot q ) {
        checkPointers(q);
        return nb2IsValidRotation(q.address());
    }
    /* {@code b2IsValidRotation( b2Rot q ); } */
    public static native boolean nb2IsValidRotation(long q);

    // --- [ b2IsValidTransform ] ---
    /**
     * {@code b2IsValidTransform( b2Transform t ); }
     * @param t b2Transform
     * @return boolean
     */
    public static boolean b2IsValidTransform( b2Transform t ) {
        checkPointers(t);
        return nb2IsValidTransform(t.address());
    }
    /* {@code b2IsValidTransform( b2Transform t ); } */
    public static native boolean nb2IsValidTransform(long t);

    // --- [ b2IsValidAABB ] ---
    /**
     * {@code b2IsValidAABB( b2AABB aabb );}
     * @param aabb b2AABB
     * @return boolean
     */
    public static boolean b2IsValidAABB( b2AABB aabb ) {
        checkPointers(aabb);
        return nb2IsValidAABB(aabb.address());
    }
    public static native boolean nb2IsValidAABB( long aabb );

    // --- [ b2IsValidPlane ] ---

    /**
     * {@code b2IsValidPlane( b2Plane a ); }
     *
     * @param a b2Plane
     * @return boolean
     */
    public static boolean b2IsValidPlane(b2Plane a) {
        checkPointers(a);
        return n2IsValidPlane(a.address());
    }

    /* {@code b2IsValidPlane( b2Plane a ); } */
    public static native boolean n2IsValidPlane(long a);

    // --- [ b2IsValidPosition ] ---
    /**
     * {@code b2IsValidPosition( b2Pos p );}
     *
     * @param p b2Pos
     * @return boolean
     */
    public static boolean b2IsValidPosition(b2Pos p) {
        checkPointers(p);
        return nb2IsValidPosition(p.address());
    }
    /* {@code b2IsValidPosition( b2Pos p );} */
    public static native boolean nb2IsValidPosition(long p);

    // --- [ b2IsValidWorldTransform ] ---

    /**
     * {@code b2IsValidWorldTransform( b2WorldTransform t );}
     *
     * @param t b2WorldTransform
     * @return boolean
     */
    public static boolean b2IsValidWorldTransform(b2WorldTransform t) {
        checkPointers(t);
        return nb2IsValidWorldTransform(t.address());
    }
    /* {@code b2IsValidWorldTransform( b2WorldTransform t );} */
    public static native boolean nb2IsValidWorldTransform(long t);

    // --- [ b2MinInt ] ---

    /**
     * {@code b2MinInt( int a, int b )}
     *
     * @param a int
     * @param b int
     * @return int
     */
    public static int b2MinInt(int a, int b) {
        return nb2MinInt(a, b);
    }

    /* {@code b2MinInt( int a, int b )} */
    public static native int nb2MinInt(int a, int b);


    // --- [ b2MaxInt ] ---

    /**
     * {@code b2MaxInt( int a, int b )}
     *
     * @param a int
     * @param b int
     * @return int
     */
    public static int b2MaxInt(int a, int b) {
        return nb2MaxInt(a, b);
    }

    /* {@code b2MaxInt( int a, int b )} */
    public static native int nb2MaxInt(int a, int b);


    // --- [ b2AbsInt ] ---

    /**
     * {@code b2AbsInt( int a )}
     *
     * @param a int
     * @return int
     */
    public static int b2AbsInt(int a) {
        return nb2AbsInt(a);
    }

    /* {@code b2AbsInt( int a )} */
    public static native int nb2AbsInt(int a);


    // --- [ b2ClampInt ] ---

    /**
     * {@code b2ClampInt( int a, int lower, int upper )}
     *
     * @param a int
     * @param lower int
     * @param upper int
     * @return int
     */
    public static int b2ClampInt(int a, int lower, int upper) {
        return nb2ClampInt(a, lower, upper);
    }

    /* {@code b2ClampInt( int a, int lower, int upper )} */
    public static native int nb2ClampInt(int a, int lower, int upper);
    
    // --- [ b2CeilingInt ] ---

    /**
     * {@code B2_INLINE int b2CeilingInt( int numerator, int denominator )}
     *
     * @param numerator int
     * @param denominator int
     * @return int
     */
    public static int b2CeilingInt(int numerator, int denominator) {
        return nb2CeilingInt(numerator, denominator);
    }

    /* {@code B2_INLINE int b2CeilingInt( int numerator, int denominator )} */
    public static native int nb2CeilingInt(int numerator, int denominator);


    // --- [ b2MinFloat ] ---

    /**
     * {@code B2_INLINE float b2MinFloat( float a, float b )}
     *
     * @param a float
     * @param b float
     * @return float
     */
    public static float b2MinFloat(float a, float b) {
        return nb2MinFloat(a, b);
    }

    /* {@code B2_INLINE float b2MinFloat( float a, float b )} */
    public static native float nb2MinFloat(float a, float b);


    // --- [ b2MaxFloat ] ---

    /**
     * {@code B2_INLINE float b2MaxFloat( float a, float b )}
     *
     * @param a float
     * @param b float
     * @return float
     */
    public static float b2MaxFloat(float a, float b) {
        return nb2MaxFloat(a, b);
    }

    /* {@code B2_INLINE float b2MaxFloat( float a, float b )} */
    public static native float nb2MaxFloat(float a, float b);


    // --- [ b2AbsFloat ] ---

    /**
     * {@code B2_INLINE float b2AbsFloat( float a )}
     *
     * @param a float
     * @return float
     */
    public static float b2AbsFloat(float a) {
        return nb2AbsFloat(a);
    }

    /* {@code B2_INLINE float b2AbsFloat( float a )} */
    public static native float nb2AbsFloat(float a);


    // --- [ b2ClampFloat ] ---

    /**
     * {@code B2_INLINE float b2ClampFloat( float a, float lower, float upper )}
     *
     * @param a float
     * @param lower float
     * @param upper float
     * @return float
     */
    public static float b2ClampFloat(float a, float lower, float upper) {
        return nb2ClampFloat(a, lower, upper);
    }

    /* {@code B2_INLINE float b2ClampFloat( float a, float lower, float upper )} */
    public static native float nb2ClampFloat(float a, float lower, float upper);


    // --- [ b2Atan2 ] ---

    /**
     * {@code B2_API float b2Atan2( float y, float x ); }
     *
     * @param y float
     * @param x float
     * @return float
     */
    public static float b2Atan2(float y, float x) {
        return nb2Atan2(y, x);
    }

    /* {@code B2_API float b2Atan2( float y, float x ); } */
    public static native float nb2Atan2(float y, float x);


    // --- [ b2ComputeCosSin ] ---

    /**
     * {@code B2_API b2CosSin b2ComputeCosSin( float radians ); }
     *
     * @param radians float
     * @param __result b2CosSin
     * @return b2CosSin
     */
    public static b2CosSin b2ComputeCosSin(float radians, b2CosSin __result) {
        checkPointers(__result);
        nb2ComputeCosSin(radians, __result.address());
        return __result;
    }

    /* {@code B2_API b2CosSin b2ComputeCosSin( float radians ); } */
    public static native void nb2ComputeCosSin(float radians, long __result);


    // --- [ b2Dot ] ---

    /**
     * {@code B2_INLINE float b2Dot( b2Vec2 a, b2Vec2 b )}
     *
     * @param a b2Vec2
     * @param b b2Vec2
     * @return float
     */
    public static float b2Dot(b2Vec2 a, b2Vec2 b) {
        checkPointers(a, b);
        return nb2Dot(a.address(), b.address());
    }

    /* {@code B2_INLINE float b2Dot( b2Vec2 a, b2Vec2 b )} */
    public static native float nb2Dot(long a, long b);

    // --- [ b2Cross ] ---

    /**
     * {@code B2_INLINE float b2Cross( b2Vec2 a, b2Vec2 b )}
     *
     * @param a b2Vec2
     * @param b b2Vec2
     * @return float
     */
    public static float b2Cross(b2Vec2 a, b2Vec2 b) {
        checkPointers(a, b);
        return nb2Cross(a.address(), b.address());
    }

    /* {@code B2_INLINE float b2Cross( b2Vec2 a, b2Vec2 b )} */
    public static native float nb2Cross(long a, long b);


    // --- [ b2CrossVS ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2CrossVS( b2Vec2 v, float s )}
     *
     * @param v b2Vec2
     * @param s float
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2CrossVS(b2Vec2 v, float s, b2Vec2 __result) {
        checkPointers(v, __result);
        nb2CrossVS(v.address(), s, __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2CrossVS( b2Vec2 v, float s )} */
    public static native void nb2CrossVS(long v, float s, long __result);


    // --- [ b2CrossSV ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2CrossSV( float s, b2Vec2 v )}
     *
     * @param s float
     * @param v b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2CrossSV(float s, b2Vec2 v, b2Vec2 __result) {
        checkPointers(v, __result);
        nb2CrossSV(s, v.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2CrossSV( float s, b2Vec2 v )} */
    public static native void nb2CrossSV(float s, long v, long __result);


    // --- [ b2LeftPerp ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2LeftPerp( b2Vec2 v )}
     *
     * @param v b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2LeftPerp(b2Vec2 v, b2Vec2 __result) {
        checkPointers(v, __result);
        nb2LeftPerp(v.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2LeftPerp( b2Vec2 v )} */
    public static native void nb2LeftPerp(long v, long __result);


    // --- [ b2RightPerp ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2RightPerp( b2Vec2 v )}
     *
     * @param v b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2RightPerp(b2Vec2 v, b2Vec2 __result) {
        checkPointers(v, __result);
        nb2RightPerp(v.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2RightPerp( b2Vec2 v )} */
    public static native void nb2RightPerp(long v, long __result);


    // --- [ b2Add ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2Add( b2Vec2 a, b2Vec2 b )}
     *
     * @param a b2Vec2
     * @param b b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2Add(b2Vec2 a, b2Vec2 b, b2Vec2 __result) {
        checkPointers(a, b, __result);
        nb2Add(a.address(), b.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2Add( b2Vec2 a, b2Vec2 b )} */
    public static native void nb2Add(long a, long b, long __result);


    // --- [ b2Sub ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2Sub( b2Vec2 a, b2Vec2 b )}
     *
     * @param a b2Vec2
     * @param b b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2Sub(b2Vec2 a, b2Vec2 b, b2Vec2 __result) {
        checkPointers(a, b, __result);
        nb2Sub(a.address(), b.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2Sub( b2Vec2 a, b2Vec2 b )} */
    public static native void nb2Sub(long a, long b, long __result);

    // --- [ b2Neg ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2Neg( b2Vec2 a )}
     *
     * @param a b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2Neg(b2Vec2 a, b2Vec2 __result) {
        checkPointers(a, __result);
        nb2Neg(a.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2Neg( b2Vec2 a )} */
    public static native void nb2Neg(long a, long __result);


    // --- [ b2Lerp ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2Lerp( b2Vec2 a, b2Vec2 b, float t )}
     *
     * @param a b2Vec2
     * @param b b2Vec2
     * @param t float
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2Lerp(b2Vec2 a, b2Vec2 b, float t, b2Vec2 __result) {
        checkPointers(a, b, __result);
        nb2Lerp(a.address(), b.address(), t, __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2Lerp( b2Vec2 a, b2Vec2 b, float t )} */
    public static native void nb2Lerp(long a, long b, float t, long __result);


    // --- [ b2Mul ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2Mul( b2Vec2 a, b2Vec2 b )}
     *
     * @param a b2Vec2
     * @param b b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2Mul(b2Vec2 a, b2Vec2 b, b2Vec2 __result) {
        checkPointers(a, b, __result);
        nb2Mul(a.address(), b.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2Mul( b2Vec2 a, b2Vec2 b )} */
    public static native void nb2Mul(long a, long b, long __result);


    // --- [ b2MulSV ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2MulSV( float s, b2Vec2 v )}
     *
     * @param s float
     * @param v b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2MulSV(float s, b2Vec2 v, b2Vec2 __result) {
        checkPointers(v, __result);
        nb2MulSV(s, v.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2MulSV( float s, b2Vec2 v )} */
    public static native void nb2MulSV(float s, long v, long __result);


    // --- [ b2MulAdd ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2MulAdd( b2Vec2 a, float s, b2Vec2 b )}
     *
     * @param a b2Vec2
     * @param s float
     * @param b b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2MulAdd(b2Vec2 a, float s, b2Vec2 b, b2Vec2 __result) {
        checkPointers(a, b, __result);
        nb2MulAdd(a.address(), s, b.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2MulAdd( b2Vec2 a, float s, b2Vec2 b )} */
    public static native void nb2MulAdd(long a, float s, long b, long __result);


    // --- [ b2MulSub ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2MulSub( b2Vec2 a, float s, b2Vec2 b )}
     *
     * @param a b2Vec2
     * @param s float
     * @param b b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2MulSub(b2Vec2 a, float s, b2Vec2 b, b2Vec2 __result) {
        checkPointers(a, b, __result);
        nb2MulSub(a.address(), s, b.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2MulSub( b2Vec2 a, float s, b2Vec2 b )} */
    public static native void nb2MulSub(long a, float s, long b, long __result);


    // --- [ b2Abs ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2Abs( b2Vec2 a )}
     *
     * @param a b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2Abs(b2Vec2 a, b2Vec2 __result) {
        checkPointers(a, __result);
        nb2Abs(a.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2Abs( b2Vec2 a )} */
    public static native void nb2Abs(long a, long __result);


    // --- [ b2Min ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2Min( b2Vec2 a, b2Vec2 b )}
     *
     * @param a b2Vec2
     * @param b b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2Min(b2Vec2 a, b2Vec2 b, b2Vec2 __result) {
        checkPointers(a, b, __result);
        nb2Min(a.address(), b.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2Min( b2Vec2 a, b2Vec2 b )} */
    public static native void nb2Min(long a, long b, long __result);


    // --- [ b2Max ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2Max( b2Vec2 a, b2Vec2 b )}
     *
     * @param a b2Vec2
     * @param b b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2Max(b2Vec2 a, b2Vec2 b, b2Vec2 __result) {
        checkPointers(a, b, __result);
        nb2Max(a.address(), b.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2Max( b2Vec2 a, b2Vec2 b )} */
    public static native void nb2Max(long a, long b, long __result);

    // --- [ b2Clamp ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2Clamp( b2Vec2 v, b2Vec2 a, b2Vec2 b )}
     *
     * @param v b2Vec2
     * @param a b2Vec2
     * @param b b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2Clamp(b2Vec2 v, b2Vec2 a, b2Vec2 b, b2Vec2 __result) {
        checkPointers(v, a, b, __result);
        nb2Clamp(v.address(), a.address(), b.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2Clamp( b2Vec2 v, b2Vec2 a, b2Vec2 b )} */
    public static native void nb2Clamp(long v, long a, long b, long __result);

    // --- [ b2Length ] ---

    /**
     * {@code B2_INLINE float b2Length( b2Vec2 v )}
     *
     * @param v b2Vec2
     * @return float
     */
    public static float b2Length(b2Vec2 v) {
        checkPointers(v);
        return nb2Length(v.address());
    }

    /* {@code B2_INLINE float b2Length( b2Vec2 v )} */
    public static native float nb2Length(long v);


    // --- [ b2Distance ] ---

    /**
     * {@code B2_INLINE float b2Distance( b2Vec2 a, b2Vec2 b )}
     *
     * @param a b2Vec2
     * @param b b2Vec2
     * @return float
     */
    public static float b2Distance(b2Vec2 a, b2Vec2 b) {
        checkPointers(a, b);
        return nb2Distance(a.address(), b.address());
    }

    /* {@code B2_INLINE float b2Distance( b2Vec2 a, b2Vec2 b )} */
    public static native float nb2Distance(long a, long b);


    // --- [ b2Normalize ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2Normalize( b2Vec2 v )}
     *
     * @param v b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2Normalize(b2Vec2 v, b2Vec2 __result) {
        checkPointers(v, __result);
        nb2Normalize(v.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2Normalize( b2Vec2 v )} */
    public static native void nb2Normalize(long v, long __result);


    // --- [ b2IsNormalized ] ---

    /**
     * {@code B2_INLINE bool b2IsNormalized( b2Vec2 a )}
     *
     * @param a b2Vec2
     * @return boolean
     */
    public static boolean b2IsNormalized(b2Vec2 a) {
        checkPointers(a);
        return nb2IsNormalized(a.address());
    }

    /* {@code B2_INLINE bool b2IsNormalized( b2Vec2 a )} */
    public static native boolean nb2IsNormalized(long a);


    // --- [ b2GetLengthAndNormalize ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2GetLengthAndNormalize( float* length, b2Vec2 v )}
     *
     * @param length FloatBuffer
     * @param v b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2GetLengthAndNormalize(FloatBuffer length, b2Vec2 v, b2Vec2 __result) {
        checkPointers(v, __result);
        nb2GetLengthAndNormalize(length, v.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2GetLengthAndNormalize( float* length, b2Vec2 v )} */
    public static native void nb2GetLengthAndNormalize(FloatBuffer length, long v, long __result);


    // --- [ b2NormalizeRot ] ---

    /**
     * {@code B2_INLINE b2Rot b2NormalizeRot( b2Rot q )}
     *
     * @param q b2Rot
     * @param __result b2Rot
     * @return b2Rot
     */
    public static b2Rot b2NormalizeRot(b2Rot q, b2Rot __result) {
        checkPointers(q, __result);
        nb2NormalizeRot(q.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Rot b2NormalizeRot( b2Rot q )} */
    public static native void nb2NormalizeRot(long q, long __result);


    // --- [ b2IntegrateRotation ] ---

    /**
     * {@code B2_INLINE b2Rot b2IntegrateRotation( b2Rot q1, float deltaAngle )}
     *
     * @param q1 b2Rot
     * @param deltaAngle float
     * @param __result b2Rot
     * @return b2Rot
     */
    public static b2Rot b2IntegrateRotation(b2Rot q1, float deltaAngle, b2Rot __result) {
        checkPointers(q1, __result);
        nb2IntegrateRotation(q1.address(), deltaAngle, __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Rot b2IntegrateRotation( b2Rot q1, float deltaAngle )} */
    public static native void nb2IntegrateRotation(long q1, float deltaAngle, long __result);


    // --- [ b2LengthSquared ] ---

    /**
     * {@code B2_INLINE float b2LengthSquared( b2Vec2 v )}
     *
     * @param v b2Vec2
     * @return float
     */
    public static float b2LengthSquared(b2Vec2 v) {
        checkPointers(v);
        return nb2LengthSquared(v.address());
    }

    /* {@code B2_INLINE float b2LengthSquared( b2Vec2 v )} */
    public static native float nb2LengthSquared(long v);


    // --- [ b2DistanceSquared ] ---

    /**
     * {@code B2_INLINE float b2DistanceSquared( b2Vec2 a, b2Vec2 b )}
     *
     * @param a b2Vec2
     * @param b b2Vec2
     * @return float
     */
    public static float b2DistanceSquared(b2Vec2 a, b2Vec2 b) {
        checkPointers(a, b);
        return nb2DistanceSquared(a.address(), b.address());
    }

    /* {@code B2_INLINE float b2DistanceSquared( b2Vec2 a, b2Vec2 b )} */
    public static native float nb2DistanceSquared(long a, long b);


    // --- [ b2MakeRot ] ---

    /**
     * {@code B2_INLINE b2Rot b2MakeRot( float radians )}
     *
     * @param radians float
     * @param __result b2Rot
     * @return b2Rot
     */
    public static b2Rot b2MakeRot(float radians, b2Rot __result) {
        checkPointers(__result);
        nb2MakeRot(radians, __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Rot b2MakeRot( float radians )} */
    public static native void nb2MakeRot(float radians, long __result);


    // --- [ b2MakeRotFromUnitVector ] ---

    /**
     * {@code B2_INLINE b2Rot b2MakeRotFromUnitVector( b2Vec2 unitVector )}
     *
     * @param unitVector b2Vec2
     * @param __result b2Rot
     * @return b2Rot
     */
    public static b2Rot b2MakeRotFromUnitVector(b2Vec2 unitVector, b2Rot __result) {
        checkPointers(unitVector, __result);
        nb2MakeRotFromUnitVector(unitVector.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Rot b2MakeRotFromUnitVector( b2Vec2 unitVector )} */
    public static native void nb2MakeRotFromUnitVector(long unitVector, long __result);


    // --- [ b2ComputeRotationBetweenUnitVectors ] ---

    /**
     * {@code B2_API b2Rot b2ComputeRotationBetweenUnitVectors( b2Vec2 v1, b2Vec2 v2 ); }
     *
     * @param v1 b2Vec2
     * @param v2 b2Vec2
     * @param __result b2Rot
     * @return b2Rot
     */
    public static b2Rot b2ComputeRotationBetweenUnitVectors(b2Vec2 v1, b2Vec2 v2, b2Rot __result) {
        checkPointers(v1, v2, __result);
        nb2ComputeRotationBetweenUnitVectors(v1.address(), v2.address(), __result.address());
        return __result;
    }

    /* {@code B2_API b2Rot b2ComputeRotationBetweenUnitVectors( b2Vec2 v1, b2Vec2 v2 ); } */
    public static native void nb2ComputeRotationBetweenUnitVectors(long v1, long v2, long __result);


    // --- [ b2IsNormalizedRot ] ---

    /**
     * {@code B2_INLINE bool b2IsNormalizedRot( b2Rot q )}
     *
     * @param q b2Rot
     * @return boolean
     */
    public static boolean b2IsNormalizedRot(b2Rot q) {
        checkPointers(q);
        return nb2IsNormalizedRot(q.address());
    }

    /* {@code B2_INLINE bool b2IsNormalizedRot( b2Rot q )} */
    public static native boolean nb2IsNormalizedRot(long q);


    // --- [ b2InvertRot ] ---

    /**
     * {@code B2_INLINE b2Rot b2InvertRot( b2Rot a )}
     *
     * @param a b2Rot
     * @param __result b2Rot
     * @return b2Rot
     */
    public static b2Rot b2InvertRot(b2Rot a, b2Rot __result) {
        checkPointers(a, __result);
        nb2InvertRot(a.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Rot b2InvertRot( b2Rot a )} */
    public static native void nb2InvertRot(long a, long __result);


    // --- [ b2NLerp ] ---

    /**
     * {@code B2_INLINE b2Rot b2NLerp( b2Rot q1, b2Rot q2, float t )}
     *
     * @param q1 b2Rot
     * @param q2 b2Rot
     * @param t float
     * @param __result b2Rot
     * @return b2Rot
     */
    public static b2Rot b2NLerp(b2Rot q1, b2Rot q2, float t, b2Rot __result) {
        checkPointers(q1, q2, __result);
        nb2NLerp(q1.address(), q2.address(), t, __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Rot b2NLerp( b2Rot q1, b2Rot q2, float t )} */
    public static native void nb2NLerp(long q1, long q2, float t, long __result);


    // --- [ b2ComputeAngularVelocity ] ---

    /**
     * {@code B2_INLINE float b2ComputeAngularVelocity( b2Rot q1, b2Rot q2, float inv_h )}
     *
     * @param q1 b2Rot
     * @param q2 b2Rot
     * @param inv_h float
     * @return float
     */
    public static float b2ComputeAngularVelocity(b2Rot q1, b2Rot q2, float inv_h) {
        checkPointers(q1, q2);
        return nb2ComputeAngularVelocity(q1.address(), q2.address(), inv_h);
    }

    /* {@code B2_INLINE float b2ComputeAngularVelocity( b2Rot q1, b2Rot q2, float inv_h )} */
    public static native float nb2ComputeAngularVelocity(long q1, long q2, float inv_h);


    // --- [ b2Rot_GetAngle ] ---

    /**
     * {@code B2_INLINE float b2Rot_GetAngle( b2Rot q )}
     *
     * @param q b2Rot
     * @return float
     */
    public static float b2Rot_GetAngle(b2Rot q) {
        checkPointers(q);
        return nb2Rot_GetAngle(q.address());
    }

    /* {@code B2_INLINE float b2Rot_GetAngle( b2Rot q )} */
    public static native float nb2Rot_GetAngle(long q);


    // --- [ b2Rot_GetXAxis ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2Rot_GetXAxis( b2Rot q )}
     *
     * @param q b2Rot
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2Rot_GetXAxis(b2Rot q, b2Vec2 __result) {
        checkPointers(q, __result);
        nb2Rot_GetXAxis(q.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2Rot_GetXAxis( b2Rot q )} */
    public static native void nb2Rot_GetXAxis(long q, long __result);


    // --- [ b2Rot_GetYAxis ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2Rot_GetYAxis( b2Rot q )}
     *
     * @param q b2Rot
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2Rot_GetYAxis(b2Rot q, b2Vec2 __result) {
        checkPointers(q, __result);
        nb2Rot_GetYAxis(q.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2Rot_GetYAxis( b2Rot q )} */
    public static native void nb2Rot_GetYAxis(long q, long __result);

    
    // --- [ b2MulRot ] ---

    /**
     * {@code B2_INLINE b2Rot b2MulRot( b2Rot q, b2Rot r )}
     *
     * @param q b2Rot
     * @param r b2Rot
     * @param __result b2Rot
     * @return b2Rot
     */
    public static b2Rot b2MulRot(b2Rot q, b2Rot r, b2Rot __result) {
        checkPointers(q, r, __result);
        nb2MulRot(q.address(), r.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Rot b2MulRot( b2Rot q, b2Rot r )} */
    public static native void nb2MulRot(long q, long r, long __result);


    // --- [ b2InvMulRot ] ---

    /**
     * {@code B2_INLINE b2Rot b2InvMulRot( b2Rot a, b2Rot b )}
     *
     * @param a b2Rot
     * @param b b2Rot
     * @param __result b2Rot
     * @return b2Rot
     */
    public static b2Rot b2InvMulRot(b2Rot a, b2Rot b, b2Rot __result) {
        checkPointers(a, b, __result);
        nb2InvMulRot(a.address(), b.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Rot b2InvMulRot( b2Rot a, b2Rot b )} */
    public static native void nb2InvMulRot(long a, long b, long __result);


    // --- [ b2RelativeAngle ] ---

    /**
     * {@code B2_INLINE float b2RelativeAngle( b2Rot a, b2Rot b )}
     *
     * @param a b2Rot
     * @param b b2Rot
     * @return float
     */
    public static float b2RelativeAngle(b2Rot a, b2Rot b) {
        checkPointers(a, b);
        return nb2RelativeAngle(a.address(), b.address());
    }

    /* {@code B2_INLINE float b2RelativeAngle( b2Rot a, b2Rot b )} */
    public static native float nb2RelativeAngle(long a, long b);


    // --- [ b2UnwindAngle ] ---

    /**
     * {@code B2_INLINE float b2UnwindAngle( float radians )}
     *
     * @param radians float
     * @return float
     */
    public static float b2UnwindAngle(float radians) {
        return nb2UnwindAngle(radians);
    }

    /* {@code B2_INLINE float b2UnwindAngle( float radians )} */
    public static native float nb2UnwindAngle(float radians);


    // --- [ b2RotateVector ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2RotateVector( b2Rot q, b2Vec2 v )}
     *
     * @param q b2Rot
     * @param v b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2RotateVector(b2Rot q, b2Vec2 v, b2Vec2 __result) {
        checkPointers(q, v, __result);
        nb2RotateVector(q.address(), v.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2RotateVector( b2Rot q, b2Vec2 v )} */
    public static native void nb2RotateVector(long q, long v, long __result);


    // --- [ b2InvRotateVector ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2InvRotateVector( b2Rot q, b2Vec2 v )}
     *
     * @param q b2Rot
     * @param v b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2InvRotateVector(b2Rot q, b2Vec2 v, b2Vec2 __result) {
        checkPointers(q, v, __result);
        nb2InvRotateVector(q.address(), v.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2InvRotateVector( b2Rot q, b2Vec2 v )} */
    public static native void nb2InvRotateVector(long q, long v, long __result);


    // --- [ b2TransformPoint ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2TransformPoint( b2Transform t, const b2Vec2 p )}
     *
     * @param t b2Transform
     * @param p b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2TransformPoint(b2Transform t, ConstB2Vec2 p, b2Vec2 __result) {
        checkPointers(t, p, __result);
        nb2TransformPoint(t.address(), p.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2TransformPoint( b2Transform t, const b2Vec2 p )} */
    public static native void nb2TransformPoint(long t, long p, long __result);


    // --- [ b2InvTransformPoint ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2InvTransformPoint( b2Transform t, const b2Vec2 p )}
     *
     * @param t b2Transform
     * @param p b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2InvTransformPoint(b2Transform t, ConstB2Vec2 p, b2Vec2 __result) {
        checkPointers(t, p, __result);
        nb2InvTransformPoint(t.address(), p.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2InvTransformPoint( b2Transform t, const b2Vec2 p )} */
    public static native void nb2InvTransformPoint(long t, long p, long __result);


    // --- [ b2MulTransforms ] ---

    /**
     * {@code B2_INLINE b2Transform b2MulTransforms( b2Transform A, b2Transform B )}
     *
     * @param A b2Transform
     * @param B b2Transform
     * @param __result b2Transform
     * @return b2Transform
     */
    public static b2Transform b2MulTransforms(b2Transform A, b2Transform B, b2Transform __result) {
        checkPointers(A, B, __result);
        nb2MulTransforms(A.address(), B.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Transform b2MulTransforms( b2Transform A, b2Transform B )} */
    public static native void nb2MulTransforms(long A, long B, long __result);


    // --- [ b2InvMulTransforms ] ---

    /**
     * {@code B2_INLINE b2Transform b2InvMulTransforms( b2Transform A, b2Transform B )}
     *
     * @param A b2Transform
     * @param B b2Transform
     * @param __result b2Transform
     * @return b2Transform
     */
    public static b2Transform b2InvMulTransforms(b2Transform A, b2Transform B, b2Transform __result) {
        checkPointers(A, B, __result);
        nb2InvMulTransforms(A.address(), B.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Transform b2InvMulTransforms( b2Transform A, b2Transform B )} */
    public static native void nb2InvMulTransforms(long A, long B, long __result);

    // --- [ b2ToPos ] ---

    /**
     * {@code B2_INLINE b2Pos b2ToPos( b2Vec2 v )}
     *
     * @param v b2Vec2
     * @param __result b2Pos
     * @return b2Pos
     */
    public static b2Pos b2ToPos(b2Vec2 v, b2Pos __result) {
        checkPointers(v, __result);
        nb2ToPos(v.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Pos b2ToPos( b2Vec2 v )} */
    public static native void nb2ToPos(long v, long __result);

    // --- [ b2ToVec2 ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2ToVec2( b2Pos p )}
     *
     * @param p b2Pos
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2ToVec2(b2Pos p, b2Vec2 __result) {
        checkPointers(p, __result);
        nb2ToVec2(p.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2ToVec2( b2Pos p )} */
    public static native void nb2ToVec2(long p, long __result);

    // --- [ b2RoundDownFloat ] ---

    /**
     * {@code B2_INLINE float b2RoundDownFloat( double x )}
     *
     * @param x double
     * @return float
     */
    public static float b2RoundDownFloat(double x) {
        return nb2RoundDownFloat(x);
    }

    /* {@code B2_INLINE float b2RoundDownFloat( double x )} */
    public static native float nb2RoundDownFloat(double x);

    // --- [ b2RoundUpFloat ] ---

    /**
     * {@code B2_INLINE float b2RoundUpFloat( double x )}
     *
     * @param x double
     * @return float
     */
    public static float b2RoundUpFloat(double x) {
        return nb2RoundUpFloat(x);
    }

    /* {@code B2_INLINE float b2RoundUpFloat( double x )} */
    public static native float nb2RoundUpFloat(double x);

    // --- [ b2SubPos ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2SubPos( b2Pos a, b2Pos b )}
     *
     * @param a b2Pos
     * @param b b2Pos
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2SubPos(b2Pos a, b2Pos b, b2Vec2 __result) {
        checkPointers(a, b, __result);
        nb2SubPos(a.address(), b.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2SubPos( b2Pos a, b2Pos b )} */
    public static native void nb2SubPos(long a, long b, long __result);

    // --- [ b2OffsetPos ] ---

    /**
     * {@code B2_INLINE b2Pos b2OffsetPos( b2Pos p, b2Vec2 d )}
     *
     * @param p b2Pos
     * @param d b2Vec2
     * @param __result b2Pos
     * @return b2Pos
     */
    public static b2Pos b2OffsetPos(b2Pos p, b2Vec2 d, b2Pos __result) {
        checkPointers(p, d, __result);
        nb2OffsetPos(p.address(), d.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Pos b2OffsetPos( b2Pos p, b2Vec2 d )} */
    public static native void nb2OffsetPos(long p, long d, long __result);

    // --- [ b2LerpPosition ] ---

    /**
     * {@code B2_INLINE b2Pos b2LerpPosition( b2Pos a, b2Pos b, float t )}
     *
     * @param a b2Pos
     * @param b b2Pos
     * @param t float
     * @param __result b2Pos
     * @return b2Pos
     */
    public static b2Pos b2LerpPosition(b2Pos a, b2Pos b, float t, b2Pos __result) {
        checkPointers(a, b, __result);
        nb2LerpPosition(a.address(), b.address(), t, __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Pos b2LerpPosition( b2Pos a, b2Pos b, float t )} */
    public static native void nb2LerpPosition(long a, long b, float t, long __result);

    // --- [ b2TransformWorldPoint ] ---

    /**
     * {@code B2_INLINE b2Pos b2TransformWorldPoint( b2WorldTransform t, b2Vec2 p )}
     *
     * @param t b2WorldTransform
     * @param p b2Vec2
     * @param __result b2Pos
     * @return b2Pos
     */
    public static b2Pos b2TransformWorldPoint(b2WorldTransform t, b2Vec2 p, b2Pos __result) {
        checkPointers(t, p, __result);
        nb2TransformWorldPoint(t.address(), p.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Pos b2TransformWorldPoint( b2WorldTransform t, b2Vec2 p )} */
    public static native void nb2TransformWorldPoint(long t, long p, long __result);

    // --- [ b2InvTransformWorldPoint ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2InvTransformWorldPoint( b2WorldTransform t, b2Pos p )}
     *
     * @param t b2WorldTransform
     * @param p b2Pos
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2InvTransformWorldPoint(b2WorldTransform t, b2Pos p, b2Vec2 __result) {
        checkPointers(t, p, __result);
        nb2InvTransformWorldPoint(t.address(), p.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2InvTransformWorldPoint( b2WorldTransform t, b2Pos p )} */
    public static native void nb2InvTransformWorldPoint(long t, long p, long __result);

    // --- [ b2InvMulWorldTransforms ] ---

    /**
     * {@code B2_INLINE b2Transform b2InvMulWorldTransforms( b2WorldTransform A, b2WorldTransform B )}
     *
     * @param A b2WorldTransform
     * @param B b2WorldTransform
     * @param __result b2Transform
     * @return b2Transform
     */
    public static b2Transform b2InvMulWorldTransforms(b2WorldTransform A, b2WorldTransform B, b2Transform __result) {
        checkPointers(A, B, __result);
        nb2InvMulWorldTransforms(A.address(), B.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Transform b2InvMulWorldTransforms( b2WorldTransform A, b2WorldTransform B )} */
    public static native void nb2InvMulWorldTransforms(long A, long B, long __result);

    // --- [ b2OffsetWorldTransform ] ---

    /**
     * {@code B2_INLINE b2WorldTransform b2OffsetWorldTransform( b2WorldTransform A, b2Transform B ); }
     *
     * @param A b2WorldTransform
     * @param B b2Transform
     * @param __result store
     *
     * @return b2WorldTransform
     */
    public static b2WorldTransform b2OffsetWorldTransform(b2WorldTransform A, b2Transform B, b2WorldTransform __result) {
        checkPointers(A, B, __result);
        nb2OffsetWorldTransform(A.address(), B.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2WorldTransform b2OffsetWorldTransform( b2WorldTransform A, b2Transform B ); } */
    public static native void nb2OffsetWorldTransform(long A, long B, long __result);

    // --- [ b2ToRelativeTransform ] ---

    /**
     * {@code B2_INLINE b2Transform b2ToRelativeTransform( b2WorldTransform t, b2Pos base )}
     *
     * @param t b2WorldTransform
     * @param base b2Pos
     * @param __result b2Transform
     * @return b2Transform
     */
    public static b2Transform b2ToRelativeTransform(b2WorldTransform t, b2Pos base, b2Transform __result) {
        checkPointers(t, base, __result);
        nb2ToRelativeTransform(t.address(), base.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Transform b2ToRelativeTransform( b2WorldTransform t, b2Pos base )} */
    public static native void nb2ToRelativeTransform(long t, long base, long __result);

    // --- [ b2MakeWorldTransform ] ---

    /**
     * {@code B2_INLINE b2WorldTransform b2MakeWorldTransform( b2Transform t )}
     *
     * @param t b2Transform
     * @param __result b2WorldTransform
     * @return b2WorldTransform
     */
    public static b2WorldTransform b2MakeWorldTransform(b2Transform t, b2WorldTransform __result) {
        checkPointers(t, __result);
        nb2MakeWorldTransform(t.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2WorldTransform b2MakeWorldTransform( b2Transform t )} */
    public static native void nb2MakeWorldTransform(long t, long __result);
    
    // --- [ b2MulMV ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2MulMV( b2Mat22 A, b2Vec2 v )}
     *
     * @param A b2Mat22
     * @param v b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2MulMV(b2Mat22 A, b2Vec2 v, b2Vec2 __result) {
        checkPointers(A, v, __result);
        nb2MulMV(A.address(), v.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2MulMV( b2Mat22 A, b2Vec2 v )} */
    public static native void nb2MulMV(long A, long v, long __result);


    // --- [ b2GetInverse22 ] ---

    /**
     * {@code B2_INLINE b2Mat22 b2GetInverse22( b2Mat22 A )}
     *
     * @param A b2Mat22
     * @param __result b2Mat22
     * @return b2Mat22
     */
    public static b2Mat22 b2GetInverse22(b2Mat22 A, b2Mat22 __result) {
        checkPointers(A, __result);
        nb2GetInverse22(A.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Mat22 b2GetInverse22( b2Mat22 A )} */
    public static native void nb2GetInverse22(long A, long __result);


    // --- [ b2Solve22 ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2Solve22( b2Mat22 A, b2Vec2 b )}
     *
     * @param A b2Mat22
     * @param b b2Vec2
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2Solve22(b2Mat22 A, b2Vec2 b, b2Vec2 __result) {
        checkPointers(A, b, __result);
        nb2Solve22(A.address(), b.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2Solve22( b2Mat22 A, b2Vec2 b )} */
    public static native void nb2Solve22(long A, long b, long __result);


    // --- [ b2AABB_Contains ] ---

    /**
     * {@code B2_INLINE bool b2AABB_Contains( b2AABB a, b2AABB b )}
     *
     * @param a b2AABB
     * @param b b2AABB
     * @return boolean
     */
    public static boolean b2AABB_Contains(b2AABB a, b2AABB b) {
        checkPointers(a, b);
        return nb2AABB_Contains(a.address(), b.address());
    }

    /* {@code B2_INLINE bool b2AABB_Contains( b2AABB a, b2AABB b )} */
    public static native boolean nb2AABB_Contains(long a, long b);


    // --- [ b2AABB_Center ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2AABB_Center( b2AABB a )}
     *
     * @param a b2AABB
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2AABB_Center(b2AABB a, b2Vec2 __result) {
        checkPointers(a, __result);
        nb2AABB_Center(a.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2AABB_Center( b2AABB a )} */
    public static native void nb2AABB_Center(long a, long __result);


    // --- [ b2AABB_Extents ] ---

    /**
     * {@code B2_INLINE b2Vec2 b2AABB_Extents( b2AABB a )}
     *
     * @param a b2AABB
     * @param __result b2Vec2
     * @return b2Vec2
     */
    public static b2Vec2 b2AABB_Extents(b2AABB a, b2Vec2 __result) {
        checkPointers(a, __result);
        nb2AABB_Extents(a.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2Vec2 b2AABB_Extents( b2AABB a )} */
    public static native void nb2AABB_Extents(long a, long __result);


    // --- [ b2AABB_Union ] ---

    /**
     * {@code B2_INLINE b2AABB b2AABB_Union( b2AABB a, b2AABB b )}
     *
     * @param a b2AABB
     * @param b b2AABB
     * @param __result b2AABB
     * @return b2AABB
     */
    public static b2AABB b2AABB_Union(b2AABB a, b2AABB b, b2AABB __result) {
        checkPointers(a, b, __result);
        nb2AABB_Union(a.address(), b.address(), __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2AABB b2AABB_Union( b2AABB a, b2AABB b )} */
    public static native void nb2AABB_Union(long a, long b, long __result);


    // --- [ b2AABB_Overlaps ] ---

    /**
     * {@code B2_INLINE bool b2AABB_Overlaps( b2AABB a, b2AABB b )}
     *
     * @param a b2AABB
     * @param b b2AABB
     * @return boolean
     */
    public static boolean b2AABB_Overlaps(b2AABB a, b2AABB b) {
        checkPointers(a, b);
        return nb2AABB_Overlaps(a.address(), b.address());
    }

    /* {@code B2_INLINE bool b2AABB_Overlaps( b2AABB a, b2AABB b )} */
    public static native boolean nb2AABB_Overlaps(long a, long b);

    // --- [ b2MakeAABB ] ---

    /**
     * {@code B2_INLINE b2AABB b2MakeAABB( const b2Vec2* points, int count, float radius )}
     *
     * @param points b2Vec2.Buffer
     *
     * @param count int
     * @param radius float
     * @param __result b2AABB
     * @return b2AABB
     */
    public static b2AABB b2MakeAABB(ConstB2Vec2.ConstBuffer points, int count, float radius, b2AABB __result) {
        checkPointers(points, __result);
        nb2MakeAABB(points.address(), count, radius, __result.address());
        return __result;
    }

    /* {@code B2_INLINE b2AABB b2MakeAABB( const b2Vec2* points, int count, float radius )} */
    public static native void nb2MakeAABB(long points, int count, float radius, long __result);


    // --- [ b2PlaneSeparation ] ---

    /**
     * {@code B2_INLINE float b2PlaneSeparation( b2Plane plane, b2Vec2 point )}
     *
     * @param plane b2Plane
     * @param point b2Vec2
     * @return float
     */
    public static float b2PlaneSeparation(b2Plane plane, b2Vec2 point) {
        checkPointers(plane, point);
        return nb2PlaneSeparation(plane.address(), point.address());
    }

    /* {@code B2_INLINE float b2PlaneSeparation( b2Plane plane, b2Vec2 point )} */
    public static native float nb2PlaneSeparation(long plane, long point);


    // --- [ b2SpringDamper ] ---

    /**
     * {@code B2_INLINE float b2SpringDamper( float hertz, float dampingRatio, float position, float velocity, float timeStep )}
     *
     * @param hertz float
     * @param dampingRatio float
     * @param position float
     * @param velocity float
     * @param timeStep float
     * @return float
     */
    public static float b2SpringDamper(float hertz, float dampingRatio, float position, float velocity, float timeStep) {
        return nb2SpringDamper(hertz, dampingRatio, position, velocity, timeStep);
    }

    /* {@code B2_INLINE float b2SpringDamper( float hertz, float dampingRatio, float position, float velocity, float timeStep )} */
    public static native float nb2SpringDamper(float hertz, float dampingRatio, float position, float velocity, float timeStep);


    // --- [ b2SetLengthUnitsPerMeter ] ---

    /**
     * {@code B2_API void b2SetLengthUnitsPerMeter( float lengthUnits ); }
     *
     * @param lengthUnits float
     */
    public static void b2SetLengthUnitsPerMeter(float lengthUnits) {
        nb2SetLengthUnitsPerMeter(lengthUnits);
    }

    /* {@code B2_API void b2SetLengthUnitsPerMeter( float lengthUnits ); } */
    public static native void nb2SetLengthUnitsPerMeter(float lengthUnits);


    // --- [ b2GetLengthUnitsPerMeter ] ---

    /**
     * {@code B2_API float b2GetLengthUnitsPerMeter( void ); }
     *
     * @return float
     */
    public static float b2GetLengthUnitsPerMeter() {
        return nb2GetLengthUnitsPerMeter();
    }

    /* {@code B2_API float b2GetLengthUnitsPerMeter( void ); } */
    public static native float nb2GetLengthUnitsPerMeter();
}
