package com.mapbox.android.telemetry.location;

import android.location.Location;
import com.mapbox.android.telemetry.LocationEvent;
import java.math.BigDecimal;

/* loaded from: classes3.dex */
public class LocationMapper {
    private static final double MAX_LONGITUDE = 180.0d;
    private static final double MIN_LONGITUDE = -180.0d;
    private static final int SEVEN_DIGITS_AFTER_DECIMAL = 7;
    private SessionIdentifier sessionIdentifier = new SessionIdentifier();

    private static double wrap(double d, double d2, double d3) {
        double d4 = d3 - d2;
        return ((((d - d2) % d4) + d4) % d4) + d2;
    }

    @Deprecated
    public static LocationEvent create(Location location, String str) {
        return createLocationEvent(location, "unknown", str);
    }

    public static LocationEvent create(Location location, String str, String str2) {
        return createLocationEvent(location, str, str2);
    }

    public LocationEvent from(Location location, String str) {
        return createLocationEvent(location, str, this.sessionIdentifier.getSessionId());
    }

    public void updateSessionIdentifier(SessionIdentifier sessionIdentifier) {
        this.sessionIdentifier = sessionIdentifier;
    }

    private static LocationEvent createLocationEvent(Location location, String str, String str2) {
        LocationEvent locationEvent = new LocationEvent(str2, round(location.getLatitude()), wrapLongitude(round(location.getLongitude())), str);
        addAltitudeIfPresent(location, locationEvent);
        addAccuracyIfPresent(location, locationEvent);
        return locationEvent;
    }

    private static double round(double d) {
        return new BigDecimal(d).setScale(7, 1).doubleValue();
    }

    private static double wrapLongitude(double d) {
        return (d < -180.0d || d > 180.0d) ? wrap(d, -180.0d, 180.0d) : d;
    }

    private static void addAltitudeIfPresent(Location location, LocationEvent locationEvent) {
        if (location.hasAltitude()) {
            locationEvent.setAltitude(Double.valueOf(Math.round(location.getAltitude())));
        }
    }

    private static void addAccuracyIfPresent(Location location, LocationEvent locationEvent) {
        if (location.hasAccuracy()) {
            locationEvent.setAccuracy(Float.valueOf(Math.round(location.getAccuracy())));
        }
    }
}
