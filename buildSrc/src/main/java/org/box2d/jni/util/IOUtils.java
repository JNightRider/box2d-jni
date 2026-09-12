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
package org.box2d.jni.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import org.box2d.jni.BuildType;
import org.box2d.jni.Flavor;

/**
 *
 * @author wil
 */
public class IOUtils {
    
    public static void ioCPFile(File source, File output, String name) {
        try {
            output.mkdirs();
            File newFile = new File(output, name);
            Files.copy(source.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IllegalStateException("The file could not be copied", e);
        }
    }

    public static void ioCPFile(List<File> sources, File output) {
        try {
            output.mkdirs();
            for (File file : sources) {
                File newFile = new File(output, file.getName());
                Files.copy(file.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new IllegalStateException("The file could not be copied", e);
        }
    }

    public static File ioMakePath(Object ...names) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            builder.append(names[i]);
            if ((i + 1 ) < names.length) {
                builder.append(File.separator);
            }
        }
        return new File(String.valueOf(builder));
    }
    
    public static File ioDir(File parent, String child) {
        return ioDir(new File(parent, child));
    }
    
    public static File ioDir(String path) {
        return ioDir(new File(path));
    }
    
    public static File ioDir(File path) {
        if (path.exists()) {
            return path;
        }
        if (! path.mkdirs()) {
            throw new IllegalStateException("The route could not be created: " + path);
        }
        return path;
    }
}
