// Copyright Night Rider. All rights reserved.
// https://opensource.org/license/bsd-3-clause

/*
 * File:   common_tools.h
 * Author: wil
 */

#pragma once

#include <stdint.h>


// -----------------------------------------------------

#define UNUSED_PARAM(param) \
    (void)(param);

#define UNUSED_PARAMS(a, b) \
    (void)(a); \
    (void)(b);

// -----------------------------------------------------

#define ADDRESS_FLOAT_BUFFER(__env, buffer, name, capacity) \
    jfloat * const name = (jfloat *) (*__env)->GetDirectBufferAddress(__env, buffer); \
    const jlong capacity = (*__env)->GetDirectBufferCapacity(__env, buffer);
/*
#define ADDRESS_INT_BUFFER(__env, buffer, name, capacity)                       \
    jint * const name = (jint *) __env->GetDirectBufferAddress(buffer);         \
    const jlong capacity = (__env)->GetDirectBufferCapacity(buffer);

#define ADDRESS_UINT64_BUFFER(__env, buffer, name, capacity)                    \
    uint64_t * const name = (uint64_t *) __env->GetDirectBufferAddress(buffer); \
    const jlong capacity = (__env)->GetDirectBufferCapacity(buffer);

#define ADDRESS_UINT32_BUFFER(__env, buffer, name, capacity)                    \
    uint32_t * const name = (uint32_t *) __env->GetDirectBufferAddress(buffer); \
    const jlong capacity = (__env)->GetDirectBufferCapacity(buffer);

#define ADDRESS_UINT8_BUFFER(__env, buffer, name, capacity)                     \
    uint8_t * const name = (uint8_t *) __env->GetDirectBufferAddress(buffer);   \
    const jlong capacity = (__env)->GetDirectBufferCapacity(buffer);*/