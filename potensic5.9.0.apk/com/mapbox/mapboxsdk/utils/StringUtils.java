package com.mapbox.mapboxsdk.utils;

import java.text.Normalizer;

/* loaded from: classes3.dex */
class StringUtils {
    StringUtils() {
    }

    static String unaccent(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("(\\p{InCombiningDiacriticalMarks}|\\p{InCombiningDiacriticalMarksForSymbols}|\\p{InCombiningDiacriticalMarksSupplement})+", "");
    }
}