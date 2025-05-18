package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.p022v5.models.AutoValue_DirectionsError;
import com.mapbox.api.directions.p022v5.models.C$AutoValue_DirectionsError;
import com.mapbox.api.directions.p022v5.models.DirectionsJsonObject;
import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class DirectionsError extends DirectionsJsonObject implements Serializable {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract DirectionsError build();

        public abstract Builder code(String str);

        public abstract Builder message(String str);
    }

    public abstract String code();

    public abstract String message();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_DirectionsError.Builder();
    }

    public static TypeAdapter<DirectionsError> typeAdapter(Gson gson) {
        return new AutoValue_DirectionsError.GsonTypeAdapter(gson);
    }
}