package com.mapbox.android.core.location;

import android.app.PendingIntent;
import android.os.Looper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
class LocationEngineProxy<T> implements LocationEngine {
    private Map<LocationEngineCallback<LocationEngineResult>, T> listeners;
    private final LocationEngineImpl<T> locationEngineImpl;

    LocationEngineProxy(LocationEngineImpl<T> locationEngineImpl) {
        this.locationEngineImpl = locationEngineImpl;
    }

    @Override // com.mapbox.android.core.location.LocationEngine
    public void getLastLocation(LocationEngineCallback<LocationEngineResult> locationEngineCallback) throws SecurityException {
        Utils.checkNotNull(locationEngineCallback, "callback == null");
        this.locationEngineImpl.getLastLocation(locationEngineCallback);
    }

    @Override // com.mapbox.android.core.location.LocationEngine
    public void requestLocationUpdates(LocationEngineRequest locationEngineRequest, LocationEngineCallback<LocationEngineResult> locationEngineCallback, Looper looper) throws SecurityException {
        Utils.checkNotNull(locationEngineRequest, "request == null");
        Utils.checkNotNull(locationEngineCallback, "callback == null");
        LocationEngineImpl<T> locationEngineImpl = this.locationEngineImpl;
        T listener = getListener(locationEngineCallback);
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        locationEngineImpl.requestLocationUpdates(locationEngineRequest, listener, looper);
    }

    @Override // com.mapbox.android.core.location.LocationEngine
    public void requestLocationUpdates(LocationEngineRequest locationEngineRequest, PendingIntent pendingIntent) throws SecurityException {
        Utils.checkNotNull(locationEngineRequest, "request == null");
        this.locationEngineImpl.requestLocationUpdates(locationEngineRequest, pendingIntent);
    }

    @Override // com.mapbox.android.core.location.LocationEngine
    public void removeLocationUpdates(LocationEngineCallback<LocationEngineResult> locationEngineCallback) {
        Utils.checkNotNull(locationEngineCallback, "callback == null");
        this.locationEngineImpl.removeLocationUpdates((LocationEngineImpl<T>) removeListener(locationEngineCallback));
    }

    @Override // com.mapbox.android.core.location.LocationEngine
    public void removeLocationUpdates(PendingIntent pendingIntent) {
        this.locationEngineImpl.removeLocationUpdates(pendingIntent);
    }

    int getListenersCount() {
        Map<LocationEngineCallback<LocationEngineResult>, T> map = this.listeners;
        if (map != null) {
            return map.size();
        }
        return 0;
    }

    T getListener(LocationEngineCallback<LocationEngineResult> locationEngineCallback) {
        if (this.listeners == null) {
            this.listeners = new ConcurrentHashMap();
        }
        T t = this.listeners.get(locationEngineCallback);
        if (t == null) {
            t = this.locationEngineImpl.createListener(locationEngineCallback);
        }
        this.listeners.put(locationEngineCallback, t);
        return t;
    }

    T removeListener(LocationEngineCallback<LocationEngineResult> locationEngineCallback) {
        Map<LocationEngineCallback<LocationEngineResult>, T> map = this.listeners;
        if (map != null) {
            return map.remove(locationEngineCallback);
        }
        return null;
    }
}
