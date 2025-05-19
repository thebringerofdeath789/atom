package com.mapbox.core.utils;

/* loaded from: classes3.dex */
public final class ColorUtils {
    private ColorUtils() {
    }

    public static String toHexString(int i, int i2, int i3) {
        String format = String.format("%02X%02X%02X", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        return format.length() < 6 ? "000000".substring(0, 6 - format.length()) + format : format;
    }
}
