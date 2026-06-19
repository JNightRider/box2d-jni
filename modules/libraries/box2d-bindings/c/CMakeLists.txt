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

find_package(PkgConfig REQUIRED)
pkg_check_modules(FFI REQUIRED IMPORTED_TARGET libffi)

if(NOT JNI_FOUND)
    message(FATAL_ERROR "No JNI found, please configure your JAVA_HOME")
endif()

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

# Dependencies - Box2D
add_subdirectory(extern/box2d)

# Modules
add_subdirectory(src)
