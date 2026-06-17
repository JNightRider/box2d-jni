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
