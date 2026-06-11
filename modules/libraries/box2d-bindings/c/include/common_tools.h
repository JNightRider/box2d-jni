// Copyright Night Rider. All rights reserved.
// https://opensource.org/license/bsd-3-clause

/*
 * File:   common_tools.h
 * Author: wil
 */

#pragma once

#include <stdint.h>
#include <stdlib.h>

#include <jni.h>
#include <ffi.h>

#ifdef __cplusplus
    #define EXTERN_C_ENTER extern "C" {
    #define EXTERN_C_EXIT }
#else
    #define EXTERN_C_ENTER
    #define EXTERN_C_EXIT
#endif

// -----------------------------------------------------

EXTERN_C_ENTER

typedef struct Callback
{
    JavaVM *jvm;
    jobject handle;
    jmethodID javaCallback;
    ffi_cif* cif;
    ffi_closure *closure;
    ffi_type* rtype;
    ffi_type** atypes;
    void* code;
} Callback;

Callback* jniCallbackCreate(
    JNIEnv *env,
    jobject object,
    ffi_type* restype,
    size_t nargs,
    ffi_type** atypes
);

void jniCallbackFree(Callback* ptr);

EXTERN_C_EXIT

// -----------------------------------------------------

#define UNUSED_PARAM(param) \
    (void)(param);

#define UNUSED_PARAMS(a, b) \
    (void)(a); \
    (void)(b);

// -----------------------------------------------------

#define ADDRESS_FLOAT_BUFFER(env, buffer, name, capacity) \
    jfloat * const name = (jfloat *) (*env)->GetDirectBufferAddress(env, buffer); \
    const jlong capacity = (*env)->GetDirectBufferCapacity(env, buffer);

#define ADDRESS_INT_BUFFER(env, buffer, name, capacity) \
    jint * const name = (jint *) (*env)->GetDirectBufferAddress(env, buffer); \
    const jlong capacity = (*env)->GetDirectBufferCapacity(env, buffer);

#define ADDRESS_UINT64_BUFFER(env, buffer, name, capacity) \
    uint64_t * const name = (uint64_t *) (*env)->GetDirectBufferAddress(env, buffer); \
    const jlong capacity = (*env)->GetDirectBufferCapacity(env,buffer);

#define ADDRESS_UINT32_BUFFER(env, buffer, name, capacity) \
    uint32_t * const name = (uint32_t *) (*env)->GetDirectBufferAddress(env, buffer); \
    const jlong capacity = (*env)->GetDirectBufferCapacity(env, buffer);

#define ADDRESS_UINT8_BUFFER(env, buffer, name, capacity) \
    uint8_t * const name = (uint8_t *) (*env)->GetDirectBufferAddress(env, buffer);   \
    const jlong capacity = (*env)->GetDirectBufferCapacity(env, buffer);
    

#if !defined( NDEBUG ) || defined( B2_ENABLE_ASSERT )
#define EXCEPTION_CHECK(env) \
    if ((*env)->ExceptionCheck(env)) { \
        (*env)->ExceptionDescribe(env); \
        (*env)->ExceptionClear(env); \
        B2_ASSERT(false); \
    }
#else
#define EXCEPTION_CHECK(env)
#endif



#ifdef ANDROID

// Note: On ART, the first argument to AttachCurrentThread() is JNIEnv **,
// which doesn't comply with the Invocation API specification.

#define ATTACH_CURRENT_THREAD(jvm, env, attachedHere) \
    bool attachedHere = false; \
    jint retCode = (*jvm)->GetEnv(jvm, (void **)(env), JNI_VERSION_1_6); \
    if (JNI_EDETACHED == retCode) { \
        retCode = (*jvm)->AttachCurrentThread(jvm, env, NULL); \
        attachedHere = true; \
    } \
    B2_ASSERT(JNI_OK == retCode);

#define DETACH_CURRENT_THREAD(jvm, env, attachedHere) \
    if (attachedHere) { \
        (*jvm)->DetachCurrentThread(jvm); \
    }

#else

#define ATTACH_CURRENT_THREAD(jvm, env, attachedHere) \
    (*jvm)->AttachCurrentThread(jvm, (void **)(env), NULL); \

#define DETACH_CURRENT_THREAD(jvm, env, attachedHere) \
    (*jvm)->DetachCurrentThread(jvm);

#endif

