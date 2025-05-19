package com.mapbox.api.matching.v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.matching.v5.models.AutoValue_MapMatchingResponse;
import com.mapbox.api.matching.v5.models.C$AutoValue_MapMatchingResponse;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class MapMatchingResponse implements Serializable {

    public static abstract class Builder {
        public abstract MapMatchingResponse build();

        public abstract Builder code(String str);

        public abstract Builder matchings(List<MapMatchingMatching> list);

        public abstract Builder message(String str);

        public abstract Builder tracepoints(List<MapMatchingTracepoint> list);
    }

    public abstract String code();

    public abstract List<MapMatchingMatching> matchings();

    public abstract String message();

    public abstract Builder toBuilder();

    public abstract List<MapMatchingTracepoint> tracepoints();

    public static Builder builder() {
        return new C$AutoValue_MapMatchingResponse.Builder();
    }

    public static TypeAdapter<MapMatchingResponse> typeAdapter(Gson gson) {
        return new AutoValue_MapMatchingResponse.GsonTypeAdapter(gson);
    }

    public static MapMatchingResponse fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(MapMatchingAdapterFactory.create());
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (MapMatchingResponse) gsonBuilder.create().fromJson(str, MapMatchingResponse.class);
    }
}
