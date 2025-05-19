package com.ipotensic.kernel.services;

/* loaded from: classes2.dex */
public interface OnLocationChangedListener {
    void onBDLocationChanged(double d, double d2, float f);

    void onGpsSystemClose();

    void onGpsSystemOpen();

    void onPhoneOrientationChanged(float f);

    void onSatelliteCount(int i);

    void onSystemLocationChanged(double d, double d2, float f);
}
