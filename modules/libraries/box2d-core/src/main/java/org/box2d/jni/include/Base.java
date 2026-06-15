/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.include;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;

import org.box2d.jni.*;
import org.box2d.jni.system.Library;
import static org.box2d.jni.system.Checks.*;

/**
 * Base functionality
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Base {
    static { Library.initialize(); }
    /* Native bindings: {@code #define B2_HASH_INIT 5381} */
    public static final int B2_HASH_INIT = 5381;
    
    // --- [ b2SetAllocator ] ---

    /**
     * {@code B2_API void b2SetAllocator( b2AllocFcn* allocFcn, b2FreeFcn* freeFcn ); }
     *
     * @param allocFcn b2AllocFcnI
     * @param freeFcn b2FreeFcnI
     */
    public static void b2SetAllocator(b2AllocFcnI allocFcn, b2FreeFcnI freeFcn) {
        checkPointers(allocFcn, freeFcn);
        nb2SetAllocator(allocFcn.address(), freeFcn.address());
    }
    /* {@code B2_API void b2SetAllocator( b2AllocFcn* allocFcn, b2FreeFcn* freeFcn ); } */
    public static native void nb2SetAllocator(long allocFcn, long freeFcn);


    // --- [ b2GetByteCount ] ---

    /**
     * {@code B2_API int64_t b2GetByteCount( void ); }
     *
     * @return long
     */
    public static long b2GetByteCount() {
        return nb2GetByteCount();
    }
    /* {@code B2_API int64_t b2GetByteCount( void ); } */
    public static native long nb2GetByteCount();


    // --- [ b2SetAssertFcn ] ---

    /**
     * {@code B2_API void b2SetAssertFcn( b2AssertFcn* assertFcn ); }
     *
     * @param assertFcn b2AssertFcnI
     * @return b2AssertFcn
     */
    public static b2AssertFcn b2SetAssertFcn(b2AssertFcnI assertFcn) {
        checkPointers(assertFcn);
        nb2SetAssertFcn(assertFcn.address());
        return b2AssertFcn.create(assertFcn);
    }
    /* {@code B2_API void b2SetAssertFcn( b2AssertFcn* assertFcn ); } */
    public static native void nb2SetAssertFcn(long assertFcn);


    // --- [ b2SetLogFcn ] ---

    /**
     * {@code B2_API void b2SetLogFcn( b2LogFcn* logFcn ); }
     *
     * @param logFcn b2LogFcnI
     * @return b2LogFcn
     */
    public static b2LogFcn b2SetLogFcn(b2LogFcnI logFcn) {
        checkPointers(logFcn);
        nb2SetLogFcn(logFcn.address());
        return b2LogFcn.create(logFcn);
    }
    /* {@code B2_API void b2SetLogFcn( b2LogFcn* logFcn ); } */
    public static native void nb2SetLogFcn(long logFcn);

    // --- [ b2GetVersion ] ---

    /**
     * {@code B2_API b2Version b2GetVersion( void ); }
     *
     * @param __result b2Version
     * @return b2Version
     */
    public static b2Version b2GetVersion(b2Version __result) {
        checkPointers(__result);
        nb2GetVersion(__result.address());
        return __result;
    }
    /* {@code B2_API b2Version b2GetVersion( void ); } */
    public static native void nb2GetVersion(long __result);
    
    // --- [ b2GetTicks ] ---

    /**
     * {@code B2_API uint64_t b2GetTicks( void ); }
     *
     * @return long
     */
    public static long b2GetTicks() {
        return nb2GetTicks();
    }
    /* {@code B2_API uint64_t b2GetTicks( void ); } */
    public static native long nb2GetTicks();

    // --- [ b2GetMilliseconds ] ---

    /**
     * {@code B2_API float b2GetMilliseconds( uint64_t ticks ); }
     *
     * @param ticks long
     * @return float
     */
    public static float b2GetMilliseconds(long ticks) {
        return nb2GetMilliseconds(ticks);
    }
    /* {@code B2_API float b2GetMilliseconds( uint64_t ticks ); } */
    public static native float nb2GetMilliseconds(long ticks);

    // --- [ b2GetMillisecondsAndReset ] ---

    /**
     * {@code B2_API float b2GetMillisecondsAndReset( uint64_t* ticks ); }
     *
     * @param ticks LongBuffer
     * @return float
     */
    public static float b2GetMillisecondsAndReset(LongBuffer ticks) {
        return nb2GetMillisecondsAndReset(ticks);
    }
    /* {@code B2_API float b2GetMillisecondsAndReset( uint64_t* ticks ); } */
    public static native float nb2GetMillisecondsAndReset(LongBuffer ticks);

    // --- [ b2Yield ] ---

    /**
     * {@code B2_API void b2Yield( void ); }
     */
    public static void b2Yield() {
        nb2Yield();
    }
    /* {@code B2_API void b2Yield( void ); } */
    public static native void nb2Yield();

    // --- [ b2Hash ] ---

    /**
     * {@code B2_API uint32_t b2Hash( uint32_t hash, const uint8_t* data, int count ); }
     *
     * @param hash int
     * @param data ByteBuffer
     * @param count int
     * @return int
     */
    public static int b2Hash(int hash, ByteBuffer data, int count) {
        return nb2Hash(hash, data, count);
    }
    /* {@code B2_API uint32_t b2Hash( uint32_t hash, const uint8_t* data, int count ); } */
    public static native int nb2Hash(int hash, ByteBuffer data, int count);
    /** private constructor. */
    private Base() {}
}
