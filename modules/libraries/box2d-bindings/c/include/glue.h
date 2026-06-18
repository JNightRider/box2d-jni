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
 * File:   glue.h
 * Author: wil
 */

#pragma once

#include <stdint.h>
#include <ffi.h>

// --- [ ffi_type: b2Vec2 ] ---

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

// --- [ ffi_type: b2Rot ] ---

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

// --- [ ffi_type: b2ShapeId ] ---

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

// --- [ ffi_type: b2Transform ] ---

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

// --- [ ffi_type: 2AABB ] ---

static ffi_type* ffi_type_b2AABB_elements[3] = {
    &ffi_type_b2Vec2,
    &ffi_type_b2Vec2,
    NULL
};
static ffi_type ffi_type_b2AABB = {
    .size = 0,
    .alignment = 0,
    .type = FFI_TYPE_STRUCT,
    .elements = ffi_type_b2AABB_elements
};

// --- [ double precision ] ---

#if defined( BOX2D_DOUBLE_PRECISION )
// --- [ ffi_type: b2Pos ] ---

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

// --- [ ffi_type: b2WorldTransform ] ---

static ffi_type* ffi_type_b2WorldTransform_elements[3] = {
    &ffi_type_b2Pos,
    &ffi_type_b2Rot,
    NULL
};
static ffi_type ffi_type_b2WorldTransform = {
    .size = 0,
    .alignment = 0,
    .type = FFI_TYPE_STRUCT,
    .elements = ffi_type_b2WorldTransform_elements
};

#else

#define ffi_type_b2Pos_elements             ffi_type_b2Vec2_elements
#define ffi_type_b2Pos                      ffi_type_b2Vec2          

#define ffi_type_b2WorldTransform_elements  ffi_type_b2Transform_elements
#define ffi_type_b2WorldTransform           ffi_type_b2Transform 

#endif
