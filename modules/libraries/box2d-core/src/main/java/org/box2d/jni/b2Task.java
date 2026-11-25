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
import org.box2d.jni.readonly.ConstB2Task;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2Task
 * {
 *     b2TaskCallbackFcn* fcn;
 *     void* context;
 *     b2TaskType type;
 *     bool deferred;
 * } b2Task;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Task extends Struct<b2Task> implements ConstB2Task {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            FCN,
            CONTEXT,
            TYPE,
            DEFERRED;

    static {
        Layout layout = __struct(
                __member(VarType.Uintptrt.sizeof()),
                __member(VarType.Uintptrt.sizeof()),
                __member(4),
                __member(1)
        );

        FCN = layout.offsetof(0);
        CONTEXT = layout.offsetof(1);
        TYPE = layout.offsetof(2);
        DEFERRED = layout.offsetof(3);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Task(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Task(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2Task(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code fcn} */
    @Override
    public long fcn() { return nfcn(address()); }

    /** @return Returns the property {@code context} */
    @Override
    public long context() { return ncontext(address()); }

    /** @return Returns the property {@code type} */
    @Override
    public b2TaskType type() { return ntype(address()); }

    /** @return Returns the property {@code deferred} */
    @Override
    public boolean deferred() { return ndeferred(address()); }

    /**
     * Set the value of property {@code fcn}
     *
     * @param value b2TaskCallbackFcnI
     * @return b2Task
     */
    public b2Task fcn(b2TaskCallbackFcnI value) {
        nfcn(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code context}
     *
     * @param value long
     * @return b2Task
     */
    public b2Task context(long value) {
        ncontext(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code type}
     *
     * @param value b2TaskType
     * @return b2Task
     */
    public b2Task type(b2TaskType value) {
        ntype(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code deferred}
     *
     * @param value boolean
     * @return b2Task
     */
    public b2Task deferred(boolean value) {
        ndeferred(address(), value);
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
    protected b2Task create(long address, Pointer ptr) {
        return ptr == null ? new b2Task(address) : new b2Task(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2Task
     */
    private static b2Task factory() {
        return new b2Task(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Task
     */
    public static b2Task createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Task(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Task}.
     *
     * @param alloc Custom memory manager
     * @return b2Task
     */
    public static b2Task alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2Task(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2Task}.
     *
     * @return b2Task
     */
    public static b2Task calloc() {
        return new b2Task(ncalloc(1, SIZEOF));
    }

    /**
     * Reserve memory for the new object {@code b2Task}.
     *
     * @param arean arena
     * @return b2Task
     */
    public static b2Task calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2Task(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Task}.
     *
     * @return b2Task
     */
    public static b2Task malloc() {
        return new b2Task(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Task}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Task}.
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
     * Reserve an amount n of memory for the object {@code b2Task}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer calloc(int capacity) {
        return new Buffer(ncalloc(capacity, SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Task}.
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
    
    public static long nfcn(long address) { return memGetAddress(address + FCN); }
    public static long ncontext(long address) { return memGetAddress(address + CONTEXT); }
    public static b2TaskType ntype(long address) { return b2TaskType.valueOf(memGetInt(address + TYPE)); }
    public static boolean ndeferred(long address) { return memGetByte(address + DEFERRED) != 0; }

    public static void nfcn(long address, b2TaskCallbackFcnI value) { memPutAddress(address + FCN, value.address()); }
    public static void ncontext(long address, long value) { memPutAddress(address + CONTEXT, value); }
    public static void ntype(long address, b2TaskType value) { memPutInt(address + TYPE, value.value()); }
    public static void ndeferred(long address, boolean value) { memPutByte(address + DEFERRED, (byte) (value ? 1 : 0)); }
    
    // -----------------------------------

    /** An array of {@code b2Task} structs. */
    public static class Buffer extends StructBuffer<b2Task, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2Task ELEMENT_FACTORY = b2Task.factory();

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
        protected b2Task getElementFactory() {
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
