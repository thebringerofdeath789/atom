package com.logan.server.jhttp;

import java.util.Date;

/* loaded from: classes3.dex */
public class HttpLog {
    private static final String ANSI_COLOR_BLUE = "\u001b[34m";
    private static final String ANSI_COLOR_GREEN = "\u001b[32m";
    private static final String ANSI_COLOR_NORMAL = "\u001b[0m";
    private static final String ANSI_COLOR_ORANGE = "\u001b[33m";
    private static final String ANSI_COLOR_RED = "\u001b[31m";
    public static final int LOG_LEVEL_DEBUG = 0;
    public static final int LOG_LEVEL_ERROR = 3;
    public static final int LOG_LEVEL_INFO = 1;
    public static final int LOG_LEVEL_WARNING = 2;
    private static boolean sAnsiColorEnable = true;
    private static LogCallback sLogCallback = null;
    private static int sLogLevel = 1;

    public interface LogCallback {
        void onLog(String str);
    }

    private static void log(String str, int i, String str2, String str3, Object... objArr) {
        String format = String.format(str3, objArr);
        String str4 = sAnsiColorEnable ? str + "[" + new Date().toString() + "] " + str2 + format + ANSI_COLOR_NORMAL : "[" + new Date().toString() + "] " + str2 + format;
        LogCallback logCallback = sLogCallback;
        if (logCallback != null) {
            logCallback.onLog(str4);
        } else {
            System.out.println(str4);
        }
    }

    /* renamed from: D */
    public static void m1732D(String str, Object... objArr) {
        if (sLogLevel <= 0) {
            log(ANSI_COLOR_GREEN, 0, "D/ ", str, objArr);
        }
    }

    /* renamed from: I */
    public static void m1734I(String str, Object... objArr) {
        if (1 >= sLogLevel) {
            log(ANSI_COLOR_NORMAL, 1, "I/ ", str, objArr);
        }
    }

    /* renamed from: W */
    public static void m1735W(String str, Object... objArr) {
        if (2 >= sLogLevel) {
            log(ANSI_COLOR_ORANGE, 2, "W/ ", str, objArr);
        }
    }

    /* renamed from: E */
    public static void m1733E(String str, Object... objArr) {
        if (3 >= sLogLevel) {
            log(ANSI_COLOR_RED, 3, "E/ ", str, objArr);
        }
    }

    public static void setLogCallback(LogCallback logCallback) {
        sLogCallback = logCallback;
    }

    public static void enableAnsiColor(boolean z) {
        sAnsiColorEnable = z;
    }

    public static void setLogLevel(int i) {
        sLogLevel = i;
    }
}