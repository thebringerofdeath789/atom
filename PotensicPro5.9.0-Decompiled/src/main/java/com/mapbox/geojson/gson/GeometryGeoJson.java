package com.mapbox.geojson.gson;

import com.google.gson.GsonBuilder;
import com.mapbox.geojson.Geometry;
import com.mapbox.geojson.GeometryAdapterFactory;

/* loaded from: classes3.dex */
public class GeometryGeoJson {
    public static Geometry fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(GeoJsonAdapterFactory.create());
        gsonBuilder.registerTypeAdapterFactory(GeometryAdapterFactory.create());
        return (Geometry) gsonBuilder.create().fromJson(str, Geometry.class);
    }
}
