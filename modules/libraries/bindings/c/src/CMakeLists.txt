add_library(box2d-bindings SHARED
    common_tools.c
    org_box2d_jni_libc_LibCFloat.c
    org_box2d_jni_libc_LibCMath.c
    org_box2d_jni_libc_LibCStdlib.c
    org_box2d_jni_libc_LibCString.c
    org_box2d_jni_system_JNI.c
    org_box2d_jni_system_Memory.c
    org_box2d_jni_system_Upcalls.c
    org_box2d_jni_system_VarType.c
    
    box2d/org_box2d_jni_include_MathFunctions.c
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
        PkgConfig::FFI
)

if(UNIX AND NOT APPLE)
    target_link_libraries(box2d-bindings PRIVATE m)
endif()