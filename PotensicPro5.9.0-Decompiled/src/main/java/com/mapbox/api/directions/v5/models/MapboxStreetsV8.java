package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.models.AutoValue_MapboxStreetsV8;
import com.mapbox.api.directions.v5.models.C$AutoValue_MapboxStreetsV8;
import com.mapbox.api.directions.v5.models.DirectionsJsonObject;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;

/* loaded from: classes3.dex */
public abstract class MapboxStreetsV8 extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract MapboxStreetsV8 build();

        public abstract Builder roadClass(String str);
    }

    @SerializedName(JamXmlElements.CLASS)
    public abstract String roadClass();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_MapboxStreetsV8.Builder();
    }

    public static TypeAdapter<MapboxStreetsV8> typeAdapter(Gson gson) {
        return new AutoValue_MapboxStreetsV8.GsonTypeAdapter(gson);
    }

    public static MapboxStreetsV8 fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (MapboxStreetsV8) gsonBuilder.create().fromJson(str, MapboxStreetsV8.class);
    }
}
