package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.p022v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.p022v5.models.AutoValue_BannerComponents;
import com.mapbox.api.directions.p022v5.models.C$AutoValue_BannerComponents;
import com.mapbox.api.directions.p022v5.models.DirectionsJsonObject;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BannerComponents extends DirectionsJsonObject implements Comparable<BannerComponents> {
    public static final String AFTERTOLL = "aftertoll";
    public static final String CITYREAL = "cityreal";
    public static final String DELIMITER = "delimiter";
    public static final String EXIT = "exit";
    public static final String EXIT_NUMBER = "exit-number";
    public static final String EXPRESSWAY_ENTRANCE = "entrance";
    public static final String EXPRESSWAY_EXIT = "exit";
    public static final String GUIDANCE_VIEW = "guidance-view";
    public static final String ICON = "icon";
    public static final String JCT = "jct";
    public static final String LANE = "lane";
    public static final String SAPA = "sapa";
    public static final String SAPAGUIDEMAP = "sapaguidemap";
    public static final String SIGNBOARD = "signboard";
    public static final String TEXT = "text";
    public static final String TOLLBRANCH = "tollbranch";

    @Retention(RetentionPolicy.CLASS)
    public @interface BannerComponentsSubType {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface BannerComponentsType {
    }

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract Builder abbreviation(String str);

        public abstract Builder abbreviationPriority(Integer num);

        public abstract Builder active(Boolean bool);

        public abstract Builder activeDirection(String str);

        public abstract BannerComponents build();

        public abstract Builder directions(List<String> list);

        public abstract Builder imageBaseUrl(String str);

        public abstract Builder imageUrl(String str);

        public abstract Builder mapboxShield(MapboxShield mapboxShield);

        public abstract Builder subType(String str);

        public abstract Builder text(String str);

        public abstract Builder type(String str);
    }

    @SerializedName("abbr")
    public abstract String abbreviation();

    @SerializedName("abbr_priority")
    public abstract Integer abbreviationPriority();

    public abstract Boolean active();

    @SerializedName("active_direction")
    public abstract String activeDirection();

    public abstract List<String> directions();

    @SerializedName("imageBaseURL")
    public abstract String imageBaseUrl();

    @SerializedName("imageURL")
    public abstract String imageUrl();

    @SerializedName("mapbox_shield")
    public abstract MapboxShield mapboxShield();

    public abstract String subType();

    public abstract String text();

    public abstract Builder toBuilder();

    public abstract String type();

    public static Builder builder() {
        return new C$AutoValue_BannerComponents.Builder();
    }

    public static TypeAdapter<BannerComponents> typeAdapter(Gson gson) {
        return new AutoValue_BannerComponents.GsonTypeAdapter(gson);
    }

    public static BannerComponents fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (BannerComponents) gsonBuilder.create().fromJson(str, BannerComponents.class);
    }

    @Override // java.lang.Comparable
    public int compareTo(BannerComponents bannerComponents) {
        Integer abbreviationPriority = abbreviationPriority();
        Integer abbreviationPriority2 = bannerComponents.abbreviationPriority();
        if (abbreviationPriority == null && abbreviationPriority2 == null) {
            return 0;
        }
        if (abbreviationPriority == null) {
            return 1;
        }
        if (abbreviationPriority2 == null) {
            return -1;
        }
        return abbreviationPriority.compareTo(abbreviationPriority2);
    }
}