package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.p022v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.p022v5.models.AutoValue_LegStep;
import com.mapbox.api.directions.p022v5.models.C$AutoValue_LegStep;
import com.mapbox.api.directions.p022v5.models.DirectionsJsonObject;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class LegStep extends DirectionsJsonObject {
    public static final String MUTCD = "mutcd";
    public static final String VIENNA = "vienna";

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract Builder bannerInstructions(List<BannerInstructions> list);

        public abstract LegStep build();

        public abstract Builder destinations(String str);

        public abstract Builder distance(double d);

        public abstract Builder drivingSide(String str);

        public abstract Builder duration(double d);

        public abstract Builder durationTypical(Double d);

        public abstract Builder exits(String str);

        public abstract Builder geometry(String str);

        public abstract Builder intersections(List<StepIntersection> list);

        public abstract Builder maneuver(StepManeuver stepManeuver);

        public abstract Builder mode(String str);

        public abstract Builder name(String str);

        public abstract Builder pronunciation(String str);

        public abstract Builder ref(String str);

        public abstract Builder rotaryName(String str);

        public abstract Builder rotaryPronunciation(String str);

        public abstract Builder speedLimitSign(String str);

        public abstract Builder speedLimitUnit(String str);

        public abstract Builder voiceInstructions(List<VoiceInstructions> list);

        public abstract Builder weight(double d);
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface SpeedLimitSign {
    }

    public abstract List<BannerInstructions> bannerInstructions();

    public abstract String destinations();

    public abstract double distance();

    @SerializedName("driving_side")
    public abstract String drivingSide();

    public abstract double duration();

    @SerializedName("duration_typical")
    public abstract Double durationTypical();

    public abstract String exits();

    public abstract String geometry();

    public abstract List<StepIntersection> intersections();

    public abstract StepManeuver maneuver();

    public abstract String mode();

    public abstract String name();

    public abstract String pronunciation();

    public abstract String ref();

    @SerializedName("rotary_name")
    public abstract String rotaryName();

    @SerializedName("rotary_pronunciation")
    public abstract String rotaryPronunciation();

    public abstract String speedLimitSign();

    public abstract String speedLimitUnit();

    public abstract Builder toBuilder();

    public abstract List<VoiceInstructions> voiceInstructions();

    public abstract double weight();

    public static Builder builder() {
        return new C$AutoValue_LegStep.Builder();
    }

    public static TypeAdapter<LegStep> typeAdapter(Gson gson) {
        return new AutoValue_LegStep.GsonTypeAdapter(gson);
    }

    public static LegStep fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (LegStep) gsonBuilder.create().fromJson(str, LegStep.class);
    }
}