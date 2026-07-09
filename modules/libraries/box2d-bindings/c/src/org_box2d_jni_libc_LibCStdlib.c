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

/*
 * File:   org_box2d_jni_libc_LibCStdlib.h
 * Author: wil
 */

#include <stdio.h>
#include <stdlib.h>

#include "common_tools.h"
#include "box2d/jni/org_box2d_jni_libc_LibCStdlib.h"

/*
 * Class:     org_box2d_jni_libc_LibCStdlib
 * Method:    ncalloc
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_libc_LibCStdlib_ncalloc
  (JNIEnv *, jclass, jlong num, jlong size);
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)(uintptr_t)calloc((size_t)num, (size_t)size);
}

/*
 * Class:     org_box2d_jni_libc_LibCStdlib
 * Method:    nmalloc
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_libc_LibCStdlib_nmalloc
    (JNIEnv *__env, jclass clazz, jlong size)
{
    UNUSED_PARAMS(__env, clazz)
    return (jlong)(uintptr_t)malloc((size_t)size);
}

/*
 * Class:     org_box2d_jni_libc_LibCStdlib
 * Method:    nfree
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_libc_LibCStdlib_nfree
    (JNIEnv *__env, jclass clazz, jlong ptrAddress)
{
    void *ptr = (void *)(uintptr_t)ptrAddress;
    UNUSED_PARAMS(__env, clazz)
    free(ptr);
}

/*
 * Class:     org_box2d_jni_libc_LibCStdlib
 * Method:    naligned_alloc
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_libc_LibCStdlib_naligned_1alloc
    (JNIEnv *__env, jclass clazz, jlong alignment, jlong size)
{
    UNUSED_PARAMS(__env, clazz)
#ifdef _WIN32
    return (jlong)(uintptr_t)_aligned_malloc((size_t)size, (size_t)alignment);
#else
    #if defined(__STDC_VERSION__) && (__STDC_VERSION__ >= 201112L) /* c11 */
        return (jlong)(uintptr_t)aligned_alloc((size_t)alignment, (size_t)size);
    #else
        void *ptr = NULL;
        if (posix_memalign(&ptr, (size_t)alignment, (size_t)size)) {
            return NULL;
        }
        return (jlong)(uintptr_t)ptr;
    #endif
#endif
}

/*
 * Class:     org_box2d_jni_libc_LibCStdlib
 * Method:    naligned_free
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_libc_LibCStdlib_naligned_1free
    (JNIEnv *__env, jclass clazz, jlong address)
{
    void* ptr = (void*)(uintptr_t)address;
    UNUSED_PARAMS(__env, clazz)
#if defined(_WIN32)
    _aligned_free(ptr);
#else
    free(ptr);
#endif
}
