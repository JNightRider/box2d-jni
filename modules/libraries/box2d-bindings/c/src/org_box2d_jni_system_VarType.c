// Copyright Night Rider. All rights reserved.
// https://github.com/JNightRider/box2d-jni/blob/master/LICENSE

/*
 * File:   org_box2d_jni_system_VarType.h
 * Author: wil
 */

#include "common_tools.h"
#include "box2d/jni/org_box2d_jni_system_VarType.h"

// -----------

typedef enum JNIVarType {
    VAR_TYPE_INT8_t     = 0x0001,
    VAR_TYPE_INT16_t    = 0x0002,
    VAR_TYPE_INT32_t    = 0x0003,
    VAR_TYPE_INT64_t    = 0x0004,
    VAR_TYPE_FLOAT      = 0x0005,
    VAR_TYPE_DOUBLE     = 0x0006,
    VAR_TYPE_UINTPTR_t  = 0x0007,
    VAR_TYPE_POINTER    = 0x0008
} JNIVarType;

static int getSizeOf(JNIVarType type)
{
    switch (type)
    {
    case VAR_TYPE_INT8_t:   return sizeof(int8_t);
    case VAR_TYPE_INT16_t:  return sizeof(int16_t);
    case VAR_TYPE_INT32_t:  return sizeof(int32_t);
    case VAR_TYPE_INT64_t:  return sizeof(int64_t);
    case VAR_TYPE_FLOAT:    return sizeof(float);
    case VAR_TYPE_DOUBLE:   return sizeof(double);
    case VAR_TYPE_UINTPTR_t:return sizeof(uintptr_t);
    case VAR_TYPE_POINTER:  return sizeof(void*);
    default: return 0;
    }
}

// -----------

/*
 * Class:     org_box2d_jni_system_VarType
 * Method:    __nsizeof
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_org_box2d_jni_system_VarType__1_1nsizeof
    (JNIEnv *__env, jclass clazz, jint vartype)
{
    JNIVarType tp = (JNIVarType)vartype;
    UNUSED_PARAMS(__env, clazz)
    return (jint) getSizeOf(tp);
}
