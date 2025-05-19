package com.mapbox.api.directions.v5.models;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.utils.UnrecognizedPropertiesUtils;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import com.mapbox.geojson.Point;
import com.mapbox.geojson.PointAsCoordinatesTypeAdapter;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class DirectionsJsonObject implements Serializable {
    abstract Map<String, SerializableJsonElement> unrecognized();

    public String toJson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        gsonBuilder.registerTypeAdapter(Point.class, new PointAsCoordinatesTypeAdapter());
        return gsonBuilder.create().toJson(this);
    }

    public final JsonElement getUnrecognizedProperty(String str) {
        SerializableJsonElement serializableJsonElement;
        Map<String, SerializableJsonElement> unrecognized = unrecognized();
        if (unrecognized == null || (serializableJsonElement = unrecognized.get(str)) == null) {
            return null;
        }
        return serializableJsonElement.getElement();
    }

    public final Set<String> getUnrecognizedPropertiesNames() {
        Map<String, SerializableJsonElement> unrecognized = unrecognized();
        if (unrecognized != null) {
            return unrecognized.keySet();
        }
        return Collections.emptySet();
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
