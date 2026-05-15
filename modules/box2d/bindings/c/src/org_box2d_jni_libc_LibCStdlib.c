#include <stdlib.h>

#include "box2d/jni/org_box2d_jni_libc_LibCStdlib.h"

/*
 * Class:     org_box2d_jni_libc_LibCStdlib
 * Method:    nmalloc
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_box2d_jni_libc_LibCStdlib_nmalloc
    (JNIEnv *__env, jclass clazz, jlong size)
{
    return (jlong)(void*)malloc((size_t)size);
}

/*
 * Class:     org_box2d_jni_libc_LibCStdlib
 * Method:    nfree
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_box2d_jni_libc_LibCStdlib_nfree
    (JNIEnv *__env, jclass clazz, jlong ptr)
{
    free((void*)ptr);
}
