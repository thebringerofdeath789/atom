package com.mapbox.api.matrix.v1.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.v5.models.DirectionsWaypoint;
import com.mapbox.api.matrix.v1.models.AutoValue_MatrixResponse;
import com.mapbox.api.matrix.v1.models.C$AutoValue_MatrixResponse;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class MatrixResponse implements Serializable {

    public static abstract class Builder {
        public abstract MatrixResponse build();

        public abstract Builder code(String str);

        public abstract Builder destinations(List<DirectionsWaypoint> list);

        public abstract Builder distances(List<Double[]> list);

        public abstract Builder durations(List<Double[]> list);

        public abstract Builder sources(List<DirectionsWaypoint> list);
    }

    public abstract String code();

    public abstract List<DirectionsWaypoint> destinations();

    public abstract List<Double[]> distances();

    public abstract List<Double[]> durations();

    public abstract List<DirectionsWaypoint> sources();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_MatrixResponse.Builder();
    }

    public static TypeAdapter<MatrixResponse> typeAdapter(Gson gson) {
        return new AutoValue_MatrixResponse.GsonTypeAdapter(gson);
    }
}
