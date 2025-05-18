package com.mapbox.android.core.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.location.LocationResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class LocationEngineResult {
    private static final String GOOGLE_PLAY_LOCATION_RESULT = "com.google.android.gms.location.LocationResult";
    private final List<Location> locations;

    private LocationEngineResult(List<Location> list) {
        this.locations = Collections.unmodifiableList(list);
    }

    public static LocationEngineResult create(Location location) {
        ArrayList arrayList = new ArrayList();
        if (location != null) {
            arrayList.add(location);
        }
        return new LocationEngineResult(arrayList);
    }

    public static LocationEngineResult create(List<Location> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list);
            arrayList.removeAll(Collections.singleton(null));
            return new LocationEngineResult(arrayList);
        }
        return new LocationEngineResult(Collections.emptyList());
    }

    public Location getLastLocation() {
        if (this.locations.isEmpty()) {
            return null;
        }
        return this.locations.get(0);
    }

    public List<Location> getLocations() {
        return Collections.unmodifiableList(this.locations);
    }

    public static LocationEngineResult extractResult(Intent intent) {
        LocationEngineResult extractGooglePlayResult = Utils.isOnClasspath(GOOGLE_PLAY_LOCATION_RESULT) ? extractGooglePlayResult(intent) : null;
        return extractGooglePlayResult == null ? extractAndroidResult(intent) : extractGooglePlayResult;
    }

    private static LocationEngineResult extractGooglePlayResult(Intent intent) {
        LocationResult extractResult = LocationResult.extractResult(intent);
        if (extractResult != null) {
            return create((List<Location>) extractResult.getLocations());
        }
        return null;
    }

    private static LocationEngineResult extractAndroidResult(Intent intent) {
        if (hasResult(intent)) {
            return create((Location) intent.getExtras().getParcelable("location"));
        }
        return null;
    }

    private static boolean hasResult(Intent intent) {
        return intent != null && intent.hasExtra("location");
    }
}