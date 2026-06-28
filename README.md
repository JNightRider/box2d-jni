# Box2d JNI

[![Maven Central Version](https://img.shields.io/maven-central/v/io.github.jnightrider/box2d-jni)](https://central.sonatype.com/artifact/io.github.jnightrider/box2d-jni/versions)
[![License: BSD](https://img.shields.io/badge/License-BSD--3-yel)](https://opensource.org/license/BSD-3-clause)

The Box2d-JNI Project provides JVM bindings for [Box2d](https://github.com/erincatto/box2d) Physics Library, to facilitate 
physics simulation in JVM languages such as Java and Kotlin.

Source code (in Java and C) is provided under an [ BSD-3 license](https://github.com/JNightRider/box2d-jni/blob/master/LICENSE).

**Modules**

- box2d-core: The Java code and links to the native code can be found here.
- box2d-bindings: The C code and the implementation of the links (CMake). 

## Requirements

This project is written in Java and C11 (C17), and uses CMake and Gradle for compilation.

Make sure you have the necessary tools and the **libffi** library installed on your system before compiling.

### Languages and Tools

- Java 17 or higher.
- C17
- CMake

### Libraries

- [Box2d](https://box2d.org/)
- [Libffi](https://sourceware.org/libffi/)

## Supported Platforms

Box2d-JNI has been ported to many different platforms.

At the time of release, the following basic configurations have been
tested:

| Architecture   | Operating System            | Compiler |
|----------------|-----------------------------|----------|
| AArch32(ARM32) | Linux/Android (arm64_v8a)   | Clang    |
| AArch64(ARM64) | Linux/Android (armeabi_v7a) | Clang    |
| X86            | Linux/Android (x86)         | Clang    |
| X86-64         | Linux/Android (x86_64)      | Clang    |
| X86-64         | Linux                       | GCC      |
| X86-64         | Windows/MinGW               | GCC      |
| X86-64         | Mac OSX                     | GCC      |

## Starting Box2d-JNI

Box2d-JNI is a mirror of **box2d**, so the official documentation is valid for those who wish to use this library.

- [Go to the documentation](https://box2d.org/documentation/)
- [Sample (Hello Box2D)](https://github.com/JNightRider/box2d-jni/blob/master/modules/samples/src/main/java/org/box2d/jni/HelloBox2D.java) 
