package com.mapbox.android.core.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import java.util.Iterator;

/* loaded from: classes3.dex */
class MapboxFusedLocationEngineImpl extends AndroidLocationEngineImpl {
    private static final String TAG = "MapboxLocationEngine";

    @Override // com.mapbox.android.core.location.AndroidLocationEngineImpl, com.mapbox.android.core.location.LocationEngineImpl
    public /* bridge */ /* synthetic */ LocationListener createListener(LocationEngineCallback locationEngineCallback) {
        return createListener((LocationEngineCallback<LocationEngineResult>) locationEngineCallback);
    }

    MapboxFusedLocationEngineImpl(Context context) {
        super(context);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.mapbox.android.core.location.AndroidLocationEngineImpl, com.mapbox.android.core.location.LocationEngineImpl
    public LocationListener createListener(LocationEngineCallback<LocationEngineResult> locationEngineCallback) {
        return new MapboxLocationEngineCallbackTransport(locationEngineCallback);
    }

    @Override // com.mapbox.android.core.location.AndroidLocationEngineImpl, com.mapbox.android.core.location.LocationEngineImpl
    public void getLastLocation(LocationEngineCallback<LocationEngineResult> locationEngineCallback) throws SecurityException {
        Location bestLastLocation = getBestLastLocation();
        if (bestLastLocation != null) {
            locationEngineCallback.onSuccess(LocationEngineResult.create(bestLastLocation));
        } else {
            locationEngineCallback.onFailure(new Exception("Last location unavailable"));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.mapbox.android.core.location.AndroidLocationEngineImpl, com.mapbox.android.core.location.LocationEngineImpl
    public void requestLocationUpdates(LocationEngineRequest locationEngineRequest, LocationListener locationListener, Looper looper) throws SecurityException {
        super.requestLocationUpdates(locationEngineRequest, locationListener, looper);
        if (shouldStartNetworkProvider(locationEngineRequest.getPriority())) {
            try {
                this.locationManager.requestLocationUpdates("network", locationEngineRequest.getInterval(), locationEngineRequest.getDisplacement(), locationListener, looper);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.mapbox.android.core.location.AndroidLocationEngineImpl, com.mapbox.android.core.location.LocationEngineImpl
    public void requestLocationUpdates(LocationEngineRequest locationEngineRequest, PendingIntent pendingIntent) throws SecurityException {
        super.requestLocationUpdates(locationEngineRequest, pendingIntent);
        if (shouldStartNetworkProvider(locationEngineRequest.getPriority())) {
            try {
                this.locationManager.requestLocationUpdates("network", locationEngineRequest.getInterval(), locationEngineRequest.getDisplacement(), pendingIntent);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private Location getBestLastLocation() {
        Iterator<String> it = this.locationManager.getAllProviders().iterator();
        Location location = null;
        while (it.hasNext()) {
            Location lastLocationFor = getLastLocationFor(it.next());
            if (lastLocationFor != null && Utils.isBetterLocation(lastLocationFor, location)) {
                location = lastLocationFor;
            }
        }
        return location;
    }

    private boolean shouldStartNetworkProvider(int i) {
        return (i == 0 || i == 1) && this.currentProvider.equals("gps");
    }

    private static final class MapboxLocationEngineCallbackTransport implements LocationListener {
        private final LocationEngineCallback<LocationEngineResult> callback;
        private Location currentBestLocation;

        MapboxLocationEngineCallbackTransport(LocationEngineCallback<LocationEngineResult> locationEngineCallback) {
            this.callback = locationEngineCallback;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (Utils.isBetterLocation(location, this.currentBestLocation)) {
                this.currentBestLocation = location;
            }
            LocationEngineCallback<LocationEngineResult> locationEngineCallback = this.callback;
            if (locationEngineCallback != null) {
                locationEngineCallback.onSuccess(LocationEngineResult.create(this.currentBestLocation));
            }
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            Log.d(MapboxFusedLocationEngineImpl.TAG, "onStatusChanged: " + str);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            Log.d(MapboxFusedLocationEngineImpl.TAG, "onProviderEnabled: " + str);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            Log.d(MapboxFusedLocationEngineImpl.TAG, "onProviderDisabled: " + str);
        }
    }
}