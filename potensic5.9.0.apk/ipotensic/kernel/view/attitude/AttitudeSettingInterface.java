package com.ipotensic.kernel.view.attitude;

import com.mapbox.mapboxsdk.geometry.LatLng;

/* loaded from: classes2.dex */
public interface AttitudeSettingInterface {
    void deInit();

    void setAngleToNorth(int i);

    void setConnect(boolean z);

    void setFlightLatLng(LatLng latLng);

    void setHomeLatLng(LatLng latLng);

    void setRemoterAngel(int i);

    void setRemoterLatLng(LatLng latLng);

    void setRotate(int i);

    void setWindSpeedAndDirection(int i, float f);

    void setYawPitch(int i);
}