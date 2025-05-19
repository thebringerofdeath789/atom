package com.mapbox.mapboxsdk;

import com.mapbox.mapboxsdk.http.HttpRequest;
import com.mapbox.mapboxsdk.maps.TelemetryDefinition;

/* loaded from: classes3.dex */
public interface ModuleProvider {
    HttpRequest createHttpRequest();

    LibraryLoaderProvider createLibraryLoaderProvider();

    TelemetryDefinition obtainTelemetry();
}
