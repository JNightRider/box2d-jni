/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.system;

import java.util.Iterator;
import java.util.Set;

import static org.box2d.jni.system.Upcalls.*;

/**
 * Utility class for box2d callbacks.
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public final class Callbacks {

    /**
     * Remove all native instances of active callbasck from the registry,
     * bearing in mind that this will invalidate the memory address of all
     * objects.
     */
    public static void b2FreeCallbacks() {
        Set<CallbackI> callbaks = UP_CALLS.keySet();
        Iterator<CallbackI> it = callbaks.iterator();

        while (it.hasNext()) {
            upcallFree(it.next(), false);
            it.remove();
        }
    }

    /**  private constructor. */
    private Callbacks() { }
}
