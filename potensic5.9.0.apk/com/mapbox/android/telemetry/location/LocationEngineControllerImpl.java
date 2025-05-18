package com.mapbox.android.telemetry.location;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.hjq.permissions.Permission;
import com.mapbox.android.core.location.LocationEngine;
import com.mapbox.android.core.location.LocationEngineRequest;

/* loaded from: classes3.dex */
class LocationEngineControllerImpl implements LocationEngineController {
    private static final long DEFAULT_INTERVAL_IN_MILLISECONDS = 1000;
    private static final long DEFAULT_MAX_WAIT_TIME = 5000;
    private static final String TAG = "LocationController";
    private final Context applicationContext;
    private final LocationEngine locationEngine;
    private final LocationUpdatesBroadcastReceiver locationUpdatesBroadcastReceiver;

    @Override // com.mapbox.android.telemetry.location.LocationEngineController
    public void onPause() {
    }

    LocationEngineControllerImpl(Context context, LocationEngine locationEngine, LocationUpdatesBroadcastReceiver locationUpdatesBroadcastReceiver) {
        this.applicationContext = context;
        this.locationEngine = locationEngine;
        this.locationUpdatesBroadcastReceiver = locationUpdatesBroadcastReceiver;
    }

    @Override // com.mapbox.android.telemetry.location.LocationEngineController
    public void onResume() {
        registerReceiver();
        requestLocationUpdates();
    }

    @Override // com.mapbox.android.telemetry.location.LocationEngineController
    public void onDestroy() {
        removeLocationUpdates();
        unregisterReceiver();
    }

    private void registerReceiver() {
        try {
            this.applicationContext.registerReceiver(this.locationUpdatesBroadcastReceiver, new IntentFilter("com.mapbox.android.telemetry.location.locationupdatespendingintent.action.LOCATION_UPDATED"));
        } catch (IllegalArgumentException e) {
            Log.e(TAG, e.toString());
        }
    }

    private void unregisterReceiver() {
        try {
            this.applicationContext.unregisterReceiver(this.locationUpdatesBroadcastReceiver);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, e.toString());
        }
    }

    private void requestLocationUpdates() {
        if (!checkPermissions()) {
            Log.w(TAG, "Location permissions are not granted");
            return;
        }
        try {
            this.locationEngine.requestLocationUpdates(createRequest(1000L), getPendingIntent());
        } catch (SecurityException e) {
            Log.e(TAG, e.toString());
        }
    }

    private void removeLocationUpdates() {
        this.locationEngine.removeLocationUpdates(getPendingIntent());
    }

    private PendingIntent getPendingIntent() {
        return PendingIntent.getBroadcast(this.applicationContext, 0, new Intent("com.mapbox.android.telemetry.location.locationupdatespendingintent.action.LOCATION_UPDATED"), 134217728);
    }

    private boolean isPermissionGranted(String str) {
        return ContextCompat.checkSelfPermission(this.applicationContext, str) == 0;
    }

    private boolean checkPermissions() {
        return isPermissionGranted(Permission.ACCESS_FINE_LOCATION) || isPermissionGranted(Permission.ACCESS_COARSE_LOCATION);
    }

    private static LocationEngineRequest createRequest(long j) {
        return new LocationEngineRequest.Builder(j).setPriority(3).setMaxWaitTime(5000L).build();
    }
}