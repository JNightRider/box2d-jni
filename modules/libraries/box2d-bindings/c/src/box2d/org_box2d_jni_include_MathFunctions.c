// Copyright Night Rider. All rights reserved.
// https://github.com/JNightRider/box2d-jni/blob/master/LICENSE

/*
 * File:   org_box2d_jni_include_MathFunctions.h
 * Author: wil
 */

#include <stdlib.h>

#include "common_tools.h"
#include "box2d/math_functions.h"
#include "box2d/jni/org_box2d_jni_include_MathFunctions.h"

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nB2_PI
 * Signature: ()F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nB2_1PI
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat) B2_PI;
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2IsValidFloat
 * Signature: (F)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_MathFunctions_nb2IsValidFloat
    (JNIEnv *__env, jclass clazz, jfloat a)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean) b2IsValidFloat(a);
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2IsValidVec2
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_MathFunctions_nb2IsValidVec2
    (JNIEnv *__env, jclass clazz, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t) address;
    return (jboolean) b2IsValidVec2( *ptr );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2IsValidRotation
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_MathFunctions_nb2IsValidRotation
    (JNIEnv *__env, jclass clazz, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    b2Rot* ptr = (b2Rot*)(uintptr_t) address;
    return (jboolean) b2IsValidRotation( *ptr );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2IsValidTransform
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_MathFunctions_nb2IsValidTransform
    (JNIEnv *__env, jclass clazz, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    b2Transform* t = (b2Transform*)(uintptr_t) address;
    return (jboolean) b2IsValidTransform( *t );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2IsValidAABB
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_MathFunctions_nb2IsValidAABB
    (JNIEnv *__env, jclass clazz, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    b2AABB* aabb = (b2AABB*)(uintptr_t) address;
    return (jboolean) b2IsValidAABB( *aabb );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    n2IsValidPlane
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_MathFunctions_n2IsValidPlane
    (JNIEnv *__env, jclass clazz, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    b2Plane* a = (b2Plane*)(uintptr_t) address;
    return (jboolean) b2IsValidPlane( *a );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2IsValidPosition
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_MathFunctions_nb2IsValidPosition
    (JNIEnv *__env, jclass clazz, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2IsValidPosition( *(b2Pos*)address );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2IsValidWorldTransform
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_MathFunctions_nb2IsValidWorldTransform
    (JNIEnv *__env, jclass clazz, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    return (jboolean)b2IsValidWorldTransform( *(b2WorldTransform*)address );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2MinInt
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_MathFunctions_nb2MinInt
    (JNIEnv *__env, jclass clazz, jint a, jint b)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint) b2MinInt( a, b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2MaxInt
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_MathFunctions_nb2MaxInt
    (JNIEnv *__env, jclass clazz, jint a, jint b)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint) b2MaxInt( a, b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2AbsInt
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_MathFunctions_nb2AbsInt
    (JNIEnv *__env, jclass clazz, jint a)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint) b2AbsInt( a );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2ClampInt
 * Signature: (III)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_MathFunctions_nb2ClampInt
    (JNIEnv *__env, jclass clazz, jint a, jint lower, jint upper)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint) b2ClampInt( a, lower, upper );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2CeilingInt
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_include_MathFunctions_nb2CeilingInt
    (JNIEnv *__env, jclass clazz, jint numerator, jint denominator)
{
    UNUSED_PARAMS(__env, clazz)
    return (jint) b2CeilingInt( numerator, denominator );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2MinFloat
 * Signature: (FF)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nb2MinFloat
    (JNIEnv *__env, jclass clazz, jfloat a, jfloat b)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat) b2MinFloat( a, b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2MaxFloat
 * Signature: (FF)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nb2MaxFloat
    (JNIEnv *__env, jclass clazz, jfloat a, jfloat b)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat) b2MaxFloat( a, b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2AbsFloat
 * Signature: (F)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nb2AbsFloat
    (JNIEnv *__env, jclass clazz, jfloat a)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat) b2AbsFloat( a );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2ClampFloat
 * Signature: (FFF)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nb2ClampFloat
    (JNIEnv *__env, jclass clazz, jfloat a, jfloat lower, jfloat upper)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat) b2ClampFloat( a, lower, upper );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2Atan2
 * Signature: (FF)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nb2Atan2
    (JNIEnv *__env, jclass clazz, jfloat y, jfloat x)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat) b2Atan2( y, x );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2ComputeCosSin
 * Signature: (FJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2ComputeCosSin
    (JNIEnv *__env, jclass clazz, jfloat radians, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2CosSin* ptr = (b2CosSin*)(uintptr_t)__result;
    *ptr = b2ComputeCosSin( radians );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2Dot
 * Signature: (JJ)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nb2Dot
    (JNIEnv *__env, jclass clazz, jlong aAddress, jlong bAddress)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* a = (b2Vec2*)(uintptr_t)aAddress;
    b2Vec2* b = (b2Vec2*)(uintptr_t)bAddress;
    return (jfloat) b2Dot( *a, *b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2Cross
 * Signature: (JJ)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nb2Cross
    (JNIEnv *__env, jclass clazz, jlong aAddress, jlong bAddress)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* a = (b2Vec2*)(uintptr_t)aAddress;
    b2Vec2* b = (b2Vec2*)(uintptr_t)bAddress;
    return (jfloat)  b2Cross( *a, *b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2CrossVS
 * Signature: (JFJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2CrossVS
    (JNIEnv *__env, jclass clazz, jlong vAddress, jfloat s, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Vec2* v = (b2Vec2*)(uintptr_t)vAddress;
    *ptr = b2CrossVS(  *v, s );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2CrossSV
 * Signature: (FJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2CrossSV
    (JNIEnv *__env, jclass clazz, jfloat s, jlong vAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Vec2* v = (b2Vec2*)(uintptr_t)vAddress;
    *ptr = b2CrossSV( s, *v );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2LeftPerp
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2LeftPerp
    (JNIEnv *__env, jclass clazz, jlong vAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Vec2* v = (b2Vec2*)(uintptr_t)vAddress;
    *ptr = b2LeftPerp( *v );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2RightPerp
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2RightPerp
    (JNIEnv *__env, jclass clazz, jlong vAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Vec2* v = (b2Vec2*)(uintptr_t)vAddress;
    *ptr = b2RightPerp( *v );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2Add
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2Add
    (JNIEnv *__env, jclass clazz, jlong aAddress, jlong bAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Vec2* a = (b2Vec2*)(uintptr_t)aAddress;
    b2Vec2* b = (b2Vec2*)(uintptr_t)bAddress;
    *ptr = b2Add( *a, *b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2Sub
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2Sub
    (JNIEnv *__env, jclass clazz, jlong aAddress, jlong bAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Vec2* a = (b2Vec2*)(uintptr_t)aAddress;
    b2Vec2* b = (b2Vec2*)(uintptr_t)bAddress;
    *ptr = b2Sub( *a, *b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2Neg
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2Neg
    (JNIEnv *__env, jclass clazz, jlong aAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Vec2* a = (b2Vec2*)(uintptr_t)aAddress;
    *ptr = b2Neg( *a );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2Lerp
 * Signature: (JJFJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2Lerp
    (JNIEnv *__env, jclass clazz, jlong aAddress, jlong bAddress, jfloat t, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Vec2* a = (b2Vec2*)(uintptr_t)aAddress;
    b2Vec2* b = (b2Vec2*)(uintptr_t)bAddress;
    *ptr = b2Lerp( *a, *b, t );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2Mul
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2Mul
    (JNIEnv *__env, jclass clazz, jlong aAddress, jlong bAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Vec2* a = (b2Vec2*)(uintptr_t)aAddress;
    b2Vec2* b = (b2Vec2*)(uintptr_t)bAddress;
    *ptr = b2Mul( *a, *b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2MulSV
 * Signature: (FJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2MulSV
    (JNIEnv *__env, jclass clazz, jfloat s, jlong vAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Vec2* v = (b2Vec2*)(uintptr_t)vAddress;
    *ptr = b2MulSV( s, *v );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2MulAdd
 * Signature: (JFJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2MulAdd
    (JNIEnv *__env, jclass clazz, jlong aAddress, jfloat s, jlong bAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Vec2* a = (b2Vec2*)(uintptr_t)aAddress;
    b2Vec2* b = (b2Vec2*)(uintptr_t)bAddress;
    *ptr = b2MulAdd( *a, s, *b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2MulSub
 * Signature: (JFJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2MulSub
    (JNIEnv *__env, jclass clazz, jlong aAddress, jfloat s, jlong bAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Vec2* a = (b2Vec2*)(uintptr_t)aAddress;
    b2Vec2* b = (b2Vec2*)(uintptr_t)bAddress;
    *ptr = b2MulSub( *a, s, *b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2Abs
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2Abs
    (JNIEnv *__env, jclass clazz, jlong aAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Vec2* a = (b2Vec2*)(uintptr_t)aAddress;
    *ptr = b2Abs( *a );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2Min
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2Min
    (JNIEnv *__env, jclass clazz, jlong aAddress, jlong bAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Vec2* a = (b2Vec2*)(uintptr_t)aAddress;
    b2Vec2* b = (b2Vec2*)(uintptr_t)bAddress;
    *ptr = b2Min( *a, *b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2Max
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2Max
    (JNIEnv *__env, jclass clazz, jlong aAddress, jlong bAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Vec2* a = (b2Vec2*)(uintptr_t)aAddress;
    b2Vec2* b = (b2Vec2*)(uintptr_t)bAddress;
    *ptr = b2Max( *a, *b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2Clamp
 * Signature: (JJJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2Clamp
    (JNIEnv *__env, jclass clazz, jlong vAddress, jlong aAddress, jlong bAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Vec2* v = (b2Vec2*)(uintptr_t)vAddress;
    b2Vec2* a = (b2Vec2*)(uintptr_t)aAddress;
    b2Vec2* b = (b2Vec2*)(uintptr_t)bAddress;
    *ptr = b2Clamp( *v, *a, *b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2Length
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nb2Length
    (JNIEnv *__env, jclass clazz, jlong vAddress)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* v = (b2Vec2*)(uintptr_t)vAddress;
    return (jfloat) b2Length( *v );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2Distance
 * Signature: (JJ)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nb2Distance
    (JNIEnv *__env, jclass clazz, jlong aAddress, jlong bAddress)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* a = (b2Vec2*)(uintptr_t)aAddress;
    b2Vec2* b = (b2Vec2*)(uintptr_t)bAddress;
    return (jfloat) b2Distance( *a, *b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2Normalize
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2Normalize
    (JNIEnv *__env, jclass clazz, jlong vAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Vec2* v = (b2Vec2*)(uintptr_t)vAddress;
    *ptr = b2Normalize( *v );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2IsNormalized
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_MathFunctions_nb2IsNormalized
    (JNIEnv *__env, jclass clazz, jlong aAddress)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* a = (b2Vec2*)(uintptr_t)aAddress;
    return (jboolean) b2IsNormalized( *a );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2GetLengthAndNormalize
 * Signature: (Ljava/nio/FloatBuffer;JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2GetLengthAndNormalize
    (JNIEnv *__env, jclass clazz, jobject __buffer, jlong vAddress, jlong __result)
{
    ADDRESS_FLOAT_BUFFER(__env, __buffer, length, __capacity)
    UNUSED_PARAM(__capacity)
    UNUSED_PARAM(clazz)

    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Vec2* v = (b2Vec2*)(uintptr_t)vAddress;
    *ptr = b2GetLengthAndNormalize( (float*)length, *v );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2NormalizeRot
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2NormalizeRot
    (JNIEnv *__env, jclass clazz, jlong qAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Rot* ptr = (b2Rot*)(uintptr_t)__result;
    b2Rot* q = (b2Rot*)(uintptr_t)qAddress;
    *ptr = b2NormalizeRot( *q );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2IntegrateRotation
 * Signature: (JFJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2IntegrateRotation
    (JNIEnv *__env, jclass clazz, jlong q1Address, jfloat deltaAngle, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Rot* ptr = (b2Rot*)(uintptr_t)__result;
    b2Rot* q1 = (b2Rot*)(uintptr_t)q1Address;
    *ptr = b2IntegrateRotation( *q1, deltaAngle );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2LengthSquared
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nb2LengthSquared
    (JNIEnv *__env, jclass clazz, jlong vAddress)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* v = (b2Vec2*)(uintptr_t)vAddress;
    return (jfloat) b2LengthSquared( *v );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2DistanceSquared
 * Signature: (JJ)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nb2DistanceSquared
    (JNIEnv *__env, jclass clazz, jlong aAddress, jlong bAddress)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* a = (b2Vec2*)(uintptr_t)aAddress;
    b2Vec2* b = (b2Vec2*)(uintptr_t)bAddress;
    return (jfloat) b2DistanceSquared( *a, *b );

}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2MakeRot
 * Signature: (FJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2MakeRot
    (JNIEnv *__env, jclass clazz, jfloat radians, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Rot* ptr = (b2Rot*)(uintptr_t)__result;
    *ptr = b2MakeRot( radians );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2MakeRotFromUnitVector
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2MakeRotFromUnitVector
    (JNIEnv *__env, jclass clazz, jlong unitVectorAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Rot* ptr = (b2Rot*)(uintptr_t)__result;
    b2Vec2* unitVector = (b2Vec2*)(uintptr_t) unitVectorAddress;
    *ptr = b2MakeRotFromUnitVector( *unitVector );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2ComputeRotationBetweenUnitVectors
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2ComputeRotationBetweenUnitVectors
    (JNIEnv *__env, jclass clazz, jlong v1Address, jlong v2Address, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Rot* ptr = (b2Rot*)(uintptr_t)__result;
    b2Vec2* v1 = (b2Vec2*)(uintptr_t) v1Address;
    b2Vec2* v2 = (b2Vec2*)(uintptr_t) v2Address;
    *ptr = b2ComputeRotationBetweenUnitVectors( *v1, *v2 );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2IsNormalizedRot
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_MathFunctions_nb2IsNormalizedRot
    (JNIEnv *__env, jclass clazz, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    b2Rot* q = (b2Rot*)(uintptr_t)address;
    return (jboolean) b2IsNormalizedRot( *q );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2InvertRot
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2InvertRot
    (JNIEnv *__env, jclass clazz, jlong aAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Rot* ptr = (b2Rot*)(uintptr_t)__result;
    b2Rot* a = (b2Rot*)(uintptr_t)aAddress;
    *ptr = b2InvertRot( *a );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2NLerp
 * Signature: (JJFJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2NLerp
    (JNIEnv *__env, jclass clazz, jlong q1Address, jlong q2Address, jfloat t, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Rot* ptr = (b2Rot*)(uintptr_t)__result;
    b2Rot* q1 = (b2Rot*)(uintptr_t)q1Address;
    b2Rot* q2 = (b2Rot*)(uintptr_t)q2Address;
    *ptr = b2NLerp( *q1, *q2, t );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2ComputeAngularVelocity
 * Signature: (JJF)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nb2ComputeAngularVelocity
    (JNIEnv *__env, jclass clazz, jlong q1Address, jlong q2Address, jfloat inv_h)
{
    UNUSED_PARAMS(__env, clazz)
    b2Rot* q1 = (b2Rot*)(uintptr_t)q1Address;
    b2Rot* q2 = (b2Rot*)(uintptr_t)q2Address;
    return (jfloat) b2ComputeAngularVelocity( *q1, *q2, inv_h );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2Rot_GetAngle
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nb2Rot_1GetAngle
    (JNIEnv *__env, jclass clazz, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    b2Rot* q = (b2Rot*)(uintptr_t)address;
    return (jfloat)b2Rot_GetAngle( *q );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2Rot_GetXAxis
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2Rot_1GetXAxis
    (JNIEnv *__env, jclass clazz, jlong qAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Rot* q = (b2Rot*)(uintptr_t)qAddress;
    *ptr = b2Rot_GetXAxis( *q );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2Rot_GetYAxis
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2Rot_1GetYAxis
    (JNIEnv *__env, jclass clazz, jlong qAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Rot* q = (b2Rot*)(uintptr_t)qAddress;
    *ptr = b2Rot_GetYAxis( *q );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2MulRot
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2MulRot
    (JNIEnv *__env, jclass clazz, jlong qAddress, jlong rAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Rot* ptr = (b2Rot*)(uintptr_t)__result;
    b2Rot* q = (b2Rot*)(uintptr_t)qAddress;
    b2Rot* r = (b2Rot*)(uintptr_t)rAddress;
    *ptr = b2MulRot( *q, *r );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2InvMulRot
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2InvMulRot
    (JNIEnv *__env, jclass clazz, jlong aAddress, jlong bAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Rot* ptr = (b2Rot*)(uintptr_t)__result;
    b2Rot* a = (b2Rot*)(uintptr_t)aAddress;
    b2Rot* b = (b2Rot*)(uintptr_t)bAddress;
    *ptr = b2InvMulRot( *a, *b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2RelativeAngle
 * Signature: (JJ)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nb2RelativeAngle
    (JNIEnv *__env, jclass clazz, jlong aAddress, jlong bAddress)
{
    UNUSED_PARAMS(__env, clazz)
    b2Rot* a = (b2Rot*)(uintptr_t)aAddress;
    b2Rot* b = (b2Rot*)(uintptr_t)bAddress;
    return (jfloat)b2RelativeAngle( *a, *b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2UnwindAngle
 * Signature: (F)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nb2UnwindAngle
    (JNIEnv *__env, jclass clazz, jfloat radians)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2UnwindAngle( radians );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2RotateVector
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2RotateVector
    (JNIEnv *__env, jclass clazz, jlong qAddress, jlong vAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Rot* q = (b2Rot*)(uintptr_t)qAddress;
    b2Vec2* v = (b2Vec2*)(uintptr_t)vAddress;
    *ptr = b2RotateVector( *q, *v );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2InvRotateVector
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2InvRotateVector
    (JNIEnv *__env, jclass clazz, jlong qAddress, jlong vAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Rot* q = (b2Rot*)(uintptr_t)qAddress;
    b2Vec2* v = (b2Vec2*)(uintptr_t)vAddress;
    *ptr = b2InvRotateVector( *q, *v );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2TransformPoint
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2TransformPoint
    (JNIEnv *__env, jclass clazz, jlong tAddress, jlong pAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Transform* t = (b2Transform*)(uintptr_t)tAddress;
    const b2Vec2* p = (const b2Vec2*)(uintptr_t)pAddress;
    *ptr = b2TransformPoint( *t, *p );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2InvTransformPoint
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2InvTransformPoint
    (JNIEnv *__env, jclass clazz, jlong tAddress, jlong pAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Transform* t = (b2Transform*)(uintptr_t)tAddress;
    const b2Vec2* p = (const b2Vec2*)(uintptr_t)pAddress;
    *ptr = b2InvTransformPoint( *t, *p );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2MulTransforms
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2MulTransforms
    (JNIEnv *__env, jclass clazz, jlong AAddress, jlong BAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Transform* ptr = (b2Transform*)(uintptr_t)__result;
    b2Transform* A = (b2Transform*)(uintptr_t)AAddress;
    b2Transform* B = (b2Transform*)(uintptr_t)BAddress;
    *ptr = b2MulTransforms( *A, *B );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2InvMulTransforms
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2InvMulTransforms
    (JNIEnv *__env, jclass clazz, jlong AAddress, jlong BAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Transform* ptr = (b2Transform*)(uintptr_t)__result;
    b2Transform* A = (b2Transform*)(uintptr_t)AAddress;
    b2Transform* B = (b2Transform*)(uintptr_t)BAddress;
    *ptr = b2InvMulTransforms( *A, *B );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2ToPos
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2ToPos
    (JNIEnv *__env, jclass clazz, jlong v, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Pos*)__result = b2ToPos( *(b2Vec2*)v );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2ToVec2
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2ToVec2
    (JNIEnv *__env, jclass clazz, jlong p, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Vec2*)__result = b2ToVec2( *(b2Pos*)p );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2RoundDownFloat
 * Signature: (D)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nb2RoundDownFloat
    (JNIEnv *__env, jclass clazz, jdouble x)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat) b2RoundDownFloat(x);
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2RoundUpFloat
 * Signature: (D)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nb2RoundUpFloat
    (JNIEnv *__env, jclass clazz, jdouble x)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat) b2RoundUpFloat( x );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2SubPos
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2SubPos
    (JNIEnv *__env, jclass clazz, jlong a, jlong b, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Vec2*)__result = b2SubPos( *(b2Pos*) a, *(b2Pos*) b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2OffsetPos
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2OffsetPos
    (JNIEnv *__env, jclass clazz, jlong p, jlong d, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Pos*)__result = b2OffsetPos( *(b2Pos*) p, *(b2Vec2*) d );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2LerpPosition
 * Signature: (JJFJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2LerpPosition
    (JNIEnv *__env, jclass clazz, jlong a, jlong b, jfloat t, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Pos*)__result = b2LerpPosition( *(b2Pos*) a, *(b2Pos*) b, t );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2TransformWorldPoint
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2TransformWorldPoint
    (JNIEnv *__env, jclass clazz, jlong t, jlong p, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Pos*)__result = b2TransformWorldPoint( *(b2WorldTransform*) t, *(b2Vec2*) p );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2InvTransformWorldPoint
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2InvTransformWorldPoint
    (JNIEnv *__env, jclass clazz, jlong t, jlong p, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Vec2*)__result = b2InvTransformWorldPoint( *(b2WorldTransform*) t, *(b2Pos*) p );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2InvMulWorldTransforms
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2InvMulWorldTransforms
    (JNIEnv *__env, jclass clazz, jlong A, jlong B, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Transform*)__result = b2InvMulWorldTransforms( *(b2WorldTransform*) A, *(b2WorldTransform*) B );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2ToRelativeTransform
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2ToRelativeTransform
    (JNIEnv *__env, jclass clazz, jlong t, jlong base, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2Transform*)__result = b2ToRelativeTransform( *(b2WorldTransform*)t, *(b2Pos*)base );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2MakeWorldTransform
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2MakeWorldTransform
    (JNIEnv *__env, jclass clazz, jlong t, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    *(b2WorldTransform*)__result = b2MakeWorldTransform( *(b2Transform*) t );
}


/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2MulMV
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2MulMV
    (JNIEnv *__env, jclass clazz, jlong AAddress, jlong vAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Mat22* A = (b2Mat22*)(uintptr_t)AAddress;
    b2Vec2* v = (b2Vec2*)(uintptr_t)vAddress;
    *ptr = b2MulMV( *A, *v );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2GetInverse22
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2GetInverse22
    (JNIEnv *__env, jclass clazz, jlong AAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Mat22* ptr = (b2Mat22*)(uintptr_t)__result;
    b2Mat22* A = (b2Mat22*)(uintptr_t)AAddress;
    *ptr = b2GetInverse22( *A );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2Solve22
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2Solve22
    (JNIEnv *__env, jclass clazz, jlong AAddress, jlong bAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2Mat22* A = (b2Mat22*)(uintptr_t)AAddress;
    b2Vec2* b = (b2Vec2*)(uintptr_t)bAddress;
    *ptr = b2Solve22( *A, *b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2AABB_Contains
 * Signature: (JJ)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_MathFunctions_nb2AABB_1Contains
    (JNIEnv *__env, jclass clazz, jlong aAddresss, jlong bAddresss)
{
    UNUSED_PARAMS(__env, clazz)
    b2AABB* a = (b2AABB*)(uintptr_t)aAddresss;
    b2AABB* b = (b2AABB*)(uintptr_t)bAddresss;
    return (jboolean)b2AABB_Contains( *a, *b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2AABB_Center
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2AABB_1Center
    (JNIEnv *__env, jclass clazz, jlong aAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2AABB* a = (b2AABB*)(uintptr_t)aAddress;
    *ptr = b2AABB_Center( *a );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2AABB_Extents
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2AABB_1Extents
    (JNIEnv *__env, jclass clazz, jlong aAddress, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* ptr = (b2Vec2*)(uintptr_t)__result;
    b2AABB* a = (b2AABB*)(uintptr_t)aAddress;
    *ptr = b2AABB_Extents( *a );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2AABB_Union
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2AABB_1Union
    (JNIEnv *__env, jclass clazz, jlong aAddresss, jlong bAddresss, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    b2AABB* ptr = (b2AABB*)(uintptr_t)__result;
    b2AABB* a = (b2AABB*)(uintptr_t)aAddresss;
    b2AABB* b = (b2AABB*)(uintptr_t)bAddresss;
    *ptr = b2AABB_Union( *a, *b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2AABB_Overlaps
 * Signature: (JJ)Z
 */
JNIEXPORT jboolean JNICALL Java_org_box2d_jni_include_MathFunctions_nb2AABB_1Overlaps
    (JNIEnv *__env, jclass clazz, jlong aAddresss, jlong bAddresss)
{
    UNUSED_PARAMS(__env, clazz)
    b2AABB* a = (b2AABB*)(uintptr_t)aAddresss;
    b2AABB* b = (b2AABB*)(uintptr_t)bAddresss;
    return (jboolean)b2AABB_Overlaps( *a, *b );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2MakeAABB
 * Signature: (JIFJ)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2MakeAABB
    (JNIEnv *__env, jclass clazz, jlong __buffer, jint count, jfloat radius, jlong __result)
{
    UNUSED_PARAMS(__env, clazz)
    const b2Vec2* points = (const b2Vec2*)(const uintptr_t)(__buffer);
    b2AABB* ptr = (b2AABB*)(uintptr_t)__result;
    *ptr = b2MakeAABB(points, count, radius );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2PlaneSeparation
 * Signature: (JJ)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nb2PlaneSeparation
    (JNIEnv *__env, jclass clazz, jlong pointAddress, jlong planeAddress)
{
    UNUSED_PARAMS(__env, clazz)
    b2Vec2* point = (b2Vec2*)(uintptr_t)pointAddress;
    b2Plane* plane = (b2Plane*)(uintptr_t)planeAddress;
    return (jfloat)b2PlaneSeparation( *plane, *point );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2SpringDamper
 * Signature: (FFFFF)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nb2SpringDamper
    (JNIEnv *__env, jclass clazz, jfloat hertz, jfloat dampingRatio, jfloat position, jfloat velocity, jfloat timeStep)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2SpringDamper( hertz, dampingRatio, position, velocity, timeStep );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2SetLengthUnitsPerMeter
 * Signature: (F)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_include_MathFunctions_nb2SetLengthUnitsPerMeter
    (JNIEnv *__env, jclass clazz, jfloat lengthUnits)
{
    UNUSED_PARAMS(__env, clazz)
    b2SetLengthUnitsPerMeter( lengthUnits );
}

/*
 * Class:     org_box2d_jni_include_MathFunctions
 * Method:    nb2GetLengthUnitsPerMeter
 * Signature: ()F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_include_MathFunctions_nb2GetLengthUnitsPerMeter
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jfloat)b2GetLengthUnitsPerMeter();
}
