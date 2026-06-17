// Copyright Night Rider. All rights reserved.
// https://opensource.org/license/bsd-3-clause

/*
 * File:   org_box2d_jni_system_Upcalls.h
 * Author: wil
 */

#include <stdio.h>
#include <ffi.h>

#include "common_tools.h"
#include "box2d/jni/org_box2d_jni_system_Upcalls.h"

static ffi_type* ffi_type_b2ShapeId_elements[4] = {
    &ffi_type_sint32,
    &ffi_type_uint16,
    &ffi_type_uint16,
    NULL
};
static ffi_type ffi_type_b2ShapeId = {
    .size = 0,
    .alignment = 0,
    .type = FFI_TYPE_STRUCT,
    .elements = ffi_type_b2ShapeId_elements
};

// -----------------------------------------------------

static ffi_type* ffi_type_b2Vec2_elements[3] = {
    &ffi_type_float,
    &ffi_type_float,
    NULL
};
static ffi_type ffi_type_b2Vec2 = {
    .size = 0,
    .alignment = 0,
    .type = FFI_TYPE_STRUCT,
    .elements = ffi_type_b2Vec2_elements
};

// -----------------------------------------------------

static ffi_type* ffi_type_b2Pos_elements[3] = {
    &ffi_type_double,
    &ffi_type_double,
    NULL
};
static ffi_type ffi_type_b2Pos = {
    .size = 0,
    .alignment = 0,
    .type = FFI_TYPE_STRUCT,
    .elements = ffi_type_b2Pos_elements
};

// -----------------------------------------------------

static ffi_type* ffi_type_b2Rot_elements[3] = {
    &ffi_type_float,
    &ffi_type_float,
    NULL
};
static ffi_type ffi_type_b2Rot = {
    .size = 0,
    .alignment = 0,
    .type = FFI_TYPE_STRUCT,
    .elements = ffi_type_b2Rot_elements
};

// -----------------------------------------------------

static ffi_type* ffi_type_b2Transform_elements[3] = {
    &ffi_type_b2Vec2,
    &ffi_type_b2Rot,
    NULL
};
static ffi_type ffi_type_b2Transform = {
    .size = 0,
    .alignment = 0,
    .type = FFI_TYPE_STRUCT,
    .elements = ffi_type_b2Transform_elements
};

// -----------------------------------------------------

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    nffi_type_void
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Upcalls_nffi_1type_1void
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)&ffi_type_void;
}

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    nffi_type_uint8
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Upcalls_nffi_1type_1uint8
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)&ffi_type_uint8;
}

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    nffi_type_sint8
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Upcalls_nffi_1type_1sint8
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)&ffi_type_sint8;
}

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    nffi_type_uint16
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Upcalls_nffi_1type_1uint16
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)&ffi_type_uint16;
}

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    nffi_type_sint16
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Upcalls_nffi_1type_1sint16
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)&ffi_type_sint16;
}

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    nffi_type_uint32
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Upcalls_nffi_1type_1uint32
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)&ffi_type_uint32;
}

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    nffi_type_sint32
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Upcalls_nffi_1type_1sint32
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)&ffi_type_sint32;
}

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    nffi_type_uint64
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Upcalls_nffi_1type_1uint64
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)&ffi_type_uint64;
}

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    nffi_type_sint64
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Upcalls_nffi_1type_1sint64
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)&ffi_type_sint64;
}

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    nffi_type_float
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Upcalls_nffi_1type_1float
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)&ffi_type_float;
}

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    nffi_type_double
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Upcalls_nffi_1type_1double
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)&ffi_type_double;
}

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    nffi_type_pointer
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Upcalls_nffi_1type_1pointer
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)&ffi_type_pointer;
}

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    nffi_type_longdouble
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Upcalls_nffi_1type_1longdouble
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)&ffi_type_longdouble;
}

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    nffi_type_b2ShapeId
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Upcalls_nffi_1type_1b2ShapeId
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong) &ffi_type_b2ShapeId;
}

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    nffi_type_b2Vec2
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Upcalls_nffi_1type_1b2Vec2
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong) &ffi_type_b2Vec2;
}

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    nffi_type_b2Pos
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Upcalls_nffi_1type_1b2Pos
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong) &ffi_type_b2Pos;
}

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    nffi_type_b2Rot
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Upcalls_nffi_1type_1b2Rot
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong) &ffi_type_b2Rot;
}

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    nffi_type_b2Transform
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Upcalls_nffi_1type_1b2Transform
    (JNIEnv *__env, jclass clazz)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong) &ffi_type_b2Transform;
}

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    njniCallbackCreate
 * Signature: (Ljava/lang/Object;JLjava/nio/LongBuffer;)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Upcalls_njniCallbackCreate
    (JNIEnv *__env, jclass clazz, jobject obj, jlong ret, jobject arg, jlong size)
{
    UNUSED_PARAM(clazz)
    ffi_type** const atypes = (ffi_type**) (*__env)->GetDirectBufferAddress(__env, arg);
    ffi_type* restype = (ffi_type*)ret;
    Callback* ptr = jniCallbackCreate(__env, obj, restype, (size_t)size, atypes);
    return (jlong)ptr;
}

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    njniCallbackFree
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_system_Upcalls_njniCallbackFree
    (JNIEnv *__env, jclass clazz, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    Callback* ptr = (Callback*)(uintptr_t)address;
    jniCallbackFree(ptr);
}

/*
 * Class:     org_box2d_jni_system_Upcalls
 * Method:    napiClosureFunction
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_system_Upcalls_napiClosureFunction
    (JNIEnv *__env, jclass clazz, jlong address)
{
    UNUSED_PARAMS(__env, clazz)
    Callback* ptr = (Callback*)(uintptr_t)address;
    return (jlong)ptr->code;
}
