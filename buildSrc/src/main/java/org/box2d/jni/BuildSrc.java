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

import java.util.Base64;
import org.box2d.jni.android.AndroidAbi;

/**
 * Utility methods used in Gradle builds.
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class BuildSrc {

    /**
     * Generates the list of build types to be executed based on user
     * configurations; by default, it returns all default options, unless a
     * specific one is specified.
     *
     * @see BuildType#Debug
     * @see BuildType#Release
     *
     * @param type type name
     * @return {@code BuildType[]}
     */
    public static BuildType[] makeBuildType(Object type) {
        if (type == null) {
            return BuildType.values();
        }
        return new BuildType[]{
            BuildType.valueOf(String.valueOf(type))
        };
    }

    /**
     * Generates the list of binary flavors to be produced; by default, it
     * returns all default options, unless a specific one is specified.
     *
     * @see Flavor#Dp
     * @see Flavor#Sp
     *
     * @param type flavor name
     * @return {@code Flavor[]}
     */
    public static Flavor[] makeFlavor(Object type) {
        if (type == null) {
            return Flavor.values();
        }
        return new Flavor[]{
            Flavor.valueOf(String.valueOf(type))
        };
    }

    /**
     * Generates the Android ABIs; by default, it returns all default options,
     * unless a specific one is specified.
     *
     * @see AndroidAbi
     *
     * @param type abi name
     * @return {@code AndroidAbi[]}
     */
    public static AndroidAbi[] makeAndroidAbi(Object type) {
        if (type == null) {
            return AndroidAbi.values();
        }
        for (var abi : AndroidAbi.values()) {
            if (abi.getName().equals(String.valueOf(type))) {
                return new AndroidAbi[]{
                    abi
                };
            }
        }
        return AndroidAbi.values();
    }

    /**
     * Generates the toolchain path for compiling native Android objects; this
     * locates the binaries for each ABI within the NDK path.
     *
     * @param ndkhome NDK path
     * @param abi the abi
     * @return String
     */
    public static String makeToolchainBin(Object ndkhome, AndroidAbi abi) {
        Platform platform = Platform.get();
        StringBuilder sb = new StringBuilder();
        sb.append(ndkhome)
                .append("/toolchains/llvm/prebuilt");

        if (null == platform) {
            sb.append("/linux-x86_64");
        } else {
            switch (platform) {
                case WINDOWS ->
                    sb.append("/windows-x86_64");
                case MACOSX -> {
                    if (Platform.getArchitecture() == Platform.Architecture.ARM64) {
                        sb.append("/darwin-arm64");
                    } else {
                        sb.append("/darwin-x86_64");
                    }
                }
                default ->
                    sb.append("/linux-x86_64");
            }
        }

        sb.append("/bin");
        return String.valueOf(sb);
    }

    /**
     * Generates the path where the libraries will be stored within the
     * {@code .jar} file, based on the operating system and CPU architecture of
     * the platform where the compilation takes place.
     *
     * @return String
     */
    public static String makeJARPathLib() {
        Platform platform = Platform.get();
        Platform.Architecture arch = Platform.getArchitecture();
        StringBuilder buffer = new StringBuilder();
        buffer.append('/')
                .append(platform.getNativePath())
                .append('/')
                .append(arch.getName());
        return String.valueOf(buffer);
    }

    /**
     * Decode a string from Base64-encoded text. Used to recover signing keys
     * that have been stored in properties.
     *
     * @param encodedText the text to decode (may be {@code null})
     * @return a String or {@code null}
     */
    public static String decodeBase64(Object encodedText) {
        String result;
        if (encodedText == null) {
            result = null;
        } else {
            byte[] decoded = Base64.getDecoder().decode(String.valueOf(encodedText));
            result = new String(decoded);
        }

        return result;
    }
}
