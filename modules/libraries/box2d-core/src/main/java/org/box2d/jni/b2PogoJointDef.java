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
package org.box2d.jni;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2PogoJointDef;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2PogoJointDef
 * {
 *     b2JointDef base;
 *     b2Vec2 normal;
 *     float hertz;
 *     float dampingRatio;
 *     float restLength;
 *     float maxTensionForce;
 *     float maxCompressionForce;
 *     float impulse;
 *     float velocity;
 *     int internalValue;
 * } b2PogoJointDef;
 * </code></pre>
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.3.0
 */
public class b2PogoJointDef extends Struct<b2PogoJointDef> implements ConstB2PogoJointDef {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            BASE,
            NORMAL,
            HERTZ,
            DAMPING_RATIO,
            REST_LENGTH,
            MAX_TENSION_FORCE,
            MAX_COMPRESSION_FORCE,
            IMPULSE,
            VELOCITY,
            INTERNAL_VALUE;

    static {
        Layout layout = __struct(
                __member(b2JointDef.SIZEOF, b2JointDef.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4)
        );

        BASE = layout.offsetof(0);
        NORMAL = layout.offsetof(1);
        HERTZ = layout.offsetof(2);
        DAMPING_RATIO = layout.offsetof(3);
        REST_LENGTH = layout.offsetof(4);
        MAX_TENSION_FORCE = layout.offsetof(5);
        MAX_COMPRESSION_FORCE = layout.offsetof(6);
        IMPULSE = layout.offsetof(7);
        VELOCITY = layout.offsetof(8);
        INTERNAL_VALUE = layout.offsetof(9);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2PogoJointDef(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2PogoJointDef(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2PogoJointDef(long address, boolean factor) {
        super(address, factor);
    }
    
    /** @return Returns the property {@code base} */
    @Override
    public b2JointDef base() { return nbase(address()); }
    /** @return Returns the property {@code normal} */
    @Override
    public b2Vec2 normal() { return nnormal(address()); }
    /** @return Returns the property {@code hertz} */
    @Override
    public float hertz() { return nhertz(address()); }
    /** @return Returns the property {@code dampingRatio} */
    @Override
    public float dampingRatio() { return ndampingRatio(address()); }
    /** @return Returns the property {@code restLength} */
    @Override
    public float restLength() { return nrestLength(address()); }
    /** @return Returns the property {@code maxTensionForce} */
    @Override
    public float maxTensionForce() { return nmaxTensionForce(address()); }
    /** @return Returns the property {@code maxCompressionForce} */
    @Override
    public float maxCompressionForce() { return nmaxCompressionForce(address()); }
    /** @return Returns the property {@code impulse} */
    @Override
    public float impulse() { return nimpulse(address()); }
    /** @return Returns the property {@code velocity} */
    @Override
    public float velocity() { return nvelocity(address()); }
    /** @return Returns the property {@code internalValue} */
    @Override
    public int internalValue() { return ninternalValue(address()); }

    /**
     * Set the value of property {@code base}
     * 
     * @param value b2JointDef
     * @return b2PogoJointDef
     */
    public b2PogoJointDef base(b2JointDef value) {
        nbase(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code normal}
     * 
     * @param value b2Vec2
     * @return b2PogoJointDef
     */
    public b2PogoJointDef normal(b2Vec2 value) {
        nnormal(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code hertz}
     * 
     * @param value float
     * @return b2PogoJointDef
     */
    public b2PogoJointDef hertz(float value) {
        nhertz(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code dampingRatio}
     * 
     * @param value float
     * @return b2PogoJointDef
     */
    public b2PogoJointDef dampingRatio(float value) {
        ndampingRatio(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code restLength}
     * 
     * @param value float
     * @return b2PogoJointDef
     */
    public b2PogoJointDef restLength(float value) {
        nrestLength(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code maxTensionForce}
     * 
     * @param value float
     * @return b2PogoJointDef
     */
    public b2PogoJointDef maxTensionForce(float value) {
        nmaxTensionForce(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code maxCompressionForce}
     * 
     * @param value float
     * @return b2PogoJointDef
     */
    public b2PogoJointDef maxCompressionForce(float value) {
        nmaxCompressionForce(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code impulse}
     * 
     * @param value float
     * @return b2PogoJointDef
     */
    public b2PogoJointDef impulse(float value) {
        nimpulse(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code velocity}
     * 
     * @param value float
     * @return b2PogoJointDef
     */
    public b2PogoJointDef velocity(float value) {
        nvelocity(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code internalValue}
     * 
     * @param value int
     * @return b2PogoJointDef
     */
    public b2PogoJointDef internalValue(int value) {
        ninternalValue(address(), value);
        return this;
    }
    
    /*(non-Javadoc)
     */
    @Override
    public int sizeof() {
        return SIZEOF;
    }

    /*(non-Javadoc)
     */
    @Override
    protected b2PogoJointDef create(long address, Pointer ptr) {
        return ptr == null ? new b2PogoJointDef(address) : new b2PogoJointDef(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2PogoJointDef
     */
    private static b2PogoJointDef factory() {
        return new b2PogoJointDef(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2PogoJointDef
     */
    public static b2PogoJointDef createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2PogoJointDef(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2PogoJointDef}.
     *
     * @param alloc Custom memory manager
     * @return b2PogoJointDef
     */
    public static b2PogoJointDef alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2PogoJointDef(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2PogoJointDef}.
     *
     * @return b2PogoJointDef
     */
    public static b2PogoJointDef calloc() {
        return new b2PogoJointDef(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2PogoJointDef}.
     *
     * @param arean arena
     * @return b2PogoJointDef
     */
    public static b2PogoJointDef calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2PogoJointDef(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2PogoJointDef}.
     *
     * @return b2PogoJointDef
     */
    public static b2PogoJointDef malloc() {
        return new b2PogoJointDef(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2PogoJointDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2PogoJointDef}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, capacity, SIZEOF);
        return new Buffer(address, capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2PogoJointDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2PogoJointDef}.
     *
     * @param capacity Number of elements
     * @param arena Arean
     * @return Buffer
     */
    public static Buffer calloc(int capacity, ArenaAlloc arena) {
        long ptr = arena.ncalloc(ALIGNOF, capacity, SIZEOF);
        return new Buffer(ptr, capacity);
    }

    // -----------------------------------

    public static b2JointDef nbase(long address)            { return b2JointDef.createSafe(() -> address + BASE);  }
    public static b2Vec2 nnormal(long address)              { return b2Vec2.createSafe(() -> address + NORMAL);    }
    public static float nhertz(long address)                { return memGetFloat(address + HERTZ);                 }
    public static float ndampingRatio(long address)         { return memGetFloat(address + DAMPING_RATIO);         }
    public static float nrestLength(long address)           { return memGetFloat(address + REST_LENGTH);           }
    public static float nmaxTensionForce(long address)      { return memGetFloat(address + MAX_TENSION_FORCE);     }
    public static float nmaxCompressionForce(long address)  { return memGetFloat(address + MAX_COMPRESSION_FORCE); }
    public static float nimpulse(long address)              { return memGetFloat(address + IMPULSE);               }
    public static float nvelocity(long address)             { return memGetFloat(address + VELOCITY);              }
    public static int ninternalValue(long address)          { return memGetInt(address + INTERNAL_VALUE);          }

    public static void nbase(long address, b2JointDef value)           { nmemcpy(address + BASE, value.address(), b2JointDef.SIZEOF); }
    public static void nnormal(long address, b2Vec2 value)             { nmemcpy(address + NORMAL, value.address(), b2Vec2.SIZEOF);   }
    public static void nhertz(long address, float value)               { memPutFloat(address + HERTZ, value);                               }
    public static void ndampingRatio(long address, float value)        { memPutFloat(address + DAMPING_RATIO, value);                       }
    public static void nrestLength(long address, float value)          { memPutFloat(address + REST_LENGTH, value);                         }
    public static void nmaxTensionForce(long address, float value)     { memPutFloat(address + MAX_TENSION_FORCE, value);                   }
    public static void nmaxCompressionForce(long address, float value) { memPutFloat(address + MAX_COMPRESSION_FORCE, value);               }
    public static void nimpulse(long address, float value)             { memPutFloat(address + IMPULSE, value);                             }
    public static void nvelocity(long address, float value)            { memPutFloat(address + VELOCITY, value);                            }
    public static void ninternalValue(long address, int value)         { memPutInt(address + INTERNAL_VALUE, value);                        }
    
    // -----------------------------------

    /** An array of {@code b2PogoJointDef} structs. */
    public static class Buffer extends StructBuffer<b2PogoJointDef, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2PogoJointDef ELEMENT_FACTORY = b2PogoJointDef.factory();

        /**
         * Create a new buffer.
         *
         * @param address long
         * @param remaining int
         */
        public Buffer(long address, int remaining) {
            super(address, remaining);
        }

        /**
         * Create a new buffer.
         *
         * @param address long
         * @param mark int
         * @param position int
         * @param limit int
         * @param capacity int
         */
        public Buffer(long address, int mark, int position, int limit, int capacity) {
            super(address, mark, position, limit, capacity);
        }

        /*(non-Javadoc)
         */
        @Override
        protected b2PogoJointDef getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /*(non-Javadoc)
         */
        @Override
        protected Buffer self() {
            return this;
        }

        /*(non-Javadoc)
         */
        @Override
        protected Buffer create(long address, int mark, int position, int limit, int capacity) {
            return new Buffer(address, mark, position, limit, capacity);
        }
    }
}

