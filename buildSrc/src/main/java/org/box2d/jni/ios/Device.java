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

import java.util.List;

/**
 *
 * @author wil
 */
public enum Device {

    device_arm64("device-arm64", "iphoneos"),
    simulator_arm64("arm64", "iphonesimulator"),
    simulator_x86_64("x86_64", "iphonesimulator");

    private final String architecture;
    private final String type;

    private Device(String architecture, String type) {
        this.architecture = architecture;
        this.type = type;
    }

    public static Device parseDevice(String name) {
        for (Device device : values()) {
            if (device.getArchitecture().equalsIgnoreCase(name)) {
                return device;
            }
        }
        throw new UnsupportedOperationException(name);
    }
    
    public static Device[] parseValues(List<String> names) {
        if (names.size() > values().length) {
            throw new IllegalStateException();
        }
        
        Device[] devices = new Device[names.size()];
        for (int i = 0; i < devices.length; i++) {
            String name = names.get(i);
            devices[i] = parseDevice(name);
        }
        return devices;
    }

    public String getArchitecture() {
        return architecture;
    }

    public String getNativeArch() {
        if (architecture.startsWith("device-")) {
            return architecture.substring(7, architecture.length());
        }
        return architecture;
    }

    public String getType() {
        return type;
    }
}
