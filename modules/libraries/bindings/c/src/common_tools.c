// Copyright Night Rider. All rights reserved.
// https://opensource.org/license/bsd-3-clause

/*
 * File:   common_tools.c
 * Author: wil
 */

#include "common_tools.h"
#include "box2d/base.h"

#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <stdarg.h>

#include <jni.h>
#include <ffi.h>

static void cbHandler(ffi_cif* cif, void* resp, void** args, void* userdata)
{
    Callback* ptr = (Callback*)(uintptr_t)userdata;
    UNUSED_PARAM(cif)

    JNIEnv *env;
    ATTACH_CURRENT_THREAD(ptr->jvm, &env, flag)

    // Invoke the Java callback
    (*env)->CallVoidMethod(env,
        ptr->handle,
        ptr->javaCallback,
        (jlong)(uintptr_t)resp,
        (jlong)(uintptr_t)args
    );
    
    EXCEPTION_CHECK(env)
    ATTACH_CURRENT_THREAD(ptr->jvm, &env, flag)
}

Callback* jniCallbackCreate(
    JNIEnv *env,
    jobject object,
    ffi_type* restype,
    size_t nargs,
    ffi_type** atypes
) {
    Callback* ptr = (Callback*) calloc(1, sizeof(Callback));

    (*env)->GetJavaVM(env, &ptr->jvm);
    ptr->handle = (*env)->NewGlobalRef(env, object);
    EXCEPTION_CHECK(env)

    const jclass clazz = (*env)->GetObjectClass(env, object);
    ptr->javaCallback  = (*env)->GetMethodID(env, clazz, "callback", "(JJ)V");
    EXCEPTION_CHECK(env)

    // init: libfii
    ptr->cif = (ffi_cif*) malloc(sizeof(ffi_cif));
    ptr->closure = (ffi_closure*) ffi_closure_alloc(sizeof(ffi_closure), &ptr->code);

    ptr->rtype = restype;
    ptr->atypes = malloc(sizeof(ffi_type*) * nargs);

    {
        for (size_t i = 0; i < nargs; i++)
        {
            ptr->atypes[i] = atypes[i];
        }
        //va_list ftype;
        //va_start(ftype, nargs);

        //for (size_t i = 0; i < nargs; i++) {
        //    ptr->atypes[i] = va_arg(ftype, ffi_type*);
        //}
        //va_end(ftype);
    }

    if (ffi_prep_cif(ptr->cif, FFI_DEFAULT_ABI, nargs, ptr->rtype, ptr->atypes) != FFI_OK)
    {
        jniCallbackFree(ptr);
        return NULL;
    }
    if (ffi_prep_closure_loc(ptr->closure, ptr->cif, cbHandler, ptr, ptr->code) != FFI_OK)
    {
        jniCallbackFree(ptr);
        return NULL;
    }
    return ptr;
}

void jniCallbackFree(Callback* ptr)
{
    if (ptr == NULL) {
        return;
    }

    JNIEnv *env;
    ATTACH_CURRENT_THREAD(ptr->jvm, &env, flag)

    (*env)->DeleteGlobalRef(env, ptr->handle);
    EXCEPTION_CHECK(env)
    DETACH_CURRENT_THREAD(ptr->jvm, &env, flag)
    
    ffi_closure_free(ptr->closure);
    free(ptr->atypes);
    free(ptr->cif);
    free(ptr);
}
