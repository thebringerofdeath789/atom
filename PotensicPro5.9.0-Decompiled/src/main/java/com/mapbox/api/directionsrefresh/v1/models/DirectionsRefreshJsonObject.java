package com.mapbox.api.directionsrefresh.v1.models;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.utils.UnrecognizedPropertiesUtils;
import com.mapbox.api.directionsrefresh.v1.DirectionsRefreshAdapterFactory;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import com.mapbox.geojson.Point;
import com.mapbox.geojson.PointAsCoordinatesTypeAdapter;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class DirectionsRefreshJsonObject implements Serializable {
    abstract Map<String, SerializableJsonElement> unrecognized();

    public String toJson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        gsonBuilder.registerTypeAdapter(Point.class, new PointAsCoordinatesTypeAdapter());
        gsonBuilder.registerTypeAdapterFactory(DirectionsRefreshAdapterFactory.create());
        return gsonBuilder.create().toJson(this);
    }

    public final Map<String, JsonElement> getUnrecognizedJsonProperties() {
        return UnrecognizedPropertiesUtils.fromSerializableProperties(unrecognized());
    }

    static abstract class Builder<T extends Builder> {
        abstract T unrecognized(Map<String, SerializableJsonElement> map);

        Builder() {
        }

        public T unrecognizedJsonProperties(Map<String, JsonElement> map) {
            return unrecognized(UnrecognizedPropertiesUtils.toSerializableProperties(map));
        }
    }
}
