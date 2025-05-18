package com.google.android.exoplayer2;

import android.os.Build;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class ExoPlayerLibraryInfo {
    public static final boolean ASSERTIONS_ENABLED = true;

    @Deprecated
    public static final String DEFAULT_USER_AGENT;
    public static final boolean GL_ASSERTIONS_ENABLED = false;
    public static final String TAG = "ExoPlayer";
    public static final boolean TRACE_ENABLED = true;
    public static final String VERSION = "2.14.2";
    public static final int VERSION_INT = 2014002;
    public static final String VERSION_SLASHY = "ExoPlayerLib/2.14.2";
    private static final HashSet<String> registeredModules;
    private static String registeredModulesString;

    static {
        String str = Build.VERSION.RELEASE;
        DEFAULT_USER_AGENT = new StringBuilder(String.valueOf(str).length() + 57).append("ExoPlayerLib/2.14.2 (Linux; Android ").append(str).append(") ").append(VERSION_SLASHY).toString();
        registeredModules = new HashSet<>();
        registeredModulesString = "goog.exo.core";
    }

    private ExoPlayerLibraryInfo() {
    }

    public static synchronized String registeredModules() {
        String str;
        synchronized (ExoPlayerLibraryInfo.class) {
            str = registeredModulesString;
        }
        return str;
    }

    public static synchronized void registerModule(String str) {
        synchronized (ExoPlayerLibraryInfo.class) {
            if (registeredModules.add(str)) {
                String str2 = registeredModulesString;
                registeredModulesString = new StringBuilder(String.valueOf(str2).length() + 2 + String.valueOf(str).length()).append(str2).append(", ").append(str).toString();
            }
        }
    }
}