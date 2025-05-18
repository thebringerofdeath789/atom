package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.p022v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.p022v5.models.AutoValue_TollCost;
import com.mapbox.api.directions.p022v5.models.C$AutoValue_TollCost;
import com.mapbox.api.directions.p022v5.models.DirectionsJsonObject;

/* loaded from: classes3.dex */
public abstract class TollCost extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract TollCost build();

        public abstract Builder currency(String str);

        public abstract Builder paymentMethods(PaymentMethods paymentMethods);
    }

    public abstract String currency();

    @SerializedName("payment_methods")
    public abstract PaymentMethods paymentMethods();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_TollCost.Builder();
    }

    public static TypeAdapter<TollCost> typeAdapter(Gson gson) {
        return new AutoValue_TollCost.GsonTypeAdapter(gson);
    }

    public static TollCost fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (TollCost) gsonBuilder.create().fromJson(str, TollCost.class);
    }
}