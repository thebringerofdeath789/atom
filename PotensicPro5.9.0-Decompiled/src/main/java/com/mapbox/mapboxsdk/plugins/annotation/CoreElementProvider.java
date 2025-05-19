package com.mapbox.mapboxsdk.plugins.annotation;

import com.mapbox.mapboxsdk.style.layers.Layer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonOptions;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;

/* loaded from: classes3.dex */
interface CoreElementProvider<L extends Layer> {
    L getLayer();

    String getLayerId();

    GeoJsonSource getSource(GeoJsonOptions geoJsonOptions);
}
