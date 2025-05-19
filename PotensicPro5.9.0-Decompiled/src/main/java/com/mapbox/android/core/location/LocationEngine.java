package com.mapbox.android.core.location;

import android.app.PendingIntent;
import android.os.Looper;

/* loaded from: classes3.dex */
public interface LocationEngine {
    void getLastLocation(LocationEngineCallback<LocationEngineResult> locationEngineCallback) throws SecurityException;

    void removeLocationUpdates(PendingIntent pendingIntent);

    void removeLocationUpdates(LocationEngineCallback<LocationEngineResult> locationEngineCallback);

    void requestLocationUpdates(LocationEngineRequest locationEngineRequest, PendingIntent pendingIntent) throws SecurityException;

    void requestLocationUpdates(LocationEngineRequest locationEngineRequest, LocationEngineCallback<LocationEngineResult> locationEngineCallback, Looper looper) throws SecurityException;
}
