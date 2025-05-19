package com.mapbox.api.directions.v5;

import com.google.gson.TypeAdapterFactory;

/* loaded from: classes3.dex */
public abstract class DirectionsAdapterFactory implements TypeAdapterFactory {
    public static TypeAdapterFactory create() {
        return new AutoValueGson_DirectionsAdapterFactory();
    }
}
