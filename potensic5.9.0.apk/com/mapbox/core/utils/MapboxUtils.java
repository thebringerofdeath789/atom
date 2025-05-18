package com.mapbox.core.utils;

/* loaded from: classes3.dex */
public final class MapboxUtils {
    private MapboxUtils() {
    }

    public static boolean isAccessTokenValid(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("pk.") || str.startsWith("sk.") || str.startsWith("tk."));
    }
}