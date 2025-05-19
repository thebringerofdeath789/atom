package com.mapbox.core.constants;

import com.mapbox.core.BuildConfig;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class Constants {
    public static final String BASE_API_URL = "https://api.mapbox.com";
    public static final String HEADER_USER_AGENT = String.format(Locale.US, "MapboxJava/%s (%s)", BuildConfig.VERSION, BuildConfig.GIT_REVISION);
    public static final String MAPBOX_USER = "mapbox";
    public static final int PRECISION_5 = 5;
    public static final int PRECISION_6 = 6;

    private Constants() {
    }
}
