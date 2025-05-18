package com.mapbox.api.routetiles.p028v1.versions.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.mapbox.api.geocoding.p024v5.models.CarmenContext;
import com.mapbox.api.geocoding.p024v5.models.CarmenFeature;
import com.mapbox.api.geocoding.p024v5.models.GeocodingResponse;
import com.mapbox.api.matching.p025v5.models.MapMatchingError;
import com.mapbox.api.matching.p025v5.models.MapMatchingMatching;
import com.mapbox.api.matching.p025v5.models.MapMatchingResponse;
import com.mapbox.api.matching.p025v5.models.MapMatchingTracepoint;
import com.mapbox.api.matrix.p026v1.models.MatrixResponse;
import com.mapbox.api.optimization.p027v1.models.OptimizationResponse;
import com.mapbox.api.optimization.p027v1.models.OptimizationWaypoint;

/* loaded from: classes3.dex */
final class AutoValueGson_RouteTileVersionsAdapterFactory extends RouteTileVersionsAdapterFactory {
    AutoValueGson_RouteTileVersionsAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (CarmenContext.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) CarmenContext.typeAdapter(gson);
        }
        if (CarmenFeature.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) CarmenFeature.typeAdapter(gson);
        }
        if (GeocodingResponse.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) GeocodingResponse.typeAdapter(gson);
        }
        if (MapMatchingError.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) MapMatchingError.typeAdapter(gson);
        }
        if (MapMatchingMatching.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) MapMatchingMatching.typeAdapter(gson);
        }
        if (MapMatchingResponse.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) MapMatchingResponse.typeAdapter(gson);
        }
        if (MapMatchingTracepoint.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) MapMatchingTracepoint.typeAdapter(gson);
        }
        if (MatrixResponse.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) MatrixResponse.typeAdapter(gson);
        }
        if (OptimizationResponse.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) OptimizationResponse.typeAdapter(gson);
        }
        if (OptimizationWaypoint.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) OptimizationWaypoint.typeAdapter(gson);
        }
        if (RouteTileVersionsResponse.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) RouteTileVersionsResponse.typeAdapter(gson);
        }
        return null;
    }
}