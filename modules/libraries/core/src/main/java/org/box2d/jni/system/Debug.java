/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni.system;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author wil
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

        private static final BiFunction<String, Color, String> FCOLOR = (text, color) -> color.getColor() + text + NULL.getColor();
        private static final BiFunction<String, Color, String> FBACKGROUND = (text, color) -> color.getBackground() + text + NULL.getBackground();

        private static final Map<String, BiFunction<String, Color, String>> MAP = new HashMap<>();

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
                    String chars = format.apply(param, colors[index++]);
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

    static {
        DEBUG = true;
    }
    
    public static void apiPrint(CharSequence msg) {
        if (DEBUG) {
            DEBUG_STREAM.print(Color.sprintf("%c{ " + msg + "}\n", Color.CYAN));
        }
    }

    public static void apiLog(CharSequence msg) {
        if (DEBUG) {
            DEBUG_STREAM.print(Color.sprintf("[  %c{ok}  ] " + msg + "\n", Color.GREEN));
        }
    }
    
    public static void apiWarr(CharSequence msg) {
        if (DEBUG) {
            DEBUG_STREAM.print(Color.sprintf("[ %c{warr} ] " + msg + "\n", Color.YELLOW));
        }
    }
    
    public static void apiErro(CharSequence msg) {
        if (DEBUG) {
            DEBUG_STREAM.print(Color.sprintf("[ %c{erro} ] %c{" + msg + "}\n", Color.RED, Color.WHITE));
        }
    }

    public static void apiLogMore(CharSequence msg) {
        if (DEBUG) {
            DEBUG_STREAM.print("\t\t" + msg + "\n");
        }
    }
}
