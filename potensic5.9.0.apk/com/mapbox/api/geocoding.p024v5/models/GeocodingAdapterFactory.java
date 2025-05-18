package com.mapbox.api.geocoding.p024v5.models;

import com.google.gson.TypeAdapterFactory;

/* loaded from: classes3.dex */
public abstract class GeocodingAdapterFactory implements TypeAdapterFactory {
    public static TypeAdapterFactory create() {
        return new AutoValueGson_GeocodingAdapterFactory();
    }
}