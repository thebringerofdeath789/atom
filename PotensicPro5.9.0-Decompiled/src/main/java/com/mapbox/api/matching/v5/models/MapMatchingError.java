package com.mapbox.api.matching.v5.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.mapbox.api.matching.v5.models.AutoValue_MapMatchingError;
import com.mapbox.api.matching.v5.models.C$AutoValue_MapMatchingError;
import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class MapMatchingError implements Serializable {

    public static abstract class Builder {
        public abstract MapMatchingError build();

        public abstract Builder code(String str);

        public abstract Builder message(String str);
    }

    public abstract String code();

    public abstract String message();

    public static Builder builder() {
        return new C$AutoValue_MapMatchingError.Builder();
    }

    public static TypeAdapter<MapMatchingError> typeAdapter(Gson gson) {
        return new AutoValue_MapMatchingError.GsonTypeAdapter(gson);
    }
}
