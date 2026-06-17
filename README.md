# Box2d JNI

The Box2d-JNI Project provides JVM bindings for [Box2d](https://github.com/erincatto/box2d) Physics Library, to facilitate 
physics simulation in JVM languages such as Java and Kotlin.

**Modules**

- box2d-core: The Java code and links to the native code can be found here.
- box2d-bindings: The C code and the implementation of the links (CMake). 

## Requirements

This project is written in Java and C11 (C17), and uses CMake and Gradle for compilation.

Make sure you have the necessary tools and the **libffi** library installed on your system before compiling.

### Languages ​​and Tools

- Java 17 or higher.
- C17

### Libraries

- [Box2d](https://box2d.org/)
- [Libffi](https://sourceware.org/libffi/)


Source code (in Java and C) is provided under an [ BSD-3 license](https://github.com/JNightRider/box2d-jni/blob/master/LICENSE).
