package com.mapbox.api.geocoding.p024v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mapbox.api.geocoding.p024v5.models.AutoValue_GeocodingResponse;
import com.mapbox.api.geocoding.p024v5.models.C$AutoValue_GeocodingResponse;
import com.mapbox.geojson.BoundingBox;
import com.mapbox.geojson.GeometryAdapterFactory;
import com.mapbox.geojson.gson.BoundingBoxTypeAdapter;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class GeocodingResponse implements Serializable {
    private static final String TYPE = "FeatureCollection";

    public static abstract class Builder {
        public abstract Builder attribution(String str);

        public abstract GeocodingResponse build();

        public abstract Builder features(List<CarmenFeature> list);

        public abstract Builder query(List<String> list);

        abstract Builder type(String str);
    }

    public abstract String attribution();

    public abstract List<CarmenFeature> features();

    public abstract List<String> query();

    public abstract Builder toBuilder();

    public abstract String type();

    public static GeocodingResponse fromJson(String str) {
        return (GeocodingResponse) new GsonBuilder().registerTypeAdapterFactory(GeometryAdapterFactory.create()).registerTypeAdapter(BoundingBox.class, new BoundingBoxTypeAdapter()).registerTypeAdapterFactory(GeocodingAdapterFactory.create()).create().fromJson(str, GeocodingResponse.class);
    }

    public static Builder builder() {
        return new C$AutoValue_GeocodingResponse.Builder().type(TYPE);
    }

    public String toJson() {
        return new GsonBuilder().registerTypeAdapterFactory(GeometryAdapterFactory.create()).registerTypeAdapter(BoundingBox.class, new BoundingBoxTypeAdapter()).registerTypeAdapterFactory(GeocodingAdapterFactory.create()).create().toJson(this, GeocodingResponse.class);
    }

    public static TypeAdapter<GeocodingResponse> typeAdapter(Gson gson) {
        return new AutoValue_GeocodingResponse.GsonTypeAdapter(gson);
    }
}