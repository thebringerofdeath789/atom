package com.mapbox.mapboxsdk.maps;

/* loaded from: classes3.dex */
public enum GlyphsRasterizationMode {
    NO_GLYPHS_RASTERIZED_LOCALLY,
    IDEOGRAPHS_RASTERIZED_LOCALLY,
    ALL_GLYPHS_RASTERIZED_LOCALLY;

    public static GlyphsRasterizationMode valueOf(int i) {
        if (i == 1) {
            return IDEOGRAPHS_RASTERIZED_LOCALLY;
        }
        if (i == 2) {
            return ALL_GLYPHS_RASTERIZED_LOCALLY;
        }
        return NO_GLYPHS_RASTERIZED_LOCALLY;
    }
}
