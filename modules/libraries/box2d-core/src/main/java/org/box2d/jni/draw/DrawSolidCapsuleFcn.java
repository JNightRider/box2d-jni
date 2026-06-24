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
package org.box2d.jni.draw;

import org.box2d.jni.b2Pos;
import org.box2d.jni.system.Callback;
import org.box2d.jni.system.Checks;

/**
 * Callback function: {@code void ( *DrawSolidCapsuleFcn )( b2Pos p1, b2Pos p2, float radius, b2HexColor color, void* context ); }
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class DrawSolidCapsuleFcn extends Callback implements DrawSolidCapsuleFcnI {

    /**
     * Callback flag
     * @see DrawSolidCapsuleFcn#isByValue()
     */
    protected boolean byValue;

    /**
     * Create a callback instance using libffi.
     *
     * @param address A virtual memory address
     */
    public DrawSolidCapsuleFcn(long address) {
        super(address);
    }

    /**
     * Modify the way arguments are provided for the invoked function.
     *
     * @see DrawSolidCapsuleFcn#isByValue()
     *
     * @param byValue boolean
     */
    public void byValue(boolean byValue) {
        this.byValue = byValue;
    }

    /* (non-Javadoc)
     */
    @Override
    public boolean isByValue() {
        return this.byValue;
    }

    /**
     * Create a new empty object of type {@code DrawSolidCapsuleFcn}.
     *
     * @param delegate the dynamic function handler.
     * @return DrawSolidCapsuleFcn
     */
    public static DrawSolidCapsuleFcn create(DrawSolidCapsuleFcnI delegate) {
        if (delegate == null) {
            return null;
        }

        if (delegate instanceof DrawSolidCapsuleFcn) {
            return (DrawSolidCapsuleFcn) delegate;
        }

        long address = delegate.address();
        if (!Checks.isValidPointer(address)) {
            return null;
        }
        return new Container(address, delegate);
    }

    /**
     * Container that handles the dynamic function.
     */
    private static final class Container extends DrawSolidCapsuleFcn {

        /**The dynamic or lambda function. */
        private final DrawSolidCapsuleFcnI delegate;

        /**
         * Create a new container to handle the <code>DrawSolidCapsuleFcn</code> function.
         *
         * @param address long
         * @param delegate DrawSolidCapsuleFcn|function
         */
        public Container(long address, DrawSolidCapsuleFcnI delegate) {
            super(address);
            this.delegate = delegate;
        }

        /*(non-Javadoc)
         */
        @Override
        public void invoke(b2Pos p1, b2Pos p2, float radius, int color, long context) {
            delegate.invoke(p1, p2, radius, color, context);
        }
    }
}
