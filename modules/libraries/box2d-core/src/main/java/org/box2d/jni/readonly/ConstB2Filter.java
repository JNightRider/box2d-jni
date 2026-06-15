/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2Filter</code>. (native type: const b2Filter)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2Filter extends ConstStruct {

    /**
     * The collision category bits. Normally you would just set one bit. The
     * category bits should represent your application object types.
     *
     * @return long
     */
    long categoryBits();

    /**
     * The collision mask bits. This states the categories that this shape would
     * accept for collision. For example, you may want your player to only
     * collide with static objects and other players.
     *
     * @return long
     */
    long maskBits();

    /**
     * Collision groups allow a certain group of objects to never collide
     * (negative) or always collide (positive). A group index of zero has no
     * effect. Non-zero group filtering always wins against the mask bits. For
     * example, you may want ragdolls to collide with other ragdolls but you
     * don't want ragdoll self-collision. In this case you would give each
     * ragdoll a unique negative group index and apply that group index to all
     * shapes on the ragdoll.
     *
     * @return int
     */
    int groupIndex();
}
