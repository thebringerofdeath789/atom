package com.mapbox.mapboxsdk.exceptions;

/* loaded from: classes3.dex */
public class MapboxLifecycleException extends RuntimeException {
    public MapboxLifecycleException() {
        super("MapView requires calling the correct Activity lifecycle methods: onCreate, onStart, onStop and onDestroy.");
    }
}