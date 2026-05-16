/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.libc;

import java.util.HashMap;
import java.util.Map;

import org.box2d.jni.system.Pointer;
import static org.box2d.jni.system.Pointer.*;

/**
 *
 * @author wil
 */
public class LibCVarType {

    public static final int 
            TYPE_CHAR    = 1,
            TYPE_INT     = 2,
            TYPE_FLOAT   = 3,
            TYPE_DOUBLE  = 4,
            TYPE_LONG    = 5,
            TYPE_BOOL    = 6,
            TYPE_POINTER = 7;

    private static final Map<Class, Integer> VAR_TYPE = new HashMap<>();

    static {
        VAR_TYPE.put(Character.TYPE, TYPE_CHAR);
        VAR_TYPE.put(Integer.TYPE, TYPE_INT);
        VAR_TYPE.put(Float.TYPE, TYPE_FLOAT);
        VAR_TYPE.put(Double.TYPE, TYPE_DOUBLE);
        VAR_TYPE.put(Boolean.TYPE, TYPE_BOOL);
        VAR_TYPE.put(Long.TYPE, TYPE_LONG);
        VAR_TYPE.put(Pointer.class, TYPE_POINTER);
    }

    public static int valueOf(Class clazz) {
        Integer varType = VAR_TYPE.get(clazz);
        if (varType == null) {
            return (int) NULL;
        }
        return varType;
    }
}
