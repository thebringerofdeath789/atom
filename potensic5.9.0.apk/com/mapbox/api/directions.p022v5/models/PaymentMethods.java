package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.p022v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.p022v5.models.AutoValue_PaymentMethods;
import com.mapbox.api.directions.p022v5.models.C$AutoValue_PaymentMethods;
import com.mapbox.api.directions.p022v5.models.DirectionsJsonObject;

/* loaded from: classes3.dex */
public abstract class PaymentMethods extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract PaymentMethods build();

        public abstract Builder cash(CostPerVehicleSize costPerVehicleSize);

        public abstract Builder etc(CostPerVehicleSize costPerVehicleSize);
    }

    public abstract CostPerVehicleSize cash();

    public abstract CostPerVehicleSize etc();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_PaymentMethods.Builder();
    }

    public static TypeAdapter<PaymentMethods> typeAdapter(Gson gson) {
        return new AutoValue_PaymentMethods.GsonTypeAdapter(gson);
    }

    public static PaymentMethods fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (PaymentMethods) gsonBuilder.create().fromJson(str, PaymentMethods.class);
    }
}