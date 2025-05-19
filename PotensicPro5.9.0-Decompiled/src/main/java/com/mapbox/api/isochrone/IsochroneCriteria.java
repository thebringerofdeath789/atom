package com.mapbox.api.isochrone;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class IsochroneCriteria {
    public static final String PROFILE_CYCLING = "cycling";
    public static final String PROFILE_DEFAULT_USER = "mapbox";
    public static final String PROFILE_DRIVING = "driving";
    public static final String PROFILE_WALKING = "walking";

    @Retention(RetentionPolicy.CLASS)
    public @interface IsochroneProfile {
    }
}
