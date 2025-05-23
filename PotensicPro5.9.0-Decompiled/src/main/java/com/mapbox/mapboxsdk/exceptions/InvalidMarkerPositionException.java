package com.mapbox.mapboxsdk.exceptions;

/* loaded from: classes3.dex */
public class InvalidMarkerPositionException extends RuntimeException {
    public InvalidMarkerPositionException() {
        super("Adding an invalid Marker to a Map. Missing the required position field. Provide a non null LatLng as position to the Marker.");
    }
}
