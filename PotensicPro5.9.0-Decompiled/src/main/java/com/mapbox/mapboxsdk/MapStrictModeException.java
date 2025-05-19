package com.mapbox.mapboxsdk;

/* loaded from: classes3.dex */
class MapStrictModeException extends RuntimeException {
    MapStrictModeException(String str) {
        super(String.format("Map detected an error that would fail silently otherwise: %s", str));
    }
}
