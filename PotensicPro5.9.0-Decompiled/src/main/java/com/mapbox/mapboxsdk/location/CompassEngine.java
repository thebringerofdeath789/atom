package com.mapbox.mapboxsdk.location;

/* loaded from: classes3.dex */
public interface CompassEngine {
    void addCompassListener(CompassListener compassListener);

    int getLastAccuracySensorStatus();

    float getLastHeading();

    void removeCompassListener(CompassListener compassListener);
}
