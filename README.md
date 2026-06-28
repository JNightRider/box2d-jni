# Box2d JNI

[![Maven Central Version](https://img.shields.io/maven-central/v/io.github.jnightrider/box2d-jni)](https://central.sonatype.com/artifact/io.github.jnightrider/box2d-jni/versions)
[![License: BSD](https://img.shields.io/badge/License-BSD--3-yel)](https://opensource.org/license/BSD-3-clause)

The Box2d-JNI Project provides JVM bindings for [Box2d](https://github.com/erincatto/box2d) Physics Library, to facilitate 
physics simulation in JVM languages such as Java and Kotlin.

Source code (in Java and C) is provided under an [ BSD-3 license](https://github.com/JNightRider/box2d-jni/blob/master/LICENSE).

## Requirements

This project is written in Java and C11 (C17), and uses CMake and Gradle for compilation.

Make sure you have the necessary tools installed on your system before compiling: JVM 17, C11 (MinGW), CMake

## Supported Platforms

Box2d-JNI has been ported to many different platforms.

At the time of release, the following basic configurations have been
tested:

| Architecture   | Operating System            | Compiler | Classifier                |
|----------------|-----------------------------|----------|---------------------------|
| AArch32(ARM32) | Linux/Android (arm64_v8a)   | Clang    | `:android(@aar)`          |
| AArch64(ARM64) | Linux/Android (armeabi_v7a) | Clang    | `:android(@aar)`          |
| X86            | Linux/Android (x86)         | Clang    | `:android(@aar)`          |
| X86-64         | Linux/Android (x86_64)      | Clang    | `:android(@aar)`          |
| X86-64         | Linux                       | GCC      | `:linux_x64(Dp/Sp)`       |
| X86-64         | Windows/MinGW               | GCC      | `:windows_x64(Dp/Sp)`     |
| X86-64         | Mac OSX                     | Clang    | `:osx_x64(Dp/Sp)`         |
| aarch64        | Linux                       | GCC      | `:linux_aarch64(Dp/Sp)`   |
| aarch64        | Windows/MinGW               | Clang    | `:windows_aarch64(Dp/Sp)` |
| aarch64        | Mac OSX                     | Clang    | `:osx_aarch64(Dp/Sp)`     |

## Starting Box2d-JNI

Box2d-JNI is a mirror of **box2d**, so the official documentation is valid for those who wish to use this library.

- [Go to the documentation](https://box2d.org/documentation/)
- [Sample (Hello Box2D)](https://github.com/JNightRider/box2d-jni/blob/master/modules/samples/src/main/java/org/box2d/jni/HelloBox2D.java) 
