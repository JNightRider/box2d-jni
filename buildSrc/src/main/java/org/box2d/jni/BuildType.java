/*
BSD 3-Clause License

Copyright (c) 2026, Night Rider

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.box2d.jni;

/**
 * Enumerated class defining compilation types for native binaries.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public enum BuildType {
    /**
     * for development, debugging, and functional testing
     */
    Debug("Debug", "ON"),
    /**
     * for performance testing and production
     */
    Release("Release", "OFF");

    /** Type name. */
    private final String name;
    /** Compilation flag. */
    private final String flag;

    /**
     * Constructor.
     *
     * @param name String
     * @param flag String
     */
    private BuildType(String name, String flag) {
        this.name = name;
        this.flag = flag;
    }

    /**
     * Returns the type name.
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type flag.
     *
     * @return String
     */
    public String getFlag() {
        return flag;
    }

    /*(non-Javadoc)
     */
    @Override
    public String toString() {
        return "buildTypes: " + name + ":" + flag;
    }
}
