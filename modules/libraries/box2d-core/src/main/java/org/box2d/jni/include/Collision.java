/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni.include;

import org.box2d.jni.system.Library;
import static org.box2d.jni.system.Checks.*;

/**
 * Class that represents the {@code collision.h} header of box2d.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Collision {
    static { Library.initialize(); }
    /* Native bindings: {@code #define B2_MAX_POLYGON_VERTICES 8 */
    public static final int B2_MAX_POLYGON_VERTICES = 8;
}
