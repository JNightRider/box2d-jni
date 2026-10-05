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
package org.box2d.jni.cmake;

import java.util.ArrayList;
import java.util.Arrays;
import javax.inject.Inject;
import org.box2d.jni.BuildType;
import org.box2d.jni.Flavor;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ListProperty;
import org.gradle.api.provider.Property;

/**
 *
 * @author wil
 */
public class FlavorProperty {

    private final String name;

    private final ListProperty<String> cFlags;
    private final ListProperty<String> arguments;
    private final Property<Flavor> flavor;

    @Inject
    public FlavorProperty(String name, ObjectFactory objects) {
        this.name = name;
        this.flavor = objects.property(Flavor.class);
        this.cFlags = objects.listProperty(String.class);
        this.arguments = objects.listProperty(String.class);

        this.cFlags.convention(new ArrayList<>());
        this.arguments.convention(new ArrayList<>());

        if (Flavor.Dp.getName().equalsIgnoreCase(name)) {
            this.flavor.convention(Flavor.Dp);
        } else if (Flavor.Sp.getName().equalsIgnoreCase(name)) {
            this.flavor.convention(Flavor.Sp);
        } else {
            throw new IllegalArgumentException("Product flavors: " + name);
        }
    }

    public void arguments(String... values) {
        arguments.addAll(Arrays.asList(values));
    }

    public void cFlags(String... values) {
        cFlags.addAll(Arrays.asList(values));
    }

    public String getName() {
        return name;
    }

    public ListProperty<String> getcFlags() {
        return cFlags;
    }

    public ListProperty<String> getArguments() {
        return arguments;
    }

    public Property<Flavor> getFlavor() {
        return flavor;
    }
     
    public String getCFlagsStr() {
        StringBuilder builder = new StringBuilder();
        for (String command : cFlags.get()) {
            builder.append(command).append(' ');
        }
        return String.valueOf(builder).trim();
    }

    public String getArgumentsStr() {
        StringBuilder builder = new StringBuilder();
        for (String command : arguments.get()) {
            builder.append(command).append(' ');
        }
        return String.valueOf(builder).trim();
    }
}
