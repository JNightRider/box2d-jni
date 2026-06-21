cmake_minimum_required(VERSION 3.22)
project(box2d-bindings
	VERSION 1.0.0
	DESCRIPTION "An implementation of the Box2D physics engine for Java (JNI)"
	LANGUAGES C CXX
)

set(CMAKE_C_STANDARD 11)
set(CMAKE_C_STANDARD_REQUIRED ON)

set(BUILD_SHARED_LIBS OFF)

set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/natives)
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/natives)
set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/natives)

set(BINDINGS_SUFFIX "" CACHE STRING "Native library suffix")

# Configure JNI headers
find_package(JNI REQUIRED)

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

# Dependencies
# libffi
include(ExternalProject)

if(UNIX AND NOT APPLE)
    set(LIBFFI_CFLAGS "-fPIC")
else()
    set(LIBFFI_CFLAGS "")
endif()



set(LIBFFI_PREFIX ${CMAKE_BINARY_DIR}/extern/libffi)
ExternalProject_Add(libffi_project
    SOURCE_DIR ${CMAKE_SOURCE_DIR}/extern/libffi

    CONFIGURE_COMMAND
		CFLAGS=${LIBFFI_CFLAGS}
        ./configure
        --prefix=${LIBFFI_PREFIX}
        --disable-shared
        --enable-static
		--disable-docs

    BUILD_COMMAND make -j
    INSTALL_COMMAND make install

	BUILD_BYPRODUCTS
        ${LIBFFI_PREFIX}/lib/libffi.a

    BUILD_IN_SOURCE 1
)

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
