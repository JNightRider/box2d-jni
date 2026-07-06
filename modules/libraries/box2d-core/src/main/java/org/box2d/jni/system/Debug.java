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

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A small utility for generating logs with a specific format and colors (if
 * supported).
 *
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Debug {

    public enum Color {
        BLACK("\u001B[30m", "\u001B[40m"),
        RED("\u001B[31m", "\u001B[41m"),
        GREEN("\u001B[32m", "\u001B[42m"),
        YELLOW("\u001B[33m", "\u001B[43m"),
        BLUE("\u001B[34m", "\u001B[44m"),
        PURPLE("\u001B[35m", "\u001B[45m"),
        CYAN("\u001B[36m", "\u001B[46m"),
        WHITE("\u001B[37m", "\u001B[47m"),
        NULL("\u001B[0m", "\u001B[0m");

        private static final BiFunction<String, Color, String> FCOLOR = (text, color) -> color == null
                ? text : color.getColor() + text + NULL.getColor();

        private static final BiFunction<String, Color, String> FBACKGROUND = (text, color) -> color == null
                ? text : color.getBackground() + text + NULL.getBackground();

        private static final Map<String, BiFunction<String, Color, String>> MAP = new HashMap<>();
        private static final Boolean SKIP_COLOR = Platform.get() == Platform.Android || Sys.DISABLE_DEBUG_COLOR.get(false);

        static {
            MAP.put("c", FCOLOR);
            MAP.put("b", FBACKGROUND);
        }

        private final String txColorCode;
        private final String bgColorCode;

        private Color(String txColorCode, String bgColorCode) {
            this.txColorCode = txColorCode;
            this.bgColorCode = bgColorCode;
        }

        public String getColor() {
            return txColorCode;
        }

        public String getBackground() {
            return bgColorCode;
        }

        public static String sprintf(String value, Color... colors) {
            Pattern p = Pattern.compile("%(\\w+)\\{(.*?)\\}");
            Matcher m = p.matcher(value);

            StringBuilder buffer = new StringBuilder();
            int index = 0;

            while (m.find()) {
                String name = m.group(1);
                String param = m.group(2);

                BiFunction<String, Color, String> format = MAP.get(name);
                if (format != null) {
                    String chars = format.apply(param, SKIP_COLOR ? null : colors[index++]);
                    m.appendReplacement(
                            buffer,
                            Matcher.quoteReplacement(chars)
                    );
                }
            }

            m.appendTail(buffer);
            return String.valueOf(buffer);
        }
    }

    protected static Boolean DEBUG;
    private static final PrintStream DEBUG_STREAM = System.out;
    
    private static void check() {
        DEBUG = !Sys.DISABLE_DEBUG.get(false);
    }
    
    public static void apiPrint(CharSequence msg) {
        check();
        if (DEBUG) {
            DEBUG_STREAM.print(Color.sprintf("%c{" + msg + "}\n", Color.CYAN));
        }
    }

    public static void apiLog(CharSequence msg) {
        check();
        if (DEBUG) {
            DEBUG_STREAM.print(Color.sprintf("[  %c{ok}  ] " + msg + "\n", Color.GREEN));
        }
    }
    
    public static void apiWarr(CharSequence msg) {
        check();
        if (DEBUG) {
            DEBUG_STREAM.print(Color.sprintf("[ %c{warr} ] " + msg + "\n", Color.YELLOW));
        }
    }
    
    public static void apiErro(CharSequence msg) {
        check();
        if (DEBUG) {
            DEBUG_STREAM.print(Color.sprintf("[ %c{erro} ] %c{" + msg + "}\n", Color.RED, Color.WHITE));
        }
    }

    public static void apiLogMore(CharSequence msg, Color ...colors) {
        check();
        if (DEBUG) {
            DEBUG_STREAM.print(Color.sprintf("\t\t" + msg + "\n", colors));
        }
    }
}
