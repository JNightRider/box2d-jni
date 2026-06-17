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
 * File:   org_box2d_jni_libc_LibCMath.h
 * Author: wil
 */

#include <stdlib.h>
#include <math.h>

#include "common_tools.h"
#include "box2d/jni/org_box2d_jni_libc_LibCMath.h"

/*
 * Class:     org_box2d_jni_libc_LibCMath
 * Method:    ncosf
 * Signature: (F)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_libc_LibCMath_ncosf
(JNIEnv *__env, jclass clazz, jfloat a)
{
    return (jfloat)cosf(a);
}

/*
 * Class:     org_box2d_jni_libc_LibCMath
 * Method:    nsinf
 * Signature: (F)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_libc_LibCMath_nsinf
(JNIEnv *__env, jclass clazz, jfloat a)
{
    return (jfloat)sinf(a);
}

/*
 * Class:     org_box2d_jni_libc_LibCMath
 * Method:    natan2f
 * Signature: (FF)F
 */
JNIEXPORT jfloat JNICALL Java_org_box2d_jni_libc_LibCMath_natan2f
(JNIEnv *__env, jclass clazz, jfloat y, jfloat x)
{
    return (jfloat)atan2f(y, x);
}
