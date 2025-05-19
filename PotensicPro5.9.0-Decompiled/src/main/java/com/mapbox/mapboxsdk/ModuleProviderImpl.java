package com.mapbox.mapboxsdk;

import com.mapbox.mapboxsdk.http.HttpRequest;
import com.mapbox.mapboxsdk.maps.TelemetryDefinition;
import com.mapbox.mapboxsdk.module.http.HttpRequestImpl;
import com.mapbox.mapboxsdk.module.loader.LibraryLoaderProviderImpl;
import com.mapbox.mapboxsdk.module.telemetry.TelemetryImpl;

/* loaded from: classes3.dex */
public class ModuleProviderImpl implements ModuleProvider {
    @Override // com.mapbox.mapboxsdk.ModuleProvider
    public HttpRequest createHttpRequest() {
        return new HttpRequestImpl();
    }

    @Override // com.mapbox.mapboxsdk.ModuleProvider
    public TelemetryDefinition obtainTelemetry() {
        return new TelemetryImpl();
    }

    @Override // com.mapbox.mapboxsdk.ModuleProvider
    public LibraryLoaderProvider createLibraryLoaderProvider() {
        return new LibraryLoaderProviderImpl();
    }
}
