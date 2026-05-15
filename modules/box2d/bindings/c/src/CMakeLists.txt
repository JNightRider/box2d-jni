add_library(box2d-bindings SHARED
    org_box2d_jni_libc_LibCStdlib.c
)

target_include_directories(box2d-bindings
    PUBLIC
        ${CMAKE_SOURCE_DIR}/include
    PRIVATE
        ${JNI_INCLUDE_DIRS}
)
target_link_libraries(box2d-bindings
    PRIVATE
        box2d
)

if(UNIX AND NOT APPLE)
    target_link_libraries(box2d-bindings PRIVATE m)
endif()