/*
Copyright Night Rider. All rights reserved.
https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.system;

import java.lang.ref.Cleaner;

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
public abstract class Struct<SELF extends Struct<SELF>> implements AutoCloseable, Pointer {

    /** A cleaner for all native objects (pointers | structures) that have been initialized. */
    private static final Cleaner PTR_CLEANER = Cleaner.create();

    /**
     * A virtual memory address that manages a native object through a pointer,
     * whose address can be used to manipulate that native object.
     */
    private long address;
}
