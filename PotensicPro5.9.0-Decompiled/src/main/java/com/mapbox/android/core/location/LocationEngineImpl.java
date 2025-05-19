package com.mapbox.android.core.location;

import android.app.PendingIntent;
import android.os.Looper;

/* loaded from: classes3.dex */
interface LocationEngineImpl<T> {
    T createListener(LocationEngineCallback<LocationEngineResult> locationEngineCallback);

    void getLastLocation(LocationEngineCallback<LocationEngineResult> locationEngineCallback) throws SecurityException;

    void removeLocationUpdates(PendingIntent pendingIntent);

    void removeLocationUpdates(T t);

    void requestLocationUpdates(LocationEngineRequest locationEngineRequest, PendingIntent pendingIntent) throws SecurityException;

    void requestLocationUpdates(LocationEngineRequest locationEngineRequest, T t, Looper looper) throws SecurityException;
}
