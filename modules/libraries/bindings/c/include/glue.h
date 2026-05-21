// Copyright Night Rider. All rights reserved.
// https://opensource.org/license/bsd-3-clause

/*
 * File:   glue.h
 * Author: wil
 */

#pragma once

#include <stdlib.h>
#include <vector>

#include <jni.h>
#include <ffi.h>

#if !defined( NDEBUG ) || defined( B2_ENABLE_ASSERT )
#define EXCEPTION_CHECK(__env)           \
    if ((__env)->ExceptionCheck()) {     \
        (__env)->ExceptionDescribe();    \
        B2_ASSERT(false);                \
    }
#else
#define EXCEPTION_CHECK(__env)
#endif

#ifdef ANDROID
// doesn't match the Invocation API spec
#define ATTACH_CURRENT_THREAD(__env, attachEnv) \
    (__env)->AttachCurrentThread(attachEnv, NULL)

#else
#define ATTACH_CURRENT_THREAD(__env, attachEnv) \
    (__env)->AttachCurrentThread((void **)(attachEnv), NULL)

#endif
