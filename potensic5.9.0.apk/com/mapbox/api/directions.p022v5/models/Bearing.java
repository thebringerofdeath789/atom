package com.mapbox.api.directions.p022v5.models;

import com.mapbox.api.directions.p022v5.models.AutoValue_Bearing;
import com.mapbox.api.directions.p022v5.models.DirectionsJsonObject;

/* loaded from: classes3.dex */
public abstract class Bearing extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract Builder angle(double d);

        public abstract Bearing build();

        public abstract Builder degrees(double d);
    }

    public abstract double angle();

    public abstract double degrees();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new AutoValue_Bearing.Builder().angle(45.0d).degrees(90.0d);
    }
}