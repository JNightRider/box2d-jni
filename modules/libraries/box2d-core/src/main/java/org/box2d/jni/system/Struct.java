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
package org.box2d.jni.system;

import java.lang.ref.Cleaner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

import org.box2d.jni.readonly.ConstStruct;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Debug.*;
import static org.box2d.jni.system.Pointer.*;

/**
 * <code>Struct</code> class in charge of managing a data structure, said
 * structure is native and is only accessible through its memory address. This
 * object offers methods to facilitate its manipulation.
 * <p>
 * Any data type (class or object) that needs to form native structures can
 * inherit from this class.
 * </p>
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <SELF> A type of structure
 */
public abstract class Struct<SELF extends Struct<SELF>> extends Uintptr implements ConstStruct, AutoCloseable, Pointer {
    
    protected static final int DEFAULT_PACK_ALIGNMENT = Platform.get() == Platform.WINDOWS ? 8 : 0x4000_0000;
    protected static final int DEFAULT_ALIGN_AS       = 0;
    
    static {
        Library.initialize();
    }

    /** A cleaner for all native objects (pointers | structures) that have been initialized. */
    private static final Cleaner PTR_CLEANER = Cleaner.create();    

    /**
     * A class in charge of managing the release status of the physical memory 
     * that is assigned to a native object loaded in a java object.
     */
    protected static class State implements Runnable {
        
        /** Object with a native reference. */
        private final AtomicLong struct;

        /**
         * Generate a new state for resource (memory) release.
         * @param struct Object with a native reference
         */
        public State(AtomicLong struct) {
            this.struct = struct;
        }

        /* (non-Javadoc)
         * @see java.lang.Runnable#run() 
         */
        @Override
        public void run() {
            long address = struct.getAndSet(NULL);
            if (address != NULL) {
                apiLog("Freed memory (struct): " + String.format("[0x%X]", address));
                nfree(address);
            } else {
                apiWarr("An attempt was made to free invalid (previously freed) memory.");
            }
        }
    }

    /** A reference to a native data structure. */
    protected Pointer ptr;
    /** An object in charge of managing the state (release) of a native object. */
    private State state;
    /** The result of registering with the cleaner. */
    private Cleaner.Cleanable cleanable;

    /**
     * Generate a new object (structure) <code>Struct</code> that references a native 
     * object that is still used in the system, such a reference only gives access to 
     * the memory address and <strong>CANNOT RELEASE IT</strong>.
     * <p>
     * <b>NOTE</b> 
     * Be careful when making a reference, as memory will not be freed when you destroy 
     * this object or when it is no longer accessible, so you will have to locate the 
     * original object to destroy it or make it inaccessible for the JVM's GC to clean up.
     * </p>
     * 
     * @param ptr The structure it points to (reference)
     */
    protected Struct(Pointer ptr) {
        super(NULL, false);
        this.ptr = ptr;
    }

    /**
     * Constructor of the <code>Struct</code> class where a data structure is 
     * created to manage and encapsulate the memory address of a native object, 
     * said address is obtained through a native call by the JVM. 
     * <p>
     * Do not use this constructor unless you have a valid memory address (at your own risk).
     * </p>
     * @param address A virtual memory address
     */
    protected Struct(long address) {
        this(address, false);
    }

    /**
     * Constructor of the <code>Struct</code> class where a data structure is
     * created to manage and encapsulate the memory address of a native object,
     * said address is obtained through a native call by the JVM.
     * <p>
     * Do not use this constructor unless you have a valid memory address (at
     * your own risk).
     * </p>
     *
     * @param address A virtual memory address
     * @param factor It is {@code true} if the created structure is intended to
     * provide information and does not point to any virtual memory address;
     * {@code false} if it is a pointer.
     */
    protected Struct(long address, boolean factor) {
        super(address, !factor);
        if (!factor) {
            this.ptr       = null;
            this.state     = new State(this.address);
            this.cleanable = PTR_CLEANER.register(Struct.this, state);
        }
    }

    /* (non-Javadoc)
     * @see java.lang.AutoCloseable#close() 
     */
    @Override
    public void close() {
        if (!validToRelease()) {
            apiWarr("Memory cannot be freed since this object ("
                    + getClass().getName()
                    + ") is a reference: "
                    + String.format("[0x%X]", address()));
            return;
        }
        if (cleanable != null) {
            cleanable.clean();
        } else {
            apiWarr("An attempt was made to remove an object that is not pointing at anything: " + getClass());
        }
    }

    /**
     * Check if this object is releasable.
     * @return boolean
     */
    protected boolean validToRelease() {
        if ((state == null || cleanable == null) && ptr != null) {
            return false;
        }
        return true;
    }
    
    /**
     * Frees the struct allocation.
     *
     * <p>This method should not be used if the memory backing this struct is not owned by the struct.</p>
     */
    protected void free() {
        nfree(address());
    }

    /**
     * Returns {@code sizeof(struct)}.
     *
     * @return long
     */
    public abstract int sizeof();

    /**
     * Similar to {@link #Struct(long) the constructor}, but returns
     * the exact type of the {@code Struct} subclass.
     *
     * <p>
     * Effectively, every {@code Struct} instance is a factory for more
     * instances of the same type. This is used by {@link StructBuffer}.</p>
     *
     * @param address the struct memory address
     * @param ptr The structure it points to (reference)
     * @return Struct|{@code void*}
     */
    protected abstract SELF create(long address, Pointer ptr);

    /** Zeroes-out the struct data. */
    public void clear() {
        nmemset(address(), 0, sizeof());
    }
    
    /* (non-Javadoc) @see org.cube.system.Pointer#address() */
    @Override
    public long address() { return ptr == null ? super.address() : ptr.address(); }
    
    // ---------------- Implementation utilities ----------------
    
    /**
     * A functional interface that enables lambda expressions to be passed to
     * the {@link #validate} method. [INTERNAL USE ONLY]
     */
    @FunctionalInterface
    public interface StructValidation {

        void validate(long struct);
    }

    /**
     * Validates each struct contained in the specified struct array. [INTERNAL
     * USE ONLY]
     *
     * @param array the struct array to validate
     * @param count the number of structs in {@code array}
     * @param SIZEOF the size of each struct, in bytes
     * @param validation the validation
     */
    public static void validate(long array, int count, int SIZEOF, StructValidation validation) {
        for (int i = 0; i < count; i++) {
            validation.validate(array + Integer.toUnsignedLong(i) * SIZEOF);
        }
    }

    public static void validate(long array, long count, int SIZEOF, StructValidation validation) {
        validate(array, (int) count, SIZEOF, validation);
    }

    // ---------------- Struct Member Layout ----------------
    protected static class Member {

        final int size;
        final int alignment;
        final boolean forcedAlignment;

        int offset;

        Member(int size, int alignment, boolean forcedAlignment) {
            this.size = size;
            this.alignment = alignment;
            this.forcedAlignment = forcedAlignment;
        }

        public int getSize() {
            return size;
        }

        public int getAlignment() {
            return alignment;
        }

        public int getAlignment(int packAlignment) {
            return forcedAlignment ? alignment : min(alignment, packAlignment);
        }
    }

    protected static class Layout extends Member {

        final Member[] members;

        Layout(int size, int alignment, boolean forceAlignment, Member[] members) {
            super(size, alignment, forceAlignment);
            this.members = members;
        }

        public int offsetof(int member) {
            return members[member].offset;
        }
    }

    protected static Member __padding(int num, boolean condition) {
        return __padding(num, 1, condition);
    }

    protected static Member __padding(int num, int size, boolean condition) {
        return __member(condition ? num * size : 0, size);
    }

    protected static Member __member(int size) {
        return __member(size, size);
    }

    protected static Member __member(int size, int alignment) {
        return __member(size, alignment, false);
    }

    protected static Member __member(int size, int alignment, boolean forceAlignment) {
        return new Member(size, alignment, forceAlignment);
    }

    protected static Member __array(int size, int length) {
        return __array(size, size, length);
    }

    protected static Member __array(int size, int alignment, int length) {
        return new Member(size * length, alignment, false);
    }

    protected static Member __array(int size, int alignment, boolean forceAlignment, int length) {
        return new Member(size * length, alignment, forceAlignment);
    }

    protected static Layout __union(Member... members) {
        return __union(DEFAULT_PACK_ALIGNMENT, DEFAULT_ALIGN_AS, members);
    }

    protected static Layout __union(int packAlignment, int alignas, Member... members) {
        List<Member> union = new ArrayList<>(members.length);

        int size = 0;
        int alignment = alignas;
        for (Member m : members) {
            size = max(size, m.size);
            alignment = max(alignment, m.getAlignment(packAlignment));

            m.offset = 0;
            union.add(m);
            if (m instanceof Layout) {
                addNestedMembers(m, union, 0);
            }
        }

        return new Layout(size, alignment, alignas != 0, union.toArray(Member[]::new));
    }

    protected static Layout __struct(Member... members) {
        return __struct(DEFAULT_PACK_ALIGNMENT, DEFAULT_ALIGN_AS, members);
    }

    protected static Layout __struct(int packAlignment, int alignas, Member... members) {
        List<Member> struct = new ArrayList<>(members.length);

        int size = 0;
        int alignment = alignas;
        for (Member m : members) {
            int memberAlignment = m.getAlignment(packAlignment);

            m.offset = align(size, memberAlignment);

            size = m.offset + m.size;
            alignment = max(alignment, memberAlignment);

            struct.add(m);
            if (m instanceof Layout) {
                addNestedMembers(m, struct, m.offset);
            }
        }

        // tail padding
        size = align(size, alignment);

        return new Layout(size, alignment, alignas != 0, struct.toArray(Member[]::new));
    }

    private static void addNestedMembers(Member nested, List<Member> members, int offset) {
        Layout layout = (Layout) nested;

        for (Member m : layout.members) {
            m.offset += offset;
            members.add(m);
        }
    }

    private static int align(int offset, int alignment) {
        return ((offset - 1) | (alignment - 1)) + 1;
    }
}
