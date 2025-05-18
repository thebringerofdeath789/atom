package com.mapbox.mapboxsdk.location;

import android.animation.TypeEvaluator;
import com.mapbox.mapboxsdk.geometry.LatLng;

/* loaded from: classes3.dex */
class LatLngEvaluator implements TypeEvaluator<LatLng> {
    private final LatLng latLng = new LatLng();

    LatLngEvaluator() {
    }

    @Override // android.animation.TypeEvaluator
    public LatLng evaluate(float f, LatLng latLng, LatLng latLng2) {
        double d = f;
        this.latLng.setLatitude(latLng.getLatitude() + ((latLng2.getLatitude() - latLng.getLatitude()) * d));
        this.latLng.setLongitude(latLng.getLongitude() + ((latLng2.getLongitude() - latLng.getLongitude()) * d));
        return this.latLng;
    }
}