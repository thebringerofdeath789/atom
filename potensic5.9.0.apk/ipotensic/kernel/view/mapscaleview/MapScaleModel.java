package com.ipotensic.kernel.view.mapscaleview;

/* loaded from: classes2.dex */
class MapScaleModel {
    private static final int FT_IN_MILE = 5280;
    private static final double TILE_SIZE_FT_AT_0_ZOOM = 513592.62d;
    private static final double TILE_SIZE_METERS_AT_0_ZOOM = 156543.03d;
    private final float density;
    private boolean isChina;
    private int maxWidth;
    private static final float[] METERS = {0.2f, 0.5f, 1.0f, 2.0f, 5.0f, 10.0f, 20.0f, 50.0f, 100.0f, 200.0f, 500.0f, 1000.0f, 2000.0f, 5000.0f, 10000.0f, 20000.0f, 50000.0f, 100000.0f, 200000.0f, 500000.0f, 1000000.0f, 2000000.0f};
    private static final float[] FT = {1.0f, 2.0f, 5.0f, 10.0f, 20.0f, 50.0f, 100.0f, 200.0f, 500.0f, 1000.0f, 2000.0f, 5000.0f, 5280.0f, 10560.0f, 26400.0f, 52800.0f, 105600.0f, 264000.0f, 528000.0f, 1056000.0f, 2640000.0f, 5280000.0f, 1.056E7f};
    private float lastZoom = -1.0f;
    private double lastLatitude = -100.0d;

    MapScaleModel(float f) {
        this.density = f;
    }

    void setMaxWidth(int i) {
        this.maxWidth = i;
    }

    void setPosition(float f, double d, boolean z) {
        this.lastZoom = f;
        this.lastLatitude = d;
        this.isChina = z;
    }

    Scale update(boolean z) {
        float f = this.lastZoom;
        double d = this.lastLatitude;
        float f2 = 0.0f;
        if (f < 0.0f || Math.abs(d) > 90.0d) {
            return null;
        }
        double d2 = z ? TILE_SIZE_METERS_AT_0_ZOOM : TILE_SIZE_FT_AT_0_ZOOM;
        float[] fArr = z ? METERS : FT;
        double cos = ((d2 / this.density) * Math.cos((3.141592653589793d * d) / 180.0d)) / Math.pow(2.0d, f);
        int length = fArr.length;
        double d3 = this.maxWidth + 1;
        while (d3 > this.maxWidth && length > 0) {
            length--;
            f2 = fArr[length];
            d3 = Math.abs(f2 / cos);
        }
        this.lastZoom = f;
        this.lastLatitude = d;
        return new Scale(text(f2, z), (float) d3);
    }

    private String text(float f, boolean z) {
        if (this.isChina) {
            if (f < 1000.0f) {
                return ((int) f) + " m";
            }
            return (((int) f) / 1000) + " km";
        }
        if (f < 5280.0f) {
            return ((int) f) + " ft";
        }
        return (((int) f) / FT_IN_MILE) + " mile";
    }
}