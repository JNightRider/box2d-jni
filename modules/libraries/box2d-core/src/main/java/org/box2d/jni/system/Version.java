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
package org.box2d.jni.system;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class can be used to query the Box2d-JNI version.
 *
 * @author wil
 * @version 1.0.0
 * @since 2.1.0
 */
public final class Version {

    static {
        String version = getJarVersion();
        Matcher matcher = Pattern
                .compile("^(\\d+)\\.(\\d+)\\.(\\d+)([ab])?$")
                .matcher(version);

        if (!matcher.find()) {
            throw new IllegalStateException("Failed to parse Box2dJNI Version: " + version);
        }

        String major = matcher.group(1);
        String minor = matcher.group(2);
        String revision = matcher.group(3);
        String prefix = matcher.group(4);

        VERSION_MAJOR = Integer.parseInt(major);
        VERSION_MINOR = Integer.parseInt(minor);
        VERSION_REVISION = Integer.parseInt(revision);
        BUILD_TYPE = BuildType.valuePostfix(prefix);
    }

    /** Current version of library. */
    public static final int
            VERSION_MAJOR,
            VERSION_MINOR,
            VERSION_REVISION;

    /** The development state of the current build. */
    public static final BuildType BUILD_TYPE;

    private static final String VERSION =
        String.valueOf('v') 
            + VERSION_MAJOR +
        '.' + VERSION_MINOR +
        '.' + VERSION_REVISION + 
        ' ' + BUILD_TYPE.name;
    
    /** The development state of the current build. */
    public enum BuildType {
        /** Work in progress, unstable. */
        ALPHA("a", "Alpha"),
        /** Feature complete, unstable. */
        BETA("b", "Beta"),
        /** Feature complete, stable, official release. */
        STABLE("", "Stable");

        /** metadata */
        public final String postfix, name;

        /**
         * Constructor
         *
         * @param postfix String
         * @param name String
         */
        BuildType(String postfix, String name) {
            this.postfix = postfix;
            this.name = name;
        }

        private static BuildType valuePostfix(String value) {
            if (value == null) {
                return STABLE;
            }
            for (BuildType buildType : BuildType.values()) {
                if (Objects.equals(buildType.postfix, value)) {
                    return buildType;
                }
            }
            throw new UnsupportedOperationException(value);
        }
    }

    /**
     * Returns the BoxdJNI version.
     *
     * @return String
     */
    public static String getVersion() { return VERSION; }
    private static String getJarVersion() {
        InputStream in = Version.class.getResourceAsStream("/META-INF/VERSION");
        StringBuilder builder = new StringBuilder();
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append('\n');
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return String.valueOf(builder).trim();
    }
}
