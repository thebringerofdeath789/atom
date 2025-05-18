package com.mapbox.api.staticmap.p030v1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public final class StaticMapCriteria {
    public static final String DARK_STYLE = "dark-v10";
    public static final String LARGE_PIN = "pin-l";
    public static final String LIGHT_STYLE = "light-v10";
    public static final String MEDIUM_PIN = "pin-m";
    public static final String NAVIGATION_GUIDANCE_DAY = "navigation-guidance-day-v4";
    public static final String NAVIGATION_GUIDANCE_NIGHT = "navigation-guidance-night-v4";
    public static final String NAVIGATION_PREVIEW_DAY = "navigation-preview-day-v3";
    public static final String NAVIGATION_PREVIEW_NIGHT = "navigation-preview-night-v3";
    public static final String OUTDOORS_STYLE = "outdoors-v11";
    public static final String SATELLITE_STREETS_STYLE = "satellite-streets-v11";
    public static final String SATELLITE_STYLE = "satellite-v9";
    public static final String SMALL_PIN = "pin-s";
    public static final String STREET_STYLE = "streets-v11";

    @Retention(RetentionPolicy.CLASS)
    public @interface MarkerCriteria {
    }

    private StaticMapCriteria() {
        throw new AssertionError("No Instances.");
    }
}