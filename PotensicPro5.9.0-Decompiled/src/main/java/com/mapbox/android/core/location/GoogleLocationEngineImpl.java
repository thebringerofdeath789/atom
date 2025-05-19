package com.mapbox.android.core.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
class GoogleLocationEngineImpl implements LocationEngineImpl<LocationCallback> {
    private final FusedLocationProviderClient fusedLocationProviderClient;

    private static int toGMSLocationPriority(int i) {
        if (i == 0) {
            return 100;
        }
        if (i != 1) {
            return i != 2 ? 105 : 104;
        }
        return 102;
    }

    @Override // com.mapbox.android.core.location.LocationEngineImpl
    public /* bridge */ /* synthetic */ LocationCallback createListener(LocationEngineCallback locationEngineCallback) {
        return createListener((LocationEngineCallback<LocationEngineResult>) locationEngineCallback);
    }

    GoogleLocationEngineImpl(FusedLocationProviderClient fusedLocationProviderClient) {
        this.fusedLocationProviderClient = fusedLocationProviderClient;
    }

    GoogleLocationEngineImpl(Context context) {
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.mapbox.android.core.location.LocationEngineImpl
    public LocationCallback createListener(LocationEngineCallback<LocationEngineResult> locationEngineCallback) {
        return new GoogleLocationEngineCallbackTransport(locationEngineCallback);
    }

    @Override // com.mapbox.android.core.location.LocationEngineImpl
    public void getLastLocation(LocationEngineCallback<LocationEngineResult> locationEngineCallback) throws SecurityException {
        GoogleLastLocationEngineCallbackTransport googleLastLocationEngineCallbackTransport = new GoogleLastLocationEngineCallbackTransport(locationEngineCallback);
        this.fusedLocationProviderClient.getLastLocation().addOnSuccessListener(googleLastLocationEngineCallbackTransport).addOnFailureListener(googleLastLocationEngineCallbackTransport);
    }

    @Override // com.mapbox.android.core.location.LocationEngineImpl
    public void requestLocationUpdates(LocationEngineRequest locationEngineRequest, LocationCallback locationCallback, Looper looper) throws SecurityException {
        this.fusedLocationProviderClient.requestLocationUpdates(toGMSLocationRequest(locationEngineRequest), locationCallback, looper);
    }

    @Override // com.mapbox.android.core.location.LocationEngineImpl
    public void requestLocationUpdates(LocationEngineRequest locationEngineRequest, PendingIntent pendingIntent) throws SecurityException {
        this.fusedLocationProviderClient.requestLocationUpdates(toGMSLocationRequest(locationEngineRequest), pendingIntent);
    }

    @Override // com.mapbox.android.core.location.LocationEngineImpl
    public void removeLocationUpdates(LocationCallback locationCallback) {
        if (locationCallback != null) {
            this.fusedLocationProviderClient.removeLocationUpdates(locationCallback);
        }
    }

    @Override // com.mapbox.android.core.location.LocationEngineImpl
    public void removeLocationUpdates(PendingIntent pendingIntent) {
        if (pendingIntent != null) {
            this.fusedLocationProviderClient.removeLocationUpdates(pendingIntent);
        }
    }

    private static LocationRequest toGMSLocationRequest(LocationEngineRequest locationEngineRequest) {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(locationEngineRequest.getInterval());
        locationRequest.setFastestInterval(locationEngineRequest.getFastestInterval());
        locationRequest.setSmallestDisplacement(locationEngineRequest.getDisplacement());
        locationRequest.setMaxWaitTime(locationEngineRequest.getMaxWaitTime());
        locationRequest.setPriority(toGMSLocationPriority(locationEngineRequest.getPriority()));
        return locationRequest;
    }

    private static final class GoogleLocationEngineCallbackTransport extends LocationCallback {
        private final LocationEngineCallback<LocationEngineResult> callback;

        GoogleLocationEngineCallbackTransport(LocationEngineCallback<LocationEngineResult> locationEngineCallback) {
            this.callback = locationEngineCallback;
        }

        public void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            List locations = locationResult.getLocations();
            if (!locations.isEmpty()) {
                this.callback.onSuccess(LocationEngineResult.create((List<Location>) locations));
            } else {
                this.callback.onFailure(new Exception("Unavailable location"));
            }
        }
    }

    static final class GoogleLastLocationEngineCallbackTransport implements OnSuccessListener<Location>, OnFailureListener {
        private final LocationEngineCallback<LocationEngineResult> callback;

        GoogleLastLocationEngineCallbackTransport(LocationEngineCallback<LocationEngineResult> locationEngineCallback) {
            this.callback = locationEngineCallback;
        }

        public void onSuccess(Location location) {
            this.callback.onSuccess(location != null ? LocationEngineResult.create(location) : LocationEngineResult.create((List<Location>) Collections.emptyList()));
        }

        public void onFailure(Exception exc) {
            this.callback.onFailure(exc);
        }
    }
}
