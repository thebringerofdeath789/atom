package com.ipotensic.baselib;

import android.util.Log;

/* loaded from: classes2.dex */
public class DDLog {
    private static final String DEFAULT_TAG = "------DDLog------";
    private static boolean isDebug = false;

    public static void setDebug(boolean z) {
        isDebug = z;
    }

    public static void v(String str, String str2) {
        if (isDebug) {
            Log.v(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (isDebug) {
            Log.d(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (isDebug) {
            Log.i(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (isDebug) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (isDebug) {
            if (str2.length() <= 1024) {
                Log.e(str, str2);
                return;
            }
            while (str2.length() > 1024) {
                String substring = str2.substring(0, 1024);
                str2 = str2.replace(substring, "");
                Log.e(str, substring);
            }
            Log.e(str, str2);
        }
    }

    public static void v(String str) {
        if (isDebug) {
            Log.v(DEFAULT_TAG, str);
        }
    }

    public static void d(String str) {
        if (isDebug) {
            Log.d(DEFAULT_TAG, str);
        }
    }

    public static void i(String str) {
        if (isDebug) {
            Log.i(DEFAULT_TAG, str);
        }
    }

    public static void w(String str) {
        if (isDebug) {
            Log.w(DEFAULT_TAG, str);
        }
    }

    public static void e(String str) {
        if (isDebug) {
            Log.e(DEFAULT_TAG, str);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (isDebug) {
            Log.e(str, str2, th);
        }
    }

    public static void printStackTrace(String str) {
        try {
            if (isDebug) {
                StringBuilder sb = new StringBuilder();
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                for (int i = 0; i < stackTrace.length; i++) {
                    if (i != 0) {
                        StackTraceElement stackTraceElement = stackTrace[i];
                        sb.append("\n" + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "  line:" + stackTraceElement.getLineNumber());
                    }
                }
                e("ddlog-print-trace " + str, sb.toString());
            }
        } catch (Exception e) {
            e("打印失败 ：" + e.getMessage());
        }
    }
}
