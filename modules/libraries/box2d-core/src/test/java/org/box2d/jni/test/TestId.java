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
package org.box2d.jni.test;

import org.box2d.jni.*;

import static org.box2d.jni.include.Id.*;
import static org.box2d.jni.test.TestMacros.*;

/**
 * A line-by-line Java translation of the box2d 'test/test_id.c' example.
 * <p>
 * Source code: https://github.com/erincatto/box2d/blob/main/test/test_id.c
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class TestId {

    int IdTest( )
    {
        int a = 0x01234567;

        {
            b2WorldId id = b2LoadWorldId( a, b2WorldId.malloc() );
            int b = b2StoreWorldId( id );
            ENSURE( b == a );
        }

        long x = 0x0123456789ABCDEFl;

        {
            b2BodyId id = b2LoadBodyId( x, b2BodyId.malloc() );
            long y = b2StoreBodyId( id );
            ENSURE( x == y );
        }

        {
            b2ShapeId id = b2LoadShapeId( x, b2ShapeId.malloc() );
            long y = b2StoreShapeId( id );
            ENSURE( x == y );
        }

        {
            b2ChainId id = b2LoadChainId( x, b2ChainId.malloc() );
            long y = b2StoreChainId( id );
            ENSURE( x == y );
        }

        {
            b2JointId id = b2LoadJointId( x, b2JointId.malloc() );
            long y = b2StoreJointId( id );
            ENSURE( x == y );
        }

        return 0;
    }
}
