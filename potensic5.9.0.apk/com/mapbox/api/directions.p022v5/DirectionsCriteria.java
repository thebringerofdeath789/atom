package com.mapbox.api.directions.p022v5;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public final class DirectionsCriteria {
    public static final String ANNOTATION_CLOSURE = "closure";
    public static final String ANNOTATION_CONGESTION = "congestion";
    public static final String ANNOTATION_CONGESTION_NUMERIC = "congestion_numeric";
    public static final String ANNOTATION_DISTANCE = "distance";
    public static final String ANNOTATION_DURATION = "duration";
    public static final String ANNOTATION_MAXSPEED = "maxspeed";
    public static final String ANNOTATION_SPEED = "speed";
    public static final String ANNOTATION_TRAFFIC_TENDENCY = "traffic_tendency";
    public static final String APPROACH_CURB = "curb";
    public static final String APPROACH_UNRESTRICTED = "unrestricted";
    public static final String BASE_API_URL = "https://api.mapbox.com";
    public static final String DESTINATION_ANY = "any";
    public static final String DESTINATION_LAST = "last";
    public static final String EXCLUDE_CASH_ONLY_TOLLS = "cash_only_tolls";
    public static final String EXCLUDE_FERRY = "ferry";
    public static final String EXCLUDE_MOTORWAY = "motorway";
    public static final String EXCLUDE_RESTRICTED = "restricted";
    public static final String EXCLUDE_TOLL = "toll";
    public static final String EXCLUDE_TUNNEL = "tunnel";
    public static final String EXCLUDE_UNPAVED = "unpaved";
    public static final String GEOMETRY_POLYLINE = "polyline";
    public static final String GEOMETRY_POLYLINE6 = "polyline6";
    public static final String IMPERIAL = "imperial";
    public static final String INCLUDE_HOT = "hot";
    public static final String INCLUDE_HOV2 = "hov2";
    public static final String INCLUDE_HOV3 = "hov3";
    public static final String METRIC = "metric";
    public static final String OVERVIEW_FALSE = "false";
    public static final String OVERVIEW_FULL = "full";
    public static final String OVERVIEW_SIMPLIFIED = "simplified";
    public static final String PROFILE_CYCLING = "cycling";
    public static final String PROFILE_DEFAULT_USER = "mapbox";
    public static final String PROFILE_DRIVING = "driving";
    public static final String PROFILE_DRIVING_TRAFFIC = "driving-traffic";
    public static final String PROFILE_WALKING = "walking";
    public static final String SOURCE_ANY = "any";
    public static final String SOURCE_FIRST = "first";
    public static final int TRAFFIC_TENDENCY_CONSTANT_CONGESTION = 1;
    public static final int TRAFFIC_TENDENCY_DECREASING_CONGESTION = 3;
    public static final int TRAFFIC_TENDENCY_INCREASING_CONGESTION = 2;
    public static final int TRAFFIC_TENDENCY_RAPIDLY_DECREASING_CONGESTION = 5;
    public static final int TRAFFIC_TENDENCY_RAPIDLY_INCREASING_CONGESTION = 4;
    public static final int TRAFFIC_TENDENCY_UNKNOWN = 0;

    @Retention(RetentionPolicy.CLASS)
    public @interface AnnotationCriteria {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface ApproachesCriteria {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface DestinationCriteria {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface ExcludeCriteria {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface GeometriesCriteria {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface IncludeCriteria {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface OverviewCriteria {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface ProfileCriteria {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface SourceCriteria {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface TrafficTendencyCriteria {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface VoiceUnitCriteria {
    }

    private DirectionsCriteria() {
    }
}