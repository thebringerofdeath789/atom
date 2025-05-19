package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.models.AutoValue_VoiceInstructions;
import com.mapbox.api.directions.v5.models.C$AutoValue_VoiceInstructions;
import com.mapbox.api.directions.v5.models.DirectionsJsonObject;

/* loaded from: classes3.dex */
public abstract class VoiceInstructions extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract Builder announcement(String str);

        public abstract VoiceInstructions build();

        public abstract Builder distanceAlongGeometry(Double d);

        public abstract Builder ssmlAnnouncement(String str);
    }

    public abstract String announcement();

    public abstract Double distanceAlongGeometry();

    public abstract String ssmlAnnouncement();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_VoiceInstructions.Builder();
    }

    public static TypeAdapter<VoiceInstructions> typeAdapter(Gson gson) {
        return new AutoValue_VoiceInstructions.GsonTypeAdapter(gson);
    }

    public static VoiceInstructions fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (VoiceInstructions) gsonBuilder.create().fromJson(str, VoiceInstructions.class);
    }
}
