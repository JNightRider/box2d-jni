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
 * File:   org_box2d_jni_libc_LibCString.h
 * Author: wil
 */

 #include <string.h>

#include "common_tools.h"
#include "box2d/jni/org_box2d_jni_libc_LibCString.h"

/*
 * Class:     org_box2d_jni_libc_LibCString
 * Method:    nmemset
 * Signature: (JIJ)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_libc_LibCString_nmemset
    (JNIEnv *__env, jclass clazz, jlong address, jint value, jlong num)
{
    jlong __result;
    UNUSED_PARAMS(__env, clazz)
    __result = (jlong)(uintptr_t) memset((void *)address, (int)value, (size_t)num);
    return __result;
}

/*
 * Class:     org_box2d_jni_libc_LibCString
 * Method:    nmemcpy
 * Signature: (JJJ)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_libc_LibCString_nmemcpy
    (JNIEnv *__env, jclass clazz, jlong dest, jlong src, jlong n)
{
    jlong __result;
    UNUSED_PARAMS(__env, clazz)
    __result = (jlong)(uintptr_t) memcpy((void *)dest, (const void*) src, (size_t) n);
    return __result;
}

/*
 * Class:     org_box2d_jni_libc_LibCString
 * Method:    nstrlen
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_libc_LibCString_nstrlen
    (JNIEnv *__env, jclass clazz, jlong s)
{
    jlong __result;
    UNUSED_PARAMS(__env, clazz)
    __result = (jlong)(size_t) strlen((char*)s);
    return __result;
}
