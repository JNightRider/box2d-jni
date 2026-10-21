# Box2d JNI

[![Maven Central Version](https://img.shields.io/maven-central/v/io.github.jnightrider/box2d-jni)](https://central.sonatype.com/artifact/io.github.jnightrider/box2d-jni/versions)
[![License: BSD](https://img.shields.io/badge/License-BSD--3-yel)](https://opensource.org/license/BSD-3-clause)

The Box2d-JNI Project provides JVM bindings for [Box2d](https://github.com/erincatto/box2d) Physics Library, to facilitate 
physics simulation in JVM languages such as Java and Kotlin.

Source code (in Java and C) is provided under an [ BSD-3 license](https://github.com/JNightRider/box2d-jni/blob/master/LICENSE).

## Requirements

This project is written in Java and C11 (C17), and uses CMake and Gradle for compilation.

Make sure you have the necessary tools installed on your system before compiling: JVM 17, C11 (MinGW), CMake

## How to use Box2D-JNI in projects

- [Go to the test example](https://github.com/JNightRider/box2d-jni/blob/master/modules/samples/src/main/java/org/box2d/jni/HelloBox2D.java)

## External links

[Official Box2D documentation](https://box2d.org/documentation/)

[Official Box2D repository on GitHub](https://github.com/erincatto/box2d)

## Supported Platforms

Box2d-JNI has been ported to many different platforms.

At the time of release, the following basic configurations have been
tested:

| Architecture      | Operating System            | Compiler | Classifier                 |
|-------------------|-----------------------------|----------|----------------------------|
| AArch64(ARM64)    | Linux/Android (arm64_v8a)   | Clang    | `:android_(Sp/Dp)@aa`      |
| AArch32(ARM32)    | Linux/Android (armeabi_v7a) | Clang    | `:android_(Sp/Dp)@aa`      |
| RISC-V64(riscv64) | Linux/Android (riscv64)     | Clang    | `:android_(Sp/Dp)@aa`      |
| X86               | Linux/Android (x86)         | Clang    | `:android_(Sp/Dp)@aa`      |
| X86-64            | Linux/Android (x86_64)      | Clang    | `:android_(Sp/Dp)@aa`      |
| X86-64            | Linux                       | GCC      | `:linux_x64(Dp/Sp)`        |
| aarch64           | Linux                       | GCC      | `:linux_aarch64(Dp/Sp)`    |
| X86-64            | Windows/MinGW               | GCC      | `:windows_x64(Dp/Sp)`      |
| aarch64           | Windows/MinGW               | Clang    | `:windows_aarch64(Dp/Sp)`  |
| X86-64            | Mac OSX                     | Clang    | `:osx_x64(Dp/Sp)`          |
| aarch64           | Mac OSX                     | Clang    | `:osx_aarch64(Dp/Sp)`      |
