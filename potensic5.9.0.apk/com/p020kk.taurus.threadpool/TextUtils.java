package com.p020kk.taurus.threadpool;

/* loaded from: classes2.dex */
public class TextUtils {
    public static String formatStackTrace(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append("    at ").append(stackTraceElement.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}