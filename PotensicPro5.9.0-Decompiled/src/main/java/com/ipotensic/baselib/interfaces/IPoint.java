package com.ipotensic.baselib.interfaces;

import com.mapbox.mapboxsdk.geometry.LatLng;

/* loaded from: classes2.dex */
public interface IPoint {
    double getLat();

    double getLng();

    default LatLng getLatLng() {
        return new LatLng(getLat(), getLng());
    }

    default boolean valid() {
        return (getLat() == 0.0d && getLng() == 0.0d) ? false : true;
    }
}
