package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.p022v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.p022v5.models.AutoValue_CostPerVehicleSize;
import com.mapbox.api.directions.p022v5.models.C$AutoValue_CostPerVehicleSize;
import com.mapbox.api.directions.p022v5.models.DirectionsJsonObject;

/* loaded from: classes3.dex */
public abstract class CostPerVehicleSize extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract CostPerVehicleSize build();

        public abstract Builder jumbo(Double d);

        public abstract Builder large(Double d);

        public abstract Builder middle(Double d);

        public abstract Builder small(Double d);

        public abstract Builder standard(Double d);
    }

    public abstract Double jumbo();

    public abstract Double large();

    public abstract Double middle();

    public abstract Double small();

    public abstract Double standard();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_CostPerVehicleSize.Builder();
    }

    public static TypeAdapter<CostPerVehicleSize> typeAdapter(Gson gson) {
        return new AutoValue_CostPerVehicleSize.GsonTypeAdapter(gson);
    }

    public static CostPerVehicleSize fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (CostPerVehicleSize) gsonBuilder.create().fromJson(str, CostPerVehicleSize.class);
    }
}