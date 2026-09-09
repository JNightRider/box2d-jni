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

    set(CMAKE_XCODE_ATTRIBUTE_ENABLE_BITCODE NO)

    # Un ExternalProject de libffi debe compilar solamente una arquitectura.
    # Device arm64, Simulator arm64 o Simulator x86_64.
    list(LENGTH CMAKE_OSX_ARCHITECTURES IOS_ARCH_COUNT)

    if(NOT IOS_ARCH_COUNT EQUAL 1)
        message(FATAL_ERROR
            "libffi debe compilarse una arquitectura por directorio de build. "
            "Valor recibido: CMAKE_OSX_ARCHITECTURES=${CMAKE_OSX_ARCHITECTURES}"
        )
    endif()

    list(GET CMAKE_OSX_ARCHITECTURES 0 IOS_ARCH)

    if(NOT CMAKE_OSX_DEPLOYMENT_TARGET)
        set(CMAKE_OSX_DEPLOYMENT_TARGET "13.0")
    endif()

    # Detectar SDK utilizado por el build principal.
    #
    # Valores esperados:
    #   iphoneos
    #   iphonesimulator
    if(CMAKE_OSX_SYSROOT MATCHES "iphonesimulator")
        set(IOS_SDK_NAME "iphonesimulator")
        set(IOS_PLATFORM_NAME "simulator")
    elseif(CMAKE_OSX_SYSROOT MATCHES "iphoneos")
        set(IOS_SDK_NAME "iphoneos")
        set(IOS_PLATFORM_NAME "device")
    else()
        message(FATAL_ERROR
            "SDK de iOS no reconocido: ${CMAKE_OSX_SYSROOT}. "
            "Usa iphoneos o iphonesimulator."
        )
    endif()

    find_program(XCRUN_EXECUTABLE xcrun REQUIRED)

    execute_process(
        COMMAND
            ${XCRUN_EXECUTABLE}
            --sdk ${IOS_SDK_NAME}
            --show-sdk-path

        OUTPUT_VARIABLE IOS_SDK_PATH
        OUTPUT_STRIP_TRAILING_WHITESPACE
        COMMAND_ERROR_IS_FATAL ANY
    )

    execute_process(
        COMMAND
            ${XCRUN_EXECUTABLE}
            --sdk ${IOS_SDK_NAME}
            --find clang

        OUTPUT_VARIABLE IOS_CLANG
        OUTPUT_STRIP_TRAILING_WHITESPACE
        COMMAND_ERROR_IS_FATAL ANY
    )

    execute_process(
        COMMAND
            ${XCRUN_EXECUTABLE}
            --sdk ${IOS_SDK_NAME}
            --find ar

        OUTPUT_VARIABLE IOS_AR
        OUTPUT_STRIP_TRAILING_WHITESPACE
        COMMAND_ERROR_IS_FATAL ANY
    )

    execute_process(
        COMMAND
            ${XCRUN_EXECUTABLE}
            --sdk ${IOS_SDK_NAME}
            --find ranlib

        OUTPUT_VARIABLE IOS_RANLIB
        OUTPUT_STRIP_TRAILING_WHITESPACE
        COMMAND_ERROR_IS_FATAL ANY
    )

    # Triple utilizado por Clang.
    if(IOS_PLATFORM_NAME STREQUAL "device")
        if(NOT IOS_ARCH STREQUAL "arm64")
            message(FATAL_ERROR
                "Actualmente iOS Device debe compilarse como arm64. "
                "Arquitectura recibida: ${IOS_ARCH}"
            )
        endif()

        set(IOS_CLANG_TARGET
            "${IOS_ARCH}-apple-ios${CMAKE_OSX_DEPLOYMENT_TARGET}"
        )

    elseif(IOS_PLATFORM_NAME STREQUAL "simulator")
        if(NOT IOS_ARCH STREQUAL "arm64"
           AND NOT IOS_ARCH STREQUAL "x86_64")
            message(FATAL_ERROR
                "Arquitectura no soportada para iOS Simulator: ${IOS_ARCH}. "
                "Usa arm64 o x86_64."
            )
        endif()

        set(IOS_CLANG_TARGET
            "${IOS_ARCH}-apple-ios${CMAKE_OSX_DEPLOYMENT_TARGET}-simulator"
        )
    endif()

    # Host de Autotools. El target real de iOS se indica mediante -target.
    if(IOS_ARCH STREQUAL "arm64")
        set(LIBFFI_AUTOTOOLS_HOST "arm-apple-darwin")
    elseif(IOS_ARCH STREQUAL "x86_64")
        set(LIBFFI_AUTOTOOLS_HOST "x86_64-apple-darwin")
    else()
        message(FATAL_ERROR
            "Arquitectura iOS no soportada: ${IOS_ARCH}"
        )
    endif()

    # Evita que Device, Simulator arm64 y Simulator x86_64
    # escriban en el mismo directorio.
    set(LIBFFI_PREFIX
        "${CMAKE_BINARY_DIR}/extern/libffi/${IOS_SDK_NAME}-${IOS_ARCH}"
    )

    set(LIBFFI_BUILD_DIR
        "${CMAKE_BINARY_DIR}/extern/libffi-build/${IOS_SDK_NAME}-${IOS_ARCH}"
    )

    set(LIBFFI_CFLAGS
        "-target ${IOS_CLANG_TARGET} -arch ${IOS_ARCH} -isysroot ${IOS_SDK_PATH} -fPIC"
    )

    message(STATUS "iOS SDK=${IOS_SDK_NAME}")
    message(STATUS "iOS SDK path=${IOS_SDK_PATH}")
    message(STATUS "iOS architecture=${IOS_ARCH}")
    message(STATUS "iOS target=${IOS_CLANG_TARGET}")
    message(STATUS "iOS deployment target=${CMAKE_OSX_DEPLOYMENT_TARGET}")
    message(STATUS "libffi prefix=${LIBFFI_PREFIX}")
    message(STATUS "libffi CFLAGS=${LIBFFI_CFLAGS}")

    ExternalProject_Add(libffi_project
        SOURCE_DIR
            "${CMAKE_SOURCE_DIR}/extern/libffi"

        BINARY_DIR
            "${LIBFFI_BUILD_DIR}"

        CONFIGURE_COMMAND
            ${CMAKE_COMMAND} -E env
                "CC=${IOS_CLANG}"
                "AR=${IOS_AR}"
                "RANLIB=${IOS_RANLIB}"
                "CFLAGS=${LIBFFI_CFLAGS}"
                "CPPFLAGS=${LIBFFI_CFLAGS}"

                "./configure"
                "--host=${LIBFFI_AUTOTOOLS_HOST}"
                "--target=${LIBFFI_AUTOTOOLS_HOST}"
                "--prefix=${LIBFFI_PREFIX}"
                --disable-shared
                --enable-static
                --disable-docs
                --disable-multi-os-directory

        BUILD_COMMAND ${CMAKE_MAKE_PROGRAM} -j

        INSTALL_COMMAND ${CMAKE_MAKE_PROGRAM} install

        BUILD_BYPRODUCTS
            "${LIBFFI_PREFIX}/lib/libffi.a"
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
