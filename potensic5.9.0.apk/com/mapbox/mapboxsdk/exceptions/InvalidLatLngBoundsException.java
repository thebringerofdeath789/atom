package com.mapbox.mapboxsdk.exceptions;

/* loaded from: classes3.dex */
public class InvalidLatLngBoundsException extends RuntimeException {
    public InvalidLatLngBoundsException(int i) {
        super("Cannot create a LatLngBounds from " + i + " items");
    }
}