add_library(box2d-bindings SHARED
    common_tools.c
    org_box2d_jni_libc_LibCFloat.c
    org_box2d_jni_libc_LibCMath.c
    org_box2d_jni_libc_LibCStdint.c
    org_box2d_jni_libc_LibCStdlib.c
    org_box2d_jni_libc_LibCString.c
    org_box2d_jni_system_JNI.c
    org_box2d_jni_system_JNIB2.c
    org_box2d_jni_system_Memory.c
    org_box2d_jni_system_MemoryUtil.c
    org_box2d_jni_system_Upcalls.c
    org_box2d_jni_system_VarType.c
    box2d/org_box2d_jni_b2BodyType.c
    box2d/org_box2d_jni_b2JointType.c
    box2d/org_box2d_jni_b2RecQueryType.c
    box2d/org_box2d_jni_b2ShapeType.c
    box2d/org_box2d_jni_b2TOIState.c
    box2d/org_box2d_jni_b2TreeNodeFlags.c
    box2d/org_box2d_jni_include_Base.c
    box2d/org_box2d_jni_include_Box2d.c
    box2d/org_box2d_jni_include_Collision.c
    box2d/org_box2d_jni_include_Id.c
    box2d/org_box2d_jni_include_MathFunctions.c
    box2d/org_box2d_jni_include_Types.c
)

set_target_properties(box2d-bindings PROPERTIES
    OUTPUT_NAME "box2d-bindings${BINDINGS_SUFFIX}"
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

if(BOX2D_DOUBLE_PRECISION)
    target_compile_definitions(box2d-bindings
        PRIVATE BOX2D_DOUBLE_PRECISION
    )
endif()

if(UNIX AND NOT APPLE)
    target_link_libraries(box2d-bindings PRIVATE m)
endif()