/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2TreeNodeChildren</code>. (native type: const b2TreeNodeChildren)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2TreeNodeChildren extends ConstStruct {

    /**
     * child node index 1
     *
     * @return int
     */
    int child1();

    /**
     * child node index 2
     *
     * @return int
     */
    int child2();
}
