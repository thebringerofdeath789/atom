package com.mapbox.api.geocoding.v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.geocoding.v5.models.AutoValue_CarmenFeature;
import com.mapbox.api.geocoding.v5.models.C$AutoValue_CarmenFeature;
import com.mapbox.geojson.BoundingBox;
import com.mapbox.geojson.GeoJson;
import com.mapbox.geojson.Geometry;
import com.mapbox.geojson.GeometryAdapterFactory;
import com.mapbox.geojson.Point;
import com.mapbox.geojson.gson.BoundingBoxTypeAdapter;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class CarmenFeature implements GeoJson {
    private static final String TYPE = "Feature";

    public static abstract class Builder {
        public abstract Builder address(String str);

        public abstract Builder bbox(BoundingBox boundingBox);

        public abstract CarmenFeature build();

        public abstract Builder context(List<CarmenContext> list);

        public abstract Builder geometry(Geometry geometry);

        public abstract Builder id(String str);

        public abstract Builder language(String str);

        public abstract Builder matchingPlaceName(String str);

        public abstract Builder matchingText(String str);

        public abstract Builder placeName(String str);

        public abstract Builder placeType(List<String> list);

        public abstract Builder properties(JsonObject jsonObject);

        public abstract Builder rawCenter(double[] dArr);

        public abstract Builder relevance(Double d);

        public abstract Builder text(String str);

        abstract Builder type(String str);
    }

    public abstract String address();

    @Override // com.mapbox.geojson.GeoJson
    public abstract BoundingBox bbox();

    public abstract List<CarmenContext> context();

    public abstract Geometry geometry();

    public abstract String id();

    public abstract String language();

    @SerializedName("matching_place_name")
    public abstract String matchingPlaceName();

    @SerializedName("matching_text")
    public abstract String matchingText();

    @SerializedName("place_name")
    public abstract String placeName();

    @SerializedName("place_type")
    public abstract List<String> placeType();

    public abstract JsonObject properties();

    @SerializedName("center")
    abstract double[] rawCenter();

    public abstract Double relevance();

    public abstract String text();

    public abstract Builder toBuilder();

    @Override // com.mapbox.geojson.GeoJson
    @SerializedName("type")
    public abstract String type();

    public static CarmenFeature fromJson(String str) {
        CarmenFeature carmenFeature = (CarmenFeature) new GsonBuilder().registerTypeAdapterFactory(GeometryAdapterFactory.create()).registerTypeAdapter(BoundingBox.class, new BoundingBoxTypeAdapter()).registerTypeAdapterFactory(GeocodingAdapterFactory.create()).create().fromJson(str, CarmenFeature.class);
        return carmenFeature.properties() == null ? carmenFeature.toBuilder().properties(new JsonObject()).build() : carmenFeature;
    }

    public static Builder builder() {
        return new C$AutoValue_CarmenFeature.Builder().type(TYPE).properties(new JsonObject());
    }

    public Point center() {
        double[] rawCenter = rawCenter();
        if (rawCenter == null || rawCenter.length != 2) {
            return null;
        }
        return Point.fromLngLat(rawCenter[0], rawCenter[1]);
    }

    public static TypeAdapter<CarmenFeature> typeAdapter(Gson gson) {
        return new AutoValue_CarmenFeature.GsonTypeAdapter(gson);
    }

    @Override // com.mapbox.geojson.GeoJson
    public String toJson() {
        return new GsonBuilder().registerTypeAdapterFactory(GeometryAdapterFactory.create()).registerTypeAdapter(BoundingBox.class, new BoundingBoxTypeAdapter()).registerTypeAdapterFactory(GeocodingAdapterFactory.create()).create().toJson((properties() == null || properties().size() != 0) ? this : toBuilder().properties(null).build(), CarmenFeature.class);
    }
}
