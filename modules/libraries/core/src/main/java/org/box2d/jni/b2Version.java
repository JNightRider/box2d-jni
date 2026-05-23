/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.system.Memory.*;
import static org.box2d.jni.system.VarType.*;

/**
 * <pre><code>
 * typedef struct b2Version
 * {
 * 	/// Significant changes
 * 	int major;

 * 	/// Incremental changes
 * 	int minor;

 * 	/// Bug fixes
 * 	int revision;
 * } b2Version;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Version extends Struct<b2Version> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            MAJOR,
            MINOR,
            REVISION;
    
    static {
        Layout layout = __struct(
                __member(Int32t.sizeof()),
                __member(Int32t.sizeof()),
                __member(Int32t.sizeof())
        );
        
        MAJOR = layout.offsetof(0);
        MINOR = layout.offsetof(1);
        REVISION = layout.offsetof(2);
        
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }
    
    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Version(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Version(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     *
     * @see Struct#Struct(long, boolean)
     */
    protected b2Version(long address, boolean factor) {
        super(address, factor);
    }

    /**
     * Initializes this struct with the specified values.
     *
     * @param major the valur {@code major}
     * @param minor the valur {@code minor}
     * @param revision the valur {@code revision}
     *
     * @return b2Version
     */
    public b2Version set(
        int major,
        int minor,
        int revision
    ) {
        major(major);
        minor(minor);
        revision(revision);
        return this;
    }

    /** @return Returns the property {@code major} */
    public int major() { return nmajor(address()); }
    /** @return Returns the property {@code minor} */
    public int minor() { return nminor(address()); }
    /** @return Returns the property {@code revision} */
    public int revision() { return nrevision(address()); }
    
    /**
     * Set the value of property {@code major}
     *
     * @param value The value
     * @return b2Version
     */
    public b2Version major(int value) { nmajor(address(), value); return this; }
    /**
     * Set the value of property {@code minor}
     *
     * @param value The value
     * @return b2Version
     */
    public b2Version minor(int value) { nminor(address(), value); return this; }
    /**
     * Set the value of property {@code revision}
     *
     * @param value The value
     * @return b2Version
     */
    public b2Version revision(int value) { nrevision(address(), value); return this; }
    
    /*(non-Javadoc)
     */
    @Override
    public int sizeof() { return SIZEOF; }
 
    /*(non-Javadoc)
     */
    @Override
    protected b2Version create(long address, Pointer ptr) {
        return ptr == null ? new b2Version(address) : new b2Version(ptr);
    }
    
    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2Version
     */
    private static b2Version factory() {
        return new b2Version(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Version
     */
    public static b2Version createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Version(ptr);
    }
    
    /**
     * Reserve memory for the new object {@code b2Version}.
     *
     * @param alloc Custom memory manager
     * @return b2Version
     */
    public static b2Version alloc(AllocFunc alloc) {
        return new b2Version(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2Version}.
     *
     * @return b2Version
     */
    public static b2Version malloc() {
        return new b2Version(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Version}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Version}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }
    

    // -----------------------------------    
    public static int nmajor(long address) { return memGetInt(address + MAJOR); }
    public static int nminor(long address) { return memGetInt(address + MINOR); }
    public static int nrevision(long address) { return memGetInt(address + REVISION); }

    public static void nmajor(long address, int value) { memPutInt(address + MAJOR, value); }
    public static void nminor(long address, int value) { memPutInt(address + MINOR, value); }
    public static void nrevision(long address, int value) { memPutInt(address + REVISION, value); }
    // -----------------------------------
    
    // -----------------------------------
    
    /** An array of {@code b2Version} structs. */
    public static class Buffer extends StructBuffer<b2Version, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2Version ELEMENT_FACTORY = b2Version.factory();

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

        /*(non-Jabadoc)
         */
        @Override
        protected b2Version getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /*(non-Jabadoc)
         */
        @Override
        protected Buffer self() {
            return this;
        }

        /*(non-Jabadoc)
         */
        @Override
        protected Buffer create(long address, int mark, int position, int limit, int capacity) {
            return new Buffer(address, mark, position, limit, capacity);
        }        
    }
}
