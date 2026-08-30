cmake_minimum_required(VERSION 3.22.1)
project(box2d-bindings
    VERSION 1.0.0
    DESCRIPTION "An implementation of the Box2D physics engine for Java (JNI)"
    LANGUAGES C
)

set(CMAKE_C_STANDARD 11)
set(CMAKE_C_STANDARD_REQUIRED ON)

set(BUILD_SHARED_LIBS OFF)

set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/natives)
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/natives)
set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/natives)

set(BINDINGS_SUFFIX "" CACHE STRING "Native library suffix")

# Box2D configuration for JNI
set(BOX2D_SAMPLES OFF CACHE BOOL "" FORCE)
set(BOX2D_BENCHMARKS OFF CACHE BOOL "" FORCE)
set(BOX2D_DOCS OFF CACHE BOOL "" FORCE)
set(BOX2D_UNIT_TESTS OFF CACHE BOOL "" FORCE)
set(BOX2D_PROFILE OFF CACHE BOOL "" FORCE)
set(BOX2D_VALIDATE OFF CACHE BOOL "" FORCE)
set(BOX2D_DISABLE_SIMD OFF CACHE BOOL "" FORCE)

if(NOT DEFINED BOX2D_DOUBLE_PRECISION)
    set(BOX2D_DOUBLE_PRECISION OFF CACHE BOOL "" FORCE)
endif()

if(TYPE_DEBUG)
    set(CMAKE_BUILD_TYPE Debug)
    set(B2_ENABLE_ASSERT ON)
else()
    set(CMAKE_BUILD_TYPE Release)
    set(B2_ENABLE_ASSERT OFF)
endif()

# Dependencies
# libffi
include(ExternalProject)
set(LIBFFI_PREFIX ${CMAKE_BINARY_DIR}/extern/libffi)

if(CMAKE_SYSTEM_NAME STREQUAL "Android")
    message(STATUS "Compiling libffi on Android")
    # Native library suffix
    if(BOX2D_DOUBLE_PRECISION)
        set(BINDINGS_SUFFIX "_${CMAKE_BUILD_TYPE}Dp")
    else()
        set(BINDINGS_SUFFIX "_${CMAKE_BUILD_TYPE}Sp")
    endif()

    message(STATUS "BOX2D_DOUBLE_PRECISION=${BOX2D_DOUBLE_PRECISION}")
    message(STATUS "CMAKE_BUILD_TYPE=${CMAKE_BUILD_TYPE}")
    message(STATUS "BINDINGS_SUFFIX=${BINDINGS_SUFFIX}")

    # Android NDK toolchain
    if(NOT BINDINGS_ANDROID_HOME)
        message(FATAL_ERROR "ANDROID_TOOLCHAIN_BIN not set")
    endif()
    set(ANDROID_TOOLCHAIN_BIN
        "${ANDROID_NDK}/toolchains/llvm/prebuilt/${BINDINGS_ANDROID_HOME}/bin")

    # Determine target from ABI
    if(ANDROID_ABI STREQUAL "arm64-v8a")
        set(CLANG_TRIPLE "aarch64-linux-android")
        set(AUTOTOOLS_HOST "aarch64-linux-android")
    elseif(ANDROID_ABI STREQUAL "armeabi-v7a")
        set(CLANG_TRIPLE "armv7a-linux-androideabi")
        set(AUTOTOOLS_HOST "arm-linux-androideabi")
    elseif(ANDROID_ABI STREQUAL "x86")
        set(CLANG_TRIPLE "i686-linux-android")
        set(AUTOTOOLS_HOST "i686-linux-android")
    elseif(ANDROID_ABI STREQUAL "x86_64")
        set(CLANG_TRIPLE "x86_64-linux-android")
        set(AUTOTOOLS_HOST "x86_64-linux-android")
    elseif(ANDROID_ABI STREQUAL "riscv64")
        set(CLANG_TRIPLE "riscv64-linux-android")
        set(AUTOTOOLS_HOST "riscv64-linux-android")
    else()
        message(FATAL_ERROR "Unsupported Android ABI: ${ANDROID_ABI}")
    endif()

    set(ANDROID_TOOLCHAIN_BIN "${ANDROID_NDK}/toolchains/llvm/prebuilt/linux-x86_64/bin")
    set(ANDROID_CC "${ANDROID_TOOLCHAIN_BIN}/${CLANG_TRIPLE}${ANDROID_PLATFORM_LEVEL}-clang")
    set(ANDROID_AR "${ANDROID_TOOLCHAIN_BIN}/llvm-ar")
    set(ANDROID_RANLIB "${ANDROID_TOOLCHAIN_BIN}/llvm-ranlib")

    message(STATUS "ANDROID_ABI=${ANDROID_ABI}")
    message(STATUS "ANDROID_NATIVE_API_LEVEL=${ANDROID_NATIVE_API_LEVEL}")
    message(STATUS "ANDROID_TOOLCHAIN_BIN=${ANDROID_TOOLCHAIN_BIN}")
    message(STATUS "ANDROID_CC=${ANDROID_CC}")
    message(STATUS "ANDROID_AR=${ANDROID_AR}")
    message(STATUS "ANDROID_RANLIB=${ANDROID_RANLIB}")

    ExternalProject_Add(libffi_project
        SOURCE_DIR ${CMAKE_SOURCE_DIR}/extern/libffi
        CONFIGURE_COMMAND
            env
            CC=${ANDROID_CC}
            AR=${ANDROID_AR}
            RANLIB=${ANDROID_RANLIB}

            ./configure
            --host=${AUTOTOOLS_HOST}
            --prefix=${LIBFFI_PREFIX}
            --disable-shared
            --enable-static
            --disable-docs
            CFLAGS=-fPIC

        BUILD_COMMAND make -j
        INSTALL_COMMAND make install

        BUILD_BYPRODUCTS
            ${LIBFFI_PREFIX}/lib/libffi.a

        BUILD_IN_SOURCE 1
    )
else()
    # Configure JNI headers
    find_package(JNI REQUIRED)

    if(UNIX OR APPLE)
        message(STATUS "Compiling libffi on Unix")

        ExternalProject_Add(libffi_project
            SOURCE_DIR ${CMAKE_SOURCE_DIR}/extern/libffi
            CONFIGURE_COMMAND
                ./configure
                --prefix=${LIBFFI_PREFIX}
                --disable-shared
                --enable-static
                --disable-docs
                CFLAGS=-fPIC

            BUILD_COMMAND make -j
            INSTALL_COMMAND make install

            BUILD_BYPRODUCTS
                ${LIBFFI_PREFIX}/lib/libffi.a

            BUILD_IN_SOURCE 1
        )
    elseif(MINGW)
        message(STATUS "Compiling libffi on Windows with MINGW")

        find_program(BASH_EXECUTABLE bash)
        ExternalProject_Add(libffi_project
            SOURCE_DIR ${CMAKE_SOURCE_DIR}/extern/libffi
            CONFIGURE_COMMAND
                ${BASH_EXECUTABLE}  -lc "./configure --prefix=${LIBFFI_PREFIX} --disable-shared --enable-static --disable-docs"

            BUILD_COMMAND ${BASH_EXECUTABLE}  -lc "make -j"
            INSTALL_COMMAND ${BASH_EXECUTABLE}  -lc "make install"

            BUILD_BYPRODUCTS
                ${LIBFFI_PREFIX}/lib/libffi.a

            BUILD_IN_SOURCE 1
        )
    else()
        message(FATAL_ERROR "GNU|MINGW tools are required to compile this project.")
    endif()
endif()

add_library(ffi STATIC IMPORTED GLOBAL)
set_target_properties(ffi PROPERTIES
    IMPORTED_LOCATION
        ${LIBFFI_PREFIX}/lib/libffi.a
)
add_dependencies(ffi libffi_project)

# box2d
add_subdirectory(extern/box2d)

# Modules
add_subdirectory(src)
