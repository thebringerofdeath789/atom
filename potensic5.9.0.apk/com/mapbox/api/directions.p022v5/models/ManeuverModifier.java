package com.mapbox.api.directions.p022v5.models;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public final class ManeuverModifier {
    public static final String LEFT = "left";
    public static final String RIGHT = "right";
    public static final String SHARP_LEFT = "sharp left";
    public static final String SHARP_RIGHT = "sharp right";
    public static final String SLIGHT_LEFT = "slight left";
    public static final String SLIGHT_RIGHT = "slight right";
    public static final String STRAIGHT = "straight";
    public static final String UTURN = "uturn";

    @Retention(RetentionPolicy.CLASS)
    public @interface Type {
    }
}