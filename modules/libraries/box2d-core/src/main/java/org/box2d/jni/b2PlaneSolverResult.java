/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni;

import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2PlaneSolverResult
 * {
 *     b2Vec2 translation;
 *     int iterationCount;
 * } b2PlaneSolverResult;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2PlaneSolverResult extends Struct<b2PlaneSolverResult> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            TRANSLATION,
            ITERATION_COUNT;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4)
        );

        TRANSLATION = layout.offsetof(0);
        ITERATION_COUNT = layout.offsetof(1);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2PlaneSolverResult(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2PlaneSolverResult(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2PlaneSolverResult(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code translation} */
    public b2Vec2 translation() { return ntranslation(address()); }
    /** @return Returns the property {@code iterationCount} */
    public int iterationCount() { return niterationCount(address()); }

    /**
     * Set the value of property {@code translation}
     *
     * @param value b2Vec2
     * @return b2PlaneSolverResult
     */
    public b2PlaneSolverResult translation(b2Vec2 value) {
        ntranslation(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code iterationCount}
     *
     * @param value int
     * @return b2PlaneSolverResult
     */
    public b2PlaneSolverResult iterationCount(int value) {
        niterationCount(address(), value);
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
    protected b2PlaneSolverResult create(long address, Pointer ptr) {
        return ptr == null ? new b2PlaneSolverResult(address) : new b2PlaneSolverResult(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2PlaneSolverResult
     */
    private static b2PlaneSolverResult factory() {
        return new b2PlaneSolverResult(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2PlaneSolverResult
     */
    public static b2PlaneSolverResult createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2PlaneSolverResult(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2PlaneSolverResult}.
     *
     * @param alloc Custom memory manager
     * @return b2PlaneSolverResult
     */
    public static b2PlaneSolverResult alloc(AllocFunc alloc) {
        return new b2PlaneSolverResult(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2PlaneSolverResult}.
     *
     * @return b2PlaneSolverResult
     */
    public static b2PlaneSolverResult malloc() {
        return new b2PlaneSolverResult(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2PlaneSolverResult}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2PlaneSolverResult}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------
    
    public static b2Vec2 ntranslation(long address) { return b2Vec2.createSafe(() -> address + TRANSLATION); }
    public static int niterationCount(long address) { return memGetInt(address + ITERATION_COUNT); }

    public static void ntranslation(long address, b2Vec2 value) { nmemcpy(address + TRANSLATION, value.address(), b2Vec2.SIZEOF); }
    public static void niterationCount(long address, int value) { memPutInt(address + ITERATION_COUNT, value); }
    
    // -----------------------------------

    /** An array of {@code b2PlaneSolverResult} structs. */
    public static class Buffer extends StructBuffer<b2PlaneSolverResult, Buffer> implements JNINative {

        /** An element that provides information about the structure. */
        private static final b2PlaneSolverResult ELEMENT_FACTORY = b2PlaneSolverResult.factory();

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
        protected b2PlaneSolverResult getElementFactory() {
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
