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
package org.box2d.jni.ios;

import java.util.ArrayList;
import javax.inject.Inject;
import org.box2d.jni.cmake.BuildTypeProperty;
import org.box2d.jni.cmake.CMakeProperty;
import org.box2d.jni.cmake.FlavorProperty;
import org.gradle.api.Action;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ListProperty;
import org.gradle.api.provider.Property;

/**
 *
 * @author wil
 */
public abstract class IOSProperties {
    
    public static String getCMakeArguments(IOSProperties iosp, BuildTypeProperty buildType, FlavorProperty flavor) {
        StringBuilder builder = new StringBuilder();
        CMakeProperty makeProperty = iosp.getCMake();
        
        String cFlags = (
            makeProperty.getCFlagsStr() + ' ' + buildType.getCFlagsStr() + ' ' + flavor.getCFlagsStr()
        ).trim();
        
        String argumnets = (
            makeProperty.getArgumentsStr() + ' ' + buildType.getArgumentsStr() + ' ' + flavor.getArgumentsStr()
        ).trim();
        
        builder.append(argumnets);
        if (! cFlags.isEmpty()) {
            builder.append(' ')
                   .append("-DCMAKE_C_FLAGS=")
                   .append('"')
                   .append(cFlags)
                   .append('"');
        }
        return String.valueOf(builder).trim();
    }
    
    private final Property<String> miVersion;
    private final CMakeProperty cmake;
    
    private final NamedDomainObjectContainer<BuildTypeProperty> buildTypes;
    private final NamedDomainObjectContainer<FlavorProperty> productFlavors;
    private final ListProperty<String> devices;
    
    @Inject
    public IOSProperties(ObjectFactory objects) {
        miVersion = objects.property(String.class);
        cmake = objects.newInstance(CMakeProperty.class);
        
        buildTypes = objects.domainObjectContainer(BuildTypeProperty.class);
        productFlavors = objects.domainObjectContainer(FlavorProperty.class);
        
        devices = objects.listProperty(String.class);
        devices.convention(new ArrayList<>());
    }
    
    public void devices(String... values) {
        devices.addAll(values);
    }

    public void cmake(Action<? super CMakeProperty> action) {
        action.execute(cmake);
    }

    public NamedDomainObjectContainer<BuildTypeProperty> getBuildTypes() {
        return buildTypes;
    }

    public NamedDomainObjectContainer<FlavorProperty> getProductFlavors() {
        return productFlavors;
    }

    public ListProperty<String> getDevices() {
        return devices;
    }

    public Property<String> getMiVersion() {
        return miVersion;
    }

    public CMakeProperty getCMake() {
        return cmake;
    }
}
