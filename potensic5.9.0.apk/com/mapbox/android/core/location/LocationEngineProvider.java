package com.mapbox.android.core.location;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;

/* loaded from: classes3.dex */
public final class LocationEngineProvider {
    private static final String GOOGLE_API_AVAILABILITY = "com.google.android.gms.common.GoogleApiAvailability";
    private static final String GOOGLE_LOCATION_SERVICES = "com.google.android.gms.location.LocationServices";

    private LocationEngineProvider() {
    }

    @Deprecated
    public static LocationEngine getBestLocationEngine(Context context, boolean z) {
        return getBestLocationEngine(context);
    }

    public static LocationEngine getBestLocationEngine(Context context) {
        Utils.checkNotNull(context, "context == null");
        boolean isOnClasspath = Utils.isOnClasspath(GOOGLE_LOCATION_SERVICES);
        if (Utils.isOnClasspath(GOOGLE_API_AVAILABILITY)) {
            isOnClasspath &= GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0;
        }
        return getLocationEngine(context, isOnClasspath);
    }

    private static LocationEngine getLocationEngine(Context context, boolean z) {
        if (z) {
            return new LocationEngineProxy(new GoogleLocationEngineImpl(context.getApplicationContext()));
        }
        return new LocationEngineProxy(new MapboxFusedLocationEngineImpl(context.getApplicationContext()));
    }
}