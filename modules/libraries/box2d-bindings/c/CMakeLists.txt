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

    # Determine target from ABI
    if(ANDROID_ABI STREQUAL "arm64-v8a")
        set(CLANG_TRIPLE "aarch64-linux-android")
        set(AUTOTOOLS_HOST "aarch64-linux-android")
    elseif(ANDROID_ABI STREQUAL "armeabi-v7a")
        set(BOX2D_DISABLE_SIMD ON CACHE BOOL "" FORCE)
        message(WARNING "BOX2D_DISABLE_SIMD=ON for armeabi-v7a")

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

    set(ANDROID_TOOLCHAIN_BIN "${ANDROID_NDK}/toolchains/llvm/prebuilt/${BINDINGS_ANDROID_HOME}/bin")
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
elseif(CMAKE_SYSTEM_NAME STREQUAL "iOS")
    message(STATUS "Compiling libffi for iOS")
    set(JNI_INCLUDE_DIRS
        "$ENV{JAVA_HOME}/include"
        "$ENV{JAVA_HOME}/include/darwin"
    )

    set(CMAKE_XCODE_ATTRIBUTE_ENABLE_BITCODE NO)
    list(GET CMAKE_OSX_ARCHITECTURES 0 IOS_ARCH)

    if(CMAKE_OSX_SYSROOT MATCHES "iphonesimulator")
        set(IOS_SDK_NAME "iphonesimulator")
        set(IOS_PLATFORM_NAME "simulator")
    elseif(CMAKE_OSX_SYSROOT MATCHES "iphoneos")
        set(IOS_SDK_NAME "iphoneos")
        set(IOS_PLATFORM_NAME "device")
    else()
        message(FATAL_ERROR "Unrecognized iOS SDK: ${CMAKE_OSX_SYSROOT}"  )
    endif()

    find_program(XCRUN_EXECUTABLE NAMES xcrun REQUIRED )
    find_program(MAKE_EXECUTABLE NAMES gmake make REQUIRED )
    find_program(SH_EXECUTABLE NAMES sh REQUIRED )

    execute_process(
        COMMAND
            "${XCRUN_EXECUTABLE}"
            --sdk "${IOS_SDK_NAME}"
            --show-sdk-path

        RESULT_VARIABLE IOS_SDK_RESULT
        OUTPUT_VARIABLE IOS_SDK_PATH
        OUTPUT_STRIP_TRAILING_WHITESPACE
        ERROR_VARIABLE IOS_SDK_ERROR
    )

    execute_process(
        COMMAND
            "${XCRUN_EXECUTABLE}"
            --sdk "${IOS_SDK_NAME}"
            --find clang

        RESULT_VARIABLE IOS_CLANG_RESULT
        OUTPUT_VARIABLE IOS_CLANG
        OUTPUT_STRIP_TRAILING_WHITESPACE
        ERROR_VARIABLE IOS_CLANG_ERROR
    )

    execute_process(
        COMMAND
            "${XCRUN_EXECUTABLE}"
            --sdk "${IOS_SDK_NAME}"
            --find ar

        RESULT_VARIABLE IOS_AR_RESULT
        OUTPUT_VARIABLE IOS_AR
        OUTPUT_STRIP_TRAILING_WHITESPACE
        ERROR_VARIABLE IOS_AR_ERROR
    )

    execute_process(
        COMMAND
            "${XCRUN_EXECUTABLE}"
            --sdk "${IOS_SDK_NAME}"
            --find ranlib

        RESULT_VARIABLE IOS_RANLIB_RESULT
        OUTPUT_VARIABLE IOS_RANLIB
        OUTPUT_STRIP_TRAILING_WHITESPACE
        ERROR_VARIABLE IOS_RANLIB_ERROR
    )

    if(IOS_PLATFORM_NAME STREQUAL "device")
        set(IOS_CLANG_TARGET "arm64-apple-ios${CMAKE_OSX_DEPLOYMENT_TARGET}")
        set(LIBFFI_AUTOTOOLS_HOST "aarch64-apple-darwin" )
    else()
        if(IOS_ARCH STREQUAL "arm64")
            set(IOS_CLANG_TARGET "arm64-apple-ios${CMAKE_OSX_DEPLOYMENT_TARGET}-simulator")
            set(LIBFFI_AUTOTOOLS_HOST "aarch64-apple-darwin" )
        elseif(IOS_ARCH STREQUAL "x86_64")
            set(IOS_CLANG_TARGET "x86_64-apple-ios${CMAKE_OSX_DEPLOYMENT_TARGET}-simulator")
            set(LIBFFI_AUTOTOOLS_HOST "x86_64-apple-darwin" )
        else()
            message(FATAL_ERROR "Unsupported simulator architecture: ${IOS_ARCH}")
        endif()
    endif()

    set(LIBFFI_SOURCE_DIR "${CMAKE_CURRENT_SOURCE_DIR}/extern/libffi")
    set(LIBFFI_PREFIX "${CMAKE_BINARY_DIR}/extern/libffi/${IOS_SDK_NAME}-${IOS_ARCH}")
    set(LIBFFI_BUILD_DIR "${CMAKE_BINARY_DIR}/extern/libffi-build/${IOS_SDK_NAME}-${IOS_ARCH}")
    set(LIBFFI_LOG_DIR "${CMAKE_BINARY_DIR}/extern/libffi-logs/${IOS_SDK_NAME}-${IOS_ARCH}")

    set(LIBFFI_CFLAGS
        "-target ${IOS_CLANG_TARGET} -arch ${IOS_ARCH} -isysroot ${IOS_SDK_PATH} -fPIC"
    )

    message(STATUS "iOS SDK=${IOS_SDK_NAME}")
    message(STATUS "iOS SDK path=${IOS_SDK_PATH}")
    message(STATUS "iOS architecture=${IOS_ARCH}")
    message(STATUS "iOS target=${IOS_CLANG_TARGET}")
    message(STATUS "iOS deployment target=${CMAKE_OSX_DEPLOYMENT_TARGET}")
    message(STATUS "iOS clang=${IOS_CLANG}")
    message(STATUS "iOS ar=${IOS_AR}")
    message(STATUS "iOS ranlib=${IOS_RANLIB}")
    message(STATUS "Make executable=${MAKE_EXECUTABLE}")
    message(STATUS "libffi source=${LIBFFI_SOURCE_DIR}")
    message(STATUS "libffi build=${LIBFFI_BUILD_DIR}")
    message(STATUS "libffi prefix=${LIBFFI_PREFIX}")
    message(STATUS "libffi CFLAGS=${LIBFFI_CFLAGS}")

    ExternalProject_Add(libffi_project
        PREFIX "${CMAKE_BINARY_DIR}/libffi_project-prefix"
        SOURCE_DIR "${LIBFFI_SOURCE_DIR}"
        BINARY_DIR "${LIBFFI_BUILD_DIR}"
        LOG_DIR  "${LIBFFI_LOG_DIR}"

        CONFIGURE_COMMAND
            "${CMAKE_COMMAND}" -E env
                "CC=${IOS_CLANG}"
                "AR=${IOS_AR}"
                "RANLIB=${IOS_RANLIB}"
                "CFLAGS=${LIBFFI_CFLAGS}"
                "CPPFLAGS=-isysroot ${IOS_SDK_PATH}"
                "LDFLAGS=-target ${IOS_CLANG_TARGET} -arch ${IOS_ARCH} -isysroot ${IOS_SDK_PATH}"

            "${SH_EXECUTABLE}"
                "${LIBFFI_SOURCE_DIR}/configure"
                "--host=${LIBFFI_AUTOTOOLS_HOST}"
                "--prefix=${LIBFFI_PREFIX}"
                --disable-shared
                --enable-static
                --disable-docs
                --disable-multi-os-directory

        BUILD_COMMAND "${MAKE_EXECUTABLE}" -j2
        INSTALL_COMMAND "${MAKE_EXECUTABLE}" install
        BUILD_BYPRODUCTS "${LIBFFI_PREFIX}/lib/libffi.a"

        LOG_CONFIGURE OFF
        LOG_BUILD OFF
        LOG_INSTALL OFF

        USES_TERMINAL_CONFIGURE TRUE
        USES_TERMINAL_BUILD TRUE
        USES_TERMINAL_INSTALL TRUE
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
