package com.mapbox.api.matching.v5.models;

import com.google.gson.TypeAdapterFactory;

/* loaded from: classes3.dex */
public abstract class MapMatchingAdapterFactory implements TypeAdapterFactory {
    public static TypeAdapterFactory create() {
        return new AutoValueGson_MapMatchingAdapterFactory();
    }
}
