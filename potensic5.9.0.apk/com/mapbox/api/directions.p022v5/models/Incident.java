package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.p022v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.p022v5.models.AutoValue_Incident;
import com.mapbox.api.directions.p022v5.models.C$AutoValue_Incident;
import com.mapbox.api.directions.p022v5.models.DirectionsJsonObject;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class Incident extends DirectionsJsonObject {
    public static final String IMPACT_CRITICAL = "critical";
    public static final String IMPACT_LOW = "low";
    public static final String IMPACT_MAJOR = "major";
    public static final String IMPACT_MINOR = "minor";
    public static final String IMPACT_UNKNOWN = "unknown";
    public static final String INCIDENT_ACCIDENT = "accident";
    public static final String INCIDENT_CONGESTION = "congestion";
    public static final String INCIDENT_CONSTRUCTION = "construction";
    public static final String INCIDENT_DISABLED_VEHICLE = "disabled_vehicle";
    public static final String INCIDENT_LANE_RESTRICTION = "lane_restriction";
    public static final String INCIDENT_MASS_TRANSIT = "mass_transit";
    public static final String INCIDENT_MISCELLANEOUS = "miscellaneous";
    public static final String INCIDENT_OTHER_NEWS = "other_news";
    public static final String INCIDENT_PLANNED_EVENT = "planned_event";
    public static final String INCIDENT_ROAD_CLOSURE = "road_closure";
    public static final String INCIDENT_ROAD_HAZARD = "road_hazard";
    public static final String INCIDENT_WEATHER = "weather";

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract Builder affectedRoadNames(List<String> list);

        public abstract Builder alertcCodes(List<Integer> list);

        public abstract Incident build();

        public abstract Builder closed(Boolean bool);

        public abstract Builder congestion(Congestion congestion);

        public abstract Builder countryCodeAlpha2(String str);

        public abstract Builder countryCodeAlpha3(String str);

        public abstract Builder creationTime(String str);

        public abstract Builder description(String str);

        public abstract Builder endTime(String str);

        public abstract Builder geometryIndexEnd(Integer num);

        public abstract Builder geometryIndexStart(Integer num);

        /* renamed from: id */
        public abstract Builder mo1739id(String str);

        public abstract Builder impact(String str);

        public abstract Builder lanesBlocked(List<String> list);

        public abstract Builder longDescription(String str);

        public abstract Builder numLanesBlocked(Integer num);

        public abstract Builder startTime(String str);

        public abstract Builder subType(String str);

        public abstract Builder subTypeDescription(String str);

        public abstract Builder type(String str);
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface ImpactType {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface IncidentType {
    }

    @SerializedName("affected_road_names")
    public abstract List<String> affectedRoadNames();

    @SerializedName("alertc_codes")
    public abstract List<Integer> alertcCodes();

    public abstract Boolean closed();

    public abstract Congestion congestion();

    @SerializedName("iso_3166_1_alpha2")
    public abstract String countryCodeAlpha2();

    @SerializedName("iso_3166_1_alpha3")
    public abstract String countryCodeAlpha3();

    @SerializedName("creation_time")
    public abstract String creationTime();

    public abstract String description();

    @SerializedName("end_time")
    public abstract String endTime();

    @SerializedName("geometry_index_end")
    public abstract Integer geometryIndexEnd();

    @SerializedName("geometry_index_start")
    public abstract Integer geometryIndexStart();

    /* renamed from: id */
    public abstract String mo1738id();

    public abstract String impact();

    @SerializedName("lanes_blocked")
    public abstract List<String> lanesBlocked();

    @SerializedName("long_description")
    public abstract String longDescription();

    @SerializedName("num_lanes_blocked")
    public abstract Integer numLanesBlocked();

    @SerializedName("start_time")
    public abstract String startTime();

    @SerializedName("sub_type")
    public abstract String subType();

    @SerializedName("sub_type_description")
    public abstract String subTypeDescription();

    public abstract Builder toBuilder();

    public abstract String type();

    public static Builder builder() {
        return new C$AutoValue_Incident.Builder();
    }

    public static TypeAdapter<Incident> typeAdapter(Gson gson) {
        return new AutoValue_Incident.GsonTypeAdapter(gson);
    }

    public static Incident fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (Incident) gsonBuilder.create().fromJson(str, Incident.class);
    }
}