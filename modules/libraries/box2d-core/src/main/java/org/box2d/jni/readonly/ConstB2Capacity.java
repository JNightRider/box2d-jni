/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a constant
 * of type <code>b2Capacity</code>. (native type: const b2Capacity)
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ConstB2Capacity extends ConstStruct {
    /** @return Returns the property {@code staticShapeCount} */
    public int staticShapeCount();
    /** @return Returns the property {@code dynamicShapeCount} */
    public int dynamicShapeCount();
    /** @return Returns the property {@code staticBodyCount} */
    public int staticBodyCount();
    /** @return Returns the property {@code dynamicBodyCount} */
    public int dynamicBodyCount();
    /** @return Returns the property {@code contactCount} */
    public int contactCount();
}
