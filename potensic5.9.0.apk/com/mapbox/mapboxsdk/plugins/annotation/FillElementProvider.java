package com.mapbox.mapboxsdk.plugins.annotation;

import com.mapbox.mapboxsdk.style.layers.FillLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonOptions;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
class FillElementProvider implements CoreElementProvider<FillLayer> {
    private static final AtomicLong ID_GENERATOR = new AtomicLong(0);
    private static final String ID_GEOJSON_LAYER = "mapbox-android-fill-layer-%s";
    private static final String ID_GEOJSON_SOURCE = "mapbox-android-fill-source-%s";
    private final String layerId;
    private final String sourceId;

    FillElementProvider() {
        long incrementAndGet = ID_GENERATOR.incrementAndGet();
        this.layerId = String.format(ID_GEOJSON_LAYER, Long.valueOf(incrementAndGet));
        this.sourceId = String.format(ID_GEOJSON_SOURCE, Long.valueOf(incrementAndGet));
    }

    @Override // com.mapbox.mapboxsdk.plugins.annotation.CoreElementProvider
    public String getLayerId() {
        return this.layerId;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.mapbox.mapboxsdk.plugins.annotation.CoreElementProvider
    public FillLayer getLayer() {
        return new FillLayer(this.layerId, this.sourceId);
    }

    @Override // com.mapbox.mapboxsdk.plugins.annotation.CoreElementProvider
    public GeoJsonSource getSource(GeoJsonOptions geoJsonOptions) {
        return new GeoJsonSource(this.sourceId, geoJsonOptions);
    }
}