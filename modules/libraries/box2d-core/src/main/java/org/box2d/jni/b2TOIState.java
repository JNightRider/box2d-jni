/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.Library;

/**
 * <pre><code>
 * typedef enum b2TOIState
 * {
 *     b2_toiStateUnknown,
 *     b2_toiStateFailed,
 *     b2_toiStateOverlapped,
 *     b2_toiStateHit,
 *     b2_toiStateSeparated
 * } b2TOIState;
 * </code></pre>
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public enum b2TOIState {

    /**
     * <pre><code>
     * b2_toiStateUnknown -&#62; box2d
     * </code></pre>
     */
    b2_toiStateUnknown(
        nb2_toiStateUnknown()
    ),

    /**
     * <pre><code>
     * b2_toiStateFailed -&#62; box2d
     * </code></pre>
     */
    b2_toiStateFailed(
        nb2_toiStateFailed()
    ),

    /**
     * <pre><code>
     * b2_toiStateOverlapped -&#62; box2d
     * </code></pre>
     */
    b2_toiStateOverlapped(
        nb2_toiStateOverlapped()
    ),

    /**
     * <pre><code>
     * b2_toiStateHit -&#62; box2d
     * </code></pre>
     */
    b2_toiStateHit(
        nb2_toiStateHit()
    ),

    /**
     * <pre><code>
     * b2_toiStateSeparated -&#62; box2d
     * </code></pre>
     */
    b2_toiStateSeparated(
        nb2_toiStateSeparated()
    );

    static {
        Library.initialize();
    }

    /**
     * An integer value that identifies the body type natively, that is, it is the native body type.
     */
    private final Integer b2Type;

    /**
     * Generate a new <code>b2TOIState</code>.
     * @param b2Type type
     */
    private b2TOIState(Integer b2Type) {
        this.b2Type = b2Type;
    }

    /**
     * Returns the native type
     * @return int
     */
    protected Integer value() {
        return b2Type;
    }

    /**
     * Evaluate the native type to return an enumerated object ready to be consumed.
     * @param type type
     * @return TOI state
     */
    public static b2TOIState valueOf(int type) {
        if (type == b2_toiStateUnknown.value()) {
            return b2_toiStateUnknown;
        } else if (type == b2_toiStateFailed.value()) {
            return b2_toiStateFailed;
        } else if (type == b2_toiStateOverlapped.value()) {
            return b2_toiStateOverlapped;
        } else if (type == b2_toiStateHit.value()) {
            return b2_toiStateHit;
        } else if (type == b2_toiStateSeparated.value()) {
            return b2_toiStateSeparated;
        }
        throw new UnsupportedOperationException("enum: " + type);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.valueOf(b2Type);
    }

    /* Binding JNI to property 'b2_toiStateUnknown' of structure 'b2TOIState' */
    public static native int nb2_toiStateUnknown();
    /* Binding JNI to property 'b2_toiStateFailed' of structure 'b2TOIState' */
    public static native int nb2_toiStateFailed();
    /* Binding JNI to property 'b2_toiStateOverlapped' of structure 'b2TOIState' */
    public static native int nb2_toiStateOverlapped();
    /* Binding JNI to property 'b2_toiStateHit' of structure 'b2TOIState' */
    public static native int nb2_toiStateHit();
    /* Binding JNI to property 'b2_toiStateSeparated' of structure 'b2TOIState' */
    public static native int nb2_toiStateSeparated();
}
