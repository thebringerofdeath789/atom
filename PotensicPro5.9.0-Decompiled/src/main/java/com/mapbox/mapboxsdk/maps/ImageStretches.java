package com.mapbox.mapboxsdk.maps;

/* loaded from: classes3.dex */
public final class ImageStretches {
    private final float first;
    private final float second;

    public ImageStretches(float f, float f2) {
        this.first = f;
        this.second = f2;
    }

    public float getFirst() {
        return this.first;
    }

    public float getSecond() {
        return this.second;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ImageStretches)) {
            return false;
        }
        ImageStretches imageStretches = (ImageStretches) obj;
        return this.first == imageStretches.first && this.second == imageStretches.second;
    }

    public int hashCode() {
        float f = this.first;
        int floatToIntBits = (f != 0.0f ? Float.floatToIntBits(f) : 0) * 31;
        float f2 = this.second;
        return floatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0);
    }

    public String toString() {
        return "[ first: " + this.first + ", second: " + this.second + " ]";
    }
}
