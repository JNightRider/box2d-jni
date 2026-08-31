package org.box2d.jni.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.box2d.jni.system.Library
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LibraryTest {

    @Test
    fun initLibrary() {
        Library.initialize()
    }
}