package org.box2d.jni;

import org.box2d.jni.libc.LibC;
import org.box2d.jni.system.Pointer;


public class Main {

    public static void main(String[] args) {
        System.out.println(LibC.sizeof(Pointer.class));
    }
}
