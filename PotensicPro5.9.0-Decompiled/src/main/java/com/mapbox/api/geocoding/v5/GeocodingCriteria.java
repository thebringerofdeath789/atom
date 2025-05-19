package com.mapbox.api.geocoding.v5;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public final class GeocodingCriteria {
    public static final String MODE_PLACES = "mapbox.places";
    public static final String MODE_PLACES_PERMANENT = "mapbox.places-permanent";
    public static final String REVERSE_MODE_DISTANCE = "distance";
    public static final String REVERSE_MODE_SCORE = "score";
    public static final String TYPE_ADDRESS = "address";
    public static final String TYPE_COUNTRY = "country";
    public static final String TYPE_DISTRICT = "district";
    public static final String TYPE_LOCALITY = "locality";
    public static final String TYPE_NEIGHBORHOOD = "neighborhood";
    public static final String TYPE_PLACE = "place";
    public static final String TYPE_POI = "poi";
    public static final String TYPE_POI_LANDMARK = "poi.landmark";
    public static final String TYPE_POSTCODE = "postcode";
    public static final String TYPE_REGION = "region";

    @Retention(RetentionPolicy.CLASS)
    public @interface GeocodingModeCriteria {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface GeocodingReverseModeCriteria {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface GeocodingTypeCriteria {
    }

    private GeocodingCriteria() {
    }
}
