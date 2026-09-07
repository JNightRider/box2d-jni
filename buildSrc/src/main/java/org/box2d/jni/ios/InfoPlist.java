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

import javax.inject.Inject;
import org.gradle.api.Action;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.Property;

/**
 *
 * @author wil
 */
public class InfoPlist {
    
    private final Property<String> CFBundleDevelopmentRegion;
    private final Property<String> CFBundleExecutable;    
    private final Property<String> CFBundleInfoDictionaryVersion;
    private final Property<String> CFBundleName;
    private final Property<String> CFBundlePackageType;
    private final Property<String> CFBundleShortVersionString;
    private final Property<Integer> CFBundleVersion;
    private final Property<String> MinimumOSVersion;
    
    private final NamedDomainObjectContainer<CFBundleIdentifier> CFBundleIdentifier;

    @Inject
    public InfoPlist(ObjectFactory objects) {
        CFBundleDevelopmentRegion = objects.property(String.class);
        CFBundleExecutable = objects.property(String.class);
        
        CFBundleInfoDictionaryVersion = objects.property(String.class);
        CFBundleName = objects.property(String.class);
        CFBundlePackageType = objects.property(String.class);
        CFBundleShortVersionString = objects.property(String.class);
        CFBundleVersion = objects.property(Integer.class);
        MinimumOSVersion = objects.property(String.class);
        
        CFBundleIdentifier = objects.domainObjectContainer(
            CFBundleIdentifier.class
        );
        
        CFBundleDevelopmentRegion.convention("en");
        CFBundleInfoDictionaryVersion.convention("6.0");
        CFBundlePackageType.convention("FMWK");
        CFBundleVersion.convention(1);
        MinimumOSVersion.convention("");
    }

    public Property<String> getCFBundleDevelopmentRegion() {
        return CFBundleDevelopmentRegion;
    }

    public Property<String> getCFBundleExecutable() {
        return CFBundleExecutable;
    }

    public NamedDomainObjectContainer<CFBundleIdentifier> getCFBundleIdentifier() {
        return CFBundleIdentifier;
    }

    public Property<String> getCFBundleInfoDictionaryVersion() {
        return CFBundleInfoDictionaryVersion;
    }

    public Property<String> getCFBundleName() {
        return CFBundleName;
    }

    public Property<String> getCFBundlePackageType() {
        return CFBundlePackageType;
    }

    public Property<String> getCFBundleShortVersionString() {
        return CFBundleShortVersionString;
    }

    public Property<Integer> getCFBundleVersion() {
        return CFBundleVersion;
    }

    public Property<String> getMinimumOSVersion() {
        return MinimumOSVersion;
    }
}
